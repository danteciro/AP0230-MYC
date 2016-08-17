<%-- 
    Document   : nuevo
    Created on : 29/09/2014, 11:42:11 AM
    Author     : gvillanueva
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <!--PR119 RSIS 19 inicion -->
        <script type="text/javascript">

        var detalleNormaTecnicaDTO = ${detalleNormaTecnicaDTO};

        </script>
        <!--PR119 RSIS 19 Fin -->
        <script type="text/javascript" src='<c:url value="/javascript/app/moduloObligaciones/baseLegal/mantenimiento/nuevo.js" />' charset="utf-8"></script>        
        <style>
        	
            .pui-tabview-left > .pui-tabview-nav{
                width:17% !important;
            }
            .pui-tabview-left > .pui-tabview-panels{
                width:82% !important;
            }
            #dialogConfirmacionEditarRegistroBaseLegal{
                width:350px;
            }
        </style>
    </head>
    <body >

        <div id="${idDialog}" >
        	<input id="iptDetalleNormaTecnica" type="hidden" value="" >
            <input id="codTrazabilidad" type="hidden" value="${codTrazabilidad}" >
            <input id="accionDialogMantenimiento" type="hidden" value="${flagBaseLegal}" >
            <input id="idDialogMantenimientoBaseLegal" type="hidden" value="${idDialog}" >
            <div id="tabNewBaseLegal" style="width:990px;">
                <ul>
                    <li id="tab1"><a href="#newBaseLegal">Base Legal</a></li>
                    <li id="tab2"><a href="#newObligacionNormativa">Obligación Normativa</a></li>

                </ul>
                <div id="newBaseLegal">
                    <div id="dialogAgregarBaseLegal">
                        <form id="frmAgregarBaseLegal" >
<!-- 05/11/2015 -->
                            <input id="codTrazabilidadNuevo" name="codTrazabilidad" type="hidden" value="${codTrazabilidad}">
<!-- 1 -->
                            <div id="divMensajeValidacion" class="errorMensaje" tabindex='1' style="display: none" ></div>
                            <div class="form">

                                <div class="filaForm">
<!-- 05/11/2015 -->
                                     <div id="divDescCodigoBaseLegal" class="lblc" style="width:140px;display:inline-block;;"><label for="txtCodBaseLegal">Código Base Legal:</label></div>
<!-- 2 -->                                    
                                    <div style="width:200px;">
                                        <input id="txtidBaseLegal" name="idBaseLegal" value="${baseLegal.idBaseLegal}" type="text" maxlength="100" style="display: none;"/>
                                        <input id="txtCodBaseLegal" name="codigoBaseLegal" value="${CodigoBaseLegal}${baseLegal.codigoBaseLegal}" validate="" type="text" maxlength="100" style="display: none;"/>
<!-- 05/11/2015 -->                                        
                                        <input id="txtCodigoBaseLegalNuevo" name="" value="${CodigoBaseLegal}${baseLegal.codigoBaseLegal}" validate="" type="text" maxlength="100" style="display: inline-block;"/>
<!-- 3 -->                                         
                                    </div>
<!--                                     <div style="float:right;"><input id="btnEliminarBaseLegal" type="button" value="Eliminar" class="btn_a btn_small" ></div> -->
										 <div style="float:right;"><seg:botonTag code="EL" value="Eliminar" styleClass="btn_a btn_small" id="btnEliminarBaseLegal" title="Eliminar" onclick=""/></div>
