$(function() {
	$('#default').puigrowl();		
	//initArbolDistritos([]);	
    buscarTreeDataSancAdm();
});

function buscarTreeDataSancAdm(){
    $.ajax({
        url: baseURL + 'pages/tipoSancion/listarTipoSancion',
        type: "post",
        async: false,
        data: {
            estado:"1"
        },
        beforeSend:muestraLoading,
        success: function(data) {
            ocultaLoading();
            if(data.lista!=null){
            	treeData = fxTreeSancAdm.build(data.lista);
            }            
            initArbolSancionAdministrativa(treeData);
        },
        error:errorAjax
    });
}

function initArbolSancionAdministrativa(treeData){
       
    /*********/
    var seleccion=$('#arbolSancAdmEspe').attr('seleccion');
    
    $("#arbolSancAdmEspe").fancytree({
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
                $('#idSancAdmSelecEspe').val("["+selKeys.join(",")+"]");
            }            
        },
        click:function(event,data){
            if(seleccion!="multiple"){
                if(data.node.isFolder()){
                    $('#idSancAdmSelecEspe').val("");
                }else{
                    $('#idSancAdmSelecEspe').val("[{id:'"+data.node.key+"',nombre:'"+data.node.title+"'}]"); 
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
    $("#arbolSancAdmEspe").fancytree("getRootNode").visit(function(node) {
        node.setExpanded(true);
    });
}

//POPUP BUSQUEDA DE DistrIDAD
$('#btnSeleccionarSancAdm').click(function() {
    //document.getElementById("txtDistrP1").value = document.getElementById("idDistritosSelecEspe").value;
    $("#txtDistrP1").val('');
    $("#txtDistrP1").attr('title', '' );
    $("#txtIdDistrP1").val('');
    
    if(document.getElementById("idSancAdmSelecEspe").value == '' || document.getElementById("idSancAdmSelecEspe").value == '[]'){
        mensajeGrowl('warning', "Seleccione una Sancion Administrativa", 'Intente de nuevo');
        return false;
    }else{
        var data=eval("("+$('#idSancAdmSelecEspe').val()+")");
        $("#txtSancAdmP1").val( $.map(data,function(item){return item.nombre;}).join(', ') );
        $("#txtSancAdmP1").attr('title', $.map(data,function(item){return item.nombre;}).join(', ') );
        $("#txtIdSandAdmP1").val( $.map(data,function(item){return item.id;}).join(',') );
        $("#txtJsonSancAdmP1").val($('#idSancAdmSelecEspe').val());
        idTipiSanc=$.map(data,function(item){return item.id;}).join(',');
    }
	
    $("#dialogBusqSancAdm").dialog("close");	    
});