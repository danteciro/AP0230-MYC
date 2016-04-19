var contadorObligacionTipo = 0;

$(function(){
    anularEnter();
    procesarGridNuevoObligacionTipo(0);
   // $('#btnAgregarNuevaObligacionTipo').click(btnAgregarObligacionTipo); 
    $('#btnGuardarObliTipo').click(btnGuardarNuevoObligacionTipo);  
    $('#btnEditarObliTipo').click(procEditarObligacionTipo);
    $('#btnbuscarObliTipo').click(function(){procesarGridNuevoObligacionTipo();}); 
    $('#btnLimpiarObliTipo').click(limpiaFrmMantObligacionTipo); 
    boton.closeDialog();
   
});

function btnGuardarNuevoObligacionTipo(){
	//if(jQuery("#gridObligacionTipoNuevaOT").jqGrid('getRowData').length==0 || jQuery("#gridObligacionTipoNuevaOT").jqGrid('getRowData').length==undefined){
		if ( $('#frmMantObligacionTipo').validateAllForm("#divMensajeValidaObligacionTipo") ) {
			confirm.open("¿Ud est&aacute; seguro de Guardar?","procGuardarObligacionTipo('1')");
	    }
  /*  }else{
    	confirm.open("¿Ud est&aacute; seguro de Guardar?","procGuardarObligacionTipo('2')");
    }*/
}

function procGuardarObligacionTipo(tipo){
	/*var datax=null;
	if(tipo=='1'){
		datax=$('#frmMantObligacionTipo').serialize();
	}else{
		cont=0;
		$('#gridObligacionTipoNuevaOT input').map(function(){
		  $(this).attr('name','obligaciones['+cont+'].nombre');
		  cont++;
		});
		datax=$('#frmMantObligacionTipoGrilla').serialize();
	}*/
    
    $.ajax({
        url:baseURL + "pages/obligacionTipo/registrarObligacionTipo",
        type:'post',
        async:false,
        data:$('#frmMantObligacionTipo').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                limpiaFrmMantObligacionTipo();
                procesarGridNuevoObligacionTipo();
                fill.combo(data.listadoObligacionTipo,'idObligacionTipo','nombre','#cmbObligacionTipoNuevo');
                fill.combo(data.listadoObligacionTipo,'idObligacionTipo','nombre','#cmbObligacionTipo');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

/*function btnAgregarObligacionTipo(){
    var mydata = [{
            nombre: $('#txtNombreObTipo').val()
    }];
    if(contadorObligacionTipo==0){
    	procesarGridNuevoObligacionTipo();
    }
    if(jQuery("#gridObligacionTipoNuevaOT").length>0 && mydata[0].nombre!=''){
        jQuery("#gridObligacionTipoNuevaOT").jqGrid('addRowData',contadorObligacionTipo,mydata[0]); 
	contadorObligacionTipo++;
    }
    limpiaFrmMantObligacionTipo();
}*/
function limpiaFrmMantObligacionTipo() {
    $("#txtNombreObTipo,#txtIdObligacionTipo").val("");
    $('#btnbuscarObliTipo').show();
    $('#btnGuardarObliTipo').show();
    $('#btnLimpiarObliTipo').hide();
    $('#btnEditarObliTipo').hide();
}
function eliminarNuevoObligacionTipo(rowid) {
	  confirm.open("¿Ud est&aacute; seguro de eliminar?","procEliminarNuevoObligacionTipo('"+rowid+"')");
}

function procEliminarNuevoObligacionTipo(rowid) {
    
    $.ajax({
        url:baseURL + "pages/obligacionTipo/eliminarObligacionTipo",
        type:'post',
        async:false,
        data:{idObligacionTipo:rowid},
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarGridNuevoObligacionTipo();
                fill.combo(data.listadoObligacionTipo,'idObligacionTipo','nombre','#cmbObligacionTipoNuevo');
              //  $('#dialogMantObligacionTipo').dialog('close');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
function procesarGridNuevoObligacionTipo(flg_load){
    if(flg_load==undefined){flg_load='1';}
    $("#gridContenedorObligacionTipoNuevaOT").html("");
    var grid = $("<table>", {
        "id": "gridObligacionTipoNuevaOT"
    });
    var pager = $("<div>", {
        "id": "paginacionObligacionTipoNuevaOT"
    });
    $("#gridContenedorObligacionTipoNuevaOT").append(grid).append(pager);

    var nombres = ['idObligacionTipo', 'NOMBRE','campo'];
    var columnas = [
        {name: "obligacionTipo", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "nombre", width: 500, sortable: false, hidden: false, align: "left"},
        {name: "campo", width: 100, sortable: false, hidden: true, align: "center",formatter: "inputObliTIpo"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/obligacionTipo/findObligacionTipo",
        datatype: "local",
        datatype: "json",
        postData: {
        	flg_load:flg_load,
            nombre: $("#txtNombreObTipo").val()
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionObligacionTipoNuevaOT",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Obligación Tipo",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idObligacionTipo"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkEliminarNuevoObligacionTipo').attr('onClick', 'eliminarNuevoObligacionTipo("' + rowid + '")');
            $('#linkEditarObligacionTipo').attr('onClick', 'editarMantObligacionTipo("' + rowid + '")');
            $('#linkSeleccionarResp').attr('onClick', 'obtenerTipoObligacion("'+rowid+'")');
        },
        loadComplete: function(data) {
            $('#contextMenuObligacionTipoNuevaOT').parent().remove();
            $('#divContextMenuObligacionTipoNuevaOT').html("<ul id='contextMenuObligacionTipoNuevaOT'>"
                    + "<li> <a id='linkEditarObligacionTipo' data-icon='ui-icon-pencil' title='Editar'>Editar</a></li>"
                    + "<li> <a id='linkEliminarNuevoObligacionTipo' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "<li> <a id='linkSeleccionarResp' data-icon='ui-icon-check' title='seleccionar'>Seleccionar</a></li>"
                    + "</ul>");
            $('#contextMenuObligacionTipoNuevaOT').puicontextmenu({
                target: $('#gridObligacionTipoNuevaOT')
            });
        }
    });
}
function obtenerTipoObligacion(rowid){
	$('#cmbObligacionTipoNuevo').val(rowid);
	$('#dialogNuevoObligacionTipo').dialog('close');
	
}

jQuery.extend($.fn.fmatter, {
	inputObliTIpo: function(cellvalue, options, rowdata) { 
        return '<input type="text" value="'+rowdata.nombre+'">';;
    }
});


function editarMantObligacionTipo(rowid){
	 var row = $('#gridObligacionTipoNuevaOT').jqGrid('getRowData', rowid);  
	  $('#txtIdObligacionTipo').val(rowid);
	  $('#txtNombreObTipo').val(row.nombre);
	  $('#btnbuscarObliTipo').hide();
          $('#btnGuardarObliTipo').hide();
	  $('#btnLimpiarObliTipo').show();
          $('#btnEditarObliTipo').show();
}
function procEditarObligacionTipo(){
       
    $.ajax({
        url:baseURL + "pages/obligacionTipo/editarObligacionTipo",
        type:'post',
        async:false,
        data:$('#frmMantObligacionTipo').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarGridNuevoObligacionTipo();
                limpiaFrmMantObligacionTipo();
                fill.combo(data.listadoObligacionTipo,'idObligacionTipo','nombre','#cmbObligacionTipoNuevo');
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}


