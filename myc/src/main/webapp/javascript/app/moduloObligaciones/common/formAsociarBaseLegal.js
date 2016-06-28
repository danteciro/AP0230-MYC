var basesLegales=[];
var item;

$(function(){
    boton.closeDialog();
    var numericOptions = {
        allowMinus   : false,
        allowThouSep : false
    };
    $('#txtAnoAsigBL').numeric(numericOptions);  
    var fechaActual = new Date();
    var anio = fechaActual.getFullYear();
    $('#formBuscarAsigBaseLegal').validarForm(); 
    $("#txtAnoAsigBL").spinner({max:(anio+1)},{min:1990});
//    $("#txtAnoAsigBL").bind("keydown", function (event) {
//        event.preventDefault();
//    });
//    $("#txtFechaEntrVigeAsigBL").datepicker();
    $("#txtFechaEntrVigeAsigBL").datepicker(configuracionBasicaFechas());
    $("#txtFechaEntrVigeAsigBL").bind("keydown", function (event) {
        event.preventDefault();
    });
    $('#botoAsociarBusquedaAvanzadaBaseLegal').click(function(){asignarBasesLegales();});
    $('#btnBuscarAsigBL').click(function(){
        var validar = true;
        //////////////////////////////////
        var mensajeValidacion = "";
        var divValidacion = $('#divMensajeValidaAsigBaseLegal');
        var fechaActual = new Date();
        var anioFinal = fechaActual.getFullYear();
        var anio = $('#txtAnoAsigBL').val();
        if(anio != "" && ( parseInt(anio) < 1990 || parseInt(anio) > (anioFinal+1) )){
            mensajeValidacion += "* Debe ingresar un año valido (mayor a 1990 y menor a "+(anioFinal+1)+") <br>";       
        }
        if(mensajeValidacion != ""){
            divValidacion.show();
            divValidacion.focus();
            divValidacion.html(mensajeValidacion);
            validar = false;
        }else{
            divValidacion.hide();
            divValidacion.html("");
        }
        //////////////////////////////////
        if(validar){
            gridAsigBaseLegal();
            $('.divBtnAsociar').css('display','block');
        }
    });
    $('#botoAsociarBaseLegalesObligacion').click(function(){asignarBasesLegalesObligacion();});
    $('#slcTipoAnexoAsigBL').change(function(){
        $('#txtArticuloAnexoAsigBL').val("");
        if($('#slcTipoAnexoAsigBL').val()==''){
            $('#txtArticuloAnexoAsigBL').attr('disabled','disabled');
        }else{
            $('#txtArticuloAnexoAsigBL').removeAttr('disabled');
        }
    });
    
    //Validacion de Formatos
    var articulo = {
                allowNumeric  : true,
                allowLatin    : false,
                allowUpper    : false,
                allowLower    : true,
                allowCaseless : true,
                allowOtherCharSets : false,
                allowSpace    : false
    };
    
    var codigoBaseLegal = {
            allowNumeric  : true,
            allowLatin    : false,
            allowUpper    : false,
            allowLower    : false,
            allowCaseless : true,
            allowOtherCharSets : false,
            allowSpace    : false,
            allow    : 'BL-'
    };
    
    $('#txtCodBaseLegaAsigBL').alphanum(codigoBaseLegal);
    $('#txtArticuloAsigBL').alphanum(articulo);
    $('#txtArticuloAnexoAsigBL').alphanum(articulo);
    
    $('#btnLimpiarAsigBL').click(function(){
    	$('#formBuscarAsigBaseLegal').find('input[type=text],textarea,select,input[role=spinbutton]').each(function(){
        	$(this).val('');
        });
    });
});

function configuracionBasicaFechas() {
   	 var ob = {
   	   changeMonth: false,
   	   changeYear: true,
   	   showOn: "focus",
   	   showOn: "button",
   	   buttonImage: ""+ baseURL+"images/cal.gif",
   	   buttonImageOnly: true,
   	   showAnim: "fade",
   	   dateFormat: "dd/mm/yy",
           yearRange: '1960:2050'
   	 };
   	 return ob;
    }

