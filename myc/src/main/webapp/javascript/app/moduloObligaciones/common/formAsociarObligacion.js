var basesLegales=[];
var item;

$(function(){
    boton.closeDialog();
    $('#txtDescrObliDetalleAsigObli').alphanum(charAllow);
    $('#formBuscarAsigObli').validarForm(); 
    $('#btnAsociarBusquedaAvanzadaBaseLegal').click(function(){asignarObligacionesAsigObli();});
    $('#btnBuscarAsigObli').click(function(){gridAsigObligacion();$('.divBtnAsociarObligacion').css('display','block');});
    //arboles
    initArbolActividadesAsigObli();
    $('#txtRubrosAsigObli').click(btnAgregarActividadAsigObli);
    initArbolTemasAsigObli();
    $('#txtTemasAsigObli').click(btnAgregarTemasAsigObli);
    
    //Validacion de Formatos
    var codigoObligacion = {
            allowNumeric  : true,
            allowLatin    : false,
            allowUpper    : false,
            allowLower    : false,
            allowCaseless : true,
            allowOtherCharSets : false,
            allowSpace    : false,
            allow    : 'OB-'
    };
    var descripcion = {
            allowNumeric  : true,
            allowLatin    : true,
            allowUpper    : true,
            allowLower    : true,
            allowCaseless : true,
            allowOtherCharSets : false,
            allowSpace    : true,
            allow         : 'áéíóúÁÉÍÓÚÑñ.'
    };
    $('#txtCodiObliAsigObli').alphanum(codigoObligacion);
    
    $('#btnLimpiarAsigObli').click(function(){
    	$('#formBuscarAsigObli').find('input[type=text],textarea,select,input[role=spinbutton]').each(function(){
        	$(this).val('');
        });
    });
    
});

function asignarObligacionesAsigObli() {
    var dataGrilla = $('#gridContenedorBuscarAsigObli').find('input:checked');
    if(dataGrilla.length>0){
        dataGrilla.map(function() {
            addObligacionesGridOblig($(this).attr('id').replace('chkObli',''), $(this).attr('codigo'), $(this).attr('descripcion'));
        });
        $("#dialogAsociarObligacion").dialog("close");
    } 
}
    
/**
 * funcion para asociar bases legales grid concordancia
 */
function addObligacionesGridOblig(id,codigo,descripcion) {
    if(validarCampos(id)){
        var idData = id;
        var rowData = {
               idObligacion : id,
               codigoObligacion : codigo,
               descripcion : descripcion
        };
        $("#gridOblig").addRowData(idData, rowData);  
    }
}
    
    /**
     * funcion para validar campos del grid
     */
function validarCampos(id){
     var retorno = true;
     var ids = $("#gridOblig").jqGrid('getDataIDs');
     for (var i = 0; i < ids.length; i++){
         var rowId = ids[i];
         var rowData = $('#gridOblig').jqGrid ('getRowData', rowId);
         if (rowData.idObligacion==id){
            mensajeGrowl("error", "Campo Repetido", "");
            retorno = false;
            break;
         }
     }
     return retorno;
 }

function gridAsigObligacion(varLista){
    if(varLista==undefined){varLista=1;}

    var nombres = ['idObligacion','Código Obligación','Descripción Obligación',''];
    var columnas = [
        {name:'idObligacion',index:'id', width:55,hidden:true}, 
        {name: "codigoObligacion",width: 100,sortable: false,align: "center"},
        {name: "descripcionObligacion",width: 800,sortable: false,align: "left"},
        {name: "checkObli",width: 50,sortable: false,align: "center",formatter: "imgCheckAsigObli"}
    ];
    $("#gridContenedorBuscarAsigObli").html("");
    var grid = $("<table>", {"id": "gridBuscarAsigObli"});
    var pager = $("<div>", {"id": "paginacionBuscarAsigObli"});
    $("#gridContenedorBuscarAsigObli").append(grid).append(pager);
    grid.jqGrid({
        url: baseURL + "pages/baseLegal/listarObligacion",
        datatype: "json",
        mtype: 'POST',
        postData: {
            codigoObligacion:$('#txtCodiObliAsigObli').val(),
            descDetalle:$('#txtDescrObliDetalleAsigObli').val(),
            idCriticidadObligacion:$('#slcCritiObliAsigObli').val(),
            idActividadesBusq:$('#idsRubrosAsigObli').val(),
            idTemasBusq:$('#idsTemasAsigObli').val(),
            flgBusqAvanzada:"1",
            varLista:varLista,
            idsObligacion:$('#idsObligacion').val()
        },
        hidegrid: false,
        rowNum: 1000,
        pager: "#paginacionBuscarAsigObli",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "300px",
        viewrecords: true,
        caption: "Busqueda Avanzada Obligaciones",
        width: "998px",
        jsonReader : {
            root : "filas",
            page : "pagina",
            total : "total",
            records : "registros",
            id:"idObligacion"
        }
    });
}
    
