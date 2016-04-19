<%-- 
    Document   : maestro tabla
    Created on : 13/02/2015, 15:27:21 PM
    Author     : gvillanueva
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/maestroTabla/mantFrmMaestroTabla.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantMaestroTabla" class="tac">
            <div id="divMensajeValidaMaestroTabla" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <fieldset>
                <div class="form">
                    <div class="filaForm" style="display:none;">
                        <div class="lble"><label for="txtAplicacionMaesTabMant">APLICACION(*):</label></div>
                        <div>
                            <input id="txtAplicacionMaesTabMant" name="aplicacion" type="text" validate="[O]" maxlength="200" value="USU"/>
                        </div>
                    </div>
                    <div class="filaForm" style="display:none;">
                        <div class="lble"><label for="txtEsEditableMaesTabMant">ES EDITABLE(*):</label></div>
                        <div>
                            <select id="txtEsEditableMaesTabMant" name="esEditable" validate="[O]">
                                <option value="SI" selected >SI</option>
                                <option value="NO">NO</option>
                            </select>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lble"><label for="txtDominioMaesTabMant">GRUPO DE NEGOCIO(*):</label></div>
                        <div>
                            <input id="txtDominioMaesTabMant" name="dominio" type="text" validate="[O]" maxlength="20"/>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lble vat"><label for="txtDescripMaesTabMant">DESCRIPCIÓN(*):</label></div>
                        <div>
                            <textarea id="txtDescripMaesTabMant" name="descripcion" style="height:25px" maxlength="200" validate="[O]" ></textarea>
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>
        <div style="text-align:left;" id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
        <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarMaesTabMant" title="Buscar" onclick=""/>
<!--             <input id="btnBuscarMaesTabMant" class="btn_a btn_small" type="button" value="Buscar" title="Buscar"> -->
		<seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarMaesTabMant" title="Guardar" onclick=""/>
<!--             <input id="btnGuardarMaesTabMant" class="btn_a btn_small" type="button" value="Guardar" title="Guardar"> -->
            <input id="btnCancelarMaesTabMant" class="btn_a btn_small" type="button" value="Limpiar" title="limpiar" style="display:none;">
            <seg:botonTag code="MO" value="Editar" styleClass="btn_a btn_small a-ipt-a" id="btnEditarMaesTabMant" title="Editar" onclick=""/>
<!--             <input id="btnEditarMaesTabMant" class="btn_a btn_small" type="button" value="Editar" title="Editar" style="display:none;"> -->
            <input class="btnCloseDialog btn_a btn_small" type="button" value="Cerrar" title="Cerrar">
        </div>
        <div class="tac">
            <div class="gridMargin ilb">
                <div id="gridContenedorMaesTabMant"></div>
                <div id="divContextMenuMaesTabMant"></div>
            </div>
        </div>
    </body>
</html>