function asignarBasesLegalesObligacion() {

    var dataGrilla = $('#gridContenedorBuscarAsigBL').find('input:checked');
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
                page: 1,
                codTrazabilidad:$('#codTrazabilidad').val()
            },
            success: function(data) {
                if (data.resultado == 0) {
                    mensajeGrowl("success",data.mensaje);
                    datajson = data.filas;
                    nuevaObligacionNormativa.procesarGridAsociaBaseLegal();
                    NroAsignados++;
                } else if(data.resultado == 1) {
                	mensajeGrowl("error",data.mensaje);
                }
            }
        });
        $("#dialogAsociarBaseLegal").dialog("close");
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
    
function asignarBasesLegales() {

    var dataGrilla = $('#gridContenedorBuscarAsigBL').find('input:checked');
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
        $("#dialogAsociarBaseLegal").dialog("close");
        gestionBaseLegal.concatenaDescripcionBaseLegal();
    }
    if($(txtCodigoBaseLegalNuevo).val() != ""){
    	$("#btnEditarBaseLegal").click();
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

function gridAsigBaseLegal(varLista){
    if(varLista==undefined){varLista=1;}

    var nombres = ['idBaseLegal','Código Base Legal','Descripción Base Legal',' ',''];
    var columnas = [
        {name:'idBaseLegal',index:'id', width:55,hidden:true}, 
        {name: "codigoBaseLegal",width: 100,sortable: false,align: "center"},
        {name: "descripcionGeneralBaseLegal",width: 800,sortable: false,align: "left"},
        {name: "check",width: 50,sortable: false,align: "center",formatter: "imgCheck"},
        {name: "revisado",width: 50,sortable: false,align: "center",hidden:true}
    ];

    $("#gridContenedorBuscarAsigBL").html("");
    var grid = $("<table>", {"id": "gridBusqAvanzadaBaseLegal"});
    var pager = $("<div>", {"id": "paginacionBaseLegalAvanzada"});
    $("#gridContenedorBuscarAsigBL").append(grid).append(pager);

    grid.jqGrid({
        // 06-11-2015
        url: baseURL + "pages/baseLegal/common/busquedaAvanzada/listarBaseLegalToBaseLegal",
        datatype: "json",
        postData: {
            codigoBaseLegal:$('#txtCodBaseLegaAsigBL').val(),
            fechaEntradaVigenciaNormaLegal:$('#txtFechaEntrVigeAsigBL').val(),
            tipoNormaLegal:$('#slcTipoNormaLegaAsigBL').val(),
            numeroNormaLegal:$('#txtNumeroAsigBL').val(),
            anioNormaLegal:$('#txtAnoAsigBL').val(),
            siglaNormaLegal:$('#slcSiglaAsigBL').val(),
            articuloNormaLegal:$('#txtArticuloAsigBL').val(),
            tipoAnexo:$('#slcTipoAnexoAsigBL').val(),
            articuloAnexo:$('#txtArticuloAnexoAsigBL').val(),
            varLista:varLista,
            idsBaseLegal:$('#idsBaseLegal').val()+$('#txtidBaseLegalConcordancia').val(),
            flgBusqAvanzada:'1',
            opcion:'1'
        },
        hidegrid: false,
        mtype: 'POST',
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
            root : "filas",
            page : "pagina",
            total : "total",
            records : "registros",
            id:"idBaseLegal"
        }
    });
}
    
jQuery.extend($.fn.fmatter, {
    imgCheck: function(cellvalue, options, rowdata) {
        return "<input type=\"checkbox\" id='" + trim(rowdata.codigoBaseLegal)+"chkA' value='"+rowdata.idBaseLegal+"' name='"+rowdata.descripcionGeneralBaseLegal+"' /> <label class='checkbox' for='" + trim(rowdata.codigoBaseLegal) + "chkA' ></label>";
    }
});