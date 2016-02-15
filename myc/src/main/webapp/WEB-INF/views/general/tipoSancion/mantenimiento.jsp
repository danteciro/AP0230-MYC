<%-- 
    Document   : inicio
    Created on : 14/07/2014, 11:52:49 AM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Tipo Sancion" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/tipoSancion/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content" id="buscarTipoSancion">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA DE TIPO - SANCION</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="formBusqueda" class="tac">
                                <div class="form">
                          			  <div class="filaForm">
                                            <div class="lble"><label for="txtDescripRequ">NOMBRE:</label></div>
                                            <div>
                                                <input id="nombre" name="nombre" type="text" maxlength="100" class="inputGrande" />
                                            </div>
                                        </div>                                 
                                </div>
                            </form>
                            <div id="botones">
                                <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarSancion" title="Buscar Procedimiento" onclick=""/>
<!--                                <button id="btnBuscarProc" title="Buscar Procedimiento">Buscar</button>-->
                                <button id="btnLimpiarForm" title="Limpiar Opciones" >Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                        <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoTipoSancion" title="Nuevo Procedimiento" onclick=""/>
<!--                             <button title="Nuevo Procedimiento"id="btnNuevoProc">Nuevo</button> -->
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorTipoSancion"></div>
                            <div id="divContextMenuTipoSancion"></div>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
        <div id="dialogMantTipoSancion" style="display:none;"></div>
        
      
        
      
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>