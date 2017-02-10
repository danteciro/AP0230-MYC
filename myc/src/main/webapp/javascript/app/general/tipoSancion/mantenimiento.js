//var contadorTipoSancion = 0;
$(function() {
    initInicioTipoSancion();
   // $('#frmMantTipoSancion').validarForm();
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
function initInicioTipoSancion() {
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    confirm.start();
  
    $('#btnBuscarTipoSancion').click(function(){procesarGridTipoSancion();});
    $('#btnNuevoTipoSancion').click(function(){abrirMantTipoSancion("new");});
   
    //$('#btnEditarTipoSancion').click(btnEditarTipoSancion);
    $('#btnLimpiarForm').click(btnLimpiarForm);
     
}
/*function btnGuardarTipoSancion(){

	if ( $('#frmMantTipoSancion').validateAllForm("#divMensajeValidaTipoSancion") ) {
        confirm.open("¿Ud est&aacute; seguro de Guardar?","procGuardarTipoSancion()");
    }
}
function procGuardarTipoSancion(){
    
    $.ajax({
        url:baseURL + "pages/TipoSancion/registrarTipoSancion",
        type:'post',
        async:false,
        data:$('#frmMantTipoSancion').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", "Se registró correctamente", "");
                procesarGridTipoSancion();
                fill.combo(data.listadoTipoSancion,'idTipoSancion','nombre','#cmbTipoSancionNuevo');
                $('#dialogMantTipoSancion').dialog('close');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}*/

function btnEditarTipoSancion(){
	if ( $('#frmMantTipoSancion').validateAllForm("#divMensajeValidaTipoSancion") ) {
        confirm.open("¿Ud est&aacute; seguro de Guardar?","procEditarTipoSancion()");
    }
}
function procEditarTipoSancion(){
       
    $.ajax({
        url:baseURL + "pages/TipoSancion/editarTipoSancion",
        type:'post',
        async:false,
        data:$('#frmMantTipoSancion').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", "Se registró correctamente", "");
                procesarGridTipoSancion();
                $('#dialogMantTipoSancion').dialog('close');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}


function btnLimpiarForm(){
    $('#formBusqueda').find('input, select').val('');
 
}
function procesarGridTipoSancion(flg_load) {
    if (flg_load === undefined) {
        flg_load = 1;
    }    

    $("#gridContenedorTipoSancion").html("");
    var grid = $("<table>", {
        "id": "gridTipoSancion"
    });
    var pager = $("<div>", {
        "id": "paginacionTipoSancion"
    });
    $("#gridContenedorTipoSancion").append(grid).append(pager);

    var nombres = ['ID',  'TIPO SANCION'];
    var columnas = [
        {name: "idTipoSancion", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "nombre", width: 100, sortable: false, hidden: false, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/TipoSancion/findTipoSancion",
        datatype: "local",
        datatype: "json",
        postData: {
        	flg_load:flg_load,
            nombre: $("#nombre").val()
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionTipoSancion",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Tipo Sancion",
        autowidth: true,
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
            $('#linkVerTipoSancion').attr('onClick', 'abrirMantTipoSancion("view","' + rowid + '")');
            $('#linkEditarTipoSancion').attr('onClick', 'abrirMantTipoSancion("edit","' + rowid + '")');
            $('#linkEliminarTipoSancion').attr('onClick', 'eliminarTipoSancion("' + rowid + '")');
        },
        loadComplete: function(data) {

            $('#contextMenuTipoSancion').parent().remove();
            $('#divContextMenuTipoSancion').html("<ul id='contextMenuTipoSancion'>"
            		+ "<li> <a id='linkVerTipoSancion' data-icon='ui-icon-search' title='Ver Detalle'>Consultar</a> </li>"
            		+ "<li> <a id='linkEditarTipoSancion' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarTipoSancion' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuTipoSancion').puicontextmenu({
                target: $('#gridTipoSancion')
            });
        }
    });
}


function abrirMantTipoSancion(tipo,rowid){

    var title="CONSULTAR TIPO SANCION";
    if(tipo=='edit'){
        title="EDITAR TIPO SANCION";
    }else if(tipo=='new'){
        title="NUEVO TIPO SANCION";
    }
    
    var row = $('#gridTipoSancion').jqGrid('getRowData', rowid);
    $.ajax({
        url:baseURL + "pages/TipoSancion/abrirMantTipoSancion", 
        type:'get',
        async:false,
        data:{
            tipo:tipo,
            idTipoSancion:rowid,
            nombre:row.nombre
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantTipoSancion").html(data);
            $("#dialogMantTipoSancion").dialog({
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
                $('#frmMantTipoSancion').find('input,select,textarea').attr('disabled',true);
                $('#txtNombre').val(row.nombre);
            }
            if(tipo=="edit"){
            	   $('#txtIdTipoSancion').val(rowid);
            	   $('#txtNombre').val(row.nombre);
            }
        },
        error:errorAjax
    });
}

function eliminarTipoSancion(rowid){
    confirm.open("¿Ud est&aacute; seguro de eliminar?","procEliminarTipoSancion('"+rowid+"')");
}

function procEliminarTipoSancion(rowid) {
    
    $.ajax({
        url:baseURL + "pages/TipoSancion/eliminarTipoSancion",
        type:'post',
        async:false,
        data:{idTipoSancion:rowid},
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", "Se eliminó correctamente", "");
                procesarGridTipoSancion();
              //  $('#dialogMantTipoSancion').dialog('close');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

