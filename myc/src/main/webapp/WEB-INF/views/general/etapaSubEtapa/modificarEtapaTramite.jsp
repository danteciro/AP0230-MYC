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
       <script type="text/javascript" src='<c:url value="/javascript/app/general/etapaSubEtapa/modificarEtapaTramite.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantEditarEtapa" class="">
            <div id="divMensajeMantEditarEtapa" class="errorMensaje" tabindex='1' style="display: none;" ></div>
                                  
                                  <input type="hidden" id="idEtapaEdit" value="${idEtapaVal}" >
                                  <div class="filaForm">
									    <div class="lblc" ><label for="idInforGeneralMod">Información General de Trámite:</label></div>
									    <input id="idInforGeneralMod" name="notificacion" validate="[O]" type="text" style="width:400px;text-transform:uppercase" value="${etapaTramite.idConfTramite.idTramite.descripcion}" />
									    
									    <input type="hidden" value="${etapaTramite.idConfTramite.idConfTramite}"  id="idConfTramite"/>
									    
									    <div style="float:right">
											<input id="btnModConfiguracion_modificarEtapaTramite" class="btn_a btn_small" type="button" title="Nueva SubEtapa" name="" value="Editar">
										</div>
	                              </div>
								  <div class="filaForm">
										<div class="lblc" ><label for="idProcesoMod">Proceso :</label></div>
	                                    <select id="cmbProceso" name="idcmbProceso" validate="[O]" disabled="disabled" style="width:275px">
	                                            <option value="">--Seleccione--</option>
							                 	<c:forEach items="${listaProceso}" var="pro">
							                 		<option value='${pro.idProceso}' <c:if test="${(pro.descripcion==proceso)}">selected</c:if>> ${pro.descripcion}</option>
							                 	</c:forEach> 
	                                    </select>
                     			  
								  </div>
								  <div class="filaForm">
										<div class="lblc" ><label for="idEtapaMod">Etapa (*) :</label></div>
	                                    <input id="idEtapaMod" name="notificacion" validate="[O]" type="text" maxlength="100" style="width:250px;text-transform:uppercase" value="${etapaTramite.idEtapa.descripcion}" />	                                    	                                    
								  </div>
								  <div class="filaForm">
	                                    <div class="lblc" ><label for="idPlazoMod">Plazo (*) :</label></div>
	                                    <input id="idPlazoMod" name="notificacion" validate="[O]" type="text" maxlength="2" style="width:250px;text-transform:uppercase" value="${etapaTramite.idEtapa.plazo}" />                     			  
								  </div>
								  <div class="filaForm">
								   		<div class="lble" ><label for="idSubEtapaMod">SubEtapas :</label></div>
		           				   </div>
		           				   <div>
		           				  		 <div style="float:right">
											<input id="btnNuevaSubEtapa_modificarEtapaTramite" class="btn_a btn_small" type="button" title="Nueva SubEtapa" name="" value="Nuevo">
										</div>
									</div>
										<br><br>
								  
			  						   <div id="gridContenedorSubEtapasModificar" class="content-grilla"></div>        	       				      
        	       				    
        	       				        
	        	       				   <div id="divMenuMantSubEtapa"></div>
			                    	   <div id="divTagEnlacesMantSubEtapas" style="display:none;">
											<div id="divEnlaceTagVerMantSubEtapa">
											    <span class="pui-menuitem-icon ui-icon ui-icon-search"></span>
									            <seg:enlaceTag id="linkVerMantSubEtapa" code="CO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
									            <span>Consultar</span>
											</div>
									       	<div id="divEnlaceTagEditarMantSubEtapa">
									       	    <span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
									            <seg:enlaceTag id="linkEditarMantSubEtapa" code="MO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
									            <span>Editar</span>
									       	</div>
									       	<div id="divEnlaceTagEliminarMantSubEtapa">
									       	    <span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
									            <seg:enlaceTag id="linkEliminarMantSubEtapa" code="EL" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
									            <span>Eliminar</span>
											</div>
										</div> 
									
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <seg:botonTag code="IN" value="Guardar" id="btnGuardarEtapa_modificarEtapaTramite" title="Guardar" styleClass="btn_a btn_small" onclick=""/>
            <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        
        <!-- dialogs -->
      
    </body>
</html>
      