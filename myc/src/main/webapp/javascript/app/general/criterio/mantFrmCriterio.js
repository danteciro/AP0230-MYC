var criterio = (function() {
	function constructor() {
            definirObtenerTipificaciones();
            $('#btnAsociarSancionEspecifica').puibutton({icon: 'ui-icon-transfer-e-w'});
            gridSancionEspecifica();
            $('#btnEditarCriterio').click(function(){editarCriterio();});
            $('#btnGuardarCriterio').click(function(){guardarCriterio();gridSancionEspecifica();});
            $('#cmbTipoCriterio').change(function(){cambiarTipoCriterio();});
            $('#btnNuevaSancionEspecifica').click(function(){validaCriterioCreado();});
            $('#btnCerrarCriterio').click(function(){
            	$('#containerDialogMantenimientoCriterio').dialog("close");
            });
            $('#txtMontoCriterio').alphanum(numericMonto);
	}
	
	function validaCriterioCreado(){
		if($('#idCriterio').val()!=null && $('#idCriterio').val()!="" ){
			abrirMantNuevaSancEspe("nuevo",$('#idCriterio').val());
		}
	}
	function confirmEliminarSancionEspecificaCriterio(rowid){
            confirm.open("¿Ud. est&aacute; seguro de eliminar?","criterio.procEliminarSancionEspecificaCriterio('"+rowid+"')");
        }
        function procEliminarSancionEspecificaCriterio(idDetalleCriterio){
            $.ajax({
                url:baseURL + "pages/criterio/eliminarDetalleCriterio",
                type:'post',
                async:false,
                data:{
                    idDetalleCriterio:idDetalleCriterio
                },
                beforeSend:muestraLoading,
                success:function(data){
                    ocultaLoading();
                    if(data.resultado=="SUCCESS"){
                        mensajeGrowl("success", global.confirm.delete, "");
                        criterio.gridSancionEspecifica();
                        procesarGridCriterio();
                    }else if(data.resultado=="ERROR"){
                        mensajeGrowl("error", data.mensaje, "Intente de nuevo");
                    }else{
                        mensajeGrowl("error", data.mensaje, "");
                    }
                },
                error:errorAjax
            });
        }
	function abrirMantNuevaSancEspe(tipo,idCriterio,rowid){
            var row = $('#gridSancionEspecCriterio').jqGrid('getRowData', rowid);
            $.ajax({
                url:baseURL + "pages/criterio/abrirDialogMantSanciones",
                type:'get',
                async:false,
                data:{
                    tipo:tipo,
                    idCriterio:idCriterio,
                    sancionEspecifica:row.sancionEspecifica,
                    tipoSancionEspecifica:row.tipoSancionEspecifica,
                    sancionMonetaria:row.sancionMonetaria,
                    concatIdTipoSancion:row.concatIdTipoSancion,
                    idDetalleCriterio:row.idDetalleCriterio
                },
                beforeSend:muestraLoading,
                success:function(data){
                    ocultaLoading();
                    $("#containerDialogMantenimientoSanciones").html(data);
                    $("#containerDialogMantenimientoSanciones").dialog({
                        resizable: false,
                        draggable: true,
                        autoOpen: true,
                        height:"auto",
                        width: "auto",
                        modal: true,
                        dialogClass: 'dialog',
                        title: "Mantenimiento Sanciones",
                        closeText: "Cerrar"
                    });

                },
                error:errorAjax
            });
	}
	function cambiarTipoCriterio(){
		if($('#cmbTipoCriterio option:selected').text()=="MONETARIA"){
			$('#divMontoCriterio').css('display','block');
			$('#txtMontoCriterio').val('');
			$('#txtTipifOblNor').val('');
			$('#txtIdTipificacion').val('');
		}else if($('#cmbTipoCriterio option:selected').text()=="ADMINISTRATIVA"){
			$('#divTipificacionCriterio').css('display','block');
			$('#txtTipifOblNor').val('');
			$('#txtIdTipificacion').val('');
			$('#divMontoCriterio').css('display','none');
			$('#txtMontoCriterio').val('');
		}else if($('#cmbTipoCriterio option:selected').text()=="AMBAS"){
			$('#divMontoCriterio').css('display','block');
			$('#txtTipifOblNor').val('');
			$('#txtIdTipificacion').val('');
			$('#divTipificacionCriterio').css('display','block');
			$('#txtMontoCriterio').val('');
		}else{
			$('#divMontoCriterio').css('display','none');
			$('#txtTipifOblNor').val('');
			$('#txtIdTipificacion').val('');
			$('#divTipificacionCriterio').css('display','block');
			$('#txtMontoCriterio').val('');
		}
	}
	function editarCriterioConfirmado(){
		$.ajax({
            url: baseURL + "pages/criterio/editarCriterio",
            type: 'post',
            async: false,
            data: {
                    idCriterio:$('#idCriterio').val(),
            	descripcion:$('#txtDescripcionCriterio').val(),
            	tipoCriterio:$('#cmbTipoCriterio').val(),
            	sancionMonetaria:$('#txtMontoCriterio').val(),
            	idTipificacion:$('#txtIdTipificacion').val(),
            	listaSanciones:$('#divEtapa').find('input[type=checkbox]').map(function(){if($(this).is(':checked')){	return $(this).attr('value').replace('idExpeSele','');} }).get().join(",")
            },
            beforeSend: muestraLoading,
            success: function(data) {
                ocultaLoading();
                if (data.resultado == "0") {
                        criterio.gridSancionEspecifica();
                    mensajeGrowl("success", data.mensaje, "");
                    procesarGridCriterio();
                } else {
                    mensajeGrowl("error", data.mensaje, "");
                }
            },
            error: errorAjax
        });
	}
	function editarCriterio(){
	    var validar = $('#formCriterio').validateAllForm("#divMensajeValidaFrmCriterio");
	    if(validar){	    	
	    	 confirm.start();
	       	  confirm.open("¿Esta seguro de actualizar el criterio?","criterio.editarCriterioConfirmado()");
	    	
	    }
	}
	function guardarCriterio(){
	    var validar = $('#formCriterio').validateAllForm("#divMensajeValidaFrmCriterio");
	    if(validar){	    	
	    	 confirm.start();
       	  confirm.open("¿Esta seguro de guardar el criterio?","criterio.guardarCriterioConfirmado()");

	    };
	}
	function guardarCriterioConfirmado(){
    	$.ajax({
            url: baseURL + "pages/criterio/registrarCriterio",
            type: 'post',
            async: false,
            data: {
            	descripcion:$('#txtDescripcionCriterio').val(),
            	tipoCriterio:$('#cmbTipoCriterio').val(),
            	sancionMonetaria:$('#txtMontoCriterio').val(),
            	idTipificacion:$('#txtIdTipificacion').val(),
            	listaSanciones:$('#divEtapa').find('input[type=checkbox]').map(function(){if($(this).is(':checked')){	return $(this).attr('value').replace('idExpeSele','');} }).get().join(",")
            },
            beforeSend: muestraLoading,
            success: function(data) {
                ocultaLoading();
                if (data.resultado == "0") {
                        criterio.gridSancionEspecifica();
                	$('#idCriterio').val(data.idCriterio);
                	$('#btnNuevaSancionEspecifica').removeAttr('disabled');
                	$('#btnNuevaSancionEspecifica').css('display','inline-block');
                    mensajeGrowl("success", data.mensaje, "");
                    $('#btnGuardarCriterio').css('display','none');
                    $('#btnEditarCriterio').css('display','inline-block');
                    procesarGridCriterio();
                } else {
                    mensajeGrowl("error", data.mensaje, "");
                }
            },
            error: errorAjax
        });
	}
	function cargarProcesosSancionatorios(idTipificacion) {
        var idTipificacion;
        $.getJSON(baseURL + "pages/criterio/obtenerProcesosCriterio", {idTipificacion: idTipificacion, ajax: 'true'}, function(data) {
            var html = '';
            var len = data.length;
            if (len > 0) {
                for (var i = 0; i < len; i++) {
                    html += '<div style="margin-right:30px;">';
                     html += '<input id="rdProceso' + data[i].idProceso + '" type="radio" name="proceso" value="' + data[i].idProceso + '" class="rdProceso" />';
                    html += '<label for="rdProceso' + data[i].idProceso + '" class="radio">' + data[i].descripcion + '</label>';
                    html += '</div>';
                }
                $('#divEtapa').html(html);
                if (len == 1) {
                    $('.rdProceso').attr("checked", true);
                }
                $("#dvEtapa").show();
                $("#dvTituloEtapa").show();
            } else {
                mensajeGrowl("error", "Error", "La tipificacion no tiene procesos sancionatorios asociados");
            }
        });
    }
	
    function definirObtenerTipificaciones() {
        $("#txtTipifOblNor").autocomplete({
	      appendTo: "#tabTip",
	      minLength: 1,
	      delimiter: ",",
	      source: function (request, response) {
          $.getJSON(baseURL + "pages/mantenimiento/baseLegal/findTipificaciones?codigo="+$("#txtTipifOblNor").val(), request, function(result) {
             response($.map(result, function(item) {
                  return {
                      // following property gets displayed in drop down
                      label: item.codTipificacion,
                      // following property gets entered in the textbox
                      value: item.codTipificacion,
                      // following property is added for our own use
                      id: item.idTipificacion
                  };
              	}));
          	 });
	      },
	    //define select handler
	      select : function(event, ui) {
//                  console.log('-- select --');
	    	  if (ui.item) {
	    		  event.preventDefault();
                          //console.log('-- ui.item.value = '+ui.item.value);
                          //console.log('-- ui.item.id = '+ui.item.id);
                          $("#txtTipifOblNor").val(ui.item.value);
                          $('#txtIdTipificacion').val(ui.item.id);
                          obtenerTipificacion(ui.item.id);
	            return false;
	          }
	      },
		    
	      change: function(event,ui){
//                console.log('-- change --');
                if(ui.item == null){
                    //console.log('-- change 1 --');
                    //console.log('-- change 1 = '+$("#txtTipifOblNor").val());
                    var URL = baseURL + "pages/mantenimiento/baseLegal/findTipificacionCodigoCriterio";
                    $.get( URL,{codigo:$("#txtTipifOblNor").val()},
                    function(data) {
//                        console.log('-- codTipificacion = '+data.codTipificacion);
//                        console.log('-- idTipificacion = '+data.idTipificacion);
                        if(data.idTipificacion !== null){
                            $('#txtIdTipificacion').val(data.idTipificacion);
//                            nuevoBL.txtDescripcionTipificacionOblig.val(data.descripcion);
//                            nuevoBL.txtSancionTipificacionObligacion.val(data.sancionMonetaria);
//                            nuevoBL.txtBaseLegalTipificacionObligacion.val(data.basesLegales);
                            var html='';
                            for(var x = 0; x < data.listaTipificacionSancion.length;x++){
                                var idTipoSancion = data.listaTipificacionSancion[x].tipoSancion.idTipoSancion;
                                var descripcionSancion = data.listaTipificacionSancion[x].tipoSancion.descripcion;
//                                console.info('-- IdTipoSancion --'+idTipoSancion);
//                                console.info('-- Descripcion --'+descripcionSancion);
                                
                                html += '<div style="margin-right:30px;">';
                                html += '<input id="rdProceso' + idTipoSancion + '" type="checkbox" name="proceso" value="' + idTipoSancion + '" class="checkbox" />';
                                html += '<label for="rdProceso' + idTipoSancion + '" class="checkbox">' + descripcionSancion + '</label>';
                                html += '</div>';
                            }
                            $('#divEtapa').html(html);
                            $("#divEtapa").css('display','inline-block');
                            $('#divProcesosCriterio').css('display','block');
                        }else{
                            $(".chkTipoSancion").attr('checked', false);
                            $('#txtIdTipificacion').val("");
                            $('#divProcesosCriterio').css('display','none');
//                            nuevoBL.txtDescripcionTipificacionOblig.val("");
//                            nuevoBL.txtSancionTipificacionObligacion.val("");
//                            nuevoBL.txtBaseLegalTipificacionObligacion.val("");
                        }
                    });
                }else{
                    //console.log('-- change 2    --');
                    $("#txtTipifOblNor").val(ui.item.value);
                    $('#txtIdTipificacion').val(ui.item.id);
                    obtenerTipificacion(ui.item.id);
                }
                
             }
	      
	    });
    }
    
    function obtenerTipificacion(idTipificacion) {
//        console.log('-- obtenerTipificacion idTipificacion = '+idTipificacion);
        $.ajax({
            url:baseURL + "pages/mantenimiento/baseLegal/obtenerTipificacionCriterio",
            type:'get',
            async:false,
            data:{
                idTipificacion: idTipificacion,
                ajax: 'true'
            },
            success:function(data){
                if(data.resultado == 0){
                    $('#txtIdTipificacion').val(data.tipificacion.idTipificacion);
                    var html='';
                    for(var x = 0; x < data.tipificacion.listaTipificacionSancion.length;x++){
                        var idTipoSancion = data.tipificacion.listaTipificacionSancion[x].tipoSancion.idTipoSancion;
                        var descripcionSancion = data.tipificacion.listaTipificacionSancion[x].tipoSancion.descripcion;   
//                        console.info('-- For lista tipificacion --'+idTipoSancion);
//                        console.info('-- For lista descripcion --'+descripcionSancion);
                        html += '<div style="float:left; margin-right:10px;">';
                        html += '<input id="rdProceso' + idTipoSancion + '" type="checkbox" name="proceso" value="' + idTipoSancion + '" class="checkbox" />';
                        html += '<label for="rdProceso' + idTipoSancion + '" class="checkbox">' + descripcionSancion + '</label>';
                        html += '</div>';
                    }
                    $('#divEtapa').html(html);
                    $("#divEtapa").css('display','inline-block');
                    $('#divProcesosCriterio').css('display','block');
                }else{
                    $('#divProcesosCriterio').css('display','none');
                    mensajeGrowl("error", "Error", "Contactarse con el Administrador");
                }
            },
            error:errorAjax
        });
//        var URL = baseURL + "pages/mantenimiento/baseLegal/obtenerTipificacionCriterio";
//        $.getJSON(URL, {
//            idTipificacion: idTipificacion,
//            ajax: 'true'
//        }, function(data) {
//            if(data.resultado == 0){
//                $('#txtIdTipificacion').val(data.tipificacion.idTipificacion);
//                var html='';
//                for(var x = 0; x < data.tipificacion.listaTipificacionSancion.length;x++){
//                	
//                	
//                    var idTipoSancion = data.tipificacion.listaTipificacionSancion[x].tipoSancion.idTipoSancion;
//                    var descripcionSancion = data.tipificacion.listaTipificacionSancion[x].tipoSancion.descripcion;   
//                    console.info('-- For lista tipificacion --'+idTipoSancion);
//                    console.info('-- For lista descripcion --'+descripcionSancion);
//                    html += '<div style="float:left; margin-right:10px;">';
//                    html += '<input id="rdProceso' + (x + 1) + '" type="checkbox" name="proceso" value="' + idTipoSancion + '" class="checkbox" />';
//                    html += '<label for="rdProceso' + (x + 1) + '" class="checkbox">' + descripcionSancion + '</label>';
//                    html += '</div>';
//                }
//                $('#divEtapa').html(html);
//                $("#divEtapa").css('display','inline-block');
//                $('#divProcesosCriterio').css('display','block');
//            }else{
//            	$('#divProcesosCriterio').css('display','none');
//                mensajeGrowl("error", "Error", "Contactarse con el Administrador");
//            }
//        });
    }
    
    function gridSancionEspecifica() {
        var colNames = ['ID DETALLE CRITERIO','DESCRIPCION SANCION ESPECIFICA','SANCION MONETARIA','tipoSancionEspecifica','TIPO', 'SANCIONES','concatIdTipoSancion'];
        var colModel = [
            {name: "idDetalleCriterio", hidden: true, width: 200, sortable: false, align: "center"},
            {name: "sancionEspecifica", width: 460, sortable: false, align: "center"},
            {name: "sancionMonetaria"},
            {name: "tipoSancionEspecifica",hidden:true},
            {name: "descTipoSancionEspecifica", width: 200, sortable: false, align: "center"},
            {name: "descripcionSancion", width: 200, sortable: false, align: "center",formatter:"fmtDescripSancion"},
            {name: "concatIdTipoSancion", formatter:"fmtConcatIdTipoSancion",hidden:true}
        ];
        
        $("#gridSancionEspecificaCriterio").html("");
        var url = baseURL + "pages/sancionEspecifica/listarSancionEspecificaCriterio";
        var postData = {idCriterio:$('#idCriterio').val()};
            
        var grid = $("<table>", {
            "id": "gridSancionEspecCriterio"
        });
        var pager = $("<div>", {
            "id": "paginacionSancionEspecificaCriterio"
        });
        $("#gridSancionEspecificaCriterio").append(grid).append(pager);
        grid.jqGrid({
            url:url,
            datatype: "json",
            postData: postData,
            hidegrid: false,
            rowNum: global.rowNum,
            pager: "#paginacionSancionEspecificaCriterio",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames : colNames,
            colModel : colModel,
            height: "auto",
            viewrecords: true,
            caption: "Listado de Sanciones Especificas",
            width: 860,
            jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros",id:"idDetalleCriterio"},
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                var row = grid.jqGrid('getRowData', rowid);
                $('#linkEliminarSancionEspecificoCriterio').attr('onClick', 'criterio.confirmEliminarSancionEspecificaCriterio("' + rowid + '")');
                $('#linkEditarSancionEspecificoCriterio').attr('onClick', 'criterio.abrirMantNuevaSancEspe("edit","' + $('#idCriterio').val() + '","' + rowid + '")');
            },
            loadComplete: function(data) {
                $('#contextMenuSancionEspecificaCriterio').parent().remove();
                $('#divContextMenuSancionEspecificaCriterio').html("<ul id='contextMenuSancionEspecificaCriterio'>"
                	+ "<li> <a id='linkEditarSancionEspecificoCriterio' data-icon='ui-icon-pencil' title=''>Editar</a></li>"
                        + "<li> <a id='linkEliminarSancionEspecificoCriterio' data-icon='ui-icon-trash' title=''>Eliminar</a></li>"
                	+ "</ul>");
                $('#contextMenuSancionEspecificaCriterio').puicontextmenu({
                	target: $('#gridSancionEspecCriterio')
                });
            }
        });
    }
	
	return{
		constructor : constructor,
		cargarProcesosSancionatorios:cargarProcesosSancionatorios,
		obtenerTipificacion:obtenerTipificacion,
		definirObtenerTipificaciones:definirObtenerTipificaciones,
                gridSancionEspecifica:gridSancionEspecifica,
                abrirMantNuevaSancEspe:abrirMantNuevaSancEspe,
                confirmEliminarSancionEspecificaCriterio:confirmEliminarSancionEspecificaCriterio,
                procEliminarSancionEspecificaCriterio:procEliminarSancionEspecificaCriterio,
                guardarCriterioConfirmado:guardarCriterioConfirmado,
                editarCriterioConfirmado:editarCriterioConfirmado
    };
	
})();
$(function() {
	criterio.constructor();
});

