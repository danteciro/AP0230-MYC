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
       <script type="text/javascript" src='<c:url value="/javascript/app/general/etapaSubEtapa/nuevaEtapa.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmNuevaEtapa" class="">
            <div id="divMensajeNuevaEtapa" class="errorMensaje" tabindex='1' style="display: none;" ></div>
          							<div class="filaForm">
	                                    <div class="lble" ><label for="cmbSector">Proceso :</label></div>
	                                    <div>
	                                    	 <select id="cmbProcesoEtapa" name="idcmbProceso" validate="[O]" disabled="disabled" class="lble">
	                                            <option value="">--Seleccione--</option>
							                 	<c:forEach items="${listaProcesoEtapa}" var="pro">
							                 		<option value='${pro.idProceso}' <c:if test="${(pro.descripcion==procesoEtapa)}">selected</c:if>> ${pro.descripcion}</option>
							                 	</c:forEach> 
	                                        </select>
                     					 </div>
	                                </div>
	                                <div class="filaForm">
	                                 		<div class="lble"><label> Descripcion (*) :</label></div>
                                    		<input id="descripcionEtapa" name="descripcion" validate="[O]" type="text" maxlength="100" style="width:300px;text-transform:uppercase" value="" />
                     				</div>
	                 			   <div class="filaForm">
		           				   			<div class="lble"><label> Plazo (*) :</label></div>
                                            <input id="plazoEtapa" name="plazo" validate="[O]" type="text" maxlength="2" style="width:300px;text-transform:uppercase" value="" />
                     				</div>
		           				   
		           				  
            
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <seg:botonTag code="IN" value="Guardar" id="btnRegistrarEtapa" title="Guardar" styleClass="btn_a btn_small" onclick=""/>
            <button  title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        
    </body>
</html>
      