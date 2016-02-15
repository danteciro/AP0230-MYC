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
        <script type="text/javascript" src='<c:url value="/javascript/app/general/obligacionTipo/mantFrmObligacionTipo.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantObligacionTipo" class="tac">  
            <div id="divMensajeValidaObligacionTipo" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <input id="txtIdObligacionTipo" name="idObligacionTipo" type="hidden" value=""/>
            <input id="txtTipo" type="hidden" value="${tipo}" />
            <fieldset>
                <div class="form">
                    <div class="filaForm">
                        <div class="lblc vat"><label for="txtNombreNomb">NOMBRE(*):</label></div>  
                        <div>
                            <input id="txtNombreObTipo" name="nombre" type="text" maxlength="80" validate="[O]" />
                        </div>
                    </div>                             
                </div>
            </fieldset>
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>           
        <div id="botones">
            <input id="btnbuscarObliTipo" class="btn_a btn_small" type="button" value="Buscar" title="Buscar Obligacion Tipo">
            <seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarObliTipo" title="Guardar Tipo Obligacion" onclick=""/>
            <input id="btnLimpiarObliTipo" class="btn_a btn_small" type="button" value="Limpiar" title="Limpiar Obligacion Tipo" style="display:none;">
            <input id="btnEditarObliTipo" class="btn_a btn_small" type="button" value="Editar" title="Buscar Obligacion Tipo" style="display:none;">
            <input class="btnCloseDialog btn_a btn_small" type="button" value="Cerrar" title="Cerrar">
        </div>
        <form id="frmMantObligacionTipoGrilla" class="tac">
            <div class="gridMargin ilb">
                <div id="gridContenedorObligacionTipoNuevaOT"></div>
                <div id="divContextMenuObligacionTipoNuevaOT"></div>
            </div>
        </form>
    </body>
</html>