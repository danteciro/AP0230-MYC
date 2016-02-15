$(function() {
	$('#default').puigrowl();
	
	procesarGridListadoActividades();	
	
	$('#btnRegresar').click(function() {
		window.location.href = baseURL + 'pages/principal/configuracionRegistro';
    });	
});

function procesarGridListadoActividades(flg_load) {	
	if(flg_load==undefined){flg_load=1;}
	
    $("#gridContenedorBusqActividad").html("");
    var grid = $("<table>", {
        "id": "idGridBusqActividad"
    });
    var pager = $("<div>", {
        "id": "idPaginacionBusqActividad"
    });
    $("#gridContenedorBusqActividad").append(grid).append(pager);

    var nombres = ['Grupo Actividad','Sub-Actividad','Actividad', 'Tipo Dirección', 'Instalación', 'Mod. Instalación', 'Estudio de Riesgo', 'Plan de Contingencia', 'Opinión Favorable', 'Actas de Verificación de Pruebas', 'Actas de Verificación de Pruebas y Conformidad', 'Actas de Verificación de Conformidad', 'Inscripción', 'Modificación de Inscripción', 'Suspensión de Parte', 'Cancelación de Parte', 'Habilitación de Parte', 'Reconsideración', 'Apelación','Conf.'];
    var columnas = [
        {name: "desGrupoActividad", index:"desGrupoActividad", sortable: false, align: "left", width: 100},
        {name: "desSubGrupoActividad", index:"desSubGrupoActividad", sortable: false, align: "left", width: 120}, 
        {name: "desActividad", index:"desActividad", sortable: false, align: "left", width: 120},
        {name: "codTipoDireccion", index:"codTipoDireccion", sortable: false, align: "center", width: 80, 
        						   edittype:"select", editable: true, 
        						   editoptions:{value:"0:--Seleccione--;1:Establecimiento;2:Instalación;3:Pernoctación",
		        							    dataInit: function(elem) {
		       	  					 			            $(elem).width(130);
		       	  				 							}
        						   				}
        },
        {name: "flgTramInstalacion", index:"flgTramInstalacion", width: 20, formatter: 'colCheckTramIns', align: 'center'},
        {name: "flgTramModInstalacion", index:"flgTramModInstalacion", width: 20, formatter: 'colCheckTramModIns', align: 'center'},
        {name: "flgTramEstRiesgo", index:"flgTramEstRiesgo", width: 20, formatter: 'colCheckTramEstRiego', align: 'center'},
        {name: "flgTramPlanContingencia", index:"flgTramPlanContingencia", width: 20, formatter: 'colCheckTramPlanContingencia', align: 'center'},
        {name: "flgTramOpinionFav", index:"flgTramOpinionFav", width: 20, formatter: 'colCheckTramOpinionFav', align: 'center'},
        {name: "flgTramActasVerif", index:"flgTramActasVerif", width: 20, formatter: 'colCheckTramVerif', align: 'center'},
        {name: "flgTramActasVerifYPrueba", index:"flgTramActasVerifYPrueba", width: 20, formatter: 'colCheckTramVerifYPrueba', align: 'center'},
        {name: "flgTramActasPrueba", index:"flgTramActasPrueba", width: 20, formatter: 'colCheckTramPrueba', align: 'center'},
        {name: "flgTramInscripcion", index:"flgTramInscripcion", width: 20, formatter: 'colCheckTramInscripcion', align: 'center'},
        {name: "flgTramModInscripcion", index:"flgTramModInscripcion", width: 20, formatter: 'colCheckTramModInscripcion', align: 'center'},
        {name: "flgTramSuspension", index:"flgTramSuspension", width: 20, formatter: 'colCheckTramSuspension', align: 'center'},
        {name: "flgTramCancelacion", index:"flgTramCancelacion", width: 20, formatter: 'colCheckTramCancelacion', align: 'center'},
        {name: "flgTramHabilitacion", index:"flgTramHabilitacion", width: 20, formatter: 'colCheckTramHabilitacion', align: 'center'},
        {name: "flgTramReconsideracion", index:"flgTramReconsideracion", width: 20, formatter: 'colCheckTramReconsideracion', align: 'center'},
        {name: "flgTramApelacion", index:"flgTramApelacion", width: 20, formatter: 'colCheckTramApelacion', align: 'center'},
        {name: "flgAsignado", index:"flgAsignado", width: 20, formatter: 'colAsignacion', align: 'center'}
    ];
    grid.jqGrid({
        url: baseURL + "pages/actividadesController/listarActividades",
        datatype: "json",
        postData: {
        	flg_load:flg_load
        },
        hidegrid: false,
        rowNum: global.rowNum,
        pager: "#idPaginacionBusqActividad",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        autowidth: true,
        caption: "Listado de Actividades",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false
        },
        loadComplete: function(data) {            
            
            for( var i=0;i < data.filas.length+1;i++){
				grid.jqGrid("editRow",i);

			}
            
            fxGrilla.setPtosSuspensivos('idGridBusqActividad','desGrupoActividad');
            fxGrilla.setPtosSuspensivos('idGridBusqActividad','desSubGrupoActividad');
            fxGrilla.setPtosSuspensivos('idGridBusqActividad','desActividad');
        },
        resizeStop:function(){
            //colocando puntos suspensivos
        	fxGrilla.setPtosSuspensivos('idGridBusqActividad','desGrupoActividad');
            fxGrilla.setPtosSuspensivos('idGridBusqActividad','desSubGrupoActividad');
            fxGrilla.setPtosSuspensivos('idGridBusqActividad','desActividad');
        }
    });
    
    grid.jqGrid('setGroupHeaders', {
  	  useColSpanStyle: true, 
  	  groupHeaders:[ 
  		{startColumnName: 'flgTramInstalacion', numberOfColumns: 5, titleText: '<em>Instalación</em>'},
  		{startColumnName: 'flgTramActasVerif', numberOfColumns: 3, titleText: '<em>Pruebas</em>'},
  		{startColumnName: 'flgTramInscripcion', numberOfColumns: 7, titleText: 'Registro Hidrocarburos'}
  	  ]	
  });
}

