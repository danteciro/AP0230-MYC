<!--
* Resumen
* Objeto            : mantenimientoEtapas.jsp
* Descripción       : Pantalla de mantenimiento de Etapas y SubEtapas
* Fecha de Creación : 06/10/2016
* PR de Creación    : 
* Autor             : GMD
* =====================================================================================================================================================================
* Modificaciones |
* Motivo         |  Fecha        |   Nombre                     |     Descripción
* =====================================================================================================================================================================
* OSINE_SFS-1232 | 16/10/2016    |   Victor  Rojas              |     PANTALLA: CONFIGURACION ETAPAS Y SUBETAPAS
* OSINE_SFS-1232 | 03/11/2016    |   Luis García Reyna          |     CONFIGURACION ETAPAS Y SUBETAPAS - Validaciones
-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/etapaSubEtapa/modificarConfiguracion.js" />' charset="utf-8"></script>
    </head>
    
    <body>
        <input type="hidden" id="idConfTramite" value="${nombrePadre}">
        <div id="divMensajeValidaFrmConfEtapSubEtap" class="errorMensaje" style="display: none"></div>
        <div class="form" id='divFrmConfEtapSubEtap'>
            <div class="filaForm">
                <div class="lble vam"><label>Gerencia (*) :</label> </div>
                <div>
                    <input id="gerenciaMod"  style="width:450px;"   type="text" value="${unidadPadre}" disabled="disabled"/>
                </div>
            </div>
            <div class="filaForm">
                <div class="lble vam"><label>Divisi&oacute;n (*) :</label> </div>
                <div>
                    <input id="divisionMod"  style="width:450px;"   maxlength="50" type="text" value="${confTramite.idCnfActUniOrganica.idUnidadOrganica.descripcion}" disabled="disabled"/>
                </div>
            </div>
            <div class="filaForm">
                <div class="lble vam"><label>Sector (*) :</label> </div>
                <div>
                    <input id="sectorMod"  style="width:450px;"   maxlength="50" type="text" value="${sector}" disabled="disabled"/>
                </div>
            </div>
                <div class="filaForm">
                <div class="lble vam"><label>Actividad (*) :</label> </div>
                <div>
                    <input id="actividadMod"  style="width:450px;"   maxlength="50" type="text" value="${actividadPadre}" disabled="disabled"/>
                </div>
            </div>
            <div class="filaForm">
                <div class="lble vam"><label>Agente (*) :</label> </div>
                <div>
                    <input id="agenteMod"   style="width:450px;"    maxlength="50" type="text" value="${confTramite.idCnfActUniOrganica.idActividad.nombre}" disabled="disabled"/>
                </div>
            </div>
            <div class="filaForm">
                <div class="lble vam"><label>Trámite (*) :</label> </div>
                <div>
                    <input id="tramiteMod"   style="width:450px;"   maxlength="50" type="text" value="${confTramite.idTramite.descripcion}" disabled="disabled"/>
                </div>
            </div>
            <div class="filaForm">
                <div class="lble vam" style="padding: 10px 0px 10px 2px"><label>Informe de orientación (*) :</label></div>
                <div>
                    <textarea id="orientacionMod" validate="[O]" rows="3"  style="width:450px;"  maxlength="1000">${confTramite.orientacion}</textarea>  
                </div>
            </div>
            <div class="filaForm">
                <div class="lble vam"><label>Notificación (*) :</label></div>
                <div>
                    <input id="notificacionMod" validate="[O]" rows="3" style="width:450px;"  maxlength="3" type="text" value="${confTramite.porcentajeNotificacion}"/> 
                </div>
            </div>
            <div class="filaForm">
                <div><span id="mensajeValorNotificacion"></span> </div>
                <span id="mensajeValorNotificacion"></span> 
            </div>              
        </div>
                
        <div id="botones" style="margin: 20px 0px;">
            <input type="button" id="btnGuardarEditarConfig" title="Agregar Guardar" class="btn-azul btn-small" value="Guardar">
            <input type="button" title="Cerrar" class="btnCloseDialog btn-azul btn-small" value="Cerrar">
        </div>
                
        <div class="txt-obligatorio">(*) Campos obligatorios</div>
                
    </body>
    
</html>
      