/**
* Resumen           
* Objeto            : mantenimiento.js
* Descripción       : JavaScript de prioridad norma agente en el MYC.
* Fecha de Creación : 07/07/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Mario Dioses Fernandez.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
var mensajeErrorEdicion = "";
var flagBusqueda=false;
$(function() {
    procesarGridNormaAgente(0);
    initInicioNormaAgente();  
});


function initInicioNormaAgente(){
	$("#botones2").hide();
	$("#botones3").hide();
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });    
    confirm.start();
    $('#btnBuscarPrioridaNA').click(function(){
    	buscarNormaAgente();
    });
    $('#btnNuevoPrioridaNA').click(function(){
    	abrirMantNormaAgente("new",'', $('#cmbActividad').val(), $('#cmbAgente').val());     	
    }); 
    $('#btnEditarPrioridaNA').click(editarPrioridadNA);
    $('#btnCancelarActivarEditarPrioridaNA, #btnCancelarEdicionPrioridaNA').click(cancelarModificar);    
    $('#btnSeleccionarTodoPrioridaNA').click(seleccionarTodo);
    $('#btnActivarEditarPrioridaNA').click(activarModoEdicion);    
    $('#btnGuardarEdicionPrioridaNA').click(function(){
    	confirm.open("¿Ud. est&aacute; seguro de actualizar registros?","guardarEdicion()");   	
    });   
    $('#btnLimpiarForm').click(btnLimpiarForm);
    $('#cmbActividad').change(function(){cargarAgente();activarBotones();});
    $('#cmbAgente').change(function(){
    	procesarGridNormaAgente(0);
    	cancelarModificar();
    });
    activarBotones();
}

function buscarNormaAgente(){
	activarBotones();
	if($('#cmbActividad').val()!='' && $('#cmbAgente').val()!=''){
		procesarGridNormaAgente();
	} 	
}

function activarBotones(){
	if($('#cmbActividad').val()!='' && $('#cmbAgente').val()!=''){	
		$('#btnEditarPrioridaNA').removeAttr('disabled');
		$('#btnNuevoPrioridaNA').removeAttr('disabled');
		$('#btnEditarPrioridaNA').attr('class','btn_a btn_small');
		$('#btnNuevoPrioridaNA').attr('class','btn_a btn_small');		
	} else {
		procesarGridNormaAgente(0); 
		$('#btnEditarPrioridaNA').attr('disabled','disabled');
		$('#btnNuevoPrioridaNA').attr('disabled','disabled');
		$('#btnEditarPrioridaNA').attr('class','btn_small');	
		$('#btnNuevoPrioridaNA').attr('class','btn_small');			
	}
}

function guardarEdicion(){
	var repetidos = false;
	var ordenRepetidos='';
	var grid=$("#gridPrioridadNorma1");	
	var row_temporal;
	var filasSeleccionadas=grid.jqGrid("getGridParam","selarrrow");
	//validamos que no acepte numeros de orden repetidos y que sea mayor a cero. 
	var _pase=true;
	var errorMensaje = "La(s) normas legales </br> ";
	$(filasSeleccionadas).each(function(i,item){		
		var fil=parseInt(item);
		var valor_row = "Fila " + grid.jqGrid('getInd',fil);
		var valor_orden = $(jQuery('#gridPrioridadNorma1').jqGrid("getInd",fil,true)).find("input[name='orden']").val();
		var normaLegales=$(jQuery('#gridPrioridadNorma1').jqGrid("getInd",fil,true)).find("td[aria-describedby='gridPrioridadNorma1_idBaseLegal.descripcionGeneralBaseLegal']").html();  
		valor_orden = $.trim(valor_orden);		
		if(valor_orden == null || valor_orden.length == 0 || valor_orden == 0){
			errorMensaje = errorMensaje +"<b>"+normaLegales+"</b></br> " ;
			_pase=false;
		};		
		$(filasSeleccionadas).each(function(x,item_){	
			var fil_=parseInt(item_);
			var valor_orden_=$(jQuery('#gridPrioridadNorma1').jqGrid("getInd",fil_,true)).find("input[name='orden']").val();
			if(fil!=fil_){				
				if(valor_orden==valor_orden_ && valor_orden!=0 && valor_orden_!=0){
					if(ordenRepetidos.indexOf(valor_orden)==-1)
						ordenRepetidos+="<b>("+valor_orden+")</b>, ";
					repetidos=true;
					_pase=false;
				}
			}
		});
	});
	errorMensaje = errorMensaje +" no se puede(n) editar. Ingrese n&uacute;mero de orden correcto." ;
	if(repetidos){
		ordenRepetidos=ordenRepetidos.substring(0, ordenRepetidos.length - 2);
		errorMensaje = "No se puedo editar, los n&uacute;meros de orden " + ordenRepetidos + " son repetidos.";
	}
	
	if(_pase){
		var index=0;
		var cadIdPrioridadNormaAgente="";
		var cadOrden="";
		mensajeErrorEdicion = "Se encontraron los siguientes errores";
		var parameters = "_=p";
		$(filasSeleccionadas).each(function(i,item){
			var fila=parseInt(item);
			row_temporal = fila;
			
			var idPrioridadNormaAgente=$('#gridPrioridadNorma1').jqGrid('getRowData', fila)['idPrioridadNormaAgente'];
			cadIdPrioridadNormaAgente+=idPrioridadNormaAgente+",";
			var idActividad=$('#cmbAgente').val();
			var idBaseLegal=$('#gridPrioridadNorma1').jqGrid('getRowData', fila)['idBaseLegal.idBaseLegal'];
			var orden=$(jQuery('#gridPrioridadNorma1').jqGrid("getInd",fila,true)).find("input[name='orden']").val();
			cadOrden+=orden+",";
			parameters += "&listaPrioridadNorma["+index+"].idPrioridadNormaAgente="+idPrioridadNormaAgente;
			parameters += "&listaPrioridadNorma["+index+"].idAgente.idActividad="+idActividad;                          
	    	parameters += "&listaPrioridadNorma["+index+"].idBaseLegal.idBaseLegal="+idBaseLegal;
	    	parameters += "&listaPrioridadNorma["+index+"].orden="+orden;   
	    	index++;
		});		
		if(cadOrden.length!=0)
			cadOrden = cadOrden.substr(0, cadOrden.length - 1);
		if(cadIdPrioridadNormaAgente.length!=0)
			cadIdPrioridadNormaAgente = cadIdPrioridadNormaAgente.substr(0, cadIdPrioridadNormaAgente.length - 1);
		parameters +="&codigosOrden="+cadOrden;
		parameters +="&codigosPrioridadNormaAgente="+cadIdPrioridadNormaAgente;
		$.ajax({
			url:baseURL + "pages/prioridadNormaAgente/saveEdition", 
	        type: 'post',
	        async: false,
	        data: parameters,
	        success: function(data) {
	        	ocultaLoading();         	
	        	if(data.resultado=='0'){
	        		mensajeGrowl("success", global.confirm.edit); 
	        		mostrarBotones1();
	        		procesarGridNormaAgente(1);
	            } else {
	            	mensajeGrowl("error", data.mensaje);
	            }
	        },
	        error: errorAjax
	    });		
	}else{
		mensajeGrowl("warn", errorMensaje, "");
	}	
	activarSeleccion("#grid", true);
}

function editarPrioridadNA(){
	var rows= jQuery("#gridPrioridadNorma1").jqGrid('getRowData');
	if(rows.length!=null){
		mostrarBotones2();
		activarSeleccion("#gridPrioridadNorma1", true);
	} 
}

function cancelarModificar(){
	mostrarBotones1();
	activarSeleccion("#gridPrioridadNorma1", false);
	resetSeleccion("#gridPrioridadNorma1");
	actualizaGrilla();
}

function cancelarModificar2(){
	mostrarBotones1();
	activarSeleccion("#gridPrioridadNorma1", false);
	resetSeleccion("#gridPrioridadNorma1");
	//actualizaGrilla();
}


function actualizaGrilla(){
	$('#gridPrioridadNorma1').trigger("reloadGrid",[{
		current: true
	}]);
}

function resetSeleccion(selector){	
	var grid=$(selector);
    var ids = grid.getDataIDs();    
    seleccionarTodo();
    for (var i=0; i<ids.length; i++) {
        grid.jqGrid('setSelection',ids[i], false);
    }    
}

function activarModoEdicion(){	
	var grid=$("#gridPrioridadNorma1");
	var filasSeleccionadas=grid.jqGrid("getGridParam","selarrrow");//para seleccionar la fila de una grilla 
	if(filasSeleccionadas.length <= 0){
		mensajeGrowl("warn", "Debe seleccionar al menos un registro para poder editar.", "");
		activarSeleccion("#gridPrioridadNorma1", true);
	}else{
		mostrarBotones3();
		for( var i=0;i < filasSeleccionadas.length;i++){
			grid.jqGrid("editRow",filasSeleccionadas[i], null, function(){
				var fila=parseInt(filasSeleccionadas[i]);
				$(jQuery('#gridPrioridadNorma1').jqGrid("getInd", fila, true)).find("input[name='orden']").numeric(onlyNumericOptions);
				$(jQuery('#gridPrioridadNorma1').jqGrid("getInd", fila, true)).find("input[name='orden']").keyup(function(){ if($(jQuery('#gridPrioridadNorma1').jqGrid("getInd", fila, true)).find("input[name='orden']").val()==0) $(jQuery('#gridPrioridadNorma1').jqGrid("getInd", fila, true)).find("input[name='orden']").val(''); });
				$(jQuery('#gridPrioridadNorma1').jqGrid("getInd", fila, true)).find("input[name='orden']").attr('maxlength','6');
				$(jQuery('#gridPrioridadNorma1').jqGrid("getInd", fila, true)).find("input[name='orden']").css("text-align", "center");
			});
		}
		activarSeleccion("#gridPrioridadNorma1", false);
	}
}

function seleccionarTodo(){
	var grid=$("#gridPrioridadNorma1");
    grid.jqGrid('resetSelection');
    var ids = grid.getDataIDs();
    for (var i=0; i < ids.length; i++) {
        grid.jqGrid('setSelection',ids[i], true);
    }
}

function mostrarBotones1(){
	$("#botones3").hide();
	$("#botones2").hide();
	$("#botones1").show();
}

function mostrarBotones2(){	
	$("#botones3").hide();
	$("#botones2").show();
	$("#botones1").hide();
}

function mostrarBotones3(){
	$("#botones3").show();
	$("#botones2").hide();
	$("#botones1").hide();
}

function btnLimpiarForm(){
	mostrarBotones1();
    $('#formBusqueda').find('input, select').val('');    
    procesarGridNormaAgente(0);
    activarBotones();
}

function activarSeleccion(selector, flag){
	var grid=$(selector);
	if(flag){
		grid.jqGrid('setGridParam', { beforeSelectRow: null });
	}else{
		grid.jqGrid('setGridParam', { beforeSelectRow: function(rowid, e) { return false; } });
	}		
}

function abrirMantNormaAgente(tipo,idPrioridadNormaAgente,idActividad,idAgente){
    var title="CONSULTAR PRIORIDAD NORMA";
    if(tipo=='edit'){
        title="EDITAR PRIORIDAD NORMA";
    }else if(tipo=='new'){
        title="NUEVA PRIORIDAD NORMA";
    }    
    $.ajax({
        url:baseURL + "pages/prioridadNormaAgente/abrirMantPrioridadNormaAgente", 
        type:'get',
        async:false,
        data:{
            tipo:tipo,
            idPrioridadNormaAgente:idPrioridadNormaAgente,
            idActividad:idActividad,
            idAgente:idAgente            
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantPrioridadNorma").html(data);
            $("#dialogMantPrioridadNorma").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "800",
                position: ['center', 'top+30'],
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText: "Cerrar"
            });
        },
        error:errorAjax
    });
}

function procesarGridNormaAgente(flg_load){
    if(flg_load==undefined){flg_load=1;}
    
    $("#gridContenedorPrioridadNorma1").html("");
    var grid = $("<table>", {
        "id": "gridPrioridadNorma1"
    });
    var pager = $("<div>", {
        "id": "paginacionPrioridadNorma1"
    });
    $("#gridContenedorPrioridadNorma1").append(grid).append(pager);

    var nombres = ['id','idBaseLegal', 'Normas Legales','Orden'];
    var columnas = [
        {name: "idPrioridadNormaAgente",width: 50,sortable: false,align: "center",hidden:true},
        {name: "idBaseLegal.idBaseLegal",width: 50,sortable: false,align: "center",hidden:true},
        {name: "idBaseLegal.descripcionGeneralBaseLegal",width: 150,sortable: false,align: "left"}, 
        {name: "orden",width: 50,sortable: false,align: "center", editable: true}        
    ];       
    grid.jqGrid({
        url: baseURL + "pages/prioridadNormaAgente/findGridPrioridadNormaAgente",
        datatype: "json",
        postData: {
        	idAgente:$('#cmbAgente').val(),
        	flg_load:flg_load
        },
        multiselect: true,
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionPrioridadNorma1",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Normas Prioridad",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idPrioridadNormaAgente"
        },
        onSelectRow: function(rowid, status) {
            //grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {            	
            $('#linkEliminarPrioridadNormaAgente').attr('onClick', 'eliminarPrioridadNormaAgente("'+rowid+'")');                      
            if($('#divEnlaceTagEliminarPrioridadNormaAgente input').html()!=null){
                $('#contextMenuPrioridadNorma li a[value="EL-GRIDELIMINARPRIORIDADNORMA"]').html($('#divEnlaceTagEliminarPrioridadNormaAgente').html());
             } else {  
                $('#contextMenuPrioridadNorma li a[value="EL-GRIDELIMINARPRIORIDADNORMA"]').remove();
             }
            if($("#btnActivarEditarPrioridaNA").is(":visible")  || ( $('#divContextMenuPrioridadNorma1 input').html()==null && $('#divEnlaceTagEliminarPrioridadNormaAgente input').html()==null)){
            	$('#contextMenuPrioridadNorma').parent().css('opacity',0);
            }            
        },
        loadComplete: function(data) {
        	$('#contextMenuPrioridadNorma').parent().css('opacity',1);
            $('#contextMenuPrioridadNorma').parent().remove();
            $('#divContextMenuPrioridadNorma1').html("<ul id='contextMenuPrioridadNorma'>"            		
            		+"<li> <a value='EL-GRIDELIMINARPRIORIDADNORMA'></a></li>"                    
                    + "</ul>");
            $('#contextMenuPrioridadNorma').puicontextmenu({
                target: $('#gridContenedorPrioridadNorma1')
            });
        },
        onPaging: function() {
        	cancelarModificar2();
        }
    });
    activarSeleccion("#gridPrioridadNorma1", false);
}

function eliminarPrioridadNormaAgente(rowid){	
	confirm.open("¿Ud. est&aacute; seguro de eliminar este registro?","procEliminarPrioridadNormaAgente('"+rowid+"',callbackEliminaPrioridadNorma)");
}

function callbackEliminaPrioridadNorma(){
	procesarGridNormaAgente();
}

function procEliminarPrioridadNormaAgente(id, callback){
	$.ajax({
        url:baseURL + "pages/prioridadNormaAgente/eliminarPrioridadNorma",
        type:'post',
        async:false,
        data:{
            idPrioridadNorma:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.delete, "");
                callback();
            } else {
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function cargarAgente(){
	fill.clean('#cmbAgente');
	procesarGridNormaAgente(0);
	if($('#cmbActividad').val()!=''){
		$.ajax({
	        url:baseURL + "pages/actividadesController/listarActividad", 
	        type:'post',
	        async:false,
	        data:{
	        	idActividadPadre:$('#cmbActividad').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();	            
	            fill.combo(data.filas,'idActividad','nombre','#cmbAgente');
	        },
	        error:errorAjax
	    });
	}
}

