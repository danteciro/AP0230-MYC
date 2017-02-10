<%-- 
    Document   : zonificacion
    Created on : 29/12/2014, 11:19:25 AM
    Author     : lbarboza
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Zonificacion" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/mantenimiento/zonificacion.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA ZONIFICACIÓN</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <div class="tac">
                                <div class="form">
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtNombreZoniBusq">NOMBRE ZONIFICACIÓN:</label></div>
                                        <div>
                                            <input id="txtDescripZoniBusq" name="descripcion" type="text"  maxlength="25" class="inputPeque txtMayus" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="botones">
                                <button id="btnBuscarZoni" title="Buscar Zonificación" class="btnSimple">Buscar</button> 
                                <!--seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarZoni" title="Buscar Zonificación" onclick=""/-->
                                <button id="btnLimpiarBuscarZoni" title="Limpiar" class="btnSimple">Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                            <button id="btnNuevoZoni" title="Nueva Zonificación">Nuevo</button> 
                            <!--seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoZoni" title="Nueva Zonificación" onclick=""/-->
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorZonificacion"></div>
                            <div id="divContextMenuZonificacion"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- dialogs -->
        <div id="dialogMantZonificacion" class="dialog"  title="Mantenimiento Zonificación" style="display:none;">
            <form id="frmMantZonificacion" class="tac">
                <div id="divMensajeValidaZonificacion" class="errorMensaje" tabindex='1' style="display: none" ></div>
                <input id="txtIdZonificacion" name="idZonificacion" type="hidden"/>
                <input id="txtEstadoZonificacion" name="estado" type="hidden"/>
                <div class="form">
                    <fieldset>
                        <div class="filaForm">
                            <div class="lble"><label for="txtNombreZonificacion">NOMBRE(*):</label></div>
                            <div>
                                <input id="txtNombreZonificacion" name="nombre" type="text" validate="[O]" maxlength="38" class="inputPeque txtMayus" />
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div id="botones">
                    <input id="btnAgregarZoni" class="btn_a btn_small" type="button" value="Agregar" title="Agregar Zonificación">
                    <!--seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnAgregarZoni" title="Agregar Detalle Zonificación" onclick=""/-->
                </div>
                <div class="gridMargin">
                    <div id="gridContenedorZonificacionAgregar"></div>
                    <div id="divContextMenuZonificacionAgregar"></div>
                </div>
            </form>
            <div id="obligatorio">(*) Campos obligatorios</div>
            <div id="botones">
                 <button id="btnGuardarZoni" title="Guardar Zonificación">Guardar</button> 
                <!--seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarZoni" title="Guardar Zonificación" onclick=""/-->
                 <button id="btnEditarZoni" title="Editar Zonificación" style="display:none;">Editar</button> 
                <!--seg:botonTag code="MO" value="Editar " styleClass="btn_a btn_small" id="btnEditarZoni" title="Editar Zonificación" onclick=""/-->
                <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
            </div>
            
        </div>

        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>