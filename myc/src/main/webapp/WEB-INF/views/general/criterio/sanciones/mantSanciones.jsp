<%-- 
    Document   : sanciones_especificas
    Created on : 15/09/2015, 11:42:11 AM
    Author     : l_garcia
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src='<c:url value="/javascript/app/general/criterio/sanciones/mantSanciones.js" />' charset="utf-8"></script>
</head>
<body>
    <input type="hidden" id="txtTipoSanc" value="${tipo}">
    <input type="hidden" id="txtSancMoneSanc" value="${reg.sancionMonetaria}">
    <input type="hidden" id="txtConcatIdTipoSancion" value="${reg.concatIdTipoSancion}">
    <form id="frmMantSanc">
        <div id="divMensajeValidaFrmMantSanc" class="errorMensaje" tabindex='1' style="display: none" ></div>
        <input type="hidden" id="idCriterioSanc" name="idCriterio" value="${reg.idCriterio}">
        <input type="hidden" name="idDetalleCriterio" value="${reg.idDetalleCriterio}">
        <div class="filaForm">
            <div class="slcta vat">
                <label for="txtDescSancEspeSanc">Descripción Sanción Específica(*):</label>
            </div>
            <div>
                <textarea name="sancionEspecifica" validate="[O]" class="inputGrande" maxlength="2000">${reg.sancionEspecifica}</textarea>
            </div>
        </div>	

        <div class="filaForm">
            <div class="slcta">
                <label for="cmbTipoSancEspeSanc">Tipo de Sanción Específica(*):</label>
            </div>
            <div>
                <select id="cmbTipoSancEspeSanc" name="tipoSancionEspecifica" validate="[O]">
                    <option value="">--Seleccione--</option>
                    <c:forEach items="${listaTipoCriterio}" var="t">
                        <option value='${t.idMaestroColumna}' <c:if test="${reg.tipoSancionEspecifica==t.idMaestroColumna}">selected</c:if> >${t.descripcion}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div id="divMontoCriterioSanc" class="filaForm" style="display:none;">
            <div class="slcta">
                <label for="txtMontoCriterioSanc">Monto(*):</label>
            </div>
            <div>
                <input type="text" id="txtMontoCriterioSanc" name="sancionMonetaria" style="width:95px;" />
            </div>
            <div style="width:20px;"><label>UIT</label></div>
        </div>			    
        
        <fieldset id="divTipificacionSanc" style="display:none;width: 662px;">
            <legend>Procesos Sancionatorios</legend>
            <div class="filaForm"></div>
        </fieldset>	
    </form>
    <div id="botones">
        <c:if test="${tipo=='nuevo'}">
        <button id="btnGuardarDetalleCriterioSanc" type="button" class="btnSimple">Guardar</button>
        </c:if>
        <c:if test="${tipo=='edit'}">
        <button id="btnEditarDetalleCriterioSanc" type="button" class="btnSimple">Editar</button>
        </c:if>
        <button id="btnCerrar" title="Cerrar" class="btnCloseDialog">Cerrar</button>
    </div>		
</body>
</html>
