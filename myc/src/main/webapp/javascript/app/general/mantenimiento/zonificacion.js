var contadorZonificacion=0;
$(function() {
   // procesarGridParametroDinamico(0);
    initInicioZonificacion();
    $('#frmMantZonificacion').validarForm();
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
function initInicioZonificacion() {
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    confirm.start();
    $("#dialogMantZonificacion").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
//    comboboxMaestroColumna('cmbAmbitoParaBusq', baseURL + "pages/parametro/findAmbitoParametro");
//    comboboxMaestroColumna('cmbAmbitoPara', baseURL + "pages/parametro/findAmbitoParametro");
//    comboboxMaestroColumna('cmbTipoConsulta', baseURL + "pages/parametro/findTipoConsulta");

    $('#btnBuscarZoni').click(function() {
        procesarGridZonificacion();
    });
    $('#btnNuevoZoni').click(btnNuevoZoni);
    $('#btnGuardarZoni').click(btnGuardarZoni);
    $('#btnEditarZoni').click(btnEditarZoni);
    $('#btnAgregarZoni').click(btnAgregarZoni);
    $('#btnLimpiarBuscarZoni').click(btnLimpiarBuscarZoni);
//    $('#btnNuevoValoPara').click(btnNuevoValoPara);
//    $('#btnGuardarValoPara').click(btnGuardarValoPara);
//    $('#btnEditarValoPara').click(btnEditarValoPara);
     
}
function btnLimpiarBuscarZoni(){
    $('#txtDescripZoniBusq').val("");
}
function procesarGridZonificacion(flg_load) {
    if (flg_load === undefined) {
        flg_load = 1;
    }

    $("#gridContenedorZonificacion").html("");
    var grid = $("<table>", {
        "id": "gridZonificacion"
    });
    var pager = $("<div>", {
        "id": "paginacionZonificacion"
    });
    $("#gridContenedorZonificacion").append(grid).append(pager);

    var nombres = ['ID', 'NOMBRE', 'ESTADO'];
    var columnas = [
        {name: "idZonificacion", width: 100, sortable: false, align: "center"},
        {name: "nombre", width: 300, sortable: false, hidden: false, align: "left"},
        {name: "estado", width: 100, sortable: false, hidden: true, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/zonificacion/listarZonificacion",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            nombre: $("#txtDescripZoniBusq").val().toUpperCase()
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionZonificacion",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Zonificaciones",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idZonificacion"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkVerProcedimiento').attr('onClick', 'verParametroDinamico("' + rowid + '")');
            $('#linkEditarZonificacion').attr('onClick', 'editarZonificacion("' + rowid + '")');
            $('#linkEliminarZonificacion').attr('onClick', 'eliminarZonificacion("' + rowid + '")');
            $('#linkZonificacionDetalle').attr('onClick', 'zonificacionDetalle("' + rowid + '")');
//            $('#linkAgregarActProcedimiento').attr('onClick', 'mostrarValorParametroDinamico("' + rowid + '","' + row.nombre + '")');
        },
        loadComplete: function(data) {
            $('#contextMenuZonificacion').parent().remove();
            $('#divContextMenuZonificacion').html("<ul id='contextMenuZonificacion'>"
                    + "<li> <a id='linkEditarZonificacion' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarZonificacion' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "<li> <a id='linkZonificacionDetalle' data-icon='ui-icon-search' title='Zonificacion Detalle'>Zonificacion Detalle</a></li>"
//                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
                    + "</ul>");
            $('#contextMenuZonificacion').puicontextmenu({
                target: $('#gridZonificacion')
            });
        }
    });
}
function editarZonificacion(rowid) {
    limpiaFrmMantZonificacion();
    
    var row = $('#gridZonificacion').jqGrid('getRowData', rowid);
    $("#dialogMantZonificacion").dialog("option", "title", "EDITAR ZONIFICACIÓN");
    $("#dialogMantZonificacion").dialog("open");
    $('#btnEditarZoni').show();
    $('#btnGuardarZoni').hide();
    
    $('#txtIdZonificacion').val(row.idZonificacion);
    $('#txtNombreZonificacion').val(row.nombre);
    $('#txtEstadoZonificacion').val(row.estado);
}
function zonificacionDetalle(rowid){
    var row = $('#gridZonificacion').jqGrid('getRowData', rowid);
    
}
function btnNuevoZoni() {
    limpiaFrmMantZonificacion();
    $("#dialogMantZonificacion").dialog("option", "title", "NUEVA ZONIFICACIÓN");
    $("#dialogMantZonificacion").dialog("open");
    //comboboxMaestroColumna('cmbAmbitoPara', baseURL + "pages/parametro/findAmbitoParametro");
    
//    $('#cmbTipoConsulta').change( function(){
//    	 //if ($('#cmbTipoConsulta').val()=='200'){ $('#divPreguntaPara').show();} else { $('#divPreguntaPara').hide();}
//         if ($('#cmbTipoConsulta :checked').html()=='PREGUNTA'){ $('#divPreguntaPara').show();} else { $('#divPreguntaPara').hide();}
//    });
    $("#txtNombreZonificacion").alphanum(alphaOptions);
}
function limpiaFrmMantZonificacion() {
    $('#frmMantZonificacion').find('input,select,textarea').not('#btnAgregarZoni').val("");
    $('#btnEditarZoni').hide();
    $('#btnGuardarZoni').show();
}
function btnGuardarZoni() {
//    $('#txtNombreZonificacion').val($('#txtNombreZonificacion').val().trim());
//    var validar = $('#frmMantZonificacion').validateAllForm("#divMensajeValidaZonificacion");
//    
//    if (validar) {
        confirm.open("¿Ud. est&aacute; seguro de guardar estos registros?", "procGuardarZoni()");
//    }
}
function procGuardarZoni() {
    var rows= jQuery("#gridZonificacionAgregar").jqGrid('getRowData');
    var error = "0";
    for(var i=0;i<rows.length;i++){
        var row=rows[i];
        $.ajax({
            url:baseURL + "pages/zonificacion/registrarZonificacion",
            type:'post',
            async:false,
            data: {
                nombreZonificacion:row['nombreZonificacion']
            },//$('#frmMantZonificacion').serialize(),
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                if(data.resultado=="0"){
//                    mensajeGrowl("success", "Se registró correctamente", "");
//                    procesarGridZonificacion();
//                    $("#dialogMantZonificacion").dialog("close");
//                    confirm.open("¿Desea configurar detalle para esta zonificación?", "configurarDetalle("+data.idZoni+")");
                }else{
                    error = "1";
                    mensajeGrowl("error", data.mensaje, "");
                }
            },
            error:errorAjax
        });
        $("#dialogMantZonificacion").dialog("close");
    }
    if(error === "0"){
        mensajeGrowl("success", "Se registró correctamente", "");
        procesarGridZonificacion();
        $("#dialogMantZonificacion").dialog("close");
    }else{
        mensajeGrowl("error", "Error al registrar", "");
    }
}
function configurarDetalle(idZoni){
    window.location.href = baseURL + 'pages/zonificacionDetalle?idZoni='+idZoni;
}
function btnEditarZoni() {
    $('#txtNombreZonificacion').val($('#txtNombreZonificacion').val().trim());
    var validar = $('#frmMantZonificacion').validateAllForm("#divMensajeValidaZonificacion");
    if (validar) {
        confirm.open("¿Ud. est&aacute; seguro de guardar los cambios en esta zonificación?", "procEditarZoni()");
    }
}
function procEditarZoni() {
    $.ajax({
        url:baseURL + "pages/zonificacion/editarZonificacion",
        type:'post',
        async:false,
        data:$('#frmMantZonificacion').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", "Se actualizó el registro correctamente", "");
                procesarGridZonificacion();
                $("#dialogMantZonificacion").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function eliminarZonificacion(rowid) {
    var row = $('#gridZonificacion').jqGrid('getRowData', rowid);
    confirm.open("¿Ud. est&aacute; seguro de eliminar la zonificación?", "procEliminarZoni('" + row.idZonificacion + "')");
}
function procEliminarZoni(id) {
    $.ajax({
        url:baseURL + "pages/zonificacion/eliminarZonificacion",
        type:'post',
        async:false,
        data:{
            idZonificacion:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", "Se eliminó el registro correctamente", "");
                procesarGridZonificacion();
                $("#dialogMantZonificacion").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function btnAgregarZoni(){
    var validar = $('#frmMantZonificacion').validateAllForm("#divMensajeValidaZonificacion");
    if(validar){
        var mydata = [{
                nombreZonificacion: $('#txtNombreZonificacion').val().toUpperCase()
        }];
        if(contadorZonificacion==0){
            procesarGridZonificacionAgregar();
        }
        if(jQuery("#gridZonificacionAgregar").length>0){
            jQuery("#gridZonificacionAgregar").jqGrid('addRowData',contadorZonificacion,mydata[0]); 
            contadorZonificacion++;
        }
        limpiaFrmMantZonificacion();
    }
}
function procesarGridZonificacionAgregar(){
    $("#gridContenedorZonificacionAgregar").html("");
    var grid = $("<table>", {
        "id": "gridZonificacionAgregar"
    });
    var pager = $("<div>", {
        "id": "paginacionZonificacionAgregar"
    });
    $("#gridContenedorZonificacionAgregar").append(grid).append(pager);

    var nombres = ['ZONIFICACIÓN'];
    var columnas = [
        {name: "nombreZonificacion", width: 100, sortable: false, hidden: false, align: "left"}
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
        pager: "#paginacionZonificacionAgregar",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Zonificaciones",
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
            $('#linkEliminarZonificacionAgregar').attr('onClick', 'eliminarZonificacionAgregar("' + rowid + '")');
//            $('#linkAgregarActProcedimiento').attr('onClick', 'mostrarValorParametroDinamico("' + rowid + '","' + row.nombre + '")');
        },
        loadComplete: function(data) {
            $('#contextMenuZonificacionAgregar').parent().remove();
            $('#divContextMenuZonificacionAgregar').html("<ul id='contextMenuZonificacionAgregar'>"
//                    + "<li> <a id='linkEditarZonificacionDetalle' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarZonificacionAgregar' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
                    + "</ul>");
            $('#contextMenuZonificacionAgregar').puicontextmenu({
                target: $('#gridZonificacionAgregar')
            });
        }
    });
}
function eliminarZonificacionAgregar(rowid) {
    $('#gridZonificacionAgregar').jqGrid('delRowData',rowid);
    contadorZonificacion--;
}