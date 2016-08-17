/*
* Resumen           
* Objeto            : mantFrmAgente.js
* Descripción       : JavaScript del mantenimiento de agente MYC.
* Fecha de Creación : 08/07/2015.
* PR de Creación    : OSINE_SFS-600
* Autor             : Mario Dioses Fernández.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
$(function() {
    boton.closeDialog();   
    initMantAgente();
});
function initMantAgente(){
	$('#txtNombreActividadAgente').alphanum(constant.valida.alphanum.nombre);
	$('#txtNombreAgente_').alphanum(constant.valida.alphanum.nombre);
    $('#txtCodigoAgente').alphanum(constant.valida.alphanum.numeros);
    $("#txtNumeroOrdenAgente").numeric(onlyNumericOptions);
    $("#txtNumeroOrdenAgente").keyup(function(){ if($("#txtNumeroOrdenAgente").val()==0) $("#txtNumeroOrdenAgente").val(''); });
	$('#btnBuscarAgente_').click(function(){procesarGridAgente_();});
	$('#btnGuardarAgente_').click(btnGuardarAgente);
	//procesarGridAgente_(0);
}

function procesarGridAgente_(flg_load){
	//alert("buscando agentes al guardar");	
	var requisito;
	$.ajax({
        url:baseURL + "pages/mantenimientoActividad/consultarAgente", 
        type:'get',
        async:false,
        data:{
        	idActividadPadre : $('#idActividadPadreAgente_ ').val(),
        	nombre: $('#txtNombreAgente_').val(),
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            requisito=data.filas;
        },
        error:errorAjax
    });
	
	$('#verAgente').html("");
    var html="";
    $.each(requisito,function(k,v){
        var descripcion=v['codigoPadre'] +' - '+ v['nombrePadre'];
        html += '<div class="fila" >'+
                   '<div class="ilb requ vam tal" style="width:90%;">'+descripcion+'</div>';
        html += '</div>';
    });    
    $('#verAgente').html(html);
    
//    if(flg_load==undefined){flg_load=1;}
//    
//    $("#gridContenedorAgente_").html("");
//    var grid = $("<table>", {
//        "id": "gridAgente_"
//    });
//    var pager = $("<div>", {
//        "id": "paginacionAgente_"
//    });
//    $("#gridContenedorAgente_").append(grid).append(pager);
//
//    var nombres = ['idActividadPadre','idActividad','nombre','codigo','Orden','Agente'];
//    var columnas = [
//        {name: "idActividadPadre",width: 20,sortable: false,align: "center",hidden:true},
//        {name: "idActividad",width: 20,sortable: false,align: "center",hidden:true},
//        {name: "nombre",width: 160,sortable: false,align: "left",hidden:true},
//        {name: "codigo",width: 20,sortable: false,align: "center",hidden:true},
//        {name: "orden",width: 60,sortable: false,align: "center",hidden:false},
//        {name: "nombreAgente",width: 470,sortable: false,align: "left",formatter:"agente"}
//    ];
//    grid.jqGrid({
//        url: baseURL + "pages/mantenimientoActividad/findAgente",
//        datatype: "json",
//        postData: {
//        	idActividadPadre:$('#idActividadPadreAgente_').val(),
//            nombre:$('#txtNombreAgente_').val(),
//            codigo:$('#txtCodigoAgente').val(),
//            orden:$('#txtNumeroOrdenAgente').val(),
//            flg_load:flg_load
//        },
//        hidegrid: false,
//        rowNum: global.rowNumPrinc,
//        pager: "#paginacionAgente_",
//        emptyrecords: "No se encontraron resultados",
//        loadtext: "Cargando",
//        colNames: nombres,
//        colModel: columnas,
//        height: "auto",
//        viewrecords: true,
//        caption: "Listado de Agentes XXXX",
//        autowidth: true,
//        jsonReader: {
//            root: "filas",
//            page: "pagina",
//            total: "total",
//            records: "registros",
//            repeatitems: false,
//            id: "idActividad"
//        }
//    });
}

function btnGuardarAgente(){
    var validar = $('#frmMantAgente_').validateAllForm("#divMensajeValidaAgente_");
    if($('#tipoAgente_').val()=='editar'){
    	accion='editar';
    }else if($('#tipoAgente_').val()=='nuevo'){
    	accion='guardar';
    }
    if(validar){
        confirm.open("¿Ud. est&aacute; seguro de "+accion+" el registro?","guardarAgente_()");
    }
};

function guardarAgente_() {
    $.ajax({
        url:baseURL + "pages/mantenimientoActividad/guardarActividad",
        type:'post',
        async:false,
        data:{
        	tipo: $('#tipoAgente_').val(),
        	idActividadPadre: $('#idActividadPadreAgente_').val(),
        	idActividad: $('#idActividadAgente_').val(),
        	codigo: $('#txtCodigoAgente').val(),
        	nombre: $('#txtNombreAgente_').val(),
        	orden: $('#txtNumeroOrdenAgente').val(),
        	forzarOrdenamiento: false
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
            	if($('#tipoAgente_').val()=='nuevo') 
            		mensajeGrowl("success", global.confirm.save, "");
            	else 
            		mensajeGrowl("success", global.confirm.edit, "");
                $("#dialogMantAgentes").dialog("close");
                procesarGridAgente();
            }else if(data.resultado=="RESTRICT"){
            	confirm.open(data.mensaje,"ajustarActividades_()");            	
            	procesarGridAgente();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function ajustarActividades_(){
	$.ajax({
        url:baseURL + "pages/mantenimientoActividad/ajustarActividades",
        type:'post',
        async:false,
        data:{
        	tipo: $('#tipoAgente_').val(),
        	idActividadPadre: $('#idActividadPadreAgente_').val(),
        	idActividad: $('#idActividadAgente_').val(),
        	codigo: $('#txtCodigoAgente').val(),
        	nombre: $('#txtNombreAgente_').val(),
        	orden: $('#txtNumeroOrdenAgente').val()        	
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
            	if($('#tipoAgente_').val()=='nuevo') 
            		mensajeGrowl("success", global.confirm.save, "");
            	else 
            		mensajeGrowl("success", global.confirm.edit, "");
                $("#dialogMantAgentes").dialog("close");
                procesarGridAgente();
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
