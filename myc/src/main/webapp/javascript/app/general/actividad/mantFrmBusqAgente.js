$(function() {
    boton.closeDialog();
    
    $('#txtAgente').alphanum(constant.valida.alphanum.nombre);
    $("#txtAgenteOrden").numeric(onlyNumericOptions);
    $("#txtAgenteOrden").keyup(function(){ if($("#txtAgenteOrden").val()==0) $("#txtAgenteOrden").val(''); });
    procesarGridAgente(0);
    
    initFrmBusqAgente();
});
function initFrmBusqAgente(){
	$('#btnBuscarAgente').click(function(){procesarGridAgente();});
	$('#btnNuevoAgente').click(function(){abrirMantAgente("nuevo",'','');});
}

function abrirMantAgente(tipo,rowid,idGrid){
	var idActividad=-1;
	var codigo='';
	var nombre='';
	var orden=-1;
	switch (tipo){
	    case "nuevo" :
	        title="NUEVO AGENTE";break;
	    case "editar" :
	        title="EDITAR AGENTE";
	        var row=$('#'+idGrid).jqGrid("getRowData",rowid);
	        idActividad=row['idActividad'];
	        codigo=row['codigo'];
	    	orden=row['orden'];
	    	nombre=row['nombre'];
	        break;
	    default :
	        title="";break;
	}
	$.ajax({
        url:baseURL + "pages/mantenimientoActividad/abrirMantFrmAgente", 
        type:'post',
        async:false,
        data:{
        	tipo: tipo, 
        	idActividadPadre: $('#idActividadPadre').val(), 
        	nombrePadre: $('#txtActividadBusq').val(),
        	idActividad:idActividad,
        	codigo:codigo,
        	orden:orden,
        	nombre:nombre        	      	
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantAgentes").html(data);
            $("#dialogMantAgentes").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                position: ['center', 'top+30'],
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
        },
        error:errorAjax
    });
}

function procesarGridAgente(flg_load){
    if(flg_load==undefined){flg_load=1;}
    
    $("#gridContenedorAgente").html("");
    var grid = $("<table>", {
        "id": "gridAgente"
    });
    var pager = $("<div>", {
        "id": "paginacionAgente"
    });
    $("#gridContenedorAgente").append(grid).append(pager);

    var nombres = ['idActividadPadre','idActividad','nombre','codigo','Orden','Agente'];
    var columnas = [
        {name: "idActividadPadre",width: 20,sortable: false,align: "center",hidden:true},
        {name: "idActividad",width: 20,sortable: false,align: "center",hidden:true},
        {name: "nombre",width: 160,sortable: false,align: "left",hidden:true},
        {name: "codigo",width: 20,sortable: false,align: "center",hidden:true},
        {name: "orden",width: 60,sortable: false,align: "center",hidden:false},
        {name: "nombreAgente",width: 420,sortable: false,align: "left",formatter:"agente"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoActividad/findAgente",
        datatype: "json",
        postData: {
        	idActividadPadre:$('#idActividadPadre').val(),
            nombre:$('#txtAgente').val(),
            orden:$('#txtAgenteOrden').val(),
            flg_load:flg_load
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionAgente",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Agentes",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idActividad"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {        	
        	var row=$('#'+"gridAgente").jqGrid("getRowData",rowid);        
            $('.pui-menuitem #linkEditarAgente, #linkEditarAgente').attr('onClick', 'abrirMantAgente("editar","'+rowid+'","gridAgente")');
            $('.pui-menuitem #linkEliminarAgente, #linkEliminarAgente').attr('onClick', 'eliminarAgente("'+rowid+'")');
            
            if($('#divEnlaceTagEditarAgente input').html()!=null){
                $('#contextMenuAgente li a[value="MO-AGENTE"]').html($('#divEnlaceTagEditarAgente').html());
             } else {  
                $('#contextMenuAgente li a[value="MO-AGENTE"]').remove();
             }
            
            if($('#divEnlaceTagEliminarAgente input').html()!=null){
                $('#contextMenuAgente li a[value="EL-AGENTE"]').html($('#divEnlaceTagEliminarAgente').html());
             } else {  
                $('#contextMenuAgente li a[value="EL-AGENTE"]').remove();
             }
            
            
        },
        loadComplete: function(data) {
            $('#contextMenuAgente').parent().css('opacity',1);
            $('#contextMenuAgente').parent().remove();
            $('#divContextMenuAgente').html("<ul id='contextMenuAgente'>"
                    + "<li> <a value='MO-AGENTE'></a></li>"
                    + "<li> <a value='EL-AGENTE'></a></li>"
                    + "</ul>");            
            if($('#divEnlaceTagEditarAgente input').html()!=null || 
               $('#divEnlaceTagEliminarAgente input').html()!=null){
            	$('#contextMenuAgente').puicontextmenu({
                    target: $('#gridAgente')
                });
            }else{
            	$('#divContextMenuAgente').hide();
            }            
        },
    });
}

function eliminarAgente(rowid){
    var row = $('#gridAgente').jqGrid('getRowData', rowid);
    confirm.open("¿Ud. est&aacute; seguro de eliminar este registro?","procEliminarAgente('"+rowid+"')");
}


function procEliminarAgente(rowid){
	var row = $('#gridAgente').jqGrid('getRowData', rowid);
    $.ajax({
        url:baseURL + "pages/mantenimientoActividad/eliminarActividad",
        type:'post',
        async:false,
        data:{
        	idActividad: row['idActividad']
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridAgente();
            } else {
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

jQuery.extend($.fn.fmatter, {
    agente: function(cellvalue, options, rowdata) {
        var codigo=$.trim(rowdata.codigo);
        var nombre=$.trim(rowdata.nombre);
        var html = '';
        if (codigo != null && codigo != '' && codigo != undefined &&
        		nombre != null && nombre != '' && nombre != undefined){       
            html=codigo+' - '+nombre;
        }
        return html;
    }
});

