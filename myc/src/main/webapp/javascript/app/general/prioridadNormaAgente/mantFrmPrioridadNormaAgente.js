/*
* Resumen           
* Objeto            : mantFrmPrioridadNormaAgente.js
* Descripción       : JavaScript del mantenimiento de prioridad norma agente en el MYC.
* Fecha de Creación : 28/06/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Mario Dioses Fernández.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
var contadorPrioridadNorma = 0;
var mydata = [];

$(function() {
    anularEnter();
    $("#txtOrden").numeric(onlyNumericOptions);
    $('#frmMantPrioridadNormaAgente').validarForm();
    $('#btnAgregarPrioridaNorma').click(btnAgregarPrioridaNorma); 
    $('#btnGuardarPrioridadesNorma').click(btnGuardarPrioridadesNorma); 
    $("#txtOrden").keyup(function(){ if($("#txtOrden").val()==0) $("#txtOrden").val(''); });
    boton.closeDialog();
    procesarGridTipificacionAgregar();
});

function procesarGridTipificacionAgregar(){	
    $("#gridContenedorPrioridadNormaAgregar").html("");
    var grid = $("<table>", {
        "id": "gridPrioridadNormaAgregar"
    });
    var pager = $("<div>", {
        "id": "paginacionPrioridadNormaAgregar"
    });
    $("#gridContenedorPrioridadNormaAgregar").append(grid).append(pager);

    var nombres = ['idAgente', 'idBaseLegal', 'NORMA', 'PRIORIDAD'];
    var columnas = [
        {name: "idAgente", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "idBaseLegal", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "normaLegaldescripcion", width: 550, sortable: false, hidden: false, align: "left"},
        {name: "prioridad", width: 200, sortable: false, hidden: false, align: "center"}
    ];
    grid.jqGrid({
    	data: mydata,
        datatype: "local",
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#paginacionPrioridadNormaAgregar",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Normas - Prioridad",
        autowidth: true,       
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            $('#linkEliminarPrioridadNormaAgregar').attr('onClick', 'eliminarPrioridadNormaAgregar("' + rowid + '")');
        },
        loadComplete: function(data) {
            $('#contextMenuPrioridadNormaAgregar').parent().remove();
            $('#divContextMenuPrioridadNormaAgregar').html("<ul id='contextMenuPrioridadNormaAgregar'>"
                    + "<li> <a id='linkEliminarPrioridadNormaAgregar' data-icon='ui-icon-trash' title='Eliminar'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuPrioridadNormaAgregar').puicontextmenu({
                target: $('#gridPrioridadNormaAgregar')
            });
        }
    });
}
function eliminarPrioridadNormaAgregar(rowid) {
	var normaLegaldescripcion=$('#gridPrioridadNormaAgregar').jqGrid('getRowData', rowid)['normaLegaldescripcion'];
	var idBaseLegal=$('#gridPrioridadNormaAgregar').jqGrid('getRowData', rowid)['idBaseLegal'];
	var html=$('#cmbNorma').html();
	for(var i=0;i<mydata.length;i++){   
		if(mydata[i]['idBaseLegal']==idBaseLegal && mydata[i]['normaLegaldescripcion']==normaLegaldescripcion){      
			html+='<option value="'+idBaseLegal+'">'+normaLegaldescripcion+'</option>';			
			mydata.splice(i, 1);
			procesarGridTipificacionAgregar();
			$('#cmbNorma').html(html);
			fill.sortSelect('#cmbNorma', 'text', 'asc');
			break;
		}
	}
}

function btnAgregarPrioridaNorma(){
	var validar = $('#frmMantPrioridadNormaAgente').validateAllForm("#divMensajeValidaPrioridadNormaAgente");
	if (validar) {
		procAgregarPrioridadNorma();		
	}
}
function btnGuardarPrioridadesNorma(){
	if (mydata.length>0) {
      	 confirm.open("¿Ud. est&aacute; seguro de guardar estos registros?","procGuardarPrioridadesNorma()");
    } else {
    	mensajeGrowl("warn", "Ingrese informaci&oacuten correctamente.", "");
    }
}

function procAgregarPrioridadNorma(){	
	var descTipoMoneda = "";
	var idAgente=$('#txtIdAgente').val();
    var idBaseLegal = $("#cmbNorma").val();
    var normaDescripcion = $("#cmbNorma option:selected").text();
    var orden = $("#txtOrden").val();    

    if(!verificarCmbNorma(orden)){
		mydata.push({
			idAgente : idAgente,
	    	idBaseLegal : idBaseLegal,
	    	normaLegaldescripcion : normaDescripcion,
	    	prioridad : orden    	
	    });
	    procesarGridTipificacionAgregar();
	    contadorPrioridadNorma++;
	    
	    limpiaFrmMantAgregarPrioridadNorma();
    }
}

function verificarCmbNorma(prioridad){
	var exite=false;
	$.ajax({
		url:baseURL + "pages/prioridadNormaAgente/findPrioridadNormaAgente", 
        type:'get',
        async:false,
        data:{
            idAgente:$('#txtIdAgente').val(), 
            orden:prioridad
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();   
            var idAgente=$('#txtIdAgente').val();
            if(data.total==0){ 
            	for(var i=0;i<mydata.length;i++){
                	if(mydata[i].idAgente==idAgente && mydata[i].prioridad==prioridad){
                		exite=true;
                		break;
                	}                	
                }
            	if(exite) {
            		mensajeGrowl("warn", "Norma legal no se puede agregar, ingrese otro n&uacute;mero de orden.", "");
            	} else {
            		$("#cmbNorma option:selected").remove();
            		$("#txtOrden").val("");
            	}
            } else {
            	exite=true;
            	mensajeGrowl("warn", "Norma legal no se puede agregar, ya se encuentra registrada con el mismo n&uacute;mero de orden.", "");
            }
        },
        error:errorAjax
    });
	return exite;
}

function limpiaFrmMantAgregarPrioridadNorma(){
	$("#cmbNorma, #txtOrden").val("");	
}

function procGuardarPrioridadesNorma(){
    //generamos los parametros post
    var parameters = "_=p";
    for(var x = 0; x<mydata.length; x++){	
    	if(mydata[x].idAgente!=null) parameters += "&listaPrioridadNorma["+x+"].idAgente.idActividad="+mydata[x].idAgente;                          
    	if(mydata[x].idBaseLegal!=null) parameters += "&listaPrioridadNorma["+x+"].idBaseLegal.idBaseLegal="+mydata[x].idBaseLegal;
    	if(mydata[x].idBaseLegal!=null) parameters += "&listaPrioridadNorma["+x+"].orden="+mydata[x].prioridad;
	}       
	$.ajax({
		url:baseURL + "pages/prioridadNormaAgente/guardarPrioridadNorma", 
        type: 'post',
        async: false,
        data: parameters,
        success: function(data) {
        	ocultaLoading();         	
        	if(data.resultado=='0'){
        		mensajeGrowl("success", global.confirm.save); 
        		$("#dialogMantPrioridadNorma").dialog("close");
        		procesarGridNormaAgente();
            } else {
            	mensajeGrowl("error", data.mensaje);
            }
        },
        error: errorAjax
    });
}
