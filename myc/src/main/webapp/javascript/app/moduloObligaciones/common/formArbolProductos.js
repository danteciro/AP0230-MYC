var arbolProductos= (function(){
function initArbolProductos(){
    $("#divArbolProductos").fancytree({
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
        
        $("#listProductos").val(selRootKeys.join(", "));    
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
    
    $("#divArbolProductos").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
    
}
function initInicio(){
 $('#botoSeleccionarArbolProductos').click(function(){
     $('#txtProductosBusquedaAvanzadaBaseLegal').val($('#listProductos').val());
     $('#txtProductosMantenimientoBaseLegal').val($('#listProductos').val());
     $('#txtProBaseLegal').val($('#listProductos').val());
     $('#txtProductosObligacion').val($('#listProductos').val());
     $('#dialogArbolProductos').dialog('close');
 });
 
 $('#dialogArbolProductos').dialog({
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
    initArbolProductos:initArbolProductos
};
})
();
$(function() {
    arbolProductos.initInicio();
    arbolProductos.initArbolProductos();
    
  
});