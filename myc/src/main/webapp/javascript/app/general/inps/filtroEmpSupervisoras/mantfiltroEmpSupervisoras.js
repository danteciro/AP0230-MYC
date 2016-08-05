$(function() {	
    initInicioFiltroEmpSupe();
    findFiltrosEmpSup();
    confirm.start();
});
function initInicioFiltroEmpSupe() {
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/inps';
    });
    $('#slctGerencia').change(function() {  
        listarDivisiones();
    });
    $('#slctDivision').change(function() {  
        findConfFiltrosEmpSup();
    });
    $('#btnGuardarfiltroEmpSupervisada').click(function() {
        if ($('#frmUnidadOrganicaMant').validateAllForm("#divMensajeValidaParametro")) {    
            confirm.open("¿Ud. est&aacute; seguro de guardar los cambios?","RegistrarConfFiltrosEmpSup()");
        } 
    });
}
function listarDivisiones() {
    fill.clean("#slctDivision");
    $('#slctDivision').trigger('change');
    if($('#slctGerencia').val()!=''){
        $.ajax({
            url:baseURL + "pages/unidadOrganica/listarUnidadOrganica",
            type:'post',
            async:false,
            data:{ 
                idUnidadOrganicaSuperior:$('#slctGerencia').val()
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                fill.combo(data.listaUnidadOrganica,"idUnidadOrganica","descripcion","#slctDivision");        
            },
            error:errorAjax
        });
    }
}
function findFiltrosEmpSup() {
    $.ajax({
        url:baseURL + "pages/confFiltrosEmpSup/findFiltrosEmpSup",
        type:'get',
        async:false,
        data:{},
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            var html='';
            $.each(data.listaFiltrosEmpSup,function(k,v){      
            	var id="chk_"+v.idMaestroColumna;
                html+='<div class="filaForm">';
            	html+='<input id="'+id+'" type="checkbox" disabled="disabled" name="'+v.idMaestroColumna+'">';
            	html+='<label for="'+id+'" class="checkbox">'+v.descripcion+'</label>';
                html+='</div>';
            });        
            $('#chkFiltros').append(html); 
        },
        error:errorAjax
    });
}
function findConfFiltrosEmpSup() {
	if($('#slctDivision').val()!=''){
		$.ajax({
	        url:baseURL + "pages/confFiltrosEmpSup/findConfFiltrosEmpSup",
	        type:'get',
	        async:false,
	        data:{
                    idUnidadOrganica:$('#slctDivision').val()
	        },
	        beforeSend:muestraLoading,
	        success:function(data){
	            ocultaLoading();
	            if(data.listaConfFiltrosEmpSup.length!=0){
		            $("#chkFiltros").find("input").removeAttr('disabled');
		            $("#chkFiltros").find("input").removeAttr('checked');	
		            $.each(data.listaConfFiltrosEmpSup,function(k,v){      
		            	var id="#chk_"+v.idFiltro;
		            	$(id).attr('checked','checked');	            	               
		            });    
	            } else {
	            	$("#chkFiltros").find("input").removeAttr('disabled');
	            	$("#chkFiltros").find("input").removeAttr('checked');	  
	            }
	        },
	        error:errorAjax
	    });
	} else {
		$("#chkFiltros").find("input").attr('disabled','disabled');
		$("#chkFiltros").find("input").removeAttr('checked');	       
	}
}
function RegistrarConfFiltrosEmpSup() {
    var idUnidadOrganica=$('#slctDivision').val();
    var listaCheckConfFiltroEmpSup="";
    var listaConfFiltroEmpSup="";
    var parameters = "_=p";	

    $("#chkFiltros").find("input:checked").each(function(k,v) { 
            listaCheckConfFiltroEmpSup += $(this).attr('name')+"_"; 
    });
    $("#chkFiltros").find("input").each(function(i,o) { 
            listaConfFiltroEmpSup += $(this).attr('name')+"_"; 	
    });
    parameters += "&listaCheckConfFiltroEmpSup="+listaCheckConfFiltroEmpSup;
    parameters += "&idUnidadOrganica="+idUnidadOrganica;		
    parameters += "&listaConfFiltroEmpSup="+listaConfFiltroEmpSup;	

    $.ajax({
        url:baseURL + "pages/confFiltrosEmpSup/registrarConfFiltrosEmpSup",
        type:'post',
        async:false,
        data: parameters,
        success:function(data){
            ocultaLoading();
            if(data.resultado=='0'){
                mensajeGrowl("success", data.mensaje);
            } else {
                mensajeGrowl("error", data.mensaje);
            } 
        },
        error:errorAjax
    });	
}