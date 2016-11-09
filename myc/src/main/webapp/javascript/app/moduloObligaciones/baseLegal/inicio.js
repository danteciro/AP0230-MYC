var flagBaseLegal;
var flagPadre;
//var nuevo;
var busquedaBaseLegal = (function() {
    /* Variables Globales en el Ambito "busquedaBaseLegal" */
    /* variables que se envian al controller para crear/verdetalle/eliminar/editar "NO":Crear Nueva Base Legal / "SI":Ver Detalle Base Legal */
    var codVerDetalle = "NO"; 
    var codEliminarBaseLegal;
    var CodigoEditarBaseLegal;
    
    var descripcion = {
            allowNumeric  : true,
            allowLatin    : true,
            allowUpper    : true,
            allowLower    : true,
            allowCaseless : true,
            allowOtherCharSets : false,
            allowSpace    : true,
            allow         : 'áéíóúÁÉÍÓÚÑñ.°'
        };
    
    var codigoBaseLegal = {
            allowNumeric  : true,
            allowLatin    : false,
            allowUpper    : false,
            allowLower    : false,
            allowCaseless : true,
            allowOtherCharSets : false,
            allowSpace    : false,
            allow    : 'NORM-'
    };
                                
    /**
     * @returns {undefined}
     * funcion inicializadora en el ámbito "busquedaBaseLegal"
     */
    function constructor() {
        /* agre jpiro 20150106 - ini */
        confirm.start();
        /* agre jpiro 20150106 - fin */
        /**
         * inicializa al cargar la página la funcion "procesarGridBaseLegal"
         */
    	objComponenteGestionObligacionInicio.btnBusqueda.click(function(){
    		procesarGridBaseLegalGet(1);
    		$('#txtIdNormaSeleccionada').val("");
    		$('#txtIdBaseSeleccionada').val("");
//    		$('#txtIdNormaSeleccionada').removeAttr('value');
//    		$('#txtIdBaseSeleccionada').removeAttr('value');
    		$('#divContGridBusqObli').css('display','none');
    		$('#divContGridBusqBaseLegal').css('display','block');
    	});
        /**
         * button.click(function)
         * abre pop up mantenimiento para crear nueva base legal
         */
        objComponenteGestionObligacionInicio.btnMantenimientoBaseLegal.click(function() {
            codVerDetalle = "NO";/* crear nueva Base Legal */
            //nuevo="Si";//Nueva Base Legal
            flagBaseLegal="nuevo";
            abrirMantenimientoBaseLegal(flagBaseLegal);
        });
        /**
         * button.click(function)
         * abre pop up busqueda avanzada
         */
        objComponenteGestionObligacionInicio.btnBusquedaAvanzada.click(function() {
            abrirBusquedaAvanzadaBaseLegal();
        });
        /**
         * button.click(function)
         * Redirect to "baseURL + 'pages/indice'"
         */
        objComponenteGestionObligacionInicio.btnRegresarMenu.click(function() { 
        
        window.location.href = baseURL + 'pages/principal/mantenimientoObligaciones'; });
        
        $('#txtDescBaseLegal').alphanum(charAllow);
        $('#txtCodigoBaseLegal').alphanum(codigoBaseLegal);
        $('#txtTituloBaseLegal').alphanum(charAllow);
        $('#btnLimpiarBaseLegal').click(function(){
        	limpiarBuscarBaseLegal();
        	procesarGridBaseLegal(0);
        	$('#txtIdNormaSeleccionada').val('');
        	$('#txtIdBaseSeleccionada').val('');        	
        });
    }
    /**
     * @returns {undefined}
     * $(container).html(data) : insert JSP "dlgBusquedaAvanzadaBaseLegal" 
     */
    function abrirBusquedaAvanzadaBaseLegal() {
        $.ajax({
            url:baseURL + "pages/baseLegal/abrirDialogBusquedaAvanzadaBaseLegal", 
            type:'get',
            data:{},
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                //objComponenteGestionObligacionInicio.divContainerBusquedaAvanzadaGestionObligacion.html(data);
                //$('#divContenedorBusquedaAvanzadaBaseLegal').css("display","none");
                //objComponenteGestionObligacionInicio.divOcultaContainerBusquedaAvanzada.css("display","block");
                objComponenteGestionObligacionInicio.divContainerBusquedaAvanzadaGestionObligacion.html(data);
                objComponenteGestionObligacionInicio.divContainerBusquedaAvanzadaGestionObligacion.dialog({
                    resizable: false,
                    draggable: true,
                    autoOpen: true,
                    height:"auto",
                    width: "auto",
                    modal: true,
                    closeText: "Cerrar"
                });
            },
            error:errorAjax
        });
//        var URL = baseURL + "pages/baseLegal/abrirDialogBusquedaAvanzadaBaseLegal";
//        $.get(URL, function(data) {
//            objComponenteGestionObligacionInicio.divContainerBusquedaAvanzadaGestionObligacion.html(data);
//            $('#divContenedorBusquedaAvanzadaBaseLegal').css("display","none");
//            objComponenteGestionObligacionInicio.divOcultaContainerBusquedaAvanzada.css("display","block");
//        });
    }
    /**
     * @returns {undefined}
     * $(container).html(data) : insert JSP "dlgMantenimientoBaseLegal" - Nuevo y Ver Detalle 
     */
    function abrirMantenimientoBaseLegal(flagBaseLegal) {
        var URL = baseURL + "pages/baseLegal/abrirDialogMantenimientoBaseLegal";
        if(flagBaseLegal=="nuevo"){
            $.get(URL, {flagBaseLegal:flagBaseLegal, idNormaSeleccionada:$('#txtIdNormaSeleccionada').val()}, function(data) {
                objComponenteGestionObligacionInicio.divContainerMantenimientoBaseLegal.html(data);
                /** muestra div contenedor mantenimiento **/
                $('#divOcultaContainerMantenimiento').css("display","block"); 
                validaNuevaBaseLegal.procesarGridObligConcordancia();
                validaNuevaBaseLegal.procesarGridOblig();
                $('#btnEliminarBaseLegal').css('display','none');                
                flagPadre = "nuevo";
                if(flagPadre == "nuevo"){
                	$('#cmbNormaLegal').attr('validate','[O]');
                }
                if($('#txtIdNormaSeleccionada').val()!=""){
                	$('#cmbNormaLegal').val($('#txtIdNormaSeleccionada').val());                
                    $('#cmbHideNormaLegal').val($('#txtIdNormaSeleccionada').val());
                	gestionBaseLegal.obtenerNormaPadre($('#txtIdNormaSeleccionada').val());
                	gestionBaseLegal.validaComportamientoRegistroBaseLegal();
                    gestionBaseLegal.validaArticuloBaseLegal();
                    $('#chkModificatoria').removeAttr('disabled');
            		$('#chkConcordancia').removeAttr('disabled');
            		$('#cmbTipAneBaseLegal').removeAttr('disabled');
            	    $('#cmbNorTecBaseLegal').removeAttr('disabled');
            		
                }
            });
        }
    }
    /**
     * 
     * @returns {undefined}
     * Elimina Base Legal
     */
    function getEliminarBaseLegal(id) {
        var URL = baseURL + "pages/mantenimiento/baseLegal/eliminaBaseLegal";
        $.get(URL,{idBaseLegal:id}, function(data) {
            if (data.resultado == 0) {
                mensajeGrowl("success", "Se elimino el registro correctamente", "");
                busquedaBaseLegal.procesarGridBaseLegal();
                gestionBaseLegal.cerrarMantenimientoBaseLegal();
                validaCerrar=1;
            }
        });
    }
    /**
     * @returns {undefined}
     * $(container).html(data) : insert JSP "dlgHistoricoBaseLegal" 
     */
    function abrirHistoricoBaseLegal() {
        var URL = baseURL + "pages/baseLegal/abrirDialogHistoricoBaseLegal";
        $.get(URL, function(data) {
            objComponenteGestionObligacionInicio.divContainerHistoricoBaseLegal.html(data);
            $('#historicoGeneralObligacionNormativa').css("display","none");
            validaNuevaBaseLegal.procesarGridOblig();
//          objComponenteGestionObligacionInicio.divOcultaContainerHistorico.css("display","block");
        });
    }
    /**
     * @returns {undefined}
     * $(container).html(data) : insert JSP "dlgHistoricoBaseLegal" 
     */
    function abrirHistoricoObligacion() {
        var URL = baseURL + "pages/baseLegal/abrirDialogHistoricoBaseLegal";
        $.get(URL, function(data) {
            objComponenteGestionObligacionInicio.divContainerHistoricoBaseLegal.html(data);
            $('#historicoGeneralBaseLegal').css("display","none");
        });
    }
    
    /**
     * 
     * @param {type} varLista
     * @param {type} data
     * @returns {busquedaBaseLegal._L3.procesarGridBaseLegal}
     */
    function procesarGridBaseLegal(varLista, data) {
        var divValidacion = $('#divMensajeValidacionBusqueda');
        var validacion = true;
        if(validacion){
            if(varLista==undefined){varLista=1;}
            if(data==undefined){
                data={
                	codigoBaseLegal:$('#txtCodigoBaseLegal').val(),
                    titulo:$('#txtTituloBaseLegal').val(),
                    descripcionNormaLegal:$('#txtDescBaseLegal').val(),
                    varLista:varLista,
                    opcion:1
//                    flgBusqAvanzada:'1'
                    };
            }

            $("#gridContenedorBasesLegales").html("");
            var grid = $("<table>", {"id": "gridBasesLegales"});
            var pager = $("<div>", {"id": "paginacionBasesLegales"});
            $("#gridContenedorBasesLegales").append(grid).append(pager);
            var nombres = ['ID', 'Código Base Legal', 'Descripción Base Legal','tieneAct','nombreArchivo','Descargar','flag'];

            var columnas = [
                {name: "idBaseLegal", width: 130, sortable: false, align: "center", hidden: true},
                {name: "codigoBaseLegal", width: 130, sortable: false, align: "center"},
                {name: "descripcionGeneralBaseLegal", width: 800, sortable: false, align: "left"},
                {name: "tieneAct", width: 30, sortable: false, hidden: true, align: "center"},
                {name: "nombreArchivo",width: 70,align: "center",hidden:true},
                {name: "rutaAlfresco",width: 70,align: "center",formatter: "descargarFileBaseLegal"},
                {name: "flagPadre",width: 70,align: "center",hidden:true},
                
            ];
            grid.jqGrid({
                url: baseURL + "pages/baseLegal/listarBaseLegalPadre",
                datatype: "json",
                postData: data,
                mtype: "POST",
                hidegrid: false,
                rowNum: global.rowNumPrinc,
                pager: "#paginacionBasesLegales",
                emptyrecords: "No se encontraron resultados",
                loadtext: "Cargando",
                colNames: nombres,
                colModel: columnas,
                height: "auto",
                viewrecords: true,
                caption: "Búsqueda Bases Legales",
                autowidth: true,
                jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros",id:"idBaseLegal"},
                onSelectRow: function(rowid, status) {
    //                grid.resetSelection();
                	$('#txtIdNormaSeleccionada').attr('value',rowid);
                },
                onRightClickRow: function(rowid, iRow, iCol, e) {
                	$('#linkVerBaseLegal,#linkObtenerBaseLegal,#linkVerObligacionBA,#linkEditarObligacionBA').css('display','none');
                	var row=$('#gridBasesLegales').getRowData(rowid); 
                    if(row.flagPadre=='P'){
                    	$('#linkVerBaseLegal').css('display','');
                    	$('#linkObtenerBaseLegal').css('display','');                    	
                    }else{
                    	$('#linkVerObligacionBA').css('display','');
                    	$('#linkEditarObligacionBA').css('display','');
                    }
                    $('#linkVerBaseLegal').attr('onClick', 'busquedaBaseLegal.verBaseLegal("' + rowid + '")');
                    $('#linkObtenerBaseLegal').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegal("' + rowid + '")');
                    $('#linkVerObligacionBA').attr('onClick', 'busquedaBaseLegal.verBaseLegalDetalle("' + rowid + '")');
                    $('#linkEditarObligacionBA').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegalDetalle("' + rowid +'")');

	                if($('#divEnlaceTagVerNormaLegal input').html()!=null){
	                    $('#contextMenuBasesLegales li a[value="CO-NORMALEGAL"]').html($('#divEnlaceTagVerNormaLegal').html());
	                   } else {
	                  	  $('#contextMenuBasesLegales li a[value="CO-NORMALEGAL"]').remove();
	                   }
	                
	                if($('#divEnlaceTagEditarNormaLegal input').html()!=null){
	                    $('#contextMenuBasesLegales li a[value="MO-NORMALEGAL"]').html($('#divEnlaceTagEditarNormaLegal').html());
	                   } else {
	                 	  $('#contextMenuBasesLegales li a[value="MO-NORMALEGAL"]').remove();
	                   }                    
                },
                loadComplete: function(data) {
                    $('#contextMenuBasesLegales').parent().remove();
                    $('#divContextMenuBasesLegales').html("<ul id='contextMenuBasesLegales'>"
                            + "<li> <a value='CO-NORMALEGAL'></a> </li>"
                            + "<li> <a value='MO-NORMALEGAL'></a></li>"                            
                            + "</ul>");
                    $('#contextMenuBasesLegales').puicontextmenu({target: $('#gridBasesLegales')});                
//                onRightClickRow: function(rowid, iRow, iCol, e) {
//                	$('#linkVerBaseLegal,#linkObtenerBaseLegal,#linkVerObligacionBA,#linkEditarObligacionBA').css('display','none');
//                	var row=$('#gridBasesLegales').getRowData(rowid); 
//                    if(row.flagPadre=='P'){
//                    	$('#linkVerBaseLegal').css('display','');
//                    	$('#linkObtenerBaseLegal').css('display','');                    	
//                    }else{
//                    	$('#linkVerObligacionBA').css('display','');
//                    	$('#linkEditarObligacionBA').css('display','');
//                    }
//                    $('#linkVerBaseLegal').attr('onClick', 'busquedaBaseLegal.verBaseLegal("' + rowid + '")');/*function: busquedaBaseLegal.verBaseLegal*/
//                    $('#linkObtenerBaseLegal').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegal("' + rowid + '")');/*function: busquedaBaseLegal.editarBaseLegal*/
//                    $('#linkVerObligacionBA').attr('onClick', 'busquedaBaseLegal.verBaseLegalDetalle("' + rowid + '")');/*function: busquedaBaseLegal.verBaseLegal*/
//                    $('#linkEditarObligacionBA').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegalDetalle("' + rowid +'")');
//                },
//                loadComplete: function(data) {
//                    $('#contextMenuBasesLegales').parent().remove();
//                    $('#divContextMenuBasesLegales').html("<ul id='contextMenuBasesLegales'>"
//                            + "<li> <a id='linkVerBaseLegal' data-icon='ui-icon-search' title='Ver Norma Legal'>Ver Norma Legal</a> </li>"
//                            //+ "<li> <a id='linkVerHistoricoBaseLegal' data-icon='ui-icon-note' title='Ver Histórico Base Legal'>Ver Histórico Base Legal</a></li>"
//                            + "<li> <a id='linkObtenerBaseLegal' data-icon='ui-icon-pencil' title='Editar Norma Legal'>Editar Norma Legal</a></li>"
//    //                        + "<li> <a id='linkEliminarBaseLegal' data-icon='ui-icon-trash' title='Eliminar Base Legal'>Eliminar Base Legal</a></li>"
//                            + "<li> <a id='linkVerObligacionBA' data-icon='ui-icon-search' title='Ver Base Legal'>Ver Base Legal</a> </li>"
//                            + "<li> <a id='linkEditarObligacionBA' data-icon='ui-icon-pencil' title='Editar Base Legal'>Editar Base Legal</a></li>"                            
//                            + "</ul>");
//                    $('#contextMenuBasesLegales').puicontextmenu({target: $('#gridBasesLegales')});
                    
                    var fila = $('#gridBasesLegales').jqGrid('getRowData');
                    for (var i = 0; i < fila.length; i++) {
                        origen = fila[i].flagPadre;
                        	$('#gridBasesLegales').find("td[aria-describedby='gridBasesLegales_codigoBaseLegal']").css("font-weight","bold");
                        	$('#gridBasesLegales').find("td[aria-describedby='gridBasesLegales_descripcionGeneralBaseLegal']").css("font-weight","bold");
                        	
                     }
                    
                },
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
                    "selectOnExpand": false},
                subGridRowExpanded: function(subgrid_id, row_id) {
                    var dataPadre = grid.getRowData(row_id);
                    var subgrid_table_id, pager_id;
                    subgrid_table_id = subgrid_id + "_t";
                    pager_id = "p_" + subgrid_table_id;
                    $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");//<div id='"+pager_id+"' class='scroll'></div>
                    jQuery("#" + subgrid_table_id).jqGrid({
                        url: baseURL + "pages/baseLegal/listarDetalleBaseLegalHijo",
                        postData: {row_id: dataPadre.idBaseLegal},
                        datatype: "json",
                        mtype: 'POST',
                        colNames: ['ID','Código Base Legal','','Descripción Base Legal',''],
                        colModel: [{name: "idBaseLegal", width: 130, sortable: false, align: "center", hidden: true},
                                   {name: "codigoBaseLegal", width: 130, sortable: false, align: "center"},
                                   {name: "correlativo", width: 50, sortable: false, align: "center"},
                                   {name: "descripcionGeneralBaseLegal", width: 800, sortable: false, align: "left"},
                                   {name: "flagPadre",width: 70,align: "center",hidden:true}],
                        rowNum: global.rowNum,
                        jsonReader: {
                            root: "filas", //la lista de registros a mostrar en el grid
                            page: "pagina", //la pagina actual
                            total: "total", //total de paginas
                            records: "registros", //numero total de registros
                            repeatitems: false,
                            id: "idBaseLegal"
                        },
                        pager: pager_id,
                        sortname: 'num',
                        sortorder: "asc",
                        height: '100%',
                        autowidth: true,
                        onSelectRow: function(row_id, status) {
                        	jQuery("#" + subgrid_table_id).resetSelection();
                        },
                        onRightClickRow: function(rowid, iRow, iCol, e) {
                        	var tabla = subgrid_table_id;
                            var row = jQuery("#" + subgrid_table_id).jqGrid('getRowData', rowid);
                            $('#txtIdBaseSeleccionada').attr('value',rowid);
                            $('#linkVerHistoricoObligacion').attr('onClick', 'busquedaBaseLegal.abrirHistoricoObligacion("' + rowid + '")');
                            $('#linkVerObligacion').attr('onClick', 'busquedaBaseLegal.verBaseLegalDetalle("' + rowid + '")');
                            $('#linkEditarObligacion').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegalDetalle("' + rowid +'")');
                            $('#linkEliminarObligacion').attr('onClick', 'busquedaBaseLegal.confirmEliminarObligacion("' + rowid + '")');
                            
                            if($('#divEnlaceTagVerBaseLegal input').html()!=null){
                                $('#contextMenuObligaciones li a[value="CO-BASELEGAL"]').html($('#divEnlaceTagVerBaseLegal').html());
                             } else {  
                                $('#contextMenuObligaciones li a[value="CO-BASELEGAL"]').remove();
                             }
                            
                            if($('#divEnlaceTagEditarBaseLegal input').html()!=null){
                                $('#contextMenuObligaciones li a[value="MO-BASELEGAL"]').html($('#divEnlaceTagEditarBaseLegal').html());
                             } else {  
                                $('#contextMenuObligaciones li a[value="MO-BASELEGAL"]').remove();
                             }
                        },
                        loadComplete: function(data) {
                            $('#contextMenuObligaciones').parent().remove();
                            $('#divContextMenuObligaciones').html("<ul id='contextMenuObligaciones'>"
                                    + "<li> <a value='CO-BASELEGAL'></a> </li>"
                                    + "<li> <a value='MO-BASELEGAL'></a></li>"
                                    + "</ul>");
                            $('#contextMenuObligaciones').puicontextmenu({
                                target: $('#gridBasesLegales .ui-subgrid')
                            });                        
//                        onRightClickRow: function(rowid, iRow, iCol, e) {
//                        	var tabla = subgrid_table_id;
//                            var row = jQuery("#" + subgrid_table_id).jqGrid('getRowData', rowid);
//                            $('#txtIdBaseSeleccionada').attr('value',rowid);
//                            $('#linkVerHistoricoObligacion').attr('onClick', 'busquedaBaseLegal.abrirHistoricoObligacion("' + rowid + '")');/*function: busquedaBaseLegal.historicoBaseLegal*/
//                            $('#linkVerObligacion').attr('onClick', 'busquedaBaseLegal.verBaseLegalDetalle("' + rowid + '")');/*function: busquedaBaseLegal.verBaseLegal*/
//                            $('#linkEditarObligacion').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegalDetalle("' + rowid +'")');/*function: busquedaBaseLegal.editarBaseLegal*/
//                            $('#linkEliminarObligacion').attr('onClick', 'busquedaBaseLegal.confirmEliminarObligacion("' + rowid + '")');/*function: busquedaBaseLegal.confirmEliminarBaseLegal*/
//                        },
//                        loadComplete: function(data) {
//                            $('#contextMenuObligaciones').parent().remove();
//                            $('#divContextMenuObligaciones').html("<ul id='contextMenuObligaciones'>"
//                                    + "<li> <a id='linkVerObligacion' data-icon='ui-icon-search' title='Ver Base Legal'>Ver Base Legal</a> </li>"
//                                    //+ "<li> <a id='linkVerHistoricoObligacion' data-icon='ui-icon-note' title='Historico Obligación'>Ver Histórico Obligación</a></li>"
//                                    + "<li> <a id='linkEditarObligacion' data-icon='ui-icon-pencil' title='Editar Base Legal'>Editar Base Legal</a></li>"
//                                    //+ "<li> <a id='linkEliminarObligacion' data-icon='ui-icon-trash' title='Eliminar Obligación'>Eliminar Obligación</a></li>"
//                                    + "</ul>");
//                            $('#contextMenuObligaciones').puicontextmenu({
//                                target: $('#gridBasesLegales .ui-subgrid')
//                            });
                        }
                    });
                }
            });
        }
        
    }
    
    function obtenerBaseLegal(rowid){
    	flagPadre = "padre";
        flagBaseLegal="editar";
        var row = $('#gridBasesLegales').jqGrid('getRowData', rowid);
        CodigoEditarBaseLegal=row.idBaseLegal;
        abrirMantenimientoGestionBaseLegal();
    }
    function obtenerBaseLegalDetalle(rowid,tabla){
    	flagPadre = "hijo";
        flagBaseLegal="editar";
        CodigoEditarBaseLegal=rowid;
        abrirMantenimientoGestionBaseLegal();
    }
    /**
     * 
     * @returns {undefined}
     */
    function abrirMantenimientoGestionBaseLegal(){
        var URL = baseURL + "pages/mantenimiento/baseLegal/obtenerBaseLegal";
        $.get(URL,{codigoEditarBaseLegal:CodigoEditarBaseLegal,flagBaseLegal:flagBaseLegal}, function(data) {
        	objComponenteGestionObligacionInicio.divContainerMantenimientoBaseLegal.html(data);
            objComponenteGestionObligacionInicio.divOcultaContainerGestionObligacion.css("display","block");
            prueba=CodigoEditarBaseLegal;
            if(flagBaseLegal=="editar"){
            	gestionBaseLegal.habilitarMantenimientoBaseLegal();
                validaNuevaBaseLegal.procesarGridOblig();
                validaNuevaBaseLegal.procesarGridObligConcordancia();
                gestionBaseLegal.verBaseLegalCompleta();
                gestionBaseLegal.modoVisualizacion = flagBaseLegal;
                if(flagPadre=="hijo"){
                	gestionBaseLegal.validaComportamientoRegistroBaseLegal();
                	$('#chkNormaLegalPadre').attr('disabled','disabled');
                	$('#cmbNormaLegal').attr('validate','[O]');
                	// Inicio MYC-7 Cambio de Alcance
                    nuevoBL.cmbTipoAnexoNormaLegal.removeAttr('disabled');
                	nuevoBL.cmbNumeroAnexo.removeAttr('disabled');
                	nuevoBL.cmbTipoNormaTecnica.removeAttr('disabled');     
                	if(nuevoBL.cmbTipoAnexoNormaLegal.val()!="-1"){
                		$('#dateFecVigenciaNormaAnexo').removeAttr('disabled');
                	}
                	$('#chkCrearObligacion').removeAttr('disabled');
                	gestionBaseLegal.concatenaDescripcionBaseLegal();
                	// Fin MYC-7 Cambio de Alcance
            	}else if(flagPadre=="padre"){
            		gestionBaseLegal.validaComportamientoRegistroBaseLegal();
            		$('#divBaseLegalPadre').css('display','inline-block');
            		$('#divDetalleBaseLegalHijo').css('display','none');
            		$('#chkNormaLegalPadre').attr('disabled','disabled');
            		$('#cmbNormaLegal').attr('disabled','disabled');
            		$('#btnEliminarBaseLegalPadre').css('display','inline-block');
            		$('#btnEliminarBaseLegal').css('display','none');
            		$('#divImgBaseLegal').css('display','inline-block');
            	}
            }else if(flagBaseLegal=="ver"){
            	nuevoBL.btnGuardarBaseLegal.css("display","none");//oculta boton guardar
            	validaNuevaBaseLegal.procesarGridOblig();
            	validaNuevaBaseLegal.procesarGridObligConcordancia();
            	gestionBaseLegal.verBaseLegalCompleta();
            	gestionBaseLegal.modoVisualizacion = flagBaseLegal;
            	if(flagPadre=="hijo"){
            		$('#chkNormaLegalPadre').attr('disabled','disabled');
            		$('#cmbNormaLegal').attr('disabled','disabled');
            	}else if(flagPadre=="padre"){
            		$('#divBaseLegalPadre').css('display','inline-block');
            		$('#divDetalleBaseLegalHijo').css('display','none');
            		
            		$('#chkNormaLegalPadre').attr('disabled','disabled');
            		$('#cmbNormaLegal').attr('disabled','disabled');
            		
            	}
            	
            }
        });
    }
    /*Rsis 14 - Inicio*/
    
    function eliminarIncumplimiento (rowid){
    	alert("aaaa");
    	confirm.start();
        confirm.open("¿Ud est&aacute; seguro de eliminar este requisito?","procEliminarIncumplimiento('"+rowid+"')");
        
    }
    
    function procEliminarIncumplimiento(id){
    	alert(""+id);
        $.ajax({
            url:baseURL + "pages/mantenimiento/baseLegal/eliminarIncumplimiento",
            	
            type:'post',
            async:false,
            data:{
            	idEscenearioIncumplimiento:id            	
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                if(data.resultado=="SUCCESS"){
                    mensajeGrowl("success", global.confirm.delete, "");
                    gridIncumplimiento();
                }else if(data.resultado=="RESTRICT"){
                    mensajeGrowl("warn", data.mensaje, "");
                }else{
                    mensajeGrowl("error", data.mensaje, "");
                }
            },
            error:errorAjax
        });
    }
    /*Rsis 14 - Inicio*/
    /**
     * @param {type} rowid
     * @returns {undefined}
     * function: alert "Confirm Delete"
     */
    function confirmEliminarBaseLegal(rowid) {
        confirm.start();
        confirm.open("¿Ud est&aacute; seguro de eliminar esta Base Legal?",
                "busquedaBaseLegal.eliminarBaseLegal('" + rowid + "')");/*function: busquedaBaseLegal.confirmEliminarBaseLegal*/
    }
    /**
     * @param {type} rowid
     * @returns {undefined}
     * function: "Delete Register"
     */
    function eliminarBaseLegal(rowid) {
        var row = $('#gridBasesLegales').jqGrid('getRowData', rowid);
        codEliminarBaseLegal=row.codigoBaseLegal;
        busquedaBaseLegal.getEliminarBaseLegal(rowid);
    }
    /**
     * @param {type} imgs
     * @returns {String}
     * function: formatter in jqGrid "<img />"
     */
    function img(imgs) {
        if (imgs === 1) {
            var detalle = "";
            detalle = "<img src=\"" + baseURL + "/images/stickers.png\" onclick=\"redirectPagina('/mgo/pages/baseLegal')\"  style=\"cursor: pointer;\" alt=\"detalle\" title=\"Detalle\" height=\"20\"  width=\"18\" />";
            return detalle;
        } else {
            detalle = "";
            return detalle;
        }
    }
    
    jQuery.extend($.fn.fmatter, {
        descargarFileBaseLegal: function(cellvalue, options, rowdata) {
            var nombre=rowdata.nombreArchivo;
            var sel = '';
            if (nombre != null && nombre != '' && nombre != undefined){       
            console.log(nombre);
              $("#txtNombreArchivo").val(nombre);
              sel = '<a class="link" href="'+baseURL + 'pages/documentoAdjunto/descargaArchivoAlfresco?aplicacionSpace=OBLIGACIONES&nombreArchivo='+nombre+'&rutaAlfresco='+rowdata.rutaAlfresco+'">'+
              '<img class="vam" width="17" height="18" src="'+baseURL+'images/stickers.png">'+
            '</a>';
            }
            return sel;
        }
    });
    /**
     * @param {type} rowid
     * @returns {undefined}
     * function: "Edit Register"
     */
    function verBaseLegal(rowid) {
    	flagPadre = "padre";
        flagBaseLegal="ver";
        var row = $('#gridBasesLegales').jqGrid('getRowData', rowid);
        CodigoEditarBaseLegal=row.idBaseLegal;
        abrirMantenimientoGestionBaseLegal();
    }
    function verBaseLegalDetalle(rowid) {
    	flagPadre = "hijo";
        flagBaseLegal="ver";
        CodigoEditarBaseLegal=rowid;
        abrirMantenimientoGestionBaseLegal();
    }
    /**
     * return: convierte a las funciones privadas en públicas
     */
    
    function limpiarBuscarBaseLegal(){
    	$('#formBaseLegal').find(':input').each(function(){
    	$(this).val('');
    	});
	}
    
    function procesarGridBusqAvanObligacion(varLista, data) {
        var divValidacion = $('#divMensajeValidacionBusqueda');
        var validacion = true;
        if(validacion){
            if(varLista==undefined){varLista=1;}
            if(data==undefined){

            }
            $("#gridContenedorBusqAvanObligaciones").html("");
            var grid = $("<table>", {"id": "gridBusqAvanObligaciones"});
            var pager = $("<div>", {"id": "paginacionBusqAvanObligaciones"});
            $("#gridContenedorBusqAvanObligaciones").append(grid).append(pager);
            var nombres = ['ID','ID Obligacion', 'Código Obligación', 'Descripción Obligación','nombreArchivo','Descargar','estado',''];

            var columnas = [
                {name: "idBaseLegal", width: 130, sortable: false, align: "center", hidden: true},
                {name: "idObligacion", width: 130, sortable: false, align: "center", hidden: true},
                {name: "codigoObligacion", width: 130, sortable: false, align: "center"},
                {name: "descripcionObligacion", width: 800, sortable: false, align: "left"},
                {name: "nombreArchivo",width: 70,align: "center",hidden:true},
                {name: "rutaAlfresco",width: 70,align: "center",formatter: "descargarFileObligacion",hidden:true},
                {name: "estadoObligacion",width: 70,align: "center",hidden:true},
                {name: "tieneAct", width: 30, sortable: false, hidden: true, align: "center"}
            ];
            grid.jqGrid({
                url: baseURL + "pages/baseLegal/listarBusqAvanObligacion",
                datatype: "json",
                postData: data,
                mtype: 'POST',
                hidegrid: false,
                rowNum: global.rowNumPrinc,
                pager: "#paginacionBusqAvanObligaciones",
                emptyrecords: "No se encontraron resultados",
                loadtext: "Cargando",
                colNames: nombres,
                colModel: columnas,
                height: "auto",
                viewrecords: true,
                caption: "Búsqueda Obligaciones",
                autowidth: true,
                jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros",id:"idObligacion"},
                onSelectRow: function(rowid, status) {
                },
                onRightClickRow: function(rowid, iRow, iCol, e) {
                	var row=$('#gridBasesLegales').getRowData(rowid); 
                    $('#linkVerBusqAvanObligacion').attr('onClick', 'busquedaBaseLegal.verBusqAvanObligacion("' + rowid + '")');
                    $('#linkEditarBusqAvanObligacion').attr('onClick', 'busquedaBaseLegal.obtenerBusqAvanObligacion("' + rowid + '")');
                },
                loadComplete: function(data) {
//                    $('#contextMenuBusqAvanObligaciones').parent().remove();
//                    $('#divContextMenuBusqAvanObligaciones').html("<ul id='contextMenuBusqAvanObligaciones'>"
//                            + "<li> <a id='linkVerBusqAvanObligacion' data-icon='ui-icon-search' title='Ver Obligación'>Ver Obligación</a> </li>"
//                            + "<li> <a id='linkEditarBusqAvanObligacion' data-icon='ui-icon-pencil' title='Editar Obligación'>Editar Obligación</a></li>"
//                            + "</ul>");
//                    $('#contextMenuBusqAvanObligaciones').puicontextmenu({target: $('#gridBusqAvanObligaciones')});
                   
                },
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
                    "selectOnExpand": false},
                subGridRowExpanded: function(subgrid_id, row_id) {
                    var dataPadre = grid.getRowData(row_id);
                    var subgrid_table_id, pager_id;
                    subgrid_table_id = subgrid_id + "_t";
                    pager_id = "p_" + subgrid_table_id;
                    $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");//<div id='"+pager_id+"' class='scroll'></div>
                    jQuery("#" + subgrid_table_id).jqGrid({
                        url: baseURL + "pages/baseLegal/listarDetalleBaseLegalByObligacion",
                        postData: {row_id: dataPadre.idObligacion},
                        datatype: "json",
                        mtype: 'POST',
                        colNames: ['ID','Código Base Legal','','Descripción Base Legal',''],
                        colModel: [{name: "idBaseLegal", width: 130, sortable: false, align: "center", hidden: true},
                                   {name: "codigoBaseLegal", width: 130, sortable: false, align: "center"},
                                   {name: "correlativo", width: 50, sortable: false, align: "center"},
                                   {name: "descripcionGeneralBaseLegal", width: 800, sortable: false, align: "left"},
                                   {name: "flagPadre",width: 70,align: "center",hidden:true}],
                        rowNum: global.rowNum,
                        jsonReader: {
                            root: "filas", //la lista de registros a mostrar en el grid
                            page: "pagina", //la pagina actual
                            total: "total", //total de paginas
                            records: "registros", //numero total de registros
                            repeatitems: false,
                            id: "idBaseLegal"
                        },
                        pager: pager_id,
                        sortname: 'num',
                        sortorder: "asc",
                        height: '100%',
                        autowidth: true,
                        onSelectRow: function(row_id, status) {
                        	jQuery("#" + subgrid_table_id).resetSelection();
                        },
                        onRightClickRow: function(rowid, iRow, iCol, e) {
                        	var tabla = subgrid_table_id;
                            var row = jQuery("#" + subgrid_table_id).jqGrid('getRowData', rowid);
                            $('#linkVerBaseLegalByObligacion').attr('onClick', 'busquedaBaseLegal.verBaseLegalDetalle("' + rowid + '")');/*function: busquedaBaseLegal.verBaseLegal*/
                            $('#linkEditarBaseLegalByObligacion').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegalDetalle("' + rowid +'")');/*function: busquedaBaseLegal.editarBaseLegal*/
                        },
                        loadComplete: function(data) {
                            $('#contextMenuBusqAvanBaseLegal').parent().remove();
                            $('#divContextMenuBusqAvanBaseLegal').html("<ul id='contextMenuBusqAvanBaseLegal'>"
                                    + "<li> <a id='linkVerBaseLegalByObligacion' data-icon='ui-icon-search' title='Ver Base Legal'>Ver Base Legal</a> </li>"
                                    + "<li> <a id='linkEditarBaseLegalByObligacion' data-icon='ui-icon-pencil' title='Editar Base Legal'>Editar Base Legal</a></li>"
                                    + "</ul>");
                            $('#contextMenuBusqAvanBaseLegal').puicontextmenu({
                                target: $('#gridBusqAvanObligaciones .ui-subgrid')
                            });
                        }
                    });
                }
            });
        }
        
    }
    
    
    function verBusqAvanObligacion(rowid) {
        flagBaseLegal="ver";
        CodigoEditarBaseLegal=rowid;
        mode=0;
        abrirMantenimientoGestionObligacion(rowid,mode);
    }
    
    
    function obtenerBusqAvanObligacion(rowid,tabla){
        flagBaseLegal="editar";
        CodigoEditarBaseLegal=rowid;
        mode=1;
        abrirMantenimientoGestionObligacion(rowid,mode);
    }
    
    function abrirMantenimientoGestionObligacion(rowid,mode){
        var URL = baseURL + "pages/mantenimiento/baseLegal/obtenerObligacion";
        $.get(URL,{codigoEditarBaseLegal:rowid,flagBaseLegal:flagBaseLegal}, function(data) {
        	objComponenteGestionObligacionInicio.divContainerMantenimientoBaseLegal.html(data);
            objComponenteGestionObligacionInicio.divOcultaContainerGestionObligacion.css("display","block");
            nuevaObligacionNormativa.consultarObligacion(rowid,mode);
            
        });
    }
    
    function procesarGridBaseLegalGet(varLista, data) {
        var divValidacion = $('#divMensajeValidacionBusqueda');
        var validacion = true;
        if(validacion){
            if(varLista==undefined){varLista=1;}
            if(data==undefined){
                data={
                	codigoBaseLegal:$('#txtCodigoBaseLegal').val(),
                    titulo:$('#txtTituloBaseLegal').val(),
                    descripcionNormaLegal:$('#txtDescBaseLegal').val(),
                    varLista:varLista,
                    opcion:1
//                    flgBusqAvanzada:'1'
                    };
            }

            $("#gridContenedorBasesLegales").html("");
            var grid = $("<table>", {"id": "gridBasesLegales"});
            var pager = $("<div>", {"id": "paginacionBasesLegales"});
            $("#gridContenedorBasesLegales").append(grid).append(pager);
            var nombres = ['ID', 'Código Base Legal', 'Descripción Base Legal','tieneAct','nombreArchivo','Descargar','flag'];

            var columnas = [
                {name: "idBaseLegal", width: 130, sortable: false, align: "center", hidden: true},
                {name: "codigoBaseLegal", width: 130, sortable: false, align: "center"},
                {name: "descripcionGeneralBaseLegal", width: 800, sortable: false, align: "left"},
                {name: "tieneAct", width: 30, sortable: false, hidden: true, align: "center"},
                {name: "nombreArchivo",width: 70,align: "center",hidden:true},
                {name: "rutaAlfresco",width: 70,align: "center",formatter: "descargarFileBaseLegal"},
                {name: "flagPadre",width: 70,align: "center",hidden:true},
                
            ];
            grid.jqGrid({
                url: baseURL + "pages/baseLegal/listarBaseLegalPadreGet",
                datatype: "json",
                postData: data,
                mtype:'POST',
                hidegrid: false,
                rowNum: global.rowNumPrinc,
                pager: "#paginacionBasesLegales",
                emptyrecords: "No se encontraron resultados",
                loadtext: "Cargando",
                colNames: nombres,
                colModel: columnas,
                height: "auto",
                viewrecords: true,
                caption: "Búsqueda Bases Legales",
                autowidth: true,
                jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros",id:"idBaseLegal"},
                onSelectRow: function(rowid, status) {
    //                grid.resetSelection();
                	$('#txtIdNormaSeleccionada').attr('value',rowid);
                },
                onRightClickRow: function(rowid, iRow, iCol, e) {
                	$('#linkVerBaseLegal,#linkObtenerBaseLegal,#linkVerObligacionBA,#linkEditarObligacionBA').css('display','none');
                	var row=$('#gridBasesLegales').getRowData(rowid); 
                    if(row.flagPadre=='P'){
                    	$('#linkVerBaseLegal').css('display','');
                    	$('#linkObtenerBaseLegal').css('display','');                    	
                    }else{
                    	$('#linkVerObligacionBA').css('display','');
                    	$('#linkEditarObligacionBA').css('display','');
                    }
                    $('#linkVerBaseLegal').attr('onClick', 'busquedaBaseLegal.verBaseLegal("' + rowid + '")');
                    $('#linkObtenerBaseLegal').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegal("' + rowid + '")');
                    $('#linkVerObligacionBA').attr('onClick', 'busquedaBaseLegal.verBaseLegalDetalle("' + rowid + '")');
                    $('#linkEditarObligacionBA').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegalDetalle("' + rowid +'")');
                    
	                if($('#divEnlaceTagVerNormaLegal input').html()!=null){
	                    $('#contextMenuBasesLegales li a[value="CO-NORMALEGAL"]').html($('#divEnlaceTagVerNormaLegal').html());
	                   } else {
	                  	  $('#contextMenuBasesLegales li a[value="CO-NORMALEGAL"]').remove();
	                   }
	                
	                if($('#divEnlaceTagEditarNormaLegal input').html()!=null){
	                    $('#contextMenuBasesLegales li a[value="MO-NORMALEGAL"]').html($('#divEnlaceTagEditarNormaLegal').html());
	                   } else {
	                 	  $('#contextMenuBasesLegales li a[value="MO-NORMALEGAL"]').remove();
	                   }
                },
                loadComplete: function(data) {
                    $('#contextMenuBasesLegales').parent().remove();
                    $('#divContextMenuBasesLegales').html("<ul id='contextMenuBasesLegales'>"
                            + "<li> <a value='CO-NORMALEGAL'></a> </li>"
                            + "<li> <a value='MO-NORMALEGAL'></a></li>"
                            + "</ul>");
                    $('#contextMenuBasesLegales').puicontextmenu({target: $('#gridBasesLegales')});
//                onRightClickRow: function(rowid, iRow, iCol, e) {
//                	$('#linkVerBaseLegal,#linkObtenerBaseLegal,#linkVerObligacionBA,#linkEditarObligacionBA').css('display','none');
//                	var row=$('#gridBasesLegales').getRowData(rowid); 
//                    if(row.flagPadre=='P'){
//                    	$('#linkVerBaseLegal').css('display','');
//                    	$('#linkObtenerBaseLegal').css('display','');                    	
//                    }else{
//                    	$('#linkVerObligacionBA').css('display','');
//                    	$('#linkEditarObligacionBA').css('display','');
//                    }
//                    $('#linkVerBaseLegal').attr('onClick', 'busquedaBaseLegal.verBaseLegal("' + rowid + '")');/*function: busquedaBaseLegal.verBaseLegal*/
//                    $('#linkObtenerBaseLegal').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegal("' + rowid + '")');/*function: busquedaBaseLegal.editarBaseLegal*/
//                    $('#linkVerObligacionBA').attr('onClick', 'busquedaBaseLegal.verBaseLegalDetalle("' + rowid + '")');/*function: busquedaBaseLegal.verBaseLegal*/
//                    $('#linkEditarObligacionBA').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegalDetalle("' + rowid +'")');
//                },
//                loadComplete: function(data) {
//                    $('#contextMenuBasesLegales').parent().remove();
//                    $('#divContextMenuBasesLegales').html("<ul id='contextMenuBasesLegales'>"
//                            + "<li> <a id='linkVerBaseLegal' data-icon='ui-icon-search' title='Ver Norma Legal'>Ver Norma Legal</a> </li>"
//                            //+ "<li> <a id='linkVerHistoricoBaseLegal' data-icon='ui-icon-note' title='Ver Histórico Base Legal'>Ver Histórico Base Legal</a></li>"
//                            + "<li> <a id='linkObtenerBaseLegal' data-icon='ui-icon-pencil' title='Editar Norma Legal'>Editar Norma Legal</a></li>"
//    //                        + "<li> <a id='linkEliminarBaseLegal' data-icon='ui-icon-trash' title='Eliminar Base Legal'>Eliminar Base Legal</a></li>"
//                            + "<li> <a id='linkVerObligacionBA' data-icon='ui-icon-search' title='Ver Base Legal'>Ver Base Legal</a> </li>"
//                            + "<li> <a id='linkEditarObligacionBA' data-icon='ui-icon-pencil' title='Editar Base Legal'>Editar Base Legal</a></li>"                            
//                            + "</ul>");
//                    $('#contextMenuBasesLegales').puicontextmenu({target: $('#gridBasesLegales')});
                    
                    var fila = $('#gridBasesLegales').jqGrid('getRowData');
                    for (var i = 0; i < fila.length; i++) {
                        origen = fila[i].flagPadre;
                        	$('#gridBasesLegales').find("td[aria-describedby='gridBasesLegales_codigoBaseLegal']").css("font-weight","bold");
                        	$('#gridBasesLegales').find("td[aria-describedby='gridBasesLegales_descripcionGeneralBaseLegal']").css("font-weight","bold");
                        	
                     }
                    
                },
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
                    "selectOnExpand": false},
                subGridRowExpanded: function(subgrid_id, row_id) {
                    var dataPadre = grid.getRowData(row_id);
                    var subgrid_table_id, pager_id;
                    subgrid_table_id = subgrid_id + "_t";
                    pager_id = "p_" + subgrid_table_id;
                    $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");//<div id='"+pager_id+"' class='scroll'></div>
                    jQuery("#" + subgrid_table_id).jqGrid({
                        url: baseURL + "pages/baseLegal/listarDetalleBaseLegalHijo",
                        postData: {row_id: dataPadre.idBaseLegal},
                        datatype: "json",
                        mtype: 'POST',
                        colNames: ['ID','Código Base Legal','','Descripción Base Legal',''],
                        colModel: [{name: "idBaseLegal", width: 130, sortable: false, align: "center", hidden: true},
                                   {name: "codigoBaseLegal", width: 130, sortable: false, align: "center"},
                                   {name: "correlativo", width: 50, sortable: false, align: "center"},
                                   {name: "descripcionGeneralBaseLegal", width: 800, sortable: false, align: "left"},
                                   {name: "flagPadre",width: 70,align: "center",hidden:true}],
                        rowNum: global.rowNum,
                        jsonReader: {
                            root: "filas", //la lista de registros a mostrar en el grid
                            page: "pagina", //la pagina actual
                            total: "total", //total de paginas
                            records: "registros", //numero total de registros
                            repeatitems: false,
                            id: "idBaseLegal"
                        },
                        pager: pager_id,
                        sortname: 'num',
                        sortorder: "asc",
                        height: '100%',
                        autowidth: true,
                        onSelectRow: function(row_id, status) {
                        	jQuery("#" + subgrid_table_id).resetSelection();
                        },
                        onRightClickRow: function(rowid, iRow, iCol, e) {
                        	var tabla = subgrid_table_id;
                            var row = jQuery("#" + subgrid_table_id).jqGrid('getRowData', rowid);
                            $('#txtIdBaseSeleccionada').attr('value',rowid);
                            $('#linkVerHistoricoObligacion').attr('onClick', 'busquedaBaseLegal.abrirHistoricoObligacion("' + rowid + '")');
                            $('#linkVerObligacion').attr('onClick', 'busquedaBaseLegal.verBaseLegalDetalle("' + rowid + '")');
                            $('#linkEditarObligacion').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegalDetalle("' + rowid +'")');
                            $('#linkEliminarObligacion').attr('onClick', 'busquedaBaseLegal.confirmEliminarObligacion("' + rowid + '")');
                            
                            if($('#divEnlaceTagVerBaseLegal input').html()!=null){
                                $('#contextMenuObligaciones li a[value="CO-BASELEGAL"]').html($('#divEnlaceTagVerBaseLegal').html());
                             } else {  
                                $('#contextMenuObligaciones li a[value="CO-BASELEGAL"]').remove();
                             }
                            
                            if($('#divEnlaceTagEditarBaseLegal input').html()!=null){
                                $('#contextMenuObligaciones li a[value="MO-BASELEGAL"]').html($('#divEnlaceTagEditarBaseLegal').html());
                             } else {  
                                $('#contextMenuObligaciones li a[value="MO-BASELEGAL"]').remove();
                             }
                        },
                        loadComplete: function(data) {
                            $('#contextMenuObligaciones').parent().remove();
                            $('#divContextMenuObligaciones').html("<ul id='contextMenuObligaciones'>"
                                    + "<li> <a value='CO-BASELEGAL'></a> </li>"
                                    + "<li> <a value='MO-BASELEGAL'></a></li>"
                                    + "</ul>");
                            $('#contextMenuObligaciones').puicontextmenu({
                                target: $('#gridBasesLegales .ui-subgrid')
                            });
//                        onRightClickRow: function(rowid, iRow, iCol, e) {
//                        	var tabla = subgrid_table_id;
//                            var row = jQuery("#" + subgrid_table_id).jqGrid('getRowData', rowid);
//                            $('#txtIdBaseSeleccionada').attr('value',rowid);
//                            $('#linkVerHistoricoObligacion').attr('onClick', 'busquedaBaseLegal.abrirHistoricoObligacion("' + rowid + '")');/*function: busquedaBaseLegal.historicoBaseLegal*/
//                            $('#linkVerObligacion').attr('onClick', 'busquedaBaseLegal.verBaseLegalDetalle("' + rowid + '")');/*function: busquedaBaseLegal.verBaseLegal*/
//                            $('#linkEditarObligacion').attr('onClick', 'busquedaBaseLegal.obtenerBaseLegalDetalle("' + rowid +'")');/*function: busquedaBaseLegal.editarBaseLegal*/
//                            $('#linkEliminarObligacion').attr('onClick', 'busquedaBaseLegal.confirmEliminarObligacion("' + rowid + '")');/*function: busquedaBaseLegal.confirmEliminarBaseLegal*/
//                        },
//                        loadComplete: function(data) {
//                            $('#contextMenuObligaciones').parent().remove();
//                            $('#divContextMenuObligaciones').html("<ul id='contextMenuObligaciones'>"
//                                    + "<li> <a id='linkVerObligacion' data-icon='ui-icon-search' title='Ver Base Legal'>Ver Base Legal</a> </li>"
//                                    //+ "<li> <a id='linkVerHistoricoObligacion' data-icon='ui-icon-note' title='Historico Obligación'>Ver Histórico Obligación</a></li>"
//                                    + "<li> <a id='linkEditarObligacion' data-icon='ui-icon-pencil' title='Editar Base Legal'>Editar Base Legal</a></li>"
//                                    //+ "<li> <a id='linkEliminarObligacion' data-icon='ui-icon-trash' title='Eliminar Obligación'>Eliminar Obligación</a></li>"
//                                    + "</ul>");
//                            $('#contextMenuObligaciones').puicontextmenu({
//                                target: $('#gridBasesLegales .ui-subgrid')
//                            });
                        }
                    });
                }
            });
        }
        
    }
    
    return{
        getEliminarBaseLegal:getEliminarBaseLegal,
        abrirHistoricoObligacion: abrirHistoricoObligacion,
        abrirHistoricoBaseLegal: abrirHistoricoBaseLegal,
        verBaseLegal: verBaseLegal,
        procesarGridBaseLegal: procesarGridBaseLegal,
        confirmEliminarBaseLegal: confirmEliminarBaseLegal,
        eliminarBaseLegal: eliminarBaseLegal,
        abrirMantenimientoBaseLegal: abrirMantenimientoBaseLegal,
        obtenerBaseLegal:obtenerBaseLegal,
        obtenerBaseLegalDetalle:obtenerBaseLegalDetalle,
        verBaseLegalDetalle:verBaseLegalDetalle,
        constructor: constructor,
        procesarGridBusqAvanObligacion:procesarGridBusqAvanObligacion,
        obtenerBusqAvanObligacion:obtenerBusqAvanObligacion,
        verBusqAvanObligacion:verBusqAvanObligacion
    };
})();
/**
 * funcion autoejecutable
 */
