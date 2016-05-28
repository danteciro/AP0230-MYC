$(function() {
    boton.closeDialog();
    buscarRequisito();
    $('#txtNombreBusq').on({
        keyup: function(e) {
            busqSensitivaRequisitos($(this).val(),armarGrillaAgreRequ);    
        }
    });
    $('#btnBuscarRequ').click(armarGrillaAgreRequ);
    armarGrillaRequSelecHead();
    anularEnter();
});

function buscarRequisito(){
    $.ajax({
        url:baseURL + "pages/requisito/consultarRequisito", 
        type:'get',
        async:false,
        data:{
            descripcion:"",
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            requisito=data.filas;
        },
        error:errorAjax
    });
}

function armarGrillaAgreRequ(){
    //HEAD
    $('#requisitosAgregar').html("");
    var html="";
    //CUERPO
    $.each(requisito,function(k,v){
        //se verifica q sea distinto de los requisitos generales
        if(validaMostrarRequisito( v.idRequisito,$('#tipoRequisito').val(),$('#idRequisitoProcedimientoPad').val() )){
            //se compara texto escrito (txtNombreBusq) con cada requisito
            if( v['descripcion'].toUpperCase().indexOf( $.trim($('#txtNombreBusq').val()).toUpperCase() )!='-1' || $('#txtNombreBusq').val()=='' ){
                var descripcionFinal=fxTxt.resaltar(v['descripcion'],$('#txtNombreBusq').val());
                html += '<div class="fila">'+
                           '<div class="ilb requ vam tal" style="width:98%;">'+descripcionFinal+'</div>';
                html +=    "<div class='btns ilb vam tar'><span onclick='agregaRequisito(this);' idRequisito='"+v.idRequisito+"' comentario='"+v.comentarioPredeterminado+"' title='AGREGAR REQUISITO' class='ui-icon ui-icon-plusthick button' style='margin:1px;'></span></div>";
                html += '</div>';
            }
        }
    });    
    $('#requisitosAgregar').html(html);
}
function validaMostrarRequisito(idRequisito,tipoRequisitoAgregar,idRequisitoProcPad){
    var valida=true;
    var esSubRequ=(idRequisitoProcPad!=null && idRequisitoProcPad!="")?true:false;
    switch (tipoRequisitoAgregar){
        case 'especifico':
            $('.idRequisitoGral').map(function(){
                if(idRequisito==$(this).val()){valida=false;}
            });
        break;
        
        case 'general':
            //valida contra requisitos ya INSERTADOS (insertados en bd)
            if(esSubRequ){
                $('#gralRequProc'+idRequisitoProcPad).find('.idSubRequisitoGral').map(function(){
                    if(idRequisito==$(this).val()){valida=false;}
                });                
            }else{
                $('.idRequisitoGral').map(function(){
                    if(idRequisito==$(this).val()){valida=false;}
                });
            }
            //valida contra requisitos ya SELECCIONADOS (seleccionados en popup)
            $('.idRequisitoSelec').map(function(){
                if(idRequisito==$(this).val()){valida=false;}
            });
        break;
        
        default:
            console.log("tipoRequisito no reconocido");
    }
    return valida;
}
function agregaRequisito(obj){
    var requisitoReg=[
        {idRequisito:$(obj).attr("idRequisito"),descripcion:$(obj).parent().parent().children('div').eq(0).html(),comentarioPredeterminado:$(obj).attr("comentario")}
    ];
    armarGrillaRequSelec(requisitoReg);
    $(obj).parent().parent().remove();
}
function armarGrillaRequSelecHead(){
    //HEAD
    var html='<div class="head">'+
        '<div class="ilb requ vam">REQUISITO</div>'+
        '<div class="ilb come vam">COMENTARIO</div>';
    //cabecera campos parametros dinamicos
    $.each(campos,function(k,v){
        if(v.idAmbitoParametrico.descripcion.toUpperCase()=='REQUISITO' && v.valores.length>0){
            html+='<div class="ilb para vam">'+v.nombre+'</div>';
        }        
    });
    html+='<div class="ilb sele vam"></div>'+
    '</div>';
    $('#requisitosAgregarSeleccionados').html(html);
}
function armarGrillaRequSelec(requisitoReg){
    //CUERPO
    var html="";
    $.each(requisitoReg,function(k,v){
        var comentarioPredeterminado=(v['comentarioPredeterminado']=='null' || v['comentarioPredeterminado']==null)?"":v['comentarioPredeterminado'];
        //se agrega campos fijos (requisito, comentario)
        html+='<div class="fila" idrequisito="'+v.idRequisito+'">'+
                 '<input type="hidden" class="idRequisitoSelec" value="'+v.idRequisito+'" />'+
                 '<input type="hidden" class="idRequisitoProcedimientoPad" />'+ 
                 '<input type="hidden" class="flgGeneral" />'+
                 '<div class="ilb requ vam tal" style="font-size:0.9em;">'+v.descripcion+'</div>'+
                 '<div class="ilb come vam">'+
                    '<input type="text" class="comentario" id="come'+v.idRequisito+'" onkeypress="openDialogComentarioRequ(this);return false;" '+
                        "onclick='openDialogComentarioRequ(this)' value='"+comentarioPredeterminado+"' title='"+comentarioPredeterminado+"' >"+
                 '</div>';
        //se agrega campos de parametros dinamicos
        $.each(campos,function(kk,vv){
            if(vv.idAmbitoParametrico.descripcion.toUpperCase()=='REQUISITO' && vv.valores.length>0){
                html+='<div class="ilb para vam parametroDinamico" idparametrodinamico="'+vv.idParametroDinamico+'">'+
                         //'<input type="hidden" class="idParametroDinamico" value="'+vv.idParametroDinamico+'" />'+
                         '<select class="idValorParametro">';
//                            '<option value="">--Seleccione--</option>';
                //se agregan valores de cada parametro dinamico
                //if(vv.valores.length>0){
                    $.each(vv.valores,function(kkk,vvv){
                        html+=  '<option value="'+vvv.idValorParametro+'" ';
                        if(vvv.valorDefecto=='1'){html+='selected';}//si tiene flag default en 1, se coloca valor por defecto
                        html+=  '>'+vvv.valor+'</option>';
                    });
                //}               
                html+=   '</select>'+
                      '</div>';
            }
        });
        html += "<div class='btns sele ilb vam tar'>"+
                    "<span class='ui-icon ui-icon-closethick button' title='QUITAR REQUISITO' onclick='$(this).parent().parent().remove();' style='margin:1px;'></span>"+
                "</div>";
        html+='</div>';
    });
    $('#requisitosAgregarSeleccionados').append(html);
}