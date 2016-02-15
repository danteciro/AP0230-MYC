var contadorEtapa = 0;
var contadorTramite = 0;
var contadorMotivoTramite = 0;
$(function() {
   // procesarGridParametroDinamico(0);
    initInicioEtapa();
    $('#frmMantEtapa').validarForm();
    procesarGridEtapaUtil(1, $("#cmbProcesoNuevo").val());
});
var alphaOptions = {
    allowNumeric  : true,
    allowLatin    : true,
    allowUpper    : true,
    allowLower    : true,
    allowCaseless : true,
    allowOtherCharSets : false,
    allowSpace    : true,
    allow	  : 'Ññóáéíóú'
};
function initInicioEtapa() {
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    //Inicializa Grid

    //
    confirm.start();
    
    $("#dialogMantEtapa").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    $("#dialogMantTramite").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    $("#dialogMantMotivoTramite").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
  
    $('#btnBuscarEtapa').click(function() {
    	idProceso=$("#cmbProcesoBusq").val();
    	flg_load=1;
        procesarGridEtapa(flg_load,idProceso);
    });
    $('#btnNuevoEtapa').click(btnNuevoEtapa);
    $('#btnGuardarEtapa').click(btnGuardarEtapa);
    $('#btnEditarEtapa').click(btnEditarEtapa);
    $('#btnLimpiarBuscarEtapa').click(btnLimpiarBuscarEtapa);
    $('#btnAgregarTramite').click(btnAgregarTramite); 
    $('#btnAgregarMotivoTramite').click(btnAgregarMotivoTramite); 
    $('#btnAgregarEtapa').click(function(){
    	idProceso=$('#cmbProceso').val();
        flg_load=1;
        procesarGridEtapaUtil(flg_load,idProceso);
    });
    $('#btnRegistrarEtapa').click(btnGuardarEtapaUtil);
    $('#btnEditarEtapaUtil').click(btnEditarEtapaUtil);
    $('#btnCancelarUtil').click(function(){
    	$('#btnEditarEtapaUtil').css('display','none');
        $('#btnCancelarUtil').css('display','none');
        $('#btnRegistrarEtapa').show();
        $('#btnAgregarEtapa').show();
    });
    $('.btnCloseDialog').click(function(){
    	$("#dialogMantEtapa").dialog("close");
    });
    $('#btnCloseFrmTramite').click(function(){
    	$('#dialogMantTramite').dialog('close');
    });
//    $('#btnNuevoValoPara').click(btnNuevoValoPara);
//    $('#btnGuardarValoPara').click(btnGuardarValoPara);
//    $('#btnEditarValoPara').click(btnEditarValoPara);
     
}
function btnLimpiarBuscarEtapa(){
    $('#cmbProcesoBusq').val(0);
}
function procesarGridEtapaUtil(flg_load,idProceso,tipo) {
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    //temporal
//    var mydata = [
//        {idEtapa: "1", proceso: "PROCESO 1", descripcion: "PRUEBA DE ETAPA 1", idProceso: "01"},
//        {idEtapa: "2", proceso: "PROCESO 2", descripcion: "PRUEBA DE ETAPA 2", idProceso: "02"}
//    ];
    //temporal
    $("#gridContenedorEtapa").html("");
    var grid = $("<table>", {
        "id": "gridEtapaUtil"
    });
    var pager = $("<div>", {
        "id": "paginacionEtapa"
    });
    $("#gridContenedorEtapa").append(grid).append(pager);

    var nombres = ['ID', 'PROCESO', 'ETAPA', 'IDPROCESO'];
    var columnas = [
        {name: "idEtapa", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "proceso", width: 150, sortable: false, hidden: false, align: "center"},
        {name: "descripcion", width: 350, sortable: false, hidden: false, align: "left"},
        {name: "idProceso", width: 150, sortable: false, hidden: true, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/etapaTramite/listarEtapa",
//        datatype: "local",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idProcesoBusqueda: idProceso,
            descripcion:$('#txtDescripcion').val()
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionEtapa",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Etapas",
       // autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idEtapa"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkVerProcedimiento').attr('onClick', 'verParametroDinamico("' + rowid + '")');
            $('#linkEditarEtapaUtil').attr('onClick','editarEtapaUtil("'+rowid+'")');
            $('#linkEliminarEtapaUtil').attr('onClick', 'eliminarEtapaUtil("' + rowid + '")');
            
            $('#linkSeleccionarEtapaUtil').attr('onClick', 'seleccionarEtapaUtil("' + rowid+'","'+tipo + '")');
            $('#linkGestionarTramite').attr('onClick', 'gestionarTramite("' + rowid + '")');
//            $('#linkAgregarActProcedimiento').attr('onClick', 'mostrarValorParametroDinamico("' + rowid + '","' + row.nombre + '")');
        },
        loadComplete: function(data) {
            //temporal
//            for (var i = 0; i <= mydata.length; i++) {
//                jQuery("#gridEtapa").jqGrid('addRowData', i + 1, mydata[i]);
//            }
            //temporal
        	
            $('#contextMenuEtapa').parent().remove();
            $('#divContextMenuEtapa').html("<ul id='contextMenuEtapa'>"
            		+ "<li> <a id='linkEditarEtapaUtil' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
            		+ "<li> <a id='linkEliminarEtapaUtil' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
            		+ "<li> <a id='linkSeleccionarEtapaUtil' data-icon='ui-icon-check' title='Seleccionar'>Seleccionar</a></li>"
//                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
                    + "</ul>");
            $('#contextMenuEtapa').puicontextmenu({
                target: $('#gridEtapaUtil')
            });
        }
    });
}

