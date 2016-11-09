$(function() {
	boton.closeDialog();

	$('#btnGuardarModSubEtapa').click(function(){
		validarAgregarNuevaSubEtapa(); 
	});
	$('#tiempoDiasSubEtapa').alphanum(numericPorcentaje);
	obtenerDisponible();
	
});

function obtenerDisponible(){
	$.ajax({
        url:baseURL + "pages/mantenimientoEtapa/obtenerDatosEtapa",
        type:'post',
        async:false,
        data:{
        	etapaId : $('#idEtapaAgregar').val()	        	
	        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
            	console.info('plazo '+data.plazo);
            	$('#idEtapaPlazoEditar').val(data.plazo);
            	$('#idEtapaDisponibleEditar').val(data.disponible);
            	console.info('disponible '+data.disponible);
            }
        },
        error:errorAjax
	});
}

function validarAgregarNuevaSubEtapa(){
	var mensajeValidacion = "";
	var divValidacion = $('#divMensajeNuevaSubEtapa');
	if ( $('#frmNuevaSubEtapa').validateAllForm("#divMensajeNuevaSubEtapa") ) {
    	divValidacion.hide();
        divValidacion.html("");
        var a = parseInt($('#tiempoDiasSubEtapa').val());
        var b = parseInt($('#idEtapaDisponibleEditar').val());
    	if(a>b){
    		mensajeValidacion += "* El tiempo en Dias debe ser menor o igual a: "+$('#idEtapaDisponibleEditar').val();
            divValidacion.show();
            divValidacion.focus();
            divValidacion.html(mensajeValidacion);
    	}else{
    		 confirm.open("¿Ud est&aacute; seguro de Guardar?","modificarSubEtapa()");
    	}
            
    }    

	
}

function modificarSubEtapa(){
	$.ajax({
        url:baseURL + "pages/mantenimientoEtapa/registrarNuevaSubEtapa",
        type:'post',
        async:false,
        data:{
        	descripcion : $('#descripcionSubEtapa').val(),
        	tiempoDias : $('#tiempoDiasSubEtapa').val(),
        	'idResponsable.idMaestroColumna' : $('#cmbResponsableSubEtapa').val(),
        	etapaId : $('#idEtapaAgregar').val()
        	
	        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.save, "");
                $('#dialogModSubEtapaSub').dialog('close');
                mantenimientoEtapa.listarSubEtapaModificar( $('#idEtapaAgregar').val());
            }
        },
        error:errorAjax
	});
}