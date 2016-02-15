<%-- 
    Document   : concurso
    Created on : 28/01/2015, 06:58:45 PM
    Author     : lbarboza
    Modifier   : jpiro
--%>
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Concursos" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/concurso/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA CONCURSO</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <div class="tac">
                                <div class="form">
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtNroConcursoBusq">NRO CONCURSO:</label></div>
                                        <div>
                                            <input id="txtNroConcursoBusq" name="nroConcurso" type="text" validate="[O]" maxlength="200" class="inputPeque txtMayus" />
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtNombreConcursoBusq">NOMBRE CONCURSO:</label></div>
                                        <div>
                                            <input id="txtNombreConcursoBusq" name="nombreConcurso" type="text" validate="[O]" maxlength="200" class="inputPeque txtMayus" />
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtDescripcionConcursoBusq">DESCRIPCI&Oacute;N:</label></div>
                                        <div>
                                            <input id="txtDescripcionConcursoBusq" name="descripcionConcurso" type="text" validate="[O]" maxlength="200" class="inputPeque txtMayus" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="botones">
                                <button id="btnBuscarConcurso" title="Buscar Concurso" class="btnSimple">Buscar</button>
                                <!--seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarConcurso" title="Buscar Zonificación Detalle" onclick=""/-->
                                <button id="btnLimpiarBuscarConcurso" title="Limpiar" class="btnSimple">Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                            <button id="btnNuevoConcurso" title="Nuevo Concurso">Nuevo</button> 
                            <!--seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoConcurso" title="Nuevo Detalle Zonificación" onclick=""/-->
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorConcurso"></div>
                            <div id="divContextMenuConcurso"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- dialogs -->
        <div id="dialogMantConcurso" class="dialog"  title="Mantenimiento Concurso" style="display:none;">
            <form id="frmMantConcurso" class="tac">
                <div id="divMensajeValidaConcurso" class="errorMensaje" tabindex='1' style="display: none" ></div>
                <input id="txtIdConcurso" name="idConcurso" type="hidden"/>
                <div class="form">
                    <fieldset>
                        <div class="filaForm">
                            <div class="lble"><label for="txtNroConcurso">NRO CONCURSO(*):</label></div>
                            <div>
                                <input id="txtNroConcurso" name="numeroConcurso" type="text" validate="[O]" maxlength="38" class="inputPeque txtMayus" />
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lble"><label for="txtNombreConcurso">NOMBRE CONCURSO(*):</label></div>
                            <div>
                                <input id="txtNombreConcurso" name="nombreConcurso" type="text" validate="[O]" maxlength="200" class="inputPeque txtMayus" />
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lble"><label for="txtDescripcionConcuros">DESCRIPCI&Oacute;N(*):</label></div>
                            <div>
                                <input id="txtDescripcionConcurso" name="descripcionConcurso" type="text" validate="[O]" maxlength="200" class="inputPeque txtMayus" />
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="gridMargin">
                    <div id="gridContenedorConcursoAgregar"></div>
                    <div id="divContextMenuConcursoAgregar"></div>
                </div>
            </form>
            <div id="obligatorio">(*) Campos obligatorios</div>
            <div id="botones">
                <seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnAgregarConcurso" title="Guardar Concurso" onclick=""/>
                <button id="btnGuardarConcurso" title="Guardar Etapa" style="display:none;">Guardar</button> 
                <seg:botonTag code="MO" value="Editar" styleClass="btn_a btn_small" id="btnEditarConcurso" title="Editar Concurso" onclick=""/>
                <input class="btnCloseDialog btn_a btn_small" type="button" value="Cerrar" title="Cerrar">                
            </div>
        </div>
        
        <div id="dialogArchivosConcurso"></div>
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>