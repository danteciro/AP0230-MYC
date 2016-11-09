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
       <script type="text/javascript" src='<c:url value="/javascript/app/general/etapaSubEtapa/modificarSubEtapa.js" />' charset="utf-8"></script>
    </head>
    <body>
       <form id="frmSubEtapaMod" class="">
          		<div id="divMensajeSubEtapa" class="errorMensaje" tabindex='1' style="display: none;" ></div>
          				<input hidden="true" id="idEtapaPlazo" />
          				<input hidden="true" id="idEtapaDisponible" />
	                               <div class="filaForm">
	                                    <div class="lble" ><label for="cmbGerencia">Etapa (*) :</label></div>
	                                    <div>
	                                        <select id="cmbEtapasSubMod" name="idEtapas" validate="[O]" class="lbla">
	                                            <option value="">--Seleccione--</option>
							                 	<c:forEach items="${listaEtapa}" var="eta">
							                 		<option value='${eta.idEtapa}'>${eta.descripcion}</option>
							                 	</c:forEach> 
	                                        </select>
	                                </div>
	                                </div>
	                                <div class="filaForm">
	                                 		<div class="lble"><label>Descripción (*) : </label></div>
                                  		    <input id="descripcionSubEtapaMod" name="notificacion" validate="[O]" type="text" maxlength="100" style="width:225px;text-transform:uppercase" value="" />
                     			   </div>
	                                <div class="filaForm">
	                                 		<div class="lble"><label>Tiempo en Días (*) :</label></div>
                                  		    <input id="tiempoDiasSubEtapaMod" name="notificacion" validate="[O]" type="text" maxlength="2" style="width:225px;text-transform:uppercase" value="" />
                     			   </div>
	                 			   <div class="filaForm">
	                                 		<div class="lble"><label>Responsable (*) :</label></div>
                                            <div>
                                            	<select id="cmbResponsableSubEtapaMod" name="idRes" validate="[O]" class="lble">
	                                        		 <option value="">--Seleccione--</option>
							                     	<c:forEach items="${listaResponsable}" var="res">
							                 			<option value='${res.idMaestroColumna}'>${res.descripcion}</option>
							                 	 	</c:forEach> 
	                                    	  	</select>
	                                    	</div>
		           				   </div>
		           				   <div class="filaForm">
		           				   		<div id="gridContenedorSubEtapas" class="content-grilla"></div>
		           				   </div>
            
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <seg:botonTag code="IN" value="Guardar" id="btnGuardarSubEtapa" title="Guardar" styleClass="btn_a btn_small" onclick=""/>
            <button  title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        
    </body>
</html>
      