function procesarGridEtapa(flg_load,idProceso) {
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    //temporal
//    var mydata = [
//        {idEtapa: "1", proceso: "PROCESO 1", descripcion: "PRUEBA DE ETAPA 1", idProceso: "01"},
//        {idEtapa: "2", proceso: "PROCESO 2", descripcion: "PRUEBA DE ETAPA 2", idProceso: "02"}
//    ];
    //temporal
    $("#gridContenedorEtapa").html("");
    var grid = $("<table>", {
        "id": "gridEtapa"
    });
    var pager = $("<div>", {
        "id": "paginacionEtapa"
    });
    $("#gridContenedorEtapa").append(grid).append(pager);

    var nombres = ['ID', 'PROCESO', 'ETAPA', 'IDPROCESO'];
    var columnas = [
        {name: "idEtapa", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "proceso", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "descripcion", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "idProceso", width: 100, sortable: false, hidden: true, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/etapaTramite/listarEtapa",
//        datatype: "local",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idProcesoBusqueda: idProceso
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionEtapa",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Etapas",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idEtapa"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkVerProcedimiento').attr('onClick', 'verParametroDinamico("' + rowid + '")');
            $('#linkEditarEtapaUtil').attr('onClick','editarEtapaUtil("'+rowid+'")');
            $('#linkEliminarEtapaUtil').attr('onClick', 'eliminarEtapaUtil("' + rowid + '")');
            $('#linkEditarEtapa').attr('onClick', 'editarEtapa("' + rowid + '")');
            $('#linkEliminarEtapa').attr('onClick', 'eliminarEtapa("' + rowid + '")');
            $('#linkGestionarTramite').attr('onClick', 'gestionarTramite("' + rowid + '")');
//            $('#linkAgregarActProcedimiento').attr('onClick', 'mostrarValorParametroDinamico("' + rowid + '","' + row.nombre + '")');
        },
        loadComplete: function(data) {
            //temporal
//            for (var i = 0; i <= mydata.length; i++) {
//                jQuery("#gridEtapa").jqGrid('addRowData', i + 1, mydata[i]);
//            }
            //temporal
            $('#contextMenuEtapa').parent().remove();
            $('#divContextMenuEtapa').html("<ul id='contextMenuEtapa'>"
            		
                    + "<li> <a id='linkEditarEtapa' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarEtapa' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "<li> <a id='linkGestionarTramite' data-icon='ui-icon-bookmark' title='Gestionar Maestro Columna'>Gestionar Tramites</a></li>"
//                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
                    + "</ul>");
            $('#contextMenuEtapa').puicontextmenu({
                target: $('#gridEtapa')
            });
        }
    });
}


