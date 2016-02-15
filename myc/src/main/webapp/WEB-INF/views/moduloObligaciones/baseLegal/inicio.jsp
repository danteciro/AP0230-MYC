<%-- 
    Document   : inicio
    Created on : 13/08/2014, 10:28:47 AM
    Author     : gvillanueva
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Gestión de Base Legal" scrollPanelTitle="Base Legal">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/moduloObligaciones/baseLegal/inicio.js" />' charset="utf-8"></script>
        <style>
            .ui-state-active{
                background:#002c53 !important;
            }
            .ui-state-active a, .ui-state-active a:link, .ui-state-active a:visited{
                color:white !important;
            }
            #options .pui-panel-titlebar{
                background: none repeat scroll 0 0 #ffffff;
                border: 2px solid #ffffff;
            }
            #options{
                border: 1px solid #ffffff;
            }

            .fieldsetlegal {
            margin: 0 0 0 143px;
            display: inline-block;

            }
            .lblc{
                text-align: right !important;
            }
            .fileUpload {
                cursor: pointer;
                height: 25px;
                opacity: 0;
                position: absolute;
                width: 437px;
                z-index: 5;
            }
            .ui-jqgrid tr.jqgrow td {
                font-size: 12px !important;
                white-space: normal !important;
            } 
            .ui-jqgrid .ui-jqgrid-htable th div {
                font-size: 12px !important;
                text-transform: none;
                white-space:normal !important;
                position:relative;
                overflow:hidden;
            }
            #gridContenedorConfiguracionSupervision .ui-jqgrid tr.jqgrow td {
                font-size: 11px !important;
                font-weight: bold !important;
            }
            
            #gridContenedorConfiguracionSupervision td[aria-describedby="gridConfiguracionSupervision_tieneAct"]{
                color: white;
            } 
            .textBoldConfiguracion{
                font-weight: bold !important;
            }

        </style>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div class="container">
            <div class="pui-panel ui-widget-content">
                <div class="pui-panel-titlebar ui-corner-all">
                    <span class="ui-panel-title">GESTION DE BASE LEGAL</span>
                </div>
                <div class="pui-panel-content ui-widget-content">
                    <fieldset id="busquedaBaseLegal">
                        <form id="formBaseLegal" class="tac"> 
                            <div id="divMensajeValidacionBusqueda" class="errorMensaje" tabindex='1' style="display: none" ></div>
                            <div class="form">
                                <div class="filaForm">
                                    <div class="lble"><label for="txtCodigoBaseLegal">C&#243;digo Norma Legal:</label></div>
                                    <div>
                                        <input id="txtCodigoBaseLegal" name="txtCodigoBaseLegal" type="text" maxlength="10" />
                                    </div>
                                </div>
                                <div class="filaForm">
                                    <div class="lble vam"><label for="txtTituloBaseLegal">T&iacute;tulo Norma Legal:</label></div>
                                    <div class="vam">
                                        <input id="txtTituloBaseLegal" name="" type="text" maxlength="2000" style="width: 465px;" />
                                    </div>
                                </div>
                                <div class="filaForm">
                                    <div class="lble vam"><label for="txtDescBaseLegal">Descripci&#243;n Norma Legal:</label></div>
                                    <div class="vam">
                                        <input id="txtDescBaseLegal" name="txtDescBaseLegal" type="text" maxlength="2000" style="width: 465px;" />
                                    </div>
                                </div>                                
                            </div>
                        </form>
                        <div id="botones">
                            <button id="btnBuscarBaseLegal" title="Buscar" class="btnSimple">Buscar</button>
                            <button id="btnLimpiarBaseLegal" title="Limpiar" class="btnSimple">Limpiar</button>
                            <button id="btnBusquedaAvanzadaBaseLegal" title="Busqueda Avanzada Base Legal" class="btnSimple">Busqueda Avanzada</button>
                        </div>

                    </fieldset>
                    <div id="botonesDerecha">
                        <input type="text" id="txtIdNormaSeleccionada" style="display:none" />
                        <input type="text" id="txtIdBaseSeleccionada" style="display:none" />
                        <button title="Crear Base Legal" id="btnMantenimientoBaseLegal">Nuevo</button>
                    </div>
                    <div id="divContGridBusqBaseLegal">
                    <div id="gridContenedorBasesLegales"></div>
                    <div id="divContextMenuBasesLegales"></div>
                    <div id="divContextMenuObligaciones"></div>
                    </div>
                    <div id="divContGridBusqObli">
                    <div id="gridContenedorBusqAvanObligaciones"></div>
                    <div id="divContextMenuBusqAvanObligaciones"></div>
                    <div id="divContextMenuBusqAvanBaseLegal"></div>
                    </div>
                </div>
            </div>
        </div>    
        <!--Contenedores-->
        <!--Contenedor Búsqueda Avanzada--> 
        <div id="divOcultaContainerBusquedaAvanzada" style="display:none;"><div id="containerDialogBusquedaAvanzadaBaseLegal" title="Busqueda Avanzada Base Legal"></div></div>
        <div id="divOcultaContainerMantenimiento" style="display:none;"><div id="containerDialogMantenimientoBaseLegal"></div></div>
        <div id="divOcultaContainerHistorico" style="display:none;"><div id="containerDialogHistoricoBaseLegal"></div></div>
        
        <!--Boton Regresar-->
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
        
    </jsp:attribute>
</t:template>

