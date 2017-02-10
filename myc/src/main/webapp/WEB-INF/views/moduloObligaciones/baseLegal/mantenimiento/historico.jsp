<%-- 
    Document   : historico
    Created on : 13/10/2014, 11:38:29 AM
    Author     : gvillanueva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/moduloObligaciones/baseLegal/mantenimiento/historico.js" />' charset="utf-8"></script>
    </head>
    <body >
        <div id="${idDialog}">
        <input id="idDialogHistoricoBaseLegal" type="hidden" value="${idDialog}">
            <div id="historicoGeneralBaseLegal" style="width: 996px;">
                Historico General Base Legal
                <div id="gridContenedorHistoricoGeneralBaseLegal"></div>
                <div id="divContextMenuHistoricoGeneralBaseLegal"></div>
            </div>
            <div id="historicoGeneralObligacionNormativa" style="width: 996px;">
                Historico General Obligación Normativa
                <div id="gridContenedorHistoricoGeneralObligacionNormativa"></div>
                <div id="divContextMenuHistoricoGeneralObligacionNormativa"></div>
            </div>
            <div id="botones">
                <button id="btnCerrarPopUpHistorico">Cerrar</button>
            </div>
        </div>
    </body>
</html>