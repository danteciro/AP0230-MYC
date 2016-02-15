<%-- 
    Document   : inicio
    Created on : 14/07/2014, 11:52:49 AM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Tramite Actividad" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/tramiteActividad/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA DE TRAMITE - RUBRO</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="buscarProc" class="tac">
                                <div class="form">
                                    <div class="filaForm" >
                                        <div class="lble"><label for="cmbProcesoBusq">PROCESO:</label></div>
                                        <div class="slcta">
                                            <select id="cmbProcesoBusq">
                                                <option value="">--Seleccione--</option>
                                                <c:forEach items="${listadoProceso}" var="t">
                                                    <option value='${t.idProceso}' <c:if test="${t.idProceso==r.idProceso}">selected</c:if> >${t.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbEtapaBusq">ETAPA DEL PROCESO:</label></div>
                                        <div class="slcta">
                                            <select id="cmbEtapaBusq">
                                                <option value="">--Seleccione--</option>
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
                                <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarTramRubr" title="Buscar Tramite - Rubro" onclick=""/>
<!--                                <button id="btnBuscarProc" title="Buscar Procedimiento">Buscar</button>-->
                                <button id="btnLimpiarForm" title="Limpiar Opciones" >Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                        <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoTramRubr" title="Nuevo Tramite - Rubro" onclick=""/>
<!--                             <button title="Nuevo Procedimiento"id="btnNuevoProc">Nuevo</button> -->
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorTramiteActividad"></div>
                            <div id="divContextMenuTramiteActividad"></div>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
        <div id="dialogMantTipoTramiteActividad" style="display:none;"></div>
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>