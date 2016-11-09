$(function() {
	 boton.closeDialog();
	$('#btnGuardarSubEtapaMod').click(function() {
		validarActualizar();
	});
	obtenerDisponible();
	$('#tiempoDiasSubEtapaMod').alphanum(numericPorcentaje);
});

function validarActualizar(){
		var mensajeValidacion = "";
		var divValidacion = $('#divMensajeModificarSubEtapa');
		if ( $('#frmModificarSubEtapa').validateAllForm("#divMensajeModificarSubEtapa") ) {
	    	divValidacion.hide();
	        divValidacion.html("");
	        var a = parseInt($('#tiempoDiasSubEtapaMod').val());
	        var b = parseInt($('#idEtapaDisponibleEditarSub').val());
	        var c = parseInt($('#idTiempoActualSubEtapa').val());
	        var d = b + c;
	    	if(a>d){
	    		mensajeValidacion += "* El tiempo en Dias debe ser menor o igual a: "+d;
	            divValidacion.show();
	            divValidacion.focus();
	            divValidacion.html(mensajeValidacion);
	    	}else{
	    		confirm.open("¿Ud est&aacute; seguro de Modificar el registro?","actualizarSubEtapa()");
	    	}
	            
	    } 
}

function obtenerDisponible(){
	$.ajax({
        url:baseURL + "pages/mantenimientoEtapa/obtenerDatosEtapa",
        type:'post',
        async:false,
        data:{
        	etapaId : $('#idEtapaEdit').val()	        	
	        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
            	console.info('plazo '+data.plazo);
            	$('#idEtapaPlazoEditarSub').val(data.plazo);
            	$('#idEtapaDisponibleEditarSub').val(data.disponible);
            	console.info('disponible '+data.disponible);
            }
        },
        error:errorAjax
	});
}

function actualizarSubEtapa() {
	$.ajax({
        url:baseURL + "pages/mantenimientoEtapa/actualizarSubEtapa",
        type:'post',
        async:false,
        data:{
        	idSubetapa : $('#idSubEtapaMod').val(),
        	descripcion : $('#descripcionSubEtapaMod').val(),
        	tiempoDias : $('#tiempoDiasSubEtapaMod').val(),
           'idEtapa.idEtapa' : $('#cmbEtapasSubMod').val(),
           'idResponsable.idMaestroColumna' : $('#cmbResponsableSubEtapaMod').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.save, "");
                $('#dialogModificarSubEtapa').dialog('close');
                mantenimientoEtapa.listarSubEtapaModificar($('#cmbEtapasSubMod').val());
               
            }
        },
        error:errorAjax
	});
}
