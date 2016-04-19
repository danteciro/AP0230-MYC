//se usa en casos edit(editar), view(consultar) procedimiento
var idSileAdmi;
var idTramites;
var idActividades;
$(function() {
    procesarGridProcedimiento("0");
    initInicioProc();
});
function initInicioProc(){
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoRequisitos';
    });
    confirm.start();
    $('#btnBuscarProc').click(function(){procesarGridProcedimiento();});
    $('#cmbProcesoBusq').change(function(){cargaEtapa(fill.combo,"#cmbProcesoBusq",'#cmbEtapaBusq');fill.clean('#cmbTramiteBusq');});
    $('#cmbEtapaBusq').change(function(){cargaTramite(fill.combo,"#cmbEtapaBusq",'#cmbTramiteBusq');});
    $('#btnNuevoProc').click(function(){abrirMantProcedimiento("new");});
    $('#btnLimpiarForm').click(btnLimpiarForm);
    //ALPHANUM
    //$('#txtItemProcBusq').alphanum(alphaNumOptions);
}

function btnLimpiarForm(){
    $('#buscarProc').find('input, select').val('');
    $('#cmbEtapaBusq').trigger('change');
    $('#txtActivP1').attr('title','');
}

function abrirMantProcedimiento(tipo,rowid){
    var title="CONSULTAR PROCEDIMIENTO";
    if(tipo=='edit'){
        title="EDITAR PROCEDIMIENTO";
    }else if(tipo=='new'){
        title="NUEVO PROCEDIMIENTO";
    }
    var row = $('#gridProcedimiento').jqGrid('getRowData', rowid);
    $.ajax({
        url:baseURL + "pages/procedimiento/abrirMantProcedimiento", 
        type:'get',
        async:false,
        data:{
            tipo:tipo,
            idProcedimiento:rowid,
            idProceso:row.idProceso,
            idEtapa:row.idEtapa
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantProcedimiento").html(data);
            $("#dialogMantProcedimiento").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText:"Cerrar"
            });
            if(tipo=="view"){
                $('#frmMantProcedimiento').find('input,select,textarea').attr('disabled',true);
            }
        },
        error:errorAjax
    });
}
/////////////////////////
function validarManualMantProc(){
    var retorno=true;
    if ( $('#txtPlazoResolver').val()!="" && (isNaN($('#txtPlazoResolver').val()) || $('#txtPlazoResolver').val()<=0) ){
        muestraDivError("#divMensajeValidaProcedimiento","Número de dias hábiles debe ser mayor a cero","#txtPlazoResolver");
        retorno=false;
    }
    if ( $('#txtPorcUIT').attr('validate')!=undefined && $('#txtPorcUIT').attr('validate').indexOf("[O]")>=0 
            && (isNaN($('#txtPorcUIT').val()) || $('#txtPorcUIT').val()<=0) ){
        muestraDivError("#divMensajeValidaProcedimiento","En % UIT: el número debe ser mayor a cero.","#txtPorcUIT");
        retorno=false;
    }
    return retorno;
}
// PROC NUEVO - INICIO 
function btnGuardarProc(){
    if ( validarManualMantProc() && $('#frmMantProcedimiento').validateAllForm("#divMensajeValidaProcedimiento") ) {
        confirm.open("¿Ud est&aacute; seguro de Guardar este nuevo Procedimiento?","procGuardarProc()");
    }
}
function procGuardarProc(){
    settearNamesFormMantProcedimiento();
    
    $.ajax({
        url:baseURL + "pages/procedimiento/registrarProcedimiento",
        type:'post',
        async:false,
        data:$('#frmMantProcedimiento').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridProcedimiento();
                $('#dialogMantProcedimiento').dialog('close');
                confirm.open("¿Desea gestionar requisitos para este nuevo procedimiento?","gestionarRequProcedimientoForm('"+data.procedimiento.idProcedimiento+"','"+$('#txtItemProc').val()+"','"+$('#txtDenominacionProc').val()+"')",{textAceptar:'SI',textCancelar:'NO'});    
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
// PROC NUEVO - FIN 
// EDITAR PROC - INICIO
function btnEditarProc(){
    if ( validarManualMantProc() && $('#frmMantProcedimiento').validateAllForm("#divMensajeValidaProcedimiento") ) {
        //confirm.open("¿Ud est&aacute; seguro de Guardar los Cambios en este Procedimiento?","procEditarProc()");
        validarDependProcedimiento();
    }
};
function validarDependProcedimiento(){
    settearNamesFormMantProcedimiento();
    
    $.ajax({
        url:baseURL + "pages/procedimiento/validarDependProcedimiento",
        type:'post',
        async:false,
        data:$('#frmMantProcedimiento').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="RESTRICT"){
                mensajeGrowl("warn", data.mensaje, "");
            }else if(data.resultado=="DEPENDENCE"){
            	confirm.open(data.mensaje,"procEditarProc()");
            }else if(data.resultado=="SUCCESS") {
                confirm.open(data.mensaje,"procEditarProc()");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function procEditarProc(){
    settearNamesFormMantProcedimiento();
    
    $.ajax({
        url:baseURL + "pages/procedimiento/editarProcedimiento",
        type:'post',
        async:false,
        data:$('#frmMantProcedimiento').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridProcedimiento();
                $('#dialogMantProcedimiento').dialog('close');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function settearNamesFormMantProcedimiento(){
    //coloca name a input check tramites seleccionados
    var cont=0;
    $('#contTramites').find('input').removeAttr('name');//limpia names
    $('#contTramites').find('input:checked').map(function(){//busca marcados con check
      $(this).attr('name','tramites['+cont+'].idTramite');//les coloca names
      cont++;
    });
    //coloca name a input check actividades seleccionados
    cont=0;
    $('#idActividadesAgregarSelect').find('input:checked').map(function(){//busca marcados con check
      $(this).attr('name','actividades['+cont+'].idActividad');//les coloca names
      cont++;
    });
}
//EDITAR REQUISITO - FIN
//ELIMINAR REQUISITO - INICIO
function eliminarProcedimiento(rowid){
    confirm.open("¿Ud est&aacute; seguro de eliminar este Procedimiento?","procEliminarProc('"+rowid+"')");
}
function procEliminarProc(id){
    $.ajax({
        url:baseURL + "pages/procedimiento/eliminarProcedimiento",
        type:'post',
        async:false,
        data:{
            idProcedimiento:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridProcedimiento();
            }else if(data.resultado=="RESTRICT"){
                mensajeGrowl("warn", data.mensaje, "");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//ELIMINAR REQUISITO - FIN

function gestionarRequProcedimiento(rowid) {
    $('#postGestionarRequisitos').find('input').val('');
    var row = $('#gridProcedimiento').jqGrid('getRowData', rowid);
    $('#idProcedimientoP').val(rowid);
    $('#itemP').val(row.item);
    $('#procedimientoP').val(fxGrilla.limpiaPtos(row.denominacion));
    //$('#procesoP').val(row.proceso);
    document.forms["postGestionarRequisitos"].submit();
}

function gestionarRequProcedimientoForm(id, item, denominacion) {
    $('#postGestionarRequisitos').find('input').val('');
    $('#idProcedimientoP').val(id);
    $('#itemP').val(item);
    $('#procedimientoP').val(denominacion);
    document.forms["postGestionarRequisitos"].submit();
}

//CONSULTAR PROC - FIN
/////////////////////////
function procesarGridProcedimiento(flg_load) {
    if(flg_load === undefined){flg_load=1;}
    
    var nombres = ['ITEM','DENOMINACIÓN DE PROCEDIMIENTO','idProceso','idEtapa','ETAPA DEL PROCESO','tieneAct'];
    var columnas = [
        {name: "item",width: 30,sortable: false,align: "center"}, 
        {name: "denominacion",width: 500,sortable: false,align: "left"}, 
        {name: "idProceso",width: 80,sortable: false,hidden: true,align: "center"},
        {name: "idEtapa",width: 80,sortable: false,hidden: true,align: "center"},
        {name: "proceso",width: 80,sortable: false,hidden: false,align: "center"},
        {name: "tieneAct",width: 30,sortable: false,hidden: true,align: "center"}
    ];
    var nombresSubGrid = ['RUBRO'];
    var columnasSubGrid = [{name: "nombre",width: 450,sortable: false,align: "left"}];
    
    $("#gridContenedorProcedimiento").html("");
    var grid = $("<table>", {
        "id": "gridProcedimiento"
    });
    var pager = $("<div>", {
        "id": "paginacionProcedimiento"
    });
    $("#gridContenedorProcedimiento").append(grid).append(pager);

    grid.jqGrid({
        url: baseURL + "pages/procedimiento/findProcedimiento",
        datatype: "json",
        postData: {
            item:$('#txtItemProcBusq').val(),
            denominacion:$('#txtDenominacionProcBusq').val(),
            baseLegal:$('#txtBaseLegalBusq').val(),
            idEtapa:$('#cmbEtapaBusq').val(),
            idTramite:$('#cmbTramiteBusq').val(),
            idActividad:$('#txtIdActivP1').val(),
            flg_load:flg_load
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionProcedimiento",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Procedimientos",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idProcedimiento"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkVerProcedimiento').attr('onClick', 'abrirMantProcedimiento("view","'+rowid+'")');
            $('#linkEditarProcedimiento').attr('onClick', 'abrirMantProcedimiento("edit","'+rowid+'")');
            $('#linkEliminarProcedimiento').attr('onClick', 'eliminarProcedimiento("'+rowid+'")');
            $('#linkGestionarRequisitosProcedimiento').attr('onClick', 'gestionarRequProcedimiento("' + rowid + '")');

            if($('#divEnlaceTagConsultar input').html()!=null){
                $('#contextMenuProcedimiento li a[value="CO-PROCEDIMIENTO"]').html($('#divEnlaceTagConsultar').html());               
               } else {
             	  $('#contextMenuProcedimiento li a[value="CO-PROCEDIMIENTO"]').remove();
               }
            
            if($('#divEnlaceTagEditar input').html()!=null){
                $('#contextMenuProcedimiento li a[value="MO-PROCEDIMIENTO"]').html($('#divEnlaceTagEditar').html());               
               } else {
             	  $('#contextMenuProcedimiento li a[value="MO-PROCEDIMIENTO"]').remove();
               }
            
            if($('#divEnlaceTagEliminar input').html()!=null){
                $('#contextMenuProcedimiento li a[value="EL-PROCEDIMIENTO"]').html($('#divEnlaceTagEliminar').html());               
               } else {
             	  $('#contextMenuProcedimiento li a[value="EL-PROCEDIMIENTO"]').remove();
               }
            
            if($('#divEnlaceTagGestionar input').html()!=null){
                $('#contextMenuProcedimiento li a[value="MO-PROCEDIMIENTOGES"]').html($('#divEnlaceTagGestionar').html());
               } else {
             	  $('#contextMenuProcedimiento li a[value="MO-PROCEDIMIENTOGES"]').remove();
               }
        },
        loadComplete: function(data) {
            $('#contextMenuProcedimiento').parent().remove();
            $('#divContextMenuProcedimiento').html("<ul id='contextMenuProcedimiento'>"
                    + "<li> <a value='CO-PROCEDIMIENTO'></a> </li>"
                    + "<li> <a value='MO-PROCEDIMIENTO'></a></li>"
                    + "<li> <a value='EL-PROCEDIMIENTO'></a></li>"
                    + "<li> <a value='MO-PROCEDIMIENTOGES'></a></li>"
                    + "</ul>");
            $('#contextMenuProcedimiento').puicontextmenu({
                target: $('#gridProcedimiento')
            });
            
//        onRightClickRow: function(rowid) {
//            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkVerProcedimiento').attr('onClick', 'abrirMantProcedimiento("view","'+rowid+'")');
//            $('#linkEditarProcedimiento').attr('onClick', 'abrirMantProcedimiento("edit","'+rowid+'")');
//            $('#linkEliminarProcedimiento').attr('onClick', 'eliminarProcedimiento("'+rowid+'")');
//            //$('#linkAgregarActProcedimiento').attr('onClick', 'agregarActProcedimiento("'+rowid+'","'+row.item+'","'+fxGrilla.limpiaPtos(row.denominacion)+'")');
//            //$('#linkVerActProcedimiento').attr('onClick', 'verActProcedimiento("'+rowid+'","'+row.item+'","'+fxGrilla.limpiaPtos(row.denominacion)+'")');
//            $('#linkGestionarRequisitosProcedimiento').attr('onClick', 'gestionarRequProcedimiento("' + rowid + '")');
//        },
//        loadComplete: function(data) {
//            $('#contextMenuProcedimiento').parent().remove();
//            $('#divContextMenuProcedimiento').html("<ul id='contextMenuProcedimiento'>"
//                    + "<li> <a id='linkVerProcedimiento' data-icon='ui-icon-search' title='Ver Detalle'>Consultar</a> </li>"
//                    + "<li> <a id='linkEditarProcedimiento' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
//                    + "<li> <a id='linkEliminarProcedimiento' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                    + "<li> <a id='linkGestionarRequisitosProcedimiento' data-icon='ui-icon-clipboard' title='Gestionar Requisitos'>Gestionar Requisitos</a></li>"
//                    + "</ul>");
//            $('#contextMenuProcedimiento').puicontextmenu({
//                target: $('#gridProcedimiento')
//            });
            //colocando puntos suspensivos
            fxGrilla.setPtosSuspensivos('gridProcedimiento','denominacion');
        },
        resizeStop:function(){
            //colocando puntos suspensivos
            fxGrilla.setPtosSuspensivos('gridProcedimiento','denominacion');
        },
        //SUBGRID
        subGrid: true, 
        afterInsertRow: function(rowid, aData, rowelem) {
            var rowData = grid.getRowData(rowid);
            if( rowData["tieneAct"]==0){
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
                url: baseURL + "pages/procedimiento/findActividadProcedimiento",
                datatype: "json", 
                postData: {
                    idProcedimiento:row_id,
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
                jsonReader: {
                    root: "filas",
                    page: "pagina",
                    total: "total",
                    records: "registros",
                    repeatitems: false,
                    id: "idActividad"
                },
                loadComplete: function(data) {
                    $('#contextMenuProcedimientoSub').parent().remove();
                    $('#divContextMenuProcedimientoSub').html("<ul id='contextMenuProcedimientoSub'>"
                            + "<li> Sin Accion </li>"
                            + "</ul>");
                    $('#contextMenuProcedimientoSub').puicontextmenu({
                        target: $("#gridProcedimiento .ui-subgrid")
                    });
                    $('#contextMenuProcedimientoSub').parent().css('opacity',0);
                }
            }); 
        }
    });
}

function abrirPopupBusqActividad() {
    $.ajax({
        url:baseURL + "pages/commonRequisitos/abrirPopupBusqActividad", 
        type:'get',
        async:false,
        data:{
            seleccion:"individual"
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogBusqActividad").html(data);
            $("#dialogBusqActividad").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: "Seleccione Rubro"
            });
        },
        error:errorAjax
    });
}

//DIALOG AGREGAR ACTIVIDADES
/*function verActProcedimiento(rowid,item,descripcion){
    $('#itemProcConsActi').html(item);
    $('#descripProcConsActi').html(descripcion);
    procesarGridActividadProcedimiento(rowid,item);
    $('#dialogConsultarActividad').dialog('open');
}*/
/*function agregarActProcedimiento(rowid,item,descripcion){
    limpiaFrmAgregarActividadProcedimiento();
    $('#dialogAgregarActividad').dialog('open');
    $('#itemProcAgreActi').html(item);
    $('#descripProcAgreActi').html(descripcion);
    //$("#arbolActividadesAgregar").fancytree("getTree").activateKey("19");
}*/
/*function limpiaFrmAgregarActividadProcedimiento(){
    $('#cmbTramiteProcAgreActi,#cmbDuplicarActiTramite').val("");
    $('#chkDuplicarActiTramite').attr('checked',false);
    $("#arbolActividadesAgregar").fancytree("getTree").visit(function(node){
        node.setSelected(false);
    });
    $('#chkTodoTramite').attr('checked',true);
    $('#chkTodoTramite').trigger('change');
}*/
/*function changeChkTodoTramite(){
    if($('#chkTodoTramite').attr('checked')){
        $('#filaTramite').hide();
    }else{
        $('#filaTramite').show();
    }
}*/
/*function initArbolActividadesAsignar(){
    $("#arbolActividadesAgregar").fancytree({
        checkbox: true,
        selectMode: 3,
        //source:treeData,
        select: function(event, data) {
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node){
                if(!node.folder){
                    return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
                }
            });
            agregaActividadDeArbol("["+selKeys.join(",")+"]");
        },
        keydown: function(event, data) {
            if( event.which === 32 ) {
                data.node.toggleSelected();
                return false;
            }
        },
        //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
        //initId: "treeData",
        cookieId: "fancytree-Cb1",
        idPrefix: "fancytree-Cb1-"
    });
    
    $("#arbolActividadesAgregar").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
    $('#btnAgregarActividadProc').click(btnAgregarActividadProc);
}*/
/*function duplicarActiTramite(){
    if($('#chkDuplicarActiTramite').attr('checked') && $('#cmbDuplicarActiTramite').val()=='INSTALACION'){
        $("#arbolActividadesAgregar").fancytree("getTree").visit(function(node){
            node.setSelected(false);
        });
        var data=[16,18,19,20];
        $.each(data,function(k,v){
            $("#arbolActividadesAgregar").fancytree("getTree").getNodeByKey(String(v)).setSelected();        
        });
    }
}*/
/*function cargaActiPorTramite(){
    $("#arbolActividadesAgregar").fancytree("getTree").visit(function(node){
        node.setSelected(false);
    });
    if($('#cmbTramiteProcAgreActi').val()!=''){
        var data=[];
        if($('#itemProcAgreActi').html()=='H15'){
            data=[8,14,12,10,11,16,17,18,19,20];
        }else if($('#itemProcAgreActi').html()=='H18'){
            data=[22,23,24,25,26,27,28,29,30,31,32,33];
        }else if($('#cmbTramiteProcAgreActi').val()=='INSTALACION'){
            data=[16,18,19,20];
        }
                
        $.each(data,function(k,v){
            $("#arbolActividadesAgregar").fancytree("getTree").getNodeByKey(String(v)).setSelected();        
        });
    }
}*/
/*function quitarActividadDeAgregar(id,obj){
    $(obj).parent().remove();
    //retirando de arbol actividades
    $("#arbolActividadesAgregar").fancytree("getTree").getNodeByKey(String(id)).setSelected(false);   
}*/
/*function agregaActividadDeArbol(datax){
    var data=eval("("+datax+")");
    var html="";
    $.each(data,function(k,v){
        html+='<div id="'+v.id+'" class="fila">';
        html+=' <div class="txtFilaUnic ilb data" style="width: 97%">'+v.nombre+'</div>';
        html+=' <div onclick="quitarActividadDeAgregar('+v.id+',this)" class="btnQuitar ui-state-default ui-corner-all ilb" title="Quitar"><span class="ui-icon ui-icon-closethick"></span></div>';
        html+='</div>';
    });
    $('#idActividadesAgregarSelect').html(html);
}*/
/*function btnAgregarActividadProc(){
    mensajeGrowl("success", "Se registró correctamente", "");
    $('#dialogAgregarActividad').dialog('close');
}*/
function cargaEtapa(callback,CmbOrigen,tagDestino){
    var idProceso = $(CmbOrigen).val();
    if(idProceso!=""){
        $.ajax({
            url: baseURL + 'pages/etapa/loadEtapa',
            type: "post",
            async: false,
            data: {
                idProceso: idProceso
            },
            //beforeSend:muestraLoading,
            success: function(data) {
                //ocultaLoading();
                callback(data.filas,'idEtapa','descripcion',tagDestino);
            },
            error:errorAjax
        });
    }else{
        callback([],'idEtapa','descripcion',tagDestino);
    }
}
function cargaTramite(callback,CmbOrigen,tagDestino){
    var idEtapa = $(CmbOrigen).val();
    if(idEtapa!=""){
        $.ajax({
            url: baseURL + 'pages/tramite/loadTramite',
            type: "post",
            async: false,
            data: {
                idEtapa: idEtapa
            },
            //beforeSend:muestraLoading,
            success: function(data) {
                //ocultaLoading();
                callback(data.filas,'idTramite','descripcion',tagDestino);
            },
            error:errorAjax
        });
    }else{
        callback([],'idTramite','descripcion',tagDestino);
    }
}
function cargaSilencioAdministrativo(callback,CmbOrigen,tagDestino,textoDefault){
    var idMaestroColumna = $(CmbOrigen).val();
    if(idMaestroColumna!=""){
        $.ajax({
            url: baseURL + 'pages/procedimiento/loadCmbSilencioAdministrativo',
            type: "post",
            async: false,
            data: {
                idMaestroColumna: idMaestroColumna
            },
            success: function(data) {
                callback(data.filas,'idMaestroColumna','descripcion',tagDestino,textoDefault);
            }
        });
    }else{
        callback([],'idMaestroColumna','descripcion',tagDestino);
    }
}
