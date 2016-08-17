<%-- 
* Resumen           
* Objeto            : mantenimientoActividad.jsp
* Descripción       : Diseño del mantenimiento de actividades MYC.
* Fecha de Creación : 24/06/2015.
* PR de Creación    : OSINE_SFS-600
* Autor             : Hernán Torres Sáenz.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
--%>
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Actividad" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/actividad/mantenimientoActividad.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> MANTENIMIENTO ACTIVIDAD Y AGENTE</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="formBusquedaAgenteInstalacion">
                                <div class="tac">
                                    <div class="form">
                                        <div class="filaForm">
                                        <div class="lble"><label for="cmbActividadBusq">ACTIVIDAD:</label></div>
                                        	<div>
	                                            <select id="cmbActividadBusq" class="ipt-medium-small" style="width: 350px;">
	                                                <option value="">--Seleccione--</option>
	                                                <c:forEach items="${listadoActividades}" var="la">
	                                                	<option value='${la.idActividad}' >${la.nombre}</option>
	                                                </c:forEach>
	                                            </select>
	                                        </div>
	                                    </div>
	                                    <div class="filaForm">
		                                    <div class="lble"><label for="txtAgenteInstalacion">AGENTE Y/O INSTALACIÓN:</label></div>
		                                    <div>
		                                        <input id="txtAgenteInstalacion" class="ipt-medium-small" name="orden" type="text" maxlength="100" style="text-transform:uppercase;width: 325px;"/>
		                                    </div>
	                                	</div>
                                	</div>
                                </div>
                            </form>
                            <div id="botones">
                            <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarAgenteInstalacion" title="Buscar Actividad" onclick=""/>
                            <button id="btnLimpiarFormAgenteInstalacion" title="Limpiar Opciones">Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                        <seg:botonTag code="CO" value="Editar" styleClass="btn_a btn_small" id="btnEditarAgenteInstalacion" title="Editar Agente y/o Instalación" onclick=""/>
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorAgenteInstalacion"></div>
                            <div id="divContextMenuAgenteInstalacion"></div>
                        </div>
                        <!-- 
                        <div id="divTagEnlaces" style="display:none;">
					       	<div id="divEnlaceTagEditarActividad">
					            <span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
					            <seg:enlaceTag id="linkEditarActividad" code="MO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
					            <span>Editar</span>
					       	</div>
					       	<div id="divEnlaceTagEliminarActividad">
								<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
					            <seg:enlaceTag id="linkEliminarActividad" code="EL" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
					            <span>Eliminar</span>
							</div>
							<div id="divEnlaceTagVerActividad">
								<span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
								<seg:enlaceTag id='linkVerActividad' code='CO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Consultar</span>
							</div>
						</div>
						 -->
                    </div>
                </div>
            </div>
        </div>
        
        <!-- dialogs -->
        <div id="dialogMantActividadAgente" class="dialog"  title="Mantenimiento Actividad y Agente" style="display:none;"></div>
        <div id="dialogMantActividades" class="dialog"  title="Mantenimiento Actividad" style="display:none;"></div>
        <div id="dialogMantBusqAgentes" class="dialog"  title="Mantenimiento de Agentes" style="display:none;"></div>
        <div id="dialogMantAgentes" class="dialog"  title="Mantenimiento de Agentes" style="display:none;"></div>
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>