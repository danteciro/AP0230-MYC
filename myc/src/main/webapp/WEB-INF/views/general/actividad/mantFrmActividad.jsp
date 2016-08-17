<%-- 
* Resumen           
* Objeto            : mantFrmActividad.jsp
* Descripción       : Diseño del mantenimiento de actividades MYC.
* Fecha de Creación : 30/06/2015.
* PR de Creación    : OSINE_SFS-600
* Autor             : Hernán Torres Sáenz.
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
        <script type="text/javascript" src='<c:url value="/javascript/app/general/actividad/mantFrmActividad.js" />' charset="utf-8"></script>
    </head>
    <body>
    	<input type="hidden" id="idActividad" name="idActividad" value="${a.idActividad}">
        <input id="tipoActividad_" name="tipoActividad_" type="hidden" value="${tipo}"/>
        <form id="frmMantActividad" class="tac">
            <div id="divMensajeValidaActividad" class="errorMensaje" tabindex='1' style="display: none;" ></div>
            <fieldset >
                <div class="form">
                    <div class="filaForm">
                        <div class="lblc"><label for="txtNombreActividad" style="margin-left:20%;">ACTIVIDAD:</label></div>
                        <div>
                            <input id="txtNombreActividad" name="txtNombreActividad" validate="[O]" type="text" maxlength="100" style="width:300px;text-transform:uppercase" value="${a.nombre}" />
                        </div>
                        <div>
                        	<seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarActividades" title="Buscar" onclick=""/>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lblc"><label for="txtCodigo" style="margin-left:20%;">CÓDIGO:</label></div>
                        <div>
                            <input id="txtCodigo" name="txtCodigo" validate="[O]" type="text" maxlength="3" style="width:50px;" value="${a.codigo}" <c:if test="${tipo=='editar'}">disabled</c:if>/>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lblc"><label for="txtNumeroOrden" style="margin-left:20%;">ORDEN:</label></div>
                        <div>
                            <input id="txtNumeroOrden" name="txtNumeroOrden" validate="[O]" type="text" maxlength="6" style="width:50px;" value="${a.orden}" />
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>
        <div id="botones" style="margin-top:10px;">
      		<seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarActividad" title="Guardar" onclick=""/>
      		<button class="btnCloseDialog" title="Cerrar">Cerrar</button>
      	</div>
      	<div class="tableDiv tblAgreRequ" style="width:100%;">
          <div class="titu tal">ACTIVIDADES REGISTRADAS</div>
          <div id="verActividad" class="cont wsp ilb tal" style="width: 100%;height: 250px;overflow: auto;"></div>
      	</div>		        
    </body>
</html>