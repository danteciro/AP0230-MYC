<%-- 
    Document   : inicio
    Created on : 23/07/2014, 05:30:07 PM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Tipificación" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/tipificacion/mantenimiento.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA DE TIPIFICACIÓN</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <form id="formBusqueda">
                                <div class="tac">
                                    <div class="form">
                                        <div class="filaForm">
                                            <div class="lble"><label for="txtCodTipi">COD. TIPIFICACIÓN:</label></div>
                                            <div>
                                                <input id="txtCodTipi" name="descripcion" type="text" maxlength="100" />
                                            </div>
                                        </div>
                                        <div class="filaForm">
                                            <div class="lble"><label for="txtDescTipi">DESCRIPCIÓN:</label></div>
                                            <div>
                                                <input id="txtDescTipi" name="descripcion" type="text" maxlength="100" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <div id="botones">
                             <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarTipi" title="Buscar Tipificación" onclick=""/>
                              <button id="btnLimpiarForm" title="Limpiar Opciones">Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
                          <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoTipi" title="Nuevo Tipificación" onclick=""/>
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorTipificacion"></div>
                            <div id="divContextMenuTipificacion"></div>
                            <div id="divContextMenuTipificacionSub"></div>
                        </div>
		                <!-- PR0013 - Inicio -->                           
		                <div id="divTagEnlaces" style="display:none;">
							<div id="divEnlaceTagVerTipificacion">
								<span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
								<seg:enlaceTag id='linkVerTipificacion' code='CO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Consultar</span>
							</div>
							<div id="divEnlaceTagEditarTipificacion">
								<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
								<seg:enlaceTag id='linkEditarTipificacion' code='MO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Editar</span>
							</div>
							<div id="divEnlaceTagEliminarTipificacion">
								<span class="pui-menuitem-icon ui-icon ui-icon-folder-collapsed"></span>
								<seg:enlaceTag id='linkEliminarTipificacion' code='EL' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Eliminar</span>
							</div>
						</div>
						<!-- PR0013 - Fin -->
                    </div>
                </div>
            </div>
        </div>
            
        <!-- dialogs -->
        <div id="dialogMantTipificacion" class="dialog"  title="Mantenimiento Tipificación" style="display:none;margin: 0px 20px;"></div>
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>
