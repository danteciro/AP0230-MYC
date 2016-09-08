<%-- 
    Document   : frmMantRequisito
    Created on : 08/08/2014, 03:42:43 PM
    Author     : jpiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            //var declarada en padre (/mantenimiento.js), usada para armar formulario en caso de edit(editar) o view(consultar), la emplea mantFrm.js
            idActividades="${idActividad}";
        </script>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/siguo/configuracion/mantFrmConfiguracionSiguo.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantModulo" class="tac">
            <div id="divMensajeValidaModulo" class="errorMensaje" tabindex='1' style="display: none;" ></div>
            <input id="tipoP" type="hidden" value="${tipo}"/>  
            <input type="hidden" name="idOrgaActiModuSecc" value="${idOrgaActiModuSecc}"/>  
    	
	                                <div class="filaForm">
	                                    <div class="lbla"><label for="txtNro">Actividad - Componente - Secci&oacute;n:</label></div>
                                        <div >
                                            <input id="txtNroModal" name="item"  value="${idOrgaActiModuSecc}" type="text" class="lblc" disabled />
                                        </div>
	                                </div>
	                                <div class="filaForm">
	                                    <div class="lbla" ><label for="cmbGerenciaModal">Gerencia:</label></div>
	                                    <div>
	                                        <select id="cmbGerenciaModal" name="idUnidadOrganicaSuperior.idUnidadOrganica" validate="[O]">
	                                            <option value="">--Seleccione--</option>
							                    <c:forEach items="${listadoGerenciaModal}" var="lts">
							                        <option value='${lts.idUnidadOrganica}' <c:if test='${configuracion.idUnidadOrganicaSuperior.idUnidadOrganica==lts.idUnidadOrganica}'>selected</c:if> >${lts.descripcion}</option>
							                    </c:forEach>
	                                        </select>
	                                    </div>
	                                </div>
	                                <div class="filaForm">
	                                    <div class="lbla" ><label for="cmbDivisionModal">Divisi&oacute;n:</label></div>
	                                    <div>
	                                    	 <input id="txtIdDivisionModal" value="${configuracion.idUnidadOrganica.idUnidadOrganica}" type="hidden" />
	                                        <select id="cmbDivisionModal" name="idUnidadOrganica.idUnidadOrganica" validate="[O]">
	                                            <option value="">--Seleccione--</option>
	                                        </select>
	                                    </div>
	                                </div>
	                                <div class="filaForm">
	                                    <div class="lbla"><label for="txtActivP1Modal">Actividad:</label></div>
                                        <div >
                                            <input id="txtActivP1Modal" value="${configuracion.idActividad.descripcionActividad}" validate="[O]" onclick="abrirPopupBusqActividadModal()" type="text" style="cursor: pointer;" readonly placeholder="Click para seleccionar rubro"/>
                                            <input id="txtIdActivP1Modal" value="${configuracion.idActividad.idActividad}" name="idActividad.idActividad" type="hidden" />
                                        </div>                                        
	                                </div>
	                                <div class="filaForm">
	                                    <div class="lbla" ><label for="cmbComponenteModal">Componente:</label></div>
	                                    <div>
	                                        <select id="cmbComponenteModal" name="idModulo.idModulo" validate="[O]">
	                                            <option value="">--Seleccione--</option>
	                                            <c:forEach items="${listadoComponenteModal}" var="ltra">
							                        <option value='${ltra.idModulo}' <c:if test='${configuracion.idModulo.idModulo==ltra.idModulo}'>selected</c:if> >${ltra.descripcion}</option>
							                    </c:forEach>
	                                        </select>
	                                    </div>
	                                </div> 
	                                <div class="filaForm">
	                                    <div class="lbla"><label for="txtNro">Orden de Visualizaci&oacute;n del Componente:</label></div>
                                        <div >
                                            <input id="txtOrdenComponenteModal" maxlength="5" validate="[O]" name="ordenComponente" type="text" class="lblc" value="${configuracion.ordenComponente}"/>
                                        </div>
	                                </div>
	                                <div class="filaForm">
	                                    <div class="lbla" ><label for="cmbComponenteModal">Secci&oacute;n:</label></div>
	                                    <div>
	                                        <select id="cmbComponenteModal" name="idSeccion.idSeccion" validate="[O]">
	                                            <option value="">--Seleccione--</option>
	                                            <c:forEach items="${listadoSeccionModal}" var="ltra">
							                        <option value='${ltra.idSeccion}' <c:if test='${configuracion.idSeccion.idSeccion==ltra.idSeccion}'>selected</c:if> >${ltra.descripcion}</option>
							                    </c:forEach>
	                                        </select>
	                                    </div>
	                                </div> 
	                                <div class="filaForm">
	                                    <div class="lbla"><label for="txtNro">Orden de Visualizaci&oacute;n de la Secci&oacute;n:</label></div>
                                        <div >
                                            <input id="txtOrdenSeccionModal" validate="[O]" maxlength="5" name="ordenSeccion" value="${configuracion.ordenSeccion}" type="text" class="lblc" />
                                        </div>
	                                </div>
                    
            
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <c:if test="${tipo=='new'}">
                <seg:botonTag code="IN" value="Guardar" id="btnGuardarModulo" title="Guardar" styleClass="btn_a btn_small" onclick=""/>
            </c:if>
            <c:if test="${tipo=='edit'}">
                <seg:botonTag code="MO" value="Editar" id="btnEditarModulo" title="Editar" styleClass="btn_a btn_small" onclick=""/>
            </c:if>
            <button id="btnCloseConfiguracion" title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        
        <!-- dialogs -->
        <div id="dialogNuevoObligacionTipo" style="display:none;"></div>
    </body>
</html>
      