<!--                                     <div style="float:right;"><input id="btnEliminarBaseLegalPadre" type="button" value="Eliminar" class="btn_a btn_small" style="display:none;"></div> -->
										 <div style="float:right;"><seg:botonTag code="EL" value="Eliminar"  styleClass="btn_a btn_small a-ipt-a" id="btnEliminarBaseLegalPadre" title="Eliminar" onclick=""/></div>
                                </div> 
                                <div class="filaForm">
                                <div class="lblc" style="width:140px;" ></div>
                                	<div style="width:200px;">
                                        <input id="chkNormaLegalPadre" type="checkbox" name="flagPadre" value="${baseLegal.flagPadre}" /> 
                                        <label for="chkNormaLegalPadre" class="checkbox">Norma Legal</label>
                                    	</div>
                                </div>
                                <div class="filaForm">
				                                	<div class="lblc" style="width:140px;text-align: right;"><label for="cmbNormaLegal">Norma Legal Padre:</label></div>
				                                	<div class="lbld">
				                                        <input id="cmbHideNormaLegal" value="${baseLegal.idBaseLegalPadre}" style="display:none;">
				                                        <select id="cmbNormaLegal" name="idBaseLegalPadre" class="lbld">
				                                            <option value="">--Seleccione--</option>
				                                        </select>
				                                    </div>
				                            </div>
				                            <div id="divBaseLegalPadre">  
                                <div class="filaForm">
                                    <div class="lblc" style="width:140px;text-align: right;"><label for="cmbTipBaseLegal">Tipo Norma Legal(*):</label></div>
                                    <div style="width: 200px;">
                                        <input id="cmbHideTipoBaseLegal" value="${baseLegal.tipoNormaLegal}" style="display:none;">
                                        <select id="cmbTipBaseLegal" name="tipoNormaLegal" validate="[O]" class="lbld">
                                            <option value="-1">--Seleccione--</option>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="filaForm">
                                
                                    <div class="lblc" style="width:140px;" ><label for="txtNumBaseLegal" >Número(*):</label></div>
                                    <div style="width:200px;">
                                        <input id="txtNumBaseLegal" name="numeroNormaLegal" value="${baseLegal.numeroNormaLegal}" validate="[SN][O]" type="text" maxlength="5" >
                                    </div>
                                    <div class="lblc"><label for="txtAnioBaseLegal">Año:</label></div>
                                    <div style="width:200px;">
                                        <input id="txtAnioBaseLegal" name="anioNormaLegal" value="${baseLegal.anioNormaLegal}" validate=""  placeholder="--2000--" style="width:160px;" maxlength="4">
                                    </div>
                                    <div class="lblc" ><label for="cmbSiBaseLegal">Sigla:</label></div>
                                    <div>
                                        <input id="cmbHideSiglaBaseLegal" value="${baseLegal.siglaNormaLegal}" style="display:none;">
                                        <select id="cmbSigBaseLegal" name="siglaNormaLegal" validate="" >
                                            <option value="">--Seleccione--</option>
                                        </select>
                                    </div>
                                </div>
                                <div id="divDetalleBaseLegal">
                                    <div class="filaForm"> 
                                        <div class="lblc" style="width:140px;" ><label for="dateFecVigencia" >Fecha Entrada Vigencia: </label></div>
                                        <div style="width:200px;">
                                            <input id="dateFecVigencia" value="${fechaVigenciaNormaLegalController}" name="fechaEntradaVigenciaNormaLegal" type="text" readonly>
                                        </div>
                                        <div class="lblc" ><label for="dateFecPublicacion" >Fecha Publicación: </label></div>
                                        <div style="width:200px;">
                                            <input id="dateFecPublicacion" value="${fechaPublicacionNormaLegalController}" name="fechaPublicacionNormaLegal" type="text" readonly>
                                        </div>
                                        <!--upload archivo-->
                                        <div style="width:100px;">

                                        </div>
                                        <div id="divImgBaseLegal" class="vam">
                                            <input id="imgSubir" type="button" value="Doc. Adjuntos" class="btn_a btn_small">
                                            <div id="divArchivoNormaLegal">
                                            <c:if test="${documentoAdjunto!=null}">
                                            <a class="link" href="/myc/pages/documentoAdjunto/descargaArchivoAlfresco?aplicacionSpace=OBLIGACIONES&nombreArchivo=${baseLegal.nombreArchivo}&rutaAlfresco=${baseLegal.rutaAlfresco}">
                                                <img class="vam" width="17" height="18" src="/myc/images/stickers.png">
                                            </a>
                                            </c:if>
                                            </div>
                                            <label id="lblSubirArchivoBaseLegal">(.pdf)</label>
                                        </div>
                                        
                                        <!--fin upload-->
                                    </div>
                                    <div class="filaForm">
                                        <div class="lblc" style="vertical-align:top;width:140px;"><label for="txtaTitBaseLegal">Título:</label></div>
                                        <div>
                                            <!-- PR119 - Item 22 - Inicio -->
                                            <%--<textarea id="txtaTitBaseLegal" value="${baseLegal.tituloNormaLegal}" name="tituloNormaLegal"  maxlength="200" style="height:17px;width:773px;">${baseLegal.tituloNormaLegal}</textarea> --%>
                                            <textarea id="txtaTitBaseLegal" value="${baseLegal.tituloNormaLegal}" name="tituloNormaLegal"  maxlength="500" style="height:17px;width:773px;">${baseLegal.tituloNormaLegal}</textarea>
                                            <!-- PR119 - Item 22 - Fin -->
                                        </div>
                                    </div>
                                    
                                    <input id="txtidNivelArticulo" name="idNivelArtirculo" value="${detalleBaseLegal.idNivelArtirculo}" type="text" style="display: none;"/>
                                    <input id="txtFecNorma" value="${fechaPublicacionDetalleNormaLegalController}" style="display: none;" />
                                </div>
                                </div> 
                                <div id="obligatorio">(*) Campos obligatorios</div>
                                <div class="filaForm">
                                    <br>

                                </div>
                                <div id="divDetalleBaseLegalHijo">
                                <fieldset>
                                    <legend> Artículo </legend>
                                    <div class="filaForm">
                                    	<input id="txtidDetalleBaseLegal" name="idDetalleBaseLegal" value="${detalleBaseLegal.idDetalleBaseLegal}" type="text" maxlength="100" style="display: none;"/>
                                        <div class="lblc" style="width:127px;"><label for="txtArtBaseLegal"><strong>Artículo:</strong></label></div>
                                        <div style="width:200px;">
                                            <input id="txtArtBaseLegal" value="${detalleBaseLegal.articuloNormaLegal}" name="articuloNormaLegal" validate="[SN]" type="text" maxlength="3">
                                        </div>
                                        <div class="lblc"><label for="txtInc1BaseLegal"><strong>Inciso Nivel 1:</strong></label></div>
                                        <div style="width:200px;">
                                            <input id="txtInc1BaseLegal" value="${detalleBaseLegal.incisoUnoNormaLegal}" name="incisoUnoNormaLegal" type="text" style="" maxlength="3">
                                        </div>
                                        <div class="lblc"><label for="txtInc2BaseLegal"><strong>Inciso Nivel 2:</strong></label></div>
                                        <div style="">
                                            <input id="txtInc2BaseLegal" value="${detalleBaseLegal.incisoDosNormaLegal}" name="incisoDosNormaLegal" type="text" style="" maxlength="3">
                                        </div>
                                    </div>

                                    <div id="fecnivelnorma" style="display: none;">
                                        <div class="filaForm"> 
                                            <div class="lblc" style="width:127px;" ><label for="dateFecVigenciaNorma" >Fecha Entrada Vigencia: </label></div>
                                            <div style="width:200px;">
                                                 <!-- PR119 - Item 21 - Inicio -->
                                                 <!--<input id="dateFecVigenciaNorma" value="" name="" type="text" readonly> -->
                                                <input id="dateFecVigenciaNorma" value="${baseLegalFechavigencia}" name="" type="text" readonly>
                                                <!-- PR119 - Item 21 - Fin -->
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                                <div class="filaForm" >


                                </div>
                                <fieldset>
                                    <legend>Anexo</legend> 
                                    <div class="filaForm">
                                        <div class="lblc" style="width:127px;"><label for="cmbTipAneBaseLegal"><Strong>Tipo de Anexo:</Strong></label></div>
                                        <div style="">
                                        	<input id="cmbHideTipoAnexoBaseLegal" value="${detalleBaseLegal.tipoAnexo}" style="display:none;"/>
                                            <select id="cmbTipAneBaseLegal" name="tipoAnexo" validate="" >
                                            </select>
											<!--Rsis 1 - Inicio -->
											<div class="lblc">
												<label id="lblNumeroAnexo" for="cmbNumeroAnexo" style="display:none;"><strong>N°:</strong></label>
											</div>
											<div style="width: 200px;">
												<input id="cmbHideNumeroAnexo"
													value="${detalleBaseLegal.numeroAnexo}"
													style="display: none;" /> <select id="cmbNumeroAnexo"
													name="numeroAnexo" validate="" style="display:none;">
												</select>
											</div>
											<!--Rsis 1 - Fin -->
                                        </div>
                                    </div>
                                    <div id="divAnexoBaseLegal" style="display:none;">
                                        <div class="filaForm">
                                            <div class="lblc" style="width:127px;"><label for="txtArtAneBaseLegal"><Strong>Artículo:</Strong></label></div>
                                            <div style="width:200px;">
                                                <input id="txtArtAneBaseLegal" value="${detalleBaseLegal.articuloAnexo}" name="articuloAnexo" validate="[SN]" type="text" maxlength="3">
                                            </div>
                                            <div class="lblc" ><label for="txtInc3BaseLegal"><strong>Inciso Nivel 1:</strong></label></div>
                                            <div style="width:200px;">
                                                <input id="txtInc3BaseLegal" value="${detalleBaseLegal.incisoUnoAnexo}" name="incisoUnoAnexo" type="text" style="" maxlength="3">
                                            </div>
                                            <div class="lblc"><label for="txtInc4BaseLegal"><strong>Inciso Nivel 2:</strong></label></div>
                                            <div style="">
                                                <input id="txtInc4BaseLegal" value="${detalleBaseLegal.incisoDosAnexo}" name="incisoDosAnexo" type="text" style="" maxlength="3">
                                            </div>

                                        </div>
                                        <div class="filaForm"> 
                                            <div class="lblc" style="width:127px;" ><label for="dateFecVigenciaNorma" >Fecha Entrada Vigencia: </label></div>
                                            <div style="width:200px;">
                                                <input id="dateFecVigenciaNormaAnexo" value="" name="" type="text" readonly>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>


                                <div class="filaForm" >

                                </div>      
                                <fieldset>
                                    <legend>Norma Técnica</legend>
                                    <div class="filaForm" style="height:50px;" >
                                        <div class="lblc" style="vertical-align:top;width:127px"><label for="cmbNorTecBaseLegal" ><strong>Tipo de Norma Técnica:</strong></label> </div>
                                        <div class="lble" style="width:200px;vertical-align: top;" >
                                            <input id="cmbHideNormaTecnicaBaseLegal" value="${detalleBaseLegal.tipoNormaTecnica}" style="display:none;">
                                            <select id="cmbNorTecBaseLegal" name="tipoNormaTecnica" validate="" >
                                            </select>
                                        </div>  
                                        <!-- PR119 - Item 22 - Inicio -->
                                        <!--<textarea id="txtDesNorTecBaseLegal" value="${detalleBaseLegal.descripcionNormaTecnica}" name="descripcionNormaTecnica" validate="" maxlength="300" hidden="true" style="height:40px;width:569px;vertical-align:bottom;" placeholder="Norma">${detalleBaseLegal.descripcionNormaTecnica}</textarea>-->
                                        <textarea id="txtDesNorTecBaseLegal" value="${detalleBaseLegal.descripcionNormaTecnica}" name="descripcionNormaTecnica" validate="" maxlength="300" hidden="true" style="height:40px;width:300px;vertical-align:bottom;" placeholder="Norma">${detalleBaseLegal.descripcionNormaTecnica}</textarea>
                                        <seg:botonTag code="MO" value="Agregar"  styleClass="btn_a btn_small" id="btnAgregarNormaTecnica" onclick="" />
                                        <!-- PR119 - Item 17 - Fin -->
                                    </div>
                                    <!-- PR119 - Item 17 - Inicio -->
                                    <br>
                                    <div align="center">
                                        <table id="tblNormaTecnica"></table>
                                        <div id="pNormaTecnica"></div>
                                    </div>
                                    <br>
                                    <div id="inputsDetalleNorma">
<!--                                         <input type="checkbox" name="detalleNormaTecnica[0].idTipoNormaTecnica"  id="cmb" value="1" checked> -->
<!--                                         <input type="checkbox" name="detalleNormaTecnica[1].idTipoNormaTecnica"  id="cmb" value="2" checked> -->
                                    </div>
                                 <!-- PR119 - Item 17 - Fin -->
                                </fieldset>
                                <div class="filaForm" >
                                    <br>
                                </div>
                                <div class="filaForm" >
<!-- 05/11/2015 -->
<!--                                <div style="width:140px;"><label for="" > </label></div>                                     -->
                                    <div style="width:200px;">
                                        <input id="chkModificatoria" type="checkbox" name="modificatoria" value="${detalleBaseLegal.modificatoria}">
                                        <label for="chkModificatoria" class="checkbox">Modificatorias</label>
                                    </div>
                                    <div style="width:200px;" >
                                        <input id="chkConcordancia" type="checkbox" name="concordancia" value="${detalleBaseLegal.concordancia}">
                                        <label for="chkConcordancia" class="checkbox">Concordancia</label>
                                    </div>
                                </div>
