$(function(){
    boton.closeDialog();
    $('#chkBaseLegal').click(function(){
    	if($('#chkBaseLegal').is(':checked')){
    		$('#formBusqAvanBL').find('input[type=text],textarea,select,input[role=spinbutton]').each(function(){
            	$(this).val('');
            });
    	}
    });
    $('#chkObligaciones').click(function(){
    	if($('#chkObligaciones').is(':checked')){
    		$('#formBusqAvanBL').find('input[type=text],textarea,select,input[role=spinbutton]').each(function(){
            	$(this).val('');
            });
    	}
    });
    
    var numericOptions = {
        allowMinus   : false,
        allowThouSep : false
    };
    $('#txtAnoBusqAvanBL').numeric(numericOptions);  
    var fechaActual = new Date();
    var anio = fechaActual.getFullYear();
    $('#formBusqAvanBL').validarForm(); 
    $("#txtAnoBusqAvanBL").spinner({max:(anio+1)},{min:1990});
//    $("#txtFechaEntrVigeBusqAvanBL").datepicker();
    $("#txtFechaEntrVigeBusqAvanBL").datepicker(configuracionBasicaFechas());
//    nuevoBL.dateFechaVigenciaArtNormaLegal.datepicker(configuracionBasicaFechas());
                   
    $('#btnBuscarBusqAvanBL').click(function(){
        var validar = $('#formBusqAvanBL').validateAllForm("#divMensajeValidaBusqAvanBL");
        //////////////////////////////////
        var mensajeValidacion = "";
        var divValidacion = $('#divMensajeValidaBusqAvanBL');
        
        var fechaActual = new Date();
        var anioFinal = fechaActual.getFullYear();
        var anio = $('#txtAnoBusqAvanBL').val();
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
            gridBusquedaAvanzadaBaseLegal();
        }
    });
    
    $('#slcTipoAnexoBusqAvanBL').change(function(){
        $('#txtArticuloAnexoBusqAvanBL').val("");
        if($('#slcTipoAnexoBusqAvanBL').val()==''){
            $('#txtArticuloAnexoBusqAvanBL').attr('disabled','disabled');
        }else{
            $('#txtArticuloAnexoBusqAvanBL').removeAttr('disabled');
        }
    });
    
    $('#btnLimpiarBusqAvanBL').click(function(){
    	$('#formBusqAvanBL').find('input[type=text],textarea,select,input[role=spinbutton]').each(function(){
        	$(this).val('');
        });
    });
    
    //arboles
    initArbolActividadesBusqAvanBL();
    $('#txtRubrosBusqAvanBL').click(btnAgregarActividadBusqAvanBL);
    initArbolTemasBusqAvanBL();
    $('#txtTemasBusqAvanBL').click(btnAgregarTemasBusqAvanBL);
//    $("#txtAnoBusqAvanBL").bind("keydown", function (event) {
//                event.preventDefault();
//        });
    //Validacion de Formatos
    
    var codigoBaseLegal = {
            allowNumeric  : true,
            allowLatin    : false,
            allowUpper    : false,
            allowLower    : false,
            allowCaseless : true,
            allowOtherCharSets : false,
            allowSpace    : false,
            allow    : 'BL-NORM'
    };
    
    var codigoObligacion = {
            allowNumeric  : true,
            allowLatin    : false,
            allowUpper    : false,
            allowLower    : false,
            allowCaseless : true,
            allowOtherCharSets : false,
            allowSpace    : false,
            allow    : 'OB-'
    };
    
    var articulo = {
                allowNumeric  : true,
                allowLatin    : false,
                allowUpper    : false,
                allowLower    : true,
                allowCaseless : true,
                allowOtherCharSets : false,
                allowSpace    : false
    };
    var descripcion = {
            allowNumeric  : true,
            allowLatin    : true,
            allowUpper    : true,
            allowLower    : true,
            allowCaseless : true,
            allowOtherCharSets : false,
            allowSpace    : true,
            allow         : 'áéíóúÁÉÍÓÚÑñ.'
    };
    
    $('#txtCodBaseLegaBusqAvanBL').alphanum(codigoBaseLegal);
    $('#txtCodiObliNomaBusqAvanBL').alphanum(codigoObligacion);
    $('#txtArticuloBusqAvanBL').alphanum(articulo);
    $('#txtArticuloAnexoBusqAvanBL').alphanum(articulo);
    $('#txtDescrObliDetalleBusqAvanBL').alphanum(charAllow);
    
    //////////////////////////////////////////////
    $("#chkBaseLegal").prop("checked",true);
    $("#divBaseLegal1").show();
	$("#divBaseLegal2").show();
	$("#divBaseLegal3").show();
	$("#divObligaciones1").hide();
	$("#divObligaciones2").hide();
    $(".opcionBusquedaAvanzado").click(function(){
    	if(this.id == "chkBaseLegal" && $("#chkBaseLegal").prop("checked")){
    		$("#divBaseLegal1").show();
    		$("#divBaseLegal2").show();
    		$("#divBaseLegal2a").show();
    		$("#divBaseLegal3").show();
    		$("#divBaseLegal3a").show();
    		$("#divObligaciones1").hide();
    		$("#divObligaciones2").hide();
    	}else if(this.id == "chkObligaciones" && $("#chkObligaciones").prop("checked")){
    		$("#divBaseLegal1").hide();
    		$("#divBaseLegal2").hide();
    		$("#divBaseLegal2a").hide();
    		$("#divBaseLegal3").hide();
    		$("#divBaseLegal3a").hide();
    		$("#divObligaciones1").show();
    		$("#divObligaciones2").show();
    	}
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
    
function gridBusquedaAvanzadaBaseLegal(varLista){
    if(varLista==undefined){varLista=1;}
    var data={
        codigoBaseLegal:$('#txtCodBaseLegaBusqAvanBL').val(),
        fechaEntradaVigenciaNormaLegal:$('#txtFechaEntrVigeBusqAvanBL').val(),
        tipoNormaLegal:$('#slcTipoNormaLegaBusqAvanBL').val(),
        numeroNormaLegal:$('#txtNumeroBusqAvanBL').val(),
        anioNormaLegal:$('#txtAnoBusqAvanBL').val(),
        siglaNormaLegal:$('#slcSiglaBusqAvanBL').val(),
        articuloNormaLegal:$('#txtArticuloBusqAvanBL').val(),
        tipoAnexo:$('#slcTipoAnexoBusqAvanBL').val(),
        articuloAnexo:$('#txtArticuloAnexoBusqAvanBL').val(),
        codigoObligacion:$('#txtCodiObliNomaBusqAvanBL').val(),
        descObligacionDetalle:$('#txtDescrObliDetalleBusqAvanBL').val(),
        idCriticidadObligacion:$('#slcCritiObliBusqAvanBL').val(),
        idActividadesBusq:$('#idsRubrosBusqAvanBL').val(),
        idTemasBusq:$('#idsTemasBusqAvanBL').val(),
        idObligacionTipo:$('#slcObliTipoBusqAvanBL').val(),
        varLista:varLista,
        flgBusqAvanzada:'1',
        opcion:$('input[name=opcionBusquedaAvanzado]:checked').val()
    };
    if(data.opcion == 1){
    	busquedaBaseLegal.procesarGridBaseLegal(1,data);
    	$('#divContGridBusqObli').css('display','none');
		$('#divContGridBusqBaseLegal').css('display','');
    }else if(data.opcion == 0){
    	busquedaBaseLegal.procesarGridBusqAvanObligacion(1,data);
    	$('#divContGridBusqObli').css('display','');
		$('#divContGridBusqBaseLegal').css('display','none');
    }
    
    objComponenteGestionObligacionInicio.divContainerBusquedaAvanzadaGestionObligacion.dialog('close');
}

//ARBOL ACTIVIDADES
function btnAgregarActividadBusqAvanBL(){
    $('#popupArbolActiBusqAvanBL').dialog({
        width: 640,height:280,modal:true,
        close: function( event, ui ) {//se destruye popup para evitar conflicto con arbol y seleccionados
            $(this).dialog('destroy');
        }
    });
}
function initArbolActividadesBusqAvanBL(){
    var treeData=[];
    $.ajax({
        url: baseURL + 'pages/actividadesController/loadActividad',
        type: "post",
        async: false,
        data: {},
        success: function(data) {
            treeData = fxTree.build(data.filas);
        },
        error:errorAjax
    });
    $("#arbolActividadesBusqAvanBL").fancytree({
        checkbox: true,
        selectMode: 3,
        source:treeData,
        select: function(event, data) {
            var nodosSeleccionados = $.map(data.tree.getSelectedNodes(), function(node){
                if(!node.folder){
                    return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
                }
            });
            seleccionarActividadParaBusqAvan("["+nodosSeleccionados.join(",")+"]");
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
    
    $("#arbolActividadesBusqAvanBL").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
}
function seleccionarActividadParaBusqAvan(datax){
    var data=eval("("+datax+")");
    var ids=$.map(data,function(reg){return reg.id;}).join(',');
    var txts=$.map(data,function(reg){return reg.nombre;}).join(',');
    
    $('#idsRubrosBusqAvanBL').val(ids);
    $('#txtRubrosBusqAvanBL').val(txts);
    $('#txtRubrosBusqAvanBL').attr('title',txts);
}
//ARBOL TEMAS
function btnAgregarTemasBusqAvanBL(){
    $('#popupArbolTemasBusqAvanBL').dialog({
        width: 640,height:280,modal:true,
        close: function( event, ui ) {//se destruye popup para evitar conflicto con arbol y seleccionados
            $(this).dialog('destroy');
        }
    });
}
function initArbolTemasBusqAvanBL(){
    var treeData=[];
    $.ajax({
        //url: baseURL + 'pages/actividadesController/loadActividad',
        url: baseURL + 'pages/mantenimiento/baseLegal/obtenerTemaObligacion',
        type: "post",
        async: false,
        data: {},
        success: function(data) {
            treeData = fxTreeTema.build(data.filas);
        },
        error:errorAjax
    });
    $("#arbolTemasBusqAvanBL").fancytree({
        checkbox: true,
        selectMode: 3,
        source:treeData,
        select: function(event, data) {
            var nodosSeleccionados = $.map(data.tree.getSelectedNodes(), function(node){
                if(!node.folder){
                    return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
                }
            });
            seleccionarTemaParaBusqAvan("["+nodosSeleccionados.join(",")+"]");
        },
        keydown: function(event, data) {
            if( event.which === 32 ) {
                data.node.toggleSelected();
                return false;
            }
        },
        //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
        //initId: "treeData",
        cookieId: "fancytree-Cb2",
        idPrefix: "fancytree-Cb2-"
    });
    
    $("#arbolTemasBusqAvanBL").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
}
function seleccionarTemaParaBusqAvan(datax){
    var data=eval("("+datax+")");
    var ids=$.map(data,function(reg){return reg.id;}).join(',');
    var txts=$.map(data,function(reg){return reg.nombre;}).join(',');
    
    $('#idsTemasBusqAvanBL').val(ids);
    $('#txtTemasBusqAvanBL').val(txts);
    $('#txtTemasBusqAvanBL').attr('title',txts);
}