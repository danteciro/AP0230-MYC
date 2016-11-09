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
* OSINE_SFS-1232 | 23/08/2016    |   Victor  Rojas              |     PANTALLA: CONFIGURACION ETAPAS Y SUBETAPAS
* OSINE_SFS-1232 | 03/11/2016    |   Luis García Reyna          |     CONFIGURACION ETAPAS Y SUBETAPAS - Validaciones
-->

<!--OSINE_SFS-1232 - lgarciar - Inicio -->
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Configuracion Etapa SubEtapa" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/etapaSubEtapa/mantenimientoEtapa.js" />' charset="utf-8"></script>      
        <style>
        .ui-jqgrid tr.jqgrow td {
                font-size: 12px !important;
                white-space: normal !important;
            } 
            .ui-jqgrid .ui-jqgrid-htable th div {
                font-size: 12px !important;
                text-transform: none;
                white-space:normal !important;
                position:relative;
                overflow:hidden;
            }
        </style>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div class="container pui-panel ui-widget-content">
            
            <div class="pui-panel-titlebar ui-corner-all">
                <span class="ui-panel-title"> CONFIGURACI&Oacute;N DE ETAPAS Y SUBETAPAS DE ATENCIÓN </span>
            </div>
            
            <div class="pui-panel-content ui-widget-content">
                
                <fieldset class='tac' style="margin: 10px 10px">
                    <div class="form">
                        <div class="filaForm">
                            <div class="ipt-small vam"><label>Gerencia :</label> </div>
                            <div>
                                <select id="cmbGerenciaEtapa" name="idGerencia" class="ipt-medium-small">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listaGerencia}" var="uni">
                                    <option value='${uni.idUnidadOrganica}'>${uni.descripcion}</option>
                                    </c:forEach> 
                                </select>
                            </div>

                            <div class="ipt-small vam" style="margin-left: 40px;"><label>Responsable :</label> </div>
                            <div>
                                <select id="cmbResponsable" name="idRes" class="ipt-medium-small">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listaResponsable}" var="res">
                                    <option value='${res.idMaestroColumna}'>${res.descripcion}</option>
                                    </c:forEach> 
                                </select>
                            </div>

                        </div>

                        <div class="filaForm">
                            <div class="ipt-small vam"><label>División :</label> </div>
                            <div>
                                <select id="cmbDivisionEtapa" name="idDivision" class="ipt-medium-small">
                                    <option value="">--Seleccione--</option>                             
                                </select>
                            </div>

                            <div class="ipt-small vam" style="margin-left: 40px;" ><label>Trámite :</label> </div>
                            <select  id="cmbTramiteEtapa" name="idTramite" validate="[O]" class="lblm">
                                <option value="">--Seleccione--</option>
                                <c:forEach items="${listaTramite}" var="tramite">
                                <option value='${tramite.idTramite}'>${tramite.descripcion}</option>
                                </c:forEach>
                            </select>

                        </div>

<!--                        <div class="filaForm">
                            <div class="ipt-small vam"><label>Sector :</label> </div>
                            <div>
                                <select id="cmbSectorEtapa" name="idSector" class="ipt-medium-small">
                                    <option value="">--Seleccione--</option>
                                </select>
                            </div>
                        </div>-->
                        <div class="filaForm">
                            <div class="ipt-small vam"><label>Actividad :</label> </div>
                            <div>
                                <select id="cmbActividadEtapa" name="idActividadEtapa" class="ipt-medium-small">
                                    <option value="">--Seleccione--</option>                           
                                </select>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="ipt-small vam"><label>Agente :</label> </div>
                            <div>
                                <select id="cmbAgenteEtapa" name="cmbAgente" class="ipt-medium-small">
                                    <option value="">--Seleccione--</option>                            
                                </select>
                            </div>
                        </div>
                    </div>

                    <div id="botones" style="margin: 20px 0px;">
                        <input type="button" id="btnBuscarEtapaTramite" title="Buscar" class="btn-azul btn-small" value="Buscar">
                        <input type="button" id="btnLimpiarEtapas" title="Limpiar" class="btn-azul btn-small" value="Limpiar">
                    </div>

                </fieldset>

                <div id="botonesDerecha" style="margin: 10px 25px;">
                    <input type="button" id="btnNuevaEtapaTramite_mantEtapa" title="Buscar" class="btn-azul btn-small" value="Nuevo">
                </div>

                <div class="gridMargin">
                    <div id="gridContenedorConsulta" class="content-grilla"></div> 
                    <div id="divContextMenuTipificacionSub"></div>
                </div>
                
                <div id="divMenuMantEtapa"></div>
                <div id="divTagEnlacesMantEtapas" style="display:none;">
                <div id="divEnlaceTagVerMantEtapa">
                    <span class="pui-menuitem-icon ui-icon ui-icon-search"></span>
                        <seg:enlaceTag id="linkVerMantEtapa" code="CO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
                    <span>Consultar</span>
                </div>
                <div id="divEnlaceTagEditarMantEtapa">
                    <span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
                        <seg:enlaceTag id="linkEditarMantEtapa" code="MO" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
                    <span>Editar</span>
                </div>
                <div id="divEnlaceTagEliminarMantEtapa">
                    <span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
                        <seg:enlaceTag id="linkEliminarMantEtapa" code="EL" enlace="" value="" onclick="" styleClass="a-ipt"></seg:enlaceTag>
                    <span>Eliminar</span>
                </div>
                </div>
                <!-- Dialogs - Inicio -->
                <div id="dialogEtapaTramiteSub" style="display:none;"></div>
                <div id="dialogModificarEtapaTramite" style="display:none;"></div>
                <div id="dialogModificarSubEtapa" style="display:none;"></div>
                <div id="dialogNuevaConfiguracionEtapa" style="display:none;"></div>
                <div id="dialogNuevaEtapaSub" style="display:none;"></div>
                <div id="dialogNuevaSubEtapaSub" style="display:none;"></div>
                <div id="dialogNuevaSubEtapaEtapaTramite" style="display:none;"></div>
                <div id="dialogModSubEtapaSub" style="display:none;"></div>
                <div id="dialogModificarConfiguracion" style="display:none;"></div>
                <!-- Dialogs - Fin -->
         </div>  
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
        
    </jsp:attribute>   
</t:template>
<!--OSINE_SFS-1232 - lgarciar - Fin -->