jQuery.extend($.fn.fmatter, {
    fmtConcatIdTipoSancion: function(cellvalue, options, rowdata) {
        var retorno="";
        $.each(rowdata.tipificacionSancion,function( index, value ){
            retorno+=value.tipoSancion.idTipoSancion;
            retorno+=",";
        });
        retorno=retorno.substring(0, (retorno.length-1));
        return retorno;
    }
});
jQuery.extend($.fn.fmatter, {
    fmtDescripSancion: function(cellvalue, options, rowdata) {
        var retorno="";
        var descTipoSancionEspecifica=rowdata.descTipoSancionEspecifica;
        var sancionMonetaria=rowdata.sancionMonetaria;
        var concatTipificacionSancion="";
        $.each(rowdata.tipificacionSancion,function( index, value ){
            concatTipificacionSancion+=value.tipoSancion.descripcion;
            concatTipificacionSancion+=", ";
        });
        concatTipificacionSancion=concatTipificacionSancion.substring(0, (concatTipificacionSancion.length-2));
        
        if(descTipoSancionEspecifica=="MONETARIA"){
            retorno=sancionMonetaria + " UIT ";
        }else if(descTipoSancionEspecifica=="ADMINISTRATIVA"){
            retorno=concatTipificacionSancion;
        }else if(descTipoSancionEspecifica=="AMBAS"){
            retorno+=sancionMonetaria+ " UIT ";
            if(concatTipificacionSancion!=""){
            	retorno+= ", "+concatTipificacionSancion;
            }
        }
        return retorno;
    }
});
