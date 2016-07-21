//se usa en casos edit(editar), view(consultar) procedimiento
var idSileAdmi;
var idTramites;
var idActividades;
/* OSINE_SFS-610 - Inicio */
var nodeSeleccion='';
/* OSINE_SFS-610 - Fin */
$(function() {
    procesarGridRubroOpcion("0");
    initInicioProc();
    $('#btnAgregarActividadMan').click(btnAgregarActividadMan);    
    initArbolActividades();
});
function initInicioProc(){
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    confirm.start();
    $('#btnBuscarRubroOpcion').click(function(){procesarGridRubroOpcion();});
    //$('#cmbEtapaBusq').change(function(){cargaTramite(fill.combo,"#cmbEtapaBusq",'#cmbTramiteBusq');});
    $('#btnNuevoRubroOpcion').click(function(){abrirMantTramiteActividad("new");});
    $('#btnLimpiarForm').click(btnLimpiarForm);
}

function btnLimpiarForm(){
//    $('#buscarProc').find('input, select').val('');
    $('#buscarProc').find('select').val('');
    /* OSINE_SFS-610 - Inicio */
    procesarGridRubroOpcion(0);
    /* OSINE_SFS-610 - Fin */
}

function abrirMantTramiteActividad(tipo,rowid){
    var title="CONSULTAR TRÁMITE vs RUBRO";
    if(tipo=='edit'){
        title="EDITAR TRÁMITE vs RUBRO";
    }else if(tipo=='new'){
        title="NUEVA RELACIÓN RUBRO - OPCIÓN";
    }
    var row = $('#gridTramiteActividad').jqGrid('getRowData', rowid);
    $.ajax({
        url:baseURL + "pages/rubroOpcion/abrirManRubroOpcion", 
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
            $("#dialogMantTipoRubroOpcion").html(data);
            $("#dialogMantTipoRubroOpcion").dialog({
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


function abrirMantEditRubroOpcion(tipo,rowid){
	 /* OSINE_SFS-610 - Inicio */
	 var title="CONSULTAR ACTIVIDAD vs TIPO TRÁMITE";
	 /* OSINE_SFS-610 - Fin */
	    if(tipo=='edit'){
	    	/* OSINE_SFS-610 - Inicio */
	        title="EDITAR RELACIÓN RUBRO vs OPCIÓN";
	        /* OSINE_SFS-610 - Fin */
	 }
    var row = $('#gridRubroOpcion').jqGrid('getRowData', rowid);
    $.ajax({
        url:baseURL + "pages/rubroOpcion/abrirManEditRubroOpcion", 
        type:'get',
        async:false,
        data:{
            tipo:tipo,
            idRubroOpcion:rowid,
            idActividad:row.idActividad,
            idOpcion:row["opcion.idOpcion"]
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantTipoRubroOpcion").html(data);
            $("#dialogMantTipoRubroOpcion").dialog({
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
                $('#btnAgregarActividad').attr('disabled',true);
                $('#btnAgregarOpciones').attr('disabled',true);
            }
          
        },
        error:errorAjax
    });
}

// PROC NUEVO - INICIO 
function btnGuardarRubroOpcion(){
//	var validar=$('#frmMantRubroOpcion').validateAllForm("#divMensajeValidaTramiteActividad"); 
//    if (validar) {
    	/**
    	 * Inicio: revisar validacion generica
    	 */
    	validaRubro=true;
    	cont=0;
    	errorCheck="";
    	$('#idOpcionesAgregarSelect').find('input:checked').map(function(){        cont++;    });
    	
    	 if($('#cmbRubro').val()==""){
    		validaRubro=false;
    		var texto = "";
            var error = "RUBROS: Debe Seleccionar Actividad.";
            errorCheck += texto + error;
            $('#divMensajeValidaTramiteActividad').show();
            $('#divMensajeValidaTramiteActividad').focus();
            $('#divMensajeValidaTramiteActividad').html(errorCheck);
    	}
    	else if(cont==0){
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
    		confirm.open("¿Ud est&aacute; seguro de Guardar este nuevo registro?","procGuardarRubroOpcion()");
    	}
        
//    }
}
function procGuardarRubroOpcion(){
    settearNamesFormMantProcedimiento();
    $.ajax({
        url:baseURL + "pages/rubroOpcion/registrarRubroOpcion",
        type:'post',
        async:false,
        data:$('#frmMantRubroOpcion').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridRubroOpcion();
                $('#dialogMantTipoRubroOpcion').dialog('close');
                //confirm.open("¿Desea gestionar requisitos para este nuevo Tramite - Actividad?","gestionarRequProcedimientoForm('"+data.procedimiento.idProcedimiento+"','"+$('#txtItemProc').val()+"','"+$('#txtDenominacionProc').val()+"')",{textAceptar:'SI',textCancelar:'NO'});    
            }
            else if (data.resultado=="ERROR"){
            	mensajeGrowl("error", data.mensaje, "");
            }
            else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
// PROC NUEVO - FIN 
// EDITAR PROC - INICIO
function btnEditarRubroOpcion(){
  
    		console.info('si valido form');
        	/**
        	 * Inicio: revisar validacion generica
        	 */
        	validaRubro=true;
        	cont=0;
        	errorCheck="";
        	$('#idOpcionesAgregarSelect').find('input:checked').map(function(){        cont++;    });
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
               confirm.open("¿Ud est&aacute; seguro de Guardar los Cambios en este requisito?","procEditarRubroOpcion()");
        	}
};
function procEditarRubroOpcion(){
    settearNamesFormMantProcedimiento();
    
    $.ajax({
        url:baseURL + "pages/rubroOpcion/editarRubroOpcion",
        type:'post',
        async:false,
        data:$('#frmMantRubroOpcion').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridRubroOpcion();
                $('#dialogMantTipoRubroOpcion').dialog('close');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function settearNamesFormMantProcedimiento(){
    //coloca name a input check actividades seleccionados
    cont=0;
    $('#idOpcionesAgregarSelect').find('input:checked').map(function(){//busca marcados con check
    	$(this).attr('name','opciones['+cont+'].idOpcion');//les coloca names
      cont++;
    });
}
//EDITAR REQUISITO - FIN
//ELIMINAR REQUISITO - INICIO
function eliminarRubroOpcion (rowid, idActividad){
    confirm.open("¿Ud est&aacute; seguro de eliminar este requisito?","procEliminarRubroOpcion('"+rowid+"','"+idActividad+"')");
}
function procEliminarRubroOpcion(id, idActividad){
    $.ajax({
        url:baseURL + "pages/rubroOpcion/eliminarRubroOpcion",
        type:'post',
        async:false,
        data:{
        	idRubroOpcion:id,
        	idActividad: idActividad
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridRubroOpcion();
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
function procesarGridRubroOpcion(flg_load) {
    if(flg_load === undefined){flg_load=1;}
    
    var nombres = ['idActividad','Rubro','idOpcion','Opcion'];
    var columnas = [
        {name: "idActividad",width: 30,sortable: false,hidden: true,align: "center"}, 
        {name: "descActividad",width: 80,sortable: false,hidden: false,align: "center"},
        {name: "opcion.idOpcion",width: 30,sortable: false,hidden: true,align: "center"},
        {name: "opcion.nombre",width: 80,sortable: false,hidden: false,align: "center"}
    ];
  
    $("#gridContenedorRubroOpcion").html("");
    var grid = $("<table>", {
        "id": "gridRubroOpcion"
    });
    var pager = $("<div>", {
        "id": "paginacionRubroOpcion"
    });
    $("#gridContenedorRubroOpcion").append(grid).append(pager);

    grid.jqGrid({
        url: baseURL + "pages/rubroOpcion/findRubroOpcion",
        datatype: "json",
        postData: {
//            idProceso:$('#cmbTramiteActividad').val(),
//            idEtapa:$('#cmbEtapaBusq').val(),
            //idTramite:$('#cmbTramiteBusq').val(),
            idActividad:$('#cmbTramiteActividad').val(),
            flg_load:flg_load
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionRubroOpcion",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de relaciones Rubro vs Opci&oacute;n",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idRubroOpcion"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkVerTramiteActividad').attr('onClick', 'abrirMantEditRubroOpcion("view","'+rowid+'")');
            $('#linkEditarTramiteActividad').attr('onClick', 'abrirMantEditRubroOpcion("edit","'+rowid+'")');
            $('#linkEliminarTramiteActividad').attr('onClick', 'eliminarRubroOpcion("'+rowid+'","'+row.idActividad+'")');
            
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
                target: $('#gridRubroOpcion')
            });
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

/*jsifuentes*/
function btnAgregarActividadMan(){
    $('#popupArbolActiMan').dialog({
        width: 640,height:280,modal:true,
        close: function( event, ui ) {//se destruye popup para evitar conflicto con arbol y seleccionados
            //console.log('cerrando y destruyendo popup');
        	/* OSINE_SFS-610 - Inicio */
        	if(nodeSeleccion==null || nodeSeleccion==undefined || nodeSeleccion==''){
        		$('#optRubroMan').css("display","none");
        		$('#cmbTramiteActividad').val('');
        	} 
        	nodeSeleccion='';
        	/* OSINE_SFS-610 - Fin */
            $(this).dialog('destroy');
        }
    });
}

/*jsifuentes*/
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
    $("#arbolActividadesMan").fancytree({
        checkbox: true,
        selectMode: 1,
        source:treeData,
        select: function(event, data) {
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node){
                if(!node.folder){
                	console.log(node.key);                	                	
                	$("#optRubroMan").val(node.key);
                    $("#optRubroMan").text(node.title);
                    $("#optRubroMan").attr('selected','selected');
                    /* OSINE_SFS-610 - Inicio */
                    nodeSeleccion = node.key;
                    $('#optRubroMan').css("display","block");
                    /* OSINE_SFS-610 - Fin */
                    return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
                } else {
                	/* OSINE_SFS-610 - Inicio */
                	$('#optRubroMan').css("display","none");
                	/* OSINE_SFS-610 - Fin */
                }
            });
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
    
    $("#arbolActividadesMan").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
}
