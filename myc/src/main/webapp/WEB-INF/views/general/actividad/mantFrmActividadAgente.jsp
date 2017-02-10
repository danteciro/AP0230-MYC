<%-- 
* Resumen           
* Objeto            : mantFrmActividadAgente.jsp
* Descripción       : Diseño del mantenimiento de Actividades y Agentes MYC.
* Fecha de Creación : 28/06/2015.
* PR de Creación    : OSINE_SFS-600
* Autor             : Hernán Torres Sáenz.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/actividad/mantFrmActividadAgente.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantActividadAgente" class="tac">
            <div id="divMensajeValidaActividadAgente" class="errorMensaje" tabindex='1' style="display: none;" ></div>
            <fieldset >
                <div class="form" style="margin: 0 auto;">
                    <div class="filaForm">
                        <div class="lblc"><label for="txtActividad" style="margin-left:20%;">ACTIVIDAD:</label></div>
                        <div>
                            <input id="txtActividad" name="txtActividad" type="text" maxlength="100" style="width:350px;text-transform:uppercase;" />
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lblc"><label for="txtOrden" style="margin-left:20%;">ORDEN:</label></div>
                        <div>
                            <input id="txtOrden" name="txtOrden" type="text" maxlength="6" style="width:50px;" />
                        </div>
                    </div>
                </div>
                <div id="botones">
        			<seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarActividad" title="Buscar" onclick=""/>
        		</div>
            </fieldset>
        </form>
        
        <div id="botonesDerecha">
        	<seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevaActividad" title="Nuevo" onclick=""/>
        </div>
        <div class="gridMargin">
            <div id="gridContenedorActividad"></div>
            <div id="divContextMenuActividad"></div>
        </div>
        <div id="divTagEnlaces" style="display:none;">
	       	<div id="divEnlaceTagEditarActividad">
	            <span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
	            <seg:enlaceTag id="linkEditarActividad" code="MO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
	            <span>Editar</span>
	       	</div>
	       	<div id="divEnlaceTagEliminarActividad">
				<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
	            <seg:enlaceTag id="linkEliminarActividad" code="EL" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
	            <span>Eliminar</span>
			</div>
			<div id="divEnlaceTagAgregarAgente">
				<span class="pui-menuitem-icon ui-icon ui-icon-plus"></span>
	            <seg:enlaceTag id="linkAgregarAgente" code="CO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
	            <span>Agregar Agente</span>
			</div>
		</div>
    </body>
</html>