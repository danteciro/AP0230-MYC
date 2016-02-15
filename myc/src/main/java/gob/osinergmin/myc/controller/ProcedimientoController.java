/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarProcedimientoInRO;
import gob.osinergmin.myc.domain.out.GuardarProcedimientoOutRO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.ProcedimientoFilter;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.business.ActividadServiceNeg;
import gob.osinergmin.myc.service.business.EtapaServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.ProcedimientoServiceNeg;
import gob.osinergmin.myc.service.business.ProcesoServiceNeg;
import gob.osinergmin.myc.service.business.TramiteServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;
import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author jpiro
 */

@Controller
@RequestMapping("/procedimiento")
public class ProcedimientoController {
    private static final Logger LOG = LoggerFactory.getLogger(PrincipalController.class);
    @Inject
    private ProcedimientoServiceNeg procedimientoServiceNeg;
    @Inject
    private ProcesoServiceNeg procesoServiceNeg;
    @Inject
    private EtapaServiceNeg etapaServiceNeg;
    @Inject
    private MaestroColumnaServiceNeg maestroColumnaServiceNeg;
    @Inject
    private TramiteServiceNeg tramiteServiceNeg;
    @Inject
    private ActividadServiceNeg actividadServiceNeg;
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("listadoProceso", procesoServiceNeg.listarProceso());
        model.addAttribute("listadoEtapa", etapaServiceNeg.listarEtapaByDescProceso(Constantes.DESC_PROCESO_PRE_OPERATIVA));
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT_PROCEDIMIENTO;
    }
    
    @RequestMapping(value="/validarDependProcedimiento", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> validarDependProcedimiento(ProcedimientoDTO procedimientoDTO){
        LOG.info("procesando validarDependProcedimiento");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{
            procedimientoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            GuardarProcedimientoInRO in=new GuardarProcedimientoInRO();
            in.setProcedimiento(procedimientoDTO);
            
            GuardarProcedimientoOutRO out=procedimientoServiceNeg.validarDependProcedimiento(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){
            LOG.error("Error en validarDependProcedimiento: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
    @RequestMapping(value="/editarProcedimiento", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarProcedimiento(ProcedimientoDTO procedimientoDTO){
        LOG.info("procesando editarProcedimiento");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            procedimientoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            GuardarProcedimientoInRO in=new GuardarProcedimientoInRO();
            in.setProcedimiento(procedimientoDTO);
            in.setUsuario(usuarioDTO);
            
            GuardarProcedimientoOutRO out=procedimientoServiceNeg.editarProcedimiento(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("procedimiento", out.getProcedimiento());              
            LOG.info("out.getMensaje--->"+out.getMensaje());
            retorno.put(ConstantesWeb.VV_MENSAJE,out.getMensaje());
        }catch(Exception e){
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en editarProcedimiento: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
    @RequestMapping(value="/eliminarProcedimiento", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> eliminarProcedimiento(ProcedimientoDTO procedimeintoDTO){
        LOG.info("procesando eliminarProcedimiento");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            procedimeintoDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            GuardarProcedimientoInRO in=new GuardarProcedimientoInRO();
            in.setProcedimiento(procedimeintoDTO);
            in.setUsuario(usuarioDTO);
            
            GuardarProcedimientoOutRO out=procedimientoServiceNeg.eliminarProcedimiento(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            //retorno.put("requisito", out.getProcedimiento());              
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
            
        }catch(Exception e){
            LOG.error("Error en eliminarProcedimiento: "+e.getMessage());
            e.printStackTrace();
        }
        
        return retorno;
    }
    
    @RequestMapping(value="/registrarProcedimiento", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarProcedimiento(ProcedimientoDTO procedimientoDTO){
        LOG.info("procesando registrarProcedimiento");
        Map<String,Object> retorno = new HashMap<String,Object>();
        LOG.info("--------->item="+procedimientoDTO.getItem());
        LOG.info("--------->plazoresolvr="+procedimientoDTO.getPlazoResolver());
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            procedimientoDTO.setIdProcedimiento(null);
            procedimientoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            GuardarProcedimientoInRO in=new GuardarProcedimientoInRO();
            in.setProcedimiento(procedimientoDTO);
            in.setUsuario(usuarioDTO);
            
            GuardarProcedimientoOutRO out=procedimientoServiceNeg.guardarProcedimiento(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("procedimiento", out.getProcedimiento());              
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarProcedimiento: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
    @RequestMapping(value="/loadCmbSilencioAdministrativo",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> loadCmbSilencioAdministrativo(long idMaestroColumna){
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            LOG.info("procesando loadCmbSilencioAdministrativo");
            List<MaestroColumnaDTO> listado;
            listado=maestroColumnaServiceNeg.buscarByDescripHijos(idMaestroColumna);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value = "/abrirMantProcedimiento", method = RequestMethod.GET)
    public String abrirMantProcedimiento ( String tipo, Long idProcedimiento,Long idEtapa, Long idProceso,HttpSession sesion,Model model ) {
        try{
            model.addAttribute("listadoProceso", procesoServiceNeg.listarProceso());
            model.addAttribute("listadoEtapa", etapaServiceNeg.listarEtapaByDescProceso(Constantes.DESC_PROCESO_PRE_OPERATIVA));
            model.addAttribute("listadoAnexo", maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_ANEXO_RRH));
            model.addAttribute("listadoCalificacion", maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_CALIFICACION));
            model.addAttribute("listadoInicProc", maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_INICIO_PROCEDIMIENTO));
            model.addAttribute("listadoAutCompReso", maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_AUTORIDAD_RESOLVER));
            model.addAttribute("listadoReconsideracion", maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_INST_RESO_RECONSI));
            model.addAttribute("listadoApelacion", maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_INST_RESO_APEL));
            model.addAttribute("valorUit", maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_VALOR_UIT).get(0));
            
            model.addAttribute("tipo", tipo);
        
            if(!tipo.equals("new") && idProcedimiento!=null){
                ProcedimientoFilter filtro=new ProcedimientoFilter();
                filtro.setIdProcedimiento(idProcedimiento);
                ProcedimientoDTO registro=procedimientoServiceNeg.buscarProcedimientoByFiltro(filtro);
                registro.setIdEtapa(idEtapa);
                registro.setIdProceso(idProceso);
                model.addAttribute("r", registro);
                //listar tramites
                List<TramiteDTO> tramites = tramiteServiceNeg.findTramiteByFilter(new TramiteFilter(idProcedimiento,Constantes.CONSTANTE_ESTADO_ACTIVO));
                String txtTramites=MycUtil.concatenaTramites(tramites);
                model.addAttribute("tram", txtTramites);
                //listar actividades
                List<ActividadDTO> actividades = actividadServiceNeg.findActividadByFilter(new ActividadFilter(idProcedimiento,Constantes.CONSTANTE_ESTADO_ACTIVO));
                String txtActividades=MycUtil.concatenaActividades(actividades);
                model.addAttribute("acti", txtActividades);
            }
        }catch(Exception e){
            LOG.error("",e);
        }
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT_FRM_PROCEDIMIENTO;
    }
    
    @RequestMapping(value="/findProcedimiento",method=RequestMethod.GET)
    public @ResponseBody Map<String,Object> findProcedimiento(ProcedimientoFilter filtro,int rows, int page, int flg_load, 
        HttpSession session, HttpServletResponse response, HttpServletRequest request){
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
            LOG.info("procesando findProcedimiento");
            List<ProcedimientoDTO> listado;
            int total=0;
            Integer cuenta;
            
            if(flg_load==1){
                int inicio;
                inicio=rows*page-rows;
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                
                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                listado=procedimientoServiceNeg.listarProcedimiento(filtro, auxiliar);
                LOG.info("cuenta Controller findProcedimiento="+auxiliar[0]);

                cuenta=auxiliar[0];
                if (cuenta > 0) {
                    total = (int) Math.ceil((double) cuenta / (double) rows);
                }

                retorno.put("total", total);
                retorno.put("pagina", page);
                retorno.put("registros", cuenta);
                retorno.put("filas", listado);
                
            }            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/findActividadProcedimiento",method=RequestMethod.GET)
    public @ResponseBody Map<String,Object> findActividadProcedimiento(Long idProcedimiento,int rows,int page, int flg_load,HttpSession session){
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            LOG.info("procesando findActividadProcedimiento");
            List<ActividadDTO> listado;
            int total=0;
            Integer cuenta;
            if(flg_load==1){
                int inicio;
                inicio=rows*page-rows;
                
                ActividadFilter filtro=new ActividadFilter();
                filtro.setIdProcedimiento(idProcedimiento);
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                
                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                listado=procedimientoServiceNeg.listarActividadProcedimiento(filtro,auxiliar);
                LOG.info("cuenta Controller listarActividadProcedimiento="+auxiliar[0]);

                cuenta=auxiliar[0];
                if (cuenta > 0) {
                    total = (int) Math.ceil((double) cuenta / (double) rows);
                }

                retorno.put("total", total);
                retorno.put("pagina", page);
                retorno.put("registros", cuenta);
                retorno.put("filas", listado);
            }            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
}
