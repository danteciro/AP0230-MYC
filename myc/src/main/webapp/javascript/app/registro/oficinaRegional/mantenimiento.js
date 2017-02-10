
$(function() {

    procesarGridRegiones("0");
    initPopupMantMacroregion();
});

function initPopupMantMacroregion(){
	
	$('#btnGuardarMacroRegion').click(function() {
		btnGuardarMacroRegion();
	});	
	$('#btnCloseMacroRegion').click(function() {
	    $("#dialogMantOficinaRegional").dialog("close");
	});		
	
	$('#btnAgregarMacroRegion').click(function() {
		btnAgregarMacroRegion();
	});	
	
}




/////////////////////////
//  NUEVO - INICIO 

function btnAgregarMacroRegion(){
    var validar = $('#frmMantMacroRegion').validateAllForm("#divMensajeValidaMacroRegion");
    if (validar) {
        confirm.open("¿Ud est&aacute; seguro de Guardar esta nueva Region?","procesarGridRegiones()");
    }
}
function btnGuardarMacroRegion(){  
        confirm.open("¿Ud est&aacute; seguro de Guardar esta nueva MacroRegion?","procGuardarMacroRegion()");
         
}
function procGuardarMacroRegion(){
 /*   var nuevo = {
        item:$('#txtItemProc').val(), 
        descripcion:$('#txtDenominacionProc').val(),
        proceso:$('#cmbProceso').val(),
        tieneAct:0
    };
    $("#gridProcedimiento").jqGrid('addRowData', 10, nuevo);*/
    mensajeGrowl("success", "Se registró correctamente", "");
    var idProc='1';//este valor debe retornarse despues de guardar Procedimiento (etapa construccion con BD)
  
    $("#dialogMantOficinaRegional").dialog("close");
}
//  NUEVO - FIN 
// EDITAR  - INICIO
function editarProcedimiento(rowid){
    abrirMantProcedimiento('edit',rowid);
}
function btnEditarProc(){
    var validar = $('#frmMantProcedimiento').validateAllForm("#divMensajeValidaProcedimiento");
    if (validar) {
        confirm.open("¿Ud est&aacute; seguro de Guardar los Cambios en este Procedimiento?","procEditarProc()");
    }
};
function procEditarProc(){
    procesarGridProcedimiento();
    $("#dialogMantProcedimiento").dialog("close");
    mensajeGrowl("success", "Se registró correctamente los cambios", "");
}
//EDITAR  - FIN
//ELIMINAR  - INICIO
function eliminarProcedimiento(rowid){
    confirm.open("¿Ud est&aacute; seguro de eliminar este Procedimiento?","procEliminarProc('"+rowid+"')");
}
function procEliminarProc(id){
    $('#gridProcedimiento').jqGrid('delRowData',id);
    mensajeGrowl("success", "Se elimino el registro correctamente", "");
}
//ELIMINAR  - FIN
//CONSULTAR  - INICIO
function verProcedimiento(rowid){
    editarProcedimiento(rowid);
    $("#dialogMantProcedimiento").dialog("option","title","CONSULTAR PROCEDIMIENTO");
    $('#btnEditarProc').hide();
    $('#btnGuardarProc').hide();
    
    $('#frmMantProcedimiento').find('input,select,textarea').attr('disabled',true);
}
//CONSULTAR REGIONES - FIN
/////////////////////////

function procesarGridRegiones(flg_load) {
	   
	if(flg_load==undefined){flg_load=1;}
    var nombres = ['N°','Departamento','Jefe Regional','Conf.'];
    var columnas = [
        {name: "item",width: 30,sortable: false,align: "center"}, 
        {name: "campo2",width: 150,sortable: false,align: "center"},
        {name: "campo3",width: 200,sortable: false,hidden: false,align: "center"},
        {name: "flgAsignado",width: 200,align: "center",formatter: 'colConfiguracion'},
    ];
     
    $("#gridContenedorRegion").html("");
    var grid = $("<table>", {
        "id": "idgridRegion"
    });
    var pager = $("<div>", {
        "id": "paginacionRegion"
    });
    $("#gridContenedorRegion").append(grid).append(pager);

    grid.jqGrid({
        url: baseURL + "pages/oficinasRegionales/findRegiones",
        datatype: "json",
        postData: {
        	flg_load:flg_load
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionRegion",
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
            id: "idRegion"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);           
            $('#linkConfigurar').attr('onClick', 'abrirConfigurarRegion("'+rowid+'")');
            $('#linkEliminar').attr('onClick', 'abrirConfigurarRegion("'+rowid+'")');
        },
        loadComplete: function(data) {
            $('#contextMenuRegion').parent().remove();
            $('#divContextMenuRegion').html("<ul id='contextMenuRegion'>"
                         + "<li> <a id='linkConfigurar' data-icon='ui-icon-pencil' title='Configurar'>Configurar</a></li>"
                         + "<li> <a id='linkEliminar' data-icon='ui-icon-pencil' title='Eliminar'>Eliminar</a></li>"
                         + "</ul>");
            $('#contextMenuRegion').puicontextmenu({
                target: $('#idgridRegion')
            });
        }
    });
   
}

jQuery.extend($.fn.fmatter, {
	colConfiguracion: function(cellvalue, options, rowdata) {
		var botonAsignado = "";
    	var botonDesasignado = "";
    	
    	if(rowdata.flgAsignado == true){
    		botonAsignado = "<img src=\""
    			+ baseURL
    			+ "images/ok.png\" id='idA"+ rowdata.index + "' title=\"Desasignar\" alt=\"Desasignar\"/>";
    	
    		botonDesasignado = "<img src=\""
    			+ baseURL
    			+ "images/eliminar.gif\" id='idD"+ rowdata.index + "' style=\"display:none;\" title=\"Asignar\" alt=\"Asignar\"/>";
    	}
    	else{
    		botonAsignado = "<img src=\""
    			+ baseURL
    			+ "images/ok.png\" id='idA"+ rowdata.index + "' style=\"display:none;\" title=\"Desasignar\" alt=\"Desasignar\"/>";
    	
    		botonDesasignado = "<img src=\""
    			+ baseURL
    			+ "images/eliminar.gif\" id='idD"+ rowdata.index + "' title=\"Asignar\" alt=\"Asignar\"/>";
    	}
		return botonAsignado + botonDesasignado;
		
    }
});


//NUEVO OFICINA  - INICIO
function abrirConfigurarRegion(tipo,rowid){
	var title= 'Configuración';
 
    $.ajax({
        url:baseURL + "pages/oficinasRegionales/abrirConfiguracionRegion", 
        type:'get',
        async:false,
        data:{
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogConfiguracionRegion").html(data);
            $("#dialogConfiguracionRegion").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: title
            });
        
        },
        error:errorAjax
    });
}
