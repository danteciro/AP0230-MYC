package gob.osinergmin.myc.controller;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarObligacionTipoInRO;
import gob.osinergmin.myc.domain.out.GuardarObligacionTipoOutRO;
import gob.osinergmin.myc.domain.ui.ObligacionTipoFilter;
import gob.osinergmin.myc.service.business.EtapaServiceNeg;
import gob.osinergmin.myc.service.business.ObligacionTipoServiceNeg;
import gob.osinergmin.myc.service.business.ProcesoServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
*
* @author dmedrano
*/
@Controller
@RequestMapping("/obligacionTipo")
public class ObligacionTipoController {

	   @Inject
	    private ProcesoServiceNeg procesoServiceNeg;
	    @Inject
	    private EtapaServiceNeg etapaServiceNeg;
	    @Inject 
	    private ObligacionTipoServiceNeg obligacionTipoNeg;
	    @Inject
	    private ObligacionTipoServiceNeg obligacionTipoServiceNeg;
	    
	    private static final Logger LOG = LoggerFactory.getLogger(ProcesoObligacionTipoController.class);
	    
	    @RequestMapping(method = RequestMethod.GET)
	    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
	        model.addAttribute("listadoProceso", procesoServiceNeg.listarProceso());
	    	model.addAttribute("fecha", ConstantesWeb.getFECHA());
	        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
	        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_OBLI_TIPO;
	    }
	    @RequestMapping(value = "/abrirMantNuevoObligacionTipo", method = RequestMethod.GET)
	    public String abrirMantNuevoObligacionTipo( String tipo,Long idObligacionProceso, Long idActividad, Long idProceso,HttpSession sesion,Model model ) {
	        try{
	            model.addAttribute("listadoProceso", procesoServiceNeg.listarProceso());
	            model.addAttribute("tipo", tipo);          
	            LOG.info("idProceso-->"+ idProceso);            	
	          
	        }catch(Exception e){
	            LOG.error("",e);
	        }
	        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_FRM_NUEVO_OBLIGACION_TIPO;
	    }
	    
	    @RequestMapping(value = "/abrirMantObligacionTipo", method = RequestMethod.GET)
	    public String abrirMantObligacionTipo( String tipo,Long idObligacionProceso, Long idActividad, Long idProceso,HttpSession sesion,Model model ) {
	        try{
	            model.addAttribute("listadoProceso", procesoServiceNeg.listarProceso());
	            model.addAttribute("tipo", tipo);          
	            LOG.info("idProceso-->"+ idProceso);            	
	          
	        }catch(Exception e){
	            LOG.error("",e);
	        }
	        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_FRM_OBLIGACION_TIPO;
	    }
	    
	    @RequestMapping(value="/findObligacionTipo",method=RequestMethod.GET)
	    public @ResponseBody Map<String,Object> findObligacionTipo(ObligacionTipoFilter filtro,int rows, int page, int flg_load, 
	        HttpSession session, HttpServletResponse response, HttpServletRequest request){
	        Map<String,Object> retorno=new HashMap<String,Object>();
	        
	        try{
	            LOG.info("procesando findObligacionTipo");
	            List<ObligacionTipoDTO> listado;
	            int total=0;
	            Integer cuenta;
	            
	            if(flg_load==1){
	                
	            	int inicio;
	                inicio=rows*page-rows;
	                filtro.setStartIndex(inicio);
	                filtro.setResultsNumber(rows);

	                int[] auxiliar=new int[1];
	                auxiliar[0]=0;
                
	                listado = obligacionTipoNeg.listarObligacionTipo(filtro, auxiliar);
	                LOG.info("cuenta Controller findObligacionTipo="+auxiliar[0]);
	                cuenta=auxiliar[0];
	                
	                if (cuenta > 0) {
	                    total = (int) Math.ceil((double) cuenta / (double) rows);
	                }
	                retorno.put("total", total);	            
		            retorno.put("registros", cuenta);
		            retorno.put("filas", listado);
	            }
	                
	                        
	        }catch(Exception ex){
	            LOG.error("",ex);
	        }
	        return retorno;
	    }
	    
	    @RequestMapping(value="/registrarObligacionTipo", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> registrarObligacionTipo(ObligacionTipoDTO obligacionTipoDTO,Model model){
	        LOG.info("procesando registrarParametro");
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        
	        try{
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	            usuarioDTO.setCodigo("00001");//TODO por completar
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            GuardarObligacionTipoInRO in =new GuardarObligacionTipoInRO();
	            in.setObligacionTipo(obligacionTipoDTO);
	            
	            in.setUsuario(usuarioDTO);

                    GuardarObligacionTipoOutRO out =obligacionTipoNeg.guardarObligacionTipo(in);
	            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
	            retorno.put("obligacionTipo", out.getObligacionTipo());              
	            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());	            
	            retorno.put("listadoObligacionTipo",obligacionTipoServiceNeg.listarObligacion());
	           
	        }catch(Exception ex){
                    retorno.put(ConstantesWeb.VV_RESULTADO, 1);
                    retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
                    LOG.error("Error en registrarObligacionTipo",ex);
	        }
	        
	        return retorno;
	    }
	    
	 
	    
	    @RequestMapping(value="/editarObligacionTipo", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> editarObligacionTipo(ObligacionTipoDTO obligacionTipoDTO){
	        LOG.info("procesando editarObligacionTipo");
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        
	        try{
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	            usuarioDTO.setCodigo("00001");//TODO por completar
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            obligacionTipoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
	            GuardarObligacionTipoInRO in =new GuardarObligacionTipoInRO();
	            
	            
	            String nombre =obligacionTipoDTO.getNombre().replaceAll(" +", " ");            
	            obligacionTipoDTO.setNombre(nombre);
	            
	            in.setObligacionTipo(obligacionTipoDTO);
	            in.setUsuario(usuarioDTO);
	              	    
	            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
	            retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
	            
	            GuardarObligacionTipoOutRO out =obligacionTipoNeg.editarObligacionTipo(in);
	            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
	            retorno.put("obligacion", out.getObligacionTipo());              
	            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
                    retorno.put("listadoObligacionTipo",obligacionTipoServiceNeg.listarObligacion());
		     
	           
	        }catch(Exception e){
	            LOG.error("Error en editarObligacionTipo: "+e.getMessage());
	            e.printStackTrace();
	        }
	        
	        return retorno;
	    }
	    
	    @RequestMapping(value="/eliminarObligacionTipo", method= RequestMethod.POST)
	    public @ResponseBody Map<String,Object> eliminarObligacionTipo(ObligacionTipoDTO obligacionTipoDTO){
	        LOG.info("procesando eliminarObligacionTipo");
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        
	        try{
	            UsuarioDTO usuarioDTO = new UsuarioDTO();
	            usuarioDTO.setCodigo("00001");//TODO por completar
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            obligacionTipoDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
	            GuardarObligacionTipoInRO in =new GuardarObligacionTipoInRO();           
	            
	            
	            in.setObligacionTipo(obligacionTipoDTO);
	            in.setUsuario(usuarioDTO);
	              	    
	            GuardarObligacionTipoOutRO out =obligacionTipoNeg.eliminarObligacionTipo(in);
	            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
	            retorno.put("obligacion", out.getObligacionTipo());              
	            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
	            retorno.put("listadoObligacionTipo",obligacionTipoServiceNeg.listarObligacion());
		}catch(Exception ex){
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                    retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
                    LOG.error("Error en eliminarObligacionTipo",ex);
	        }
	        
	        return retorno;
	    }
}