jQuery.extend($.fn.fmatter, {
	colCheckTramIns: function(cellvalue, options, rowdata){		
		if(rowdata.flgTramInstalacion == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"Ins' id='" + rowdata.index +"Ins' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "Ins' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"Ins' id='" + rowdata.index +"Ins' value='1'/><label class='checkbox' for='" + rowdata.index + "Ins' ></label>";
    },
    colCheckTramModIns: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramModInstalacion == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"ModIns' id='" + rowdata.index +"ModIns' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "ModIns' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"ModIns' id='" + rowdata.index +"ModIns' value='1'/><label class='checkbox' for='" + rowdata.index + "ModIns' ></label>";
    },
    colCheckTramEstRiego: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramEstRiesgo == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"EstRiego' id='" + rowdata.index +"EstRiego' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "EstRiego' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"EstRiego' id='" + rowdata.index +"EstRiego' value='1'/><label class='checkbox' for='" + rowdata.index + "EstRiego' ></label>";
    },
    colCheckTramPlanContingencia: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramPlanContingencia == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"PlanContingencia' id='" + rowdata.index +"PlanContingencia' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "PlanContingencia' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"PlanContingencia' id='" + rowdata.index +"PlanContingencia' value='1'/><label class='checkbox' for='" + rowdata.index + "PlanContingencia' ></label>";
    },
    colCheckTramOpinionFav: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramOpinionFav == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"OpinionFav' id='" + rowdata.index +"OpinionFav' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "OpinionFav' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"OpinionFav' id='" + rowdata.index +"OpinionFav' value='1'/><label class='checkbox' for='" + rowdata.index + "OpinionFav' ></label>";
    },
    colCheckTramVerif: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramActasVerif == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"Verif' id='" + rowdata.index +"Verif' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "Verif' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"Verif' id='" + rowdata.index +"Verif' value='1'/><label class='checkbox' for='" + rowdata.index + "Verif' ></label>";
    },
    colCheckTramVerifYPrueba: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramActasVerifYPrueba == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"VerifYPrueba' id='" + rowdata.index +"VerifYPrueba' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "VerifYPrueba' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"VerifYPrueba' id='" + rowdata.index +"VerifYPrueba' value='1'/><label class='checkbox' for='" + rowdata.index + "VerifYPrueba' ></label>";
    },
    colCheckTramPrueba: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramActasPrueba == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"Prueba' id='" + rowdata.index +"Prueba' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "Prueba' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"Prueba' id='" + rowdata.index +"Prueba' value='1'/><label class='checkbox' for='" + rowdata.index + "Prueba' ></label>";
    },
    colCheckTramInscripcion: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramInscripcion == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"Inscripcion' id='" + rowdata.index +"Inscripcion' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "Inscripcion' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"Inscripcion' id='" + rowdata.index +"Inscripcion' value='1'/><label class='checkbox' for='" + rowdata.index + "Inscripcion' ></label>";
    },
    colCheckTramModInscripcion: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramModInscripcion == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"ModInscripcion' id='" + rowdata.index +"ModInscripcion' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "ModInscripcion' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"ModInscripcion' id='" + rowdata.index +"ModInscripcion' value='1'/><label class='checkbox' for='" + rowdata.index + "ModInscripcion' ></label>";
    },
    colCheckTramSuspension: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramSuspension == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"Suspension' id='" + rowdata.index +"Suspension' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "Suspension' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"Suspension' id='" + rowdata.index +"Suspension' value='1'/><label class='checkbox' for='" + rowdata.index + "Suspension' ></label>";
    },
    colCheckTramCancelacion: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramCancelacion == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"Cancelacion' id='" + rowdata.index +"Cancelacion' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "Cancelacion' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"Cancelacion' id='" + rowdata.index +"Cancelacion' value='1'/><label class='checkbox' for='" + rowdata.index + "Cancelacion' ></label>";
    },
    colCheckTramHabilitacion: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramHabilitacion == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"Habilitacion' id='" + rowdata.index +"Habilitacion' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "Habilitacion' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"Habilitacion' id='" + rowdata.index +"Habilitacion' value='1'/><label class='checkbox' for='" + rowdata.index + "Habilitacion' ></label>";
    },
    colCheckTramReconsideracion: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramReconsideracion == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"Reconsideracion' id='" + rowdata.index +"Reconsideracion' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "Reconsideracion' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"Reconsideracion' id='" + rowdata.index +"Reconsideracion' value='1'/><label class='checkbox' for='" + rowdata.index + "Reconsideracion' ></label>";
    },
    colCheckTramApelacion: function(cellvalue, options, rowdata) {
		if(rowdata.flgTramApelacion == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"Apelacion' id='" + rowdata.index +"Apelacion' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "Apelacion' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"Apelacion' id='" + rowdata.index +"Apelacion' value='1'/><label class='checkbox' for='" + rowdata.index + "Apelacion' ></label>";
    },
    colAsignacion: function(cellvalue, options, rowdata){
    	var botonAsignado = "";
    	var botonDesasignado = "";

    	if(rowdata.flgAsignado == true){
    		botonAsignado = "<img src=\""
    			+ baseURL
    			+ "images/ok.png\" id='idA"+ rowdata.index + "' onclick=\"asignar("
    			+ rowdata.flgAsignado + ",this,"+ rowdata.index + ",'" + rowdata.codActividad
    			+ "');\" style=\"cursor: pointer;\" title=\"Desasignar\" alt=\"Desasignar\"/>";
    	
    		botonDesasignado = "<img src=\""
    			+ baseURL
    			+ "images/eliminar.gif\" id='idD"+ rowdata.index + "' onclick=\"asignar("
    			+ rowdata.flgAsignado + ",this,"+ rowdata.index + ",'" + rowdata.codActividad
    			+ "');\" style=\"cursor: pointer; display:none;\" title=\"Asignar\" alt=\"Asignar\"/>";
    	}
    	else{
    		botonAsignado = "<img src=\""
    			+ baseURL
    			+ "images/ok.png\" id='idA"+ rowdata.index + "' onclick=\"asignar("
    			+ rowdata.flgAsignado + ",this,"+ rowdata.index + ",'" + rowdata.codActividad
    			+ "');\" style=\"cursor: pointer; display:none;\" title=\"Desasignar\" alt=\"Desasignar\"/>";
    	
    		botonDesasignado = "<img src=\""
    			+ baseURL
    			+ "images/eliminar.gif\" id='idD"+ rowdata.index + "' onclick=\"asignar("
    			+ rowdata.flgAsignado + ",this,"+ rowdata.index + ",'" + rowdata.codActividad
    			+ "');\" style=\"cursor: pointer;\" title=\"Asignar\" alt=\"Asignar\"/>";
    	}
		
		return botonAsignado + botonDesasignado;
    }
});

function asignar(flgAsignar, objImg, index,codActividad){
	var idElemento = objImg.id;
	
	if(idElemento.substring(0,3) == 'idA'){
		document.getElementById("idA"+index).style.display = "none";
		document.getElementById("idD"+index).style.display = "";
		abrirPopupAsigUnidFisScop();
	}
	else{
		document.getElementById("idA"+index).style.display = "";
		document.getElementById("idD"+index).style.display = "none";
		abrirPopupAsigUnidFisScop();
	}
}

function abrirPopupAsigUnidFisScop(codActividad) {
    var title = "Configuración de Actividad";
    
    $.ajax({
        url:baseURL + "pages/actividadesController/irPopupAsigUnidFisScop",
        data: {
        	codActividad: codActividad
        },
        type:'get',
        async:false,
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogAsigUnidFisScop").html(data);
            $("#dialogAsigUnidFisScop").dialog({
                resizable: false,
                draggable: false,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: title
            });
        },
        error:errorAjax
    });
}
