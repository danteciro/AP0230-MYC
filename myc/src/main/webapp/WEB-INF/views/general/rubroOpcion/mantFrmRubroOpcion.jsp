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
        <script type="text/javascript" src='<c:url value="/javascript/app/general/rubroOpcion/mantFrmRubroOpcion.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantRubroOpcion" class="tac">
            <div id="divMensajeValidaTramiteActividad" class="errorMensaje" tabindex='1' style="display: none;" ></div>
            <input id="tipoP" type="hidden" disabled value="${tipo}"/>
          
            
            <div id="tabsMantProcedimiento">
                <ul>
                    <li><a href="#tabTramiteActividad">RUBRO - OPCI&Oacute;N</a></li>
                </ul>
    
                <div id="tabTramiteActividad" style="width:620px;">
                    <div class="form" style="width:100%">
                        <div class="filaForm">
                            <div class="lble"><label for="cmbEtapa">RUBRO(*):</label></div>
                            <div class="slcta">
                              <select id="cmbRubro" name="idActividad">
                                  <option id="optRubro"  value="">--Seleccione--</option>
                              </select>
                            </div>
                            <input id="btnAgregarActividad" type="button" value="AGREGAR RUBROS" class="button_2">
                        </div>
                        <div class="filaForm">
                            <input id="btnAgregarOpciones" type="button" value="AGREGAR OPCIONES" class="button_2">
                        </div>
                        <div id="popupArbolActi" class="filaFormMarg" style="display:none;" title="SELECCIONAR RUBROS">
                            <div id="arbolActividades" style="height: 160px;">
                            </div>
                            <div id="botones" style="margin-top:20px;">
                                <button title="Cerrar" onclick="$('#popupArbolActi').dialog('close');return false;">Cerrar</button>
                            </div>
                        </div>
                        <div id="popupArbolOpciones" class="filaFormMarg" style="display:none;" title="SELECCIONAR OPCIONES">
                            <div id="arbolOpciones" style="height: 160px;">
                            </div>
                            <div id="botones" style="margin-top:20px;">
                                <button title="Cerrar" onclick="$('#popupArbolOpciones').dialog('close');return false;">Cerrar</button>
                            </div>
                        </div>
                        <div class="tableDiv">
                            <div class="titu">OPCIONES AGREGADAS</div>
                            <div class="lble" style="display:none;"><label for="idOpcionesAgregarSelect">RUBROS(*):</label></div>
                            <div id="idOpcionesAgregarSelect" validate="[CHECK]" class="cont" style="overflow:auto;height: 150px;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <c:if test="${tipo=='new'}">
                <seg:botonTag code="IN" value="Guardar" id="btnGuardarRubroOpcion" title="Guardar" styleClass="btn_a btn_small" onclick=""/>
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
      