$(function() {
	boton.closeDialog();
	$('#btnGuardarNuevaSubEtapa').click(function() {
		validarGuardarSubEtapa();
	});
	
	$('#tiempoDiasSubEtapaNueva').alphanum(numericPorcentaje);
	$('#cmbEtapasSubNueva').change(function(){
		$.ajax({
	        url:baseURL + "pages/mantenimientoEtapa/obtenerDatosEtapa",
	        type:'post',
	        async:false,
	        data:{
	        	etapaId : $('#cmbEtapasSubNueva').val()	        	
		        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="0"){
	            	console.info('plazo '+data.plazo);
	            	$('#idEtapaPlazoNuevo').val(data.plazo);
	            	$('#idEtapaDisponibleNuevo').val(data.disponible);
	            	console.info('disponible '+data.disponible);
	            }
	        },
	        error:errorAjax
		});
	});
});

function validarGuardarSubEtapa(){
	var mensajeValidacion = "";
	var divValidacion = $('#divMensajeNuevaSubEtapa_EtapaTramite');
    if ( $('#frmNuevaSubEtapa_EtapaTramite').validateAllForm("#divMensajeNuevaSubEtapa_EtapaTramite")  ) {
    	divValidacion.hide();
        divValidacion.html("");
        var a = parseInt($('#tiempoDiasSubEtapaNueva').val());
        var b = parseInt($('#idEtapaDisponibleNuevo').val());
    	if(a>b){
    		mensajeValidacion += "* El tiempo en Dias debe ser menor o igual a: "+$('#idEtapaDisponibleNuevo').val();
            divValidacion.show();
            divValidacion.focus();
            divValidacion.html(mensajeValidacion);
    	}else{
    		confirm.open("¿Ud est&aacute; seguro de Guardar?","agregarSubEtapa()");
    	}
            
    }
}

function agregarSubEtapa(){
	$.ajax({
        url:baseURL + "pages/mantenimientoEtapa/registrarNuevaSubEtapa",
        type:'post',
        async:false,
        data:{
        	descripcion : $('#descripcionSubEtapaNueva').val(),
        	tiempoDias : $('#tiempoDiasSubEtapaNueva').val(),
        	'idResponsable.idMaestroColumna' : $('#cmbResponsableSubEtapaNueva').val(),
        	etapaId : $('#cmbEtapasSubNueva').val()
        	
	        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.save, "");
                $('#dialogNuevaSubEtapaEtapaTramite').dialog('close');
                procesarLista.listarSubEtapaEtapa('','');
            }
        },
        error:errorAjax
	});
}