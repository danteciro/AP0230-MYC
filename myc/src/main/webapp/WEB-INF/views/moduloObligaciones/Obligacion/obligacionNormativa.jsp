<%-- 
    Document   : obligacionNormativa
    Created on : 13/08/2014, 07:39:09 PM
    Author     : gvillanueva
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Obligación Normativa" scrollPanelTitle="Obligación Normativa">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/moduloObligaciones/Obligacion/obligacionNormativa.js" />' charset="utf-8"></script>
                  
        
<style>
    .fileUpload{
			width: 437px;
			height: 25px;
			opacity: 0;
			z-index: 5;
			position: absolute;
			top: 5px;
			
			cursor: pointer;
		}
    #options .pui-panel-titlebar{
        background: none repeat scroll 0 0 #ffffff;
        border: 2px solid #ffffff;
    }
    #options{
        border: 1px solid #ffffff;
    }
    
    .fieldsetlegal {
    margin: 0 0 0 125px;
    display: inline-block;
    
    }
    .lblc{
    text-align: right !important;
    }
    tr td input[type="checkbox"]{
    display: block !important;
    }
    .ui-jqgrid tr.jqgrow td {
    overflow: visible !important;
    }

    .ui-jqgrid tr.jqgrow td {
    font-size: 11px !important;
    
    white-space: normal !important;
    height:auto;
    vertical-align:text-top;
    text-align: justify !important;
    } 
    .ui-jqgrid .ui-jqgrid-htable th div {
    font-size: 12px !important;
    text-transform: uppercase;
    white-space:normal !important;
    height:auto;
    vertical-align:text-top;
    position:relative;
    //overflow:hidden;
    text-align: justify;
    } 
        </style>
        </script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> GESTION DE OBLIGACIONES NORMATIVAS</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="formObligacionNormativa" class="tac">
                                <div class="form">
                                    <div class="filaForm">
                                        <div class="slcta"><label for="txtCodigoObligacionNormativa">Código Obligación Normativa:</label></div>
                                        <div>
                                            <input id="txtCodigoObligacionNormativa" name="item" type="text" maxlength="100" />
                                            
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="slcta vat"><label for="txtDescObligacionNormativa">Descripción Obligación Normativa:</label></div>
                                        <div>
                                            <textarea id="txtDescObligacionNormativa" name="Descripción Obligación Normativa" style="height:40px;width:400px;" maxlength="400"></textarea>
                                            
                                        </div>
                                    </div>

                                </div>
                            </form>
                            <div id="botones">
                                <button id="btnBuscar" title="Buscar" class="btnSimple">Buscar</button>
                                
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                            <button title="Nueva Obligación Normativa" id="btnNuevoObligacionNormativa">Nuevo</button>
<!--                            <button title="Arbol de Actividades" id="btnFormActividad">Arbol</button>-->
                            
                        </div>
                        <br>
                        <div id="gridContenedorOblig"></div>
                        <div id="divContextMenuOblig"></div>
             
                    </div>
                </div>
                <!-- Dialog Arbol de Actividades-->
                <div id="dialogArbolActividades"></div>
                <!---->
                <div class="dialog" id="dialogArbolBusqueda" title="ARBOL DE ACTIVIDADES" style="display:none;">
                    <form >
                        <fieldset>
                            <legend>Arbol de Actividades</legend>
                            <div id="arbolActividadesAgregar" style="height: 250px;width:465px;">
                                <ul style="display: none;">
                                    <li id='0' class='folder'>ACTIVIDADES
                                        <ul style="display:none;">

                                            <li id='1' class='folder'>REFINERIA
                                                <ul>
                                                    <li id='2'>Refineria Complejas</li>
                                                    <li id='3'>Refinería Topping</li>
                                                </ul>
                                            </li>
                                            <li id='4' class='folder'>Planta de Procesamiento
                                                <ul>
                                                    <li id='5'>Procesamiento Gas</li>
                                                    <li id='6'>Procesamiento LGN</li>
                                                </ul>
                                            </li>
                                            <li id='7' class='folder'>Planta de Lubricante
                                                <ul>
                                                    <li id='8'>Planta de Lubricante y Grasas</li>
                                                </ul>
                                            </li>
                                            <li id='9' class='folder'>Planta de Abastecimiento
                                                <ul>
                                                    <li id='10'>Plantas de Abastecimiento de Combustible Líquido y OPDH</li>
                                                    <li id='11'>Plantas de Abastecimiento de GLP</li>
                                                    <li id='12'>Plantas de Abastecimiento de Aeropuerto</li>
                                                </ul>
                                            </li>
                                            <li id='13' class='folder'>Planta Envasadora
                                                <ul>
                                                    <li id='14'>Planta Envasadora de GLP</li>
                                                </ul>
                                            </li>
                                            <li id='15' class='folder'>Terminales
                                                <ul>
                                                    <li id='16'>Terminales Combustibles Líquidos
                                                    <li id='17'>Terminales Fluviales</li>
                                                    <li id='18'>Terminales GLP</li>
                                                    <li id='19'>Terminales Maritimos</li>
                                                    <li id='20'>Terminales OPDH</li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </fieldset>
                        
                        <div id="botonesDerecha">
                            <button title="Seleccionar Actividades"id="btnSeleccionarActividades">Seleccionar</button>
                        </div>
                    </form>
                </div>
                <!--generar relaciones-->
         <div id="dialogGenerarRelaciones" class="dialog"  title="ASIGNAR BASES LEGAL" style="display:none;">
            
                
                            <div class="form"> 
                                <div class="filaForm">

                                </div>

                                <div class="filaForm">
                                    <div class="lblc" style="width:140px;text-align: right;"><label for="cmbbuTipoBaseLegal">Tipo Norma Legal(*):</label></div>
                                    <div style="width: 200px;">
                                        <select id="cmbbuTipoBaseLegal" validate="[O]" name="tipobaselegal">
                                            <option value="">--Seleccione--</option>
                                            <option value="1">Decreto Legislativo - DLeg.</option>
                                            <option value="2">Decreto Supremo - DS</option>
                                            <option value="3">Ley - Ley</option>
                                            <option value="4">Resolución Directoral - RD</option>
                                            <option value="5">Resolución de Consejo Directivo - RCD</option>
                                            <option value="6">Resolución de Gerencia General - RGG</option>
                                            <option value="7">Resolución de Gerencia de Fiscalización de Hidrocarburos Líquidos - RGFHL</option>
                                            <option value="8">Resolución Ministerial - RM</option>
                                            <option value="9">Resolución SubDirectoral - RSDIR</option>

                                        </select>
                                    </div>
                                    <div class="lblc" ><label for="txtbuNumeroBaseLegal" >Número(*):</label></div>
                                    <div style="width:120px;">
                                        <input style="width:70px;" id="txtbuNumeroBaseLegal" name="value" type="text">
                                    </div>
                                    <div class="lblc" style="width:100px;"><label for="cmbbuAnoBaseLegal">Año:</label></div>
                                    <div style="width:120px;">
                                        <input id="cmbbuAnoBaseLegal" name="value" style="width:100px;" placeholder="--2000--">
                                    </div>
                                    <div class="lblc" style="width:100px;"><label for="cmbbuSiglaBaseLegal">Sigla:</label></div>
                                    <div>
                                        <select style="width:100px;" id="cmbbuSiglaBaseLegal" validate="[O]" name="sigla">
                                            <option value="">--Seleccione--</option>
                                            <option value="">EM</option>
                                            <option value="1">DGH</option>
                                            <option value="2">MEM</option>
                                            <option value="3">PCM</option>
                                            <option value="3">OS/CD</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="filaForm"> 
                                    <div class="lblc" style="width:140px;" ><label for="datepickervig1" >Fecha Entrada Vigencia: </label></div>
                                    <div style="width:200px;">
                                        <input type="text" id="datepickervig1" >
                                    </div>
                                    <div class="lblc" ><label for="datepickerpub1" >Fecha Publicación: </label></div>
                                    <div style="width:200px;">
                                        <input type="text" id="datepickerpub1" >
                                    </div>


                                </div>
                                <div class="filaForm">
                                    <div class="lblc" style="vertical-align:top;width:140px;"><label for="txtTituloBaseLegal">Título:</label></div>
                                    <div>
                                        <textarea maxlength="400" style="height:40px;width:833px;" name="Norma" id="txtTituloBaseLegal" placeholder="Descripción del Título de la Base Legal"></textarea>
                                    </div>
                                </div>
                                
                                <div id="options" style="margin:0;" title=" ">
                                <fieldset class="fieldsetlegal">
                                <div class="filaForm">
                                         
                                    <div class="lblc"><label for="txtbuArticuloBaseLegal"><strong>Artículo:</strong></label></div>
                                    <div style="">
                                         <input id="txtArticuloBaseLegal" name="value" type="text" >
                                    </div>
                                    <div class="lblc"><label for="cmbbuIndice1BaseLegal"><strong>Inciso Nivel 1:</strong></label></div>
                                    <div style="">
                                        <input id="txtIndice1BaseLegal" name="value" type="text" style="width:135px;">
                                    </div>
                                    <div class="lblc"><label for="cmbbuIndice2BaseLegal"><strong>Inciso Nivel 2:</strong></label></div>
                                    <div style="">
                                        <input id="txtIndice2BaseLegal" name="value" type="text" style="width:135px;">
                                    </div>
                                    
                                 
                                            </div>
                                <div class="filaForm" >
                                    <br>
                                </div>
                                
                                  <div class="filaForm">
                                     <div class="lblc"><label for="cmbbuBaseBaseLegal"><Strong>Tipo de Anexo:</Strong></label></div>
                                    <div style="">
                                         <select id="cmbBaseBaseLegal" validate="[O]" name="base">
                                            <option value="">--Seleccione--</option>
                                            <option value="1">Reglamento</option>
                                            <option value="2">Texto Único Ordenado</option>

                                        </select>
                                    </div>
                                     </div>
                                     <div class="filaForm">
                                     <div class="lblc"><label for="txtbuArtDispBaseLegal"><Strong>Artículo:</Strong></label></div>
                                    <div style="">
                                         <input id="txtArtDispBaseLegal" name="value" type="text" >
                                    </div>
                                    <div class="lblc" ><label for="cmbbuIndice3BaseLegal"><strong>Inciso Nivel 1:</strong></label></div>
                                    <div style="">
                                        <input id="txtIndice3BaseLegal" name="value" type="text" style="width:135px;" >
                                    </div>
                                    <div class="lblc"><label for="cmbbuIndice4BaseLegal"><strong>Inciso Nivel 2:</strong></label></div>
                                    <div style="">
                                         <input id="txtIndice4BaseLegal" name="value" type="text" style="width:135px;" >
                                    </div>
                                              
                                </div>
                                       
                                <div class="filaForm" >
                                    <br>
                                </div>
                                <div class="filaForm" >
                                <div class="lblc"  ><label for="datepickerart1" ><strong>Fecha Entrada Vigencia:</strong> </label></div>
                                <div style="width:200px;vertical-align: top;">
                                        <input type="text" id="datepickerart1">
                                </div>
                                </div>
                                
                                <div class="filaForm">
                                    <br>
                                </div>
                                <div class="filaForm" >
                                    <div class="lblc" style="width:100px;"><label for="txtbuActividadBaseLegal">Actividades:</label></div>
                                    <div>
                                        <input id="txtbuActividadBaseLegal" name="item" type="text" maxlength="100" placeholder="Actividades" style="width:120px;" />
                                    </div> 
                                    <div class="lble" style="width:120px;">
                                        <button id="btnActividadClave1" type="button" title="Actividades" class="btnSimple">Actividades</button>
                                    </div>
                                    <div class="lblc" style="width:120px;"><label for="txtProductoBaseLegal">Productos:</label></div>
                                    <div>
                                        <input id="txtProductoBaseLegal" name="item" type="text" maxlength="100"  placeholder="Productos" style="width:120px;"/>
                                    </div> 
                                    <div class="lble" style="width:120px;">
                                        <button id="btnProductoClave1" type="button" title="Productos" class="btnSimple">Productos</button>
                                    </div>         
                                </div>
                            </fieldset>
                                  
                                    </div>
                                </div>
                            
                            <div>
                                <div id="obligatorio" style="height:10px;text-align: left;padding-left: 140px;" colspan="6">(*) Campos Obligatorios</div>
                                <br>
                            </div>
                <div id="botones">
                                <button id="btnBuscarAvanBaseLegal" type="button" title="Busqueda Avanzada Base Legal" class="btnSimple">Buscar</button>
                                <button title="Cerrar" id="btnClose" class="btnCloseDialog">Cerrar</button>
                            </div>
            
                
                <div id="tabs">
		  <ul>
			<li><a href="#tabs-1">Búsqueda Base Legal</a></li>
			<li><a href="#tabs-2">Asignación Base Legal</a></li>
			
		  </ul>
		  <div id="tabs-1">
                                            
                      <table id="list9"></table>
                      <div id="pager9"></div>
                      
		</div>
		  <div id="tabs-2">
                     <table id="list10"></table>
                      <div id="pager10"></div>
                      <div>
                          <center><button id="btnAsignar" title="Asignar" class="btnSimple">Guardar</button></center>
                     </div>
		</div>
		  
		</div>
                   
            
            
        </div>
                
                <!-- upload dialog -->
                <div class="dialog" id="dialogUpload" title="Subir Archivo" style="display:none;">
                    <form class="tac">
                        <fieldset>
                            <legend>Subir Archivo</legend>
                            <div class="form">
                                <input type="file" id="fileupload"/>
                                <button id="guardarUpload" class="btnSimple" title="Subir Archivo" type="button">Guardar Archivo</button>
                                </div>
                            <div></div>
                        </fieldset>
                    </form>
                </div>
                <div class="dialog" id="dialogUpload1" title="Subir Archivo" style="display:none;">
                    <form class="tac">
                        <fieldset>
                            <legend>Subir Archivo</legend>
                            <div class="form">
                                <input type="file" id="fileupload1"/>
                                <button id="guardarUpload1" class="btnSimple" title="Subir Archivo" type="button">Guardar Archivo</button>
                                </div>
                            <div></div>
                        </fieldset>
                    </form>
                </div>
                        
                
                <!-- dialog subir archivo -->
                <div id="dialogNuevaFoto" title="Nueva Pauta" class="dialog" style="display:none;" >
                    <div>
				<form id="formArchivo" >
				
							<table>
								<tr>
								<td><label>Nombre Archivo:</label></td>
									<td colspan="3">
									<input id="fileArchivo"   name="archivos[0]" placeholder="" value="" type="file" class="fileUpload" />
										
									<input id="file_name" type="text" value="" name="nombreArchivo" disabled="disabled" style="width:220px;">

									<td><button id="search_file" type="button" title="Seleccionar Foto" class="btnGuardar" style="width:150px;">Doc. Adjuntos</button>
									<!--  button id="add_file" type="button" title="Agregar Archivo" class="btnGuardar" onclick="javascript:validarArchivo();" >Agregar</button> </td-->
									
								</tr>							
							
							</table>

				</form>				
                    </div>
                    <div>
				<form id="formNuevaFoto">
					<div style="margin:auto; display:table;">
					<input id="new_fotoPrincipal" type="hidden" name="fotoPrincipal" />
                                        <div class="filaForm">
                                            <div class="lble" style="width:94px;"><label>Título(*):</label></div>
                                            <div><input id="new_txtTituloFoto" name="titulo" type="text" class="textoMayusculas" style="width:430px;"/></div>
                                        </div>			
                                        <div class="filaForm">
                                            <div class="lble vat" style="width:94px;"><label>Descripción:</label></div>
                                            <div><textarea id="new_txtDescripcionFoto" name="comentario" class="textoMayusculas" rows="2" style="width: 430px;"></textarea></div>  
                                        </div>                 
                                        <div class="filaForm">
                                            <div class="lble" style="width:94px;"><label>Fecha Carga:</label></div>
                                            <div><input id="new_dtpFechaCaptura" name="fechaCaptura" type="text"/></div>
					</div>
                                        <div class="lble" style="padding-left: 94px;"><label id="obligatorio">(*) Campos Obligatorios</label></div>
			            	
					<div id="botones">
					<button id="btnCrearFoto" type="button" title="Crear Foto" class="btnGuardar">Guardar</button>
					<button type="button" title="Cancelar" class="btnCloseDialog">Cancelar</button>
					</div>
							
					</div>
				</form>
                    </div>
                </div>
                <!-- dialog-->
                <div class="dialog" id="dialogArbolBusquedaProducto" title="ARBOL DE PRODUCTOS" style="display:none;">
                    <form >
                        <fieldset>
                            <legend>Arbol de Productos</legend>
                            <div id="arbolProductosAgregar" style="height: 250px;width:465px;">
                                <ul style="display: none;">
                                    <li id='0' class='folder'>PRODUCTOS
                                        <ul style="display:none;">

                                            <li id='1' class='folder'>Combustibles Líquidos
                                                <ul>
                                                    
                                                    <li id='2'>Gasol 84</li>
                                                </ul>
                                            </li>
                                            <li id='3' class='folder'>GLP
                                                <ul>
                                                    <li id='4'>GLP 1</li>
                                                    <li id='5'>GLP 2</li>
                                                </ul>
                                            </li>
                                            
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </fieldset>
                        
                        <div id="botonesDerecha">
                            <button title="Seleccionar Actividades"id="btnSeleccionarActividades">Seleccionar</button>
                        </div>
                    </form>
            </div>
            <div class="dialog" id="dialogArbolBusquedaProducto1" title="ARBOL DE PRODUCTOS" style="display:none;">
                    <form >
                         <fieldset>
                            <legend>Arbol de Productos</legend>
                            <div id="arbolProductos" style="height: 200px;width:465px;">
                                <ul style="display: none;">
                                    <li id='0' class='folder'>PRODUCTOS
                                        <ul style="display:none;">

                                            <li id='1' class='folder'>Combustibles Líquidos
                                                <ul>
                                                    
                                                    <li id='2'>Gasol 84</li>
                                                </ul>
                                            </li>
                                            <li id='3' class='folder'>GLP
                                                <ul>
                                                    <li id='4'>GLP 1</li>
                                                    <li id='5'>GLP 2</li>
                                                </ul>
                                            </li>
                                            
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </fieldset>
                        
                        <div id="botonesDerecha">
                            <button title="Seleccionar Productos" id="btnSeleccionarProductos">Seleccionar</button>
                        </div>
                    </form>
            </div>
            <div class="dialog" id="dialogArbolBusquedaTransporte" title="ARBOL DE TRANSPORTES" style="display:none;">
                <form >
                     <fieldset>
                            <legend>Arbol de Transportes</legend>
                            <div id="arbolActividades" style="height: 200px;width:465px;">
                                <ul style="display: none;">
                                    <li id='0' class='folder'>TIPOS DE TRANSPORTES
                                        <ul style="display:none;">

                                            <li id='1'>Camión</li>
                                            <li id='2'>Camioneta</li>
                                            <li id='3'>Tractor</li>
                                          
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </fieldset>
                    
                    <div id="botonesDerecha">
                     <button title="Seleccionar Transportes" id="btnSeleccionarTransporte">Seleccionar</button>
                    </div>
                </form>
            </div>
                        
                        
                        
        <div id="dialogAgregarObligacionNormativa" class="dialog"  title="OBLIGACION NORMATIVA" style="display:none;">
            
                <fieldset>
                    <legend>Obligación Normativa</legend>
                    <div class="form">
                        <div class="filaForm">
                                <div class="slcta"><label for="txtseCodigoObligacionNormativa">Código Obligación Normativa:</label></div>
                                <div>
                                            <input id="txtseCodigoObligacionNormativa" name="item" type="text" maxlength="100" disabled="disabled"/>
                                </div>
                        </div>
                         <div class="filaForm">
                                <div class="slcta" style="vertical-align: top;"><label for="txtDesObligacionNormativa">Descripción Obligación Normativa:</label></div>
                                    <div>
                                    <textarea id="txtDesObligacionNormativa" maxlength="500" style="height:40px;width: 750px;" class="" name="obligacion normativa" ></textarea>
                                    </div>
                        </div>
                        <div class="filaForm">
                        <div class="slcta" ><label for="cmbTipoObligacionNormativa">Tema de Obligación Normativa:</label></div>
                        <div>
                            <select id="cmbTipoObligacionNormativa" validate="[O]" name="tipoobligacionnormativa">
                                <option value="">--Seleccione--</option>
                                <option value="1">Documental</option>
                                <option value="2">Eléctrica</option>
                                <option value="3">Estructural</option>
                                <option value="4">General</option>
                            </select>
                        </div>
                        <div class="lblc" style="width:200px;"><label for="cmbCriticidadObligacionNormativa">Criticidad de Obligación Normativa:</label></div>
                        <div>
                            <select id="cmbCriticidadObligacionNormativa" validate="[O]" name="criticidad">
                                <option value="">--Seleccione--</option>
                                <option value="">Baja</option>
                                <option value="1">Media</option>
                                <option value="2">Alta</option>
                                
                            </select>
                        </div>
                        
                        
                        <div class="vam">
                            
