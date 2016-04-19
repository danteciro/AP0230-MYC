<%-- 
    Document   : maestroColumna
    Created on : 15/01/2015, 10:32:57 AM
    Author     : lbarboza
--%>
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Maestro Columna" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/maestroColumna/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA MAESTRO COLUMNA</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <div class="tac">
                                <div class="form">
                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbDominioBusq">GRUPO DE NEGOCIO:</label></div>
                                        <div>
                                            <select id="cmbDominioBusq">
                                                <option value="">--Seleccione--</option>
                                                <c:forEach items="${listadoAplicaciones}" var="la">
                                                    <optgroup label='${la.aplicacion}'>                                
                                                        <c:forEach items="${listadoDominios}" var="ld">
                                                            <c:if test="${ld.aplicacion==la.aplicacion}">
                                                                <option value='${ld.dominio}' <c:if test="${r.dominio==ld.dominio}">selected</c:if>>${ld.descripcion}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="botones">
                            <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarMaesColu" title="Buscar Maestro Columna" onclick=""/>
<!--                                 <button id="btnBuscarMaesColu" title="Buscar Maestro Columna" class="btnSimple">Buscar</button> -->
<!--                                <button id="btnLimpiarBuscarMaesColu" title="Limpiar" class="btnSimple">Limpiar</button>-->
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                        <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoMaesColu" title="Nuevo Maestro Columna" onclick=""/>
<!--                             <button id="btnNuevoMaesColu" title="Nuevo Maestro Columna">Nuevo</button>  -->
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorMaestroColumna"></div>
                            <div id="divContextMenuMaestroColumna"></div>
                        </div>
                        <div id="divTagEnlaces" style="display:none;">
					       	<div id="divEnlaceTagEditarMaestroColumna">
					            <span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
					            <seg:enlaceTag id="linkEditarMaestroColumna" code="MO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
					            <span>Editar</span>
					       	</div>
					       	<div id="divEnlaceTagEliminarMaestroColumna">
								<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
					            <seg:enlaceTag id="linkEliminarMaestroColumna" code="EL" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
					            <span>Eliminar</span>
							</div>
							
							<div id="divEnlaceTagEditarMaestroColumnaMant">
					            <span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
					            <seg:enlaceTag id="linkEditarMaesColuMant" code="MO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
					            <span>Editar</span>
					       	</div>
					       	<div id="divEnlaceTagEliminarMaestroColumnaMant">
								<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
					            <seg:enlaceTag id="linkEliminarMaesColuMant" code="EL" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
					            <span>Eliminar</span>
							</div>
							<div id="divEnlaceTagEditarMaestroTablaMant">
					            <span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
					            <seg:enlaceTag id="linkEditarMaesTabMant" code="MO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
					            <span>Editar</span>
					       	</div>
					       	<div id="divEnlaceTagSeleccionarMaestroTablaMant">
								<span class="pui-menuitem-icon ui-icon ui-icon-check"></span>
					            <seg:enlaceTag id="linkSeleccionarMaesTabMant" code="MO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
					            <span>Seleccionar</span>
							</div>
						</div>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- dialogs -->
        <div id="dialogMantMaestroColumna" class="dialog"  title="Mantenimiento Maestro Columna" style="display:none;"></div>
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>