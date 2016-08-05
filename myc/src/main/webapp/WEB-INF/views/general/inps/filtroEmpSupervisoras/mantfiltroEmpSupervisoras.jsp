<%-- 
    Document   : mantfiltroEmpSupervisora
    Created on : 28/01/2015, 06:58:45 PM
    Author     : mdiosesf
--%>
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Filtro de Empresas Supervisoras" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/inps/filtroEmpSupervisoras/mantfiltroEmpSupervisoras.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">    	
        <div id="form_registro">
            <input id="maxNivelDivision" type="hidden" value="${maxNivelDivision}" /> 
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> FILTROS DE EMPRESAS SUPERVISORAS</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <div class="tac">
                                <form id="frmUnidadOrganicaMant">
                                    <div id="divMensajeValidaParametro" class="errorMensaje" tabindex='1' style="display: none" ></div>
                                    <div class="form">
                                        <div class="filaForm">
                                            <div class="lble"><label for="txtNombBusq">GERENCIA(*):</label></div>
                                            <select id="slctGerencia" name="estado" validate="[O]">
                                                <option value=''>--Seleccione--</option>
                                                <c:forEach items="${listaUnidadOrganicaGerencia}" var="t">
                                                    <option value='${t.idUnidadOrganica}'>${t.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="filaForm">
                                            <div class="lble"><label for="txtNombBusq">DIVISION(*):</label></div>
                                            <select id="slctDivision" name="estado" validate="[O]">
                                                <option value=''>--Seleccione--</option>
                                            </select>
                                        </div>
                                        <div>
                                            <div class="lble ilb vat"><label for="txtNombBusq">FILTROS:</label></div>
                                            <div id='chkFiltros' class="ilb"></div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div id="botones" style="margin-bottom:10px;"> 
                                <seg:botonTag code="MO" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarfiltroEmpSupervisada" title="Guardar" onclick=""/>
                            </div>
                        </fieldset>                       
                    </div>
                </div>
            </div>
        </div>       
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>