<!-- 4 -->
                                <div class="filaForm">
                                    <br>
                                </div>
                                <div class="filaForm">                                   
                                </div>
								<div class="filaForm titCustomize">Bases Legales en Concordancia:</div>
								<div class="filaForm"></div>
                                <div id="divDescripcionObligacionConcordancia" style="display: none;" >
                                	<div class="titCustomize">
	                                	<div class="filaForm">
											<seg:botonTag id="btnAsociaBaseLegalConcordancia" code="IN" value="Asociar" onclick="" styleClass="a-ipt-r"><span class="pui-button-icon-left ui-icon ui-icon-document"></span></seg:botonTag>
<!-- 	                                	<a id="btnAsociaBaseLegalConcordancia">Asociar</a> -->
	                                	</div>
	                                	<div id="gridContenedorObligConcordancia"></div>
	                                    <div id="divContextMenuObligConcordancia"></div>
                                    </div>
                                </div>
								

                                                      </div>
                                                      <div class="filaForm">
                                    <br>
                                    <br>
                                    <div class="lblc" style="width:140px;vertical-align: top;"><label for="txtDesConcatenado" >Descripción Base Legal:</label></div>
                                    <div style="">
                                    
                                        <textarea id="txtDesConcatenado" name="" maxlength="2000"  style="width:781px;vertical-align:bottom;" value="${baseLegal.descripcionGeneralBaseLegal}" rows="3">${baseLegal.descripcionGeneralBaseLegal}</textarea>
                                        <textarea id="txtDesConcatenadoOculto" name="descripcionGeneralBaseLegal" style="display: none" maxlength="2000"></textarea>
                                    </div>

                                </div> 
                            </div>
<!--  05/11/2015                            -->
                            <div id="toggAsigna" style="display: none;">
	                                <div class="filaForm" >
<!-- 	                                	<div style="width:140px;"><label for=""> </label></div> -->
		                                <div style="width:200px;" >
											<input id="chkCrearObligacion" type="checkbox" name="obligacion" value="${baseLegal.obligacion}" >
											<label for="chkCrearObligacion" class="checkbox">Obligación</label>
										</div>
	                                </div>
									<div class="filaForm titCustomize">Listado de Obligaciones Asociadas:</div>
									<div class="filaForm"></div>
	                                <div id="divCrearObligacionUnica" style="display: none;">
	                                   <div class="titCustomize">
	                                    	<div class="filaForm">	   
	                                    		<seg:botonTag id="btnNuevaObligacionNormativa" code="IN" value="Nuevo" onclick="" styleClass="a-ipt-r"></seg:botonTag>
<!-- 												<a id="btnNuevaObligacionNormativa">Nuevo</a>-->
												<seg:botonTag id="btnAsociarObligacionNormativa" code="IN" value="Asociar" onclick="" styleClass="a-ipt-r"></seg:botonTag>
<!-- 	                                        	<a id="btnAsociarObligacionNormativa">Asociar</a> -->
	                                    	</div>
	                                    <div id="gridContenedorOblig" ></div> <!-- style="float: left; width: 81%" -->
	                                    <div id="divContextMenuOblig"></div>
	                                    </div>
	                                    <!-- PR0013 - Inicio -->
					                    <div id="divTagEnlacesNormaLegal" style="display:none;">
											<div id="divEnlaceTagVerNormaLegalHijo">
												<span class="pui-menuitem-icon ui-icon ui-icon-search"></span>
												<seg:enlaceTag id='linkVerObligacionDetalle' code='CO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
												<span>Ver Detalle</span>
											</div>
											<div id="divEnlaceTagEditarNormaLegalHijo">
												<span class="pui-menuitem-icon ui-icon ui-icon-pencil"></span>
												<seg:enlaceTag id='linkEditarObligacionDetalle' code='MO' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
												<span>Editar</span>
											</div>
											<div id="divEnlaceTagEliminarNormaLegalHijo">
												<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
												<seg:enlaceTag id='linkEliminarObligacion' code='EL' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
												<span>Eliminar</span>
											</div>
										</div>
										<!-- PR0013 - Fin -->
	                                 </div>
                              </div>
                            
                            <div>
                                <br>
                            </div>
						
                        </form> 

                        <div id="botones">
                        	<seg:botonTag code="MO" value="Guardar"  styleClass="btn_a btn_small a-ipt-a" id="btnEditarBaseLegal" title="Editar Base Legal" onclick=""/>
<!--                             <button id="btnEditarBaseLegal" type="button" title="Editar Base Legal" style="display:none;">Guardar</button> -->
<!--                             <button id="btnNuevaBaseLegal" type="button" title="Agregar Base Legal" class="btnSimple">Guardar</button> -->
                            <seg:botonTag code="IN" value="Guardar"  styleClass="btn_a btn_small" id="btnNuevaBaseLegal" title="Agregar Base Legal" onclick=""/>
                            <button id="btnCerrar" title="Cerrar" class="">Cerrar</button>
                        </div>


                    </div>
                </div>
                <div id="newObligacionNormativa">
                    <div id="dialogAgregarObligacionNormativa"   title="OBLIGACI&Oacute;N NORMATIVA" >
                    	<div id="toggCabeceraObligacion" >
                    	<div id="cabeceraObligacion" >
                        <form id="frmNuevaOblNorm" >
                            <input name="codTrazabilidad" type="hidden" value="${codTrazabilidad}">
<!-- 05/11/2015 -->
                            <input id="txtidBaseLegalByObligacion" name="idBaseLegal" style="display:none;"  value="${baseLegal.idBaseLegal}" />
                            <!-- PR119 - Item 18 - Inicio -->
                            <input id="txtidBaseLegalConcordancia" name="idBaseLegalConcordancia" style="display:none;"  value="" />
                            <div id="baseLegalConcordancia">
                            </div>
                            <!-- PR119 - Item 18 - Fin -->
                            
                            <div id="divMensajeValidacionObl" class="errorMensaje" tabindex='1' style="display: none" ></div>
                            <div id="divMensajeValOblNor" class="errorMensaje" tabindex='1' style="display: none" >Se debe registrar la Obligación Normativa</div>
                            <div class="filaForm">
                            <div style="width:23%;">
                            <div style="width:200px;display: none;">
                            <input id="idObligacion" name="idObligacion" style="display:none;"/>
                                        <input id="codBaseLegal" name="codigoBaseLegal" validate="" type="text" maxlength="100" />
                                    </div>
                                    <div id="lblCodigo" class="slcta"><label for="txtCodOblNor">Código Obligación Normativa:</label></div>
                                    
                                </div>
                                <div style="width:57%;">
                                    <div >
                                        <input id="txtCodObl" name="codigoObligacion" value="${CodigoOblg}${codObligacionEditar}" type="text" maxlength="10" style="display: none;"/>
                                        <input id="txtCodOblVer" name="" value="" type="text" maxlength="10" validate="" style="display: none;"/>
                                        <input id="txtCodOblNor" name="" value="${CodigoOblg}${codObligacionEditar}" type="text" maxlength="10" />
                                    </div>
                                </div>
                                <div style="text-align: center;">
