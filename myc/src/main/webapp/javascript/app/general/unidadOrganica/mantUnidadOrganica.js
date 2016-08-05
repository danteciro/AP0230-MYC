var idUnidadOrganica;
var treeData=[];
$(function() {	
    initUnidadOrganica();
    cargaDataArbol(initArbol);
    initComportamiento();
    confirm.start();
});
function initUnidadOrganica() {
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral/';
    }); 
}

function cargaDataArbol(callback){
    $.ajax({
        url: baseURL + 'pages/unidadOrganica/listarUnidadOrganica',
        type: "post",
        async: false,
        data: {},
        success: function(data) { 
            treeData = fxTreeUnidadOrganica.build(data.listaUnidadOrganica);             
            if(callback!=undefined){
                callback();
            }
        },
        error:errorAjax
    });
}
function initArbol(){    
    $("#arbolUnidadorganica").fancytree({
        checkbox: false,
        selectMode: 1,
        source:treeData,
        select: function(event, data) {        	
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node){
                if(!node.folder){
                    return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
                }
            });            
        },
        keydown: function(event, data) {
            if( event.which === 32 ) {
                data.node.toggleSelected();
                return false;
            }
        },           
        extensions: ["menu"],
		 	menu: {
		        selector: "#myMenu",
		        position: {my: "center"},
		        open: function(event, data){		   
                            $('#myMenu li').map(function(){
                                if($('#permisosSeguridad').val().indexOf($(this).attr('CODE'))==-1){
                                    $(this).css('display','none');
                                }else{
                                    $(this).css('display','');
                                }
                            })
		        },
		        focus: function(event, data){
                            if(data.node!=null){idUnidadOrganica=data.node.key;}
		        }
		    },
        cookieId: "fancytree-Cb2",
        idPrefix: "fancytree-Cb2-"
    }); 
    
    $("#arbolUnidadorganica").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
}
function updateArbol(){
    ($("#arbolUnidadorganica").fancytree("getTree")).reload(treeData).done(function(){ });
    $("#arbolUnidadorganica").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
}

function initComportamiento() {	
    $("#divUnidadOrganica").dialog({
        resizable : false,
        draggable : true,
        autoOpen : false,
        height : "auto",
        width : "auto",
        modal : true,
        dialogClass : 'dialog',
        closeText : "Cerrar"
    });
    
    $("#nuevaUnidadOrganica").click(function() {	
        LimpiarDivUnidad();
        getUnidadOrganica(idUnidadOrganica,global.accion.save);
    });  
    
    $("#editarUnidadOrganica").click(function() {        		
        LimpiarDivUnidad();
        getUnidadOrganica(idUnidadOrganica,global.accion.update);
    });
    
    $("#consultaUnidadOrganica").click(function() {        		
        LimpiarDivUnidad();
        getUnidadOrganica(idUnidadOrganica,global.accion.consult);
    });
    
    $("#eliminarUnidadOrganica").click(function() {
    confirm.open("¿Ud. est&aacute; seguro de eliminar la unidad?", "eliminarUnidadOrganica()");    	
    });
	
    $("#btnAceptarUnidadOrganica").click(function() { 
        var validar = $('#frmUnidadOrganica').validateAllForm("#divMensajeValidaUnidadOrganica");
        if (validar) {  
            confirm.open("¿Ud. est&aacute; seguro de guardar este registro?","registrarUnidadOrganica()");
        } 
    });
    
    $("#btnEditarUnidadOrganica").click(function() { 
        var validar = $('#frmUnidadOrganica').validateAllForm("#divMensajeValidaUnidadOrganica");
        if (validar) {    
            confirm.open("¿Ud. est&aacute; seguro de guardar los cambios en esta Unidad Org&aacute;nica?","editarUnidadOrganica()");
        } 
    });
    
    $('#uoVacio').change(verificaCheckVacio);
}

function verificaCheckVacio(){
    if ($('#uoVacio').is(":checked")){
        $('#txtDescripcion,#txtDetalle,#txtCodDepSiga,#txtSigla').val($('#unidOrgaRegiVacioValor').val());
        $('#txtDescripcion,#txtDetalle,#txtCodDepSiga,#txtSigla').attr('disabled','disabled');
    }else{
        $('#txtDescripcion,#txtDetalle,#txtCodDepSiga,#txtSigla').val('');
        $('#txtDescripcion,#txtDetalle,#txtCodDepSiga,#txtSigla').removeAttr('disabled');
    }
}

function registrarUnidadOrganica(){
	$.ajax({
        url: baseURL + 'pages/unidadOrganica/registrarUnidadOrganica',
        type: "post",
        async: false,
        data: {
        	descripcion:$('#txtDescripcion').val(),
        	detalle:$('#txtDetalle').val(),
        	codDepSiga:$('#txtCodDepSiga').val(),
        	sigla:$('#txtSigla').val(),
        	nivel:$('#txtNivel').val(),
        	idUnidadOrganicaSuperior:$('#txtIdUnidadOrganicaPadre').val()
        },
        success: function(data) {        	
            if(data.resultado=="0") {
            	cargaDataArbol(updateArbol);
            	mensajeGrowl("success", global.confirm.save, "");            	
            } else {
            	mensajeGrowl("error", data.mensaje, "");
            }
            $("#divUnidadOrganica").dialog("close");
        },
        error:errorAjax
    });
}

