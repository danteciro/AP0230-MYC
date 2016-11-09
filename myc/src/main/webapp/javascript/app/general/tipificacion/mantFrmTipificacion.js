var contadorTipificacion = 0;
var idTipificacionTmp = 0;
$(function() {
    anularEnter();
    $('#frmMantTipificacion').validarForm();
    $('#btnGuardarTipi').click(btnGuardarTipi);
    $('#btnEditarTipi').click(btnEditarTipi);
    $('#txtTipoSancon').change(mostrarCampos);
    boton.closeDialog();
    $('#btnAbreMantTipoSancion').click(abreMantTipoSancion);
    mostrarCampos();
    $('#txtTipoSancon').change(function(){
        idTipiSanc="";
        $('#txtTipoMoneda,#txtSancionMonetaria,#txtSancAdmP1,#txtIdSandAdmP1,#txtJsonSancAdmP1').val("");
        $('#txtSancAdmP1').attr('title','');
    });
    $('#txtCodTipificacion').alphanum(tipificacion);
    $('#txtDescripcion').alphanum(charAllow);
    $('#txtBasesLegales').alphanum(charAllow);
//    $('#btnAgregarTipificacion').click(btnAgregarTipificacion);
    
    //comboboxMaestroColumna('txtTipoSancon', baseURL + "pages/parametro/findTipoSancion");
    //comboboxTipificacionesPadre('txtTipificacionPadre', baseURL + "pages/tipificacion/findListadoTipificacion");
});
function comboboxTipificacionesPadre(idSelect, url) {
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
                        $items += "<option value='" + value.idTipificacion + "'>" + value.codTipificacion + "</option>";
                    });
                    $combo.html($items);
                } else {
                    $combo.html('<option value="">--Seleccione--</option>');
                }
            } else {
            }
        },
        error: function() {
        }
    });
}
function btnAgregarTipificacion(){
    var validar = $('#frmMantTipificacion').validateAllForm("#divMensajeValidaTipificacion");
    var descTipoMoneda = "";
    if($('#txtTipoMoneda').val() !== ""){
        descTipoMoneda = $("#txtTipoMoneda option:selected").text();
    }
    var descTipiPadre = "";
    if($('#txtTipificacionPadre').val() !== ""){
        descTipiPadre = $("#txtTipificacionPadre option:selected").text();
    }
    if(validar){
//        var data=eval("("+$('#txtJsonSancAdmP1').val()+")");
//        $.map(data,function(item){
            var mydata = [{
                    codigoTipificacion: $('#txtCodTipificacion').val(),
                    tipoSancion: $('#txtTipoSancon').val(),
                    descTipoSancion: $("#txtTipoSancon option:selected").text(),
                    tipoMoneda: $('#txtTipoMoneda').val(),
                    descTipoMoneda: descTipoMoneda,
                    sancionMonetaria: $('#txtSancionMonetaria').val().toUpperCase(),
//                    idSancionAdministrativa: item.id,
//                    descSancionMonetaria: item.nombre,
                    descripcion: $('#txtDescripcion').val().toUpperCase(),
                    basesLegales: $('#txtBasesLegales').val().toUpperCase(),
                    tipificacionPadre: $('#txtTipificacionPadre').val(),
                    descTipificacionPadre: descTipiPadre
            }];
            if(contadorTipificacion==0){
                procesarGridTipificacionAgregar();
            }
            if(jQuery("#gridTipificacionAgregar").length>0){
                jQuery("#gridTipificacionAgregar").jqGrid('addRowData',contadorTipificacion,mydata[0]); 
                contadorTipificacion++;
            }
//        });
        limpiaFrmMantTipificacion();
    }
}
function procesarGridTipificacionAgregar(){
    $("#gridContenedorTipificacionAgregar").html("");
    var grid = $("<table>", {
        "id": "gridTipificacionAgregar"
    });
    var pager = $("<div>", {
        "id": "paginacionTipificacionAgregar"
    });
    $("#gridContenedorTipificacionAgregar").append(grid).append(pager);

    var nombres = ['CODIGO TIPIFICACION', 'TIPOSANCION', 'TIPO SANCION', 'TIPOMONEDA', 'TIPO MONEDA', 'SANCION MONETARIA', 'DESCRIPCION', 'BASES LEGALES', 'TIPIFICACIONPADRE', 'TIPIFICACION PADRE'];
    var columnas = [
        {name: "codigoTipificacion", width: 100, sortable: false, hidden: false, align: "center"},
        {name: "tipoSancion", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "descTipoSancion", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "tipoMoneda", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "descTipoMoneda", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "sancionMonetaria", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "descripcion", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "basesLegales", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "tipificacionPadre", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "descTipificacionPadre", width: 100, sortable: false, hidden: false, align: "center"}
    ];
    grid.jqGrid({
//        url: baseURL + "pages/zonificacionDetalle/listarZonificacionDetalle",
        datatype: "local",
//        postData: {
//            flg_load: flg_load,
//            zonificacion: $("#cmbZonificacionesBusq").val()
//        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionTipificacionAgregar",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Tipificaciones",
        autowidth: true,
//        jsonReader: {
//            root: "filas",
//            page: "pagina",
//            total: "total",
//            records: "registros",
//            repeatitems: false,
//            id: "idZonificacionDetalle"
//        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkVerProcedimiento').attr('onClick', 'verParametroDinamico("' + rowid + '")');
//            $('#linkEditarZonificacionDetalle').attr('onClick', 'editarZonificacionDetalle("' + rowid + '")');
            $('#linkEliminarTipificacionAgregar').attr('onClick', 'eliminarTipificacionAgregar("' + rowid + '")');
//            $('#linkAgregarActProcedimiento').attr('onClick', 'mostrarValorParametroDinamico("' + rowid + '","' + row.nombre + '")');
        },
        loadComplete: function(data) {
            $('#contextMenuTipificacionAgregar').parent().remove();
            $('#divContextMenuTipificacionAgregar').html("<ul id='contextMenuTipificacionAgregar'>"
//                    + "<li> <a id='linkEditarZonificacionDetalle' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarTipificacionAgregar' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
                    + "</ul>");
            $('#contextMenuTipificacionAgregar').puicontextmenu({
                target: $('#gridTipificacionAgregar')
            });
        }
    });
}
function eliminarTipificacionAgregar(rowid) {
    $('#gridTipificacionAgregar').jqGrid('delRowData',rowid);
    contadorTipificacion--;
}
function limpiaFrmMantTipificacion(){
    $('#frmMantTipificacion').find('input,select,textarea').not('#btnAgregarTipificacion,#btnAbreMantTipoSancion').val("");
    $('#btnEditarTipi').hide();
    $('#btnGuardarTipi').show();
}
function abreMantTipoSancion(){
    var title="SANCIÓN ADMINISTRATIVA";
    $.ajax({
        url:baseURL + "pages/tipoSancion/abrirMantTipoSancion", 
        type:'get',
        async:false,
        data:{
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantTipoSancion").html(data);
            $("#dialogMantTipoSancion").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "550px",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar",
                close: function( event, ui ) {
                    $(this).dialog('destroy');
                }
            });
        },
        error:errorAjax
    });
}
function mostrarCampos(){
    //var tipoSancion = $('#txtTipoSancon').val();
    //if(tipoSancion === "253"){
    if($('#txtTipoSancon').find(':selected').html()=="MONETARIA"){
        $("#tipoMoneda").show();
        $("#txtTipoMoneda").attr("validate","[O]");
        $("#sancionMonetaria").show();
        $("#txtSancionMonetaria").attr("validate","[O]");
        $("#sancionAdministrativa").hide();
        $("#txtSancAdmP1").removeAttr("validate");
    //}else if(tipoSancion === "254"){
    }else if($('#txtTipoSancon').find(':selected').html()=="ADMINISTRATIVA"){
        $("#tipoMoneda").hide();
        $("#txtTipoMoneda").removeAttr("validate");
        $("#sancionMonetaria").hide();
        $("#txtSancionMonetaria").removeAttr("validate");
        $("#sancionAdministrativa").show();
        $("#txtSancAdmP1").attr("validate","[O]");
    //}else if(tipoSancion === "255"){
    }else if($('#txtTipoSancon').find(':selected').html()=="AMBAS"){
        $("#tipoMoneda").show();
        $("#txtTipoMoneda").attr("validate","[O]");
        $("#sancionMonetaria").show();
        $("#txtSancionMonetaria").attr("validate","[O]");
        $("#sancionAdministrativa").show();
        $("#txtSancAdmP1").attr("validate","[O]");
    }else{
        $("#tipoMoneda").hide();
        $("#txtTipoMoneda").removeAttr("validate");
        $("#sancionMonetaria").hide();
        $("#txtSancionMonetaria").removeAttr("validate");
        $("#sancionAdministrativa").hide();
        $("#txtSancAdmP1").removeAttr("validate");
    }
}
function btnGuardarTipi(){
    var validar = $('#frmMantTipificacion').validateAllForm("#divMensajeValidaTipificacion");
//    
//       
//    if($('#txtDescRequ').val()!=''  && $('input[name="archivos[' +  i + ']"]').val()!=''){
//    	$("#formArchivo").submit();	
//    } else {
    //var tipoSancion = $('#txtTipoSancon').val();
    /*if(tipoSancion === "253"){
        if($("#txtTipoMoneda").val()==="" || $("#txtSancionMonetaria").val()===""){
            alert("Debe seleccionar Tipo Moneda e ingresar Sancion Monetaria");
            validar = false;
        }
    }else if(tipoSancion === "254"){
        if($("#txtSancAdmP1").val()===""){
            alert("Debe seleccionar Sancion Administrativa");
            validar = false;
        }
    }else if(tipoSancion === "255"){
        if($("#txtTipoMoneda").val()==="" || $("#txtSancionMonetaria").val()==="" || $("#txtSancAdmP1").val()===""){
            alert("Debe seleccionar Tipo Moneda, Sancion Monetaria y Sancion Administrativa");
            validar = false;
        }
    }*/
    	if (validar) {
       	 confirm.open("¿Ud. est&aacute; seguro de guardar estos registros?","procGuardarTipificacion()");
       } 
//    }
};
function procGuardarTipificacion(){
    var SancAdm = "";
    if($('#txtSancAdmP1').val()!=""){
        SancAdm=$('#txtIdSandAdmP1').val();
//        var data=eval("("+$('#txtJsonSancAdmP1').val()+")");
//        
//        $.map(data,function(item){
//            SancAdm = SancAdm + item.id + ",";
//        });
    }
        
    if(SancAdm === ""){
        SancAdm = "-1";
    }
        
    $.ajax({
        url: baseURL + "pages/tipificacion/registrarTipificacion",
        type: 'post',
        async: false,
        data: {
            codigoTipificacion:$('#txtCodTipificacion').val(),
            tipoSancion:$('#txtTipoSancon').val(),
            tipoMoneda:$('#txtTipoMoneda').val(),
            sancionMonetaria:$('#txtSancionMonetaria').val().toUpperCase(),
            descripcion:$('#txtDescripcion').val(),
            basesLegales:$('#txtBasesLegales').val().trim(),
            tipificacionPadre:$('#txtTipificacionPadre').val(),
            tipoSanciones:SancAdm
        },//$('#frmMantZonificacionDetalle').serialize(),
        beforeSend: muestraLoading,
        success: function(data) {
            ocultaLoading();
            if (data.resultado == "0") {
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridTipificacion();
                $("#dialogMantTipificacion").dialog("close");
            } else {
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error: errorAjax
    });
}
function btnEditarTipi(){
    $('#txtCodTipificacion').val($('#txtCodTipificacion').val().trim());
    $('#txtSancionMonetaria').val($('#txtSancionMonetaria').val().trim());
    $('#txtDescripcion').val($('#txtDescripcion').val().trim());
    $('#txtBasesLegales').val($('#txtBasesLegales').val().trim());
    var validar = $('#frmMantTipificacion').validateAllForm("#divMensajeValidaTipificacion");
    if (validar) {
        confirm.open("¿Ud. est&aacute; seguro de guardar los cambios en esta tipificacion?", "procEditarTipificacion()");
    }
}
function procEditarTipificacion() {
    var SancAdm = "";
    //var IdSanAdm = "";
    if($('#txtTipoSancon').val()!=""){
        SancAdm=$('#txtIdSandAdmP1').val();
//        var data=eval("("+$('#txtJsonSancAdmP1').val()+")");
//        
//        $.map(data,function(item){
//            SancAdm = SancAdm + item.id + ",";
//        });
    }
    
//    if(idTipSan !== ""){
//        IdSanAdm = idTipSan + ",";
//    }
    
        if(SancAdm === ""){
            SancAdm = "-1";
        }
        
//        if(IdSanAdm === ""){
//            IdSanAdm = "-1";
//        }
    
    $.ajax({
        url:baseURL + "pages/tipificacion/editarTipificacion",
        type:'post',
        async:false,
        data:{
                idTipificacion:$('#txtIdTipificacion').val(),
                codigoTipificacion:$('#txtCodTipificacion').val(),
                tipoSancion:$('#txtTipoSancon').val(),
                tipoMoneda:$('#txtTipoMoneda').val(),
                sancionMonetaria:$('#txtSancionMonetaria').val().toUpperCase(),
                descripcion:$('#txtDescripcion').val(),
                basesLegales:$('#txtBasesLegales').val(),
                tipificacionPadre:$('#txtTipificacionPadre').val(),
                tipoSanciones:SancAdm
            },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridTipificacion();
                $("#dialogMantTipificacion").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function abrirPopupBusqSancionAdministrativa() {
  
    $.ajax({
        url:baseURL + "pages/tipoSancion/abrirPopupBusqSancAdm", 
        type:'get',
        async:false,
        data:{
            seleccion:"multiple"
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogBusqSancAdm").html(data);
            $("#dialogBusqSancAdm").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: "Seleccione Sancion Administrativa",
                close: function( event, ui ) {
                    $(this).dialog('destroy');
                }
            });
        },
        error:errorAjax
    });
    
    console.log("--->"+idTipiSanc);
    if(idTipiSanc!=""){
        var actis=idTipiSanc.split(",");
        $.each(actis,function(k,v){
          $("#arbolSancAdmEspe").fancytree("getTree").getNodeByKey(parseInt(v)).setSelected();        
        });
    }
}