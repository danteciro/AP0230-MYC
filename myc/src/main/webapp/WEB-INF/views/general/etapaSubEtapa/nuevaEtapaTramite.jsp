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
       <script type="text/javascript" src='<c:url value="/javascript/app/general/etapaSubEtapa/nuevaEtapaTramite.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantEtapaTramite" class="">
        	<input type="hidden" id="codigoConfiguracionTramite" />
            <div id="divMensajeMantEtapaTramite" class="errorMensaje" tabindex='1' style="display: none;" ></div>
          							<div class="filaForm">
	                                    <div class="lble" ><label for="cmbConfiguracion">Información General de Trámite</label></div>
	                                    <div style="float:right">
											<input id="btnNuevaConfig_etapaTramite" class="btn_a btn_small" type="button" title="Nuevo" name="" value="Nuevo">
										</div>
	                                </div>
	                                <div>
		                                <div class="filaForm" >
		                                </div>
	                                	 <div id="gridContenedorConfiguracion" class="content-grilla"></div>  
		           				   	</div>    
		           				   	
<!-- 	                                <div class="filaForm"> -->
<!-- 	                                    <div class="lble" ><label for="cmbSector">Proceso :</label></div> -->
<!-- 	                                    <div> -->
<!-- 	                                    	 <select id="cmbProceso" name="idcmbProceso" validate="[O]" disabled="disabled" class="lble"> -->
<!-- 	                                            <option value="">--Seleccione--</option> -->
<%-- 							                 	<c:forEach items="${listaProceso}" var="pro"> --%>
<%-- 							                 		<option value='${pro.idProceso}' <c:if test="${(pro.descripcion==proceso)}">selected</c:if>> ${pro.descripcion}</option> --%>
<%-- 							                 	</c:forEach>  --%>
<!-- 	                                        </select> -->
<!--                      					 </div> -->
<!-- 	                                </div> -->
	                                <div class="filaForm">
	                                  	<div class="lble" ><label>Etapa :</label></div>
	                                    <div style="float:right">
											<input id="btnNuevaEtapa_etapaTramite" class="btn_a btn_small" type="button" title="Nuevo" name="" value="Nuevo">
										</div>
	                                </div>
	                                 </br>    
	                                <div>
	                                	<div id="gridContenedorEtapas" class="content-grilla"></div> 
		           				   	</div>  
	                                <div class="filaForm">
	                                    <div class="lble"><label>SubtEtapa (*) :</label></div>
	                                    <div style="float:right">
											<input id="btnNuevaSubEtapa_etapaTramite" class="btn_a btn_small" type="button" title="Nuevo" name="" value="Nuevo">
										</div>
                                    </div>
                                    </br>
                                    <div>
                                    	<div id="gridContenedorSubEtapas" class="content-grilla"></div>
	                                </div>
	    </form>

<!-- 	   								 <div id="dialogMantenimiento" style="display:none;"></div> -->
	                                 
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <seg:botonTag code="IN" value="Guardar" id="btnGuardarEtapaTramite" title="Guardar" styleClass="btn_a btn_small" onclick=""/>
            <button  title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        
        
    </body>
</html>
      