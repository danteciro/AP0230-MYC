$(function() {
	$('#default').puigrowl();		
	initPopupAsignarUbigeo();	
	
	procesarGridAsignarOficina("0");
});

function initPopupAsignarUbigeo(){
	
	$('#btnGuardarOficina').click(function() {
		confirm.open("¿Ud est&aacute; seguro de Guardar?","");
	});	
	$('#btnCloseOficina').click(function() {
	    $("#dialogConfiguracionRegion").dialog("close");
	});
	
}

function procesarGridAsignarOficina(flg_load) {
	   
	if(flg_load==undefined){flg_load=1;}
    var nombres = ['N°','Tipo','Nombre','Direccion','Telefono','Fax'];
    var columnas = [
        {name: "item",width: 30,sortable: false,align: "center"}, 
        {name: "campo6",width: 120,sortable: false,align: "center"}, 
        {name: "campo2",width: 150,sortable: false,hidden: false,align: "center"},
        {name: "campo3",width: 150,sortable: false,hidden: false,align: "center"},
        {name: "campo4",width: 150,sortable: false,hidden: false,align: "center"},
        {name: "campo5",width: 150,sortable: false,hidden: false,align: "center"}
    ];
     
    $("#gridContenedorOficina").html("");
    var grid = $("<table>", {
        "id": "idgridOficina"
    });
    var pager = $("<div>", {
        "id": "paginacionOficina"
    });
    $("#gridContenedorOficina").append(grid).append(pager);

    grid.jqGrid({
        url: baseURL + "pages/oficinasRegionales/findOficinas",
        datatype: "json",
        postData: {
        	flg_load:flg_load
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionOficina",
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
            id: "idOficina"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);           
            $('#linkEliminarOficina').attr('onClick', 'eliminarOficina("'+rowid+'")');
            
        },
        loadComplete: function(data) {
            $('#contextMenuOficina').parent().remove();
            $('#divContextMenuOficina').html("<ul id='contextMenuOficina'>"
                         + "<li> <a id='linkEliminarOficina' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuOficina').puicontextmenu({
                target: $('#idgridOficina')
            });
        }
    });
   
}



