<%-- 
* Resumen           
* Objeto            : mantFrmPrioridadNormaAgente.jsp
* Descripción       : Diseño del mantenimiento de prioridad norma agente en el MYC.
* Fecha de Creación : 28/06/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Erick Ortiz Gil.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/prioridadNormaAgente/mantFrmPrioridadNormaAgente.js" />' charset="utf-8"></script>
    </head>
    <body>
    	<fieldset>
	        <form id="frmMantPrioridadNormaAgente" class="tac">  
	            <div id="divMensajeValidaPrioridadNormaAgente" class="errorMensaje" tabindex='1' style="display: none" ></div>
	            <input id="txtIdPrioridadNormaAgente" name="idPrioridadNormaAgente" type="hidden" value="${r.idPrioridadNormaAgente}"/>
	            <input id="txtIdAgente" name="idAgente" type="hidden" value="${idAgente}"/>
	            <input id="txtIdActividad" name="idActividad" type="hidden" value="${idActividad}"/>
	            <input id="txtTipo" type="hidden" value="${tipo}" />
	               
	            <div class="form">
	                <div class="filaForm">
	                    <div class="lble vat"><label for="txtActividad">Actividad:</label></div>
	                    <div>
	                        <input name="actividad" id="txtActividad" style="width: 350px;" maxlength="20" type="text" disabled="disabled" value="${actividad}" />
	                    </div>
	                </div>
	                <div class="filaForm">
	                    <div class="lble vat"><label for="txtActividad">Agente y/o instalaci&oacute;n :</label></div>
	                    <div>
	                        <input name="agente" id="txtAgente" style="width: 350px;" maxlength="20" type="text" disabled="disabled" value="${agente}" />
	                    </div>
	                </div>
	                <div class="filaForm">
	                    <div class="lble vat"><label for="cmbNorma">Norma(*) :</label></div>
	                    <div>
	                        <select id="cmbNorma" name="idNormaLegal" style="width: 250px;" validate="[O]">
	                     		<option value="">--Seleccione--</option>
	                          <c:forEach items="${listadoNormas}" var="t">
	                              <option value='${t.idBaseLegal}' >${t.descripcionGeneralBaseLegal}</option>
	                          </c:forEach>
	                     	</select> 
	                    </div>
	                </div>
	                <div class="filaForm">
	                    <div class="lble vat"><label for="txtOrden">Orden(*) :</label></div>
	                    <div>
	                        <input name="orden" id="txtOrden" maxlength="6" style="width: 50px;" type="text" validate="[O]"/>
	                    </div>
	                </div>                                
	            </div>          
	        </form>
	        <div id="botones2" style="text-align: center; margin-top:8px;margin-bottom:8px;">
	            <c:if test="${tipo=='new'}">
	                <seg:botonTag code="IN" value="Agregar" styleClass="btn_a btn_small" id="btnAgregarPrioridaNorma" title="Agregar Prioridad Norma" onclick=""/>
	            </c:if>                       
	        </div>       
	        <div class="gridMargin">
	        	<div id="gridContenedorPrioridadNormaAgregar"></div>
	            <div id="divContextMenuPrioridadNormaAgregar"></div>
	        </div>
	        <div id="obligatorio">(*) Campos obligatorios</div>
	   	</fieldset>	    
        <div id="botones" style="margin-top:10px;">
            <c:if test="${tipo=='new'}">
                <seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarPrioridadesNorma" title="Guardar Tipificación" onclick=""/>
            </c:if>
            <c:if test="${tipo=='edit'}">
                <seg:botonTag code="MO" value="Editar" styleClass="btn_a btn_small" id="btnEditarPrioridadesNorma" title="Editar Tipificación" onclick=""/>
            </c:if>
            <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
    </body>
</html>