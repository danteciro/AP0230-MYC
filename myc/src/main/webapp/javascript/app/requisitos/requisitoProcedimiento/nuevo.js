var constanteModifico = false;
var constanteObj;
var campos = [];
var requisito=[];

$(function() {
    acordeon();
    initInicioRequProc();
    buscarParametrosDinamicos();//pa campos[] y otros
    $('#txtComentarioRequ').alphanum({
                allowNumeric  : true,
                allowLatin    : true,
                allowUpper    : true,
                allowLower    : true,
                allowCaseless : true,
                allowOtherCharSets : true,
                allowSpace    : true,
                allow         : '!@#$%^&*()+=[]\\\;,/{}|":<>?~`.- _'
        });
});

//REORDENAMIENTO REQUISITOS - INICIO
function evalOrdenRequisitos(id_sortable,callback){
    var contador=0;
    var regModificar="";
    regModificar=$(id_sortable).children('li').map(function(){
      contador++;
      if(contador!=$(this).attr('nroorden')){
        return $(this).attr('idrequproc')+"-"+contador;
      }
    }).get().join('/');
    
    if(regModificar!=""){
        actualizarOrdenRequisitos(regModificar,callback);
    }
}
function actualizarOrdenRequisitos(regModificar,callback){
    $.ajax({
        url:baseURL + "pages/requisitoProcedimiento/actualizarOrdenRequProc", 
        type:'post',
        async:false,
        data:{
            regModificar:regModificar
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            callback();
        },
        error:errorAjax
    });   
}
//REORDENAMIENTO REQUISITOS - FIN


function buscarParametrosDinamicos(){
    $.ajax({
        url:baseURL + "pages/parametro/listarParametrosValores", 
        type:'get',
        async:false,
        data:{
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            campos=data.filas;
        },
        error:errorAjax
    });
}

function initInicioRequProc() {
    $('#btnRegresar').click(function() {
        //window.location.href = baseURL + 'pages/requisitoProcedimiento';
        window.location.href = baseURL + 'pages/procedimiento';
    });
    confirm.start();
    $('#dialogComentarioRequ').dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    var id = "form.tab";
    $(id + ' select,' + id + ' input,' + id + ' textarea').each(
            function(index) {
                $(this).on({
                    change: function(e) {
                        constanteModifico = true;
                    }
                });
            }
    );
}
function openDialogComentarioRequ(obj) {
    $('#txtComentarioRequ').val($(obj).val());
    $('#btnAsignarComentarioRequ').unbind("click");
    $('#btnAsignarComentarioRequ').bind("click",function() {
        $('#requisitosAgregarSeleccionados #' + $(obj).attr('id')).val($('#txtComentarioRequ').val());
        $('#requisitosAgregarSeleccionados #' + $(obj).attr('id')).attr('title',($('#txtComentarioRequ').val()));
        $('#dialogComentarioRequ').dialog('close');
    })
    $('#dialogComentarioRequ').dialog('open');
}

/*function agregarSubRequisito(idReque) {
    if ($('#requisitosAgregar').find('input[type="checkbox"]:checked').length == 0) {
        mensajeGrowl("warn", "Seleccione Requisitos a Agregar", "");
        return false;
    }
    mensajeGrowl("success", "Se registró correctamente", "");
    $('#dialogAgregarRequisito').dialog('close');
}*/
function btnEliminarRequisito(idRequ,tipo) {
    if($('#'+idRequ).children('div.sr').length>0){
        mensajeGrowl("warn", "No se puede eliminar Requisito porque contiene SubRequisitos", "Por favor primero elimine los SubRequisitos");
        return false;
    }else if( tipo=='gral' && $('.idRequisitoGral').length==1 && $('.idRequisitoEspe').length>0 ){
        mensajeGrowl("warn", "No se puede eliminar Requisito porque existen Requisitos Específicos", "Por favor primero elimine los Requisitos Específicos");
        return false;
    }else{
        confirm.open("¿Ud est&aacute; seguro de Eliminar este Requisito?","procEliminarRequisito('"+idRequ+"','"+tipo+"')");
    }
}
function procEliminarRequisito(idRequ,tipo) {
    $.ajax({
        url:baseURL + "pages/requisitoProcedimiento/eliminarRequisitoProcedimiento",
        type:'post',
        async:false,
        data:{
            idRequisitoProcedimiento:idRequ.replace("gralRequProc","").replace("subRequProc","").replace("espeRequProc","")
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.delete, "");
                if(tipo=="gral"){
                    buscarRequGral();
                }else{
                    buscarRequEspe();
                }
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

////////DIALOG AGREGA REQUISITOS/////////
function abrirAgregarRequisitos(title, fxBtn, idRequProcPad, txtRequProcPadx,tipo) {
    $.ajax({
        url: baseURL + "pages/requisitoProcedimiento/abrirAgregarRequisito",
        type: 'get',
        async: false,
        data: {
            idProcedimiento:$('#idProcedimento').val(),
            idRequisitoProcedimientoPad:idRequProcPad,
            txtRequProcPad:txtRequProcPadx,
            tipoRequisito:tipo
        },
        beforeSend: muestraLoading,
        success: function(data) {
            ocultaLoading();
            $("#dialogAgregarRequisito").html(data);
            $("#dialogAgregarRequisito").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height: "auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: title
            });
            $('#btnAgregarRequ').attr('onclick', fxBtn);
            if (txtRequProcPadx != undefined && txtRequProcPadx != '') {
                $('#filaRequisitoPadre').show();
                $('#lblRequisitoPadre').html(txtRequProcPadx);
            }
        },
        error: errorAjax
    });
}
function busqSensitivaRequisitos(txt,callback){
    var pal=txt.split(" ");
    if($.trim(txt)!="" && pal[1]!=undefined){
        callback();
    }
}
/////////////////

function acordeon() {
    $('#steps li').click(function() {
        $('#steps li').removeClass('active');
        if (!$(this).hasClass("disabled")) {
            /*if (constanteModifico) {
             $("#dialogConfirmacionCambio").dialog("open");
             constanteObj = $(this);
             return;
             }*/
            $(this).addClass('active');
            $('#form_registro section.toggle').removeClass('active');
            $('#form_registro section.toggle').hide();
            $('#form_registro section[data-step="' + $(this).attr('data-step') + '"]').addClass('active');
            $('#form_registro section[data-step="' + $(this).attr('data-step') + '"]').show();
        }
    });
    $('#form_registro .continue').click(function() {
        $('#form_registro section.toggle').removeClass('active');
        $('#form_registro section[data-step="' + $(this).attr('data-step') + '"]').addClass('active');
        $('#steps li').removeClass('active');
        $('li[data-step="' + $(this).attr('data-step') + '"]').addClass('active');
        $('body').scrollTop($('#step_' + $(this).attr('data-step')).offset().top);
    });
}