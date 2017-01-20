package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.RequProcParaDinaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarCnfRequProcedimientoInRO;
import gob.osinergmin.myc.domain.in.GuardarProcedimientoInRO;
import gob.osinergmin.myc.domain.out.GuardarCnfRequProcedimientoOutRO;
import gob.osinergmin.myc.domain.out.GuardarProcedimientoOutRO;
import gob.osinergmin.myc.domain.ui.CnfRequProcedimientoFilter;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.domain.ui.ZonificacionFilter;
import gob.osinergmin.myc.service.business.CnfRequProcedimientoNeg;
import gob.osinergmin.myc.service.business.TramiteServiceNeg;
import gob.osinergmin.myc.service.business.UbigeoServiceNeg;
import gob.osinergmin.myc.service.business.ZonificacionServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;
import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author jpiro
 */

@Controller
@RequestMapping("/requisitoProcedimiento")
public class RequisitoProcedimientoController {
    private static final Logger LOG = LoggerFactory.getLogger(RequisitoProcedimientoController.class);
    @Inject
    private TramiteServiceNeg tramiteServiceNeg;
    @Inject
    private CnfRequProcedimientoNeg cnfRequProcedimientoNeg;
    @Inject
    private UbigeoServiceNeg ubigeoServiceNeg;
    @Inject
    private ZonificacionServiceNeg zonificacionServiceNeg;
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model,HttpSession session,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        model.addAttribute("xxp",session.getAttribute("xxp"));
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_CONF_REQUISITOXPROCEDIMIENTO;
    }
    
    @RequestMapping(value="/registrarRequisitoProcedimientoEspe", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarRequisitoProcedimientoEspe(ProcedimientoDTO procedimientoDTO){
        LOG.info("-->registroDTO-idProcedimiento->"+procedimientoDTO.getIdProcedimiento());
        for(CnfRequProcedimientoDTO regMaestro : procedimientoDTO.getRequProcedimiento()){
            LOG.info("-----------------------------");
            LOG.info("----------------------------");
            LOG.info("idRequisito="+regMaestro.getIdRequisito());
            LOG.info("idRequisitoProcedimientoPad="+regMaestro.getIdRequisitoProcedimientoPad());
            LOG.info("comentario="+regMaestro.getComentario());
            LOG.info("flgGeneral="+regMaestro.getFlgGeneral());
            LOG.info("valoresParaDina="+regMaestro.getValoresParaDina());
            LOG.info("-----------------------------");
            for(RequProcParaDinaDTO regMaestroPD : regMaestro.getValoresParaDina()){
                LOG.info("valorParametro.idParametroDinamico="+regMaestroPD.getValorParametro().getIdParametroDinamico());
                LOG.info("valorParametro.idValorParametro="+regMaestroPD.getValorParametro().getIdValorParametro());
                if(regMaestroPD.getValorParametro().getIdValorParametro()!=null){
                    LOG.info("registraloooo XD");
                }
            }
            LOG.info("-----------------------------");
            LOG.info("actividades="+procedimientoDTO.getActividades());
            if(procedimientoDTO.getActividades()!=null){
                for(ActividadDTO regAct : procedimientoDTO.getActividades()){
                    LOG.info("actividad==>"+regAct.getIdActividad());
                }
            }
        }
        
        LOG.info("procesando registrarRequisitoProcedimientoEspe");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            try{
            	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            	String usuario = ConstantesWeb.getUSUARIO(request);
            	usuarioDTO.setCodigo(usuario);
            }catch(Exception e){
            	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
            }
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            procedimientoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            GuardarProcedimientoInRO in=new GuardarProcedimientoInRO();
            
            GuardarProcedimientoOutRO out=new GuardarProcedimientoOutRO();
            if(procedimientoDTO.getActividades()!=null){
                for(ActividadDTO regAct : procedimientoDTO.getActividades()){
                    //setteando idActividad a cada requisito a 
                    for(CnfRequProcedimientoDTO regRequProc : procedimientoDTO.getRequProcedimiento()){
                        regRequProc.setIdActividad(regAct.getIdActividad());
                    }
                    in.setProcedimiento(procedimientoDTO);
                    in.setUsuario(usuarioDTO);
                    out=cnfRequProcedimientoNeg.guardarRequisitosProcedimiento(in);
                }
            }else{
                in.setProcedimiento(procedimientoDTO);
                in.setUsuario(usuarioDTO);
                out=cnfRequProcedimientoNeg.guardarRequisitosProcedimiento(in);
            }
            
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){
            LOG.error("Error en registrarRequisitoProcedimientoEspe: "+e.getMessage());
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
    @RequestMapping(value="/eliminarRequisitoProcedimiento", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> eliminarCnfRequProcedimiento(CnfRequProcedimientoDTO registroDTO){
        LOG.info("procesando eliminarCnfRequProcedimiento - inicio");
        LOG.info("eliminando-->"+registroDTO.getIdRequisitoProcedimiento());
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            try{
            	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            	String usuario = ConstantesWeb.getUSUARIO(request);
            	usuarioDTO.setCodigo(usuario);
            }catch(Exception e){
            	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
            }
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            registroDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            GuardarCnfRequProcedimientoInRO in=new GuardarCnfRequProcedimientoInRO();
            in.setCnfRequProcedimiento(registroDTO);
            in.setUsuario(usuarioDTO);
            
            GuardarCnfRequProcedimientoOutRO out=cnfRequProcedimientoNeg.eliminarCnfRequProcedimiento(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("cnfRequProcedimiento", out.getCnfRequProcedimiento());              
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        
        }catch(Exception e){
            LOG.error("Error en eliminarRequisito: "+e.getMessage());
            e.printStackTrace();
        }
        LOG.info("procesando eliminarCnfRequProcedimiento - fin");
        return retorno;
    }
    
    @RequestMapping(value="/registrarRequisitoProcedimientoGral", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarRequisitoProcedimientoGral(ProcedimientoDTO procedimientoDTO,HttpServletRequest request){
        LOG.info("-->registroDTO-idProcedimiento->"+procedimientoDTO.getIdProcedimiento());
        for(CnfRequProcedimientoDTO regMaestro : procedimientoDTO.getRequProcedimiento()){
            LOG.info("-----------------------------");
            LOG.info("----------------------------");
            LOG.info("idRequisito="+regMaestro.getIdRequisito());
            LOG.info("idRequisitoProcedimientoPad="+regMaestro.getIdRequisitoProcedimientoPad());
            LOG.info("comentario="+regMaestro.getComentario());
            LOG.info("flgGeneral="+regMaestro.getFlgGeneral());
            LOG.info("valoresParaDina="+regMaestro.getValoresParaDina());
            LOG.info("-----------------------------");
            for(RequProcParaDinaDTO regMaestroPD : regMaestro.getValoresParaDina()){
                LOG.info("valorParametro.idParametroDinamico="+regMaestroPD.getValorParametro().getIdParametroDinamico());
                LOG.info("valorParametro.idValorParametro="+regMaestroPD.getValorParametro().getIdValorParametro());
                if(regMaestroPD.getValorParametro().getIdValorParametro()!=null){
                    LOG.info("registraloooo XD");
                }
            }
        }
        
        LOG.info("procesando registrarRequisitoProcedimientoGral");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            procedimientoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            GuardarProcedimientoInRO in=new GuardarProcedimientoInRO();
            in.setProcedimiento(procedimientoDTO);
            in.setUsuario(usuarioDTO);
            
            GuardarProcedimientoOutRO out=cnfRequProcedimientoNeg.guardarRequisitosProcedimiento(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("Procedimiento", out.getProcedimiento());              
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){
            LOG.error("Error en registrarProcedimiento: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
    @RequestMapping(value="/listarRequisitosProcedimiento",method= RequestMethod.GET)
    public @ResponseBody Map<String, Object> listarRequisitosProcedimiento(CnfRequProcedimientoFilter filtro, HttpSession session){
        LOG.info("procesando listarRequisitosProcedimiento - inicio");
        LOG.info("flgGeneral="+filtro.getFlgGeneral());
        Map<String,Object> retorno = new HashMap<String, Object>();
        try{
            List<CnfRequProcedimientoDTO> listado;
            Integer cuenta=0;

            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            listado=cnfRequProcedimientoNeg.listarRequisitosProcedimiento(filtro);
            LOG.info("listadoRequProc="+listado);
            if(listado!=null){
                cuenta=listado.size();
            }           
            
            retorno.put("registros", cuenta);
            retorno.put("filas", listado);
            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        LOG.info("procesando listarRequisitosProcedimiento - fin");
        return retorno;
    }
    
    @RequestMapping(value= "/nuevo", method = RequestMethod.POST)
    public String nuevo(Long idProcedimiento,String item,String procedimiento,String proceso,HttpSession sesion,HttpServletRequest request,Model model) {
        ZonificacionFilter filter = new ZonificacionFilter();
        model.addAttribute("idProcedimiento", idProcedimiento);
        model.addAttribute("item", item);
        model.addAttribute("procedimiento", procedimiento);
        model.addAttribute("proceso", proceso);
        model.addAttribute("listadoTramite", tramiteServiceNeg.findTramiteByFilter(new TramiteFilter(idProcedimiento,Constantes.CONSTANTE_ESTADO_ACTIVO)));
        model.addAttribute("listaDepartamentos", ubigeoServiceNeg.obtenerListadoDepartamentos());
        model.addAttribute("listaZonificacion", zonificacionServiceNeg.obtenerListadoZonificacion(filter));
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_CONF_REQUISITOXPROCEDIMIENTO_NUEVO;
    }
    
    @RequestMapping(value= "/consulta", method = RequestMethod.GET)
    public String busqueda() {
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_CONF_REQUISITOXPROCEDIMIENTO_CONSULTA;
    }
    
    @RequestMapping(value = "/abrirAgregarRequisito", method = RequestMethod.GET)
    public String abrirAgregarRequisito ( Long idProcedimiento,String idRequisitoProcedimientoPad, String txtRequProcPad, String tipoRequisito,HttpSession sesion,Model model ) {
        model.addAttribute("idProcedimientoMant",idProcedimiento);
        model.addAttribute("idRequisitoProcedimientoPadMant",idRequisitoProcedimientoPad);
        model.addAttribute("txtRequProcPadMant",txtRequProcPad);
        model.addAttribute("tipoRequisito",tipoRequisito);
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_CONF_REQUISITOXPROCEDIMIENTO_FRM_AGREGAR_REQUISITO;
    }
    
    //reordenamiento requisitos
    @RequestMapping(value="/actualizarOrdenRequProc", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> actualizarOrdenRequProc(String regModificar,HttpServletRequest request){
        LOG.info("procesando actualizarOrdenRequProc");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            cnfRequProcedimientoNeg.actualizarOrdenRequProc(regModificar,usuarioDTO);
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            retorno.put(ConstantesWeb.VV_MENSAJE, "Cambios realizados");
        }catch(Exception e){
            LOG.error("Error en actualizarOrdenRequProc",e);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
        }        
        return retorno;
    }
}
