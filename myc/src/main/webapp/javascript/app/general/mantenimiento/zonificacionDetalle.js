var contadorDetalleZonificacion=0;
var variable;
$(function() {
   // procesarGridParametroDinamico(0);
    initInicioZonificacion();
    $('#frmMantZonificacionDetalle').validarForm();
});
var alphaOptions = {
    allowNumeric  : true,
    allowLatin    : true,
    allowUpper    : true,
    allowLower    : true,
    allowCaseless : true,
    allowOtherCharSets : false,
    allowSpace    : true,
    allow	  : 'Ññóáéíóú'
};
function initInicioZonificacion() {
    console.log('-- initInicioZonificacion --');
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    confirm.start();
    $("#dialogMantZonificacionDetalle").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true,
        closeText:"Cerrar"
    });
    $("#dialogEditarZonificacionDetalle").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true,
        closeText:"Cerrar"
    });
    
    $("#dialogMantZonificacion").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "500px",
        dialogClass: 'dialog',
        modal: true,
        closeText:"Cerrar",
        beforeClose: function(event, ui) { 
//            comboboxZonificacion('cmbZonificacionesBusq', baseURL + "pages/zonificacionDetalle/findZonificaciones");
//            comboboxZonificacion('cmbZonificaciones', baseURL + "pages/zonificacionDetalle/findZonificaciones");
//            comboboxZonificacion('cmbZonificacionesEditar', baseURL + "pages/zonificacionDetalle/findZonificaciones");
            procesarGridDetalleZonificacionAgregar();
            return true;
        }
    });
    $("#dialogConfirmacionZonificacionNuevo").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "370px",
        dialogClass: 'dialog',
        modal: true,
        closeText:"Cerrar"
    });
    comboboxZonificacion('cmbZonificacionesBusq', baseURL + "pages/zonificacionDetalle/findZonificaciones");
    comboboxZonificacion('cmbZonificaciones', baseURL + "pages/zonificacionDetalle/findZonificaciones");
    comboboxZonificacion('cmbZonificacionesEditar', baseURL + "pages/zonificacionDetalle/findZonificaciones");
//    comboboxMaestroColumna('cmbTipoConsulta', baseURL + "pages/parametro/findTipoConsulta");

    $('#btnBuscarZoniDeta').click(function() {
        procesarGridZonificacionDetalle();
    });
    $('#btnLimpiarBuscarZoniDeta').click(btnLimpiarBuscarZoniDeta);
    $('#btnNuevoZoniDeta').click(btnNuevoZoniDeta);
    $('#btnGuardarZoniDeta').click(btnGuardarZoniDeta);
    $('#btnEditarZoniDeta').click(btnEditarZoniDeta);
    $('#btnAgregarZoniDeta').click(btnAgregarZoniDeta);
//    $('#btnNuevoValoPara').click(btnNuevoValoPara);
//    $('#btnGuardarValoPara').click(btnGuardarValoPara);
//    $('#btnEditarValoPara').click(btnEditarValoPara);
    $('#cmbDepartamento').change(cargarProvincias);
  //  $('#cmbProvincias').change(cargarDistritos);
    $('#cmbDepartamentoEditar').change(cargarProvinciasEditar);
    $('#cmbProvinciasEditar').change(cargarDistritosEditar);
    $('#btnNuevoZoni').click(btnNuevoZoni);
    $('#btnConfirmacionNoZonificacionNuevo').click(cerrarConfirmacionZonificacion);
    $('#btnAgregarZoni').click(btnAgregarZonificacion);
    $('#btnEditarZoni').click(btnAgregarZonificacion);
    $('#btnLimpiarZoni').click(limpiaFrmMantZonificacion);
    $('#btnBuscarZonificacion').click(procesarGridZonificacion);
    $('#cmbZonificaciones').change(procesarGridDetalleZonificacionAgregar);
    variable = getUrlVars()["idZoni"];
    //alert("variable = "+variable);
    if (typeof(variable) != "undefined"){
        btnNuevoZoniDeta();
    }
}
function btnLimpiarBuscarZoniDeta(){
    $('#cmbZonificacionesBusq').val("");
}
function btnNuevoZoni() {
    console.log('-- btnNuevoZoni --');
    limpiaFrmMantZonificacion();
    $("#dialogMantZonificacion").dialog("option", "title", "NUEVA ZONIFICACIÓN");
    $("#dialogMantZonificacion").dialog("open");
    procesarGridZonificacion()
    //comboboxMaestroColumna('cmbAmbitoPara', baseURL + "pages/parametro/findAmbitoParametro");
    
//    $('#cmbTipoConsulta').change( function(){
//    	 //if ($('#cmbTipoConsulta').val()=='200'){ $('#divPreguntaPara').show();} else { $('#divPreguntaPara').hide();}
//         if ($('#cmbTipoConsulta :checked').html()=='PREGUNTA'){ $('#divPreguntaPara').show();} else { $('#divPreguntaPara').hide();}
//    });
    $("#txtNombreZonificacion").alphanum(alphaOptions);
}