<!--                                 	<input id="btnEliminarObligacion" class="btn_a btn_small" type="button" value="Eliminar" style="display: none;"> -->
                                	<seg:botonTag code="EL" value="Eliminar"  styleClass="btn_a btn_small a-ipt-a" id="btnEliminarObligacion" title="Eliminar" onclick=""/>
                                </div>
                            </div>
                                <div style="width:100%;" class="filaForm" ></div>
                            <div class="filaForm">   
                                <div style="width:23%;" class="vat">
                                    <div class="slcta" ><label for="txtDesOblNor">Descripción Obligación Normativa(*):</label></div>
                                </div>
                                <div style="width:57%">
                                    <textarea id="txtDesOblNor" validate="[O]" rows="4" class="" name="descripcionObligacion" style="width:95%" maxlength="4000"></textarea>
                                </div>
                                
			                    </div> 
			                    
			                    
			                    <div class="filaForm" >
			                    <div class="lble" class="vam" style="width:23%;"><label for="cmbCriOblNor">Criticidad de Obligación Normativa:</label></div> 
			                    <div class="vam">
       																<input id="cmbHideCriticidadObligacion" value="" style="display:none;"/>
                       <select id="cmbCriOblNor" validate="" name="criticidadObligacion">
                       <option value="">--Seleccione--</option>
                      	</select>	
                      	</div>
                      	<div class="vam" >&nbsp;&nbsp;&nbsp;</div>
                      	<div class="vam">
                      	<button id="imgCarOblNor" style="display: block;">Doc. Adjuntos</button>
                      	</div>
                        <div class="vam">&nbsp;&nbsp;<label id="lblDocAdjExtOblNor">(.png)</label></div>
                                    <div id="divDownloadImg" class="vam" style="padding-left:5px;"></div>
                                    <div class="vam" ><label id="lblFileCargado" ></label></div>
                       </div>             
                      	<div style="width:100%;"><br></div>
                      	<div style="clear:both;"></div>
                      	<div id="obligatorio">(*) Campos obligatorios</div>
                                <div style="width:100%;"><br></div>
                                <div ></div>                               
                                        <div style="text-align:center;">
                                        <button id="btnNuevaOblNor" type="button" title="Registrar Obligación Normativa" class="btnSimple">Guardar</button>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button id="btnCerrarOblNor" title="Cerrar" class="btnSimple" type="button" >Cerrar</button>
			                    	<button id="btnCerrarOblNorVerDetalle" title="Cerrar" class="" style="display:none;">Cerrar</button></div>
                                	
			                    	<!--<button id="btnGuardarNuevo" type="button" title="Registrar Nueva Obligación Normativa" class="btnSimple">Guardar y Nuevo</button>-->     
			           </form>
         </div>
                                
                    	</div>
                    	
                    	</div>
                    			<div id="toggDetalle" style="background:none repeat scroll 0 0 ;display: block;overflow: hidden;padding: 2px 0 2px 5px;text-align: center;width: 930px;"></div>
                    	<div><br></div>			
                                <div id="toggObligacion" class="titCustomize">

                                    <div id="tabNueOblNor" style="width:920px;">
                                        <ul>
                                            <!--Rsis 11 - Inicio-->
                                            <!--
                                            <li><a href="#tabTip">Tipificación</a></li>
                                            <li><a href="#tabPau">Criterios</a></li>
                                            <li><a href="#tabDes">Descripciones</a></li>
                                            <li><a href="#tabReferencia">Referenciar Base Legal</a></li>
                                            <li><a href="#tabAsignar">Tipo de Supervisión</a></li>
                                            <li><a href="#tabRelaciones">Temas</a></li>
                                            -->
                                        	<li id="tabSupervision"><a href="#tabAsignar">Tipo de Supervisión</a></li>
                                            <li id="tabSanciones"><a href="#tabTip">Sanciones</a></li>
                                            <li id="tabDescr"><a href="#tabDes">Descripciones</a></li>
                                            <li id="tabRef"><a href="#tabReferencia">Referenciar Base Legal</a></li>                                            
                                            <li id="tabRelac"><a href="#tabRelaciones">Temas</a></li>
											<li id="tabMedSeg"><a href="#tabMedidaSeguridad">Medida
												de Seguridad</a></li>
											<!--Rsis 11 - Fin-->
                                        </ul>
                                        <div id="tabTip">
                                          <!-- PR119 - Item 7 - Inicio -->
                                          <div id="fldstTipificaciones">
			                                <h3>Tipificaciones</h3>
			                              <!-- PR119 - Item 7 - Fin --> 
                                            <div id="tipificacionEditarObligacion">
                                                <div id="divMensajeValidacionAdicionarTipificacion" class="errorMensaje" tabindex='1' style="display: none" ></div>
                                                <div id="divContenidoTipificacion" >
                                                <div class="filaForm">
                                                    <div style="width:150px;"><label for="txtTipifOblNor">Tipificación:</label></div>   
                                                    <div>
                                                        <input type="text" id="txtIdTipificacion" name="value" style="display: none" />
                                                        <input type="text" id="txtTipifOblNor" validate="" name="tipificacionObligacion" style="width:100px;" maxlength="20">
                                                    </div>
                                                    <div class="lblc" style="width:160px;"><label for="txtDesTipifOblNor">Descripción de la Infracción:</label></div>   
                                                    <div>
                                                        <!-- PR119 - Item 7 - Inicio -->
                                                        <!--<input type="text" id="txtDesTipifOblNor" name="value" style="width:416px;" disabled="disabled" maxlength="500"/>-->
                                                        <input type="text" id="txtDesTipifOblNor" name="value" style="width:350px;" disabled="disabled" maxlength="500"/>
                                                        <!-- PR119 - Item 7 - Fin --> 
                                                    </div>
                                                </div>
                                                <div class="filaForm">

                                                    <div style="width:150px;"><label for="spinhastaOblNor">Sanción Monetaria (Hasta):</label></div>   
                                                    <div>
                                                        <input id="spinhastaOblNor" name="value" style="width:95px;">
                                                    </div>
                                                    <div style="width:20px;"><label for="spinhastaOblNor">UIT</label></div>
                                                    <div class="lblc" style="width:136px;"><label for="txtBaseLegalTipificacion">Base Legal:</label></div>   
                                                    <div>
                                                        <!-- PR119 - Item 7 - Inicio -->
                                                        <!--<input type="text" id="txtBaseLegalTipificacion" name="value" style="width:416px;" disabled="disabled" />-->
                                                        <input type="text" id="txtBaseLegalTipificacion" name="value" style="width:350px;" disabled="disabled" />
                                                        <!-- PR119 - Item 7 - Fin -->
                                                    </div>
                                                </div>
                                                <fieldset>
                                                    <legend>Otras Sanciones</legend>
                                                    <div id="dvTipSan" class="filaForm" style="margin-left:15px;">
                                                      <div id="divTipSan"></div>
                                                    </div>
                                                </fieldset>
                                                <div><br></div>
                                                </div>
                                                <div id="botones">
<!--                                                     <button id="btnAgregarTipificacion">Asociar</button> -->
                                                    <seg:botonTag code="IN" value="Asociar" styleClass="btn_a btn_small" id="btnAgregarTipificacion" title="Asociar" onclick=""/>
                                                </div>
                                                <div><br></div>
                                                <!-- PR119 - Item 7 - Inicio -->
                                                <div style="border:0px black solid;padding:2px;margin:0px 0px 6px 0px;background:none repeat scroll 0 0 #e5e5e7;">Listado de Tipificaciones :</div>
	                                            <div id="divContextMenuTipificacion"></div>
	                                            <div id="gridTipificacion"></div>
	                                            <!-- PR119 - Item 7 - Fin -->
                                            </div>
                                            
                                            <!-- PR119 - Item 07 - Inicio -->
<!--
                                          <div id="divDocumentoAdjuntoDetalle" class="filaForm" >
                                            <div style="width:180px;"></div>
                                            <div><input id="btnSubirDocumentoAdjuntoDetalle" class="btn_a btn_small" type="button" value="Doc. Adjuntos"></div>
                                                <div id="divDownloadDetalleImg" class="vam" style="padding-left:5px;">
-->
<!--                                                     <a id="lnkDownloadArchivoDescripcion" href="" ><img id="imgFilDesOblNor" style="cursor: pointer;"  height="24" width="20" hidden="true" src="/myc/images/stickers.png"/></a> -->
<!--
                                                </div>
                                                <div style="vertical-align: middle"><label>(.png)</label></div>
                                            </div>
                                            
                                            <div class="filaForm" style="display: none">
                                                <div class="lble vat" style="width:200px;"><label for="txtDescObligacionNormativaGuia">Descripción Obligación Normativa (Guia):</label></div>
                                                <div>
                                                    <textarea maxlength="500" style="height:40px;width: 706px;" class="" name="descripcionGuiaObligacion" id="txtDescObligacionNormativaGuia"></textarea>
                                                </div>


                                            </div>
                                            <div class="filaForm" style="display: none">
                                                <div class="lble vat" style="width:200px;"><label for=""></label></div>

                                                <div class="vam">
-->												
                                                    <!--                                <button id="imgUpload" class="btnSimple" title="Subir Archivo"  type="button">Subir Archivo</button>-->
<!--													
													

                                                    <button id="btnCargarDescOblNor" >Doc. Adjuntos</button>


                                                </div>
                                                <div style="vertical-align:middle;">
                                                    <img id="imgFileDescCargaOblNor" height="24" width="20" hidden="true" src="/myc/images/stickers.png"/>
                                                    <label id="lblDescFileCargado" ></label>
                                                </div>     
                                            </div>
                                            <div class="filaForm"><br></div>
                                            <div id="botones">
                                            	<seg:botonTag code="MO" value="Guardar" styleClass="btn_a btn_small" id="btnAgregarDescripcion" title="Guardar" onclick=""/>
