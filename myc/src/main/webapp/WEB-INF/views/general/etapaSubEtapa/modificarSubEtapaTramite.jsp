<%-- 
  	Resumen.
	Objeto                :              manteniminetoEtapas.jsp
	Descripción           :              Pantalla de mantenimiento de Etapas y SubEtapas
	Fecha de Creación     :              06/10/2016
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
       <script type="text/javascript" src='<c:url value="/javascript/app/general/etapaSubEtapa/modificarSubEtapaTramite.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmModificarSubEtapa" class="">
            <div id="divMensajeModificarSubEtapa" class="errorMensaje" tabindex='1' style="display: none;" ></div>
            <input type="hidden" id="idSubEtapaMod"  value="${subEtapa.idSubetapa}">   
            <input id="idEtapaPlazoEditarSub" type="hidden"/>
            <input id="idEtapaDisponibleEditarSub" type="hidden"/>
            <input id="idTiempoActualSubEtapa" type="hidden" value="${subEtapa.tiempoDias}" />
	                               <div class="filaForm">
	                                    <div class="lble" ><label for="cmbGerencia">Etapa :</label></div>
	                                    <div>
	                                        <select id="cmbEtapasSubMod" name="idEtapas" validate="[O]" style="width:300px" value="${subEtapa.idEtapa.idEtapa}" disabled="disabled">
	                                            <option value="">--Seleccione--</option>
							                 	<c:forEach items="${listaEtapa}" var="eta">
							                 		<option value='${eta.idEtapa}' <c:if test="${(eta.idEtapa==etapa)}">selected</c:if>>${eta.descripcion}</option>
							                 	</c:forEach> 
	                                        </select>
	                                    </div>
	                                    
	                                </div>
	                                <div class="filaForm">
	                                 		<div class="lble"><label>Descripción: </label></div>
                                  		    <input id="descripcionSubEtapaMod" name="notificacion" validate="[O]" type="text" maxlength="100" style="width:275px;text-transform:uppercase" value="${subEtapa.descripcion}" />
                     			   </div>
	                                <div class="filaForm">
	                                 		<div class="lble"><label>Tiempo en Días :</label></div>
                                  		    <input id="tiempoDiasSubEtapaMod" name="notificacion" validate="[O]" type="text" maxlength="2" style="width:275px;text-transform:uppercase" value="${subEtapa.tiempoDias}" />
                     			   </div>
	                 			   <div class="filaForm">
	                                 		<div class="lble"><label>Responsable :</label></div>
                                            <div>
                                            	<select id="cmbResponsableSubEtapaMod" name="idRes" validate="[O]" style="width:300px">
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
            <seg:botonTag code="IN" value="Guardar" id="btnGuardarSubEtapaMod" title="Guardar" styleClass="btn_a btn_small" onclick=""/>
            <button  title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        
    </body>
</html>
      