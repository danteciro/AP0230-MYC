<%-- 
    Document   : formAsociarBaseLEgal
    Created on : 10/01/2015, 09:35:14 AM
    Author     : jpiro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/moduloObligaciones/common/formAsociarObligacion.js" />' charset="utf-8"></script>
    </head>
    
    <body>
        <form id="formBuscarAsigObli" class="tac">    
            <div class="form"> 
                <div class="filaForm">
                    <div class="lblc vam" style="width:140px;"><label for="txtCodiObliAsigObli">Código Obligación Normativa:</label></div>
                    <div class="vam" style="width:200px;">
                         <input id="txtCodiObliAsigObli" type="text">
                         <input type="hidden" id="idsObligacion" value="${idsObligacion}" />
                    </div> 
                    <div class="lblc vam" style="width:140px;"><label for="txtDescrObliDetalleAsigObli">Descripción Obligacion (Acta y Declaración Jurada):</label></div>
                    <div class="vam">
                        <textarea id="txtDescrObliDetalleAsigObli" maxlength="2000" style="height:27px;width:415px;"></textarea>
                    </div>
                </div>
                <div class="filaForm">
                    <div class="lblc vam" style="width:140px;"><label for="slcCritiObliAsigObli">Criticidad de Obligación:</label></div>
                    <div style="width:200px;">
                        <select id="slcCritiObliAsigObli">
                           <option value="">--Seleccione--</option>
                           <c:forEach items="${listCriticidad}" var="t">
                               <option value='${t.idMaestroColumna}'>${t.descripcion}</option>
                           </c:forEach>
                       </select>
                    </div>
                    
                    <div class="lblc vam" style="width:140px;"><label for="txtRubrosAsigObli">Rubros:</label></div>
                    <div class="vam">
                        <input id="txtRubrosAsigObli" type="text" readonly>
                        <input id="idsRubrosAsigObli" type="hidden" readonly>
                    </div>
                    <div id="popupArbolActiAsigObli" class="filaFormMarg" style="display:none;" title="SELECCIONAR RUBROS">
                        <div id="arbolActividadesAsigObli" style="height: 160px;">
                        </div>
                        <div id="botones" style="margin-top:20px;">
                            <button title="Cerrar" onclick="$('#popupArbolActiAsigObli').dialog('close');return false;">Cerrar</button>
                        </div>
                    </div>
                    
                    <div class="lblc vam" style="width:65px;"><label for="txtTemasAsigObli">Temas:</label></div>
                    <div class="vam">
                        <input id="txtTemasAsigObli" type="text" readonly>
                        <input id="idsTemasAsigObli" type="hidden" readonly>
                    </div>
                    <div id="popupArbolTemasAsigObli" class="filaFormMarg" style="display:none;" title="SELECCIONAR TEMAS">
                        <div id="arbolTemasAsigObli" style="height: 160px;">
                        </div>
                        <div id="botones" style="margin-top:20px;">
                            <button title="Cerrar" onclick="$('#popupArbolTemasAsigObli').dialog('close');return false;">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!--<div id="obligatorio" class="tal">(*) Campos obligatorios</div>-->
        <div id="botones">
            <button id="btnBuscarAsigObli" title="Buscar">Buscar</button>
            <button id="btnLimpiarAsigObli" title="Limpiar" class="btnSimple">Limpiar</button>
            <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        <!-- Grid Resultado de la Búsqueda Avanzada-->
        <div id="gridContenedorBuscarAsigObli" class="ilb"></div>
        
        <div id="botones"  class="divBtnAsociarObligacion" style="text-align:center;display:none;">
            <button id="btnAsociarBusquedaAvanzadaBaseLegal" title="Asociar Bases Legales" >Asociar</button>
        </div>
        
    </body>
</html>
