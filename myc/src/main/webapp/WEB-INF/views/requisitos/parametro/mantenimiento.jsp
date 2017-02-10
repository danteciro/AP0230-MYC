<%-- 
    Document   : inicio
    Created on : 23/07/2014, 03:43:45 PM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Parametros" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/requisitos/parametro/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA PARÁMETROS DINÁMICOS</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <div class="tac">
                                <div class="form">
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtNombreParaBusq">NOMBRE:</label></div>
                                        <div>
                                            <input id="txtDescripParaBusq" name="descripcion" type="text"  maxlength="25" class="inputPeque txtMayus" />
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="">ÁMBITO:</label></div>
                                        <div>                                           
											<select	id="cmbAmbitoParaBusq" name="idAmbitoParametrico.idMaestroColumna" validate="[O]"></select>
							            </div>
                                    </div>
                                 
                                </div>
                            </div>
                            <div id="botones">
<!--                                 <button id="btnBuscarPara" title="Buscar Parametro Dinamico" class="btnSimple">Buscar</button> -->
                                 <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarPara" title="Buscar Parámetro Dinámico" onclick=""/>
                                
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
<!--                             <button id="btnNuevoPara" title="Nuevo Parámetro Dinámico">Nuevo</button> -->
                            <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoPara" title="Nuevo Parámetro Dinámico" onclick=""/>
                            
                        </div>
                        
                        <div class="gridMargin">
                            <div id="gridContenedorParametroDinamico"></div>
                            <div id="divContextMenuParametroDinamico"></div>
                        </div>
                        
						<!-- PR0013 - Inicio -->                           
            			<div id="divTagEnlaces" style="display:none;">
							<div id="divEnlaceTagEditar">
								<span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
								<seg:enlaceTag id='linkEditarProcedimiento' code='MO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Editar</span>
							</div>
							<div id="divEnlaceTagEliminar">
								<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
								<seg:enlaceTag id='linkEliminarProcedimiento' code='EL' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Eliminar</span>
							</div>
							<div id="divEnlaceTagValores">
								<span class="pui-menuitem-icon ui-icon ui-icon-note"></span>
								<seg:enlaceTag id='linkAgregarActProcedimiento' code='CO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Valores</span>
							</div>
						</div>
						<!-- PR0013 - Fin -->
                    </div>
                    
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
        <div id="dialogMantParametro" class="dialog"  title="Mantenimiento Parámetros Dinámicos" style="display:none;">
            <form id="frmMantParametro" class="tac">
                <div id="divMensajeValidaParametro" class="errorMensaje" tabindex='1' style="display: none" ></div>
                <input id="txtIdPara" name="idParametroDinamico" type="hidden"/>
                <div class="form">
                    <div class="filaForm">
                        <div class="lble"><label for="txtNombrePara">NOMBRE(*):</label></div>
                        <div>
                            <input id="txtNombrePara" name="nombre" type="text" validate="[O]" maxlength="25" class="inputPeque txtMayus" />
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lble"><label for="">ÁMBITO(*):</label></div>
                        <div>
                           <select	id="cmbAmbitoPara" name="idAmbitoParametrico.idMaestroColumna" validate="[O]">
       
                           </select>
                        </div>
                    </div>
                    
                    <div class="filaForm">
                        <div class="lble"><label for="">TIPO CONSULTA:</label></div>
                         <div>                                           
						 <select	id="cmbTipoConsulta" name="idTipoConsulta.idMaestroColumna" ></select>
						  </div>
                    </div>
                    <div class="filaForm">
                        <div class="lble vat"><label for="txtDescripcionPara">DESCRIPCIÓN:</label></div>
                        <div>
                            <textarea name="descripcion" id="txtDescripcionPara" maxlength="500" style="height:50px" class="inputGrande"></textarea>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lble vat"><label for="txtComentarioPara">COMENTARIO:</label></div>
                        <div>
                            <textarea name="comentario" id="txtComentarioPara" maxlength="500" style="height:50px" class="inputGrande"></textarea>
                        </div>
                    </div>
                    
                    <div class="filaForm" id="divPreguntaPara"  style="display:none;">
                        <div class="lble vat"><label for="txtComentarioPara">PREGUNTA:</label></div>
                        <div>
                            <textarea name="pregunta" id="txtPreguntaPara" maxlength="500" style="height:50px" class="inputGrande"></textarea>
                        </div>
                    </div>
                </div>
            </form>
            <div id="obligatorio">(*) Campos obligatorios</div>
            <div id="botones">
