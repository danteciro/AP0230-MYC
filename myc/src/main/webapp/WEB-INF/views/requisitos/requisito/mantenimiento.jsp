<%-- 
    Document   : inicio
    Created on : 23/07/2014, 05:30:07 PM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Requisitos" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/requisitos/requisito/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                      <input id="txtNombreArchivo" name="txtNombreArchivo" type="hidden" />
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA DE REQUISITOS</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="formBusqueda">
                                <div class="tac">
                                    <div class="form">
                                        <div class="filaForm">
                                            <div class="lble"><label for="txtDescripRequ">DESCRIPCIÓN:</label></div>
                                            <div>
                                                <input id="txtDescripRequ" name="descripcion" type="text" maxlength="100" class="inputGrande" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <div id="botones">
                             <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarRequ" title="Buscar Requisito" onclick=""/>
<!--                                 <button id="btnBuscarRequ" title="Buscar Requisito" class="btnSimple">Buscar</button> -->
                              <button id="btnLimpiarForm" title="Limpiar Opciones">Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                          <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoRequ" title="Nuevo Requisito" onclick=""/>
<!--                             <button id="btnNuevoRequ" title="Nuevo Requisito">Nuevo</button> -->
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorRequisito"></div>
                            <div id="divContextMenuRequisito"></div>
                        </div>
                        <div id="divTagEnlaces" style="display:none;">
							<div id="divEnlaceTagConsultar">
					            <span class="pui-menuitem-icon ui-icon ui-icon-search"></span>
					            <seg:enlaceTag id="linkVerRequisito" code="CO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
					            <span>Consultar</span>
					       	</div>
					       	<div id="divEnlaceTagEditar">
					            <span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
					            <seg:enlaceTag id="linkEditarRequisito" code="MO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
					            <span>Editar</span>
					       	</div>
					       	<div id="divEnlaceTagEliminar">
								<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
					            <seg:enlaceTag id="linkEliminarRequisito" code="EL" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
					            <span>Eliminar</span>
							</div>
						</div>
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
        <div id="dialogMantRequisito" class="dialog"  title="Mantenimiento Requisito" style="display:none;margin: 0px 20px;"></div>
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>
