$(function(){
    $('#tabsMantProcedimiento').tabs();
    initArbolActividadesEdit();
    initArbolOpciones();
    $('#btnEditarRubroOpcion').click(btnEditarRubroOpcion);
    $('#btnAgregarActividad').click(btnAgregarActividad);
    $('#btnAgregarOpciones').click(btnAgregarOpcion);
    boton.closeDialog();
    initMantFrmProcedimiento();
    
});

function initMantFrmProcedimiento(){
	
    //EDIT - VIEW
    if($('#tipoP').val()!='new'){
        if(idActividades!=""){
            var actis=idActividades.split(",");
            $.each(actis,function(k,v){
              $("#arbolActividadesEdit").fancytree("getTree").getNodeByKey(parseInt(v)).setSelected();        
            });
        }
        
        if(idOpciones!=""){
            var opcio=idOpciones.split(",");
            $.each(opcio,function(k,v){
              $("#arbolOpcionesEdit").fancytree("getTree").getNodeByKey(parseInt(v)).setSelected();        
            });
        }
    }
    //ALPHANUM
    $('#txtItemProc').alphanum(alphaNumOptions);
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

function btnAgregarOpcion(){
    $('#popupArbolOpciones').dialog({
        width: 640,height:280,modal:true,
        close: function( event, ui ) {//se destruye popup para evitar conflicto con arbol y seleccionados
            //console.log('cerrando y destruyendo popup');
            $(this).dialog('destroy');
        }
    });
}

function quitarOpcionDeAgregar(id,obj){
    $(obj).parent().remove();
    //retirando de arbol actividades
    var nodo=$("#arbolOpcionesEdit").fancytree("getTree").getNodeByKey(parseInt(id));
    if(nodo==null){
        nodo=$("#arbolOpcionesEdit").fancytree("getTree").getNodeByKey(String(id));//evitar conflicto pa arboles armados con html (<ul> - <li>)
    }
    //$("#arbolActividades").fancytree("getTree").getNodeByKey(id).setSelected(false);   
    nodo.setSelected(false);   
}
/*ARBOL ACTIVIDADES*/
function initArbolActividadesEdit(){
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
    $("#arbolActividadesEdit").fancytree({
        checkbox: true,
        selectMode: 1,
        source:treeData,
        select: function(event, data) {
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node){
                if(!node.folder){
                	$("#optRubro").val(node.key);
                    $("#optRubro").text(node.title);
                    return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
                }
            });
//            agregaActividadDeArbol("["+selKeys.join(",")+"]");
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
    
    $("#arbolActividadesEdit").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
}

function agregaOpcionDeArbol(datax, idOpcionTipoSuper){
    var data=eval("("+datax+")");
    var html="";
    $.each(data,function(k,v){
        html+='<div id="'+v.id+'" class="fila">';
        html+=' <div class="txtFilaUnic ilb data vam" style="width: 96%">'+v.nombre+'</div>';
        html+=' <input type="checkbox" value="'+v.id+'" checked >';
        if($('#tipoP').val()!="view" && v.id != idOpcionTipoSuper){
            html+=' <div onclick="quitarOpcionDeAgregar('+v.id+',this)" class="btnQuitar ui-state-default ui-corner-all ilb vam" title="Quitar"><span class="ui-icon ui-icon-closethick"></span></div>';
        }
        html+='</div>';
    });
    $('#idOpcionesAgregarSelect').html(html);
}

/*ARBOL OPCIONES*/
function initArbolOpciones(){
    var treeData=[];
    var idOpcion='';
    $.ajax({
        url: baseURL + 'pages/rubroOpcion/loadOpciones',
        type: "post",
        async: false,
        data: {},
        //beforeSend:muestraLoading,
        success: function(data) {
            //ocultaLoading();
            treeData = fxTreeOpciones.build(data.filas);
            idOpcion= data.idOpcionTipoSuperv;
            
        },
        error:errorAjax
    });
    $("#arbolOpcionesEdit").fancytree({
        checkbox: true,
        source:treeData,
        select: function(event, data) {
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node){
                    return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
            });
            agregaOpcionDeArbol("["+selKeys.join(",")+"]", idOpcion);
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
    
    if(idOpcion!='' && idOpcion!=undefined && parseInt(idOpcion)>0){
        var nodo=$("#arbolOpcionesEdit").fancytree("getTree").getNodeByKey(parseInt(idOpcion));
        nodo.setSelected(true);
        nodo.unselectable = true;
    }

    
    $("#arbolOpcionesEdit").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
}
