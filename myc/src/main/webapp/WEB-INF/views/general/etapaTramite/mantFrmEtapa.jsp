<%-- 
    Document   : etapa
    Created on : 20/01/2015, 12:27:21 PM
    Author     : dmedrano
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/etapaTramite/mantFrmEtapa.js" />' charset="utf-8"></script>
    </head>
    <body>
       
        <form id="frmMantEtapa" class="tac">
            <div id="divMensajeValidaEtapa" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <input id="txtIdEtapa" name="idEtapa" type="hidden"/>
            <input id="txtIdProceso" name="idProceso" type="hidden"/>
            <div>
                <fieldset>
                    <div class="form">
                        <div class="filaForm">
                            <div class="lble"><label for="cmbProceso">PROCESO(*):</label></div>
                            <div>
                                <select id="cmbProceso" name="proceso" validate="[O]">
                                     <c:forEach items="${listadoProceso}" var="t">
                                        <option value='${t.idProceso}' <c:if test="${t.idProceso==idProceso}">selected</c:if> >${t.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lble"><label for="txtDescripcion">DESCRIPCION ETAPA(*):</label></div>
                            <div>
                                <input id="txtDescripcion" name="descripcion" type="text" validate="[O]" maxlength="200" class="inputPeque txtMayus" />
                            </div>
                        </div>
                    </div>
                </fieldset>
            </div>
        </form>
        <div style="text-align:left;" id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <input id="btnBuscarEtapa" class="btn_a btn_small" type="button" value="Buscar" title="Buscar Etapa">
            <input id="btnRegistrarEtapa" class="btn_a btn_small" type="button" value="Guardar" title="Guardar Etapa">
            <input id="btnCancelarUtil" class="btn_a btn_small" type="button" value="Limpiar" title="Limpiar" style="display:none;">
            <input id="btnEditarEtapaUtil" class="btn_a btn_small" type="button" value="Editar" title="Editar Etapa" style="display:none;">
            <input class="btnCloseDialog btn_a btn_small" type="button" value="Cerrar" title="Cerrar">
        </div>
        <div class="gridMargin form">
            <div id="divContextMenuEtapa"></div>
            <div id="gridContenedorEtapa"></div>
        </div>
    </body>
</html>