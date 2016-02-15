$(function() {
    procesarGridMaestroColumna(0);
    confirm.start();
    initInicioMaestroTabla();
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
function initInicioMaestroTabla() {
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    $('#btnBuscarMaesColu').click(function(){procesarGridMaestroColumna();});
    $('#btnNuevoMaesColu').click(function(){abrirMantMaestroColumna("new",'');});
    $('#btnLimpiarBuscarMaesColu').click(btnLimpiarBuscarMaesColu);
}
function btnLimpiarBuscarMaesColu(){
    $('#cmbDominioBusq').val("");
}
//NUEVO REQUISITO - INICIO
function abrirMantMaestroColumna(tipo,rowid){
    //validacion para NOEDITABLES
    var row = $('#gridMaestroColumna').jqGrid('getRowData', rowid);
    if(row.esEditable=='NO'){mensajeGrowl("warn", "El registro NO es editable", "");return false;}
    
    var title="CONSULTAR MAESTRO COLUMNA";
    if(tipo=='edit'){
        title="EDITAR MAESTRO COLUMNA";
    }else if(tipo=='new'){
        title="NUEVO MAESTRO COLUMNA";
    }    
    $.ajax({
        url:baseURL + "pages/maestroColumna/abrirMantMaestroColumna", 
        type:'get',
        async:false,
        data:{
            tipo:tipo,
            idMaestroColumna:rowid
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantMaestroColumna").html(data);
            $("#dialogMantMaestroColumna").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
            /* Observación */
            if(tipo=='new'){
            	$('#cmbDominioMant').val($('#cmbDominioBusq').val());
            }
            setAplicacionFromCmbDominio();
            procesarGridMaesColuMant(); 
            /* Observación */
        },
        error:errorAjax
    });
}
function procEditarMaestroColumna() {   
    $.ajax({
        url:baseURL + "pages/maestroColumna/editarMaestroColumna",
        type:'post',
        async:false,
        data:$('#frmMantMaestroColumna').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridMaestroColumna();
                limpiarMaesColu();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function procGuardarMaestroColumna() {   
    $.ajax({
        url:baseURL + "pages/maestroColumna/guardarMaestroColumna",
        type:'post',
        async:false,
        data:$('#frmMantMaestroColumna').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridMaestroColumna();
                limpiarMaesColu();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//ELIMINAR REQUISITO - INICIO
function eliminarMaestroColumna(rowid){
    //validacion para NOEDITABLES
    var row = $('#gridMaestroColumna').jqGrid('getRowData', rowid);
    if(row.esEditable=='NO'){mensajeGrowl("warn", "El registro NO es editable", "No puede ser Eliminado.");return false;}
    
    confirm.open("¿Ud. est&aacute; seguro de eliminar este registro?","procEliminarMaestroColumna('"+rowid+"',callbackEliminaMaestroColumna)");
}
function procEliminarMaestroColumna(id,callback){
    $.ajax({
        url:baseURL + "pages/maestroColumna/eliminarMaestroColumna",
        type:'post',
        async:false,
        data:{
            idMaestroColumna:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.delete, "");
                callback();
            } else {
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function callbackEliminaMaestroColumna(){
    procesarGridMaestroColumna();
}

function procesarGridMaestroColumna(flg_load) {
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorMaestroColumna").html("");
    var grid = $("<table>", {
        "id": "gridMaestroColumna"
    });
    var pager = $("<div>", {
        "id": "paginacionMaestroColumna"
    });
    $("#gridContenedorMaestroColumna").append(grid).append(pager);

    var nombres = ['ID','DOMINIO', 'CODIGO', 'DESCRIPCION', 'APLICACION','esEditable'];
    var columnas = [
        {name: "idMaestroColumna", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "dominio", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "codigo", width: 50, sortable: false, hidden: false, align: "left"},
        {name: "descripcion", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "aplicacion", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "esEditable", width: 200, sortable: false, hidden: true, align: "left"}       
    ];
    grid.jqGrid({
        url: baseURL + "pages/maestroColumna/findMaestroColumna",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            dominio:$('#cmbDominioBusq').val(),
            aplicacion:$('#cmbDominioBusq').find(':selected').parent().attr('label')
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionMaestroColumna",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Maestro Columna",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idMaestroColumna"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            $('#linkEditarMaestroColumna').attr('onClick', 'abrirMantMaestroColumna("edit","'+rowid+'")');
            $('#linkEliminarMaestroColumna').attr('onClick', 'eliminarMaestroColumna("'+rowid+'")');
            //$('#linkGestionarMaestroColumna').attr('onClick', 'gestionarMaestroColumna("' + rowid + '")');
            //$('#linkAgregarActProcedimiento').attr('onClick', 'mostrarValorParametroDinamico("' + rowid + '","' + row.nombre + '")');
        },
        loadComplete: function(data) {
            $('#contextMenuMaestroColumna').parent().remove();
            $('#divContextMenuMaestroColumna').html("<ul id='contextMenuMaestroColumna'>"
                    + "<li> <a id='linkEditarMaestroColumna' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarMaestroColumna' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                    + "<li> <a id='linkGestionarMaestroColumna' data-icon='ui-icon-bookmark' title='Gestionar Maestro Columna'>Gestionar Maestro Columna</a></li>"
//                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
                    + "</ul>");
            $('#contextMenuMaestroColumna').puicontextmenu({
                target: $('#gridMaestroColumna')
            });
        }
    });
}