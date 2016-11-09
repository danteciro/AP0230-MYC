$(function() {
	 boton.closeDialog();
	$('#btnModConfiguracion_modificarEtapaTramite').click(function() {
		mantenimientoEtapa.abrirModificarConfiguracion();
	});
	$('#idPlazoMod').alphanum(numericPorcentaje);
	
	
	$('#btnNuevaSubEtapa_modificarEtapaTramite').click(function() {
		procesarModalesModificar.abrirAgregarSubEtapa();
	});
	
	
	$('#btnGuardarEtapa_modificarEtapaTramite').click(function() {
		validarActualizarEtapa();
	});
	
});

function validarActualizarEtapa(){
	if ( $('#frmMantEditarEtapa').validateAllForm("#divMensajeMantEditarEtapa") ) {
        confirm.open("¿Ud est&aacute; seguro de Guardar?","actualizarEtapa()");
	 }
}

var procesarModalesModificar = {
		 abrirModificarConfiguracion : function() {
			$.ajax({
			        url:baseURL + "pages/mantenimientoEtapa/abrirModificarConfiguracion", 
			        type:'POST',
			        async:false,
			        data:{
			        	idConfTramite : $("#idConfTramite").val()
			        },
			        beforeSend:muestraLoading,
			        success:function(data){
			            ocultaLoading();
			            $("#dialogModificarConfiguracion").html(data);
			            $("#dialogModificarConfiguracion").dialog({
			                resizable: false,
			                draggable: true,
			                autoOpen: true,
			                height:"auto",
			                width: "auto",
			                modal: true,
			                dialogClass: 'dialog',
			                title: "Modificar Configuración de Etapas y SubEtapas de Atención"
			            });
			        },
			        error:errorAjax
			    });
		},
		abrirAgregarSubEtapa: function() {
			$.ajax({
		        url:baseURL + "pages/mantenimientoEtapa/abrirModificarSubEtapa", 
		        type:'POST',
		        async:false,
		        data:{
		        	    idEtapaMod : $("#idEtapaEdit").val()
		        },
		        beforeSend:muestraLoading,
		        success:function(data){
		            ocultaLoading();
		            $("#dialogModSubEtapaSub").html(data);
		            $("#dialogModSubEtapaSub").dialog({
		                resizable: false,
		                draggable: true,
		                autoOpen: true,
		                height:"auto",
		                width: "auto",
		                modal: true,
		                dialogClass: 'dialog',
		                title: "Agregar SubEtapa"
		            });
		        },
		        error:errorAjax
		    });
		},
};

function actualizarEtapa() {
	$.ajax({
        url:baseURL + "pages/mantenimientoEtapa/actualizarEtapaModificarEtapaTramite",
        type:'post',
        async:false,
        data:{
        	idEtapaEdit : $('#idEtapaEdit').val(),
        	nombreEtapa : $('#idEtapaMod').val(),
        	plazo : $('#idPlazoMod').val()
        	
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.save, "");
                mantenimientoEtapa.listarEtapaTramite();
            }else if(data.resultado=="2"){
            	mensajeGrowl("warn", data.mensaje, "");
            }
        },
        error:errorAjax
	});
}

	