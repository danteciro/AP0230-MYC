<%--************************************************************************************
Modulo 			        :    Configuración de Actividades
Creado/Modificado por	:    Cristian Florian
Descripción 		    :    pagina que permite el listado de Actividades y su configuración.
Fecha y Hora	      	:    10/10/2014 
****************************************************************************************--%>
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Configuración de Actividades" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/registro/actividad/listado.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">    
    
    <div class="pui-panel ui-widget-content">
	    <div class="pui-panel-titlebar ui-corner-all">
	        <span class="ui-panel-title">CONFIGURACION DE ACTIVIDADES</span>
	    </div>
	    <br/>
	    <div >
           <div id="gridContenedorBusqActividad"></div>
           <div id="divContextMenuBusqActividad"></div>
        </div>
    </div>
    
	<div id="dialogAsigUnidFisScop" class="dialog"></div>
	    
    <div id="stack" class="ui-stack">
        <a id="btnRegresar" title="Regresar"></a>
    </div>
    </jsp:attribute>
</t:template>
