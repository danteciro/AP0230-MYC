$(function() {
   // procesarGridParametroDinamico(0);
    initInicioParametro();
    $('#frmMantParametro,#frmMantValorParametro').validarForm();
});

var alphaOptions = {
		allowNumeric  : true,
		allowLatin    : true,
		allowUpper    : true,
		allowLower    : true,
		allowCaseless : true,
		allowOtherCharSets : false,
		allowSpace    : true,
		allow		  : 'Ññóáéíóú'
			
	 };
function initInicioParametro() {
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoRequisitos';
    });
    confirm.start();
    $("#dialogMantParametro,#dialogMantValorParametro,#detalleValoresParametro").dialog({
        resizable: false,
        autoOpen: false,
        height: "auto",
        width: "auto",
        dialogClass: 'dialog',
        modal: true
    });
    comboboxMaestroColumna('cmbAmbitoParaBusq', baseURL + "pages/parametro/findAmbitoParametro");
    comboboxMaestroColumna('cmbAmbitoPara', baseURL + "pages/parametro/findAmbitoParametro");
    comboboxMaestroColumna('cmbTipoConsulta', baseURL + "pages/parametro/findTipoConsulta");

    $('#btnBuscarPara').click(function() {
        procesarGridParametroDinamico();
    });
    $('#btnNuevoPara').click(btnNuevoPara);
    $('#btnGuardarPara').click(btnGuardarPara);
    $('#btnEditarPara').click(btnEditarPara);
    $('#btnNuevoValoPara').click(btnNuevoValoPara);
    $('#btnGuardarValoPara').click(btnGuardarValoPara);
    $('#btnEditarValoPara').click(btnEditarValoPara);
     
}

//NUEVO PARAMETRO - INICIO
function btnNuevoPara() {
    limpiaFrmMantParametro();
    $("#dialogMantParametro").dialog("option", "title", "NUEVO PARÁMETRO DINÁMICO");
    $("#dialogMantParametro").dialog("open");
    comboboxMaestroColumna('cmbAmbitoPara', baseURL + "pages/parametro/findAmbitoParametro");
    
    $('#cmbTipoConsulta').change( function(){
    	 //if ($('#cmbTipoConsulta').val()=='200'){ $('#divPreguntaPara').show();} else { $('#divPreguntaPara').hide();}
         if ($('#cmbTipoConsulta :checked').html()=='PREGUNTA'){ $('#divPreguntaPara').show();} else { $('#divPreguntaPara').hide();}
    });    
    $("#txtNombrePara").alphanum(alphaOptions);
   
}

