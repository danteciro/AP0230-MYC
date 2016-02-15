$(function() {
    anularEnter();
    boton.closeDialog();
    $('#frmMantMaestroColumna').validarForm();
    $('#btnEditarMaesColu').click(btnEditarMaesColu);
    $('#btnGuardarMaesColu').click(btnGuardarMaesColu);
    $('#btnAgregarDominio').click(abrirMantMaestroTabla);
    $('#btnLimpiarMaesColu').click(limpiarMaesColu);
    
    var codigo = {
    		 allowNumeric  : true,
             allowLatin    : false,
             allowUpper    : false,
             allowLower    : false,
             allowCaseless : true,
             allowOtherCharSets : false,
             allowSpace    : false,
            allow         : '-'
        };
    
    var descripcion = {
            allowNumeric  : true,
            allowLatin    : true,
            allowUpper    : true,
            allowLower    : true,
            allowCaseless : true,
            allowOtherCharSets : false,
            allowSpace    : true,
            allow         : 'áéíóúÁÉÍÓÚÑñ."()'
        };
    
    $('#txtCodigoMant').alphanum(codigo);
    $('#txtDescripcionMant').alphanum(descripcion);
    
    
    initMantMaesColu();
});
function initMantMaesColu(){
    $('#cmbDominioMant').change(function(){
        setAplicacionFromCmbDominio();
        procesarGridMaesColuMant();        
    });
    procesarGridMaesColuMant();
    ($('#tipoP').val()=="new")?$('#btnEditarMaesColu').hide():$('#btnGuardarMaesColu').hide();
    
}

//limpiar
function limpiarMaesColu(){
    $('#frmMantMaestroColumna').find('input,select,textarea').not('input:button').val("");
    $('#btnEditarMaesColu').hide();
    $('#btnGuardarMaesColu').show();
    $('#cmbDominioMant').trigger("change");
}
//editar
function editarMaesColuMant(rowid){
	
    var row=$('#gridMaesColuMant').jqGrid('getRowData',rowid); 
    if(row.esEditable=='SI'){
        $('#idMaesColuMant').val(rowid);
        $('#txtCodigoMant').val(row.codigo);
        $('#txtDescripcionMant').val(row.descripcion);

        $('#btnEditarMaesColu').show();
        $('#btnGuardarMaesColu').hide();
    }else{
        mensajeGrowl("warn", "El registro NO es editable", "");
    }
}
function btnEditarMaesColu(){
    var validar = $('#frmMantMaestroColumna').validateAllForm("#divMensajeValidaMaestroColumna");
    if(validar){
        confirm.open("¿Ud. est&aacute; seguro de guardar los cambios?","procEditarMaestroColumna()");
    }
};
function btnGuardarMaesColu(){
    var validar = $('#frmMantMaestroColumna').validateAllForm("#divMensajeValidaMaestroColumna");
    if(validar){
        confirm.open("¿Ud. est&aacute; seguro de guardar el registro?","procGuardarMaestroColumna()");
    }
};
function eliminarMaesColuMant(rowid){
    var row = $('#gridMaesColuMant').jqGrid('getRowData', rowid);
    if(row.esEditable=='NO'){mensajeGrowl("warn", "El registro NO es editable", "No puede ser Eliminado.");return false;}
    
    confirm.open("¿Ud. est&aacute; seguro de eliminar este registro?","procEliminarMaestroColumna('"+rowid+"',callbackEliminaMaesColuMant)");
}
function callbackEliminaMaesColuMant(){
    procesarGridMaestroColumna();
    procesarGridMaesColuMant();
}
function procesarGridMaesColuMant(flg_load) {
    if(flg_load===undefined){flg_load=1;}
    var dominio=$('#cmbDominioMant').val();
    if (dominio==""){flg_load=0;}
    
    $("#gridContenedorMaesColuMant").html("");
    var grid = $("<table>", {
        "id": "gridMaesColuMant"
    });
    var pager = $("<div>", {
        "id": "paginacionMaesColuMant"
    });
    $("#gridContenedorMaesColuMant").append(grid).append(pager);

    var nombres = ['ID','APLICACION','DOMINIO', 'CODIGO', 'DESCRIPCION','esEditable' ];
    var columnas = [
        {name: "idMaestroColumna", width: 50, sortable: false, hidden: true, align: "center"},
        {name: "aplicacion", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "dominio", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "codigo", width: 50, sortable: false, hidden: false, align: "left"},
        {name: "descripcion", width: 300, sortable: false, hidden: false, align: "left"},
        {name: "esEditable", width: 200, sortable: false, hidden: true, align: "left"}       
    ];
    grid.jqGrid({
        url: baseURL + "pages/maestroColumna/findMaestroColumna",
        datatype: "json",
        postData: {
            flg_load: flg_load,
            dominio:dominio,
            aplicacion:$('#cmbAplicacionMant').val()
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionMaesColuMant",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Valores del Grupo de Negocio",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idMaestroColumna"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            $('#linkEditarMaesColuMant').attr('onClick', 'editarMaesColuMant("'+rowid+'")');
            $('#linkEliminarMaesColuMant').attr('onClick', 'eliminarMaesColuMant("'+rowid+'")');
        },
        loadComplete: function(data) {
            $('#contextMenuMaesColuMant').parent().remove();
            $('#divContextMenuMaesColuMant').html("<ul id='contextMenuMaesColuMant'>"
                    + "<li> <a id='linkEditarMaesColuMant' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarMaesColuMant' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuMaesColuMant').puicontextmenu({
                target: $('#gridMaesColuMant')
            });
        }
    });
}
function setAplicacionFromCmbDominio(){
    $('#cmbAplicacionMant').val($('#cmbDominioMant').find(':selected').parent().attr('label'));
}

/////////////////////////////////
function abrirMantMaestroTabla(){
    var title="NUEVO GRUPO NEGOCIO"; 
    $.ajax({
        url:baseURL + "pages/maestroTabla/abrirMantMaestroTabla", 
        type:'get',
        async:false,
        data:{},
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantMaestroTabla").html(data);
            $("#dialogMantMaestroTabla").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "550px",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText:"Cerrar",
                close: function( event, ui ) {
                    $(this).dialog('destroy');
                }
            });


        },
        error:errorAjax
    });
}
function llenaDominioOptGroup(listadoAplicaciones,listadoDominios,idDest){
    var html='<option value="">--Seleccione--</option>';
    $.each(listadoAplicaciones,function(key,val){
        html+='<optgroup label="'+val.aplicacion+'">';
            $.each(listadoDominios,function(k,v){
               if(val.aplicacion==v.aplicacion){
                   html+='<option value="'+v.dominio+'">'+v.descripcion+'</option>';
               } 
            });
        html+='</option>';
        
    });
    $(idDest).html(html);
}
