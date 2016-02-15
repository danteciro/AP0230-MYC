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
            idSileAdmi="<c:choose><c:when test="${tipo != 'new'}">${r.idSilencioAdministrativo}</c:when><c:otherwise>30</c:otherwise></c:choose>";
            idTramites="${tram}";
            idActividades="${acti}";
        </script>
        <script type="text/javascript" src='<c:url value="/javascript/app/requisitos/procedimiento/mantFrmProcedimiento.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantProcedimiento" class="tac">
            <div id="divMensajeValidaProcedimiento" class="errorMensaje" tabindex='1' style="display: none;" ></div>
            <input id="tipoP" type="hidden" disabled value="${tipo}"/>
            <input id="txtIdProcedimiento" name="idProcedimiento" type="hidden" value="${r.idProcedimiento}"/>
            
            <div id="tabsMantProcedimiento">
                <ul>
                    <li><a href="#tabProcedimiento">PROCEDIMIENTO</a></li>
                    <li><a href="#tabTramiteActividad">TRÁMITE - RUBROS</a></li>
                </ul>
                <div id="tabProcedimiento" style="width:620px;">
                    <div class="form" style="width:100%">
                        <div class="filaForm">
                            <div class="lble"><label for="txtItemProc">ITEM:</label></div>
                            <div>
                                <input id="txtItemProc" name="item" type="text" maxlength="10" value="${r.item}" />
                            </div>
                            <div class="lbli"><label for="cmbAnexoRrh">ANEXO RRH:</label></div>
                            <div>
                                <select id="cmbAnexoRrh" name="idAnexoRrh">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listadoAnexo}" var="t">
                                        <option value='${t.idMaestroColumna}' <c:if test="${r.idAnexoRrh==t.idMaestroColumna}">selected</c:if>>${t.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lble vam vat"><label for="txtDenominacionProc">DENOMINACIÓN DE PROCEDIMIENTO(*):</label></div>
                            <div class="vat">
                                <textarea id="txtDenominacionProc" name="denominacion" class="inputGrande txtMayus" style="height:50px" maxlength="500" validate="[O]" validatetab="tabProcedimiento">${r.denominacion}</textarea>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lble vat"><label for="txtBaseLegal">BASE LEGAL(*):</label></div>
                            <div>
                                <textarea id="txtBaseLegal" name="baseLegal" class="inputGrande" style="height:50px" maxlength="2000" validate="[O]" validatetab="tabProcedimiento">${r.baseLegal}</textarea>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lble vam"><label>DERECHO TRAMITACIÓN(*):</label></div>
                            <div>
                                <div>GRATUITO</div>
                                <div class="vam">
                                    <input type="checkbox" id="chkTramGrat" <c:if test="${r.derechoTramitacion==null || r.derechoTramitacion==0}">checked</c:if> >
                                    <label for="chkTramGrat" class="checkbox"></label>
                                </div>
                            </div>
                        </div>
                        <div id="filaDerechoTramitacion" style="<c:if test="${r.derechoTramitacion==null || r.derechoTramitacion==0}">display: none;</c:if>">
                            <div class="filaFormSubE">
                                <div class="lblg"><label for="txtPorcUIT">En % UIT:</label></div>
                                <div class="slcta">
                                    <input id="txtPorcUIT" name="derechoTramitacion" value="<c:choose><c:when test="${tipo!='new'}">${r.derechoTramitacion}</c:when><c:otherwise>0</c:otherwise></c:choose>" type="text" maxlength="10" class="inputSmall tac" validate="[MONEDA]" validatetab="tabProcedimiento" />
                                </div>
                                <div class="lblc"><label for="txtPorcUIT">Valor UIT:</label></div>
                                <div>
                                    <label id="txtValorUIT" idmc="${valorUit.idMaestroColumna}">${valorUit.descripcion}</label>
                                    <input type="hidden" name="idValorUit" value="${valorUit.idMaestroColumna}" />
                                </div>
                            </div>
                            <div class="filaFormSubE">
                                <div class="lblg"><label for="txtSoles">En S/.:</label></div>
                                <div>
                                    <label id="txtSoles">0.00</label>
                                </div>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lble" for="cmbCalificacion"><label>CALIFICACIÓN:</label></div>
                            <div class="slcta">
                                <select id="cmbCalificacion" name="idCalificacion">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listadoCalificacion}" var="t">
                                        <option value='${t.idMaestroColumna}' 
                                            <c:if test="${tipo=='new'}"><c:if test="${t.descripcion=='EVALUACION PREVIA'}">selected</c:if></c:if> 
                                            <c:if test="${tipo!='new'}"><c:if test="${t.idMaestroColumna==r.idCalificacion}">selected</c:if></c:if>
                                        >${t.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="slcta">
                                <select id="cmbSilencioAdministrativo" name="idSilencioAdministrativo" style="display:none;">
                                    <option value="">--Seleccione--</option>
                                </select>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lbla"><label for="cmbEvalPrevia">PLAZO A RESOLVER (en dias habiles)(*):</label></div>
                            <div>
                                <input id="txtPlazoResolver" name="plazoResolver" type="text" maxlength="3" value="<c:choose><c:when test="${tipo!='new'}">${r.plazoResolver}</c:when><c:otherwise>30</c:otherwise></c:choose>" validate="[O][SNP]"/>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lbla"><label for="txtInicioProc">INICIO DEL PROCEDIMIENTO:</label></div>
                            <div>
                                <select id="cmbInicioProc" name="idInicioProcedimiento">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listadoInicProc}" var="t">
                                        <option value='${t.idMaestroColumna}' 
                                            <c:if test="${tipo=='new'}"><c:if test="${t.descripcion=='MESA DE PARTE'}">selected</c:if></c:if> 
                                            <c:if test="${tipo!='new'}"><c:if test="${t.idMaestroColumna==r.idInicioProcedimiento}">selected</c:if></c:if>
                                        >${t.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lbla"><label for="txtAutoridadCompetente">AUTORIDAD COMPETENTE PARA RESOLVER:</label></div>
                            <div>
                                <select id="cmbAutoridadCompe" name="idAutoridadCompetente">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listadoAutCompReso}" var="t">
                                        <option value='${t.idMaestroColumna}' <c:if test="${t.idMaestroColumna==r.idAutoridadCompetente}">selected</c:if> >${t.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lbla"><label>INSTANCIAS DE RESOLUCIÓN DE RECURSOS:</label></div>
                        </div>
                        <div class="filaFormSubE">
                            <div class="lblg"><label for="cmbReconsideracion">Reconsideración:</label></div>
                            <div>
                                <select id="cmbReconsideracion" name="idReconsideracion">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listadoReconsideracion}" var="t">
                                        <option value='${t.idMaestroColumna}' <c:if test="${t.idMaestroColumna==r.idReconsideracion}">selected</c:if> >${t.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="filaFormSubE">
                            <div class="lblg"><label for="cmbApelacion">Apelación:</label></div>
                            <div>
                                <select id="cmbApelacion" name="idApelacion">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listadoApelacion}" var="t">
                                        <option value='${t.idMaestroColumna}' <c:if test="${t.idMaestroColumna==r.idApelacion}">selected</c:if> >${t.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lble vam vat"><label for="txtDenominacionProc">NOTA PROCEDIMIENTO:</label></div>
                            <div class="vat">
                                <textarea id="txtNotaProc" name="notaProcedimiento" class="inputGrande" style="height:50px" maxlength="4000" >${r.notaProcedimiento}</textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="tabTramiteActividad" style="width:620px;">
                    <div class="form" style="width:100%">
                        <div class="filaForm" style="display:none">
                            <div class="lble"><label for="cmbProceso">PROCESO(*):</label></div>
                            <div class="slcta">
                                <select id="cmbProcesoXXX" name="idProceso" validatetab="tabTramiteActividad">
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
                        </div>
                        <div id="tramitesNuevoProc" style="display:none;">
                            <div class="filaForm">
                                <div class="lble"><label for="contTramites">TRAMITES(*):</label></div>
                            </div>
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
                            <div id="idActividadesAgregarSelect" class="cont" style="overflow:auto;height: 150px;"></div>
                        </div>
                        
<!--                        <fieldset style="display:none;">
                            <legend>Seleccione Parametros Dinamicos y Orden</legend>
                            <div class="tac">
                                <div class="ilb">
                                    <div class="ilb" style="width: 150px;">Disponibles</div>
                                    <div class="ilb" style="width: 50px;"> - </div>
                                    <div class="ilb" style="width: 150px;">Seleccionados</div>
                                </div>
                                <div id="picklist" class="ilb">  
                                    <select name="source">  
                                    </select>  
                                    <select name="target">  
                                        <option value="1">ETAPA</option>  
                                        <option value="2">ZONA</option>  
                                        <option value="3">TIPO PERSONA</option>  
                                    </select>  
                                </div>
                            </div>
                        </fieldset>-->
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
    </body>
</html>
      