<%-- 
    Document   : frmAgregarRequisito
    Created on : 22/08/2014, 09:54:30 AM
    Author     : jpiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/requisitos/requisitoProcedimiento/common/frmAgregarRequisito.js" />' charset="utf-8"></script>
    </head>
    <body>
        <input type="hidden" id="tipoRequisito" value="${tipoRequisito}" />
        <div class="filaForm" id="filaRequisitoPadre" style="display:none;">
            <input type="hidden" id="idRequisitoProcedimientoPad" value="${idRequisitoProcedimientoPadMant}" />
            <div class="lble vat"><label>REQUISITO:</label></div>
            <div class="ilb vat tal" style="width: 800px;">
                <span id="lblRequisitoPadre"></span>
            </div>
        </div>
        <div class="filaForm">
            <div class="lble"><label>DESCRIPCIÓN:</label></div>
            <div class="ilb">
                <input id="txtNombreBusq" name="nombre" type="text" maxlength="100" class="inputGrande" />
            </div>
            <div class="ilb">
                <button id="btnBuscarRequ" title="BUSCAR REQUISITO">Buscar</button>
            </div>
        </div>
        <div class="tableDiv tblAgreRequ">
            <div class="titu tal">REQUISITOS DISPONIBLES</div>
                <div id="requisitosAgregar" class="cont wsp ilb tal" style="width: 995px;height: 150px;overflow: auto;"></div>
        </div>
        
        <form id="frmMantRequProcedimiento">
            <input type="hidden" name="idProcedimiento" value="${idProcedimientoMant}" />
            <div class="tableDiv tblAgreRequ ilb">
                <div class="titu tal">REQUISITOS SELECCIONADOS</div>
                <div style="max-width: 1000px;height: 180px;overflow: auto;">
                    <div id="requisitosAgregarSeleccionados" class="cont wsp ilb"></div>
                </div>
            </div>
        </form>
        
        <div id="botones">
            <seg:botonTag code="IN" value="Agregar" id="btnAgregarRequ" title="AGREGAR" styleClass="btn_a btn_small" onclick=""/>
<!--            <button id="btnAgregarRequ" title="AGREGAR">Agregar</button>-->
            <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
    </body>
</html>