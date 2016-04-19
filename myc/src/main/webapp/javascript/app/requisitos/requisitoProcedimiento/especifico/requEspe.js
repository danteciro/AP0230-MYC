var reqEspe=[];
var treeData=[];
$(function() {
    buscarRequEspe();
    armaCabeceraRequisitosEspe();
    //armaEspecificosRequisitos(reqEspe);
    initRequEspe();
});

function buscarRequEspe(){
    $.ajax({
        url:baseURL + "pages/requisitoProcedimiento/listarRequisitosProcedimiento", 
        type:'get',
        async:false,
        data:{
            idProcedimiento:$('#idProcedimento').val(),
            flgGeneral:"0"
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            reqEspe=data.filas;
            armaEspecificosRequisitos(data.filas);
        },
        error:errorAjax
    });
}

function initRequEspe() {
    evaluaCheckTodoMenuCircular();
    $('#menuCircularEspe').find('input').on('change', function() {
        evaluaCheckMenuCircular($(this).val());
    });
    $('#btnAgregarRequEspe').click(btnAgregarRequEspe);
    $('#btnLimpiarEspe').click(limpiarTodosEspe);
    $('#cmbTramiteEspe').change(function(){
        limpiaTramiteEspe();
        cargaMotivoTramite(fill.combo,"#cmbTramiteEspe",'#cmbMotivoTramiteEspe');
        $('#txtActivP1,#txtIdActivP1').val("");
        $('#txtActivP1').attr('title','');
    });
    armaSeccionOtros();
//    $('#cmbDepartamentoEspe').change(cargarProvincias);
//    $('#cmbProvinciaEspe').change(cargarDistritos);
//    $('#cmbDistritoEspe').change(cargarZonificacion);
}

function armaSeccionOtros(){
    var html="";
    $.each(campos,function(kk,vv){
        if(vv.idAmbitoParametrico.descripcion.toUpperCase()!='REQUISITO' && vv.valores.length>0){
            html+='<div class="ilb">';
            html+='<div class="lblc vam"><label for="cmbPD'+vv.idParametroDinamico+'">'+vv.nombre+':</label></div>';
            
            html+='<div class="slcta vam parametroDinamicoOtros" idparametrodinamico="'+vv.idParametroDinamico+'">'+
                     //'<input type="hidden" class="idParametroDinamicoOtros" value="'+vv.idParametroDinamico+'" />'+
                     '<select id="cmbPD'+vv.idParametroDinamico+'" class="idValorParametroOtros">'+
                        '<option value="">--Seleccione--</option>';
            //se agregan valores de cada parametro dinamico
            //if(vv.valores.length>0){
                $.each(vv.valores,function(kkk,vvv){
                    html+= '<option value="'+vvv.idValorParametro+'" ';
                    if(vvv.valorDefecto=='1'){html+='selected';}//si tiene flag default en 1, se coloca valor por defecto
                    html+= '>'+vvv.valor+'</option>';
                });
            //}               
            html+=   '</select>'+
                  '</div>';
                  
            html+='</div>  ';
        }
    });
    
    $('#parametroDinamicosSeccionOtros').html(html);
}

function cargaMotivoTramite(callback,CmbOrigen,tagDestino){
    var idTramite = $(CmbOrigen).val();
    if(idTramite!=""){
        $.ajax({
            url: baseURL + 'pages/tramite/loadMotivoTramite',
            type: "post",
            async: false,
            data: {
                idTramite: idTramite
            },
            success: function(data) {
                callback(data.filas,'idMotivoTramite','descripcion',tagDestino);
                
                if(data.filas.length>0){
                    $('#filaMotivoTramiteEspe').show();
                }
            },
            error:errorAjax
        });
    }else{
        callback([],'idMotivoTramite','descripcion',tagDestino);
    }
}

