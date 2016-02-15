$(function() {
    boton.closeDialog();
    $('#frmMantSanc').validarForm(); 
    $('#cmbTipoSancEspeSanc').change(function(){cambiarTipoSancionEspe();});
    $('#cmbTipoSancEspeSanc').trigger('change');
    $('#btnGuardarDetalleCriterioSanc').click(validaGuardarDetalleCriterioSanc);
    $('#btnEditarDetalleCriterioSanc').click(validaEditarDetalleCriterioSanc);
    validaEditFormMantSanc();
    $('#txtMontoCriterioSanc').alphanum(numericMonto);
});
function validaEditFormMantSanc(){
    if($('#txtTipoSanc').val()=='edit'){
        if($('#cmbTipoSancEspeSanc option:selected').text()=="MONETARIA"){
            $('#txtMontoCriterioSanc').val($('#txtSancMoneSanc').val());
        }else if($('#cmbTipoSancEspeSanc option:selected').text()=="ADMINISTRATIVA"){
            $('#txtConcatIdTipoSancion').val().split(',').map(function(v,i){
                $('#chkMantTS_'+v).attr('checked',true);
            });
        }else if($('#cmbTipoSancEspeSanc option:selected').text()=="AMBAS"){
            $('#txtMontoCriterioSanc').val($('#txtSancMoneSanc').val());
            $('#txtConcatIdTipoSancion').val().split(',').map(function(v,i){
                $('#chkMantTS_'+v).attr('checked',true);
            });
        }
    }
}
function validaGuardarDetalleCriterioSanc(){
    if ($('#frmMantSanc').validateAllForm("#divMensajeValidaFrmMantSanc")) {
        confirm.open("¿Ud. est&aacute; seguro de Guardar?","procGuardarDetalleCriterioSanc()");
    } 
}
function procGuardarDetalleCriterioSanc(){
    settearNamesFormMantSanc();
    
    $.ajax({
        url:baseURL + "pages/criterio/registrarDetalleCriterio",
        type:'post',
        async:false,
        data:$('#frmMantSanc').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                criterio.gridSancionEspecifica();
                $("#containerDialogMantenimientoSanciones").dialog("close");
            }else if(data.resultado=="ERROR"){
                mensajeGrowl("error", data.mensaje, "Intente de nuevo");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
    procesarGridCriterio();
}
function validaEditarDetalleCriterioSanc(){
    if ($('#frmMantSanc').validateAllForm("#divMensajeValidaFrmMantSanc")) {
        confirm.open("¿Ud. est&aacute; seguro de Guardar?","procEditarDetalleCriterioSanc()");
    } 
}
function procEditarDetalleCriterioSanc(){
    settearNamesFormMantSanc();
    
    $.ajax({
        url:baseURL + "pages/criterio/editarDetalleCriterio",
        type:'post',
        async:false,
        data:$('#frmMantSanc').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                criterio.gridSancionEspecifica();
                $("#containerDialogMantenimientoSanciones").dialog("close");
            }else if(data.resultado=="ERROR"){
                mensajeGrowl("error", data.mensaje, "Intente de nuevo");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
    procesarGridCriterio();
}
function settearNamesFormMantSanc(){
    //coloca name a input check tramites seleccionados
    var cont=0;
    $('#divTipificacionSanc').find('input').removeAttr('name');//limpia names
    $('#divTipificacionSanc ').find('input:checked').map(function(){//busca marcados con check
        $(this).attr('name','tipificacionSancion['+cont+'].idTipoSancion');//les coloca names
        $(this).parent().find('input:eq(1)').attr('name','tipificacionSancion['+cont+'].idTipificacion');//les coloca names
        cont++;
    });
}

function cambiarTipoSancionEspe(){
    $('#divMontoCriterioSanc,#divTipificacionSanc').css('display','none');
    $('#txtMontoCriterioSanc').val('');
    $('#txtMontoCriterioSanc').removeAttr('validate');
    $('#divTipificacionSanc div:eq(0)').html('');
    
    if($('#cmbTipoSancEspeSanc option:selected').text()=="MONETARIA"){
        $('#divMontoCriterioSanc').css('display','');
        $('#txtMontoCriterioSanc').attr('validate','[O]');
    }else if($('#cmbTipoSancEspeSanc option:selected').text()=="ADMINISTRATIVA"){        
        obtenerTipificacionSancionEspe();
    }else if($('#cmbTipoSancEspeSanc option:selected').text()=="AMBAS"){        
        obtenerTipificacionSancionEspe();
        $('#divMontoCriterioSanc,#divTipificacionSanc').css('display','');
        $('#txtMontoCriterioSanc').attr('validate','[O]');
    }
}

function obtenerTipificacionSancionEspe() {
    $.ajax({
        url:baseURL + "pages/tipificacion/findTipificacionSancionMantSanc",
        type:'get',
        async:false,
        data:{
            idCriterio:$('#idCriterioSanc').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            var html='';
            for(var x = 0; x < data.filas.length;x++){
                var idTipoSancion = data.filas[x].idTipoSancion;
                var descripcionSancion = data.filas[x].descripcionSancion;   
                var idTipificacion = data.filas[x].idTipificacion;
                html+='<div style="padding: 2px;">'+
                    '<input id="chkMantTS_' + idTipoSancion + '" type="checkbox" value="' + idTipoSancion + '">'+
                    '<label for="chkMantTS_' + idTipoSancion + '" class="checkbox">' + descripcionSancion + '</label>'+
                    '<input type="hidden" value="' + idTipificacion + '">'+
                    '</div>';
                if(data.filas.length>0){
                	if($('#cmbTipoSancEspeSanc option:selected').text()=="ADMINISTRATIVA"){
                		$('#divTipificacionSanc').css('display','');
                	}
                }
            }
            $('#divTipificacionSanc div:eq(0)').html(html);
        },
        error:errorAjax
    });
}