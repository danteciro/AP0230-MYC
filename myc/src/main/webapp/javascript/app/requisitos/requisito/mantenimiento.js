$(function() {
    procesarGridRequisito(0);
    initInicioRequisito();  
});
var i = 0;
var alphaOptions = {
		allowNumeric  : true,
		allowLatin    : true,
		allowUpper    : true,
		allowLower    : true,
		allowCaseless : true,
		allowOtherCharSets : false,
		allowSpace    : true,
		allow		  : 'Ññóáéíóú'
			
	 };



function initInicioRequisito(){
    
	$('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoRequisitos';
    });
    confirm.start();
    $('#btnBuscarRequ').click(function(){procesarGridRequisito();});
    $('#btnNuevoRequ').click(function(){abrirMantRequisito("new",'');});   
    $('#btnLimpiarForm').click(btnLimpiarForm);
        
    $('#txtDescripRequ').on({
        keyup: function(e) {
            busqSensitivaRequisitos($(this).val(),procesarGridRequisito);    
        }
    });
}


function btnLimpiarForm(){
    $('#formBusqueda').find('input, select').val('');
 
}

function busqSensitivaRequisitos(txt,callback){
    var pal=txt.split(" ");
    if($.trim(txt)!="" && pal[1]!=undefined){
        callback();
    }
}

