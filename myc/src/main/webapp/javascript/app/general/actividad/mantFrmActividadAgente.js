$(function() {
    boton.closeDialog();
    //$('#btnEditarMaesColu').click(btnEditarMaesColu);
    //$('#btnGuardarMaesColu').click(btnGuardarMaesColu);
    
    $('#txtActividad').alphanum(constant.valida.alphanum.nombre);
    $('#txtOrden').alphanum(constant.valida.alphanum.orden);
    procesarGridActividad(0);
    
    initFrmActividadAgente();
});
function initFrmActividadAgente(){
	$("#txtOrden").numeric(onlyNumericOptions);
	$("#txtOrden").keyup(function(){ if($("#txtOrden").val()==0) $("#txtOrden").val(''); });
	$('#btnBuscarActividad').click(function(){procesarGridActividad();});
	$('#btnNuevaActividad').click(function(){abrirMantActividad("nuevo","","");});
    
}

function abrirMantActividad(tipo,rowid,idGrid){
	switch (tipo){
	    case "nuevo" :
	        title="NUEVA ACTIVIDAD";break;
	    case "editar" :
	        title="EDITAR ACTIVIDAD";break;
	    default :
	        title="";break;
	}
	var row=$('#'+idGrid).jqGrid("getRowData",rowid);
	$.ajax({
        url:baseURL + "pages/mantenimientoActividad/abrirMantActividad", 
        type:'post',
        async:false,
        data:{
        	tipo: tipo, 
        	idActividad: row['idActividadPadre'],
        	codigo: row['codigoPadre'],
        	nombre: row['nombrePadre'],
        	orden: row['ordenPadre']
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantActividades").html(data);
            $("#dialogMantActividades").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
        },
        error:errorAjax
    });
}

function procesarGridActividad(flg_load){
    if(flg_load==undefined){flg_load=1;}
    
    $("#gridContenedorActividad").html("");
    var grid = $("<table>", {
        "id": "gridActividad"
    });
    var pager = $("<div>", {
        "id": "paginacionActividad"
    });
    $("#gridContenedorActividad").append(grid).append(pager);

    var nombres = ['idActividad','codigoPadre','nombrePadre','Orden','Actividad'];
    var columnas = [
        {name: "idActividadPadre",width: 20,sortable: false,align: "center",hidden:true},
        {name: "codigoPadre",width: 20,sortable: false,align: "center",hidden:true},
        {name: "nombrePadre",width: 20,sortable: false,align: "center",hidden:true},
        {name: "ordenPadre",width: 60,sortable: false,align: "center"}, 
        {name: "nombre",width: 420,sortable: false,align: "left",formatter:"actividad"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoActividad/findActividad",
        datatype: "json",
        postData: {
            nombre:$('#txtActividad').val(),
            orden:$('#txtOrden').val(),
            flg_load:flg_load
        },
        mtype: 'POST',
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionActividad",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de actividades",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idActividadPadre"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            $('.pui-menuitem #linkEditarActividad, #linkEditarActividad').attr('onClick', 'abrirMantActividad("editar","'+rowid+'","gridActividad")');
            $('.pui-menuitem #linkEliminarActividad, #linkEliminarActividad').attr('onClick', 'eliminarActividad("'+rowid+'")');
            $('.pui-menuitem #linkAgregarAgente, #linkAgregarAgente').attr('onClick', 'abrirMantFrmBusqAgente("'+rowid+'","gridActividad")');
            if($('#divEnlaceTagEditarActividad input').html()!=null){
                $('#contextMenuActividad li a[value="MO-ACTIVIDAD"]').html($('#divEnlaceTagEditarActividad').html());
             } else {  
                $('#contextMenuActividad li a[value="MO-ACTIVIDAD"]').remove();
             }
            
            if($('#divEnlaceTagEliminarActividad input').html()!=null){
                $('#contextMenuActividad li a[value="EL-ACTIVIDAD"]').html($('#divEnlaceTagEliminarActividad').html());
             } else {  
                $('#contextMenuActividad li a[value="EL-ACTIVIDAD"]').remove();
             }
            
            if($('#divEnlaceTagAgregarAgente input').html()!=null){
                $('#contextMenuActividad li a[value="CO-AGENTE"]').html($('#divEnlaceTagAgregarAgente').html());
             } else {  
                $('#contextMenuActividad li a[value="CO-AGENTE"]').remove();
             }
        },
        loadComplete: function(data) {
            $('#contextMenuActividad').parent().css('opacity',1);
            $('#contextMenuActividad').parent().remove();
            $('#divContextMenuActividad').html("<ul id='contextMenuActividad'>"
                    + "<li> <a value='MO-ACTIVIDAD'></a></li>"
                    + "<li> <a value='EL-ACTIVIDAD'></a></li>"
                    + "<li> <a value='CO-AGENTE'></a></li>"
                    + "</ul>");
            $('#contextMenuActividad').puicontextmenu({
                target: $('#gridActividad')
            });
        },
    });
}

function eliminarActividad(rowid){
    var row = $('#gridActividad').jqGrid('getRowData', rowid);
    confirm.open("¿Ud. est&aacute; seguro de eliminar este registro?","procEliminarActividad('"+rowid+"')");
}


function procEliminarActividad(rowid){
	var row = $('#gridActividad').jqGrid('getRowData', rowid);
    $.ajax({
        url:baseURL + "pages/mantenimientoActividad/eliminarActividad",
        type:'post',
        async:false,
        data:{
        	idActividad: row['idActividadPadre']
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridActividad();
            } else {
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}


function abrirMantFrmBusqAgente(rowid,idGrid){
	var row=$('#'+idGrid).jqGrid('getRowData',rowid);
	$.ajax({
        url:baseURL + "pages/mantenimientoActividad/abrirMantFrmBusqAgente", 
        type:'post',
        async:false,
        data:{
        	idActividad: row['idActividadPadre'],
        	codigo: row['codigoPadre'],
        	nombre: row['nombrePadre'],
        	orden: row['ordenPadre']
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantBusqAgentes").html(data);
            $("#dialogMantBusqAgentes").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                position: ['center', 'top+30'],
                modal: true,
                dialogClass: 'dialog',
                title: "MANTENIMIENTO DE AGENTES",
                closeText: "Cerrar"
            });
        },
        error:errorAjax
    });
}

jQuery.extend($.fn.fmatter, {
    actividad: function(cellvalue, options, rowdata) {
        var codigo=$.trim(rowdata.codigoPadre);
        var nombre=$.trim(rowdata.nombrePadre);
        var html = '';
        if (codigo != null && codigo != '' && codigo != undefined &&
        		nombre != null && nombre != '' && nombre != undefined){       
            html=codigo+' - '+nombre;
        }
        return html;
    }
});

