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
        <script type="text/javascript" src='<c:url value="/javascript/app/registro/oficinaRegional/mantenimiento.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/app/registro/oficinaRegional/popupBusqResponsable.js" />' charset="utf-8"></script>
    </head>
    <body>
            <div style="min-width: 800px;">
            <div id="divMensajeValidaMacroRegion" class="errorMensaje" tabindex='1' style="display: none" ></div>
               <form id="frmMantMacroRegion">          
                    <fieldset>
                    <legend>Seleccion Macro Region</legend>
                    <div class="form">
                        <div class="filaForm">
                             <div class="lblc"><label>OMR:</label></div>
                             <div class="slcta vam">
	                            <select id="idCmbOmr" validate="[O]" >
	                                <option value="">--Seleccione--</option>
	                                <option value="3">OMR III</option>
	                            </select>
                        	</div>
                        	<div class="lblc"><label>Supervisor Regional:</label></div>
                        	<div>
	                            <input id="txtSupervisorReg"  type="text" maxlength="100" style="width: 250px;" disabled="disabled" />
	                            <button class="btnBuscar" onclick="abrirPopupBusqResponsable('txtSupervisorReg')" title="Buscar" src="" type="button">
	                            	<i class="icon-search"></i> 
		                        </button>
                        	</div>
                        </div>
                        <div class="filaForm">
                             <div class="lblc"></div>
                             <div class="slcta vam"></div>
                        	<div class="lblc"><label>Jefe Regional:</label></div>
                        	<div>
	                            <input id="txtJefeReg"  type="text" maxlength="100" style="width: 250px;" disabled="disabled" />
	                            <button class="btnBuscar" onclick="abrirPopupBusqResponsable('txtJefeReg')" title="Buscar" src="" type="button">
	                            	<i class="icon-search"></i> 
		                        </button>
                        	</div>
                        </div>                          	
                    </div>
                </fieldset>
                <fieldset>
	                <legend>Asignación de Departamentos</legend>
                	<div id="idRegistroRegiones">                
	              		  <div class="filaForm">
		              		  	<div class="lblc"><label>Departamento:</label></div>
	                             <div class="slcta vam">
		                            <select id="" validate="[O]" >
		                                <option value="">--Seleccione--</option>
		                                <option value="1">Amazonas</option>
		                                <option value="2">Ancash</option>
		                                <option value="3">Apurimac</option>
		                                <option value="4">Arequipa</option>
		                                <option value="5">Ayacucho</option>
		                                <option value="6">Cajamarca</option>
		                                <option value="7">Callao</option>
		                                <option value="8">Cusco</option>
		                                <option value="8">Huancavelica</option>
		                                <option value="8">Huanuco</option>
		                                <option value="8">Ica</option>
		                                <option value="8">Junin</option>
		                                <option value="8">La Libertad</option>
		                                <option value="8">Lambayeque</option>
		                                <option value="8">Lima</option>
		                                <option value="8">Loreto</option>
		                                <option value="8">Madre De Dios</option>
		                                <option value="8">Moquegua</option>
		                                <option value="8">Pasco</option>
		                                <option value="8">Piura</option>
		                                <option value="8">Puno</option>
		                                <option value="8">San Martin</option>
		                                <option value="8">Tacna</option>
		                                <option value="8">Tumbes</option>
		                                <option value="8">Ucayali</option>
		                            </select>
	                        	</div>
                                <div class="lblc"><label>Jefe Regional:</label></div>
                                <div>
	                            	<input id="txtResponsable"  type="text" maxlength="100" style="width: 250px;" disabled="disabled" />		                            	
	                            	<button class="btnBuscar" onclick="abrirPopupBusqResponsable('txtResponsable')" title="Buscar" src="" type="button">
	                            		<i class="icon-search"></i> 
	                            	</button>
                          		   </div>              
		                    </div>
	              </div>	                
	             
                    <div id="botones"  >
		              	<button title="Agregar" id="btnAgregarMacroRegion" >Agregar</button>
		            </div>
		            
	              <div class="gridMargin" align="center">
		                <div id="gridContenedorRegion"></div>
		                <div id="divContextMenuRegion"></div>
		            </div>
                </fieldset>
                </form>
                     
		        <div id="obligatorio">(*) Campos obligatorios</div>
		        <div id="botones">
		            <button id="btnGuardarMacroRegion" title="Guardar">Guardar</button>
		            <button id="btnEditarMacroRegion" title="Editar" style="display:none;">Editar</button>
		            <button title="Cerrar" class="btnCloseDialog" id="btnCloseMacroRegion">Cerrar</button>
		        </div>

		            
	     </div >
        
        <!-- dialogs -->
        <div id="dialogBusqResponsable" class="dialog"  style="display:none;">
        
          <table  width="100%">
	                 <tr>
	               		<td><label>Codigo</label></td>
	               		<td><input id="txtCodigo" type="text" style="width: 80%"/></td>
	               		<td><label>Usuario</label></td>
	               		<td><input id="txtUsuario" type="text" style="width: 80%"/></td>
	               </tr>
	               <tr>
	               		<td><label>Nombres Completos:</label></td>
	               		<td colspan="3"><input id="txtDirOperBusqResp" type="text" style="width: 91.5%"/></td>
	               </tr>
	               <tr>
                    	<td colspan="4">
                    		<br/>
                    		<div align="center">
		                    	<button id="btnBuscarBusqResp" title="Buscar" type="button">Buscar</button>
		                    	<button id="btnLimpiarBusqResp" title="Limpiar" type="button">Limpiar</button>
		                    	<button id="btnCerrarBusqResp" title="Cerrar" type="button">Cerrar</button>
	                    	</div>
	                    	<br/>
                    	</td>
                    </tr>
	        	</table>
		        <div align="center" class="tableMargin">
						<div id="gridContenedorBusqResp"></div>
						<div id="divContextMenuBusqResp"></div><br/>
			    </div>
        
        
        </div>
        
        
       
    </body>
</html>