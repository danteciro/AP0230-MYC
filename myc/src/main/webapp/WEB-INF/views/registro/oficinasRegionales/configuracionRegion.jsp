<%-- 
    Document   : frmMantOficinaRegional
    Created on : 21/08/2014, 03:42:43 PM
    Author     : dmedrano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
         <script type="text/javascript" src='<c:url value="/javascript/app/registro/oficinaRegional/popupAsignacionUbigeo.js" />' charset="utf-8"></script>
         <script type="text/javascript" src='<c:url value="/javascript/app/registro/oficinaRegional/popupAsignacionOficina.js" />' charset="utf-8"></script>	
    </head>   
    <body>


	<div id="tabsob">
                 <ul>
                       <li><a href="#tabs-1">Ubigeo</a></li>
                       <li><a href="#tabs-2">Oficina</a></li>
                       
                 </ul>
                 <div id="tabs-1">
                  <div class="form" style="min-width: 760px;">
                    <fieldset>
                	<legend>Asignación de Ubigeo</legend>
                    
                    <div class="filaForm">
                           <div class="lblc"><label for="cmbDepartamento">Departamento:</label></div>
                           <div class="slcta vam">
                               <select id="cmbProcesoBusq" name="proceso">
                                   <option value="">--Seleccione--</option>
                                   <option value="" selected="selected">Cajamarca</option>
                                   <option value=""></option>
                                   <option value=""></option>
                               </select>
                           </div>
                            <div class="lblc"><label for="cmbProvincia">Provincia:</label></div>
                           <div class="slcta va">
                               <select id="cmbProcesoBusq" name="proceso">
                                   <option value="">--Seleccione--</option>
                                   <option value=""></option>
                                   <option value=""></option>
                                   <option value=""></option>
                               </select>
                           </div>
                            <div class="lblc"><label for="cmbDistrito">Distrito:</label></div>
                           <div class="slcta va">
                               <select id="cmbProcesoBusq" name="proceso">
                                   <option value="">--Seleccione--</option>
                                   <option value=""></option>
                                   <option value=""></option>
                                   <option value=""></option>
                               </select>
                           </div>
                                                      
                    </div>

		             </fieldset>   
		             <div class="filaForm">
                    <div id="botones"   >
		                <button title="Agregar" id="btnAgregarUbigeo">Agregar</button>
		            </div>
		            </div>
		            <div align="center"  class="gridMargin">
		                <div id="gridContenedorUbigeo"></div>
		                <div id="divContextMenuUbigeo"></div></br>
		            </div>
		            
		             <div id="botones">
			            <button id="btnGuardarUbigeo" title="Guardar">Guardar</button>
			            <button id="btnEditarUbigeo" title="Editar" style="display:none;">Editar</button>
			            <button title="Cerrar" class="btnCloseDialog" id="btnCloseUbigeo">Cerrar</button>
			        </div>
                 
                 
                 </div>
                 </div>
                 
                 <div id="tabs-2">
                    
                   <div class="form" style="min-width: 760px;">
                 	<fieldset>
                	<legend>Asignación de Oficina </legend>
                    <div class="filaForm"> 
                    	   <div class="lblc"><label for="cmbProvincia">Tipo:</label></div>
                           <div class="slcta va">
                               <select id="cmbProcesoBusq" name="proceso">
                                   <option value="">--Seleccione--</option>
                                   <option value="">REGIONAL</option>
                                   <option value="">DELEGADA</option>
                                   <option value="">DESCONCENTRADA</option>
                               </select>
                    </div>
                    </div>
                    <div class="filaForm">
                            <div class="lblc vat"><label>Nombre:</label></div>
                            <div>
                             <input id="txtBaseLegalBusq" name="baseLegal" type="text" maxlength="100" style="width: 465px;" />
                            </div>
                     </div>
                   
                   
                     <div class="filaForm">
                            <div class="lblc vat"><label>Dirección:</label></div>
                            <div>
                             <input id="txtBaseLegalBusq" name="baseLegal" type="text" maxlength="100" style="width: 465px;" />
                            </div>
                     </div>
                    
                   
                     <div class="filaForm">
                            <div class="lblc vat"><label>Telefono:</label></div>
                            <div>
                             <input id="txtBaseLegalBusq" name="baseLegal" type="text" maxlength="50" style="width: 250px;" />
                            </div>
                        </div>
                 
              	
                    <div class="filaForm">
                            <div class="lblc vat"><label>Fax:</label></div>
                            <div>
                             <input id="txtBaseLegalBusq" name="baseLegal" type="text" maxlength="50" style="width: 250px;" />
                            </div>
                     </div>                    
                   
		             </fieldset>  
		            <div class="filaForm">
                    <div id="botones"   >
		                <button title="Agregar">Agregar</button>
		            </div>
		            </div> 
		            <div align="center"  class="gridMargin">
		                <div id="gridContenedorOficina"></div>
		                <div id="divContextMenuOficina"></div></br>
		            </div>
		            
		              <div id="botones">
			            <button id="btnGuardarOficina" title="Guardar">Guardar</button>
			            <button id="btnEditarOficina" title="Editar" style="display:none;">Editar</button>
			            <button title="Cerrar" class="btnCloseDialog" id="btnCloseOficina">Cerrar</button>
			        </div>
                
                 </div>
                 </div>
	</div>                        
                        
                        
                        
   
    </body>
</html>                        