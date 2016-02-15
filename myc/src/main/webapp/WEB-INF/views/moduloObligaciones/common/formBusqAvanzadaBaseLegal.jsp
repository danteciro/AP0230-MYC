<%-- 
    Document   : formBusqAvanzadaBaseLegal
    Created on : 10/01/2015, 09:35:14 AM
    Author     : jpiro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/moduloObligaciones/common/formBusqAvanzadaBaseLegal.js" />' charset="utf-8"></script>
    </head>
    
    <body>
        <form id="formBusqAvanBL" class="tac">  
            <div id="divMensajeValidaBusqAvanBL" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <div class="form"> 
            	<div class="filaForm">
            			<div class="lblc" style="width:370px;"></div>
	            		<div style="width: 200px;">
	                         <input type="radio" id="chkBaseLegal" value="1" name="opcionBusquedaAvanzado" class="opcionBusquedaAvanzado" />
	                         <label for="chkBaseLegal" class="radio" >Base Legal</label>
	   					</div>
	   					<div >
	                         <input type="radio" id="chkObligaciones" value="0" name="opcionBusquedaAvanzado" class="opcionBusquedaAvanzado" />
	                         <label for="chkObligaciones" class="radio" >Obligaciones</label>
	   					</div>
            	</div>
            	
                <div class="filaForm" id="divBaseLegal1">
                    <div class="lblc" style="width:140px;"><label for="txtCodBaseLegaBusqAvanBL">Código Base Legal:</label></div>
                    <div style="width: 200px;">
                        <input id="txtCodBaseLegaBusqAvanBL" type="text" maxlength="10">
                    </div>
                </div>
                <div class="filaForm" id="divBaseLegal2">
                    <div class="lblc" style="width:140px;text-align: right;"><label for="slcTipoNormaLegaBusqAvanBL">Tipo Norma Legal:</label></div>
                    <div style="width: 200px;">
                        <select id="slcTipoNormaLegaBusqAvanBL"  >
                            <option value="">--Seleccione--</option>
                            <c:forEach items="${listTipoNormaLegal}" var="t">
                                  <option value='${t.idMaestroColumna}'>${t.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div> 
                    <div class="lblc" style="width:140px;" ><label for="txtFechaEntrVigeBusqAvanBL" >Fecha Entrada Vigencia: </label></div>
                    <div style="width:200px;">
                        <input id="txtFechaEntrVigeBusqAvanBL" type="text" readonly>
                    </div>                   
                </div>
                <div class="filaForm" id="divBaseLegal2a">
                  <div class="lblc" style="width:140px;text-align: right;" ><label for="txtNumeroBusqAvanBL" >Número:</label></div>
                    <div style="width:200px;">
                        <input id="txtNumeroBusqAvanBL" type="text" validate="[SN]" maxlength="5" >
                    </div>
                    <div class="lblc" style="width:140px;"><label for="txtAnoBusqAvanBL">Año:</label></div>
                    <div style="width:120px;">
                        <input id="txtAnoBusqAvanBL" placeholder="--2000--" maxlength="4" style="width:100px;" >
                    </div>
                    <div class="lblc" ><label for="slcSiglaBusqAvanBL">Sigla:</label></div>
                    <div>
                        <select id="slcSiglaBusqAvanBL" >
                            <option value="">--Seleccione--</option>
                            <c:forEach items="${listSigla}" var="t">
                                  <option value='${t.idMaestroColumna}'>${t.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="filaForm" id="divBaseLegal3">
                    <div class="lblc" style="width:140px;"><label for="txtArticuloBusqAvanBL">Artículo:</label></div>
                    <div style="width:200px;">
                        <input id="txtArticuloBusqAvanBL" maxlength="3" type="text" >
                    </div>                    
                </div>
                <div class="filaForm" id="divBaseLegal3a" >
                    <div class="filaForm">
                        <div class="lblc" style="width:140px;"><label for="slcTipoAnexoBusqAvanBL">Tipo de Anexo:</label></div>
                        <div style="width:200px;">
                             <select id="slcTipoAnexoBusqAvanBL" >
                                <option value="">--Seleccione--</option>
                                <c:forEach items="${listTipoAnexo}" var="t">
                                    <option value='${t.idMaestroColumna}'>${t.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div style="width:140px;" class="lblc" ><label for="txtArticuloAnexoBusqAvanBL">Artículo Anexo:</label></div>
                    <div >
                        <input id="txtArticuloAnexoBusqAvanBL" type="text" maxlength="3" disabled>
                    </div>
                </div>
                <div class="filaForm" id="divObligaciones1">
                    <div class="lblc vam" style="width:140px;"><label for="txtCodiObliNomaBusqAvanBL">Código Obligación Normativa:</label></div>
                    <div class="vam" style="width:200px;">
                        <input id="txtCodiObliNomaBusqAvanBL" type="text" maxlength="20">
                    </div> 
                    <div class="lblc vam" style="width:140px;"><label for="txtDescrObliDetalleBusqAvanBL">Descripción Obligación (Acta y Declaración Jurada):</label></div>
                    <div class="vam">
                        <textarea id="txtDescrObliDetalleBusqAvanBL" maxlength="2000" style="height:27px;width:415px;" maxlength="2000" ></textarea>
                    </div>
                </div>
                <div class="filaForm" id="divObligaciones2">
                    <div class="lblc vam" style="width:140px;"><label for="slcCritiObliBusqAvanBL">Criticidad de Obligación:</label></div>
                    <div style="width:200px;">
                        <select id="slcCritiObliBusqAvanBL">
                           <option value="">--Seleccione--</option>
                           <c:forEach items="${listCriticidad}" var="t">
                               <option value='${t.idMaestroColumna}'>${t.descripcion}</option>
                           </c:forEach>
                       </select>
                    </div>
                    
                    <div class="lblc vam" style="width:140px;"><label for="txtRubrosBusqAvanBL">Rubros:</label></div>
                    <div class="vam">
                        <input id="txtRubrosBusqAvanBL" type="text" readonly>
                        <input id="idsRubrosBusqAvanBL" type="hidden" readonly>
                    </div>
                    <div id="popupArbolActiBusqAvanBL" class="filaFormMarg" style="display:none;" title="SELECCIONAR RUBROS">
                        <div id="arbolActividadesBusqAvanBL" style="height: 160px;">
                        </div>
                        <div id="botones" style="margin-top:20px;">
                            <button title="Cerrar" onclick="$('#popupArbolActiBusqAvanBL').dialog('close');return false;">Cerrar</button>
                        </div>
                    </div>
                    <div class="lblc vam" style="width:65px;"><label for="slcObliTipoBusqAvanBL">Obligación Tipo:</label></div>
                    <div class="vam">
                    	<div style="width:200px;">
                        <select id="slcObliTipoBusqAvanBL">
                           <option value="">--Seleccione--</option>
                           <option value="-1">--Sin Configurar--</option>
                           <c:forEach items="${listObligacionTipo}" var="t">
                               <option value='${t.idObligacionTipo}'>${t.nombre}</option>
                           </c:forEach>
                       </select>
                    </div>
                    </div>
<!--                     <div class="lblc vam" style="width:65px;"><label for="txtTemasBusqAvanBL">Temas:</label></div> -->
<!--                     <div class="vam"> -->
<!--                         <input id="txtTemasBusqAvanBL" type="text" readonly> -->
<!--                         <input id="idsTemasBusqAvanBL" type="hidden" readonly> -->
<!--                     </div> -->
                    <div id="popupArbolTemasBusqAvanBL" class="filaFormMarg" style="display:none;" title="SELECCIONAR TEMAS">
                        <div id="arbolTemasBusqAvanBL" style="height: 160px;">
                        </div>
                        <div id="botones" style="margin-top:20px;">
                            <button title="Cerrar" onclick="$('#popupArbolTemasBusqAvanBL').dialog('close');return false;">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!--<div id="obligatorio">(*) Campos obligatorios</div>-->
        <div id="botones">
            <button id="btnBuscarBusqAvanBL" title="Buscar" >Buscar</button>
            <button id="btnLimpiarBusqAvanBL" title="Limpiar" class="btnSimple">Limpiar</button>
            <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
        
    </body>
</html>
