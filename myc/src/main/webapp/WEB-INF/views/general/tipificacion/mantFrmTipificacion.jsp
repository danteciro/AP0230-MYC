<%-- 
    Document   : frmMantRequisito
    Created on : 21/08/2014, 03:42:43 PM
    Author     : jpiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            //var declarada en padre (procedimiento/mantenimiento.js), usada para armar formulario en caso de edit(editar) o view(consultar), la emplea mantFrmProcedimiento.js
            idTipiSanc="${listaTipificacionSancion}";
        </script>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/tipificacion/mantFrmTipificacion.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantTipificacion" class="tac">  
            <div id="divMensajeValidaTipificacion" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <input id="txtIdTipificacion" name="idTipificacion" type="hidden" value="${r.idTipificacion}"/>
            <input id="txtTipo" type="hidden" value="${tipo}" />
               
            <div class="form">
                <div class="filaForm">
                    <div class="lble vat"><label for="txtCodTipificacion">COD. TIPIFICACIÓN(*):</label></div>
                    <div>
                        <input name="codTipificacion" id="txtCodTipificacion" maxlength="20" type="text" validate="[O]" <c:if test="${tipo=='view'}">disabled</c:if> value="${r.codTipificacion}" />
                    </div>
                </div>
                    <div class="filaForm">
                    <div class="lble vat"><label for="txtTipoSancon">TIPO SANCIÓN(*):</label></div>
                    <div>
                        <select id="txtTipoSancon" name="claseSancion" validate="[O]" <c:if test="${tipo=='view'}">disabled</c:if>>
                            <option value="">--Seleccione--</option>
                            <c:forEach items="${listaTipoSancion}" var="t">
                                <option value='${t.idMaestroColumna}' <c:if test="${r.claseSancion==t.idMaestroColumna}">selected</c:if>>${t.descripcion}</option>
                            </c:forEach>
<!--                            <option value="">--Seleccione--</option>-->
<!--                            <option value="1">MONETARIA</option>
                            <option value="2">ADMINISTRATIVA</option>
                            <option value="3">AMBAS</option>-->
                        </select>
                    </div>
                </div>
                <div class="filaForm" id="tipoMoneda" style="display: none;">
                    <div class="lble vat"><label for="txtTipoMoneda">TIPO MONEDA(*):</label></div>
                    <div>
                        <select id="txtTipoMoneda" name="tipoMoneda" <c:if test="${tipo=='view'}">disabled</c:if>>
                            <option value="">--Seleccione--</option>
                            <option value="1" <c:if test="${r.idTipoMoneda=='1'}">selected</c:if>>SOLES</option>
                            <option value="2" <c:if test="${r.idTipoMoneda=='2'}">selected</c:if>>DOLARES</option>
                        </select>
                    </div>
                </div>
                <div class="filaForm" id="sancionMonetaria" style="display: none;">
                    <div class="lble vat"><label for="sancionMonetaria">SANCIÓN MONETARIA(*):</label></div>
                    <div>
                        <input name="sancionMonetaria" maxlength="20" id="txtSancionMonetaria" type="text" <c:if test="${tipo=='view'}">disabled</c:if> value="${r.sancionMonetaria}" validate="[MONEDA]">
                    </div>
                    <div class="lble vat"><label for="sancionMonetaria">EN U.I.T.</label></div>
                </div>
                <div class="filaForm" id="sancionAdministrativa" style="display: none;">
                    <div class="lble vat"><label for="sancionAdministrativa">SANCIÓN ADMINISTRATIVA(*):</label></div>
<!--                    <div>
                        <input name="sancionAdministrativa" id="txtCodTipi" <c:if test="${tipo=='view'}">disabled</c:if> value="${r.codTipificacion}">
                    </div>-->
                    <div>
                        <input id="txtSancAdmP1" onclick="abrirPopupBusqSancionAdministrativa()" type="text" <c:if test="${tipo=='view'}">disabled</c:if> style="cursor: pointer; width: 325px;" readonly placeholder="Click para seleccionar Sancion Administrativa" value="${listaTxtTipificacionSancion}" title="${listaTxtTipificacionSancion}"/>
                        <input id="txtIdSandAdmP1" type="hidden" value="${listaTipificacionSancion}" />
                        <input id="txtJsonSancAdmP1" type="hidden" />
                    </div>
                    <div id="dialogBusqSancAdm" class="dialog" style="display:none;"></div>
                    <div>
                        <input type="button" title="Agregar" value="Agregar" <c:if test="${tipo=='view'}">style="display: none"</c:if> class="btn_a btn_small" id="btnAbreMantTipoSancion">
                    </div>
                </div>
                <div class="filaForm">
                    <div class="lble vat"><label for="descripcion">DESCRIPCIÓN:</label></div>
                    <div>
                        <textarea name="descripcion" id="txtDescripcion" maxlength="500" style="height:50px;" class="inputGrande" <c:if test="${tipo=='view'}">disabled</c:if> >${r.descripcion}</textarea>
                        <input id="edit_descp" type="hidden" value="${r.descripcion}">
                    </div>
                </div>
                <div class="filaForm">
                    <div class="lble vat"><label for="basesLegales">BASES LEGALES:</label></div>
                    <div>
                        <textarea name="basesLegales" id="txtBasesLegales" maxlength="500" style="height:50px;" class="inputGrande" <c:if test="${tipo=='view'}">disabled</c:if> >${r.basesLegales}</textarea>
                        <input id="edit_descp" type="hidden" value="${r.basesLegales}">
                    </div>
                </div>
                <div class="filaForm">
                    <div class="lble vat"><label for="txtTipificacionPadre">TIPIFICACIÓN PADRE:</label></div>
                    <div>
                        <select id="txtTipificacionPadre" name="tipificacionPadre" <c:if test="${tipo=='view'}">disabled</c:if>>
                            <option value="">--Seleccione--</option>
                            <c:forEach items="${listaTipificacionPadre}" var="t">
                                <option value='${t.idTipificacion}' <c:if test="${r.idTipificacionPadre==t.idTipificacion}">selected</c:if>>${t.codTipificacion}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
<!--                <div class="filaForm">
                    <div>
                        <textarea name="listaTipificacionSancion" id="txtListaTipificacionSancion" maxlength="500" style="height:50px;" class="inputGrande" <c:if test="${tipo=='view'}">disabled</c:if> >${r.listaTipificacionSancion}</textarea>
                        <input id="edit_descp" type="hidden" value="${r.listaTipificacionSancion}">
                    </div>
                </div>-->
            </div>
<!--            <div id="botones">
                <input id="btnAgregarTipificacion" class="btn_a btn_small" type="button" value="Agregar" title="Agregar Etapa">
                seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnAgregarEtapa" title="Agregar Detalle Zonificación" onclick=""/
            </div>-->
            <div class="gridMargin">
                <div id="gridContenedorTipificacionAgregar"></div>
                <div id="divContextMenuTipificacionAgregar"></div>
            </div>
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <c:if test="${tipo=='new'}">
                <seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarTipi" title="Guardar Tipificación" onclick=""/>
            </c:if>
            <c:if test="${tipo=='edit'}">
                <seg:botonTag code="MO" value="Editar" styleClass="btn_a btn_small" id="btnEditarTipi" title="Editar Tipificación" onclick=""/>
            </c:if>
            <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        
        <!-- dialogs -->
        <div id="dialogMantTipoSancion" class="dialog"  title="Tipo Sancion" style="display:none;"></div>
    </body>
</html>