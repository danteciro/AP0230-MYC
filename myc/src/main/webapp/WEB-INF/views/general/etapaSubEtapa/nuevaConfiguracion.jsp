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
       <script type="text/javascript" src='<c:url value="/javascript/app/general/etapaSubEtapa/nuevaConfiguracion.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantConfiguracionEtapa" class="">
            <div id="divMensajeMantConfiguracionEtapa" class="errorMensaje" tabindex='1' style="display: none;" ></div>
          
	                           <div class="filaForm">
	                                    <div class="lble" ><label for="cmbGerencia">Gerencia (*) :</label></div>
	                                    <div>
	                                        <select id="cmbGerenciaEtapa2" name="idGerencia" validate="[O]" class="lbld">
	                                            <option value="">--Seleccione--</option>
							                 	<c:forEach items="${listaGerencia}" var="uni">
							                 		<option value='${uni.idUnidadOrganica}'>${uni.descripcion}</option>
							                 	</c:forEach> 
	                                        </select>
	                                    </div>
	                                    
	                                </div>
	                                <div class="filaForm">
	                                    <div class="lble" ><label for="cmbDivisionEtapa">Divisi&oacute;n (*) :</label></div>
	                                    <div>
	                                        <select id="cmbDivisionEtapa2" name="idUnidadOrganica" validate="[O]" class="lbld">
	                                            <option value="">--Seleccione--</option>
	                                        </select>
	                                    </div>
	                                </div>
	                                <div class="filaForm">
	                                  	<div class="lble" ><label for="cmbSector">Sector (*) :</label></div>
	                                    <div>
	                                        <select id="cmbSectorEtapa2" name="idSector" validate="[O]" class="lbld">
	                                        	   <option value="">--Seleccione--</option>
	                                    	</select>
	                                    </div>
	                                </div>
	                                <div class="filaForm">
	                                    <div class="lble"><label>Actividad (*) :</label></div>
                                         <div>
	                                        <select id="cmbActividadEtapa2" name="" validate="[O]" class="lbld">
	                                            <option value="">--Seleccione--</option>
	                                        </select>
	                                    </div>
	                                </div>
	                                <div class="filaForm">
	                                    <div class="lble" ><label for="cmbAgente">Agente (*) :</label></div>
	                                    <div>
	                                        <select id="cmbAgenteEtapa2" name="idActividad" validate="[O]" class="lbld">
	                                            <option value="">--Seleccione--</option>
	                                        </select>
	                                    </div>
	                                </div>
	                                <div class="filaForm">
	                                	<div class="lble" ><label for="cmbAgente">Trámite (*) : </label></div>
	                                    <select  id="cmbTramiteEtapa2" name="idTramite" validate="[O]" class="lbld">
	                                    	<option value="">--Seleccione--</option>
	                                    	<c:forEach items="${listaTramite}" var="tramite">
	                                    		<option value='${tramite.idTramite}'>${tramite.descripcion}</option>
							                </c:forEach>
	                                    </select>
	                                </div> 
	                                
	                                <div class="filaForm">
	                                 		<div class="lble"><label>Informe de orientación (*) :</label></div>
                                            <textArea id="txtMotivo"  validate="[O]" name="informeOrientacion" class="" maxlength="999" style="width:475px;text-transform:uppercase"></textArea>
		           				   </div>
	                 			   <div class="filaForm">
		           				   			<div class="lble"><label id="lblNotificacion">% Notificación <span id="alertaNoti">(*)</span> : </label></div>
                                            <input id="txtNotificacion" name="notificacion" validate="[O]" type="text" maxlength="3" style="width:475px;text-transform:uppercase" value="" />
                     						
		           				   </div>
	           				   	   <div class="filaForm">
	           				   	   			<div><span id="mensajeNoti"></span> </div>
	           				   	   			<span id="mensajeNoti"></span> 
	           				   	   </div>
		 </form>
        
        <div id="gridContenedorEtapas" class="content-grilla"></div>
		<div id="gridContenedorSubEtapas" class="content-grilla"></div>
        
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <seg:botonTag code="IN" value="Guardar" id="btnGuardarConfigEtapa" title="Guardar" styleClass="btn_a btn_small" onclick=""/>
            <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        
        <!-- dialogs -->
    </body>
</html>
      