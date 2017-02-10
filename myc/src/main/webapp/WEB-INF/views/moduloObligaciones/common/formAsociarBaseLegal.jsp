<%-- 
    Document   : formAsociarBaseLEgal
    Created on : 10/01/2015, 09:35:14 AM
    Author     : jpiro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/moduloObligaciones/common/formAsociarBaseLegal.js" />' charset="utf-8"></script>
    </head>
    
    <body>
        <form id="formBuscarAsigBaseLegal" class="tac">    
            <div id="divMensajeValidaAsigBaseLegal" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <div class="form"> 
                <div class="filaForm">
                    <div class="lblc" style="width:140px;"><label for="txtCodBaseLegaAsigBL">Código Base Legal:</label></div>
                    <div style="width: 200px;">
                        <input id="txtCodBaseLegaAsigBL" name="codigoBaseLegal" type="text">
                        <input type="hidden" id="idsBaseLegal" value="${idsBaseLegal}" />
                    </div>
                    <div class="lblc" style="width:120px;" ><label for="txtFechaEntrVigeAsigBL" >Fecha Entrada Vigencia: </label></div>
                    <div style="width:200px;">
                        <input id="txtFechaEntrVigeAsigBL" type="text" name="fechaEntradaVigenciaNormaLegal">
                    </div>
                </div>
                <div class="filaForm">
                    <div class="lblc" style="width:140px;text-align: right;"><label for="slcTipoNormaLegaAsigBL">Tipo Norma Legal:</label></div>
                    <div style="width: 200px;">
                        <select id="slcTipoNormaLegaAsigBL" name="tipoNormaLegal" class="lbld" >
                            <option value="">--Seleccione--</option>
                            <c:forEach items="${listTipoNormaLegal}" var="t">
                                  <option value='${t.idMaestroColumna}'>${t.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                </div>
                <div class="filaForm">
                <div class="lblc" style="width:140px;" ><label for="txtNumeroAsigBL" >Número:</label></div>
                    <div style="width:120px;">
                        <input id="txtNumeroAsigBL" type="text" name="numeroNormaLegal" validate="[SN]" maxlength="3" style="width:70px;" >
                    </div>
                    <div class="lblc" style="width:200px;"><label for="txtAnoAsigBL">Año:</label></div>
                    <div style="width:120px;">
                        <input id="txtAnoAsigBL" name="anioNormaLegal" placeholder="--2000--" style="width:100px;" maxlength="4" >
                    </div>
                    <div class="lblc" style="width:130px;"><label for="slcSiglaAsigBL">Sigla:</label></div>
                    <div>
                        <select style="width:100px;" id="slcSiglaAsigBL" name="siglaNormaLegal">
                            <option value="">--Seleccione--</option>
                            <c:forEach items="${listSigla}" var="t">
                                  <option value='${t.idMaestroColumna}'>${t.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="filaForm">
                    <div class="lblc" style="width:140px;"><label for="txtArticuloAsigBL">Artículo:</label></div>
                    <div style="width:200px;">
                         <input id="txtArticuloAsigBL" type="text" name="articuloNormaLegal" maxlength="3">
                    </div>
                    <div class="filaForm">
                        <div class="lblc" style="width:120px;"><label for="slcTipoAnexoAsigBL">Tipo de Anexo:</label></div>
                        <div style="width:200px;">
                             <select id="slcTipoAnexoAsigBL" name="tipoAnexo">
                                <option value="">--Seleccione--</option>
                                <c:forEach items="${listTipoAnexo}" var="t">
                                    <option value='${t.idMaestroColumna}'>${t.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="lblc" style="width:50px;"><label for="txtArticuloAnexoAsigBL">Artículo Anexo:</label></div>
                    <div style="">
                         <input id="txtArticuloAnexoAsigBL" type="text" name="articuloAnexo" disabled maxlength="3">
                    </div>
                </div>
            </div>
        </form>
        <div id="obligatorio" class="tal">(*) Campos obligatorios</div>
        <div id="botones">
            <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarAsigBL" title="Buscar" onclick=""/>
<!--             <button id="btnBuscarAsigBL" title="Buscar" >Buscar</button> -->
            <button id="btnLimpiarAsigBL" title="Limpiar" class="btnSimple">Limpiar</button>
            <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        <!-- Grid Resultado de la Búsqueda Avanzada-->
        <div id="gridContenedorBuscarAsigBL" class="ilb"></div>
        
        <div id="botones" class="divBtnAsociar" style="display:none;text-align: center;">
            <c:if test="${variable=='1'}">  
                <seg:botonTag code="IN" value="Asociar" styleClass="btn_a btn_small" id="botoAsociarBusquedaAvanzadaBaseLegal" title="Asociar Bases Legales" onclick=""/>
<!--                 <button id="botoAsociarBusquedaAvanzadaBaseLegal" title="Asociar Bases Legales" >Asociar</button> -->
            </c:if>
            <c:if test="${variable=='0'}">  
                <button id="botoAsociarBaseLegalesObligacion" title="Asociar Bases Legales">Asociar</button>
            </c:if>
        </div>
        
    </body>
</html>