function limpiaFrmMantZonificacion() {
    console.log('-- limpiaFrmMantZonificacion --');
    $('#frmMantZonificacion').find('input,select,textarea').not('#btnAgregarZoni').val("");
    //$('#btnEditarZoni').hide();
    //$('#btnGuardarZoni').show();
    $('#btnBuscarZonificacion,#btnAgregarZoni').show();
    $('#btnLimpiarZoni,#btnEditarZoni').hide();
}

function btnAgregarZonificacion(){
    console.log('-- btnAgregarZonificacion --');
    var validar = $('#frmMantZonificacion').validateAllForm("#divMensajeValidaZonificacion");
    if(validar){
        console.log("modo = "+$("#txtModo").val());
        if($("#txtModo").val() != 1){
            guardarZona();
        }else{
            actualizarZona();
        }
    }
}

function guardarZona() {
    console.log("-- guardarZona --");
    $("#lblConfirmacionZonificacion").html("¿Desea registrar la Zonificación?");
    $('#btnConfirmacionSiZonificacionNuevo').unbind( "click" );
    $('#btnConfirmacionSiZonificacionNuevo').click(guardarZonificacion);
    $("#dialogConfirmacionZonificacionNuevo").dialog("open");
}

function actualizarZona() {
    console.log("-- actualizarZona --");
    $("#lblConfirmacionZonificacion").html("¿Desea actulizar la Zonificación?");
    $('#btnConfirmacionSiZonificacionNuevo').unbind( "click" );
    $('#btnConfirmacionSiZonificacionNuevo').click(actualizarZonificacion);
    $("#dialogConfirmacionZonificacionNuevo").dialog("open");
}

function cerrarConfirmacionZonificacion() {
    $("#dialogConfirmacionZonificacionNuevo").dialog("close");
}

