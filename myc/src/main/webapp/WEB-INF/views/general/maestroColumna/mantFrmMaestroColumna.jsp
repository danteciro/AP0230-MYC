<%-- 
    Document   : frmMantRequisito
    Created on : 21/08/2014, 03:42:43 PM
    Author     : jpiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/maestroColumna/mantFrmMaestroColumna.js" />' charset="utf-8"></script>
    </head>
    <body>
        <input id="tipoP" type="hidden" value="${tipo}"/>
        <form id="frmMantMaestroColumna" class="tac">
            <div id="divMensajeValidaMaestroColumna" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <input id="idMaesColuMant" name="idMaestroColumna" type="hidden" value="${r.idMaestroColumna}"/>
            <fieldset>
                <div class="form">
                    <div class="filaForm" style="display:none;">
                        <div class="lble"><label for="cmbAplicacionMant">APLICACION(*):</label></div>
                        <div>
                            <select id="cmbAplicacionMant" name="aplicacion" validate="[O]">
                                <option value="">--Seleccione--</option>
                                <c:forEach items="${listadoAplicaciones}" var="t">
                                    <option value='${t.aplicacion}' <c:if test="${r.aplicacion==t.aplicacion}">selected</c:if>>${t.aplicacion}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lble"><label for="cmbDominioMant">GRUPO DE NEGOCIO(*):</label></div>
                        <div>
                            <select id="cmbDominioMant" name="dominio" validate="[O]">
                                <option value="">--Seleccione--</option>
                                <c:forEach items="${listadoAplicaciones}" var="la">
                                    <optgroup label='${la.aplicacion}'>                                
                                        <c:forEach items="${listadoDominios}" var="ld">
                                            <c:if test="${ld.aplicacion==la.aplicacion}">
                                                <option value='${ld.dominio}' <c:if test="${r.dominio==ld.dominio}">selected</c:if>>${ld.descripcion}</option>
                                            </c:if>
                                        </c:forEach>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                        	<seg:botonTag code="IN" value="Agregar" styleClass="btn_a btn_small" id="btnAgregarDominio" title="Agregar" onclick=""/>
<!--                             <input type="button" title="Agregar" value="Agregar" class="btn_a btn_small" id="btnAgregarDominio"> -->
                        </div>
                    </div>
                
                    <div class="filaForm">
                        <div class="lble"><label for="txtCodigoMant">CODIGO(*):</label></div>
                        <div>
                            <input id="txtCodigoMant" name="codigo" type="text" validate="[O]" maxlength="5" value="${r.codigo}"/>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lble"><label for="txtDescripcionMant">DESCRIPCION(*):</label></div>
                        <div>
                            <textarea id="txtDescripcionMant" name="descripcion" type="text" validate="[O]" maxlength="200" value="${r.descripcion}" style="width:350px;" >${r.descripcion}</textarea>
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>                    
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
        <seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarMaesColu" title="Agregar Maestro Columna" onclick=""/>
<!--             <input type="button" title="Agregar Maestro Columna" value="Guardar" class="btn_a btn_small" id="btnGuardarMaesColu"> -->
<seg:botonTag code="MO" value="Editar" styleClass="btn_a btn_small" id="btnEditarMaesColu" title="Editar Maestro Columna" onclick=""/>
<!--             <input type="button" title="Editar Maestro Columna" value="Editar" class="btn_a btn_small" id="btnEditarMaesColu"> -->
            <input type="button" title="Limpiar" value="Limpiar" class="btn_a btn_small" id="btnLimpiarMaesColu">
            <input type="button" title="Cerrar" value="Cerrar" class="btnCloseDialog btn_a btn_small">
        </div>
        <div class="gridMargin">
            <div id="gridContenedorMaesColuMant"></div>
            <div id="divContextMenuMaesColuMant"></div>
        </div>
        <div id="dialogMantMaestroTabla" class="dialog"  title="Mantenimiento Maestro Tabla" style="display:none;"></div>
    </body>
</html>