var codEtapa = -1;
var codigoEtapa = -1;
var codigoConfTramite = -1;
var etapas = [];
var tipoConsulta = false;
$(function() {
	confirm.start();
	initCombo();
	retroceder();
    boton.closeDialog();
    mantenimientoEtapa.listarEtapaTramite();
    
    procesarCombo.listarDivisiones();
    
    $('#btnBuscarEtapaTramite').click(function() {
    	 mantenimientoEtapa.listarEtapaTramite();
     });
    
    $('#btnNuevaEtapaTramite_mantEtapa').click(function() {
    	mantenimientoEtapa.abrirNuevaEtapaTramite();
    });
   /*---agregar SubEtapa 3er modal*/
    $('#btnNuevaSubEtapa_modificarEtapaTramite').click(function() {
    	mantenimientoEtapa.abrirAgregarSubEtapa();
	});
    /*---agregar SubEtapa 3er modal*/
      $('#tiempoDiasSubEtapaMod').alphanum(numericMonto);
	
    /*----Modificar 3er modal*/
    $('#btnLimpiarEtapas').click(function() {
		mantenimientoEtapa.limpiarConsulta();
	});
    
    /*-- abrir modales del 2do modal---*/
    $('#btnNuevaSubEtapa_etapaTramite').click(function() {
		procesarModales.abrirNuevaSubEtapa();
	});	
	$('#btnNuevaEtapa_etapaTramite').click(function() {
		procesarModales.abrirNuevaEtapa();
	});	
	$('#btnNuevaConfig_etapaTramite').click(function() {
		procesarModales.abrirNuevaConfiguracion();
	});	
	 /*-- abrir modales del 2do modal---*/
   
});

function retroceder() {
	$('#btnRegresar').click(
			function() {
				window.location.href = baseURL
						+ 'pages/principal/mantenimientoGeneral';
			});
	
}

function initCombo(){
	$('#cmbGerenciaEtapa').change(function() {
		procesarCombo.listarDivisiones();
	});

	$('#cmbDivisionEtapa').change(function() {
		procesarCombo.listarActividad();
		procesarCombo.listarSectores();
		
	});
	
	$('#cmbActividadEtapa').change(function(){
		procesarCombo.listarAgentes();
	});
	
}

