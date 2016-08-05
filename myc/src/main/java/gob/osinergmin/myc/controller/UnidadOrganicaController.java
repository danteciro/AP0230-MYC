package gob.osinergmin.myc.controller;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.PersonalUnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.MaestroColumnaFilter;
import gob.osinergmin.myc.domain.ui.PersonalUnidadOrganicaFilter;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.PersonalUnidadOrganicaServiceNeg;
import gob.osinergmin.myc.service.business.UnidadOrganicaServiceNeg;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
*
* @author mdiosesf
*/
@Controller
@RequestMapping("/unidadOrganica")
public class UnidadOrganicaController {
    private static final Logger LOG = LoggerFactory.getLogger(UnidadOrganicaController.class);
    @Inject
    private UnidadOrganicaServiceNeg unidadOrganicaServiceNeg;  
    @Inject
    private MaestroColumnaServiceNeg maestroColumnaServiceNeg;
    @Value("${unidad.organica.max.nivel}")
    private Long maxNivelDivision;
    @Value("${unidad.organica.registrar.vacio.valor}")
    private String unidOrgaRegiVacioValor;
    @Inject
    private PersonalUnidadOrganicaServiceNeg personalUnidadOrganicaServiceNeg;  
	
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        model.addAttribute("maxNivelDivision", maxNivelDivision);
        model.addAttribute("unidOrgaRegiVacioValor", unidOrgaRegiVacioValor);
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_UNIDAD_ORGANICA;
    }
       
    @RequestMapping(value = "/listarUnidadOrganica", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> listarUnidadOrganica(UnidadOrganicaFilter filtro, HttpServletRequest request, HttpSession session){
        LOG.info("procesando POST para listarUnidadOrganica" + "/ ID Unidad Organica "+ filtro.getIdUnidadOrganica());
        Map<String, Object> retorno=new HashMap<String, Object>();
        List<UnidadOrganicaDTO> lista=new ArrayList<UnidadOrganicaDTO>(); 
        try {   
        	lista=unidadOrganicaServiceNeg.findUnidadOrganica(filtro);  
        	retorno.put("listaUnidadOrganica", lista);
        } catch (Exception e) {
            LOG.error("Error al editar listarUnidadOrganica",e);            
        }
        return retorno;
    } 
    
    @RequestMapping(value = "/listarUnidadOrganicaMant", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> listarUnidadOrganicaMant(UnidadOrganicaFilter filtro, HttpServletRequest request, HttpSession session){
        LOG.info("procesando POST para listarUnidadOrganicaMant" + "/ ID Unidad Organica "+ filtro.getIdUnidadOrganica());
        Map<String, Object> retorno=new HashMap<String, Object>();
        UnidadOrganicaDTO uniOpe=new UnidadOrganicaDTO(); 
        try {   
            uniOpe=unidadOrganicaServiceNeg.findUnidadOrganica(filtro).get(0);  
            List<MaestroColumnaDTO> maesColu=maestroColumnaServiceNeg.buscarByDominioByAplicacionByCodigo(Constantes.DOMINIO_NIVEL_UNIDAD_ORGA, Constantes.APPLICACION_MYC, String.valueOf(uniOpe.getNivel()+1));
            
            retorno.put("unidadOrganica", uniOpe);
            retorno.put("maestroColumna", maesColu!=null && maesColu.size()>0 ? maesColu.get(0):null);
        } catch (Exception e) {
            LOG.error("Error al editar listarUnidadOrganicaMant",e);            
        }
        return retorno;
    } 
    
    @RequestMapping(value = "/registrarUnidadOrganica", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> registrarUnidadOrganica(UnidadOrganicaDTO unidadOrganicaDTO, HttpSession session, HttpServletRequest request){
        LOG.info("procesando POST para registrarUnidadOrganica");
        Map<String,Object> retorno=new HashMap<String,Object>();
        MaestroColumnaFilter filtroMaestro=new MaestroColumnaFilter();
        UnidadOrganicaFilter filtroUnidad=new UnidadOrganicaFilter();
        try {
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
        	usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
        	usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
        	filtroMaestro.setAplicacion(Constantes.APPLICACION_MYC);
        	filtroMaestro.setCodigo(unidadOrganicaDTO.getNivel().toString());
        	filtroMaestro.setDominio(Constantes.DOMINIO_NIVEL_UNIDAD_ORGA);
        	List<MaestroColumnaDTO> listaNiveles=maestroColumnaServiceNeg.listarMaestroColumna(filtroMaestro);
        	if(listaNiveles!=null && listaNiveles.size()!=0){  
        		filtroUnidad.setIdUnidadOrganicaSuperior(unidadOrganicaDTO.getIdUnidadOrganicaSuperior());
        		filtroUnidad.setDescripcion(unidadOrganicaDTO.getDescripcion());
        		filtroUnidad.setSigla(unidadOrganicaDTO.getSigla());
        		filtroUnidad.setCodDepSiga(unidadOrganicaDTO.getCodDepSiga());
        		List<UnidadOrganicaDTO> listaUnidad=unidadOrganicaServiceNeg.findUnidadOrganica(filtroUnidad);
        		if(listaUnidad==null || listaUnidad.size()==0){
	        		unidadOrganicaDTO.setSede(Constantes.CONSTANTE_SEDE_UNIDAD_ORGANICA);
	            	unidadOrganicaDTO.setNombreNivel(listaNiveles.get(0));
	            	unidadOrganicaDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
	            	
	            	unidadOrganicaServiceNeg.guardarUnidadOrganica(unidadOrganicaDTO, usuarioDTO);
	            	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
	                retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
        		} else {
            		retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                    retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE_DUPLICATE);
            	}
        	} else {
        		retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE);
        	}
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en registrarUnidadOrganica",ex);
        }
        return retorno;
    }  
    
    @RequestMapping(value = "/editarUnidadOrganica", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> editarUnidadOrganica(UnidadOrganicaDTO unidadOrganicaDTO, HttpSession session, HttpServletRequest request){
        LOG.info("procesando POST para registrarUnidadOrganica");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try {
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
        	usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
        	usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            unidadOrganicaDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            unidadOrganicaServiceNeg.editarUnidadOrganica(unidadOrganicaDTO, usuarioDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_UPDATE);
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en registrarUnidadOrganica",ex);
        }
        return retorno;
    }  
    
    @RequestMapping(value = "/eliminarUnidadOrganica", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> eliminarUnidadOrganica(Long idUnidadOrganica, HttpSession session, HttpServletRequest request){
        LOG.info("procesando POST para registrarUnidadOrganica");
        Map<String,Object> retorno=new HashMap<String,Object>();
        UnidadOrganicaFilter filtro=new UnidadOrganicaFilter();
        List<UnidadOrganicaDTO> lista=new ArrayList<UnidadOrganicaDTO>();
        List<UnidadOrganicaDTO> listaHijos=new ArrayList<UnidadOrganicaDTO>(); 
        try {
            filtro.setIdUnidadOrganica(idUnidadOrganica);
            lista=unidadOrganicaServiceNeg.findUnidadOrganica(filtro);
            filtro=new UnidadOrganicaFilter();
            filtro.setIdUnidadOrganicaSuperior(idUnidadOrganica);
            listaHijos=unidadOrganicaServiceNeg.findUnidadOrganica(filtro);
            if(listaHijos==null || listaHijos.size()==0){
                if(lista!=null && lista.size()!=0){
                    List<PersonalUnidadOrganicaDTO> persoUnidOrg = personalUnidadOrganicaServiceNeg.findbyFilter(new PersonalUnidadOrganicaFilter(null, idUnidadOrganica));
                    if(persoUnidOrg!=null && persoUnidOrg.size()>0){
                        retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                        retorno.put(ConstantesWeb.VV_MENSAJE,  ConstantesWeb.mensajes.MSG_OPERATION_FAIL_HAS_PERSONAL);
                    }else{
                        UsuarioDTO usuarioDTO = new UsuarioDTO();
                        usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
                        usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());

                        UnidadOrganicaDTO unidadOrganicaDTO=lista.get(0);       		      		        		
                        unidadOrganicaDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                        unidadOrganicaServiceNeg.editarUnidadOrganica(unidadOrganicaDTO, usuarioDTO);
                        retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                        retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
                    }
                } else {
                    retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                    retorno.put(ConstantesWeb.VV_MENSAJE,  ConstantesWeb.mensajes.MSG_OPERATION_FAIL_DELETE);
                }
            }
            else {
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                retorno.put(ConstantesWeb.VV_MENSAJE,  ConstantesWeb.mensajes.MSG_OPERATION_FAIL_HAS_NODE);
            }
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en registrarUnidadOrganica",ex);
        }
        return retorno;
    }  
}