function guardarZonificacion(){
    console.log('-- guardarZonificacion --');
    cerrarConfirmacionZonificacion();
    $.ajax({
        url:baseURL + "pages/zonificacion/registrarZonificacion",
        type:'post',
        async:false,
        data: {
            nombreZonificacion:$('#txtNombreZonificacion').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                $("#txtNombreZonificacion").val("");
                procesarGridZonificacion();
                comboboxZonificacion('cmbZonificacionesBusq', baseURL + "pages/zonificacionDetalle/findZonificaciones");
                comboboxZonificacion('cmbZonificaciones', baseURL + "pages/zonificacionDetalle/findZonificaciones");
                comboboxZonificacion('cmbZonificacionesEditar', baseURL + "pages/zonificacionDetalle/findZonificaciones");
                //alert("idZoni = "+data.idZoni);
                setTimeout(function(){ $('#cmbZonificaciones').val(data.idZoni); $('#cmbZonificaciones').trigger("change"); }, 500);
                //$('#cmbZonificaciones').val(data.idZoni);
                mensajeGrowl("success", global.confirm.save, "");
                limpiaFrmMantZonificacion();
            }else{
                error = "1";
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function actualizarZonificacion(){
    console.log('-- actualizarZonificacion --');
    cerrarConfirmacionZonificacion();
    $.ajax({
        url:baseURL + "pages/zonificacion/editarZonificacion",
        type:'post',
        async:false,
        data: {
            idZonificacion:$('#txtIdZonificacion').val(),
            nombre:$('#txtNombreZonificacion').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                $("#txtNombreZonificacion").val("");
                procesarGridZonificacion();
                comboboxZonificacion('cmbZonificacionesBusq', baseURL + "pages/zonificacionDetalle/findZonificaciones");
                comboboxZonificacion('cmbZonificaciones', baseURL + "pages/zonificacionDetalle/findZonificaciones");
                comboboxZonificacion('cmbZonificacionesEditar', baseURL + "pages/zonificacionDetalle/findZonificaciones");
                mensajeGrowl("success", global.confirm.edit, "");
                limpiaFrmMantZonificacion();
            }else{
                error = "1";
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function desahabilitarZonificacion(){
    console.log('-- desahabilitarZonificacion --');
    $.ajax({
        url:baseURL + "pages/zonificacion/eliminarZonificacion",
        type:'post',
        async:false,
        data: {
            idZonificacion:$('#txtIdZonificacion').val()
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                cerrarConfirmacionZonificacion();
                procesarGridZonificacion();
                comboboxZonificacion('cmbZonificacionesBusq', baseURL + "pages/zonificacionDetalle/findZonificaciones");
                comboboxZonificacion('cmbZonificaciones', baseURL + "pages/zonificacionDetalle/findZonificaciones");
                comboboxZonificacion('cmbZonificacionesEditar', baseURL + "pages/zonificacionDetalle/findZonificaciones");
                mensajeGrowl("success", global.confirm.delete, "");
            }else{
                error = "1";
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function procesarGridZonificacion() {
    console.log('-- procesarGridZonificacion --');

    $("#gridContenedorZonificacion").html("");
    var grid = $("<table>", {
        "id": "gridZonificacion"
    });
    var pager = $("<div>", {
        "id": "paginacionZonificacion"
    });
    $("#gridContenedorZonificacion").append(grid).append(pager);

    var nombres = ['ID', 'NOMBRE', 'ESTADO'];
    var columnas = [
        {name: "idZonificacion", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "nombre", width: 300, sortable: false, hidden: false, align: "left"},
        {name: "estado", width: 100, sortable: false, hidden: true, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/zonificacion/listarZonificacion",
        datatype: "json",
        postData: {
            nombre: $("#txtNombreZonificacion").val()
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionZonificacion",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Zonificaciones",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idZonificacion"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            $('#linkEditarZonificacion').attr('onClick', 'editarZonificacion("' + rowid + '")');
            $('#linkEliminarZonificacion').attr('onClick', 'eliminarZonificacion("' + rowid + '")');
        },
        loadComplete: function(data) {
            $('#contextMenuZonificacion').parent().remove();
            $('#divContextMenuZonificacion').html("<ul id='contextMenuZonificacion'>"
                    + "<li> <a id='linkEditarZonificacion' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarZonificacion' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuZonificacion').puicontextmenu({
                target: $('#gridZonificacion')
            });
        }
    });
}

function editarZonificacion(rowid){
    console.log(rowid);
    var row = $("#gridZonificacion").jqGrid('getRowData', rowid);
    $("#txtNombreZonificacion").val(row.nombre);
    $("#txtIdZonificacion").val(row.idZonificacion);
    $("#txtModo").val(1);
    
    $('#btnBuscarZonificacion,#btnAgregarZoni').hide();
    $('#btnLimpiarZoni,#btnEditarZoni').show();
}

function eliminarZonificacion(rowid){
    console.log("-- eliminarZonificacion --");
    var row = $("#gridZonificacion").jqGrid('getRowData', rowid);
    $("#txtIdZonificacion").val(row.idZonificacion);

    $("#lblConfirmacionZonificacion").html("¿Desea eliminar la Zonificación?");
    $('#btnConfirmacionSiZonificacionNuevo').unbind( "click" );
    $('#btnConfirmacionSiZonificacionNuevo').click(desahabilitarZonificacion);
    $("#dialogConfirmacionZonificacionNuevo").dialog("open");
}

function cargarProvincias(){
    $.ajax({
       url:baseURL + '/pages/ubigeo/listarProvincias',
       type:'post',
       async:false,
       data:{
           idDepartamento:$('#cmbDepartamento').val()
       },
       success:function(data){
           $("#cmbProvincias,#cmbDistritos").html("<option value=''>--Seleccione--</option>");//limpia combos q dependen de departamento
           if(data.lista!=null){
               html="<option value=''>--Seleccione--</option>";
               $.each(data.lista,function(key,val){
                   html+="<option value='"+val.idProvincia+"'>"+val.nombre+"</option>";
               });
               $('#cmbProvincias').html(html);
           }
       }
    });
}
/*function cargarDistritos(){
    $.ajax({
       url:baseURL + '/pages/ubigeo/listarDistritos',
       type:'post',
       async:false,
       data:{
           idDepartamento:$('#cmbDepartamento').val(),
           idProvincia:$('#cmbProvincias').val()
       },
       success:function(data){
           $("#cmbDistritos").html("<option value=''>--Seleccione--</option>");//limpia combos q dependen de provincia
           if(data.lista!=null){
               html="<option value=''>--Seleccione--</option>";
               $.each(data.lista,function(key,val){
                   html+="<option value='"+val.idDistrito+"'>"+val.nombre+"</option>";
               });
               $('#cmbDistritos').html(html);
           }
       }
    });
}*/
function cargarProvinciasEditar(){
    $.ajax({
       url:baseURL + '/pages/ubigeo/listarProvincias',
       type:'post',
       async:false,
       data:{
           idDepartamento:$('#cmbDepartamentoEditar').val()
       },
       success:function(data){
           $("#cmbProvinciasEditar,#cmbDistritosEditar").html("<option value=''>--Seleccione--</option>");//limpia combos q dependen de departamento
           if(data.lista!=null){
               html="<option value=''>--Seleccione--</option>";
               $.each(data.lista,function(key,val){
                   html+="<option value='"+val.idProvincia+"'>"+val.nombre+"</option>";
               });
               $('#cmbProvinciasEditar').html(html);
           }
       }
    });
}
function cargarDistritosEditar(){
    $.ajax({
       url:baseURL + '/pages/ubigeo/listarDistritos',
       type:'post',
       async:false,
       data:{
           idDepartamento:$('#cmbDepartamentoEditar').val(),
           idProvincia:$('#cmbProvinciasEditar').val()
       },
       success:function(data){
           $("#cmbDistritosEditar").html("<option value=''>--Seleccione--</option>");//limpia combos q dependen de provincia
           if(data.lista!=null){
               html="<option value=''>--Seleccione--</option>";
               $.each(data.lista,function(key,val){
                   html+="<option value='"+val.idDistrito+"'>"+val.nombre+"</option>";
               });
               $('#cmbDistritosEditar').html(html);
           }
       }
    });
}
/**
 * 
 * @param idSelect identificador del select
 * @param url URL que devuelve el JSON con los datos
 */
function comboboxZonificacion(idSelect, url) {
    $.ajax({
        url: url,
        type: "post",
        success: function(response) {
            if (!response.error) {
                $combo = $("#" + idSelect);
                $combo.empty();
                if (response.lista) {
                    $items = '<option value="">--Seleccione--</option>';
                    $.each(response.lista, function(index, value) {
                        $items += "<option value='" + value.idZonificacion + "'>" + value.nombre + "</option>";
                    });
                    $combo.html($items);
                } else {
                    $combo.html('<option value="0">--Seleccione--</option>');
                }
            } else {
            }
        },
        error: function() {
        }
    });
}
function procesarGridZonificacionDetalle() {
    console.log('-- procesarGridZonificacionDetalle --');
//    if (flg_load === undefined) {
//        flg_load = 1;
//    }

    $("#gridContenedorZonificacionDetalle").html("");
    var grid = $("<table>", {
        "id": "gridZonificacionDetalle"
    });
    var pager = $("<div>", {
        "id": "paginacionZonificacionDetalle"
    });
    $("#gridContenedorZonificacionDetalle").append(grid).append(pager);

    var nombres = ['ID', 'ZONIFICACIÓN', 'DEPARTAMENTO', 'PROVINCIA', 'DISTRITO', 'IDZONIFICACION', 'IDDEPARTAMENTO', 'IDPROVINCIA', 'IDDISTRITO'];
    var columnas = [
        {name: "idZonificacionDetalle", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "nombreZonificacion", width: 100, sortable: false, align: "left"},
        {name: "nombreDepartamento", width: 300, sortable: false, hidden: false, align: "left"},
        {name: "nombreProvincia", width: 300, sortable: false, hidden: false, align: "left"},
        {name: "nombreDistrito", width: 300, sortable: false, hidden: false, align: "left"},
        {name: "idZonificacion", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "idDepartamento", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "idProvincia", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "idDistrito", width: 100, sortable: false, hidden: true, align: "left"},
    ];
    var idZonificacion = $("#cmbZonificacionesBusq").val();

    grid.jqGrid({
        url: baseURL + "pages/zonificacionDetalle/listarZonificacionDetalle",
        datatype: "json",
        postData: {idZonificacion: idZonificacion},
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionZonificacionDetalle",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Detalle de Zonificaciones",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idZonificacionDetalle"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkVerProcedimiento').attr('onClick', 'verParametroDinamico("' + rowid + '")');
            $('#linkEditarZonificacionDetalle').attr('onClick', 'editarZonificacionDetalle("' + rowid + '")');
            $('#linkEliminarZonificacionDetalle').attr('onClick', 'eliminarZonificacionDetalle("' + rowid + '")');
//            $('#linkAgregarActProcedimiento').attr('onClick', 'mostrarValorParametroDinamico("' + rowid + '","' + row.nombre + '")');
        },
        loadComplete: function(data) {
            $('#contextMenuZonificacionDetalle').parent().remove();
            $('#divContextMenuZonificacionDetalle').html("<ul id='contextMenuZonificacionDetalle'>"
                    + "<li> <a id='linkEditarZonificacionDetalle' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarZonificacionDetalle' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
                    + "</ul>");
            $('#contextMenuZonificacionDetalle').puicontextmenu({
                target: $('#gridZonificacionDetalle')
            });
        }
    });
}
function editarZonificacionDetalle(rowid) {
    limpiaFrmEditarZonificacionDetalle();
    
    var row = $('#gridZonificacionDetalle').jqGrid('getRowData', rowid);
    $("#dialogEditarZonificacionDetalle").dialog("option", "title", "EDITAR ZONIFICACIÓN");
    $("#dialogEditarZonificacionDetalle").dialog("open");
    $('#btnEditarZoniDeta').show();
//    $('#btnGuardarZoniDeta').hide();
    
    $('#txtIdZonificacionDetalleEditar').val(row.idZonificacionDetalle);
    $('#cmbZonificacionesEditar').val(row["idZonificacion"]);
    $('#cmbDepartamentoEditar').val(row["idDepartamento"]);
    $('#cmbDepartamentoEditar').trigger('change');
    $('#cmbProvinciasEditar').val(row["idProvincia"]);
    $('#cmbProvinciasEditar').trigger('change');
    $('#cmbDistritosEditar').val(row["idDistrito"]);
    //$('#txtNombreZonificacion').val(row.nombre);
    //$('#txtEstadoZonificacion').val(row.estado);
}
function btnNuevoZoniDeta() {
    limpiaFrmMantZonificacionDetalle();
    $("#dialogMantZonificacionDetalle").dialog("option", "title", "NUEVO DETALLE ZONIFICACIÓN");
    $("#dialogMantZonificacionDetalle").dialog("open");
    //comboboxMaestroColumna('cmbAmbitoPara', baseURL + "pages/parametro/findAmbitoParametro");
    $('#cmbZonificaciones').val($('#cmbZonificacionesBusq').val());
    procesarGridDetalleZonificacionAgregar();
//    if (typeof(variable) != "undefined"){
//        $('#cmbZonificaciones').val(variable);
//        variable = undefined;
//    }
    
//    $('#cmbTipoConsulta').change( function(){
//    	 //if ($('#cmbTipoConsulta').val()=='200'){ $('#divPreguntaPara').show();} else { $('#divPreguntaPara').hide();}
//         if ($('#cmbTipoConsulta :checked').html()=='PREGUNTA'){ $('#divPreguntaPara').show();} else { $('#divPreguntaPara').hide();}
//    });
//    $("#txtNombreZonificacion").alphanum(alphaOptions);
}
function limpiaFrmMantZonificacionDetalle() {
    $('#frmMantZonificacionDetalle').find('input,select,textarea').not('#btnAgregarZoniDeta,#cmbZonificaciones,#btnNuevoZoni').val("");
    fill.clean('#cmbProvincias');
    $('#btnEditarZoni').hide();
    $('#btnGuardarZoni').show();
}
function limpiaFrmEditarZonificacionDetalle() {
    $('#frmEditarZonificacionDetalle').find('input,select,textarea').val("");
//    $('#btnEditarZoni').hide();
//    $('#btnGuardarZoni').show();
}
function btnGuardarZoniDeta() {
    //$('#txtNombreZonificacion').val($('#txtNombreZonificacion').val().trim());
    //var validar = $('#frmMantZonificacionDetalle').validateAllForm("#divMensajeValidaZonificacionDetalle");
    
    //if (validar) {
        confirm.open("¿Ud. est&aacute; seguro de guardar estos registros?", "procGuardarZoniDeta()");
    //}
}
//function procGuardarZoniDeta() {
//    var rows= jQuery("#gridZonificacionDetalleAgregar").jqGrid('getRowData');
//    var error = "0";
//    for(var i=0;i<rows.length;i++){
//        var row=rows[i];
//        //alert("row = "+row['idDepartamento']);
//        
//        $.ajax({
//            url: baseURL + "pages/zonificacionDetalle/registrarZonificacionDetalle",
//            type: 'post',
//            async: false,
//            data: {
//                idZonificacion:row['idZonificacion'],
//                idDepartamento:row['idDepartamento'],
//                idProvincia:row['idProvincia'],
//                idDistrito:row['idDistrito']
//            },//$('#frmMantZonificacionDetalle').serialize(),
//            beforeSend: muestraLoading,
//            success: function(data) {
//                ocultaLoading();
//                if (data.resultado == "0") {
//                    //mensajeGrowl("success", "Se registró correctamente", "");
//                    //procesarGridZonificacionDetalle();
//                    //$("#dialogMantZonificacionDetalle").dialog("close");
//                } else {
//                    error = "1";
//                    mensajeGrowl("error", data.mensaje, "");
//                }
//            },
//            error: errorAjax
//        });
//        $("#dialogMantZonificacionDetalle").dialog("close");
//    }
//    if(error === "0"){
//        mensajeGrowl("success", "Se registró correctamente", "");
//        procesarGridZonificacionDetalle();
//        $("#dialogMantZonificacionDetalle").dialog("close");
//    }else{
//        mensajeGrowl("error", "Error al registrar", "");
//    }
//}
function btnEditarZoniDeta() {
    //$('#txtNombreZonificacion').val($('#txtNombreZonificacion').val().trim());
    var validar = $('#frmEditarZonificacionDetalle').validateAllForm("#divMensajeValidaEditarZonificacionDetalle");
    if (validar) {
        confirm.open("¿Ud. est&aacute; seguro de guardar los cambios en este detalle zonificación?", "procEditarZoniDeta()");
    }
}
function procEditarZoniDeta() {
    console.log('-- procEditarZoniDeta --');
    $.ajax({
        url:baseURL + "pages/zonificacionDetalle/editarZonificacionDetalle",
        type:'post',
        async:false,
        data:$('#frmEditarZonificacionDetalle').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridZonificacionDetalle();
                $("#dialogEditarZonificacionDetalle").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function eliminarZonificacionDetalle(rowid) {
    var row = $('#gridZonificacionDetalle').jqGrid('getRowData', rowid);
    confirm.open("¿Ud. est&aacute; seguro de eliminar el detalle zonificación?", "procEliminarZoniDeta('" + row.idZonificacionDetalle + "')");
}
function procEliminarZoniDeta(id) {
    $.ajax({
        url:baseURL + "pages/zonificacionDetalle/eliminarZonificacionDetalle",
        type:'post',
        async:false,
        data:{
            idZonificacionDetalle:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridZonificacionDetalle();
                $("#dialogMantZonificacionDetalle").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function btnAgregarZoniDeta(){
    $("#txtDistrP1").attr("validate","[O]");
    //$("#txtDistrP1").attr("onclick","abrirPopupBusqDistrito()");
    var validar = $('#frmMantZonificacionDetalle').validateAllForm("#divMensajeValidaZonificacionDetalle");
    if(validar){
        confirm.open("¿Desea guardar los registros?","guardarDetalleZonificacion()");
//    	var data=eval("("+$('#txtJsonDistrP1').val()+")");
//    	$.map(data,function(item){
//    		var mydata = [{
//                idZonificacion: $('#cmbZonificaciones').val(),
//                zonificacion: $("#cmbZonificaciones option:selected").text(),
//                idDepartamento: $('#cmbDepartamento').val(),
//                departamento: $("#cmbDepartamento option:selected").text(),
//                idProvincia: $('#cmbProvincias').val(),
//                provincia: $("#cmbProvincias option:selected").text(),
//                idDistrito: item.id,
//                distrito: item.nombre
//	        }];
//	        if(contadorDetalleZonificacion==0){
//	            procesarGridDetalleZonificacionAgregar();
//	        }
//	        if(jQuery("#gridZonificacionDetalleAgregar").length>0){
//	            jQuery("#gridZonificacionDetalleAgregar").jqGrid('addRowData',contadorDetalleZonificacion,mydata[0]); 
//	            contadorDetalleZonificacion++;
//	        }
//		});
//        limpiaFrmMantZonificacionDetalle();
    }
}

function guardarDetalleZonificacion() {
    console.log('-- guardarDetalleZonificacion --');
    $.ajax({
        url: baseURL + "pages/zonificacionDetalle/registrarZonificacionDetalle",
        type: 'post',
        async: false,
        data: {
            idZonificacion: $('#cmbZonificaciones').val(),
            idDepartamento: $('#cmbDepartamento').val(),
            idProvincia: $('#cmbProvincias').val(),
            distritos:$('#txtIdDistrP1').val()
        },
        beforeSend: muestraLoading,
        success: function(data) {
            ocultaLoading();
            if (data.resultado == "0") {
                mensajeGrowl("success", global.confirm.save, "");
                limpiaFrmMantZonificacionDetalle();
                procesarGridDetalleZonificacionAgregar();
//                procesarGridZonificacionDetalle();
                //$("#dialogMantZonificacionDetalle").dialog("close");
            } else {
                error = "1";
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error: errorAjax
    });
}


function procesarGridDetalleZonificacionAgregar(){
    $("#gridContenedorZonificacionDetalleAgregar").html("");
    var grid = $("<table>", {
        "id": "gridZonificacionDetalleAgregar"
    });
    var pager = $("<div>", {
        "id": "paginacionZonificacionDetalleAgregar"
    });
    $("#gridContenedorZonificacionDetalleAgregar").append(grid).append(pager);

    var nombres = ['ID', 'ZONIFICACIÓN', 'DEPARTAMENTO', 'PROVINCIA', 'DISTRITO', 'IDZONIFICACION', 'IDDEPARTAMENTO', 'IDPROVINCIA', 'IDDISTRITO'];
    var columnas = [
        {name: "idZonificacionDetalle", width: 10, sortable: false, hidden: true, align: "center"},
        {name: "nombreZonificacion", width: 150, sortable: false, align: "left"},
        {name: "nombreDepartamento", width: 300, sortable: false, hidden: false, align: "left"},
        {name: "nombreProvincia", width: 300, sortable: false, hidden: false, align: "left"},
        {name: "nombreDistrito", width: 300, sortable: false, hidden: false, align: "left"},
        {name: "idZonificacion", width: 10, sortable: false, hidden: true, align: "left"},
        {name: "idDepartamento", width: 10, sortable: false, hidden: true, align: "left"},
        {name: "idProvincia", width: 10, sortable: false, hidden: true, align: "left"},
        {name: "idDistrito", width: 30, sortable: false, hidden:true, align: "left"},
    ];
    var idZonificacion = $("#cmbZonificaciones").val();
    if(idZonificacion == ""){
        idZonificacion = 0;
    }
    grid.jqGrid({
        url: baseURL + "pages/zonificacionDetalle/listarZonificacionDetalleAgregar",
        datatype: "json",
        postData: {
            idZonificacion: idZonificacion
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionZonificacionDetalleAgregar",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Detalle de Zonificaciones",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idZonificacionDetalle"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
//            var row = grid.jqGrid('getRowData', rowid);
////            $('#linkVerProcedimiento').attr('onClick', 'verParametroDinamico("' + rowid + '")');
//            $('#linkEditarZonificacionDetalle').attr('onClick', 'editarZonificacionDetalle("' + rowid + '")');
//            $('#linkEliminarZonificacionDetalle').attr('onClick', 'eliminarZonificacionDetalle("' + rowid + '")');
////            $('#linkAgregarActProcedimiento').attr('onClick', 'mostrarValorParametroDinamico("' + rowid + '","' + row.nombre + '")');
        },
        loadComplete: function(data) {
//            $('#contextMenuZonificacionDetalle').parent().remove();
//            $('#divContextMenuZonificacionDetalle').html("<ul id='contextMenuZonificacionDetalle'>"
//                    + "<li> <a id='linkEditarZonificacionDetalle' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
//                    + "<li> <a id='linkEliminarZonificacionDetalle' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
////                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
//                    + "</ul>");
//            $('#contextMenuZonificacionDetalle').puicontextmenu({
//                target: $('#gridZonificacionDetalle')
//            });
        }
    });
    
//    var nombres = ['IDZONI', 'ZONIFICACIÓN', 'IDDEPTO', 'DEPARTAMENTO', 'IDPROVINCIA', 'PROVINCIA', 'IDDISTRITO', 'DISTRITO'];
//    var columnas = [
//        {name: "idZonificacion", width: 100, sortable: false, hidden: true, align: "center"},
//        {name: "zonificacion", width: 100, sortable: false, hidden: false, align: "left"},
//        {name: "idDepartamento", width: 100, sortable: false, hidden: true, align: "center"},
//        {name: "departamento", width: 100, sortable: false, hidden: false, align: "left"},
//        {name: "idProvincia", width: 100, sortable: false, hidden: true, align: "left"},
//        {name: "provincia", width: 100, sortable: false, hidden: false, align: "left"},
//        {name: "idDistrito", width: 100, sortable: false, hidden: true, align: "left"},
//        {name: "distrito", width: 100, sortable: false, hidden: false, align: "left"}
//    ];
//    grid.jqGrid({
////        url: baseURL + "pages/zonificacionDetalle/listarZonificacionDetalle",
//        datatype: "local",
////        postData: {
////            flg_load: flg_load,
////            zonificacion: $("#cmbZonificacionesBusq").val()
////        },
//        hidegrid: false,
//        rowNum: global.rowNum,
//        pager: "#paginacionZonificacionDetalleAgregar",
//        emptyrecords: "No se encontraron resultados",
//        loadtext: "Cargando",
//        colNames: nombres,
//        colModel: columnas,
//        height: "auto",
//        viewrecords: true,
//        caption: "Listado de Detalle de Zonificaciones",
//        autowidth: true,
////        jsonReader: {
////            root: "filas",
////            page: "pagina",
////            total: "total",
////            records: "registros",
////            repeatitems: false,
////            id: "idZonificacionDetalle"
////        },
//        onSelectRow: function(rowid, status) {
//            grid.resetSelection();
//        },
//        onRightClickRow: function(rowid, iRow, iCol, e) {
//            var row = grid.jqGrid('getRowData', rowid);
////            $('#linkVerProcedimiento').attr('onClick', 'verParametroDinamico("' + rowid + '")');
////            $('#linkEditarZonificacionDetalle').attr('onClick', 'editarZonificacionDetalle("' + rowid + '")');
//            $('#linkEliminarZonificacionDetalleAgregar').attr('onClick', 'eliminarZonificacionDetalleAgregar("' + rowid + '")');
////            $('#linkAgregarActProcedimiento').attr('onClick', 'mostrarValorParametroDinamico("' + rowid + '","' + row.nombre + '")');
//        },
//        loadComplete: function(data) {
//            $('#contextMenuZonificacionDetalleAgregar').parent().remove();
//            $('#divContextMenuZonificacionDetalleAgregar').html("<ul id='contextMenuZonificacionDetalleAgregar'>"
////                    + "<li> <a id='linkEditarZonificacionDetalle' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
//                    + "<li> <a id='linkEliminarZonificacionDetalleAgregar' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
////                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
//                    + "</ul>");
//            $('#contextMenuZonificacionDetalleAgregar').puicontextmenu({
//                target: $('#gridZonificacionDetalleAgregar')
//            });
//        }
//    });
}
function eliminarZonificacionDetalleAgregar(rowid) {
    $('#gridZonificacionDetalleAgregar').jqGrid('delRowData',rowid);
    contadorDetalleZonificacion--;
}
function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}

function validarMostrarDistritosZonificacion() {
    console.log('validarMostrarDistritosZonificacion');
    var validar = false;
    var divValidacion = $("#divMensajeValidaZonificacionDetalle");
    var mensajeValidacion = "";
    if($('#cmbZonificaciones').val() == ""){
         mensajeValidacion += "* Debe seleccionar una Zonificación <br>";   
    }
    if($('#cmbDepartamento').val() == ""){
         mensajeValidacion += "* Debe seleccionar un Departamento <br>";   
    }
    if($('#cmbProvincias').val() == ""){
         mensajeValidacion += "* Debe seleccionar una Provincia <br>";   
    }
    if(mensajeValidacion != ""){
        divValidacion.show();
        divValidacion.focus();
        divValidacion.html(mensajeValidacion);
        validar = false;
    }else{
        divValidacion.hide();
        divValidacion.html("");
        validar = true;
    }
    return validar;
}

function abrirPopupBusqDistrito() {
    console.log('abrirPopupBusqDistrito');
    $("#txtDistrP1").removeAttr("validate");
    var validar = $('#frmMantZonificacionDetalle').validateAllForm("#divMensajeValidaZonificacionDetalle");
//    if(validarMostrarDistritosZonificacion()){
    if(validar){
        $.ajax({
            url:baseURL + "pages/zonificacionDetalle/abrirPopupBusqDistrito", 
            type:'get',
            async:false,
            data:{
                seleccion:"multiple",
                idDepartamento:$('#cmbDepartamento').val(),
                idProvincia:$('#cmbProvincias').val(),
                idZonificacion:$('#cmbZonificaciones').val()
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                $("#dialogBusqDistrito").html(data);
                $("#dialogBusqDistrito").dialog({
                    resizable: false,
                    draggable: true,
                    autoOpen: true,
                    height:"auto",
                    width: "auto",
                    modal: true,
                    dialogClass: 'dialog',
                    title: "Seleccione Distrito"
                });
            },
            error:errorAjax
        });
    }
}