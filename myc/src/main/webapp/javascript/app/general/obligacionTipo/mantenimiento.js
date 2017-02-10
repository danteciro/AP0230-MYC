//var contadorObligacionTipo = 0;
$(function() {
    initInicioObligacionTipo();
   // $('#frmMantObligacionTipo').validarForm();
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
function initInicioObligacionTipo() {
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    confirm.start();
  
    $('#btnBuscarObligacionTipo').click(function(){procesarGridObligacionTipo();});
    $('#btnNuevoObligacionTipo').click(function(){abrirMantObligacionTipo("new");});
   
    //$('#btnEditarObligacionTipo').click(btnEditarObligacionTipo);
    $('#btnLimpiarForm').click(btnLimpiarForm);
     
}
/*function btnGuardarObligacionTipo(){

	if ( $('#frmMantObligacionTipo').validateAllForm("#divMensajeValidaObligacionTipo") ) {
        confirm.open("¿Ud est&aacute; seguro de Guardar?","procGuardarObligaciontipo()");
    }
}
function procGuardarObligaciontipo(){
    
    $.ajax({
        url:baseURL + "pages/obligacionTipo/registrarObligacionTipo",
        type:'post',
        async:false,
        data:$('#frmMantObligacionTipo').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", "Se registró correctamente", "");
                procesarGridObligacionTipo();
                fill.combo(data.listadoObligacionTipo,'idObligacionTipo','nombre','#cmbObligacionTipoNuevo');
                $('#dialogMantObligacionTipo').dialog('close');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}*/

function btnEditarObligacionTipo(){
	if ( $('#frmMantObligacionTipo').validateAllForm("#divMensajeValidaObligacionTipo") ) {
        confirm.open("¿Ud est&aacute; seguro de Guardar?","procEditarObligacionTipo()");
    }
}
function procEditarObligacionTipo(){
       
    $.ajax({
        url:baseURL + "pages/obligacionTipo/editarObligacionTipo",
        type:'post',
        async:false,
        data:$('#frmMantObligacionTipo').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", "Se registró correctamente", "");
                procesarGridObligacionTipo();
                $('#dialogMantObligacionTipo').dialog('close');
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
function procesarGridObligacionTipo(flg_load) {
    if (flg_load === undefined) {
        flg_load = 1;
    }    

    $("#gridContenedorObligacionTipo").html("");
    var grid = $("<table>", {
        "id": "gridObligacionTipo"
    });
    var pager = $("<div>", {
        "id": "paginacionObligacionTipo"
    });
    $("#gridContenedorObligacionTipo").append(grid).append(pager);

    var nombres = ['ID',  'TIPO OBLIGACION'];
    var columnas = [
        {name: "idObligacionTipo", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "nombre", width: 100, sortable: false, hidden: false, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/obligacionTipo/findObligacionTipo",
        datatype: "local",
        datatype: "json",
        postData: {
        	flg_load:flg_load,
            nombre: $("#nombre").val()
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionObligacionTipo",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Tipo Obligacion",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idObligacionTipo"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkVerObligacionTipo').attr('onClick', 'abrirMantObligacionTipo("view","' + rowid + '")');
            $('#linkEditarObligacionTipo').attr('onClick', 'abrirMantObligacionTipo("edit","' + rowid + '")');
            $('#linkEliminarObligacionTipo').attr('onClick', 'eliminarObligacionTipo("' + rowid + '")');
        },
        loadComplete: function(data) {

            $('#contextMenuObligacionTipo').parent().remove();
            $('#divContextMenuObligacionTipo').html("<ul id='contextMenuObligacionTipo'>"
            		+ "<li> <a id='linkVerObligacionTipo' data-icon='ui-icon-search' title='Ver Detalle'>Consultar</a> </li>"
            		+ "<li> <a id='linkEditarObligacionTipo' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarObligacionTipo' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuObligacionTipo').puicontextmenu({
                target: $('#gridObligacionTipo')
            });
        }
    });
}


function abrirMantObligacionTipo(tipo,rowid){

    var title="CONSULTAR TIPO OBLIGACION";
    if(tipo=='edit'){
        title="EDITAR TIPO OBLIGACION";
    }else if(tipo=='new'){
        title="NUEVO TIPO OBLIGACION";
    }
    
    var row = $('#gridObligacionTipo').jqGrid('getRowData', rowid);
    $.ajax({
        url:baseURL + "pages/obligacionTipo/abrirMantObligacionTipo", 
        type:'get',
        async:false,
        data:{
            tipo:tipo,
            idObligacionTipo:rowid,
            nombre:row.nombre
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantObligacionTipo").html(data);
            $("#dialogMantObligacionTipo").dialog({
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
                $('#frmMantObligacionTipo').find('input,select,textarea').attr('disabled',true);
                $('#txtNombreObTipo').val(row.nombre);
            }
            if(tipo=="edit"){
            	   $('#txtIdObligacionTipo').val(rowid);
            	   $('#txtNombreObTipo').val(row.nombre);
            }
        },
        error:errorAjax
    });
}

function eliminarObligacionTipo(rowid){
    confirm.open("¿Ud est&aacute; seguro de eliminar?","procEliminarObligacionTipo('"+rowid+"')");
}

function procEliminarObligacionTipo(rowid) {
    
    $.ajax({
        url:baseURL + "pages/obligacionTipo/eliminarObligacionTipo",
        type:'post',
        async:false,
        data:{idObligacionTipo:rowid},
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", "Se eliminó correctamente", "");
                procesarGridObligacionTipo();
              //  $('#dialogMantObligacionTipo').dialog('close');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

