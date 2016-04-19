//se usa en casos edit(editar), view(consultar) procedimiento
var idSileAdmi;
var idTramites;
var idActividades;
$(function() {
    procesarGridTramRubr("0");
    initInicioProc();
});
function initInicioProc(){
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    confirm.start();
    $('#btnBuscarTramRubr').click(function(){procesarGridTramRubr();});
    $('#cmbProcesoBusq').change(function(){cargaEtapa(fill.combo,"#cmbProcesoBusq",'#cmbEtapaBusq');fill.clean('#cmbTramiteBusq');});
    //$('#cmbEtapaBusq').change(function(){cargaTramite(fill.combo,"#cmbEtapaBusq",'#cmbTramiteBusq');});
    $('#btnNuevoTramRubr').click(function(){abrirMantTramiteActividad("new");});
    $('#btnLimpiarForm').click(btnLimpiarForm);
    //ALPHANUM
    $('#txtItemProcBusq').alphanum(alphaNumOptions);
}

function btnLimpiarForm(){
    $('#buscarProc').find('input, select').val('');
    $('#cmbProcesoBusq').trigger('change');
    $('#txtActivP1').attr('title','');
}

function abrirMantTramiteActividad(tipo,rowid){
    var title="CONSULTAR TRÁMITE vs RUBRO";
    if(tipo=='edit'){
        title="EDITAR TRÁMITE vs RUBRO";
    }else if(tipo=='new'){
        title="NUEVO TRÁMITE vs RUBRO";
    }
    var row = $('#gridTramiteActividad').jqGrid('getRowData', rowid);
    $.ajax({
        url:baseURL + "pages/tramiteActividad/abrirManTramiteActividad", 
        type:'get',
        async:false,
        data:{
            tipo:tipo,
            idTramiteActividad:rowid,
            idActividad:row["idActividad.idActividad"],
            idProceso:row.idProceso,
            idEtapa:row.idEtapa,
            idTramite:row.idTramite
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantTipoTramiteActividad").html(data);
            $("#dialogMantTipoTramiteActividad").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText:"Cerrar"
            });
            if(tipo=="view"){
                $('#frmMantProcedimiento').find('input,select,textarea').attr('disabled',true);
            }
            $('#cmbEtapa').attr('disabled','disabled');
            $('#btnNuevaEtapa').css('display','none');
        },
        error:errorAjax
    });
}


function abrirMantEditTramiteActividad(tipo,rowid){
	
	 var title="CONSULTAR ACTIVIDAD vs TIPO TRÁMITE";
	    if(tipo=='edit'){
	        title="EDITAR ACTIVIDAD vs TIPO TRÁMITE";
	 }
    var row = $('#gridTramiteActividad').jqGrid('getRowData', rowid);
    $.ajax({
        url:baseURL + "pages/tramiteActividad/abrirManEditTramiteActividad", 
        type:'get',
        async:false,
        data:{
            tipo:tipo,
            idTramiteActividad:rowid,
            idActividad:row["actividad.idActividad"],
            idProceso:row.idProceso,
            idEtapa:row.idEtapa,
            idTramite:row.idTramite
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantTipoTramiteActividad").html(data);
            $("#dialogMantTipoTramiteActividad").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText:"Cerrar"
            });
            if(tipo=="view"){
                $('#frmMantProcedimiento').find('input,select,textarea').attr('disabled',true);
            }
          
        },
        error:errorAjax
    });
}