jQuery.extend($.fn.fmatter, {
    imgCheckAsigObli: function(cellvalue, options, rowdata) {
        return "<input type=\"checkbox\" id='" + rowdata.idObligacion+"chkObli' codigo='"+rowdata.codigoObligacion+"' descripcion='"+rowdata.descripcionObligacion+"' /> <label class='checkbox' for='" + rowdata.idObligacion + "chkObli' ></label>";
    }
});

//ARBOL ACTIVIDADES
function btnAgregarActividadAsigObli(){
    $('#popupArbolActiAsigObli').dialog({
        width: 640,height:280,modal:true,
        close: function( event, ui ) {//se destruye popup para evitar conflicto con arbol y seleccionados
            $(this).dialog('destroy');
        }
    });
}
function initArbolActividadesAsigObli(){
    var treeData=[];
    $.ajax({
        url: baseURL + 'pages/actividadesController/loadActividad',
        type: "post",
        async: false,
        data: {},
        success: function(data) {
            treeData = fxTree.build(data.filas);
        },
        error:errorAjax
    });
    $("#arbolActividadesAsigObli").fancytree({
        checkbox: true,
        selectMode: 3,
        source:treeData,
        select: function(event, data) {
            var nodosSeleccionados = $.map(data.tree.getSelectedNodes(), function(node){
                if(!node.folder){
                    return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
                }
            });
            seleccionarActividadParaAsigObli("["+nodosSeleccionados.join(",")+"]");
        },
        keydown: function(event, data) {
            if( event.which === 32 ) {
                data.node.toggleSelected();
                return false;
            }
        },
        //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
        //initId: "treeData",
        cookieId: "fancytree-Cb3",
        idPrefix: "fancytree-Cb3-"
    });
    
    $("#arbolActividadesAsigObli").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
}
function seleccionarActividadParaAsigObli(datax){
    var data=eval("("+datax+")");
    var ids=$.map(data,function(reg){return reg.id;}).join(',');
    var txts=$.map(data,function(reg){return reg.nombre;}).join(',');
    
    $('#idsRubrosAsigObli').val(ids);
    $('#txtRubrosAsigObli').val(txts);
    $('#txtRubrosAsigObli').attr('title',txts);
}
//ARBOL TEMAS
function btnAgregarTemasAsigObli(){
    $('#popupArbolTemasAsigObli').dialog({
        width: 640,height:280,modal:true,
        close: function( event, ui ) {//se destruye popup para evitar conflicto con arbol y seleccionados
            $(this).dialog('destroy');
        }
    });
}
function initArbolTemasAsigObli(){
    var treeData=[];
    $.ajax({
        //url: baseURL + 'pages/actividadesController/loadActividad',
        url: baseURL + 'pages/mantenimiento/baseLegal/obtenerTemaObligacion',
        type: "post",
        async: false,
        data: {},
        success: function(data) {
            treeData = fxTreeTema.build(data.filas);
        },
        error:errorAjax
    });
    $("#arbolTemasAsigObli").fancytree({
        checkbox: true,
        selectMode: 3,
        source:treeData,
        select: function(event, data) {
            var nodosSeleccionados = $.map(data.tree.getSelectedNodes(), function(node){
                if(!node.folder){
                    return "{id:'"+node.key+"',nombre:'"+node.title+"'}";
                }
            });
            seleccionarTemaParaAsigObli("["+nodosSeleccionados.join(",")+"]");
        },
        keydown: function(event, data) {
            if( event.which === 32 ) {
                data.node.toggleSelected();
                return false;
            }
        },
        //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
        //initId: "treeData",
        cookieId: "fancytree-Cb4",
        idPrefix: "fancytree-Cb4-"
    });
    
    $("#arbolTemasAsigObli").fancytree("getRootNode").visit(function(node){
        node.setExpanded(true);
    });
}
function seleccionarTemaParaAsigObli(datax){
    var data=eval("("+datax+")");
    var ids=$.map(data,function(reg){return reg.id;}).join(',');
    var txts=$.map(data,function(reg){return reg.nombre;}).join(',');
    
    $('#idsTemasAsigObli').val(ids);
    $('#txtTemasAsigObli').val(txts);
    $('#txtTemasAsigObli').attr('title',txts);
}