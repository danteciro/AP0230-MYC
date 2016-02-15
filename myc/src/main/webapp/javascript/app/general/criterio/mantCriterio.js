$(function() {
    initInicioCriterio();
    $('#formCriterio').validarForm();
});

function initInicioCriterio() {
	
	//boton_regresar
	$('#btnRegresar').click(function() {window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';});
	confirm.start();
	//boton_limpiar
	$('#btnLimpiarCriterio').click(function(){limpiarBuscarCriterio();});	
	//boton_buscar_criterio
	$('#btnBuscarCriterio').click(function() {procesarGridCriterio();});	
	$('#btnMantenimientoCriterio').click(function(){abrirMantenimientoCriterio('nuevo');});

}

function abrirMantenimientoCriterio(tipo,idCriterio){
    $.ajax({
        url:baseURL + "pages/criterio/abrirCriterio",
        type:'get',
        async:false,
        data:{tipo:tipo,idCriterio:idCriterio},
        beforeSend:muestraLoading,
        success:function(data){
        	ocultaLoading();
            $("#containerDialogMantenimientoCriterio").html(data);
            $("#containerDialogMantenimientoCriterio").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: "Mantenimiento Criterio",
                closeText: "Cerrar"
            });
            $('#btnNuevaSancionEspecifica').attr('disabled');
            $('#btnNuevaSancionEspecifica').css('display','none');
            validaEditar(tipo);
        },
        error:errorAjax
    });
}
//funcion_boton_limpiar
function limpiarBuscarCriterio(){$('#formCriterio').find(':input').each(function(){$(this).val('');});}

