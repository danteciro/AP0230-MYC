<%-- 
    Document   : zonificacionDetalle
    Created on : 30/12/2014, 04:01:12 PM
    Author     : lbarboza
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Zonificacion Detalle" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/general/mantenimiento/zonificacionDetalle.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="form_registro">
            <div class="container">
                <div class="pui-panel ui-widget-content">
                    <div class="pui-panel-titlebar ui-corner-all">
                        <span class="ui-panel-title"> BÚSQUEDA DETALLE ZONIFICACI&Oacute;N</span>
                    </div>
                    <div class="pui-panel-content ui-widget-content">
                        <fieldset>
                            <div class="tac">
                                <div class="form">
                                    <div class="filaForm">
                                        <div class="lble"><label for="cmbZonificacionesBusq">NOMBRE ZONIFICACIÓN:</label></div>
                                        <div>
                                            <select id="cmbZonificacionesBusq" name="idAmbitoParametrico.idMaestroColumna" validate="[O]">
                                                
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="botones">
<!--                                 <button id="btnBuscarZoniDeta" title="Buscar Zonificación Detalle" class="btnSimple">Buscar</button> -->
                                <seg:botonTag code="CO" value="Buscar" styleClass="btn_a btn_small" id="btnBuscarZoniDeta" title="Buscar Zonificación Detalle" onclick=""/>
                                <button id="btnLimpiarBuscarZoniDeta" title="Limpiar" class="btnSimple">Limpiar</button>
                            </div>
                        </fieldset>
                        <div id="botonesDerecha">
<!--                             <button id="btnNuevoZoniDeta" title="Nuevo Detalle Zonificación">Nuevo</button>  -->
                            <seg:botonTag code="IN" value="Nuevo" styleClass="btn_a btn_small" id="btnNuevoZoniDeta" title="Nuevo Detalle Zonificación" onclick=""/>
                        </div>
                        <div class="gridMargin">
                            <div id="gridContenedorZonificacionDetalle"></div>
                            <div id="divContextMenuZonificacionDetalle"></div>
                        </div>
            			<!-- PR0013 - Inicio -->                           
			            <div id="divTagEnlacesZonifiDet" style="display:none">
							<div id="divEnlaceTagEditarZonifiDet">
								<span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
								<seg:enlaceTag id='linkEditarZonificacionDetalle' code='MO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Editar</span>
							</div>
							<div id="divEnlaceTagEliminarZonifiDet">
								<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
								<seg:enlaceTag id='linkEliminarZonificacionDetalle' code='EL' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
								<span>Eliminar</span>
							</div>
						</div>
						<!-- PR0013 - Fin -->
                    </div>
                </div>
            </div>
        </div>
        <!-- dialogs -->
        <div id="dialogMantZonificacionDetalle" class="dialog"  title="Mantenimiento Detalle Zonificación" style="display:none;">
            <form id="frmMantZonificacionDetalle" >
                <div id="divMensajeValidaZonificacionDetalle" class="errorMensaje" tabindex='1' style="display: none" ></div>
                <input id="txtIdZonificacionDetalle" name="idZonificacionDetalle" type="hidden"/>
                <div class="form">
                    <div class="filaForm">
                        <div class="lble"><label for="cmbZonificaciones">&nbsp;&nbsp;&nbsp; ZONIFICACIÓN(*):</label></div>
                        <div>&nbsp;&nbsp;&nbsp;&nbsp;
                            <select id="cmbZonificaciones" validate="[O]">

                            </select>
                        </div>
                        <div>&nbsp;&nbsp;
                            <seg:botonTag code="IN" value="Agregar" styleClass="btn_a btn_small" id="btnNuevoZoni" title="Agregar Zonificación" onclick=""/>
