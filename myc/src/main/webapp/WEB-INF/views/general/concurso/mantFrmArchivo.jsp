<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/javascript/app/general/concurso/mantFrmArchivo.js" />' charset="utf-8"></script>
    </head>
    <body>
        <input type="hidden" id="idConcursoDocConcurso" name="idConcurso" value="${idConcurso}">
        <form id="frmArchivoDocConcurso" class="tab" action="/myc/pages/documentoAdjunto/subirArchivo" method="post" enctype="multipart/form-data" encoding="multipart/form-data">
            <div id="divMensajeValidacionDocConcurso" class="errorMensaje" tabindex="1" style="display:none"></div>
            <table class="tableCenter" style="width: 605px;">
                <tr>
                    <td>
                        <label>Nro. Concurso:</label>
                    </td> 
                    <td>
                        ${numeroConcurso}    
                    </td>
                </tr>
                <tr>
                    <td style="width:135px;"><label>Archivo(*):</label></td>
                    <td>
                        <div id="container_input" >
                            <input type="file" id="txtArchivoDocConcurso" name="archivo">
                            <input id="txtFileNameDocConcurso" type="text" disabled="disabled" name="nombreArchivo" validate="[O]">
                            <a id="search_file" class="button" href="#">Buscar archivo</a>
                        </div>
                    </td>
                </tr>
            </table>
        </form>
        <form id="frmDocConcurso" class="tab">
            <input id="hddIdDocumentoAdjuntoDocConcurso" type="hidden" name="idDocumentoAdjunto" />
            <table class="tableCenter" style="width: 605px;">
                <tr><td><label>Tipo Documento(*):</label></td>
                    <td> 
                        <select id="cmbTipoDocumentoDocConcurso" validate='[O]' name="tipoDocumentoCarga.idMaestroColumna">
                            <option value="">--Seleccione--</option>
                            <c:forEach items="${listadoTipoDocumento}" var="t">
                                <option value='${t.idMaestroColumna}'>${t.descripcion}</option>
                            </c:forEach>
                        </select>
                    </td><td>
                    </td>

                </tr>
                <tr><td><label>Fecha del Documento(*):</label></td>
                    <td> <input id="txtFechaDocConcurso" type="text" validate="[O]" name="fechaDocumento"/></td><td>
                    </td>

                </tr>
                <tr><td><label>T&iacute;tulo(*):</label></td>
                    <td> <input id="txtTituloDocConcurso" type="text" validate="[O]" name="titulo" style="width: 400px" /></td><td>
                    </td>
                </tr>

                <tr><td><label>Comentarios:</label></td>
                    <td> <textarea id="txtComentarioDocConcurso" style="width: 400px" name="comentario"></textarea></td><td>
                    </td>
                </tr>

            </table>
        </form>
        <div id="obligatorio">(*) Campos obligatorios</div>
        <div id="botones">
            <seg:botonTag code="IN" value="Guardar" styleClass="btn_a btn_small" id="btnGuardarDocConcurso" title="Guardar" onclick=""/>
            <seg:botonTag code="MO" value="Editar" styleClass="btn_a btn_small" id="btnEditarDocConcurso" title="Editar" onclick=""/>
            <input type="button" title="Limpiar" id="btnLimpiarDocConcurso" class="btn_a btn_small" value="Limpiar">
            <input type="button" title="Cerrar" class="btn_a btn_small btnCloseDialog" value="Cerrar">
        </div>
        <div align="center" >
            <div id="gridContenedorDocConcurso"></div>
            <div id="divContextMenuDocConcurso"></div>
        </div> 
    </body>
</html>
