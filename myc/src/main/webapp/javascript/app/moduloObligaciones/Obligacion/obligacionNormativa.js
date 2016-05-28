$(function() {
    initInicio();
    gridBasesLegales();
    procesarGridProcedimientotab1();
    procesarGridProcedimientotab2();
    initArbolActividadesAsignar();
    changeCombo();
    initArbolProductosAsignar();
    initArbolProductos();
    initArbolActividades();
    procesarGridFotos();
    //$('#checkboxAplica').change(changeCheckBox);
    $('#btnAsignar').click(btnGuardarAsignacion);
    procesarGridOblig();
});
function btnGuardarAsignacion(){
    
        confirm.open("Ud est&aacute; seguro de guardar la asignaci&oacuten?");

}

function changeCheckBox() {
    if ($("#checkboxAplica").attr("checked")) {
        $("#aplicaCategorias").show();
    } else {
        $("#aplicaCategorias").hide();
    }
}
function changeCombo() {

    $("#cmbbuNormaBaseLegal").change(function() {
        var num = $('#cmbbuNormaBaseLegal option:selected').text();

        if (num == '--Seleccione--') {
            $("#text4").hide();

        } else if (num == 'Norma Técnica Peruana') {
            $("#text4").show();
        } else if (num == 'NFPA') {
            $("#text4").show();
        }
    });
}
function initInicio() {
    
    
    
    confirm.start();    
    $("#options").puipanel({
        toggleable: true,
        collapsed: true

    });
    
    $("#new_dtpFechaCaptura").datepicker();
    $("#cmbbuAnoBaseLegal").spinner({max: 2014}, {min: 1930});
    $("#datepickerart1").datepicker();
    $("#datepickervig1").datepicker();
    $("#datepickerpub1").datepicker();
    
    $("#dialogNuevaFoto").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    $("#btnNuevecito").click(function(){
        $("#dialogNuevaFoto").dialog("open");
    });
    $("#dialogArbolBusqueda").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    $("#dialogArbolBusquedaProducto").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    $("#dialogArbolBusquedaProducto1").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    $('#btnProductos').click(function() {
        $("#dialogArbolBusquedaProducto1").dialog("open");
    });
    $("#dialogArbolBusquedaTransporte").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    $('#btnTransportes').click(function() {
        $("#dialogArbolBusquedaTransporte").dialog("open");
    });


    $('#btnProductoClave1').click(function() {
        $("#dialogArbolBusquedaProducto").dialog("open");
    });
    $('#btnActividadClave1').click(function() {
        $("#dialogArbolBusqueda").dialog("open");
    });

    $("#tabs").tabs();
    $("#tabsob").tabs();
    $("#btnClose").click(function() {
        $("#dialogAgregarObligacionNormativa").dialog("close");
    });
    //regresa a la URL indicada
    
    $("#spinnerhasta").spinner({min: 0}, {max: 300}, {disabled: true});

    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/indice';
    });
    $("#dialogAgregarObligacionNormativa").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    $("#dialogGenerarRelaciones").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });

    //$('#btnAsignar').click(function(){
    //$("#dialogGenerarRelaciones").dialog("open");
    //});
    $('#btnNuevoObligacionNormativa').click(function() {
        $("#dialogAgregarObligacionNormativa").dialog("open");
    });
    $("#dialogUpload").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    $("#dialogUpload1").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    $('#imgUpload').click(function() {
        $("#dialogUpload").dialog("open");
    });
    $('#imgUpload1').click(function() {
        $("#dialogUpload1").dialog("open");
    });


    $('#guardarUpload').click(function() {

        $("#imgcargar").show();
        $("#dialogUpload").dialog("close");

        $("#file_name").text($("#fileArchivo").val());
        $("#txtImgUpload").text($("#fileupload").val());


    });
    $('#guardarUpload1').click(function() {

        $("#imgcargar1").show();
        $("#dialogUpload1").dialog("close");

        $("#file_name").text($("#fileArchivo").val());
        $("#txtImgUpload1").text($("#fileupload1").val());


    });

    $('#btnFormActividad').click(function() {
        abrirArbolActividades();
    });
}
function abrirArbolActividades() {

    $.ajax({
        url: baseURL + "pages/obligacionNormativa/abrirArbolActividad",
        type: 'get',
        async: false,
        data: {
        },
        beforeSend: muestraLoading,
        success: function(data) {
            ocultaLoading();
            $("#dialogArbolActividades").html(data);
            $("#dialogArbolActividades").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height: "auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: "ARBOL DE ACTIVIDADES"
            });

        },
        error: errorAjax
    });

}
//funciones ...(3)
//funcion para llenar el grid ...inicializada en (1)
function procesarGridProcedimientotab1() {

    var mydata = [
        {id: "BL001", invdate: "Art. 42° de Reglamento Aprobado por DS. N° 054-1993-EM", tieneAct: 0},
        {id: "BL002", invdate: "Art. 43° de Reglamento Aprobado por DS. N° 054-1993-EM", tieneAct: 0},
        {id: "BL003", invdate: "Art. 44° de Reglamento Aprobado por DS. N° 054-1993-EM", tieneAct: 0},
        {id: "BL004", invdate: "Art. 45° de Reglamento Aprobado por DS. N° 054-1993-EM", tieneAct: 0},
        {id: "BL005", invdate: "Art. 46° de Reglamento Aprobado por DS. N° 054-1993-EM", tieneAct: 0},
        {id: "BL006", invdate: "Art. 47° de Reglamento Aprobado por DS. N° 054-1993-EM", tieneAct: 0},
        {id: "BL007", invdate: "Art. 48° de Reglamento Aprobado por DS. N° 054-1993-EM", tieneAct: 0},
        {id: "BL008", invdate: "Art. 49° de Reglamento Aprobado por DS. N° 054-1993-EM", tieneAct: 0}

    ];


    jQuery("#list9").jqGrid({
        //url:'server.php?q=2&nd='+new Date().getTime(), 
        datatype: "local",
        colNames: ['CODIGO BASE LEGAL', 'DESCRIPCION BASE LEGAL'],
        colModel: [{name: 'id', index: 'id', width: 150},
            {name: 'invdate', index: 'invdate', width: 750}],
        rowNum: 10,
        pager: '#pager9',
        sortname: 'id',
        recordpos: 'left',
        viewrecords: true,
        sortorder: "desc",
        multiselect: true,
        hidegrid: false,
        caption: "Busqueda Avanzada Base Legal",
        loadComplete: function(data) {
            for (var i = 0; i <= mydata.length; i++) {
                jQuery("#list9").jqGrid('addRowData', i + 1, mydata[i]);
            }
        }

    }

    );
    jQuery("#list9").jqGrid('navGrid', '#pager9', {add: false, del: false, edit: false, position: 'center'});
}
function procesarGridProcedimientotab2() {

    var mydata = [
        {id: "BL001", invdate: "Art. 42° de Reglamento Aprobado por DS. N° 054-1993-EM", tieneAct: 0},
        {id: "BL005", invdate: "Art. 46° de Reglamento Aprobado por DS. N° 054-1993-EM", tieneAct: 0},
        {id: "BL006", invdate: "Art. 47° de Reglamento Aprobado por DS. N° 054-1993-EM", tieneAct: 0},
        {id: "BL007", invdate: "Art. 48° de Reglamento Aprobado por DS. N° 054-1993-EM", tieneAct: 0}


    ];


    jQuery("#list10").jqGrid({
        //url:'server.php?q=2&nd='+new Date().getTime(), 
        datatype: "local",
        colNames: ['CODIGO BASE LEGAL', 'DESCRIPCION BASE LEGAL'],
        colModel: [{name: 'id', index: 'id', width: 150},
            {name: 'invdate', index: 'invdate', width: 750}],
        rowNum: 10,
        pager: '#pager10',
        sortname: 'id',
        recordpos: 'left',
        viewrecords: true,
        sortorder: "desc",
        multiselect: false,
        hidegrid: false,
        caption: "Asignado Base Legal",
        loadComplete: function(data) {
            for (var i = 0; i <= mydata.length; i++) {
                jQuery("#list10").jqGrid('addRowData', i + 1, mydata[i]);
            }
        },
    }

    );
    jQuery("#list10").jqGrid('navGrid', '#pager10', {add: false, del: false, edit: false, position: 'center'});
}
function asignarBaseLegal(rowid) {
    var row = $('#gridObligacionNormativa').jqGrid('getRowData', rowid);
    $("#dialogGenerarRelaciones").dialog("open");

}
//grid de fotos
function img(imgs){
    
    if(imgs==1){
    var detalle="";
       detalle="<img src=\""+baseURL+"/images/stickers.png\" onclick=\"redirectPagina('/mgo/pages/baseLegal')\"  style=\"cursor: pointer;\" alt=\"detalle\" title=\"Detalle\" height=\"20\"  width=\"18\" />";   
       return detalle;
   }else{
       detalle="";
       return detalle;
   }

}
function procesarGridFotos() {
    var mydata = [
        {nomArchivo: "Pauta-Puertas", titArchivo: "Pauta de Puertas",desArchivo: "puertas pintadas a mano",fecArchivo: "23/12/2013", tieneAct: 0,Img_Descarga:1},
        {nomArchivo: "Pauta-Puertas", titArchivo: "Pauta de Puertas",desArchivo: "puertas pintadas a mano",fecArchivo: "23/12/2013", tieneAct: 0,Img_Descarga:1},
        {nomArchivo: "Pauta-Puertas", titArchivo: "Pauta de Puertas",desArchivo: "puertas pintadas a mano",fecArchivo: "23/12/2013", tieneAct: 0,Img_Descarga:1},
        {nomArchivo: "Pauta-Puertas", titArchivo: "Pauta de Puertas",desArchivo: "puertas pintadas a mano",fecArchivo: "23/12/2013", tieneAct: 0,Img_Descarga:1},
        {nomArchivo: "Pauta-Puertas", titArchivo: "Pauta de Puertas",desArchivo: "puertas pintadas a mano",fecArchivo: "23/12/2013", tieneAct: 0,Img_Descarga:1}  
       
       
    ];
    
    var nombres = ['Nombre Archivo', 'Título','Descripción','Fecha Subida', 'tieneAct','Descargar'];
    var columnas = [
        {name: "nomArchivo", width: 150, sortable: false, align: "center"},
        {name: "titArchivo", width: 180, sortable: false, align: "justify"},
        {name: "desArchivo", width: 350, sortable: false, align: "center"},
        {name: "fecArchivo", width: 150, sortable: false, align: "justify"},
        {name: "tieneAct", width: 30, sortable: false, hidden: true, align: "center"},
        {name: "Img_Descarga",width: 60,sortable: false,align: "center",formatter:img}

    ];
    

    $("#gridPautas").html("");
    var grid = $("<table>", {
        "id": "gridPautas1"
    });
    var pager = $("<div>", {
        "id": "paginacionPautas"
    });
    $("#gridContenedorPautas").append(grid).append(pager);

    grid.jqGrid({
        // url: baseURL + "pages/busquedaController/find",
        datatype: "local",
        /*postData: {
         codigoOsinerg: $("#txtCodigoOsinerg").val()
         },*/
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionPautas",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Pautas",
        autowidth: true,
        onSelectRow: function(rowid, status) {
            grid.resetSelection();

        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            //$('#linkVerProcedimiento').attr('onClick', 'verProcedimiento("")');
            $('#linkEditarPauta').attr('onClick', 'editarPauta("' + rowid + '")');
            //$('#linkEliminarProcedimiento').attr('onClick', 'eliminarProcedimiento("'+rowid+'")');
            // $('#linkAgregarActProcedimiento').attr('onClick', 'agregarActProcedimiento("'+rowid+'","'+row.codigo+'","'+row.descripcion+'")');
        },
        loadComplete: function(data) {
            for (var i = 0; i <= mydata.length; i++) {
                jQuery("#gridPautas1").jqGrid('addRowData', i + 1, mydata[i]);
            }

            $('#contextMenuPautas').parent().remove();
            $('#divContextMenuPautas').html("<ul id='contextMenuPautas'>"
                    + "<li> <a id='linkEditarPauta' data-icon='ui-icon-pencil' title='Ver Detalle'>Editar</a> </li>"
                    //+ "<li> <a id='linkEditarProcedimiento' data-icon='ui-icon-pencil' title='Editar'>Modificar</a></li>"
                    //+ "<li> <a id='linkEliminarProcedimiento' data-icon='ui-icon-trash' title='Editar'>Eliminar</a></li>"
                    + "<li> <a id='linkEliminarPauta' data-icon='ui-icon-trash' title='Asignar Bases Legales'>Eliminar</a></li>"
                    //+ "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-clipboard' title='Editar'>Gestionar Requisitos</a></li>"
                    + "</ul>");
            $('#contextMenuPautas').puicontextmenu({
                //target: $('#gridObligacionNormativa').find('tr').not('.ui-subgrid,.ui-subgrid tr')
                target: $('#gridPautas1').find('tr').not('.ui-subgrid,.ui-subgrid tr')
            });
        }
        
    });
       
}
//grid de busqueda principal
function procesarGridOblig(varLista) {
	if(varLista==undefined){varLista=1;}
$("#gridContenedorOblig").html("");
var grid = $("<table>", {
    "id": "gridOblig"
});
var pager = $("<div>", {
    "id": "paginacionOblig"
});
$("#gridContenedorOblig").append(grid).append(pager);

var nombres = ['ID','Código Obligacion','Fecha Vigencia','Fecha Publicacion',
                'Indice','Descripcion Obligación','','','','','',''];
var columnas = [
    {name: "idObligacion",width: 130,sortable: false,align: "center",hidden:true},
    {name: "codigoObligacion",width: 150,sortable: false,align: "center"},
    {name: "fechaEntradaVigenciaObligacion",width: 130,sortable: false,align: "center",hidden:true},
    {name: "fechaPublicacionObligacion",width: 130,sortable: false,align: "center",hidden:true},
    {name: "indiceCreacionObligacion",width: 130,sortable: false,align: "center",hidden:true},
    {name: "descripcionObligacion",width: 400,sortable: false,align: "center"},
    {name: "temaObligacion",width: 130,sortable: false,align: "center",hidden:true},
    {name: "criticidadObligacion",width: 130,sortable: false,align: "center",hidden:true},
    {name: "tipificacionObligacion",width: 300,sortable: false,align: "center",hidden:true},
    {name: "descripcionActaObligacion",width: 30,sortable: false,hidden: true,align: "center"},
    {name: "descripcionGuiaObligacion",width: 130,sortable: false,align: "center",hidden:true},
    {name: "tieneAct",width: 130,sortable: false,align: "center",hidden:true}
];
grid.jqGrid({
    url: baseURL + "pages/baseLegal/listarObligacion",
    datatype: "json",
    postData: {
    	descripcion:$('#txtDescObligacionNormativa').val(),
		varLista:varLista
    },
    hidegrid: false,
    rowNum: 7,
    pager: "#paginacionOblig",
    emptyrecords: "No se encontraron resultados",
    loadtext: "Cargando",
    colNames: nombres,
    colModel: columnas,
    height: "auto",
    viewrecords: true,
    caption: "Obligaciones Normativas",
    autowidth: true,
    jsonReader: {
        root: "filas",
        page: "pagina",
        total: "total",
        records: "registros"
    },
    onSelectRow: function(rowid, status) {
        grid.resetSelection();
    },
    onRightClickRow: function(rowid, iRow, iCol, e) {
        var row = grid.jqGrid('getRowData', rowid);
        $('#linkVerBaseLegal').attr('onClick', 'verBaseLegal("'+rowid+'")');
        $('#linkEliminarProcedimiento').attr('onClick', 'eliminarBaseLegal("'+rowid+'")');
        },
    loadComplete: function(data) {
        $('#contextMenuOblig').parent().remove();
        $('#divContextMenuOblig').html("<ul id='contextMenuOblig'>"
                + "<li> <a id='linkVerBaseLegal' data-icon='ui-icon-search' title='Ver Detalle'>Ver Detalle</a> </li>"
                + "<li> <a id='linkEliminarBaseLegal' data-icon='ui-icon-trash' title='Editar'>Eliminar</a></li>"
                + "</ul>");
        $('#contextMenuOblig').puicontextmenu({
            target: $('#gridOblig')
        });
    },
    afterInsertRow: function(rowid, aData, rowelem) {
        var rowData = grid.getRowData(rowid);
        if( rowData["tieneAct"]==0){
            $('tr#'+rowid, grid)
            .children("td.sgcollapsed")
            .html("")
            .removeClass('ui-sgcollapsed sgcollapsed');
        }
    }
});

}
function img(imgs){

if(imgs==1){
    var detalle="";
       detalle="<img src=\""+baseURL+"/images/stickers.png\" onclick=\"redirectPagina('/mgo/pages/baseLegal')\"  style=\"cursor: pointer;\" alt=\"detalle\" title=\"Detalle\" height=\"20\"  width=\"18\" />";   
       return detalle;
    }else{
       detalle="";
       return detalle;
    }
}
//Grid Bases Legales
function gridBasesLegales() {
    var mydata = [
        {Codigo_BaseLegal: "DBL001", Desc_BaseLegal: "Decreto Supremo N° 054-93-EM Reglamento Artículo 42°", tieneAct: 0},
        {Codigo_BaseLegal: "DBL002", Desc_BaseLegal: "Decreto Supremo N° 054-93-EM Reglamento Artículo 43°", tieneAct: 0},
        {Codigo_BaseLegal: "DBL003", Desc_BaseLegal: "Decreto Supremo N° 054-93-EM Reglamento Artículo 57°", tieneAct: 0}

    ];

    var nombres = ['Código Base Legal', 'Descripción Base Legal', 'tieneAct'];
    var columnas = [
        {name: "Codigo_BaseLegal", width: 130, sortable: false, align: "center"},
        {name: "Desc_BaseLegal", width: 800, sortable: false, align: "center"},
        {name: "tieneAct", width: 30, sortable: false, hidden: true, align: "center"}
    ];


    $("#gridBasesLegales").html("");
    var grid = $("<table>", {
        "id": "gridBasesLegales"
    });
    var pager = $("<div>", {
        "id": "paginacionBasesLegales"
    });
    $("#gridContenedorBaseLegal").append(grid).append(pager);

    grid.jqGrid({
        // url: baseURL + "pages/busquedaController/find",
        datatype: "local",
        /*postData: {
         codigoOsinerg: $("#txtCodigoOsinerg").val()
         },*/
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionBasesLegales",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Bases Legales",
        autowidth: true,
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkVerProcedimiento').attr('onClick', 'verProcedimiento("")');
            $('#linkEditarProcedimiento').attr('onClick', 'editarProcedimiento("")');
            $('#linkEliminarProcedimiento').attr('onClick', 'eliminarProcedimiento("' + rowid + '")');
            $('#linkAgregarActProcedimiento').attr('onClick', 'agregarActProcedimiento("' + rowid + '","' + row.codigo + '","' + row.descripcion + '")');
        },
        loadComplete: function(data) {
            for (var i = 0; i <= mydata.length; i++) {
                jQuery("#gridBasesLegales").jqGrid('addRowData', i + 1, mydata[i]);
            }

            $('#contextMenuBaseLegal').parent().remove();
            //$('#divContextMenuBaseLegal').html("<ul id='contextMenuBaseLegal'>"
            // + "<li> <a id='linkAtenderUnidad' data-icon='ui-icon-search' title='Ver Detalle'>Ver Detalle</a> </li>"
            //+ "<li> <a id='linkEditarProcedimiento' data-icon='ui-icon-pencil' title='Editar'>Modificar</a></li>"
            //+ "<li> <a id='linkEliminarProcedimiento' data-icon='ui-icon-trash' title='Editar'>Eliminar</a></li>"
            //+ "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Editar'>Agregar Tramite-Actividad</a></li>"
            //+ "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-clipboard' title='Editar'>Gestionar Requisitos</a></li>"
            //       + "</ul>");
            $('#contextMenuBaseLegal').puicontextmenu({
                target: $('#gridBasesLegales').find('tr').not('.ui-subgrid,.ui-subgrid tr')
            });
        },
        //SUBGRID
        subGrid: true,
        afterInsertRow: function(rowid, aData, rowelem) {
            var rowData = grid.getRowData(rowid);
            if (rowData["tieneAct"] == 0) {
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
                loadComplete: function(data) {
                    for (var i = 0; i <= mydataSubGrid.length; i++) {
                        jQuery("#" + subgrid_table_id).jqGrid('addRowData', i + 1, mydataSubGrid[i]);
                    }
                },
            });
        }
    });
}
function initArbolActividadesAsignar() {
    $("#arbolActividadesAgregar").fancytree({
        checkbox: true,
        selectMode: 3,
        //source:treeData,
        select: function(event, data) {
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node) {
                if (!node.folder) {
                    return "{id:'" + node.key + "',nombre:'" + node.title + "'}";
                }
            });

        },
        keydown: function(event, data) {
            if (event.which === 32) {
                data.node.toggleSelected();
                return false;
            }
        },
        //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
        //initId: "treeData",
        cookieId: "fancytree-Cb1",
        idPrefix: "fancytree-Cb1-"
    });

    $("#arbolActividadesAgregar").fancytree("getRootNode").visit(function(node) {
        node.setExpanded(true);
    });

}
function initArbolActividades() {
    $("#arbolActividades").fancytree({
        checkbox: true,
        selectMode: 3,
        //source:treeData,
        select: function(event, data) {
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node) {
                if (!node.folder) {
                    return "{id:'" + node.key + "',nombre:'" + node.title + "'}";
                }
            });

        },
        keydown: function(event, data) {
            if (event.which === 32) {
                data.node.toggleSelected();
                return false;
            }
        },
        //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
        //initId: "treeData",
        cookieId: "fancytree-Cb1",
        idPrefix: "fancytree-Cb1-"
    });

    $("#arbolActividades").fancytree("getRootNode").visit(function(node) {
        node.setExpanded(true);
    });

}
function initArbolProductosAsignar() {
    $("#arbolProductosAgregar").fancytree({
        checkbox: true,
        selectMode: 3,
        //source:treeData,
        select: function(event, data) {
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node) {
                if (!node.folder) {
                    return "{id:'" + node.key + "',nombre:'" + node.title + "'}";
                }
            });

        },
        keydown: function(event, data) {
            if (event.which === 32) {
                data.node.toggleSelected();
                return false;
            }
        },
        //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
        //initId: "treeData",
        cookieId: "fancytree-Cb1",
        idPrefix: "fancytree-Cb1-"
    });

    $("#arbolProductosAgregar").fancytree("getRootNode").visit(function(node) {
        node.setExpanded(true);
    });

}
function initArbolProductos() {
    $("#arbolProductos").fancytree({
        checkbox: true,
        selectMode: 3,
        //source:treeData,
        select: function(event, data) {
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node) {
                if (!node.folder) {
                    return "{id:'" + node.key + "',nombre:'" + node.title + "'}";
                }
            });

        },
        keydown: function(event, data) {
            if (event.which === 32) {
                data.node.toggleSelected();
                return false;
            }
        },
        //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
        //initId: "treeData",
        cookieId: "fancytree-Cb1",
        idPrefix: "fancytree-Cb1-"
    });

    $("#arbolProductos").fancytree("getRootNode").visit(function(node) {
        node.setExpanded(true);
    });

}