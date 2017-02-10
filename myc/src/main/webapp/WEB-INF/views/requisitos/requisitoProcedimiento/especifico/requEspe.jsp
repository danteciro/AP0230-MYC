<%-- 
    Document   : procedimiento
    Created on : 14/07/2014, 12:12:37 PM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript"
            src='<c:url value="/javascript/app/requisitos/requisitoProcedimiento/especifico/requEspe.js" />' charset="utf-8">
        </script>	
    </head>
    <body>
        <div class="pui-panel ui-widget-content" style="margin:0px 0px 5px 0px;">
            <h2 class="subtitle">
                <a href="#">REQUISITOS ESPECÍFICOS</a>
            </h2>
           
            <div style="margin:0px 20px;">
                <div class="filaForm">
                   
                  
                </div>
                <div class="filaForm">
                    <div class="lble vat"><label>PROCEDIMIENTO:</label></div>
                      <div class="ilb vat" style="width:85px;">${item}</div>
                    <div class="ilb vat" style="width:500px;">${procedimiento}</div>
                </div>
            </div>
           
            <div id="menuCircularEspe" class="tac">
                <div class="ilb vam">
                    <div class=" ilb vam">
                        <input type="checkbox" id="chkTramite" value="Tramite"><label class="checkbox" for="chkTramite"></label>
                    </div>
                    <label for="chkTramite">TRÁMITE</label><label for="chkTramite" class="icoCircular tramite ilb vam"></label>
                </div>
                <div class="ilb vam">
                    <div class=" ilb vam">
                        <input type="checkbox" id="chkActividad" value="Actividad"><label class="checkbox" for="chkActividad"></label>
                    </div>
                    <label for="chkActividad">RUBRO</label><label for="chkActividad" class="icoCircular actividad ilb vam"></label>
                </div>
                <div class="ilb vam">
                    <div class=" ilb vam">
                        <input type="checkbox" id="chkZonificacion" value="Zonificacion"><label class="checkbox" for="chkZonificacion"></label>
                    </div>
                    <label for="chkZonificacion">ZONIFICACIÓN</label><label for="chkZonificacion" class="icoCircular zonificacion ilb vam"></label>
                </div>
                <div class="ilb vam">
                    <div class=" ilb vam">
                        <input type="checkbox" id="chkOtros" value="Otros"><label class="checkbox" for="chkOtros"></label>
                    </div>
                    <label for="chkOtros">OTROS</label><label for="chkOtros" class="icoCircular otros ilb vam"></label>
                </div>
            </div>
            <div id="contenedorOpciones">
                <div id="contTramite" class="pui-subpanel ui-widget-content">
<!--                    <div class="pui-subpanel-subtitlebar">
                        <span class="ui-panel-title"> TRÁMITES</span>
                    </div>-->
                    <div class="pui-subpanel-content">
                        <div class="filaForm">
                            <div class="lblc">
                                <label for="cmbTramiteEspe">TRÁMITE:</label></div><div class="slcta">
                                <select id="cmbTramiteEspe" name="tramite">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listadoTramite}" var="t">
                                        <option value='${t.idTramite}'>${t.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="ilb" id="filaMotivoTramiteEspe" style="display:none;">
                                <div class="lblc">
                                    <label for="cmbMotivoTramiteEspe">MOTIVO:</label></div><div class="slcta">
                                    <select id="cmbMotivoTramiteEspe" name="tramite">
                                        <option value="">--Seleccione--</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                <div id="contActividad" class="pui-subpanel ui-widget-content">
<!--                    <div class="pui-subpanel-subtitlebar">
                        <span class="ui-panel-title"> RUBRO</span>
                    </div>-->
                    <div class="pui-subpanel-content">
                        <div class="filaForm">
                            <div class="lblc">
                                <label>RUBRO:</label></div><div class="lblc">
                                <input id="txtActivP1" onclick="abrirPopupBusqActividad()" type="text" style="cursor: pointer; width: 700px;" readonly placeholder="Click para seleccionar rubro"/>
                                <input id="txtIdActivP1" type="hidden" />
                            </div>
                            <div id="dialogBusqActividad" class="dialog" style="display:none;"></div>
                        </div>
                    </div>
                </div>
                <div id="contZonificacion" class="pui-subpanel ui-widget-content">
<!--                    <div class="pui-subpanel-subtitlebar">
                        <span class="ui-panel-title"> ZONIFICACIÓN</span>
                    </div>-->
                    <div class="pui-subpanel-content">
                        <div class="filaForm">
                            <div class="lblc">
                                <label for="cmbZonificacionEspe">ZONIFICACIÓN:</label></div><div class="slcta">
                                <select id="cmbZonificacionEspe">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listaZonificacion}" var="zon">
                                        <option value="${zon.idZonificacion}">${zon.nombre}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            