<!--                             <input id="btnNuevoZoni" class="btn_a btn_small" type="button" value="Agregar" title="Agregar Zonificación"> -->
                        </div>
                    </div>
                    &nbsp;
                    <fieldset>
                        <div class="filaForm">
                            <div class="lble"><label for="cmbDepartamento">DEPARTAMENTO(*):</label></div>
                            <div>
                                <select id="cmbDepartamento" name="idDepartamento" validate="[O]">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listaDepartamentos}" var="dep">
                                        <option value="${dep.idDepartamento}">${dep.nombre}</option>
                                    </c:forEach> 
                                </select>
                            </div>
<!--                        </div>
                        <div class="filaForm">-->
                            <div class="lble"><label for="cmbProvincias">PROVINCIA(*):</label></div>
                            <div>
                                <select id="cmbProvincias" name="idProvincia" validate="[O]">
                                    <option value="">--Seleccione--</option>
                                </select>
                            </div>
						</div>
                        <div class="filaForm">
                            <div class="lble"><label for="lblDistrito">DISTRITO(*):</label></div>
<!--                             <div>
                                <select id="cmbDistritos" name="idDistrito" validate="[O]">
                                    <option value="">--Seleccione--</option>
                                </select> 
                            </div>-->
                             <div >
                                 <input id="txtDistrP1" onclick="abrirPopupBusqDistrito()" type="text" style="cursor: pointer; width: 488px;" readonly placeholder="Click para seleccionar Distrito"/>
                                  <input id="txtIdDistrP1" type="hidden" />
                                  <input id="txtJsonDistrP1" type="hidden" />
                                  
                             </div>
                              <div id="dialogBusqDistrito" class="dialog" style="display:none;"></div>
                        </div>
                    </fieldset>
                </div>
            </form>
            <div id="obligatorio">(*) Campos obligatorios</div>
            <div id="botones">
<!--                        <button id="btnAgregarZoniDeta" title="Agregar Detalle Zonificación">Agregar</button> -->
               <input id="btnAgregarZoniDeta" class="btn_a btn_small" type="button" value="Guardar" title="Guardar Detalle Zonificación">
               <!--seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnAgregarZoniDeta" title="Agregar Detalle Zonificación" onclick=""/-->
               <input class="btnCloseDialog btn_a btn_small" type="button" value="Cerrar" title="Cerrar">
            </div>
            <div class="gridMargin">
               <div id="gridContenedorZonificacionDetalleAgregar"></div>
               <div id="divContextMenuZonificacionDetalleAgregar"></div>
            </div>
        </div>
        
        <div id="dialogEditarZonificacionDetalle" class="dialog"  title="Mantenimiento Detalle Zonificación" style="display:none;">
            <form id="frmEditarZonificacionDetalle" class="tac">
                <div id="divMensajeValidaEditarZonificacionDetalle" class="errorMensaje" tabindex='1' style="display: none" ></div>
                <input id="txtIdZonificacionDetalleEditar" name="idZonificacionDetalle" type="hidden"/>
                <div class="form">
                    <div class="filaForm">
                        <div class="lble"><label for="cmbZonificaciones">&nbsp;ZONIFICACIÓN(*):</label></div>
                        <div>&nbsp;&nbsp;&nbsp;&nbsp;
                            <select id="cmbZonificacionesEditar" name="idZonificacion" validate="[O]">

                            </select>
                        </div>
                    </div>
                    &nbsp;
                    <fieldset>
                        <div class="filaForm">
                            <div class="lble"><label for="cmbZonificaciones">DEPARTAMENTO(*):</label></div>
                            <div>
                                <select id="cmbDepartamentoEditar" name="idDepartamento" validate="[O]">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listaDepartamentos}" var="dep">
                                        <option value="${dep.idDepartamento}">${dep.nombre}</option>
                                    </c:forEach> 
                                </select>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lble"><label for="cmbZonificaciones">PROVINCIA(*):</label></div>
                            <div>
                                <select id="cmbProvinciasEditar" name="idProvincia" validate="[O]">
                                    <option value="">--Seleccione--</option>
                                </select>
                            </div>
                        </div>
                        <div class="filaForm">
                            <div class="lble"><label for="cmbZonificaciones">DISTRITO(*):</label></div>
                            <div>
                                <select id="cmbDistritosEditar" name="idDistrito" validate="[O]">
                                    <option value="">--Seleccione--</option>
                                </select>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </form>
            <div id="obligatorio">(*) Campos obligatorios</div>
            <div id="botones">
