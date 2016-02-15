<%-- 
    Document   : inicio
    Created on : 14/07/2014, 11:52:49 AM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Tipo Obligacion" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/obligacionTipo/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA DE TIPO - OBLIGACION</span>
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
                                <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarObligacionTipo" title="Buscar Procedimiento" onclick=""/>
<!--                                <button id="btnBuscarProc" title="Buscar Procedimiento">Buscar</button>-->
                                <button id="btnLimpiarForm" title="Limpiar Opciones" >Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                        <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoObligacionTipo" title="Nuevo Procedimiento" onclick=""/>
<!--                             <button title="Nuevo Procedimiento"id="btnNuevoProc">Nuevo</button> -->
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorObligacionTipo"></div>
                            <div id="divContextMenuObligacionTipo"></div>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
        <div id="dialogMantObligacionTipo" style="display:none;"></div>
        
        <!-- formulario -->
        <form id="postGestionarRequisitos" method="post" action="requisitoProcedimiento/nuevo">
            <input type="hidden" id="idProcedimientoP" name="idProcedimiento">
            <input type="hidden" id="itemP" name="item">
            <input type="hidden" id="procedimientoP" name="procedimiento">
            <input type="hidden" id="procesoP" name="proceso">
        </form>
        
      
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>