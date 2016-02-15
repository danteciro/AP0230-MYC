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
        <script type="text/javascript" src='<c:url value="/javascript/app/general/procesoObligacionTipo/mantFrmProcesoObligacionTipo.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantProcesoObligacionTipo" class="tac">
            <div id="divMensajeValidaProcesoObligacionTipo" class="errorMensaje" tabindex='1' style="display: none;" ></div>
            <input id="tipoP" type="hidden" value="${tipo}"/>  
            <input type="hidden" name="idProOblTip" value="${idProOblTip}"/>  
    
            <div id="tabTramiteActividad" style="width:620px;">
                <div class="form" style="width:100%">
                    <div class="filaForm" >
                        <div class="lble"><label for="cmbProceso">PROCESO(*):</label></div>
                        <div class="slcta">
                            <select id="cmbProcesoXXX" name="idProceso" validate="[O]">
                                <option value="">--Seleccione--</option>
                                <c:forEach items="${listadoProceso}" var="t">
                                    <option value='${t.idProceso}' <c:if test="${t.idProceso==idProceso}">selected</c:if> >${t.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lble"><label for="cmbProceso">OBLIGACION TIPO(*):</label></div>
                        <div class="slcta">
                            <select id="cmbObligacionTipoNuevo" name="idObligacionTipo" validate="[O]">
                                <option value="">--Seleccione--</option>
                                  <c:forEach items="${listadoObligacionTipo}" var="t">
                                    <option value='${t.idObligacionTipo}' <c:if test="${t.idObligacionTipo==idObligacionTipo}">selected</c:if> >${t.nombre}</option>
                                </c:forEach>    
                            </select>
                        </div>
                        <div>
                            <input id="btnNuevaObligacionTipo" class="btn_a btn_small" type="button" value="Agregar" title="Agregar">
                        </div>
                    </div>

                    <div class="filaForm">
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
                        <div id="idActividadesAgregarSelect" class="cont" style="overflow:auto;height: 150px;"></div>
                    </div>
                </div>
            </div>
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <c:if test="${tipo=='new'}">
                <seg:botonTag code="IN" value="Guardar" id="btnGuardarProcesoObliTipo" title="Guardar" styleClass="btn_a btn_small" onclick=""/>
            </c:if>
            <c:if test="${tipo=='edit'}">
                <seg:botonTag code="MO" value="Editar" id="btnEditarProcesoObliTipo" title="Editar" styleClass="btn_a btn_small" onclick=""/>
            </c:if>
            <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        
        <!-- dialogs -->
        <div id="dialogNuevoObligacionTipo" style="display:none;"></div>
    </body>
</html>
      