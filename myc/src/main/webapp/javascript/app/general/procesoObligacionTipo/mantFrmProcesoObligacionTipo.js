$(function(){
    anularEnter();
    initArbolActividades();
    $('#btnAgregarActividad').click(btnAgregarActividad);
    $('#btnNuevaObligacionTipo').click( function(){
    	abrirNuevoObligacionTipo('new');
    });
    $('#btnGuardarProcesoObliTipo').click(btnGuardarProcesoObliTipo);
    $('#btnEditarProcesoObliTipo').click(btnEditarProcesoObliTipo);
    
    boton.closeDialog();
    
    if(idActividades!=""){
        var actis=idActividades.split(",");
        $.each(actis,function(k,v){
          $("#arbolActividades").fancytree("getTree").getNodeByKey(parseInt(v)).setSelected();        
        });
    }
});

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
    var selectMode=($('#tipoP').val()=="new")?3:1
    $("#arbolActividades").fancytree({
        checkbox: true,
        selectMode: selectMode,
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
        cookieId: "fancytree-Cb2",
        idPrefix: "fancytree-Cb2-"
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


function abrirNuevoObligacionTipo(tipo){
    
   title="NUEVO OBLIGACION TIPO"; 
      
    $.ajax({
        url:baseURL + "pages/obligacionTipo/abrirMantNuevoObligacionTipo", 
        type:'get',
        async:false,
        data:{
            tipo:tipo
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogNuevoObligacionTipo").html(data);
            $("#dialogNuevoObligacionTipo").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "550px",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText:"Cerrar",
                close: function( event, ui ) {
                    $(this).dialog('destroy');
                }
            });
          
            
        },
        error:errorAjax
    });
}