-->												
<!--                                                 <button id="btnAgregarDescripcion">Guardar</button> -->
<!-- 
                                            </div>

                                        </div>
                                        <div id="tabPau">
                                        <div id="divMensajeValidacionOblCriterio" class="errorMensaje" style="display:none;" tabindex="1"></div>
-->
                                      <!-- PR119 - Item 07 - Fin -->
                                            
                                            <!-- PR119 - Item 07 - Inicio -->
                                       		<h3>Criterio</h3> 
                                            <!-- pestaña unida -->
                                           <div id="criterioEditarObligacion">
                                            <div id="divMensajeValidacionOblCriterio" class="errorMensaje" style="display:none;" tabindex="1"></div>
                                           <!-- PR119 - Item 07 - Fin -->
                                            <div id="criterioObligacionEditar">
<!-- 05/11/2015 -->
                                            <form id="formCriterio">                     
                                            <div class="filaForm">
                                            <div style="width:150px;"><label for="cmbTipiCriterio">Tipificación:</label></div>   
                                            	<div>                                                	
                                                    <select style="width:120px;" id="cmbTipiCriterio" name="idTipificacion" class="lbld" validate="[O]" >
				                                            <option value="">--Seleccione--</option>
				                                    </select>
                                            	</div>
                                            </div>
                                            
                                            <div class="filaForm">
                        						<div class="vat" style="width:150px;"><label for="txtIncumplimientoCriterio">Incumplimiento:</label></div>
                        						<div>
                        							<!-- PR119 - Item 22 - Inicio -->
                        							<!--<textarea id="txtIncumplimientoCriterio" style="width: 700px;" value="" name="descripcion" class="lbld" maxlength="400" rows="2" validate="[O]" ></textarea> -->
                            						<textarea id="txtIncumplimientoCriterio" style="width: 650px;" value="" name="descripcion" class="lbld" maxlength="400" rows="2" validate="[O]" ></textarea>
                            						<!-- PR119 - Item 22 - Fin -->
                        						</div>
                    						</div>
                    						
                    						<div class="filaForm">

                                                    <div style="width:150px;"><label for="txtSancionMonetariaCriterio">Sanción Monetaria (Hasta):</label></div>   
                                                    <div>
                                                        <input type="text" id="txtSancionMonetariaCriterio" name="sancionMonetaria" style="width:95px;"  maxlength="12">
                                                    </div>
                                                    <div style="width:20px;"><label for="">UIT</label></div>
                                                    <div class="lblc" style="width:136px;"><label for="txtBaseLegalCriterio">Base Legal:</label></div>   
                                                    <div>
                                                        <!-- PR119 - Item 22 - Inicio -->
                                                        <!--<input type="text" id=txtBaseLegalCriterio name="baseLegal" style="width:416px;" maxlength="1000"/>-->
                                                        <input type="text" id=txtBaseLegalCriterio name="baseLegal" style="width:367px;" maxlength="1000"/>
                                                        <!-- PR119 - Item 22 - Fin -->
                                                    </div>
                                            </div>
                                            <div class="form">
                                            	
							                    <div id="divProcesosCriterio" style="display:none;width: 875px;">
							                    <fieldset>
                                                    <legend>Otras Sanciones</legend>
							                        <div class="filaForm" style="margin-top: 5px;"></div>
							                        <div id="dvTituloEtapa" class="filaForm">
							                        </div>
							                        <div class="filaForm" style="margin-top: 5px;"></div>
							                        <div id="dvEtapa" class="filaForm">
							                        <div style="display: none;"><label for="divEtapa">Sanciones:</label></div>							                        
							                            <div id="divEtapa" ></div>
							                        </div>
							                        </fieldset>
							                    </div>
							                    
							                </div>
							                </form>
<!-- front_Criterio -->
                                            <input type="hidden" id="idCriteriosJuntos" />
<!-- 05/11/2015 -->
                                            <div id="botones" class="filaForm">
<!--                                            <input id="botoSubirPauta" class="btn_a btn_small" type="button" style="display: inline-block;" value="Asociar"> -->
<!--                                             	<input id="btnGuardarObliTipiCriterio" class="btn_a btn_small" type="button" style="display: inline-block;" value="Asociar"> -->
                                            	<seg:botonTag code="IN" value="Asociar" styleClass="btn_a btn_small" id="btnGuardarObliTipiCriterio" title="Asociar" onclick=""/>
                                            	
                                            </div>
                                            <div >
                                                <br>
                                            </div>
                                            </div>
                                            <div style="border:0px black solid;padding:2px;margin:0px 0px 6px 0px;background:none repeat scroll 0 0 #e5e5e7;">Listado de Criterios :</div>
                                            <div id="gridContenedorCriterio"></div>
                                            <div id="divContextMenuCriterio"></div>
                                            <div id="divContextMenuCriterioSub"></div>
                                          </div>
                                        <!-- PR119 - Item 7 - Inicio -->
										</div>
                                        </div>
                                        <div id="tabDes">
                                            <div class="filaForm">
                                           					<input id="idDetalleObligacion" style="display:none;" />
                                                <div class="lble vat" style="width:180px;"><label for="txtDescObligacionNormativaActa">Descripción Obligación Normativa (Acta y Declaración Jurada):</label></div>
                                                <div>
                                                    <textarea style="width: 670px;" rows="3" class="" name="descripcionActaObligacion" id="txtDescObligacionNormativaActa" maxlength="4000"></textarea>
                                                </div>
                                            </div>
                                            <div class="filaForm">
                                                
                                            </div>
                                            
                                            <div id="divDocumentoAdjuntoDetalle" class="filaForm" >
                                            <div style="width:180px;"></div>
                                            <div><input id="btnSubirDocumentoAdjuntoDetalle" class="btn_a btn_small" type="button" value="Doc. Adjuntos"></div>
                                                <div id="divDownloadDetalleImg" class="vam" style="padding-left:5px;">
<!--                                                     <a id="lnkDownloadArchivoDescripcion" href="" ><img id="imgFilDesOblNor" style="cursor: pointer;"  height="24" width="20" hidden="true" src="/myc/images/stickers.png"/></a> -->
                                                </div>
                                                <div style="vertical-align: middle"><label>(.png)</label></div>
                                            </div>
                                            
                                            <div class="filaForm" style="display: none">
                                                <div class="lble vat" style="width:200px;"><label for="txtDescObligacionNormativaGuia">Descripción Obligación Normativa (Guia):</label></div>
                                                <div>
                                                    <textarea maxlength="500" style="height:40px;width: 706px;" class="" name="descripcionGuiaObligacion" id="txtDescObligacionNormativaGuia"></textarea>
                                                </div>


                                            </div>
                                            <div class="filaForm" style="display: none">
                                                <div class="lble vat" style="width:200px;"><label for=""></label></div>

                                                <div class="vam">
                                                    <!--                                <button id="imgUpload" class="btnSimple" title="Subir Archivo"  type="button">Subir Archivo</button>-->

                                                    <button id="btnCargarDescOblNor" >Doc. Adjuntos</button>


                                                </div>
                                                <div style="vertical-align:middle;">
                                                    <img id="imgFileDescCargaOblNor" height="24" width="20" hidden="true" src="/myc/images/stickers.png"/>
                                                    <label id="lblDescFileCargado" ></label>
                                                </div>     
                                            </div>
                                            <div class="filaForm"><br></div>
                                            <div id="botones">
                                            	<seg:botonTag code="MO" value="Guardar" styleClass="btn_a btn_small" id="btnAgregarDescripcion" title="Guardar" onclick=""/>
<!--                                                 <button id="btnAgregarDescripcion">Guardar</button> -->
                                            </div>
                                        <!-- PR119 - Item 7 - Fin -->
                                        </div>
                                        <div id="tabReferencia">
                                            <div id="asociaObligacionEditar" >
                                            <div class="filaForm">
                                            <seg:botonTag code="IN" value="Asociar" styleClass="btn_a btn_small" id="btnAsociaNuevaBaseLegal" title="Asociar" onclick=""/>
