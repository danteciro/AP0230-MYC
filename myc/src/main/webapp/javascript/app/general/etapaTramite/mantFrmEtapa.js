$(function() {
    $('#frmMantEtapa').validarForm();
    procesarGridEtapaUtil(1, $("#cmbProcesoNuevo").val());
    boton.closeDialog();
    anularEnter();
    initMantFrmEtapa();
});
function initMantFrmEtapa(){
    $('#btnBuscarEtapa').click(function(){procesarGridEtapaUtil("1",$('#cmbProceso').val());});
    $('#btnRegistrarEtapa').click(btnGuardarEtapaUtil);
    $('#btnEditarEtapaUtil').click(btnEditarEtapaUtil);
    $('#btnCancelarUtil').click(limpiarMantFrmEtapa);
}
//NUEVO
function btnGuardarEtapaUtil() {
    var validar=$('#frmMantEtapa').validateAllForm("#divMensajeValidaEtapa");
    if(validar){
            confirm.open("¿Desea registrar esta Etapa?", "procGuardarEtapaUtil()");
    }        
}
function procGuardarEtapaUtil() {
    $.ajax({
        url:baseURL + "pages/etapaTramite/registrarEtapa",
        type:'post',
        async:false,
        data: {
            idProceso:$('#cmbProceso').val(),
            descripcionEtapa:$('#txtDescripcion').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridEtapaUtil("1",$('#cmbProceso').val());
                //fill.combo(data.listadoEtapa,'idEtapa','descripcion','#cmbEtapa');
                $('#cmbProcesoNuevo').trigger("change");
                limpiarMantFrmEtapa();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//EDITAR
function editarEtapaUtil(rowid){
    var row = $('#gridEtapaUtil').jqGrid('getRowData', rowid);
    $('#txtIdEtapa').val(row["idEtapa"]);
    $('#txtIdProceso').val(row["idProceso"]);
    $('#cmbProceso').val(row["idProceso"]);
    $('#txtDescripcion').val(row["descripcion"]);
    
    $('#btnEditarEtapaUtil').css('display','inline-block');
    $('#btnCancelarUtil').css('display','inline-block');
    $('#btnRegistrarEtapa').hide();
    $('#btnBuscarEtapa').hide();
}
function btnEditarEtapaUtil(){
    $('#txtDescripcion').val($('#txtDescripcion').val().trim());
    var validar = $('#frmMantEtapa').validateAllForm("#divMensajeValidaEtapa");
    if (validar) {
        confirm.open("¿Ud. est&aacute; seguro de guardar los cambios en esta etapa?", "procEditarEtapaUtil()");
    }
}
function procEditarEtapaUtil() {
    $.ajax({
        url:baseURL + "pages/etapaTramite/editarEtapa",
        type:'post',
        async:false,
        data:$('#frmMantEtapa').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridEtapaUtil("1",$('#cmbProceso').val());
                //fill.combo(data.listadoEtapa,'idEtapa','descripcion','#cmbEtapa');
                $('#cmbProceso').trigger("change");
                limpiarMantFrmEtapa();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//eliminar
function eliminarEtapaUtil(rowid) {
    var row = $('#gridEtapaUtil').jqGrid('getRowData', rowid);
    confirm.open("¿Ud. est&aacute; seguro de eliminar la etapa?", "procEliminarEtapaUtil('" + row.idEtapa + "')");
}
function procEliminarEtapaUtil(id) {
    $.ajax({
        url:baseURL + "pages/etapaTramite/eliminarEtapa",
        type:'post',
        async:false,
        data:{
            idEtapa:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridEtapaUtil("1",$('#cmbProceso').val());
                $('#cmbProceso').trigger("change");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}


//LIMPIAR
function limpiarMantFrmEtapa(){
    $('#txtDescripcion,#txtIdEtapa,#txtIdProceso').val("");
    $('#btnEditarEtapaUtil').css('display','none');
    $('#btnCancelarUtil').css('display','none');
    $('#btnRegistrarEtapa').show();
    $('#btnBuscarEtapa').show();
}


function procesarGridEtapaUtil(flg_load,idProceso) {
	if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorEtapa").html("");
    var grid = $("<table>", {
        "id": "gridEtapaUtil"
    });
    var pager = $("<div>", {
        "id": "paginacionEtapa"
    });
    $("#gridContenedorEtapa").append(grid).append(pager);

    var nombres = ['ID', 'PROCESO', 'ETAPA', 'IDPROCESO'];
    var columnas = [
        {name: "idEtapa", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "proceso", width: 150, sortable: false, hidden: false, align: "center"},
        {name: "descripcion", width: 350, sortable: false, hidden: false, align: "left"},
        {name: "idProceso", width: 150, sortable: false, hidden: true, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/etapaTramite/listarEtapa",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            idProcesoBusqueda: idProceso,
            descripcion:$('#txtDescripcion').val()
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionEtapa",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Etapas",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idEtapa"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            $('#linkEditarEtapaUtil').attr('onClick','editarEtapaUtil("'+rowid+'")');
            $('#linkEliminarEtapaUtil').attr('onClick', 'eliminarEtapaUtil("' + rowid + '")');
            
            $('#linkSeleccionarEtapaUtil').attr('onClick', 'seleccionarEtapaUtil("' + rowid+'")');
            $('#linkGestionarTramite').attr('onClick', 'gestionarTramite("' + rowid + '")');
            
            if($('#divEnlaceTagEditarEpata input').html()!=null){
                $('#contextMenuEtapa li a[value="MO-ETAPA"]').html($('#divEnlaceTagEditarEpata').html());
             } else {
                $('#contextMenuEtapa li a[value="MO-ETAPA"]').remove();
             }
            
            if($('#divEnlaceTagEliminarEpata input').html()!=null){
                $('#contextMenuEtapa li a[value="EL-ETAPA"]').html($('#divEnlaceTagEliminarEpata').html());
             } else {
                $('#contextMenuEtapa li a[value="EL-ETAPA"]').remove();
             }
            
            if($('#divEnlaceTagSeleccionarEpata input').html()!=null){
                $('#contextMenuEtapa li a[value="CO-ETAPA"]').html($('#divEnlaceTagSeleccionarEpata').html());
             } else {
                $('#contextMenuEtapa li a[value="CO-ETAPA"]').remove();
             }
        },
        loadComplete: function(data) {
            $('#contextMenuEtapa').parent().remove();
            $('#divContextMenuEtapa').html("<ul id='contextMenuEtapa'>"
            		+ "<li> <a value='MO-ETAPA'></a></li>"
            		+ "<li> <a value='EL-ETAPA'></a></li>"
            		+ "<li> <a value='CO-ETAPA'></a></li>"
                    + "</ul>");
            $('#contextMenuEtapa').puicontextmenu({
                target: $('#gridEtapaUtil')
            });
//        onRightClickRow: function(rowid, iRow, iCol, e) {
//            $('#linkEditarEtapaUtil').attr('onClick','editarEtapaUtil("'+rowid+'")');
//            $('#linkEliminarEtapaUtil').attr('onClick', 'eliminarEtapaUtil("' + rowid + '")');
//            
//            $('#linkSeleccionarEtapaUtil').attr('onClick', 'seleccionarEtapaUtil("' + rowid+'")');
//            $('#linkGestionarTramite').attr('onClick', 'gestionarTramite("' + rowid + '")');
//        },
//        loadComplete: function(data) {
//            $('#contextMenuEtapa').parent().remove();
//            $('#divContextMenuEtapa').html("<ul id='contextMenuEtapa'>"
//            		+ "<li> <a id='linkEditarEtapaUtil' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
//            		+ "<li> <a id='linkEliminarEtapaUtil' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//            		+ "<li> <a id='linkSeleccionarEtapaUtil' data-icon='ui-icon-check' title='Seleccionar'>Seleccionar</a></li>"
//                    + "</ul>");
//            $('#contextMenuEtapa').puicontextmenu({
//                target: $('#gridEtapaUtil')
//            });
        }
    });
}
function seleccionarEtapaUtil(rowid,tipo){
    var row = $('#gridEtapaUtil').jqGrid('getRowData', rowid);
    $('#cmbProcesoNuevo').val(row["idProceso"]);
    obtenerEtapa($('#cmbProcesoNuevo').val());
    setTimeout(function(){ $('#cmbEtapa').val(row["idEtapa"]); $('#cmbEtapa').trigger("change"); }, 500);
    $("#dialogMantEtapa").dialog("close");
}
