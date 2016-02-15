

<%@ include file="/common/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <script type="text/javascript" src='<c:url value="/javascript/app/registro/oficinaRegional/mantenimiento.js" />' charset="utf-8"></script>
        <script type="text/javascript" src='<c:url value="/javascript/app/registro/oficinaRegional/popupBusqResponsable.js" />' charset="utf-8"></script>	
    </head>
    <body>
	           <table  width="100%">
	                 <tr>
	                   
						<td align="right"><label>Tipo de Documento:</label></td>
	                    <td>
	               			<select id="cmbDistrBusqUni">
	                          <option value="0">--Seleccione--</option>
	                          <option value="1">DNI</option>  
	                          <option value="1">CE</option>  
	                                                     
	                       	</select>
						</td>
						<td><label>Nro de Documento</label></td>
	               		<td ><input id="txtRazSocBusqUni" type="text" style="width: 80%"/></td>
	               		<td><label>Codigo</label></td>
	               		<td colspan="5"><input id="txtCodigo" type="text" style="width: 80%"/></td>
	               </tr>
	                
	                <tr>
	               		<td><label>Apellido Paterno</label></td>
	               		<td ><input id="txtRazSocBusqUni" type="text" style="width: 80%"/></td>
	               		<td><label>Apellido Materno</label></td>
	               		<td ><input id="txtRazSocBusqUni" type="text" style="width: 80%"/></td>
	               		<td><label>Nombre</label></td>
	               		<td ><input id="txtRazSocBusqUni" type="text" style="width: 80%"/></td>
	               </tr>	               
	            
	               <tr>
	               		<td><label>Nombres Completos:</label></td>
	               		<td colspan="3"><input id="txtDirOperBusqResp" type="text" style="width: 80%"/></td>
	               
	                   
						<td align="right"><label>Genero:</label></td>
	                    <td >
	               			<select id="cmbGeneroBusqResp">
	                          <option value="0">--Seleccione--</option>
	                          <option value="1">Masculino</option>  
	                            <option value="1">Femenino</option>                               
	                       	</select>
						</td>
	               </tr>
	               <tr>
                    	<td colspan="6">
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
    </body>
</html>