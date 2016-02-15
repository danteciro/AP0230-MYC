<%-- 
    Document   : inicio
    Created on : 07/09/2015, 02:50:33 PM
    Author     : lgarciar
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Búsqueda Criterio" scrollPanelTitle="Criterio">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/criterio/mantCriterio.js" />' charset="utf-8"></script>

    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div class="container">
            <div class="pui-panel ui-widget-content">
                <div class="pui-panel-titlebar ui-corner-all">
                    <span class="ui-panel-title">BÚSQUEDA CRITERIO</span>
                </div>
                <div class="pui-panel-content ui-widget-content">
                    <fieldset id="busquedaCriterio">
                        <form id="formCriterio" class="tac"> 
                            <div id="divMensajeValidacionBusqueda" class="errorMensaje" tabindex='1' style="display: none" ></div>
                            <div class="form">                                
                                <div class="filaForm">
                                    <div class="lble vam"><label for="txtDescCriterio">Búsqueda Criterio:</label></div>
                                    <div class="vam">
                                        <input id="txtDescCriterio" placeholder="Ingrese Descripción del Criterio" name="txtDescCriterio" type="text" maxlength="2000" style="width: 465px;" />
                                    </div>
                                </div>
                            </div>
                        </form>
                        <div id="botones">
                            <button id="btnBuscarCriterio" title="Buscar" class="btnSimple">Buscar</button>
                            <button id="btnLimpiarCriterio" title="Limpiar" class="btnSimple">Limpiar</button>                           
                        </div>
                    </fieldset>
                    <div id="botonesDerecha">
                        <button title="Crear Criterio" id="btnMantenimientoCriterio">Nuevo</button>
                    </div>

                    <div id="gridContenedorCriterio"></div>  
                    <div id="divContextMenuCriterio"></div>
                    <div id="divContextMenuDetalleCriterio"></div>
                    
                </div>
            </div>
        </div>    
        <!--Contenedores-->
		<div id="containerDialogMantenimientoCriterio" style="display:none;"></div>
		<div id="containerDialogMantenimientoSanciones" style="display:none;"></div>
        
        <!--Boton_Regresar-->
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
        
    </jsp:attribute>
</t:template>