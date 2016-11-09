<%-- 
  	Resumen.
	Objeto                :              manteniminetoEtapas.jsp
	Descripción           :              Pantalla de mantenimiento de Etapas y SubEtapas
	Fecha de Creación     :              16/10/2016
	Autor                 :              jorojasb.
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	Modificaciones
	Motivo                                    Fecha                                   Nombre                              Descripción
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  OSINE_SFS-1232	                         23/08/2016                        Victor  Rojas             PANTALLA: CONFIGURACION ETAPAS Y SUBETAPAS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
       <script type="text/javascript" src='<c:url value="/javascript/app/general/etapaSubEtapa/nuevaSubEtapaEtapaTramite.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmNuevaSubEtapa_EtapaTramite" class="">
            <div id="divMensajeNuevaSubEtapa_EtapaTramite" class="errorMensaje" tabindex='1' style="display: none;" ></div>
            <input hidden="true" id="idEtapaPlazoNuevo" />
          				<input hidden="true" id="idEtapaDisponibleNuevo" />
                                    <div class="filaForm">
	                                    <div class="lble" ><label for="cmbGerencia">Etapa (*):</label></div>
	                                    <div>
	                                        <select id="cmbEtapasSubNueva" name="idEtapas" validate="[O]" style="width:300px" value="${subEtapa.idEtapa.idEtapa}">
	                                            <option value="">--Seleccione--</option>
							                 	<c:forEach items="${listaEtapa}" var="eta">
							                 		<option value='${eta.idEtapa}' <c:if test="${(eta.idEtapa==etapa)}">selected</c:if>>${eta.descripcion}</option>
							                 	</c:forEach> 
	                                        </select>
	                                    </div>
	                                    
	                                </div>
	                                <div class="filaForm">
	                                 		<div class="lble"><label>Descripción (*): </label></div>
                                  		    <input id="descripcionSubEtapaNueva" name="notificacion" validate="[O]" type="text" maxlength="100" style="width:275px;text-transform:uppercase" value="${subEtapa.descripcion}" />
                     			   </div>
	                                <div class="filaForm">
	                                 		<div class="lble"><label>Tiempo en Días (*):</label></div>
                                  		    <input id="tiempoDiasSubEtapaNueva" name="notificacion" validate="[O]" type="text" maxlength="2" style="width:275px;text-transform:uppercase" value="${subEtapa.tiempoDias}" />
                     			   </div>
	                 			   <div class="filaForm">
	                                 		<div class="lble"><label>Responsable (*):</label></div>
                                            <div>
                                            	<select id="cmbResponsableSubEtapaNueva" name="idRes" validate="[O]" style="width:300px">
	                                        		 <option value="">--Seleccione--</option>
							                     	<c:forEach items="${listaResponsable}" var="res">
							                 			<option value='${res.idMaestroColumna}' <c:if test="${(res.idMaestroColumna==responsable)}">selected</c:if> >${res.descripcion}</option>
							                 	 	</c:forEach> 
	                                    	  	</select>
	                                    	</div>
		           				   </div>
		 </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <seg:botonTag code="IN" value="Guardar" id="btnGuardarNuevaSubEtapa" title="Guardar" styleClass="btn_a btn_small" onclick=""/>
            <button  title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        
    </body>
</html>
      