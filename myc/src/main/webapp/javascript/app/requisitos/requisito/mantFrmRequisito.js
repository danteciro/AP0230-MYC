$(function() {
	
    var descripcion = {
               allowNumeric  : true,
                allowLatin    : true,
                allowUpper    : true,
                allowLower    : true,
                allowCaseless : true,
                allowOtherCharSets : true,
                allowSpace    : true,
                allow         : '!@#$%^&*()+=[]\\\;,/{}|":<>?~`.- _'
           };
	
    boton.closeDialog();
    $('#frmMantRequisito').validarForm();
    $("#txtArchivoRequisito").change(function(){      
        $("#txtFileNameArchivoRequisito").val(quitaSlashDir($("#txtArchivoRequisito").val())); 
    });
    $('#btnGuardarRequ').click(btnGuardarRequ);
    $('#btnEditarRequ').click(btnEditarRequ);
    $('#txtDescRequ').on('change',verificaRequSimilares);
    $('#txtDescRequ').alphanum(descripcion);
    $('#txtComentarioRequ').alphanum(descripcion);
    anularEnterTextArea('#txtDescRequ,#txtComentarioRequ');
 
});

var i = 0;

$("#formArchivo").ajaxForm(
		{
			dataType : 'json',
			resetForm : true,
			success : function(data) {
				var mensaje;
				var resultado;
				//clearDiv('div_msje_archivo');
				if (data != null && data.error != null) {
					resultado=data.error;
					if (data.error) {
						mensaje=data.mensaje;				
						
					} else {
						if (data.intValue != undefined
								&& data.intValue != null) {
							nArchivos = data.intValue;
							
						}
						mensaje="";
						
					}
					enviarDatosArchivo(resultado,mensaje);

				}		
				
				
			}
});

$("#formArchivoEdit").ajaxForm(
		{
			dataType : 'json',
			resetForm : true,
			success : function(data) {
				var mensaje;
				var resultado;
				//clearDiv('div_msje_archivo');
				if (data != null && data.error != null) {
					resultado=data.error;
					if (data.error) {
						mensaje=data.mensaje;				
						
					} else {
						if (data.intValue != undefined
								&& data.intValue != null) {
							nArchivos = data.intValue;
							
						}
						mensaje="";
						
					}
					enviarDatosArchivoEdit(resultado,mensaje);

				}						
				
			}
});
function enviarDatosArchivo(resultado,mensaje){
	console.log(resultado);
	if(!resultado){
	 confirm.open("¿Ud. est&aacute; seguro de guardar este nuevo requisito?","procGuardarRequ()");					
				
	}else {
		mensajeGrowl("error", "Error", mensaje);
	}
	
}

function enviarDatosArchivoEdit(resultado,mensaje){	
	console.log(resultado);
	if(!resultado){
		validarDependRequ();   						
	}else {
		mensajeGrowl("error", "Error", mensaje);
	}
	
}


function inputFile(){
	$('input[name="archivos[' +  i + ']"]').change(function() {
		if ($(this).val() != ''){ $('#file_name').val($(this).val().replace(/C:\\fakepath\\/i, ''));  }
		
	});
};

function cuenta(){ 
  	$("#caracteres").val($("#txtDescRequ").val().length);
} 
function btnGuardarRequ(){
    var validar = $('#frmMantRequisito').validateAllForm("#divMensajeValidaRequisito");
    
       
    if($('#txtDescRequ').val()!=''  && $('input[name="archivos[' +  i + ']"]').val()!=''){
    	$("#formArchivo").submit();	
    } else {
    	if (validar) {
       	 confirm.open("¿Ud. est&aacute; seguro de guardar este nuevo requisito?","procGuardarRequ()");
       } 
    }
};
function btnEditarRequ(){
    var validar = $('#frmMantRequisito').validateAllForm("#divMensajeValidaRequisito");
    var val=0;
    if ($('#txtDescRequ').val()!='' && $('input[name="archivos[' +  i + ']"]').val()=='') {
    	validarDependRequ();   	
    }    	 
     if($('#txtDescRequ').val()!='' && $('input[name="archivos[' +  i + ']"]').val()!=''){
            $("#formArchivoEdit").submit();	    
     }
    
   
};
function verificaRequSimilares(){
    $('#divRequisitosSimilares #requisitosSimilares').html("");
    $('#divRequisitosSimilares').hide();
    
    var requisito=$.trim($('#txtDescRequ').val());
    if(requisito==''){return false;}
    
    var requSimi=[];
    $.ajax({
        url:baseURL + "pages/requisito/verificaRequisitoSimilar", 
        type:'get',
        async:false,
        data:{
            descripcion:requisito
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            requSimi=data;
        },
        error:errorAjax
    });
    
    if(requSimi.length>0){
        var html="<ul>";
        var cont=0;
        $.each(requSimi,function(k,v){
            if( !($('#txtTipo').val()=='edit' && v.descripcion==$('#edit_descp').val()) ){                
                cont++;
                html+="<li>"+v.descripcion+"</li>";
            }
        });
        html+="</ul>";
        if(cont>0){
            $('#divRequisitosSimilares #requisitosSimilares').html(html);
            $('#divRequisitosSimilares').show();
        }        
    }
}
