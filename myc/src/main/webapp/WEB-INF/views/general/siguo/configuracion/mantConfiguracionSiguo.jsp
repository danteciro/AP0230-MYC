<%-- 
    Document   : configuracionSiguo
    Created on : 23/08/2016, 17:17:16 PM
    Author     : gvillanueva

	Resumen.
	Objeto                :              configuracionSiguo.jsp
	Descripción           :              Pantalla de mantenimiento de los componentes - secciones.
	Fecha de Creación     :              23/08/2016
	Autor                 :              gvillanueva.
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	Modificaciones
	Motivo                                    Fecha                                   Nombre                              Descripción
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  OSINE_SFS-	                         23/08/2016                        Giancarlo Villanueva             PANTALLA: CONFIGURACION SIGUO
--%>
<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Configuracion del siguo" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/siguo/configuracion/configuracionSiguo.js" />' charset="utf-8"></script>
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
/*                 overflow:hidden; */
            }
    	</style>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">    	
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> CONFIGURACI&Oacute;N SIGUO</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                    	<div id="divMensajeValidacionConfiguracionSiguo" class="errorMensaje" tabindex='1' style="display: none" ></div>
                        <fieldset>
                            <div class="tac">
                                <div class="form">
                                <form id="frmConfiguracionSiguo">
	                                <div class="filaForm">
	                                    <div class="lble" ><label for="cmbGerencia">Gerencia:</label></div>
	                                    <div>
	                                        <select id="cmbGerencia" name="idGerencia" validate="[O]" class="lblxa">
	                                            <option value="">--Seleccione--</option>
							                    <c:forEach items="${listadoGerencia}" var="lts">
							                        <option value='${lts.idUnidadOrganica}'>${lts.descripcion}</option>
							                    </c:forEach>
	                                        </select>
	                                    </div>
	                                </div>
	                                <div class="filaForm">
	                                    <div class="lble" ><label for="cmbDivision">Divisi&oacute;n:</label></div>
	                                    <div>
	                                        <select id="cmbDivision" name="idDivision" validate="[O]" class="lblxa">
	                                            <option value="">--Seleccione--</option>
	                                        </select>
	                                    </div>
	                                </div>
	                                <div class="filaForm">
	                                    <div class="lble"><label for="txtActivP1">Actividad:</label></div>
                                        <div >
                                            <input id="txtActivP1"  style="width:325px;" onclick="abrirPopupBusqActividad()" type="text" style="cursor: pointer;" readonly placeholder="Click para seleccionar rubro"/>
                                            <input id="txtIdActivP1" type="hidden" />
                                        </div>
                                        <div id="dialogBusqActividad" class="dialog" style="display:none;"></div>
                                        <div id="dialogBusqActividadModal" class="dialog" style="display:none;"></div>
	                                </div>
	                                <div class="filaForm">
	                                    <div class="lble" ><label for="cmbComponente">Componente:</label></div>
	                                    <div>
	                                        <select id="cmbComponente" name="cmbComponente" validate="[O]" class="lblxa">
	                                            <option value="">--Seleccione--</option>
	                                            <c:forEach items="${listadoComponente}" var="ltra">
							                        <option value='${ltra.idModulo}'>${ltra.descripcion}</option>
							                    </c:forEach>
	                                        </select>
	                                    </div>
	                                </div> 
	                            </form>                                                                                                      
                                </div>
                            </div>
                            <div id="botones" style="margin-bottom:10px;"> 
                            	<seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscar" title="Buscar" onclick=""/>
                            	<seg:botonTag code="CO" value="Limpiar" styleClass="btn_a btn_small" id="btnLimpiar" title="Limpiar" onclick=""/>
                            </div>
                        </fieldset>      
                        <div id="botonesDerecha">
                        <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoModulo" title="Nuevo Modulo" onclick=""/>
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorModulo"></div>
                            <div id="divContextMenuModulo"></div>
                        </div>  
                        <div id="divTagEnlacesModulo" style="display:none">
							<div id="divEnlaceTagVerModulo">
								<span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
								<seg:enlaceTag id='linkVerModulo' code='CO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Ver</span>
							</div>
							<div id="divEnlaceTagEditarModulo">
								<span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
								<seg:enlaceTag id='linkEditarModulo' code='CO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Editar</span>
							</div>
							<div id="divEnlaceTagEliminarModulo">
								<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
								<seg:enlaceTag id='linkEliminarModulo' code='EL' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Eliminar</span>
							</div>
						</div>   
						<div id="dialogMantModulo" style="display:none;"></div>            
                    </div>
                </div>
            </div>
        </div>       
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>