var procesarLista = {
		
		listarEtapa : function(obj,idConfTramite) {
			etapas = [];
			procesarLista.listarSubEtapaEtapa('','');
			validarCheckConfTramite(obj, idConfTramite);
			var nombres = ['ETAPA','PLAZO','SELECCIONAR ETAPA','a'];
	        var columnas = [
	            {name: "descripcion", width: 200, sortable: false, align: "center"},
	            {name: "plazo", width: 95, sortable: false, align: "center"},
	            {name : "", width : 110, sortable : false, align : "center", formatter:"formatoSelectEtapa" },
	            {name: "idEtapa", hidden:true}
	         ];
	        var url = baseURL + "pages/mantenimientoEtapa/listarEtapa" ;
			var nombreGrid = "Etapas";
			$("#gridContenedor"+nombreGrid).html("");
	        var grid = $("<table>", {
	            "id": "grid"+nombreGrid
	        });
	        var pager = $("<div>", {
	            "id": "paginacion"+nombreGrid
	        });
	        $("#gridContenedor"+nombreGrid).append(grid).append(pager);
	        
	        grid.jqGrid({
				    url: url,
		            datatype: "json",
		            mtype : "POST",
		            postData: { 
		            	idConfTramite:idConfTramite
		            },
		            hidegrid: false,
		            rowNum: 5,
		            pager: "#paginacion"+nombreGrid,
		            emptyrecords: "No se encontraron resultados",
		            recordtext: "{0} - {1}",
		            loadtext: "Cargando",
		            colNames: nombres,
		            colModel: columnas,
		            height: "auto",
		            width: 587,
		            viewrecords: true,
		            caption: "",
		            jsonReader: {
		                root: "filas",
		                page: "pagina",
		                total: "total",
		                records: "registros",
		                repeatitems: false,
		            },
		            onSelectRow: function(rowid, status) {
		                grid.resetSelection();
		            },
		            loadComplete: function(data){
		            	var c=0;
			        	for(var x = 0; x < etapas.length;x++){			        		
			        		if(etapas[x]!=-1){
				            		c++;
				            		console.info('eq - ' + c);
				            		$('#gridContenedorEtapas').find('input[class=ETAPA]').map(function(){
				            			var id = $(this).attr('id').replace('seleccionEtapa_', '');
				            			console.info('etapa - ' + etapas[x]);
				            			console.info('etapa - ' + id);
				                		if(etapas[x] == id){
				                			$('#seleccionEtapa_'+id).attr('checked',true);    
//				                			listaEtapas.push(lista[x].idEtapa);
				                		}
				                	});
			        		}
			            } 
		            },
		            loadError: function(jqXHR) {
		                errorAjax(jqXHR);
		            }
		    });
	        
		},	
		listarSubEtapaEtapa : function(obj,idEtapa) {
	    	console.log("id "+ idEtapa);
	    	if(obj.checked){
	    	   console.log('hizo check idEtapa=' + idEtapa);
	    	   codigoEtapa =  idEtapa;
	    	   etapas.push(idEtapa);
	    	   console.log('val etapa array size ' + etapas.length);
	    	   console.info('Etapas: -> '+etapas);
	    	}else{
	    		console.log('no esta marcado');
	    		for(var x=0;x<etapas.length;x++){
	    			if(etapas[x] == idEtapa){
	    				etapas.splice(x, 1);
	    			}			
	    		}
	    		console.info('Etapas: -> '+etapas);
	    	}
	    	if(etapas.length==0){
	    		etapas.push(-1);
	    	}
	    	
	    	var nombres = ['ETAPA','DESCRIPCIÓN','TIEMPO EN DÍAS HÁBILES','RESPONSABLE','a','b','c'];
	        var columnas = [
	            {name: "idEtapa.descripcion", width: 150, sortable: false, align: "center"},
	            {name: "descripcion", width: 150, sortable: false, align: "center"},
	            {name: "tiempoDias",width: 95, sortable: false, align: "center"},
	            {name: "idResponsable.descripcion",width: 100, sortable: false, align: "left" },
		        {name: "estado", hidden:true},
		        {name: "idSubetapa", hidden:true },
		        {name: "idEtapa.idEtapa", hidden:true},
	         ];
	        var url = baseURL + "pages/mantenimientoEtapa/listarSubEtapaCompleta" ;
			var nombreGrid = "SubEtapas";
			$("#gridContenedor"+nombreGrid).html("");
	        var grid = $("<table>", {
	            "id": "grid"+nombreGrid
	        });
	        var pager = $("<div>", {
	            "id": "paginacion"+nombreGrid
	        });
	        $("#gridContenedor"+nombreGrid).append(grid).append(pager);
	        
	        grid.jqGrid({
				    url: url,
		            datatype: "json",
		            mtype : "POST",
		            postData: { 
//		            	idEtapa : codigoEtapa
		            	idEtapa : etapas
		            },
		            hidegrid: false,
		            rowNum: 5,
		            pager: "#paginacion"+nombreGrid,
		            emptyrecords: "No se encontraron resultados",
		            recordtext: "{0} - {1}",
		            loadtext: "Cargando",
		            colNames: nombres,
		            colModel: columnas,
		            height: "auto",
		            width: 587,
		            viewrecords: true,
		            caption: "",
		            jsonReader: {
		                root: "filas",
		                page: "pagina",
		                total: "total",
		                records: "registros",
		                repeatitems: false,
		            },
		            onSelectRow: function(rowid, status) {
		                grid.resetSelection();
		            },
		            loadComplete: function(data){
		             },
		            loadError: function(jqXHR) {
		                errorAjax(jqXHR);
		            }
		    });
		},		
		listarConfiguracion : function() {
				var nombres = ['ESTADOS DE ATENCION','TIEMPO EN DÍAS HÁBILES','RESPONSABLE','a','b','c'];
		        var columnas = [
		            {name: "descripcion", width: 95, sortable: false, align: "center"},
		            {name: "tiempoDias",width: 95, sortable: false, align: "center"},
		            {name: "responsable",width: 100, sortable: false, align: "center" },
			        {name: "estado", hidden:true},
			        {name: "idSubetapa", hidden:true },
			        {name: "idEtapa.idEtapa", hidden:true},
		            
		         ];
		        var url = baseURL + "pages/mantenimientoEtapa/listarSubEtapa" ;
				var nombreGrid = "SubEtapas";
				$("#gridContenedor"+nombreGrid).html("");
		        var grid = $("<table>", {
		            "id": "grid"+nombreGrid
		        });
		        var pager = $("<div>", {
		            "id": "paginacion"+nombreGrid
		        });
		        $("#gridContenedor"+nombreGrid).append(grid).append(pager);
		        
		        grid.jqGrid({
					    url: url,
			            datatype: "json",
			            mtype : "POST",
			            postData: { 
			            	idEtapa:$('#idEtapaEdit').val()
			            },
			            hidegrid: false,
			            rowNum: 5,
			            pager: "#paginacion"+nombreGrid,
			            emptyrecords: "No se encontraron resultados",
			            recordtext: "{0} - {1}",
			            loadtext: "Cargando",
			            colNames: nombres,
			            colModel: columnas,
			            height: "auto",
			            viewrecords: true,
			            caption: "",
			            jsonReader: {
			                root: "filas",
			                page: "pagina",
			                total: "total",
			                records: "registros",
			                repeatitems: false,
			            },
			            onSelectRow: function(rowid, status) {
			                grid.resetSelection();
			            },
			            loadComplete: function(data){
			             },
			            loadError: function(jqXHR) {
			                errorAjax(jqXHR);
			            }
			    });
			},
		listarConfTramite : function() {
				var nombres = ['TRÁMITE','AGENTE','ORIENTACIÓN','SELECCIONAR','idConfTramite'];
		        var columnas = [
		            {name: "idTramite.descripcion",width: 150, sortable: false, align: "center"},
		            {name: "idCnfActUniOrganica.idActividad.nombre",width: 100, sortable: false, align: "center" },
		            {name: "orientacion",width: 100, sortable: false, align: "center" },
		            {name : "", width : 110, sortable : false, align : "center", formatter:"formatoSelectConfiguracion" },
		            {name: "idConfTramite", width: 95, sortable: false, align: "center", hidden:true},
		         ];
		        var url = baseURL + "pages/mantenimientoEtapa/listarConfTramite" ;
				var nombreGrid = "Configuracion";
				$("#gridContenedor"+nombreGrid).html("");
		        var grid = $("<table>", {
		            "id": "grid"+nombreGrid
		        });
		        var pager = $("<div>", {
		            "id": "paginacion"+nombreGrid
		        });
		        $("#gridContenedor"+nombreGrid).append(grid).append(pager);
		        
		        grid.jqGrid({
					    url: url,
			            datatype: "json",
			            mtype : "POST",
			            postData: { 
			            	
			            },
			            hidegrid: false,
			            rowNum: 5,
			            pager: "#paginacion"+nombreGrid,
			            emptyrecords: "No se encontraron resultados",
			            recordtext: "{0} - {1}",
			            loadtext: "Cargando",
			            colNames: nombres,
			            colModel: columnas,
			            height: "auto",
			            viewrecords: true,
			            caption: "",
			            jsonReader: {
			                root: "filas",
			                page: "pagina",
			                total: "total",
			                records: "registros",
			                repeatitems: false,
			            },
			            onSelectRow: function(rowid, status) {
			                grid.resetSelection();
			            },
			            loadComplete: function(data){
			             },
			            loadError: function(jqXHR) {
			                errorAjax(jqXHR);
			            }
			    });
			},
		listarActividad : function() {
				fill.clean("#cmbActividadEtapa2");
				$('#cmbActividadEtapa2').trigger('change');
				if ($('#cmbDivisionEtapa2').val() != '') {
					$.ajax({
						url : baseURL + "pages/mantenimientoEtapa/listarActividades",
						type : 'post',
						async : false,
						data : {
							idUnidadOrganica : $('#cmbDivisionEtapa2').val()
						},
						beforeSend : muestraLoading,
						success : function(data) {
							ocultaLoading();
							fill.combo(data.listaActividades, "idActividad", "nombre",
									"#cmbActividadEtapa2");
						},
						error : errorAjax
					});
				}
			},
		listarSectores : function() {
				$('#cmbSectorEtapa2').trigger('change');
				if ($('#cmbDivisionEtapa2').val() != '') {
					$.ajax({
						url : baseURL + "pages/mantenimientoEtapa/listarSectores",
						type : 'post',
						async : false,
						data : {
							idUnidadOrganica : $('#cmbDivisionEtapa2').val()
						},
						beforeSend : muestraLoading,
						success : function(data) {
							ocultaLoading();
							fill.combo(data.listaSectores, "idMaestroColumna",
									"descripcion", "#cmbSectorEtapa2");
						},
						error : errorAjax
					});
				}
			},
		listarAgentes : function() {
				$('#cmbAgenteEtapa2').trigger('change');
				if ($('#cmbActividadEtapa2').val() != '') {
					$.ajax({
						url : baseURL + "pages/mantenimientoEtapa/listarAgentes",
						type : 'post',
						async : false,
						data : {
							idActividad : $('#cmbActividadEtapa2').val()
						},
						beforeSend : muestraLoading,
						success : function(data) {
							ocultaLoading();
							fill.combo(data.listaAgentes, "idActividad",
									"nombre", "#cmbAgenteEtapa2");
						},
						error : errorAjax
					});
				}
			},	
		listarDivisiones : function() {
			fill.clean("#cmbDivisionEtapa2");
			$('#cmbDivisionEtapa2').trigger('change');
			if ($('#cmbGerenciaEtapa2').val() != '') {
				$.ajax({
					url : baseURL + "pages/mantenimientoEtapa/listarDivisiones",
					type : 'post',
					async : false,
					data : {
						idUnidadOrganica : $('#cmbGerenciaEtapa2').val()
					},
					beforeSend : muestraLoading,
					success : function(data) {
						ocultaLoading();
						fill.combo(data.listaDivisiones, "idUnidadOrganica",
								"descripcion", "#cmbDivisionEtapa2");
					},
					error : errorAjax
				});
			}
		}		
			
};
var procesarModales = {
		abrirNuevaConfiguracion : function(){
			procesarCombos();
			
			$.ajax({
		        url:baseURL + "pages/mantenimientoEtapa/abrirNuevaConfiguracion", 
		        type:'POST',
		        async:false,
		        data:{
		            
		        },
		        beforeSend:muestraLoading,
		        success:function(data){
		            ocultaLoading();
		            $("#dialogNuevaConfiguracionEtapa").html(data);
		            $("#dialogNuevaConfiguracionEtapa").dialog({
		                resizable: false,
		                draggable: true,
		                autoOpen: true,
		                height:"auto",
		                width: "auto",
		                modal: true,
		                dialogClass: 'dialogModal',
		                title: "Configuración de Etapas y SubEtapas de Atención"
		            });
		            
		        },
		        error:errorAjax
		    });
		},	
		abrirNuevaSubEtapaEtapaTramite: function() {
			$.ajax({
		        url:baseURL + "pages/mantenimientoEtapa/abrirNuevaSubEtapaEtapaTramite", 
		        type:'POST',
		        async:false,
		        data:{
		            
		        },
		        beforeSend:muestraLoading,
		        success:function(data){
		            ocultaLoading();
		            $("#dialogNuevaSubEtapaEtapaTramite").html(data);
		            $("#dialogNuevaSubEtapaEtapaTramite").dialog({
		                resizable: false,
		                draggable: true,
		                autoOpen: true,
		                height:"auto",
		                width: "auto",
		                modal: true,
		                dialogClass: 'dialog',
		                title: "Agregar SubEtapa"
		            });
		        },
		        error:errorAjax
		    });
		},
		abrirNuevaEtapa : function() {
			$.ajax({
		        url:baseURL + "pages/mantenimientoEtapa/abrirNuevaEtapa", 
		        type:'POST',
		        async:false,
		        data:{
		            
		        },
		        beforeSend:muestraLoading,
		        success:function(data){
		            ocultaLoading();
		            $("#dialogNuevaEtapaSub").html(data);
		            $("#dialogNuevaEtapaSub").dialog({
		                resizable: false,
		                draggable: true,
		                autoOpen: true,
		                height:"auto",
		                width: "auto",
		                modal: true,
		                dialogClass: 'dialogModal',
		                title: "Agregar Etapa"
		            });
		        },
		        error:errorAjax
		    });
		}
	 
};

