var cajaDestino;

$(function() {
	initPopupBusqResponsable();	
});

function initPopupBusqResponsable(){
	
	$('#btnBuscarBusqResp').click(function() {
		procesarGridBusqResponsable("0");		
	});	
	$('#btnCerrarBusqResp').click(function() {
	    $("#dialogBusqResponsable").dialog("close");
	});
	$('#btnLimpiarBusqResponsable').click(function() {
		
	});	
}

function abrirPopupBusqResponsable(idDestino) {
	cajaDestino = idDestino;
    var title = "Búsqueda de Personas";    
    $("#dialogBusqResponsable").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true,
        title:title
    });
    $("#dialogBusqResponsable").dialog("open"); 

}

function procesarGridBusqResponsable(flg_load) {
	   
	if(flg_load==undefined){flg_load=1;}
    var nombres = ['N°','Codigo','Usuario','Nombre Completo','Correo'];
    var columnas = [
        {name: "item",width: 30,sortable: false,align: "center"}, 
        {name: "campo1",width: 120,sortable: false,align: "center"}, 
        {name: "campo2",width: 150,sortable: false,hidden: false,align: "center"},
        {name: "campo3",width: 150,sortable: false,hidden: false,align: "left"},
        {name: "campo4",width: 150,sortable: false,hidden: false,align: "left"}
    ];
     
    $("#gridContenedorBusqResp").html("");
    var grid = $("<table>", {
        "id": "idgridResp"
    });
    var pager = $("<div>", {
        "id": "paginacionResp"
    });
    $("#gridContenedorBusqResp").append(grid).append(pager);

    grid.jqGrid({
        url: baseURL + "pages/oficinasRegionales/findResponsable",
        datatype: "json",
        postData: {
        	flg_load:flg_load
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionResp",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Supervisores",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idResp"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);           
            $('#linkSeleccionarResp').attr('onClick', 'obtenerResponsable("'+row.campo3+'")');
            
        },
        loadComplete: function(data) {
            $('#contextMenuResp').parent().remove();
            $('#divContextMenuBusqResp').html("<ul id='contextMenuResp'>"
                         + "<li> <a id='linkSeleccionarResp' title='seleccionar'>Seleccionar</a></li>"
                    + "</ul>");
            $('#contextMenuResp').puicontextmenu({
                target: $('#idgridResp')
            });
        }
    });
   
}


function obtenerResponsable(nombreCompleto){	
	$("#dialogBusqResponsable").dialog("close");
	$("#"+cajaDestino).val(nombreCompleto);
	
}


