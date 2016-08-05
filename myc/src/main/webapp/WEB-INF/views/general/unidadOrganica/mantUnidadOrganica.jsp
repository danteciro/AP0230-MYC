<%-- 
    Document   : mantUnidadOrganica
    Created on : 21/05/2016, 01:33:45 AM
    Author     : mdiosesf
--%>
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Mantenimiento Unidad Organica" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/unidadOrganica/mantUnidadOrganica.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">    	  	
        <div id="form_registro">
            <input id="maxNivelDivision" type="hidden" value="${maxNivelDivision}" /> 
            <input id="permisosSeguridad" type="hidden" value="${xxp}" />
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> MANTENIMIENTO UNIDAD ORGANICA</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <div class="tac">
                                <div class="form" style="width: 900px;">
                                    <div id="arbolUnidadorganica"></div>                                                                                                                   
                                </div>                                
                            </div>
                        </fieldset> 
                        <ul id="myMenu" class="contextMenu ui-helper-hidden">
                            <li code="CO">
                                <a href="#" id="consultaUnidadOrganica" class="cp">
                                    <span class="pui-menuitem-icon ui-icon ui-icon-search"></span>
                                    <span class="ui-menuitem-text">Consultar Unidad Orgánica</span>
                                </a>
                            </li>
                            <li CODE="IN">
                                <a href="#" id="nuevaUnidadOrganica" class="cp">
                                    <span class="pui-menuitem-icon ui-icon ui-icon-plusthick"></span>
                                    <span class="ui-menuitem-text">Nueva Unidad Orgánica</span>
                                </a>
                            </li>
                            <li code="MO">
                                <a href="#" id="editarUnidadOrganica" class="cp">
                                    <span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
                                    <span class="ui-menuitem-text">Editar Unidad Orgánica</span>
                                </a>
                            </li>
                            <li code="EL">
                                <a href="#" id="eliminarUnidadOrganica" class="cp">
                                    <span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
                                    <span class="ui-menuitem-text">Eliminar Unidad Orgánica</span>
                                </a>
                            </li>
                        </ul>	                      
                    </div>
                    <!-- popups --> 
                    <div id="divUnidadOrganica" style="display: none;" class="dialog">	
                        <fieldset>
                            <form id="frmUnidadOrganica" class="tac">
                                <div id="divMensajeValidaUnidadOrganica" class="errorMensaje" tabindex='1' style="display: none" ></div>  
                                <div class="form">
                                    <div class="filaForm">
                                            <div class="lble"><label>NIVEL:</label></div>							
                                            <div><label id="lblNombreNivel" style="font-weight: bold; font-size: 14px;"></label></div>
                                    </div>
                                    <div id="divUOVacio" class="filaForm">
                                        <div class="lble"></div>
                                        <div>
                                            <input type="checkbox" id="uoVacio">
                                            <label class="checkbox" for="uoVacio">Registrar Nivel Vacio</label>
                                        </div>
                                        <input type="hidden" id="unidOrgaRegiVacioValor" value="${unidOrgaRegiVacioValor}" disabled />
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtDescripcion">DESCRIPCION(*):</label></div>
                                        <div>
                                            <input id="txtIdUnidadOrganica" type="hidden" /> 
                                            <input id="txtIdUnidadOrganicaPadre" type="hidden" />
                                            <input id="txtSede" type="hidden" />
                                            <input id="txtTipoUnidadOrganica" type="hidden" />  
                                            <input id="txtNivel" type="hidden" />
                                            <input id="txtNombreNivel" type="hidden" />  
                                            <input id="txtDescripcion" type="text" validate="[O]" maxlength="100" class="inputPeque txtMayus" />
                                        </div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtDetalle">DETALLE(*):</label></div>							
                                        <div><input id="txtDetalle" type="text" validate="[O]" maxlength="200" class="inputPeque txtMayus" /></div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtCodDepSiga">CODIGO SIGA(*):</label></div>
                                        <div><input id="txtCodDepSiga" type="text" validate="[O]" maxlength="4" class="inputPeque txtMayus" /></div>
                                    </div>
                                    <div class="filaForm">
                                        <div class="lble"><label for="txtSigla">SIGLA(*):</label></div>
                                        <div><input id="txtSigla" type="text" validate="[O]" maxlength="15" class="inputPeque txtMayus" /></div>
                                    </div>											
                                </div>
                            </form>  
                        </fieldset>
                        <div id="botones">
                            <input id="btnAceptarUnidadOrganica" class="btn_a btn_small" type="button" value="Guardar" title="Guardar">
                            <input id="btnEditarUnidadOrganica" class="btn_a btn_small" type="button" value="Editar" title="Guardar">
                            <input class="btnCloseDialog btn_a btn_small" type="button" value="Cerrar" title="Cerrar">
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>  
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>