function btnNuevoEtapa() {
    limpiaFrmMantEtapa();
    $("#dialogMantEtapa").dialog("option", "title", "NUEVA ETAPA");
    $("#dialogMantEtapa").dialog("open");
	//abrirMantEtapa('new','');
}
function abrirMantEtapa(tipo,rowid){
	limpiaFrmMantEtapa();
  //  $("#dialogMantEtapa").dialog("option", "title", "NUEVA ETAPA");
  //  $("#dialogMantEtapa").dialog("open");

        var title="CONSULTAR ETAPA";
        if(tipo=='edit'){
            title="EDITAR ETAPA";
        }else if(tipo=='new'){
            title="NUEVO ETAPA";
        }
        
        var row = $('#gridObligacionProceso').jqGrid('getRowData', rowid);
        $.ajax({
            url:baseURL + "pages/etapa/abrirMantEtapa", 
            type:'get',
            async:false,
            data:{
                tipo:tipo              
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
                    closeText:"Cerrar"
                });
                if(tipo=="view"){
                    $('#frmMantObligacionProceso').find('input,select,textarea').attr('disabled',true);
                }
            },
            error:errorAjax
        });
    
    $("#txtNombreZonificacion").alphanum(alphaOptions);
}
function limpiaFrmMantEtapa() {
    $('#frmMantEtapa').find('input,select,textarea').not('#btnAgregarEtapa').val("");
    $('#btnEditarEtapa').hide();
    $('#btnGuardarEtapa').show();
}
function limpiaFrmMantTramite() {
    $('#frmMantTramite').find('input,select,textarea').not('#btnAgregarTramite,#txtEtapaTr').val("");
//    $('#btnEditarMaesTabl').hide();
//    $('#btnGuardarMaesTabl').show();
}
function limpiaFrmMantMotivoTramite() {
    $('#frmMantMotivoTramite').find('input,select,textarea').not('#btnAgregarMotivoTramite,#txtTramite').val("");
//    $('#btnEditarMaesTabl').hide();
//    $('#btnGuardarMaesTabl').show();
}
function btnGuardarEtapa() {
    confirm.open("¿Ud. est&aacute; seguro de guardar estos registros?", "procGuardarEtapa()");
}
function btnGuardarEtapaUtil() {
	var validar=$('#frmMantEtapa').validateAllForm("#divMensajeValidaEtapa");
	if(validar){
		confirm.open("¿Desea registrar esta Etapa?", "procGuardarEtapaUtil()");
	}
    
}
function procGuardarEtapaUtil() {
	
    	$.ajax({
            url:baseURL + "pages/etapaTramite/registrarEtapa",
            type:'post',
            async:false,
            data: {
                idProceso:$('#cmbProceso').val(),
                descripcionEtapa:$('#txtDescripcion').val()
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                if(data.resultado=="0"){
                	mensajeGrowl("success", "Se registró correctamente", "");
                	idProceso=$('#cmbProceso').val();
                    flg_load=1;
                    procesarGridEtapaUtil(flg_load,idProceso);
                    fill.combo(data.listadoEtapa,'idEtapa','descripcion','#cmbEtapa');
                }else{
                    error = "1";
                    mensajeGrowl("error", data.mensaje, "");
                }
            },
            error:errorAjax
        });
//        $("#dialogMantEtapa").dialog("close");

}
//function procGuardarEtapa() {
//    var rows= jQuery("#gridEtapaAgregar").jqGrid('getRowData');
//    var error = "0";
//    	$.ajax({
//            url:baseURL + "pages/etapaTramite/registrarEtapa",
//            type:'post',
//            async:false,
//            data: {
//                idProceso:$('#cmbProceso').val(),
//                descripcionEtapa:$('#txtDescripcion').val()
//            },//$('#frmMantZonificacion').serialize(),
//            beforeSend:muestraLoading,
//            success:function(data){
//                ocultaLoading();
//                if(data.resultado=="0"){
//                	 fill.combo(data.listadoEtapa,'idEtapa','descripcion','#cmbEtapa');
////                    mensajeGrowl("success", "Se registró correctamente", "");
////                    procesarGridZonificacion();
////                    $("#dialogMantZonificacion").dialog("close");
////                    confirm.open("¿Desea configurar detalle para esta zonificación?", "configurarDetalle("+data.idZoni+")");
//                }else{
//                    error = "1";
//                    mensajeGrowl("error", data.mensaje, "");
//                }
//            },
//            error:errorAjax
//        });
//        $("#dialogMantEtapa").dialog("close");
//    
//    if(error === "0"){
//        mensajeGrowl("success", "Se registró correctamente", "");
//        idProceso=$('#cmbProcesoBusq').val();
//    	flg_load=1;
//        procesarGridEtapa(flg_load,idProceso);
//        $("#dialogMantEtapa").dialog("close");
//    }else{
//        mensajeGrowl("error", "Error al registrar", "");
//    }
//}
function seleccionarEtapaUtil(rowid,tipo){
	var row = $('#gridEtapaUtil').jqGrid('getRowData', rowid);
		$('#cmbProcesoNuevo').val(row["idProceso"]);
//		$('#cmbProcesoEditar').val(row["idProceso"]);
		
		obtenerEtapa($('#cmbProcesoNuevo').val());
//		obtenerEtapa($('#cmbProcesoEditar').val());
		setTimeout(function(){ $('#cmbEtapa').val(row["idEtapa"]); $('#cmbEtapa').trigger("change"); }, 500);
		$("#dialogMantEtapa").dialog("close");
}

