<%-- 
    Document   : formBusquedaAvanzada
    Created on : 27/08/2014, 09:35:14 AM
    Author     : gvillanueva
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/moduloObligaciones/common/formBusquedaAvanzada.js" />' charset="utf-8"></script>
    <style>
   
        #toggBusquedaAvanzadaBaseLegal .pui-panel-titlebar{
            background: none repeat scroll 0 0 #ffffff;
            border: 2px solid #ffffff;
        }
        #toggBusquedaAvanzadaBaseLegal{
            border: 1px solid #ffffff;
        }
    
        .fielDetalleBusquedaAvanzadaBaseLegal {
            margin: 0 0 0 125px;
            display: inline-block;
        }
    </style>
    </head>
    <body>
    <div class="container">
        <input id="idDialogBusquedaAvanzadaBaseLegal" type="hidden" value="${idDialog}">
        <div id="${idDialog}">
            <form id="formBusquedaAvanzadaBaseLegal" class="tac">    
                <div class="form"> 
                    <div class="filaForm">
                    </div>
                    <div class="filaForm">
                        <div class="lblc" style="width:140px;text-align: right;"><label for="combNormaLegalBusquedaAvanzadaBaseLegal">Tipo Norma Legal(*):</label></div>
                        <div style="width: 200px;">
                            <select id="combNormaLegalBusquedaAvanzadaBaseLegal" name="TipoNormaLegal" >
                                <option value="">--Seleccione--</option>
                                <c:forEach items="${listTipoNormaLegal}" var="t">
                                      <option value='${t.idMaestroColumna}'>${t.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="lblc" ><label for="textNumeroBusquedaAvanzadaBaseLegal" >Número(*):</label></div>
                        <div style="width:120px;">
                            <input id="textNumeroBusquedaAvanzadaBaseLegal" type="text" name="Número" style="width:70px;" >
                        </div>
                        <div class="lblc" style="width:100px;"><label for="textAnoBusquedaAvanzadaBaseLegal">Año:</label></div>
                        <div style="width:120px;">
                            <input id="textAnoBusquedaAvanzadaBaseLegal" name="Año" placeholder="--2000--" style="width:100px;" >
                        </div>
                        <div class="lblc" style="width:100px;"><label for="combSiglaBusquedaAvanzadaBaseLegal">Sigla:</label></div>
                        <div>
                            <select style="width:100px;" id="combSiglaBusquedaAvanzadaBaseLegal" name="Sigla">
                                <option value="">--Seleccione--</option>
                                <option value="">EM</option>
                                <option value="1">DGH</option>
                                <option value="2">MEM</option>
                                <option value="3">PCM</option>
                                <option value="3">OS/CD</option>
                            </select>
                        </div>
                    </div>
                    <div class="filaForm"> 
                        <div class="lblc" style="width:140px;" ><label for="dateFechaEntradaVigenciaBusquedaAvanzadaBaseLegal" >Fecha Entrada Vigencia: </label></div>
                        <div style="width:200px;">
                            <input id="dateFechaEntradaVigenciaBusquedaAvanzadaBaseLegal" type="text">
                        </div>
                        <div class="lblc" ><label for="dateFechaPublicacionBusquedaAvanzadaBaseLegal" >Fecha Publicación: </label></div>
                        <div style="width:200px;">
                            <input id="dateFechaPublicacionBusquedaAvanzadaBaseLegal" type="text">
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lblc" style="vertical-align:top;width:140px;"><label for="textTituloBusquedaAvanzadaBaseLegal">Título:</label></div>
                        <div>
                            <textarea id="txtaTituloBusquedaAvanzadaBaseLegal" name="Título" maxlength="400" style="height:40px;width:833px;" placeholder="Descripción del Título de la Base Legal"></textarea>
                        </div>
                    </div>
                    <div id="toggBusquedaAvanzadaBaseLegal" title=" " style="margin:0;">
                    <fieldset class="fielDetalleBusquedaAvanzadaBaseLegal">
                    <div class="filaForm">
                        <div class="lblc"><label for="textArticuloBusquedaAvanzadaBaseLegal"><strong>Artículo:</strong></label></div>
                        <div style="">
                             <input id="textArticuloBusquedaAvanzadaBaseLegal" type="text" name="Artículo">
                        </div>
                        <div class="lblc"><label for="textInciso1BusquedaAvanzadaBaseLegal"><strong>Inciso Nivel 1:</strong></label></div>
                        <div style="">
                            <input id="textInciso1BusquedaAvanzadaBaseLegal"  type="text" name="Inciso Nivel uno" style="width:135px;">
                        </div>
                        <div class="lblc"><label for="textInciso2BusquedaAvanzadaBaseLegal"><strong>Inciso Nivel 2:</strong></label></div>
                        <div style="">
                            <input id="textInciso2BusquedaAvanzadaBaseLegal" type="text" name="Inciso Nivel dos"  style="width:135px;">
                        </div>
                    </div>
                    <div class="filaForm" >
                        <br>
                    </div>
                    <div class="filaForm">
                        <div class="lblc"><label for="combAnexoBusquedaAvanzadaBaseLegal"><Strong>Tipo de Anexo:</Strong></label></div>
                        <div style="">
                             <select id="combAnexoBusquedaAvanzadaBaseLegal" name="Anexo">
                                <option value="">--Seleccione--</option>
                                <option value="1">Reglamento</option>
                                <option value="2">Texto Único Ordenado</option>
                            </select>
                        </div>
                    </div>
                    <div class="filaForm">
                        <div class="lblc"><label for="textArticuloAnexoBusquedaAvanzadaBaseLegal"><Strong>Artículo:</Strong></label></div>
                        <div style="">
                             <input id="textArticuloAnexoBusquedaAvanzadaBaseLegal" type="text" name="Artículo del Anexo">
                        </div>
                        <div class="lblc" ><label for="textIncisoAnexo1BusquedaAvanzadaBaseLegal"><strong>Inciso Nivel 1:</strong></label></div>
                        <div style="">
                            <input id="textIncisoAnexo1BusquedaAvanzadaBaseLegal" type="text" name="Inciso Nivel 1 del Anexo"  style="width:135px;" >
                        </div>
                        <div class="lblc"><label for="textIncisoAnexo2BusquedaAvanzadaBaseLegal"><strong>Inciso Nivel 2:</strong></label></div>
                        <div style="">
                             <input id="textIncisoAnexo2BusquedaAvanzadaBaseLegal" type="text" name="Inciso Nivel 2 del Anexo" style="width:135px;" >
                        </div>

                    </div>
                    <div class="filaForm" style="padding:0px;">
                        <br>
                    </div>        
                    <div class="filaForm" >
                    <div class="lblc" style="vertical-align:bottom;"><label for="dateFechaEntradaVigenciaDetalleBusquedaAvanzadaBaseLegal" ><strong>Fecha Entrada Vigencia:</strong> </label></div>
                    <div style="width:200px;">
                            <input id="dateFechaEntradaVigenciaDetalleBusquedaAvanzadaBaseLegal" type="text" >
                    </div>
                    </div>
                    <div class="filaForm">
                        <br>
                    </div>
                    <div class="filaForm" >
                        <div class="lblc" style="width:100px;"><label for="textActividadesBusquedaAvanzadaBaseLegal">Actividades:</label></div>
                        <div>
                            <input id="txtActividadesBusquedaAvanzadaBaseLegal" type="text" name="item" maxlength="100" placeholder="Actividades" style="width:120px;" />
                        </div> 
                        <div class="lblc" style="width:120px;"><label for="textProductosBusquedaAvanzadaBaseLegal">Productos:</label></div>
                        <div>
                            <input id="txtProductosBusquedaAvanzadaBaseLegal" name="item" type="text" maxlength="100"  placeholder="Productos" style="width:120px;"/>
                        </div> 
                    </div>
                    </fieldset>
                    </div>
                </div>
            </form>
        <div>
            <div id="obligatorio"  colspan="6" style="height:10px;padding-left: 140px;">(*) Campos Obligatorios</div>
        </div>
        <div id="botones">
            <button id="botoBuscarBusquedaAvanzadaBaseLegal" title="Buscar" >Buscar</button>
            <button title="Cerrar" class="" id="botoCerrarBusquedaAvanzadaBaseLegal">Cerrar</button>
        </div>
        <!-- Grid Resultado de la Búsqueda Avanzada-->
        <div id="divContenedorBusquedaAvanzadaBaseLegal">
        <center><div id="gridContenedorBusquedaAvanzadaBaseLegal"></div></center>
        <div id="divContextMenuBusquedaAvanzadaBaseLegal"></div>
        <div id="botones">
            <button id="botoAsociarBusquedaAvanzadaBaseLegal" title="Asociar Bases Legales" >Asociar</button>
            <button id="botoAsociarBaseLegalesObligacion" title="Asociar Bases Legales">Asociar</button>
        </div>
        </div>
        <!-- Contenedores -->
        <!--Contenedor Arboles-->
        <div id="containerDialogArbolActividades"></div>
        <div id="containerDialogArbolProductos"></div>
        </div>
    </div>
    </body>
</html>