<!--                 <button id="btnGuardarZoniDeta" title="Guardar Detalle Zonificación">Guardar</button> -->
                <!--seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarZoniDeta" title="Guardar Detalle Zonificación" onclick=""/-->
                 <button id="btnEditarZoniDeta" title="Editar Detalle Zonificación">Editar</button> 
                <!--seg:botonTag code="MO" value="Editar " styleClass="btn_a btn_small" id="btnEditarZoniDeta" title="Editar Detalle Zonificación" onclick=""/-->
                <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
            </div>
        </div>
        
        <div id="dialogMantZonificacion" class="dialog"  title="Mantenimiento Zonificación" style="display:none;">
            <form id="frmMantZonificacion" >
                <div id="divMensajeValidaZonificacion" class="errorMensaje" tabindex='1' style="display: none" ></div>
                <input id="txtIdZonificacion" name="idZonificacion" type="hidden"/>
                <input id="txtEstadoZonificacion" name="estado" type="hidden"/>
                <div class="filaForm">
                    <fieldset>
                        <div>
                            <div class="lble"><label for="txtNombreZonificacion">NOMBRE(*):</label></div>
                            <div>
                                <input id="txtIdZonificacion" type="hidden" />
                                <input id="txtModo" type="hidden" />
                                <input id="txtNombreZonificacion" name="nombre" type="text" validate="[O]" maxlength="38" class="inputPeque txtMayus" />
                            </div>
                        </div>
                    </fieldset>
                </div>
            </form>
            <div id="obligatorio">(*) Campos obligatorios</div>
            <div id="botones">
                <input id="btnBuscarZonificacion" class="btn_a btn_small" type="button" value="Buscar" title="Buscar Zonificación">
                <input id="btnAgregarZoni" class="btn_a btn_small" type="button" value="Guardar" title="Agregar Zonificación">
                <input id="btnLimpiarZoni" class="btn_a btn_small" type="button" value="Limpiar" title="Limpiar" style="display:none">
                <input id="btnEditarZoni" class="btn_a btn_small" type="button" value="Editar" title="Editar Zonificación" style="display:none">
                <!--seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnAgregarZoni" title="Agregar Detalle Zonificación" onclick=""/-->
                <input class="btnCloseDialog btn_a btn_small" type="button" value="Cerrar" title="Cerrar">
            </div>
            <div class="gridMargin">
                <div id="gridContenedorZonificacion"></div>
                <div id="divContextMenuZonificacion"></div>
                <!--<div id="gridContenedorZonificacionAgregar"></div>-->
                <!--<div id="divContextMenuZonificacionAgregar"></div>-->
            </div>
        </div>
        
        <div id="dialogConfirmacionZonificacionNuevo" class="dialog" style="display: none;" 
             title="Confirmaci&oacute;n">
            <p> <span class="ui-icon ui-icon-alert" id="icon"></span>
                <label id="lblConfirmacionZonificacion"></label>
            </p>
            <p>&nbsp;</p>
            <div id="botones"> 
                <button id="btnConfirmacionSiZonificacionNuevo" type="button"  class="btnSimple">Aceptar</button>
                <button id="btnConfirmacionNoZonificacionNuevo" type="button"  class="btnSimple">Cancelar</button>
            </div>
        </div>
        
        <div id="stack" class="ui-stack">
            <a id="btnRegresar" title="Regresar"></a>
        </div>
    </jsp:attribute>
</t:template>