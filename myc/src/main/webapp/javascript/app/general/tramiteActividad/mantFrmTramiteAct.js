$(function(){
    $('#tabsMantProcedimiento').tabs();
    initArbolActividades();
    $('#frmMantProcedimiento').validarForm(); 
    $('#cmbEtapa').change(function(){cargaTramite(fillTramiteNuevoProc,"#cmbEtapa",'#tramitesNuevoProc');});
    $('#btnGuardarProc').click(btnGuardarProc);
    $('#btnEditarProc').click(btnEditarProc);
    $('#btnAgregarActividad').click(btnAgregarActividad);
    $('#btnNuevaEtapa').click(function(){ abrirNuevaEtapa('new');});
    $('#btnNuevoTramite').click(function(){abrirNuevoTramite('new'); });
    boton.closeDialog();
    initMantFrmProcedimiento();
    //obtenerProceso();
    $('#cmbProcesoNuevo').change(function(){
    	if($('#cmbProcesoNuevo').val()==''){
    		$('#cmbEtapa').val('');
    		$('#cmbEtapa').attr('disabled','disabled');
            $('#btnNuevaEtapa').css('display','none');
            $('#cmbEtapa').trigger("change");
            $('#btnNuevoTramite').css('display','none');
            
    	}else{
    		obtenerEtapa($('#cmbProcesoNuevo').val());
    		$('#cmbEtapa').val('');
    		$('#cmbEtapa').removeAttr('disabled');
            $('#btnNuevaEtapa').css('display','inline-block');
            $('#cmbEtapa').trigger("change");
            $('#btnNuevoTramite').css('display','none');
    	}
    	
    });
    $('#cmbEtapa').change(function(){
    	if($('#cmbEtapa').val()==''){
    		$('#btnNuevoTramite').css('display','none');
//    		$('#chkTramit').css('display','none');
//    		$('#chkTramite').attr('checked',false);
    	}else{
    		$('#btnNuevoTramite').css('display','inline-block');
//    		$('#chkTramit').css('display','inline-block');
//    		$('#chkTramite').attr('checked',false);
    	}
    	
    });
    $('#chkTramite').change(function(){
    	if($('#chkTramite').is(':checked')){
    		$('#contTramites').find('input').map(function(){
                $(this).attr('checked',true);
            });
        }else{
        	$('#contTramites').find('input').map(function(){
        		$(this).attr('checked',false);;
            });
        }
    });
    
});

function obtenerProceso() {
    $.getJSON("/myc/pages/tramiteActividad/obtenerProceso", {
        //idActividad: idActividad,
        ajax: 'true',
        async: false
    }, function(data) {
        var html = '<option value="">--Seleccione--</option>';
        var len = data.length;
        for (var i = 0; i < len; i++) {
            if (data[i].idMaestroColumna == $('#cmbProcesoNuevo').val()) {
                html += '<option value="' + data[i].idProceso + '" selected="selected">'
                        + data[i].descripcion + '</option>';
            } else {
                html += '<option value="' + data[i].idProceso + '">'
                        + data[i].descripcion + '</option>';
            }
        }
        $('#cmbProcesoNuevo').html(html);
    });
}
function obtenerEtapa(idProceso) {	
    $.getJSON("/myc/pages/tramiteActividad/listEtapaDetail", {
    	idProceso: idProceso,
        ajax: 'true',
        async: false
    }, function(data) {
        etapa.SlcOptGroup(data,"#cmbEtapa");
    });
}

function abrirNuevaEtapa(tipo){
	   
	   title="NUEVO ETAPA"; 
	      
	    $.ajax({
	        url:baseURL + "pages/etapa/abrirMantEtapa", 
	        type:'get',
	        async:false,
	        data:{
	            tipo:tipo,
                    idProceso:$('#cmbProcesoNuevo').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            $("#dialogMantEtapa").html(data);
	            $("#dialogMantEtapa").dialog({
	                resizable: false,
	                draggable: true,
	                autoOpen: true,
	                height:"auto",
	                width: "550px",
	                modal: true,
	                dialogClass: 'dialog',
	                title: title,
	                closeText:"Cerrar",
	                close: function( event, ui ) {
	                    $(this).dialog('destroy');
	                }
	            });
//	            idProceso=$("#cmbProceso").val();
//	        	flg_load=1;
//	        	procesarGridEtapaUtil(flg_load,idProceso,tipo);
	            
	        },
	        error:errorAjax
	    });
	}

function abrirNuevoTramite(tipo){
    
	   title="NUEVO TRAMITE"; 
	      
	    $.ajax({
	        url:baseURL + "pages/etapaTramite/abrirMantTramite", 
	        type:'get',
	        async:false,
	        data:{
	            tipo:tipo,
                    idEtapa:$('#cmbEtapa').val(),
                    txtEtapa:$('#cmbEtapa option:selected').html()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            $("#dialogMantTramite").html(data);
	            $("#dialogMantTramite").dialog({
	                resizable: false,
	                draggable: true,
	                autoOpen: true,
	                height:"auto",
	                width: "550px",
	                modal: true,
	                dialogClass: 'dialog',
	                title: title,
	                closeText:"Cerrar",
	                close: function( event, ui ) {
	                    $(this).dialog('destroy');
	                }
	            });
	        },
	        error:errorAjax
	    });
//	    $('#txtIdEtapaTramite').val($('#cmbEtapa').val());
//	    $('#txtEtapaTr').val($('#cmbEtapa option:selected').html());
	    //procesarGridTramite();
	}
