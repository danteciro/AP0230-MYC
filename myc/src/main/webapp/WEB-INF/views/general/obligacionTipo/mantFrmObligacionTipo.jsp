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
               
            <div class="form">
                <div class="filaForm">
                    <div class="lblc vat"><label for="txtNombreNomb">NOMBRE(*):</label></div>  
                    <div>
                        <input id="txtNombreObTipo" name="obligaciones[0].nombre" type="text" maxlength="80" class="inputGrande" validate="[O]" />
                    </div>
                    <div>
                        <input id="btnAgregarNuevaObligacionTipo" class="btn_a btn_small" type="button" value="Agregar" title="Agregar Obligacion Tipo">
                    </div>
                </div>              
            </div>
        </form>
        <form id="frmMantObligacionTipoGrilla" class="tac">
            <div class="gridMargin">
                        <div id="gridContenedorObligacionTipoNuevaOT"></div>
                        <div id="divContextMenuObligacionTipoNuevaOT"></div>
            </div>
            
            
        </form>
   
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <c:if test="${tipo=='new'}">
                <seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarObliTipo" title="Guardar Tipo Obligacion" onclick=""/>
            </c:if>
            <c:if test="${tipo=='edit'}">
                <seg:botonTag code="MO" value="Editar" styleClass="btn_a btn_small" id="btnEditarObliTipo" title="Editar Tipo Obligacion" onclick=""/>
            </c:if>
            <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
    </body>
</html>