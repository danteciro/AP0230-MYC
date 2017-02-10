var idActividades;
$(function() {
    procesarGridObligacionProceso(0);
    initInicioObligacionProceso();   
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
function initInicioObligacionProceso() {
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    confirm.start();
  
    $('#btnBuscarOP').click(function(){procesarGridObligacionProceso();});
    $('#btnNuevoObligacionProceso').click(function(){abrirMantObligacionProceso("new");});
    $("#btnLimpiarForm").click(btnLimpiarForm);
    //$('#btnGuardarObligacionProceso').click(btnGuardarObligacionProceso);
    //$('#btnEditarObligacionProceso').click(btnEditarObligacionProceso);
}

function btnLimpiarForm(){
    $('#formBusqueda').find('input, select').val('');
 
}
function procesarGridObligacionProceso(flg_load) {
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorObligacionProceso").html("");
    var grid = $("<table>", {
        "id": "gridObligacionProceso"
    });
    var pager = $("<div>", {
        "id": "paginacionObligacionProceso"
    });
    $("#gridContenedorObligacionProceso").append(grid).append(pager);

    var nombres = ['ID','idProceso','PROCESO','idObligacionTipo','OBLIGACION TIPO','idActividad','ACTIVIDAD'];
    var columnas = [
        {name: "idProOblTip", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "proceso.idProceso", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "proceso.descripcion", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "obligacionTipo.idObligacionTipo", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "obligacionTipo.nombre", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "actividad.idActividad", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "actividad.nombre", width: 100, sortable: false, hidden: false, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/procesoObligacionTipo/findProcesoObligacionTipo",
        datatype: "local",
       datatype: "json",
       postData: {
            flg_load: flg_load,
            idActividad: $("#txtIdActivP1").val(),
            idObligacionTipo:$("#cmbObligacionTipo").val(),
            idProceso:$("#cmbProceso").val()
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionObligacionProceso",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Proceso Obligacion",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idProOblTip"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkVerObligacionProceso').attr('onClick', 'abrirMantObligacionProceso("view","' + rowid + '")');
            $('#linkEditarObligacionProceso').attr('onClick', 'abrirMantObligacionProceso("edit","' + rowid + '")');
            $('#linkEliminarObligacionProceso').attr('onClick', 'eliminarObligacionProceso("' + rowid + '")');
            
            if($('#divEnlaceTagVerObliTipo input').html()!=null){
                $('#contextMenuObligacionProceso li a[value="CO-OBLIGACIONPROC"]').html($('#divEnlaceTagVerObliTipo').html());
             } else {  
                $('#contextMenuObligacionProceso li a[value="CO-OBLIGACIONPROC"]').remove();
             }
            
            if($('#divEnlaceTagEliminarObliTipo input').html()!=null){
                $('#contextMenuObligacionProceso li a[value="EL-OBLIGACIONPROC"]').html($('#divEnlaceTagEliminarObliTipo').html());
             } else {  
                $('#contextMenuObligacionProceso li a[value="EL-OBLIGACIONPROC"]').remove();
             }
        },
        loadComplete: function(data) {
            $('#contextMenuObligacionProceso').parent().remove();
            $('#divContextMenuObligacionProceso').html("<ul id='contextMenuObligacionProceso'>"
            		+ "<li> <a value='CO-OBLIGACIONPROC'>Consultar</a> </li>"
                    + "<li> <a value='EL-OBLIGACIONPROC'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuObligacionProceso').puicontextmenu({
                target: $('#gridObligacionProceso')
            });
//        onRightClickRow: function(rowid, iRow, iCol, e) {
//            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkVerObligacionProceso').attr('onClick', 'abrirMantObligacionProceso("view","' + rowid + '")');
//            $('#linkEditarObligacionProceso').attr('onClick', 'abrirMantObligacionProceso("edit","' + rowid + '")');
//            $('#linkEliminarObligacionProceso').attr('onClick', 'eliminarObligacionProceso("' + rowid + '")');
//        },
//        loadComplete: function(data) {
//            $('#contextMenuObligacionProceso').parent().remove();
//            $('#divContextMenuObligacionProceso').html("<ul id='contextMenuObligacionProceso'>"
//            		+ "<li> <a id='linkVerObligacionProceso' data-icon='ui-icon-search' title='Ver Detalle'>Consultar</a> </li>"
//            		//+ "<li> <a id='linkEditarObligacionProceso' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
//                    + "<li> <a id='linkEliminarObligacionProceso' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                    + "</ul>");
//            $('#contextMenuObligacionProceso').puicontextmenu({
//                target: $('#gridObligacionProceso')
//            });
        }
    });
}


function abrirMantObligacionProceso(tipo,rowid){
    var title="CONSULTAR PROCESO OBLIGACION";
    if(tipo=='edit'){
        title="EDITAR PROCESO OBLIGACION";
    }else if(tipo=='new'){
        title="NUEVO PROCESO OBLIGACION";
    }
    
    var row = $('#gridObligacionProceso').jqGrid('getRowData', rowid);
    $.ajax({
        url:baseURL + "pages/procesoObligacionTipo/abrirMantProcesoObligacionTipo", 
        type:'get',
        async:false,
        data:{
            tipo:tipo,
            idProOblTip:rowid,
            idObligacionTipo:row['obligacionTipo.idObligacionTipo'],
            idActividad:row['actividad.idActividad'],
            idProceso:row['proceso.idProceso']
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantObligacionProceso").html(data);
            $("#dialogMantObligacionProceso").dialog({
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
                $('#frmMantProcesoObligacionTipo').find('input,select,textarea').attr('disabled',true);
            }
        },
        error:errorAjax
    });
}

function eliminarObligacionProceso(rowid) {
    confirm.open("¿Ud. est&aacute; seguro de eliminar este registro?","procEliminarObligacionProceso('"+rowid+"')");
}

function procEliminarObligacionProceso(id){
    $.ajax({
        url:baseURL + "pages/procesoObligacionTipo/eliminarProcesoObligacionTipo",
        type:'post',
        async:false,
        data:{
            idProOblTip:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridObligacionProceso();
            }else {
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
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

//PROC NUEVO - INICIO 
function btnGuardarProcesoObliTipo(){
    if ( $('#frmMantProcesoObligacionTipo').validateAllForm("#divMensajeValidaProcesoObligacionTipo") ) {
        if($('#idActividadesAgregarSelect').children('div').length>0){
            confirm.open("¿Ud est&aacute; seguro de Guardar?","procGuardarProcesoObliTipo()");
        }else{
            mensajeGrowl("warn", "Seleccione Rubro", "");
        }
    }
}
function procGuardarProcesoObliTipo(){
    settearNamesFormMantProcedimiento();
    $.ajax({
        url:baseURL + "pages/procesoObligacionTipo/registrarProcesoObligacionTipo",
        type:'post',
        async:false,
        data:$('#frmMantProcesoObligacionTipo').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridObligacionProceso();
                $('#dialogMantObligacionProceso').dialog('close');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//PROC EDITAR - INICIO 
function btnEditarProcesoObliTipo(){
    if ( $('#frmMantProcesoObligacionTipo').validateAllForm("#divMensajeValidaProcesoObligacionTipo") ) {
        if($('#idActividadesAgregarSelect').children('div').length>0){
            confirm.open("¿Ud est&aacute; seguro de Guardar los cambios?","procEditarProcesoObliTipo()");
        }else{
            mensajeGrowl("warn", "Seleccione Rubro", "");
        }
    }
}
function procEditarProcesoObliTipo(){
    settearNamesFormMantProcedimiento();
    $.ajax({
        url:baseURL + "pages/procesoObligacionTipo/editarProcesoObligacionTipo",
        type:'post',
        async:false,
        data:$('#frmMantProcesoObligacionTipo').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridObligacionProceso();
                $('#dialogMantObligacionProceso').dialog('close');
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
    $('#idActividadesAgregarSelect').find('input:checked').map(function(){//busca marcados con check
      $(this).attr('name','actividades['+cont+'].idActividad');//les coloca names
      cont++;
    });
}