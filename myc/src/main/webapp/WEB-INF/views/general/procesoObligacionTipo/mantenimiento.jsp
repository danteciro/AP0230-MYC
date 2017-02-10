<%-- 
    Document   : inicio
    Created on : 14/07/2014, 11:52:49 AM
    Author     : jpiro
--%>
  
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Proceso Obligacion" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/procesoObligacionTipo/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA DE PROCESO - OBLIGACIÓN TIPO</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="formBusqueda" class="tac">
                                <div class="form">
                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbProceso">PROCESO:</label></div>
                                        <div class="slcta">
                                            <select id="cmbProceso" name="idProceso">
                                                <option value="">--Seleccione--</option>
                                                <c:forEach items="${listadoProceso}" var="t">
                                                    <option value='${t.idProceso}' <c:if test="${t.idProceso==r.idProceso}">selected</c:if> >${t.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbProceso">OBLIGACION TIPO:</label></div>
                                        <div class="slcta">
                                            <select id="cmbObligacionTipo" name="idObligacionTipo">
                                                <option value="">--Seleccione--</option>
                                                  <c:forEach items="${listadoObligacionTipo}" var="t">
                                                    <option value='${t.idObligacionTipo}' <c:if test="${t.idObligacionTipo==r.idObligacionTipo}">selected</c:if> >${t.nombre}</option>
                                                </c:forEach>    
                                            </select>
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtActivP1">RUBRO:</label></div>
                                        <div >
                                            <input id="txtActivP1" onclick="abrirPopupBusqActividad()" type="text" style="cursor: pointer; width: 400px;" readonly placeholder="Click para seleccionar rubro"/>
                                            <input id="txtIdActivP1" type="hidden" />
                                        </div>
                                        <div id="dialogBusqActividad" class="dialog" style="display:none;"></div>
                                    </div>
                                 
                                </div>
                            </form>
                            <div id="botones">
                                <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarOP" title="Buscar Procedimiento" onclick=""/>
                                <seg:botonTag code="CO" value="Limpiar" styleClass="btn_a btn_small" id="btnLimpiarForm" title="Limpiar Opciones" onclick=""/>
<!--                                <button id="btnLimpiarForm" title="Limpiar Opciones" >Limpiar</button>-->
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                        <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoObligacionProceso" title="Nuevo Procedimiento" onclick=""/>
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorObligacionProceso"></div>
                            <div id="divContextMenuObligacionProceso"></div>
                        </div>
						<!-- PR0013 - Inicio -->                           
			            <div id="divTagEnlacesObliTipo" style="display:none">
							<div id="divEnlaceTagVerObliTipo">
								<span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
								<seg:enlaceTag id='linkVerObligacionProceso' code='CO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Consultar</span>
							</div>
							<div id="divEnlaceTagEliminarObliTipo">
								<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
								<seg:enlaceTag id='linkEliminarObligacionProceso' code='EL' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Eliminar</span>
							</div>
						</div>
						<!-- PR0013 - Fin -->
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
        <div id="dialogMantObligacionProceso" style="display:none;"></div>
        
            
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>