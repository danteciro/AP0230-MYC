<%-- 
    Document   : inicio
    Created on : 23/07/2014, 05:30:07 PM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de MacroRegión" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/registro/confOficinasRegionales.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BUSQUEDA DE MACROREGION</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="formBusqueda">
                                <div class="tac">
                                    <div class="form">
                                        <div class="filaForm">
                                            <div class="lble"><label for="txtDescripRequ">CODIGO:</label></div>
                                            <div>
                                                <input id="txtDescripRequ" name="descripcion" type="text" maxlength="50" class="inputGrande" />
                                            </div>
                                        </div>
                                        <div class="filaForm">
                                            <div class="lble"><label for="txtDescripRequ">MACROREGION:</label></div>
                                            <div>
                                                <input id="txtDescripRequ" name="descripcion" type="text" maxlength="50" class="inputGrande" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <div id="botones">
                                <button id="btnBuscarOficinaRegional" title="Buscar Oficina" class="btnSimple">Buscar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                            <button id="btnNuevaOficinaRegional" title="Nuevo Oficina">Nuevo</button>
                        </div>
                        <div >
                            <div id="gridContenedorOficinaReginal"></div>
                            <div id="divContextMenuOficinaRegional"></div>
                              <div id="divContextMenuOficinaRegionalSub"></div>
                        </div>

                    </div>
                    
                </div>

            </div>
        </div>
            
        <!-- dialogs -->
        <div id="dialogMantOficinaRegional" class="dialog"  title="Configuracion OficinaRegional" style="display:none;margin: 0px 20px;"></div>
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
        
           
        <!-- dialogs -->
        
        <div id="dialogConfiguracionRegion" class="dialog"></div>
        <div id="dialogMantOficina" class="dialog"></div>
        <div id="dialogMantUbigeo" class="dialog"></div>
    </jsp:attribute>
</t:template>
