$(function() {
	boton.closeDialog();
	procesarGridOficinaRegional("0");
    initInicioOficinaRegional();
});
function initInicioOficinaRegional(){
	
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/configuracionRegistro';
    });
    confirm.start();
    $('#btnBuscarOficinaRegional').click(function(){procesarGridOficinaRegional();});
    $('#btnNuevaOficinaRegional').click(function(){abrirConfOficinaRegional("new");});
}



function abrirConfOficinaRegional(tipo,rowid){
	
    var title="CONSULTA MACROREGION";
    if(tipo=='edit'){
        title="EDITAR MACROREGION";
    }else if(tipo=='new'){
        title="NUEVA MACROREGION";
    }
    $.ajax({
        url:baseURL + "pages/oficinasRegionales/abrirMantOficinaRegional", 
        type:'get',
        async:false,
        data:{
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantOficinaRegional").html(data);
            $("#dialogMantOficinaRegional").dialog({
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






function asignarUbigeo(tipo,rowid){
    title="ASIGNAR UBIGEO";
$.ajax({
    url:baseURL + "pages/oficinasRegionales/abrirAsignacionUbigeo", 
    type:'get',
    async:false,
    data:{
    },
    beforeSend:muestraLoading,
    success:function(data){
        ocultaLoading();
        $("#dialogMantUbigeo").html(data);
        $("#dialogMantUbigeo").dialog({
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


function asignarOficinaRegional(tipo,rowid){

    title="ASIGNAR OFICINA ";

$.ajax({
    url:baseURL + "pages/oficinasRegionales/abrirAsignacionOficinaRegional", 
    type:'get',
    async:false,
    data:{
    },
    beforeSend:muestraLoading,
    success:function(data){
        ocultaLoading();
        $("#dialogMantOficina").html(data);
        $("#dialogMantOficina").dialog({
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
/*
function procGuardarOficinaRegional(){
    var nuevo = {};
    $("#gridOficinaRegional").jqGrid('addRowData', 6, nuevo);
    mensajeGrowl("success", "Se registró correctamente", "");
    $("#dialogMantOficinaRegional").dialog("close");
}
//NUEVO OficinaRegional - FIN
//EDITAR OficinaRegional - INICIO
*/
function editMacroRegion(rowid){
	abrirConfOficinaRegional('edit',rowid);
	  $('#btnEditarMacroRegion').show();
      $('#btnGuardarMacroRegion').hide();
      $('#idCmbOmr').val("1");
      $('#idCmbOmr').attr('disabled',true);
}
/*
function procEditarOficinaRegional(){
    procesarGridOficinaRegional();
    mensajeGrowl("success", "Se registró correctamente los cambios", "");
    $("#dialogMantOficinaRegional").dialog("close");
}
//EDITAR OficinaRegional - FIN
//ELIMINAR OficinaRegional - INICIO
*/
function eliminarMacroRegion(rowid){
    confirm.open("¿Ud est&aacute; seguro de eliminar la MacroRegion?","procEliminarOficinaRegional('"+rowid+"')");
}

function procEliminarOficinaRegional(id){
    $('#idGridOficinaRegional').jqGrid('delRowData',id);
    mensajeGrowl("success", "Se elimino el registro correctamente", "");
}
//ELIMINAR OficinaRegional - FIN
//CONSULTAR OficinaRegional - INICIO
function verMacroRegion(rowid){
	abrirConfOficinaRegional('',rowid);
    $("#dialogMantOficinaRegional").dialog("option","title","CONSULTAR MACROREGION");
    $('#btnGuardarMacroRegion').hide();
    $('#btnEditarMacroRegion').hide(); 
    $('#idRegistroRegiones').hide();
    $('#btnAgregarMacroRegion').hide();    
    $('#idCmbOmr').val("1");
    $('#frmMantMacroRegion').find('input,select,textarea').attr('disabled',true);
    
}
//CONSULTAR OFICINA REGIONAL - FIN
///////////////////////////
function procesarGridOficinaRegional(flg_load){

	 if(flg_load==undefined){flg_load=1;}
   
    var nombres = ['Codigo','Nombre','estado'];
    var columnas = [
        {name: "campo1",width: 500,sortable: false,align: "left"}, 
        {name: "campo2",width: 500,sortable: false,align: "left"}, 
        {name: "campo4",width: 500,sortable: false,align: "left",hidden: true,align: "center"}, 
            
    ];
    
    var mydataSubGrid = [
               
	     {codigo: "RG1",nombre: "Piura"},
	     {codigo: "RG2",nombre: "Tumbes"},
	      ];
    var mydataSubGridOMRII = [
                	     {codigo:"RG1",nombre: "Amazonas"},
                	     {codigo:"RG1",nombre: "Lanbayeque"},
                	     {codigo:"RG1",nombre: "San Martin"}
                	      ];
    var mydataSubGridOMRIII = [
                     	     {codigo:"RG1",nombre: "Ancash"},
                     	     {codigo:"RG1",nombre: "Cajamarca"},
                     	     {codigo:"RG1",nombre: "La Libertad"}
                     	      ];
    var nombresSubGrid = ['Codigo','Región'];
    var columnasSubGrid = [{name: "codigo", width: 450, sortable: false, align: "left"},
                           {name: "nombre", width: 450, sortable: false, align: "left"}];


    
    $("#gridContenedorOficinaReginal").html("");
    var grid = $("<table>", {
        "id": "idGridOficinaRegional"
    });
    var pager = $("<div>", {
        "id": "paginacionOficinaRegional"
    });
    $("#gridContenedorOficinaReginal").append(grid).append(pager);

    grid.jqGrid({
        url: baseURL + "pages/oficinasRegionales/findOficinaRegional",
        datatype: "json",
        postData: {
        	flg_load:flg_load
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionOficinaRegional",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de MacroRegión",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idOficinaRegional"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);         
     
            $('#linkVerOficinaRegional').attr('onClick', 'verMacroRegion("'+rowid+'")');
            $('#linkEditarOficinaRegional').attr('onClick', 'editMacroRegion("'+rowid+'")');
            $('#linkEliminarOficinaRegional').attr('onClick', 'eliminarMacroRegion("'+rowid+'")');
        },
        loadComplete: function(data) {
            $('#contextMenuOficinaRegional').parent().remove();
            $('#divContextMenuOficinaRegional').html("<ul id='contextMenuOficinaRegional'>"
            		 + "<li> <a id='linkVerOficinaRegional' data-icon='ui-icon-search' title='Ver Detalle'>Consultar</a> </li>"
                     + "<li> <a id='linkEditarOficinaRegional' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                     + "<li> <a id='linkEliminarOficinaRegional' data-icon='ui-icon-pencil' title='Eliminar'>Eliminar</a></li>"

                    + "</ul>");
            $('#contextMenuOficinaRegional').puicontextmenu({
                target: $('#idGridOficinaRegional')
            });
        },
        
        
        subGrid: true,
        afterInsertRow: function(rowid, aData, rowelem) {
            var rowData = grid.getRowData(rowid);
          
            if (rowData["campo4"] == 0) {
                $('tr#' + rowid, grid)
                        .children("td.sgcollapsed")
                        .html("")
                        .removeClass('ui-sgcollapsed sgcollapsed');
            }
        },
        subGridOptions: {
            "plusicon": "ui-icon-circle-plus",
            "minusicon": "ui-icon-circle-minus",
            "openicon": "ui-icon-arrowreturn-1-e",
            "reloadOnExpand": false,
            "selectOnExpand": true
        },
        subGridRowExpanded: function(subgrid_id, row_id) {
            var subgrid_table_id, pager_id;
            subgrid_table_id = subgrid_id + "_t";
            pager_id = "p_" + subgrid_table_id;
            $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='" + pager_id + "' class='scroll'></div>");
            jQuery("#" + subgrid_table_id).jqGrid({
                //url:"subgrid.php?q=2&id="+row_id, 
                datatype: "local",
                colNames: nombresSubGrid,
                colModel: columnasSubGrid,
                rowNum: global.rowNum,
                pager: pager_id,
                sortname: 'num',
                sortorder: "asc",
                height: '100%',
                autowidth: true,  
                onSelectRow: function(row_id, status) {
                    grid.resetSelection();
                },
                
                onRightClickRow: function(row_id, iRow, iCol, e) {
                	 var row = grid.jqGrid('getRowData', row_id); 
                	 $('#linkVerRegion').attr('onClick', 'verRegion("'+row+'")');                   
                },
                
                loadComplete: function(data) {
                    var data = mydataSubGrid;
                   
                  //DATA PERSONALIZADA
                    var rowData = grid.getRowData(row_id);
                    
                    if (rowData.campo1 == 'OMR II') {
                        data = mydataSubGridOMRII;
                    } 
                    else if(rowData.campo1 == 'OMR III'){
                    	data = mydataSubGridOMRIII;
                    }

                    for (var i = 0; i <= data.length; i++) {
                    
                        jQuery("#" + subgrid_table_id).jqGrid('addRowData', i + 1, data[i]);                   
                        //$('#linkAsignarJefeRegional').attr('onClick', 'asignarJefeRegional("'+data[i].responsable+'")');
                        
                    }
                    
                    $('#contextMenuOficinaRegionalSub').parent().remove();
                    $('#divContextMenuOficinaRegionalSub').html("<ul id='contextMenuOficinaRegionalSub'>"
                    		 + "<li> <a id='linkVerRegion' data-icon='ui-icon-search' title='Ver Detalle'>Consultar</a> </li>"
                             + "</ul>");                    
                    $('#contextMenuOficinaRegionalSub').puicontextmenu({
                        target: $("#" + subgrid_table_id)
                    });
                }
            });
        }
   
    });
}


function asignarJefeRegional(macroRegion,responsable){
	  confirm.open("¿Ud est&aacute; seguro de Asignar el Responsable de la MacroRegión: "+macroRegion+"?","procesarGridOficinaRegional()");
	
}