<!--                 <button id="btnGuardarPara" title="Guardar">Guardar</button> -->
                <seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarPara" title="Guardar Parametro" onclick=""/>
<!--                 <button id="btnEditarPara" title="Editar" style="display:none;">Editar</button> -->
                <seg:botonTag code="MO" value="Editar" styleClass="btn_a btn_small" id="btnEditarPara" title="Editar Parametro" onclick=""/>
                <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
            </div>
        </div>
        <!-- dialogs -->
        <div id="dialogMantValorParametro" class="dialog"  title="Mantenimiento Valor para Parámetro Dinámico" style="display:none;">
            <form id="frmMantValorParametro" class="tac">
                <div id="divMensajeValidaValorParametro" class="errorMensaje" tabindex='1' style="display: none" ></div>
                <input id="txtIdValoPara" name="idValorParametro" type="hidden"/>
                <input id="txtIdParametroDinamico" name="idParametroDinamico" type="hidden"/>
                <input id="chkValorDefecto"  name="valorDefecto"   type="hidden" >
                <div class="form">
                    <div class="filaForm">
                        <div class="lble"><label for="txtValorValoPara">VALOR(*):</label></div>
                        <div>
                            <input id="txtValorValoPara" name="valor" type="text" validate="[O]" maxlength="25" class="inputPeque txtMayus" />
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lble"></div>
                        <div class="ilb"><label for="txtValorValoPara">DEFINIR COMO VALOR POR DEFECTO </label></div>
                        <div class="ilb vam">
                            <input type="checkbox" id="chkValorDefault"  >
                            <label for="chkValorDefault" class="checkbox"></label>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lble vat"><label for="txtDescripcionValoPara">DESCRIPCIÓN:</label></div>
                        <div>
                            <textarea id="txtDescripcionValoPara" name="descripcion" maxlength="500" style="height:50px" class="inputGrande"></textarea>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lble vat"><label for="txtComentarioPara">COMENTARIO:</label></div>
                        <div>
                            <textarea id="txtComentarioValoPara" name="comentario" maxlength="500" style="height:50px" class="inputGrande"></textarea>
                        </div>
                    </div>
                </div>
            </form>
            <div id="obligatorio">(*) Campos obligatorios</div>
            <div id="botones">
<!--                 <button id="btnGuardarValoPara" title="Guardar">Guardar</button> -->
                 <seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarValoPara" title="Guardar" onclick=""/>
<!--                 <button id="btnEditarValoPara" title="Editar" style="display:none;">Editar</button> -->
                <seg:botonTag code="MO" value="Editar" styleClass="btn_a btn_small" id="btnEditarValoPara" title="Editar" onclick=""/>
                <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
            </div>
        </div>
        <!-- dialog -->
        <div id="detalleValoresParametro" style="display:none;" title="Valores Parámetro Dinámico">
            <input type="hidden" id="txtIdParametroDinamicoValor">
            <div class="filaFormUniq">
                <div class="lble"><label>PARÁMETRO DINÁMICO:</label></div>
                <div class="lbla"><span id="lblDescripPara"></span></div>
            </div>
            <div class="tar">
                <div class="gridMargin ilb">
                    <div id="gridContenedorValoresParametroDinamico"></div>
                    <div id="divContextMenuValoresParametroDinamico"></div>
                </div>
            </div>
			<div id="divTagEnlaces" style="display:none;">
				<div id="divEnlaceTagEditarValoPara">
					<span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
					<seg:enlaceTag id='linkEditarValoPara' code='MO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
					<span>Editar</span>
				</div>
				<div id="divEnlaceTagEliminarValoPara">
					<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
					<seg:enlaceTag id='linkEliminarValoPara' code='EL' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
					<span>Eliminar</span>
				</div>
			</div>
            <div id="botones">
<!--                 <button id="btnNuevoValoPara" type="button" title="Nuevo Valor">Nuevo</button> -->
                <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoValoPara" title="Nuevo" onclick=""/>
                <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
            </div>
        </div>
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>
