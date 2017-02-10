<%-- 
    Document   : requisitoProcedimiento
    Created on : 14/07/2014, 12:13:05 PM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript"
            src='<c:url value="/javascript/app/requisitos/requisitoProcedimiento/general/requGral.js" />' charset="utf-8">
        </script>	
    </head>
    <body>
        <div class="pui-panel ui-widget-content">
            <h2 class="subtitle">
                <a href="#">REQUISITOS GENERALES</a>
            </h2>
              
            <div style="margin:0px 20px;">
                <div class="filaForm">
                    <div class="lble vat"><label>PROCEDIMIENTO:</label></div>
                    <div class="ilb vat" style="width:85px;">${item}</div>
                    <div class="ilb vat" style="width:500px;">${procedimiento}</div>
                </div>
            </div>
            
        </div>
        <div id="botonesDerecha">
            <seg:botonTag code="IN" value="Agregar Req." id="btnAgregarRequGral" title="AGREGAR REQUISITO GENERAL" styleClass="btn_a btn_small" onclick=""/>
<!--            <button id="btnAgregarRequGral" title="AGREGAR REQUISITO GENERAL">Agregar Req.</button>-->
        </div>
        
        <div class="pui-panel ui-widget-content">
            <div class="pui-panel-content ui-widget-content" style="overflow: auto;">
                <div id="tituGralRequ" class="ui-panel-title">REQUISITOS GENERALES</div>
                <div id="headRequGral" class="tblRequ"></div>
                <div class="ui-widget-content ilb" style="min-width: 965px;overflow: auto; padding-right: 25px; max-height: 500px;">
<!--                 	<div id="divEnlaceTagAgregarSubRequisito" class="btns ilb vat tar"> -->
<!-- 							<span class="ui-icon ui-icon-plusthick" title='AGREGAR SUBREQUISITO'></span> -->
<%-- 							<seg:enlaceTag id='linkAgregarRequisito' code='IN' enlace='' value='' onclick='' styleClass='a-ipt-a'></seg:enlaceTag> --%>
<!-- 					</div> -->
                    <div id="gralRequ" class="tblRequ">
                        <ul id="sortableGralRequ">
<!--                            <li><div id="gralRequProc11" class="fila"><div><input type="hidden" value="409" class="idRequisitoGral"><div title="ESTUDIO DE SUELOS" class="desc ilb vat">ESTUDIO DE SUELOS</div><div class="btns ilb vat tar"> <span onclick="btnAgregarSubRequisitoGral(&quot;gralRequProc11&quot;,&quot;ESTUDIO DE SUELOS&quot;)" title="AGREGAR SUBREQUISITO" class="ui-icon ui-icon-plusthick"></span> <span onclick="btnEliminarRequisito(&quot;gralRequProc11&quot;,&quot;gral&quot;)" title="ELIMINAR REQUISITO" class="ui-icon ui-icon-closethick"></span></div><div title="" class="camp ilb vat come"></div><div title="" class="camp ilb vat"></div><div title="" class="camp ilb vat"></div><div title="" class="camp ilb vat"></div></div></div></li>
                            <li><div id="gralRequProc12" class="fila"><div><input type="hidden" value="411" class="idRequisitoGral"><div title="ESTUDIO DE RIESGOS APROBADO." class="desc ilb vat">ESTUDIO DE RIESGOS APROBADO.</div><div class="btns ilb vat tar"> <span onclick="btnAgregarSubRequisitoGral(&quot;gralRequProc12&quot;,&quot;ESTUDIO DE RIESGOS APROBADO.&quot;)" title="AGREGAR SUBREQUISITO" class="ui-icon ui-icon-plusthick"></span> <span onclick="btnEliminarRequisito(&quot;gralRequProc12&quot;,&quot;gral&quot;)" title="ELIMINAR REQUISITO" class="ui-icon ui-icon-closethick"></span></div><div title="La aprobación no es aplicable a Plantas Envasadoras" class="camp ilb vat come">La aprobación no es aplicable a Plantas Envasadoras</div><div title="" class="camp ilb vat"></div><div title="" class="camp ilb vat"></div><div title="" class="camp ilb vat"></div></div></div></li>
                            <li><div id="gralRequProc13" class="fila"><div><input type="hidden" value="412" class="idRequisitoGral"><div title="MEMORIA DESCRIPTIVA." class="desc ilb vat">MEMORIA DESCRIPTIVA.</div><div class="btns ilb vat tar"> <span onclick="btnAgregarSubRequisitoGral(&quot;gralRequProc13&quot;,&quot;MEMORIA DESCRIPTIVA.&quot;)" title="AGREGAR SUBREQUISITO" class="ui-icon ui-icon-plusthick"></span> <span onclick="btnEliminarRequisito(&quot;gralRequProc13&quot;,&quot;gral&quot;)" title="ELIMINAR REQUISITO" class="ui-icon ui-icon-closethick"></span></div><div title="" class="camp ilb vat come"></div><div title="" class="camp ilb vat"></div><div title="" class="camp ilb vat"></div><div title="" class="camp ilb vat"></div></div></div></li>
                            <li><div id="gralRequProc14" class="fila"><div><input type="hidden" value="413" class="idRequisitoGral"><div title="ESPECIFICACIONES TÉCNICAS DE LOS EQUIPOS PRINCIPALES DEL PROYECTO." class="desc ilb vat">ESPECIFICACIONES TÉCNICAS DE LOS EQUIPOS PRINCIPALES DEL PROYECTO.</div><div class="btns ilb vat tar"> <span onclick="btnAgregarSubRequisitoGral(&quot;gralRequProc14&quot;,&quot;ESPECIFICACIONES TÉCNICAS DE LOS EQUIPOS PRINCIPALES DEL PROYECTO.&quot;)" title="AGREGAR SUBREQUISITO" class="ui-icon ui-icon-plusthick"></span> <span onclick="btnEliminarRequisito(&quot;gralRequProc14&quot;,&quot;gral&quot;)" title="ELIMINAR REQUISITO" class="ui-icon ui-icon-closethick"></span></div><div title="" class="camp ilb vat come"></div><div title="" class="camp ilb vat"></div><div title="" class="camp ilb vat"></div><div title="" class="camp ilb vat"></div></div></div></li>-->
                        </ul>
                    </div>                    
                </div>
            </div>
        </div>
    </body>
</html>