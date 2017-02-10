var inps = 'pages/inps/';
$(function() {	
	initSeleccionMuestral();
});

function initSeleccionMuestral(){	
	$('#txtProbGrifoES').alphanum(enteroMonto);
	$('#txtPorcSupContingencia').alphanum(enteroMonto);	
	$("#txtProbGrifoES").blur(function() {
		  if(this.value>100){
			  $( "#txtProbGrifoES" ).val('100');
		  }
		  if(this.value==0){
			  $( "#txtProbGrifoES" ).val('1');
		  }
	});
	$("#txtPorcSupContingencia").blur(function() {
		  if(this.value>100){
			  $( "#txtPorcSupContingencia" ).val('100');
		  }
		  if(this.value==0){
			  $( "#txtPorcSupContingencia" ).val('1');
		  }
	});
	
	
	$('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/inps';
    });
	$('#cmbTipoSupervision').change(function(){
		obtenerObligacionSubTipo($('#cmbTipoSupervision').val());
	});
	$('#cmbSubTipoSupervision').change(function(){

	});
	$('#btnGuardarSeleccionMuestral').click(function(){
		var valorContigencia = $('#txtPorcSupContingencia').val();
		var porcContingencia = valorContigencia/100;	
		var valorProbabilidad = $('#txtProbGrifoES').val();
		var porcProbabilidad= valorProbabilidad/100;
		$('#txtPorcSupContingenciaHidden').val(porcContingencia);
		$('#txtProbGrifoESHidden').val(porcProbabilidad);
		var valida;
	    valida = $('#frmSeleccionMuestral').validateAllForm('#divMensajeValidacionSeleccionMuestral');
		if(valida){
			registrarSeleccionMuestral();
		}
		
	});
	
	
}

function obtenerObligacionSubTipo(idTipoSupervision) {
    $.getJSON("obligacionSubTipo/listarObligacionSubTipo", {
    	idObligacionTipo: idTipoSupervision,
        ajax: 'true',
        async: true
    }, function(data) {
        var html = '<option value="">--Seleccione--</option>';
        var len = data.length;
        for (var i = 0; i < len; i++) {
        	html += '<option value="' + data[i].idObligacionSubTipo + '">'
        	+ data[i].nombre + '</option>';
        }
        $('#cmbSubTipoSupervision').html(html);
    });
}

function obtenerProbabilidad(codigo) {
    $.getJSON("obligacionSubTipo/obtenerParametros", {
    	codigo: codigo,
        ajax: 'true',
        async: true
    }, function(data) {
        	$('#txtProbGrifoES').val(data.descripcion);
    });
}

function obtenerPorcentaje(codigo) {
    $.getJSON("obligacionSubTipo/obtenerParametros", {
    	codigo: codigo,
        ajax: 'true',
        async: true
    }, function(data) {
        	$('#txtPorcSupContingencia').val(data.descripcion);
    });
}

function registrarSeleccionMuestral() {
		$('#btnGuardarSeleccionMuestral').attr('disabled','disabled');
        $.ajax({
            url: baseURL + inps + "supervisionMuestral/registrarSeleccionMuestral",            
            type: 'post',
            async: false,
            data: $("#frmSeleccionMuestral").serialize(),
            beforeSend: muestraLoading,
            success: function(data) {
                if (data.resultado == 0) {
                    mensajeGrowl("success", "Se generó correctamente muestra ", "Se registrarón los datos correctamente");
                    ocultaLoading();
                    $('#btnGuardarSeleccionMuestral').removeAttr('disabled');
                } else if (data.resultado == 2) {
                    ocultaLoading();
                    mensajeGrowl('warn', "Selecci&oacute;n Muestral:", 'El periodo actual ya cuenta con la selecci&oacute;n muestral');
                    $('#btnGuardarSeleccionMuestral').removeAttr('disabled');
                } else if(data.resultado == 3){
                	ocultaLoading();
                    mensajeGrowl('warn', "Selecci&oacute;n Muestral:", 'La actividad no se encuentra registrada');
                    $('#btnGuardarSeleccionMuestral').removeAttr('disabled');
                }  else {
                      mensajeGrowl('error', "Error en el insertar", 'Intente de nuevo');
                    ocultaLoading();
                }
            },
            error: errorAjax
        });
        
}