function validarCheckConfTramite(object, idConfTramite){
	console.log('idConfTramite=' + idConfTramite);
	codigoConfTramite = idConfTramite;
	$('#codigoConfiguracionTramite').val(idConfTramite);
}

var procesarCombo = {
		
		listarDivisiones : function(){
			fill.clean("#cmbDivisionEtapa");
			$('#cmbDivisionEtapa').trigger('change');
			if ($('#cmbGerenciaEtapa').val() != '') {
				$.ajax({
					url : baseURL + "pages/mantenimientoEtapa/listarDivisiones",
					type : 'post',
					async : false,
					data : {
						idUnidadOrganica : $('#cmbGerenciaEtapa').val()
					},
					beforeSend : muestraLoading,
					success : function(data) {
						ocultaLoading();
						fill.combo(data.listaDivisiones, "idUnidadOrganica",
								"descripcion", "#cmbDivisionEtapa");
						if( data.resultado==0){
							
						}
					},
					
					error : errorAjax
				});
			}
		},
		listarActividad : function() {
			fill.clean("#cmbActividadEtapa");
			$('#cmbActividadEtapa').trigger('change');
			if ($('#cmbDivisionEtapa').val() != '') {
				$.ajax({
					url : baseURL + "pages/mantenimientoEtapa/listarActividades",
					type : 'post',
					async : false,
					data : {
						idUnidadOrganica : $('#cmbDivisionEtapa').val()
					},
					beforeSend : muestraLoading,
					success : function(data) {
						ocultaLoading();
						fill.combo(data.listaActividades, "idActividad", "nombre",
								"#cmbActividadEtapa");
					},
					error : errorAjax
				});
			}
		},
		listarSectores : function() {
			$('#cmbSectorEtapa').trigger('change');
			if ($('#cmbDivisionEtapa').val() != '') {
				$.ajax({
					url : baseURL + "pages/mantenimientoEtapa/listarSectores",
					type : 'post',
					async : false,
					data : {
						idUnidadOrganica : $('#cmbDivisionEtapa').val()
					},
					beforeSend : muestraLoading,
					success : function(data) {
						ocultaLoading();
						fill.combo(data.listaSectores, "idMaestroColumna",
								"descripcion", "#cmbSectorEtapa");
					},
					error : errorAjax
				});
			}
		},
		listarAgentes : function() {
			$('#cmbAgenteEtapa').trigger('change');
			if ($('#cmbActividadEtapa').val() != '') {
				$.ajax({
					url : baseURL + "pages/mantenimientoEtapa/listarAgentes",
					type : 'post',
					async : false,
					data : {
						idActividad : $('#cmbActividadEtapa').val()
					},
					beforeSend : muestraLoading,
					success : function(data) {
						ocultaLoading();
						fill.combo(data.listaAgentes, "idActividad",
								"nombre", "#cmbAgenteEtapa");
					},
					error : errorAjax
				});
			}
		},
};

