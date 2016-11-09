$(function() {
	boton.closeDialog();
	$('#btnGuardarSubEtapa').click(function() {
		btnGuardarSubEtapa();
	});	
	$('#tiempoDiasSubEtapa').alphanum(numericPorcentaje);
	$('#cmbEtapasSubMod').change(function(){
		$.ajax({
	        url:baseURL + "pages/mantenimientoEtapa/obtenerDatosEtapa",
	        type:'post',
	        async:false,
	        data:{
	        	etapaId : $('#cmbEtapasSubMod').val()	        	
		        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="0"){
	            	console.info('plazo '+data.plazo);
	            	$('#idEtapaPlazo').val(data.plazo);
	            	$('#idEtapaDisponible').val(data.disponible);
	            	console.info('disponible '+data.disponible);
	            }
	        },
	        error:errorAjax
		});
	});
	$('#tiempoDiasSubEtapaMod').alphanum(numericPorcentaje);
});

function btnGuardarSubEtapa(){
	var mensajeValidacion = "";
	var divValidacion = $('#divMensajeNuevaSubEtapa');
    if ( $('#frmSubEtapaMod').validateAllForm("#divMensajeSubEtapa") ) {
    	divValidacion.hide();
        divValidacion.html("");
        var a = parseInt($('#tiempoDiasSubEtapaMod').val());
        var b = parseInt($('#idEtapaDisponible').val());
    	if(a>b){
    		mensajeValidacion += "* El tiempo en Dias debe ser menor o igual a: "+$('#idEtapaDisponible').val();
            divValidacion.show();
            divValidacion.focus();
            divValidacion.html(mensajeValidacion);
    	}else{
    		confirm.open("¿Ud est&aacute; seguro de Guardar?","registrarNuevaSubEtapa()");
    	}
            
    }
}


function registrarNuevaSubEtapa() {
		$.ajax({
	        url:baseURL + "pages/mantenimientoEtapa/registrarNuevaSubEtapa",
	        type:'post',
	        async:false,
	        data:{
	        	descripcion : $('#descripcionSubEtapaMod').val(),
	        	tiempoDias : $('#tiempoDiasSubEtapaMod').val(),
	        	'idResponsable.idMaestroColumna' : $('#cmbResponsableSubEtapaMod').val(),
	        	'idEtapa.idEtapa' : $('#cmbEtapasSubMod').val(),
	        	etapaId : $('#cmbEtapasSubMod').val()
	        	
		        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="0"){
	                mensajeGrowl("success", global.confirm.save, "");
	                $('#dialogNuevaSubEtapaSub').dialog('close');
	                procesarLista.listarSubEtapaEtapa('','');
	            }
	        },
	        error:errorAjax
		});

}