<%-- 
    Document   : popupBusqSancAdm
    Created on : 10/02/2015, 06:27:21 PM
    Author     : lbarboza
--%>

<%@ include file="/common/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
     <script type="text/javascript" src='<c:url value="/javascript/app/general/common/sancionAdministrativa/popupBusqSancAdm.js" />' charset="utf-8"></script>
    </head>
    <body>
<!--    <form id="frmBusqActividad">-->
<!--     			  <input type="hidden" id="idDepartamento" value="${idDepartamento}" >
                  <input type="hidden" id="idProvincia"  value="${idProvincia}">-->
			     <div class="pui-panel-content" >
                        <div class="filaFormMarg">
                            <input type="hidden" id="idSancAdmSelecEspe"/>
                            <div id="arbolSancAdmEspe" style="height:300px;width:700px;" seleccion="${seleccion}">
                            </div>
                        </div>
                    </div>
                    
	                 
            <br/>
            <div align="center">
                <button id="btnSeleccionarSancAdm" title="Seleccionar" type="button">Seleccionar</button>
            </div>
<!--        </form>  -->
</body>      