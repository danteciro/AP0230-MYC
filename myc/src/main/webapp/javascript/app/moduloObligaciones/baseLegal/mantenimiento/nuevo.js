var prueba;
var codObligacion;
var datajson = [];
var validaCerrar=0;
var modoVer = "ver";
var modoEdicion = "edicion";

var gestionBaseLegal = (function() {
    var flag;
    var modoVisualizacion;
    var idDialog = $('#idDialogMantenimientoBaseLegal').val();    
    function constructor() { 
    	inicializarFormularioBaseLegal();
    	// Inicio MYC-7 Cambio de Alcance
    	$('#cmbNumeroAnexo').change(function(){
    		concatenaDescripcionBaseLegal();
    	});
    	$("#cmbNorTecBaseLegal").change(function() {
    		var num = $('#cmbNorTecBaseLegal option:selected').text();
    		if (num == '--Seleccione--') {
    			nuevoBL.txtDescripcionNormaTecnica.css("display","none");
    			nuevoBL.txtDescripcionNormaTecnica.attr('disabled','disabled');
    			nuevoBL.txtDescripcionNormaTecnica.val('');
    			
    			
    			$("#btnAgregarNormaTecnica").css("display","none");
//    			concatenaDescripcionBaseLegal();
    		} else{
    			nuevoBL.txtDescripcionNormaTecnica.css("display","inline-block");
    			nuevoBL.txtDescripcionNormaTecnica.removeAttr('disabled');
    			
    			$("#btnAgregarNormaTecnica").css("display","inline-block");
//    			concatenaDescripcionBaseLegal();
    		}
    	});
    	
    	nuevoBL.txtIncisoUnoAnexoNormaLegal.keyup(function() {
            if (nuevoBL.txtIncisoUnoAnexoNormaLegal.val() != "") {
            	validaIncisoAnexoBaseLegalTrue(true);
            } else {
            	validaIncisoAnexoBaseLegalFalse(false);
            }
        });
    	// Fin MYC-7 Cambio de Alcance
    	$('#fldstTipificaciones').accordion({
    		heightStyle: "content"
    	});
    	$('#tipificacionEditarObligacion').removeAttr('height');
    	$('#criterioEditarObligacion').removeAttr('height');
    	/* OSINE_SFS-610 - INICIO */
    	$('#formFileOblNor').css('margin-top',30);
    	$('#formFileDesOblNor').css('margin-top',30);
    	$('#formFileInfraccion').css('margin-top',30);  
    	/* OSINE_SFS-610 - FIN */
    	$('#fldstMedidaSeguridad').accordion({
    		heightStyle: "content"
    	});
    	
    	$('#seguridadInfracion').removeAttr('height');
    	$('#seguridadEscenario').removeAttr('height');
//  05-11-2015
    	$('#txtBaseLegalCriterio').alphanum(charAllow);
    	$('#txtDescInfraccion').alphanum(charAllow);
    	$('#txtaTitBaseLegal').alphanum(charAllow);
    	//--
    	$('#cmbTipiCriterio').change(function(){
    			cargaInicial.obtenerTipificacion($('#cmbTipiCriterio').val());
    	});
    	
    	$('#btnGuardarObliTipiCriterio').click(function(){
    		var validar;
            validar = $('#formCriterio').validateAllForm('#divMensajeValidacionObl');
            if(validar){
            	validaNuevaBaseLegal.guardarCriterio();	
            }
    		
    	});
//    	
    	$('#btnBuscarCriterio').click(function() {validaNuevaBaseLegal.procesarGridCriterio();});
    	$('#divBaseLegalPadre').css('display','none');
    	$('#btnLimpiarCriterio').click(function(){
    		$('#txtDescCriterio').val("");
    	});
    	$('#btnSalirCriterio').click(function(){
    		$('#dialogCriterios').dialog("close");
    	});

    	$('#chkNormaLegalPadre').change(function(){
    		if($('#chkNormaLegalPadre').is(':checked')){
    			$('#cmbNormaLegal').attr('disabled','disabled');
    			$('#cmbNormaLegal').val('');
    			$('#divDetalleBaseLegalHijo').css('display','none');
    			$('#divBaseLegalPadre').css('display','inline-block');
    			$('#txtArtBaseLegal').attr('disabled','disabled');
    			$('#chkNormaLegalPadre').val('P');
    			$('#cmbNormaLegal').removeAttr('validate');
    		}else{
    			$('#cmbNormaLegal').removeAttr('disabled');
    			$('#divDetalleBaseLegalHijo').css('display','inline-block');
    			$('#divBaseLegalPadre').css('display','none');
    			$('#chkNormaLegalPadre').val('');
    			$('#cmbNormaLegal').attr('validate','[O]');
    		}
    		
    	});
    	
    	$('#btnEliminarBaseLegal').css('display','none');
    	$('#cmbNormaLegal').change(function(){
    		gestionBaseLegal.obtenerNormaPadre($('#cmbNormaLegal').val());
    		gestionBaseLegal.validaComportamientoRegistroBaseLegal();
    		gestionBaseLegal.validaArticuloBaseLegal();
    		$('#chkModificatoria').removeAttr('disabled');
    		$('#chkConcordancia').removeAttr('disabled');

    	});
        /* creado jpiro 20150106 - inicio */
        $("#formArchivoBL").ajaxForm({
            dataType : 'json',
            resetForm : true,
            success : function(data) {
                if (data != null && data.error != null) {
                    enviarDatosArchivoBL(data);
                }						
            }
        });
        $("#fileImagenBL").change(function(){      
            $("#txtNombreFileImagenBL").val(quitaSlashDir($("#fileImagenBL").val())); 
        });
        /* creado jpiro 20150106 - fin */
        
        /*Inicializa Models*/
    	
        models();
        dialogMantenimientoBaseLegal();
        /**/
        $('#fechaMotivoBaseLegal').datepicker();
        $('#btnConfirmacionEditarSiBaseLegal').click(guardaEditarRegistroBaseLegal);
        $('#btnConfirmacionEditarNoBaseLegal').click(function() {
            $('#dialogConfirmacionEditarRegistroBaseLegal').dialog('close');
        });
        var fechaActual = new Date();
        var anio = fechaActual.getFullYear();
        nuevoBL.btnGuardarNuevoObligacion.click(guardarNuevaObligacion);
        nuevoBL.divTabNormaLegal.tabs({active: 0});
        nuevoBL.txtAnioNormaLegal.spinner({max: (anio+1)}, {min: 1960});
        
        picker();//Funcion: inicializa Datepickers
        
        nuevoBL.btnCrearObligacion.click(mostrarCrearObligacion);
        nuevoBL.btnBuscarObligacion.click(concatenaDescripcionBaseLegal);
        nuevoBL.btnGenerarDescripcionNormaLegal.click(concatenaDescripcionBaseLegal);
        nuevoBL.btnAbrirPopUpImagen.click(abrirPopUpSubirArchivoBaseLegal);
        nuevoBL.btnGuardarImagen.click(guardarArchivoBaseLegal);
        nuevoBL.btnCerrarObligacion.click(cancelarRegistroObligacion);
        nuevoBL.btnGuardarObligacion.click(abrirPopUpConfirmacionRegistroObligacion);
        nuevoBL.btnConfirmaNoGuardarObligacion.click(cerrarPopUpConfirmaRegistroObligacion);
        nuevoBL.btnConfirmaSiGuardarObligacion.click(confirmaRegistroObligacion);
        nuevoBL.btnConfirmaNoNuevaObligacion.click(cerrarPopUpConfirmaRegistroNuevaObligacion);
        //nuevoBL.btnConfirmaSiNuevaObligacion.click(confirmaRegistroNuevaObligacion);
        nuevoBL.btnEditarBaseLegal.click(abrirPopUpConfirmacionEditarBaseLegal);
        nuevoBL.btnGuardarBaseLegal.click(abrirPopUpConfirmacionBaseLegal);
        nuevoBL.btnConfirmaSiGuardarBaseLegal.click(confirmaRegistroBaseLegal);
        nuevoBL.btnConfirmaNoGuardarBaseLegal.click(CerrarPopUpConfirmaRegistroBaseLegal);
        nuevoBL.btnConfirmaNoGuardarTipificacion.click(cerrarPopUpConfirmaNoTipificacion);
        nuevoBL.btnConfirmaSiGuardarTipificacion.click(ConfirmaSiTipificacion);
        nuevoBL.btnCerrar.click(function(){
            if(gestionBaseLegal.modoVisualizacion != modoVer){
                $('#dialogConfirmacionSalirBaseLegal').dialog('open');
            }else{
                cerrarMantenimientoBaseLegal();
            }
        });
        nuevoBL.btnCerrarMostrarCodigoBaseLegal.click(function(){
// 05-11-2015
        	$('#dialogMostrarCodigoBaseLegal').dialog('close');
            if($('#chkNormaLegalPadre').val()=="P"){
            	$("#" + idDialog).dialog('close');
            }else{
            	$("#" + idDialog).dialog('open');
            }        	
//        	
        });
        $('#btnConfirmacionSalirSiBaseLegal').click(function(){  
        	cerrarMantenimientoBaseLegal();});
        $('#btnConfirmacionSalirNoBaseLegal').click(function(){  
        	$('#dialogConfirmacionSalirBaseLegal').dialog('close');
        	});
        
        $('#btnConfirmacionOtraObligacionNormativa').click(confirmaRegistroNuevaObligacion);
        nuevoBL.chkConcordancia.change(function(){
        	if (nuevoBL.chkConcordancia.attr('checked')) {
        		$('#divDescripcionObligacionConcordancia').css("display","block");
        		}else{$('#divDescripcionObligacionConcordancia').css("display","none");}
        });

        /**
         * button.click(function)
         * function: init inputs type=text Abre PopUp Arbol de Actividades
         */
        nuevoBL.txtActividadNormaLegal.click(abrirPopUpArbolActividades);
        nuevoBL.txtProductoNormaLegal.click(abrirPopUpArbolProductos);
        /**
         * @returns {undefined}
         * function: init functions
         */
        
        $('#btnAsociaBaseLegalConcordancia').click(abrirPopUpBusquedaAvanzadaConcordancia);
        $('#btnNuevaObligacionNormativa').puibutton({icon: 'ui-icon-document'});
        $('#btnAsociarObligacionNormativa').puibutton({icon: 'ui-icon-document'});
        $('#btnAsociarObligacionNormativa').click(abrirPopUpBusquedaAvanzadaObligaciones);
        chkMostrarObligacion();
        
        nuevoBL.btnAgregaNuevaObligacionNormativa.click(function(){crearObligacionNormativa();validarGridObligacion();});
                
        /** Funcion de Comportamiento Base Legal**/
        $('#cmbTipBaseLegal').change(function(){
        	validaComportamientoRegistroBaseLegal();
        });
        
        nuevoBL.fileImagenObligacion.change(function(event){
            var img = new Image();
            img.src = URL.createObjectURL(this.files[0]);
            img.onload = function() {
                var validarArchivoObligacion = $('#divMensajeValidacionObligacionArchivo');
                if(this.width > 800 || this.height > 600){
                    validarArchivoObligacion.show();
                    validarArchivoObligacion.focus();
                    validarArchivoObligacion.html("* El tamaño de la imagen no corresponde con la permitida (800 x 600)");
                    $('#botoGuardarFile').css('display','none');
                    /* OSINE_SFS-610 - INICIO */
                    $('#formFileOblNor').css('margin-top',0);
                    /* OSINE_SFS-610 - FIN */
                }else{
                	$('#botoGuardarFile').css('display','inline-block');
                    validarArchivoObligacion.hide();
                    validarArchivoObligacion.html("");
                    /* OSINE_SFS-610 - INICIO */
                    $('#formFileOblNor').css('margin-top',30);
                    /* OSINE_SFS-610 - FIN */
                }
            };
        }); 
        
        $("#formFileOblNor").ajaxForm({
            dataType : 'json',
            async: false,
            resetForm : true,
            success : function(data) {
                
                if (data != null && data.error != null) {
                    enviarDatosArchivoObligacion(data);
                }						
            }
        });
        
        nuevoBL.fileImagenDescripcion.change(function(event){
            var img = new Image();
            img.src = URL.createObjectURL(this.files[0]);
            img.onload = function() {
                var validarArchivoDescripcion = $('#divMensajeValidacionArchivoDescripcion');
                if(this.width > 800 || this.height > 600){
                    validarArchivoDescripcion.show();
                    validarArchivoDescripcion.focus();
                    validarArchivoDescripcion.html("* El tamaño de la imagen no corresponde con la permitida (800 x 600)");
                    //Limpiando archivo adjunto
                    document.getElementById('formFileDesOblNor').reset();
                    /* OSINE_SFS-610 - INICIO */
                    $('#formFileDesOblNor').css('margin-top',0);
                    /* OSINE_SFS-610 - FIN */
                }else{
                    validarArchivoDescripcion.hide();
                    validarArchivoDescripcion.html("");
                    /* OSINE_SFS-610 - INICIO */
                    $('#formFileDesOblNor').css('margin-top',30);
                    /* OSINE_SFS-610 - FIN */                    
                }
            };
        }); 
        
        nuevoBL.fileInfraccion.change(function(event){
            var img = new Image();
            img.src = URL.createObjectURL(this.files[0]);
            img.onload = function() {
                var validarArchivoDescripcion = $('#divMensajeValidacionArchivoInfraccion');
                if(this.width > 800 || this.height > 600){
                    validarArchivoDescripcion.show();
                    validarArchivoDescripcion.focus();
                    validarArchivoDescripcion.html("* El tamaño de la imagen no corresponde con la permitida (800 x 600)");
                    $('#botoGuardarFileInfraccion').css('display','none');
                    $('#formFileInfraccion').css('margin-top',0);
                    //Limpiando archivo adjunto
                    //document.getElementById('formFileInfraccion').reset();                    
                }else{
                	$('#botoGuardarFileInfraccion').css('display','inline-block');
                    validarArchivoDescripcion.hide();
                    validarArchivoDescripcion.html("");
                    $('#formFileInfraccion').css('margin-top',30);
                }
            };
        }); 
                       
        $("#formFileDesOblNor").ajaxForm({
            dataType : 'json',
            async: false,
            resetForm : true,
            success : function(data) {
                if (data != null && data.error != null) {
                    enviarDatosArchivoDescripcion(data);
                }						
            }
        });
        /*Rsis 11 - Inicio*/
        $("#formFileInfraccion").ajaxForm({
            dataType : 'json',
            async: false,
            resetForm : true,
            success : function(data) {
                if (data != null && data.error != null) {
                    enviarDatosArchivoInfraccion(data);
                }						
            }
        });
        /*Rsis 11 - Fin*/
        generaDescripcionEvento();
        
        var articulo = {
        	    allowNumeric  : true,
        	    allowLatin    : false,
        	    allowUpper    : false,
        	    allowLower    : true,
        	    allowCaseless : true,
        	    allowOtherCharSets : false,
        	    allowSpace    : false
        };
        
        var numericOptions = {
        	   allowMinus   : false,
        	   allowThouSep : false
        };
        
        var alphaNumOptions = {
        	    allowNumeric  : true,
        	    allowLatin    : true,
        	    allowUpper    : true,
        	    allowLower    : true,
        	    allowCaseless : true,
        	    allowOtherCharSets : false,
        	    allowSpace    : true,
        	    allow    : 'Ñ,ñ',
//        	      forceUpper    : true, 
        	   };
        
        var inciso = {
        	   allowNumeric  : true,
        	   allowLatin    : true,
        	   allowUpper    : true,
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
// 05-11-2015        
        var SancionMonetariaCriterio = {
        		allowNumeric  : true,
         	   	allowLatin    : false,
         	   	allowUpper    : true,
         	   	allowLower    : true,
         	   	allowCaseless : true,
         	   	allowOtherCharSets : false,
         	   	allowSpace    : false,
         	    allow         : '.'
            };
                
    	var BaseLegalCriterio = {
            allowNumeric  : true,
            allowLatin    : true,
            allowUpper    : true,
            allowLower    : true,
            allowCaseless : true,
            allowOtherCharSets : false,
            allowSpace    : true,
            allow         : '°-/'
        }; 
//   
          $("#txtNumBaseLegal").numeric(numericOptions);
          $('#txtAnioBaseLegal').numeric(numericOptions);
          $('#txtDescObligacionNormativaActa').alphanum(charAllow);
          $('#txtArtBaseLegal').alphanum(articulo);
          $('#txtInc1BaseLegal').alphanum(inciso);
          $('#txtInc2BaseLegal').alphanum(inciso);
          $('#txtArtAneBaseLegal').alphanum(articulo);
          $('#txtInc3BaseLegal').alphanum(inciso);
          $('#txtInc4BaseLegal').alphanum(inciso);
// 05-11-2015          
          $('#txtIncumplimientoCriterio').alphanum(charAllow);
          $('#txtSancionMonetariaCriterio').alphanum(SancionMonetariaCriterio);
//          
          /////// Cambiar
          $('#tabNewBaseLegal').tabs('disable',1);//desabilitar tab obligacion
//          
          $('#btnEliminarBaseLegalPadre').click(function(){
        	  var idBaseLegal=$('#txtidBaseLegal').val();
        	  $.ajax({
                  url:baseURL + "pages/baseLegal/consultaBaseLegalHijo", 
                  type:'get',
                  data:{idBaseLegal:idBaseLegal},
                  beforeSend:muestraLoading,
                  success:function(data){
                      ocultaLoading();
                      if(data.listado!=null){
                    	  confirm.start();
                    	  confirm.open("No se puede eliminar La Norma Legal seleccionada, existen Bases Legales dependientes","");
                      }else{
                    	  confirm.start();
                    	  confirm.open("¿Esta seguro de eliminar la Norma Legal Padre?","gestionBaseLegal.eliminarBaseLegal('" + idBaseLegal + "')");
                      }
                      
                  },
                  error:errorAjax
              });
          });
          $("#btnEliminarBaseLegal").click(function(){
        	  
        	  var idBaseLegal=$('#txtidBaseLegal').val();
        	  gestionBaseLegal.confirmEliminarBaseLegal(idBaseLegal);

        });
    }
    
    function obtenerNormaPadre(idBaseLegalPadre){
		$.ajax({
            url:baseURL + "pages/mantenimiento/baseLegal/obtenerBaseLegalPadre", 
            type:'get',
            data:{idBaseLegalPadre:idBaseLegalPadre},
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                if(data!=null){
                	$('#cmbHideTipoBaseLegal').val(data.baseLegal.idBaseLegal);
                    $('#cmbTipBaseLegal').val(data.baseLegal.tipoNormaLegal);
                    $('#txtNumBaseLegal').val(data.baseLegal.numeroNormaLegal);
                    $('#txtAnioBaseLegal').val(data.baseLegal.anioNormaLegal);
                    $('#cmbHideSiglaBaseLegal').val(data.baseLegal.siglaNormaLegal);
                    $('#cmbSigBaseLegal').val(data.baseLegal.siglaNormaLegal);
                    $('#dateFecVigencia').val(data.fechaVigencia);
                    $('#dateFecPublicacion').val(data.fechaPublicacion);
                    $('#txtaTitBaseLegal').val(data.baseLegal.tituloNormaLegal);
                    $('#txtArtBaseLegal').removeAttr('disabled');
                    $('#txtNumBaseLegal').removeAttr('disabled');
                    $('#txtAnioBaseLegal').removeAttr('disabled');
                    $('#cmbSigBaseLegal').removeAttr('disabled');
                    $('#dateFecVigencia').removeAttr('disabled');
                    $('#dateFecPublicacion').removeAttr('disabled');
                    $('#txtaTitBaseLegal').removeAttr('disabled');
                    $('#dateFecVigenciaNorma').datepicker('option','minDate',data.fechaVigencia).trigger('change');
                	$('#dateFecVigenciaNormaAnexo').datepicker('option','minDate',data.fechaVigencia).trigger('change');
                }else{
                	$('#cmbHideTipoBaseLegal').val('');
                	$('#cmbTipBaseLegal').val('');
                    $('#txtNumBaseLegal').val('');
                    $('#txtAnioBaseLegal').val('');
                    $('#cmbHideSiglaBaseLegal').val('');
                    $('#cmbSigBaseLegal').val('');
                    $('#dateFecVigencia').val('');
                    $('#dateFecPublicacion').val('');
                    $('#txtaTitBaseLegal').val('');
                    $('#txtArtBaseLegal').attr('disabled','disabled');
                }
                
            },
            error:errorAjax
        });
    }
    
    function confirmEliminarBaseLegal(rowid) {
        confirm.start();
//        var mensaje = "¿Ud est&aacute; seguro de eliminar esta Base Legal?";
        var mensaje = "Esta operaci&oacute;n es irreversible y no elimina las obligaciones relacionadas, ¿Est&aacute; seguro de eliminar la base legal que tiene obligaciones relacionadas?";
        confirm.open(mensaje,
                "gestionBaseLegal.eliminarBaseLegal('" + rowid + "')");/*function: busquedaBaseLegal.confirmEliminarBaseLegal*/
    }
    /**
     * @param {type} rowid
     * @returns {undefined}
     * function: "Delete Register"
     */
    function eliminarBaseLegal(rowid) {
        getEliminarBaseLegal(rowid);
    }
    
    function getEliminarBaseLegal(id) {
        var URL = baseURL + "pages/mantenimiento/baseLegal/eliminaBaseLegal";
        $.get(URL,{idBaseLegal:id}, function(data) {
            if (data.resultado == 0) {
                mensajeGrowl("success",data.mensaje);
                busquedaBaseLegal.procesarGridBaseLegal();
                validaCerrar=1;
                gestionBaseLegal.cerrarMantenimientoBaseLegal();
            }else{
            	mensajeGrowl("error",data.mensaje);
            }
        });
    }
    
    function verBaseLegalCompleta(){
    	
    	if(flagBaseLegal=="ver"){
    		
    		nuevoBL.txtArticuloNormaLegal.attr('disabled','disabled');
    		$('#divDescCodigoBaseLegal').css('display','inline-block');//Descripcion código base legal
    		$('#txtCodigoBaseLegalNuevo').css('display','block');//Text código base legal
// 05-11-2015    		
    		if(flagPadre=="hijo"){
    			$('#toggAsigna').css('display','inline-block'); 
    		}else{
    			$('#toggAsigna').css('display','none'); 
    		}
//    		
    		$('#btnEliminarBaseLegal').css('display','none');
    		nuevoBL.cmbTipoNormaLegal.attr('disabled','disabled');
	    	
	    	if(nuevoBL.chkObligacion.val()==1){
	    		nuevoBL.chkObligacion.attr('checked',true);
	    	}	    	
	    	if($('#chkNormaLegalPadre').val()=='P'){
	    		$('#chkNormaLegalPadre').attr('checked',true);
	    	}
	    	if(nuevoBL.chkModificatoria.val()==1){
	    		nuevoBL.chkModificatoria.attr('checked',true);
	    	}
	    	
	    	if(nuevoBL.chkConcordancia.val()==1){
	    		nuevoBL.chkConcordancia.attr('checked',true);
	    	}
	    	if(nuevoBL.chkConcordancia.attr('checked')){
	    		nuevoBL.divListadoBasesLegalesConcordancia.css("display","block");
	    	}
	    	if(nuevoBL.chkObligacion.attr('checked')){
	    		nuevoBL.divContenedorGridObligaciones.css("display","block");
	    	}

	    	if(nuevoBL.txtArticuloNormaLegal.val()!=''){
	    		nuevoBL.divNormaArticuloNormaLegal.css("display","block");
	    	}
	    	
	    	if($('#cmbHideTipoAnexoBaseLegal').val()!=-1 && $('#cmbHideTipoAnexoBaseLegal').val()!=''){
	    		nuevoBL.divAnexoNormaLegal.css("display","block");
            	$('#cmbNumeroAnexo').css("display","inline-block");
            	$('#lblNumeroAnexo').css("display","inline-block");
	    		
	    	} else{
	    		nuevoBL.divAnexoNormaLegal.css("display","none");
	    	}
	    	    	
	    	if($('#cmbHideNormaTecnicaBaseLegal').val()!=-1 && $('#cmbHideNormaTecnicaBaseLegal').val()!=''){
	    		nuevoBL.txtDescripcionNormaTecnica.css("display","inline-block");
	    	}else{
	    		nuevoBL.txtDescripcionNormaTecnica.css("display","none");
	    		$('#btnAgregarNormaTecnica').css("display","none");
	    	}
	    	
	    	if(nuevoBL.txtArticuloNormaLegal.val()!=''){
	    		var fecha=0;
	    		if($('#cmbHideTipoAnexoBaseLegal').val()!=-1 && $('#cmbHideTipoAnexoBaseLegal').val()!=''){
	    			nuevoBL.dateFechaVigenciaAnexoNormaLegal.val($('#txtFecNorma').val());
	    			fecha=1;
	    		}else{
	    			if(fecha==0){
		    			nuevoBL.dateFechaVigenciaArtNormaLegal.val($('#txtFecNorma').val());
		    		}
	    		}
	    		
	    	}
//	    	nuevoBL.dateFechaPublicacionNormaLegal.datepicker();
	    	$('#btnAsociarObligacionNormativa').css('display','none');
	    	$('#btnAsociaBaseLegalConcordancia').css('display','none');
	    	$('#btnNuevaObligacionNormativa').css('display','none');
	    	
    	}else if(flagBaseLegal=="editar"){
    		$('#divDescCodigoBaseLegal').css('display','inline-block');//Descripcion código base legal
    		$('#txtCodigoBaseLegalNuevo').css('display','block');//Text código base legal
// 05-11-2015
    		if(flagPadre=="hijo"){
    			$('#toggAsigna').css('display','inline-block'); 
    		}else{
    			$('#toggAsigna').css('display','none'); 
    		}
//    		
    		
    		$('#btnEliminarBaseLegal').css('display','block');
    		if(nuevoBL.txtNumeroNormaLegal.val()!=''){
    			nuevoBL.txtNumeroNormaLegal.removeAttr('disabled');
    			nuevoBL.txtAnioNormaLegal.spinner({disabled: false});
    			nuevoBL.cmbSiglaNormaLegal.removeAttr('disabled');
    			nuevoBL.dateFechaVigenciaNormaLegal.removeAttr('disabled');
    			nuevoBL.dateFechaPublicacionNormaLegal.removeAttr('disabled');
    			nuevoBL.txtTituloNormaLegal.removeAttr('disabled');
    			/* modificado jpiro 20150106 - inicio */
                        //$('#divImgBaseLegal').css("display","inline-block");
                        validaVerAdjuDocuBaseLegal();
                        /* modificado jpiro 20150106 - fin */	
                        validaNumeroBaseLegalTrue();
    			validaNumeroBaseLegal();
    		}
    		
    		if($('#chkNormaLegalPadre').val()=='P'){
	    		$('#chkNormaLegalPadre').attr('checked',true);
	    	}
    		
    		if(nuevoBL.txtArticuloNormaLegal.val()!=''){
        		nuevoBL.divNormaArticuloNormaLegal.css("display","block");
        		validaArticuloBaseLegalTrue();
        		validaArticuloBaseLegal();
        	}
        	
    		if(nuevoBL.txtIncisoUnoNormaLegal.val()!=''){
    			nuevoBL.txtIncisoDosNormaLegal.removeAttr('disabled');
    			validaIncisoArticuloBaseLegalTrue();
        	}
    		
        	if($('#cmbHideTipoAnexoBaseLegal').val()!=-1 && $('#cmbHideTipoAnexoBaseLegal').val()!=''){
        		nuevoBL.divAnexoNormaLegal.css("display","block");
        		nuevoBL.txtArticuloAnexoNormaLegal.removeAttr('disabled');
        		validaComboTipoAnexoBaseLegal();
            	$('#cmbNumeroAnexo').css("display","inline-block");
            	$('#lblNumeroAnexo').css("display","inline-block");
        		
        	} else{
	    		nuevoBL.divAnexoNormaLegal.css("display","none");
	    	}
        	
        	if(nuevoBL.txtArticuloAnexoNormaLegal.val()!=''){
        		nuevoBL.txtIncisoUnoAnexoNormaLegal.removeAttr('disabled');
        		validaArticuloAnexoBaseLegal();
        	}
        	    
        	if(nuevoBL.txtIncisoUnoAnexoNormaLegal.val()!=''){
        		nuevoBL.txtIncisoDosAnexoNormaLegal.removeAttr('disabled');
        		validaIncisoAnexoBaseLegal();
        	}
        	
        	if($('#cmbHideNormaTecnicaBaseLegal').val()!=-1 && $('#cmbHideNormaTecnicaBaseLegal').val()!=''){
        		nuevoBL.txtDescripcionNormaTecnica.css("display","inline-block");
        		nuevoBL.txtDescripcionNormaTecnica.removeAttr('disabled');
        		$('#btnAgregarNormaTecnica').css("display","inline-block");
        		validaComboTipoNormaTecnica();
        	}else{
	    		nuevoBL.txtDescripcionNormaTecnica.css("display","none");
	    		$('#btnAgregarNormaTecnica').css("display","none");
	    	}
        	
        	
        	if(nuevoBL.chkObligacion.val()==1){
        		nuevoBL.chkObligacion.attr('checked',true);
        		nuevoBL.chkObligacion.removeAttr('disabled');
        		concatenaDescripcionBaseLegal();
        	}
        	
        	if(nuevoBL.chkModificatoria.val()==1){
        		nuevoBL.chkModificatoria.attr('checked',true);
        		nuevoBL.chkModificatoria.removeAttr('disabled');
        		concatenaDescripcionBaseLegal();
        	}
        	
        	if(nuevoBL.chkConcordancia.val()==1){
        		nuevoBL.chkConcordancia.attr('checked',true);
        		nuevoBL.chkConcordancia.removeAttr('disabled');
        		concatenaDescripcionBaseLegal();
        	}
        	if(nuevoBL.chkConcordancia.attr('checked')){
        		nuevoBL.divListadoBasesLegalesConcordancia.css("display","block");
        	}
        	if(nuevoBL.chkObligacion.attr('checked')){
        		nuevoBL.divContenedorGridObligaciones.css("display","block");
        	}
        	
        	if(nuevoBL.txtArticuloNormaLegal.val()!=''){
	    		var fecha=0;
	    		if($('#cmbHideTipoAnexoBaseLegal').val()!=-1 && $('#cmbHideTipoAnexoBaseLegal').val()!=''){
	    			nuevoBL.dateFechaVigenciaAnexoNormaLegal.val($('#txtFecNorma').val());
	    			fecha=1;
	    		}else{
	    			if(fecha==0){
		    			nuevoBL.dateFechaVigenciaArtNormaLegal.val($('#txtFecNorma').val());
		    		}
	    		}
	    		
	    	}
        }
    }
    
    function editarBaseLegalCompleta(){
    	gestionBaseLegal.inicializarFormularioBaseLegal();
    }
    
    function picker(){

//    	nuevoBL.dateFechaPublicacionNormaLegal.datepicker(configuracionBasica(nuevoBL.dateFechaVigenciaNormaLegal,"minDate"));
    	nuevoBL.dateFechaPublicacionNormaLegal.datepicker(configuracionBasicaFechas());
	    nuevoBL.dateFechaPublicacionNormaLegal.keydown(function(event){
	   	  var key=event.keyCode || event.charCode;
	   	  if(key != 8 && key !== 46)
	   	   return false;
	   	 });
//    	nuevoBL.dateFechaVigenciaArtNormaLegal.datepicker(configuracionBasica(nuevoBL.dateFechaVigenciaNormaLegal,"maxDate"));
    	nuevoBL.dateFechaVigenciaArtNormaLegal.datepicker(configuracionBasicaFechas());
        nuevoBL.dateFechaVigenciaArtNormaLegal.keydown(function(event){
  	   	  var key=event.keyCode || event.charCode;
  	   	  if(key != 8 && key !== 46)
  	   	   return false;
  	   	 });
        
//        nuevoBL.dateFechaVigenciaAnexoNormaLegal.datepicker(configuracionBasica(nuevoBL.dateFechaVigenciaNormaLegal,"maxDate"));
        nuevoBL.dateFechaVigenciaAnexoNormaLegal.datepicker(configuracionBasicaFechas());
        nuevoBL.dateFechaVigenciaAnexoNormaLegal.keydown(function(event){
  	   	  var key=event.keyCode || event.charCode;
  	   	  if(key != 8 && key !== 46)
  	   	   return false;
  	   	 });
        
        
//	    var el=$("#dateFecPublicacion,#dateFecVigenciaNorma,#dateFecVigenciaNormaAnexo");
//    	nuevoBL.dateFechaVigenciaNormaLegal.datepicker(configuracionBasica(el,"maxDate"));
    	nuevoBL.dateFechaVigenciaNormaLegal.datepicker(configuracionBasicaFechaVigencia());
    	nuevoBL.dateFechaVigenciaNormaLegal.keydown(function(event){
    		var key=event.keyCode || event.charCode;
	   	  	if(key != 8 && key !== 46)
	   	  		return false;
    	});
    	$('#dateFecVigenciaNorma').datepicker('option','minDate',$('#dateFecVigencia').val()).trigger('change');
    	$('#dateFecVigenciaNormaAnexo').datepicker('option','minDate',$('#dateFecVigencia').val()).trigger('change');
    	console.info('ingreso');
    	
    	gestionBaseLegal.concatenaDescripcionBaseLegal();
    	console.info('paso concatenar');
   	}
    
    function configuracionBasicaFechaVigencia() {
   	 var ob = {
   	   changeMonth: false,
   	   changeYear: true,
   	   showOn: "focus",
   	   showOn: "button",
   	   buttonImage: ""+ baseURL+"images/cal.gif",
   	   buttonImageOnly: true,
   	   showAnim: "fade",
   	   dateFormat: "dd/mm/yy",
           yearRange: '1960:2050',
   	   onSelect: function(selectedDate){
   	   var fecha=$.datepicker.parseDate("dd/mm/yy",selectedDate);            
            nuevoBL.dateFechaVigenciaArtNormaLegal.datepicker("option","minDate",fecha);
//            nuevoBL.dateFechaVigenciaAnexoNormaLegal.datepicker("option","minDate",fecha);
       }
   	 };
   	 return ob;
    }
    
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
    
    function validarGridObligacion(){
    	var parametrosArray = new Array();	
    	var arrayIds = $("#gridObligConcordancia").jqGrid('getDataIDs');
        parametrosArray = arrayIds;
    }
    /**
     * 
     */
    function crearObligacionNormativa(){
    	gridIncumplimiento();
    	$('#lblCodigo').css('display','none');//oculta label codigo
    	$('#txtCodOblNor').css('display','none');//oculta codigo
    	$('#btnEliminarObligacion').css('display','none');//ocultar Boton Eliminar Obligacion
    	$('#idObligacion').val('');
    	$('#codBaseLegal').val($('#txtCodBaseLegal').val());
    	$('#subgrid').val('1');
    	$('#txtDesOblNor').val('');
//    	PR OSINE_119 - Item 22 - Inicio
    	
    	$('#idInfraccion').val('');
    	$('#txtDescInfraccion').val('');
    	/* OSINE_SFS-610 - Inicio */
     	//$('#cmbMedidaSeguirdad').val('-1');
    	//$('#cmbAccionInfraccion').val('-1');
     	/* OSINE_SFS-610 - Fin */
    	$('#contenedorImgMedidaSeguridad').remove();
    	$('#cmbEscenario').val('-1');
    	$('#gridIncumplimiento').jqGrid('clearGridData');
//    	PR OSINE_119 - Item 22 - Fin
//    	nuevaObligacionNormativa.consultaAjax();
    	evaluaDetalle();
//    	nuevaObligacionNormativa.listarTemasByIdObligacion($('#idObligacion').val());
    	nuevaObligacionNormativa.initArbolActividades();//verificar
    	cargaInicial.obtenerCriticidadObligacion();
    	
    	//Estilos EDITAR
    	nuevoBL.txtCodigoObligacion.attr('disabled', 'disabled');
    	nuevoBL.txtDescripcionObligacion.removeAttr('disabled');
    	nuevoBL.cmbCriticidadObligacion.removeAttr('disabled');
    	nuevoBL.btnGuardarObligacion.css('display','inline-block');//muestra boton guardar
    	$('#imgCarOblNor').css('display','inline-block');//muestra subir archivo
    	$('#lblDocAdjExtOblNor').css('display','inline-block');//muestra subir archivo
    	//Estilos EDITAR --> Tipificación
    	$('#tipificacionEditarObligacion').css('display','block');
    	//Estilos EDITAR --> Criterio
    	$('#criterioObligacionEditar').css('display','block');
    	//Estilos EDITAR --> Descripciones
    	nuevoBL.txtDescripcionActaObligacion.removeAttr('disabled');
    	$('#btnAgregarDescripcion').css('display','inline-block');
    	//Estilos EDITAR --> Asociar Base Legal
    	$('#asociaObligacionEditar').css('display','block');
    	//Estilos EDITAR --> Configuración
    	nuevoBL.divConfigurarSupervision.css('display','block');
//    	nuevaObligacionNormativa.gridConfiguracionObligacion();
    	//Estilos EDITAR --> Relaciones
    	nuevoBL.btnGuardarRelacionObligacion.css('display','inline-block');
    	nuevaObligacionNormativa.listarTemasByIdObligacion($('#idObligacion').val());
//    	$("#divArbolTemasObligacion").fancytree({disabled:false});
    	//Estilo cambio de Tab
    	$('#tabNewBaseLegal').tabs("enable",1);
        $('#tabNewBaseLegal').tabs({active: 1});
        $('#tabNewBaseLegal').tabs("disable",0);
        $('#divDocumentoAdjuntoDetalle').css('display','block');
//        nuevaObligacionNormativa.gridConfiguracionObligacion();//verificar donde inicializar el grid
        document.getElementById("divDownloadImg").innerHTML="";
        document.getElementById("divDownloadDetalleImg").innerHTML="";
        document.getElementById("divDownloadDetalleImgInfraccion").innerHTML="";   
        $("#cmbMedidaSeguirdad > option[codigo='GG2']").attr('selected',true);        
        $("#cmbAccionInfraccion > option[codigo='AA2']").attr('selected',true);  
    }
    
    function evaluaDetalle(){
    	if($('#idObligacion').val()!="" && $('#idObligacion').val()!="0"){
    		$('#toggObligacion').css('display','block');
    	}else{
    		$('#toggObligacion').css('display','none');
    	}
    }
    /**
     * 
     */
    function chkMostrarObligacion(){
    	nuevoBL.chkObligacion.change(function() {
            if (nuevoBL.chkObligacion.attr('checked')) {nuevoBL.divContenedorGridObligaciones.css("display","block");
            } else {nuevoBL.divContenedorGridObligaciones.css("display","none");}
        });
    }
    /**
     * 
     */
    function abrirPopUpBusquedaAvanzadaConcordancia(){
        ///////////////////////////////////////////////////////////
        var idsBaseLegalAsociarBaseLegal = "";
        var allRowsGrid = $("#gridObligConcordancia").getRowData();
        if($("#txtidBaseLegal").val() != ""){
            idsBaseLegalAsociarBaseLegal = $("#txtidBaseLegal").val() + ",";
        }
        if(allRowsGrid.length != undefined ){
            for(var x = 0; x<allRowsGrid.length; x++){
                idsBaseLegalAsociarBaseLegal += allRowsGrid[x].idBaseLegal + ",";
            }
            idsBaseLegalAsociarBaseLegal = idsBaseLegalAsociarBaseLegal.substring(0, idsBaseLegalAsociarBaseLegal.length - 1); 
        }
        if(idsBaseLegalAsociarBaseLegal == ""){
            idsBaseLegalAsociarBaseLegal = "0";
        }
        ///////////////////////////////////////////////////////////
    	variable=1;
	validaNuevaBaseLegal.asociaObligacion(variable, idsBaseLegalAsociarBaseLegal);        
    }
    
    function abrirPopUpBusquedaAvanzadaObligaciones(){
    	var idsObligacion = "";
        var allRowsGrid = $("#gridOblig").getRowData();
	if(allRowsGrid.length != undefined ){
            for(var x = 0; x<allRowsGrid.length; x++){
                idsObligacion += allRowsGrid[x].idObligacion + ",";
            }
            idsObligacion = idsObligacion .substring(0, idsObligacion .length - 1); 
        }
	if(idsObligacion == ""){
            idsObligacion = "0";
        }
        $.ajax({
            url:baseURL + "pages/baseLegal/abrirDialogAsociarObligacion", 
            type:'get',
            data:{idsObligacion:idsObligacion},
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                $("#dialogAsociarObligacion").html(data);
                $("#dialogAsociarObligacion").dialog({
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
    }
    /**
     * 
     * @returns {undefined}
     */
    function guardaEditarRegistroBaseLegal() {
    	
    	$('#dialogConfirmacionEditarRegistroBaseLegal').dialog('close');
    	/** insertando names**/
    	if(nuevoBL.dateFechaVigenciaArtNormaLegal.val()!='' && $('#dateFecVigenciaNorma').attr('disabled')!='disabled' ){
    		nuevoBL.dateFechaVigenciaArtNormaLegal.removeAttr('disabled');
    		nuevoBL.dateFechaVigenciaArtNormaLegal.attr('name','fechaEntradaVigenciaNorma');// se coloca name
    	}

    	if(nuevoBL.dateFechaVigenciaAnexoNormaLegal.val()!='' && $('#dateFecVigenciaNormaAnexo').attr('disabled')!='disabled'){
    		nuevoBL.dateFechaVigenciaAnexoNormaLegal.removeAttr('disabled');
    		nuevoBL.dateFechaVigenciaAnexoNormaLegal.attr('name','fechaEntradaVigenciaNorma');
    	}
    	
    	if(nuevoBL.chkConcordancia.attr('checked')){
    		nuevoBL.chkConcordancia.val(1);
    		nuevoBL.chkConcordancia.attr('name','concordancia');
	    	var cont=0;
	        $('#gridContenedorObligConcordancia').find('input').removeAttr('name');//limpia names
	        var data=$('#gridContenedorObligConcordancia').find('input');
	        data.map(function(){//busca marcados con check
	        	$(this).attr('checked',true);
	        	$(this).attr("name","listaBasesLegales["+cont+"].idBaseLegalDestino");//les coloca names
	        	cont++;
	        });
	        if(cont==0){
	        	nuevoBL.chkConcordancia.removeAttr('name');
	        	nuevoBL.chkConcordancia.removeAttr('checked');
	        }
    	}
    	
    	if(nuevoBL.chkModificatoria.attr('checked')){
    		nuevoBL.chkModificatoria.val(1);
    		nuevoBL.chkModificatoria.attr('name','modificatoria');
    	}
    	
    	if(nuevoBL.chkObligacion.is(':checked')){
    		nuevoBL.chkObligacion.val(1);
    		nuevoBL.chkObligacion.attr('name','obligacion');
    		var cont=0;
	        $('#gridContenedorOblig').find('input').removeAttr('name');//limpia names
	        var data=$('#gridContenedorOblig').find('input');
	        data.map(function(){//busca marcados con check
	        	$(this).attr('checked',true);
	        	$(this).attr("name","listaObligaciones["+cont+"].idObligacion");//les coloca names
	        	cont++;
	        });
	        if(cont==0){
	        	nuevoBL.chkObligacion.removeAttr('name');
	        	nuevoBL.chkObligacion.removeAttr('checked');
	        }
    	}
    	$('#chkNormaLegalPadre').removeAttr('disabled');
    	/** <--> **/
    	concatenaDescripcionBaseLegal();
    	settearInputsDetalleNorma();
        confirmacion = "N";
        if (confirmacion == "N") {//Nuevo Expediente
            $.ajax({
                url: baseURL + "pages/mantenimiento/baseLegal/actualizarBaseLegal",
                type: 'post',
                async: true,
                data: $("#frmAgregarBaseLegal").serialize(),
                beforeSend: muestraLoading,
                success: function(data) {
                    if (data.resultado == 0) {
                        mensajeGrowl("success", data.mensaje);
                        ocultaLoading();
                        busquedaBaseLegal.procesarGridBaseLegal();
                        validaCerrar=1;
                        cerrarMantenimientoBaseLegal();
                    } else if (data.resultado == 2) {
                        muestraDivError('#divMensajeValidacion', data.mensaje,'');
                        ocultaLoading();
                    } else {
                        mensajeGrowl('error', data.mensaje);
                        ocultaLoading();
                    }
                },
                error: errorAjax
            });
//            cerrarMantenimientoBaseLegal();
        }
        $('#chkNormaLegalPadre').attr('disabled','disabled');
    }
    /**
     * @returns {undefined}
     * $(container).html(data) : inserta 'data'
     */
    function abrirPopUpArbolActividades() {
        var URL = baseURL + "pages/mantenimiento/baseLegal/arbolActividades";
        $.get(URL, function(data) {
            $("#containerDialogArbolActividadesMantenimiento").html(data);
        });
    }
    /**
     * @returns {undefined}
     * $(container).html(data) : inserta 'data'
     */
    function abrirPopUpArbolProductos() {
        var URL = baseURL + "pages/mantenimiento/baseLegal/arbolProductos";
        $.get(URL, function(data) {
            $("#containerDialogArbolProductosMantenimiento").html(data);
        });
    }
    /**
     * @returns {undefined}
     * .dialog('close')
     */
    function cerrarMantenimientoBaseLegal() {
        $("#" + idDialog).dialog('close');
    }
    /**
     * @returns {undefined}
     * .dialog(properties)
     */
    function dialogMantenimientoBaseLegal() {
        dialog(idDialog, 'Mantenimiento Base Legal', false, 'dialogMantenimientoBaseLegal');
//        $('#' + idDialog).dialog("option", "position", { my: "center bottom", at: "center center", of: window });
        $('#' + idDialog).on("dialogclose", function(event, ui) {
        	$(this).dialog("destroy");
            $(this).remove();
            //remove elementos insertados en el html
            $('div[role="dialog"]').remove();
            $('#ui-datepicker-div').remove();
            $('#contextMenuPautas').parent().remove();
            $('#contextMenuPautaSancionTipificacion').parent().remove();
            $('#contextMenuArchivo').parent().remove();
            $('#contextMenuTipificacion').parent().remove();
            $('#contextMenuOblig').parent().remove();
            $('#contextMenuCriterio').parent().remove();
            $('#contextMenuArchivo').parent().remove();
            $('#contextMenuObligConcordancia').parent().remove();
            $('#dialogComunConf').remove();
            $('.dialogComunConf').remove();
            nuevaObligacionNormativa.limpiandoArchivoObligacion();
            /*oculta container*/
            $('#divOcultaContainerMantenimiento').css("display","none");
            //dialog de confirmacion
        });
        
        $('#' + idDialog).on("dialogbeforeclose", function(event, ui) { 
            if(gestionBaseLegal.modoVisualizacion != modoVer){
                var isOpen=$('#dialogConfirmacionSalirBaseLegal').dialog("isOpen");
                var isOpen2=$('#' + idDialog).dialog("isOpen");
                if(isOpen){
                        return true;
                }
                if(validaCerrar==0){
                        $('#dialogConfirmacionSalirBaseLegal').dialog('open');
                        return false;
                }else if(validaCerrar==1){
                        return true;
                }
            }
        });
        
        $("#" + idDialog).dialog('open');
        
    }

    function deshabilitarVerBaseLegal(){
        /*campos a deshabilitar*/   
        nuevoBL.cmbTipoNormaLegal.attr('disabled','disabled');
        nuevoBL.dateFechaVigenciaArtNormaLegal.attr('disabled','disabled');
        nuevoBL.txtArticuloAnexoNormaLegal.attr('disabled','disabled');
        nuevoBL.dateFechaVigenciaAnexoNormaLegal.attr('disabled','disabled');
        nuevoBL.txtDescripcionNormaTecnica.attr('disabled','disabled');
        /*Rsis 1 - Inicio*/
        nuevoBL.cmbNumeroAnexo.attr('disabled','disabled');
        /*Rsis 1 - Fin*/
        /* campos a ocultar */
        nuevoBL.divBotonesGridObligaciones.css("display","none");
        nuevoBL.btnGuardarBaseLegal.css("display","none");
        nuevoBL.btnGenerarDescripcionNormaLegal.css("display","none");
        nuevoBL.divNormaArticuloNormaLegal.css("display","block");//$('#fecnivelnorma').css("display","block");
        nuevoBL.divAnexoNormaLegal.css("display","block");//$('#divAnexoBaseLegal').css("display","block");
        nuevoBL.txtDescripcionNormaTecnica.css("display","inline-block");//$('#txtDesNorTecBaseLegal').css("display","block");
        nuevoBL.divContenedorGridObligaciones.css("display","block");//$('#divCrearObligacionUnica').css("display","block");
        nuevoBL.btnGuardarBaseLegal.css("display","none");
        /* pantalla obligacion */
        
    }
    /**
     * 
     * @returns {undefined}
     */
    function habilitarMantenimientoBaseLegal() {
        $('#btnEditarBaseLegal').css("display","inline-block");
        nuevoBL.btnGuardarBaseLegal.css("display","none");
    }
    /**
     * funcion 
     * @returns {undefined}
     */
    function models() {
        $("#dialogConfirmacionRegistroBaseLegal").dialog({
            resizable: false,
            draggable: false,
            autoOpen: false,
            height: "auto",
            minHeight: 20,
            maxWidth: 500,
            dialogClass: 'dialog',
            modal: true
        });
        $("#dialogConfirmacionSalirBaseLegal").dialog({
            resizable: false,
            draggable: false,
            autoOpen: false,
            height: "auto",
            minHeight: 20,
            maxWidth: 500,
            dialogClass: 'dialog',
            modal: true
        });
        
        $("#dialogConfirmacionEditarRegistroBaseLegal").dialog({
            resizable: false,
            draggable: false,
            autoOpen: false,
            height: "auto",
            width: "auto",
            minHeight: 20,
            maxWidth: 500,
            dialogClass: 'dialog',
            modal: true
        });
        $("#dialogConfirmacionObligacionNormativa").dialog({
            resizable: false,
            draggable: false,
            autoOpen: false,
            height: "auto",
            width: "auto",
            minHeight: 20,
            maxWidth: 500,
            dialogClass: 'dialog',
            modal: true
        });
        $("#dialogConfirmacionObligacionNormativaTipificacion").dialog({
            resizable: false,
            draggable: false,
            autoOpen: false,
            height: "auto",
            minHeight: 20,
            maxWidth: 500,
            dialogClass: 'dialog',
            modal: true
        });
        $("#dialogConfirmacionObligacionNormativaNuevo").dialog({
            resizable: false,
            draggable: false,
            autoOpen: false,
            height: "auto",
            minHeight: 20,
            maxWidth: 500,
            dialogClass: 'dialog',
            modal: true
        });
        $("#dlgSubImagen").dialog({
            resizable: false,
            autoOpen: false,
            height: "auto",
            width: "auto",
            dialogClass: 'dialog',
            modal: true
        });
        $("#dialogMostrarCodigoBaseLegal").dialog({
            resizable: false,
            autoOpen: false,
            height: "auto",
            width: "auto",
            dialogClass: 'dialog',
            modal: true,
            title: 'Base Legal',
            beforeClose: function(event, ui) { 
// 05-11-2015
//                $("#" + idDialog).dialog('close');
                return true;
            }
        });
    }

    function guardarNuevaObligacion() {
        prueba = nuevoBL.txtCodigoNormaLegal.val();
        var validarObligacion;
        validarObligacion = $('#frmNuevaOblNorm').validateAllForm('#divMensajeValidacionObl');
        if (validarObligacion) {
            confirmacion = "N";
            if ($('#txtTipifOblNor').val() === "") {
                flag = 0;
                $("#dialogConfirmacionObligacionNormativaTipificacion").dialog("open");
            }
            else {
                $("#dialogConfirmacionObligacionNormativaNuevo").dialog("open");
            }

        }
    }

    function abrirPopUpSubirArchivoBaseLegal() {
        document.getElementById('frmAgregarBaseLegal').onsubmit = function() {
            return false;
        };
        $("#dlgSubImagen").dialog("open");
    }

    function guardarArchivoBaseLegal() {
        /* creado jpiro 20150106 - inicio */
        var validar;
        validar = $('#formArchivoBL').validateAllForm("");
        if($('input[name="archivos[0]"]').val()!='' && validar){
            $("#imgArchivo").css("display","none");
            $("#lblImgArchivo").text("");
            $("#formArchivoBL").submit();
        }
        /* creado jpiro 20150106 - fin */
        
        /* modificado jpiro 20150106 - inicio */
//        $("#imgArchivo").css("display","block");
//        $("#dlgSubImagen").dialog("close");
//        $("#lblImgArchivo").text($("#desImagen").val());
        /* modificado jpiro 20150106 - fin */
    }
    
    /*
     * creado jpiro 20150106, envia archivo al servidor
     * @returns {Boolean}
     */
    function enviarDatosArchivoBL(data) {
        if (data.error) {
            mensajeGrowl("error", "Error", data.mensaje);
        } else {            
            document.getElementById("divArchivoNormaLegal").innerHTML="";
            $('#divArchivoNormaLegal').append('<a class="link" href="'+baseURL + 'pages/mantenimiento/baseLegal/descargaArchivoNormaLegal"><img class="vam" width="20" height="24" src="'+baseURL+'images/stickers.png"></a>');
            $("#dlgSubImagen").dialog("close");
        }
    }

    function cancelarRegistroObligacion() {
    	$( "#tabNewBaseLegal" ).tabs( "enable", 0 );
        $('#tabNewBaseLegal').tabs({active: 0});
        $( "#tabNewBaseLegal" ).tabs( "disable", 1 );
        nuevaObligacionNormativa.limpiandoArchivoObligacion();
        return false;
//        $('#tab2').css("display","none");
//        $('#chkCrearObligacion').attr('checked', false);
        
        //$('#divCrearObligacionUnica').css("display","none");
    }

    function abrirPopUpConfirmacionRegistroObligacion() {
        prueba = nuevoBL.txtCodigoNormaLegal.val();
        var validarObligacion;
        validarObligacion = $('#frmNuevaOblNorm').validateAllForm('#divMensajeValidacionObl');
        
        if (validarObligacion) {
        	confirmacion = "N";
        	
        	if($('#idObligacion').val()==""){
        		$("#dialogConfirmacionObligacionNormativa").dialog("open");
        	}else if($('#idObligacion').val()!=""){
        		gestionBaseLegal.confirmaRegistroObligacion();
        	}
        	
        }
    }
    /**
     * No esta Funcional
     */
    function ConfirmaSiTipificacion() {
        $("#dialogConfirmacionObligacionNormativaTipificacion").dialog("close");
        if (flag === 1) {
            $("#dialogConfirmacionObligacionNormativa").dialog("open");
        } else if (flag === 0) {
            $("#dialogConfirmacionObligacionNormativaNuevo").dialog("open");
        }
    }

    function cerrarPopUpConfirmaNoTipificacion() {
        $("#dialogConfirmacionObligacionNormativaTipificacion").dialog("close");
    }

    function cerrarPopUpConfirmaRegistroObligacion() {
        $('#divMensajeValOblNor').css("display","none");
        $("#dialogConfirmacionObligacionNormativa").dialog("close");
    }

    function enviarDatosArchivoObligacion(data) {
        if (data.error) {
            mensajeGrowl("error", "Error", data.mensaje);
        } else {
        	document.getElementById("divDownloadImg").innerHTML="";
            $('#divDownloadImg').append('<a class="link" href="'+baseURL + 'pages/mantenimiento/baseLegal/descargaArchivoObligacion"><img class="vam" width="20" height="24" src="'+baseURL+'images/stickers.png"></a>');
//            $('#divDownloadImg').append('<span class="ui-icon ui-icon-closethick"  title="ELIMINAR ARCHIVO"></span>');//btn borrar archivo
//            nuevoBL.lblMuestraNombreArchivo.text(nuevoBL.fileImagenObligacion.val());
            $('#dialogCargarNuevaOblNor').dialog('close');
        }
    }
    
    function enviarDatosArchivoDescripcion(data) {
        if (data.error) {
            mensajeGrowl("error", "Error", data.mensaje);
        } else {
        	document.getElementById("divDownloadDetalleImg").innerHTML="";
            $('#divDownloadDetalleImg').append('<a class="link" href="'+baseURL + 'pages/mantenimiento/baseLegal/descargaArchivoDescripcion"><img class="vam" width="20" height="24" src="'+baseURL+'images/stickers.png"></a>');
//            nuevoBL.imgMuestraImagenArchivoDescripcion.css("display","block");
            $('#dialogCargarArchivoDescripcion').dialog('close');
        }
    }
    
    /*Rsis 11 - Inicio*/
    function enviarDatosArchivoInfraccion(data) {
        if (data.error) {
            mensajeGrowl("error", "Error", data.mensaje);
        } else {
        	document.getElementById("divDownloadDetalleImgInfraccion").innerHTML="";
            $('#divDownloadDetalleImgInfraccion').append('<a id="contenedorImgMedidaSeguridad" class="link" href="'+baseURL + 'pages/mantenimiento/baseLegal/descargaArchivoInfraccion"><img id="imgMedidaSeguridad" class="vam" width="20" height="24" src="'+baseURL+'images/stickers.png"></a>');
//            nuevoBL.imgMuestraImagenArchivoDescripcion.css("display","block");
            $('#dialogCargarArchivoInfraccion').dialog('close');
        }
    }
    /*Rsis 11 - Fin*/
    function confirmaRegistroObligacion(retorno) {
    	confirmacion="N";
        $("#dialogConfirmacionObligacionNormativa").dialog("close");
        $('#divMensajeValOblNor').css("display","none");
//        $('#tabNewBaseLegal').tabs({active: 0});
        settearInputsConcordancia();
        if (confirmacion == "N") {//Nuevo Expediente
            $.ajax({
                url: baseURL + "pages/mantenimiento/baseLegal/registrarObligacionNormativa",
                type: 'post',
                async: false,
                data: $("#frmNuevaOblNorm").serialize(),
                beforeSend: muestraLoading,
                success: function(data) {
                    if (data.resultado == 0) {
                    	mensajeGrowl("success", data.mensaje);
                    	
                    	 $('#tabSanciones').hide();                                               
                         $('#tabDescr').hide();
                         $('#tabRef').hide();
                         $('#tabRelac').hide();
                         $('#tabMedSeg').hide();
                    	
                    	$('#lblCodigo').css('display','inline-block');//muestra label codigo
                    	$('#txtCodOblNor').css('display','inline-block');//muestra codigo
                    	$('#btnEliminarObligacion').css('display','inline-block');//muestra codigo
                        $('#idObligacion').val(data.idObligacion);
                        $('#txtCodObl').val(data.codigoObligacion);
                        $('#txtCodOblNor').val(data.codigoObligacion);
                        
                        ocultaLoading();
                        addGridObligacionBaseLegal(data.idObligacion,data.codigoObligacion);
                        gestionBaseLegal.evaluaDetalle();
                        //Inicia Grids al crear
//                        nuevaObligacionNormativa.procesarGridAsociaBaseLegal();//cambio grid
                        nuevaObligacionNormativa.gridConfiguracionObligacion();
                        nuevaObligacionNormativa.listarTemasByIdObligacion(data.idObligacion);
                        nuevaObligacionNormativa.recargarGriTipificacion();
                        nuevaObligacionNormativa.recargarGridCriterios();
                        $('#idDetalleObligacion').val(data.idDetalleObligacion);//limpiar idDetalle
                        nuevaObligacionNormativa.procesarGridAsociaBaseLegal();
                        
                    } else if (data.resultado == 1) {
                    	mensajeGrowl('success', data.mensaje);
                    	var idRow=$('#idObligacion').val();
                    	var idDescripcion=$('#txtDesOblNor').val();
                    	$("#gridOblig").jqGrid('setRowData', idRow , {descripcion:idDescripcion});
                        ocultaLoading();
                    }else if (data.resultado == 2) {
                        muestraDivError("divMensajeValidacion", data.mensaje, "");
                        ocultaLoading();
                    } else {
                        mensajeGrowl('error', "Error en el insertar", 'Intente de nuevo');
                        ocultaLoading();
                    }
                },
                error: errorAjax
            });
        }
            $("#tabSupervision a").click();
        	return false;
        
        	
    }
    
    function addGridObligacionBaseLegal(id,codigo){
    	// Agregar obligacion al grid de obligaciones de la base legal
        var idObligacion = id;
        var codigoObligacion = codigo;
        var descripcionObligacion = $('#txtDesOblNor').val();
        var idData =id;
        var rowData = {
        	idObligacion : idObligacion,
        	codigoObligacion : codigoObligacion,
        	descripcion : descripcionObligacion,
        };
        $("#gridOblig").addRowData(idData, rowData);  
    }

    function cerrarPopUpConfirmaRegistroNuevaObligacion() {
        $('#divMensajeValOblNor').css("display","none");
        $("#dialogConfirmacionObligacionNormativaNuevo").dialog("close");
    }

    function confirmaRegistroNuevaObligacion() {
        $("#dialogConfirmacionObligacionNormativaNuevo").dialog("close");
        $("#dialogConfirmacionObligacionNormativa").dialog("close");
        $('#divMensajeValOblNor').css("display","none");
        if (confirmacion == "N") {//Nuevo Expediente
            $.ajax({
                url: baseURL + "pages/baseLegal/registrarObligacionNormativa",
                type: 'post',
                async: false,
                data: $("#frmNuevaOblNorm").serialize(),
                beforeSend: muestraLoading,
                success: function(data) {
                    if (data.resultado == 0) {
                        mensajeGrowl("success", "Se registró correctamente", "Se registrarón los datos correctamente");
                        ocultaLoading();
                        gestionBaseLegal.generaCodigoObligacion();
                        validaNuevaBaseLegal.procesarGridOblig();
                    } else if (data.resultado == 2) {
                        muestraDivError("divMensajeValidacion", data.mensaje, "");
                        ocultaLoading();
                    } else {
                        //mensajeGrowl("success", "Se registró correctamente", "Se registrarón los datos correctamente");
                        mensajeGrowl('error', "Error en el insertar", 'Intente de nuevo');
                        ocultaLoading();
                    }
                },
                error: errorAjax
            });

        }
    }

    function generaCodigoObligacion() {
        cadena = $('#txtCodObl').val();
        partenumerica = cadena.substring(3, cadena.length);
        partenumerica++;
        partecadena = cadena.substring(0, 3);
        correlativo = partecadena + "00" + partenumerica;
        nuevoBL.txtCodigoObligacion.val(correlativo);
        nuevoBL.txtDescripcionObligacion.val('');
        nuevoBL.cmbTemaObligacion.val('');
        nuevoBL.cmbCriticidadObligacion.val('');
        nuevoBL.txtCodigoTipificacionObligacion.val('');
        nuevoBL.txtDescripcionActaObligacion.val('');
        nuevoBL.txtDescripcionGuiaObligacion.val('');
        /*limpia tipificacion*/
        nuevoBL.txtDescripcionTipificacionOblig.val('');
        nuevoBL.txtSancionTipificacionObligacion.val('');
//        nuevoBL.chkCierreEstablecimiento.attr('checked', false);
//        nuevoBL.chkCierreInstalacion.attr('checked', false);
//        nuevoBL.chkComisoBienes.attr('checked', false);
//        nuevoBL.chkParalizacionObras.attr('checked', false);
//        nuevoBL.chkRetiroInstalacion.attr('checked', false);
//        nuevoBL.chkSuspensionDefinitiva.attr('checked', false);
//        nuevoBL.chkSuspensionTemporal.attr('checked', false);
        $('#txtCodObl').val(correlativo);
    }

    function abrirPopUpConfirmacionEditarBaseLegal() {
concatenaDescripcionBaseLegal();
        
        var resultadoValidacion  = validacionDatosBaseLegal();
        ///////////////////////////
        if (resultadoValidacion) {
            confirmacion = "N";
    	$("#dialogConfirmacionEditarRegistroBaseLegal").dialog("open");
        }
    }
    /**
     * 
     * @returns {undefined}
     */
    function abrirPopUpConfirmacionBaseLegal() {
    	concatenaDescripcionBaseLegal();
        
        var resultadoValidacion  = validacionDatosBaseLegal();
        ///////////////////////////
        if (resultadoValidacion) {
            confirmacion = "N";
            $("#dialogConfirmacionRegistroBaseLegal").dialog("open");
        }
    }

    /**
     * Comment
     */
    function validacionDatosBaseLegal() {
        $('#divMensajeValOblNor').css("display","none");
        var validarBaseLegal = false;
        validarBaseLegal = $('#frmAgregarBaseLegal').validateAllForm('#divMensajeValidacion');
            
        var divValidacion = $('#divMensajeValidacion');
        var mensajeValidacion = "";
        if($('#cmbTipBaseLegal').val() == "-1"){
            mensajeValidacion += "* Debe seleccionar un Tipo Normal Legal <br>";   
        }
        // Inicio MYC-7 Cambio de Alcance
        if(nuevoBL.txtArticuloNormaLegal.val() == '0' || nuevoBL.txtArticuloNormaLegal.val() == '00' || nuevoBL.txtArticuloNormaLegal.val() == '000'){
        	mensajeValidacion += "* (Artículo) valor a registrar no permitido <br>";
        	nuevoBL.txtArticuloNormaLegal.addClass("error");
        }else{
        	nuevoBL.txtArticuloNormaLegal.removeClass("error");
        }
        if($('#txtArtAneBaseLegal').val() == '0' || $('#txtArtAneBaseLegal').val()  == '00' || $('#txtArtAneBaseLegal').val()  == '000'){
        	mensajeValidacion += "* (Artículo del Anexo) valor a registrar no permitido <br>";
        	$('#txtArtAneBaseLegal').addClass("error");
        }else{
        	$('#txtArtAneBaseLegal').removeClass("error");
        }
        // Fin MYC-7 Cambio de Alcance
        if(nuevoBL.txtNumeroNormaLegal.val()==""){
            mensajeValidacion += "* Debe ingresar Número <br>";   
        }
        var fechaActual = new Date();
        var anioFinal = fechaActual.getFullYear();
        var anio = $('#txtAnioBaseLegal').val();
        if(anio != "" && ( parseInt(anio) < 1960 || parseInt(anio) > (anioFinal+1) )){
            mensajeValidacion += "* Debe ingresar un año valido (mayor a 1960 y menor o igual a "+(anioFinal+1)+") <br>";       
        }
        if ($('#chkCrearObligacion').is(':checked')) {
            var filasGridObligaciones = $("#gridOblig").getRowData();
            if(filasGridObligaciones.length != undefined && filasGridObligaciones.length == 0){
                mensajeValidacion += "* Debe asociar una Obligación <br>";   
            }
            // Inicio MYC-7 Cambio de Alcance
//            else if(filasGridObligaciones.length> 0 && nuevoBL.txtArticuloNormaLegal.val()==""){
//            	mensajeValidacion += "* Debe ingresar Artículo para poder asociar Obligaciones <br>";
//            	nuevoBL.txtArticuloNormaLegal.addClass("error");
//            }
            // Fin MYC-7 Cambio de Alcance
        }
        
        if ($('#chkModificatoria').is(':checked')) {
            if(nuevoBL.txtNumeroNormaLegal.val()==""){
            	mensajeValidacion += "* Debe ingresar Número guardar con modificatorias <br>";
            	nuevoBL.txtNumeroNormaLegal.addClass("error");
            }
        }
        
        if ($('#chkConcordancia').is(':checked')) {
            var filasGridConcordancia = $("#gridObligConcordancia").getRowData();
            if(filasGridConcordancia.length != undefined && filasGridConcordancia.length == 0){
                mensajeValidacion += "* Debe asociar una Base Legal <br>";   
            }else if(filasGridConcordancia.length> 0 && nuevoBL.txtNumeroNormaLegal.val()==""){
            	mensajeValidacion += "* Debe ingresar Número asociar Bases Legales en Concordancia <br>";
            	nuevoBL.txtNumeroNormaLegal.addClass("error");
            }
        } 
        
        var expreg = new RegExp("^[0-9]{1,3}$|^[a-z]{1,2}$");
        if($('#txtInc1BaseLegal').val() != "" && !expreg.test($('#txtInc1BaseLegal').val())){
        	/* OSINE_SFS-610 - Inicio */
            //mensajeValidacion += "* Debe ingresar un valor valido para el Articulo - Inciso Nivel 1 ( ### o AA ) <br>";
        	mensajeValidacion += "* Debe ingresar un valor v&aacute;lido para el Art&iacute;culo - Inciso Nivel 1 ( ### &oacute; aa ) <br>";
        	/* OSINE_SFS-610 - Fin */
            $('#txtInc1BaseLegal').addClass("error");
        }
        
        if($('#txtInc2BaseLegal').val() != "" && !expreg.test($('#txtInc2BaseLegal').val())){
        	/* OSINE_SFS-610 - Inicio */
            //mensajeValidacion += "* Debe ingresar un valor valido para el Articulo - Inciso Nivel 2 ( ### o AA ) <br>";
        	mensajeValidacion += "* Debe ingresar un valor v&aacute;lido para el Art&iacute;culo - Inciso Nivel 2 ( ### &oacute; aa ) <br>";
        	/* OSINE_SFS-610 - Fin */
            $('#txtInc2BaseLegal').addClass("error");
        }
        
        if($('#txtInc3BaseLegal').val() != "" && !expreg.test($('#txtInc3BaseLegal').val())){
        	/* OSINE_SFS-610 - Inicio */
            //mensajeValidacion += "* Debe ingresar un valor valido para el Anexo - Inciso Nivel 1 ( ### o AA ) <br>";
        	mensajeValidacion += "* Debe ingresar un valor v&aacute;lido para el Anexo - Inciso Nivel 1 ( ### &oacute; aa ) <br>";
            /* OSINE_SFS-610 - Fin */
            $('#txtInc3BaseLegal').addClass("error");
        }        
        
        if($('#txtInc4BaseLegal').val() != "" && !expreg.test($('#txtInc4BaseLegal').val())){
        	/* OSINE_SFS-610 - Inicio */
            //mensajeValidacion += "* Debe ingresar un valor valido para el Anexo Inciso - Nivel 2 ( ### o AA ) <br>";   
        	mensajeValidacion += "* Debe ingresar un valor v&aacute;lido para el Anexo - Inciso Nivel 2 ( ### &oacute; aa ) <br>";
        	/* OSINE_SFS-610 - Fin */
            $('#txtInc4BaseLegal').addClass("error");
        }
        
//        if($('#cmbNumeroAnexo option:selected').text() == '--Seleccione--' && $('#cmbTipAneBaseLegal option:selected').text() != '--Seleccione--'){
//        	mensajeValidacion += "* Debe ingresar un n&uacute;mero de anexo <br>";
//        	nuevoBL.cmbNumeroAnexo.addClass("error");
//        }
        
        if($('#txtArtAneBaseLegal').val()=="" && $('#cmbTipAneBaseLegal option:selected').text() != '--Seleccione--'){
        	mensajeValidacion += "* Debe ingresar un valor en el campo Artículo del Anexo <br>";
        	nuevoBL.txtArticuloAnexoNormaLegal.addClass("error");
        }
//        Inicio MYC-7 Cambio de Alcance
//        if($('#cmbTipAneBaseLegal option:selected').text() != '--Seleccione--' && nuevoBL.txtArticuloNormaLegal.val()==""){
//        	mensajeValidacion += "* Debe ingresar un valor en el campo Artículo <br>";
//        	nuevoBL.txtArticuloNormaLegal.addClass("error");
//        }
        if($('#chkNormaLegalPadre').is(':checked')){
        	
        }else{
        	if($('#cmbNorTecBaseLegal option:selected').text() != '--Seleccione--' && nuevoBL.txtArticuloNormaLegal.val()=="" && $('#cmbTipAneBaseLegal option:selected').text() == '--Seleccione--'){
        		if(nuevoBL.txtArticuloNormaLegal.val()=="" && $('#cmbTipAneBaseLegal').val()=="-1"){
        			mensajeValidacion += "* Debe ingresar un valor en el campo Artículo o Debe seleccionar un Tipo de Anexo <br>";
        			nuevoBL.txtArticuloNormaLegal.addClass("error");
        			$('#cmbTipAneBaseLegal').addClass("error");
        		}
	        }
	        if($('#cmbNorTecBaseLegal option:selected').text() == '--Seleccione--' && nuevoBL.txtArticuloNormaLegal.val()=="" && $('#cmbTipAneBaseLegal option:selected').text() == '--Seleccione--'){
	    			mensajeValidacion += "* Debe ingresar un valor en el campo Artículo o Debe seleccionar un Tipo de Anexo <br>";
	    			nuevoBL.txtArticuloNormaLegal.addClass("error");
	    			$('#cmbTipAneBaseLegal').addClass("error");
	        }
        }        
//		  Fin MYC-7 Cambio de Alcance
        if($("#txtDesConcatenado").val().length>2000 || $('#txtDesConcatenadoOculto').val().length>2000){
        	mensajeValidacion += "* La cantidad maxima de caracteres para la descripci&oacute;n de la Base Legal es de 2000  <br>";
        	$("#txtDesConcatenado").addClass("error");
        	$('#txtDesConcatenadoOculto').addClass("error");
        }
        if(mensajeValidacion != ""){
            divValidacion.show();
            divValidacion.focus();
            divValidacion.html(mensajeValidacion);
            validarBaseLegal = false;
        }else{
            divValidacion.hide();
            divValidacion.html("");
        }
        return validarBaseLegal;
    }
    
    function confirmaRegistroBaseLegal() {
//    	obtenerCodigoBaseLegal();
    	confirmacion="N";
    	/** insertando names**/
    	if(nuevoBL.dateFechaVigenciaArtNormaLegal.val()!='' && $('#dateFecVigenciaNorma').attr('disabled')!='disabled' ){
//    		nuevoBL.dateFechaVigenciaArtNormaLegal.removeAttr('disabled');
    		nuevoBL.dateFechaVigenciaArtNormaLegal.attr('name','fechaEntradaVigenciaNorma');// se coloca name
    	}

    	if(nuevoBL.dateFechaVigenciaAnexoNormaLegal.val()!='' && $('#dateFecVigenciaNormaAnexo').attr('disabled')!='disabled'){
//    		nuevoBL.dateFechaVigenciaAnexoNormaLegal.removeAttr('disabled');
    		nuevoBL.dateFechaVigenciaAnexoNormaLegal.attr('name','fechaEntradaVigenciaNorma');
    	}
    	
    	if(nuevoBL.chkConcordancia.is(':checked')){
    		nuevoBL.chkConcordancia.val(1);
    		nuevoBL.chkConcordancia.attr('name','concordancia');
	    	var cont=0;
	        $('#gridContenedorObligConcordancia').find('input').removeAttr('name');//limpia names
	        var data=$('#gridContenedorObligConcordancia').find('input');
	        data.map(function(){//busca marcados con check
	        	$(this).attr('checked',true);
	        	$(this).attr("name","listaBasesLegales["+cont+"].idBaseLegalDestino");//les coloca names
	        	cont++;
	        });
	        if(cont==0){
	        	nuevoBL.chkConcordancia.removeAttr('name');
	        	nuevoBL.chkConcordancia.removeAttr('checked');
	        }
    	}
    	
    	if(nuevoBL.chkModificatoria.is(':checked')){
    		nuevoBL.chkModificatoria.val(1);
    		nuevoBL.chkModificatoria.attr('name','modificatoria');
    	}
    	
    	if(nuevoBL.chkObligacion.is(':checked')){
    		nuevoBL.chkObligacion.val(1);
    		nuevoBL.chkObligacion.attr('name','obligacion');
    		var cont=0;
	        $('#gridContenedorOblig').find('input').removeAttr('name');//limpia names
	        var data=$('#gridContenedorOblig').find('input');
	        data.map(function(){//busca marcados con check
	        	$(this).attr('checked',true);
	        	$(this).attr("name","listaObligaciones["+cont+"].idObligacion");//les coloca names
	        	cont++;
	        });
	        if(cont==0){
	        	nuevoBL.chkObligacion.removeAttr('name');
	        	nuevoBL.chkObligacion.removeAttr('checked');
	        }
    	}
    	/** <--> **/
    	$('#chkNormaLegalPadre').removeAttr('disabled');
        $("#dialogConfirmacionRegistroBaseLegal").dialog("close");
        concatenaDescripcionBaseLegal();//genera descripción
        var mydata = $('#tblNormaTecnica').getGridParam('data');
        
//        $.each( mydata, function( key, value ) {
//        	  alert( key + ": " + value.idTipoNormaTecnica );
//        });
        
        settearInputsDetalleNorma();
        if (confirmacion == "N") {//Nuevo 
            $.ajax({
                url: baseURL + "pages/mantenimiento/baseLegal/registrarBaseLegal",
                type: 'post',
                async: false,
                data: $("#frmAgregarBaseLegal").serialize(),
                beforeSend: muestraLoading,
                success: function(data) {
                    if (data.resultado == 0) {
// 05-11-2015           
                    	var idsConcordancia = "";
                    	if (data.baseLegal.listaBasesLegales != null){
                          $.each(data.baseLegal.listaBasesLegales,function(k,v){
                        	idsConcordancia += "," + (v.idBaseLegalDestino) ;
                          });
                    	}
                    	$('#txtidBaseLegalConcordancia').val(idsConcordancia);
                        mensajeGrowl('success', data.mensaje);
                        ocultaLoading();
                        $('#txtidBaseLegal').val(data.baseLegal.idBaseLegal);
                        $('#txtCodBaseLegal').val(data.baseLegal.codigoBaseLegal);
                        $('#txtCodigoBaseLegalNuevo').val(data.baseLegal.codigoBaseLegal);
                        $('#txtidDetalleBaseLegal').val(data.baseLegal.idDetalleBaseLegal);
                        $('#codTrazabilidadNuevo').val(data.codTrazabilidad);
                        $('#codTrazabilidad').val(data.codTrazabilidad);
                        $('#btnEditarBaseLegal').css('display','inline-block');
                        $('#btnNuevaBaseLegal').css('display','none');
                        $('#txtidBaseLegalByObligacion').val(data.baseLegal.idBaseLegal);
                        nuevoBL.chkObligacion.removeAttr('disabled');
                                                
                        if(data.baseLegal.flagPadre=="P"){
                        	$('#toggAsigna').css('display','none'); 
                            var divMostrarCodigoBaseLegal = $("#divMensajeMostrarCodigoBaseLegal").show();
                            divMostrarCodigoBaseLegal.focus();
                            /* OSINE_SFS-610 - Inicio */
                            //divMostrarCodigoBaseLegal.html(" El Codigo de la Base Legal es:"+data.codigoBaseLegal);
                            divMostrarCodigoBaseLegal.html(" El C&oacute;digo de la Base Legal es:"+data.codigoBaseLegal);
                            /* OSINE_SFS-610 - Fin */
                            $('#divDialogEditarBaseLegal').find('span').eq(1).html(data.codigoBaseLegal);
                            $("#dialogMostrarCodigoBaseLegal").dialog('open');
                        }else{
                        	$('#toggAsigna').css('display','inline-block'); 
                            var divMostrarCodigoBaseLegal = $("#divMensajeMostrarCodigoBaseLegal").show();
                            divMostrarCodigoBaseLegal.focus();
                            /* OSINE_SFS-610 - Inicio */
                            //divMostrarCodigoBaseLegal.html(" El Codigo de la Base Legal es:"+data.codigoBaseLegal);
                            divMostrarCodigoBaseLegal.html(" El C&oacute;digo de la Base Legal es:"+data.codigoBaseLegal);
                            /* OSINE_SFS-610 - Fin */
                            $('#divDialogEditarBaseLegal').find('span').eq(1).html(data.codigoBaseLegal);
                            $("#dialogMostrarCodigoBaseLegal").dialog('open');

                        }       
                        
                        busquedaBaseLegal.procesarGridBaseLegal();
                        validaCerrar=1;
//                    	
                    } else if (data.resultado == 2) {
                    	muestraDivError('#divMensajeValidacion', data.mensaje,'');
                        ocultaLoading();
                    } else if (data.resultado == 1) {
                    	muestraDivError('#divMensajeValidacion', data.mensaje,'');
                        ocultaLoading();
                    } else {
                        mensajeGrowl('error', data.mensaje);
                        ocultaLoading();
                    }
                },
                error: errorAjax
            });
            
        }
        $('#chkNormaLegalPadre').attr('disabled','disabled');
    }
    /**
     * 
     * @returns {undefined}
     */
    function CerrarPopUpConfirmaRegistroBaseLegal() {
        $("#dialogConfirmacionRegistroBaseLegal").dialog("close");
    }
    /**
     * 
     * @returns {undefined}
     */
    function limpiarSimple() {
        $('#dialogBusquedaAvanzadaBaseLegal input[type=text]').each(function(index) {
            $(this).val("");
        });
    }
    /**
     * 
     * @returns {undefined}
     */
    function botonesLimpiar() {
        $('#botoLimpiarBusquedaAvanzadaBaseLegal').click(function() {
            limpiarSimple();
        });
    }
    
    /**
     * 
     * @returns {undefined}
     */
    function concatenaDescripcionBaseLegal() {
//    	alert("ola");
        var NormaLegal = $("#cmbTipBaseLegal option:selected").text();
        var SiglaNormaLegal="";
        var lenNorma=NormaLegal.length;
        var posCaracter=NormaLegal.indexOf("-");
        var siglaDesc=NormaLegal.substring(posCaracter+2,lenNorma);
        SiglaNormaLegal= siglaDesc;

        var Numero = $("#txtNumBaseLegal").val();
        var NumeroValidado;
        if (Numero == null) {
            NumeroValidado = "";
        } else {
            NumeroValidado = " N° " + Numero;
        }

        var Ano = $("#txtAnioBaseLegal").spinner("value");
        var AnoValidado;
        if (Ano == null) {
            AnoValidado = "";
        } else {
        	// OSINE_SFS-600 - REQF-0001 - Inicio
        	if(Ano<=1999){
        		var valido = Ano.toString().substring(2);
        		Ano=valido;
        	}
        	// OSINE_SFS-600 - REQF-0001 - Fin
            AnoValidado = "-" + Ano;
        }

        var Sigla = $("#cmbSigBaseLegal option:selected").text();
        var SiglaValidado;
        if (Sigla == '--Seleccione--') {
            SiglaValidado = "";
        } else {
            SiglaValidado = "-" + Sigla;
        }

        var Articulo = $("#txtArtBaseLegal").val();
        var ArticuloValidado;
        if (Articulo == "") {
            ArticuloValidado = "";
        } else {
            ArticuloValidado = " " + "Art. N° " + Articulo+",";
        }

        var Inciso1 = $("#txtInc1BaseLegal").val();
        var Inciso1Validado;
        var Letra1;
        Letra1 = Inciso1.charAt(0);
        if (Inciso1 == "") {
            Inciso1Validado = "";
        } else {
            if (isNaN(Letra1)) {
            	// OSINE_SFS-600 - REQF-0005 - Inicio
                //Inciso1Validado = " Lit. " + Inciso1+",";
            	Inciso1Validado = " lit. " + Inciso1+",";
                // OSINE_SFS-600 - REQF-0005 - Inicio
            } else {
            	// OSINE_SFS-600 - REQF-0005 - Inicio
                //Inciso1Validado = " Num. " + Inciso1+",";
                Inciso1Validado = " num. " + Inciso1+",";
                // OSINE_SFS-600 - REQF-0005 - Inicio
            }
        }

        var Inciso2 = $("#txtInc2BaseLegal").val();
        var Inciso2Validado;
        var Letra2;
        Letra2 = Inciso2.charAt(0);
        if (Inciso2 == "") {
            Inciso2Validado = "";
        } else {
            if (isNaN(Letra2)) {
            	// OSINE_SFS-600 - REQF-0005 - Inicio
                //Inciso2Validado = " Lit. " + Inciso2+",";
                Inciso2Validado = " lit. " + Inciso2+",";
                // OSINE_SFS-600 - REQF-0005 - Inicio
            } else {
            	// OSINE_SFS-600 - REQF-0005 - Inicio
                //Inciso2Validado = " Num. " + Inciso2+",";
            	Inciso2Validado = " num. " + Inciso2+",";
                // OSINE_SFS-600 - REQF-0005 - Fin
            }
        }
        var TipoAnexo = $("#cmbTipAneBaseLegal option:selected").text();
        var TipoAnexoValidado;
        // Inicio MYC-7 Cambio de Alcance
        var NumeroAnexo ="";
        var ValorNumeroAnexo="";
        // Fin MYC-7 Cambio de Alcance
        if (TipoAnexo == '--Seleccione--') {
            TipoAnexoValidado = "";
        } else {
        	// Inicio MYC-7 Cambio de Alcance
        	if($('#cmbNumeroAnexo option:selected').text()!='--Seleccione--'){
            	ValorNumeroAnexo = $('#cmbNumeroAnexo option:selected').text();
            	NumeroAnexo = " N° " + ValorNumeroAnexo + " ";
            	TipoAnexoValidado = " " + TipoAnexo + NumeroAnexo + " aprobado por ";
            }else{
            	TipoAnexoValidado = " " + TipoAnexo + " aprobado por ";
            }
            // Fin MYC-7 Cambio de Alcance
        	// Inicio MYC-7 Cambio de Alcance
//        	TipoAnexoValidado = " " + TipoAnexo + " aprobado por ";
        	// Fin MYC-7 Cambio de Alcance
        }

        var ArticuloAnexo = $("#txtArtAneBaseLegal").val();
        var ArticuloAnexoValidado;
        var Letra5 = ArticuloAnexo.charAt(0);
        if (ArticuloAnexo == "") {
            ArticuloAnexoValidado = "";
        } else {
            ArticuloAnexoValidado = "Art. N° " + ArticuloAnexo+",";
        }


        var Inciso3 = $("#txtInc3BaseLegal").val();
        var Inciso3Validado;
        var Letra3;
        Letra3 = Inciso3.charAt(0);
        if (Inciso3 == "") {
            Inciso3Validado = "";
        } else {
            if (isNaN(Letra3)) {
            	// OSINE_SFS-600 - REQF-0005 - Inicio
                //Inciso3Validado = " Lit. " + Inciso3+",";
                Inciso3Validado = " lit. " + Inciso3+",";
                // OSINE_SFS-600 - REQF-0005 - Inicio
            } else {
            	// OSINE_SFS-600 - REQF-0005 - Inicio
                //Inciso3Validado = " Num. " + Inciso3+",";
            	Inciso3Validado = " num. " + Inciso3+",";
                // OSINE_SFS-600 - REQF-0005 - Fin
            }
        }
        var Inciso4 = $("#txtInc4BaseLegal").val();
        var Inciso4Validado;
        var Letra4;
        Letra4 = Inciso4.charAt(0);
        if (Inciso4 == "") {
            Inciso4Validado = "";
        } else {
            if (isNaN(Letra4)) {
            	// OSINE_SFS-600 - REQF-0005 - Inicio
                //Inciso4Validado = " Lit. " + Inciso4+",";
            	Inciso4Validado = " lit. " + Inciso4+",";
            	// OSINE_SFS-600 - REQF-0005 - Fin
            } else {
            	// OSINE_SFS-600 - REQF-0005 - Inicio
                //Inciso4Validado = " Num. " + Inciso4+",";
            	Inciso4Validado = " num. " + Inciso4+",";
                // OSINE_SFS-600 - REQF-0005 - Fin
            }
        }
        

        //jsifuentes inicio
        var dataTblNormaTecnica = $('#tblNormaTecnica').getGridParam('data');
        var cadena = "";
        $.each(dataTblNormaTecnica,function(k,v){
            cadena += v.descripcionIdTipoNormaTecnica + " "+ v.descripcionNorma + " ";
        });
        
        var NormaTecnica = $("#cmbNorTecBaseLegal option:selected").text();
        var NormaTecnicaValidada="";
        if (cadena != '') {
        	NormaTecnicaValidada = " de acuerdo a lo establecido en ";
        }
        //jsifuentes fin
        
//        var DescripcionNormaTecnica = $("#txtDesNorTecBaseLegal").val();
        var DescripcionNormaTecnica = cadena;
        
        var ModificatoriasValidado;
        if ($("#chkModificatoria").is(":checked")) {
            ModificatoriasValidado = " y Modificatorias";
        } else {
            ModificatoriasValidado = "";
        }

        var listaBasesLegalesConcordanciaArray= new Array();
        var DescripcionConcordanciaValidada;
        if ($('#chkConcordancia').attr('checked')) {
        	var dataGridConcordancia=$('#gridObligConcordancia').find('td[aria-describedby=gridObligConcordancia_descripcionGeneralBaseLegal]');
        	i=0;
        	dataGridConcordancia.map(function(){
        		i++;
        		listaBasesLegalesConcordanciaArray[i]="\n"+ ">"+$(this).attr('title') ;
        	});
        	listaBasesLegalesConcordanciaArray.splice(0, 1);
//        	var row = $('#gridObligConcordancia').jqGrid('getRowData', rowid);
//            descripcionBaseLegalConcordancia=row.descripcionGeneralBaseLegal;
        	
            DescripcionConcordanciaValidada = " en Concordancia con: " + listaBasesLegalesConcordanciaArray;
        } else {
            DescripcionConcordanciaValidada = "";
        }
        var concatenado;
        if (Articulo == "" && TipoAnexo == "--Seleccione--" && NormaTecnica == "--Seleccione--") {
            concatenado = SiglaNormaLegal + NumeroValidado + AnoValidado + SiglaValidado + ModificatoriasValidado + DescripcionConcordanciaValidada;
        } else if (Articulo != "" && TipoAnexo == "--Seleccione--" && NormaTecnica == "--Seleccione--") {
            concatenado = ArticuloValidado + Inciso1Validado + Inciso2Validado + " de " +
                    SiglaNormaLegal + NumeroValidado + AnoValidado + SiglaValidado + ModificatoriasValidado + DescripcionConcordanciaValidada;
        } else if (Articulo == "" && TipoAnexo != "--Seleccione--" && NormaTecnica == "--Seleccione--") {
            concatenado = ArticuloAnexoValidado + Inciso3Validado + Inciso4Validado + " del " + TipoAnexoValidado + SiglaNormaLegal +
                    NumeroValidado + AnoValidado + SiglaValidado + ModificatoriasValidado + DescripcionConcordanciaValidada;
        } else if (Articulo == "" && TipoAnexo == "--Seleccione--" && NormaTecnica != "--Seleccione--") {
            concatenado = SiglaNormaLegal + NumeroValidado + AnoValidado + SiglaValidado + ModificatoriasValidado
                    + NormaTecnicaValidada + DescripcionNormaTecnica + DescripcionConcordanciaValidada;
        } else if (Articulo == "" && TipoAnexo != "--Seleccione--" && NormaTecnica != "--Seleccione--") {
            concatenado = ArticuloAnexoValidado + Inciso3Validado + Inciso4Validado + " del " +  TipoAnexoValidado +
                    SiglaNormaLegal + NumeroValidado + AnoValidado + SiglaValidado + ModificatoriasValidado
                    + NormaTecnicaValidada + DescripcionNormaTecnica + DescripcionConcordanciaValidada;
        } else if (Articulo != "" && TipoAnexo != "--Seleccione--" && NormaTecnica != "--Seleccione--") {
            concatenado = ArticuloAnexoValidado + Inciso3Validado + Inciso4Validado + " del " + TipoAnexoValidado +
                    //ArticuloValidado + Inciso1Validado + Inciso2Validado + " de " +
                    SiglaNormaLegal + NumeroValidado + AnoValidado + SiglaValidado + ModificatoriasValidado
                    + NormaTecnicaValidada + DescripcionNormaTecnica + DescripcionConcordanciaValidada;
        } else if (Articulo != "" && TipoAnexo != "--Seleccione--" && NormaTecnica == "--Seleccione--") {
            concatenado = ArticuloAnexoValidado + Inciso3Validado + Inciso4Validado + " del " + TipoAnexoValidado +
                    //ArticuloValidado + Inciso1Validado + Inciso2Validado + " de " +
                    SiglaNormaLegal + NumeroValidado + AnoValidado + SiglaValidado + ModificatoriasValidado + DescripcionConcordanciaValidada;
        } else if (Articulo != "" && TipoAnexo == "--Seleccione--" && NormaTecnica != "--Seleccione--") {
            concatenado = ArticuloValidado + Inciso1Validado + Inciso2Validado + " de " +
                    SiglaNormaLegal + NumeroValidado + AnoValidado + SiglaValidado + ModificatoriasValidado +
                    NormaTecnicaValidada + DescripcionNormaTecnica + DescripcionConcordanciaValidada;
        } else {
            concatenado = "";
        }
        if(flagBaseLegal=="ver"){
        	concatenado = "";
        }
        $("#txtDesConcatenado").val(concatenado);
        $('#txtDesConcatenadoOculto').val(concatenado);
    }

    function mostrarCrearObligacion() {
        //chkCrearOblig.attr('value',1);
    	nuevoBL.txtCodigoObligacion.attr('disabled', 'disabled');
        $('#divCrearObligacionUnica').css("display","block");
        $('#tab2').css("display","block");
        $('#chkConcordancia').attr('checked', false);
        $('#chkModificatoria').attr('checked', false);
        $('#txtDesConBaseLegal').css("display","none");
        $('#tabNewBaseLegal').tabs({active: 1});
        $('#codBaseLegal').val($('#txtCodBaseLegal').val());
        $('#subgrid').val('1');
    }
    /** Funciones Inicializadoras - Deshabilitar **/
    
    function inicializarFormularioBaseLegal(){
//    	alert("Inicio");
    	deshabilitarCabeceraBaseLegal();
    	
    }
    
    function deshabilitarCabeceraBaseLegal(){
//    	alert(0);
    	deshabilitarArticuloBaseLegal();
    	deshabilitarListadoBaseLegal();
        deshabilitarDescripcionBaseLegal();
        
//        nuevoBL.txtArticuloNormaLegal.attr('disabled','disabled');
        
    	nuevoBL.txtCodigoBaseLegal.attr('disabled', 'disabled');
    	nuevoBL.txtNumeroNormaLegal.attr('disabled', 'disabled');
        nuevoBL.txtAnioNormaLegal.spinner({disabled: true});
        nuevoBL.cmbSiglaNormaLegal.attr('disabled', 'disabled');
        nuevoBL.dateFechaVigenciaNormaLegal.attr('disabled', 'disabled');
        nuevoBL.dateFechaPublicacionNormaLegal.attr('disabled', 'disabled');
        nuevoBL.txtTituloNormaLegal.attr('disabled', 'disabled');
        /* modificado jpiro 20150106 - inicio */
        //nuevoBL.divAdjuntarImagenBaseLegal.css("display","none");
        validaVerAdjuDocuBaseLegal();
        /* modificado jpiro 20150106 - fin */
    }
    
    function deshabilitarArticuloBaseLegal(){
    	if(nuevoBL.txtNumeroNormaLegal.val()==''){
    		nuevoBL.txtArticuloNormaLegal.attr('disabled','disabled');
    	}
    	nuevoBL.txtIncisoUnoNormaLegal.attr('disabled', 'disabled');
    	nuevoBL.txtIncisoDosNormaLegal.attr('disabled', 'disabled');
    	nuevoBL.dateFechaVigenciaArtNormaLegal.attr('disabled', 'disabled');
    	deshabilitarAnexoBaseLegal();
    	deshabilitarNormaTecnicaBaseLegal();
    	deshabilitarListadoObligacion();
    }
    
    function deshabilitarAnexoBaseLegal(){
//    	alert(2);    	
    	nuevoBL.cmbTipoAnexoNormaLegal.attr('disabled', 'disabled');
    	nuevoBL.txtArticuloAnexoNormaLegal.attr('disabled', 'disabled');
    	nuevoBL.txtIncisoUnoAnexoNormaLegal.attr('disabled', 'disabled');
    	nuevoBL.txtIncisoDosAnexoNormaLegal.attr('disabled', 'disabled');
    	nuevoBL.dateFechaVigenciaAnexoNormaLegal.attr('disabled', 'disabled');
    	/*Rsis 1 - Inicio*/
    	nuevoBL.cmbNumeroAnexo.attr('disabled', 'disabled');
    	/*Rsis 1 - Fin*/    	
    	
    }
    
    function deshabilitarNormaTecnicaBaseLegal(){
    	nuevoBL.cmbTipoNormaTecnica.attr('disabled', 'disabled');
    	nuevoBL.txtDescripcionNormaTecnica.attr('disabled', 'disabled');
    }
    
    function deshabilitarListadoObligacion(){

    	nuevoBL.chkObligacion.attr('disabled', 'disabled');
    }
    
    function deshabilitarListadoBaseLegal(){

    	nuevoBL.chkConcordancia.attr('disabled', 'disabled');
        nuevoBL.chkModificatoria.attr('disabled', 'disabled');
    }
    
    function deshabilitarDescripcionBaseLegal(){

    	nuevoBL.txtDescripcionGeneralNormaLegal.attr('disabled', 'disabled');
    }
    
    /** Funciones de Validacion del Formulario Base Legal **/
    function validaComportamientoRegistroBaseLegal(){
    	var retorno=new Boolean(false);
    	retorno=validaComboTipoNormaLegal(retorno);
    	if(retorno){

    		changeComboTipoNormaLegalTrue(retorno);
    	}else{
//    		changeComboTipoNormaLegalFalse(retorno);

    	}
    	
    }
    
    function validaComboTipoNormaLegal(retorno){

    	if ($('#cmbTipBaseLegal option:selected').text() == '--Seleccione--') {	
    		retorno=false;
    	}else{	retorno=true;	}
    	return retorno;
    }
    
    function changeComboTipoNormaLegalFalse(retorno){

    			limpiarCamposMantenimientoBaseLegal();
                deshabilitarCabeceraBaseLegal();
				nuevoBL.txtNumeroNormaLegal.attr('disabled', 'disabled');
                nuevoBL.txtAnioNormaLegal.spinner({disabled: true});
                nuevoBL.cmbSiglaNormaLegal.attr('disabled', 'disabled');
                nuevoBL.dateFechaVigenciaNormaLegal.attr('disabled', 'disabled');
                nuevoBL.dateFechaPublicacionNormaLegal.attr('disabled', 'disabled');
                nuevoBL.txtTituloNormaLegal.attr('disabled', 'disabled');
                /* modificado jpiro 20150106 - inicio */
                //nuevoBL.divAdjuntarImagenBaseLegal.css("display","none");
                validaVerAdjuDocuBaseLegal();
                /* modificado jpiro 20150106 - fin */
//                concatenaDescripcionBaseLegal();//Funcion: Genera Descripcion
    }
    
    function changeComboTipoNormaLegalTrue(retorno){
    	nuevoBL.txtNumeroNormaLegal.removeAttr('disabled');
    	nuevoBL.txtAnioNormaLegal.spinner({disabled: false});
    	nuevoBL.cmbSiglaNormaLegal.removeAttr('disabled');
    	nuevoBL.dateFechaVigenciaNormaLegal.removeAttr('disabled');
    	nuevoBL.dateFechaPublicacionNormaLegal.removeAttr('disabled');
    	nuevoBL.txtTituloNormaLegal.removeAttr('disabled');
        /* modificado jpiro 20150106 - inicio */
        //nuevoBL.divAdjuntarImagenBaseLegal.css("display","inline-block");
        validaVerAdjuDocuBaseLegal();
        /* modificado jpiro 20150106 - fin */
        validaNumeroBaseLegal(retorno);
//        concatenaDescripcionBaseLegal();//Funcion: Genera Descripcion
    }
    
    function validaNumeroBaseLegal(retorno){
    	nuevoBL.txtNumeroNormaLegal.keyup(function() {
    		if (nuevoBL.txtNumeroNormaLegal.val() != "") {
    			validaNumeroBaseLegalTrue(retorno);
            } else {
            	retorno=false;
            	validaNumeroBaseLegalFalse(retorno);
            }
        });
    	return retorno;
    }
    
    /*
     * @autor jpiro 20150105
     * @description evalua si el boton de Adjuntar archivo para Base Legal debe ser mostrado
     * @param {type} retorno
     * @returns {undefined}
     */
    function validaVerAdjuDocuBaseLegal(){
        if($('#cmbTipBaseLegal').val()>0 && $.trim($('#txtArtBaseLegal').val())=='' ){
            nuevoBL.divAdjuntarImagenBaseLegal.css("display","inline-block");
        }else{
            nuevoBL.divAdjuntarImagenBaseLegal.css("display","none");
        }
    }
    
    function validaNumeroBaseLegalTrue(retorno){
//    	alert(14);
    	if(flagBaseLegal=="editar"){
    		nuevoBL.txtArticuloNormaLegal.removeAttr('disabled');
    		nuevoBL.chkModificatoria.removeAttr('disabled');
            nuevoBL.chkConcordancia.removeAttr('disabled');
          
    		validaArticuloBaseLegal(retorno);
//            concatenaDescripcionBaseLegal();//Funcion: Genera Descripcion
    		
    	}else{
    		nuevoBL.txtArticuloNormaLegal.removeAttr('disabled');
            nuevoBL.chkModificatoria.removeAttr('disabled');
            nuevoBL.chkConcordancia.removeAttr('disabled');
//            nuevoBL.txtAnioNormaLegal.val('');
//        	nuevoBL.cmbSiglaNormaLegal.val('');
//        	nuevoBL.dateFechaVigenciaNormaLegal.val('');
//        	nuevoBL.dateFechaPublicacionNormaLegal.val('');
//        	nuevoBL.txtTituloNormaLegal.val('');
            
            validaArticuloBaseLegal(retorno);
//            concatenaDescripcionBaseLegal();//Funcion: Genera Descripcion
    	}
    	
    }
    function validaNumeroBaseLegalFalse(retorno){
//    	alert(15);
//    	nuevoBL.txtArticuloNormaLegal.attr('disabled', 'disabled');
//    	nuevoBL.chkModificatoria.attr('checked', false);
//      	nuevoBL.chkConcordancia.attr('checked', false);
      	
//      	deshabilitarArticuloBaseLegal();
//      	deshabilitarListadoBaseLegal();
//        limpiarArticulo();
//        concatenaDescripcionBaseLegal();//Funcion: Genera Descripcion
        
    }
    
    function validaArticuloBaseLegal(retorno){
    	nuevoBL.txtArticuloNormaLegal.keyup(function() {
            /* modificado jpiro 20150106 - inicio */
            validaVerAdjuDocuBaseLegal();
            /* modificado jpiro 20150106 - fin */
    		if (nuevoBL.txtArticuloNormaLegal.val() != "") {
    			validaArticuloBaseLegalTrue(retorno);
    			$('#txtidNivelArticulo').val('1');
    		} else {
    			retorno=false;
    			validaArticuloBaseLegalFalse(retorno);
    			$('#txtidNivelArticulo').val('0');
            }
            return retorno;
        });
    }

    function validaArticuloBaseLegalTrue(retorno){
    	validaIncisoArticuloBaseLegal(retorno);
    	validaComboTipoAnexoBaseLegal(retorno);
    	validaComboTipoNormaTecnica(retorno);
    	
    	nuevoBL.txtIncisoUnoNormaLegal.removeAttr('disabled');
    	
    	nuevoBL.cmbTipoAnexoNormaLegal.removeAttr('disabled');
    	/*Rsis 11 - Inicio*/
    	nuevoBL.cmbNumeroAnexo.removeAttr('disabled');
    	/*Rsis 11 - Fin*/
    	nuevoBL.cmbTipoNormaTecnica.removeAttr('disabled');
    	nuevoBL.chkObligacion.removeAttr('disabled');
    	nuevoBL.divNormaArticuloNormaLegal.css("display","block");
    	if($('#cmbTipAneBaseLegal option:selected').text() == '--Seleccione--'){
    		nuevoBL.dateFechaVigenciaArtNormaLegal.removeAttr('disabled');
    	}
    	
    	concatenaDescripcionBaseLegal();//Funcion: Genera Descripcion
   
    }
    
    function validaIncisoArticuloBaseLegal(retorno){
    	nuevoBL.txtIncisoUnoNormaLegal.keyup(function() {
            if (nuevoBL.txtIncisoUnoNormaLegal.val() != "") {
            	validaIncisoArticuloBaseLegalTrue(retorno);
            } else {
            	retorno=false;
            	validaIncisoArticuloBaseLegalFalse(retorno);
            }
        });
    }
    
    function validaIncisoArticuloBaseLegalTrue(retorno){
//    	alert(17);
    	nuevoBL.txtIncisoDosNormaLegal.removeAttr('disabled');
    	
    	concatenaDescripcionBaseLegal();//Funcion: Genera Descripcion
    }
    function validaIncisoArticuloBaseLegalFalse(retorno){
//    	alert(18);
    	nuevoBL.txtIncisoDosNormaLegal.attr('disabled', 'disabled');
    	nuevoBL.txtIncisoDosNormaLegal.val('');
    	concatenaDescripcionBaseLegal();//Funcion: Genera Descripcion
    }
        
    function validaArticuloBaseLegalFalse(retorno){
//    	deshabilitarArticuloBaseLegal();
    	nuevoBL.txtIncisoUnoNormaLegal.attr('disabled', 'disabled');
    	nuevoBL.txtIncisoDosNormaLegal.attr('disabled', 'disabled');
        limpiarArticulo();        
      concatenaDescripcionBaseLegal();
    }
    
    function validaComboTipoAnexoBaseLegal(retorno){
    	nuevoBL.cmbTipoAnexoNormaLegal.change(function() {
    		if ($('#cmbTipAneBaseLegal option:selected').text() == '--Seleccione--') {
            	retorno=false;
            	nuevoBL.dateFechaVigenciaArtNormaLegal.removeAttr('disabled');
            	validaComboTipoAnexoBaseLegalFalse(retorno);
            	$('#cmbNumeroAnexo').css("display","none");
            	$('#lblNumeroAnexo').css("display","none");
            } else {
            	nuevoBL.dateFechaVigenciaArtNormaLegal.val('');
        		nuevoBL.dateFechaVigenciaArtNormaLegal.attr('disabled','disabled');
            	validaComboTipoAnexoBaseLegalTrue(retorno);
            	$('#lblNumeroAnexo').css("display","inline-block");
            	$('#cmbNumeroAnexo').css("display","inline-block");	
            }    		
            
        });
    	return retorno;
    }
    
    function validaComboTipoAnexoBaseLegalTrue(retorno){
//    	alert(19);
    	nuevoBL.divAnexoNormaLegal.css("display","block");
        nuevoBL.txtArticuloAnexoNormaLegal.removeAttr('disabled', 'disabled');
        nuevoBL.dateFechaVigenciaAnexoNormaLegal.removeAttr('disabled', 'disabled');

        validaArticuloAnexoBaseLegal(retorno);
        
        concatenaDescripcionBaseLegal();
    	
    }
    
    function validaArticuloAnexoBaseLegal(retorno){
    	nuevoBL.txtArticuloAnexoNormaLegal.keyup(function() {
            if (nuevoBL.txtArticuloAnexoNormaLegal.val() != "") {
            	validaArticuloAnexoBaseLegalTrue(retorno);
            } else {
            	retorno=false;
            	validaArticuloAnexoBaseLegalFalse(retorno);
            }
        });
    }
    
    function validaArticuloAnexoBaseLegalTrue(retorno){
//    	alert(20);
    	nuevoBL.txtIncisoUnoAnexoNormaLegal.removeAttr('disabled');
    	validaIncisoAnexoBaseLegal(retorno);
    	
    	concatenaDescripcionBaseLegal();
    	
    }
    
    function validaArticuloAnexoBaseLegalFalse(retorno){
//    	alert(21);
    	nuevoBL.txtIncisoUnoAnexoNormaLegal.attr('disabled', 'disabled');
        nuevoBL.txtIncisoDosAnexoNormaLegal.attr('disabled', 'disabled');
        nuevoBL.txtIncisoUnoAnexoNormaLegal.val("");
        nuevoBL.txtIncisoDosAnexoNormaLegal.val("");
        
        concatenaDescripcionBaseLegal();
    }
    
    function validaIncisoAnexoBaseLegal(retorno){
    	nuevoBL.txtIncisoUnoAnexoNormaLegal.keyup(function() {
            if (nuevoBL.txtIncisoUnoAnexoNormaLegal.val() != "") {
            	validaIncisoAnexoBaseLegalTrue(retorno);
            } else {
            	retorno=false;
            	validaIncisoAnexoBaseLegalFalse(retorno);
            }
        });
    }
    
    function validaIncisoAnexoBaseLegalTrue(retorno){
//    	alert(22);
    	nuevoBL.txtIncisoDosAnexoNormaLegal.removeAttr('disabled');
    	
    	concatenaDescripcionBaseLegal();
    }
    function validaIncisoAnexoBaseLegalFalse(retorno){
//    	alert(23);
    	nuevoBL.txtIncisoDosAnexoNormaLegal.attr('disabled', 'disabled');
    	nuevoBL.txtIncisoDosAnexoNormaLegal.val('');
    	
    	concatenaDescripcionBaseLegal();
    }
    
    function validaComboTipoAnexoBaseLegalFalse(retorno){
//    	alert(24);
    	nuevoBL.divAnexoNormaLegal.css("display","none");
    	nuevoBL.txtArticuloAnexoNormaLegal.val("");
    	nuevoBL.txtIncisoUnoAnexoNormaLegal.val("");
    	nuevoBL.txtIncisoDosAnexoNormaLegal.val("");
    	nuevoBL.dateFechaVigenciaAnexoNormaLegal.val("");
    	
    	concatenaDescripcionBaseLegal();
    }
    
    function validaComboTipoNormaTecnica(retorno){
//    	alert(25);
    	$("#cmbNorTecBaseLegal").change(function() {
    		var num = $('#cmbNorTecBaseLegal option:selected').text();
    		if (num == '--Seleccione--') {
    			nuevoBL.txtDescripcionNormaTecnica.css("display","none");
    			nuevoBL.txtDescripcionNormaTecnica.attr('disabled','disabled');
    			nuevoBL.txtDescripcionNormaTecnica.val('');
    			
    			
    			$("#btnAgregarNormaTecnica").css("display","none");
    			concatenaDescripcionBaseLegal();
    		} else{
    			nuevoBL.txtDescripcionNormaTecnica.css("display","inline-block");
    			nuevoBL.txtDescripcionNormaTecnica.removeAttr('disabled');
    			
    			$("#btnAgregarNormaTecnica").css("display","inline-block");
    			concatenaDescripcionBaseLegal();
    		}
    	});
    }
    
    function limpiarCamposMantenimientoBaseLegal(){
    	limpiarCabecera();
    }
    
    function limpiarCabecera(){
//    	alert(50);
    	nuevoBL.txtNumeroNormaLegal.val('');
    	nuevoBL.txtAnioNormaLegal.val('');
    	nuevoBL.cmbSiglaNormaLegal.val('');
    	nuevoBL.dateFechaVigenciaNormaLegal.val('');
    	nuevoBL.dateFechaPublicacionNormaLegal.val('');
    	nuevoBL.txtTituloNormaLegal.val('');
    	
//    	limpiarArticulo();
    	limpiarListadoObligacion();
    	limpiarDescripcion();
    }
    
    function limpiarArticulo(){
//    	alert(51);
    	nuevoBL.txtArticuloNormaLegal.val('');
    	nuevoBL.txtIncisoUnoNormaLegal.val('');
    	nuevoBL.txtIncisoDosNormaLegal.val('');
    	nuevoBL.dateFechaVigenciaArtNormaLegal.val('');
    	nuevoBL.divNormaArticuloNormaLegal.css("display","none");
    	
//    	limpiarAnexo();
//    	limpiarNormaTecnica();
//    	limpiarConcordancia();
    }
    
    function limpiarAnexo(){
//    	alert(52);
    	nuevoBL.cmbTipoAnexoNormaLegal.val('');
    	nuevoBL.txtArticuloAnexoNormaLegal.val('');
    	nuevoBL.txtIncisoUnoAnexoNormaLegal.val('');
    	nuevoBL.txtIncisoDosAnexoNormaLegal.val('');
    	nuevoBL.dateFechaVigenciaAnexoNormaLegal.val('');
    	nuevoBL.divAnexoNormaLegal.css("display","none");
    }
    
    function limpiarNormaTecnica(){
//    	alert(53);
    	nuevoBL.cmbTipoNormaTecnica.val('');
    	nuevoBL.txtDescripcionNormaTecnica.val('');
    	nuevoBL.txtDescripcionNormaTecnica.hide('');
    }
    function limpiarListadoObligacion(){
//    	alert(54);
    	nuevoBL.chkObligacion.attr('checked',false);
    	nuevoBL.divListadoObligacion.css("display","none");
    }
    function limpiarConcordancia(){
//    	alert(55);
    	nuevoBL.chkModificatoria.attr('checked',false);
    	nuevoBL.chkConcordancia.attr('checked',false);
    	nuevoBL.divListadoBasesLegalesConcordancia.css("display","none");
    }
    function limpiarDescripcion(){
//    	alert(56);
    	nuevoBL.txtDescripcionGeneralNormaLegal.val('');
    }
    
    function generaDescripcionEvento(){
    	nuevoBL.txtAnioNormaLegal.keyup(function(){
    		concatenaDescripcionBaseLegal();
    	});
    	nuevoBL.cmbSiglaNormaLegal.change(function(){
    		concatenaDescripcionBaseLegal();
    	});
    	
    	nuevoBL.txtIncisoDosNormaLegal.keyup(function(){
    		concatenaDescripcionBaseLegal();
    	});
    	
    	nuevoBL.txtIncisoDosAnexoNormaLegal.keyup(function(){
    		concatenaDescripcionBaseLegal();
    	});
    	
    	nuevoBL.txtDescripcionNormaTecnica.keyup(function(){
    		concatenaDescripcionBaseLegal();
    	});
    	
    	nuevoBL.chkModificatoria.change(function(){
    		concatenaDescripcionBaseLegal();
    	});
    	
    	nuevoBL.chkConcordancia.change(function(){
    		concatenaDescripcionBaseLegal();
    	});
    	
    	nuevoBL.dateFechaVigenciaAnexoNormaLegal.change(function(){

    	});
    	
    	
    }

    return{
    	eliminarBaseLegal:eliminarBaseLegal,
    	concatenaDescripcionBaseLegal:concatenaDescripcionBaseLegal,
    	validaNumeroBaseLegal:validaNumeroBaseLegal,
    	validaArticuloBaseLegal:validaArticuloBaseLegal,
    	validaComboTipoAnexoBaseLegal:validaComboTipoAnexoBaseLegal,
    	validaArticuloAnexoBaseLegal:validaArticuloAnexoBaseLegal,
    	validaComboTipoNormaTecnica:validaComboTipoNormaTecnica,
    	validaComportamientoRegistroBaseLegal:validaComportamientoRegistroBaseLegal,
    	verBaseLegalCompleta:verBaseLegalCompleta,
    	editarBaseLegalCompleta:editarBaseLegalCompleta,
    	inicializarFormularioBaseLegal:inicializarFormularioBaseLegal,
        deshabilitarVerBaseLegal:deshabilitarVerBaseLegal,
        generaCodigoObligacion: generaCodigoObligacion,
        habilitarMantenimientoBaseLegal: habilitarMantenimientoBaseLegal,
        constructor: constructor,
        evaluaDetalle:evaluaDetalle,
        cerrarMantenimientoBaseLegal:cerrarMantenimientoBaseLegal,
        confirmaRegistroObligacion:confirmaRegistroObligacion,
        abrirPopUpConfirmacionRegistroObligacion:abrirPopUpConfirmacionRegistroObligacion,
        guardaEditarRegistroBaseLegal:guardaEditarRegistroBaseLegal,
        confirmaRegistroBaseLegal:confirmaRegistroBaseLegal,
        modoVisualizacion:modoVisualizacion,
        confirmEliminarBaseLegal:confirmEliminarBaseLegal,
        obtenerNormaPadre:obtenerNormaPadre,
        validaComboTipoAnexoBaseLegalTrue:validaComboTipoAnexoBaseLegalTrue,
        validaComboTipoAnexoBaseLegalFalse:validaComboTipoAnexoBaseLegalFalse
    };
})();

var nuevaObligacionNormativa = (function() {
    var codEliminarTipificacion;
    var codEliminarCriterio;
    var descEliminarSancionEspecifica;
    var modoVisualizacion;
    function models() {
        $("#dialogCargarNuevaOblNor").dialog({//Model(Cabecera Obligacion Normativa) >> Inicializa Model-dialog >>PopUp Subir Archivo
            resizable: false,
            autoOpen: false,
            height: "150",
            width: "550",
            dialogClass: 'dialog',
            modal: true,
            title: 'Subir Archivo'
        });
        $("#dialogDescGuiaOblNor").dialog({//Model(Detalle Obligacion Normativa) >> Inicializa Model-dialog >>PopUp Subir Archivo
            resizable: false,
            autoOpen: false,
            height: "auto",
            width: "auto",
            dialogClass: 'dialog',
            modal: true,
            title: 'SUBIR ARCHIVO'
        });
        $("#dialogPauta").dialog({
            resizable: false,
            autoOpen: false,
            height: "auto",
            width: "auto",
            dialogClass: 'dialog',
            modal: true,
            title: 'CRITERIO',
            beforeClose: function(event, ui) { 
                nuevaObligacionNormativa.limpiandoDatosCriterios();
                return true;
            }
        });
        $("#dialogCriterios").dialog({
            resizable: false,
            autoOpen: false,
            height: "auto",
            width: "auto",
            dialogClass: 'dialog',
            modal: true,
            title: 'CRITERIO',
            beforeClose: function(event, ui) { 
                return true;
            }
        });
        $('#dialogAsignarArbolActividades').dialog({
            resizable: false,
            draggable: false,
            autoOpen: true,
            height: "auto",
            width: "auto",
            dialogClass: 'dialogNuevo',
            modal: true,
            close: function(event, ui) {
                $(this).dialog("destroy");
                $(this).remove();
            }
        });
        $("#dialogCargarArchivoDescripcion").dialog({//Model(Archivo Descripcion) >> Inicializa Model-dialog >>PopUp Subir Archivo
            resizable: false,
            autoOpen: false,
            height: "150",
            width: "550",
            dialogClass: 'dialog',
            modal: true,
            title: 'Subir Archivo'
        });
        /*Rsis 11 - Inicio*/
        $("#dialogCargarArchivoInfraccion").dialog({//Model(Archivo Descripcion) >> Inicializa Model-dialog >>PopUp Subir Archivo
            resizable: false,
            autoOpen: false,
            height: "150",
            width: "550",
            dialogClass: 'dialog',
            modal: true,
            title: 'Subir Archivo'
        });
        /*Rsis 11 - Fin*/        
        $("#dialogDependenciaCriterio").dialog({
            resizable: false,
            autoOpen: false,
            height: "auto",
            width: "auto",
            dialogClass: 'dialog',
            modal: true,
            title: 'Dependencias para Criterios'
        });
    }
    /**
     * 
     * @returns {undefined}
     */
    function initArbolActividades() {
    	/** Listado de Actividades **/        
        var treeDataActividad=[];
        $.ajax({
            url: baseURL + 'pages/actividadesController/loadActividadConfigurada',
            type: "post",
            async: false,
            data: {},
            //beforeSend:muestraLoading,
            success: function(data) {
                //ocultaLoading();
            	if(data.filas!=null){
            		treeDataActividad = fxTreeActividad.build(data.filas);
            	}
            	
            },
            error:errorAjax
        });
        
        $("#divAsignarArbolActividades").fancytree({
            checkbox: true,
            selectMode: 1,
            source:treeDataActividad,
            select: function(event, data) {
                var selKeys = $.map(data.tree.getSelectedNodes(), function(node) {
                    if (!node.folder) {
                        return "{id:'" + node.key + "',nombre:'" + node.title + "'}";
                    }
                });
                //obtener Nodes
                var selRootNodes = data.tree.getSelectedNodes(true);
                //obtener keys
                var selRootKeys = $.map(selRootNodes, function(node) {
                    return node.key;
                });
                $("#inputCodigoActividad").val(selRootKeys.join(", "));//inserta key en input
                //obtener titles
                var selRootNames = $.map(selRootNodes, function(node) {
                    return node.title;
                });
                $("#inputDescActividad").val(selRootNames.join(", "));//inserta title

                if (selKeys.length !== 0) {} else {}
            },
            keydown: function(event, data) {
                if (event.which === 32) {
                    data.node.toggleSelected();
                    return false;
                }
            },
            //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
            //initId: "treeData",
            cookieId: "fancytree-Cb2",
            idPrefix: "fancytree-Cb2-"
        });

        $("#divAsignarArbolActividades").fancytree("getRootNode").visit(function(node) {
            node.setExpanded(true);
        });
        
        $('#divAsignarArbolActividades').find('.fancytree-has-children').find('.fancytree-checkbox').hide();
        /** Fin Listado de Actividades */
    }
    /**
     * 
     * @returns {undefined}
     */
    function constructor() {
        
        var tipificacion = {
            allowNumeric  : true,
            allowLatin    : false,
            allowUpper    : false,
            allowLower    : false,
            allowCaseless : true,
            allowOtherCharSets : false,
            allowSpace    : false,
            allow         : '.'
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
        var descripcionObligacion = {
                allowNumeric  : true,
                allowLatin    : true,
                allowUpper    : true,
                allowLower    : true,
                allowCaseless : true,
                allowOtherCharSets : true,
                allowSpace    : true,
                allow         : '!@#$%^&*()+=[]\\\;,/{}|":<>?~`.- _'
        };
        
        $('#nueva_DescripcionPauta').alphanum(descripcion);
        $('#nueva_Pauta').alphanum(descripcion);
        $('#nueva_TituloPauta').alphanum(descripcion);
        $('#txtTipifOblNor').alphanum(tipificacion);
        $('#txtDesOblNor').alphanum(charAllow);
        $('#txtDesNorTecBaseLegal').alphanum(descripcionObligacion);
    
        /*iconos de botones configurar*/
//        $('#btnAsociarActividadStepUno').puibutton({icon: 'ui-icon-triangle-1-e'});
//        $('#btnAsociarActividadStepDos').puibutton({icon: 'ui-icon-triangle-1-e'});
//        $('#btnAsociarActividadStepDosRegresar').puibutton({icon: 'ui-icon-triangle-1-w'});
//        $('#btnAsociarActividadStepTresRegresar').puibutton({icon: 'ui-icon-triangle-1-w'});
//        $('#btnAsociarActividadStepTres').puibutton({icon: 'ui-icon-triangle-1-e'});
//        $('#btnAsociarActividadStepCuatroRegresar').puibutton({icon: 'ui-icon-triangle-1-w'});
//        $('#btnGuardarRelacionStepCuatroRegresar').puibutton({icon: 'ui-icon-disk'});
        /**/
//        $('#btnAsociaNuevaBaseLegal').puibutton({icon: 'ui-icon-document'});
//        nuevoBL.btnAbrirPopUpPauta.puibutton({icon: 'ui-icon-document'});
        $('#btnSancionEspecifica').puibutton({icon: 'ui-icon-plus'});
        $('#btnSancionEspecifica').click(cargarSancionesEspecificas);
        $('#btnSancionEspecificaAgrega').click(cargarSancionesEspecificas);
//        procesarGridAsociaBaseLegal();
        gridTipificacion();

//        initArbolActividades();
        models();
        nuevoBL.divTabDetalleObligacion.tabs();//Div(Detalle Obligacion Normativa) Tab >> Inicializa Tab  
        nuevoBL.txtSancionTipificacionObligacion.spinner(//Input(Sancion Monetaria de la Tipificacion) Spinner >> Inicializa Spinner y Parametros
                {min: 0},
        {max: 300},
        {disabled: true}
        );
        nuevoBL.btnAbrirPopUpImagenObligacion.click(abrirPopUpSubirArchivoObligacion);
        nuevoBL.btnAbrirPopUpImagenDescripcion.click(abrirPopUpSubirArchivoDescripcion);
        /*Rsis 11 - Inicio*/
        nuevoBL.btnAbrirPopUpImagenInfraccion.click(abrirPopUpSubirArchivoInfraccion);
        /*Rsis 11 - Fin*/
        nuevoBL.btnCerrarPopUpImagenObligacion.click(cerrarPopUpSubirArchivoObligacion);
        nuevoBL.btnGuardarImagenObligacion.click(guardarArchivoObligacion);
        nuevoBL.btnGuardarImagenDescripcion.click(guardarArchivoDescripcion);
        /*Rsis 11 - Inicio*/
        nuevoBL.btnGuardarImagenInfraccion.click(guardarArchivoInfraccion);        
        /*Rsis 11 - Fin*/
        nuevoBL.btnAbrirPopUpImagenGuia.click(abrirPopUpSubirArchivoObligacionGuia);
        nuevoBL.btnCerrarPopUpImagenGuia.click(cerrarPopUpSubirArchivoObligacionGuia);
        nuevoBL.btnGuardarImagenGuia.click(guardarArchivoObligacionGuia);
        nuevoBL.btnAbrirPopUpPauta.click(abrirPopUpSubirArchivoObligacionPauta);
        nuevoBL.btnCerrarPopUpPauta.click(cerrarPopUpSubirArchivoObligacionPauta);
        nuevoBL.btnCerrarPopDependenciaCriterio.click(cerrarPopUpDependenciaCriterio);
        nuevoBL.btnGuardarFileCriterio.click(guardarArchivoCriterio);
        //nuevoBL.txtCodigoTipificacionObligacion.keyup(comparaValor);
//        nuevoBL.txtCodigoTipificacionObligacion.keyup(obtenerTipificacion);
        nuevoBL.txtDescripcionObligacion.keyup(copiarDescripcion);
        nuevoBL.btnGuardarImagenPauta.click(guardarCriterio);
        nuevoBL.btnAgregarTipificacion.click(agregarTipificacion);
        /*Rsis 14 - Inicio*/
        nuevoBL.btnAgregarIncumplimiento.click(agregarIncumplimiento);
        /*Rsis 14 - Fin*/
        nuevoBL.btnAsociarBaseLegal.click(function() {
            ///////////////
            var idsBaseLegalAsociarBaseLegal = "";
            var allRowsGrid = $("#gridAsociaBasesLegales").getRowData();
            if($("#txtidBaseLegal").val() != ""){
                idsBaseLegalAsociarBaseLegal = $("#txtidBaseLegal").val();
            }
            if(allRowsGrid.length != undefined ){
                for(var x = 0; x<allRowsGrid.length; x++){
                    idsBaseLegalAsociarBaseLegal += "," + allRowsGrid[x].idBaseLegal;
                }
                idsBaseLegalAsociarBaseLegal = idsBaseLegalAsociarBaseLegal.substring(0, idsBaseLegalAsociarBaseLegal.length); 
            }
            if(idsBaseLegalAsociarBaseLegal == ""){
                idsBaseLegalAsociarBaseLegal = "0";
            }
            ///////////////
            variable=0;
            
            validaNuevaBaseLegal.asociaObligacion(variable, idsBaseLegalAsociarBaseLegal);
            document.getElementById('frmNuevaOblNorm').onsubmit = function() {
                return false;
            };
        });
        //Grids Historicos
        iniciarConfigurarSupervision();
        nuevoBL.btnConfigurarSupervisionPrimerPaso.click(configurarPrimerPaso);
        nuevoBL.btnConfigurarSupervisionSegundoPaso.click(configurarSegundoPaso);
        nuevoBL.btnConfigurarSupervisionTercerPaso.click(configurarTercerPaso);
        nuevoBL.btnConfigurarSupervisionGuardar.click(configurarGuardarCnf);

        nuevoBL.btnConfigurarSupervisionRegresarSegundoPaso.click(configurarBtnRegresarSegundoPaso);
        nuevoBL.btnConfigurarSupervisionRegresarTercerPaso.click(configurarBtnRegresarTercerPaso);
        nuevoBL.btnConfigurarSupervisionRegresarCuartoPaso.click(configurarBtnRegresarCuartoPaso);
        nuevoBL.divSubirCriterio.tabs({active: 0});
        nuevoBL.txtProductosObligacion.click(abrirPopUpArbolProductosObligacion);
        nuevoBL.txtTransportesObligacion.click(abrirPopUpArbolTransportesObligacion);
        nuevoBL.btnAgregarDescripcionNormativa.click(agregarDescripcionNormativa);
        /*Rsis 11 - Inicio*/
        nuevoBL.btnGuardarInfraccion.click(agregarDescripcionInfraccion);
        /*Rsis 11 - Fin*/
        nuevoBL.btnGuardarRelacionObligacion.click(function(){registrarRelacionesObligacion();});

        nuevoBL.imgMuestraImagenArchivoDescripcion.click(function(){
//            var url = "";
//            alert('imgMuestraImagenArchivoDescripcion');
//            alert($('#idObligacion').val());
            var nombreArchivo = "";
            var rutaAlfresco = "";
//            if($('#idObligacion').val() == ""){
                $('#lnkDownloadArchivoDescripcion').attr('href',baseURL +'pages/mantenimiento/baseLegal/descargaArchivoDescripcion');
//                        href = baseURL +'pages/mantenimiento/baseLegal/descargaArchivoDescripcion';
//                alert($('#lnkDownloadArchivoDescripcion').attr("href"));
//                $('#lnkDownloadArchivoDescripcion').click();
//            }else{
//                $('#lnkDownloadArchivoDescripcion').href = baseURL +'pages/documentoAdjunto/descargaArchivoAlfresco?nombreArchivo='+nombreArchivo+'&rutaAlfresco='+rutaAlfresco;
//            }
            
        });
        nuevoBL.txtFileCriterio.change(function(event){
            var nombreArchivo = this.files[0].name;
            var img = new Image();
            img.src = URL.createObjectURL(this.files[0]);
            img.onload = function() {
                var validarCriterio = $('#divMensajeValidacionCriterioArchivo');
                if(this.width > 100 || this.height > 100){
                    validarCriterio.show();
                    validarCriterio.focus();
                    validarCriterio.html("* El tamaño de la imagen no corresponde con la permitida ( 100 x 100)");
                    //Limpiando archivo adjunto
                    document.getElementById('file_Pauta').value = "";
                    document.getElementById('formPauta').reset();
                }else{
                    validarCriterio.hide();
                    validarCriterio.html("");
                    document.getElementById('file_Pauta').value = nombreArchivo;
                }
            };
        }); 
        $("#formPauta").ajaxForm({
            dataType : 'json',
            async: false,
            resetForm : true,
            success : function(data) {
                if (data != null && data.error != null) {
                    enviarDatosArchivoCriterio(data);
                }						
            }
        });
        
        definirObtenerTipificaciones();
        $('#btnEliminarObligacion').click(function(){
        	var idObligacion=$('#idObligacion').val();
        	validaNuevaBaseLegal.confirmEliminarObligacion(idObligacion);
        	//cambia tab
        	
        });
        $('#idObligacion').val(-1);
    }
    
    ////////////////////// Funciones Tipificacion //////////////////////////////
    /**
     * Comment
     */
    function obtenerTipificacion(idTipificacion) {
        var URL = baseURL + "pages/mantenimiento/baseLegal/obtenerTipificacion";
        $.getJSON(URL, {
            idTipificacion: idTipificacion,
            ajax: 'true'
        }, function(data) {
            if(data.resultado == 0){
                nuevoBL.txtDescripcionTipificacionOblig.val('');
                nuevoBL.txtSancionTipificacionObligacion.val('');
                nuevoBL.txtBaseLegalTipificacionObligacion.val('');
                $(".chkTipoSancion").attr('checked', false);
            
                nuevoBL.txtIdTipificacion.val(data.tipificacion.idTipificacion);
                nuevoBL.txtDescripcionTipificacionOblig.val(data.tipificacion.descripcion);
                nuevoBL.txtSancionTipificacionObligacion.val(data.tipificacion.sancionMonetaria);
                nuevoBL.txtBaseLegalTipificacionObligacion.val(data.tipificacion.basesLegales);
                var html='';
                for(var x = 0; x < data.tipificacion.listaTipificacionSancion.length;x++){
                    var idTipoSancion = data.tipificacion.listaTipificacionSancion[x].idTipoSancion;
                    var descripcionSancion = data.tipificacion.listaTipificacionSancion[x].tipoSancion.descripcion;   
                    
                    html += '<div style="float:left; margin-right:10px; width:215px;">';
                    html += '<input id="rdProcesoT' + idTipoSancion + '" type="checkbox" name="proceso" value="' + idTipoSancion + '" class="checkbox" checked  disabled />';
                    html += '<label for="rdProcesoT' + idTipoSancion + '" class="checkbox">' + descripcionSancion + '</label>';
                    html += '</div>';
                }
                $('#divTipSan').html(html);
                $("#divTipSan").css('display','inline-block');
            }else{
            	var html='';
            	$('#divTipSan').html(html);
            }
        });
    }
    ////////////////////////////////////////////////////////////////////////////
    
    function configurarGuardarCnf(){
    	$.ajax({
            url: baseURL + "pages/mantenimiento/baseLegal/registrarConfiguracionObligacion",
            type: 'post',
            async: false,
            dataType:'json',
            data: {
                idObligacion: $('#idObligacion').val(),
                idRubro: $('#inputCodigoActividad').val(),
                idProceso: $('#inputTipoProceso').val(),
                idObligacionTipo:$('#inputObligacionTipo').val(),
                codTrazabilidad:$('#codTrazabilidad').val()
            },
            beforeSend: muestraLoading,
            success: function(data) {
            	
            	$('#tabTipi').css('display',"");
            	
            	for (var i = 0; i < data.countOpc; i++) {
        		var opciones=data["opcion"+i];
        		if(opciones=="ID_SANCION") {$('#tabSanciones').css('display',"");   } 
				if(opciones=="ID_REF_B_L") {$('#tabRef').css('display',""); } 
				if(opciones=="ID_DESCRP") {$('#tabDescr').css('display',"");   } 
				if(opciones=="ID_MED_SEG") {$('#tabMedSeg').css('display',"");   } 
				if(opciones=="ID_TEMAS") {$('#tabRelac').css('display',"");   } 
            	}
            	
                if (data.resultado == 0) {
                    ocultaLoading();
                    mensajeGrowl('success',data.mensaje);
                    ocultaLoading();
                    configurarBtnRegresarSegundoPaso();
                    nuevoBL.divConfigurarSupervision.puitabview('disable', 3);
                    
                } else if (data.resultado == 1) {
                	mensajeGrowl("error", data.mensaje);
                    ocultaLoading();
                }
            },
            error: errorAjax
        });
    	nuevaObligacionNormativa.gridConfiguracionObligacion();//llamar Grod Configuracion
    }
    
    function registrarRelacionesObligacion(){
    	$.ajax({
            url: baseURL + "pages/mantenimiento/baseLegal/registrarRelacionObligacion",
            type: 'post',
            async: false,
            data: {
                idObligacion: $('#idObligacion').val(),
                idCriticidad:$('#cmbCriOblNor').val(),
                idTemas:$('#inputCodigoTemas').val(),
                codTrazabilidad:$('#codTrazabilidad').val()
            },
            beforeSend: muestraLoading,
            success: function(data) {
                if (data.resultado == 0) {
                    ocultaLoading();
                    mensajeGrowl('success',data.mensaje);
                    ocultaLoading();
                } else if (data.resultado == 2) {
                    muestraDivError("divMensajeValidacion", data.mensaje, "");
                    ocultaLoading();
                } else if (data.resultado == 1) {
                	mensajeGrowl('error', data.mensaje);
                    ocultaLoading();
                } 
            },
            error: errorAjax
        });
    }
    
    function cargarSancionesEspecificas(){
        agregarDetalleCriterio();
    }
    function agregarDetalleCriterio(){
        var validarCriterio;
        validarCriterio = $('#formNuevaTipificacion').validateAllForm('#divMensajeValidacionTipificacion');
        var idCriterio = $('#codigoCriterio').val();
        if(idCriterio == "" || idCriterio == null){
            idCriterio = -1;
        }
        if(validarCriterio){
            $.ajax({
                url: baseURL + "pages/mantenimiento/baseLegal/registrarSancionEspecifica",
                type: 'post',
                async: false,
                data: {
                    descSancionEspecifica: $('#nueva_Pauta').val(),
                    idCriterio: idCriterio,
                    codTrazabilidad:$('#codTrazabilidad').val()
                },
                beforeSend: muestraLoading,
                success: function(data) {
                    if (data.resultado == 0) {
                        ocultaLoading();
                        gridListadoSancionesEspecificas();
                        $('#nueva_Pauta').val("");
                    } else if (data.resultado == 1) {
                        muestraDivError("divMensajeValidacion", data.mensaje, "");
                        ocultaLoading();
                    } else {
                        mensajeGrowl('error', "Error en el insertar", 'Intente de nuevo');
                        ocultaLoading();
                    }
                },
                error: errorAjax
            });
        }
    }
    /**
     * 
     * @param {type} parametro
     * @returns {data.codObligacionEditar|Number}
     */
//    function consultaAjax(parametro) {
//        var auxt = 0;
//        $.ajax({
//            url: baseURL + "pages/mantenimiento/baseLegal/generaCodigoObligacion",
//            type: "get",
//            async: true,
//            data: {valor:parametro
//            },
//            success: function(data) {
//                auxt = data.codObligacion;
//                $('#txtCodOblVer').val(auxt);
//                $('#txtCodOblNor').val(auxt);
//                $('#txtCodObl').val(auxt);
//                gestionBaseLegal.evaluaDetalle();
//            }
//        });
//        
//        return auxt;
//    }
    /**
     * 
     */
    function consultarObligacion(idObligacion,mode){
    	$("#tabSupervision a").click();
        $.ajax({
            url: baseURL + "pages/mantenimiento/baseLegal/consultarObligacionNormativa",
            type: 'post',
            async: true,
            data: { idObligacion:idObligacion
            },
            success: function(data) {
           
            $('#tabTipi').css('display',"");
            	for (var i = 0; i < data.countOpc; i++) {
                		
        		var opciones=data["opcion"+i];
				if(opciones=="ID_SANCION") {$('#tabSanciones').css('display',"");   } 
				if(opciones=="ID_REF_B_L") {$('#tabRef').css('display',""); } 
				if(opciones=="ID_DESCRP") {$('#tabDescr').css('display',"");   } 
				if(opciones=="ID_MED_SEG") {$('#tabMedSeg').css('display',"");   } 
				if(opciones=="ID_TEMAS") {$('#tabRelac').css('display',"");   } 
				
            	}
            	//gridIncumplimiento();
            	if(mode==1){            		
            		editarObligacion(data,mode);// 05-11-2015	
            		cargaInicial.obtenerTipificacionToCriterio($('#idObligacion').val());
            		gridIncumplimiento();
            	}else if(mode==0){
            		mostrarObligacion(data,mode);
            		gridIncumplimiento();
            	}
            }
        });
    }
    
    function mostrarObligacion(data,mode){
    	$('#lblCodigo').css('display','inline-block');//muestra label codigo
    	$('#txtCodOblNor').css('display','inline-block');//muestra codigo
    	$('#btnEliminarObligacion').css('display','none');//ocultar Boton Eliminar Obligacion
    	//Estilos VER
    	nuevoBL.txtCodigoObligacion.attr('disabled', 'disabled');
    	nuevoBL.txtDescripcionObligacion.attr('disabled', 'disabled');
    	nuevoBL.cmbCriticidadObligacion.attr('disabled', 'disabled');
    	nuevoBL.btnGuardarObligacion.css('display','none');//oculta boton guardar
    	$('#imgCarOblNor').css('display','none');//oculta subir archivo
    	$('#lblDocAdjExtOblNor').css('display','none');//oculta subir archivo
    	//Estilos VER --> Tipificación
    	$('#tipificacionEditarObligacion').css('display','none');
    	//Estilos VER --> Criterio
    	$('#criterioObligacionEditar').css('display','none');
    	//Estilos VER --> Descripciones
    	nuevoBL.txtDescripcionActaObligacion.attr('disabled', 'disabled');
    	$('#btnAgregarDescripcion').css('display','none');
    	//Estilos VER --> Asociar Base Legal
    	$('#asociaObligacionEditar').css('display','none');
    	//Estilos VER --> Configuración
    	nuevoBL.divConfigurarSupervision.css('display','none');
    	//Estilos VER --> Relaciones
    	nuevoBL.btnGuardarRelacionObligacion.css('display','none');
    	
    	$('#divContenidoTipificacion').css('display','none');
    	$('#btnAgregarTipificacion').css('display','none');
    	$('#btnAgregarIncumplimiento').css('display','none');
    	$('#btnSubirDocumentoAdjuntoDetalleInfraccion').css('display','none');
    	$('#btnGuardarInfraccion').css('display','none');
    	$('#btnSubirDocumentoAdjuntoDetalle').css('display','none');
    	
    	//Estilo cambio de Tab
    	$('#tabNewBaseLegal').tabs("enable",1);
        $('#tabNewBaseLegal').tabs({active: 1});
        $('#tabNewBaseLegal').tabs("disable",0);
    	//Cabecera
        $('#idObligacion').val(data.obligacion.idObligacion);
        $('#txtCodObl').val(data.obligacion.codigoObligacion);
        $('#txtCodOblNor').val(data.obligacion.codigoObligacion);
        nuevoBL.txtDescripcionObligacion.val(data.obligacion.descripcionObligacion);
        $('#cmbHideCriticidadObligacion').val(data.obligacion.criticidadObligacion);
        cargaInicial.obtenerCriticidadObligacion();
        
        //Configuraciones
        nuevaObligacionNormativa.gridConfiguracionObligacion();
        //Referenciar Base Legal
    	nuevaObligacionNormativa.procesarGridAsociaBaseLegal();
    	//Tipificaciones
    	nuevaObligacionNormativa.recargarGriTipificacion();
        nuevaObligacionNormativa.recargarGridCriterios();
    	//Relaciones
        $('#inputCodigoTemas').val(data.listaTema);
//        $("#divArbolTemasObligacion").fancytree({enabled:true});
        listarTemasByIdObligacion(data.obligacion.idObligacion);
    	$("#divArbolTemasObligacion").fancytree("disable");
    	gestionBaseLegal.evaluaDetalle();
    	document.getElementById("divDownloadImg").innerHTML="";
    	document.getElementById("divDownloadDetalleImg").innerHTML="";
    	document.getElementById("divDownloadDetalleImgInfraccion").innerHTML="";    	
    	if(data.obligacion.idDocumentoAdjunto!=null){
    		var nombreArchivo=data.documento.nombreArchivo;
    		var rutaAlfresco=data.documento.rutaAlfresco;
        	document.getElementById("divDownloadImg").innerHTML="";
        	$('#divDownloadImg').append('<a class="link" href="'+baseURL + 'pages/documentoAdjunto/descargaArchivoAlfresco?aplicacionSpace=OBLIGACIONES&nombreArchivo='+nombreArchivo+'&rutaAlfresco='+rutaAlfresco+'"><img class="vam" width="20" height="24" src="'+baseURL+'images/stickers.png"></a>');

    	}
    	//Detalle Descripción
        if(data.detalleObligacion!=null){
        	$('#idDetalleObligacion').val(data.detalleObligacion.idDetalleObligacion);
        	$('#txtDescObligacionNormativaActa').val(data.detalleObligacion.descripcion);	
        	if(data.documentoDetalle!=null){
        		if(data.documentoDetalle.idDocumentoAdjunto!=null){
            		var nombreArchivo=data.documentoDetalle.nombreArchivo;
            		var rutaAlfresco=data.documentoDetalle.rutaAlfresco;
            		document.getElementById("divDownloadDetalleImg").innerHTML="";
                    $('#divDownloadDetalleImg').append('<a class="link" href="'+baseURL + 'pages/documentoAdjunto/descargaArchivoAlfresco?aplicacionSpace=OBLIGACIONES&nombreArchivo='+nombreArchivo+'&rutaAlfresco='+rutaAlfresco+'"><img class="vam" width="20" height="24" src="'+baseURL+'images/stickers.png"></a>');
            	}
        	}
        	
        }else{
        	$('#idDetalleObligacion').val('');
        	$('#txtDescObligacionNormativaActa').val('');
        }
        //Infraccion
        if(data.idInfraccion!=null){
        	$('#idInfraccion').val(data.idInfraccion.idInfraccion);
        	$('#txtDescInfraccion').val(data.idInfraccion.descripcionInfraccion);
        	$('#cmbMedidaSeguirdad').val(data.idInfraccion.idMedidaSeguridadMaestro);
        	$('#cmbAccionInfraccion').val(data.idInfraccion.idAccionMaestro);
        	if(data.idInfraccion.documentoAdjuntoDTO!=null){
        		var nombreArchivo=data.idInfraccion.documentoAdjuntoDTO.nombreArchivo;
        		var rutaAlfresco=data.idInfraccion.documentoAdjuntoDTO.rutaAlfresco;
        		document.getElementById("divDownloadDetalleImgInfraccion").innerHTML="";
                $('#divDownloadDetalleImgInfraccion').append('<a class="link" href="'+baseURL + 'pages/documentoAdjunto/descargaArchivoAlfresco?aplicacionSpace=OBLIGACIONES&nombreArchivo='+nombreArchivo+'&rutaAlfresco='+rutaAlfresco+'"><img class="vam" width="20" height="24" src="'+baseURL+'images/stickers.png"></a>');
        	}
        }
        else{
        	$('#idInfraccion').val('');
        	$('#txtDescInfraccion').val('');        	
        	/* OSINE_SFS-610 - Inicio */
        	//$('#cmbMedidaSeguirdad').val('-1');
        	//$('#cmbAccionInfraccion').val('-1');
        	/* OSINE_SFS-610 - Fin */
        	document.getElementById("divDownloadDetalleImgInfraccion").innerHTML="";
        	$('#contenedorImgMedidaSeguridad').remove();
        }
                
        
       }
    
    function editarObligacion(data,mode){
    	$('#lblCodigo').css('display','inline-block');//muestra label codigo
    	$('#txtCodOblNor').css('display','inline-block');//muestra codigo
    	$('#btnEliminarObligacion').css('display','inline-block');
    	//Estilos EDITAR
    	nuevoBL.txtCodigoObligacion.attr('disabled', 'disabled');
    	nuevoBL.txtDescripcionObligacion.removeAttr('disabled');
    	nuevoBL.cmbCriticidadObligacion.removeAttr('disabled');
    	nuevoBL.btnGuardarObligacion.css('display','inline-block');//muestra boton guardar
    	$('#imgCarOblNor').css('display','inline-block');//muestra subir archivo
    	$('#lblDocAdjExtOblNor').css('display','inline-block');//muestra subir archivo
    	//Estilos EDITAR --> Tipificación
    	$('#tipificacionEditarObligacion').css('display','block');
    	//Estilos EDITAR --> Criterio
    	$('#criterioObligacionEditar').css('display','block');
    	//Estilos EDITAR --> Descripciones
    	nuevoBL.txtDescripcionActaObligacion.removeAttr('disabled');
    	$('#btnAgregarDescripcion').css('display','inline-block');
    	//Estilos EDITAR --> Asociar Base Legal
    	$('#asociaObligacionEditar').css('display','block');
    	//Estilos EDITAR --> Configuración
    	nuevoBL.divConfigurarSupervision.css('display','block');
    	//Estilos EDITAR --> Relaciones
    	nuevoBL.btnGuardarRelacionObligacion.css('display','inline-block');
    	$('#divDocumentoAdjuntoDetalle').css('display','block');
    	//Estilo cambio de Tab
    	$('#tabNewBaseLegal').tabs("enable",1);
        $('#tabNewBaseLegal').tabs({active: 1});
        $('#tabNewBaseLegal').tabs("disable",0);
    	//Cabecera
        $('#idObligacion').val(data.obligacion.idObligacion);
        $('#txtCodObl').val(data.obligacion.codigoObligacion);
        $('#txtCodOblNor').val(data.obligacion.codigoObligacion);
        $('#txtDesOblNor').val(data.obligacion.descripcionObligacion);
        $('#cmbHideCriticidadObligacion').val(data.obligacion.criticidadObligacion);
        /*Rsis 14 - Inicio*/        
        $('#idInfraccion').val(data.idInfraccion);
        /*Rsis 14 - Inicio*/
        cargaInicial.obtenerCriticidadObligacion();
        
        //Configuraciones
        nuevaObligacionNormativa.gridConfiguracionObligacion();
        nuevaObligacionNormativa.initArbolActividades();
        //Referenciar Base Legal
    	nuevaObligacionNormativa.procesarGridAsociaBaseLegal();
    	//Tipificaciones
    	nuevaObligacionNormativa.recargarGriTipificacion();
        nuevaObligacionNormativa.recargarGridCriterios();
    	//Relaciones
        $('#inputCodigoTemas').val(data.listaTema);
        
    	listarTemasByIdObligacion(data.obligacion.idObligacion);//Recarga Arbol Temas Marcado
    	$("#divArbolTemasObligacion").fancytree("enable");

    	gestionBaseLegal.evaluaDetalle();
    	document.getElementById("divDownloadImg").innerHTML="";
    	document.getElementById("divDownloadDetalleImg").innerHTML="";
    	document.getElementById("divDownloadDetalleImgInfraccion").innerHTML="";
    	if(data.obligacion.idDocumentoAdjunto!=null){
    		var nombreArchivo=data.documento.nombreArchivo;
    		var rutaAlfresco=data.documento.rutaAlfresco;
        	document.getElementById("divDownloadImg").innerHTML="";
        	$('#divDownloadImg').append('<a class="link" href="'+baseURL + 'pages/documentoAdjunto/descargaArchivoAlfresco?aplicacionSpace=OBLIGACIONES&nombreArchivo='+nombreArchivo+'&rutaAlfresco='+rutaAlfresco+'"><img class="vam" width="20" height="24" src="'+baseURL+'images/stickers.png"></a>');

    	}
    	
    	//Detalle Descripción
        if(data.detalleObligacion!=null){
        	$('#idDetalleObligacion').val(data.detalleObligacion.idDetalleObligacion);
        	$('#txtDescObligacionNormativaActa').val(data.detalleObligacion.descripcion);	
        	if(data.documentoDetalle!=null){
        		if(data.documentoDetalle.idDocumentoAdjunto!=null){
            		var nombreArchivo=data.documentoDetalle.nombreArchivo;
            		var rutaAlfresco=data.documentoDetalle.rutaAlfresco;
            		document.getElementById("divDownloadDetalleImg").innerHTML="";
                    $('#divDownloadDetalleImg').append('<a class="link" href="'+baseURL + 'pages/documentoAdjunto/descargaArchivoAlfresco?aplicacionSpace=OBLIGACIONES&nombreArchivo='+nombreArchivo+'&rutaAlfresco='+rutaAlfresco+'"><img class="vam" width="20" height="24" src="'+baseURL+'images/stickers.png"></a>');
            	}
        	}
        	
        }else{
        	$('#idDetalleObligacion').val('');
        	$('#txtDescObligacionNormativaActa').val('');
        }
        /*Rsis 16 - Inicio*/
        //Infraccion
        $('#cmbEscenario').val('-1');
        if(data.idInfraccion!=null){
        	$('#idInfraccion').val(data.idInfraccion.idInfraccion);
        	$('#txtDescInfraccion').val(data.idInfraccion.descripcionInfraccion);
        	$('#cmbMedidaSeguirdad').val(data.idInfraccion.idMedidaSeguridadMaestro);
        	$('#cmbAccionInfraccion').val(data.idInfraccion.idAccionMaestro);
        	if(data.idInfraccion.documentoAdjuntoDTO!=null){
        		var nombreArchivo=data.idInfraccion.documentoAdjuntoDTO.nombreArchivo;
        		var rutaAlfresco=data.idInfraccion.documentoAdjuntoDTO.rutaAlfresco;
        		document.getElementById("divDownloadDetalleImgInfraccion").innerHTML="";
                $('#divDownloadDetalleImgInfraccion').append('<a class="link" href="'+baseURL + 'pages/documentoAdjunto/descargaArchivoAlfresco?aplicacionSpace=OBLIGACIONES&nombreArchivo='+nombreArchivo+'&rutaAlfresco='+rutaAlfresco+'"><img class="vam" width="20" height="24" src="'+baseURL+'images/stickers.png"></a>');
        	}
        }
        else{
        	$('#idInfraccion').val('');
        	$('#txtDescInfraccion').val('');
        	/* OSINE_SFS-610 - Inicio */
        	//$('#cmbMedidaSeguirdad').val('-1');
        	//$('#cmbAccionInfraccion').val('-1');
        	/* OSINE_SFS-610 - Fin */        	
        	document.getElementById("divDownloadDetalleImgInfraccion").innerHTML="";
        	$('#contenedorImgMedidaSeguridad').remove();        	
        	
        }
        $('#divContenidoTipificacion').css('display','inline-block');
    	$('#btnAgregarTipificacion').css('display','inline-block');
    	$('#btnAgregarIncumplimiento').css('display','inline-block');
    	$('#btnSubirDocumentoAdjuntoDetalleInfraccion').css('display','inline-block');
    	$('#btnGuardarInfraccion').css('display','inline-block');
    	$('#btnSubirDocumentoAdjuntoDetalle').css('display','inline-block');
        /*Rsis 16 - Fin*/
        
    }
    
    function listarTemasByIdObligacion(idObligacion){
    	/**  Inicia Listado de Temas **/
    	
    	//Consulta y Retorna Listado de Temas
    	var treeData=[];
        $.ajax({
            url: baseURL + 'pages/mantenimiento/baseLegal/obtenerTemaObligacion',
            type: "post",
            async: false,
            data: {idObligacion:idObligacion},
            //beforeSend:muestraLoading,
            success: function(data) {
                //ocultaLoading();
                treeData = fxTreeTema.build(data.filas);
            },
            error:errorAjax
        });
        
        //Inicializa el Arbol de Temas de Obligacion
        $("#divArbolTemasObligacion").fancytree({
            checkbox: true,
            selectMode: 3,
            source:treeData,
            select: function(event, data) {
                var selKeys = $.map(data.tree.getSelectedNodes(), function(node) {
                    if (!node.folder) {
                        return "{id:'" + node.key + "',nombre:'" + node.title + "'}";
                    }
                });

                var selRootNodes = data.tree.getSelectedNodes(true);
                var selRootKeys = $.map(selRootNodes, function(node) {
                    return node.key;
                });

                $("#inputCodigoTemas").val(selRootKeys.join(", "));
                if (selKeys.length !== 0) {
                } else {
                }
            },
            keydown: function(event, data) {
                if (event.which === 32) {
                    data.node.toggleSelected();
                    return false;
                }
            },
            //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
            //initId: "treeData",
            cookieId: "fancytree-Cb10",
            idPrefix: "fancytree-Cb10-"
        });

        
      //recarga el arbol con la data
        ($("#divArbolTemasObligacion").fancytree("getTree")).reload(treeData).done(function(){ });
        
//        $("#divArbolTemasObligacion").fancytree("getRootNode").visit(function(node) {
//            node.setExpanded(true);
//        });
    }
    /**
     * 
     */
    function gridConfiguracionObligacion(){
    	var nombres = [' ',' ',' ','Rubros', 'Proceso','Obligaciones Tipo'];
        var columnas = [{name: "idConfObligacion", width: 220,hidden:true ,sortable: false, align: "center"},
            {name: "idProOblTip", width: 220,hidden:true ,sortable: false, align: "center"},
            {name: "idActividad", width: 220,hidden:true ,sortable: false, align: "center"},
            {name: "nombreActividad", width: 320, sortable: false, align: "center"},
            {name: "nombreProceso", width: 120, sortable: false, align: "center"},
            {name: "descripcionObligacionTipo", width: 430, sortable: false, align: "center"}
        ];
        $("#gridCnfOblg").html("");
        var grid = $("<table>", {"id": "gridCnfOblgacion"});
        var pager = $("<div>", { "id": "pagConfg" });
        $("#gridCnfOblg").append(grid).append(pager);
        grid.jqGrid({
        	url: baseURL + "pages/mantenimiento/baseLegal/listarConfObligacion",
            datatype: "json",
            postData: {idObligacion:$('#idObligacion').val(),varLista:1},
            hidegrid: false,
            rowNum: 5,
            pager: "#pagConfg",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
//            autoHeight: true,
            viewrecords: false,
            //caption: "",
            width: '865px',
            jsonReader: {
                root: "filas",
                page: "pagina",
                total: "total",
                records: "registros",
                id:"idConfObligacion"
            },
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                var row = grid.jqGrid('getRowData', rowid);
                $('#linkEliminarCnf').attr('onClick', 'nuevaObligacionNormativa.eliminarConfiguracionConfirm("' + rowid + '")');
                
                if($('#divEnlaceTagEliminarConfiguracionObligacion input').html()!=null){
                    $('#contextCnfOblg li a[value="EL-GRIDCONFIGURACIONOBLIGACION"]').html($('#divEnlaceTagEliminarConfiguracionObligacion').html());               
                }else {
                 	  $('#contextCnfOblg li a[value="EL-GRIDCONFIGURACIONOBLIGACION"]').remove();
                 	 $('#contextCnfOblg').parent().css('opacity',0);
                }
            },
            loadComplete: function(data) {
            	$('#contextCnfOblg').parent().css('opacity',1);
                $('#contextCnfOblg').parent().remove();
                if(nuevaObligacionNormativa.modoVisualizacion != modoVer){
                    $('#divContextCnfOblg').html("<ul id='contextCnfOblg'>"
                    		+"<li> <a value='EL-GRIDCONFIGURACIONOBLIGACION'></a></li>"
//                            + "<li> <a id='linkEliminarCnf' data-icon='ui-icon-trash' title='Eliminar Configuración'>Eliminar</a></li>"
                            + "</ul>");
                    $('#contextCnfOblg').puicontextmenu({
                        //target: $('#gridObligacionNormativa').find('tr').not('.ui-subgrid,.ui-subgrid tr')
                        target: $('#gridCnfOblgacion')
                    });                    
                }
            }
        });
    }
    function eliminarConfiguracionConfirm(rowid){
    	/* modif jpiro 20150106 - ini */
        confirm.start();
        /* modif jpiro 20150106 - fin */
        /* OSINE_SFS-610 - Inicio */
        //confirm.open("¿Ud est&aacute; seguro de eliminar la configuracion ?",
        confirm.open("¿Ud est&aacute; seguro de eliminar la configuraci&oacute;n ?",
        /* OSINE_SFS-610 - Fin */
                "nuevaObligacionNormativa.eliminarConfiguracion('" + rowid + "')");
    }
    function eliminarConfiguracion(rowid){
        var row = $('#gridCnfOblgacion').jqGrid('getRowData', rowid);
        idConfEliminar=row.idConfObligacion;
        getEliminarConfiguracion(idConfEliminar);
    }
    function getEliminarConfiguracion(idConfEliminar) {
        var URL = baseURL + "pages/mantenimiento/baseLegal/eliminarConfiguracionObligacion";
        /* OSINE_SFS-610 - Inicio */
        //$.get(URL,{idConfObligacion:idConfEliminar,codTrazabilidad:$('#codTrazabilidad').val()}, function(data) {
        $.get(URL,{idObligacion: $('#idObligacion').val(),idConfObligacion:idConfEliminar,codTrazabilidad:$('#codTrazabilidad').val()}, function(data) {
        	
        	$('#tabTipi').css('display',"");
        	var sancion=0;
        	var referencia=0;
        	var descripcion=0;
        	var medida=0;
        	var temas=0;
        	if(!(data.countOpcActualizar==undefined)){
        		for (var i = 0; i < data.countOpcActualizar; i++) {
    	    		var opciones=data["opcionActualizar"+i];
    	    		if(sancion==0){
    	    			if(opciones=="ID_SANCION") {$('#tabSanciones').css('display',"");   sancion=1;} else { $('#tabSanciones').css('display',"none"); }
    	    		}
    	    		if(referencia==0){
    	    			if(opciones=="ID_REF_B_L") {$('#tabRef').css('display',""); referencia=1;} else { $('#tabRef').css('display',"none"); }
    	    		}
    	    		if(descripcion==0){
    					if(opciones=="ID_DESCRP") {$('#tabDescr').css('display',""); descripcion=1;} else { $('#tabDescr').css('display',"none"); }
    	    		}
    	    		if(medida==0){
    					if(opciones=="ID_MED_SEG") {$('#tabMedSeg').css('display',"");  medida=1;} else { $('#tabMedSeg').css('display',"none"); }
    	    		}
    	    		if(temas==0){
    					if(opciones=="ID_TEMAS") {$('#tabRelac').css('display',"");   temas=1;} else { $('#tabRelac').css('display',"none"); }
    	    		}
            	}
        	}else{
        		$('#tabSanciones').css('display',"none");
        		$('#tabRef').css('display',"none");
        		$('#tabDescr').css('display',"none");
        		$('#tabMedSeg').css('display',"none");
        		$('#tabRelac').css('display',"none");
        	}
        	
        /* OSINE_SFS-610 - Fin */
            if (data.resultado == 0) {
                mensajeGrowl("success", "Se elimino el registro correctamente", "");
                nuevaObligacionNormativa.gridConfiguracionObligacion();}
        });
    }
    /**
     * 
     * @returns {undefined}
     */
    function gridTablaConfiguracion() {
        var nombres = ['','Rubros', 'Proceso','Obligaciones Tipo'];
        var columnas = [
            {name: "idOblgTipo", width: 220,hidden:true ,sortable: false, align: "center"},
            {name: "descripcionActividad", width: 220, sortable: false, align: "center"},
            {name: "descProceso", width: 120, sortable: false, align: "center"},
            {name: "desObligTipo", width: 342, sortable: false, align: "center"}
        ];
        $("#gridContenedorConfiguracionSupervision").html("");
        var grid = $("<table>", {"id": "gridConfiguracionSupervision"});
        $("#gridContenedorConfiguracionSupervision").append(grid);
        grid.jqGrid({
            //url: baseURL + "pages/baseLegal/findBaseLegal",
            datatype: "local",
//            data: mydata,
            //postData: {},
//            hidegrid: false,
            rowNum: 10,
//            pager: "#paginacionConfiguracionSupervision",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            height: '150px',
//            viewrecords: false,
            caption: "",
            width: '582px',
//            jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros"},
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                var row = grid.jqGrid('getRowData', rowid);
                $('#linkEliminarPreCnf').attr('onClick', 'nuevaObligacionNormativa.eliminarPreConf("' + rowid + '")');
            },
            loadComplete: function(data) {
                $('#contextPreCnf').parent().remove();
                $('#divContextPreCnf').html("<ul id='contextPreCnf'>"
                        + "<li> <a id='linkEliminarPreCnf' data-icon='ui-icon-trash' title='Eliminar Configuración'>Eliminar</a></li>"
                        + "</ul>");
                $('#contextPreCnf').puicontextmenu({
                    //target: $('#gridObligacionNormativa').find('tr').not('.ui-subgrid,.ui-subgrid tr')
                    target: $('#gridConfiguracionSupervision')
                });
            }
        });
    }
    /**
     * 
     */
    function eliminarPreConf(rowid) {
        $('#gridConfiguracionSupervision').jqGrid('delRowData', rowid);
    }

    /**
     * 
     * @returns {undefined}
     */
    function abrirPopUpArbolProductosObligacion() {
        var URL = baseURL + "pages/mantenimiento/baseLegal/arbolProductos";
        $.get(URL, function(data) {
            $("#containerDialogArbolProductosMantenimiento").html(data);
        });
    }
    function abrirPopUpArbolTransportesObligacion() {
        var URL = baseURL + "pages/mantenimiento/baseLegal/arbolTransportes";
        $.get(URL, function(data) {
            $("#containerDialogArbolTransportesMantenimiento").html(data);
        });
    }
    /**
     * 
     * @returns {undefined}
     */
    function configurarPrimerPaso() {
    	var idActividad = $("#inputCodigoActividad").val();
    	if(idActividad!=""){
    		obtenerTipoProceso(idActividad);
    	}
        document.getElementById('frmNuevaOblNorm').onsubmit = function() {
            return false;
        };
    }
    
    function obtenerTipoProceso(idActividad){
    	/** Inicio Listado Arbol de Tipo de Proceso*/
        var treeDataProceso=[];
        $.ajax({
            url: baseURL + 'pages/mantenimiento/baseLegal/obtenerProcesoObligacion',
            type: "post",
            async: false,
            data: {idActividad:idActividad},
            //beforeSend:muestraLoading,
            success: function(data) {
                //ocultaLoading();
            	if(data.resultado==0){
            		treeDataProceso = fxTreeProceso.build(data.filas);
            		nuevoBL.divConfigurarSupervision.puitabview('enable', 1);
                    nuevoBL.divConfigurarSupervision.puitabview('disable', 0);
                    nuevoBL.divConfigurarSupervision.puitabview('select', 1);
            	}else if(data.resultado==1){
            		mensajeGrowl("error", data.mensaje);
                    ocultaLoading();
            	}else{
            		mensajeGrowl("error", data.mensaje);
                    ocultaLoading();
            	}
            	
            },
            error:errorAjax
        });
        $("#divAsignarArbolTipoProceso").fancytree({
            checkbox: true,
            selectMode: 1,
            source:treeDataProceso,
//            lazy:true,
            select: function(event, data) {
                var selKeys = $.map(data.tree.getSelectedNodes(), function(node) {
                    if (!node.folder) {
                        return "{id:'" + node.key + "',nombre:'" + node.title + "'}";
                    }
                });

                var selRootNodes = data.tree.getSelectedNodes(true);
                var selRootKeys = $.map(selRootNodes, function(node) {
                    return node.key;
                });
                $("#inputTipoProceso").val(selRootKeys.join(", "));
                //obtener titles
                var selRootNames = $.map(selRootNodes, function(node) {
                    return node.title;
                });
                $("#inputDescTipoProceso").val(selRootNames.join(", "));//inserta title
                
                if (selKeys.length !== 0) {
                } else {
                }
            },
            keydown: function(event, data) {
                if (event.which === 32) {
                    data.node.toggleSelected();
                    return false;
                }
            },
            //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
            //initId: "treeData",
            cookieId: "fancytree-Cb2",
            idPrefix: "fancytree-Cb2-"
        });
        
        //recarga el arbol con la data
        ($("#divAsignarArbolTipoProceso").fancytree("getTree")).reload(treeDataProceso).done(function(){ });
       
        /** Fin Listado de Procesos */
    }
    
    
    /**
     * 
     * @returns {undefined}
     */
    function configurarSegundoPaso() {
    	var idActividad = $("#inputCodigoActividad").val();
        var idTipoProceso = $("#inputTipoProceso").val();
        if(idTipoProceso!=""){
        	obtenerObligacionTipo(idActividad,idTipoProceso);
            $('#divAsignarArbolObligacionTipo').css('display','block');
            nuevoBL.divConfigurarSupervision.puitabview('enable', 2);
            nuevoBL.divConfigurarSupervision.puitabview('disable', 1);
            nuevoBL.divConfigurarSupervision.puitabview('select', 2);
        }
        document.getElementById('frmNuevaOblNorm').onsubmit = function() {
            return false;
        };
    }
    function obtenerObligacionTipo(idActividad,idTipoProceso){
    	/** Inicio Listado Arbol de Obligaciones Tipo*/
        var treeDataObligacionTipo=[];
        $.ajax({
            url: baseURL + 'pages/mantenimiento/baseLegal/obtenerObligacionTipo',
            type: "post",
            async: false,
            data: {idActividad:idActividad,idTipoProceso:idTipoProceso},
            //beforeSend:muestraLoading,
            success: function(data) {
                //ocultaLoading();
            	treeDataObligacionTipo = fxTreeObligacionTipo.build(data.filas);
            },
            error:errorAjax
        });
        $("#divAsignarArbolObligacionTipo").fancytree({
            checkbox: true,
            selectMode: 3,
            source:treeDataObligacionTipo,
            select: function(event, data) {
                var selKeys = $.map(data.tree.getSelectedNodes(), function(node) {
                    if (!node.folder) {
                        return "{id:'" + node.key + "',nombre:'" + node.title + "'}";
                    }
                });

                var selRootNodes = data.tree.getSelectedNodes(true);
                var selRootKeys = $.map(selRootNodes, function(node) {
                    return node.key;
                });
                $("#inputObligacionTipo").val(selRootKeys.join(", "));
                //obtener titles
                var selRootNames = $.map(selRootNodes, function(node) {
                    return node.title;
                });
                $("#inputDescObligacionTipo").val(selRootNames.join(", "));//inserta title
                if (selKeys.length !== 0) {
                } else {
                }
            },
            keydown: function(event, data) {
                if (event.which === 32) {
                    data.node.toggleSelected();
                    return false;
                }
            },
            //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
            //initId: "treeData",
            cookieId: "fancytree-Cb2",
            idPrefix: "fancytree-Cb2-"
        });
        
      //recarga el arbol con la data
        ($("#divAsignarArbolObligacionTipo").fancytree("getTree")).reload(treeDataObligacionTipo).done(function(){ });
        /** Fin Listado Arbol de Obligaciones Tipo*/

    }
    
    /**
     * 
     * @returns {undefined}
     */
    function configurarBtnRegresarSegundoPaso() {
        nuevoBL.divConfigurarSupervision.puitabview('enable', 0);
        nuevoBL.divConfigurarSupervision.puitabview('disable', 1);
        nuevoBL.divConfigurarSupervision.puitabview('select', 0);
        $("#inputCodigoActividad").val("");
        $("#divAsignarArbolActividades").fancytree("getTree").visit(function(node){
            node.setSelected(false);
          });
        document.getElementById('frmNuevaOblNorm').onsubmit = function() {
            return false;
        };
    }
    /**
     * 
     * @returns {undefined}
     */
    function configurarTercerPaso() {
    	if($('#inputDescObligacionTipo').val()!=""){
    		gridTablaConfiguracion();//inicializa Grid Configuracion Temporal
        	//Descripciones
        	var descAct=$('#inputDescActividad').val();
            var descPro=$('#inputDescTipoProceso').val();
            var descOblg=$('#inputDescObligacionTipo').val();
            addGridData(descAct,descPro,descOblg);//addData
            //habilita pestaña Configuracion
        	nuevoBL.divConfigurarSupervision.puitabview('enable', 3);
            nuevoBL.divConfigurarSupervision.puitabview('disable', 2);
            nuevoBL.divConfigurarSupervision.puitabview('select', 3);
            $('#divBotonesConfigurar').css("display","block");
            $('#divBotonesConfigurarConfirma').css("display","block");
            $('#gridContenedorConfiguracionSupervision').css("display","block");
    		
    	}
    	
        document.getElementById('frmNuevaOblNorm').onsubmit = function() {
            return false;
        };
    }
    /*
     * Agrega Data al Grid 
     */
    function addGridData(descAct,descPro,descOblg){
    	//Id's
//    	var idAct=$('#inputCodigoActividad').val();
//    	var idPro=$('#inputTipoProceso').val();
//    	var idOblg=$('#inputObligacionTipo').val();
//    	var text="";
//    	var idOblgTipo=[];
//        for	(var index = 0; index < idOblg.length; index++) {
//        	text = idOblg[index];
//        	if(text!="" && text!=" "){
//        		if(isNaN(text)){ }else{
//            		idOblgTipo.push(text);
//            	}
//        	}
//        }
//        //console.info("idOblgTipo: " + idOblgTipo);
//        var cadArray=descOblg.split(",");
//        for(var index = 0; index < idOblgTipo.length; index++){
//        	text = idOblgTipo[index];
//        	if(validarCamposGridConfiguracion(idAct,idPro,idOblg,text)){
//        		var idData = idOblgTipo[index];
//                var cnfObligacion = {
//                	idOblgTipo:	idOblgTipo[index],
//                	descripcionActividad:descAct ,
//                	descProceso:descPro,
//                	desObligTipo:cadArray[index]
//                };
//                $("#gridConfiguracionSupervision").addRowData(idData, cnfObligacion);
//        	}
//        }
        var idAct=$('#inputCodigoActividad').val();
    	var idPro=$('#inputTipoProceso').val();
    	var idOblg=$('#inputObligacionTipo').val();

        var cadArray=descOblg;

        		var idData = idAct;
        
                var cnfObligacion = {
//                	idOblgTipo:	idOblgTipo[index],
                	descripcionActividad:descAct ,
                	descProceso:descPro,
                	desObligTipo:cadArray
                };
                $("#gridConfiguracionSupervision").addRowData(idData, cnfObligacion);
//        	}
//        }
        
    }
    /**
     * funcion para validar campos del grid
     */
    function validarCamposGridConfiguracion(idAct,idPro,idOblg,text){
     var encontrado = false;
     var ids= $("#gridConfiguracionSupervision").jqGrid('getDataIDs');
     for (var i = 0; i < ids.length; i++){
    	 var rowId = ids[i];
         var rowData = $('#gridConfiguracionSupervision').jqGrid ('getRowData', rowId);
         if (rowData.idOblgTipo==text){
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
     * @returns {undefined}
     */
    function configurarBtnRegresarTercerPaso() {
        nuevoBL.divConfigurarSupervision.puitabview('enable', 1);
        nuevoBL.divConfigurarSupervision.puitabview('disable', 2);
        nuevoBL.divConfigurarSupervision.puitabview('select', 1);
        $("#inputTipoProceso").val("");
        $("#divAsignarArbolTipoProceso").fancytree("getTree").visit(function(node){
            node.setSelected(false);
          });
        document.getElementById('frmNuevaOblNorm').onsubmit = function() {
            return false;
        };
    }
    /**
     * 
     * @returns {undefined}
     */
    function configurarBtnRegresarCuartoPaso() {
    	nuevoBL.divConfigurarSupervision.puitabview('enable', 2);
    	nuevoBL.divConfigurarSupervision.puitabview('disable', 3);
    	nuevoBL.divConfigurarSupervision.puitabview('select', 2);
    	$("#divAsignarArbolObligacionTipo").fancytree("getTree").visit(function(node){
            node.setSelected(false);
          });

    	document.getElementById('frmNuevaOblNorm').onsubmit = function() { return false; };
    }
    /**
     * 
     * @returns {undefined}
     */
    function iniciarConfigurarSupervision() {
        nuevoBL.divConfigurarPrimerPaso.css("display","block");
        nuevoBL.divConfigurarSegundoPaso.css("display","none");
        nuevoBL.divConfigurarTercerPaso.css("display","none");
        nuevoBL.divConfigurarCuartoPaso.css("display","none");
        nuevoBL.divConfigurarSupervision.puitabview({orientation: 'left'});
        nuevoBL.divConfigurarSupervision.puitabview('disable', 1);
        nuevoBL.divConfigurarSupervision.puitabview('disable', 2);
        nuevoBL.divConfigurarSupervision.puitabview('disable', 3);
    }
    /**
     * @returns {undefined}
     */
    function copiarDescripcion() {
        nuevoBL.txtDescripcionActaObligacion.val(nuevoBL.txtDescripcionObligacion.val());
        nuevoBL.txtDescripcionGuiaObligacion.val(nuevoBL.txtDescripcionObligacion.val());
    }
    
    /**
     * 
     * @returns {undefined}
     */
    function agregarDescripcionNormativa(){
        document.getElementById('newObligacionNormativa').onsubmit = function() {
            return false;
        };
        if($('#txtDescObligacionNormativaActa').val() !== ""){
            $.ajax({
                url: baseURL + "pages/mantenimiento/baseLegal/registrarDetalleObligacionNormativa",
                type: 'post',
                async: false,
                data: {
                    codigoObligacion: $('#idObligacion').val(),
                    idDetalleObligacion:$('#idDetalleObligacion').val(),
                    descripcionNormativa: $('#txtDescObligacionNormativaActa').val(),
                    codTrazabilidad:$('#codTrazabilidad').val()
                },
                beforeSend: muestraLoading,
                success: function(data) {
                    if(data.resultado == 0){
                        mensajeGrowl("success",data.mensaje);
                        if(data.idDetalleObligacion>0){
                            $('#idDetalleObligacion').val(data.idDetalleObligacion);
                        }
                        ocultaLoading();
                    }else if(data.resultado == 1){
                    	mensajeGrowl('error', data.mensaje);
                        ocultaLoading();
                    }

                },
                error: errorAjax
            });
        }
    }
    
    /*Rsis 11 - Inicio*/
    /**
     * 
     * @returns {undefined}
     */
    function agregarDescripcionInfraccion(){
        document.getElementById('newObligacionNormativa').onsubmit = function() {
            return false;
        };
        
        validaInfraccion=true;
    	errorCheck="";
    	var error = "";
    	
    	 if($('#txtDescInfraccion').val()==""){
    		validaInfraccion=false;
    		/* OSINE_SFS-610 - Inicio */
    		//error = "Se Debe ingresar descripcion de infraccion. <br>";
            error = "Se Debe ingresar descripci&oacute;n de infracci&oacute;n. <br>";
            /* OSINE_SFS-610 - Fin */
            $('#txtDescInfraccion').addClass("error");
            errorCheck +=  error;
    	}
    	 
    	 if($('#cmbMedidaSeguirdad').val()==-1){
     		validaInfraccion=false;
            error = "Se Debe ingresar medida de seguridad.";
            $('#cmbMedidaSeguirdad').addClass("error");
            errorCheck += error;
     	 }
    	 if($('#cmbAccionInfraccion').val()==-1){
      		validaInfraccion=false;
      		/* OSINE_SFS-610 - Inicio */
      		//error = "Se Debe ingresar Accion.";
            error = "Se Debe ingresar Acci&oacute;n.";
            /* OSINE_SFS-610 - Fin */
            $('#cmbAccionInfraccion').addClass("error");
            errorCheck += error;
      	 }
    	 /*if($('#imgMedidaSeguridad').val()==undefined){
       		validaInfraccion=false;
             error = "Se Debe ingresar Documento Adjunto.";
             errorCheck += error;
       	 }*/
    	 if (error != ""){
    	   $('#divMensajeValMedidaSeg').show();
           $('#divMensajeValMedidaSeg').focus();
           $('#divMensajeValMedidaSeg').html(errorCheck);
    	 }else{
    		$('#divMensajeValMedidaSeg').hide();
    		$('#divMensajeValMedidaSeg').html("");
    		$('#txtDescInfraccion').removeClass();
    		$('#cmbMedidaSeguirdad').removeClass();
    		$('#cmbAccionInfraccion').removeClass();
         }
    	
        if(validaInfraccion){
            $.ajax({
                url: baseURL + "pages/mantenimiento/baseLegal/registrarInfraccion",
                type: 'post',
                async: false,
                data: {                	
                    codigoObligacion: $('#idObligacion').val(),                    
                    descripcionInfraccion: $('#txtDescInfraccion').val(),
                    codTrazabilidad:$('#codTrazabilidad').val(),
                    idAccionMaestro:$('#cmbAccionInfraccion').val(),
                    idInfraccion:$('#idInfraccion').val(),
                    idMedidaSeguridadMaestro:$('#cmbMedidaSeguirdad').val()
                },
                beforeSend: muestraLoading,
                success: function(data) {
                    if(data.resultado == 0){
                        mensajeGrowl("success",data.mensaje);                        
                        if(data.idInfraccion>0){
                            $('#idInfraccion').val(data.idInfraccion);
                            if(data.retorno.documentoAdjuntoDTO!=null){
                        		var nombreArchivo=data.retorno.documentoAdjuntoDTO.nombreArchivo;
                        		var rutaAlfresco=data.retorno.documentoAdjuntoDTO.rutaAlfresco;
                        		document.getElementById("divDownloadDetalleImgInfraccion").innerHTML="";
                                $('#divDownloadDetalleImgInfraccion').append('<a class="link" href="'+baseURL + 'pages/documentoAdjunto/descargaArchivoAlfresco?aplicacionSpace=OBLIGACIONES&nombreArchivo='+nombreArchivo+'&rutaAlfresco='+rutaAlfresco+'"><img class="vam" width="20" height="24" src="'+baseURL+'images/stickers.png"></a>');
                        	}else{
                        		document.getElementById("divDownloadDetalleImgInfraccion").innerHTML="";
                        	}

                        }
                        ocultaLoading();
                    }else if(data.resultado == 1){
                    	mensajeGrowl('error', data.mensaje);
                        ocultaLoading();
                    }

                },
                error: errorAjax
            });
        }
    }
    /*Rsis 11 - Fin*/
    
    
    /**
     * 
     * @returns {undefined}
     */
    function agregarTipificacion() {
        var validacion = false;
        var divValidacion = $('#divMensajeValidacionAdicionarTipificacion');
        if($('#txtIdTipificacion').val() === ""){
            divValidacion.show();
            divValidacion.focus();
            /* OSINE_SFS-610 - INICIO */
            divValidacion.html("* Debe Ingresar una Tipificaci&oacute;n v&aacute;lida");
            /* OSINE_SFS-610 - FIN */
        }else{
            divValidacion.hide();
            divValidacion.html("");
            validacion = true;
        }
        if(validacion){
            $.ajax({
                url: baseURL + "pages/mantenimiento/baseLegal/registrarTipificacion",
                type: 'post',
                async: false,
                data: {
                    idTipificacion: $('#txtIdTipificacion').val(),
                    idObligacion: $('#idObligacion').val(),
                    codTrazabilidad:$('#codTrazabilidad').val()
                },
                beforeSend: muestraLoading,
                success: function(data) {
                    if (data.resultado == 0) {
                        mensajeGrowl("success",data.mensaje);
                        ocultaLoading();
                        recargarGriTipificacion();
                        $("#txtTipifOblNor").val('');
                        $('#txtIdTipificacion').val('');
// 05-11-2015                        
                        cargaInicial.obtenerTipificacionToCriterio($('#idObligacion').val());
//                        
                        nuevoBL.txtDescripcionTipificacionOblig.val('');
                        nuevoBL.txtSancionTipificacionObligacion.val('');
                        nuevoBL.txtBaseLegalTipificacionObligacion.val('');
                        nuevaObligacionNormativa.obtenerTipificacion($('#txtIdTipificacion').val());
                        $('#dvTipSan input[type=checkbox]').each(function(index) {
                            $(this).attr('checked',false);
                        });
                $(".chkTipoSancion").attr('checked', false);
                    } else if (data.resultado == 1) {
                        mensajeGrowl('error', data.mensaje);
                        ocultaLoading();
                    } else {
                        mensajeGrowl('error', data.mensaje);
                        ocultaLoading();
                    }
                },
                error: errorAjax
            });
            /*remove atribute desabilitar*/
            $('#txtDesTipifOblNor').attr('disabled', 'disabled');
            $('#spinhastaOblNor').spinner({disabled: true});
            /**/
        }
    }
    /*Rsis 14 - Inicio*/
    /**
     * 
     * @returns {undefined}
     */
    function agregarIncumplimiento() {

        var validacion = false;
        var divValidacion = $('#divMensajeValidacionAdicionarIncumplimiento');
        if($('#cmbEscenario').val() == "-1"){
        	$('#cmbEscenario').addClass("error");
            divValidacion.show();
            divValidacion.focus();
            divValidacion.html("* Debe Seleccionar un Escenario válido");
        }else{
            divValidacion.hide();
            divValidacion.html("");
            $('#cmbEscenario').removeClass();
            validacion = true;
            /*
            errorCheck="";
        	var error = "";
        	*/
        	 /*if($('#txtDescInfraccion').val()==""){
        		 validacion=false;
                error = "Se Debe ingresar descripcion de infraccion. <br>";
                $('#txtDescInfraccion').addClass("error");
                errorCheck +=  error;
        	}
        	 */
        	/*
        	 if (error != ""){
          	   $('#divMensajeValidacionAdicionarIncumplimiento').show();
                 $('#divMensajeValMedidaSeg').focus();
                 $('#divMensajeValidacionAdicionarIncumplimiento').html(errorCheck);
          	 }else{
          		$('#divMensajeValMedidaSeg').hide();
          		$('#divMensajeValMedidaSeg').html("");
          		$('#txtDescInfraccion').removeClass();          		
          		
               }
               */
        	 
        }
        if(validacion){
            $.ajax({
                url: baseURL + "pages/mantenimiento/baseLegal/registrarIncumplimiento",
                type: 'post',
                async: false,
                /* OSINE_SFS-610 - Inicio */
                dataType: 'json',
                /* OSINE_SFS-610 - Fin */
                data: {
                    idIncumplimiento: $('#idIncumplimiento').val(),
                    idMaestroincumplimiento: $('#cmbEscenario').val(),
                    idObligacion: $('#idObligacion').val(),
                    idInfraccion: $('#idInfraccion').val(),
                    codTrazabilidad:$('#codTrazabilidad').val()
                },
                beforeSend: muestraLoading,
                success: function(data) {
                    if (data.resultado == 0) {
                        mensajeGrowl("success",data.mensaje);
                        ocultaLoading();
                        gridIncumplimiento();
                        $("#txtTipifOblNor").val('');
                        $('#txtIdTipificacion').val('');
// 05-11-2015                        
                        cargaInicial.obtenerTipificacionToCriterio($('#idInfraccion').val());
//                        
                        nuevoBL.txtDescripcionTipificacionOblig.val('');
                        nuevoBL.txtSancionTipificacionObligacion.val('');
                        nuevoBL.txtBaseLegalTipificacionObligacion.val('');
                        //nuevaObligacionNormativa.obtenerTipificacion($('#txtIdTipificacion').val());
                        $('#dvTipSan input[type=checkbox]').each(function(index) {
                            $(this).attr('checked',false);
                        });
                $(".chkTipoSancion").attr('checked', false);
                    } else if (data.resultado == 1) {
                        mensajeGrowl('error', data.mensaje);
                        ocultaLoading();
                    } else {
                        mensajeGrowl('error', data.mensaje);
                        ocultaLoading();
                    }
                },
                /* OSINE_SFS-610 - Inicio */
                //error: errorAjax
                error : function(jqXHR) {
    				errorAjax(jqXHR);
    			}
                /* OSINE_SFS-610 - Fin */
            });
            /*remove atribute desabilitar*/
            $('#txtDesTipifOblNor').attr('disabled', 'disabled');
            $('#spinhastaOblNor').spinner({disabled: true});
            /**/
        }
    }
    /*Rsis 14 - Fin*/
    /**
     * 
     * @returns {undefined}
     */
    function gridTipificacion() {
    	/* OSINE_SFS-610 INICIO */
        var colNames = ['idTipificacion','C&oacute;digo Tipificaci&oacute;n', 'Descripci&oacute;n Infracción', 'Sanci&oacute;n','','concatIdTipoSancion'];
        /* OSINE_SFS-610 FIN */
        var colModel = [
            {name: "idTipificacion", hidden: true, width: 200, sortable: false, align: "center"},
            {name: "codTipificacion", width: 300, sortable: false, align: "center"},
            {name: "descripcion", width: 600, sortable: false, align: "center"},
            {name: "descSancionEspecifica", width: 200, sortable: false, align: "center",formatter:"fmtDescripSancion"},
            {name: "sancionMonetaria", width: 200, sortable: false, align: "center",hidden:true},
            {name: "concatIdTipoSancion", formatter:"fmtConcatIdTipoSancion",hidden:true}
        ];
        
        $("#gridTipificacion").html("");
        var url = baseURL + "pages/mantenimiento/baseLegal/findTipificacion";
        var postData = {idObligacion:-1};
            
        var grid = $("<table>", {
            "id": "gridTipificaciones"
        });
        var pager = $("<div>", {
            "id": "paginacionTipificacion"
        });
        $("#gridTipificacion").append(grid).append(pager);
        grid.jqGrid({
            url:url,
            datatype: "json",
            postData: postData,
            hidegrid: false,
            rowNum: global.rowNum,
            pager: "#paginacionTipificacion",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames : colNames,
            colModel : colModel,
            height: "auto",
            viewrecords: true,
//            caption: "Listado de Tipificaciones",
            width: 825,
            jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros"},
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                var row = grid.jqGrid('getRowData', rowid);
                
                $('#linkEliminarTipificacion').attr('onClick', 'nuevaObligacionNormativa.confirmEliminarTipificacion("' + rowid + '")');
                
                if($('#divEnlaceTagEliminarTipificacionObligacion input').html()!=null){
                    $('#contextMenuTipificacion li a[value="EL-GRIDTIPIFICACIONOBLIGACION"]').html($('#divEnlaceTagEliminarTipificacionObligacion').html());               
                }else {
                 	  $('#contextMenuTipificacion li a[value="EL-GRIDTIPIFICACIONOBLIGACION"]').remove();
                 	 $('#contextMenuTipificacion').parent().css('opacity',0);
                }
            },
            loadComplete: function(data) {
            	$('#contextMenuTipificacion').parent().css('opacity',1);
                $('#contextMenuTipificacion').parent().remove();
                if(nuevaObligacionNormativa.modoVisualizacion != modoVer){
                    $('#divContextMenuTipificacion').html("<ul id='contextMenuTipificacion'>"
                    		+"<li> <a value='EL-GRIDTIPIFICACIONOBLIGACION'></a></li>"
//                            + "<li> <a id='linkEliminarTipificacion' data-icon='ui-icon-trash' title=''>Eliminar</a></li>"
                            + "</ul>");
                    $('#contextMenuTipificacion').puicontextmenu({
                        //target: $('#gridObligacionNormativa').find('tr').not('.ui-subgrid,.ui-subgrid tr')
                        target: $('#gridTipificaciones')
                    });
                }
            }
        });
    }
    
    
    /*Rsis 14 - Fin*/
    function recargarGriTipificacion(){
    	$("#gridTipificaciones").jqGrid('setGridParam',{ postData: { idObligacion: $('#idObligacion').val()} });
        $("#gridTipificaciones").trigger("reloadGrid");
    }
    
    function confirmEliminarTipificacion(rowid) {
        /* modif jpiro 20150106 - ini */
        confirm.start();
        /* modif jpiro 20150106 - fin */
        /* OSINE_SFS-610 - INICIO */
        confirm.open("¿Ud est&aacute; seguro de eliminar esta Tipificaci&oacute;n?",
                "nuevaObligacionNormativa.eliminarTipificacion('" + rowid + "')");
        /* OSINE_SFS-610 - FIN */
    }
    function eliminarTipificacion(rowid){
        var row = $('#gridTipificaciones').jqGrid('getRowData', rowid);
        
        var URL = baseURL + "pages/mantenimiento/baseLegal/eliminarObligacionTipificacion";
        var data = {
			idTipificacion:row.idTipificacion, 
			idObligacion: $('#idObligacion').val(),
			codTrazabilidad:$('#codTrazabilidad').val()
        };
        $.get(URL,data, function(data) {
            if (data.resultado == 0) {    
// 05-11-2015
            	cargaInicial.obtenerTipificacionToCriterio($('#idObligacion').val());
//  
            	mensajeGrowl("success", data.mensaje);  
                $("#gridTipificaciones").trigger("reloadGrid");
            }else if(data.resultado == 1){
            	mensajeGrowl("error", data.mensaje);
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
                      label: (item.tieneAct==1)?item.codTipificacion + " " + item.basesLegales:item.codTipificacion,
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
	    	  if (ui.item) {
	    		  event.preventDefault();
                          $("#txtTipifOblNor").val(ui.item.value);
                          $('#txtIdTipificacion').val(ui.item.id);
                          obtenerTipificacion(ui.item.id);
	            return false;
	          }
	      },
		    
	      change: function(event,ui){

                if(ui.item == null){

                    
                    var URL = baseURL + "pages/mantenimiento/baseLegal/findTipificacionCodigo";
                    $.get( URL,{codigo:$("#txtTipifOblNor").val()},
                    function(data) {                                                
                        if(data.idTipificacion !== null){
                            nuevoBL.txtIdTipificacion.val(data.idTipificacion);
                            nuevoBL.txtDescripcionTipificacionOblig.val(data.descripcion);
                            nuevoBL.txtSancionTipificacionObligacion.val(data.sancionMonetaria);
                            nuevoBL.txtBaseLegalTipificacionObligacion.val(data.basesLegales);
                            for(var x = 0; x < data.listaTipificacionSancion.length;x++){
                                var idTipoSancion = data.listaTipificacionSancion[0].idTipoSancion;
                                $("#chkTs_"+idTipoSancion).attr('checked', true);
                            }
                        }else{
                            $(".chkTipoSancion").attr('checked', false);
                            nuevoBL.txtIdTipificacion.val("");
                            nuevoBL.txtDescripcionTipificacionOblig.val("");
                            nuevoBL.txtSancionTipificacionObligacion.val("");
                            nuevoBL.txtBaseLegalTipificacionObligacion.val("");
                        }
                    });
                }else{
                    
                    $("#txtTipifOblNor").val(ui.item.value);
                    $('#txtIdTipificacion').val(ui.item.id);
                    obtenerTipificacion(ui.item.id);
                }
                
             }
	      
	    });

    }
    /**
     * 
     * @returns {undefined}
     * function: create grid Criterio
     */
    function gridCriterio() {
// 05-11-2015    	
    	var nombres = ['IdTipiCriterio','IdCriterio', 'IdTipificacion', 'Cod. Tipificación', 'Descripción del Incumplimiento', 'Sanción Específica','','Base Legal','','concatIdTipoSancion'];
        var columnas = [
            {name: "idObliTipiCriterio", width: 20, hidden: true, sortable: false, align: "center"},
            {name: "idCriterio", width: 20, hidden: true, sortable: false, align: "center"},
            {name: "idTipificacion", width: 20, hidden: true, sortable: false, align: "center"},
            {name: "codigoTipificacion", width: 150,sortable: false, align: "center"},
            {name: "descripcionCriterio", width: 450, sortable: false, align: "center"},
            {name: "descSancionEspecifica", width: 200, sortable: false, align: "center",formatter:"fmtDescripSancion"},
            {name: "sancionEspecifica", width: 200, sortable: false, align: "center",hidden:true},
            {name: "basesLegales", width: 450, sortable: false, align: "center"},
            {name: "sancionMonetaria", width: 200, sortable: false, align: "center",hidden:true},
            {name: "concatIdTipoSancion", formatter:"fmtConcatIdTipoSancion",hidden:true}
        ];
//        
        $("#gridContenedorCriterio").html("");
        var grid = $("<table>", {
            "id": "gridCriterios"
        });
        var pager = $("<div>", {
            "id": "paginacionCriterio"
        });
        $("#gridContenedorCriterio").append(grid).append(pager);
        var postData = {idObligacion:$('#idObligacion').val()};
        grid.jqGrid({
            url: baseURL + "pages/mantenimiento/baseLegal/findObliTipiCriterio",
            datatype: "json",
            postData: postData,
            hidegrid: false,
            rowNum: global.rowNum,
            pager: "#paginacionCriterio",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            height: "auto",
            viewrecords: true,
//            caption: "Listado de Criterios",
            width: 825,
            jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros"},
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                var row = grid.jqGrid('getRowData', rowid);
//                $('#linkEditarCriterio').attr('onClick', 'nuevaObligacionNormativa.editarCriterio("' + rowid + '")');
                $('#linkEliminarCriterio').attr('onClick', 'nuevaObligacionNormativa.confirmEliminarCriterio("' + row.idObliTipiCriterio + '")');
                
                if($('#divEnlaceTagEliminarCriterioObligacion input').html()!=null){
                    $('#contextMenuCriterio li a[value="EL-GRIDCRITERIOOBLIGACION"]').html($('#divEnlaceTagEliminarCriterioObligacion').html());               
                }else {
                 	  $('#contextMenuCriterio li a[value="EL-GRIDCRITERIOOBLIGACION"]').remove();
                 	 $('#contextMenuCriterio').parent().css('opacity',0);
                }
                
            },
            loadComplete: function(data) {
            	$('#contextMenuCriterio').parent().css('opacity',1);
                $('#contextMenuCriterio').parent().remove();
                if(nuevaObligacionNormativa.modoVisualizacion != modoVer){
                    $('#divContextMenuCriterio').html("<ul id='contextMenuCriterio'>"
                    	+"<li> <a value='EL-GRIDCRITERIOOBLIGACION'></a></li>"
//                        + "<li> <a id='linkEliminarCriterio' data-icon='ui-icon-trash' title=''>Eliminar</a></li>"
                        + "</ul>");
                    $('#contextMenuCriterio').puicontextmenu({
                        //target: $('#gridObligacionNormativa').find('tr').not('.ui-subgrid,.ui-subgrid tr')
                        target: $('#gridCriterios')
                    });
                }
            },
            subGrid: false,
            afterInsertRow: function(rowid, aData, rowelem) {
                var rowData = grid.getRowData(rowid);
                if (rowData["tieneAct"]==0) {
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
                "reloadOnExpand": true,
                "selectOnExpand": false},
            subGridRowExpanded: function(subgrid_id, row_id) {
                var dataPadre = grid.getRowData(row_id);
                var subgrid_table_id, pager_id;
                subgrid_table_id = subgrid_id + "_t";
                pager_id = "p_" + subgrid_table_id;
                $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table>");//<div id='"+pager_id+"' class='scroll'></div>
                jQuery("#" + subgrid_table_id).jqGrid({
                    url: baseURL + "pages/mantenimiento/baseLegal/findDetalleCriterio",
                    postData: {idCriterio: dataPadre.idCriterio},
                    datatype: "json",
                    colNames: ['ID DETALLE CRITERIO','Sanción Específica','Sanciones','concatIdTipoSancion'],
                    colModel: [
                        {name: "idDetalleCriterio", hidden: true, width: 200, sortable: false, align: "center"},
			            {name: "sancionEspecifica", width: 460, sortable: false, align: "center"},
			            {name: "descripcionSancion", width: 200, sortable: false, align: "center",formatter:"fmtDescripSancion"},
			            {name: "concatIdTipoSancion", formatter:"fmtConcatIdTipoSancion",hidden:true}
                    ],
                    rowNum: 10,
                    jsonReader: {
                        root: "filas", //la lista de registros a mostrar en el grid
                        page: "pagina", //la pagina actual
                        total: "total", //total de paginas
                        records: "registros", //numero total de registros
                    },
                    pager: pager_id,
                    sortname: 'num',
                    sortorder: "asc",
                    height: '100%',
                    autowidth: true,
                    loadComplete: function(data) {
                        $('#contextMenuCriteroSub').parent().remove();
                        $('#divContextMenuCriterioSub').html("<ul id='contextMenuCriteroSub'>"
                                + "<li> Sin Accion </li>"
                                + "</ul>");
                        $('#contextMenuCriteroSub').puicontextmenu({
                            target: $("#gridContenedorCriterio .ui-subgrid")
                        });
                        $('#contextMenuCriteroSub').parent().css('opacity',0);
                    }
                });
            }
        });
    }
    
    function recargarGridCriterios() {
    	$("#gridCriterios").jqGrid('setGridParam',{ postData: { idObligacion: $('#idObligacion').val()} });
        $("#gridCriterios").trigger("reloadGrid");
    }
    function confirmEliminarCriterio(idCriterio) {
        confirm.start();
        /* OSINE_SFS-610 - INICIO */
        confirm.open("¿Ud est&aacute; seguro de eliminar asociaci&oacute;n con el criterio?",
                "nuevaObligacionNormativa.eliminarCriterio('" + idCriterio + "')");
        /* OSINE_SFS-610 - FIN */
    }
    function eliminarCriterio(idCriterio){
        var URL = baseURL + "pages/mantenimiento/baseLegal/eliminarCriterioAsociado";
        $.get(URL,{idCriterio:idCriterio,codTrazabilidad:$('#codTrazabilidad').val()}, function(data) {
            if (data.resultado == 0) {
                nuevaObligacionNormativa.recargarGridCriterios();                
                mensajeGrowl('success',data.mensaje);
            }else if (data.resultado == 1){
                mensajeGrowl('error',data.mensaje);
            }
        });
    }

    /**
     * 
     * @param {type} rowid
     * @returns {undefined}
     * function: "Edit Criterio"
     */
    function editarCriterio(rowid) {
        var row1 = $('#gridCriterios').jqGrid('getRowData', rowid);
        nuevoBL.txtDescripcionCriterio.val(row1.descripcion);
        $('#codigoTipificacionPauta').val(row1.idTipificacion);
        $('#codigoCriterio').val(row1.idCriterio);
        nuevoBL.txtFileCriterio.val('');
        nuevaObligacionNormativa.gridArchivosCriterio();
        nuevaObligacionNormativa.gridPautaSancionTipificacion();
        nuevaObligacionNormativa.gridListadoSancionesEspecificas();
        $('#dialogPauta').dialog('open');
    }
    /**
     * @returns {undefined}
     * function: create grid Archivos 
     */
    function gridArchivosCriterio() {
        var nombres = ['ID','Nombre Archivo', 'tieneAct', 'Descargar'];
        var columnas = [
            {name: "idDetalleDocumentoCriterio", width: 20, sortable: false, hidden: true, align: "center"},
            {name: "titulo", width: 470, sortable: false, align: "center"},
            {name: "tieneAct", width: 30, sortable: false, hidden: true, align: "center"},
            {name: "Img_Descarga", width: 60, sortable: false, align: "center", formatter: "descargarFileDocumentoCriterio"}];
        $("#gridContenedorArchivoCriterio").html("");
        var grid = $("<table>", {
            "id": "gridArchivosCriterio"
        });
        var pager = $("<div>", {
            "id": "paginacionPautas"
        });
        $("#gridContenedorArchivoCriterio").append(grid).append(pager);
        var url = baseURL + "pages/mantenimiento/baseLegal/findArchivoCriterio";
        var idCriterio = $('#codigoCriterio').val();
        if(idCriterio == "" || idCriterio == null){
            idCriterio = -1;
        }
        var postData = {idCriterio:idCriterio};
        grid.jqGrid({
            url:url,
            datatype: "json",
            postData: postData,
            hidegrid: false,
            rowNum: global.rowNum,
            pager: "#paginacionPautas",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            height: "auto",
            viewrecords: true,
            caption: "Listado de Archivos",
            autowidth: true,
            jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros"},
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                var row = grid.jqGrid('getRowData', rowid);
                $('#linkEliminarArchivo').attr('onClick', 'nuevaObligacionNormativa.eliminarArchivo("' + row.idDetalleDocumentoCriterio + '")');
            },
            loadComplete: function(data) {
                $('#contextMenuArchivo').parent().remove();
                $('#divContextMenuArchivo').html("<ul id='contextMenuArchivo'>"
                        + "<li> <a id='linkEliminarArchivo' data-icon='ui-icon-trash' title='Eliminar Archivo'>Eliminar</a></li>"
                        + "</ul>");
                $('#contextMenuArchivo').puicontextmenu({
                    //target: $('#gridObligacionNormativa').find('tr').not('.ui-subgrid,.ui-subgrid tr')
                    target: $('#gridArchivosCriterio')
                });
            }
        });
    }
    
    function recargarGridArchivoCriterios() {
        $("#gridArchivosCriterio").trigger("reloadGrid");
    }
    
    /**
     * @param {type} idDetalleDocumentoCriterio
     * @returns {undefined}
     * function: "Delete Register"
     */
    function eliminarArchivo(idDetalleDocumentoCriterio) {
        var URL = baseURL + "pages/mantenimiento/baseLegal/eliminarArchivoCriterio";
        $.get( URL,{idDetalleDocumentoCriterio:idDetalleDocumentoCriterio, idCriterio :$('#codigoCriterio').val()},
        function(data) {
           if (data.resultado == 0) {
               $("#gridArchivosCriterio").trigger("reloadGrid");
           }
        });
    }
    /**
     * 
     * @param {type} rowid
     * @returns {undefined}
     */
    function eliminarPautaSancion(rowid) {
        $('#gridPautaSancionesTipificacion').jqGrid('delRowData', rowid);
        mensajeGrowl("success", "Se elimino el registro correctamente", "");
    }
    /**
     * @returns {undefined}
     * function: create grid Archivos 
     */
    function gridPautaSancionTipificacion() {
        
        var colNames = ['idTipificacion','Cod. Tipificación', 'Descripción Infracción', 'Monto Tipificacion Hasta', 'Seleccionado','Asignar'];
        var colModel = [
            {name: "idTipificacion", hidden: true, width: 164, sortable: false, align: "center"},
            {name: "codTipificacion", width: 164, sortable: false, align: "center"},
            {name: "descripcion", width: 163, sortable: false, align: "center"},
            {name: "sancionMonetaria", width: 163, sortable: false, align: "center"},
            {name: "seleccionado", hidden: true, width: 50, sortable: false, align: "center"},
            {name: "activo", width: 50, sortable: false, align: "center", formatter: "columnaActiva2"}];
        
        $("#gridContenedorPautaSancionTipificacion").html("");
        var grid = $("<table>", {
            "id": "gridPautaSancionesTipificacion"
        });
        var pager = $("<div>", {
            "id": "paginacionPautaSancionTipificacion"
        });
        $("#gridContenedorPautaSancionTipificacion").append(grid).append(pager);
        var url = baseURL + "pages/mantenimiento/baseLegal/findTipificacionCriterio";
        var idTipificacion = $('#codigoTipificacionPauta').val();
        if(idTipificacion == "" || idTipificacion == null){
            idTipificacion = -1;
        }
        var postData = {idObligacion:$('#idObligacion').val(), idTipificacion:idTipificacion};
        grid.jqGrid({
            url:url,
            datatype: "json",
            postData: postData,
            hidegrid: false,
            rowNum: global.rowNum,
            pager: "#paginacionPautaSancionTipificacion",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames : colNames,
            colModel : colModel,
            height: "auto",
            viewrecords: true,
            caption: "Tipificacion",
            autowidth: true,
            jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros"},
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                var row = grid.jqGrid('getRowData', rowid);
                $('#linkEliminarPautaSancion').attr('onClick', 'nuevaObligacionNormativa.eliminarPautaSancion("' + rowid + '")');
            },
            loadComplete: function(data, rowid) {
                $('#contextMenuPautaSancionTipificacion').parent().remove();
                $('#divContextMenuPautaSancionTipificacion').html("<ul id='contextMenuPautaSancionTipificacion'>"
                        + "<li> <a id='linkEliminarPautaSancion' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                        + "</ul>");
                $('#contextMenuPautaSancionTipificacion').puicontextmenu({
                    //target: $('#gridObligacionNormativa').find('tr').not('.ui-subgrid,.ui-subgrid tr')
                    target: $('#gridPautaSancionesTipificacion')
                });
            }
        });
    }
    jQuery.extend($.fn.fmatter, {
        columnaActiva2: function(cellvalue, options, rowdata) {
            var selecionado = rowdata['seleccionado'];
            var checked = '';
            if(selecionado === "1"){
                checked = 'checked ="true"';
            }
            var html = '<div style="float:left; margin-right:10px;">';
            html += '<input onclick="nuevaObligacionNormativa.capturarCodigo('+rowdata.idTipificacion+')" id="rdTipificacion' + rowdata.idTipificacion + '" type="radio" '+checked+'  name="rdoSancionPauta" value="' + rowdata.idTipificacion + '" class="rdoPauta" />';
            html += '<label for="rdTipificacion' + (rowdata.idTipificacion) + '" class="radio"></label>';
            html += '</div>';
            return html;
        }
    });
    /**
     * 
     * @param {type} imgs
     * @returns {String}
     * function: formater image
     */
    jQuery.extend($.fn.fmatter, {
        descargarFileDocumentoCriterio: function(cellvalue, options, rowdata) {
            var nombreArchivo = rowdata['documento'].nombreArchivo;
            var rutaAlfresco  = rowdata['documento'].rutaAlfresco;
            var idDetalleDocumentoCriterio = rowdata['idDetalleDocumentoCriterio'];
            var url = '';
            if(idDetalleDocumentoCriterio < 0){
                url = baseURL +'pages/mantenimiento/baseLegal/descargaArchivoCriterio?&idDetalleDocumentoCriterio='+idDetalleDocumentoCriterio;    
            }else{
                url = baseURL +'pages/documentoAdjunto/descargaArchivoAlfresco?nombreArchivo='+nombreArchivo+'&rutaAlfresco='+rutaAlfresco;
            }
            var sel = '<a class="link" href="'+url+'">'+
              '<img class="vam" width="17" height="18" src="'+baseURL+'images/stickers.png">'+
            '</a>';
            return sel;
        }
    });

    function abrirPopUpSubirArchivoObligacion() {
    	$('#divMensajeValidacionObligacionArchivo').css('display','none');
    	$('#fileNuevaOblNor').val('');
        $('#dialogCargarNuevaOblNor').dialog('open');
        document.getElementById('frmNuevaOblNorm').onsubmit = function() {
            return false;
        };
    }

    function cerrarPopUpSubirArchivoObligacion() {
        $('#dialogCargarNuevaOblNor').dialog('close');
    }

    function guardarArchivoObligacion() {
    	$("#formFileOblNor").submit();
//        nuevoBL.imgMuestraImagenArchivo.css("display","block");
//        nuevoBL.lblMuestraNombreArchivo.text(nuevoBL.fileImagenObligacion.val());
//        $('#dialogCargarNuevaOblNor').dialog('close');
    }

    function abrirPopUpSubirArchivoObligacionGuia() {
        $('#dialogDescGuiaOblNor').dialog('open');
    }

    function cerrarPopUpSubirArchivoObligacionGuia() {
        $('#dialogDescGuiaOblNor').dialog('close');
    }
    
    function guardarArchivoDescripcion() {
    	$("#formFileDesOblNor").submit();
    }
    /*Rsis 11 - Inicio*/
    function guardarArchivoInfraccion() {
    	$("#formFileInfraccion").submit();
    }
    /*Rsis 11 - Fin*/
    function abrirPopUpSubirArchivoDescripcion() {
    	$('#divMensajeValidacionArchivoDescripcion').css('display','none');
    	$('#fileDesOblNor').val('');
        $('#dialogCargarArchivoDescripcion').dialog('open');
    }
    /*Rsis 11 - Inicio*/
    function abrirPopUpSubirArchivoInfraccion() {
        $('#dialogCargarArchivoInfraccion').dialog('open');
    }
    /*Rsis 11 - Fin*/
    function cerrarPopUpSubirArchivoDescripcion() {
        $('#dialogCargarArchivoDescripcion').dialog('close');
    }

    function guardarArchivoObligacionGuia() {
        nuevoBL.imgMuestraImagenGuia.css("display","block");
        nuevoBL.lblMuestraNombreGuia.text(nuevoBL.fileImagenGuia.val());
        $('#dialogDescGuiaOblNor').dialog('close');
    }

    function abrirPopUpSubirArchivoObligacionPauta() {
        
        ///////////////////////////////////////////////////
        var filasTipificaciones = $("#gridTipificaciones").getRowData();        
        var validar = true;
        var divValidacion = $("#divMensajeValidacionDependenciaCriterio");
        var mensajeValidacion = "";
        if(filasTipificaciones.length == undefined || filasTipificaciones.length == 0){
            mensajeValidacion = "* Debe agregar alguna Tipificación <br>";   
        }
        if(mensajeValidacion != ""){
            divValidacion.show();
            divValidacion.focus();
            divValidacion.html(mensajeValidacion);
            abrirPopUpDependenciaCriterio();
            validar = false;
        }else{
            divValidacion.hide();
            divValidacion.html("");
        }
        if(validar){

    	var idsBaseLegalAsociarBaseLegal = "";
        var allRowsGrid = $("#gridCriterios").getRowData();

        if(allRowsGrid.length != undefined ){
            for(var x = 0; x<allRowsGrid.length; x++){
                idsBaseLegalAsociarBaseLegal += allRowsGrid[x].idCriterio + ",";
            }
            idsBaseLegalAsociarBaseLegal = idsBaseLegalAsociarBaseLegal.substring(0, idsBaseLegalAsociarBaseLegal.length - 1); 
        }
        if(idsBaseLegalAsociarBaseLegal == ""){
            idsBaseLegalAsociarBaseLegal = "0";
        }
        $('#idCriteriosJuntos').val(idsBaseLegalAsociarBaseLegal);
        
            validaNuevaBaseLegal.procesarGridCriterio();
            $('#dialogCriterios').dialog('open');
            

        }
    }

    function cerrarPopUpSubirArchivoObligacionPauta() {
        $('#dialogPauta').dialog('close');
        limpiandoDatosCriterios();
    }
    
    function abrirPopUpDependenciaCriterio() {
        $('#dialogDependenciaCriterio').dialog('open');
    }
    
    function cerrarPopUpDependenciaCriterio() {
        $('#dialogDependenciaCriterio').dialog('close');
    }
    
    function limpiandoDatosCriterios() {
        $('#codigoTipificacionPauta').val('');
        $('#codigoCriterio').val('');
        $.ajax({url: baseURL + "pages/mantenimiento/baseLegal/cleanDatosCriterio",
                type: 'get',
                success: function(data) {
                        
                        ocultaLoading();
                },
                error: errorAjax
            });
    }
    
    function limpiandoArchivoObligacion() {
//        $('#formFileOblNor').reset();
        document.getElementById('formFileOblNor').reset();
        $.ajax({url: baseURL + "pages/mantenimiento/baseLegal/cleanDatosObligacionArchivo",
                type: 'get',
                success: function(data) {
                        
                        ocultaLoading();
                },
                error: errorAjax
            });
    }
    
    /**
     * 
     * @returns {undefined}
     * function: Guarda Archivos by Criterio
     */
    function guardarArchivoCriterio() {
        guardarArchivo();
    }

    function comparaValor() {
        if (nuevoBL.txtCodigoTipificacionObligacion.val() === '2.1.6') {
            nuevoBL.txtIdTipificacion.val('14');
            nuevoBL.txtDescripcionTipificacionOblig.val('Técnicas y/o Seguridad');
            nuevoBL.txtSancionTipificacionObligacion.val('110');
            nuevoBL.txtBaseLegalTipificacionObligacion.val('RCD N°271-2012-OS-CD');
            nuevoBL.chkComisoBienes.attr('checked', true);
            nuevoBL.chkParalizacionObras.attr('checked', true);
            nuevoBL.chkCierreInstalacion.attr('checked', true);
            nuevoBL.chkSuspensionTemporal.attr('checked', true);
            nuevoBL.chkRetiroInstalacion.attr('checked', true);
            nuevoBL.chkCierreEstablecimiento.attr('checked', false);
            nuevoBL.chkSuspensionDefinitiva.attr('checked', false);
        } else if (nuevoBL.txtCodigoTipificacionObligacion.val() === '2.3') {
            nuevoBL.txtIdTipificacion.val('15');
            nuevoBL.txtDescripcionTipificacionOblig.val('Técnicas y/o Seguridad');
            nuevoBL.txtSancionTipificacionObligacion.val('300');
            nuevoBL.txtBaseLegalTipificacionObligacion.val('RCD N°271-2012-OS-CD');
            nuevoBL.chkComisoBienes.attr('checked', false);
            nuevoBL.chkParalizacionObras.attr('checked', true);
            nuevoBL.chkCierreInstalacion.attr('checked', false);
            nuevoBL.chkSuspensionTemporal.attr('checked', true);
            nuevoBL.chkRetiroInstalacion.attr('checked', true);
            nuevoBL.chkCierreEstablecimiento.attr('checked', true);
            nuevoBL.chkSuspensionDefinitiva.attr('checked', true);
        } else if (nuevoBL.txtCodigoTipificacionObligacion.val() === '2.14.3') {
            nuevoBL.txtDescripcionTipificacionOblig.val('Técnicas y/o Seguridad');
            nuevoBL.txtSancionTipificacionObligacion.val('150');
            nuevoBL.txtBaseLegalTipificacionObligacion.val('RCD N°271-2012-OS-CD');
            nuevoBL.chkComisoBienes.attr('checked', true);
            nuevoBL.chkParalizacionObras.attr('checked', false);
            nuevoBL.chkCierreInstalacion.attr('checked', false);
            nuevoBL.chkSuspensionTemporal.attr('checked', true);
            nuevoBL.chkRetiroInstalacion.attr('checked', true);
            nuevoBL.chkCierreEstablecimiento.attr('checked', true);
            nuevoBL.chkSuspensionDefinitiva.attr('checked', true);
        } else if (nuevoBL.txtCodigoTipificacionObligacion.val() === '2.1.5') {
            nuevoBL.txtDescripcionTipificacionOblig.val('Técnicas y/o Seguridad');
            nuevoBL.txtSancionTipificacionObligacion.val('280');
            nuevoBL.txtBaseLegalTipificacionObligacion.val('RCD N°271-2012-OS-CD');
            nuevoBL.chkComisoBienes.attr('checked', true);
            nuevoBL.chkParalizacionObras.attr('checked', false);
            nuevoBL.chkCierreInstalacion.attr('checked', false);
            nuevoBL.chkSuspensionTemporal.attr('checked', true);
            nuevoBL.chkRetiroInstalacion.attr('checked', true);
            nuevoBL.chkCierreEstablecimiento.attr('checked', true);
            nuevoBL.chkSuspensionDefinitiva.attr('checked', true);
        } else if (nuevoBL.txtCodigoTipificacionObligacion.val() === '3.1.4') {
            nuevoBL.txtDescripcionTipificacionOblig.val('Autorizaciones y Registros');
            nuevoBL.txtSancionTipificacionObligacion.val('15');
            nuevoBL.txtBaseLegalTipificacionObligacion.val('RCD N°271-2012-OS-CD');
            nuevoBL.chkComisoBienes.attr('checked', true);
            nuevoBL.chkParalizacionObras.attr('checked', true);
            nuevoBL.chkCierreInstalacion.attr('checked', false);
            nuevoBL.chkSuspensionTemporal.attr('checked', true);
            nuevoBL.chkRetiroInstalacion.attr('checked', true);
            nuevoBL.chkCierreEstablecimiento.attr('checked', false);
            nuevoBL.chkSuspensionDefinitiva.attr('checked', false);
        } else if (nuevoBL.txtCodigoTipificacionObligacion.val() === '3.2.4') {
            nuevoBL.txtDescripcionTipificacionOblig.val('Autorizaciones y Registros');
            nuevoBL.txtSancionTipificacionObligacion.val('450');
            nuevoBL.txtBaseLegalTipificacionObligacion.val('RCD N°271-2012-OS-CD');
            nuevoBL.chkComisoBienes.attr('checked', true);
            nuevoBL.chkParalizacionObras.attr('checked', false);
            nuevoBL.chkCierreInstalacion.attr('checked', true);
            nuevoBL.chkSuspensionTemporal.attr('checked', true);
            nuevoBL.chkRetiroInstalacion.attr('checked', true);
            nuevoBL.chkCierreEstablecimiento.attr('checked', true);
            nuevoBL.chkSuspensionDefinitiva.attr('checked', true);
        } else if (nuevoBL.txtCodigoTipificacionObligacion.val() === '2.4') {
            nuevoBL.txtDescripcionTipificacionOblig.val('Técnicas y/o Seguridad');
            nuevoBL.txtSancionTipificacionObligacion.val('350');
            nuevoBL.txtBaseLegalTipificacionObligacion.val('RCD N°271-2012-OS-CD');
            nuevoBL.chkComisoBienes.attr('checked', false);
            nuevoBL.chkParalizacionObras.attr('checked', true);
            nuevoBL.chkCierreInstalacion.attr('checked', false);
            nuevoBL.chkSuspensionTemporal.attr('checked', true);
            nuevoBL.chkRetiroInstalacion.attr('checked', true);
            nuevoBL.chkCierreEstablecimiento.attr('checked', true);
            nuevoBL.chkSuspensionDefinitiva.attr('checked', true);
        } else if (nuevoBL.txtCodigoTipificacionObligacion.val() === '2.5') {
            nuevoBL.txtDescripcionTipificacionOblig.val('Técnicas y/o Seguridad');
            nuevoBL.txtSancionTipificacionObligacion.val('600');
            nuevoBL.txtBaseLegalTipificacionObligacion.val('RCD N°271-2012-OS-CD');
            nuevoBL.chkComisoBienes.attr('checked', false);
            nuevoBL.chkParalizacionObras.attr('checked', true);
            nuevoBL.chkCierreInstalacion.attr('checked', false);
            nuevoBL.chkSuspensionTemporal.attr('checked', true);
            nuevoBL.chkRetiroInstalacion.attr('checked', true);
            nuevoBL.chkCierreEstablecimiento.attr('checked', true);
            nuevoBL.chkSuspensionDefinitiva.attr('checked', true);
        } else {
            nuevoBL.txtDescripcionTipificacionOblig.val('');
            nuevoBL.txtSancionTipificacionObligacion.val('');
            nuevoBL.txtBaseLegalTipificacionObligacion.val('');
            nuevoBL.chkComisoBienes.attr('checked', false);
            nuevoBL.chkParalizacionObras.attr('checked', false);
            nuevoBL.chkCierreInstalacion.attr('checked', false);
            nuevoBL.chkSuspensionTemporal.attr('checked', false);
            nuevoBL.chkRetiroInstalacion.attr('checked', false);
        }
    }
    
    function guardarCriterio(){
	    var validar = $('#formCriterio').validateAllForm("#divMensajeValidacionOblCriterio");
        var idTipificacion = $('#codigoTipificacionPauta').val();
        var divValidacion = $('#divMensajeValidacionCriterio');
        if(idTipificacion === ""){
            divValidacion.show();
            divValidacion.focus();
            divValidacion.html("* Debe seleccionar una Tipificación");
            validarCriterio = false;
        }else{
            divValidacion.hide();
            divValidacion.html("");
        }
        if (validarCriterio) {
            var idCriterio = $('#codigoCriterio').val();
            if(idCriterio == "" || idCriterio == null){
                idCriterio = -1;
            } 
            $.ajax({
                url: baseURL + "pages/mantenimiento/baseLegal/registrarCriterio",
                type: 'post',
                async: false,
                data: {
                    idObligacion: $('#idObligacion').val(),
                    idTipificacion: $('#codigoTipificacionPauta').val(),
                    descripcionCriterio: $('#nueva_DescripcionPauta').val(),
                    idCriterio: idCriterio,
//                    sancionMonetaria:$('#spinhastaOblNor').val(),
                    codTrazabilidad:$('#codTrazabilidad').val()
                },
                beforeSend: muestraLoading,
                success: function(data) {
                    if (data.resultado == 0) {
                        mensajeGrowl("success", data.mensaje);
                        $('#dialogPauta').dialog('close');
                        ocultaLoading();
                        recargarGridCriterios();
                        limpiandoDatosCriterios();
                    } else if(data.resultado == 1) {
                        mensajeGrowl('error',data.mensaje);
                        $('#dialogPauta').dialog('close');
                        ocultaLoading();
                    }
                },
                error: errorAjax
            });
        }
    }
    
    /**
     * 
     * @returns {undefined}
     * function: Add Files .pdf to register
     */
    function guardarArchivo() {
        var validarCriterio = $('#formNuevoCriterio').validateAllForm('#divMensajeValidacionCriterioArchivo');
        var divValidacion = $('#divMensajeValidacionCriterioArchivo');
        var file = document.getElementById('filePauta');
        if(file.files.length == 0){
            divValidacion.show();
            divValidacion.focus();
            divValidacion.html("* Debe Cargar un archivo");
            validarCriterio = false;
        }else{
            divValidacion.hide();
            divValidacion.html("");
        }
        if(validarCriterio){
            $("#formPauta").submit();
        }
    }
    
    function enviarDatosArchivoCriterio(data) {
        if (data.error) {
            mensajeGrowl("error", "Error", data.mensaje);
        } else {
            enviarDatosCriterio();
        }
    }
    
    function enviarDatosCriterio() {
        var idCriterio = $('#codigoCriterio').val();
        if(idCriterio == "" || idCriterio == null){
            idCriterio = -1;
        }
        $.ajax({
            url: baseURL + "pages/mantenimiento/baseLegal/registrarArchivoCriterio",
            type: 'post',
            async: false,
            data: {
                nombreArchivo: $('#nueva_TituloPauta').val(),
                idCriterio: idCriterio
            },
            beforeSend: muestraLoading,
            success: function(data) {
                if (data.resultado == 0) {
                    mensajeGrowl("success", "Se registró correctamente", "Se registrarón los datos correctamente");
                    recargarGridArchivoCriterios();
                    $('#nueva_TituloPauta').val('');
                    ocultaLoading();
                } else {
                    mensajeGrowl('error', "Error en el insertar", 'Intente de nuevo');
                    ocultaLoading();
                }
            },
            error: errorAjax
        });
    }
    
    /**
     * 
     * @returns {undefined}
     */
    function gridListadoSancionesEspecificas() {
        var nombres = ['Id','Sanción Específica'];
        var columnas = [
            {name: "idDetalleCriterio", sortable: false, align: "center",hidden:true},
            {name: "sancionEspecifica", sortable: false, align: "center",hidden:false}
            ];
        $("#gridContenedorSancionEspecifica").html("");
        var grid = $("<table>", {
            "id": "gridSancionEspecifica"
        });
        $("#gridContenedorSancionEspecifica").append(grid);
        var idCriterio = $('#codigoCriterio').val();
        if(idCriterio == "" || idCriterio == null){
            idCriterio = -1;
        }
        var postData = {idCriterio:idCriterio};
        grid.jqGrid({
            url: baseURL + "pages/mantenimiento/baseLegal/findSancionEspecifica",
            datatype: "json",
            postData: postData,
            hidegrid: false,
            rowNum: 100,
            //pager: "",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            height: "auto",
            viewrecords: true,
            caption: "",
            width: 550,
            jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros"},
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                var row = grid.jqGrid('getRowData', rowid);
                $('#linkEliminarSancionEspecifica').attr('onClick', 'nuevaObligacionNormativa.eliminarSancionEspecifica("' + row.idDetalleCriterio + '")');
            },
            loadComplete: function(data, rowid) {
                $('#contextMenuSancionEspecifica').parent().remove();
                $('#divContextMenuSancionEspecifica').html("<ul id='contextMenuSancionEspecifica'>"
                        + "<li> <a id='linkEliminarSancionEspecifica' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                        + "</ul>");
                $('#contextMenuSancionEspecifica').puicontextmenu({
                    //target: $('#gridObligacionNormativa').find('tr').not('.ui-subgrid,.ui-subgrid tr')
                    target: $('#gridSancionEspecifica')
                });
            }
        });
    }
    function eliminarSancionEspecifica(idDetalleCriterio){
        var URL = baseURL + "pages/mantenimiento/baseLegal/eliminarSancionEspecifica";
        $.get( URL,{idDetalleCriterio:idDetalleCriterio, idCriterio :$('#codigoCriterio').val(),codTrazabilidad:$('#codTrazabilidad').val()},
        function(data) {
           if (data.resultado == 0) {
               gridListadoSancionesEspecificas();
           }
        });
        
    }
    
    /**
     * 
     * @returns {undefined}
     * function: create Grid gridAsociaBasesLegales
     */
    function procesarGridAsociaBaseLegal() {
    	
    	var nombres = ['Id','IdBaseLegal','Codigo Base Legal','Descripción Base Legal'];
        var columnas = [
           {name: "idOblBase", width: 130, sortable: false, align: "center", hidden: true},
           {name: "idBaseLegal", width: 130, sortable: false, align: "center", hidden: true},
           {name: "codigoBaseLegal", width: 140, sortable: false, align: "center"},
           {name: "descripcion", width: 740, sortable: false, align: "left"}
        ];
        $("#gridContenedorBasesLegalesAsociadas").html("");
        var grid = $("<table>", {"id": "gridAsociaBasesLegales"});
        var pager = $("<div>", { "id": "paginacionAsociaBasesLegales" });
        $("#gridContenedorBasesLegalesAsociadas").append(grid).append(pager);
        grid.jqGrid({
        	url: baseURL + "pages/mantenimiento/baseLegal/listarBaseLegalByObligacion",
            datatype: "json",
            postData: {idObligacion:$('#idObligacion').val(),varLista:1},
            hidegrid: false,
            rowNum: 5,
            pager: "#paginacionAsociaBasesLegales",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
//            autoHeight: true,
            viewrecords: false,
            //caption: "",
            width: '880px',
            jsonReader: {
                root: "filas",
                page: "pagina",
                total: "total",
                records: "registros"
            },
            onSelectRow: function(rowid, status) {
                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                var row = grid.jqGrid('getRowData', rowid);
                $('#linkEliminarBaseAsociada').attr('onClick', 'nuevaObligacionNormativa.eliminarBaseLegalAsociadaConfirm("' + rowid + '")');
                
                if($('#divEnlaceTagEliminarReferenciaObligacion input').html()!=null){
                    $('#contextMenuBasesLegalesAsociadas li a[value="EL-GRIDREFERENCIAOBLIGACION"]').html($('#divEnlaceTagEliminarReferenciaObligacion').html());               
                }else {
                 	  $('#contextMenuBasesLegalesAsociadas li a[value="EL-GRIDREFERENCIAOBLIGACION"]').remove();
                 	 $('#contextMenuBasesLegalesAsociadas').parent().css('opacity',0);
                }
            },
            loadComplete: function(data) {
            	$('#contextMenuBasesLegalesAsociadas').parent().css('opacity',1);
                $('#contextMenuBasesLegalesAsociadas').parent().remove();
                if(nuevaObligacionNormativa.modoVisualizacion != modoVer){
                    $('#divContextMenuBasesLegalesAsociadas').html("<ul id='contextMenuBasesLegalesAsociadas'>"
                    		 + "<li> <a value='EL-GRIDREFERENCIAOBLIGACION'></a></li>"
//                            + "<li> <a id='linkEliminarBaseAsociada' data-icon='ui-icon-trash' title='Eliminar Base Legal'>Eliminar</a></li>"
                            + "</ul>");
                    $('#contextMenuBasesLegalesAsociadas').puicontextmenu({
                        //target: $('#gridObligacionNormativa').find('tr').not('.ui-subgrid,.ui-subgrid tr')
                        target: $('#gridAsociaBasesLegales')
                    });                    
                }
            }
        });
        
    }
    
    function eliminarBaseLegalAsociadaConfirm(rowid){
    	/* modif jpiro 20150106 - ini */
        confirm.start();
        /* modif jpiro 20150106 - fin */
        confirm.open("¿Ud est&aacute; seguro de eliminar la Base Legal Asociada ?",
                "nuevaObligacionNormativa.eliminarBaseLegalAsociada('" + rowid + "')");
    }
    function eliminarBaseLegalAsociada(rowid){
        var row = $('#gridAsociaBasesLegales').jqGrid('getRowData', rowid);
        idAsocEliminar=row.idOblBase;
        idBaseLegal=row.idBaseLegal;
        idObligacion=$('#idObligacion').val();
        getEliminarBaseLegalAsociada(idAsocEliminar,idBaseLegal,idObligacion);
    }
    function getEliminarBaseLegalAsociada(idAsocEliminar,idBaseLegal,idObligacion) {
        var URL = baseURL + "pages/mantenimiento/baseLegal/eliminarBaseLegalAsociada";
        $.get(URL,{idAsocObligacion:idAsocEliminar,idBaseLegal:idBaseLegal,idObligacion:idObligacion,codTrazabilidad:$('#codTrazabilidad').val()}, function(data) {
            if (data.resultado == 0) {
                mensajeGrowl("success", data.mensaje);
                nuevaObligacionNormativa.procesarGridAsociaBaseLegal();
            }else if (data.resultado == 1) {
            	mensajeGrowl("error", data.mensaje);
            }
        });
    }
    
    function capturarCodigo(codigo) {
        $('#codigoTipificacionPauta').val(codigo);
    }
    
    function verBusqAvanObligacion(){
    	
    }
    
    return{
    	eliminarBaseLegalAsociada:eliminarBaseLegalAsociada,
    	eliminarBaseLegalAsociadaConfirm:eliminarBaseLegalAsociadaConfirm,
    	eliminarConfiguracionConfirm:eliminarConfiguracionConfirm,
    	/*Rsis 14 - Inicio*/
    	eliminarIncumplimiento:eliminarIncumplimiento,
    	/*Rsis 14 - Fin*/
    	eliminarConfiguracion:eliminarConfiguracion,
    	eliminarPreConf:eliminarPreConf,
    	gridConfiguracionObligacion:gridConfiguracionObligacion,
        eliminarSancionEspecifica:eliminarSancionEspecifica,
        confirmEliminarCriterio:confirmEliminarCriterio,
        confirmEliminarTipificacion:confirmEliminarTipificacion,
//        consultaAjax:consultaAjax,
        capturarCodigo: capturarCodigo,
        gridTipificacion: gridTipificacion,
        /*Rsis 14 - Inicio*/
        //gridIncumplimiento: gridIncumplimiento,
        /*Rsis 14 - Fin*/
        gridPautaSancionTipificacion: gridPautaSancionTipificacion,
        eliminarPautaSancion: eliminarPautaSancion,
        eliminarTipificacion: eliminarTipificacion,
        editarCriterio: editarCriterio,
        eliminarCriterio: eliminarCriterio,
        eliminarArchivo: eliminarArchivo,
        comparaValor: comparaValor,
        constructor: constructor,
        gridArchivosCriterio: gridArchivosCriterio,
        gridCriterio: gridCriterio,
        procesarGridAsociaBaseLegal:procesarGridAsociaBaseLegal,
        consultarObligacion:consultarObligacion,
        recargarGriTipificacion:recargarGriTipificacion,
        listarTemasByIdObligacion:listarTemasByIdObligacion,
        initArbolActividades:initArbolActividades,
        recargarGriTipificacion:recargarGriTipificacion,
        limpiandoDatosCriterios:limpiandoDatosCriterios,
        recargarGridCriterios:recargarGridCriterios,
        gridListadoSancionesEspecificas:gridListadoSancionesEspecificas,
        limpiandoArchivoObligacion:limpiandoArchivoObligacion,
        modoVisualizacion:modoVisualizacion,
        verBusqAvanObligacion:verBusqAvanObligacion,
        obtenerTipificacion:obtenerTipificacion

    };
})();
var cargaInicial=(function(){
	function constructor(){
		obtenerTipoAnexos();
		$("#btnAgregarNormaTecnica").css("display","none");
		obtenertipoNormaLegal();
		obtenerSiglas();
		
		var tipoAnexo = $("#cmbHideTipoAnexoBaseLegal").val();				
		obtenerTipoNormaTecnica();
		obtenerNormaLegalPadre();
		/*Rsis 11 - Inicio*/
		obtenerMedidaSeguridad();
		obtenerAccionInfraccion();
		obtenerEscenario();		
		
		//var codigo = $("#cmbHideTipoAnexoBaseLegal").val();
		//var codigo=$("#cmbTipAneBaseLegal").find(':checked').attr('codigo');
		//var codigo=$( "#cmbTipAneBaseLegal option:selected" ).val();
		//var codigo=$("#cmbTipAneBaseLegal").val();
		//var codigo=$("#cmbTipAneBaseLegal").val();
		
		/*Rsis 11 - Fin*/	
		/*Rsis 12 - Inicio*/
		$(".accordion-titulo").click(function(){
				
		   var contenido=$(this).next(".accordion-content");
					
		   if(contenido.css("display")=="none"){ //open		
		      contenido.slideDown(250);			
		      $(this).addClass("open");
		   }
		   else{ //close		
		      contenido.slideUp(250);
		      $(this).removeClass("open");	
		  }
									
		});
		/*Rsis 12 - Inicio*/
//		obtenerCriticidadObligacion();
		/*jsifuentes - Inicio*/
		cargarDetalleNormaTecnica();
		/*jsifuentes - Fin*/
		setTimeout(function(){ obtenerNumeroAnexos();}, 500);
		// Inicio MYC-7 Cambio de Alcance
		$('#cmbTipAneBaseLegal').change(function() {
		if ($('#cmbTipAneBaseLegal option:selected').text() == '--Seleccione--') {
        	nuevoBL.dateFechaVigenciaArtNormaLegal.removeAttr('disabled');
        	$('#cmbNumeroAnexo').css("display","none");
        	$('#lblNumeroAnexo').css("display","none");
        	gestionBaseLegal.validaComboTipoAnexoBaseLegalFalse(false);
        	nuevoBL.divAnexoNormaLegal.css("display","none");
        	nuevoBL.txtArticuloAnexoNormaLegal.val("");
        	nuevoBL.txtIncisoUnoAnexoNormaLegal.val("");
        	nuevoBL.txtIncisoDosAnexoNormaLegal.val("");
        	nuevoBL.dateFechaVigenciaAnexoNormaLegal.val("");
        	
        } else {
        	nuevoBL.dateFechaVigenciaArtNormaLegal.val('');
    		nuevoBL.dateFechaVigenciaArtNormaLegal.attr('disabled','disabled');
    		$('#lblNumeroAnexo').css("display","inline-block");
        	$('#cmbNumeroAnexo').css("display","inline-block");	
        	gestionBaseLegal.validaComboTipoAnexoBaseLegalTrue(true);
        	nuevoBL.cmbNumeroAnexo.removeAttr('disabled');
        	nuevoBL.divAnexoNormaLegal.css("display","block");
            nuevoBL.txtArticuloAnexoNormaLegal.removeAttr('disabled', 'disabled');
            nuevoBL.dateFechaVigenciaAnexoNormaLegal.removeAttr('disabled', 'disabled');

            gestionBaseLegal.validaArticuloAnexoBaseLegal(true);
        	
        }   		
		obtenerNumeroAnexos();
        });  
		//Fin MYC-7 Cambio de Alcance
		
	}
	/**
     * 
     * @returns {undefined}
     */
    function obtenertipoNormaLegal() {
        $.getJSON("mantenimiento/baseLegal/obtenerTipoNormaLegal", {
            //idActividad: idActividad,
            ajax: 'true',
            async: true
        }, function(data) {
            var html = '<option value="-1">--Seleccione--</option>';
            var len = data.length;
            for (var i = 0; i < len; i++) {
                if (data[i].idMaestroColumna == $('#cmbHideTipoBaseLegal').val()) {
                    html += '<option value="' + data[i].idMaestroColumna + '" selected="selected">'
                            + data[i].descripcion + '</option>';
                } else {
                    html += '<option value="' + data[i].idMaestroColumna + '">'
                            + data[i].descripcion + '</option>';
                }
            }
            $('#cmbTipBaseLegal').html(html);
        });
    }
    function obtenerNormaLegalPadre() {
        $.getJSON("mantenimiento/baseLegal/obtenerNormaLegalPadre", {
            //idActividad: idActividad,
            ajax: 'true',
            async: true
        }, function(data) {
            var html = '<option value="">--Seleccione--</option>';
            var len = data.length;
            
            for (var i = 0; i < len; i++) {
                if (data[i].idBaseLegal == $('#cmbHideNormaLegal').val()) {
                    html += '<option value="' + data[i].idBaseLegal + '" selected="selected">'
                            + data[i].descripcionGeneralBaseLegal + '</option>';
                } else {
                    html += '<option value="' + data[i].idBaseLegal + '">'
                            + data[i].descripcionGeneralBaseLegal + '</option>';
                }
            }
            $('#cmbNormaLegal').html(html);
        });
    }
    /**
     * 
     */
    function obtenerSiglas() {
        $.getJSON("mantenimiento/baseLegal/obtenerSigla", {
            //idActividad: idActividad,
            ajax: 'true',
            async: true
        }, function(data) {
            var html = '<option value="-1">--Seleccione--</option>';
            var len = data.length;
            
            for (var i = 0; i < len; i++) {
                if (data[i].idMaestroColumna == $('#cmbHideSiglaBaseLegal').val()) {
                    html += '<option value="' + data[i].idMaestroColumna + '" selected="selected">'
                            + data[i].descripcion + '</option>';
                } else {
                    html += '<option value="' + data[i].idMaestroColumna + '">'
                            + data[i].descripcion + '</option>';
                }
            }
            $('#cmbSigBaseLegal').html(html);
        });
    }
    /**
     * 
     */
    function obtenerTipoAnexos() {
        $.getJSON("mantenimiento/baseLegal/obtenerTipoAnexo", {
            //idActividad: idActividad,
            ajax: 'true',
            async: false
        }, function(data) {
            var html = '<option value="-1">--Seleccione--</option>';
            var len = data.length;
            var codigo= [];
            for (var i = 0; i < len; i++) {
                if (data[i].idMaestroColumna == $('#cmbHideTipoAnexoBaseLegal').val()) {
                    html += '<option value="' + data[i].idMaestroColumna + '" codigo="'+data[i].codigo+'" selected="selected">'
                            + data[i].descripcion + '</option>';
                   
                } else {
                	
                	 html+='<option value="'+data[i].idMaestroColumna+'" codigo="'+data[i].codigo+'">'+data[i].descripcion+'</option>';
                    
                }
            }
            $('#cmbTipAneBaseLegal').html(html);
            html = '<option value="0">--Seleccione--</option>';
            $("#cmbNumeroAnexo").html(html);
        	});  
     }
    
    /*Rsis1 - Inicio*/
    function obtenerNumeroAnexos(){           
        var url = "mantenimiento/baseLegal/obtenerNumeroAnexo";
        $.getJSON(url,
            {codTipoAnexo: $('#cmbTipAneBaseLegal').find(':checked').attr('codigo')}, 
            function(data) {
            var html = '<option value="">--Seleccione--</option>';
            var len = data.length;           
            for (var i = 0; i < len; i++) {
            	if (data[i].codigo== $('#cmbHideNumeroAnexo').val() || data[i].codigo== $('#cmbHideNumeroAnexo').val() || data[i].codigo== $('#cmbHideNumeroAnexo').val()){
                html += '<option value="' + data[i].codigo+ '" selected="selected">'
                        + data[i].descripcion + '</option>';
            	}else{
            		html += '<option value="' + data[i].codigo+ '">'
                    + data[i].descripcion + '</option>';
            	}            
            }  
            $("#cmbNumeroAnexo").html(html);
            if(flagBaseLegal=="editar"){
            	gestionBaseLegal.concatenaDescripcionBaseLegal();
                console.info('concatena nuevamente editar');
            }
            if(flagBaseLegal=="nuevo"){
            	gestionBaseLegal.concatenaDescripcionBaseLegal();
            	console.info('concatena nuevamente ver');
            }
            
        });
    }     
    /*Rsis1 - Fin*/
    
    
    /*Rsis 11 - Inicio*/
    function obtenerMedidaSeguridad() {
        $.getJSON(baseURL+"pages/maestroColumna/obtenerMedidaSeguridad", {
            //idActividad: idActividad,
            ajax: 'true',
            async: true
        }, function(data) {
            var html = '<option value="-1">--Seleccione--</option>';
            var len = data.length;
            for (var i = 0; i < len; i++) {
            		/* OSINE_SFS-610 - Inicio */
            	    //html += '<option value="' + data[i].idMaestroColumna + '">'
            		//+ data[i].descripcion + '</option>'; 
            		if (data[i].codigo == variable.infraccion){
            			html += '<option value="' + data[i].idMaestroColumna + '" codigo="'+data[i].codigo+'" selected="selected">'
            			+ data[i].descripcion + '</option>'; 
            		}else{
            			html += '<option value="' + data[i].idMaestroColumna + '"  codigo="'+data[i].codigo+'" >'
            			+ data[i].descripcion + '</option>'; 
            		}
                   /* OSINE_SFS-610 - Fin */
                }            
            $('#cmbMedidaSeguirdad').html(html);                       
        });
    }
    
    function obtenerAccionInfraccion() {    	
        $.getJSON(baseURL+"pages/maestroColumna/obtenerAccionInfraccion", {
            //idActividad: idActividad,
            ajax: 'true',
            async: true
        }, function(data) {
            var html = '<option value="-1">--Seleccione--</option>';
            var len = data.length;
            for (var i = 0; i < len; i++) {            	                   
            		/* OSINE_SFS-610 - Inicio */
                    //html += '<option value="' + data[i].idMaestroColumna + '">'
                    //        + data[i].descripcion + '</option>';
	            	if (data[i].codigo == variable.infraccion){
	            		html += '<option value="' + data[i].idMaestroColumna + '" codigo="'+data[i].codigo+'" selected="selected">'
	                    + data[i].descripcion + '</option>';
	            	}else{
	            		html += '<option value="' + data[i].idMaestroColumna + '" codigo="'+data[i].codigo+'">'
	                    + data[i].descripcion + '</option>';
	            	}
                    /* OSINE_SFS-610 - Inicio */
                }            
            $('#cmbAccionInfraccion').html(html);                       
        });
    }
    
    function obtenerEscenario() {    	    	
        $.getJSON(baseURL+"pages/maestroColumna/obtenerEscenario", {
            //idActividad: idActividad,
            ajax: 'true',
            async: true
        }, function(data) {
            var html = '<option value="-1">--Seleccione--</option>';
            var len = data.length;
            for (var i = 0; i < len; i++) {                
                    html += '<option value="' + data[i].idMaestroColumna + '" selected="selected">'
                            + data[i].descripcion + '</option>';
                }            
            $('#cmbEscenario').html(html);                       
        });
    }
    /*Rsis 11 - Fin*/
    
    /*jsifuentes - Inicio*/
    function cargarDetalleNormaTecnica() {    	
    	var mydata = null;
    	if (detalleNormaTecnicaDTO == ""){
    		mydata=[];
        }else{
        	mydata = detalleNormaTecnicaDTO;
        }
         
    	
    	$("#tblNormaTecnica").jqGrid({
    	    data: mydata,
    	    datatype: "local",
    	    height: 150,
    	    rowNum: 5,
    	    hidegrid: false,
    	    	/* OSINE_SFS-610 - Inicio */
    	       //colNames:['idDetalleNormaTecnica', 'idTipoNormaTecnica', 'Tipo De Norma Técnica','Descripcion De La Norma Técnica'],
    	    	colNames:['idDetalleNormaTecnica', 'idTipoNormaTecnica', 'Tipo De Norma T&eacute;cnica','Descripci&oacute;n De La Norma T&eacute;cnica'],
    	       /* OSINE_SFS-610 - Fin */
    	       colModel:[
                   {name:'idDetalleNormaTecnica',index:'idDetalleNormaTecnica', width:300,hidden: true},
                   {name:'idTipoNormaTecnica',index:'idTipoNormaTecnica', width:300,hidden: true},
    	           {name:'descripcionIdTipoNormaTecnica',index:'descripcionIdTipoNormaTecnica', width:300, align:"center"},
    	           {name:'descripcionNorma',index:'descripcionNorma', width:600, align:"center"}
    	       ],
    	       pager: "#pNormaTecnica",
    	       viewrecords: true,
    	       /* OSINE_SFS-610 - Inicio */
    	       //caption: "Relacion Norma Técnica"
    	       caption: "Relaci&oacute;n Norma T&eacute;cnica"
    	       /* OSINE_SFS-610 - Fin */
    	});	
    }
    /*jsifuentes - Fin*/
    
    /**
     * 
     */
    function obtenerTipoNormaTecnica() {
        $.getJSON("mantenimiento/baseLegal/obtenerTipoNormaTecnica", {
            //idActividad: idActividad,
            ajax: 'true',
            async: true
        }, function(data) {
            var html = '<option value="-1">--Seleccione--</option>';
            var len = data.length;
            for (var i = 0; i < len; i++) {
                if (data[i].idMaestroColumna == $('#cmbHideNormaTecnicaBaseLegal').val()) {
                    html += '<option value="' + data[i].idMaestroColumna + '" selected="selected">'
                            + data[i].descripcion + '</option>';
                } else {
                    html += '<option value="' + data[i].idMaestroColumna + '">'
                            + data[i].descripcion + '</option>';
                }
            }
            $('#cmbNorTecBaseLegal').html(html);
        });
    }
    /**
     * 
     */
    function obtenerCriticidadObligacion() {
        $.getJSON("mantenimiento/baseLegal/obtenerCriticidad", {
            //idActividad: idActividad,
            ajax: 'true',
            async: true
        }, function(data) {
            var html = '<option value="-1">--Seleccione--</option>';
            var len = data.length;
            for (var i = 0; i < len; i++) {
            	if (data[i].idMaestroColumna == $('#cmbHideCriticidadObligacion').val()) {
                    html += '<option value="' + data[i].idMaestroColumna + '" selected="selected">'
                            + data[i].descripcion + '</option>';
                } else {
                    html += '<option value="' + data[i].idMaestroColumna + '">'
                            + data[i].descripcion + '</option>';
                }
            }
            $('#cmbCriOblNor').html(html);
        });
    }
// 05-11-2015    
    function obtenerTipificacionToCriterio(idObligacion){
    	
   	 $.getJSON("mantenimiento/baseLegal/obtenerTipificacionToCriterio", {
            idObligacion: idObligacion,
            ajax: 'true',
            async: true
     },    
     function(data) {
            var html = '<option value="">--Seleccione--</option>';
            var len = data.length;
            if(len>0){
            	for (var i = 0; i < len; i++) {
                	if (data[i].idTipificacion == $('#cmbTipiCriterio').val()) {
                        html += '<option value="' + data[i].idTipificacion + '" selected="selected">'
                                + data[i].codTipificacion + '</option>';
                    } else {
                        html += '<option value="' + data[i].idTipificacion + '">'
                                + data[i].codTipificacion + '</option>';
                    }
                }
            }
            
            $('#cmbTipiCriterio').html(html);
      });
   }
    
    function obtenerTipificacion(idTipificacion) {
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
                        html += '<div style="float:left; margin-right:10px; padding: 5px 25px;width:215px;">';
                        html += '<input id="rdProceso' + idTipoSancion + '" type="checkbox" name="proceso" value="' + idTipoSancion + '" class="checkbox" />';
                        html += '<label for="rdProceso' + idTipoSancion + '" class="checkbox">' + descripcionSancion + '</label>';
                        html += '</div>';
                    }
                    $('#divEtapa').html(html);
                    $("#divEtapa").css('display','inline-block');
                    $('#divProcesosCriterio').css('display','block');
                }else{
                    $('#divProcesosCriterio').css('display','none');
                }
            },
            error:errorAjax
        });
      } 
    
//    
    return{
    	obtenerCriticidadObligacion:obtenerCriticidadObligacion,
    	constructor:constructor,
// 05-11-2015    	
    	obtenerTipificacionToCriterio:obtenerTipificacionToCriterio,
    	obtenerTipificacion:obtenerTipificacion,
    	obtenerNumeroAnexos:obtenerNumeroAnexos
//
    };
})();
var validaNuevaBaseLegal = (function() {
    var codEliminarObligacion;
    function procesarGridObligConcordancia() {
        $("#gridContenedorObligConcordancia").html("");
        var grid = $("<table>", {
            "id": "gridObligConcordancia"
        });
        
        $("#gridContenedorObligConcordancia").append(grid);

        var nombres = ['ID', 'Código Base Legal','Descripción Base Legal',''];
        var columnas = [
            {name: "idBaseLegal", width: 130, sortable: false, align: "center", hidden: true},
            {name: "codigoBaseLegal", width: 100, sortable: false, align: "center"},
            {name: "descripcionGeneralBaseLegal", width: 812, sortable: false, align: "left"},
            {name: "check",width: 50,sortable: false,align: "center",formatter: "imgCheckNameBaseLegal",hidden:true}
         ];
        grid.jqGrid({
//        	url: baseURL + "pages/baseLegal/comnon/busquedaAvanzada/asignarBasesLegales",
        	url: baseURL + "pages/mantenimiento/baseLegal/listarBaseLegalConcordancia",
            datatype: "json",
//            data:datajson,
            postData: {idBaseLegal:$('#txtidBaseLegal').val(),varLista:1},
            hidegrid: false,
            rowNum: 100,
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            height: "auto",
            viewrecords: true,
            caption: "Listado de Bases Legales en Concordancia",
            autowidth: true,
            jsonReader: {
                root: "filas",
                page: "pagina",
                total: "total",
                records: "registros",
                id:"idBaseLegal"
            },
            onSelectRow: function(rowid, status) {
//                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                //var row = grid.jqGrid('getRowData', rowid);
                $('#linkEliminarBaseLegalConcordancia').attr('onclick','validaNuevaBaseLegal.confirmEliminarBaseLegalConcordancia("' + rowid + '")');
                
            },
            loadComplete: function(data) {
                $('#contextMenuObligConcordancia').parent().remove();
                if(flagBaseLegal=="ver"){
                	
                }else{
                	$('#divContextMenuObligConcordancia').html("<ul id='contextMenuObligConcordancia'>"
                            + "<li> <a id='linkEliminarBaseLegalConcordancia' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                            + "</ul>");
                    $('#contextMenuObligConcordancia').puicontextmenu({
                        target: $('#gridObligConcordancia')
                    });
                	
                }
                if(jQuery("#gridObligConcordancia").getDataIDs().length!=0 && jQuery("#gridObligConcordancia").getDataIDs().length!=null){
                	gestionBaseLegal.concatenaDescripcionBaseLegal();
                }
                
              var idsConcordancia = "";
//              var dataTblConcordancia = $('#gridObligConcordancia').getGridParam('data');
              var dataTblConcordancia = $("#gridObligConcordancia").getRowData();
              
              $.each(dataTblConcordancia,function(k,v){
              	idsConcordancia += "," + (v.idBaseLegal) ;
              });
              $('#txtidBaseLegalConcordancia').val(idsConcordancia);
              
            },
          
        });
        
//        var idsConcordancia = "";
////        var dataTblConcordancia = $('#gridObligConcordancia').getGridParam('data');
//        var dataTblConcordancia = $("#gridObligConcordancia").getRowData();
//        console.log(dataTblConcordancia);
//        $.each(dataTblConcordancia,function(k,v){
//        	idsConcordancia += "," + (v.idBaseLegal) ;
//        });
//        $('#txtidBaseLegalConcordancia').val(idsConcordancia);
//        console.log(idsConcordancia);

    }
    /**
     * 
     */
    jQuery.extend($.fn.fmatter, {
    	imgCheckNameBaseLegal: function(cellvalue, options, rowdata) {
            return "<input type=\"checkbox\" id='" + trim(rowdata.codigoBaseLegal)+"' value='"+rowdata.idBaseLegal+"' name='' /> <label class='checkbox' for='" + trim(rowdata.codigoBaseLegal) + "' ></label>";
        }
        });
    /**
     * 
     */
    function confirmEliminarBaseLegalConcordancia(rowid){
    	
        confirm.start();
//        confirm.open("¿Ud est&aacute; seguro de eliminar esta Base Legal?","validaNuevaBaseLegal.eliminarBaseLegalConcordancia('" + rowid + "')");
		/* OSINE_SFS-610 - Inicio */
        //confirm.open("¿Esta seguro de eliminar la base legal concordante?","validaNuevaBaseLegal.eliminarBaseLegalConcordancia('" + rowid + "')");
        confirm.open("¿Est&aacute; seguro de eliminar la base legal concordante?","validaNuevaBaseLegal.eliminarBaseLegalConcordancia('" + rowid + "')");
        /* OSINE_SFS-610 - Fin */
    	
    }
    function eliminarBaseLegalConcordancia(rowid) {
    	$('#gridObligConcordancia').jqGrid('delRowData', rowid);
        gestionBaseLegal.concatenaDescripcionBaseLegal();
    }
    
    /*----------------------------------------------------------------------------------*/
    function procesarGridOblig() {
    	
        $("#gridContenedorOblig").html("");
        var grid = $("<table>", {
            "id": "gridOblig"
        });
//        var pager = $("<div>", {
//            "id": "paginacionOblig"
//        });
        $("#gridContenedorOblig").append(grid);

        var nombres = ['ID', 'Código Obligación', 'Descripción Obligación',''];
        var columnas = [
            {name: "idObligacion", width: 130, sortable: false, align: "center", hidden: true},
            {name: "codigoObligacion", width: 100, sortable: false, align: "center"},
            {name: "descripcion", width: 812, sortable: false, align: "left"},
            {name: "check",width: 50,sortable: false,align: "center",formatter: "imgCheckNameObligacion",hidden:true}
        ];
        grid.jqGrid({
        	url: baseURL + "pages/mantenimiento/baseLegal/listarObligacionBaseLegal",
            datatype: "json",
            postData: {idBaseLegal:$('#txtidBaseLegal').val(),varLista:1},
            hidegrid: false,
            rowNum: 500,
//            pager: "#paginacionOblig",
            emptyrecords: "No se encontraron resultados",
            loadtext: "Cargando",
            colNames: nombres,
            colModel: columnas,
            height: "auto",
            viewrecords: true,
            caption: "Listado de Obligaciones Asociadas",
            autowidth: true,
            //with: "90%",
            jsonReader: {
                root: "filas",
                page: "pagina",
                total: "total",
                records: "registros",
                id:"idObligacion"
            },
            onSelectRow: function(rowid, status) {
//                grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
                var row = grid.jqGrid('getRowData', rowid);
                $('#linkVerObligacionDetalle').attr('onClick', 'validaNuevaBaseLegal.verObligacion("' + rowid + '")');
                $('#linkEditarObligacionDetalle').attr('onClick', 'validaNuevaBaseLegal.editarObligacion("' + rowid + '")');
                /*Rsis 9 - Inicio*/
              
                $('#tabSanciones').hide();                                               
                $('#tabDescr').hide();
                $('#tabRef').hide();
                $('#tabRelac').hide();
                $('#tabMedSeg').hide();
                                
                /*Rsis 9 - Fin*/
                $('#linkEliminarObligacion').attr('onClick', 'validaNuevaBaseLegal.confirmEliminarObligacionBaseLegal("' + rowid + '")');
                
                if($('#divEnlaceTagVerNormaLegalHijo input').html()!=null){
                    $('#contextMenuOblig li a[value="CO-MENUOBLIG"]').html($('#divEnlaceTagVerNormaLegalHijo').html());
                 } else {  
                    $('#contextMenuOblig li a[value="CO-MENUOBLIG"]').remove();
                 }
                
                if($('#divEnlaceTagEditarNormaLegalHijo input').html()!=null){
                    $('#contextMenuOblig li a[value="MO-MENUOBLIG"]').html($('#divEnlaceTagEditarNormaLegalHijo').html());
                 } else {  
                    $('#contextMenuOblig li a[value="MO-MENUOBLIG"]').remove();
                 }
                
                if($('#divEnlaceTagEliminarNormaLegalHijo input').html()!=null){
                    $('#contextMenuOblig li a[value="EL-MENUOBLIG"]').html($('#divEnlaceTagEliminarNormaLegalHijo').html());
                 } else {  
                    $('#contextMenuOblig li a[value="EL-MENUOBLIG"]').remove();
                 }
            },
            loadComplete: function(data) {
                $('#contextMenuOblig').parent().remove();
                var html="";
                switch (flagBaseLegal){
                    case "ver": 
                        html="<ul id='contextMenuOblig'>"
                            + "<li> <a value='CO-MENUOBLIG'></a> </li>"
                            + "</ul>";
                        break;
                    case "nuevo":
                        html="<ul id='contextMenuOblig'>"
                        	+ "<li> <a value='CO-MENUOBLIG'></a> </li>"
                            + "<li> <a value='MO-MENUOBLIG'></a></li>"
                            + "</ul>";
                        break;
                    default :
                        html="<ul id='contextMenuOblig'>"
                        	+ "<li> <a value='CO-MENUOBLIG'></a> </li>"
                            + "<li> <a value='MO-MENUOBLIG'></a></li>"
                            + "<li> <a value='EL-MENUOBLIG'></a></li>"
                            + "</ul>";
                }
                
                $('#divContextMenuOblig').html(html);
                $('#contextMenuOblig').puicontextmenu({
                    target: $('#gridOblig')
                });                
//            onRightClickRow: function(rowid, iRow, iCol, e) {
//                var row = grid.jqGrid('getRowData', rowid);
//                $('#linkVerObligacionDetalle').attr('onClick', 'validaNuevaBaseLegal.verObligacion("' + rowid + '")');
//                $('#linkEditarObligacionDetalle').attr('onClick', 'validaNuevaBaseLegal.editarObligacion("' + rowid + '")');
//                $('#linkEliminarObligacion').attr('onClick', 'validaNuevaBaseLegal.confirmEliminarObligacionBaseLegal("' + rowid + '")');
//            },
//            loadComplete: function(data) {
//                $('#contextMenuOblig').parent().remove();
//                var html="";
//                switch (flagBaseLegal){
//                    case "ver": 
//                        html="<ul id='contextMenuOblig'>"
//                            + "<li> <a id='linkVerObligacionDetalle' data-icon='ui-icon-search' title='Ver Detalle'>Ver Detalle</a> </li>"
//                            + "</ul>";
//                        break;
//                    case "nuevo":
//                        html="<ul id='contextMenuOblig'>"
//                            + "<li> <a id='linkVerObligacionDetalle' data-icon='ui-icon-search' title='Ver Detalle'>Ver Detalle</a> </li>"
//                            + "<li> <a id='linkEliminarObligacion' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                            + "</ul>";
//                        break;
//                    default :
//                        html="<ul id='contextMenuOblig'>"
//                            + "<li> <a id='linkVerObligacionDetalle' data-icon='ui-icon-search' title='Ver Detalle'>Ver Detalle</a> </li>"
//                            + "<li> <a id='linkEditarObligacionDetalle' data-icon='ui-icon-pencil' title='Editar'>Editar</a> </li>"
//                            + "<li> <a id='linkEliminarObligacion' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
//                            + "</ul>";
//                }
//                
//                $('#divContextMenuOblig').html(html);
//                $('#contextMenuOblig').puicontextmenu({
//                    target: $('#gridOblig')
//                });                
            }
        });

    }
    jQuery.extend($.fn.fmatter, {
    	imgCheckNameObligacion: function(cellvalue, options, rowdata) {
            return "<input type=\"checkbox\" id='" + trim(rowdata.codigoObligacion)+"' value='"+rowdata.idObligacion+"' name='' /> <label class='checkbox' for='" + trim(rowdata.codigoObligacion) + "' ></label>";
        }
        });
    
    function confirmEliminarObligacionBaseLegal(rowid){
    	confirm.start();
//    	confirm.open("¿Ud est&aacute; seguro de eliminar esta Obligación?","validaNuevaBaseLegal.eliminarObligacionBaseLegal('" + rowid + "')");
    	/* OSINE_SFS-610 - Inicio */
    	//confirm.open("¿Esta seguro de eliminar la asociación con la obligación?","validaNuevaBaseLegal.eliminarObligacionBaseLegal('" + rowid + "')");
    	confirm.open("¿Est&aacute; seguro de eliminar la asociaci&oacute;n con la obligaci&oacute;n?","validaNuevaBaseLegal.eliminarObligacionBaseLegal('" + rowid + "')");
    	/* OSINE_SFS-610 - Fin */
    }
    function eliminarObligacionBaseLegal(rowid) {
    	$('#gridOblig').jqGrid('delRowData', rowid);
    }
    /**
     * 
     * @param {type} rowid
     * @returns {undefined}
     */
    function confirmEliminarObligacion(idObligacion) {
        /* modif jpiro 20150106 - ini */
        confirm.start();
        /* modif jpiro 20150106 - fin */
        confirm.open("¿Ud est&aacute; seguro de eliminar esta Obligación?",
                "validaNuevaBaseLegal.eliminarObligacion('" + idObligacion + "')");/*function: busquedaBaseLegal.confirmEliminarBaseLegal*/
    }
    /**
     * 
     * @param {type} rowid
     * @returns {undefined}
     */
    function eliminarObligacion(idObligacion){
    	var URL = baseURL + "pages/mantenimiento/baseLegal/eliminaObligacion";
        $.get(URL,{idObligacion:idObligacion}, function(data) {
            if (data.resultado == 0) {
                mensajeGrowl("success", data.mensaje);
//                validaNuevaBaseLegal.procesarGridOblig();//cambio grid
                eliminarObligacionBaseLegal(idObligacion);
                //cambia tab
                $('#tabNewBaseLegal').tabs("enable",0);
                $('#tabNewBaseLegal').tabs({active: 0});
                $('#tabNewBaseLegal').tabs("disable",1);
                }else if(data.resultado == 1){
                	mensajeGrowl("error", data.mensaje);
                }
        });
    }

    /**
     * 
     * @param {type} imgs
     * @returns {String}
     */
    function img(imgs) {

        if (imgs == 1) {
            var detalle = "";
            detalle = "<img src=\"" + baseURL + "/images/stickers.png\" onclick=\"redirectPagina('/mgo/pages/baseLegal')\"  style=\"cursor: pointer;\" alt=\"detalle\" title=\"Detalle\" height=\"20\"  width=\"18\" />";
            return detalle;
        } else {
            detalle = "";
            return detalle;
        }
    }
    /**
     * 
     * @returns {undefined}
     */
    function asociaObligacion(variable, idsBaseLegal) {
        $.ajax({
            url:baseURL + "pages/baseLegal/abrirDialogAsociarBaseLegal", 
            type:'get',
            data:{
                variable:variable,
                idsBaseLegal:idsBaseLegal
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                $("#dialogAsociarBaseLegal").html(data);
                $("#dialogAsociarBaseLegal").dialog({
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
        /*var URL = baseURL + "pages/baseLegal/abrirDialogBusquedaAvanzadaBaseLegal";
        $.get(URL, function(data) {
            objComponenteGestionObligacionInicio.divContainerBusquedaAvanzadaGestionObligacion.html(data);
            if(variable==1){
            	console.info('variable: '+variable);
            	$('#botoAsociarBaseLegalesObligacion').css('display','none');
                $('#botoAsociarBusquedaAvanzadaBaseLegal').css('display','block');
            }else if(variable==0){
            	console.info('variable: '+variable);
            	$('#botoAsociarBaseLegalesObligacion').css('display','block');
                $('#botoAsociarBusquedaAvanzadaBaseLegal').css('display','none');
            }
            
        });*/
    }
    /**
     * 
     * @param {type} rowid
     * @returns {undefined}
     */
    function verObligacion(rowid) {
        nuevaObligacionNormativa.modoVisualizacion = modoVer;
    	var row = $('#gridOblig').jqGrid('getRowData', rowid);
    	var mode=0;//ver
    	nuevaObligacionNormativa.consultarObligacion(row.idObligacion,mode);
    }
    
    function editarObligacion(rowid) {
        nuevaObligacionNormativa.modoVisualizacion = modoEdicion;
    	var row = $('#gridOblig').jqGrid('getRowData', rowid);
    	var mode=1;//editar
    	nuevaObligacionNormativa.consultarObligacion(row.idObligacion,mode);
    }
    
    function confirmAsociarCriterio(rowid,idTipificacion){
    	var idObligacion=$('#idObligacion').val();
    	var idCriterio = rowid;
    	var idsCriterios =$('#idCriteriosJuntos').val();
    	
    	
    	$.ajax({
            url:baseURL + "pages/mantenimiento/baseLegal/asociarObligacionCriterio",
            type:'post',
            async:false,
            data:{
                idCriterio:idCriterio,
                idObligacion:idObligacion,
                idTipificacion:idTipificacion,
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                if(data.resultado=="0"){
                    mensajeGrowl("success", data.mensaje, "");
                    nuevaObligacionNormativa.recargarGridCriterios();
                    $('#dialogCriterios').dialog("close");
                }else if(data.resultado=="1"){
                    mensajeGrowl("error", data.mensaje, "Intente de nuevo");
                }else{
                    mensajeGrowl("error", data.mensaje, "");
                };
            },
            error:errorAjax,
        });   	
    }
    
    function procesarGridCriterio(data) {
    	
    	//Implementando_Grid
    	
    	var validacion = true;	
    	if(validacion){
    			data={descripcion:$('#txtDescCriterio').val(),
    					idsCriterios :$('#idCriteriosJuntos').val()
    				};    		
    	}	
    	
    	$("#gridContenedorCriterioAsociar").html("");
    	var grid = $("<table>", {"id" : "gridCriterioAsociar"});
    	var pager = $("<div>", {"id" : "paginacionCriterioAsociar"});
    	$("#gridContenedorCriterioAsociar").append(grid).append(pager);
    	
    	var nombres = ['idTipificacion', 'Tipificacion','idCriterio','Criterio','idTipoCriterio','Tipo'];
        var columnas = [
            {name: "idTipificacion", width: 30, sortable: false, align: "center", hidden: true},
            {name: "descripcionTipificacion", width: 25, sortable: false, align: "center"},
            {name: "idCriterio", width: 30, sortable: false, align: "center", hidden: true},       
            {name: "descripcion", width: 200, sortable: false, align: "left"},        
            {name: "idTipoCriterio", width: 30, sortable: false, align: "center", hidden: true},  
            {name: "tipoCriterio.descripcion",width: 25,sortable: false, align: "left"}
        ];
    	
    	grid.jqGrid({
    		
    		url : baseURL + "pages/criterio/listarCriterioImpl",		
    		datatype: "json",
    	    postData: data,	   
    	    data:data,
    	    hidegrid: false,
    	    rowNum: global.rowNumPrinc,
    	    pager: "#paginacionCriterioAsociar",
    	    emptyrecords: "No se encontraron resultados",
    	    loadtext: "Cargando",
    	    colNames: nombres,
    	    colModel: columnas,
    	    height: "auto",
    	    viewrecords: true,
    	    caption: "Búsqueda Criterios",
    	    width: 650,
    	    jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros",id:"idCriterio"},
    	    onSelectRow: function(rowid, status) {
                    grid.resetSelection();
            },
            onRightClickRow: function(rowid, iRow, iCol, e) {
            	var row = $('#gridCriterioAsociar').jqGrid('getRowData', rowid);
                
                $('#linkAsociarCriterio').attr('onClick', 'validaNuevaBaseLegal.confirmAsociarCriterio("' + rowid + '","'+ row.idTipificacion +'")');
            },
            loadComplete: function(data) {
            	 $('#contextMenuCriterioAsociar').parent().remove();
            	 $('#divContextMenuCriterioAsociar').html("<ul id='contextMenuCriterioAsociar'>"
                         + "<li> <a id='linkAsociarCriterio' data-icon='ui-icon-pencil' title='Asociar'>Asociar</a></li>"                     
                         + "</ul>");
                 $('#contextMenuCriterioAsociar').puicontextmenu({target: $('#gridCriterioAsociar')});
            },
    	    
    	//Implementando_Sub_Grid
        
        subGrid: true,
        afterInsertRow: function(rowid, aData, rowelem) {
            var rowData = grid.getRowData(rowid);
            if (rowData["tieneSancion"] == 0) {
            	$('tr#' + rowid, grid).children("td.sgcollapsed").html("").removeClass('ui-sgcollapsed sgcollapsed');
            }
        },
        
    	subGridOptions: {"plusicon": "ui-icon-circle-plus","minusicon": "ui-icon-circle-minus","openicon": "ui-icon-arrowreturn-1-e","reloadOnExpand": false,"selectOnExpand": false},
    	
    	subGridRowExpanded: function(subgrid_id, row_id) { 
            	
    	var dataCriterio = grid.getRowData(row_id);
    	var subgrid_table_id, pager_id;      	
                
    	subgrid_table_id = subgrid_id + "_t";
    	pager_id = "p_" + subgrid_table_id;
    	$("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
    			
    	var nombres = ['idDetalleCriterio','idCriterio','Descripción Sanción Específica'];
        var columnas = [        
            {name: "idDetalleCriterio", width: 30, sortable: false, align: "center", hidden: true},  
            {name: "idCriterio", width: 30, sortable: false, align: "center", hidden: true},  
            {name: "sancionEspecifica", width: 200, sortable: false, align: "left"},     
        ];
        
    	jQuery("#" + subgrid_table_id).jqGrid({			
    		
    		url : baseURL + "pages/criterio/listarDetalleCriterioImpl",		
    		datatype: "json",
    	    postData: {idCriterio:dataCriterio.idCriterio},
    	    hidegrid: false,
    	    rowNum: global.rowNumPrinc,
    	    pager: pager_id,
    	    emptyrecords: "No se encontraron resultados",
    	    loadtext: "Cargando",
    	    colNames: nombres,
    	    colModel: columnas,
    	    height: "auto",
    	    viewrecords: true,
    	    caption: "Detalle Criterio",
    	    autowidth: true,
    	    jsonReader: {root: "filas", page: "pagina", total: "total", records: "registros",id:"idDetalleCriterio"},
    	    onSelectRow: function(row_id, status) {
            	jQuery("#" + subgrid_table_id).resetSelection();
            },           
    	});
       } 
     });
    }
    
// 05-11-2015
    function guardarCriterio(){
	    var validar = $('#formCriterio').validateAllForm("#divMensajeValidacionObl");
	    if(validar){
	    	var monto = $('#txtSancionMonetariaCriterio').val();
	    	var validaSancion=true;
	    	if(monto!=""){	    	
		    	validaSancion=false;
		    	var mensajeValidacion="";	    	
	            var resultadoValidacionMonto = validaDecimal(monto, 8, 3);
	            if (!resultadoValidacionMonto) {
	            	$("#txtSancionMonetariaCriterio").addClass("error"); 
	            	mensajeValidacion = "El valor de la sanci&oacute;n debe ser del formato ########.###<br>";                
	            }
	            var divValidacion = $('#divMensajeValidacionObl');            	
	    	    if (mensajeValidacion != "") {    	        	
	    	      divValidacion.show();
	    	      divValidacion.focus();
	    	      divValidacion.html(mensajeValidacion);
	    	      validaSancion = false;
	    	    } else {
	    	      divValidacion.hide();
	    	      divValidacion.html("");
	    	      validaSancion = true;
	    	    }
	    	}
	    	if(validaSancion){
	    		confirm.start();
		        confirm.open("¿Est&aacute; seguro de guardar el criterio?","validaNuevaBaseLegal.guardarCriterioConfirmado()");
	    	}
	    };
	}
	function guardarCriterioConfirmado(){
    	$.ajax({
            url: baseURL + "pages/criterio/registrarCriterio",
            type: 'post',
            async: false,
            data: {
            	descripcion:$('#txtIncumplimientoCriterio').val(),
            	idObligacion:$('#idObligacion').val(),
            	tipoCriterio:$('#cmbTipoCriterio').val(),           	
            	sancionMonetaria:$('#txtSancionMonetariaCriterio').val(),
            	idTipificacion:$('#cmbTipiCriterio').val(),
            	basesLegales:$('#txtBaseLegalCriterio').val(),
            	listaSanciones:$('#divEtapa').find('input[type=checkbox]').map(function(){if($(this).is(':checked')){	return $(this).attr('value').replace('idExpeSele','');} }).get().join(",")
            	
            },
            beforeSend: muestraLoading,
            success: function(data) {
                ocultaLoading();
                if (data.resultado == "0") {
                    mensajeGrowl("success", data.mensaje, "");
                    nuevaObligacionNormativa.recargarGridCriterios();
                    $('#formCriterio').find('input[type=text],textarea,select,input[role=spinbutton],input[type=checkbox]').each(function(){
                    	$(this).val('');
                    });
                    cargaInicial.obtenerTipificacion($('#cmbTipiCriterio').val());
                } else if(data.resultado == "3"){
                	mensajeGrowl("warn", data.mensaje, "");
                }else {
                    mensajeGrowl("error", data.mensaje, "");
                }
            },
            error: errorAjax
        });
	}
//    
    
    return{
    	confirmEliminarObligacionBaseLegal:confirmEliminarObligacionBaseLegal,
    	confirmEliminarBaseLegalConcordancia:confirmEliminarBaseLegalConcordancia,
    	eliminarBaseLegalConcordancia:eliminarBaseLegalConcordancia,
    	procesarGridObligConcordancia: procesarGridObligConcordancia,
        eliminarObligacion:eliminarObligacion,
        confirmEliminarObligacion:confirmEliminarObligacion,
        verObligacion: verObligacion,
        editarObligacion:editarObligacion,
        asociaObligacion: asociaObligacion,
        procesarGridOblig: procesarGridOblig,
        eliminarObligacionBaseLegal:eliminarObligacionBaseLegal,
        procesarGridCriterio:procesarGridCriterio,
// 05-11-2015B
        confirmAsociarCriterio:confirmAsociarCriterio,
        guardarCriterio:guardarCriterio,
        guardarCriterioConfirmado:guardarCriterioConfirmado
//        
    };
})();
$(function() {
	/*JSON del Formulario Nueva BaseLegal*/
    nuevoBL = {
        divTabNormaLegal: $('#tabNewBaseLegal'),
        /*------------------comportamiento de la norma legal-----------------------------*/
        rdoComportamientoObligacion: $('#radUsoBaseLegalOblig'),
        rdoComportamientoRequisito: $('#radUsoBaseLegalReq'),
        /*------------------cabecera de la norma legal-----------------------------------*/
        txtCodigoBaseLegal: $('#txtCodigoBaseLegalNuevo'),
        txtCodigoNormaLegal: $('#txtCodBaseLegal'),
        cmbTipoNormaLegal: $('#cmbTipBaseLegal'),
        txtNumeroNormaLegal: $('#txtNumBaseLegal'),
        txtAnioNormaLegal: $('#txtAnioBaseLegal'),
        cmbSiglaNormaLegal: $('#cmbSigBaseLegal'),
        dateFechaVigenciaNormaLegal: $('#dateFecVigencia'),
        dateFechaPublicacionNormaLegal: $('#dateFecPublicacion'),
        txtTituloNormaLegal: $('#txtaTitBaseLegal'),
        /*------------------Detalle imagen de la cabecera--------------------------*/
        divAdjuntarImagenBaseLegal: $('#divImgBaseLegal'),
        btnAbrirPopUpImagen: $('#imgSubir'),
        /* modi jpiro 20150106 - inicio */
        //fileImagen: $('#desImagen'),
        /* modi jpiro 20150106 - fin */
        btnGuardarImagen: $('#guardarImagen'),
        /*-------------------Articulo norma legal------------------------------------*/
        txtArticuloNormaLegal: $('#txtArtBaseLegal'),
        txtIncisoUnoNormaLegal: $('#txtInc1BaseLegal'),
        txtIncisoDosNormaLegal: $('#txtInc2BaseLegal'),
        dateFechaVigenciaArtNormaLegal: $('#dateFecVigenciaNorma'),
        /*-------------------Anexo norma legal---------------------------------------*/
        cmbTipoAnexoNormaLegal: $('#cmbTipAneBaseLegal'),
        txtArticuloAnexoNormaLegal: $('#txtArtAneBaseLegal'),
        txtIncisoUnoAnexoNormaLegal: $('#txtInc3BaseLegal'),
        txtIncisoDosAnexoNormaLegal: $('#txtInc4BaseLegal'),
        dateFechaVigenciaAnexoNormaLegal: $('#dateFecVigenciaNormaAnexo'),
        /*rsis4*/
        cmbNumeroAnexo: $('#cmbNumeroAnexo'),
        /*rsis4*/
        /*-------------------Norma tecnica-------------------------------------------*/
        cmbTipoNormaTecnica: $('#cmbNorTecBaseLegal'),
        txtDescripcionNormaTecnica: $('#txtDesNorTecBaseLegal'),
        /*-------------------Norma tecnica-------------------------------------------*/
        chkObligacion: $('#chkCrearObligacion'),
        chkModificatoria: $('#chkModificatoria'),
        chkConcordancia: $('#chkConcordancia'),
        divListadoObligacion: $('#divCrearObligacionUnica'),
        divListadoBasesLegalesConcordancia: $('#divDescripcionObligacionConcordancia'),
        txtDescripcionNormaLegal: $('#txtDesConBaseLegal'),
        txtActividadNormaLegal: $('#txtActividadesMantenimientoBaseLegal'),
        txtProductoNormaLegal: $('#txtProductosMantenimientoBaseLegal'),
        txtDescripcionGeneralNormaLegal: $('#txtDesConcatenado'),
        btnCrearObligacion: $('#imgCrearObligacion'),
        btnBuscarObligacion: $('#imgBuscarObligacion'),
        btnGenerarDescripcionNormaLegal: $('#imgGenerarDescripcion'),
        /*-------------------------------------------------------------------------------*/
        btnAgregaNuevaObligacionNormativa: $('#btnNuevaObligacionNormativa'),
        /*------------------Botones Obligacion Normativa---------------------------------*/
        btnEditarBaseLegal: $('#btnEditarBaseLegal'),
        btnGuardarBaseLegal: $('#btnNuevaBaseLegal'),
        btnConfirmaSiGuardarBaseLegal: $('#btnConfirmacionSiBaseLegal'),
        btnConfirmaNoGuardarBaseLegal: $('#btnConfirmacionNoBaseLegal'),
        btnCerrar: $('#btnCerrar'),
        btnCerrarMostrarCodigoBaseLegal: $('#botoCerrarMostrarCodigoBaseLegal'),
        /*------------------Nueva Obligacion Normativa---------------------------------*/
        /*------------------Cabecera Obligacion Normativa------------------------------*/
        txtCodigoObligacion: $('#txtCodOblNor'),
        txtDescripcionObligacion: $('#txtDesOblNor'),
        cmbTemaObligacion: $('#cmbTipOblNor'),
        cmbCriticidadObligacion: $('#cmbCriOblNor'),
        btnAbrirPopUpImagenObligacion: $('#imgCarOblNor'),
        btnAbrirPopUpImagenDescripcion: $('#btnSubirDocumentoAdjuntoDetalle'),
        /*Rsis 11 - Inicio*/
        btnAbrirPopUpImagenInfraccion: $('#btnSubirDocumentoAdjuntoDetalleInfraccion'),
        /*Rsis 11 - Fin*/
        imgMuestraImagenArchivo: $('#imgFilOblNor'),
        imgMuestraImagenArchivoDescripcion: $('#imgFilDesOblNor'),
        lblMuestraNombreArchivo: $('#lblFileCargado'),
        /*------------------Detalle imagen de la cabecera Obligacion-------------------*/
        fileImagenObligacion: $('#fileNuevaOblNor'),
        txtImagenObligacion: $('#file_NuevaOblNor'),
        /*Rsis 14 - Inicio*/
        txtImagenInfraccion: $('#file_Infraccion'),
        /*Rsis 14 - Fin*/
        btnSubirImagenObligacion: $('#botoBuscarOblNor'),
        btnGuardarImagenObligacion: $('#botoGuardarFile'),
        btnCerrarPopUpImagenObligacion: $('#botoCerrarFile'),
        fileImagenDescripcion: $('#fileDesOblNor'),
        /*Rsis 14 - Inicio*/
        fileInfraccion: $('#fileInfraccion'),
        /*Rsis 14 - Fin*/
        btnGuardarImagenDescripcion: $('#botoGuardarFileDescripcion'),
        /*Rsis11 - Inicio*/
        btnGuardarImagenInfraccion: $('#botoGuardarFileInfraccion'),
        /*Rsis11 - Fin*/
        /*------------------Detalle Obligacion Normativa---------------------------*/

        /*------------------Tipificacion Obligacion Normativa---------------------------*/
        txtCodigoTipificacionObligacion: $('#txtTipifOblNor'),
        txtIdTipificacion: $('#txtIdTipificacion'),
        txtDescripcionTipificacionOblig: $('#txtDesTipifOblNor'),
        txtSancionTipificacionObligacion: $('#spinhastaOblNor'),
        txtBaseLegalTipificacionObligacion:$('#txtBaseLegalTipificacion'),
//        chkComisoBienes: $('#chkCB'),
//        chkParalizacionObras: $('#chkPO'),
//        chkCierreInstalacion: $('#chkCI'),
//        chkSuspensionTemporal: $('#chkSTA'),
//        chkRetiroInstalacion: $('#chkRIE'),
//        chkCierreEstablecimiento: $('#chkCE'),
//        chkSuspensionDefinitiva: $('#chkSDA'),
        btnAgregarTipificacion: $('#btnAgregarTipificacion'),
        /*Rsis 14 - Inicio*/
        btnAgregarIncumplimiento : $('#btnAgregarIncumplimiento'),
        /*Rsis 14 - Fin*/
        /*------------------Descripciones Obligacion Normativa----------------------------*/
        txtDescripcionActaObligacion: $('#txtDescObligacionNormativaActa'),
        txtDescripcionGuiaObligacion: $('#txtDescObligacionNormativaGuia'),
        btnAbrirPopUpImagenGuia: $('#btnCargarDescOblNor'),
        imgMuestraImagenGuia: $('#imgFileDescCargaOblNor'),
        lblMuestraNombreGuia: $('#lblDescFileCargado'),
        fileImagenGuia: $('#fileDescGuiaOblNor'),
        btnGuardarImagenGuia: $('#botoGuardarDescFile'),
        btnCerrarPopUpImagenGuia: $('#botoCerrarDescFile'),
        btnAgregarDescripcionNormativa: $('#btnAgregarDescripcion'),
        /*Rsis 11 - Inicio*/
        btnGuardarInfraccion: $('#btnGuardarInfraccion'),
        /*Rsis 11 - Fin*/
        /*------------------Pautas Obligacion Normativa-----------------------------------*/
        txtTransportesObligacion: $('#txtTransportes'),
        txtProductosObligacion: $('#txtProductosObligacion'),
        btnAbrirPopUpPauta: $('#botoSubirPauta'),
        txtDescripcionCriterio: $('#nueva_DescripcionPauta'),
        txtTituloCriterio: $('#nueva_TituloPauta'),
        txtPautaSancion: $('#nueva_PautaSancion'),
        txtFileCriterio: $('#filePauta'),
        btnGuardarFileCriterio: $('#btnSubirFileCriterio'),
        btnGuardarImagenPauta: $('#botoGuardarPauta'),
        btnCerrarPopUpPauta: $('#botoCerrarPauta'),
        btnCerrarPopDependenciaCriterio: $('#botoCerrarDependenciaCriterio'),
        /*------------------Botones Guardar Obligacion Normativa--------------------------*/
        btnGuardarNuevoObligacion: $('#btnGuardarNuevo'),
        btnConfirmaNoNuevaObligacion: $('#btnConfirmacionNoObligacionNormativaNuevo'),
        btnConfirmaSiNuevaObligacion: $('#btnConfirmacionSiObligacionNormativaNuevo'),
        btnGuardarObligacion: $('#btnNuevaOblNor'),
        btnConfirmaSiGuardarObligacion: $('#btnConfirmacionSiObligacionNormativa'),
        btnConfirmaNoGuardarObligacion: $('#btnConfirmacionNoObligacionNormativa'),
        btnConfirmaSiGuardarTipificacion: $('#btnConfirmacionSiObligacionNormativaTipificacion'),
        btnConfirmaNoGuardarTipificacion: $('#btnConfirmacionNoObligacionNormativaTipificacion'),
        btnCerrarObligacion: $('#btnCerrarOblNor'),
        /*------------------Componentes y Agrupadores--------------------------*/
        divTabDetalleObligacion: $('#tabNueOblNor'),
        /*------------------TabObligacion-------------------------------------------*/
        divTabObligacion: $('#tab2'),
        /*------------------TabSubirCriterio-----------------------------------*/
        divSubirCriterio: $('#dialogPauta'),
        btnAsociarBaseLegal: $('#btnAsociaNuevaBaseLegal'),
        /*---------------------configurar Supervision-----------------------------*/
        divConfigurarPrimerPaso: $('#divStepUno'),
        divConfigurarSegundoPaso: $('#divStepDos'),
        divConfigurarTercerPaso: $('#divStepTres'),
        divConfigurarCuartoPaso: $('#divStepCuatro'),
        divConfigurarSupervision: $('#asignarArbolActividades'),
        btnConfigurarSupervisionPrimerPaso: $('#btnAsociarActividadStepUno'),
        btnConfigurarSupervisionSegundoPaso: $('#btnAsociarActividadStepDos'),
        btnConfigurarSupervisionTercerPaso: $('#btnAsociarActividadStepTres'),
        btnConfigurarSupervisionRegresarSegundoPaso: $('#btnAsociarActividadStepDosRegresar'),
        btnConfigurarSupervisionRegresarTercerPaso: $('#btnAsociarActividadStepTresRegresar'),
        btnConfigurarSupervisionRegresarCuartoPaso: $('#btnAsociarActividadStepCuatroRegresar'),
        btnConfigurarSupervisionGuardar:$('#btnGuardarRelacionStepCuatroRegresar'),
        /*----------------------------Criterios------------------------------------*/
        /* extras */
        divNormaArticuloNormaLegal: $('#fecnivelnorma'),
        divAnexoNormaLegal: $('#divAnexoBaseLegal'),
        divContenedorGridObligaciones: $('#divCrearObligacionUnica'),
        divBotonesGridObligaciones:$('#divBotonesGridObligaciones'),
        /*----------------------------Relaciones------------------------------------*/
        btnGuardarRelacionObligacion:$('#btnRelacionesObligacion'),
        
    };
});
$(function() {
    /*Funciones de nuevaObligacionNormativa que se inicializan*/
	cargaInicial.constructor();
	gestionBaseLegal.constructor();
    nuevaObligacionNormativa.constructor();
    validaNuevaBaseLegal.constructor();
    nuevaObligacionNormativa.gridArchivosCriterio();
    nuevaObligacionNormativa.gridCriterio();
//    console.log("visualizar: " + JSON.stringify(detalleNormaTecnicaDTO));
//    var chulo = detalleNormaTecnicaDTO;
    $('#btnAgregarNormaTecnica').click(function(){agregarNormaTecnica();});
   
    
});

// 05-11-2015

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
        var sancionEspecifica=rowdata.sancionEspecifica;
        var sancionMonetaria=rowdata.sancionMonetaria;
        var concatTipificacionSancion="";
        concatTipificacionSancion=concatTipificacionSancion.substring(0, (concatTipificacionSancion.length-2));
        
        if(sancionEspecifica=="" || sancionEspecifica==null){
            retorno=sancionMonetaria + " UIT ";
        }
        if(sancionMonetaria=="" || sancionMonetaria==null){
            retorno=sancionEspecifica;
        }
        if(sancionEspecifica!="" && sancionMonetaria!="" && sancionEspecifica!=null && sancionMonetaria!=null){
            retorno+=sancionMonetaria+ " UIT ";
            retorno+= ", "+sancionEspecifica;

        }
        return retorno;
    }
});

//jsifuentes inicio
function agregarNormaTecnica() {
	var idTipoNormaTecnica = $('#cmbNorTecBaseLegal').val();
	var descripcionIdTipoNormaTecnica = $("#cmbNorTecBaseLegal").find(':checked').text();
	var descripcionNorma =  $('#txtDesNorTecBaseLegal').val();
	
	 var mydata = $('#tblNormaTecnica').getGridParam('data');
	 if (idTipoNormaTecnica!="" && descripcionNorma !=""){
	   mydata.push({'idTipoNormaTecnica':idTipoNormaTecnica,'descripcionIdTipoNormaTecnica':descripcionIdTipoNormaTecnica,'descripcionNorma':descripcionNorma});
	 }
	
	 $('#tblNormaTecnica').jqGrid('clearGridData');
	 $('#tblNormaTecnica').jqGrid('setGridParam', {data: mydata});
	 $('#tblNormaTecnica').trigger('reloadGrid');
	 
	 if (idTipoNormaTecnica!="" && descripcionNorma !=""){
		 gestionBaseLegal.concatenaDescripcionBaseLegal(); 
	 }
	 $('#txtDesNorTecBaseLegal').val('');
}
//jsifuentes fin
function settearInputsDetalleNorma() {
	var dataDetalleNorma = $('#tblNormaTecnica').getGridParam('data');
	html= "";
	cont=0;
	$.each(dataDetalleNorma,function(k,v){
		
		if (v.idDetalleNormaTecnica == undefined){
          html+='<input type="checkbox" name="detalleNormaTecnica['+cont+'].idTipoNormaTecnica" value="'+v.idTipoNormaTecnica+'" checked >';
          html+='<input type="checkbox" name="detalleNormaTecnica['+cont+'].descripcionNorma" value="'+v.descripcionNorma+'" checked >';
          cont++;
		}
    });
	
	$('#inputsDetalleNorma').html(html);
	
}

$('#cmbNormaLegal').change(function(){
	$.ajax({
	    url:baseURL + "pages/mantenimiento/baseLegal/obtenerFechaEntradaVigente",
	    type:'post',
	    dataType: "json",
	    async:false,
	    data:{
	    	idBaseLegal:$('#cmbNormaLegal').val()
	    },
	    beforeSend:muestraLoading,
	    success:function(data){
	        ocultaLoading();
	        if(data.resultado=="0"){
	        	$('#dateFecVigenciaNorma').val(data.baseLegalFechavigencia);
	        	$('#dateFecVigenciaNorma').datepicker('option','minDate',$('#dateFecVigencia').val()).trigger('change');
	        	$('#dateFecVigenciaNormaAnexo').datepicker('option','minDate',$('#dateFecVigencia').val()).trigger('change');
	        }else if(data.resultado=="1"){
	            mensajeGrowl("error", data.mensaje, "Intente de nuevo");
	        }else{
	            mensajeGrowl("error", data.mensaje, "");
	        };
	    },
	    error:errorAjax,
	});

	gestionBaseLegal.obtenerNormaPadre($('#cmbNormaLegal').val());
	gestionBaseLegal.validaComportamientoRegistroBaseLegal();
	gestionBaseLegal.validaArticuloBaseLegal();
	$('#chkModificatoria').removeAttr('disabled');
	$('#chkConcordancia').removeAttr('disabled');
	//Inicio MYC-7 Cambio de Alcance
    $('#cmbTipAneBaseLegal').removeAttr('disabled');
    $('#cmbNorTecBaseLegal').removeAttr('disabled');
    //Fin MYC-7 Cambio de Alcance

});

function settearInputsConcordancia() {
	
	var dataTblConcordancia = $("#gridObligConcordancia").getRowData();
	
	html= "";
	cont=0;
	$.each(dataTblConcordancia,function(k,v){
          html+='<input type="checkbox" name="listaBasesLegales['+cont+'].idBaseLegalDestino" value="'+v.idBaseLegal+'" checked >';
          cont++;
    });
	$('#baseLegalConcordancia').html(html);
	
}
/*Rsis 14 - Inicio*/
function eliminarIncumplimiento (rowid){	
	confirm.start();
    confirm.open("¿Está seguro de quitar el escenario de incumplimiento?","procEliminarIncumplimiento('"+rowid+"')");
}
/*Rsis 14 - Fin*/

function procEliminarIncumplimiento(id){		
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
            if(data.resultado==0){
                mensajeGrowl("success", global.confirm.delete, "");
                gridIncumplimiento();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function gridIncumplimiento() {
	
    var colNames = ['id_esce_incumplimiento','Medida de Seguridad', 'Descripci&oacute;n Incumplimiento'];
    var colModel = [
        {name: "id_esce_incumplimiento", hidden: true, width: 200, sortable: false, align: "center"},
        {name: "id_esce_incu_maestro",hidden:true ,  width: 300, sortable: false, align: "center"},
        {name: "descripcionEscenarioIncumplimiento", width: 600, sortable: false, align: "center"}
    ];
    $("#gridIncumplimiento2").html("");
    var url = baseURL + "pages/mantenimiento/baseLegal/findIncumplimiento";
    var postData = {idInfraccion:$('#idInfraccion').val()};
        
    var grid = $("<table>", {
        "id": "gridIncumplimiento"
    });
    var pager = $("<div>", {
        "id": "paginacionIncumplimiento"
    });
    $("#gridIncumplimiento2").append(grid).append(pager);
    
    grid.jqGrid({
        url:url,
        datatype: "json",
        postData: postData,
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionIncumplimiento",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames : colNames,
        colModel : colModel,
        height: "auto",
        viewrecords: true,
        width: 825,
        jsonReader: {
        	root: "filas",
        	page: "pagina",
        	total: "total",
        	records: "registros",
        	idInfraccion: $('#idInfraccion').val()
        		},
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid) {             	
            var row = grid.jqGrid('getRowData', rowid); 
            $('#linkEliminarIncumplimiento').attr('onClick', 'eliminarIncumplimiento("'+row.id_esce_incumplimiento+'")');                
                            
            if($('#divEnlaceTagEliminarIncumplimiento input').html()!=null){
                $('#contextMenuIncumplimiento li a[value="EL-TRAMITEACT"]').html($('#divEnlaceTagEliminarIncumplimiento').html());
             } else {  
                $('#contextMenuIncumplimiento li a[value="EL-TRAMITEACT"]').remove();
             }
        },
        loadComplete: function(data) {
            $('#contextMenuIncumplimiento').parent().remove();
            $('#divContextMenuIncumplimiento').html("<ul id='contextMenuIncumplimiento'>"                                                
                    + "<li> <a value='EL-TRAMITEACT'></a></li>"                       
                    + "</ul>");
            $('#contextMenuIncumplimiento').puicontextmenu({
                target: $('#gridIncumplimiento')
            });
        }
    });
    
}

