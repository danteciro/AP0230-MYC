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
            
            idTramites="${tram}";
        	idActividades="";
        </script>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/tramiteActividad/mantFrmTramiteAct.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantTramiteActividad" class="tac">
            <div id="divMensajeValidaTramiteActividad" class="errorMensaje" tabindex='1' style="display: none;" ></div>
            <input id="tipoP" type="hidden" disabled value="${tipo}"/>
          
            
            <div id="tabsMantProcedimiento">
                <ul>
                    <li><a href="#tabTramiteActividad">TRÁMITE - RUBROS</a></li>
                </ul>
    
                <div id="tabTramiteActividad" style="width:620px;">
                    <div class="form" style="width:100%">
                        <div class="filaForm" >
                            <div class="lble"><label for="cmbProceso">PROCESO(*):</label></div>
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
                                </select>
                            </div>
                           <div>
                        		<input id="btnNuevaEtapa" class="btn_a btn_small" type="button" value="Agregar" title="Agregar">
                        	</div>
                        </div>
                        <div class="filaForm">
                            <div class="lble"><label for="contTramites">TRAMITES(*):</label></div>
                            <div class="slcta"></div>
                            <div><input id="btnNuevoTramite" class="btn_a btn_small" type="button" value="Agregar" title="Agregar" style="display:none;"></div>   
                        </div>
                        <div class="filaForm" style="height: 25px;">
                            <div id="chkTramit" class="lblh contChkA tar" style="display:none;">
                                <div>
                                    <input id="chkTramite" type="checkbox" value="" name="" >
                                    <label class="checkbox" for="chkTramite"></label>
                                </div>
                            </div>
                        </div>                        
                        <div id="tramitesNuevoProc" style="display:none;">
                             <div class="lble"><label for="contTramitesxx"></label></div>
                            <div class="filaForm" validate="[CHECK]" id="contTramites"></div>
                        </div>
                        
                        
                        <div class="filaForm">
                            <!--div class="lbla vam"><label>SELECCIONE ACTIVIDADES:</label></div-->
                            <input id="btnAgregarActividad" type="button" value="AGREGAR RUBROS" class="button_2">
                        </div>
                        <div id="popupArbolActi" class="filaFormMarg" style="display:none;" title="SELECCIONAR RUBROS">
                            <div id="arbolActividades" style="height: 160px;">
                            </div>
                            <div id="botones" style="margin-top:20px;">
                                <button title="Cerrar" onclick="$('#popupArbolActi').dialog('close');return false;">Cerrar</button>
                            </div>
                        </div>
                        <div class="tableDiv">
                            <div class="titu">RUBROS AGREGADOS</div>
                            <div class="lble" style="display:none;"><label for="idActividadesAgregarSelect">RUBROS(*):</label></div>
                            <div id="idActividadesAgregarSelect" validate="[CHECK]" class="cont" style="overflow:auto;height: 150px;"></div>
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
      