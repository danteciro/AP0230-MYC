var reqGral = [];

$(function() {
	buscarRequGral();
	armaCabeceraRequisitosGral();
	initRequGral();
});

function initRequGral() {
	$('#btnAgregarRequGral').click(btnAgregarRequGral);
	// habilitaRequEspe(reqGral);
}

function buscarRequGral() {
	$.ajax({
		url : baseURL
				+ "pages/requisitoProcedimiento/listarRequisitosProcedimiento",
		type : 'get',
		async : false,
		data : {
			idProcedimiento : $('#idProcedimento').val(),
			flgGeneral : "1"
		},
		//beforeSend : muestraLoading,
		success : function(data) {
			//ocultaLoading();
			reqGral = data.filas;
			armaGeneralesRequisitos(data.filas);
			habilitaRequEspe(data.filas);
		},
		error : errorAjax
	});
}

function armaCabeceraRequisitosGral() {
	var html = "<div class='fila'>";
	html += "<div class='desc ilb titu vam' title='DESCRIPCIÓN'>DESCRIPCION</div>";
	html += "<div class='btns tac ilb titu vam' title='ACCIONES'></div>";
	html += "<div class='camp ilb titu come vam' title='COMENTARIO'>COMENTARIO</div>";
	$.each(campos, function(k, v) {
		if (v.idAmbitoParametrico.descripcion.toUpperCase() == 'REQUISITO') {
			html += "<div class='camp ilb titu vam' title='" + v.nombre + "'>"
					+ v.nombre + "</div>";
		}
	});
	html += "</div>";
	$('#headRequGral').html(html);
}

