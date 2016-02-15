<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template pageTitle="Módulo Obligaciones - Indice" scrollPanelTitle="" >
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
                        var $div = $("<div class='iconoMenu'>"+			
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
                    max-width: 800px;
                    overflow: hidden;	
                    display: table;
            }
        </style> 
        
    </jsp:attribute>
    <jsp:attribute name="bodyArea">
        <ul id="menubar">
            <li><a data-icon="ui-icon-document"></a> 
                <ul>
                    <li><a class="menuItem" image="/myc/images/modulosupervisor.png" href="/myc/pages/baseLegal">Base Legal</a></li>
<!--                    <li><a class="menuItem" image="/myc/images/mantenimiento.png" href="/myc/pages/obligacionNormativa">Obligaciones</a></li>-->
                </ul>
            </li>
        </ul>
        <div class="scrollPanel" id="scrollPrincipal">		
            <span id="contenedorIconos">				
            </span>		
        </div>
<!--        <div id="stack" class="ui-stack">
            <a title="Regresar" href="/myc"></a>
        </div> -->
    </jsp:attribute>
    
</t:template>