function armaCabeceraRequisitosEspe() {
    var html = "<div class='fila'>";
    html += "<div class='desc ilb titu vam' title='DESCRIPCION'>DESCRIPCION</div>";
    html += "<div class='btns tac ilb titu vam' title='ACCIONES'></div>";
    html += "<div class='camp ilb titu come vam' title='COMENTARIO'>COMENTARIO</div>";
    html += "<div class='camp ilb titu tram vam' title='TRÁMITE'>TRÁMITE</div>";
    html += "<div class='camp ilb titu tram vam' title='MOTIVO TRÁMITE'>MOTIVO TRÁMITE</div>";
    html += "<div class='camp ilb titu acti vam' title='RUBRO'>RUBRO</div>";
    html += "<div class='camp ilb titu zoni vam' title='ZONIFICACION'>ZONIFICACIÓN</div>";
    $.each(campos, function(k, v) {
        //html += "<div class='camp ilb titu vam' title='" + v.titulo + "'>" + v.titulo + "</div>";
        html += "<div class='camp ilb titu vam' title='" + v.nombre + "'>" + v.nombre + "</div>";
    });
    html += "</div>";
    $('#headRequEspe').html(html);
}

function abrirPopupBusqActividad() {
    if($('#cmbTramiteEspe').val()==""){
        mensajeGrowl("warn", "Primero debe seleccionar Trámite", "");
        return false;
    }
    
    $.ajax({
        url:baseURL + "pages/commonRequisitos/abrirPopupBusqActividad", 
        type:'get',
        async:false,
        data:{
            seleccion:"multiple",
            idProcedimiento:$('#idProcedimento').val(),
            idTramite:$('#cmbTramiteEspe').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogBusqActividad").html(data);
            $("#dialogBusqActividad").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: "Seleccione Rubro",
                open: function() {
                    if(treeData.length==0){
                        $("#dialogBusqActividad").dialog("close");
                        mensajeGrowl("warn", "Edite el Procedimiento y agrege el Rubro al Trámite", "");
                    }
                }
            });
        },
        error:errorAjax
    });
}