$(function() {
    objComponenteGestionObligacionInicio = {
        txtCodigo                                       : $('#txtCodigoBaseLegal'),
        txtDescripcion                                  : $('#txtDescBaseLegal'),
        btnBusqueda                                     : $('#btnBuscarBaseLegal'),
        btnBusquedaAvanzada                             : $('#btnBusquedaAvanzadaBaseLegal'),
        btnMantenimientoBaseLegal                       : $('#btnMantenimientoBaseLegal'),
        gridGestionObligacion                           : $('#gridContenedorBasesLegales'),
        divMenuBaseLegal                                : $('#divContextMenuBasesLegales'),
        divMenuObligacion                               : $('#divContextMenuObligaciones'),
        divOcultaContainerBusquedaAvanzada              : $('#divOcultaContainerBusquedaAvanzada'),
        divContainerBusquedaAvanzadaGestionObligacion   : $('#containerDialogBusquedaAvanzadaBaseLegal'),
        divOcultaContainerGestionObligacion             : $('#divOcultaContainerMantenimiento'),
        divContainerMantenimientoBaseLegal              : $('#containerDialogMantenimientoBaseLegal'),
        divOcultaContainerHistorico                     : $('#divOcultaContainerHistorico'),
        divContainerHistoricoBaseLegal                  : $('#containerDialogHistoricoBaseLegal'),
        btnRegresarMenu                                 : $('#btnRegresar')
    };
});
//Cargar Unidad Divison
var uniDiv={
    //Busqueda_Unidad_Division
    cargarUnidadDivision : function (){
	//Captura_IdPersonal
	$.ajax({
            url:baseURL + "pages/baseLegal/findUnidadDivisionPersonal",
            type:'get',
            async:false,
            data:{  
                idPersonal:$('#idPersonalSesion').val()  
            },
            beforeSend:muestraLoading,
            success:function(data){
            	ocultaLoading();
                $('#divDivision').html(data.division);
                $('#divUnidad').html(data.unidad);
                $('#divActividades').html(data.listaActividades);
            },
            error:errorAjax
	});
}
};
$(function() {
    busquedaBaseLegal.constructor();
    uniDiv.cargarUnidadDivision();
});


