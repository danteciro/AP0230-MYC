$(function() {
	$('#default').puigrowl();		
	//initArbolActividades([]);	
        buscarTreeDataModal();
});

function buscarTreeDataModal(){
    $.ajax({
        url: baseURL + 'pages/actividadesController/loadActividad',
        type: "post",
        async: false,
        data: {
            idProcedimiento:$('#idProcedimientoActModal').val(),
            idTramite:$('#idTramiteActModal').val()
        },
        beforeSend:muestraLoading,
        success: function(data) {
            ocultaLoading();
            if(data.filas!=null){
                treeData = fxTree.build(data.filas);
            }            
            initArbolActividadesModal(treeData);
        },
        error:errorAjax
    });
}

function initArbolActividadesModal(treeData){
    //ejempl data json para arbol
    /*treeData = [
        {title: "REFINERIA", folder: true, key: "1",
            children: [
                {title: "Refineria Complejas", key: "2" },
                {title: "Refinería Topping", key: "3" }
            ]
        },
        {title: "Planta de Procesamiento", folder: true, key: "4",
            children: [
                {title: "Procesamiento Gas", key: "5" },
                {title: "Procesamiento LGN", key: "6" }
            ]
        },
        {title: "Planta de Lubricante", folder: true, key: "7",
            children: [
                {title: "Planta de Lubricante y Grasas", key: "8" }
            ]
        },
        {title: "Planta de Abastecimiento", folder: true, key: "9",
            children: [
                {title: "Plantas de Abastecimiento de Combustible Líquido y OPDH", key: "10" },
                {title: "Plantas de Abastecimiento de GLP", key: "11" },
                {title: "Plantas de Abastecimiento de Aeropuerto", key: "12" }
            ]
        },
        {title: "Planta Envasadora", folder: true, key: "13",
            children: [
                {title: "Planta Envasadora de GLP", key: "14" }
            ]
        },
        {title: "Terminales", folder: true, key: "15",
            children: [
                {title: "Terminales Combustibles Líquidos", key: "16" },
                {title: "Terminales Fluviales", key: "17" },
                {title: "Terminales GLP", key: "18" },
                {title: "Terminales Maritimos", key: "19" },
                {title: "Terminales OPDH", key: "20" }
            ]
        },
        {title: "Consumidor Directo", folder: true, key: "21",
            children: [
                {title: "Consumidor Directo con Instalaciones Estartégicas de  Combustibles Líquidos y OPDH", key: "22" },
                {title: "Consumidor Directo con Instalaciones Estartégicas Temporales de  Combustibles Líquidos y OPDH", key: "23" },
                {title: "Consumidor Directo de Aviación (Fijo y Movil)", key: "24" },
                {title: "Consumidor Directo de Combustible Líquido con capacidad de 5MB a 50MB", key: "25" },
                {title: "Consumidor Directo de Combustible Líquido con capacidad hasta 5MB", key: "26" },
                {title: "Consumidor Directo de Combustible Líquido con capacidad mayor a 50MB", key: "27" },
                {title: "Consumidor Directo de Combustible Líquido y OPDH  con capacidad hasta 5 MB", key: "28" },
                {title: "Consumidor Directo de OPDH", key: "29" },
                {title: "Consumidor Directo de Petróleo (Fijo y Movil)", key: "30" },
                {title: "Consumidor Directo Especial de Combustible Líquido y OPDH", key: "31" },
                {title: "Consumidor Directo Estratégico", key: "32" },
                {title: "Consumidor Directo Móvil de Combustible Líquido y OPDH", key: "33" }
            ]
        }
    ];*/
    
    /*********/
    var seleccion=$('#arbolActividadesEspeModal').attr('seleccion');
    
    $("#arbolActividadesEspeModal").fancytree({
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
                $('#idActividadesSelecEspeModal').val("["+selKeys.join(",")+"]");
            }            
        },
        click:function(event,data){
            if(seleccion!="multiple"){
                if(data.node.isFolder()){
                    $('#idActividadesSelecEspeModal').val("");
                }else{
                    $('#idActividadesSelecEspeModal').val("[{id:'"+data.node.key+"',nombre:'"+data.node.title+"'}]"); 
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
    $("#arbolActividadesEspeModal").fancytree("getRootNode").visit(function(node) {
        node.setExpanded(true);
    });
}

//POPUP BUSQUEDA DE ACTIVIDAD
$('#btnSeleccionarActModal').click(function() {
    //document.getElementById("txtActivP1").value = document.getElementById("idActividadesSelecEspeModal").value;
    $("#txtActivP1Modal").val('');
    $("#txtActivP1Modal").attr('title', '' );
    $("#txtIdActivP1Modal").val('');
    
    if(document.getElementById("idActividadesSelecEspeModal").value == '' || document.getElementById("idActividadesSelecEspeModal").value == '[]'){
        mensajeGrowl('warning', "Seleccione una Actividad", 'Intente de nuevo');
        return false;
    }else{
        var data=eval("("+$('#idActividadesSelecEspeModal').val()+")");
        $("#txtActivP1Modal").val( $.map(data,function(item){return item.nombre;}).join(', ') );
        $("#txtActivP1Modal").attr('title', $.map(data,function(item){return item.nombre;}).join(', ') );
        $("#txtIdActivP1Modal").val( $.map(data,function(item){return item.id;}).join(',') );
    }
	
    $("#dialogBusqActividadModal").dialog("close");	    
});