function btnAgregarRequEspe() {
    if(validaBtnAgregarRequEspe()){
        abrirAgregarRequisitos('AGREGAR REQUISITO ESPECIFICO', 'agregarRequisitoEspecifico()', '','','especifico');
    }    
}
function validaBtnAgregarRequEspe(){
    var retorno=true;
    if($('#menuCircularEspe').find('input:checked').length==0){
        mensajeGrowl("warn", "Seleccione algún filtro de Requisito Especifico", "Trámite, Rubro, Zonificación, Otros");
        retorno=false;
    }
    //verifica Tramite
    if($('#chkTramite').attr('checked') && $('#cmbTramiteEspe').val()==""){
        mensajeGrowl("warn", "Seleccione Trámite","");
        retorno=false;
    }
    //actividad1
    if($('#chkActividad').attr('checked') && $('#txtIdActivP1').val()==""){
        mensajeGrowl("warn", "Seleccione Rubro","");
        retorno=false;
    }
    //zonificacion
    if(( $('#chkZonificacion').attr('checked') && $('#cmbZonificacionEspe').val()=="") ){
        mensajeGrowl("warn", "Seleccione Zonificación","");
        return false;
    }
//    if( ($('#chkZonificacion').attr('checked') && $('#idZonificacionDetalleEspe').val()=="") ){
//        mensajeGrowl("warn", "El Distrito seleccionado no tiene Zonificación","");
//        return false;
//    }
    //otros
    if($('#chkOtros').attr('checked')){
        var valida=false;
        $('#parametroDinamicosSeccionOtros').find('select').map(function(){
            if($(this).val()!=""){valida=true;}
        });
        if(!valida){
            mensajeGrowl("warn", "Seleccione algún valor para sección OTROS","");
            retorno=false;
        }
    }
    
    return retorno;
}
function btnAgregarSubRequisitoEspe(idRequProc, txtRequProc) {
    abrirAgregarRequisitos('AGREGAR SUBREQUISITO', 'agregarRequisitoEspecifico()',idRequProc.replace("espeRequProc","") , txtRequProc,'especifico');
}
function agregarRequisitoEspecifico() {
    if($('#requisitosAgregarSeleccionados .fila').length==0){
        mensajeGrowl("warn", "Seleccione agregar requisito", "");
        return false;
    }else{
        confirm.open("¿Ud est&aacute; seguro de Agregar el(los) requisito(s) especifico(s)?","procAgregarRequisitoEspecifico()");
    }
}
function procAgregarRequisitoEspecifico(){
    //ARMANDO NAMES PA FORM
    ////////////////////////
    var cont=0;
    $('#requisitosAgregarSeleccionados .fila').map(function(){
        var obj=this;
        $(obj).children('input.idRequisitoSelec').attr('name','requProcedimiento['+cont+'].idRequisito');
        $(obj).find('input.comentario').attr('name','requProcedimiento['+cont+'].comentario');
        $(obj).find('input.idRequisitoProcedimientoPad').attr('name','requProcedimiento['+cont+'].idRequisitoProcedimientoPad');
        $(obj).find('input.idRequisitoProcedimientoPad').val($('#idRequisitoProcedimientoPad').val());
        $(obj).find('input.flgGeneral').attr('name','requProcedimiento['+cont+'].flgGeneral');
        $(obj).find('input.flgGeneral').val('0');
        
        ///agrega name caso especificos - TRAMITE
        if($('#chkTramite').attr('checked')){
            var html='<input type="hidden" value="'+$('#cmbTramiteEspe').val()+'" class="idTramiteAR" name="requProcedimiento['+cont+'].idTramite">';
            html+='<input type="hidden" value="'+$('#cmbMotivoTramiteEspe').val()+'" class="idMotivoTramiteAR" name="requProcedimiento['+cont+'].idMotivoTramite">';
            $(obj).append(html);
        }
        ///agrega name caso especificos - ZONIFICACION
        if($('#chkZonificacion').attr('checked') && $('#cmbZonificacionEspe').val()!=""){
            var html='<input type="hidden" value="'+$('#cmbZonificacionEspe').val()+'" class="idZonificacionAR" name="requProcedimiento['+cont+'].idZonificacion">';
            $(obj).append(html);
            
        }
        ///agrega names a paramtros dinamicos ambito REQUISITO
        var cont2=0;
        $(obj).find('div.parametroDinamico').map(function(){
            var obj2=this;
            //$(obj2).find('input.idParametroDinamico').attr('name','requProcedimiento['+cont+'].valoresParaDina['+cont2+'].valorParametro.idParametroDinamico')
            $(obj2).find('select.idValorParametro').attr('name','requProcedimiento['+cont+'].valoresParaDina['+cont2+'].valorParametro.idValorParametro')
            cont2++;
        });
        
        ///agrega name caso especificos (parametros dinamicos ambito procedimiento) - OTROS
        if($('#chkOtros').attr('checked')){
            $('#parametroDinamicosSeccionOtros').find('select').map(function(){
                var sel=this;
                if($(sel).val()!=""){
                    var html='<input type="hidden" value="'+$(sel).val()+'" class="idValorParametroAR" name="requProcedimiento['+cont+'].valoresParaDina['+cont2+'].valorParametro.idValorParametro">';
                    $(obj).append(html);
                    cont2++;//continua contador "cont2" de parametros dinamicos XD
                }
            });
        }
      cont++;
    });
    //////////////////////
    ////agrega name caso especificos - ACTIVIDAD
    if($('#chkActividad').attr('checked')){
        var act=$('#txtIdActivP1').val().split(",");
        $.each(act, function(k,v){
            var html='<input type="hidden" value="'+v+'" class="idActividadAR" name="actividades['+k+'].idActividad">';
            $("#frmMantRequProcedimiento").append(html);
        });
    }
    //////////////////////
    //////////////////////
    //return false;
    
    $.ajax({
        url:baseURL + "pages/requisitoProcedimiento/registrarRequisitoProcedimientoEspe",
        type:'post',
        async:false,
        data:$('#frmMantRequProcedimiento').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                buscarRequEspe();
                $('#dialogAgregarRequisito').dialog('close');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function evaluaCheckMenuCircular(nombre) {
    if ($('#chk' + nombre).attr('checked')) {
        $('#cont' + nombre).show('blind', {}, 500);
        //evaluacion para caso dependencia Actividad con Tramite
        if(nombre=="Actividad"){//si activa Actividad, activa y bloquea Tramite
            $('#chkTramite').attr('checked',true).trigger('change').attr('disabled',true);            
        }        
    } else {
        $('#cont' + nombre).hide('blind', {}, 500);
        limpiaOpcionEspe(nombre);
        //evaluacion para caso dependencia Actividad con Tramite
        if(nombre=="Actividad"){//si desactiva Actividad, desbloquea Tramite
            $('#chkTramite').attr('disabled',false);            
        }
    }
}
function evaluaCheckTodoMenuCircular() {
    $('#menuCircularEspe').find('input').map(function() {
        if ($(this).attr('checked')) {
            $('#cont' + $(this).val()).show();
            //evaluacion para caso Tramite disabled
            if($(this).val()=="Tramite" && $(this).attr("disabled")){
                $(this).attr("checked",true);
            }
        } else {
            $('#cont' + $(this).val()).hide();
        }
    });
    //limpiarTodosEspe();
}
function limpiaOpcionEspe(nombre) {
    $('#cont' + nombre).find('input, select').val('');
//    if(nombre=="Zonificacion"){
//        limpiaZonificacionEspe();
//    }
    if(nombre=="Tramite"){
        limpiaTramiteEspe();
    }
}
function limpiarTodosEspe() {
    $('#contenedorOpciones').find('[id^="cont"]').find('input, select').val('');
    $('#contenedorOpciones').find('[id^="cont"]').find('input').attr('title','');
    //zonificacion
//    limpiaZonificacionEspe();
    limpiaTramiteEspe();
}
function armaPermisosSeguridadEsp(){
	var permisos = $('#permisosSeguridad').val();
	var permiso = permisos.split("/");	
	console.log(permiso);
	var existeIn = false;
	var existeEl = false;
	for (var i = 0; i < permiso.length; i++) {
		console.log(permiso[i]);
		if(permiso[i]=="IN"){
			existeIn = true;
		}
		if(permiso[i]=="EL"){
			existeEl = true;
		}
	}	
	console.log(existeIn);
	console.log(existeEl);
	if(!existeIn){
		$('#espeRequ .btns').map(function(){
			$(this).find('span:eq(0)').css('display','none');
		});
	}
	if(!existeEl){
		$('#espeRequ .btns').map(function(){
			$(this).find('span:eq(1)').css('display','none');
		});
	}
}
function armaEspecificosRequisitos(reqEspe) {
    var html = "";
    $.each(reqEspe, function(key, val) {
        if(val.idRequisitoProcedimientoPad=='' || val.idRequisitoProcedimientoPad==null){
            html += "<li nroorden='"+(val.nroOrden!=null?val.nroOrden:"")+"' idrequproc='"+val.idRequisitoProcedimiento+"'>";
            html += "<div class='fila' id='espeRequProc" + val.idRequisitoProcedimiento + "'>";
            html+="<input type='hidden' class='idRequisitoEspe' value='"+val.requisito.idRequisito+"' />";
            html += "<div class='desc ilb vat' title='" + val.requisito.descripcion + "'>" + val.requisito.descripcion + "</div>";

            html += "<div class='btns ilb vat tar'>";
            html += " <span class='ui-icon ui-icon-plusthick' title='AGREGAR SUBREQUISITO'onclick='btnAgregarSubRequisitoEspe(\"espeRequProc" + val.idRequisitoProcedimiento + "\",\"" + val.requisito.descripcion + "\")'></span>" +
                    " <span class='ui-icon ui-icon-closethick' title='ELIMINAR REQUISITO' onclick='btnEliminarRequisito(\"espeRequProc" + val.idRequisitoProcedimiento + "\",\"espe\")'></span>";
            html += "</div>";

            //html += "<div class='camp ilb vat come' title='"+val.comentario+"'>"+val.comentario+"</div>";
            var comentario=val.comentario!=null?val.comentario:"";
            html+="<div class='camp ilb vat come' title='"+comentario+"'>"+comentario+"</div>";
            var tramite=val.descTramite!=null?val.descTramite:"";
            html += "<div class='camp ilb vat tram' title='" + tramite + "'>" + tramite + "</div>";
            var motivoTramite=val.descMotivoTramite!=null?val.descMotivoTramite:"";
            html += "<div class='camp ilb vat tram' title='" + motivoTramite + "'>" + motivoTramite + "</div>";
            var actividad=val.descActividad!=null?val.descActividad:"";
            html += "<div class='camp ilb vat acti' title='" + actividad + "'>" + actividad + "</div>";
            var zonificacion=val.descZonificacion!=null?val.descZonificacion:"";
            html += "<div class='camp ilb vat zoni' title='" + zonificacion + "'>" + zonificacion + "</div>";
            
            var htmlCampos=obtenerCamposValorParaDinaRequEspe(campos,val.valoresParaDina);
            html+=htmlCampos;
            html += "<ul id='sortableEspeRequProc" + val.idRequisitoProcedimiento + "'></ul>";
            html += "</div>";
            html += "</li>";
        }
    });
    $('#sortableEspeRequ').html(html);
    //ingresando hijos 2do nivel
    $.each(reqEspe, function(key, val) {
        if(val.idRequisitoProcedimientoPad!='' && val.idRequisitoProcedimientoPad!=null){
            var html = "<li nroorden='"+(val.nroOrden!=null?val.nroOrden:"")+"' idrequproc='"+val.idRequisitoProcedimiento+"'>";
            html += "<div class='fila sr' id='subRequProc" + val.idRequisitoProcedimiento + "'>";
            html += "<div class='desc ilb vat' title='" + val.requisito.descripcion + "' style='margin-left:10px;width:290px;'>" + val.requisito.descripcion + "</div>";

            html += "<div class='btns ilb vat tar'>";
            //html+=" <span class='ui-icon ui-icon-plusthick' title='AGREGAR SUBREQUISITO'onclick='btnAgregarSubRequisito(\"subRequi"+val.idRequ+"\",\""+val.requisito+"\")'></span>";
            html += " <span></span>";
            html += " <span class='ui-icon ui-icon-closethick' title='ELIMINAR SUBREQUISITO' onclick='btnEliminarRequisito(\"subRequProc"+val.idRequisitoProcedimiento+"\",\"espe\")'></span>";
            html += "</div>";

            var comentario=val.comentario!=null?val.comentario:"";
            html+="<div class='camp ilb vat come' title='"+comentario+"'>"+comentario+"</div>";
            var tramite=val.descTramite!=null?val.descTramite:"";
            html += "<div class='camp ilb vat tram' title='" + tramite + "'>" + tramite + "</div>";
            var motivoTramite=val.descMotivoTramite!=null?val.descMotivoTramite:"";
            html += "<div class='camp ilb vat tram' title='" + motivoTramite + "'>" + motivoTramite + "</div>";
            var actividad=val.descActividad!=null?val.descActividad:"";
            html += "<div class='camp ilb vat acti' title='" + actividad + "'>" + actividad + "</div>";
            var zonificacion=val.descZonificacion!=null?val.descZonificacion:"";
            html += "<div class='camp ilb vat zoni' title='" + zonificacion + "'>" + zonificacion + "</div>";
            
            var htmlCampos=obtenerCamposValorParaDinaRequEspe(campos,val.valoresParaDina);
            html+=htmlCampos;
                        
            html += "</div>";
            html += "</li>";
            $('#sortableEspeRequProc' + val.idRequisitoProcedimientoPad).append(html);
        }
    });
    //activando sortable (arrastrar y soltar)
    $("#sortableEspeRequ").sortable({placeholder: "ui-sortable-highlight"});$("#sortableEspeRequ").disableSelection();
    $( "#sortableEspeRequ" ).sortable({
        update: function( event, ui ) {
            evalOrdenRequisitos('#sortableEspeRequ',buscarRequEspe);
        }
    });
    //sortable pa subrequisitos
    $("ul[id^='sortableEspeRequProc']").sortable({placeholder: "ui-sortable-highlight"});$("ul[id^='sortableEspeRequProc']").disableSelection();
    $( "ul[id^='sortableEspeRequProc']" ).sortable({
        update: function( event, ui ) {evalOrdenRequisitos('#'+$(this).attr('id'),buscarRequEspe);}
    });
    armaPermisosSeguridadEsp();
}

function obtenerCamposValorParaDinaRequEspe(camposx,valoresParaDina){
    var html="";
    $.each(camposx,function(k,regCampo){
        var valorParaDina="";
        if(valoresParaDina.length>0){//si exiten valoresParaDina
            $.each(valoresParaDina,function(kk,regParaDina){
                if(regCampo.idParametroDinamico==regParaDina.valorParametro.idParametroDinamico){
                  valorParaDina=regParaDina.valorParametro.descripcion;
                }
            });    
        }
        html+="<div class='camp ilb vat' title='"+valorParaDina+"'>"+valorParaDina+"</div>";
    });
    return html;
}

//function cargarProvincias(){
//    $("#cmbProvinciaEspe,#cmbDistritoEspe").html("<option value=''>--Seleccione--</option>");//limpia combos q dependen de departamento
//    limpiaZonificacionEspe();
//    
//    $.ajax({
//       url:baseURL + 'pages/ubigeo/listarProvincias',
//       type:'post',
//       async:false,
//       data:{
//           idDepartamento:$('#cmbDepartamentoEspe').val()
//       },
//       success:function(data){
//           if(data.lista!=null){
//               var html="<option value=''>--Seleccione--</option>";
//               $.each(data.lista,function(key,val){
//                   html+="<option value='"+val.idProvincia+"'>"+val.nombre+"</option>";
//               });
//               $('#cmbProvinciaEspe').html(html);
//           }
//       }
//    });
//}
//function cargarDistritos(){
//    $("#cmbDistritoEspe").html("<option value=''>--Seleccione--</option>");//limpia combos q dependen de provincia
//    limpiaZonificacionEspe();
//   
//    $.ajax({
//       url:baseURL + 'pages/ubigeo/listarDistritos',
//       type:'post',
//       async:false,
//       data:{
//           idDepartamento:$('#cmbDepartamentoEspe').val(),
//           idProvincia:$('#cmbProvinciaEspe').val()
//       },
//       success:function(data){
//           if(data.lista!=null){
//               var html="<option value=''>--Seleccione--</option>";
//               $.each(data.lista,function(key,val){
//                   html+="<option value='"+val.idDistrito+"'>"+val.nombre+"</option>";
//               });
//               $('#cmbDistritoEspe').html(html);
//           }
//       }
//    });
//}
//function cargarZonificacion(){
//    limpiaZonificacionEspe();
//    
//    $.ajax({
//             url:baseURL + 'pages/ubigeo/listarZonificacionDetalle',
//        type:'post',
//        async:false,
//        data:{
//            idDepartamento:$('#cmbDepartamentoEspe').val(),
//            idProvincia:$('#cmbProvinciaEspe').val(),
//            idDistrito:$('#cmbDistritoEspe').val()
//        },
//        success:function(data){
//            if(data.lista!=null){
//                var ids="";
//                var spns="";
//                if(data.lista.length>0){
//                    //segun negocio, un distrito, solo puede tener una zonificacion, por lo que cojo [0]
//                    ids+=data.lista[0].idZonificacionDetalle;
//                    spns+=data.lista[0].zonificacion.nombre;
//                    //$('#filaZonificacionEspe').show();
//                    $('#idZonificacionDetalleEspe').val(ids);
//                    $('#spnZonificacionDetalleEspe').html(spns);
//                }
//            }
//        }
//    });
//}
//function limpiaZonificacionEspe(){
//    $('#idZonificacionDetalleEspe').val('');
//    $('#spnZonificacionDetalleEspe').html('<span style="color:#A4A4A4;">--Sin Zonificacion--</span>');
//}
function limpiaTramiteEspe(){
    $('#filaMotivoTramiteEspe').hide();
    fill.clean("#cmbMotivoTramiteEspe");
}
