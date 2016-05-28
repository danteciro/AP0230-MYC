$(function() {
	$("#tabsob").tabs();
	$('#default').puigrowl();		
	initPopupAsignarUbigeo();	
	procesarGridAsignarUbigeo("0");
});

function initPopupAsignarUbigeo(){
	
	$('#btnGuardarUbigeo').click(function() {
		confirm.open("¿Ud est&aacute; seguro de Guardar?","procesarGridAsignarUbigeo()");
	});	
	$('#btnCloseUbigeo').click(function() {
	    $("#dialogConfiguracionRegion").dialog("close");
	});
	$('#btnLimpiarBusqUni').click(function() {
		
	});
	$('#btnAgregarUbigeo').click(function() {
		procesarGridAsignarUbigeo("1");
	});
}



function procesarGridAsignarUbigeo(flg_load) {
	   
	if(flg_load==undefined){flg_load=1;}
    var nombres = ['N°','Departamento','Provincia','Distrito'];
    var columnas = [
        {name: "item",width: 30,sortable: false,align: "center"}, 
        {name: "campo1",width: 120,sortable: false,align: "center"}, 
        {name: "campo2",width: 150,sortable: false,hidden: false,align: "center"},
        {name: "campo3",width: 150,sortable: false,hidden: false,align: "center"}
    ];
     
    $("#gridContenedorUbigeo").html("");
    var grid = $("<table>", {
        "id": "idgridUbigeo"
    });
    var pager = $("<div>", {
        "id": "paginacionUbigeo"
    });
    $("#gridContenedorUbigeo").append(grid).append(pager);

    grid.jqGrid({
        url: baseURL + "pages/oficinasRegionales/findUbigeo",
        datatype: "json",
        postData: {
        	flg_load:flg_load
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionUbigeo",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idUbigeo"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);           
            $('#linkEliminarUbigeo').attr('onClick', 'eliminarUbigeo("'+rowid+'")');
            
        },
        loadComplete: function(data) {
            $('#contextMenuUbigeo').parent().remove();
            $('#divContextMenuUbigeo').html("<ul id='contextMenuUbigeo'>"
                         + "<li> <a id='linkEliminarUbigeo' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuUbigeo').puicontextmenu({
                target: $('#idgridUbigeo')
            });
        }
    });
   
}



