<%-- 
* Resumen           
* Objeto            : mantFrmBusqAgente.jsp
* Descripción       : Diseño de la busqueda y mantenimiento de Agentes MYC.
* Fecha de Creación	: 06/07/2016.
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
        <script type="text/javascript" src='<c:url value="/javascript/app/general/actividad/mantFrmBusqAgente.js" />' charset="utf-8"></script>
    </head>
    <body>
    	<input id="idActividadPadre" name="idActividadPadre" type="hidden" value="${a.idActividad}"/>
        <form id="frmMantBusqAgente" class="tac">
            <div id="divMensajeValidaBusqAgente" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <fieldset >
                <div class="form">
                    <div class="filaForm">
                        <div class="lblc"><label for="txtActividadBusq" style="margin-left:20%;">ACTIVIDAD:</label></div>
                        <div>
                            <input id="txtActividadBusq" name="txtActividadBusq" type="text" maxlength="100" style="width:350px;text-transform:uppercase" value="${a.nombre}" disabled/>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lblc"><label for="txtAgente" style="margin-left:20%;">AGENTE:</label></div>
                        <div>
                            <input id="txtAgente" name="txtAgente" type="text" maxlength="100" validate="[O]" style="width:350px;text-transform:uppercase" />
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lblc"><label for="txtAgenteOrden" style="margin-left:20%;">ORDEN:</label></div>
                        <div>
                            <input id="txtAgenteOrden" name="txtAgenteOrden" validate="[O]" type="text" maxlength="6" style="width:50px;" />
                        </div>
                    </div>
                </div>
                <div id="botones">
        			<seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarAgente" title="Buscar" onclick=""/>
        		</div>
            </fieldset>
        </form>        
        <div id="botonesDerecha">
        	<seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoAgente" title="Nuevo" onclick=""/>
        </div>
        <div class="gridMargin">
            <div id="gridContenedorAgente"></div>
            <div id="divContextMenuAgente"></div>
        </div>
        <div id="divTagEnlaces" style="display:none;">
	       	<div id="divEnlaceTagEditarAgente">
	            <span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
	            <seg:enlaceTag id="linkEditarAgente" code="MO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
	            <span>Editar</span>
	       	</div>
	       	<div id="divEnlaceTagEliminarAgente">
				<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
	            <seg:enlaceTag id="linkEliminarAgente" code="EL" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
	            <span>Eliminar</span>
			</div>
		</div>
    </body>
</html>