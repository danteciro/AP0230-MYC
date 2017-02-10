var contadorConcurso = 0;
$(function() {
    procesarGridConcurso(0);
    initInicioEtapa();
    $('#frmMantConcurso').validarForm();
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
    confirm.start();
    $("#dialogMantConcurso").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
//    $("#dialogMantTramite").dialog({
//        resizable: false,
//        autoOpen: false,
//        height: "auto",
//        width: "auto",
//        dialogClass: 'dialog',
//        modal: true
//    });

    $('#btnBuscarConcurso').click(function() {
        procesarGridConcurso();
    });
    $('#btnNuevoConcurso').click(btnNuevoConcurso);
    $('#btnGuardarConcurso').click(btnGuardarConcurso);
    $('#btnEditarConcurso').click(btnEditarConcurso);
    $('#btnAgregarConcurso').click(btnAgregarConcurso);
    $('#btnLimpiarBuscarConcurso').click(btnLimpiarBuscarConcurso);
}
function btnLimpiarBuscarConcurso(){
    $('#txtNroConcursoBusq').val("");
    $('#txtNombreConcursoBusq').val("");
    $('#txtDescripcionConcursoBusq').val("");
}
function btnNuevoConcurso() {
    limpiaFrmMantConcurso();
    $("#dialogMantConcurso").dialog("option", "title", "NUEVO CONCURSO");
    $("#dialogMantConcurso").dialog("open");
}
function limpiaFrmMantConcurso() {
    $('#frmMantConcurso').find('input,select,textarea').not('#btnAgregarConcurso').val("");
    $('#btnEditarConcurso').hide();
    $('#btnGuardarConcurso').hide();
    $('#btnAgregarConcurso').show();
    
}
function procesarGridConcurso(flg_load) {
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorConcurso").html("");
    var grid = $("<table>", {
        "id": "gridConcurso"
    });
    var pager = $("<div>", {
        "id": "paginacionConcurso"
    });
    $("#gridContenedorConcurso").append(grid).append(pager);

    var nombres = ['ID', 'NRO CONCURSO', 'NOMBRE', 'DESCRIPCI&Oacute;N'];
    var columnas = [
        {name: "idConcurso", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "numeroConcurso", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "nombreConcurso", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "descripcionConcurso", width: 100, sortable: false, hidden: false, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/concurso/listarConcurso",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idConcurso: "0",
            numeroConcurso: $("#txtNroConcursoBusq").val(),
            nombreConcurso: $("#txtNombreConcursoBusq").val(),
            descripcionConcurso: $("#txtDescripcionConcursoBusq").val()
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionConcurso",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Concursos",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idConcurso"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            $('#linkEditarConcurso').attr('onClick', 'editarConcurso("' + rowid + '")');
            $('#linkEliminarConcurso').attr('onClick', 'eliminarConcurso("' + rowid + '")');
            $('#linkDocumentosAdjuntos').attr('onClick', 'AbrirAdjuntarDocumentosConcurso("' + rowid + '")');
            
            if($('#divEnlaceTagEditarConcurso input').html()!=null){
                $('#contextMenuConcurso li a[value="MO-CONCURSO"]').html($('#divEnlaceTagEditarConcurso').html());
             } else {  
                $('#contextMenuConcurso li a[value="MO-CONCURSO"]').remove();
             }
            
            if($('#divEnlaceTagEliminarConcurso input').html()!=null){
                $('#contextMenuConcurso li a[value="EL-CONCURSO"]').html($('#divEnlaceTagEliminarConcurso').html());
             } else {  
                $('#contextMenuConcurso li a[value="EL-CONCURSO"]').remove();
             }
            
            if($('#divEnlaceTagDocAdjuntosConcurso input').html()!=null){
                $('#contextMenuConcurso li a[value="CO-CONCURSO"]').html($('#divEnlaceTagDocAdjuntosConcurso').html());
             } else {  
                $('#contextMenuConcurso li a[value="CO-CONCURSO"]').remove();
             }
        },
        loadComplete: function(data) {
            $('#contextMenuConcurso').parent().remove();
            $('#divContextMenuConcurso').html("<ul id='contextMenuConcurso'>"
                    + "<li> <a value='MO-CONCURSO'></a></li>"
                    + "<li> <a value='EL-CONCURSO'></a></li>"
                    + "<li> <a value='CO-CONCURSO'></a></li>"
                    + "</ul>");
            $('#contextMenuConcurso').puicontextmenu({
                target: $('#gridConcurso')
            });
//        onRightClickRow: function(rowid, iRow, iCol, e) {
//            $('#linkEditarConcurso').attr('onClick', 'editarConcurso("' + rowid + '")');
//            $('#linkEliminarConcurso').attr('onClick', 'eliminarConcurso("' + rowid + '")');
//            $('#linkDocumentosAdjuntos').attr('onClick', 'AbrirAdjuntarDocumentosConcurso("' + rowid + '")');
//        },
//        loadComplete: function(data) {
//            $('#contextMenuConcurso').parent().remove();
//            $('#divContextMenuConcurso').html("<ul id='contextMenuConcurso'>"
//                    + "<li> <a id='linkEditarConcurso' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
//                    + "<li> <a id='linkEliminarConcurso' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                    + "<li> <a id='linkDocumentosAdjuntos' data-icon='ui-icon-folder-collapsed' title='Documentos Adjuntos'>Documentos Adjuntos</a></li>"
//                    + "</ul>");
//            $('#contextMenuConcurso').puicontextmenu({
//                target: $('#gridConcurso')
//            });
        },
        loadError: function(jqXHR) {
            errorAjax(jqXHR);
        }
    });
}
function btnGuardarConcurso() {
//    $('#txtNombreZonificacion').val($('#txtNombreZonificacion').val().trim());
//    var validar = $('#frmMantZonificacion').validateAllForm("#divMensajeValidaZonificacion");
//    
//    if (validar) {
        confirm.open("¿Ud. est&aacute; seguro de guardar estos registros?", "procGuardarConcurso()");
//    }
}
function procGuardarConcurso() {
    var rows= jQuery("#gridConcursoAgregar").jqGrid('getRowData');
    var error = "0";
    for(var i=0;i<rows.length;i++){
        var row=rows[i];
        $.ajax({
            url:baseURL + "pages/concurso/registrarConcurso",
            type:'post',
            async:false,
            data: {
                numeroConcurso:row['nroConcurso'],
                nombreConcurso:row['nombreConcurso'],
                descripcionConcurso:row['descripcionConcurso']
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
        $("#dialogMantConcurso").dialog("close");
    }
    if(error === "0"){
        mensajeGrowl("success", "Se registró correctamente", "");
        procesarGridConcurso();
        $("#dialogMantConcurso").dialog("close");
    }else{
        mensajeGrowl("error", "Error al registrar", "");
    }
}
function editarConcurso(rowid) {
    limpiaFrmMantConcurso();
    
    var row = $('#gridConcurso').jqGrid('getRowData', rowid);
    $("#dialogMantConcurso").dialog("option", "title", "EDITAR CONCURSO");
    $("#dialogMantConcurso").dialog("open");
    $('#btnEditarConcurso').show();
    $('#btnGuardarConcurso').hide();
    $('#btnAgregarConcurso').hide();
    
    $('#txtIdConcurso').val(row.idConcurso);
    $('#txtNroConcurso').val(row.numeroConcurso);
    $('#txtNombreConcurso').val(row.nombreConcurso);
    $('#txtDescripcionConcurso').val(row.descripcionConcurso);
}
function btnEditarConcurso(){
    $('#txtNroConcurso').val($('#txtNroConcurso').val().trim());
    $('#txtNombreConcurso').val($('#txtNombreConcurso').val().trim());
    $('#txtDescripcionConcurso').val($('#txtDescripcionConcurso').val().trim());
    var validar = $('#frmMantConcurso').validateAllForm("#divMensajeValidaConcurso");
    if (validar) {
        confirm.open("¿Ud. est&aacute; seguro de guardar los cambios en este concurso?", "procEditarConcurso()");
    }
}
function procEditarConcurso() {
    $.ajax({
        url:baseURL + "pages/concurso/editarConcurso",
        type:'post',
        async:false,
        data:$('#frmMantConcurso').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridConcurso();
                $("#dialogMantConcurso").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function eliminarConcurso(rowid) {
    var row = $('#gridConcurso').jqGrid('getRowData', rowid);
    confirm.open("¿Ud. est&aacute; seguro de eliminar el concurso?", "procEliminarConcurso('" + row.idConcurso + "')");
}
function procEliminarConcurso(id) {
    $.ajax({
        url:baseURL + "pages/concurso/eliminarConcurso",
        type:'post',
        async:false,
        data:{
            idConcurso:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridConcurso();
                $("#dialogMantConcurso").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function btnAgregarConcurso(){
    var validar = $('#frmMantConcurso').validateAllForm("#divMensajeValidaConcurso");
    if(validar){
        $.ajax({
            url:baseURL + "pages/concurso/registrarConcurso",
            type:'post',
            async:false,
            data: {
                numeroConcurso:$('#txtNroConcurso').val().toUpperCase(),
                nombreConcurso:$('#txtNombreConcurso').val().toUpperCase(),
                descripcionConcurso:$('#txtDescripcionConcurso').val().toUpperCase()
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                if(data.resultado=="0"){
                    mensajeGrowl("success", global.confirm.save, "");
                    procesarGridConcurso();
                    //procesarGridConcursoAgregar();
                    $("#dialogMantConcurso").dialog("close");
                }else{
                    mensajeGrowl("error", data.mensaje, "");
                }
            },
            error:errorAjax
        });
        limpiaFrmMantConcurso();
    }
}
function procesarGridConcursoAgregar(flg_load){
    if (flg_load === undefined) {flg_load = 1;}
    
    $("#gridContenedorConcursoAgregar").html("");
    var grid = $("<table>", {
        "id": "gridConcursoAgregar"
    });
    var pager = $("<div>", {
        "id": "paginacionConcursoAgregar"
    });
    $("#gridContenedorConcursoAgregar").append(grid).append(pager);

    var nombres = ['ID', 'NRO CONCURSO', 'NOMBRE', 'DESCRIPCI&Oacute;N'];
    var columnas = [
        {name: "idConcurso", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "numeroConcurso", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "nombreConcurso", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "descripcionConcurso", width: 130, sortable: false, hidden: false, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/concurso/listarConcurso",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idConcurso: "0",
            numeroConcurso: "",
            nombreConcurso: "",
            descripcionConcurso: ""
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionConcursoAgregar",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Concursos",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idConcurso"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkEliminarConcursoAgregar').attr('onClick', 'eliminarConcursoAgregar("' + rowid + '")');
        },
        loadComplete: function(data) {
            $('#contextMenuConcursoAgregar').parent().remove();
            $('#divContextMenuConcursoAgregar').html("<ul id='contextMenuConcursoAgregar'>"
                    + "<li> <a id='linkEliminarConcursoAgregar' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuConcursoAgregar').puicontextmenu({
                target: $('#gridConcursoAgregar')
            });
        }
    });
}
function eliminarConcursoAgregar(rowid) {
    $('#gridConcursoAgregar').jqGrid('delRowData',rowid);
    contadorConcurso--;
}
function AbrirAdjuntarDocumentosConcurso(rowid){
    var row = $('#gridConcurso').jqGrid('getRowData', rowid);
    $.ajax({
        url:baseURL + "pages/concurso/abrirPopupArchivo", 
        type:'get',
        async:false,
        data:{
            idConcurso:rowid,
            numeroConcurso:row.numeroConcurso
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogArchivosConcurso").html(data);
            $("#dialogArchivosConcurso").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: "Documentos Adjuntos"
            });
        },
        error:errorAjax
    });
}