<!--                                             <input id="btnAsociaNuevaBaseLegal" class="btn_a btn_small" type="button"  value="Asociar"> -->
		                                    </div>
                                            <br>
                                            </div>
                                            <div style="border:0px black solid;padding:2px;margin:0px 0px 6px 0px;background:none repeat scroll 0 0 #e5e5e7;">Listado de Bases Legales Asociadas:</div>
                                            <input id="recepciona" type="text" hidden="true"/>
                                            <div id="gridContenedorBasesLegalesAsociadas"></div>
                                            <div id="divContextMenuBasesLegalesAsociadas"></div>
                                        </div>
                                        <div id="tabAsignar">
                                        <div style="border:0px black solid;padding:2px;margin:0px 0px 6px 0px;background:none repeat scroll 0 0 #e5e5e7;">Listado de Configuraciones:</div>
											<div id="gridCnfOblg"></div>
											<div id="divContextCnfOblg"></div>
											<div style="clear:both;"><br></div>
                                            <div id="asignarArbolActividades" class="">
                                                <ul>
                                                    <li><a href="#divStepUno">Rubros</a></li>
                                                    <li><a href="#divStepDos">Tipo de Proceso</a></li>
                                                    <li><a href="#divSteptres">Obligaciones Tipo</a></li>
                                                    <li><a href="#divStepCuatro">Confirmación</a></li>
                                                </ul>
                                                <div>
                                                    <div id="divStepUno">

                                                        <div >
                                                            
                                                                <div id="divAsignarArbolActividades" style="height:250px;width:690px;text-align: left;">
                                                                </div>
                                                            
                                                        </div>
                                                        <div style="clear:both;"><br></div>
                                                        <div style="float:right;">
                                                            <input id="inputCodigoActividad" style="display:none;"/>
                                                            <input id="inputDescActividad" style="display:none;"/>
                                                            <button id="btnAsociarActividadStepUno" title="Siguiente">Siguiente</button>
                                                        </div>
                                                    </div>
                                                    <div id="divStepDos">
                                                        <div>
                                                            
                                                                <div id="divAsignarArbolTipoProceso" style="height:250px;width:690px;float:left;text-align: left;">
                                                                </div>
                                                            
                                                        </div>
                                                        <div style="clear:both;"><br></div>
                                                        <div style="float:left;">
                                                            <input id="inputTipoProceso" style="display:none;"/>
                                                            <input id="inputDescTipoProceso" style="display:none;"/>
                                                            <button id="btnAsociarActividadStepDosRegresar" title="regresar">Regresar</button>
                                                            
                                                        </div>
                                                        <div style="float:right;">
                                                            <button id="btnAsociarActividadStepDos" title="siguiente">Siguiente</button>
                                                        </div>
                                                    </div>
                                                    <div id="divStepTres">
                                                        <div >
                                                            
                                                                <div id="divAsignarArbolObligacionTipo" style="height:250px;width:690px;float:left;text-align: left;display:none;">
                                                                </div>
                                                         
                                                        </div>
                                                        <div style="clear:both;"><br></div>
                                                        <div style="float:left;">
                                                        	<input id="inputObligacionTipo" style="display:none;"/> 
                                                        	<input id="inputDescObligacionTipo" style="display:none;"/>                                                       	
                                                            <button id="btnAsociarActividadStepTresRegresar" title="regresar">Regresar</button>
                                                            
                                                        </div>
                                                        <div style="float:right;">
                                                            <button id="btnAsociarActividadStepTres" title="siguiente">Siguiente</button>
                                                        </div>
                                                    </div>
                                                    <div id="divStepCuatro" >
                                                    	<div id="gridContenedorConfiguracionSupervision"></div>
                                                    	<div id="divContextPreCnf"></div>
<!--                                                     	<div id="divConfigObligacion" ></div> -->
                                                       <div style="clear:both;"><br></div>
                                                        <div id="divBotonesConfigurar" style="float:left;">
                                                            <button id="btnAsociarActividadStepCuatroRegresar" title="Regresar">Regresar</button>
                                                            
                                                        </div>
                                                        <div style="float:right;">
                                                        <seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarRelacionStepCuatroRegresar" title="Guardar" onclick=""/>
<!--                                                           <button id="btnGuardarRelacionStepCuatroRegresar" title="Guardar">Guardar</button> -->
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                        </div>
                                        <div id="tabRelaciones" style="height: 360px;width:880px;overflow: hidden;">
                                            <div style="width:55%;float:left;">
                                                <div ><label for="cmbTipOblNor">Tema de Obligación Normativa:</label></div>
                                            </div>
                                            <div style="width:10%;float:left;"></div>
                                            <div style="width:35%;float:right;"></div>
                                            <div style=" width:55%;float:left;">
                                                <div id="temaObligacion">
                                                    <input id="inputCodigoTemas" style="display: none;">
                                                            <div id="divArbolTemasObligacion" style="height:280px;width:890px;float:left;text-align: left;" >
                                                            </div>
                                                    </div>
                                            </div>
                                            <div style="width:10%;float:left;"></div>
                                            <div style="width:35%;float:right;">
                                            </div>
                                            <div style="clear:both;"><br></div>
                                            <div id="botones">
                                            <seg:botonTag code="MO" value="Guardar" styleClass="btn_a btn_small" id="btnRelacionesObligacion" title="Guardar" onclick=""/>
<!--                                             	<button id="btnRelacionesObligacion" type="button" title="Registrar Relaciones Obligacion Normativa" class="btnSimple">Guardar</button> -->
                                            </div>
                                        </div>
                                        <!-- Rsis 9 Inicio -->
						<div id="tabMedidaSeguridad"
							style="height: auto; width: 880px; overflow: hidden;">
							<div id="fldstMedidaSeguridad">
								<h3>Infracción</h3>
								
								<div id="seguridadInfracion">
									<div id="divMensajeValMedidaSeg" class="errorMensaje" tabindex='1' style="display: none" ></div>
									<div class="filaForm">
										<input id="idInfraccion" style="display: none;" />
										<div class="lble vat" style="width: 180px;">
											<label for="txtDescInfraccion">Descripción de
												Infracción(*):</label>
										</div>
										<div>
											<textarea style="width: 625px;" rows="3" class=""
												name="descripcionInfraccion" id="txtDescInfraccion"
												maxlength="500"></textarea>
										</div>
									</div>
									<div id="divDocumentoAdjuntoDetalle" class="filaForm">
										<div>
											<input id="btnSubirDocumentoAdjuntoDetalleInfraccion"
												class="btn_a btn_small" type="button" value="Doc. Adjuntos" required>
										</div>
										<div id="divDownloadDetalleImgInfraccion" class="vam"
											style="padding-left: 5px;">
											<!--                                                     <a id="lnkDownloadArchivoDescripcion" href="" ><img id="imgFilDesOblNor" style="cursor: pointer;"  height="24" width="20" hidden="true" src="/myc/images/stickers.png"/></a> -->
										</div>
										<div style="vertical-align: middle">
											<label>(.png)</label>
										</div>
									</div>


									<div class="filaForm">
										<input id="idHideMedidaDeSeguridad" style="display: none;" />
										<div class="lble vat" style="width: 180px;">
										
											<label for="cmbMedidaSeguirdad">Medida de seguridad(*):</label>
										</div>
										<div>																						
											<input id="cmbHideMedidaSeguridad" style="display: none;" />
											<select id="cmbMedidaSeguirdad" name="MedidaSeguridad"
												validate="" style="width: 650px;">
											</select>
										</div>
									</div>

									<div class="filaForm">
										<input id="idHideCodAccion" style="display: none;" />
										<div class="lble vat" style="width: 180px;">
											<label for="idAccionMaestro">Acci&oacute;n(*):</label>
										</div>
										<div>
											<input id="cmbHideAccionInfraccion" value="${infraccion.idAccionMaestro}" style="display:none;"/>											
											<select id="cmbAccionInfraccion" name="idAccionMaestro"
												validate="" style="width: 650px;">
											</select>
										</div>
									</div>
									<div id="botones">
										<seg:botonTag code="MO" value="Guardar"
											styleClass="btn_a btn_small" id="btnGuardarInfraccion"
											title="Guardar" onclick="" />
									</div>
								</div>
							

																				
								<h3>Escenario de
									Incumplimiento</h3>
								<div class="seguridadEscenario">							
									<div>
									<div id="divMensajeValidacionAdicionarIncumplimiento" class="errorMensaje" tabindex='1' style="display: none" ></div> 
									<div class="filaForm">
										<input id="idIncumplimiento" style="display: none;" />
										<div class="lble vat" style="width: 180px;">
											<label for="cmbEscenario">Escenario:</label>
										</div>
										<div>
											<select id="cmbEscenario" name="Escenario" validate=""
												style="width: 650px;">
											</select>
										</div>
									</div>
									<div id="botones">
										<seg:botonTag code="MO" value="Asociar"
											styleClass="btn_a btn_small" id="btnAgregarIncumplimiento"
											title="Asociar" onclick="" />
										<!--                                             	<button id="btnRelacionesObligacion" type="button" title="Registrar Relaciones Obligacion Normativa" class="btnSimple">Guardar</button> -->
									</div>
									<div style="border:0px black solid;padding:2px;margin:0px 0px 6px 0px;background:none repeat scroll 0 0 #e5e5e7;">Listado de Incumplimientos :</div>
	                                            <div id="divContextMenuIncumplimiento"></div>
	                                            <div id="gridIncumplimiento2"></div>
									
									</div>
									
								</div>
									<div id="divTagEnlaces" style="display:none;">
										<div id="divEnlaceTagEliminarIncumplimiento">
										<span class="pui-menuitem-icon ui-icon ui-icon-trash"></span>
										<seg:enlaceTag id='linkEliminarIncumplimiento' code='EL' enlace='' value='' onclick='' styleClass='a-ipt'></seg:enlaceTag>
										<span>Eliminar</span>
									</div>
								</div>
							</div>
						</div>

					</div>

					<!-- Rsis 9 Fin -->
                                    </div>
                                </div>
                        
                            
                    </div>
                       
                    <div class="filaForm">
                        <br>  
                    </div>
                </div>
            </div>





        <!-- Dialog para subir Archivos  -->
        <div class="dialog" id="dlgSubImagen" title="Subir Archivo" style="display: none;">
            <fieldset>
                <legend>Subir Archivo</legend>
                <!-- modificado jpiro 20150106 - inicio -->
