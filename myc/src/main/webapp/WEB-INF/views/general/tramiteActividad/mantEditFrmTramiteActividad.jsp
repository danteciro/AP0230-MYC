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
            //var declarada en padre (procedimiento/mantenimiento.js), usada para armar formulario en caso de edit(editar) o view(consultar), la emplea mantFrmProcedimiento.js
            idTramites="";
            idActividades="${acti}";
        </script>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/tramiteActividad/mantEditFrmTramiteAct.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantProcedimiento" class="tac">
            <div id="divMensajeValidaProcedimiento" class="errorMensaje" tabindex='1' style="display: none;" ></div>
            <input id="tipoP" type="hidden" disabled value="${tipo}"/>
            <input id="txtIdTramiteActividad" name="idTramiteActivdad" type="hidden" value="${r.idTramiteActivdad}"/>
            
            <div id="tabsMantProcedimiento">
                <ul>
                    <li><a href="#tabTramiteActividad">TRÁMITE - RUBROS</a></li>
                </ul>
    
                <div id="tabTramiteActividad" style="width:620px;">
                    <div class="form" style="width:100%">
                        <div class="filaForm" >
                            <div class="lble"><label for="cmbProcesoNuevo">PROCESO(*):</label></div>
                            <div class="slcta">
                                <select id="cmbProcesoNuevo" name="idProceso" validatetab="tabTramiteActividad">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listadoProceso}" var="t">
                                        <option value='${t.idProceso}' <c:if test="${t.idProceso==r.idProceso}">selected</c:if> >${t.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lble"><label for="cmbEtapa">ETAPA DEL PROCESO(*):</label></div>
                            <div class="slcta">
                                <select id="cmbEtapa" name="idEtapa" validate="[O]" validatetab="tabTramiteActividad">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listadoEtapa}" var="t">
                                        <option value='${t.idEtapa}' <c:if test="${t.idEtapa==r.idEtapa}">selected</c:if> >${t.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                            	<seg:botonTag code="IN" value="Agregar" styleClass="btn_a btn_small" id="btnNuevaEtapa" title="Agregar" onclick=""/>
<!--                         		<input id="btnNuevaEtapa" class="btn_a btn_small" type="button" value="Agregar" title="Agregar"> -->
                        	</div>
                        </div>
                        <div class="filaForm">
                            <div class="lble"><label for="cmbTramite">TRAMITE(*):</label></div>
                            <div class="slcta">
                                <select id="cmbTramite" name="idTramite" validate="[O]" validatetab="tabTramiteActividad">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listadoTramite}" var="t">
                                        <option value='${t.idTramite}' <c:if test="${t.idTramite==r.idTramite}">selected</c:if> >${t.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                              <div>
                        		<seg:botonTag code="IN" value="Agregar" styleClass="btn_a btn_small" id="btnNuevoTramite" title="Agregar" onclick=""/>
<!--                         		<input id="btnNuevoTramite" class="btn_a btn_small" type="button" value="Agregar" title="Agregar"> -->
                        	</div>
                        </div>
                      
                        <div class="filaForm">
                            <!--div class="lbla vam"><label>SELECCIONE ACTIVIDADES:</label></div-->
                            <seg:botonTag code="IN" value="AGREGAR RUBROS" styleClass="btn_a btn_mediun" id="btnAgregarActividad" title="AGREGAR RUBROS" onclick=""/>
<!--                             <input id="btnAgregarActividad" type="button" value="AGREGAR RUBROS" class="button_2"> -->
                        </div>
                        <div id="popupArbolActi" class="filaFormMarg" style="display:none;" title="SELECCIONAR RUBROS">
                            <div id="arbolActividadesEdit" style="height: 160px;">
                            </div>
                            <div id="botones" style="margin-top:20px;">
                                <button title="Cerrar" onclick="$('#popupArbolActi').dialog('close');return false;">Cerrar</button>
                            </div>
                        </div>
                        <div class="tableDiv">
                            <div class="titu">RUBROS AGREGADOS</div>
                            <div id="idActividadesAgregarSelect" class="cont" style="overflow:auto;height: 150px;"></div>
                        </div>
                        

                    </div>
                </div>
            </div>
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <c:if test="${tipo=='new'}">
                <seg:botonTag code="IN" value="Guardar" id="btnGuardarProc" title="Guardar" styleClass="btn_a btn_small" onclick=""/>
<!--                <button id="btnGuardarProc" title="Guardar" class="btnSimple">Guardar</button>-->
            </c:if>
            <c:if test="${tipo=='edit'}">
                <seg:botonTag code="MO" value="Editar" id="btnEditarProc" title="Editar" styleClass="btn_a btn_small" onclick=""/>
<!--                <button id="btnEditarProc" title="Editar" class="btnSimple">Editar</button>-->
            </c:if>
            <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
          <!-- dialogs -->
        <div id="dialogMantEtapa" class="dialog"  title="Mantenimiento Etapa" style="display:none;"></div>
        
         <div id="dialogMantTramite" class="dialog"  title="Mantenimiento Tramite" style="display:none;"></div>
        
    </body>
</html>
      