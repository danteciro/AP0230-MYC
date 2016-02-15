$(function(){
    $('#tabsMantProcedimiento').tabs();
    initArbolActividadesEdit();
    
    $('#frmMantObligacionProceso').validarForm(); 
    $('#cmbEtapa').change(function(){cargaTramite(fillTramiteNuevoProc,"#cmbEtapa",'#tramitesNuevoProc');});
    $('#btnGuardarProc').click(btnGuardarProc);
    $('#btnEditarProc').click(btnEditarProc);
    $('#btnAgregarActividad').click(btnAgregarActividad);
    $('#btnNuevaEtapa').click(function(){ abrirNuevaEtapa('new');});
    $('#btnNuevoTramite').click(function(){abrirNuevoTramite('new'); });
    boton.closeDialog();
    changeCmbCalificacion();
    initMantFrmProcedimiento();
//    obtenerProceso();
    $('#cmbProcesoNuevo').change(function(){
    	if($('#cmbProcesoNuevo').val()==''){
    		$('#cmbEtapa').val('');
    	}else{
    		obtenerEtapa($('#cmbProcesoNuevo').val());
    	}
    	
    });
    $('#cmbEtapa').change(function(){
    	if($('#cmbEtapa').val()==''){
    		
    	}else{
    		obtenerTramite($('#cmbEtapa').val());
    	}
    	
    });
    
    
});

function obtenerProceso() {
    $.getJSON("/myc/pages/tramiteActividad/obtenerProceso", {
        //idActividad: idActividad,
        ajax: 'true',
        async: true
    }, function(data) {
        var html = '<option value="">--Seleccione--</option>';
        var len = data.length;
        for (var i = 0; i < len; i++) {
            if (data[i].idProceso == $('#cmbProcesoNuevo').val()) {
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
    $.getJSON("/myc/pages/tramiteActividad/obtenerEtapa", {
    	idProceso: idProceso,
        ajax: 'true',
        async: true
    }, function(data) {
        var html = '<option value="">--Seleccione--</option>';
        var len = data.length;
        for (var i = 0; i < len; i++) {
            if (data[i].idMaestroColumna == $('#cmbEtapa').val()) {
                html += '<option value="' + data[i].idEtapa + '" selected="selected">'
                        + data[i].descripcion + '</option>';
            } else {
                html += '<option value="' + data[i].idEtapa + '">'
                        + data[i].descripcion + '</option>';
            }
        }
        $('#cmbEtapa').html(html);
    });
}
function obtenerTramite(idEtapa) {
    $.getJSON("/myc/pages/tramiteActividad/obtenerTramite", {
    	idEtapa: idEtapa,
        ajax: 'true',
        async: true
    }, function(data) {
        var html = '<option value="">--Seleccione--</option>';
        var len = data.length;
        for (var i = 0; i < len; i++) {
            if (data[i].idMaestroColumna == $('#cmbTramite').val()) {
                html += '<option value="' + data[i].idTramite + '" selected="selected">'
                        + data[i].descripcion + '</option>';
            } else {
                html += '<option value="' + data[i].idTramite + '">'
                        + data[i].descripcion + '</option>';
            }
        }
        $('#cmbTramite').html(html);
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
	                width: "auto",
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
//	        	tipo='edit';
//	            procesarGridEtapaUtil(flg_load,idProceso,tipo);
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
	                width: "auto",
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
//	    procesarGridTramite();
	}
function initMantFrmProcedimiento(){
	
    //EDIT - VIEW
    if($('#tipoP').val()!='new'){
        $('#txtPorcUIT').trigger("keyup");
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
              $("#arbolActividadesEdit").fancytree("getTree").getNodeByKey(parseInt(v)).setSelected();        
            });
        }
    }
    //ALPHANUM
    $('#txtItemProc').alphanum(alphaNumOptions);
}
function verificaTramiteGratuito(){
    $('#txtPorcUIT').val("0");
    $('#txtSoles').html("0.00");
    if($('#chkTramGrat').attr('checked')){
        $('#filaDerechoTramitacion').hide();
        $('#txtPorcUIT').removeAttr('validate');
    }else{
        $('#filaDerechoTramitacion').show();
        $('#txtPorcUIT').attr('validate','[O][SNP]');
    }
}
function calculaUITSoles(){
    var txtSoles=parseFloat($('#txtPorcUIT').val()*$('#txtValorUIT').html()/100).toFixed(2);
    txtSoles=(isNaN(txtSoles))?"":txtSoles;
    $('#txtSoles').html(txtSoles);
}
function changeCmbCalificacion(){
    $('#cmbSilencioAdministrativo').hide().val("").attr('validate','');
    if($('#cmbCalificacion').find('option:checked').html()=='EVALUACION PREVIA'){
        $('#cmbSilencioAdministrativo').show().attr('validate','[O]');
        if($('#tipoP').val()=="new"){
            cargaSilencioAdministrativo(fill.comboValorTxt,"#cmbCalificacion",'#cmbSilencioAdministrativo','NEGATIVO');
        }else{
            //console.log(idSileAdmi);
            cargaSilencioAdministrativo(fill.comboValorId,"#cmbCalificacion",'#cmbSilencioAdministrativo',idSileAdmi);
        }
    }
}
function fillTramiteNuevoProc(data,id,desc,tagDestino){
    $(tagDestino).hide();
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
    var nodo=$("#arbolActividadesEdit").fancytree("getTree").getNodeByKey(parseInt(id));
    if(nodo==null){
        nodo=$("#arbolActividadesEdit").fancytree("getTree").getNodeByKey(String(id));//evitar conflicto pa arboles armados con html (<ul> - <li>)
    }
    //$("#arbolActividades").fancytree("getTree").getNodeByKey(id).setSelected(false);   
    nodo.setSelected(false);   
}
/*ARBOL ACTIVIDADES*/
function initArbolActividadesEdit(){
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
    $("#arbolActividadesEdit").fancytree({
        checkbox: true,
        selectMode: 1,
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
        cookieId: "fancytree-Cb2",
        idPrefix: "fancytree-Cb2-"
    });
    
    $("#arbolActividadesEdit").fancytree("getRootNode").visit(function(node){
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