<!--                            <div class="lblc">
                                <label for="cmbDepartamentoEspe">DEPARTAMENTO:</label></div><div class="slcta">
                                <select id="cmbDepartamentoEspe">
                                    <option value="">--Seleccione--</option>
                                    <c:forEach items="${listaDepartamentos}" var="dep">
                                        <option value="${dep.idDepartamento}">${dep.nombre}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            
                            <div class="lblc">
                                <label for="cmbProvinciaEspe">PROVINCIA:</label></div><div class="slcta">
                                <select id="cmbProvinciaEspe" name="tramite">
                                    <option value="">--Seleccione--</option>
                                </select>
                            </div>
                            
                            <div class="lblc">
                                <label for="cmbDistritoEspe">DISTRITO:</label></div><div class="slcta">
                                <select id="cmbDistritoEspe" name="tramite">
                                    <option value="">--Seleccione--</option>
                                </select>
                            </div>
                        </div>
                        <div class="filaform" id="filaZonificacionEspe" style="">
                            <div class="lblc ilb"><label>ZONIFICACION:</label></div>
                            <div class="ilb" id="lblZonificacionEspe">
                                <input type="hidden" id="idZonificacionDetalleEspe" />
                                <span id="spnZonificacionDetalleEspe"><span style="color:#A4A4A4">--Sin Zonificacion--</span></span>
                            </div>
                        </div>-->
                        </div>
                    </div>
                </div>
                <div id="contOtros" class="pui-subpanel ui-widget-content">
                    <div class="pui-subpanel-subtitlebar">
                        <span class="ui-panel-title"> OTROS</span>
                    </div>
                    <div class="pui-subpanel-content">
                        <div class="filaForm" id="parametroDinamicosSeccionOtros">
<!--                        <div class="ilb">
                                <div class="lblc vam"><label for="cmbEtapa">ETAPA:</label></div>
                                <div class="slcta vam">
                                    <select id="cmbTramiteEspe" name="tramite">
                                        <option value="">--Seleccione--</option>
                                        <option value="PRIMERA">PRIMERA</option>
                                        <option value="SEGUNDA">SEGUNDA</option>
                                    </select>
                                </div>
                            </div>
                            <div class="ilb">
                                <div class="lblc vam"><label for="cmbZona">ZONA:</label></div>
                                <div class="slcta vam">
                                    <select id="cmbTramiteEspe" name="tramite">
                                        <option value="">--Seleccione--</option>
                                        <option value="URBANA">URBANA</option>
                                        <option value="RURAL">RURAL</option>
                                    </select>
                                </div>
                            </div>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="botonesDerecha">
            <button title="Limpiar Opciones" id="btnLimpiarEspe">Limpiar</button>
            <seg:botonTag code="IN" value="Agregar Req." id="btnAgregarRequEspe" title="AGREGAR REQUISITO ESPECIFICO" styleClass="btn_a btn_small" onclick=""/>
<!--            <button id="btnAgregarRequEspe" title="AGREGAR REQUISITO ESPECIFICO">Agregar Req.</button>-->
        </div>
      
        <div class="pui-panel ui-widget-content">
            <div class="pui-panel-content ui-widget-content" style="overflow: auto;">
                <div id="tituEspeRequ" class="ui-panel-title">REQUISITOS ESPECÍFICOS</div>
                <div id="headRequEspe" class="tblRequ"></div>
                <div class="ui-widget-content ilb" style="min-width: 965px;overflow: auto; padding-right: 25px; max-height: 500px;">
                    <div id="espeRequ" class="tblRequ">
                        <ul id="sortableEspeRequ"></ul>
                    </div>
                </div>
            </div>
        </div>
                
    </body>
</html>
