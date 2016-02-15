<%-- 
    Document   : frmMantRequisito
    Created on : 21/08/2014, 03:42:43 PM
    Author     : jpiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/requisitos/requisito/mantFrmRequisito.js" />' charset="utf-8"></script>
    </head>
    <body>
        <form id="frmMantRequisito" class="tac">  
            <div id="divMensajeValidaRequisito" class="errorMensaje" tabindex='1' style="display: none" ></div>
            <input id="txtIdRequisito" name="idRequisito" type="hidden" value="${r.idRequisito}"/>
            <input id="txtTipo" type="hidden" value="${tipo}" />
               
            <div class="form">
                <div class="filaForm">
                    <div class="lblc vat"><label for="txtNombreRequ">DESCRIPCIÓN(*):</label></div>
                    <div>
                        <textarea name="descripcion" id="txtDescRequ" maxlength="4000" style="height:50px;" class="inputGrande" onKeyDown="cuenta()" onKeyUp="cuenta()"  validate="[O]" <c:if test="${tipo=='view'}">disabled</c:if> >${r.descripcion}</textarea>
                        <input id="edit_descp" type="hidden" value="${r.descripcion}">
                    </div>
                </div>
                <div class="filaForm" id="divRequisitosSimilares" style="display: none;">
                    <div>Advertencia: Existe(n) requisito(s) con descripción similar:</div>
                    <div id="requisitosSimilares" style="height: 50px; width: 440px; overflow: auto;"></div>
                </div>
            </div>
        </form>
            <div class="form">
                <div class="filaForm">
                    <form id="<c:choose><c:when test="${tipo != 'new'}">formArchivoEdit</c:when><c:otherwise>formArchivo</c:otherwise></c:choose>"  action="/myc/pages/requisito/subirArchivo"
						method="post" enctype="multipart/form-data" encoding="multipart/form-data" >
						
                        <div class="lblc vam"><label for="txtArchivoRequisito">DOCUMENTO ADJUNTO:</label></div>
                        <c:if test="${tipo!='view'}">       
                        <div class="vam">
                            <div id="container_input">
                                <input id="fileArchivo"   name="archivos[0]" placeholder="" value="" type="file" class="fileUpload" />
                                <input id="file_name" type="text" name="nombreArchivo" disabled="disabled"  value="${r.nombreArchivo}"> 
                                <input id="idDocumentoAdjunto" type="hidden" name="idDocumentoAdjunto" value="${r.idDocumentoAdjunto}"> 
                                <a  href="#"  id="search_file" type="button" title="Seleccionar Foto" class="button" >Examinar</a>
                            </div>
                        </div>			
                        <div class="vam fsi" style="width: 130px;"> Formatos permitidos: jpg, doc, xls, pdf, zip, xlsx, docx</div>
                        </c:if>
                        <c:if test="${tipo=='view'}">
                            <c:choose>
                            <c:when test="${nombreArchivo!=null}">
                                <a href="../pages/requisito/descargaArchivoAlfresco?aplicacionSpace=REQUISITOS&nombreArchivo=${r.nombreArchivo}&rutaAlfresco=${r.rutaAlfresco}" title="Descarga" id="idDescarga" name="descarga" class="button">Descargar Documento</a>
                            </c:when>
                            <c:otherwise>
                                <label>No existen documentos adjunto</label>
                            </c:otherwise>
                           </c:choose>
                        </c:if>
                   </form>	
                </div>
                
                <div class="filaForm">
                    <div class="lblc vat"><label for="txtComentarioRequ">COMENTARIO PREDETERMINADO:</label></div>
                    <div>
                        <textarea name="comentarioPredeterminado" id="txtComentarioRequ" maxlength="1500" style="height:50px;width: 450px;" <c:if test="${tipo=='view'}">disabled</c:if> >${r.comentarioPredeterminado}</textarea>
                        <input id="edit_comePre" type="hidden" value="${r.comentarioPredeterminado}">
                    </div>
                </div>
            </div>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <c:if test="${tipo=='new'}">
                <seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarRequ" title="Guardar Requerimiento" onclick=""/>
            </c:if>
            <c:if test="${tipo=='edit'}">
                <seg:botonTag code="MO" value="Editar" styleClass="btn_a btn_small" id="btnEditarRequ" title="Editar Requerimiento" onclick=""/>
            </c:if>
            <button title="Cerrar" class="btnCloseDialog">Cerrar</button>
        </div>
    </body>
</html>