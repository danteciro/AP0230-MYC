var arbolActividades= (function(){
function initArbolActividades(){
    $("#divArbolActividades").fancytree({
        checkbox: true,
        selectMode: 3,
        //source:treeData,
        select: function(event, data) {
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node){
                if(!node.folder){
                    return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
                }
            });
            
        var selRootNodes = data.tree.getSelectedNodes(true);
        var selRootKeys = $.map(selRootNodes, function(node){
            return node.key;
        });
        
        $("#listActividades").val(selRootKeys.join(", "));
          
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
    
    $("#divArbolActividades").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
    
}
function initInicio(){
 $('#botoSeleccionarArbolActividades').click(function(){
     $('#txtActividadesBusquedaAvanzadaBaseLegal').val($('#listActividades').val());
     $('#txtActividadesMantenimientoBaseLegal').val($('#listActividades').val());
     $('#txtActBaseLegal').val($('#listActividades').val());
     $('#dialogArbolActividades').dialog('close');
     
 });
 $('#dialogArbolActividades').dialog({
        resizable: false,
        draggable: false,
        autoOpen: true,
        height: "auto",
	width: "auto",
        dialogClass: 'dialogNuevo',
        modal: true,
        close: function( event, ui ) {
            $(this).dialog("destroy");
            $(this).remove();
            }	
	});	
    
}
return{
    initInicio:initInicio,
    initArbolActividades:initArbolActividades
};
})
();
$(function() {
    arbolActividades.initInicio();
    arbolActividades.initArbolActividades();
   
  
});