//NUEVO REQUISITO - INICIO
function abrirMantRequisito(tipo,rowid){
    var title="CONSULTAR REQUISITO";
    if(tipo=='edit'){
        title="EDITAR REQUISITO";
    }else if(tipo=='new'){
        title="NUEVO REQUISITO";
    }    
    $.ajax({
        url:baseURL + "pages/requisito/abrirMantRequisito", 
        type:'get',
        async:false,
        data:{
            tipo:tipo,
            idRequisito:rowid
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantRequisito").html(data);
            $("#dialogMantRequisito").dialog({
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
        },
        error:errorAjax
    });
    
    //$("#txtDescRequ").alphanum(alphaOptions);
    inputFile();
}
function procGuardarRequ(){
    $('#txtFileNameArchivoRequisito').removeAttr('disabled');//TODO para enviar en serialize
    $.ajax({
        url:baseURL + "pages/requisito/registrarRequisito",
        type:'post',
        async:false,
        data:{idRequisito:$('#txtIdRequisito').val(),descripcion:$('#txtDescRequ').val(),comentarioPredeterminado:$('#txtComentarioRequ').val()},
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridRequisito();
                $("#dialogMantRequisito").dialog("close");
            }else if(data.resultado=="ERROR"){
                mensajeGrowl("error", data.mensaje, "Intente de nuevo");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
    $('#txtFileNameArchivoRequisito').attr('disabled','disabled');//TODO para enviar en serialize
}
//NUEVO REQUISITO - FIN
//EDITAR REQUISITO - INICIO

function validarDependRequ(){
    var val=0;
	$('#txtFileNameArchivoRequisito').removeAttr('disabled');//TODO para enviar en serialize
    $.ajax({
        url:baseURL + "pages/requisito/validarRequisito",
        type:'post',
        async:false,
        data:{idRequisito:$('#txtIdRequisito').val(),descripcion:$('#txtDescRequ').val(),comentarioPredeterminado:$('#txtComentarioRequ').val()},
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="DEPENDENCE"){
            	confirm.open("Este requisito tiene dependencias, los cambios realizados se aplicarán al requisito ¿Confirmar si desea realizar los cambios?","procEditarRequ()");
            	return val=1;
            } else {
            	confirm.open("¿Ud. est&aacute; seguro de guardar los cambios en este requisito?","procEditarRequ()");
            	return val=0;
            }
            
        },
        error:errorAjax
    });
    
    return val;
}

function procEditarRequ(){
    //$('#txtFileNameArchivoRequisito').removeAttr('disabled');//TODO para enviar en serialize
    var flgEditComePred=0;
    if( $('#txtTipo').val()=='edit' && $('#edit_comePre').val()!=$('#txtComentarioRequ').val() ){
        flgEditComePred=1;
    }
    $.ajax({
        url:baseURL + "pages/requisito/editarRequisito",
        type:'post',
        async:false,
        data:{
            idRequisito:$('#txtIdRequisito').val(),
            descripcion:$('#txtDescRequ').val(),
            comentarioPredeterminado:$('#txtComentarioRequ').val(),
            flgEditoComentario:flgEditComePred,
            nombreArchivo:$('#file_name').val(),
            idDocumentoAdjunto:$('#idDocumentoAdjunto').val()
        },
        beforeSend:function(){
            muestraLoading();
            $("#dialogMantRequisito").dialog("close");
        },
        success:function(data){
            ocultaLoading();
           
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridRequisito();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
    //$('#txtFileNameArchivoRequisito').attr('disabled','disabled');//TODO para enviar en serialize
}
//EDITAR REQUISITO - FIN
//ELIMINAR REQUISITO - INICIO
function eliminarRequisito(rowid){
    confirm.open("¿Ud. est&aacute; seguro de eliminar este requisito?","procEliminarRequ('"+rowid+"')");
}
function procEliminarRequ(id){
    $.ajax({
        url:baseURL + "pages/requisito/eliminarRequisito",
        type:'post',
        async:false,
        data:{
            idRequisito:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridRequisito();
            }else if(data.resultado=="DEPENDENCE"){
            	mensajeGrowl("warn", "Para eliminar el requisito, primero debe desasignarlo del Procedimiento", "");
            } else {
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//ELIMINAR REQUISITO - FIN
///////////////////////////
function procesarGridRequisito(flg_load){
    if(flg_load==undefined){flg_load=1;}
    
    $("#gridContenedorRequisito").html("");
    var grid = $("<table>", {
        "id": "gridRequisito"
    });
    var pager = $("<div>", {
        "id": "paginacionRequisito"
    });
    $("#gridContenedorRequisito").append(grid).append(pager);

    var nombres = ['REQUISITO','nombreArchivo','ARCHIVO ADJUNTO'];
    var columnas = [
        {name: "descripcion",width: 500,sortable: false,align: "left"}, 
        {name: "nombreArchivo",width: 70,align: "center",hidden:true},
        {name: "rutaAlfresco",width: 70,align: "center",formatter: "descargarPlantillaRequisito"}
        //{name: "numeroDocumento", width: 200, sortable: false, align: "center",formatter: "documento"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/requisito/findRequisito",
        datatype: "json",
        postData: {
            descripcion:$('#txtDescripRequ').val(),
            flg_load:flg_load
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionRequisito",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Requisitos",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idRequisito"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkVerRequisito').attr('onClick', 'abrirMantRequisito("view","'+rowid+'")');
            $('#linkEditarRequisito').attr('onClick', 'abrirMantRequisito("edit","'+rowid+'")');
            $('#linkEliminarRequisito').attr('onClick', 'eliminarRequisito("'+rowid+'")');
        },
        loadComplete: function(data) {
            $('#contextMenuRequisito').parent().remove();
            $('#divContextMenuRequisito').html("<ul id='contextMenuRequisito'>"
                    + "<li> <a id='linkVerRequisito' data-icon='ui-icon-search' title='Ver Detalle'>Consultar</a> </li>"
                    + "<li> <a id='linkEditarRequisito' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarRequisito' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuRequisito').puicontextmenu({
                target: $('#gridRequisito')
            });
        }
    });
}
//function descargarPlantillaRequisito(nombre) {
//    var sel = '';
//    if (nombre != null && nombre != '' && nombre != undefined){       
//    console.log(nombre);
//      $("#txtNombreArchivo").val(nombre);
//      sel = '<a class="link" href="'+baseURL + "pages/requisito/descargaArchivoAlfresco?nombreArchivo="+nombre+'"&rutaAlfresco="+nombre+'">'+
//      '<img class="vam" width="17" height="18" src="'+baseURL+'images/stickers.png">'+
//    '</a>';
//    }
//    return sel;
//}
jQuery.extend($.fn.fmatter, {
	descargarPlantillaRequisito: function(cellvalue, options, rowdata) {
        //return rowdata.idTipoDocumento.descripcion+" - "+ rowdata.numeroDocumento; 
        var nombre=rowdata.nombreArchivo;
        var sel = '';
        if (nombre != null && nombre != '' && nombre != undefined){       
        console.log(nombre);
          $("#txtNombreArchivo").val(nombre);
          sel = '<a class="link" href="'+baseURL + 'pages/requisito/descargaArchivoAlfresco?aplicacionSpace=REQUISITOS&nombreArchivo='+nombre+'&rutaAlfresco='+rowdata.rutaAlfresco+'">'+
          '<img class="vam" width="17" height="18" src="'+baseURL+'images/stickers.png">'+
        '</a>';
        }
        return sel;
    }
});

function descargaArchivoAlfresco(){
	  $.ajax({
	        url:baseURL + "pages/requisito/descargaArchivoAlfresco",
	        type:'post',
	        async:false,
	        data:{
	            nombreArchivo: $("#txtNombreArchivo").val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="SUCCESS"){
	                mensajeGrowl("success", "Se descargo el registró correctamente", "");
	                data.archivo;
	            } else {
	                mensajeGrowl("error", data.mensaje, "");
	            }
	        },
	        error:errorAjax
	    });
	
}

