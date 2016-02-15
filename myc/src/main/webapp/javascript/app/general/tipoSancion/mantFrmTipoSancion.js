var contadorTipoSancion = 0;

$(function(){
    anularEnter();
    $('#btnBuscarTipoSanc').click(function(){procesarGridTipoSanc();});  
    $('#btnGuardarTipoSanc').click(btnGuardarTipoSanc);  
    $('#btnEditarTipoSanc').click(btnEditarTipoSanc);  
    $('#btnCancelarTipoSanc').click(limpiaFrmMantTipoSanc);
    
//    $('#btnEditarObliTipo').click(btnEditarTipoSancion);
   boton.closeDialog();
   procesarGridTipoSanc(0);
});

function btnGuardarTipoSanc(){
    if ( $('#frmMantTipoSancion').validateAllForm("#divMensajeValidaTipoSancion") ) {
        confirm.open("¿Ud est&aacute; seguro de Guardar?","procGuardarTipoSancion()");
    }
}
function procGuardarTipoSancion(){
    $.ajax({
        url:baseURL + "pages/tipoSancion/registrarTipoSancion",
        type:'post',
        async:false,
        data:$('#frmMantTipoSancion').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.save, "");
                limpiaFrmMantTipoSanc();
                procesarGridTipoSanc();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function editarTipoSanc(rowid){
    var row = $('#gridTipoSanc').jqGrid('getRowData', rowid);
    $('#txtIdTipoSancion').val(rowid);
    $('#txtDescTipoSanc').val(row.descripcion);
    $('#btnBuscarTipoSanc,#btnGuardarTipoSanc').hide();
    $('#btnCancelarTipoSanc,#btnEditarTipoSanc').show();
}
function btnEditarTipoSanc(){
    if ( $('#frmMantTipoSancion').validateAllForm("#divMensajeValidaTipoSancion") ) {
        confirm.open("¿Ud est&aacute; seguro de Guardar los cambios?","procEditarTipoSancion()");
    }
}
function procEditarTipoSancion(){
    $.ajax({
        url:baseURL + "pages/tipoSancion/editarTipoSancion",
        type:'post',
        async:false,
        data:$('#frmMantTipoSancion').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.edit, "");
                limpiaFrmMantTipoSanc();
                procesarGridTipoSanc();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function eliminarTipoSanc(rowid) {
    confirm.open("¿Ud. est&aacute; seguro de eliminar la etapa?", "procEliminarTipoSanc('"+rowid+"')");
}
function procEliminarTipoSanc(id) {
    $.ajax({
        url:baseURL + "pages/tipoSancion/eliminarTipoSancion",
        type:'post',
        async:false,
        data:{
            idTipoSancion:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.delete, "");
                limpiaFrmMantTipoSanc();
                procesarGridTipoSanc();                
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function limpiaFrmMantTipoSanc() {
    $('#frmMantTipoSancion').find('input,select,textarea').val("");
    $('#btnBuscarTipoSanc,#btnGuardarTipoSanc').show();
    $('#btnCancelarTipoSanc,#btnEditarTipoSanc').hide();
}
function procesarGridTipoSanc(flg_load){
    if(flg_load==undefined){flg_load=1;}
    $("#gridContenedorTipoSanc").html("");
    var grid = $("<table>", {
        "id": "gridTipoSanc"
    });
    var pager = $("<div>", {
        "id": "paginacionTipoSanc"
    });
    $("#gridContenedorTipoSanc").append(grid).append(pager);

    var nombres = ['idTipoSancion', 'DESCRIPCIÓN'];
    var columnas = [
        {name: "idTipoSancion", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "descripcion", width: 500, sortable: false, hidden: false, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/tipoSancion/findTipoSancion",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            descripcion: $("#txtDescTipoSanc").val()
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionTipoSanc",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Sanción Administrativa",
        //autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idTipoSancion"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkEliminarTipoSanc').attr('onClick', 'eliminarTipoSanc("'+rowid+'")');
            $('#linkEditarTipoSanc').attr('onClick', 'editarTipoSanc("'+rowid+'")');
        },
        loadComplete: function(data) {
            $('#contextMenuTipoSanc').parent().remove();
            $('#divContextMenuTipoSanc').html("<ul id='contextMenuTipoSanc'>"
                    + "<li> <a id='linkEditarTipoSanc' data-icon='ui-icon-pencil' title='Eliminar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarTipoSanc' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuTipoSanc').puicontextmenu({
                target: $('#gridTipoSanc')
            });
        }
    });
}