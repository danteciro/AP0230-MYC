<%-- 
    Document   : concurso
    Created on : 28/01/2015, 06:58:45 PM
    Author     : lbarboza
    Modifier   : jpiro
--%>
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro AutoAyuda" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/autoayuda/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA AUTOAYUDA</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <div class="tac">
                                <div class="form">
                                    <div class="filaForm">
                                        <div class="lbla"><label for="txtNombBusq">NOMBRE AUTOAYUDA:</label></div>
                                        <div>
                                            <input id="txtNombBusq" name="nombre_autoayuda" type="text" validate="[O]" maxlength="50" class="inputPeque txtMayus" />
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lbla"><label for="txtIdentBusq">IDENTIFICADOR AUTOAYUDA:</label></div>
                                        <div>
                                            <input id="txtIdentBusq" name="identificador_autoayuda" type="text" validate="[O]" maxlength="40" class="inputPeque txtMayus" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="botones">
                                <button id="btnBuscarAutoAyuda" title="Buscar AutoAyuda" class="btnSimple">Buscar</button>
                                <button id="btnLimpiarBuscarAutoAyuda" title="Limpiar" class="btnSimple">Limpiar</button>
                            </div>
                        </fieldset>
                        <div class="gridMargin">
                            <div id="gridContenedorAutoAyuda"></div>
                            <div id="divContextMenuAutoAyuda"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- dialogs -->
        <div id="dialogMantAutoAyuda" class="dialog"  title="Mantenimiento AutoAyuda" style="display:none;">
            <form id="frmMantAutoAyuda" class="tac">
                <div id="divMensajeValidaAutoAyuda" class="errorMensaje" tabindex='1' style="display: none" ></div>
                <input id="txtIdAutoayuda" name="idAutoayuda" type="hidden"/>
                <div class="form">
                    <fieldset>
                        <div class="filaForm">
                            <div class="lbla"><label for="txtNombre">NOMBRE AUTOAYUDA(*):</label></div>
                            <div>
                                <input id="txtNombre" name="nombreAutoayuda" type="text" validate="[O]" maxlength="38" class="inputPlace txtMayus" />
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lbla"><label for="txtIdentificador">IDENTIFICADOR AUTOAYUDA:</label></div>
                            <div>
                                <input id="txtIdentificador" name="identificadorAutoayuda" type="text" validate="[O]" maxlength="200" class="inputPlace txtMayus" disabled />
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lbla"><label for="txtIdentificador">ESTADO(*):</label></div>
                            <div>
                                <select id="slctEstado" name="estado" class="selectPlace">
                                    <option value="1">ACTIVO</option>
                                    <option value="0">INACTIVO</option>
                                </select>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lbla vat"><label for="txtDescripcionAutoAyuda">DESCRIPCI&Oacute;N AUTOAYUDA(*):</label></div>
                            <div>
                                <textarea id="txtDescripcionAutoayuda" class="inputGrande" style="height: 80px;" name="descripcionAutoayuda" maxlength="4000" validate="[O]"></textarea>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </form>
            <div id="obligatorio">(*) Campos obligatorios</div>
            <div id="botones">
                <seg:botonTag code="MO" value="Editar" styleClass="btn_a btn_small" id="btnEditarAutoAyuda" title="Editar AutoAyuda" onclick=""/>
                <input class="btnCloseDialog btn_a btn_small" type="button" value="Cerrar" title="Cerrar">                
            </div>
        </div>
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>