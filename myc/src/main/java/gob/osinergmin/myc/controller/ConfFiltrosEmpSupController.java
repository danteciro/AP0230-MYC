package gob.osinergmin.myc.controller;
import gob.osinergmin.myc.domain.dto.ConfFiltroEmpSupDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConfFiltroEmpSupFilter;
import gob.osinergmin.myc.service.business.ConfFiltroEmpSupServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author mdiosesf
 */
@Controller
@RequestMapping("/confFiltrosEmpSup")
public class ConfFiltrosEmpSupController {
    private static final Logger LOG = LoggerFactory.getLogger(ConfFiltrosEmpSupController.class);
    @Inject
    private ConfFiltroEmpSupServiceNeg confFiltroEmpSupServiceNeg;
    @Inject
    private MaestroColumnaServiceNeg maestroColumnaServiceNeg;
    
    @RequestMapping(value="/findConfFiltrosEmpSup",method= RequestMethod.GET) 
    public @ResponseBody Map<String, Object> findConfFiltrosEmpSup(Long idUnidadOrganica, HttpSession session,HttpServletRequest request){
        LOG.info("findConfFiltrosEmpSup");
        Map<String, Object> retorno=new HashMap<String, Object>();
        List<ConfFiltroEmpSupDTO> lista=new ArrayList<ConfFiltroEmpSupDTO>();
        ConfFiltroEmpSupFilter filtro=new ConfFiltroEmpSupFilter(); 
        try{    
        	filtro.setIdUnidadOrganica(idUnidadOrganica);
        	lista = confFiltroEmpSupServiceNeg.ConfFiltroEmpSup(filtro);
        	retorno.put("listaConfFiltrosEmpSup", lista);           
        }catch(Exception ex){
            LOG.error("error findConfFiltrosEmpSup", ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/registrarConfFiltrosEmpSup",method= RequestMethod.POST) 
    public @ResponseBody Map<String, Object> registrarConfFiltrosEmpSup(String listaCheckConfFiltroEmpSup, Long idUnidadOrganica, String listaConfFiltroEmpSup, HttpSession session, HttpServletRequest request){
        LOG.info("findConfFiltrosEmpSup");
        Map<String, Object> retorno=new HashMap<String, Object>(); 
        List<ConfFiltroEmpSupDTO> lista;
        ConfFiltroEmpSupFilter filtro=new ConfFiltroEmpSupFilter(); 
        try{             	
            	String listaCheckConfFiltro[] = listaCheckConfFiltroEmpSup.split("_");
        	String listaAllConfFiltro[] = listaConfFiltroEmpSup.split("_");
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
        	usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
        	usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
        	boolean existe=false;
        	for(String registro : listaAllConfFiltro) {
        		Long IdMaestroColumna=Long.parseLong(registro);
        		existe=false;
        		lista=new ArrayList<ConfFiltroEmpSupDTO>();
				filtro.setIdUnidadOrganica(idUnidadOrganica);
				filtro.setIdFiltro(IdMaestroColumna);
				lista = confFiltroEmpSupServiceNeg.ConfFiltroEmpSup(filtro);
				ConfFiltroEmpSupDTO confFiltroEmpSupDTO = new ConfFiltroEmpSupDTO();                                
                        for(String registroCheck : listaCheckConfFiltro) {
                            if(registroCheck!=null && !registroCheck.equals("") && IdMaestroColumna==Long.parseLong(registroCheck)){        				
                                    if(lista.size()==0){ 
                                            confFiltroEmpSupDTO.setIdFiltro(IdMaestroColumna);
                                            confFiltroEmpSupDTO.setIdUnidadOrganica(idUnidadOrganica);
                                            confFiltroEmpSupDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                                            confFiltroEmpSupServiceNeg.guardarConfFiltroEmpSup(confFiltroEmpSupDTO, usuarioDTO);
                                    } else {
                                            confFiltroEmpSupDTO=lista.get(0);
                                            if(confFiltroEmpSupDTO.getEstado().equals(Constantes.CONSTANTE_ESTADO_INACTIVO)){        					
                                                    confFiltroEmpSupDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                                                    confFiltroEmpSupServiceNeg.editarConfFiltroEmpSup(confFiltroEmpSupDTO, usuarioDTO);
                                            }
                                    }
                                    existe=true;
                                    break;
                            }        			
                        }
        		if(!existe){
	        		if(lista.size()!=0){
	        			confFiltroEmpSupDTO=lista.get(0);
						confFiltroEmpSupDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
						confFiltroEmpSupServiceNeg.editarConfFiltroEmpSup(confFiltroEmpSupDTO, usuarioDTO);
	        		}
        		}
        	}
        	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE+" Los filtros de empresa supervisora.");
        }catch(Exception ex){
            LOG.error("error findConfFiltrosEmpSup", ex);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
        }
        return retorno;
    }
    
    @RequestMapping(value="/findFiltrosEmpSup",method= RequestMethod.GET) 
    public @ResponseBody Map<String, Object> findFiltrosEmpSup(HttpSession session,HttpServletRequest request){
        LOG.info("findFiltrosEmpSup");
        Map<String, Object> retorno=new HashMap<String, Object>();
        List<MaestroColumnaDTO> lista=new ArrayList<MaestroColumnaDTO>();
        try{    
        	lista = maestroColumnaServiceNeg.buscarByDominioByAplicacion(Constantes.DOMINIO_FILTRO_EMP_SUPERVISORA, Constantes.APPLICACION_INPS);
        	retorno.put("listaFiltrosEmpSup", lista);           
        }catch(Exception ex){
            LOG.error("error findFiltrosEmpSup", ex);
        }
        return retorno;
    } 
}
