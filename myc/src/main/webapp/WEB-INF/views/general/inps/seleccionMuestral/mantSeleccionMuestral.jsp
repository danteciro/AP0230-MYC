<%-- 
    Document   : mantenimientoSeleccionMuestral
    Created on : 17/05/2016, 17:17:16 PM
    Author     : gvillanueva

	Resumen.
	Objeto                :              mantSeleccionMuestral.jsp
	Descripción           :              Pantalla de mantenimiento de la seleccion muestral.
	Fecha de Creación     :              17/05/2016
	Autor                 :              gvillanueva.
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	Modificaciones
	Motivo                                    Fecha                                   Nombre                              Descripción
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  OSINE_SFS-480                          17/05/2016                        Giancarlo Villanueva             PANTALLA: SELECCION MUESTRAL - RSIS24
--%>
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Metodología de Selección para Supervisión Muestral" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/inps/seleccionMuestral/mantSeleccionMuestral.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">    	
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> METODOLOGIA DE SELECCION PARA SUPERVISION MUESTRAL</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                    	<div id="divMensajeValidacionSeleccionMuestral" class="errorMensaje" tabindex='1' style="display: none" ></div>
                        <fieldset>
                            <div class="tac">
                                <div class="form">
                                <form id="frmSeleccionMuestral">
	                                <div class="filaForm">
	                                    <div class="lble" ><label for="cmbTipoSupervision">Tipo de Supervisión:</label></div>
	                                    <div>
	                                        <select id="cmbTipoSupervision" name="idtipoSupervision" validate="[O]">
	                                            <option value="">--Seleccione--</option>
							                    <c:forEach items="${listadoTipoSupervision}" var="lts">
							                        <option value='${lts.idObligacionTipo}'>${lts.nombre}</option>
							                    </c:forEach>
	                                        </select>
	                                    </div>
	                                </div>
	                                <div class="filaForm">
	                                    <div class="lble" ><label for="cmbSubTipoSupervision">Sub Tipo de Supervisión:</label></div>
	                                    <div>
	                                        <select id="cmbSubTipoSupervision" name="idSubTipoSupervision" validate="[O]">
	                                            <option value="">--Seleccione--</option>
	                                        </select>
	                                    </div>
	                                </div>
                                	<div class="filaForm">
	                                    <div class="lble" ><label for="txtProbGrifoES">Probabilidad de encontrar un Grifo o Estación de Servicio en falta:</label></div>
	                                    <div>
	                                    	<input type="hidden" class="lble" id="txtProbGrifoESHidden"  name="probEncontrarGES" >
	                                        <input type="text" class="lble" id="txtProbGrifoES" maxlength="3"  validate="[O][SN]" >
	                                    </div>
	                                </div>  
	                                <div class="filaForm">
	                                    <div class="lble" ><label for="txtPorcSupContingencia">Porcentaje para supervisiones de contingencia:</label></div>
	                                    <div>
	                                    	<input type="hidden" class="lble" id="txtPorcSupContingenciaHidden"  name="porcSupContingencia" >
	                                        <input type="text" class="lble" id="txtPorcSupContingencia" maxlength="3" validate="[O][SN]">
	                                    </div>
	                                </div>  
	                            </form>                                                                                                      
                                </div>
                            </div>
                            <div id="botones" style="margin-bottom:10px;"> 
                            	<seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarSeleccionMuestral" title="Guardar" onclick=""/>
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