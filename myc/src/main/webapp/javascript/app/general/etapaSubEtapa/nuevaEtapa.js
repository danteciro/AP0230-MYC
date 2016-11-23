$(function(){
	 boton.closeDialog();
	$('#btnRegistrarEtapa').click(function() {
		btnGuardarEtapa();
	});	
	$('#plazoEtapa').alphanum(numericPorcentaje);
});


function btnGuardarEtapa(){
    if ( $('#frmNuevaEtapa').validateAllForm("#divMensajeNuevaEtapa") ) {
            confirm.open("¿Ud est&aacute; seguro de Guardar?","registrarNuevaEtapa()");
    }
}



function registrarNuevaEtapa() {
	$.ajax({
        url:baseURL + "pages/mantenimientoEtapa/registrarNuevaEtapa",
        type:'post',
        async:false,
        data:{
        	descripcion : $('#descripcionEtapa').val().trim(),
        	plazo : $('#plazoEtapa').val(),
        	'idProceso.idProceso' : $('#cmbProcesoEtapa').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.save, "");
                $('#dialogNuevaEtapaSub').dialog('close');
                //procesarLista.listarEtapa();
                if($('#codigoConfiguracionTramite').val()!=""){
                	console.info('Con codigo ->'+$('#codigoConfiguracionTramite').val());
                	procesarLista.listarEtapa('',$('#codigoConfiguracionTramite').val());
                }else{
                	console.info('sin codigo');
                	procesarLista.listarEtapa();
                }
                
                
            }else if(data.resultado=="2"){
            	mensajeGrowl("warn", data.mensaje, "");
            }
        },
        error:errorAjax
	});
}