<%-- 
    Document   : inicio
    Created on : 23/07/2014, 05:43:58 PM
    Author     : jpiro
--%>

<%@ include file="/common/taglibs.jsp"%>
<t:template pageTitle="Registro de Procedimientos" scrollPanelTitle="">
    <jsp:attribute name="headArea">
        <script type="text/javascript" src='<c:url value="/javascript/app/requisitos/requisitoProcedimiento/nuevo.js" />' charset="utf-8"></script>
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <div id="steps" class="center">
            <ul class="overflow">
                <li class="active" data-step="1">
                    <a href="javascript:void(0)">Requisitos Generales</a>
                </li>
                <li data-step="2" id="stepRequEspe" class="disabled">
                    <a href="javascript:void(0)">Requisitos Específicos</a>
                </li>
            </ul>
        </div>
        <div>
            <div id="form_registro" accept-charset="utf-8" method="post" action="#">
            	<input id="permisosSeguridad" type="hidden" value="${xxp}" />
                <input id="idProcedimento" type="hidden" value="${idProcedimiento}">
                <input id="itemP" type="hidden" value="${item}">
                <div class="container" style="position: relative;">
                    <section id="step_1" class="active toggle" data-step="1">
                        <jsp:include page="general/requGral.jsp"/>
                    </section>
                    <section id="step_2" class="toggle" data-step="2" style="display: none">
                        <jsp:include page="especifico/requEspe.jsp"/>
                    </section>
                    
                </div>
            </div>
        </div>
        
        <!-- dialogs -->
        <div id="dialogAgregarRequisito" class="dialog tac" title="Agregar Requisito" style="display:none;"></div>
        
        <!-- dialogs -->
        <div id="dialogComentarioRequ" class="dialog" title="COMENTARIO" style="display:none;">
            <form id="frmComentarioRequ" class="tac">
                <div class="filaForm">
                    <div>
                        <textarea id="txtComentarioRequ" name="nota" class="inputGrande" style="height:80px" maxlength="1500"></textarea>
                    </div>
                </div>
            </form>
            <div id="botones">
                <button id="btnAsignarComentarioRequ" title="GUARDAR">Guardar</button>
            </div>
        </div>
        
        <div id="stack" class="ui-stack">
             <a id="btnRegresar" title="Regresar"></a>
        </div>    
    </jsp:attribute>
</t:template>