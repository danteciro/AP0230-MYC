package gob.osinergmin.myc.controller;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarTramiteActividadInRO;
import gob.osinergmin.myc.domain.out.GuardarTramiteActividadOutRO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.TramiteActividadFilter;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.business.ActividadServiceNeg;
import gob.osinergmin.myc.service.business.EtapaServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.ProcesoServiceNeg;
import gob.osinergmin.myc.service.business.TramiteActividadServiceNeg;
import gob.osinergmin.myc.service.business.TramiteServiceNeg;
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
@RequestMapping("/tramiteActividad")
public class TramiteActividadController {

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
    @Inject
    private TramiteActividadServiceNeg tramiteActividadServiceNeg;
    
    private static final Logger LOG = LoggerFactory.getLogger(TramiteActividadController.class);
	
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("listadoProceso", procesoServiceNeg.listarProceso());
        model.addAttribute("listadoEtapa", etapaServiceNeg.listarEtapaByDescProceso(Constantes.DESC_PROCESO_PRE_OPERATIVA));
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_TRAMITE_ACTIV;
    }
    
    @RequestMapping(value = "/obtenerProceso", method = RequestMethod.GET)
    public @ResponseBody
    List<ProcesoDTO> obtenerProceso() {
        List<ProcesoDTO> listTipoNormaLegal = new ArrayList<ProcesoDTO>();
        try{
        listTipoNormaLegal=procesoServiceNeg.listarProceso();
        }catch(Exception e){
            LOG.info("error al procesar listadoTiposNormaLegal " +e);
        }
        return listTipoNormaLegal;
    }
    
    @RequestMapping(value = "/obtenerEtapa", method = RequestMethod.GET)
    public @ResponseBody
    List<EtapaDTO> obtenerEtapa(Long idProceso) {
        List<EtapaDTO> listTipoNormaLegal = new ArrayList<EtapaDTO>();
        try{
        listTipoNormaLegal=etapaServiceNeg.listarEtapaById(idProceso);
        LOG.info("Listado: "+listTipoNormaLegal);
        }catch(Exception e){
            LOG.info("error al procesar listadoTiposNormaLegal " +e);
        }
        return listTipoNormaLegal;
    }
    
    @RequestMapping(value = "/listEtapaDetail", method = RequestMethod.GET)
    public @ResponseBody
    List<EtapaDTO> listEtapaDetail(Long idProceso) {
        List<EtapaDTO> listTipoNormaLegal = new ArrayList<EtapaDTO>();
        try{
        listTipoNormaLegal=etapaServiceNeg.listEtapaDetailById(idProceso);
        LOG.info("Listado: "+listTipoNormaLegal);
        }catch(Exception e){
            LOG.info("error al procesar listadoTiposNormaLegal " +e);
        }
        return listTipoNormaLegal;
    }
    
    @RequestMapping(value = "/obtenerTramite", method = RequestMethod.GET)
    public @ResponseBody
    List<TramiteDTO> obtenerTramite(TramiteFilter filtro) {
        List<TramiteDTO> listRegistro = new ArrayList<TramiteDTO>();
        try{
        	filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
        	listRegistro=tramiteServiceNeg.findTramiteByFilter(filtro);
        	LOG.info("Listado: "+listRegistro);
        }catch(Exception e){
            LOG.info("error al procesar listadoTiposNormaLegal " +e);
        }
        return listRegistro;
    }
    
    
    
    @RequestMapping(value="/registrarTramiteActividad", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarTramiteActividad(TramiteActividadDTO tramiteActividad){
        LOG.info("procesando registrarTramiteActividad");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            tramiteActividad.setIdTramiteActivdad(null);
            tramiteActividad.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            GuardarTramiteActividadInRO in=new GuardarTramiteActividadInRO();
            in.setIdTramiteActividad(tramiteActividad);
            in.setUsuario(usuarioDTO);
            
            GuardarTramiteActividadOutRO out=tramiteActividadServiceNeg.guardarTramiteActividad(in);//procedimientoServiceNeg.guardarProcedimiento(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("TramiteActividad", out.getTramiteActividad());              
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarTramiteActividad: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
    @RequestMapping(value="/editarTramiteActividad", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarTramiteActividad(TramiteActividadDTO tramiteActividad){
        LOG.info("procesando editarTramiteActividad");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            tramiteActividad.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            tramiteActividad.setActividad(new ActividadDTO(tramiteActividad.getActividades().get(0).getIdActividad()));
            GuardarTramiteActividadInRO in=new GuardarTramiteActividadInRO();
            in.setIdTramiteActividad(tramiteActividad);
            in.setUsuario(usuarioDTO);
            
            
            GuardarTramiteActividadOutRO out=tramiteActividadServiceNeg.editarTramiteActividad(in);//procedimientoServiceNeg.guardarProcedimiento(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("TramiteActividad", out.getTramiteActividad());              
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en editarTramiteActividad: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
    @RequestMapping(value="/eliminarTramiteActividad", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> eliminarTramiteActividad(TramiteActividadDTO tramiteActividad){
        LOG.info("procesando eliminarTramiteActividad");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            tramiteActividad.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            GuardarTramiteActividadInRO in=new GuardarTramiteActividadInRO();
            in.setIdTramiteActividad(tramiteActividad);
            in.setUsuario(usuarioDTO);            
            
            GuardarTramiteActividadOutRO out=tramiteActividadServiceNeg.eliminarTramiteActividad(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("TramiteActividad", out.getTramiteActividad());              
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en eliminarTramiteActividad: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
    @RequestMapping(value = "/abrirManTramiteActividad", method = RequestMethod.GET)
    public String abrirManTramiteActividad ( String tipo,Long idTramiteActividad, Long idActividad,Long idEtapa, Long idProceso,HttpSession sesion,Model model ) {
        try{
            model.addAttribute("listadoProceso", procesoServiceNeg.listarProceso());
            model.addAttribute("tipo", tipo);
            
            if(!tipo.equals("new") && idActividad!=null){
            	LOG.info("idEtapa-->"+ idEtapa);
            	TramiteActividadFilter filtro=new TramiteActividadFilter();
                filtro.setIdTramiteActividad(idActividad);
                TramiteActividadDTO registro=tramiteActividadServiceNeg.buscarTramiteActividadByFiltro(filtro);
                registro.setIdEtapa(idEtapa);
                registro.setIdProceso(idProceso);
                model.addAttribute("r", registro);
                //listar tramites
                List<TramiteDTO> tramites = tramiteServiceNeg.findTramiteByFilter(new TramiteFilter(null,idActividad,Constantes.CONSTANTE_ESTADO_ACTIVO));
                String txtTramites=MycUtil.concatenaTramites(tramites);
                model.addAttribute("tram", txtTramites);
                LOG.info("TRAMITES"+txtTramites );
                //listar actividades
               /* List<ActividadDTO> actividades = actividadServiceNeg.findActividadByFilter(new ActividadFilter(idTramiteActividad,Constantes.CONSTANTE_ESTADO_ACTIVO));
                String txtActividades=MycUtil.concatenaActividades(actividades);
                model.addAttribute("acti", txtActividades);*/
            }
        }catch(Exception e){
            LOG.error("",e);
        }
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_FRM_TRAMITE_ACTIV;
    }
    
    @RequestMapping(value = "/abrirManEditTramiteActividad", method = RequestMethod.GET)
    public String abrirManEditTramiteActividad ( String tipo,Long idTramiteActividad, Long idActividad,Long idEtapa, Long idProceso,Long idTramite,HttpSession sesion,Model model ) {
        try{
            model.addAttribute("listadoProceso", procesoServiceNeg.listarProceso());
            //model.addAttribute("listadoEtapa", etapaServiceNeg.listarEtapaByDescProceso(Constantes.DESC_PROCESO_PRE_OPERATIVA)); 
            model.addAttribute("listadoEtapa", etapaServiceNeg.listarEtapaById(idProceso)); 
            model.addAttribute("listadoTramite",tramiteServiceNeg.findTramiteByFilter(new TramiteFilter(Constantes.CONSTANTE_ESTADO_ACTIVO,idEtapa)));
            model.addAttribute("tipo", tipo);
            LOG.info("idEtapa-->"+ idEtapa);
            LOG.info("idProceso-->"+ idProceso);
            
        	TramiteActividadFilter filtro=new TramiteActividadFilter();
            filtro.setIdTramiteActividad(idTramiteActividad);
            TramiteActividadDTO registro=tramiteActividadServiceNeg.buscarTramiteActividadByFiltro(filtro);
            registro.setIdEtapa(idEtapa);
            registro.setIdProceso(idProceso);
            registro.setIdTramite(idTramite);
            registro.setIdTramiteActivdad(idTramiteActividad);
            model.addAttribute("r", registro);
            
            List<ActividadDTO> actividades = actividadServiceNeg.findActividadByFilter(new ActividadFilter(Constantes.CONSTANTE_ESTADO_ACTIVO,idTramiteActividad));
            String txtActividades=MycUtil.concatenaActividades(actividades);
            model.addAttribute("acti", txtActividades);
            	
          
        }catch(Exception e){
            LOG.error("",e);
        }
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_FRM_EDIT_TRAMITE_ACTIV;
    }
    
    @RequestMapping(value="/findTramiteActividad",method=RequestMethod.GET)
    public @ResponseBody Map<String,Object> findTramiteActividad(TramiteActividadFilter filtro,int rows, int page, int flg_load, 
        HttpSession session, HttpServletResponse response, HttpServletRequest request){
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
            LOG.info("procesando findTramiteActividad");
            List<TramiteActividadDTO> listado;
            int total=0;
            Integer cuenta;
            
            if(flg_load==1){
                int inicio;
                inicio=rows*page-rows;
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                
                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                listado=tramiteActividadServiceNeg.listarTramiteActividad(filtro, auxiliar);
                LOG.info("cuenta Controller findTramiteActividad="+auxiliar[0]);

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
