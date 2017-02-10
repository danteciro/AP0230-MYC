<%-- 
    Document   : tipificacionSancion
    Created on : 03/02/2015, 09:58:15 AM
    Author     : lbarboza
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Zonificacion Detalle" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/mantenimiento/tipificacionSancion.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA TIPIFICACI&Oacute;N SANCI&Oacute;N</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <div class="tac">
                                <div class="form">
                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbTipificacionBusq">TIPIFICACI&Oacute;N:</label></div>
                                        <div>
                                            <select id="cmbTipificacionBusq" name="tipificacion" validate="[O]">
                                                
                                            </select>
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbTipoSancionBusq">TIPO SANCI&Oacute;N:</label></div>
                                        <div>
                                            <select id="cmbTipoSancionBusq" name="tipoSancion" validate="[O]">
                                                
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="botones">
                                <button id="btnBuscarTipiSanc" title="Buscar Tipificacion Sancion" class="btnSimple">Buscar</button>
                                <!--seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarTipiSanc" title="Buscar Zonificación Detalle" onclick=""/-->
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                            <button id="btnNuevoTipiSanc" title="Nueva Tipificacion Sancion">Nuevo</button> 
                            <!--seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoTipiSanc" title="Nuevo Detalle Zonificación" onclick=""/-->
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorTipificacionSancion"></div>
                            <div id="divContextMenuTipificacionSancion"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- dialogs -->
        
    </jsp:attribute>
</t:template>