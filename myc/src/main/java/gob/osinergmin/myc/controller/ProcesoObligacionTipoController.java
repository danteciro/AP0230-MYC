package gob.osinergmin.myc.controller;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarProcesoObligacionTipoInRO;
import gob.osinergmin.myc.domain.out.GuardarProcesoObligacionTipoOutRO;
import gob.osinergmin.myc.domain.ui.ProcesoObligacionTipoFilter;
import gob.osinergmin.myc.service.business.ObligacionTipoServiceNeg;
import gob.osinergmin.myc.service.business.ProcesoObligacionTipoServiceNeg;
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
@RequestMapping("/procesoObligacionTipo")
public class ProcesoObligacionTipoController {
	
    @Inject
    private ProcesoServiceNeg procesoServiceNeg;
    @Inject
    private ObligacionTipoServiceNeg obligacionTipoServiceNeg;
    @Inject
    private ProcesoObligacionTipoServiceNeg procesoObligacionTipoNeg;
    
    private static final Logger LOG = LoggerFactory.getLogger(ProcesoObligacionTipoController.class);
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("listadoProceso", procesoServiceNeg.listarProceso());
        model.addAttribute("listadoObligacionTipo",obligacionTipoServiceNeg.listarObligacion());
    	model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_PROCESO_OBLI;
    }
    
    @RequestMapping(value = "/abrirMantProcesoObligacionTipo", method = RequestMethod.GET)
    public String abrirMantObligacionProceso( String tipo,Long idProOblTip,Long idObligacionTipo,Long idActividad,Long idProceso,HttpSession sesion,Model model ) {
        try{
            model.addAttribute("listadoProceso", procesoServiceNeg.listarProceso());
            model.addAttribute("listadoObligacionTipo",obligacionTipoServiceNeg.listarObligacion());
            model.addAttribute("tipo", tipo);          
            if(!tipo.equals("new") && idProOblTip!=null){
                model.addAttribute("idProOblTip", idProOblTip);
                model.addAttribute("idObligacionTipo", idObligacionTipo);
                model.addAttribute("idActividad", idActividad);
                model.addAttribute("idProceso", idProceso);                
            }          
        }catch(Exception e){
            LOG.error("",e);
        }
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_FRM_OBLIGACION_PROCESO;
    }
    
    @RequestMapping(value="/findProcesoObligacionTipo",method=RequestMethod.GET)
    public @ResponseBody Map<String,Object> findProcesoObligacionTipo(ProcesoObligacionTipoFilter filtro,int rows, int page, int flg_load, 
        HttpSession session, HttpServletResponse response, HttpServletRequest request){
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
            LOG.info("procesando findProcesoObligacionTipo");
            List<ProcesoObligacionTipoDTO> listado;
            int total=0;
            Integer cuenta;
            
            if(flg_load==1){
                
            	int inicio;
                inicio=rows*page-rows;
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);

                int[] auxiliar=new int[1];
                auxiliar[0]=0;
            
                listado = procesoObligacionTipoNeg.listarProcesoObligacionTipo(filtro, auxiliar);//obligacionTipoNeg.listarObligacionTipo(filtro, auxiliar);
                LOG.info("cuenta Controller findProcesoObligacionTipo="+auxiliar[0]);
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
    
    @RequestMapping(value="/registrarProcesoObligacionTipo", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarProcesoObligacionTipo(ProcesoObligacionTipoDTO procesoObligacionTipoDTO){
        LOG.info("procesando registrarProcesoObligacionTipo");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            procesoObligacionTipoDTO.setIdProOblTip(null);
            procesoObligacionTipoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            GuardarProcesoObligacionTipoInRO in=new GuardarProcesoObligacionTipoInRO();
            in.setProcesoObligacionTipo(procesoObligacionTipoDTO);
            in.setUsuario(usuarioDTO);
            
            GuardarProcesoObligacionTipoOutRO out=procesoObligacionTipoNeg.guardarProcesoObligacionTipo(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("ProcesoObligacion", out.getProcesoObligacionTipo());              
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarProcesoObligacionTipo: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    @RequestMapping(value="/editarProcesoObligacionTipo", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarProcesoObligacionTipo(ProcesoObligacionTipoDTO procesoObligacionTipoDTO){
        LOG.info("procesando editarProcesoObligacionTipo-->"+procesoObligacionTipoDTO.getIdProOblTip());
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            procesoObligacionTipoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            GuardarProcesoObligacionTipoInRO in=new GuardarProcesoObligacionTipoInRO();
            in.setProcesoObligacionTipo(procesoObligacionTipoDTO);
            in.setUsuario(usuarioDTO);
            
            GuardarProcesoObligacionTipoOutRO out=procesoObligacionTipoNeg.editarProcesoObligacionTipo(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("ProcesoObligacion", out.getProcesoObligacionTipo());              
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarProcesoObligacionTipo: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
    @RequestMapping(value="/eliminarProcesoObligacionTipo", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> eliminarProcesoObligacionTipo(ProcesoObligacionTipoDTO procesoObligacionTipoDTO){
        LOG.info("procesando editarProcesoObligacionTipo-->"+procesoObligacionTipoDTO.getIdProOblTip());
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            procesoObligacionTipoDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            GuardarProcesoObligacionTipoInRO in=new GuardarProcesoObligacionTipoInRO();
            in.setProcesoObligacionTipo(procesoObligacionTipoDTO);
            in.setUsuario(usuarioDTO);
            
            GuardarProcesoObligacionTipoOutRO out=procesoObligacionTipoNeg.eliminarProcesoObligacionTipo(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("ProcesoObligacion", out.getProcesoObligacionTipo());              
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarProcesoObligacionTipo: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
		
}