function procesarGridTramite(flg_load){
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorTramite").html("");
    var grid = $("<table>", {
        "id": "gridTramite"
    });
    var pager = $("<div>", {
        "id": "paginacionTramite"
    });
    $("#gridContenedorTramite").append(grid).append(pager);

    var nombres = ['IDTRAMITE','ETAPA', 'TRAMITE'];
    var columnas = [
        {name: "idTramite", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "etapa", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "descripcion", width: 100, sortable: false, hidden: false, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/tramite/listarTramite",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idEtapa: $("#txtIdEtapaTramite").val()
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionTramite",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Tramites",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idTramite"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkVerProcedimiento').attr('onClick', 'verParametroDinamico("' + rowid + '")');
//            $('#linkEditarZonificacionDetalle').attr('onClick', 'editarZonificacionDetalle("' + rowid + '")');
            $('#linkEliminarTramite').attr('onClick', 'eliminarTramite("' + rowid + '")');
            $('#linkGestionarMotivo').attr('onClick', 'gestionarMotivoTramite("' + rowid + '")');
        },
        loadComplete: function(data) {
            $('#contextMenuTramite').parent().remove();
            $('#divContextMenuTramite').html("<ul id='contextMenuTramite'>"
//                    + "<li> <a id='linkEditarZonificacionDetalle' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarTramite' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "<li> <a id='linkGestionarMotivo' data-icon='ui-icon-pencil' title='Gestionar Motivo'>Gestionar Motivo</a></li>"
//                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
                    + "</ul>");
            $('#contextMenuTramite').puicontextmenu({
                target: $('#gridTramite')
            });
        }
    });
}
function initMantFrmProcedimiento(){
    //EDIT - VIEW
    if($('#tipoP').val()!='new'){
        //$('#txtPorcUIT').trigger("keyup");
        $('#cmbEtapa').trigger("change");
        if(idTramites!=""){
            var trams = idTramites.split(",");
            $.each(trams,function(k,v){
                $('#chkT_'+v).attr('checked',true);
            });
        }
        if(idActividades!=""){
            var actis=idActividades.split(",");
            $.each(actis,function(k,v){
              $("#arbolActividades").fancytree("getTree").getNodeByKey(parseInt(v)).setSelected();        
            });
        }
    }
    //ALPHANUM
    $('#txtItemProc').alphanum(alphaNumOptions);
}


function fillTramiteNuevoProc(data,id,desc,tagDestino){
    $(tagDestino).hide();
    $('#chkTramit').css('display','none');
    $('#chkTramite').attr('checked',false);
    var html="";
    if(data.length>0){
        var cont=0;
        $.each(data,function(k,v){
            html+='<div class="lblh contChkA bgA" title="'+v[desc]+'">';
            html+='<div class="ilb vam txtFilaUnic" style="width:88%;">'+v[desc]+'</div>';
            html+='<div class="fr">';
            //html+='<input type="checkbox" value="'+v[id]+'" id="chkT_'+v[id]+'" name="tramites['+cont+'].idTramite">';
            html+='<input type="checkbox" value="'+v[id]+'" id="chkT_'+v[id]+'">';
            html+='<label for="chkT_'+v[id]+'" class="checkbox"></label>';
            html+='</div>';
            html+='</div>';
            cont++;
        });
        $(tagDestino).show();
        $('#chkTramit').css('display','');
    }
    $(tagDestino).children('div').eq(1).html(html);
}
function btnAgregarActividad(){
    $('#popupArbolActi').dialog({
        width: 640,height:280,modal:true,
        close: function( event, ui ) {//se destruye popup para evitar conflicto con arbol y seleccionados
            //console.log('cerrando y destruyendo popup');
            $(this).dialog('destroy');
        }
    });
}
function quitarActividadDeAgregar(id,obj){
    $(obj).parent().remove();
    //retirando de arbol actividades
    var nodo=$("#arbolActividades").fancytree("getTree").getNodeByKey(parseInt(id));
    if(nodo==null){
        nodo=$("#arbolActividades").fancytree("getTree").getNodeByKey(String(id));//evitar conflicto pa arboles armados con html (<ul> - <li>)
    }
    //$("#arbolActividades").fancytree("getTree").getNodeByKey(id).setSelected(false);   
    nodo.setSelected(false);   
}
/*ARBOL ACTIVIDADES*/
function initArbolActividades(){
    var treeData=[];
    $.ajax({
        url: baseURL + 'pages/actividadesController/loadActividad',
        type: "post",
        async: false,
        data: {},
        //beforeSend:muestraLoading,
        success: function(data) {
            //ocultaLoading();
            treeData = fxTree.build(data.filas);
        },
        error:errorAjax
    });
    $("#arbolActividades").fancytree({
        checkbox: true,
        selectMode: 3,
        source:treeData,
        select: function(event, data) {
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node){
                if(!node.folder){
                    return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
                }
            });
            agregaActividadDeArbol("["+selKeys.join(",")+"]");
        },
        keydown: function(event, data) {
            if( event.which === 32 ) {
                data.node.toggleSelected();
                return false;
            }
        },
        //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
        //initId: "treeData",
        cookieId: "fancytree-Cb1",
        idPrefix: "fancytree-Cb1-"
    });
    
    $("#arbolActividades").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
}

function agregaActividadDeArbol(datax){
    var data=eval("("+datax+")");
    var html="";
    $.each(data,function(k,v){
        html+='<div id="'+v.id+'" class="fila">';
        html+=' <div class="txtFilaUnic ilb data vam" style="width: 96%">'+v.nombre+'</div>';
        html+=' <input type="checkbox" value="'+v.id+'" checked >';
        if($('#tipoP').val()!="view"){
            html+=' <div onclick="quitarActividadDeAgregar('+v.id+',this)" class="btnQuitar ui-state-default ui-corner-all ilb vam" title="Quitar"><span class="ui-icon ui-icon-closethick"></span></div>';
        }
        html+='</div>';
    });
    $('#idActividadesAgregarSelect').html(html);
}

