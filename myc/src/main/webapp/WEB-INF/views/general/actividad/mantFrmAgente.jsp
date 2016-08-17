<%-- 
* Resumen           
* Objeto            : mantFrmAgente.jsp
* Descripción       : Diseño del mantenimiento de agente MYC.
* Fecha de Creación : 08/07/2015.
* PR de Creación    : OSINE_SFS-600
* Autor             : Mario Dioses Fernández.
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
        <script type="text/javascript" src='<c:url value="/javascript/app/general/actividad/mantFrmAgente.js" />' charset="utf-8"></script>
    </head>
    <body>
    	<input type="hidden" id="ActividadPadre" name="ActividadPadre" value="${act3}">
    	<input type="hidden" id="tipoAgente_" name="tipoAgente_" value="${tipo}">    	
    	<input type="hidden" id="idActividadPadreAgente_" name="idActividadPadreAgente_" value="${act3.idActividadPadre}">
    	<input type="hidden" id="idActividadAgente_" name="idActividadAgente_" value="${act3.idActividad}">
        <form id="frmMantAgente_" class="tac">
            <div id="divMensajeValidaAgente_" class="errorMensaje" tabindex='1' style="display: none;" ></div>
            <fieldset>
                <div class="form">
                    <div class="filaForm">
                        <div class="lblc"><label for="txtNombreActividadAgente" style="margin-left:20%;">ACTIVIDAD:</label></div>
                        <div>
                            <input id="txtNombreActividadAgente" name="txtNombreActividadAgente" validate="[O]" type="text" maxlength="100" style="width:300px;text-transform:uppercase" value="${act3.nombrePadre}" disabled />
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lblc"><label for="txtNombreAgente_" style="margin-left:20%;">AGENTE:</label></div>
                        <div>
                            <input id="txtNombreAgente_" name="txtNombreAgente_" validate="[O]" type="text" maxlength="100" style="width:300px;text-transform:uppercase" value="${act3.nombre}" />
                        </div>
                        <div>
                        	<seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarAgente_" title="Buscar" onclick=""/>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lblc"><label for="txtCodigoAgente" style="margin-left:20%;">CÓDIGO:</label></div>
                        <div>
                            <input id="txtCodigoAgente" name="txtCodigoAgente" validate="[O]" type="text" maxlength="3" style="width:50px;" value="${act3.codigo}" <c:if test="${tipo=='editar'}">disabled</c:if> />
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lblc"><label for="txtNumeroOrdenAgente" style="margin-left:20%;">ORDEN:</label></div>
                        <div>
                            <input id="txtNumeroOrdenAgente" name="txtNumeroOrdenAgente" validate="[O]" type="text" maxlength="6" style="width:50px;" value="${act3.orden}" />
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>
        <div id="botones">
        	<seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarAgente_" title="Guardar" onclick=""/>
        	<button class="btnCloseDialog" title="Cerrar">Cerrar</button>
        </div>
        <div class="tableDiv tblAgreRequ" style="width:100%;">
          <div class="titu tal">AGENTES REGISTRADOS</div>
          <div id="verAgente" class="cont wsp ilb tal" style="width: 100%;height: 250px;overflow: auto;"></div>
      	</div>
        <div class="gridMargin">
            <div id="gridContenedorAgente_"></div>
            <div id="divContextMenuAgente_"></div>
        </div>		                
    </body>
</html>