<%-- 
    Document   : etapaTramite
    Created on : 20/01/2015, 12:27:21 PM
    Author     : lbarboza
--%>
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Etapa" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/mantenimiento/etapaTramite.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> B�SQUEDA ETAPA</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <div class="tac">
                                <div class="form">
                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbProcesoBusq">PROCESO:</label></div>
                                        <div>
                                            <select id="cmbProcesoBusq" name="proceso" validate="[O]">
                                                <option value="00">--Seleccione--</option>
                                                <option value="01">OPERATIVO</option>
                                                <option value="02">PRE OPERATIVO</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="botones">
                                <button id="btnBuscarEtapa" title="Buscar Etapa" class="btnSimple">Buscar</button>
                                <!--seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarEtapa" title="Buscar Zonificaci�n Detalle" onclick=""/-->
                                <button id="btnLimpiarBuscarEtapa" title="Limpiar" class="btnSimple">Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                            <button id="btnNuevoEtapa" title="Nueva Etapa">Nuevo</button> 
                            <!--seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoEtapa" title="Nuevo Detalle Zonificaci�n" onclick=""/-->
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorEtapa"></div>
                            <div id="divContextMenuEtapa"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- dialogs -->
        <div id="dialogMantEtapa" class="dialog"  title="Mantenimiento Etapa" style="display:none;">
           
        <!-- dialogs -->
        <div id="dialogMantTramite" class="dialog"  title="Mantenimiento Tramite" style="display:none;">
       
        
                <!-- dialogs -->
        <div id="dialogMantMotivoTramite" class="dialog"  title="Mantenimiento Motivo Tramite" style="display:none;">
            <form id="frmMantMotivoTramite" class="tac">
                <div id="divMensajeValidaMotivoTramite" class="errorMensaje" tabindex='1' style="display: none" ></div>
                <input id="txtIdTramite" name="idTramite" type="hidden"/>
                <div class="form">
                    <fieldset>
                        <div class="filaForm">
                            <div class="lble"><label for="txtTramite">TRAMITE(*):</label></div>
                            <div>
                                <input id="txtTramite" name="etapa" type="text" validate="[O]" maxlength="38" class="inputPeque txtMayus" disabled="true"/>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lble"><label for="txtDescripcionMotivoTr">DESCRIPCION(*):</label></div>
                            <div>
                                <input id="txtDescripcionMotivoTr" name="esEditable" type="text" validate="[O]" maxlength="200" class="inputPeque txtMayus" />
                            </div>
                        </div>
                    </fieldset>
                    <div id="botones">
                        <!--                        <button id="btnAgregarZoniDeta" title="Agregar Detalle Zonificaci�n">Agregar</button> -->
                        <input id="btnAgregarMotivoTramite" class="btn_a btn_small" type="button" value="Agregar" title="Agregar Motivo Tramite">
                        <!--seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnAgregarTramite" title="Agregar Detalle Zonificaci�n" onclick=""/-->
                    </div>
                    <div class="gridMargin">
                        <div id="gridContenedorMotivoTramite"></div>
                        <div id="divContextMenuMotivoTramite"></div>
                    </div>
                </div>
            </form>
            <div id="obligatorio">(*) Campos obligatorios</div>
            <div id="botones">
<!--                <button id="btnGuardarMaesColu" title="Guardar Maestro Columna">Guardar</button> -->
                <!--seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarMaesColu" title="Guardar Zonificaci�n" onclick=""/-->
                <button id="btnEditarTramite" title="Editar Tramite" style="display:none;">Editar</button> 
                <!--seg:botonTag code="MO" value="Editar " styleClass="btn_a btn_small" id="btnEditarTramite" title="Editar Zonificaci�n" onclick=""/-->
                <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
            </div>
        </div>

        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>