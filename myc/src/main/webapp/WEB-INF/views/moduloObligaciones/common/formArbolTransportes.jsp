<%-- 
    Document   : formArbolTransportes
    Created on : 13/10/2014, 06:00:53 PM
    Author     : gvillanueva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/moduloObligaciones/common/formArbolTransportes.js" />' charset="utf-8"></script>
    </head>
    <body>
    <div id="dialogArbolTransportes">
        <form id="formArbolTransportes" >
            <fieldset>
                <legend>Arbol de Transportes</legend>
                <div id="divArbolTransportes" style="height:250px;width:465px;">
                    <ul style="display: none;">
                        <li id='0' class='folder'>Transportes
                            <ul style="display:none;">
                                <li id='1'>Gasol 84</li>
                                <li id='2'>GLP 1</li>
                                <li id='3'>GLP 2</li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </fieldset>
            
        </form>
        <div id="botonesDerecha">
                <button id="botoSeleccionarArbolTransportes" class="" title="Seleccionar Actividades">Seleccionar</button>
        </div>
        <input id="listTransportes" hidden="true"/>
    </div>
    </body>
</html>
