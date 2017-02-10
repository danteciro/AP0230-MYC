$(function() {
    procesarGridAutoAyuda(0);
    initInicioAutoAyuda();
    $('#frmMantAutoAyuda').validarForm();
});
function initInicioAutoAyuda() {
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    confirm.start();
    $("#dialogMantAutoAyuda").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    $('#btnBuscarAutoAyuda').click(function() {
        procesarGridAutoAyuda();
    });
    $('#btnEditarAutoAyuda').click(btnEditarAutoAyuda);
    $('#btnLimpiarBuscarAutoAyuda').click(btnLimpiarBuscarAutoAyuda);
}
function btnLimpiarBuscarAutoAyuda(){
    $('#txtNombBusq,#txtIdentBusq').val("");
}
function btnNuevoAutoAyuda() {
    limpiaFrmMantAutoAyuda();
    $("#dialogMantAutoAyuda").dialog("option", "title", "NUEVO AUTOAYUDA");
    $("#dialogMantAutoAyuda").dialog("open");
}
function limpiaFrmMantAutoAyuda() {
    $('#frmMantAutoAyuda').find('input,select,textarea').not('#btnAgregarAutoAyuda').val("");
    $('#btnEditarAutoAyuda').hide();
    $('#btnGuardarAutoAyuda').show();
    
}
function procesarGridAutoAyuda(flg_load) {
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorAutoAyuda").html("");
    var grid = $("<table>", {
        "id": "gridAutoAyuda"
    });
    var pager = $("<div>", {
        "id": "paginacionAutoAyuda"
    });
    $("#gridContenedorAutoAyuda").append(grid).append(pager);

    var nombres = ['ID', 'NOMBRE', 'IDENTIFICADOR','ESTADO','DESCRIPCI&Oacute;N'];
    var columnas = [
        {name: "idAutoayuda", width: 10, sortable: false, hidden: true, align: "center"},
        {name: "nombreAutoayuda", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "identificadorAutoayuda", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "estado", width: 50, sortable: false, hidden: false, align: "left",formatter:"fmtEstadoAutoAyuda"},
        {name: "descripcionAutoayuda", width: 500, sortable: false, hidden: false, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/autoayuda/listarAutoAyuda",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            nombreAutoayuda: $("#txtNombBusq").val(),
            identificadorAutoayuda: $("#txtIdentBusq").val()
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionAutoAyuda",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de AutoAyuda",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idAutoayuda"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            $('#linkEditarAutoAyuda').attr('onClick', 'editarAutoAyuda("' + rowid + '")');
            
            if($('#divEnlaceTagEditarAutoAyuda input').html()!=null){
                $('#contextMenuAutoAyuda li a[value="MO-AUTOAYUDA"]').html($('#divEnlaceTagEditarAutoAyuda').html());
             } else {  
                $('#contextMenuAutoAyuda li a[value="MO-AUTOAYUDA"]').remove();
                $('#contextMenuAutoAyuda').parent().css('opacity',0);
             }
        },
        loadComplete: function(data) {
        	$('#contextMenuAutoAyuda').parent().css('opacity',1);
            $('#contextMenuAutoAyuda').parent().remove();
            $('#divContextMenuAutoAyuda').html("<ul id='contextMenuAutoAyuda'>"
                    + "<li> <a value='MO-AUTOAYUDA'>Editar</a></li>"
                    + "</ul>");
            $('#contextMenuAutoAyuda').puicontextmenu({
                target: $('#gridAutoAyuda')
            });
//        onRightClickRow: function(rowid, iRow, iCol, e) {
//            $('#linkEditarAutoAyuda').attr('onClick', 'editarAutoAyuda("' + rowid + '")');
//        },
//        loadComplete: function(data) {
//            $('#contextMenuAutoAyuda').parent().remove();
//            $('#divContextMenuAutoAyuda').html("<ul id='contextMenuAutoAyuda'>"
//                    + "<li> <a id='linkEditarAutoAyuda' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
//                    + "</ul>");
//            $('#contextMenuAutoAyuda').puicontextmenu({
//                target: $('#gridAutoAyuda')
//            });
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
}

function editarAutoAyuda(rowid) {
    limpiaFrmMantAutoAyuda();
    
    var row = $('#gridAutoAyuda').jqGrid('getRowData', rowid);
    $("#dialogMantAutoAyuda").dialog("option", "title", "EDITAR AUTOAYUDA");
    $("#dialogMantAutoAyuda").dialog("open");
    $('#btnEditarAutoAyuda').show();
    
    $('#txtIdAutoayuda').val(row.idAutoayuda);
    $('#txtNombre').val(row.nombreAutoayuda);
    $('#slctEstado').val(row.estado=='ACTIVO'?'1':'0');
    $('#txtIdentificador').val(row.identificadorAutoayuda);
    $('#txtDescripcionAutoayuda').val(row.descripcionAutoayuda);
}
function btnEditarAutoAyuda(){
    $('#txtNombre').val($('#txtNombre').val().trim());
    $('#txtDescripcionAutoayuda').val($('#txtDescripcionAutoayuda').val().trim());
    var validar = $('#frmMantAutoAyuda').validateAllForm("#divMensajeValidaAutoAyuda");
    if (validar) {
        confirm.open("¿Ud. est&aacute; seguro de guardar los cambios?", "procEditarAutoAyuda()");
    }
}
function procEditarAutoAyuda() {
    $.ajax({
        url:baseURL + "pages/autoayuda/editarAutoayuda",
        type:'post',
        async:false,
        data:{
            idAutoayuda:$('#txtIdAutoayuda').val(),
            nombreAutoayuda:$('#txtNombre').val(),
            identificadorAutoayuda:$('#txtIdentificador').val(),
            estado:$('#slctEstado').val(),
            descripcionAutoayuda:$('#txtDescripcionAutoayuda').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridAutoAyuda();
                $("#dialogMantAutoAyuda").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
jQuery.extend($.fn.fmatter, {
	fmtEstadoAutoAyuda: function(cellvalue, options, rowdata) {
        var sel = rowdata.estado==1?'ACTIVO':'INACTIVO';
        return sel;
    }
});