function btnGuardarPara() {
	$('#txtNombrePara').val($('#txtNombrePara').val().trim());
    var validar = $('#frmMantParametro').validateAllForm("#divMensajeValidaParametro");
    
    if (validar) {
        confirm.open("¿Ud. est&aacute; seguro de guardar este registro?", "procGuardarPara()");
    }
}
;
function procGuardarPara() {
    $.ajax({
        url:baseURL + "pages/parametro/registrarParametro",
        type:'post',
        async:false,
        data:$('#frmMantParametro').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridParametroDinamico();
                $("#dialogMantParametro").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//NUEVO PARAMETRO - FIN
//EDITAR PARAMETRO - INICIO
function editarParametroDinamico(rowid) {
    limpiaFrmMantParametro();
   
    var row = $('#gridParametroDinamico').jqGrid('getRowData', rowid);
    $("#dialogMantParametro").dialog("option", "title", "EDITAR PARÁMETRO DINÁMICO");
    $("#dialogMantParametro").dialog("open");
    $('#btnEditarPara').show();
    $('#btnGuardarPara').hide();
    // console.log(row["idAmbitoParametrico.idMaestroColumna"]);
    $('#txtIdPara').val(rowid);
    $('#txtNombrePara').val(row.nombre);
    $('#cmbAmbitoPara').val(row["idAmbitoParametrico.idMaestroColumna"]);
    $('#cmbTipoConsulta').val(row["idTipoConsulta.idMaestroColumna"]);
    $('#txtDescripcionPara').val(row.descripcion);
    $('#txtComentarioPara').val(row.comentario);
    $('#txtPreguntaPara').val(row.pregunta);    
    //if ($('#cmbTipoConsulta').val()=='200'){ $('#divPreguntaPara').show();} else { $('#divPreguntaPara').hide();}
    if ($('#cmbTipoConsulta :checked').html()=='PREGUNTA'){ $('#divPreguntaPara').show();} else { $('#divPreguntaPara').hide();}
    
    $('#cmbTipoConsulta').change( function(){
   	 if ($('#cmbTipoConsulta :checked').html()=='PREGUNTA'){ $('#divPreguntaPara').show();} else { $('#divPreguntaPara').hide();}
   });  
}
function btnEditarPara() {
	$('#txtNombrePara').val($('#txtNombrePara').val().trim());
	var validar = $('#frmMantParametro').validateAllForm("#divMensajeValidaParametro");
    if (validar) {
        //confirm.open("¿Ud est&aacute; seguro de Guardar los Cambios en este registro?", "procEditarPara()");
    	validarDependParametro();
    }
}

function validarDependParametro(){
    $.ajax({
        url:baseURL + "pages/parametro/validarParametro",
        type:'post',
        async:false,
        data:$('#frmMantParametro').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="DEPENDENCE"){
            	confirm.open("Este parámetro tiene dependencias, los cambios realizados se aplicarán al parámetro dinámico ¿Confirmar si desea realizar los cambios?","procEditarPara()");
            } else {
            	confirm.open("¿Ud. est&aacute; seguro de guardar los cambios en este parámetro?","procEditarPara()");
            }
            
        },
        error:errorAjax
    });
}
function procEditarPara() {
   
	 $.ajax({
	        url:baseURL + "pages/parametro/editarParametro",
	        type:'post',
	        async:false,
	        data:$('#frmMantParametro').serialize(),
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="SUCCESS"){
	                mensajeGrowl("success", global.confirm.edit, "");
	                procesarGridParametroDinamico();
	            }else{
	                mensajeGrowl("error", data.mensaje, "");
	            }
	        },
	        error:errorAjax
	    });
    $("#dialogMantParametro").dialog("close");
}
//EDITAR PARAMETRO - FIN
//ELIMINAR PARAMETRO - INICIO
function eliminarParametroDinamico(rowid) {
    confirm.open("¿Ud. est&aacute; seguro de eliminar el parámetro dinámico?", "procEliminarPara('" + rowid + "')");
}
function procEliminarPara(id) {
	 $.ajax({
	        url:baseURL + "pages/parametro/eliminarParametro",
	        type:'post',
	        async:false,
	        data:{
	            idParametroDinamico:id
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.resultado=="SUCCESS"){
	                mensajeGrowl("success", global.confirm.delete, "");
	                procesarGridParametroDinamico();
	            }else if(data.resultado=="DEPENDENCE_VALOR"){
	            	mensajeGrowl("warn", "Para eliminar el parámetro, primero debe desasignar sus valores", "");
	            }else if(data.resultado=="DEPENDENCE"){
	            	mensajeGrowl("warn", "Para eliminar el parámetro, primero debe desasignarlo del requisito procedimiento", "");
	            }  else {
	                mensajeGrowl("error", data.mensaje, "");
	            }
	        },
	        error:errorAjax
	    });
}
//ELIMINAR PARAMETRO - FIN
//////////////////////
//NUEVO VALOR PARAMETRO - INICIO


