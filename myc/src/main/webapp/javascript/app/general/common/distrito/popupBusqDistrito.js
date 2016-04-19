$(function() {
	$('#default').puigrowl();		
	//initArbolDistritos([]);	
    buscarTreeDataDis();
});

function buscarTreeDataDis(){
    $.ajax({
//        url: baseURL + 'pages/ubigeo/listarDistritos',
//        url: baseURL + 'pages/ubigeo/listarDistritosUnicos',
        url: baseURL + "pages/zonificacionDetalle/listarDistritosUnicos",
        type: "post",
        async: false,
        data: {
            idZonificacion:$('#idZonificacion').val(),
            idDepartamento:$('#idDepartamento').val(),
            idProvincia:$('#idProvincia').val()
        },
        beforeSend:muestraLoading,
        success: function(data) {
            ocultaLoading();
            if(data.lista!=null){
            	treeData = fxTreeDistrito.build(data.lista);
            }            
            initArbolDistritos(treeData);
        },
        error:errorAjax
    });
}

function initArbolDistritos(treeData){
       
    /*********/
    var seleccion=$('#arbolDistritosEspe').attr('seleccion');
    
    $("#arbolDistritosEspe").fancytree({
        checkbox: (seleccion=="multiple")?true:false,
        selectMode: (seleccion=="multiple")?3:1,
        source:treeData,
        select: function(event, data) {
            if(seleccion=="multiple"){
                var selKeys = $.map(data.tree.getSelectedNodes(), function(node){
                    if(!node.folder){
                        return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
                    }
                });
                $('#idDistritosSelecEspe').val("["+selKeys.join(",")+"]");
            }            
        },
        click:function(event,data){
            if(seleccion!="multiple"){
                if(data.node.isFolder()){
                    $('#idDistritosSelecEspe').val("");
                }else{
                    $('#idDistritosSelecEspe').val("[{id:'"+data.node.key+"',nombre:'"+data.node.title+"'}]"); 
                }
            }            
        },
        keydown: function(event, data) {
            if(seleccion=="multiple"){
                if( event.which === 32 ) {
                    data.node.toggleSelected();
                    return false;
                }
            }
        },
        cookieId: "fancytree-Cb1",
        idPrefix: "fancytree-Cb1-"
    });
    $("#arbolDistritosEspe").fancytree("getRootNode").visit(function(node) {
        node.setExpanded(true);
    });
}

//POPUP BUSQUEDA DE DistrIDAD
$('#btnSeleccionarDist').click(function() {
    //document.getElementById("txtDistrP1").value = document.getElementById("idDistritosSelecEspe").value;
    $("#txtDistrP1").val('');
    $("#txtDistrP1").attr('title', '' );
    $("#txtIdDistrP1").val('');
    
    if(document.getElementById("idDistritosSelecEspe").value == '' || document.getElementById("idDistritosSelecEspe").value == '[]'){
        mensajeGrowl('warning', "Seleccione un Distrito", 'Intente de nuevo');
        return false;
    }else{
        var data=eval("("+$('#idDistritosSelecEspe').val()+")");
        $("#txtDistrP1").val( $.map(data,function(item){return item.nombre;}).join(', ') );
        $("#txtDistrP1").attr('title', $.map(data,function(item){return item.nombre;}).join(', ') );
        $("#txtIdDistrP1").val( $.map(data,function(item){return item.id;}).join(',') );
        $("#txtJsonDistrP1").val($('#idDistritosSelecEspe').val());
    }
	
    $("#dialogBusqDistrito").dialog("close");	    
});