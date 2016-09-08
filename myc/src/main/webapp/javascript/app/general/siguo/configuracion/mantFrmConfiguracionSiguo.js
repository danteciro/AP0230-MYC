$(function() {	
    initInicioFiltroEmpSupe();
    confirm.start();
});
function initInicioFiltroEmpSupe() {
	var numericMonto = {
			allowNumeric   : true,
			allowLatin : false,
			allowOtherCharSets : false,
		    allowSpace    : false,
		    allow    : '.'
		};
	$('#txtOrdenComponenteModal').alphanum(numericMonto);
		$('#txtOrdenSeccionModal').alphanum(numericMonto);
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/inps';
    });
    $('#cmbGerenciaModal').change(function() {  
        listarDivisionesModal();
    });
    $('#cmbDivisionModal').change(function() {  

    });
    $('#btnGuardarModulo').click(btnGuardarConfiguracionSiguo);
    $('#btnEditarModulo').click(btnEditarConfiguracionSiguo);  
}
function listarDivisionesModal() {
    fill.clean("#cmbDivisionModal");
    $('#cmbDivisionModal').trigger('change');
    if($('#cmbGerenciaModal').val()!=''){
        $.ajax({
            url:baseURL + "pages/unidadOrganica/listarUnidadOrganica",
            type:'post',
            async:false,
            data:{ 
                idUnidadOrganicaSuperior:$('#cmbGerenciaModal').val()
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                fill.combo(data.listaUnidadOrganica,"idUnidadOrganica","descripcion","#cmbDivisionModal");        
            },
            error:errorAjax
        });
    }
}