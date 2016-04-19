<%-- 
    Document   : inicio
    Created on : 14/07/2014, 11:52:49 AM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Procedimientos" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/requisitos/procedimiento/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">        	
            <div class="container">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA DE PROCEDIMIENTOS</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="buscarProc" class="tac">
                                <div class="form">
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtItemProcBusq">ITEM:</label></div>
                                        <div>
                                            <input id="txtItemProcBusq" name="item" type="text" maxlength="10" />
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble vam"><label for="txtDenominacionProcBusq">DENOMINACIÓN DE PROCEDIMIENTO:</label></div>
                                        <div class="vam">
                                            <input id="txtDenominacionProcBusq" name="denominacion" type="text" maxlength="100" style="width: 465px;" />
                                        </div>
                                    </div>
<!--                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbProcesoBusq">PROCESO(*):</label></div>
                                        <div class="slcta">
                                            <select id="cmbProcesoBusq">
                                                <option value="">--Seleccione--</option>
                                                <c:forEach items="${listadoProceso}" var="t">
                                                    <option value='${t.idProceso}' <c:if test="${t.idProceso==r.idProceso}">selected</c:if> >${t.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>-->
                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbEtapaBusq">ETAPA DEL PROCESO:</label></div>
                                        <div class="slcta">
                                            <select id="cmbEtapaBusq">
                                                <option value="">--Seleccione--</option>
                                                <c:forEach items="${listadoEtapa}" var="t">
                                                      <option value='${t.idEtapa}'>${t.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="lblc"><label for="cmbTramiteBusq">TRÁMITE:</label></div>
                                        <div class="slcta">
                                            <select id="cmbTramiteBusq">
                                                <option value="">--Seleccione--</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtActivP1">RUBRO:</label></div>
                                        <div class="lblc">
                                            <input id="txtActivP1" onclick="abrirPopupBusqActividad()" type="text" style="cursor: pointer; width: 465px;" readonly placeholder="Click para seleccionar rubro"/>
                                            <input id="txtIdActivP1" type="hidden" />
                                        </div>
                                        <div id="dialogBusqActividad" class="dialog" style="display:none;"></div>
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
                                <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarProc" title="Buscar Procedimiento" onclick=""/>
<!--                                <button id="btnBuscarProc" title="Buscar Procedimiento">Buscar</button>-->
                                <button id="btnLimpiarForm" title="Limpiar Opciones" >Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                        <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoProc" title="Nuevo Procedimiento" onclick=""/>
<!--                             <button title="Nuevo Procedimiento"id="btnNuevoProc">Nuevo</button> -->
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorProcedimiento"></div>
                            <div id="divContextMenuProcedimiento"></div>
                            <div id="divContextMenuProcedimientoSub"></div>
                        </div>
                        <!-- PR0013 - Inicio -->
                        <div id="divTagEnlaces" style="display:none;" >
							<div id="divEnlaceTagConsultar">
								<span class="pui-menuitem-icon ui-icon ui-icon-search"></span>
								<seg:enlaceTag id='linkVerProcedimiento' code='CO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Consultar</span>
							</div>
							<div id="divEnlaceTagEditar">
								<span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
								<seg:enlaceTag id='linkEditarProcedimiento' code='MO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Editar</span>
							</div>
							<div id="divEnlaceTagEliminar">
								<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
								<seg:enlaceTag id='linkEliminarProcedimiento' code='EL' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Eliminar</span>
							</div>
							<div id="divEnlaceTagGestionar">
								<span class="pui-menuitem-icon ui-icon ui-icon-clipboard"></span>
								<seg:enlaceTag id='linkGestionarRequisitosProcedimiento' code='CO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Gestionar Requisitos</span>
							</div>
						</div>
                        <!-- PR0013 - Fin -->
                        
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
        <div id="dialogMantProcedimiento" style="display:none;"></div>
        
        <!-- formulario -->
        <form id="postGestionarRequisitos" method="post" action="requisitoProcedimiento/nuevo">
            <input type="hidden" id="idProcedimientoP" name="idProcedimiento">
            <input type="hidden" id="itemP" name="item">
            <input type="hidden" id="procedimientoP" name="procedimiento">
            <input type="hidden" id="procesoP" name="proceso">
        </form>
        
        <!-- dialogs -->
        <!--div id="dialogAgregarActividad" class="dialog"  title="Editar Actividades" style="display:none;">
            <form id="frmAgregarActividadProcedimiento" class="tac">
                <fieldset>
                    <legend>Procedimiento</legend>
                    <div class="form">
                        <div class="filaForm">
                            <div class="lblc"><label>ITEM:</label></div>
                            <div>
                                <label id="itemProcAgreActi"></label>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lblc vat"><label>DESCRIPCION:</label></div>
                            <div class="lbld">
                                <label id="descripProcAgreActi"></label>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <div class="form" style="min-width: 760px;">
                    <div class="filaForm">
                        <div class="ilb vam">
                            <input type="checkbox" id="chkTodoTramite" checked>
                            <label class="checkbox" for="chkTodoTramite"></label>
                        </div>
                        <div class="ilb vam"><label for="chkTodoTramite">Todos los tramites</label></div>
                    </div>
                    <div class="filaForm" id="filaTramite">
                        <div class="lblc vam"><label for="cmbTramiteProcAgreActi">TRAMITE(*):</label></div>
                        <div class="slcta vam">
                            <select id="cmbTramiteProcAgreActi" validate="[O]" name="tramite">
                                <option value="">--Seleccione--</option>
                                <option value="INSTALACION">INSTALACION</option>
                                <option value="MODIFICACION">MODIFICACION</option>
                            </select>
                        </div>
                        <div class="lbla tar vam">
                            <div class="ilb vam">
                                <input type="checkbox" id="chkDuplicarActiTramite">
                                <label class="checkbox" for="chkDuplicarActiTramite"></label>
                            </div>
                            <div class="ilb vam">DUPLICAR DE TRAMITE:</div>
                        </div>
                        <div class="slcta vam">
                            <select id="cmbDuplicarActiTramite">
                                <option value="">--Seleccione--</option>
                                <option value="INSTALACION">INSTALACION</option>
                                <option value="MODIFICACION">MODIFICACION</option>
                            </select>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lbla vam"><label>SELECCIONE ACTIVIDADES:</label></div>
                    </div>
                    <div class="filaFormMarg">
                        <div id="arbolActividadesAgregar" style="height: 160px;">
                            <ul style="display: none;">
                                <li id='0' class='folder'>ACTIVIDADES
                                    <ul style="display:none;">
                                        
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
                                                <li id='16'>Terminales Combustibles Líquidos</li>
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
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </form>
            
            <div class="tableDiv">
                <div class="titu">ACTIVIDADES AGREGADAS</div>
                <div id="idActividadesAgregarSelect" class="cont" style="overflow:auto;height: 150px;"></div>
            </div>
            
            <div id="botones">
                <button id="btnAgregarActividadProc" type="button" title="Agregar Actividades" class="btnSimple">Guardar</button>
                <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
            </div>
        </div-->
        
        <!-- dialogs -->
        <!--div id="dialogConsultarActividad" class="dialog"  title="Consultar Tramite Actividad" style="display:none;">
            
            <fieldset>
                <legend>Procedimiento</legend>
                <div class="form">
                    <div class="filaForm">
                        <div class="lblc"><label>ITEM:</label></div>
                        <div>
                            <label id="itemProcConsActi"></label>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lblc vat"><label>DESCRIPCION:</label></div>
                        <div class="lbld">
                            <label id="descripProcConsActi"></label>
                        </div>
                    </div>
                </div>
            </fieldset>
            
            <div class="gridMargin">
                <div id="gridContenedorActividadProcedimiento"></div>
            </div>
                
            <div id="botones">
                <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
            </div>
        </div-->
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>