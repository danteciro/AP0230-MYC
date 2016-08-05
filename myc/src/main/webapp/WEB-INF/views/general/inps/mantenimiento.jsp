<%-- 
    Document   : configuracion INPS
    Created on : 12/05/2016, 10:48:16 AM
    Author     : mdiosesf

	Resumen.
	Objeto                :              mantenimiento.jsp
	Descripción           :              menú de las opciones del INPS.
	Fecha de Creación     :              12/05/2016
	Autor                 :              GMD.
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	Modificaciones
	Motivo                                    Fecha                                   Nombre                              Descripción
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  OSINE_SFS-480                          12/05/2016                        Sergio Dioses                    Añadir opción en el menú INPS: FILTRO EMPRESAS SUPERVISORAS.
	  OSINE_SFS-480                          17/05/2016                        Giancarlo Villanueva             Añadir opción en el menú INPS: SELECCION MUESTRAL.
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template pageTitle="MANTENIMIENTOS INPS" scrollPanelTitle="">
    
    <jsp:attribute name="headArea">
        <script type="text/javascript" charset="utf-8">
            $(function(){
                iniciarMenus();
            });
            function iniciarMenus(){
                $("#menubar li a.menuItem").each(function( index ) {
                        var $textoIcono = $(this).html();
                        var $ruta	= $(this).attr("href");
                        var $imagen = $(this).attr("image");
                        var $div = $(	"<div class='iconoMenu'>"+			
                                                                "<a href='"+$ruta+"'>"+
                                                                        "<img src='"+$imagen+"' alt='"+$textoIcono+"'></img>"+
                                                                "</a>"+
                                                                "<span>"+
                                                                        "<a href='"+$ruta+"'>"+$textoIcono+"</a>"+
                                                                "</span>"+
                                                        "</div>");
                        $div.appendTo($("#contenedorIconos"));				
                });
                var $height = 0;	
                $(".iconoMenu").each(function(index){
                        var $thisHeight =  parseInt($(this).height())+10;		
                        $heightInt =  parseInt($height);			
                        if($thisHeight > $heightInt){
                                $heightInt = $thisHeight;
                        }						
                });
                $(".iconoMenu").height($heightInt);
                $("#menubar").hide();		
            }       
        </script>        
        <style>
            .iconoMenu{
                    float: left;
                    overflow: hidden;
                    width: 200px;
                    margin: 5px 10px;
                    text-align: center;				
            }
            .iconoMenu img{
                    width: 100px;
                    height: 100px;
                    border-width:0px;
            }
            .iconoMenu span{
                    display: block;
                    text-transform:capitalize;
                    text-align: center;		
                    font-weight:bold;
                    font-size: 1em;					
            }
            .iconoMenu span a{
                    text-decoration: none;						
            }
            .iconoMenu:hover{
                    background-color:#CBE3F7;							
            }
            #contenedorIconos {	
                    margin: 20px auto;
                    max-width: 1000px;
                    overflow: hidden;	
                    display: table;
            }
        </style> 
    </jsp:attribute>    
    <jsp:attribute name="bodyArea">
        <div class="tac titua">MANTENIMIENTO GENERAL INPS</div>
        <ul id="menubar" style="display:none;">  
            <li> <a data-icon="ui-icon-document"></a>  
                <ul>  
                    <li><a class="menuItem" image="/myc/images/inps_emp_supervisoras.png" href="/myc/pages/inps/filtroEmpSupervisoras"><p>FILTRO EMPRESAS SUPERVISORAS</p></a></li> <!-- OSINE_SFS-480 - RSIS10  -->
                    <li><a class="menuItem" image="/myc/images/inps_seleccion_muestral.png" href="/myc/pages/inps/seleccionMuestral"><p>SELECCION MUESTRAL</p></a></li> <!-- OSINE_SFS-480 - RSIS23  -->
                </ul>  
            </li>  
        </ul>        
        <div class="scrollPanel" id="scrollPrincipal"><span id="contenedorIconos"></span></div>
		<div id="stack" class="ui-stack">
            <a title="Regresar" href="/myc/pages/principal/mantenimientoGeneral"></a>
        </div>
    </jsp:attribute>    
</t:template>
