<%-- 
    Document   : inicio
    Created on : 14/07/2014, 11:52:49 AM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Tramite Actividad" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/rubroOpcion/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content" id="buscarProcedimiento">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title">BUSQUEDA RELACI&Oacute;N RUBRO - OPCI&Oacute;N</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="buscarProc" class="tac">
                                <div class="form">
                                    <div class="filaForm" >
                                        <div class="lble"><label for="cmbProcesoBusq">RUBRO:</label></div>
                                        <div class="lblxa">
                                            <select id="cmbTramiteActividad" name="idActividad" class="lblxa">
                                              <option value="">--Seleccione--</option>
                                              <option id="optRubroMan"  value="-1" style="display:none;"></option>
                                            </select>
                                        </div>
                                        <input id="btnAgregarActividadMan" type="button" value="SELECCIONAR RUBROS" class="button_2">
                                        
                                    </div>
                                </div>
                            </form>
                            <div id="botones">
                                <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarRubroOpcion" title="Buscar Tramite - Rubro" onclick=""/>
<!--                                <button id="btnBuscarProc" title="Buscar Procedimiento">Buscar</button>-->
                                <button id="btnLimpiarForm" title="Limpiar Opciones" >Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="popupArbolActiMan" class="filaFormMarg" style="display:none;" title="SELECCIONAR RUBROS">
                            <div id="arbolActividadesMan" style="height: 160px;">
                            </div>
                            <div id="botones" style="margin-top:20px;">
                                <button title="Cerrar" onclick="$('#popupArbolActiMan').dialog('close');return false;">Cerrar</button>
                            </div>
                        </div>
                        <div id="botonesDerecha">
                        <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoRubroOpcion" title="Nuevo Tramite - Rubro" onclick=""/>
<!--                             <button title="Nuevo Procedimiento"id="btnNuevoProc">Nuevo</button> -->
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorRubroOpcion"></div>
                            <div id="divContextMenuTramiteActividad"></div>
                        </div>
                        <div id="divTagEnlaces" style="display:none;">
							<div id="divEnlaceTagConsultar">
								<span class="pui-menuitem-icon ui-icon ui-icon-search"></span>
								<seg:enlaceTag id='linkVerTramiteActividad' code='CO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Consultar</span>
							</div>
							<div id="divEnlaceTagEditar">
								<span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
								<seg:enlaceTag id='linkEditarTramiteActividad' code='MO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Editar</span>
							</div>
							<div id="divEnlaceTagEliminar">
								<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
								<seg:enlaceTag id='linkEliminarTramiteActividad' code='EL' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Eliminar</span>
							</div>
						</div>
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
        <div id="dialogMantTipoRubroOpcion" style="display:none;"></div>
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>