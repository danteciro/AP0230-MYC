/*
* Resumen
* Objeto            : mantenimientoEtapas.js
* Descripción       : JavaScript donde se maneja las acciones de la pestaña mantenimientoEtapas.
* Fecha de Creación : 06/10/2016
* PR de Creación    : 
* Autor             : GMD
* =====================================================================================================================================================================
* Modificaciones |
* Motivo         |  Fecha        |   Nombre                     |     Descripción
* =====================================================================================================================================================================
* OSINE_SFS-1232 | 03/11/2016    |   Luis García Reyna          |     CONFIGURACION ETAPAS Y SUBETAPAS - Validaciones
*/


// general/etapaSubEtapa/modificarConfiguracion.js

var genEtaSubModConf={
    
    inicializaEventos: function(){
        $('#notificacionMod').alphanum(numericPorcentaje);        
        $('#btnGuardarEditarConfig').click(function() {genEtaSubModConf.fxRegistraMantEta.validaRegistroMantEta();});
      },
    
    fxRegistraMantEta:{
        validaRegistroMantEta: function(){
            if($('#divFrmConfEtapSubEtap').validateAllForm("#divMensajeValidaFrmConfEtapSubEtap")){
                var mensajeValidacion = '';
                mensajeValidacion = genEtaSubModConf.validacionNotificacion();
                if (mensajeValidacion == '') {
                    confirm.open("¿Confirma que desea actualizar el registro?","genEtaSubModConf.fxRegistraMantEta.procesaRegistrMantEtaModConf()");
                    
                }else {
                    mensajeGrowl('warn', mensajeValidacion);
                }
            }else{
                mensajeGrowl("warn", "Se debe completar los campos obligatorios, corregir", "");
            }
        },
                
        procesaRegistrMantEtaModConf : function (){
            $.ajax({
            url:baseURL + "pages/mantenimientoEtapa/modificarConfiguracion",
            type:'post',
            async:false,
            data:{  
                idConfTramite : $('#idConfTramite').val(),
                orientacion : $('#orientacionMod').val(),
                notificacion : $('#notificacionMod').val()
            },
            success:function(data){
             ocultaLoading();           
                if(data.resultado=='0'){
                    mensajeGrowl("success", global.confirm.save, "");
                    mantenimientoEtapa.listarSubEtapaModificar($('#idEtapaEdit').val());
                    $('#dialogModificarConfiguracion').dialog('close');
                }else{
                    mensajeGrowl("error", data.mensaje, "");
                }                    
            },
            error:errorAjax
            });
        }                
    },
    
    validacionNotificacion: function() {
        var mensajeValidacion = '';
        if(parseInt($('#notificacionMod').val()) < 1 || parseInt($('#notificacionMod').val()) > 100){
            $('#notificacionMod').addClass('error');
            mensajeValidacion = "Se debe ingresar un valor entre 1 y 100 , corregir";
            return mensajeValidacion;
        }
       return mensajeValidacion;
    }
    
}

$(function() {
    boton.closeDialog();
    genEtaSubModConf.inicializaEventos();
    $('#idPlazoMod').alphanum(numericPorcentaje); 
    
  //colocar disabled
	if( $('#btnModConfiguracion_modificarEtapaTramite').val()=="Consultar"){
		 $('#orientacionMod').attr('disabled',true);
		 $('#notificacionMod').attr('disabled',true);
		 
		 $('#btnGuardarEditarConfig').hide();
		 
		 
		 
	}//colocar disabled
});
	