function editarEtapaUtil(rowid){
    
    var row = $('#gridEtapaUtil').jqGrid('getRowData', rowid);
    $('#btnEditarEtapaUtil').css('display','inline-block');
    $('#btnCancelarUtil').css('display','inline-block');
    $('#btnRegistrarEtapa').hide();
    $('#btnAgregarEtapa').hide();
    
    $('#txtIdEtapa').val(row["idEtapa"]);
    $('#txtIdProceso').val(row["idProceso"]);
    $('#cmbProceso').val(row["idProceso"]);
    $('#txtDescripcion').val(row["descripcion"]);
}
function editarEtapa(rowid){
    limpiaFrmMantEtapa();
    
    var row = $('#gridEtapa').jqGrid('getRowData', rowid);
    $("#dialogMantEtapa").dialog("option", "title", "EDITAR ETAPA");
    $("#dialogMantEtapa").dialog("open");
    $('#btnEditarEtapa').show();
    $('#btnGuardarEtapa').hide();
    $('#btnAgregarEtapa').hide();
    
    $('#txtIdEtapa').val(row["idEtapa"]);
    $('#txtIdProceso').val(row["idProceso"]);
    $('#cmbProceso').val(row["idProceso"]);
    $('#txtDescripcion').val(row["descripcion"]);
}
function btnEditarEtapa(){
    $('#txtDescripcion').val($('#txtDescripcion').val().trim());
    var validar = $('#frmMantEtapa').validateAllForm("#divMensajeValidaEtapa");
    if (validar) {
        confirm.open("¿Ud. est&aacute; seguro de guardar los cambios en esta etapa?", "procEditarEtapa()");
    }
}
function procEditarEtapa() {
    $.ajax({
        url:baseURL + "pages/etapaTramite/editarEtapa",
        type:'post',
        async:false,
        data:$('#frmMantEtapa').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", "Se actualizó el registro correctamente", "");
                idProceso=$('#cmbProcesoBusq').val();
                flg_load=1;
                procesarGridEtapa(flg_load,idProceso);
                $("#dialogMantEtapa").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function btnEditarEtapaUtil(){
    $('#txtDescripcion').val($('#txtDescripcion').val().trim());
    var validar = $('#frmMantEtapa').validateAllForm("#divMensajeValidaEtapa");
    if (validar) {
        confirm.open("¿Ud. est&aacute; seguro de guardar los cambios en esta etapa?", "procEditarEtapaUtil()");
    }
}
function procEditarEtapaUtil() {
    $.ajax({
        url:baseURL + "pages/etapaTramite/editarEtapa",
        type:'post',
        async:false,
        data:$('#frmMantEtapa').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", "Se actualizó el registro correctamente", "");
                idProceso=$('#cmbProceso').val();
                flg_load=1;
                procesarGridEtapaUtil(flg_load,idProceso);
                $('#btnEditarEtapaUtil').css('display','none');
                $('#btnCancelarUtil').css('display','none');
                $('#btnRegistrarEtapa').show();
                $('#btnAgregarEtapa').show();
            }else{
                mensajeGrowl("error", data.mensaje, "");
                $('#btnEditarEtapaUtil').css('display','none');
                $('#btnCancelarUtil').css('display','none');
                $('#btnRegistrarEtapa').show();
                $('#btnAgregarEtapa').show();
            }
        },
        error:errorAjax
    });
}
function eliminarEtapaUtil(rowid) {
    var row = $('#gridEtapaUtil').jqGrid('getRowData', rowid);
    confirm.open("¿Ud. est&aacute; seguro de eliminar la etapa?", "procEliminarEtapaUtil('" + row.idEtapa + "')");
}
function procEliminarEtapaUtil(id) {
    $.ajax({
        url:baseURL + "pages/etapaTramite/eliminarEtapa",
        type:'post',
        async:false,
        data:{
            idEtapa:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", "Se eliminó el registro correctamente", "");
                idProceso=$('#cmbProceso').val();
                flg_load=1;
                procesarGridEtapaUtil(flg_load,idProceso);
                $('#btnEditarEtapaUtil').css('display','none');
                $('#btnCancelarUtil').css('display','none');
                $('#btnRegistrarEtapa').show();
                $('#btnAgregarEtapa').show();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function eliminarEtapa(rowid) {
    var row = $('#gridEtapa').jqGrid('getRowData', rowid);
    confirm.open("¿Ud. est&aacute; seguro de eliminar la etapa?", "procEliminarEtapa('" + row.idEtapa + "')");
}
function procEliminarEtapa(id) {
    $.ajax({
        url:baseURL + "pages/etapaTramite/eliminarEtapa",
        type:'post',
        async:false,
        data:{
            idEtapa:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", "Se eliminó el registro correctamente", "");
                idProceso=$('#cmbProcesoBusq').val();
                flg_load=1;
                procesarGridEtapa(flg_load,idProceso);
                $("#dialogMantEtapa").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function gestionarTramite(rowid){
	abrirMantTramite('new',rowid);
}
function abrirMantTramite(tipo,rowid){
    var row = $('#gridEtapa').jqGrid('getRowData', rowid);
  //  $("#dialogMantTramite").dialog("option", "title", "NUEVO TRAMITE");
  //  $("#dialogMantTramite").dialog("open");
  
    
    var title="CONSULTAR TRAMITE";
    if(tipo=='edit'){
        title="EDITAR TRAMITE";
    }else if(tipo=='new'){
        title="NUEVO TRAMITE";
    }    
    $.ajax({
        url:baseURL + "pages/etapaTramite/abrirMantTramite", 
        type:'get',
        async:false,
        data:{
            tipo:tipo              
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
                closeText:"Cerrar"
            });
            if(tipo=="view"){
                $('#frmMantObligacionProceso').find('input,select,textarea').attr('disabled',true);
            }
        },
        error:errorAjax
    });
    $('#txtIdEtapaTramite').val(row["idEtapa"]);
    $('#txtEtapaTr').val(row["descripcion"]);
    procesarGridTramite();
//    $('#txtIdAplicacion').val(row["aplicacion"]);
}

function gestionarMotivoTramite(rowid){
    var row = $('#gridTramite').jqGrid('getRowData', rowid);
    $("#dialogMantMotivoTramite").dialog("option", "title", "NUEVO MOTIVO - TRAMITE");
    $("#dialogMantMotivoTramite").dialog("open");
    
    $('#txtTramite').val(row["descripcion"]);
//    $('#txtIdAplicacion').val(row["aplicacion"]);
}
function btnAgregarTramite(){
    var validar=$('#frmMantTramite').validateAllForm('#divMensajeValidatramite');
    if(validar){
	
    $.ajax({
        url: baseURL + "pages/tramite/registrarTramite",
        type: 'post',
        async: false,
        data: {
            idEtapa: $('#txtIdEtapaTramite').val(),
            descripcionTramite: $('#txtDescripcionTr').val()
        }, //$('#frmMantZonificacion').serialize(),
        beforeSend: muestraLoading,
        success: function(data) {
            ocultaLoading();
            if (data.resultado == "0") {
                    mensajeGrowl("success", "Se registró correctamente", "");
                    procesarGridTramite();
                    $('#cmbEtapa').trigger("change");
                    //$("#dialogMantZonificacion").dialog("close");
                    //confirm.open("¿Desea configurar detalle para esta zonificación?", "configurarDetalle("+data.idZoni+")");
            } else {
                error = "1";
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error: errorAjax
    });
//    $("#dialogMantZonificacion").dialog("close");
//    var mydata = [{
//            etapa: $('#txtIdEtapaTramite').val(),
//            descripcion: $('#txtDescripcionTr').val()
//    }];
//    if(contadorTramite==0){
//        procesarGridTramite();
//    }
//    if(jQuery("#gridTramite").length>0){
//        jQuery("#gridTramite").jqGrid('addRowData',contadorTramite,mydata[0]); 
//	contadorTramite++;
//    }
//    limpiaFrmMantTramite();
	
	}
}
function btnAgregarMotivoTramite(){
    var mydata = [{
            tramite: $('#txtTramite').val(),
            descripcion: $('#txtDescripcionMotivoTr').val()
    }];
    if(contadorMotivoTramite==0){
        procesarGridMotivoTramite();
    }
    if(jQuery("#gridMotivoTramite").length>0){
        jQuery("#gridMotivoTramite").jqGrid('addRowData',contadorMotivoTramite,mydata[0]); 
        contadorMotivoTramite++;
    }
    limpiaFrmMantMotivoTramite();
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
        {name: "descripcion", width: 500, sortable: false, hidden: false, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/tramite/listarTramiteUtil",
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
            $('#linkEliminarTramite').attr('onClick', 'getEliminarTramite("' + rowid + '")');
            $('#linkGestionarMotivo').attr('onClick', 'gestionarMotivoTramite("' + rowid + '")');
        },
        loadComplete: function(data) {
            $('#contextMenuTramite').parent().remove();
            $('#divContextMenuTramite').html("<ul id='contextMenuTramite'>"
//                    + "<li> <a id='linkEditarZonificacionDetalle' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarTramite' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                    + "<li> <a id='linkGestionarMotivo' data-icon='ui-icon-pencil' title='Gestionar Motivo'>Gestionar Motivo</a></li>"
//                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
                    + "</ul>");
            $('#contextMenuTramite').puicontextmenu({
                target: $('#gridTramite')
            });
        }
    });
}
function getEliminarTramite(rowid){
    var row = $('#gridTramite').jqGrid('getRowData', rowid);
    confirm.open('¿Desea eliminar este trámite?','eliminarTramite("'+row.idTramite+'")');
}

function eliminarTramite(idtramite) {
    
    $.ajax({
        url:baseURL + "pages/tramite/eliminarTramite",
        type:'post',
        async:false,
        data:{
            idTramite:idtramite
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", "Se eliminó el registro correctamente", "");
                procesarGridTramite();
                $('#cmbEtapa').trigger("change");
                //$("#dialogMantZonificacion").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
    
//    $('#gridTramite').jqGrid('delRowData',rowid);
//    contadorTramite--;
}
function btnAgregarEtapa(){
//    var validar = $('#frmMantEtapa').validateAllForm("#divMensajeValidaEtapa");

    idProceso=$('#cmbProceso').val();
	flg_load=1;
    procesarGridEtapa(flg_load,idProceso);
}
function procesarGridEtapaAgregar(){
    $("#gridContenedorEtapaAgregar").html("");
    var grid = $("<table>", {
        "id": "gridEtapaAgregar"
    });
    var pager = $("<div>", {
        "id": "paginacionEtapaAgregar"
    });
    $("#gridContenedorEtapaAgregar").append(grid).append(pager);

    var nombres = ['IDPROCESO', 'PROCESO', 'ETAPA'];
    var columnas = [
        {name: "idProceso", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "nombreProceso", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "descripcionEtapa", width: 100, sortable: false, hidden: false, align: "center"}
    ];
    grid.jqGrid({
//        url: baseURL + "pages/zonificacionDetalle/listarZonificacionDetalle",
        datatype: "local",
//        postData: {
//            flg_load: flg_load,
//            zonificacion: $("#cmbZonificacionesBusq").val()
//        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionEtapaAgregar",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Etapas",
        autowidth: true,
//        jsonReader: {
//            root: "filas",
//            page: "pagina",
//            total: "total",
//            records: "registros",
//            repeatitems: false,
//            id: "idZonificacionDetalle"
//        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkVerProcedimiento').attr('onClick', 'verParametroDinamico("' + rowid + '")');
//            $('#linkEditarZonificacionDetalle').attr('onClick', 'editarZonificacionDetalle("' + rowid + '")');
            $('#linkEliminarEtapaAgregar').attr('onClick', 'eliminarEtapaAgregar("' + rowid + '")');
//            $('#linkAgregarActProcedimiento').attr('onClick', 'mostrarValorParametroDinamico("' + rowid + '","' + row.nombre + '")');
        },
        loadComplete: function(data) {
        	
            $('#contextMenuEtapaAgregar').parent().remove();
            $('#divContextMenuEtapaAgregar').html("<ul id='contextMenuEtapaAgregar'>"
//                    + "<li> <a id='linkEditarZonificacionDetalle' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarEtapaAgregar' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
                    + "</ul>");
            $('#contextMenuEtapaAgregar').puicontextmenu({
                target: $('#gridEtapaAgregar')
            });
        }
    });
}
function eliminarEtapaAgregar(rowid) {
    $('#gridEtapaAgregar').jqGrid('delRowData',rowid);
    contadorEtapa--;
}
function procesarGridMotivoTramite(){
    $("#gridContenedorMotivoTramite").html("");
    var grid = $("<table>", {
        "id": "gridMotivoTramite"
    });
    var pager = $("<div>", {
        "id": "paginacionMotivoTramite"
    });
    $("#gridContenedorMotivoTramite").append(grid).append(pager);

    var nombres = ['TRAMITE', 'DESCRIPCION'];
    var columnas = [
        {name: "tramite", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "descripcion", width: 100, sortable: false, hidden: false, align: "left"}
    ];
    grid.jqGrid({
//        url: baseURL + "pages/zonificacionDetalle/listarZonificacionDetalle",
        datatype: "local",
//        postData: {
//            flg_load: flg_load,
//            zonificacion: $("#cmbZonificacionesBusq").val()
//        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionMotivoTramite",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Motivo Tramite",
        autowidth: true,
//        jsonReader: {
//            root: "filas",
//            page: "pagina",
//            total: "total",
//            records: "registros",
//            repeatitems: false,
//            id: "idZonificacionDetalle"
//        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkVerProcedimiento').attr('onClick', 'verParametroDinamico("' + rowid + '")');
//            $('#linkEditarZonificacionDetalle').attr('onClick', 'editarZonificacionDetalle("' + rowid + '")');
            $('#linkEliminarMotivoTramite').attr('onClick', 'eliminarMotivoTramite("' + rowid + '")');
        },
        loadComplete: function(data) {
            $('#contextMenuMotivoTramite').parent().remove();
            $('#divContextMenuMotivoTramite').html("<ul id='contextMenuMotivoTramite'>"
//                    + "<li> <a id='linkEditarZonificacionDetalle' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarMotivoTramite' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
                    + "</ul>");
            $('#contextMenuMotivoTramite').puicontextmenu({
                target: $('#gridMotivoTramite')
            });
        }
    });
}

function eliminarMotivoTramite(rowid) {
    $('#gridMotivoTramite').jqGrid('delRowData',rowid);
    contadorMotivoTramite--;
}