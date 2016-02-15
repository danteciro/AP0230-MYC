var idTipiSanc;//listad de id de tipisanc para arbol
//var idTipSan;
$(function() {
    procesarGridTipificacion(0);
    initInicioTipificacion();  
});


function initInicioTipificacion(){
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    confirm.start();
    $('#btnBuscarTipi').click(function(){procesarGridTipificacion();});
    $('#btnNuevoTipi').click(function(){abrirMantTipificacion("new",'');});   
    $('#btnLimpiarForm').click(btnLimpiarForm);
}


function btnLimpiarForm(){
    $('#formBusqueda').find('input, select').val('');
 
}

//NUEVO REQUISITO - INICIO
function abrirMantTipificacion(tipo,rowid){
    var title="CONSULTAR TIPIFICACION";
    if(tipo=='edit'){
        title="EDITAR TIPIFICACION";
    }else if(tipo=='new'){
        title="NUEVO TIPIFICACION";
    }    
    $.ajax({
        url:baseURL + "pages/tipificacion/abrirMantTipificacion", 
        type:'get',
        async:false,
        data:{
            tipo:tipo,
            idTipificacion:rowid
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantTipificacion").html(data);
            $("#dialogMantTipificacion").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "800",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
        },
        error:errorAjax
    });
}
function procGuardarRequ(){
    $.ajax({
        url:baseURL + "pages/requisito/registrarRequisito",
        type:'post',
        async:false,
        data:{idRequisito:$('#txtIdRequisito').val(),descripcion:$('#txtDescRequ').val(),comentarioPredeterminado:$('#txtComentarioRequ').val()},
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridRequisito();
                $("#dialogMantRequisito").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//NUEVO REQUISITO - FIN
//EDITAR REQUISITO - INICIO
function procEditarRequ(){
    //$('#txtFileNameArchivoRequisito').removeAttr('disabled');//TODO para enviar en serialize
    var flgEditComePred=0;
    if( $('#txtTipo').val()=='edit' && $('#edit_comePre').val()!=$('#txtComentarioRequ').val() ){
        flgEditComePred=1;
    }
    $.ajax({
        url:baseURL + "pages/requisito/editarRequisito",
        type:'post',
        async:false,
        data:{idRequisito:$('#txtIdRequisito').val(),descripcion:$('#txtDescRequ').val(),comentarioPredeterminado:$('#txtComentarioRequ').val(),flgEditoComentario:flgEditComePred},
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
           
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", "Se registró correctamente los cambios", "");
                procesarGridRequisito();
                $("#dialogMantRequisito").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
    //$('#txtFileNameArchivoRequisito').attr('disabled','disabled');//TODO para enviar en serialize
}
//EDITAR REQUISITO - FIN
//ELIMINAR REQUISITO - INICIO
function eliminarTipificacion(rowid){
    var row = $('#gridTipificacion').jqGrid('getRowData', rowid);
    confirm.open("¿Ud. est&aacute; seguro de eliminar esta tipificacion?","procEliminarTipificacion('"+row.idTipificacion+"')");
}
function procEliminarTipificacion(id){
    $.ajax({
        url:baseURL + "pages/tipificacion/eliminarTipificacion",
        type:'post',
        async:false,
        data:{
            idTipificacion:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridTipificacion();
            }else if(data.resultado=="DEPENDENCE"){
            	mensajeGrowl("warn", "Para eliminar el requisito, primero debe desasignarlo del Procedimiento", "");
            } else {
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//ELIMINAR REQUISITO - FIN
///////////////////////////
function procesarGridTipificacion(flg_load){
    if(flg_load==undefined){flg_load=1;}
    
    $("#gridContenedorTipificacion").html("");
    var grid = $("<table>", {
        "id": "gridTipificacion"
    });
    var pager = $("<div>", {
        "id": "paginacionTipificacion"
    });
    $("#gridContenedorTipificacion").append(grid).append(pager);

    var nombres = ['IDTIPIFICACIÓN','DESCRIPCIÓN','TIPO SANCIÓN','SANC. MONETARIA','CODIGO TIPIFICACIÓN','idTipificacionPadre','CODIGO TIPIFICACIÓN PADRE','tieneSanc'];
    var columnas = [
        {name: "idTipificacion",width: 50,sortable: false,align: "center",hidden:true},
        {name: "descripcion",width: 50,sortable: false,align: "center"}, 
        {name: "descClaseSancion",width: 35,sortable: false,align: "center"},
        {name: "sancionMonetaria",width: 35,sortable: false,align: "center"},
        {name: "codTipificacion",width: 50,sortable: false,align: "center"},
        {name: "idTipificacionPadre",width: 50,sortable: false,hidden: true,align: "center"},
        {name: "descTipiPadre",width: 50,sortable: false,align: "center"},        
        {name: "tieneSanc",width: 30,sortable: false,hidden: true,align: "center"}
    ];
    var nombresSubGrid = ['SANCION ADMINISTRATIVA'];
    var columnasSubGrid = [{name: "descripcionSancion",width: 450,sortable: false,align: "left"}];
    grid.jqGrid({
        url: baseURL + "pages/tipificacion/findTipificacion",
        datatype: "json",
        postData: {
            codTipificacion:$('#txtCodTipi').val(),
            descripcion:$('#txtDescTipi').val(),
            flg_load:flg_load
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionTipificacion",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Tipificaciones",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idTipificacion"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkVerTipificacion').attr('onClick', 'abrirMantTipificacion("view","'+rowid+'")');
            $('#linkEditarTipificacion').attr('onClick', 'abrirMantTipificacion("edit","'+rowid+'")');
            $('#linkEliminarTipificacion').attr('onClick', 'eliminarTipificacion("'+rowid+'")');
        },
        loadComplete: function(data) {
            $('#contextMenuTipificacion').parent().remove();
            $('#divContextMenuTipificacion').html("<ul id='contextMenuTipificacion'>"
                    + "<li> <a id='linkVerTipificacion' data-icon='ui-icon-search' title='Ver Detalle'>Consultar</a> </li>"
                    + "<li> <a id='linkEditarTipificacion' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarTipificacion' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuTipificacion').puicontextmenu({
                target: $('#gridTipificacion')
            });
        },
        //SUBGRID
        subGrid: true, 
        afterInsertRow: function(rowid, aData, rowelem) {
            var rowData = grid.getRowData(rowid);
            if( rowData["tieneSanc"]==0){
                $('tr#'+rowid, grid)
                .children("td.sgcollapsed")
                .html("")
                .removeClass('ui-sgcollapsed sgcollapsed');
            }
        },
        subGridOptions: { 
            "plusicon"  : "ui-icon-circle-plus",
            "minusicon" : "ui-icon-circle-minus",
            "openicon" : "ui-icon-arrowreturn-1-e", 
            "reloadOnExpand" : true, 
            "selectOnExpand" : true 
        }, 
        subGridRowExpanded: function(subgrid_id, row_id) { 
            var subgrid_table_id, pager_id; 
            subgrid_table_id = subgrid_id+"_t"; 
            pager_id = "p_"+subgrid_table_id; 
            $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>"); 
            jQuery("#"+subgrid_table_id).jqGrid({ 
                url: baseURL + "pages/tipificacion/findTipificacionSancion",
                datatype: "json", 
                postData: {
                    idTipificacion:row_id,
                    flg_load:1
                },
                colNames: nombresSubGrid,
                colModel: columnasSubGrid,
                rowNum:global.rowNum, 
                pager: pager_id, 
                sortname: 'num', 
                sortorder: "asc", 
                height: '100%',
                autowidth: true,
                viewrecords: true,
                jsonReader: {
                    root: "filas",
                    page: "pagina",
                    total: "total",
                    records: "registros",
                    repeatitems: false,
                    id: "idActividad"
                },
                loadComplete: function(data) {
                    $('#contextMenuTipificacionSub').parent().remove();
                    $('#divContextMenuTipificacionSub').html("<ul id='contextMenuTipificacionSub'>"
                            + "<li> Sin Accion </li>"
                            + "</ul>");
                    $('#contextMenuTipificacionSub').puicontextmenu({
                        target: $("#gridTipificacion .ui-subgrid")
                    });
                    $('#contextMenuTipificacionSub').parent().css('opacity',0);
                }
            }); 
        }
    });
}