function btnNuevoValoPara() {
    limpiaFrmMantValorParametro();
    $("#dialogMantValorParametro").dialog("option", "title", "NUEVO VALOR PARA PARÁMETRO DINÁMICO: " + $('#lblDescripPara').html());
    $('#txtIdParametroDinamico').val($("#txtIdParametroDinamicoValor").val());
    $("#dialogMantValorParametro").dialog("open");
    $("#txtValorValoPara").alphanum(alphaOptions);    
}
function btnGuardarValoPara() {
	$('#txtValorValoPara').val($('#txtValorValoPara').val().trim());
	var validar = $('#frmMantValorParametro').validateAllForm("#divMensajeValidaValorParametro");
    
    if (validar) {
       
    	confirm.open("¿Ud. est&aacute; seguro de guardar este registro de valor?", "procGuardarValoPara()");
    }
}
function procGuardarValoPara() {
    
	if($("#chkValorDefault").is(':checked')) { $("#chkValorDefecto").val("1");} else {$("#chkValorDefecto").val("0");}
    $.ajax({
        url:baseURL + "pages/parametro/registrarValorParametro",
        type:'post',
        async:false,
        data:$('#frmMantValorParametro').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridValoresParametroDinamico($('#txtIdParametroDinamicoValor').val());
                $("#dialogMantValorParametro").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
    $("#dialogMantValorParametro").dialog("close");
}
//NUEVO VALOR PARAMETRO - FIN
//EDITAR VALOR PARAMETRO - INICIO
function editarValorParametroDinamico(rowid) {
 
	var row = $('#gridValoresParametroDinamico').jqGrid('getRowData', rowid);
    $("#dialogMantValorParametro").dialog("option", "title", "EDITAR VALOR DE PARÁMETRO DINÁMICO");
    $("#dialogMantValorParametro").dialog("open");
    $('#btnEditarValoPara').show();
    $('#btnGuardarValoPara').hide();
    $('#txtIdParametroDinamico').val($("#txtIdParametroDinamicoValor").val());
    $('#txtIdValoPara').val(rowid);
    $('#txtValorValoPara').val(row.valor);
    $('#txtDescripcionValoPara').val(row.descripcion);
    $('#txtComentarioValoPara').val(row.comentario);
    if(row.valorDefecto=='SI'){ $('#chkValorDefault').attr('checked', true);}
    else{$('#chkValorDefault').attr('checked', false);}

    
}
function btnEditarValoPara() {
	$('#txtValorValoPara').val($('#txtValorValoPara').val().trim());
	var validar = $('#frmMantValorParametro').validateAllForm("#divMensajeValidaValorParametro");
    if (validar) {
       // confirm.open("¿Ud est&aacute; seguro de Guardar los Cambios en este registro de Valor?", "procEditarValoPara()");
    	validarDependValorParametro();
    }
}

function validarDependValorParametro(){
    $.ajax({
        url:baseURL + "pages/parametro/validarValorParametro",
        type:'post',
        async:false,
        data:$('#frmMantValorParametro').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="DEPENDENCE"){
            	confirm.open("Existen dependencias, los cambios realizados se aplicarán al valor parámetro ¿Confirmar si desea realizar los cambios?","procEditarValoPara()");
            } else {
            	confirm.open("¿Ud. est&aacute; seguro de guardar los cambios en este valor parámetro?","procEditarValoPara()");
            }
            
        },
        error:errorAjax
    });
}
function procEditarValoPara() {
    //procesarGridValoresParametroDinamico($('#txtIdParametroDinamicoValor').val());
	if($("#chkValorDefault").is(':checked')) { $("#chkValorDefecto").val("1");} else {$("#chkValorDefecto").val("0");}
    $.ajax({
        url:baseURL + "pages/parametro/editarValorParametro",
        type:'post',
        async:false,
        data:$('#frmMantValorParametro').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridValoresParametroDinamico($('#txtIdParametroDinamicoValor').val());
            } else {
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
    $("#dialogMantValorParametro").dialog("close");
}
//EDITAR VALOR PARAMETRO - FIN
//ELIMINAR VALOR PARAMETRO - INICIO
function eliminarValorParametroDinamico(rowid) {
	    
    confirm.open("¿Ud. est&aacute; seguro de eliminar este registro de valor?", "procEliminarValoPara('" + rowid + "')");
}
function procEliminarValoPara(id) {
     
	//$('#gridValoresParametroDinamico').jqGrid('delRowData', id);    
    $.ajax({
        url:baseURL + "pages/parametro/eliminarValorParametro",
        type:'post',
        async:false,
        data:{
        	idValorParametro:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridValoresParametroDinamico($('#txtIdParametroDinamicoValor').val());
            }else if(data.resultado=="DEPENDENCE"){
            	mensajeGrowl("warn", "Para eliminar el valor parámetro, primero debe desasignarlo del procedimiento", "");
            } else {
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//ELIMINAR VALOR PARAMETRO - FIN
///////////////////////////////
function limpiaFrmMantParametro() {
    $('#frmMantParametro').find('input,select,textarea').val("");
    $('#btnEditarPara').hide();
    $('#btnGuardarPara').show();
    $('#filaTipoSeleccion').hide();
    $('#divPreguntaPara').hide();
    
}
function limpiaFrmMantValorParametro() {
    $('#dialogMantValorParametro').find('input,select,textarea').not('#btnGuardarValoPara,#btnEditarValoPara').val("");
    $('#chkValorDefault').attr('checked', false);
    $('#btnEditarValoPara').hide();
    $('#btnGuardarValoPara').show();
}
function procesarGridParametroDinamico(flg_load) {
    if (flg_load === undefined) {
        flg_load = 1;
    }

    $("#gridContenedorParametroDinamico").html("");
    var grid = $("<table>", {
        "id": "gridParametroDinamico"
    });
    var pager = $("<div>", {
        "id": "paginacionParametroDinamico"
    });
    $("#gridContenedorParametroDinamico").append(grid).append(pager);

    var nombres = ['NOMBRE', 'ÁMBITO', 'idMaestro','idTipoConsulta','pregunta','DESCRIPCIÓN', 'COMENTARIO'/*,'TIPO SELECCION'*/];
    var columnas = [
        {name: "nombre", width: 100, sortable: false, align: "left"},
        {name: "idAmbitoParametrico.descripcion", width: 100, sortable: false, align: "left"},
        {name: "idAmbitoParametrico.idMaestroColumna", width: 300, sortable: false, hidden: true, align: "left"},
        {name: "idTipoConsulta.idMaestroColumna", width: 300, sortable: false, hidden: true, align: "left"},
        {name: "pregunta", width: 300, sortable: false, hidden: true, align: "left"},
        {name: "descripcion", width: 300, sortable: false, hidden: false, align: "left"},
        {name: "comentario", width: 300, sortable: false, hidden: false, align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/parametro/findParametro",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            nombre: $("#txtDescripParaBusq").val(),
            idAmbitoParametrico: $("#cmbAmbitoParaBusq").val()
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionParametroDinamico",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Parámetros Dinámicos",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idParametroDinamico"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkVerProcedimiento').attr('onClick', 'verParametroDinamico("' + rowid + '")');
            $('#linkEditarProcedimiento').attr('onClick', 'editarParametroDinamico("' + rowid + '")');
            $('#linkEliminarProcedimiento').attr('onClick', 'eliminarParametroDinamico("' + rowid + '")');
            $('#linkAgregarActProcedimiento').attr('onClick', 'mostrarValorParametroDinamico("' + rowid + '","' + row.nombre + '")');
            
            
            if($('#divEnlaceTagEditar input').html()!=null){
            	$('#contextMenuParametroDinamico li a[value="MO-PARADINA"]').html($('#divEnlaceTagEditar').html());               
               } else {
             	  $('#contextMenuParametroDinamico li a[value="MO-PARADINA"]').remove();
               }
            
            if($('#divEnlaceTagEliminar input').html()!=null){
            	$('#contextMenuParametroDinamico li a[value="EL-PARADINA"]').html($('#divEnlaceTagEliminar').html());               
               } else {
             	  $('#contextMenuParametroDinamico li a[value="EL-PARADINA"]').remove();
               }
            
            if($('#divEnlaceTagValores input').html()!=null){
            	$('#contextMenuParametroDinamico li a[value="CO-PARADINA"]').html($('#divEnlaceTagValores').html());               
               } else {
             	  $('#contextMenuParametroDinamico li a[value="CO-PARADINA"]').remove();
               }
        },
        loadComplete: function(data) {
            $('#contextMenuParametroDinamico').parent().remove();
            $('#divContextMenuParametroDinamico').html("<ul id='contextMenuParametroDinamico'>"
                    + "<li> <a value='MO-PARADINA'></a></li>"
                    + "<li> <a value='EL-PARADINA'></a></li>"
                    + "<li> <a value='CO-PARADINA'></a></li>"
                    + "</ul>");
            $('#contextMenuParametroDinamico').puicontextmenu({
                target: $('#gridParametroDinamico')
            });
        }
        
//        onRightClickRow: function(rowid, iRow, iCol, e) {
//            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkVerProcedimiento').attr('onClick', 'verParametroDinamico("' + rowid + '")');
//            $('#linkEditarProcedimiento').attr('onClick', 'editarParametroDinamico("' + rowid + '")');
//            $('#linkEliminarProcedimiento').attr('onClick', 'eliminarParametroDinamico("' + rowid + '")');
//            $('#linkAgregarActProcedimiento').attr('onClick', 'mostrarValorParametroDinamico("' + rowid + '","' + row.nombre + '")');
//        },
//        loadComplete: function(data) {
//            $('#contextMenuParametroDinamico').parent().remove();
//            $('#divContextMenuParametroDinamico').html("<ul id='contextMenuParametroDinamico'>"
//                    + "<li> <a id='linkEditarProcedimiento' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
//                    + "<li> <a id='linkEliminarProcedimiento' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                    + "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Valores'>Valores</a></li>"
//                    + "</ul>");
//            $('#contextMenuParametroDinamico').puicontextmenu({
//                target: $('#gridParametroDinamico')
//            });
//        }
    });
}
function procesarGridValoresParametroDinamico(rowid) {
    $("#gridContenedorValoresParametroDinamico").html("");
    var grid = $("<table>", {
        "id": "gridValoresParametroDinamico"
    });
    var pager = $("<div>", {
        "id": "paginacionValoresParametroDinamico"
    });
    $("#gridContenedorValoresParametroDinamico").append(grid).append(pager);

    var nombres = ['VALOR', 'DESCRIPCIÓN', 'COMENTARIO', 'POR DEFECTO'];
    var columnas = [
        {name: "valor", width: 150, sortable: false, align: "left"},
        {name: "descripcion", width: 300, sortable: false, align: "left"},
        {name: "comentario", width: 300, sortable: false, align: "left"},
        {name: "valorDefecto", width: 80, sortable: false, align: "center", formatter: valorDefecto}
    ];
    grid.jqGrid({
        url: baseURL + "pages/parametro/findValorParametro",
        datatype: "json",
        postData: {
            idParametroDinamico: $('#txtIdParametroDinamicoValor').val(),
            flg_load: 1,
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionValoresParametroDinamico",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idValorParametro"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkEditarValoPara').attr('onClick', 'editarValorParametroDinamico("' + rowid + '")');
            $('#linkEliminarValoPara').attr('onClick', 'eliminarValorParametroDinamico("' + rowid + '")');
            
        	if(row.valor == "--SELECCIONE--"){
        		$('#contextMenuValoresParametroDinamico').parent().css('opacity',0);
        		$('#contextMenuValoresParametroDinamico').css('display','none');
        	} else {     	
        		$('#contextMenuValoresParametroDinamico').css('display','initial');
        	if($('#divEnlaceTagEditarValoPara input').html()!=null){
        		$('#contextMenuValoresParametroDinamico li a[value="MO-GRIDVALOPARA"]').html($('#divEnlaceTagEditarValoPara').html());               
        	} else {
        		$('#contextMenuValoresParametroDinamico li a[value="MO-GRIDVALOPARA"]').remove();
        	}	            
        	if($('#divEnlaceTagEliminarValoPara input').html()!=null){
        		$('#contextMenuValoresParametroDinamico li a[value="EL-GRIDVALOPARA"]').html($('#divEnlaceTagEliminarValoPara').html());               
        	} else {
        		$('#contextMenuValoresParametroDinamico li a[value="EL-GRIDVALOPARA"]').remove();             	 
        	}
        	if($('#divEnlaceTagEliminarValoPara input').html()==null && $('#divEnlaceTagEditarValoPara input').html()==null){
        		$('#contextMenuValoresParametroDinamico').parent().css('opacity',0);
        	}
        	$('#contextMenuValoresParametroDinamico').parent().css('opacity',1);
        	}
        },
        loadComplete: function(data) {
        	$('#contextMenuValoresParametroDinamico').parent().css('opacity',1);
            $('#contextMenuValoresParametroDinamico').parent().remove();
            $('#divContextMenuValoresParametroDinamico').html("<ul id='contextMenuValoresParametroDinamico'>"
            		+ "<li> <a value='MO-GRIDVALOPARA'></a></li>"
                    + "<li> <a value='EL-GRIDVALOPARA'></a></li>"
                    + "</ul>");
            $('#contextMenuValoresParametroDinamico').puicontextmenu({
                target: $('#gridValoresParametroDinamico')
            });
        }
//        onRightClickRow: function(rowid, iRow, iCol, e) {
//            var row = grid.jqGrid('getRowData', rowid);
//            $('#linkEditarValoPara').attr('onClick', 'editarValorParametroDinamico("' + rowid + '")');
//            $('#linkEliminarValoPara').attr('onClick', 'eliminarValorParametroDinamico("' + rowid + '")');
//        },
//        loadComplete: function(data) {
//            $('#contextMenuValoresParametroDinamico').parent().remove();
//            $('#divContextMenuValoresParametroDinamico').html("<ul id='contextMenuValoresParametroDinamico'>"
//                    + "<li><a id='linkEditarValoPara' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
//                    + "<li><a id='linkEliminarValoPara' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                    + "</ul>");
//            $('#contextMenuValoresParametroDinamico').puicontextmenu({
//                target: $('#gridValoresParametroDinamico')
//            });
//        }
    });
}
function valorDefecto(nombre) {
    var sel = 'NO';
    if (nombre == '1' && nombre != '' && nombre != undefined) {
        sel = 'SI';
    }
    return sel;
}
function mostrarValorParametroDinamico(rowid, nombre) {
    $('#txtIdParametroDinamicoValor').val(rowid);
    $('#lblDescripPara').html(nombre);
    procesarGridValoresParametroDinamico(rowid);
    $('#detalleValoresParametro').dialog('open');
}