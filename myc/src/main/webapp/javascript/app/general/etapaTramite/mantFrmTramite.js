$(function() {
    procesarGridTramite();
    boton.closeDialog();
    anularEnter();
    initMantFrmTramite();
});
function initMantFrmTramite(){
    $('#btnAgregarTramite').click(btnAgregarTramite); 
}
//nuevo
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
            },
            beforeSend: muestraLoading,
            success: function(data) {
                ocultaLoading();
                if (data.resultado == "0") {
                    mensajeGrowl("success", global.confirm.save, "");
                    procesarGridTramite();
                    $('#cmbEtapa').trigger("change");
                } else {
                    mensajeGrowl("error", data.mensaje, "");
                }
            },
            error: errorAjax
        });
    }
}
//eliminar
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
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridTramite();
                $('#cmbEtapa').trigger("change");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function procesarGridTramite(flg_load){
    if (flg_load === undefined) {flg_load = 1;}
    
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
            $('#linkEliminarTramite').attr('onClick', 'getEliminarTramite("' + rowid + '")');
            $('#linkGestionarMotivo').attr('onClick', 'gestionarMotivoTramite("' + rowid + '")');
        },
        loadComplete: function(data) {
            $('#contextMenuTramite').parent().remove();
            $('#divContextMenuTramite').html("<ul id='contextMenuTramite'>"
                    + "<li> <a id='linkEliminarTramite' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuTramite').puicontextmenu({
                target: $('#gridTramite')
            });
        }
    });
}