function editarUnidadOrganica(){
	$.ajax({
        url: baseURL + 'pages/unidadOrganica/editarUnidadOrganica',
        type: "post",
        async: false,
        data: {
        	idUnidadOrganica:$('#txtIdUnidadOrganica').val(),
        	idUnidadOrganicaSuperior:$('#txtIdUnidadOrganicaPadre').val(),
        	descripcion:$('#txtDescripcion').val(),
        	codDepSiga:$('#txtCodDepSiga').val(),
        	sigla:$('#txtSigla').val(),
        	sede:$('#txtSede').val(),
        	detalle:$('#txtDetalle').val(),
        	nivel:$('#txtNivel').val(),
        	'nombreNivel.idMaestroColumna':$('#txtNombreNivel').val()
        },
        success: function(data) {        	
            if(data.resultado=="0") {
            	cargaDataArbol(updateArbol);
            	mensajeGrowl("success", global.confirm.edit, "");
            } else {
            	mensajeGrowl("error", data.mensaje, "");
            }
            $("#divUnidadOrganica").dialog("close");
        },
        error:errorAjax
    });
}

function eliminarUnidadOrganica(){
	$.ajax({
        url: baseURL + 'pages/unidadOrganica/eliminarUnidadOrganica',
        type: "post",
        async: false,
        data: {idUnidadOrganica:idUnidadOrganica },
        success: function(data) {        	
            if(data.resultado=="0") {
            	cargaDataArbol(updateArbol);
            	mensajeGrowl("success", global.confirm.delete, "");            	
            } else {
            	mensajeGrowl("warn", data.mensaje, "");
            }
        },
        error:errorAjax
    }); 
}

function getUnidadOrganica(idUnidadOrganica, accion){
	$.ajax({
        url: baseURL + 'pages/unidadOrganica/listarUnidadOrganicaMant',
        type: "post",
        async: false,
        data: {idUnidadOrganica: idUnidadOrganica },
        success: function(data) {  
            if(data!=null){
            	var Nivel=parseInt(data.unidadOrganica.nivel)+1;
            	var maxNivel=$('#maxNivelDivision').val();
                $('#txtDescripcion,#txtDetalle,#txtCodDepSiga,#txtSigla').removeClass("error");
            	if(accion == global.accion.save){
                    if(Nivel<=maxNivel){
                        $('#txtNivel').val(Nivel);
                        $('#lblNombreNivel').text(data.maestroColumna.descripcion);
                        $('#txtIdUnidadOrganicaPadre').val(data.unidadOrganica.idUnidadOrganica);
                        $("#divUnidadOrganica").dialog('option', 'title','NUEVA UNIDAD ORGANICA');
                        $('#divUnidadOrganica').dialog('open'); 
                        
                        $('#btnAceptarUnidadOrganica').css('display','');
                        $('#divUOVacio').css('display','');
                    }else{
                        mensajeGrowl("error", global.msjMaxNivel.error + " L&iacute;mite m&aacute;ximo", "");
                    }
            	}else {
                    $('#lblNombreNivel').text(data.unidadOrganica.nombreNivel.descripcion);
                    $('#txtIdUnidadOrganica').val(data.unidadOrganica.idUnidadOrganica);
                    $('#txtIdUnidadOrganicaPadre').val(data.unidadOrganica.idUnidadOrganicaSuperior);
                    $('#txtDescripcion').val(data.unidadOrganica.descripcion);
                    $('#txtDetalle').val(data.unidadOrganica.detalle);
                    $('#txtCodDepSiga').val(data.unidadOrganica.codDepSiga);
                    $('#txtSigla').val(data.unidadOrganica.sigla);
                    $('#txtSede').val(data.unidadOrganica.sede);
                    $('#txtNombreNivel').val(data.unidadOrganica.nombreNivel.idMaestroColumna);
                    $('#txtNivel').val(data.unidadOrganica.nivel);
                    $("#divUnidadOrganica").dialog('option', 'title','EDITAR UNIDAD ORGANICA');
                    $('#divUnidadOrganica').dialog('open');
                    $('#btnEditarUnidadOrganica').css('display','');
                    if(accion == global.accion.consult){
                        $('#txtDescripcion,#txtDetalle,#txtCodDepSiga,#txtSigla').attr('disabled','disabled');
                        $('#btnAceptarUnidadOrganica,#btnEditarUnidadOrganica').css('display','none');
                        $("#divUnidadOrganica").dialog('option', 'title','CONSULTAR UNIDAD ORGANICA');
                    }
            	} 
            }
        },
        error:errorAjax
    });
}

function LimpiarDivUnidad(){	
	$('#lblNombreNivel').text('');
	$('#txtIdUnidadorganica').val('');
	$('#txtIdUnidadorganicaPadre').val('');
	$('#txtNivel').val('');
	$('#txtDescripcion').val('');
	$('#txtDetalle').val('');
	$('#txtCodDepSiga').val('');
	$('#txtSigla').val('');
	$('#slctNivelUnidadOrganica').val('');
        
    $('#uoVacio').attr('checked',false).trigger('change');
    $('#divUOVacio').css('display','none');
    $('#btnAceptarUnidadOrganica,#btnEditarUnidadOrganica').css('display','none');
}
