$(function() {
	$('#default').puigrowl();
	
	procesarGridPersonas();
	
	$('#btnGuardar').click(function() {
		$("#dialogAsigUnidFisScop").dialog("close");
    });
	$('#btnCerrar').click(function() {
		$("#dialogAsigUnidFisScop").dialog("close");
    });	
});


function procesarGridPersonas(flg_load){
	if(flg_load==undefined){flg_load=1;}
	
	$("#gridContenedorAsigUnidFisScop").html("");
    var grid = $("<table>", {
        "id": "idGridAsigUnidFisScop"
    });
    var pager = $("<div>", {
        "id": "idPaginacionBusqActividad"
    });
    $("#gridContenedorAsigUnidFisScop").append(grid).append(pager);

    var nombres = ['Grupo', 'Sub-Grupo', 'Actividad', 'Etapa', 'Trámite','UROC','UPPD','GO','SCOP'];
    var columnas = [
        {name: "desGrupoActividad", sortable: false, align: "center", align: "left", width: 210}, 
        {name: "desSubGrupoActividad", sortable: false, align: "left", align: "left", width: 250},
        {name: "desActividad", sortable: false, align: "left", align: "left", width: 230}, 
        {name: "desEtapa", sortable: false, align: "center", align: "left", width: 100},
        {name: "desTramite", sortable: false, align: "center", align: "left", width: 230},
        {name: "flgUROC", sortable: false, align: "center", align: "center", formatter: 'colCheckUROC', width: 40},
        {name: "flgUPPD", sortable: false, align: "center", align: "center", formatter: 'colCheckUPPD', width: 40},
        {name: "flgGO", sortable: false, align: "center", align: "center", formatter: 'colCheckGO', width: 40},
        {name: "flgSCOP", sortable: false, align: "center", align: "center", formatter: 'colCheckSCOP', width: 40}
    ];
    grid.jqGrid({
        url: baseURL + "pages/actividadesController/listarActividadYTramites",
        datatype: "json",
        postData: {
        	flg_load:flg_load
        },
        hidegrid: false,
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Asignación de Unidad Fiscalizadora - SCOP a Trámite",
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false
        },            
        loadComplete: function(data) {
        	fxGrilla.setPtosSuspensivos('idGridAsigUnidFisScop','desGrupoActividad');
            fxGrilla.setPtosSuspensivos('idGridAsigUnidFisScop','desSubGrupoActividad');
            fxGrilla.setPtosSuspensivos('idGridAsigUnidFisScop','desActividad');
            fxGrilla.setPtosSuspensivos('idGridAsigUnidFisScop','desTramite');
        },
        resizeStop:function(){
            //colocando puntos suspensivos
        	fxGrilla.setPtosSuspensivos('idGridAsigUnidFisScop','desGrupoActividad');
            fxGrilla.setPtosSuspensivos('idGridAsigUnidFisScop','desSubGrupoActividad');
            fxGrilla.setPtosSuspensivos('idGridAsigUnidFisScop','desActividad');
            fxGrilla.setPtosSuspensivos('idGridAsigUnidFisScop','desTramite');
        }
    });
}

jQuery.extend($.fn.fmatter, {
	colCheckUROC: function(cellvalue, options, rowdata){		
		if(rowdata.flgTramInstalacion == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"uroc' id='" + rowdata.index +"uroc' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "uroc' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"uroc' id='" + rowdata.index +"uroc' value='1'/><label class='checkbox' for='" + rowdata.index + "uroc' ></label>";
    },
    colCheckUPPD: function(cellvalue, options, rowdata){		
		if(rowdata.flgTramInstalacion == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"uppd' id='" + rowdata.index +"uppd' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "uppd' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"uppd' id='" + rowdata.index +"uppd' value='1'/><label class='checkbox' for='" + rowdata.index + "uppd' ></label>";
    },
    colCheckGO: function(cellvalue, options, rowdata){		
		if(rowdata.flgTramInstalacion == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"go' id='" + rowdata.index +"go' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "go' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"go' id='" + rowdata.index +"go' value='1'/><label class='checkbox' for='" + rowdata.index + "go' ></label>";
    },
    colCheckSCOP: function(cellvalue, options, rowdata){		
		if(rowdata.flgTramInstalacion == true)
			return "<input type=\"checkbox\" id='" + rowdata.index +"scop' id='" + rowdata.index +"scop' value='1' checked='checked'/><label class='checkbox' for='" + rowdata.index + "scop' ></label>";
		else
			return "<input type=\"checkbox\" id='" + rowdata.index +"scop' id='" + rowdata.index +"scop' value='1'/><label class='checkbox' for='" + rowdata.index + "scop' ></label>";
    }
});