function procesarGridCriterio(varLista, data) { 
	
	//Implementando_Grid
	
	var validacion = true;	
	if(validacion){
		if(varLista==undefined){varLista=1;}
		if(data==undefined){data={descripcion:$('#txtDescCriterio').val(),varLista:varLista};}
	}	
	
	$("#gridContenedorCriterio").html("");
	var grid = $("<table>", {"id" : "gridCriterio"});
	var pager = $("<div>", {"id" : "paginacionCriterio"});
	$("#gridContenedorCriterio").append(grid).append(pager);
	
	var nombres = ['idTipificacion', 'Tipificacion','idCriterio','Criterio','idTipoCriterio','Tipo','sanciones'];
    var columnas = [
        {name: "idTipificacion", width: 30, sortable: false, align: "center", hidden: true},
        {name: "codigoTipificacion", width: 25, sortable: false, align: "center"},
        {name: "idCriterio", width: 30, sortable: false, align: "center", hidden: true},       
        {name: "descripcion", width: 200, sortable: false, align: "left"},        
        {name: "idTipoCriterio", width: 30, sortable: false, align: "center", hidden: true},  
        {name: "tipoCriterio.descripcion",width: 25,sortable: false, align: "left"},
        {name: "tieneSancion",width: 30, sortable: false, align: "center", hidden: true}
    ];
	
	grid.jqGrid({
		
		url : baseURL + "pages/criterio/listarCriterioImpl",		
		datatype: "json",
	    postData: data,	   
	    data:data,
	    hidegrid: false,
	    rowNum: global.rowNumPrinc,
	    pager: "#paginacionCriterio",
	    emptyrecords: "No se encontraron resultados",
	    loadtext: "Cargando",
	    colNames: nombres,
	    colModel: columnas,
	    height: "auto",
	    viewrecords: true,
	    caption: "Búsqueda Criterios",
	    autowidth: true,
	    jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros",id:"idCriterio"},
	    onSelectRow: function(rowid, status) {
//                grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
        	var row = grid.jqGrid('getRowData', rowid);
            console.info(rowid);
            $('#linkEditarCriterio').attr('onClick', 'confirmEditarCriterio("' + rowid +'")');
            $('#linkEliminarCriterio').attr('onClick', 'confirmEliminarCriterio("' + rowid + '")');
        },
        loadComplete: function(data) {
        	 $('#contextMenuCriterio').parent().remove();
        	 $('#divContextMenuCriterio').html("<ul id='contextMenuCriterio'>"
//                     + "<li> <a id='linkConsultarCriterio' data-icon='ui-icon-search' title='Consultar'>Consultar</a> </li>"                    
                     + "<li> <a id='linkEditarCriterio' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"                     
                     + "<li> <a id='linkEliminarCriterio' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                     + "</ul>");
             $('#contextMenuCriterio').puicontextmenu({target: $('#gridCriterio')});
        },
	    
	//Implementando_Sub_Grid
    
    subGrid: true,
    afterInsertRow: function(rowid, aData, rowelem) {
        var rowData = grid.getRowData(rowid);
        if (rowData["tieneSancion"] == 0) {
        	$('tr#' + rowid, grid).children("td.sgcollapsed").html("").removeClass('ui-sgcollapsed sgcollapsed');
        }
    },
    
	subGridOptions: {"plusicon": "ui-icon-circle-plus","minusicon": "ui-icon-circle-minus","openicon": "ui-icon-arrowreturn-1-e","reloadOnExpand": false,"selectOnExpand": false},
	
	subGridRowExpanded: function(subgrid_id, row_id) { 
        	
	var dataCriterio = grid.getRowData(row_id);
	var subgrid_table_id, pager_id;      	
            
	subgrid_table_id = subgrid_id + "_t";
	pager_id = "p_" + subgrid_table_id;
	$("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
			
	var nombres = ['idDetalleCriterio','idCriterio','Descripción Sanción Específica'];
    var columnas = [        
        {name: "idDetalleCriterio", width: 30, sortable: false, align: "center", hidden: true},  
        {name: "idCriterio", width: 30, sortable: false, align: "center", hidden: true},  
        {name: "sancionEspecifica", width: 200, sortable: false, align: "left"},     
    ];
    
	jQuery("#" + subgrid_table_id).jqGrid({			
		
		url : baseURL + "pages/criterio/listarDetalleCriterioImpl",		
		datatype: "json",
	    postData: {idCriterio:dataCriterio.idCriterio},
	    hidegrid: false,
	    rowNum: global.rowNum,
	    pager: pager_id,
	    emptyrecords: "No se encontraron resultados",
	    loadtext: "Cargando",
	    colNames: nombres,
	    colModel: columnas,
	    height: "auto",
	    viewrecords: true,
	    caption: "Detalle Criterio",
	    autowidth: true,
	    jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros",id:"idDetalleCriterio"},
	    onSelectRow: function(rowid, status) {
        	jQuery("#" + subgrid_table_id).resetSelection();
        },
        loadComplete: function(data) {
        	$('#contextMenuDetalleCriterio').parent().remove();
            $('#divContextMenuDetalleCriterio').html("<ul id='contextMenuDetalleCriterio'>"
                    + "</ul>");
            $('#contextMenuDetalleCriterio').puicontextmenu({
                target: $("#gridCriterio .ui-subgrid")
            });
            $('#contextMenuDetalleCriterio').parent().css('opacity', 0);
        }
	});
   } 
 });
}

function confirmEditarCriterio(rowid){
	console.info('row id' + rowid);
	abrirMantenimientoCriterio("editar",rowid);
}

function validaEditar(tipo){
    if(tipo=="editar"){
    	if($('#cmbTipoCriterio option:selected').text()=="MONETARIA"){
			$('#divMontoCriterio').css('display','block');
		}else if($('#cmbTipoCriterio option:selected').text()=="ADMINISTRATIVA"){
			$('#divTipificacionCriterio').css('display','block');
			$('#divMontoCriterio').css('display','none');
		}else{
			$('#divMontoCriterio').css('display','block');
			$('#divTipificacionCriterio').css('display','block');
		}
    	$('#btnNuevaSancionEspecifica').removeAttr('disabled');
    	$('#btnNuevaSancionEspecifica').css('display','inline-block');
    	if($('#txtIdTipificacion').val()!="" && $('#txtIdTipificacion').val()!=null){
            criterio.obtenerTipificacion($('#txtIdTipificacion').val());
            $('#txtConcatIdTipoSancionCriterio').val().split(',').map(function(v,i){
                $('#rdProceso'+v).attr('checked',true);
            });
    	}
    }
}

function confirmEliminarCriterio(rowid) {
    confirm.start();
    confirm.open("¿Ud está seguro de eliminar este Criterio?",
    "eliminarCriterio('" + rowid + "')");
}

function eliminarCriterio(rowid) {
    var row = $('#gridCriterio').jqGrid('getRowData', rowid);
    idEliminarCriterio=row.idCriterio;
    getEliminarCriterio(rowid);
}

function getEliminarCriterio(id) {
    var URL = baseURL + "pages/criterio/eliminaCriterio";
    $.get(URL,{idCriterio:id}, function(data) {
        if (data.resultado == 0) {
            mensajeGrowl("success", "Se elimino el registro correctamente", "");
            procesarGridCriterio();
        }
    });
}