<!--                          <button id="imgUpload" class="btnSimple" title="Subir Archivo"  type="button">Subir Archivo</button>-->
                         <a class="linkImagen">
                                        <img alt="" src="/myc/images/clicpaper.png" width="25"
                                        height="25" id="imgUpload" value="Subir Archivo"
                                        title="Subir Archivo">
                             </a>                            

<!--                                -->
                                <img id="imgcargar" height="24" width="20" hidden="true" src="/myc/images/stickers.png"/>
                        </div>
                        <div style="vertical-align:middle;">
                                   <label id="txtImgUpload" ></label>
                        </div>
                        </div>
                        <div>
                            <br>
                        </div>
                        <div>
                   
                        <div id="tabsob">
                                <ul>
                                      <li><a href="#tabs-1">Tipificación</a></li>
                                      <li><a href="#tabs-2">Descripciones</a></li>
                                      <li><a href="#tabs-3">Pautas</a></li>
                                      
                                </ul>
                        <div id="tabs-1">
                        <div class="filaForm">
                            <div style="width:150px;"><label for="txtTipificacion">Tipificación:</label></div>   
                            <div>
                                <input type="text" id="txtTipificacion" name="value" style="width:100px;">
                            </div>
                            <div class="lblc" style="width:190px;"><label for="txtDescTipificacion">Descripción de la Infracción:</label></div>   
                            <div>
                                <input type="text" id="txtDescTipificacion" name="value" style="width:436px;" disabled="disabled" />
                            </div>
                        </div>
                        <div class="filaForm">
                            
                            <div style="width:150px;"><label for="spinnerhasta">Sanción Monetaria (Hasta):</label></div>   
                            <div>
                                <input id="spinnerhasta" name="value" style="width:95px;">
                            </div>
                              
                         </div>
                        <div class="filaForm"> 
                            <fieldset>
                            <legend>Otras Sanciones</legend>
                            <div style="vertical-align: top;width:40px;">
                                
                            </div>
                            <div style="vertical-align: top;width:160px;">
                                <input id="checkboxCB" type="checkbox" name="" value="" disabled="disabled">
                            <label for="checkboxCB" class="checkbox">Comiso de Bienes</label>
                            </div>
                            <div style="vertical-align: top;width:160px;">
                                <input id="checkboxPO" type="checkbox" name="" value="" disabled="disabled">
                            <label for="checkboxPO" class="checkbox">Paralización de Obras</label>
                            </div>
                            <div style="vertical-align: top;width:160px;">
                                <input id="checkboxCI" type="checkbox" name="" value="" disabled="disabled">
                            <label for="checkboxCI" class="checkbox">Cierre de Instalaciones</label>
                            </div>
                            <div style="vertical-align: top;width:160px;">
                                <input id="checkboxSTA" type="checkbox" name="" value="" disabled="disabled">
                            <label for="checkboxSTA" class="checkbox">Suspensión Temporal de Actividades</label>
                            </div>
                            <div style="vertical-align: top;width:160px;">
                                <input id="checkboxRIE" type="checkbox" name="" value="" disabled="disabled">
                            <label for="checkboxRIE" class="checkbox">Retiro de Instalaciones y/o Equipos</label>
                            </div>
                            </fieldset>
                            </div>
                            </div>
                           <div id="tabs-2">
                                <div class="filaForm">
                                        <div class="lble vat" style="width:200px;"><label for="txtDescObligacionNormativaActa">Descripción Obligación Normativa (Acta y Declaración Jurada):</label></div>
                                        <div>
                                    <textarea maxlength="500" style="height:40px;width: 706px;" class="" name="Descripción Acta" id="txtDescObligacionNormativaActa"></textarea>
                                    </div>
                                    </div>
                               <div class="filaForm">
                                   <br>
                               </div>
                                
                                <div class="filaForm">
                                        <div class="lble vat" style="width:200px;"><label for="txtDescObligacionNormativaGuia">Descripción Obligación Normativa (Guia):</label></div>
                                        <div>
                                    <textarea maxlength="500" style="height:40px;width: 706px;" class="" name="Descripción Guia" id="txtDescObligacionNormativaGuia"></textarea>
                                    </div>
                                    
                                        
                                    </div>
                               <div class="filaForm">
                                    <div class="lble vat" style="width:200px;"><label for=""></label></div>
                                        
                                  <div class="vam">
