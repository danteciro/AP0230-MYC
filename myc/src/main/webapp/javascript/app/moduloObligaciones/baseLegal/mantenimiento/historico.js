var historicoBasesLegales= (function(){
    var idDialog = $('#idDialogHistoricoBaseLegal').val();
    function constructor(){
    dialogHistoricoBaseLegal();
    gridHistoricoGeneralBaseLegal();
    historicoGeneral.btnCerrarPopUpHistorico.click(cerrarHistoricoBaseLegal);
    }
    /**
     * @returns {undefined}
     * .dialog('close')
     */
    function cerrarHistoricoBaseLegal(){
        $("#" + idDialog).dialog('close');
    }
    /**
     * @returns {undefined}
     * .dialog(properties)
     */
    function dialogHistoricoBaseLegal(){
        dialog(idDialog, 'Historico Base Legal', false, 'dialogHistoricoBaseLegal');
        $('#' + idDialog).dialog("option", "position", {my: "center bottom", at: "center center", of: window});
        $('#' + idDialog).on("dialogclose", function(event, ui) {
            $(this).dialog("destroy");
            $(this).remove();
            //remove elementos insertados en el html
            $('div[role="dialog"]').remove();
            $('#ui-datepicker-div').remove();
            $('#contextMenuPautas').parent().remove();
            $('#divOcultaContainerHistorico').hide();
        });
        $("#" + idDialog).dialog('open');
    }
    /**
     * 
     * @returns {undefined}
     * function: create JqGrid gridHistoricoGeneralBaseLegal
     */
    function gridHistoricoGeneralBaseLegal() {
        
        $("#gridContenedorHistoricoGeneralBaseLegal").html("");
        var grid = $("<table>", { "id": "gridHistoricoGeneralBasesLegales" });
        var pager = $("<div>", { "id": "paginacionHistoricoGeneralBasesLegales" });
        $("#gridContenedorHistoricoGeneralBaseLegal").append(grid).append(pager);
        var nombres = ['Codigo Base Legal','Descripción Base Legal','Fecha Creacion','Usuario','Tiene Detalle'];
        var columnas = [
            {name: "codigoObligacion",width: 130,sortable: false,align: "center"},
            {name: "descripcionObligacion",width: 430,sortable: false,align: "center"},
            {name: "fechaCreacion",width: 130,sortable: false,align: "center"},
            {name: "usuario",width: 130,sortable: false,align: "center"},
            {name: "tieneDetalle",width: 130,sortable: false,align: "center",hidden:true}   
        ];
        grid.jqGrid({   url: baseURL + "pages/baseLegal/historico/obtenerHistoricoBaseLegal",
                        datatype: "json",
                        postData: {},
                        hidegrid: false,
                        rowNum: 100,
                        pager: "#paginacionHistoricoGeneralBasesLegales",
                        emptyrecords: "No se encontraron resultados",
                        loadtext: "Cargando",
                        colNames: nombres,
                        colModel: columnas,
                        height: "auto",
                        viewrecords: true,
                        caption: "Historico Base Legal",
                        autowidth: true,
                        jsonReader: { root: "filas", page: "pagina", total: "total", records: "registros" },
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                var row = grid.jqGrid('getRowData', rowid);
            },
            loadComplete: function(data) {
                $('#ContextMenuHistoricoGeneralBaseLegal').parent().remove();
                $('#divContextMenuHistoricoGeneralBaseLegal').html("<ul id='ContextMenuHistoricoGeneralBaseLegal'>"
                    + "<li> <a id='linkVerBaseLegal' data-icon='ui-icon-search' title='Ver Detalle Base Legal'>Ver Detalle Base Legal</a> </li>"
                    + "</ul>");
                $('#ContextMenuHistoricoGeneralBaseLegal').puicontextmenu({ target: $('#gridHistoricoGeneralBasesLegales')}); 
                
            },
            subGrid:true,
            afterInsertRow: function(rowid, aData, rowelem) {
                var rowData = grid.getRowData(rowid);
                if( rowData["tieneDetalle"]==0){
                    $('tr#'+rowid, grid)
                    .children("td.sgcollapsed")
                    .html("")
                    .removeClass('ui-sgcollapsed sgcollapsed');
                } 
            },
            subGridOptions: { 
            "plusicon" : "ui-icon-circle-plus",
            "minusicon" : "ui-icon-circle-minus", 
            "openicon" : "ui-icon-arrowreturn-1-e",
            "reloadOnExpand" : false, 
            "selectOnExpand" : false }, 
            subGridRowExpanded: function(subgrid_id, row_id) { 
            var dataPadre=grid.getRowData(row_id);
            var subgrid_table_id, pager_id; 
            subgrid_table_id = subgrid_id+"_t"; 
            pager_id = "p_"+subgrid_table_id; 
            $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table>");//<div id='"+pager_id+"' class='scroll'></div>
            jQuery("#"+subgrid_table_id).jqGrid({ 
                url:baseURL + "pages/baseLegal/historico/obtenerDetalleHistoricoBaseLegal",
                postData:{row_id : dataPadre.codigoBaseLegal},
                datatype: "json", 
                colNames: ['Accion','Campo','Dato Anterior','Dato Actual','Fecha','Usuario'], 
                colModel: [{name:"accion",index:"item",width:180},
                {name:"campoModificado",index:"item",width:180},{name:"datoAnterior",index:"qty",width:250,align:"right"},
                {name:"datoActual",index:"qty",width:250,align:"right"},{name:"fechaModificado",index:"qty",width:100,align:"right"},
                {name:"usuario",index:"qty",width:100,align:"right"}],
                rowNum:10, 
                jsonReader : {
                    root : "filas", //la lista de registros a mostrar en el grid
                    page : "pagina", //la pagina actual
                    total : "total", //total de paginas
                    records : "registros" //numero total de registros
                },
                pager: pager_id, 
                sortname: 'num', 
                sortorder: "asc", 
                height: '100%' ,
                autowidth:true
            });         
        }   
        });
    
    }
    /**
     * return: functions here are publics
     */
    return{
    constructor:constructor    
    };
})();
var historicoObligaciones= (function(){
    function constructor(){
    gridHistoricoGeneralObligacionNormativa();    
    }
    /**
     * 
     * @returns {undefined}
     * function: create JqGrid gridHistoricoGeneralObligacionNormativa
     */
    function gridHistoricoGeneralObligacionNormativa() {
        
        $("#gridContenedorHistoricoGeneralObligacionNormativa").html("");
        var grid = $("<table>", { "id": "gridHistoricoGeneralObligacionesNormativas" });
        var pager = $("<div>", { "id": "paginacionHistoricoGeneralObligacionesNormativas" });
        $("#gridContenedorHistoricoGeneralObligacionNormativa").append(grid).append(pager);
        var nombres = ['Codigo Obligación','Descripción Obligación','Fecha Creacion','Fecha Vigencia','Usuario','Tiene Detalle'];
        var columnas = [
            {name: "codigoObligacion",width: 130,sortable: false,align: "center"},
            {name: "descripcionObligacion",width: 430,sortable: false,align: "center"},
            {name: "fechaCreacion",width: 130,sortable: false,align: "center"},
            {name: "fechaVigencia",width: 130,sortable: false,align: "center"},
            {name: "usuario",width: 130,sortable: false,align: "center"},
            {name: "tieneDetalle",width: 130,sortable: false,align: "center",hidden:true}   
        ];
        grid.jqGrid({   url: baseURL + "pages/baseLegal/historico/obtenerHistoricoObligacion",
                        datatype: "json",
                        postData: {},
                        hidegrid: false,
                        rowNum: 100,
                        pager: "#paginacionHistoricoGeneralObligacionesNormativas",
                        emptyrecords: "No se encontraron resultados",
                        loadtext: "Cargando",
                        colNames: nombres,
                        colModel: columnas,
                        height: "auto",
                        viewrecords: true,
                        caption: "Historico Obligación Normativa",
                        autowidth: true,
                        jsonReader: { root: "filas", page: "pagina", total: "total", records: "registros" },
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                var row = grid.jqGrid('getRowData', rowid);
            },
            loadComplete: function(data) {
                $('#ContextMenuHistoricoGeneralObligacionNormativa').parent().remove();
                $('#divContextMenuHistoricoGeneralObligacionNormativa').html("<ul id='ContextMenuHistoricoGeneralObligacionNormativa'>"
                    + "<li> <a id='linkVerObligacionNormativa' data-icon='ui-icon-search' title='Ver Detalle Base Legal'>Ver Detalle Obligación</a> </li>"
                    + "</ul>");
                $('#ContextMenuHistoricoGeneralObligacionNormativa').puicontextmenu({ target: $('#gridHistoricoGeneralObligacionesNormativas')}); 
            },
            subGrid:true,
            afterInsertRow: function(rowid, aData, rowelem) {
                var rowData = grid.getRowData(rowid);
                if( rowData["tieneDetalle"]==0){
                    $('tr#'+rowid, grid)
                    .children("td.sgcollapsed")
                    .html("")
                    .removeClass('ui-sgcollapsed sgcollapsed');
                } 
            },
            subGridOptions: { 
            "plusicon" : "ui-icon-circle-plus",
            "minusicon" : "ui-icon-circle-minus", 
            "openicon" : "ui-icon-arrowreturn-1-e",
            "reloadOnExpand" : false, 
            "selectOnExpand" : false }, 
            subGridRowExpanded: function(subgrid_id, row_id) { 
            var dataPadre=grid.getRowData(row_id);
            var subgrid_table_id, pager_id; 
            subgrid_table_id = subgrid_id+"_t"; 
            pager_id = "p_"+subgrid_table_id; 
            $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table>");//<div id='"+pager_id+"' class='scroll'></div>
            jQuery("#"+subgrid_table_id).jqGrid({ 
                url:baseURL + "pages/baseLegal/historico/obtenerDetalleHistoricoObligacion",
                postData:{row_id : dataPadre.codigoBaseLegal},
                datatype: "json", 
                colNames: ['Accion','Campo','Dato Anterior','Dato Actual','Fecha','Usuario'], 
                colModel: [{name:"accion",index:"item",width:180},
                {name:"campoModificado",index:"item",width:180},{name:"datoAnterior",index:"qty",width:250,align:"right"},
                {name:"datoActual",index:"qty",width:250,align:"right"},{name:"fechaModificado",index:"qty",width:100,align:"right"},
                {name:"usuario",index:"qty",width:100,align:"right"}],
                rowNum:10, 
                jsonReader : {
                    root : "filas", //la lista de registros a mostrar en el grid
                    page : "pagina", //la pagina actual
                    total : "total", //total de paginas
                    records : "registros" //numero total de registros
                },
                pager: pager_id, 
                sortname: 'num', 
                sortorder: "asc", 
                height: '100%' ,
                autowidth:true
            });         
        }   
        });
    
    }
    /**
     * return: functions here are publics
     */
    return{
    constructor:constructor     
    };
})
();
$(function() {
    historicoGeneral={
        btnCerrarPopUpHistorico:$('#btnCerrarPopUpHistorico')
        
    };
    historicoBasesLegales.constructor();
    historicoObligaciones.constructor();
});