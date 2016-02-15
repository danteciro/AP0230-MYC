$(function() {
    $('#btnEditarDocConcurso').hide();
    anularEnter();
    boton.closeDialog();
    
    $("#txtArchivoDocConcurso").change(function() {
        $("#txtFileNameDocConcurso").val(quitaSlashDir($("#txtArchivoDocConcurso").val()));
    });
    procesarGridDocConcurso();
    $('#btnGuardarDocConcurso').click(btnGuardarDocConcurso);
    $('#btnEditarDocConcurso').click(btnEditarDocConcurso);
    $('#btnLimpiarDocConcurso').click(limpiarCamposDocConcurso);
    $('#txtFechaDocConcurso').datepicker({dateFormat: "dd/mm/yy",changeMonth: true,changeYear: true,maxDate: 0});
});
//NUEVO
function btnGuardarDocConcurso(){
    var validarDoc = $('#frmArchivoDocConcurso').validateAllForm("#divMensajeValidacionDocConcurso");
    var validar = $('#frmDocConcurso').validateAllForm("#divMensajeValidacionDocConcurso");
    if($('#txtArchivoDocConcurso').val()!='' && validar && validarDoc){
    	$("#frmArchivoDocConcurso").submit();	
    }
};
$("#frmArchivoDocConcurso").ajaxForm({
    dataType: 'json',
    resetForm: true,
    success: function(data) {
        var mensaje="";
        if (data != null && data.error != null) {
            if (data.error) {
                mensaje = data.mensaje;
            }
            enviarDatosDocConcurso(data.error, mensaje);
        }
    }
});
function enviarDatosDocConcurso(resultado, mensaje) {
    if (!resultado) {
        confirm.open("¿Ud est&aacute; seguro de Guardar el registro?","procGuardarDocConcurso()");
    } else {
        mensajeGrowl("error", "Error", mensaje);
    }
}
function procGuardarDocConcurso(){
    $.ajax({
        url:baseURL + "pages/documentoAdjunto/registrarDocumento",
        type:'post',
        async:false,
        data:{
            idConcurso:$('#idConcursoDocConcurso').val(),
            fechaDocumento:$('#txtFechaDocConcurso').val(),
            comentario:$('#txtComentarioDocConcurso').val(),
            titulo:$('#txtTituloDocConcurso').val(),
            'tipoDocumentoCarga.idMaestroColumna':$('#cmbTipoDocumentoDocConcurso').val(),
            aplicacionSpace:'GENERALES'
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if (data.resultado == 0) {
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridDocConcurso();
                limpiarCamposDocConcurso();
            }else{
                mensajeGrowl('error', "Error al insertar Documento", "Intente de nuevo");
            }
        },
        error:errorAjax
    });
}
//EDITAR
function editarDocConcurso(rowid) {
    var row = $('#gridDocConcurso').jqGrid('getRowData', rowid);
    $("#hddIdDocumentoAdjuntoDocConcurso").val(rowid);
    $("#txtFileNameDocConcurso").val(reverseFormatoLink(row.nombreArchivo));
    $("#cmbTipoDocumentoDocConcurso").val(row['tipoDocumentoCarga.idMaestroColumna']);
    $("#txtFechaDocConcurso").val(row.fechaDocumento);
    $("#txtTituloDocConcurso").val(row.titulo);
    $("#txtComentarioDocConcurso").val(row.comentario);
    
    $("#txtArchivoDocConcurso").hide();
    
    $("#btnGuardarDocConcurso").hide();
    $("#btnEditarDocConcurso").show();
}
function btnEditarDocConcurso(){
    var validar = $('#frmDocConcurso').validateAllForm("#divMensajeValidacionDocConcurso");
    if(validar){
    	confirm.open("¿Ud est&aacute; seguro de Guardar los cambios?","procEditarDocConcurso()");
    }
};
function procEditarDocConcurso(){
    $.ajax({
        url:baseURL + "pages/documentoAdjunto/editarDocumento",
        type:'post',
        async:false,
        data:{
            idDocumentoAdjunto:$('#hddIdDocumentoAdjuntoDocConcurso').val(),
            idConcurso:$('#idConcursoDocConcurso').val(),
            fechaDocumento:$('#txtFechaDocConcurso').val(),
            comentario:$('#txtComentarioDocConcurso').val(),
            titulo:$('#txtTituloDocConcurso').val(),
            'tipoDocumentoCarga.idMaestroColumna':$('#cmbTipoDocumentoDocConcurso').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if (data.resultado == 0) {
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridDocConcurso();
                limpiarCamposDocConcurso();
            }else{
                mensajeGrowl('error', "Error al editar Documento", 'Intente de nuevo');
            }
        },
        error:errorAjax
    });
}
//ELIMINAR
function eliminarDocConcurso(rowid){
    confirm.open("¿Ud. est&aacute; seguro de eliminar este requisito?","procEliminarDocConcurso('"+rowid+"')");
};
function procEliminarDocConcurso(id){
    $.ajax({
        url:baseURL + "pages/documentoAdjunto/eliminarDocumento",
        type:'post',
        async:false,
        data:{
            idDocumentoAdjunto:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado==0){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridDocConcurso();
            }else {
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//CONSULTAR
function consultarDocConcurso(rowid){
    editarDocConcurso(rowid);
    $('#btnEditarDocConcurso').hide();
    $('#frmArchivoDocConcurso,#frmDocConcurso').find('input, select, textarea').attr("disabled",true);
}

function limpiarCamposDocConcurso() {
    $('#frmArchivoDocConcurso,#frmDocConcurso').find('input, select, textarea').val("");
    $('#frmArchivoDocConcurso,#frmDocConcurso').find('input, select, textarea').removeAttr("disabled");
    $("#txtArchivoDocConcurso").show();

    $("#btnEditarDocConcurso").hide();
    $("#btnGuardarDocConcurso").show();
}

function procesarGridDocConcurso() {
    $("#gridContenedorDocConcurso").html("");
    var grid = $("<table>", {
        "id": "gridDocConcurso"
    });
    var pager = $("<div>", {
        "id": "paginacionDocConcurso"
    });
    $("#gridContenedorDocConcurso").append(grid).append(pager);
    var nombres = ['nombreArchivo','Archivo', 'Título', 'idTipoDocumento', 'Tipo Documento', 'Fecha Documento', 'Fecha registro', 'Comentario'];

    var columnas = [
        {name: "nombreArchivo", width: 150, align: "center", sortable: false, hidden:true},
        {name: "rutaAlfresco",width: 70,align: "center",formatter: "descargarDocConcurso"},
        {name: "titulo", width: 300, sortable: false, align: "left"},
        {name: "tipoDocumentoCarga.idMaestroColumna", width: 30, sortable: false, align: "center", hidden: true},
        {name: "tipoDocumentoCarga.descripcion", width: 150, sortable: false, align: "center"},
        {name: "fechaDocumento", width: 120, sortable: false, align: "center", formatter: fecha},
        {name: "fechaCarga", width: 100, sortable: false, align: "center", formatter: fecha},
        {name: "comentario", width: 30, sortable: false, align: "center", hidden: true}
    ];
    grid.jqGrid({
        url: baseURL + "pages/documentoAdjunto/findByFiltro",
        datatype: "json",
        postData: {
            idConcurso: $("#idConcursoDocConcurso").val()
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionDocConcurso",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Archivos",
        jsonReader: {
            root: "filas", 
            page: "pagina", 
            total: "total", 
            records: "registros", 
            repeatitems: false,
            id: "idDocumentoAdjunto"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
             var row = grid.jqGrid('getRowData', rowid);
            $('#linkEditarDocConcurso').attr('onClick','editarDocConcurso("'+rowid+'")');
            $('#linkEliminarDocConcurso').attr('onClick','eliminarDocConcurso("'+rowid+'")');
            $('#linkConsultarDocConcurso').attr('onClick','consultarDocConcurso("'+rowid+'")');
        },
        loadComplete: function(data) {
            $('#contextMenuDocConcurso').parent().remove();
            var html="<ul id='contextMenuDocConcurso'>";
                html+="<li> <a id='linkEliminarDocConcurso' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "<li> <a id='linkEditarDocConcurso' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>";
                html+="<li> <a id='linkConsultarDocConcurso' data-icon='ui-icon-search' title='Consultar'>Consultar</a> </li>";
            html+="</ul>";
            $('#divContextMenuDocConcurso').html(html);
            $('#contextMenuDocConcurso').puicontextmenu({
                target: $('#gridDocConcurso')
            });
        }
    });
}
jQuery.extend($.fn.fmatter, {
	descargarDocConcurso: function(cellvalue, options, rowdata) {
        var nombre=rowdata.nombreArchivo;
        var rutaAlfresh=rowdata.rutaAlfresco;
        var sel = '';
        if (nombre != null && nombre != '' && nombre != undefined && rutaAlfresh!='' && rutaAlfresh!=null){       
          $("#txtNombreArchivo").val(nombre);
          sel = '<a class="link" href="'+baseURL + 'pages/documentoAdjunto/descargaArchivoAlfresco?aplicacionSpace=GENERALES&nombreArchivo='+nombre+'&rutaAlfresco='+rutaAlfresh+'">'+
            '<img class="vam" width="17" height="18" src="'+baseURL+'images/stickers.png">'+
            '</a>';
        }
        return sel;
    }
});
