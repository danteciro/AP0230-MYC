<%-- 
    Document   : frmMantRequisito
    Created on : 21/08/2014, 03:42:43 PM
    Author     : jpiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/tipoSancion/mantFrmTipoSancion.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantTipoSancion" class="tac">  
            <div id="divMensajeValidaTipoSancion" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <input id="txtIdTipoSancion" name="idTipoSancion" type="hidden" />
            <fieldset>
                <div class="form">
                    <div class="filaForm">
                        <div class="lblc vat"><label for="txtDescTipoSancNuevo">DESCRIPCIÓN(*):</label></div>  
                        <div>
                            <input id="txtDescTipoSanc" name="descripcion" type="text" maxlength="80" class="inputPeque" validate="[O]" />
                        </div>
                    </div>    
                </div>
            </fieldset>
            
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <input id="btnBuscarTipoSanc" class="btn_a btn_small" type="button" value="Buscar" title="Buscar Tipo Sancion">
            <input id="btnGuardarTipoSanc" class="btn_a btn_small" type="button" value="Guardar" title="Guardar Tipo Sancion">
            <input id="btnCancelarTipoSanc" class="btn_a btn_small" type="button" value="Limpiar" title="Limpiar" style="display:none;">
            <input id="btnEditarTipoSanc" class="btn_a btn_small" type="button" value="Editar" title="Editar Tipo Sancion" style="display:none;">
            <input class="btnCloseDialog btn_a btn_small" type="button" value="Cerrar" title="Cerrar">
        </div>
        <div class="tac">
            <div class="gridMargin ilb">
                <div id="gridContenedorTipoSanc"></div>
                <div id="divContextMenuTipoSanc"></div>
            </div>
        </div>
    </body>
</html>