function habilitaRequEspe(data) {
	(data.length > 0) ? $('#stepRequEspe').removeClass('disabled') : $(
			'#stepRequEspe').addClass('disabled');
}
function btnAgregarRequGral() {
	abrirAgregarRequisitos('AGREGAR REQUISITO GENERAL',
			'agregarRequisitoGeneral()', '', '', 'general');
}
function btnAgregarSubRequisitoGral(idRequProc, txtRequProc) {
	abrirAgregarRequisitos('AGREGAR SUBREQUISITO', 'agregarRequisitoGeneral()',
			idRequProc.replace("gralRequProc", ""), txtRequProc, 'general');
}
function agregarRequisitoGeneral() {
	if ($('#requisitosAgregarSeleccionados .fila').length == 0) {
		mensajeGrowl("warn", "Seleccione agregar requisito", "");
		return false;
	} else {
		confirm
				.open(
						"¿Ud est&aacute; seguro de Agregar el(los) requisito(s) general(es)?",
						"procAgregarRequisitoGeneral()");
	}
}
function procAgregarRequisitoGeneral() {
	// armando names pa form
	var cont = 0;
	$('#requisitosAgregarSeleccionados .fila')
			.map(
					function() {
						var obj = this;
						$(obj).children('input.idRequisitoSelec').attr('name',
								'requProcedimiento[' + cont + '].idRequisito');
						$(obj).find('input.comentario').attr('name',
								'requProcedimiento[' + cont + '].comentario');
						$(obj).find('input.idRequisitoProcedimientoPad').attr(
								'name',
								'requProcedimiento[' + cont
										+ '].idRequisitoProcedimientoPad');
						$(obj).find('input.idRequisitoProcedimientoPad').val(
								$('#idRequisitoProcedimientoPad').val());
						$(obj).find('input.flgGeneral').attr('name',
								'requProcedimiento[' + cont + '].flgGeneral');
						$(obj).find('input.flgGeneral').val('1');

						var cont2 = 0;
						$(obj)
								.find('div.parametroDinamico')
								.map(
										function() {
											var obj2 = this;
											// $(obj2).find('input.idParametroDinamico').attr('name','requProcedimiento['+cont+'].valoresParaDina['+cont2+'].valorParametro.idParametroDinamico')
											$(obj2)
													.find(
															'select.idValorParametro')
													.attr(
															'name',
															'requProcedimiento['
																	+ cont
																	+ '].valoresParaDina['
																	+ cont2
																	+ '].valorParametro.idValorParametro')
											cont2++;
										})
						cont++;
					});
	//
	$
			.ajax({
				url : baseURL
						+ "pages/requisitoProcedimiento/registrarRequisitoProcedimientoGral",
				type : 'post',
				async : false,
				data : $('#frmMantRequProcedimiento').serialize(),
				beforeSend : muestraLoading,
				success : function(data) {
					ocultaLoading();
					if (data.resultado == "SUCCESS") {
						mensajeGrowl("success", global.confirm.save, "");
						buscarRequGral();
						$('#dialogAgregarRequisito').dialog('close');
					} else {
						mensajeGrowl("error", data.mensaje, "");
					}
				},
				error : errorAjax
			});
}
function armaGeneralesRequisitos(reqGralx) {
    var html = "";
    $.each(reqGralx,function(key, val) {
        if (val.idRequisitoProcedimientoPad == '' || val.idRequisitoProcedimientoPad == null) {
            html += "<li nroorden='"+(val.nroOrden!=null?val.nroOrden:"")+"' idrequproc='"+val.idRequisitoProcedimiento+"'>";
            html += "<div class='fila' id='gralRequProc"
                            + val.idRequisitoProcedimiento + "'><div>";
            html += "<input type='hidden' class='idRequisitoGral' value='"
                            + val.requisito.idRequisito + "' />";
            html += "<div class='desc ilb vat' title='"
                            + val.requisito.descripcion + "'>"
                            + val.requisito.descripcion + "</div>";

            html += "<div class='btns ilb vat tar'>";
            html += " <span class='ui-icon ui-icon-plusthick' title='AGREGAR SUBREQUISITO' onclick='btnAgregarSubRequisitoGral(\"gralRequProc"
                            + val.idRequisitoProcedimiento
                            + "\",\""
                            + val.requisito.descripcion
                            + "\")'></span>"
                            + " <span class='ui-icon ui-icon-closethick' title='ELIMINAR REQUISITO' onclick='btnEliminarRequisito(\"gralRequProc"
                            + val.idRequisitoProcedimiento
                            + "\",\"gral\")'></span>";
            html += "</div>";

            var comentario = val.comentario != null ? val.comentario
                            : "";
            html += "<div class='camp ilb vat come' title='"
                            + comentario + "'>" + comentario + "</div>";

            var htmlCampos = obtenerCamposValorParaDinaRequGral(
                            campos, val.valoresParaDina);
            html += htmlCampos;

            html += "</div>";
            html += "<ul id='sortableGralRequProc" + val.idRequisitoProcedimiento + "'></ul>";
            html += "</div>";
            html += "</li>";
        }
    });
    $('#sortableGralRequ').html(html);
    // ingresando hijos 2do nivel
    $.each(reqGralx,function(key, val) {
        if (val.idRequisitoProcedimientoPad != '' && val.idRequisitoProcedimientoPad != null) {
            var html = "<li nroorden='"+(val.nroOrden!=null?val.nroOrden:"")+"' idrequproc='"+val.idRequisitoProcedimiento+"'>";
            html += "<div class='fila sr' id='subRequProc"
                            + val.idRequisitoProcedimiento + "'>";
            html += "<input type='hidden' class='idSubRequisitoGral' value='"
                            + val.requisito.idRequisito + "' />";
            html += "<div class='desc ilb vat' title='"
                            + val.requisito.descripcion
                            + "' style='margin-left:10px;width:290px;'>"
                            + val.requisito.descripcion + "</div>";

            html += "<div class='btns ilb vat tar'>";
            html += " <span></span>";
            html += " <span class='ui-icon ui-icon-closethick' title='ELIMINAR SUBREQUISITO' onclick='btnEliminarRequisito(\"subRequProc"
                            + val.idRequisitoProcedimiento
                            + "\",\"gral\")'></span>";
            html += "</div>";
            var comentario = val.comentario != null ? val.comentario
                            : "";
            html += "<div class='camp ilb vat come' title='"
                            + comentario + "'>" + comentario + "</div>";

            var htmlCampos = obtenerCamposValorParaDinaRequGral(
                            campos, val.valoresParaDina);
            html += htmlCampos;

            html += "</div>";
            html += "</li>";
            $('#sortableGralRequProc' + val.idRequisitoProcedimientoPad).append(html);
        }
    });
    //activando sortable (arrastrar y soltar)
    $("#sortableGralRequ").sortable({placeholder: "ui-sortable-highlight"});$("#sortableGralRequ").disableSelection();
    $( "#sortableGralRequ" ).sortable({
        update: function( event, ui ) {
            evalOrdenRequisitos('#sortableGralRequ',buscarRequGral);
        }
    });
    //sortable pa subrequisitos
    $("ul[id^='sortableGralRequProc']").sortable({placeholder: "ui-sortable-highlight"});$("ul[id^='sortableGralRequProc']").disableSelection();
    $( "ul[id^='sortableGralRequProc']" ).sortable({
        update: function( event, ui ) {evalOrdenRequisitos('#'+$(this).attr('id'),buscarRequGral);}
    });
}

function obtenerCamposValorParaDinaRequGral(camposx, valoresParaDina) {
	var html = "";
	$
			.each(
					camposx,
					function(k, regCampo) {
						if (regCampo.idAmbitoParametrico.descripcion
								.toUpperCase() == 'REQUISITO') {
							var valorParaDina = "";
							if (valoresParaDina.length > 0) {// si exiten
																// valoresParaDina
								$
										.each(
												valoresParaDina,
												function(kk, regParaDina) {
													if (regCampo.idParametroDinamico == regParaDina.valorParametro.idParametroDinamico) {
														valorParaDina = regParaDina.valorParametro.descripcion;
													}
												});
							}
							html += "<div class='camp ilb vat' title='"
									+ valorParaDina + "'>" + valorParaDina
									+ "</div>";
						}
					});
	return html;
}