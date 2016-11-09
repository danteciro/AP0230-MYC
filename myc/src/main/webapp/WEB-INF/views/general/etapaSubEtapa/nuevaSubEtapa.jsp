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
       <script type="text/javascript" src='<c:url value="/javascript/app/general/etapaSubEtapa/nuevaSubEtapa.js" />' charset="utf-8"></script>
    </head>
    <body>
       <form id="frmNuevaSubEtapa" class="">
           <div id="divMensajeNuevaSubEtapa" class="errorMensaje" tabindex='1' style="display: none;" ></div>
          			<input hidden="true" id="idEtapaAgregar" value="${idEtapa}"/>
          			<input hidden="true" id="idEtapaPlazoEditar" />
          			<input hidden="true" id="idEtapaDisponibleEditar" />
          			               <div class="filaForm">
	                                 		<div class="lble"><label>Descripción (*) : </label></div>
                                  		    <input id="descripcionSubEtapa" name="notificacion" validate="[O]" type="text" maxlength="100" style="width:225px;text-transform:uppercase" value="" />
                     			   </div>
	                                <div class="filaForm">
	                                 		<div class="lble"><label>Tiempo en Días (*) :</label></div>
                                  		    <input id="tiempoDiasSubEtapa" name="notificacion" validate="[O]" type="text" maxlength="2" style="width:225px;text-transform:uppercase" value="" />
                     			   </div>
	                 			   <div class="filaForm">
	                                 		<div class="lble"><label>Responsable (*) :</label></div>
                                            <div>
                                            	<select id="cmbResponsableSubEtapa" name="idRes" validate="[O]" class="lbla">
	                                        		 <option value="">--Seleccione--</option>
							                     	<c:forEach items="${listaResponsable}" var="res">
							                 			<option value='${res.idMaestroColumna}'>${res.descripcion}</option>
							                 	 	</c:forEach> 
	                                    	  	</select>
	                                    	</div>
		           				   </div>
            
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <seg:botonTag code="IN" value="Guardar" id="btnGuardarModSubEtapa" title="Guardar" styleClass="btn_a btn_small" onclick=""/>
            <button  title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        
    </body>
</html>
      