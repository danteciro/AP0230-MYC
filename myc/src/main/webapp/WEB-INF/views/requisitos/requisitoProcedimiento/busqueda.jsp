<%-- 
    Document   : inicio
    Created on : 14/07/2014, 11:52:49 AM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Configuración de Procedimientos" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/requisitos/requisitoProcedimiento/busqueda.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BUSQUEDA DE PROCEDIMIENTOS - CONFIGURACION DE REQUISITOS POR PROCEDIMIENTO</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form class="tac">
                                <div class="form">
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtItemProcBusq">ITEM:</label></div>
                                        <div>
                                            <input id="txtItemProcBusq" name="item" type="text" maxlength="100" />
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble vam"><label for="txtDenominacionProcBusq">DENOMINACION DE PROCEDIMIENTO:</label></div>
                                        <div class="vam">
                                            <input id="txtDenominacionProcBusq" name="denominacion" type="text" maxlength="100" style="width: 465px;" />
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbProcesoBusq">ETAPA DE PROCESO:</label></div>
                                        <div class="slcta">
                                            <select id="cmbProcesoBusq" name="proceso">
                                                <option value="">--Seleccione--</option>
                                                    <option value="INSTALACION">Instalación</option>
                                                    <option value="PRUEBAS">Pruebas</option>
                                                    <option value="RHO">RHO</option>
                                                    <option value="IGS">Instrumentos de Gestión de Seguridad (IGS)</option>
                                                    <option value="OF">Opinión Favorable</option>
                                            </select>
                                        </div>
                                        <div class="lblc"><label for="cmbTramiteBusq">TRAMITE:</label></div>
                                        <div class="slcta">
                                            <select id="cmbTramiteBusq" name="tramite">
                                                <option value="">--Seleccione--</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label>ACTIVIDADES:</label></div>
                                    </div>

                                    <div class="filaFormArbol">
                                        <input type="hidden" id="idActividadesSelecBusq"/>
                                        <div id="arbolActividadesBusq" style="height: 160px">
                                            <ul style="display: none;">
                                                <li id='1' class='folder'>REFINERIA
                                                    <ul>
                                                        <li id='2'>Refineria Complejas</li>
                                                        <li id='3'>Refinería Topping</li>
                                                    </ul>
                                                </li>
                                                <li id='4' class='folder'>Planta de Procesamiento
                                                    <ul>
                                                        <li id='5'>Procesamiento Gas</li>
                                                        <li id='6'>Procesamiento LGN</li>
                                                    </ul>
                                                </li>
                                                <li id='7' class='folder'>Planta de Lubricante
                                                    <ul>
                                                        <li id='8'>Planta de Lubricante y Grasas</li>
                                                    </ul>
                                                </li>
                                                <li id='9' class='folder'>Planta de Abastecimiento
                                                    <ul>
                                                        <li id='10'>Plantas de Abastecimiento de Combustible Líquido y OPDH</li>
                                                        <li id='11'>Plantas de Abastecimiento de GLP</li>
                                                        <li id='12'>Plantas de Abastecimiento de Aeropuerto</li>
                                                    </ul>
                                                </li>
                                                <li id='13' class='folder'>Planta Envasadora
                                                    <ul>
                                                        <li id='14'>Planta Envasadora de GLP</li>
                                                    </ul>
                                                </li>
                                                <li id='15' class='folder'>Terminales
                                                    <ul>
                                                        <li id='16'>Terminales Combustibles Líquidos
                                                        <li id='17'>Terminales Fluviales</li>
                                                        <li id='18'>Terminales GLP</li>
                                                        <li id='19'>Terminales Maritimos</li>
                                                        <li id='20'>Terminales OPDH</li>
                                                    </ul>
                                                </li>
                                                <li id="21" class='folder'>Consumidor Directo
                                                    <ul>
                                                        <li id="22">Consumidor Directo con Instalaciones Estartégicas de  Combustibles Líquidos y OPDH</li>
                                                        <li id="23">Consumidor Directo con Instalaciones Estartégicas Temporales de  Combustibles Líquidos y OPDH</li>
                                                        <li id="24">Consumidor Directo de Aviación (Fijo y Movil)</li>
                                                        <li id="25">Consumidor Directo de Combustible Líquido con capacidad de 5MB a 50MB</li>
                                                        <li id="26">Consumidor Directo de Combustible Líquido con capacidad hasta 5MB</li>
                                                        <li id="27">Consumidor Directo de Combustible Líquido con capacidad mayor a 50MB</li>
                                                        <li id="28">Consumidor Directo de Combustible Líquido y OPDH  con capacidad hasta 5 MB</li>
                                                        <li id="29">Consumidor Directo de OPDH</li>
                                                        <li id="30">Consumidor Directo de Petróleo (Fijo y Movil)</li>
                                                        <li id="31">Consumidor Directo Especial de Combustible Líquido y OPDH</li>
                                                        <li id="32">Consumidor Directo Estratégico</li>
                                                        <li id="33">Consumidor Directo Móvil de Combustible Líquido y OPDH</li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>

                                    <div class="filaForm">
                                        <div class="lble"><label for="txtBaseLegalBusq">BASE LEGAL:</label></div>
                                        <div>
                                            <input id="txtBaseLegalBusq" name="baseLegal" type="text" maxlength="100" style="width: 465px;" />
                                        </div>
                                    </div>

                                </div>
                            </form>
                            <div id="botones">
                                <button id="btnBuscarProc" title="Buscar Procedimiento" class="btnSimple">Buscar</button>
                            </div>
                        </fieldset>
                        
                        <div class="gridMargin">
                            <div id="gridContenedorProcedimiento"></div>
                            <div id="divContextMenuProcedimiento"></div>
                            <div id="divContextMenuProcedimientoSub"></div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
            
        <!-- formulario -->
        <form id="postGestionarRequisitos" method="post" action="requisitoProcedimiento/nuevo">
            <input type="hidden" id="idProcedimientoP" name="idProcedimiento">
            <input type="hidden" id="itemP" name="item">
            <input type="hidden" id="procedimientoP" name="procedimiento">
            <input type="hidden" id="procesoP" name="proceso">
        </form>
        
        <div id="dialogMantProcedimiento"></div>
        
        <div id="dialogProcedimientoRequisitos">
            <div>
                <div style="margin:0px 20px;">
                    <div class="filaForm">
                        <div class="lble vat"><label>PROCEDIMIENTO:</label></div>
                        <div id="lblProcedimiento" class="ilb vat" style="width:85%"></div>
                    </div>
                    <div class="filaForm">
                        <div class="lble vat"><label>ETAPA DE PROCESO:</label></div>
                        <div id="lblProceso" class="ilb vat" style="width:85%"></div>
                    </div>
                </div>
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-content ui-widget-content" style="overflow: auto;">
                        <div id="headRequ" class="tblRequ"></div>
                        <div class="ui-widget-content ilb" style="min-width: 965px;">
                            <div class="ui-panel-title">GENERALES</div>
                            <div id="gralRequ" class="tblRequ"></div>
                        </div>
                        <div class="ui-widget-content ilb" style="min-width: 965px;">
                            <div class="ui-panel-title">ESPECIFICOS</div>
                            <div id="espeRequ" class="tblRequ"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="botones">
                <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
            </div>
            
        </div>
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>