
$(function() {
	
    boton.closeDialog();
    confirm.start();
	$('#plazoEtapa').alphanum(numericMonto);
	$('#tiempoDiasSubEtapa').alphanum(numericMonto);	
	
	$('#btnNuevaSubEtapa_etapaTramite').click(function() {
		procesarModales.abrirNuevaSubEtapaEtapaTramite();
	});	
	$('#btnNuevaEtapa_etapaTramite').click(function() {
		procesarModales.abrirNuevaEtapa();
	});	
	$('#btnNuevaConfig_etapaTramite').click(function() {
		procesarModales.abrirNuevaConfiguracion();
	});	
	
	$('#btnGuardarEtapaTramite').click(function() {
		btnGuardarEtapaTramite();
	});		
	  
	
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
		
		
};

var procesarRegistro = {
		registrarEtapaTramite : function() {
			
				$.ajax({
			        url:baseURL + "pages/mantenimientoEtapa/registraEtapaTramiteDos",
			        type:'post',
			        async:false,
			        data:{
			        	etapasArray : etapas,
			        	idEtapa : codigoEtapa,
			        	idConfTramite : codigoConfTramite
			        },
			        beforeSend:muestraLoading,
			        success:function(data){
			            ocultaLoading();
			            if(data.resultado=="0"){
			                mensajeGrowl("success", global.confirm.save, "");
			                $('#dialogEtapaTramiteSub').dialog('close');
			                mantenimientoEtapa.listarEtapaTramite();
			            }
			        },
			        error:errorAjax
				});

			
		},
		
};


function btnGuardarEtapaTramite(){
	console.info(' codigo : -> '+codigoConfTramite);
	console.info(' cantidad etapas : -> '+etapas.length);
	var mensajeValidacion = "";
	var divValidacion = $('#divMensajeMantEtapaTramite');
	if(codigoConfTramite!="" && codigoConfTramite!=undefined){
		divValidacion.hide();
        divValidacion.html("");
        if(etapas.length>1){
        	confirm.open("¿Ud est&aacute; seguro de Guardar?","procesarRegistro.registrarEtapaTramite()");
        }else{
        	mensajeValidacion += "* Debe seleccionar al menos una Etapa";
            divValidacion.show();
            divValidacion.focus();
            divValidacion.html(mensajeValidacion);
        }        
	}else{
		mensajeValidacion += "* Debe seleccionar una de las configuraciones ";
            divValidacion.show();
            divValidacion.focus();
            divValidacion.html(mensajeValidacion);
	}
}


