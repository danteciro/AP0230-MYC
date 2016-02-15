<%--************************************************************************************
Modulo 			        :    Configuración de Actividades
Creado/Modificado por	:    Cristian Florian
Descripción 		    :    pagina que permite la asignacion de unidad fiscalizadora y scop a la actividad segun su tramite
Fecha y Hora	      	:    13/10/2014 
****************************************************************************************--%>
<%@ include file="/common/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
        <script type="text/javascript" src='<c:url value="/javascript/app/registro/actividad/popupAsignacion.js" />' charset="utf-8"></script>
    </head>
    <body>
       <fieldset>
       		<legend>Asignar Unidad Fiscalizadora - SCOP</legend> 
            <div>
	           <div id="gridContenedorAsigUnidFisScop"></div>
	        </div>	
	        <br/>
   			<div align="center">
    			<button id="btnGuardar" type="button" title="Guardar">Guardar</button>
    			<button id="btnCerrar" type="button" title="Cerrar">Cerrar</button>
   			</div>         
       </fieldset>
	</body>
</html>