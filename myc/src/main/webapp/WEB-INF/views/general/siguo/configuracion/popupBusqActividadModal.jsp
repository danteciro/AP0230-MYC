<%-- 
    Document   : actividades
    Created on : 17/10/2014, 12:12:37 PM
    Author     : dmedrano
--%>

<%@ include file="/common/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
     <script type="text/javascript" src='<c:url value="/javascript/app/general/siguo/configuracion/popupBusqActividadModal.js" />' charset="utf-8"></script>
    </head>
    <body>
<!--    <form id="frmBusqActividad">-->
        <input type="hidden" id="idProcedimientoActModal" value="${idProcedimientoAct}">
        <input type="hidden" id="idTramiteActModal" value="${idTramiteAct}">
     
			     <div class="pui-panel-content" >
                        <div class="filaFormMarg">
                            <input type="hidden" id="idActividadesSelecEspeModal"/>
                            <div id="arbolActividadesEspeModal" style="height:300px;width:700px;" seleccion="${seleccion}">
<!--                                <ul style="display: none;">
                                    <li id='1' class='folder'>REFINERIA
                                    <ul>
                                        <li id='2'>Refineria Complejas</li>
                                        <li id='3'>Refinería Topping</li>
                                    </ul>
                                    </li>
                                    <li id='4' class='folder'>Planta de Procesamiento
                                        <ul>
                                            <li id='5'>Procesamiento Gas</li>
                                            <li id='6'>Procesamiento LGN</li>
                                        </ul>
                                    </li>
                                    <li id='7' class='folder'>Planta de Lubricante
                                        <ul>
                                            <li id='8'>Planta de Lubricante y Grasas</li>
                                        </ul>
                                    </li>
                                    <li id='9' class='folder'>Planta de Abastecimiento
                                        <ul>
                                            <li id='10'>Plantas de Abastecimiento de Combustible Líquido y OPDH</li>
                                            <li id='11'>Plantas de Abastecimiento de GLP</li>
                                            <li id='12'>Plantas de Abastecimiento de Aeropuerto</li>
                                        </ul>
                                    </li>
                                    <li id='13' class='folder'>Planta Envasadora
                                        <ul>
                                            <li id='14'>Planta Envasadora de GLP</li>
                                        </ul>
                                    </li>
                                    <li id='15' class='folder'>Terminales
                                        <ul>
                                            <li id='16'>Terminales Combustibles Líquidos
                                            <li id='17'>Terminales Fluviales</li>
                                            <li id='18'>Terminales GLP</li>
                                            <li id='19'>Terminales Maritimos</li>
                                            <li id='20'>Terminales OPDH</li>
                                        </ul>
                                    </li>
                                    <li id="21" class='folder'>Consumidor Directo
                                        <ul>
                                            <li id="22">Consumidor Directo con Instalaciones Estartégicas de  Combustibles Líquidos y OPDH</li>
                                            <li id="23">Consumidor Directo con Instalaciones Estartégicas Temporales de  Combustibles Líquidos y OPDH</li>
                                            <li id="24">Consumidor Directo de Aviación (Fijo y Movil)</li>
                                            <li id="25">Consumidor Directo de Combustible Líquido con capacidad de 5MB a 50MB</li>
                                            <li id="26">Consumidor Directo de Combustible Líquido con capacidad hasta 5MB</li>
                                            <li id="27">Consumidor Directo de Combustible Líquido con capacidad mayor a 50MB</li>
                                            <li id="28">Consumidor Directo de Combustible Líquido y OPDH  con capacidad hasta 5 MB</li>
                                            <li id="29">Consumidor Directo de OPDH</li>
                                            <li id="30">Consumidor Directo de Petróleo (Fijo y Movil)</li>
                                            <li id="31">Consumidor Directo Especial de Combustible Líquido y OPDH</li>
                                            <li id="32">Consumidor Directo Estratégico</li>
                                            <li id="33">Consumidor Directo Móvil de Combustible Líquido y OPDH</li>
                                        </ul>
                                    </li>
                                </ul>-->
                            </div>
                        </div>
                    </div>
                    
	                 
            <br/>
            <div align="center">
                <button id="btnSeleccionarActModal" title="Seleccionar" type="button">Seleccionar</button>
            </div>
<!--        </form>  -->
</body>                    