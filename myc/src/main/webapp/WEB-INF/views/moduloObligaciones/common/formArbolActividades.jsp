<%-- 
    Document   : formArbolActividades
    Created on : 26/08/2014, 07:57:05 PM
    Author     : gvillanueva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/moduloObligaciones/common/formArbolActividades.js" />' charset="utf-8"></script>
    </head>
    <body>
    <div id="dialogArbolActividades">
        <form id="formArbolActividades" >
            <fieldset>
                <legend>Arbol de Actividades</legend>
                <div id="divArbolActividades" style="height:250px;width:465px;">
                    <ul style="display: none;">
                        <li id='0' class='folder'>ACTIVIDADES
                            <ul style="display:none;">

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
                            </ul>
                        </li>
                    </ul>
                </div>
            </fieldset>

                
        </form>
        <div id="botonesDerecha">
                    <button id="botoSeleccionarArbolActividades" class="" title="Seleccionar Actividades">Seleccionar</button>
                </div>
        <input id="listActividades" hidden="true"/>
    </div>    
    </body>
</html>
