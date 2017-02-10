<!-- 
    Document   : template
    Created on : 11/07/2014, 11:50:41 AM
    Author     : jpiro
-->

<%@tag language="java" pageEncoding="ISO-8859-15"%>
<%@ include file="/common/taglibs.jsp"%>
<%@attribute name="pageTitle"%>
<%@attribute name="scrollPanelTitle"%>
<%@attribute name="fecha"%>
<%@attribute name="usuario"%>
<%@attribute name="headArea" fragment="true" %>
<%@attribute name="bodyArea" fragment="true" %>

<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page ="/WEB-INF/templates/css.jspf"/>
        <jsp:include page ="/WEB-INF/templates/js.jspf"/>
        <jsp:include page="/WEB-INF/templates/msg.jspf" />
        
        <jsp:invoke fragment="headArea"/>
        
        <title>MYC | ${pageTitle}</title>
    </head>
    <body>
        <div id="overlay_loading" style="display:none;">
            <div class="fancytree-loading"><span class="fancytree-expander"></span></div>
        </div>
        <div id="notifynormal"></div>
        <%--
        <jsp:include page ="/WEB-INF/templates/header.jspf"/>
        --%>
        <div id="header">
            <div id="logoWrapper">
                    <img id="logo" alt="logo" src="/myc/images/osinergminLogo.png">
            </div>
            <div id="userWrapper">
                <table>
                    <tr>
                        <td class="tar">${usuario}</td> 
                        <input type="hidden" id="idPersonalSesion" value="${idPersonal}">
                        <input type="hidden" id="rolSesion" value="${nombreRol}">
                    </tr>
                    <tr>
                        <td class="tar">${fecha}</td>
                    </tr>
                </table>
            </div>
        </div>
        
        <div title="${scrollPanelTitle}" class="scrollPanel">
            <jsp:invoke fragment="bodyArea"/>
        </div>
    </body>
</html>