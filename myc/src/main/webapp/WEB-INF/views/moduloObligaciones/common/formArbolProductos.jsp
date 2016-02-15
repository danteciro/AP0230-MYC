<%-- 
    Document   : formArbolActividades
    Created on : 28/08/2014, 07:57:05 AM
    Author     : gvillanueva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/moduloObligaciones/common/formArbolProductos.js" />' charset="utf-8"></script>
    </head>
    <body>
    <div id="dialogArbolProductos">
        <form id="formArbolProductos" >
            <fieldset>
                <legend>Arbol de Productos</legend>
                <div id="divArbolProductos" style="height:250px;width:465px;">
                    <ul style="display: none;">
                        <li id='0' class='folder'>PRODUCTOS
                            <ul style="display:none;">
                                <li id='1' class='folder'>Combustibles Líquidos
                                    <ul>
                                        <li id='2'>Gasol 84</li>
                                    </ul>
                                </li>
                                <li id='3' class='folder'>GLP
                                    <ul>
                                        <li id='4'>GLP 1</li>
                                        <li id='5'>GLP 2</li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </fieldset>
            
        </form>
        <div id="botonesDerecha">
                <button id="botoSeleccionarArbolProductos" class="" title="Seleccionar Actividades">Seleccionar</button>
        </div>
        <input id="listProductos" hidden="true"/>
    </div>
    </body>
</html>
