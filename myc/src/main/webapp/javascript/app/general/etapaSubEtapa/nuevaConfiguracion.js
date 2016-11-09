$(function() {
	boton.closeDialog();
	procesarCombos();
	$('#txtNotificacion').alphanum(numericPorcentaje);
	$('#btnGuardarConfigEtapa').click(function() {
		btnGuardarConfiguracion();
	});		
	validacion();
});

function procesarCombos() {
	$('#cmbGerenciaEtapa2').change(function() {
		procesarLista.listarDivisiones();
	});

	$('#cmbDivisionEtapa2').change(function() {
		procesarLista.listarActividad();
		procesarLista.listarSectores();
	});
	
	$('#cmbActividadEtapa2').change(function(){
		procesarLista.listarAgentes();
	});
	
	$('#btnGuardarConfigEtapa').click(function() {
		btnGuardarConfiguracion();
	});	
	
	$('#btnRegistrarEtapa').click(function() {
		btnGuardarEtapa();
	});	
	
	$('#btnGuardarSubEtapa').click(function() {
		btnGuardarSubEtapa();
	});	
	
	$('#btnGuardarEtapaTramite').click(function() {
		btnGuardarEtapaTramite();
	});	
	
};

function btnGuardarConfiguracion(){
    if ( $('#frmMantConfiguracionEtapa').validateAllForm("#divMensajeMantConfiguracionEtapa") ) {
            confirm.open("¿Ud est&aacute; seguro de Guardar?","registrarConfiguracion()");
    }
}

function validacion() {
	/* OSINE_SFS-1232 - RSIS 6 - Inicio */
	$('#txtNotificacion').change(function () {
			var valor = $('#txtNotificacion').val();
			 var estado= false;
			  if(parseInt(valor) >0 && parseInt(valor) <= 100){				  
				  var mensajeHTML1 = '';
				  mensajeHTML1 ='';
				  $('#mensajeNoti').remove();
				  $('#mensajeNoti').append(mensajeHTML1);
				  estado= true;
			  }else{				  
				  $('#txtNotificacion').val('');	
				  if($('#mensajeNoti').text()==''){
					  $('#mensajeNoti').append('<span id="mensajeNoti"></span>');
					  var mensajeHTML = '';
					  mensajeHTML = '<font color="red"><b>Se debe ingresar un valor entre 1 a 100.</b></font>';
					  $('#mensajeNoti').append(mensajeHTML);
				  }
			  }
			  return estado;
	   });
	/* OSINE_SFS-1232 - RSIS 6 - Fin */
}

function registrarConfiguracion() {
	$.ajax({
        url:baseURL + "pages/mantenimientoEtapa/registrarConfiguracionEtapa",
        type:'post',
        async:false,
        data:$('#frmMantConfiguracionEtapa').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.save, "");
                $('#dialogNuevaConfiguracionEtapa').dialog('close');
                procesarLista.listarConfTramite();
            }else if(data.resultado=="2"){
            	mensajeGrowl("warn", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