<!--                <div class="form">-->
                <form id="formArchivoBL"  action="/myc/pages/documentoAdjunto/subirArchivoBaseLegal" method="post" enctype="multipart/form-data" encoding="multipart/form-data" >
<!--                    <input id="desImagen" name="fileNormaLegal" type="file" />-->
                    <input id="fileImagenBL"   name="archivos[0]" placeholder="" value="" type="file" validate="[O]" />
                    <input id="txtNombreFileImagenBL" type="hidden" validate="[O]">
                    <button id="guardarImagen" class="btnSimple" title="Subir Archivo" type="button">Guardar Archivo</button>
                </form>
<!--                </div>-->
                <!-- modificado jpiro 20150106 - fin -->
                <div></div>
            </fieldset>
        </div>
        
        <!--Dialog de Confirmación -->
        <div id="dialogConfirmacionRegistroBaseLegal" class="dialog" style="display: none;"
             title="Confirmaci&oacute;n">
            <p> <span class="ui-icon ui-icon-alert" id="icon"></span>
                ¿Desea registrar la base legal?
            </p>
            <div id="botones"> 
                <button id="btnConfirmacionSiBaseLegal" type="button"  class="btnSimple">Aceptar</button>
                <button id="btnConfirmacionNoBaseLegal" type="button"  class="btnSimple">Cancelar</button>
            </div>
        </div>
        <div id="dialogConfirmacionSalirBaseLegal" class="dialog" style="display: none;"
             title="Confirmaci&oacute;n">
            <p> <span class="ui-icon ui-icon-alert" id="icon"></span>
                ¿Está seguro de cerrar la pantalla?
                No se guardara ningún cambio
            </p>
            <div id="botones"> 
                <button id="btnConfirmacionSalirSiBaseLegal" type="button"  class="btnSimple">Aceptar</button>
                <button id="btnConfirmacionSalirNoBaseLegal" type="button"  class="btnSimple">Cancelar</button>
            </div>
        </div>
        <div id="dialogConfirmacionEditarRegistroBaseLegal" class="dialog" style="display: none;"
             title="Confirmaci&oacute;n">
<!-- 05/11/2015              -->
             <div id="divDialogEditarBaseLegal" style="width:350px;">
	            <p> <span class="ui-icon ui-icon-alert" id="icon"></span>
	            <!-- OSINE_SFS-610 - Inicio -->
	            <!-- 
	                ¿Desea actualizar la base legal con codigo: <span>${baseLegal.codigoBaseLegal}</span> ?
	                -->
	                ¿Desea actualizar la base legal con c&oacute;digo: <span>${baseLegal.codigoBaseLegal}</span> ?
	            <!-- OSINE_SFS-610 - Fin -->
	            </p>
             </div>
<!-- 7 -->
            <div id="botones"> 
                <button id="btnConfirmacionEditarSiBaseLegal" type="button"  class="btnSimple">Aceptar</button>
                <button id="btnConfirmacionEditarNoBaseLegal" type="button"  class="btnSimple">Cancelar</button>
            </div>
        </div>
        <div id="dialogConfirmacionObligacionNormativaTipificacion" class="dialog" style="display: none;"
             title="Confirmaci&oacute;n">
            <p> <span class="ui-icon ui-icon-alert" id="icon"></span>
                ¿Esta seguro de guardar la obligación sin una tipificación?  
            </p>
            <div id="botones"> 
                <button id="btnConfirmacionSiObligacionNormativaTipificacion" type="button"  class="btnSimple">Aceptar</button>
                <button id="btnConfirmacionNoObligacionNormativaTipificacion" type="button"  class="btnSimple">Cancelar</button>
            </div>
        </div>
        <div id="dialogConfirmacionObligacionNormativa" class="dialog" style="display: none;"
             title="Confirmaci&oacute;n">
            <p> <span class="ui-icon ui-icon-alert" id="icon"></span>
                ¿Desea registrar la Obligación Normativa?
            </p>
            <div id="botones" style="width:390px;"> 
                <button id="btnConfirmacionSiObligacionNormativa" type="button"  class="btnSimple">Aceptar</button>                    
<!--                 <button id="btnConfirmacionOtraObligacionNormativa" type="button"  class="btnSimple">Crear Otra</button> -->
                <button id="btnConfirmacionNoObligacionNormativa" type="button"  class="btnSimple">Cancelar</button>
            </div>
        </div>
        <div id="dialogConfirmacionObligacionNormativaNuevo" class="dialog" style="display: none;"
             title="Confirmaci&oacute;n">
            <p> <span class="ui-icon ui-icon-alert" id="icon"></span>
                ¿Desea registrar la Obligación Normativa?
            </p>
            <div id="botones"> 
                <button id="btnConfirmacionSiObligacionNormativaNuevo" type="button"  class="btnSimple">Aceptar</button>
                <button id="btnConfirmacionNoObligacionNormativaNuevo" type="button"  class="btnSimple">Cancelar</button>
            </div>
        </div>

        <div id="dialogCargarNuevaOblNor" style="display:none;overflow: hidden; text-align:center;">
            <div id="divMensajeValidacionObligacionArchivo" class="errorMensaje"  style="display: none;" ></div>
            <form id="formFileOblNor"  action="/myc/pages/documentoAdjunto/subirArchivoObligacion" method="post" enctype="multipart/form-data" encoding="multipart/form-data" >
<!--                    <input id="°desImagen" name="fileNormaLegal" type="file" />-->
                    <input id="fileNuevaOblNor"   name="archivos[0]" placeholder="" value="" type="file" validate="[O]" />
                    <input id="file_NuevaOblNor" type="hidden" validate="[O]" />
                    <button id="botoGuardarFile" class="btnSimple" title="Subir Archivo" type="button">Guardar Archivo</button>
                </form>		
        </div>
            
       <div id="dialogCargarArchivoDescripcion" style="display:none;overflow: hidden; text-align:center;">
            <div id="divMensajeValidacionArchivoDescripcion" class="errorMensaje"  style="display: none" ></div>
            <form id="formFileDesOblNor"  action="/myc/pages/documentoAdjunto/subirArchivoDescripcion" method="post" enctype="multipart/form-data" encoding="multipart/form-data" >
                    <input id="fileDesOblNor"   name="archivos[0]" placeholder="" value="" type="file" validate="[O]" />
                    <input id="file_DesOblNor" type="hidden" validate="[O]">
                    <button id="botoGuardarFileDescripcion" class="btnSimple" title="Subir Archivo" type="button">Guardar Archivo</button>
                </form>		
        </div>     
		<!-- Rsis 11 - Inicio -->
	<div id="dialogCargarArchivoInfraccion" style="display: none; overflow: hidden; text-align:center;">
		<div id="divMensajeValidacionArchivoInfraccion" class="errorMensaje"  style="display: none"></div>
		<form id="formFileInfraccion" action="/myc/pages/documentoAdjunto/subirArchivoInfraccion" method="post" enctype="multipart/form-data" encoding="multipart/form-data">
			<input id="fileInfraccion" name="archivos[0]" placeholder="" value="" type="file" validate="[O]" /> 
			<input id="file_Infraccion" type="hidden" validate="[O]">
			<button id="botoGuardarFileInfraccion" class="btnSimple" title="Subir Archivo" type="button">Guardar Archivo</button>
		</form>
	</div>
	<!-- Rsis 11 - Fin -->
		
		
        <div id="dialogDescGuiaOblNor" style="display:none;overflow: hidden;">

            <form id="formDescGuiaOblNor" >

                <table>
                    <tr>
                        <td><label>Nombre Archivo:</label></td>
                        <td colspan="3">
                            <input id="fileDescGuiaOblNor"   name="archivos[0]" placeholder="" value="" type="file" class="fileUpload" />

                            <input id="file_DescGuiaOblNor" type="text" value="" name="nombreArchivo" disabled="disabled" style="width:220px;">

                        <td><button id="botoDescGuiaOblNor" type="button" title="Seleccionar Foto" class="btnGuardar" style="width:150px;">Doc. Adjuntos</button>
                            <!--  button id="add_file" type="button" title="Agregar Archivo" class="btnGuardar" onclick="javascript:validarArchivo();" >Agregar</button> </td-->

                    </tr>							

                </table>

            </form>				
            <div>
                <div id="botones">
                    <button id="botoGuardarDescFile" type="button" title="Guardar Foto" class="btnGuardar" >Guardar</button>
                    <button id="botoCerrarDescFile" type="button" title="Cancelar" class="">Cancelar</button>
                </div>
            </div>     

        </div>
