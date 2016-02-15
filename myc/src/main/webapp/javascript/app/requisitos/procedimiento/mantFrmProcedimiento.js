$(function(){
    $('#tabsMantProcedimiento').tabs();
    initArbolActividades();
    
    $('#frmMantProcedimiento').validarForm(); 
    $('#cmbCalificacion').change(changeCmbCalificacion);
    $('#cmbEtapa').change(function(){cargaTramite(fillTramiteNuevoProc,"#cmbEtapa",'#tramitesNuevoProc');});
    $('#btnGuardarProc').click(btnGuardarProc);
    $('#btnEditarProc').click(btnEditarProc);
    $('#btnAgregarActividad').click(btnAgregarActividad);
    $('#txtPorcUIT').keyup(calculaUITSoles);
    $('#chkTramGrat').change(verificaTramiteGratuito);
    $('#picklist').puipicklist();
    boton.closeDialog();
    changeCmbCalificacion();
    initMantFrmProcedimiento();
});
function initMantFrmProcedimiento(){
    //EDIT - VIEW
    if($('#tipoP').val()!='new'){
        $('#txtPorcUIT').trigger("keyup");
        $('#cmbEtapa').trigger("change");
        if(idTramites!=""){
            var trams = idTramites.split(",");
            $.each(trams,function(k,v){
                $('#chkT_'+v).attr('checked',true);
            });
        }
        if(idActividades!=""){
            var actis=idActividades.split(",");
            $.each(actis,function(k,v){
              $("#arbolActividades").fancytree("getTree").getNodeByKey(parseInt(v)).setSelected();        
            });
        }
    }
    //ALPHANUM
    //$('#txtItemProc').alphanum(alphaNumOptions);
}
function verificaTramiteGratuito(){
    $('#txtPorcUIT').val("0");
    $('#txtSoles').html("0.00");
    if($('#chkTramGrat').attr('checked')){
        $('#filaDerechoTramitacion').hide();
        $('#txtPorcUIT').removeAttr('validate');
    }else{
        $('#filaDerechoTramitacion').show();
        $('#txtPorcUIT').attr('validate','[O][SNP]');
    }
}
function calculaUITSoles(){
    var txtSoles=parseFloat($('#txtPorcUIT').val()*$('#txtValorUIT').html()/100).toFixed(2);
    txtSoles=(isNaN(txtSoles))?"":txtSoles;
    $('#txtSoles').html(txtSoles);
}
function changeCmbCalificacion(){
    $('#cmbSilencioAdministrativo').hide().val("").attr('validate','');
    if($('#cmbCalificacion').find('option:checked').html()=='EVALUACION PREVIA'){
        $('#cmbSilencioAdministrativo').show().attr('validate','[O]');
        if($('#tipoP').val()=="new"){
            cargaSilencioAdministrativo(fill.comboValorTxt,"#cmbCalificacion",'#cmbSilencioAdministrativo','NEGATIVO');
        }else{
            //console.log(idSileAdmi);
            cargaSilencioAdministrativo(fill.comboValorId,"#cmbCalificacion",'#cmbSilencioAdministrativo',idSileAdmi);
        }
    }
}
function fillTramiteNuevoProc(data,id,desc,tagDestino){
    $(tagDestino).hide();
    var html="";
    if(data.length>0){
        var cont=0;
        $.each(data,function(k,v){
            html+='<div class="lblh contChkA bgA" title="'+v[desc]+'">';
            html+='<div class="ilb vam txtFilaUnic" style="width:88%;">'+v[desc]+'</div>';
            html+='<div class="fr">';
            //html+='<input type="checkbox" value="'+v[id]+'" id="chkT_'+v[id]+'" name="tramites['+cont+'].idTramite">';
            html+='<input type="checkbox" value="'+v[id]+'" id="chkT_'+v[id]+'">';
            html+='<label for="chkT_'+v[id]+'" class="checkbox"></label>';
            html+='</div>';
            html+='</div>';
            cont++;
        });
        $(tagDestino).show();
    }
    $(tagDestino).children('div').eq(1).html(html);
}
function btnAgregarActividad(){
    $('#popupArbolActi').dialog({
        width: 640,height:280,modal:true,
        close: function( event, ui ) {//se destruye popup para evitar conflicto con arbol y seleccionados
            //console.log('cerrando y destruyendo popup');
            $(this).dialog('destroy');
        }
    });
}
function quitarActividadDeAgregar(id,obj){
    $(obj).parent().remove();
    //retirando de arbol actividades
    var nodo=$("#arbolActividades").fancytree("getTree").getNodeByKey(parseInt(id));
    if(nodo==null){
        nodo=$("#arbolActividades").fancytree("getTree").getNodeByKey(String(id));//evitar conflicto pa arboles armados con html (<ul> - <li>)
    }
    //$("#arbolActividades").fancytree("getTree").getNodeByKey(id).setSelected(false);   
    nodo.setSelected(false);   
}
/*ARBOL ACTIVIDADES*/
function initArbolActividades(){
    var treeData=[];
    $.ajax({
        url: baseURL + 'pages/actividadesController/loadActividad',
        type: "post",
        async: false,
        data: {},
        //beforeSend:muestraLoading,
        success: function(data) {
            //ocultaLoading();
            treeData = fxTree.build(data.filas);
        },
        error:errorAjax
    });
    $("#arbolActividades").fancytree({
        checkbox: true,
        selectMode: 3,
        source:treeData,
        select: function(event, data) {
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node){
                if(!node.folder){
                    return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
                }
            });
            agregaActividadDeArbol("["+selKeys.join(",")+"]");
        },
        keydown: function(event, data) {
            if( event.which === 32 ) {
                data.node.toggleSelected();
                return false;
            }
        },
        //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
        //initId: "treeData",
        cookieId: "fancytree-Cb1",
        idPrefix: "fancytree-Cb1-"
    });
    
    $("#arbolActividades").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
}

function agregaActividadDeArbol(datax){
    var data=eval("("+datax+")");
    var html="";
    $.each(data,function(k,v){
        html+='<div id="'+v.id+'" class="fila">';
        html+=' <div class="txtFilaUnic ilb data vam" style="width: 96%">'+v.nombre+'</div>';
        html+=' <input type="checkbox" value="'+v.id+'" checked >';
        if($('#tipoP').val()!="view"){
            html+=' <div onclick="quitarActividadDeAgregar('+v.id+',this)" class="btnQuitar ui-state-default ui-corner-all ilb vam" title="Quitar"><span class="ui-icon ui-icon-closethick"></span></div>';
        }
        html+='</div>';
    });
    $('#idActividadesAgregarSelect').html(html);
}