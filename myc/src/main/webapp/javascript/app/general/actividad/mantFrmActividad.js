/* 
* Resumen           
* Objeto            : mantFrmActividad.js
* Descripción       : Diseño del mantenimiento de prioridad norma agente en el MYC.
* Fecha de Creación : 30/06/2015.
* PR de Creación    : OSINE_SFS-600
* Autor             : Hernán Torres Sáenz.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
$(function() {
    boton.closeDialog();
    
    $('#txtNombreActividad').alphanum(constant.valida.alphanum.nombre);
    $('#txtNumeroOrden').alphanum(constant.valida.alphanum.numeros);
    $("#txtNumeroOrden").keyup(function(){ if($("#txtNumeroOrden").val()==0) $("#txtNumeroOrden").val(''); });
    $('#txtCodigo').alphanum(constant.valida.alphanum.numeros);
    
    initMantActividad();
});
function initMantActividad(){
	$('#btnBuscarActividades').click(function(){procesarGridActividades();});
	$('#btnGuardarActividad').click(btnGuardarActividad);
	//$('#btnCerrarMantFrmActividad').click(function(){$("#dialogMantActividades").dialog("close");});
}

function procesarGridActividades(){
	var requisito;
	$.ajax({
        url:baseURL + "pages/mantenimientoActividad/consultarActividad", 
        type:'post',
        async:false,
        data:{
        	nombre:$('#txtNombreActividad').val(),
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            requisito=data.filas;
        },
        error:errorAjax
    });
	
	$('#verActividad').html("");
    var html="";
    $.each(requisito,function(k,v){
        var descripcion=v['codigoPadre'] +' - '+ v['nombrePadre'];
        html += '<div class="fila" >'+
                   '<div class="ilb requ vam tal" style="width:90%;">'+descripcion+'</div>';
        html += '</div>';
    });    
    $('#verActividad').html(html);
	
}

function btnGuardarActividad(){
    var validar = $('#frmMantActividad').validateAllForm("#divMensajeValidaActividad");
    if($('#tipoActividad_').val()=='editar'){
    	accion='editar';
    }else if($('#tipoActividad_').val()=='nuevo'){
    	accion='guardar';
    }
    if(validar){
        confirm.open("¿Ud. est&aacute; seguro de "+accion+" el registro?","procGuardarActividad()");
    }
}

function procGuardarActividad() {
    $.ajax({
        url:baseURL + "pages/mantenimientoActividad/guardarActividad",
        type:'post',
        async:false,
        data:{
        	tipo: $('#tipoActividad_').val(),
        	idActividad: $('#idActividad').val(),
        	codigo: $('#txtCodigo').val(),
        	nombre: $('#txtNombreActividad').val(),
        	orden: $('#txtNumeroOrden').val(),
        	forzarOrdenamiento: false,
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
            	edicionAgenteActividad=1;
            	if($('#tipoActividad_').val()=='nuevo') 
            		mensajeGrowl("success", global.confirm.save, "");
            	else 
            		mensajeGrowl("success", global.confirm.edit, "");
                $("#dialogMantActividades").dialog("close");
                procesarGridActividad();
            }else if(data.resultado=="RESTRICT"){
            	confirm.open(data.mensaje,"ajustarActividades()");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function ajustarActividades(){
	$.ajax({
        url:baseURL + "pages/mantenimientoActividad/ajustarActividades",
        type:'post',
        async:false,
        data:{
        	tipo: $('#tipoActividad_').val(),
        	idActividad: $('#idActividad').val(),
        	codigo: $('#txtCodigo').val(),
        	nombre: ($('#txtNombreActividad').val()).toUpperCase(),
        	orden: $('#txtNumeroOrden').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
            	edicionAgenteActividad=1;
            	if($('#tipoActividad_').val()=='nuevo') 
            		mensajeGrowl("success", global.confirm.save, "");
            	else 
            		mensajeGrowl("success", global.confirm.edit, "");
                $("#dialogMantActividades").dialog("close");
                procesarGridActividad();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