/////////////////////////
function validarManualMantProc(){
    var retorno=true;
    if ( $('#txtPlazoResolver').val()!="" && (isNaN($('#txtPlazoResolver').val()) || $('#txtPlazoResolver').val()<=0) ){
        muestraDivError("#divMensajeValidaProcedimiento","Número de dias hábiles debe ser mayor a cero","#txtPlazoResolver");
        retorno=false;
    }
    if ( $('#txtPorcUIT').attr('validate')!=undefined && $('#txtPorcUIT').attr('validate').indexOf("[O]")>=0 
            && (isNaN($('#txtPorcUIT').val()) || $('#txtPorcUIT').val()<=0) ){
        muestraDivError("#divMensajeValidaProcedimiento","En % UIT: el número debe ser mayor a cero.","#txtPorcUIT");
        retorno=false;
    }
    return retorno;
}
// PROC NUEVO - INICIO 
function btnGuardarProc(){
	var validar=$('#frmMantTramiteActividad').validateAllForm("#divMensajeValidaTramiteActividad"); 
    if (validar) {
    	/**
    	 * Inicio: revisar validacion generica
    	 */
    	validaRubro=true;
    	cont=0;
    	errorCheck="";
    	$('#idActividadesAgregarSelect').find('input:checked').map(function(){        cont++;    });
    	if(cont==0){
        	validaRubro=false;
            var texto = "";
            var error = "RUBROS: Debe Seleccionar uno al menos.";
            errorCheck += texto + error;
            $('#divMensajeValidaTramiteActividad').show();
            $('#divMensajeValidaTramiteActividad').focus();
            $('#divMensajeValidaTramiteActividad').html(errorCheck);
        }
    	/**
    	 * Fin
    	 */
    	if(validaRubro){
    		confirm.open("¿Ud est&aacute; seguro de Guardar este nuevo Procedimiento?","procGuardarProc()");
    	}
        
    }
}
function procGuardarProc(){
    settearNamesFormMantProcedimiento();
    
    
    $.ajax({
        url:baseURL + "pages/tramiteActividad/registrarTramiteActividad",
        type:'post',
        async:false,
        data:$('#frmMantTramiteActividad').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridTramRubr();
                $('#dialogMantTipoTramiteActividad').dialog('close');
                //confirm.open("¿Desea gestionar requisitos para este nuevo Tramite - Actividad?","gestionarRequProcedimientoForm('"+data.procedimiento.idProcedimiento+"','"+$('#txtItemProc').val()+"','"+$('#txtDenominacionProc').val()+"')",{textAceptar:'SI',textCancelar:'NO'});    
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
// PROC NUEVO - FIN 
// EDITAR PROC - INICIO
function btnEditarProc(){
	var validar=$('#frmMantProcedimiento').validateAllForm("#divMensajeValidaProcedimiento"); 
    	if (validar) {
    		console.info('si valido form');
        	/**
        	 * Inicio: revisar validacion generica
        	 */
        	validaRubro=true;
        	cont=0;
        	errorCheck="";
        	$('#idActividadesAgregarSelect').find('input:checked').map(function(){        cont++;    });
        	if(cont==0){
        		console.info('si valido rubro');
            	validaRubro=false;
                var texto = "";
                var error = "RUBROS: Debe Seleccionar uno al menos.";
                errorCheck += texto + error;
                $('#divMensajeValidaProcedimiento').show();
                $('#divMensajeValidaProcedimiento').focus();
                $('#divMensajeValidaProcedimiento').html(errorCheck);
            }
        	/**
        	 * Fin
        	 */
        	if(validaRubro){
        confirm.open("¿Ud est&aacute; seguro de Guardar los Cambios?","procEditarProc()");      
        	}
    	}
};
function validarDependProcedimiento(){
    settearNamesFormMantProcedimiento();
    
    $.ajax({
        url:baseURL + "pages/procedimiento/validarDependProcedimiento",
        type:'post',
        async:false,
        data:$('#frmMantProcedimiento').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="RESTRICT"){
                mensajeGrowl("warn", data.mensaje, "");
            }else if(data.resultado=="DEPENDENCE"){
            	confirm.open(data.mensaje,"procEditarProc()");
            }else if(data.resultado=="SUCCESS") {
                confirm.open(data.mensaje,"procEditarProc()");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function procEditarProc(){
    settearNamesFormMantProcedimiento();
    
    $.ajax({
        url:baseURL + "pages/tramiteActividad/editarTramiteActividad",
        type:'post',
        async:false,
        data:$('#frmMantProcedimiento').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridTramRubr();
                $('#dialogMantTipoTramiteActividad').dialog('close');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function settearNamesFormMantProcedimiento(){
    //coloca name a input check tramites seleccionados
    var cont=0;
    $('#contTramites').find('input').removeAttr('name');//limpia names
    $('#contTramites').find('input:checked').map(function(){//busca marcados con check
      $(this).attr('name','tramites['+cont+'].idTramite');//les coloca names
      cont++;
    });
    //coloca name a input check actividades seleccionados
    cont=0;
    $('#idActividadesAgregarSelect').find('input:checked').map(function(){//busca marcados con check
      $(this).attr('name','actividades['+cont+'].idActividad');//les coloca names
      cont++;
    });
}
//EDITAR REQUISITO - FIN
//ELIMINAR REQUISITO - INICIO
function eliminarTramiteActividad (rowid){
    confirm.open("¿Ud est&aacute; seguro de eliminar?","procEliminarProc('"+rowid+"')");
}
function procEliminarProc(id){
    $.ajax({
        url:baseURL + "pages/tramiteActividad/eliminarTramiteActividad",
        type:'post',
        async:false,
        data:{
        	idTramiteActivdad:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridTramRubr();
            }else if(data.resultado=="RESTRICT"){
                mensajeGrowl("warn", data.mensaje, "");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//ELIMINAR REQUISITO - FIN

//CONSULTAR PROC - FIN
/////////////////////////
function procesarGridTramRubr(flg_load) {
    if(flg_load === undefined){flg_load=1;}
    
    var nombres = ['idActividad','Proceso','idEtapa','Etapa','idTramite','Trámite','idProceso','idEtapa','Rubro'];
    var columnas = [
        {name: "actividad.idActividad",width: 30,sortable: false,hidden: true,align: "center"}, 
        {name: "descripcion",width: 80,sortable: false,hidden: false,align: "left"},
        {name: "idEtapa",width: 150,sortable: false,hidden: true,align: "center"},
        {name: "descEtapa",width: 150,sortable: false,hidden: false,align: "left"},
        {name: "idTramite",width: 150,sortable: false,hidden: true,align: "center"},
        {name: "descTramite",width: 150,sortable: false,hidden: false,align: "left"},
        {name: "idProceso",width: 80,sortable: false,hidden: true,align: "center"},
        {name: "idEtapa",width: 80,sortable: false,hidden: true,align: "center"},
        {name: "actividad.nombre",width: 250,sortable: false,align: "left"}
      
    ];
  
    $("#gridContenedorTramiteActividad").html("");
    var grid = $("<table>", {
        "id": "gridTramiteActividad"
    });
    var pager = $("<div>", {
        "id": "paginacionTramiteActividad"
    });
    $("#gridContenedorTramiteActividad").append(grid).append(pager);

    grid.jqGrid({
        url: baseURL + "pages/tramiteActividad/findTramiteActividad",
        datatype: "json",
        postData: {
            idProceso:$('#cmbProcesoBusq').val(),
            idEtapa:$('#cmbEtapaBusq').val(),
            //idTramite:$('#cmbTramiteBusq').val(),
            idActividad:$('#txtIdActivP1').val(),
            flg_load:flg_load
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionTramiteActividad",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Trámites vs Rubros",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idTramiteActivdad"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkVerTramiteActividad').attr('onClick', 'abrirMantEditTramiteActividad("view","'+rowid+'")');
            $('#linkEditarTramiteActividad').attr('onClick', 'abrirMantEditTramiteActividad("edit","'+rowid+'")');
            $('#linkEliminarTramiteActividad').attr('onClick', 'eliminarTramiteActividad("'+rowid+'")');
            
            if($('#divEnlaceTagConsultar input').html()!=null){
                $('#contextMenuTramiteActividad li a[value="CO-TRAMITEACT"]').html($('#divEnlaceTagConsultar').html());
             } else {  
                $('#contextMenuTramiteActividad li a[value="CO-TRAMITEACT"]').remove();
             }
            
            if($('#divEnlaceTagEditar input').html()!=null){
                $('#contextMenuTramiteActividad li a[value="MO-TRAMITEACT"]').html($('#divEnlaceTagEditar').html());
             } else {  
                $('#contextMenuTramiteActividad li a[value="MO-TRAMITEACT"]').remove();
             }
            
            if($('#divEnlaceTagEliminar input').html()!=null){
                $('#contextMenuTramiteActividad li a[value="EL-TRAMITEACT"]').html($('#divEnlaceTagEliminar').html());
             } else {  
                $('#contextMenuTramiteActividad li a[value="EL-TRAMITEACT"]').remove();
             }
        },
        loadComplete: function(data) {
            $('#contextMenuTramiteActividad').parent().remove();
            $('#divContextMenuTramiteActividad').html("<ul id='contextMenuTramiteActividad'>"
                    + "<li> <a value='CO-TRAMITEACT'></a> </li>"
                    + "<li> <a value='MO-TRAMITEACT'></a></li>"
                    + "<li> <a value='EL-TRAMITEACT'></a></li>"
                   
                    + "</ul>");
            $('#contextMenuTramiteActividad').puicontextmenu({
                target: $('#gridTramiteActividad')
            });
//        onRightClickRow: function(rowid) {
//            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkVerTramiteActividad').attr('onClick', 'abrirMantEditTramiteActividad("view","'+rowid+'")');
//            $('#linkEditarTramiteActividad').attr('onClick', 'abrirMantEditTramiteActividad("edit","'+rowid+'")');
//            $('#linkEliminarTramiteActividad').attr('onClick', 'eliminarTramiteActividad("'+rowid+'")');
//            //$('#linkAgregarActProcedimiento').attr('onClick', 'agregarActProcedimiento("'+rowid+'","'+row.item+'","'+fxGrilla.limpiaPtos(row.denominacion)+'")');
//            //$('#linkVerActProcedimiento').attr('onClick', 'verActProcedimiento("'+rowid+'","'+row.item+'","'+fxGrilla.limpiaPtos(row.denominacion)+'")');
//          
//        },
//        loadComplete: function(data) {
//            $('#contextMenuTramiteActividad').parent().remove();
//            $('#divContextMenuTramiteActividad').html("<ul id='contextMenuTramiteActividad'>"
//                    + "<li> <a id='linkVerTramiteActividad' data-icon='ui-icon-search' title='Ver Detalle'>Consultar</a> </li>"
//                    + "<li> <a id='linkEditarTramiteActividad' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
//                    + "<li> <a id='linkEliminarTramiteActividad' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                   
//                    + "</ul>");
//            $('#contextMenuTramiteActividad').puicontextmenu({
//                target: $('#gridTramiteActividad')
//            });
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }      
    });
      
}

function abrirPopupBusqActividad() {
    $.ajax({
        url:baseURL + "pages/commonRequisitos/abrirPopupBusqActividad", 
        type:'get',
        async:false,
        data:{
            seleccion:"individual"
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogBusqActividad").html(data);
            $("#dialogBusqActividad").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: "Seleccione Rubro"
            });
        },
        error:errorAjax
    });
}

//DIALOG AGREGAR ACTIVIDADES
/*function verActProcedimiento(rowid,item,descripcion){
    $('#itemProcConsActi').html(item);
    $('#descripProcConsActi').html(descripcion);
    procesarGridActividadProcedimiento(rowid,item);
    $('#dialogConsultarActividad').dialog('open');
}*/
/*function agregarActProcedimiento(rowid,item,descripcion){
    limpiaFrmAgregarActividadProcedimiento();
    $('#dialogAgregarActividad').dialog('open');
    $('#itemProcAgreActi').html(item);
    $('#descripProcAgreActi').html(descripcion);
    //$("#arbolActividadesAgregar").fancytree("getTree").activateKey("19");
}*/
/*function limpiaFrmAgregarActividadProcedimiento(){
    $('#cmbTramiteProcAgreActi,#cmbDuplicarActiTramite').val("");
    $('#chkDuplicarActiTramite').attr('checked',false);
    $("#arbolActividadesAgregar").fancytree("getTree").visit(function(node){
        node.setSelected(false);
    });
    $('#chkTodoTramite').attr('checked',true);
    $('#chkTodoTramite').trigger('change');
}*/
/*function changeChkTodoTramite(){
    if($('#chkTodoTramite').attr('checked')){
        $('#filaTramite').hide();
    }else{
        $('#filaTramite').show();
    }
}*/
/*function initArbolActividadesAsignar(){
    $("#arbolActividadesAgregar").fancytree({
        checkbox: true,
        selectMode: 3,
        //source:treeData,
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
    
    $("#arbolActividadesAgregar").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
    $('#btnAgregarActividadProc').click(btnAgregarActividadProc);
}*/
/*function duplicarActiTramite(){
    if($('#chkDuplicarActiTramite').attr('checked') && $('#cmbDuplicarActiTramite').val()=='INSTALACION'){
        $("#arbolActividadesAgregar").fancytree("getTree").visit(function(node){
            node.setSelected(false);
        });
        var data=[16,18,19,20];
        $.each(data,function(k,v){
            $("#arbolActividadesAgregar").fancytree("getTree").getNodeByKey(String(v)).setSelected();        
        });
    }
}*/
/*function cargaActiPorTramite(){
    $("#arbolActividadesAgregar").fancytree("getTree").visit(function(node){
        node.setSelected(false);
    });
    if($('#cmbTramiteProcAgreActi').val()!=''){
        var data=[];
        if($('#itemProcAgreActi').html()=='H15'){
            data=[8,14,12,10,11,16,17,18,19,20];
        }else if($('#itemProcAgreActi').html()=='H18'){
            data=[22,23,24,25,26,27,28,29,30,31,32,33];
        }else if($('#cmbTramiteProcAgreActi').val()=='INSTALACION'){
            data=[16,18,19,20];
        }
                
        $.each(data,function(k,v){
            $("#arbolActividadesAgregar").fancytree("getTree").getNodeByKey(String(v)).setSelected();        
        });
    }
}*/
/*function quitarActividadDeAgregar(id,obj){
    $(obj).parent().remove();
    //retirando de arbol actividades
    $("#arbolActividadesAgregar").fancytree("getTree").getNodeByKey(String(id)).setSelected(false);   
}*/
/*function agregaActividadDeArbol(datax){
    var data=eval("("+datax+")");
    var html="";
    $.each(data,function(k,v){
        html+='<div id="'+v.id+'" class="fila">';
        html+=' <div class="txtFilaUnic ilb data" style="width: 97%">'+v.nombre+'</div>';
        html+=' <div onclick="quitarActividadDeAgregar('+v.id+',this)" class="btnQuitar ui-state-default ui-corner-all ilb" title="Quitar"><span class="ui-icon ui-icon-closethick"></span></div>';
        html+='</div>';
    });
    $('#idActividadesAgregarSelect').html(html);
}*/
/*function btnAgregarActividadProc(){
    mensajeGrowl("success", "Se registró correctamente", "");
    $('#dialogAgregarActividad').dialog('close');
}*/
function cargaEtapa(callback,CmbOrigen,tagDestino){
    var idProceso = $(CmbOrigen).val();
    if(idProceso!=""){
        $.ajax({
            url: baseURL + 'pages/tramiteActividad/obtenerEtapa',
            type: "get",
            async: false,
            dataType:"json",
            data:{
                idProceso: idProceso
            },
            success:function(data) {
                callback(data,'idEtapa','descripcion',tagDestino);
            },
            error:function(jqXHR){
                errorAjax(jqXHR);
            }
        });
    }else{
        callback([],'idEtapa','descripcion',tagDestino);
    }
}
function cargaTramite(callback,CmbOrigen,tagDestino){
    var idEtapa = $(CmbOrigen).val();
    if(idEtapa!=""){
        $.ajax({
            url: baseURL + 'pages/tramite/loadTramite',
            type: "post",
            async: false,
            data: {
                idEtapa: idEtapa
            },
            //beforeSend:muestraLoading,
            success: function(data) {
                //ocultaLoading();
                callback(data.filas,'idTramite','descripcion',tagDestino);
            },
            error:errorAjax
        });
    }else{
        callback([],'idTramite','descripcion',tagDestino);
    }
}
function cargaSilencioAdministrativo(callback,CmbOrigen,tagDestino,textoDefault){
    var idMaestroColumna = $(CmbOrigen).val();
    if(idMaestroColumna!=""){
        $.ajax({
            url: baseURL + 'pages/procedimiento/loadCmbSilencioAdministrativo',
            type: "post",
            async: false,
            data: {
                idMaestroColumna: idMaestroColumna
            },
            success: function(data) {
                callback(data.filas,'idMaestroColumna','descripcion',tagDestino,textoDefault);
            }
        });
    }else{
        callback([],'idMaestroColumna','descripcion',tagDestino);
    }
}
