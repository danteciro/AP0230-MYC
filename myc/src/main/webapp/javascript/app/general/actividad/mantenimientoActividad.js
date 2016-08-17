/**
* Resumen		
* Objeto			: mantenimientoActividad.js
* Descripción		: JavaScript donde se centraliza el mantenimiento de Actividades.
* Fecha de Creación	: 27/06/2016.
* PR de Creación	: OSINE_SFS-600.
* Autor				: Hernán Torres Sáenz.
* =====================================================================================================================================================================
* Modificaciones |
* Motivo         |  Fecha        |   Nombre                     |     Descripción
* =====================================================================================================================================================================
*
*/
var edicionAgenteActividad = 0;

$(function() {
    procesarGridAgenteInstalacion(0);
    initInicioActividad(); 
	$('#txtAgenteInstalacion').alphanum(constant.valida.alphanum.nombre);
});

function initInicioActividad(){
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    confirm.start();
    $('#btnBuscarAgenteInstalacion').click(function(){procesarGridAgenteInstalacion();});
    $('#btnEditarAgenteInstalacion').click(function(){abrirMantAgenteInstalacion("new",'');});
    $('#btnLimpiarFormAgenteInstalacion').click(btnLimpiarFormAgenteInstalacion);
    $('#cmbActividadBusq').change(function(){
    	procesarGridAgenteInstalacion(0);
    });
}

function btnLimpiarFormAgenteInstalacion(){
    $('#formBusquedaAgenteInstalacion').find('input, select').val('');
    procesarGridAgenteInstalacion(0);
}

function abrirMantAgenteInstalacion(){  
    $.ajax({
        url:baseURL + "pages/mantenimientoActividad/abrirMantActividadAgente", 
        type:'get',
        async:false,
        data:{ },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantActividadAgente").html(data);
            $("#dialogMantActividadAgente").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                position: ['center', 'top+50'],
                modal: true,
                dialogClass: 'dialog',
                title: "MANTENIMIENTO ACTIVIDAD Y AGENTE",
                closeText: "Cerrar",
                close: function(event, ui) {   
                	console.info("" + edicionAgenteActividad);
                	if(edicionAgenteActividad == 1){
                		cargarActividadPadre();
                		procesarGridAgenteInstalacion();
                	}
                }
            });
        },
        error:errorAjax
    });
}

function cargarActividadPadre(){
	$.ajax({
        url:baseURL + "pages/mantenimientoActividad/cargarActividadPadre",
        type:'get',
        async:false,
        data:{},
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#cmbActividadBusq").html("<option value=''>--Seleccione--</option>");
            if(data.listadoActividades!=null){
                html="<option value=''>--Seleccione--</option>";
                $.each(data.listadoActividades,function(key,val){
                    html+="<option value='"+val.idActividad+"'>"+val.nombre+"</option>";
                });
                $('#cmbActividadBusq').html(html);
                edicionAgenteActividad=0;
            }
        },
        error:errorAjax
    });
}

function procGuardarActividad(){
    $.ajax({
        url:baseURL + "pages/actividad/registrarActividad",
        type:'post',
        async:false, 
        data:{idRequisito:$('#txtIdRequisito').val(),descripcion:$('#txtDescRequ').val(),comentarioPredeterminado:$('#txtComentarioRequ').val()},
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="SUCCESS"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarGridAgenteInstalacion();
                $("#dialogMantActividad").dialog("close");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}

function procesarGridAgenteInstalacion(flg_load){
    if(flg_load==undefined){flg_load=1;}
    
    $("#gridContenedorAgenteInstalacion").html("");
    var grid = $("<table>", {
        "id": "gridAgenteInstalacion"
    });
    var pager = $("<div>", {
        "id": "paginacionAgenteInstalacion"
    });
    $("#gridContenedorAgenteInstalacion").append(grid).append(pager);

    var nombres = ['idActividadPadre','Orden Actividad','Actividad','idActividad','Orden Agente','Agente y/o Instalación'];
    var columnas = [
        {name: "idActividadPadre",width: 20,sortable: false,align: "center",hidden:true},
        {name: "ordenPadre",width: 40,sortable: false,align: "center"}, 
        {name: "nombrePadre",width: 160,sortable: false,align: "left"},
        {name: "idActividad",width: 20,sortable: false,align: "center",hidden:true},
        {name: "orden",width: 40,sortable: false,align: "center"}, 
        {name: "nombre",width: 160,sortable: false,align: "left"}
    ];
    grid.jqGrid({
        url: baseURL + "pages/mantenimientoActividad/findAgenteInstalacion",
        datatype: "json",
        postData: {
        	idActividadPadre: $('#cmbActividadBusq').val(),
            nombre:$('#txtAgenteInstalacion').val(),
            flg_load:flg_load
        },
        mtype: 'POST',
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionAgenteInstalacion",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Actividades - Agentes y/o instalaciones",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idActividadPadre"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },/*
        onRightClickRow: function(rowid, iRow, iCol, e) {
        },
        loadComplete: function(data) {
        },*/
    });
}