var mantenimientoEtapa = {
	limpiarConsulta : function() {
		$('#cmbGerenciaEtapa').val('');
		$('#cmbDivisionEtapa').val('');
		$('#cmbSectorEtapa').val('');
		$('#cmbActividadEtapa').val('');
		$('#cmbAgenteEtapa').val('');
		$('#cmbResponsable').val('');
		$('#cmbTramiteEtapa').val('');
	},
			
	abrirNuevaEtapaTramite : function(){
		$.ajax({
	        url:baseURL + "pages/mantenimientoEtapa/abrirNuevaEtapaTramite", 
	        type:'POST',
	        async:false,
	        data:{
	            
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            $("#dialogEtapaTramiteSub").html(data);
	            $("#dialogEtapaTramiteSub").dialog({          	
	            	position: { my: 'top', at: 'top+20' },
//	                resizable: false,
//	                draggable: true,
	                autoOpen: true,
//	                height:"auto",
	                width: 630,
	                modal: true,
	                dialogClass: 'dialogModal',	
	                title: "DATOS GENERALES DE LA CONFIGURACIÓN",
	                closeText:"Cerrar"
	            });
	            cargarGrillas();
	            
	        },
	        error:errorAjax
	    });
	},
	listarEtapaTramite : function() {
		
		
		var nombres = ['TRAMITE','AGENTE','ETAPA','PLAZO','OPCIÓN','a','b','idResponsable','countSubEtapa'];
	
        var columnas = [
            {name: "tramite.descripcion",width: 320, sortable: false, align: "center" },
            {name: "actividad.nombre",width: 280, sortable: false, align: "center"},
            {name: "etapa.descripcion",width: 200, sortable: false, align: "center"},
            {name: "etapa.plazo",width: 120, sortable: false, align: "center"},
            {name: "estado", hidden:true},
            {name: "etapa.idEtapa", hidden:true},
            {name: "idEtapaTramite", hidden:true},
            {name: "idResponsable", hidden:true},
            {name: "countSubEtapa", hidden:true}
	     ];
        /* OSINE_SFS-1232 - lgarciar - Inicio */
        var url = baseURL + "pages/mantenimientoEtapa/findEtapaTramite" ;
       // var url = baseURL + "pages/mantenimientoEtapa/listarEtapaTramite" ;
        /* OSINE_SFS-1232 - lgarciar - Fin */
		var nombreGrid = "Consulta";
		$("#gridContenedor"+nombreGrid).html("");
        var grid = $("<table>", {
            "id": "grid"+nombreGrid
        });
        var pager = $("<div>", {
            "id": "paginacion"+nombreGrid
        });
        $("#gridContenedor"+nombreGrid).append(grid).append(pager);
        
        grid.jqGrid({
			    url: url,
	            datatype: "json",
	            mtype : "POST",
	            postData: {
	        	 	idGerencia : $('#cmbGerenciaEtapa').val(),
	        		idDivision :  $('#cmbDivisionEtapa').val(),
	        		idSector :  $('#cmbSectorEtapa').val(),
	        		idActividad :  $('#cmbActividadEtapa').val(),
	        		idAgente : $('#cmbAgenteEtapa').val(),
	        		idResponsable : $('#cmbResponsable').val(),
	        		idTramite : $('#cmbTramiteEtapa').val()
	            },
	            hidegrid: false,
	            rowNum: 5,
	            pager: "#paginacion"+nombreGrid,
	            emptyrecords: "No se encontraron resultados",
	            recordtext: "{0} - {1}",
	            loadtext: "Cargando",
	            colNames: nombres,
	            colModel: columnas,
	            height: "auto",
	            viewrecords: true,
	            caption: "Listado de Configuración Etapas y SubEtapas de Atención",
	            jsonReader: {
	                root: "filas",
	                page: "pagina",
	                total: "total",
	                records: "registros",
	                repeatitems: false,
	                
	            },
	            onSelectRow: function(rowid, status) {
	               //	$('#txtIdNormaSeleccionada').attr('value',rowid);//sacar algun valor de la etapa
	             },
                    afterInsertRow: function(rowid, aData, rowelem) {
                        var rowData = grid.getRowData(rowid);
                        if (rowData["countSubEtapa"] < 1) {
                            $('tr#' + rowid, grid)
                                    .children("td.sgcollapsed")
                                    .html("")
                                    .removeClass('ui-sgcollapsed sgcollapsed');
                        }
                    },
	            onRightClickRow: function(rowid, iRow, iCol, e) {
	            	$('#linkEditarMantEtapa').attr('onClick', 'mantenimientoEtapa.abrirMantenimientoEtapaTramite("modificar","'+rowid +'","gridConsulta")');
	                $('#linkVerMantEtapa').attr('onClick','mantenimientoEtapa.abrirMantenimientoEtapaTramite("consultar","'+rowid+'","gridConsulta")');
	                $('#linkEliminarMantEtapa').attr('onClick','mantenimientoEtapa.validarEliminarEtapaTramite("'+rowid+'","gridConsulta")');
	              
	               if($('#divEnlaceTagVerMantEtapa input').html()!=null){
	            	    $('#contextMenuMantEtapa li a[value="CO-MANTSUBE"]').html($('#divEnlaceTagVerMantEtapa').html());
	                } else {  
	                    $('#contextMenuMantEtapa li a[value="CO-MANTSUBE"]').remove();
	                 
	                }
	                
	                if($('#divEnlaceTagEditarMantEtapa input').html()!=null){
	                    $('#contextMenuMantEtapa li a[value="MO-MANTSUBE"]').html($('#divEnlaceTagEditarMantEtapa').html());
	                } else {  
	                    $('#contextMenuMantEtapa li a[value="MO-MANTSUBE"]').remove();
	                }
	                
	                if($('#divEnlaceTagEliminarMantEtapa input').html()!=null){
	                    $('#contextMenuMantEtapa li a[value="EL-MANTSUBE"]').html($('#divEnlaceTagEliminarMantEtapa').html());
	                } else {  
	                    $('#contextMenuMantEtapa li a[value="EL-MANTSUBE"]').remove();
	                }
	                
	            },
	            loadComplete: function(data){
	            	$('#contextMenuMantEtapa').parent().remove();
	            	$('#divMenuMantEtapa').html(
	            	 '<ul id="contextMenuMantEtapa">'+ 
	            		'<li><a value="CO-MANTSUBE"></a></li>'+
	            		'<li><a value="MO-MANTSUBE"></a></li>'+
	            		'<li><a value="EL-MANTSUBE"></a></li>'+
	            	'</ul>'		
	            	);
	             $('#contextMenuMantEtapa').puicontextmenu({target: $('#gridConsulta')});
	             
	            },
	            loadError: function(jqXHR) {
	                errorAjax(jqXHR);
	            },
	            subGrid: true,
	            subGridOptions: {
                    "plusicon": "ui-icon-circle-plus",
                    "minusicon": "ui-icon-circle-minus",
                    "openicon": "ui-icon-arrowreturn-1-e",
                    "reloadOnExpand": false,
                    "selectOnExpand": false
                    },
               subGridRowExpanded: function(subgrid_id, row_id) {
            	   var dataPadre = grid.getRowData(row_id);
            	   
            	   var subgrid_table_id, pager_id;
                   subgrid_table_id = subgrid_id + "_t";
                   pager_id = "p_" + subgrid_table_id;
                   	
                   
                   
                   $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
                   jQuery("#" + subgrid_table_id).jqGrid({
                	   url: baseURL + "pages/mantenimientoEtapa/listarSubEtapa",
                       postData: {
                            idEtapa : dataPadre['etapa.idEtapa']
                       			},
                       datatype: "json",
                       mtype: 'POST',
                       colNames: ['SUBETAPA DE ATENCIÓN','TIEMPO EN DÍAS HÁBILES','RESPONSABLE','a','b','c','d'],
                       colModel: [{name: "descripcion", width: 95, sortable: false, align: "center"},
              		              {name: "tiempoDias",width: 95, sortable: false, align: "center"},
            		              {name: "idResponsable.descripcion",width: 100, sortable: false, align: "center" },
            		              {name: "estado", hidden:true},
            			          {name: "idSubetapa", hidden:true },
            			          {name: "idEtapa.idEtapa", hidden:true},
            			          {name: "idResponsable.idMaestroColumna", hidden:true}
            			          ],                                  
                       rowNum: global.rowNum,
                       caption: "Listado de SubEtapas Asociadas",
                       jsonReader: {
                           root: "filas", 
                           page: "pagina", 
                           total: "total", 
                           records: "registros", 
                           repeatitems: false,
                           id: "idBaseLegal"
                       },
                       loadComplete: function(data) {
                           $('#contextMenuTipificacionSub').parent().remove();
                           $('#divContextMenuTipificacionSub').html("<ul id='contextMenuTipificacionSub'>"
                                   + "<li> Sin Accion </li>"
                                   + "</ul>");
                           $('#contextMenuTipificacionSub').puicontextmenu({
                               target: $("#gridConsulta .ui-subgrid")
                           });
                           $('#contextMenuTipificacionSub').parent().css('opacity',0);
                       },
                       pager: pager_id,
                       sortname: 'num',
                       sortorder: "asc",
                       height: '100%',
                       autowidth: true,
                     //  onSelectRow: function(row_id, status) {
                       	//jQuery("#" + subgrid_table_id).resetSelection();
                       //},
                      // onRightClickRow: function(rowid, iRow, iCol, e) {
                       
                       //}
                   });
                  
               }
	    });
	},
	listarSubEtapaModificar  : function(idEtapa) {
		var nombres = ['DESCRIPCIÓN DE LA SUBETAPA','TIEMPO EN DÍAS HÁBILES','RESPONSABLE','a','b','c','d'];
        var columnas = [
            {name: "descripcion", width: 120, sortable: false, align: "center"},
            {name: "tiempoDias",width: 120, sortable: false, align: "center"},
            {name: "idResponsable.descripcion",width: 100, sortable: false, align: "left" },
            {name: "idResponsable.idMaestroColumna", hidden:true},
            {name: "estado", hidden:true},
	        {name: "idSubetapa", hidden:true },
	        {name: "idEtapa.idEtapa", hidden:true},
         ];
       
        var url = baseURL + "pages/mantenimientoEtapa/listarSubEtapa" ;
		var nombreGrid = "SubEtapasModificar"; 
		$("#gridContenedor"+nombreGrid).html("");
        var grid = $("<table>", {
            "id": "grid"+nombreGrid
        });
        var pager = $("<div>", {
            "id": "paginacion"+nombreGrid
        });
        $("#gridContenedor"+nombreGrid).append(grid).append(pager);
       
        grid.jqGrid({
			    url: url,
	            datatype: "json",
	            mtype : "POST",
	            postData: { 
	            	idEtapa : idEtapa,
	            	
 	            },
	            hidegrid: false,
	            rowNum: 5,
	            pager: "#paginacion"+nombreGrid,
	            emptyrecords: "No se encontraron resultados",
	            recordtext: "{0} - {1}",
	            loadtext: "Cargando",
	            colNames: nombres,
	            colModel: columnas,
	            width : "600",
	            height: "auto",
	            viewrecords: true,
	            caption: "Listado de SubEtapas Asociadas",
	            jsonReader: {
	                root: "filas",
	                page: "pagina",
	                total: "total",
	                records: "registros",
	                repeatitems: false,
	            },
	            onSelectRow: function(rowid, status) {
	                grid.resetSelection();
	            },
	            onRightClickRow: function(rowid, iRow, iCol, e) {
	            	$('#linkEditarMantSubEtapa').attr('onClick', 'mantenimientoEtapa.abrirMantenimientoSubEtapaTramite("modificar","'+rowid +'","gridSubEtapasModificar")');
	                $('#linkVerMantSubEtapa').attr('onClick','mantenimientoEtapa.abrirMantenimientoSubEtapaTramite("consultar","'+rowid+'","gridSubEtapasModificar")');
	                $('#linkEliminarMantSubEtapa').attr('onClick','mantenimientoEtapa.validaSubEtapaRepetida("'+rowid+'","gridSubEtapasModificar")');
	               
	               if($('#divEnlaceTagVerMantSubEtapa input').html()!=null){
	            	    $('#contextMenuMantSubEtapa li a[value="CO-MANTSUBETAPA"]').html($('#divEnlaceTagVerMantSubEtapa').html());
	                } else {  
	                    $('#contextMenuMantSubEtapa li a[value="CO-MANTSUBETAPA"]').remove();
	                }
	                
	                if($('#divEnlaceTagEditarMantSubEtapa input').html()!=null){
	                    $('#contextMenuMantSubEtapa li a[value="MO-MANTSUBETAPA"]').html($('#divEnlaceTagEditarMantSubEtapa').html());
	                } else {  
	                    $('#contextMenuMantSubEtapa li a[value="MO-MANTSUBETAPA"]').remove();
	                }
	                
	                if($('#divEnlaceTagEliminarMantSubEtapa input').html()!=null){
	                    $('#contextMenuMantSubEtapa li a[value="EL-MANTSUBETAPA"]').html($('#divEnlaceTagEliminarMantSubEtapa').html());
	                } else {  
	                    $('#contextMenuMantSubEtapa li a[value="EL-MANTSUBETAPA"]').remove();
	                }
	            },
	            loadComplete: function(data){
	            	$('#contextMenuMantSubEtapa').parent().remove();
					$('#divMenuMantSubEtapa').html(
					        	 '<ul id="contextMenuMantSubEtapa">'+ 
					          	 '<li><a value="CO-MANTSUBETAPA"></a></li>'+
					             '<li><a value="MO-MANTSUBETAPA"></a></li>'+
					             '<li><a value="EL-MANTSUBETAPA"></a></li>'+
					            '</ul>'		
					     );
			       $('#contextMenuMantSubEtapa').puicontextmenu({target: $('#gridSubEtapasModificar')});
			       if(tipoConsulta){
			       		$('#contextMenuMantSubEtapa').parent().css('opacity',0);
			       		tipoConsulta =  false;
	               }
	            },
	            loadError: function(jqXHR) {
	                errorAjax(jqXHR);
	            }
	             
	    });
	},
	
	
	validaSubEtapaRepetida : function(rowid,idGrid) {
		var row=$('#'+idGrid).jqGrid("getRowData",rowid);
		console.log("validaSubEtapaRepetida---> idSubEtapa = " + row.idSubetapa);
		
		  $.ajax({
			  url:baseURL + "pages/mantenimientoEtapa/validaSubEtapaRepetida",
			  type : 'POST',
			  async : false,
			  data : {
				  idSubEtapa : row.idSubetapa
			  },
			  success : function(data){
				  if(data.repetido=="si"){
					  confirm.open("La SubEtapa que intenta eliminar está asociada a más de un Tramite. ¿Est&aacute seguro que desea eliminarla?","mantenimientoEtapa.procesarEliminarSubEtapaTramite('"+rowid+"','"+idGrid+"')");
				  }else if(data.repetido=="no"){
					  mantenimientoEtapa.validarEliminarSubEtapaTramite(rowid, idGrid);
				  }
			  },
			  error:errorAjax
		  });
	},	
	
	validarEliminarSubEtapaTramite : function(rowid, idGrid) {
		confirm.open("¿Ud. est&aacute; seguro de eliminar este registro?","mantenimientoEtapa.procesarEliminarSubEtapaTramite('"+rowid+"','"+idGrid+"')");
	},
	
	
	procesarEliminarSubEtapaTramite : function(rowid,idGrid) {
		  var row=$('#'+idGrid).jqGrid("getRowData",rowid);
		  console.log("procesarEliminarSubEtapaTramite---> idSubEtapa = " + row.idSubetapa);
		  $.ajax({
			  url:baseURL + "pages/mantenimientoEtapa/eliminarSubEtapa",
			  type : 'POST',
			  async : false,
			  data : {
				  idSubEtapa : row.idSubetapa
			  },
			  success : function(data){
				  if(data.resultado=="0"){
					  mantenimientoEtapa.listarSubEtapaModificar($('#idEtapaEdit').val());
					 mensajeGrowl("success", global.confirm.delete, "");
				  }else{
					  mensajeGrowl("error", data.mensaje, "");
				  }
			  },
			  error:errorAjax
		  });
		},
	
	
			
	abrirMantenimientoEtapaTramite : function(accion, rowid, idGrid){
		switch(accion){
			case 'modificar' : title = 'Editar Configuración de Etapas y SubEtapas de Atención ';break;
			case 'consultar' : title = 'Consultar Configuración de Etapas y SubEtapas de Atención ';break;
		}
	
	    var row=$('#'+idGrid).jqGrid("getRowData",rowid);
		$.ajax({
			url : baseURL + "pages/mantenimientoEtapa/abrirMantenimientoEtapaTramite", 
			type:'POST',
            async:false,
            data:{
            	title : title,
            	idEtapaTramite: row.idEtapaTramite,
            	idEtapa : row['etapa.idEtapa']
            },
            //beforeSend:muestraLoading,
		 	success:function(data){
		 		 ocultaLoading();
		 		console.log("valor idEtapa del mant= "+ row['etapa.idEtapa']);
                $("#dialogModificarEtapaTramite").html(data);
                $("#dialogModificarEtapaTramite").dialog({
// OSINE_SFS-1232 - INICIO 	            	
	            	position: { my: 'top', at: 'top+20' },
//	                resizable: false,
//	                draggable: true,
	                autoOpen: true,
//	                height:"auto",
//	            	width: "auto",
	                width: 700,
	                modal: true,
	                title: title,
	                dialogClass: 'dialogModal',
// OSINE_SFS-1232 - FIN 
                    closeText: "Cerrar",
                });
		 		if(accion=="consultar"){
	            	$('#frmMantEditarEtapa input, #frmMantEditarEtapa select').attr('disabled',true);
	            	$('#btnModConfiguracion_modificarEtapaTramite').val('Consultar');
	            	$('#btnModConfiguracion_modificarEtapaTramite').attr('disabled',false);
	            	$('#btnNuevaSubEtapa_modificarEtapaTramite').hide();
	            	$('#btnGuardarEtapa_modificarEtapaTramite').hide();	
	            	tipoConsulta =  true;
	            	
	            }
              if(accion=="modificar"){
            	  $('#idInforGeneralMod').attr('disabled',true);
	            }
	        
		 	}
		});
		mantenimientoEtapa.listarSubEtapaModificar(row['etapa.idEtapa']);
		
	},
	
	validarEliminarEtapaTramite : function(rowid, idGrid){
		confirm.open("¿Ud. est&aacute; seguro de eliminar este registro?","mantenimientoEtapa.procesarEliminarEtapaTramite('"+rowid+"','"+idGrid+"')");
	},
	
	
	procesarEliminarEtapaTramite : function(rowid,idGrid) {
	  var row=$('#'+idGrid).jqGrid("getRowData",rowid);
	  $.ajax({
		  url:baseURL + "pages/mantenimientoEtapa/eliminarEtapaTramite",
		  type : 'POST',
		  async : false,
		  data : {
			  idEtapaTramite : row.idEtapaTramite
		  },
		  success : function(data){
			  if(data.resultado=="0"){
				 mensajeGrowl("success", global.confirm.delete, "");
				 mantenimientoEtapa.listarEtapaTramite();
			  }else{
				  mensajeGrowl("error", data.mensaje, "");
			  }
		  },
		  error:errorAjax
	  });
	},
 
	abrirMantenimientoSubEtapaTramite : function(accion, rowid, idGrid) {
		console.log("ingreso abrirMantenimientoSubEtapaTramite");
		switch(accion){
			case 'modificar' : title = 'Editar SubEtapa de Atención ';break;
			case 'consultar' : title = 'Consultar SubEtapas de Atención ';break;
		}
		var row=$('#'+idGrid).jqGrid("getRowData",rowid);
		$.ajax({
			url : baseURL + "pages/mantenimientoEtapa/abrirMantenimientoSubEtapaTramite", 
			type:'POST',
            async:false,
            data:{
            	title : title,
            	descripcion : row.descripcion,
              	tiempoDias : row.tiempoDias,
              	responsable : row.responsable,
              	'idEtapa.idEtapa' : row['idEtapa.idEtapa'],
              	'idResponsable.idMaestroColumna' : row['idResponsable.idMaestroColumna'],
    	  		idSubetapa : row.idSubetapa
    	  	},
		 	//beforeSend:loading.open,
		 	success:function(data){
		 		//loading.close();
		 		console.log("valor idEtapa del mant= "+ row['idEtapa.idEtapa']);
		 		console.log("idResponsable " + row['idResponsable.idMaestroColumna']);
                $("#dialogModificarSubEtapa").html(data);
                $("#dialogModificarSubEtapa").dialog({
                    resizable: false,
                    draggable: true,
                    autoOpen: true,
                    height:"auto",
                    width: "auto",
                    modal: true,
                    title: title,
                    dialogClass: 'dialogModal',
                    closeText: "Cerrar",
                });
		 		if(accion=="consultar"){
	            	$('#frmModificarSubEtapa input, #frmModificarSubEtapa select').attr('disabled',true);
	            	$('#btnGuardarSubEtapaMod').hide();
	            	
	            }
	            if(accion=="modificar"){
	            	
	            }
	        	
		 	}
            
		});
		
	},
	
	 abrirModificarConfiguracion : function() {
			$.ajax({
			        url:baseURL + "pages/mantenimientoEtapa/abrirModificarConfiguracion", 
			        type:'POST',
			        async:false,
			        data:{
			        	idConfTramite : $("#idConfTramite").val()
			        },
			        beforeSend:muestraLoading,
			        success:function(data){
			            ocultaLoading();
			            $("#dialogModificarConfiguracion").html(data);
			            $("#dialogModificarConfiguracion").dialog({
			                resizable: false,
			                draggable: true,
			                autoOpen: true,
			                height:"auto",
			                width: "auto",
			                modal: true,
			                dialogClass: 'dialog',
			                title: "Modificar Configuración de Etapas y SubEtapas de Atención"
			            });
			        },
			        error:errorAjax
			    });
		},
   
	validarBusqueda : function() {
		var cmbGerenciaEtapa = $('#cmbGerenciaEtapa').val();
		var cmbDivisionEtapa =  $('#cmbDivisionEtapa').val();
		var cmbSectorEtapa =  $('#cmbSectorEtapa').val();
		var cmbActividadEtapa =  $('#cmbActividadEtapa').val();
		var cmbAgenteEtapa = $('#cmbAgenteEtapa').val();
		var cmbResponsable = $('#cmbResponsable').val();
		var cmbTramiteEtapa = $('#cmbTramiteEtapa').val();

	}
	

};

function cargarGrillas(){
	procesarLista.listarConfTramite();
	procesarLista.listarEtapa();
	procesarLista.listarSubEtapaEtapa('','');
}

jQuery.extend($.fn.fmatter, { 
	 formatoSelectEtapa: function(cellvalue, options, rowdata) {
		 var idEtapa=rowdata.idEtapa;
		 var html='';
		  html+="<input class='ETAPA' id='seleccionEtapa_" + idEtapa + "' type='checkbox' name='seleccionEtapa_" + idEtapa +
		  		"' onclick='procesarLista.listarSubEtapaEtapa(this,\""+idEtapa+"\")' />" +
		        "<label for='seleccionEtapa_"+ idEtapa + "' class='checkbox'></label>";
		  return html;
		  
	 },
	 formatoSelectConfiguracion: function(cellvalue, options, rowdata) {		 
		 var idConfTramite=rowdata.idConfTramite;
		 var html='';
		  html+="<input id='config_"+ idConfTramite + "' type='radio' name='config_' onclick='procesarLista.listarEtapa(this,\""+idConfTramite+"\")' />" +
		  		"<label for='config_"+ idConfTramite +"' class='radio'></label>";
		   return html;
	 } 
	
});
