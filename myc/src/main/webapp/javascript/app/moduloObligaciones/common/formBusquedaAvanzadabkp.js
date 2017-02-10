var dialogBusquedaAvanzadaBaseLegal=(function(){
	var basesLegales=[];
    var idDialog = $('#idDialogBusquedaAvanzadaBaseLegal').val();
    var item;
    /**
     * @returns {undefined}
     * función inicializadora 
     */
    function constructor(){
        dialogBusquedaAvanzadaBaseLegal();
        $("#textAnoBusquedaAvanzadaBaseLegal").spinner({max:2014},{min:1930});
        $("#dateFechaEntradaVigenciaBusquedaAvanzadaBaseLegal").datepicker();
        $("#dateFechaPublicacionBusquedaAvanzadaBaseLegal").datepicker();
        $("#dateFechaEntradaVigenciaDetalleBusquedaAvanzadaBaseLegal").datepicker();
        $("#toggBusquedaAvanzadaBaseLegal").puipanel({
                toggleable: true,
                collapsed:true
        });
        $('#botoCerrarBusquedaAvanzadaBaseLegal').click(cerrarBusquedaAvanzada);
        /**
         * button.click(function)
         * function: inicializa input type=text Abre PopUp Arbol de Actividades
         */
        $('#txtActividadesBusquedaAvanzadaBaseLegal').click(abrirPopUpArbolActividades);
        /**
         * button.click(function)
         * function: inicializa input type=text Abre PopUp Arbol de Productos
         */
        $('#txtProductosBusquedaAvanzadaBaseLegal').click(abrirPopUpArbolProductos);
        $('#botoAsociarBusquedaAvanzadaBaseLegal').click(asignarBasesLegales);
        $('#botoBuscarBusquedaAvanzadaBaseLegal').click(function(){gridBusquedaAvanzadaBaseLegal();});
        $('#botoAsociarBaseLegalesObligacion').click(function(){
        	asignarBasesLegalesObligacion();
        });
        
    }
    /**
     * @returns {undefined}
     * $(container).html(data) : inserta 'data'
     */
    function abrirPopUpArbolActividades(){
        var URL = baseURL + "pages/baseLegal/common/busquedaAvanzada/arbolActividades";
        $.get(URL,function(data){
            $("#containerDialogArbolActividades").html(data);
        });
    }
    /**
     * @returns {undefined}
     * $(container).html(data) : inserta 'data'
     */
    function abrirPopUpArbolProductos(){
        var URL = baseURL + "pages/baseLegal/common/busquedaAvanzada/arbolProductos";
        $.get(URL,function(data){
            $("#containerDialogArbolProductos").html(data);
        });
        
    }
    /**
     * @returns {undefined}
     * .dialog('close')
     */
    function cerrarBusquedaAvanzada(){$("#"+idDialog).dialog('close');}
    /**
     * @returns {undefined}
     * .dialog(properties)
     */
    function dialogBusquedaAvanzadaBaseLegal(){
		dialog(idDialog, 'Busqueda Avanzada Base Legal', false, 'dialogBusquedaAvanzada');
		//$('#' + idDialog).dialog("option", "position", { my: "center bottom", at: "center center", of: window });
                $('#' + idDialog).dialog("option", "draggable", true);
		$('#' + idDialog).on("dialogclose", function(event, ui) {
			$(this).dialog("destroy");
			$(this).remove();
                        //remove elementos insertados en el html
                        $('#ContextMenuBusquedaAvanzadaBaseLegal').parent().remove();
//                        $('#ui-datepicker-div').remove();
                        $('#divOcultaContainerBusquedaAvanzada').hide();
                });
		$("#" + idDialog).dialog('open');
    }
    function asignarBasesLegalesObligacion() {

        var dataGrilla = $('#gridContenedorBusquedaAvanzadaBaseLegal').find('input:checked');
    	var NroAsignados=0;
        var NroNoAsignados=0;
        var basesLegales = new Array();
        var prueba = new Array();
        prueba[0]='1';
        prueba[1]='2';
        i = 0;
        var idBaseLegalConcordancia;
        dataGrilla.map(function() {
            i++;
            idBaseLegalConcordancia = $(this).val();
            codigoBaseLegalConcordancia = $(this).attr('id');
            descripcionBaseLegalConcordancia = $(this).attr('name');
            basesLegales[i] = idBaseLegalConcordancia;
            var longitud = codigoBaseLegalConcordancia.length;
            var cadenaCodigo = codigoBaseLegalConcordancia.substring(0, longitud - 4);

            var id = idBaseLegalConcordancia;
            var codigo = cadenaCodigo;
            var descripcion = descripcionBaseLegalConcordancia;

            addBasesLegalesGridOBligacion(id, codigo, descripcion);
        });

        if (basesLegales.length > 0) {

            $.ajax({
                url: baseURL + 'pages/baseLegal/common/busquedaAvanzada/asignarBasesLegales',
                dataType: 'json',
                type: 'post',
                async: false,
                data: {
                    basesLegales: basesLegales,
                    idObligacion: $('#idObligacion').val(),
                    rows: 0,
                    page: 1
                },
                success: function(data) {
                    if (data.resultado == 0) {
                        mensajeGrowl("success", "Se asigno correctamente", "");
                        datajson = data.filas;
                        nuevaObligacionNormativa.procesarGridAsociaBaseLegal();
                        NroAsignados++;
                    } else {
                        NroNoAsignados++;
                    }
                }
            });

            $("#" + idDialog).dialog('close');
        }
    }
    /**
     * funcion para asociar bases legales grid concordancia
     */
    function addBasesLegalesGridOBligacion(id,codigo,descripcion) {
    	if(validarCamposObligacion(id)){
	    	var idBaseLegal = id;
	        var codigoBaseLegal = codigo;
	        var descripcionGeneralBaseLegal = descripcion;
	        var idData = $("#gridAsociaBasesLegales").getRowData().length + 1;
	        var rowData = {
	               idBaseLegal : idBaseLegal,
	               codigoBaseLegal : codigoBaseLegal,
	               descripcionGeneralBaseLegal : descripcionGeneralBaseLegal,
	        };
	        $("#gridAsociaBasesLegales").addRowData(idData, rowData);    
    	}
     }
    /**
     * funcion para validar campos del grid
     */
    function validarCamposObligacion(id){
     var encontrado = false;
     var ids = $("#gridAsociaBasesLegales").jqGrid('getDataIDs');
     for (var i = 0; i < ids.length; i++){
         var rowId = ids[i];
         var rowData = $('#gridAsociaBasesLegales').jqGrid ('getRowData', rowId);
         if (rowData.idBaseLegal==id){
        	 mensajeGrowl("error", "Campo Repetido", "");
        	 encontrado = true;
        	 break;
         }
     }
     if (encontrado == true){
         return false;      
     }
     return true;
    }
    /**
     * 
     */
    function asignarBasesLegales() {

        var dataGrilla = $('#gridContenedorBusquedaAvanzadaBaseLegal').find('input:checked');
        var basesLegales = new Array();
        var prueba = new Array();
        prueba[0]='1';
        prueba[1]='2';
        i = 0;
        var idBaseLegalConcordancia;
        dataGrilla.map(function() {
            i++;
            idBaseLegalConcordancia = $(this).val();
            codigoBaseLegalConcordancia = $(this).attr('id');
            descripcionBaseLegalConcordancia = $(this).attr('name');
            basesLegales[i] = idBaseLegalConcordancia;
            var longitud = codigoBaseLegalConcordancia.length;
            var cadenaCodigo = codigoBaseLegalConcordancia.substring(0, longitud - 4);

            var id = idBaseLegalConcordancia;
            var codigo = cadenaCodigo;
            var descripcion = descripcionBaseLegalConcordancia;

            addBasesLegalesGrid(id, codigo, descripcion);
        });

        if (basesLegales.length > 0) {
        	$("#" + idDialog).dialog('close');
        }
    }
    /**
     * funcion para asociar bases legales grid concordancia
     */
    function addBasesLegalesGrid(id,codigo,descripcion) {
    	if(validarCampos(id)){
	    	var idBaseLegal = id;
	        var codigoBaseLegal = codigo;
	        var descripcionGeneralBaseLegal = descripcion;
	        var idData = $("#gridObligConcordancia").getRowData().length + 1;
	        var rowData = {
	               idBaseLegal : idBaseLegal,
	               codigoBaseLegal : codigoBaseLegal,
	               descripcionGeneralBaseLegal : descripcionGeneralBaseLegal,
	        };
	        $("#gridObligConcordancia").addRowData(idData, rowData);    
    	}
     }
    /**
     * funcion para validar campos del grid
     */
    function validarCampos(id){
     var encontrado = false;
     var ids = $("#gridObligConcordancia").jqGrid('getDataIDs');
     for (var i = 0; i < ids.length; i++){
         var rowId = ids[i];
         var rowData = $('#gridObligConcordancia').jqGrid ('getRowData', rowId);
         if (rowData.idBaseLegal==id){
        	 mensajeGrowl("error", "Campo Repetido", "");
        	 encontrado = true;
        	 break;
         }
     }
     if (encontrado == true){
         return false;      
     }
     return true;
 }

    /**
     * función creadora del grid
     */
    function gridBusquedaAvanzadaBaseLegal(varLista){
    	if(varLista==undefined){varLista=1;}
        var nombres = ['idBaseLegal','Código Base Legal','Descripción Base Legal',' ',''];
        var columnas = [{name:'idBaseLegal',index:'id', width:55,hidden:true}, 
            {name: "codigoBaseLegal",width: 100,sortable: false,align: "center"},
            {name: "descripcionGeneralBaseLegal",width: 800,sortable: false,align: "center"},
            {name: "check",width: 50,sortable: false,align: "center",formatter: "imgCheck"},
            {name: "revisado",width: 50,sortable: false,align: "center",hidden:true}];
            $("#gridContenedorBusquedaAvanzadaBaseLegal").html("");
        var grid = $("<table>", {"id": "gridBusqAvanzadaBaseLegal"});
        var pager = $("<div>", {"id": "paginacionBaseLegalAvanzada"});
        $("#gridContenedorBusquedaAvanzadaBaseLegal").append(grid).append(pager);
        grid.jqGrid({
            url: baseURL + "pages/baseLegal/common/busquedaAvanzada/listarBaseLegal",
            datatype: "json",
            postData: {descripcion:$('#txtaTituloBusquedaAvanzadaBaseLegal').val(),
    					varLista:varLista},
            hidegrid: false,
            rowNum: 1000,
            pager: "#paginacionBaseLegalAvanzada",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            height: "300px",
            viewrecords: true,
            caption: "Busqueda Avanzada Base Legal",
            width: "998px",
            jsonReader : {
                root : "filas", //la lista de registros a mostrar en el grid
                page : "pagina", //la pagina actual
                total : "total", //total de paginas
                records : "registros", //numero total de registros
                id:"idBaseLegal"
                
            },onSelectRow: function(rowid, status) {
                //grid.resetSelection();
//                var rowdata = grid.jqGrid('getRowData', rowid);
                
//                $('#'+trim(rowdata.codigoBaseLegal)+'chkA').click(function(){
//                	
//	                if($('#'+trim(rowdata.codigoBaseLegal)+'chkA').attr('checked')){
//	                	item="1";
//	                	basesLegales.push(rowdata.idBaseLegal);
//	                }else{item="0";
//		                var position=basesLegales.indexOf(rowdata.idBaseLegal);
//		                alert(position);
//		                basesLegales.splice(position,1);
//		                alert(basesLegales.toString());
//	                }
//	                
//	                var listado=basesLegales.toString();
//	                if(variable==1){
//	                	$('#listBasesLegalesConcordancia').val(listado);
//	                }else if(variable==0){
//	                	$('#recepciona').val(listado);
//	                }                    
//                });  
            },onRightClickRow: function(rowid, iRow, iCol, e) {
//                var row = grid.jqGrid('getRowData', rowid);
//                $('#linkSeleccionarBaseLegal').attr('onClick', 'seleccionarBaseLegal("'+rowid+'")');
            },
            loadComplete: function(data) {
//                $('#ContextMenuBusquedaAvanzadaBaseLegal').parent().remove();
//                $('#divContextMenuBusquedaAvanzadaBaseLegal').html("<ul id='ContextMenuBusquedaAvanzadaBaseLegal'>"
//                        + "<li> <a id='linkSeleccionarBaseLegal' data-icon='ui-icon-extlink' title='Seleccionar'>Seleccionar</a></li>"
//                        + "</ul>");
//                $('#ContextMenuBusquedaAvanzadaBaseLegal').puicontextmenu({
//                    target: $('#gridBusqAvanzadaBaseLegal').find('tr').not('.ui-subgrid,.ui-subgrid tr')
//                });
            }
        });
    }
    /**
     * formatter
     */
    jQuery.extend($.fn.fmatter, {
    imgCheck: function(cellvalue, options, rowdata) {
        return "<input type=\"checkbox\" id='" + trim(rowdata.codigoBaseLegal)+"chkA' value='"+rowdata.idBaseLegal+"' name='"+rowdata.descripcionGeneralBaseLegal+"' /> <label class='checkbox' for='" + trim(rowdata.codigoBaseLegal) + "chkA' ></label>";
    }
    });
    return{ gridBusquedaAvanzadaBaseLegal:gridBusquedaAvanzadaBaseLegal,constructor:constructor};
})
();
$(function() {
    dialogBusquedaAvanzadaBaseLegal.constructor();
});

