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
        <script type="text/javascript" src='<c:url value="/javascript/app/general/etapaTramite/mantFrmTramite.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantTramite" class="tac">
            <div id="divMensajeValidatramite" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <input id="txtIdEtapaTramite" name="idEtapaTramite" type="hidden" value="${idEtapa}"/>
            <input id="txtProcesoEtapa" name="descProceso" type="hidden"/>
            <fieldset>
                <div class="form">
                    <div class="filaForm">
                        <div class="lble"><label for="txtEtapaTr">ETAPA(*):</label></div>
                        <div>
                            <input id="txtEtapaTr" value="${txtEtapa}" name="etapa" type="text" validate="[O]" maxlength="38" class="inputPeque txtMayus" disabled="true"/>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lble"><label for="txtDescripcionTr">DESCRIPCION(*):</label></div>
                        <div>
                            <input id="txtDescripcionTr" name="esEditable" type="text" validate="[O]" maxlength="200" class="inputPeque txtMayus" />
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <input id="btnAgregarTramite" class="btn_a btn_small" type="button" value="Guardar" title="Guardar Tramite">
            <input id="btnEditarTramite" class="btn_a btn_small" type="button" value="Editar Tramite" title="Editar Tramite" style="display:none;">
            <input class="btnCloseDialog btn_a btn_small" type="button" value="Cerrar" title="Cerrar">
        </div>
        <div class="tac">
            <div class="gridMargin ilb">
                <div id="gridContenedorTramite"></div>
                <div id="divContextMenuTramite"></div>
            </div>
        </div>
    </body>
</html>