<!--                                <button id="imgUpload" class="btnSimple" title="Subir Archivo"  type="button">Subir Archivo</button>-->
                                    <a class="linkImagen">
                                        <img alt="" src="/myc/images/clicpaper.png" width="25"
                                        height="25" id="imgUpload1" value="Subir Archivo"
                                        title="Subir Archivo">
                                    </a>                            
                                    <img id="imgcargar1" height="24" width="20" hidden="true" src="/myc/images/stickers.png"/>
                                    </div>
                                    <div style="vertical-align:middle;">
                                   <label id="txtImgUpload1" ></label>
                                    </div>     
                               </div>
                                
                            </div>
                            <div id="tabs-3">
                                 
                                <table>
				<tr>
					<td style="width:100px;"><label for="btnNuevecito">Pautas:</label></td>
					<td><button class="btnSimple" title="Subir Foto" type="button" id="btnNuevecito">Subir Pautas:</button></td>
                                        
				</tr>
                                </table>        
                                <div >
                                    <br>
                                </div>
                                <div class="gridPautas">
                                    <div id="gridContenedorPautas"></div>
                                    <div id="divContextMenuPautas"></div>
                                </div>
                                
                            </div>
                       </div>
                        
                    </div>
                        </div>
                    <div>
                        <br>
                    </div>
                    <div class="filaForm" id="aplicaCategorias">
                        
                                    <div class="lblc" style="width:120px;"><label for="txtTransportes">Transportes:</label></div>
                                    <div>
                                        <input id="txtTransportes" name="item" type="text" maxlength="100" placeholder="Transportes" style="width:120px;" />
                                    </div> 
                                    <div class="lble" style="width:120px;">
                                        <button id="btnTransportes" type="button" title="Transporte" class="btnSimple">Transporte</button>
                                    </div>
                                    <div class="lblc" style="width:120px;"><label for="txtProductos">Productos:</label></div>
                                    <div>
                                        <input id="txtProductos" name="item" type="text" maxlength="100"  placeholder="Productos" style="width:120px;"/>
                                    </div> 
                                    <div class="lble" style="width:120px;">
                                        <button id="btnProductos" type="button" title="Productos" class="btnSimple">Producto</button>
                                    </div>  
                                  
                    </div>
                        
                    
                </fieldset>
                
                <div id="botones">
                <button id="btnAgregarBaseLegal" type="button" title="Agregar Base Legal" class="btnSimple">Guardar</button>
                <button title="Cerrar" id="btnClose" class="btnCloseDialog">Cerrar</button>
                </div>
            
            
        </div>
              </div>
            
         </div>
        
          
        
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>