<!-- dialog nueva pauta -->
<div id="dialogCriterios" title="Nuevo Criterio" style="display:none;" >

                        <form id="formCriterio" class="tac"> 
                            <div class="form">                                
                                <div class="filaForm">
                                    <div class="lble vam"><label for="txtDescCriterio">Búsqueda Criterio:</label></div>
                                    <div class="vam">
                                        <input id="txtDescCriterio" placeholder="Ingrese Descripción del Criterio" name="txtDescCriterio" type="text" maxlength="2000" style="width: 465px;" />
                                    </div>
                                </div>
                            </div>
                        </form>
                        <div id="botones">
                            <button id="btnBuscarCriterio" title="Buscar" class="btnSimple">Buscar</button>
                            <button id="btnLimpiarCriterio" title="Limpiar" class="btnSimple">Limpiar</button>
                            <button id="btnSalirCriterio" title="Salir" class="btnSimple">Salir</button>                            
                        </div>

                    <div id="gridContenedorCriterioAsociar"></div>  
                    <div id="divContextMenuCriterioAsociar"></div>
                    
                </div>

        <!-- dialog subir pautas -->
        <div id="dialogPauta" title="Nuevo Criterio" style="display:none;" >
            <div id="formNuevaCriterio">
            <div id="divMensajeValidacionCriterio" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <div style="margin:auto; display:table;">
                <div class="filaForm">
                    <div class="lble vat" style="width:94px;"><label>Descripción(*):</label></div>
                    <div><textarea id="nueva_DescripcionPauta" name="comentario" rows="2" style="width: 430px;" validate="[O]" maxlength="500"></textarea></div>  
                </div>
            </div>
            </div>
            <div >
                <br>
            </div>
            <ul>
                <li><a href="#formNuevaTipificacion">TIPIFICACION</a></li>
                <li><a href="#formNuevoCriterio">DOCUMENTO</a></li>
            </ul>
            <div>
                <div id="formNuevaTipificacion">
                    <div id="divMensajeValidacionTipificacion" class="errorMensaje" tabindex='1' style="display: none" ></div>
                    <div style="margin:auto; display:table;">
                        <input id="nueva_Tipificacion" type="hidden" name=""  />
                        <div id="gridContenedorPautaSancionTipificacion"></div>
                        <div id="divContextMenuPautaSancionTipificacion"></div>
                        <div >
                            <input id="codigoTipificacionPauta" style="display:none;"/>
                            <input id="codigoCriterio" style="display:none;"/>
                            <br>
                        </div>

                        <div class="filaForm">
                            <div class="lble vat" style="width:94px;"><label>Sanción Específica:</label></div>
                            <input id="detalleSancionEspecifica" style="display:none;"/>
                            <div><textarea id="nueva_Pauta" name="pauta" class="" rows="1" style="width: 400px;" validate="[O]" maxlength="500"></textarea></div>
<!--                            <div style="vertical-align: top;"><a id="btnSancionEspecifica" title="Agregar Sanción Específica"></a></div>-->
                        </div>
                        <div id="botones" class="filaForm"><button id="btnSancionEspecificaAgrega" >Agregar</button></div>
                        <div class="filaForm" style="display:none;">
                            <div class="lble vat" style="width:94px;"><label>Sancion:</label></div>
                            <div><textarea id="nueva_Sancion" name="sancion" class="textoMayusculas" rows="1" style="width: 430px;" validate=""></textarea></div>
                        </div>
                        </div>
                        <div>
                            <div id="gridContenedorSancionEspecifica"></div>
                            <div id="divContextMenuSancionEspecifica"></div>
                        </div>
                </div>
                </div>
                <div id="formNuevoCriterio">
                    <div id="divMensajeValidacionCriterioArchivo" class="errorMensaje" tabindex='1' style="display: none" ></div>
                    <div style="margin:auto; display:table;">
                        <div class="filaForm">
                            <div class="lble" style="width:94px;"><label>Título:</label></div>
                            <div><input id="nueva_TituloPauta" name="titulo" type="text" class="textoMayusculas" style="width:430px;" validate="[O]" maxlength="200"/></div>
                        </div>	

                    </div>

                    <div>
                        <form id="formPauta" action="/myc/pages/documentoAdjunto/subirArchivoCriterio" method="post" enctype="multipart/form-data" encoding="multipart/form-data">

                            <table>
                                <tr>
                                    <td width="88"><label>Nombre Archivo:</label></td>
                                    <td colspan="3">
                                            <input id="filePauta"   name="archivos[0]" placeholder="" value="" type="file" class="fileUpload" multiple/>
                                            <input id="file_Pauta" type="text" value="" name="nombreArchivo" disabled="disabled" style="width:220px;">
                                    <td><button id="search_filePauta" type="button" title="Seleccionar Foto" class="btnGuardar" style="width:150px;">Doc. Adjuntos</button>
                                        <!--  button id="add_file" type="button" title="Agregar Archivo" class="btnGuardar" onclick="javascript:validarArchivo();" >Agregar</button> </td-->
                                        <div style="display: inline-block; vertical-align: middle">&nbsp;<label>(.png)</label></div>
                                    </td>
                                </tr>							

                            </table>

                        </form>				
                    </div>
                    <div class="lble" style="padding-left: 94px;"><label id="obligatorio">(*) Campos Obligatorios</label></div>
                    <div id="botones">
                        <button id="btnSubirFileCriterio" type="button" title="" class="">Subir</button>
                        <div >
                            <br>
                        </div>
                    </div>
                    <div id="gridContenedorArchivoCriterio"></div>
                    <div id="divContextMenuArchivo"></div>
                    <div >
                        <br>
                    </div>                            

                    <!--Containers-->
                    <!--Container Arboles-->
                    <div id="containerDialogArbolActividadesMantenimiento"></div>
                    <div id="containerDialogArbolProductosMantenimiento"></div>
                    <div id="containerDialogArbolTransportesMantenimiento"></div>
                </div>

                <div id="botones">
                    <button id="botoGuardarPauta" type="button" title="" class="">Guardar</button>
                    <button id="botoCerrarPauta" type="button" title="Cancelar" class="">Cancelar</button>
                    <div >
                    </div>
                </div>


        </div>
        <!-- dialog asociarBaseLegal -->
        <div id="dialogAsociarBaseLegal" class="dialog tac"  title="Asociar Base Legal" style="display:none;margin: 0px 20px;"></div>
        <div id="dialogAsociarObligacion" class="dialog tac"  title="Asociar Obligación" style="display:none;margin: 0px 20px;"></div>
        
        
        <div id="dialogDependenciaCriterio" style="display:none;overflow: hidden;">
            <div id="divMensajeValidacionDependenciaCriterio" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <div>
                <div id="botones">
                    <button id="botoCerrarDependenciaCriterio" type="button" title="Aceptar" class="">Aceptar</button>
                </div>
            </div>  		
        </div>   
        
        <div id="dialogMostrarCodigoBaseLegal" style="display:none;overflow: hidden;">
            <div id="divMensajeMostrarCodigoBaseLegal" tabindex='1' ></div>
            <div>
                <div id="botones">
                    <button id="botoCerrarMostrarCodigoBaseLegal" type="button" title="Aceptar" class="">Aceptar</button>
                </div>
            </div>  		
        </div> 
        
    </body>    
</html>

