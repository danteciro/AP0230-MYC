<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/criterio/mantFrmCriterio.js" />' charset="utf-8"></script>
    </head>
    <body>
        <div class="form" id="divFormCriterio" style="width:880px;" >
        <input type="hidden" id="txtConcatIdTipoSancionCriterio" value="${listaTipiSancion}">
        <input type="hidden" id="txtTipoCriterio" value="${tipo}">
        <form id="formCriterio">
            <div id="divMensajeValidaFrmCriterio" class="errorMensaje" style="display: none"></div>
            <input id="idCriterio" type="hidden" value="${criterio.idCriterio}" />
            <div class="pui-subpanel ui-widget-content">
            <div class="pui-subpanel-subtitlebar">
                    <span class="ui-panel-title">Criterio</span>
            </div>
            <div class="pui-subpanel-content tac">
                <div class="form">
                    <div class="filaForm">
                        <div class="lblc vat"><label for="txtDescripcionCriterio">Criterio:</label></div>
                        <div>
                            <textarea id="txtDescripcionCriterio" value="${criterio.descripcion}" name="descripcion" class="lbld" maxlength="200" rows="2" validate="[O]">${criterio.descripcion}</textarea>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lblc"><label>Tipo Criterio:</label></div>
                        <div>
                            <select id="cmbTipoCriterio" name="tipoCriterio.idMaestroColumna" validate="[O]" class="" <c:if test="${tipo=='consultar'}">disabled</c:if>>
                                <option value="">--Seleccione--</option>
                                <c:forEach items="${listaTipoCriterio}" var="t">
                                <option value='${t.idMaestroColumna}' <c:if test="${criterio.tipoCriterio.idMaestroColumna==t.idMaestroColumna}">selected</c:if> >${t.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div id="divMontoCriterio" class="filaForm" style="display:none;">
                        <div class="lblc"><label for="txtMontoCriterio">Monto:</label></div>
                        <div>
                            <input id="txtMontoCriterio" name="sancionMonetaria" style="width:95px;" value="${criterio.sancionMonetaria}" validate="[SN]"  maxlength="10" />
                        </div>
                        <div style="width:20px;"><label>UIT</label></div>
                    </div>			    
                    <div class="filaForm" id="divTipificacionCriterio" >
                        <div class="lblc"><label for="txtTipifOblNor">Tipificación:</label></div>
                        <div >
                            <input type="text" id="txtIdTipificacion" name="tipiSancion.tipificacion.idTipificacion" style="display: none;" value="${criterio.idTipificacion}" validate="[O]" />
                            <input type="text" id="txtTipifOblNor" name="tipificacionObligacion" style="width:100px;" maxlength="20" value="${criterio.codigoTipificacion}" validate="[O]"  maxlength="10" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="pui-subpanel-content tac">
                <div class="form">
                    <div id="divProcesosCriterio" style="display:none;width: 733px;">
                        <div class="filaForm" style="margin-top: 5px;"></div>
                        <div id="dvTituloEtapa" class="filaForm">
                            <div class=""><label>Procesos Sancionatorios:</label></div>
                        </div>
                        <div class="filaForm" style="margin-top: 5px;"></div>
                        <div id="dvEtapa" class="filaForm">
                            <div id="divEtapa"></div>
                        </div>
                    </div>
                </div>
            </div>
             
            <div class="filaForm titCustomizeCriterio">Listado de Sanciones Especificas Asociadas:</div>
            <div id="botonesDerecha">
                <input id="btnNuevaSancionEspecifica" type="button" class="btn_a btn_small" value="Nuevo"></input>
            </div>
            <div class="gridMargin tac">
                <div id="gridSancionEspecificaCriterio" class="ilb"></div>
                <div id="divContextMenuSancionEspecificaCriterio"></div>

            </div>
                        
        </div>
        </form>
        <div id="botones">
            <c:if test="${tipo=='nuevo'}">
            <button id="btnGuardarCriterio">Guardar</button>
            <button style="display:none;" id="btnEditarCriterio">Editar</button>
            </c:if>
            <c:if test="${tipo=='editar'}">
            <button id="btnEditarCriterio">Editar</button>
            </c:if>
            <button id="btnCerrarCriterio">Cerrar</button>
        </div>
    </div>
    
    </body>
</html>