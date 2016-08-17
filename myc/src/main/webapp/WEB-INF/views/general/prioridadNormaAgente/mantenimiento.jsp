<%-- 
/**
* Resumen           
* Objeto            : mantenimiento.jsp
* Descripción       : Diseño de prioridad norma agente en el MYC.
* Fecha de Creación : 07/07/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Mario Dioses Fernandez.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Mantenimiento Prioridad Norma - Agente" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/prioridadNormaAgente/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> MANTENIMIENTO PRIORIDAD NORMA AGENTE</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="formBusqueda">
                                <div class="tac">
                                    <div class="form">
                                        <div class="filaForm">
                                            <div class="lble"><label for="txtCodTipi">ACTIVIDAD (*) :</label></div>
                                            <div class="slcta">
                                            	<select id="cmbActividad" name="actividad" style="width: 350px;" validate="[O]">
                                            		<option value="">--Seleccione--</option>
	                                                <c:forEach items="${listadoActividad}" var="la">
	                                                    <option value='${la.idActividad}' >${la.nombre}</option>
	                                                </c:forEach>
                                            	</select>                                                
                                            </div>
                                        </div>
                                        <div class="filaForm">
                                            <div class="lble"><label for="txtAgente">AGENTE Y/O<br /> INSTALACI&Oacute;N (*):</label></div>
                                            <div>
                                            	<select id="cmbAgente" name="agente" style="width: 350px;" validate="[O]">
                                            		<option value="">--Seleccione--</option>
                                                </select>                                                
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <div id="botones">
                             <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarPrioridaNA" title="Buscar Prioridad Norma Agente" onclick=""/>
                              <button id="btnLimpiarForm" title="Limpiar Opciones">Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                          <div id="botones3">
                          	<seg:botonTag code="MO" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarEdicionPrioridaNA" title="Guardar Edici&oacute;n" onclick=""/>
                          	<seg:botonTag code="MO" value="Cancelar" styleClass="btn_a btn_small" id="btnCancelarEdicionPrioridaNA" title="Cancelar Edici&oacute;n" onclick=""/>
                          </div>
                          <div id="botones2">
                          	<seg:botonTag code="MO" value="Seleccionar Todo" styleClass="btn_a btn_small" id="btnSeleccionarTodoPrioridaNA" title="Seleccionar Todo" onclick=""/>
                          	<seg:botonTag code="MO" value="Activar Edici&oacute;n" styleClass="btn_a btn_small" id="btnActivarEditarPrioridaNA" title="Activar Edici&oacute;n Prioridad Norma Agente" onclick=""/>
                          	<seg:botonTag code="MO" value="Cancelar" styleClass="btn_a btn_small" id="btnCancelarActivarEditarPrioridaNA" title="Activar Edici&oacute;n Prioridad Norma Agente" onclick=""/>
                          </div>
                          <div id="botones1">                          
                          <seg:botonTag code="MO" value="Editar" styleClass="btn_a btn_small" id="btnEditarPrioridaNA" title="Editar Prioridad Norma Agente" onclick="" disabled="disabled" />
                          <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoPrioridaNA" title="Nueva Prioridad Norma Agente" onclick="" disabled="disabled" />
                          </div>
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorPrioridadNorma1"></div>
                            <div id="divContextMenuPrioridadNorma1"></div>                            
                        </div>	
                        <div id="divTagEnlaces" style="display:none;">					       	
					       	<div id="divEnlaceTagEliminarPrioridadNormaAgente">
								<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
					            <seg:enlaceTag id="linkEliminarPrioridadNormaAgente" code="EL" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
					            <span>Eliminar</span>
							</div>
						</div>	                
                    </div>
                </div>
            </div>
        </div>
        <!-- dialogs -->
        <div id="dialogMantPrioridadNorma" class="dialog"  title="Mantenimiento Prioridad Norma" style="display:none;"></div>
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>
