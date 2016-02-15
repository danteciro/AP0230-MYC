$(function(){
    anularEnter();
    boton.closeDialog();
    initMantMaesTab();
    procesarGridMaesTabMant(0);
    $('#btnBuscarMaesTabMant').click(function(){
    	procesarGridMaesTabMant();
    });
});
function initMantMaesTab(){
    $('#cmbDominioMaesTabMant').change(function(){
        setAplicMaesTabFromCmbDominioMaesTab();
    });
    $('#btnGuardarMaesTabMant').click(btnGuardarMaesTabMant);
    $('#btnEditarMaesTabMant').click(btnEditarMaesTabMant);
    $('#btnCancelarMaesTabMant').click(limpiarMaesTabMant);
    
    anularEspaciadora('#txtDominioMaesTabMant');
    
}
function btnGuardarMaesTabMant(){
    var validar = $('#frmMantMaestroTabla').validateAllForm("#divMensajeValidaMaestroTabla");
    if(validar){
        confirm.open("¿Ud. est&aacute; seguro de guardar el registro?","procGuardarMaestroTabla()");
    }
};
function btnEditarMaesTabMant(){
    var validar = $('#frmMantMaestroTabla').validateAllForm("#divMensajeValidaMaestroTabla");
    if(validar){
        confirm.open("¿Ud. est&aacute; seguro de guardar los cambios?","procEditarMaestroTabla()");
    }
};
function procGuardarMaestroTabla() {   
    $.ajax({
        url:baseURL + "pages/maestroTabla/guardarMaestroTabla",
        type:'post',
        async:false,
        data:$('#frmMantMaestroTabla').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                limpiarMaesTabMant();
                llenaDominioOptGroup(data.listadoAplicaciones,data.listadoDominios,'#cmbDominioMant,#cmbDominioBusq');
                procesarGridMaesTabMant();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function procEditarMaestroTabla() {   
    $('#txtDominioMaesTabMant').removeAttr('disabled');
    $.ajax({
        url:baseURL + "pages/maestroTabla/editarMaestroTabla",
        type:'post',
        async:false,
        data:$('#frmMantMaestroTabla').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.edit, "");
                limpiarMaesTabMant();
                llenaDominioOptGroup(data.listadoAplicaciones,data.listadoDominios);
                procesarGridMaesTabMant();
            }else{
                $('#txtDominioMaesTabMant').removeAttr('disabled',true);
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function procesarGridMaesTabMant(flg_load) {
    if(flg_load===undefined){flg_load=1;}
    $("#gridContenedorMaesTabMant").html("");
    var grid = $("<table>", {
        "id": "gridMaesTabMant"
    });
    var pager = $("<div>", {
        "id": "paginacionMaesTabMant"
    });
    $("#gridContenedorMaesTabMant").append(grid).append(pager);

    var nombres = ['ID','APLICACION','DOMINIO', 'DESCRIPCION','esEditable' ];
    var columnas = [
        {name: "idMaestroTabla", width: 50, sortable: false, hidden: true, align: "center"},
        {name: "aplicacion", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "dominio", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "descripcion", width: 300, sortable: false, hidden: false, align: "left"},
        {name: "esEditable", width: 200, sortable: false, hidden: true, align: "left"}       
    ];
    grid.jqGrid({
        url: baseURL + "pages/maestroTabla/findMaestroTabla",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            dominio:$('#txtDominioMaesTabMant').val(),
            descripcion:$('#txtDescripMaesTabMant').val()
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionMaesTabMant",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Maestro Tabla",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "apliDomi"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            $('#linkEditarMaesTabMant').attr('onClick', 'editarMaesTabMant("edit","'+rowid+'")');
            $('#linkSeleccionarMaesTabMant').attr('onClick', 'seleccionarMaesTabMant("'+rowid+'")');
            //$('#linkEliminarMaesTabMant').attr('onClick', 'eliminarMaesTabMant("'+rowid+'")');
        },
        loadComplete: function(data) {
            $('#contextMenuMaesTabMant').parent().remove();
            $('#divContextMenuMaesTabMant').html("<ul id='contextMenuMaesTabMant'>"
                    + "<li> <a id='linkEditarMaesTabMant' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkSeleccionarMaesTabMant' data-icon='ui-icon-check' title='Editar'>Seleccionar</a></li>"
                    //+ "<li> <a id='linkEliminarMaesTabMant' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuMaesTabMant').puicontextmenu({
                target: $('#gridMaesTabMant')
            });
        }
    });
}
function setAplicMaesTabFromCmbDominioMaesTab(){
    $('#cmbAplicacionMaesTabMant').val($('#cmbDominioMaesTabMant').find(':selected').parent().attr('label'));
}
function editarMaesTabMant(tipo,rowid){
    var row = $('#gridMaesTabMant').jqGrid('getRowData', rowid);
    if(row.esEditable=='SI'){
        $('#txtAplicacionMaesTabMant').val(row.aplicacion);
        $('#txtEsEditableMaesTabMant').val(row.esEditable);
        $('#txtDominioMaesTabMant').val(row.dominio);
        $('#txtDescripMaesTabMant').val(row.descripcion);
        $('#txtDominioMaesTabMant').attr('disabled',true);

        $('#btnBuscarMaesTabMant,#btnGuardarMaesTabMant').hide();
        $('#btnCancelarMaesTabMant,#btnEditarMaesTabMant').show();
    }else{
        mensajeGrowl("warn", "El registro NO es editable", "");
    }
}
function limpiarMaesTabMant(){
    $('#frmMantMaestroTabla').find('input,textarea').not('#btnBuscarMaesTabMant,#btnGuardarMaesTabMant,#btnCancelarMaesTabMant,#btnEditarMaesTabMant').val("")
    $('#txtDominioMaesTabMant').removeAttr('disabled');
    
    $('#txtAplicacionMaesTabMant').val("USU");
    $('#txtEsEditableMaesTabMant').val("SI");
    
    $('#btnBuscarMaesTabMant,#btnGuardarMaesTabMant').show();
    $('#btnCancelarMaesTabMant,#btnEditarMaesTabMant').hide();
}
function seleccionarMaesTabMant(rowid){
    var row = $('#gridMaesTabMant').jqGrid('getRowData', rowid);
    $('#cmbDominioMant').val(row.dominio);
    $('#dialogMantMaestroTabla').dialog('close');
}
