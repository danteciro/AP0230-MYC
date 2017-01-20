package gob.osinergmin.myc.controller;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarRubroOpcionInRO;
import gob.osinergmin.myc.domain.out.GuardarRubroOpcionOutRO;
import gob.osinergmin.myc.domain.ui.OpcionFilter;
import gob.osinergmin.myc.domain.ui.RubroOpcionFilter;
import gob.osinergmin.myc.domain.ui.TramiteActividadFilter;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.business.EtapaServiceNeg;
import gob.osinergmin.myc.service.business.OpcionServiceNeg;
import gob.osinergmin.myc.service.business.ProcesoServiceNeg;
import gob.osinergmin.myc.service.business.RubroOpcionServiceNeg;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
* Resumen.
* Objeto                   : RubroOpcionController.java 
* Descripción              : Controlador para el uso del modulo de rubroOpcion.
* Fecha de Creación        : 26/05/2016
* PR de Modificacion       : OSINE_119
* Autor                    : Juan Sifuentes Acosta.
* ---------------------------------------------------------------------------------------
* Modificaciones
* Motivo       Fecha       Nombre                 Descripcion
* ----------------------------------------------------------------------------------------
 */

@Controller
@RequestMapping("/rubroOpcion")
public class RubroOpcionController {

    @Inject
    private ProcesoServiceNeg procesoServiceNeg;
    @Inject
    private EtapaServiceNeg etapaServiceNeg;
    @Inject
    private TramiteServiceNeg tramiteServiceNeg;
    @Inject
    private OpcionServiceNeg opcionServiceNeg;
    @Inject
    private RubroOpcionServiceNeg rubroOpcionServiceNeg;
    @Inject
    private TramiteActividadServiceNeg tramiteActividadServiceNeg;
    
    private static final Logger LOG = LoggerFactory.getLogger(TramiteActividadController.class);
	
    /**
     * Metodo que inicia el controlador al jsp
     * @param model
     * @param sesion
     * @param request
     * @return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_RUBRO_OPCION
     */
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("listadoProceso", procesoServiceNeg.listarProceso());
        model.addAttribute("listadoEtapa", etapaServiceNeg.listarEtapaByDescProceso(Constantes.DESC_PROCESO_PRE_OPERATIVA));
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_RUBRO_OPCION;
    }
    
    /**
     * Metodo para registrar la relacion rubro opcion
     * @param rubroOpcion
     * @return retorno
     */
    @RequestMapping(value="/registrarRubroOpcion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarRubroOpcion(RubroOpcionDTO rubroOpcion){
        LOG.info("procesando registrarTramiteActividad");
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
            rubroOpcion.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            GuardarRubroOpcionInRO in=new GuardarRubroOpcionInRO();
            in.setIdRubroOpcion(rubroOpcion);
            in.setUsuario(usuarioDTO);
            
            GuardarRubroOpcionOutRO out=rubroOpcionServiceNeg.guardarRubroOpcion(in);//procedimientoServiceNeg.guardarProcedimiento(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("TramiteActividad", out.getRubroOpcion());              
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarTramiteActividad: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
    /**
     * Metodo para editar la relacion rubro opcion
     * @param rubroOpcion
     * @return retorno
     */
    @RequestMapping(value="/editarRubroOpcion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarRubroOpcion(RubroOpcionDTO rubroOpcion){
        LOG.info("procesando editarTramiteActividad");
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
            rubroOpcion.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            rubroOpcion.setOpciones(rubroOpcion.getOpciones());
            GuardarRubroOpcionInRO in=new GuardarRubroOpcionInRO();
            in.setIdRubroOpcion(rubroOpcion);
            in.setUsuario(usuarioDTO);
            
            GuardarRubroOpcionOutRO out=rubroOpcionServiceNeg.editarRubroOpcion(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
//            retorno.put("TramiteActividad", out.getTramiteActividad());
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en editarTramiteActividad: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
    /**
     * Metodo para eliminar la relacion rubro opcion
     * @param rubroOpcion
     * @return retorno
     */
    @RequestMapping(value="/eliminarRubroOpcion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> eliminarRubroOpcion(RubroOpcionDTO rubroOpcion){
        LOG.info("procesando eliminarTramiteActividad");
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
            rubroOpcion.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            GuardarRubroOpcionInRO in=new GuardarRubroOpcionInRO();
            in.setIdRubroOpcion(rubroOpcion);
            in.setUsuario(usuarioDTO);            
            
            GuardarRubroOpcionOutRO out=rubroOpcionServiceNeg.eliminarRubroOpcion(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("RubroOpcion", out.getRubroOpcion());
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en eliminarTramiteActividad: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    
    /**
     * Metodo para abrir el mantenimiento de rubro opcion
     * @param tipo
     * @param idTramiteActividad
     * @param idActividad
     * @param idEtapa
     * @param idProceso
     * @param sesion
     * @param model
     * @return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_FRM_RUBRO_OPCION
     */
    @RequestMapping(value = "/abrirManRubroOpcion", method = RequestMethod.GET)
    public String abrirManRubroOpcion ( String tipo,Long idTramiteActividad, Long idActividad,Long idEtapa, Long idProceso,HttpSession sesion,Model model ) {
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
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_FRM_RUBRO_OPCION;
    }
    
    /**
     * Metodo para abrir el mantenimiento de editar rubro opccion
     * @param tipo
     * @param idRubroOpcion
     * @param idActividad
     * @param idOpcion
     * @param sesion
     * @param model
     * @return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_EDIT_FRM_RUBRO_OPCION
     */
    @RequestMapping(value = "/abrirManEditRubroOpcion", method = RequestMethod.GET)
    public String abrirManEditTramiteActividad ( String tipo,Long idRubroOpcion, Long idActividad, Long idOpcion, HttpSession sesion,Model model ) {
        try{
            model.addAttribute("tipo", tipo);
            model.addAttribute("acti", idActividad);
            
            RubroOpcionFilter filtro=new RubroOpcionFilter();
            filtro.setIdRubroOpcion(idRubroOpcion);            
            
            OpcionFilter OpciondFilter = new OpcionFilter();
            OpciondFilter.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            OpciondFilter.setIdActividad(idActividad);
            
            List<OpcionDTO> opciones = opcionServiceNeg.findOpcionByFilter(OpciondFilter);
//            List<OpcionDTO> opciones = opcionServiceNeg.findOpcionByFilter(new OpcionFilter(Constantes.CONSTANTE_ESTADO_ACTIVO, idRubroOpcion));
            String txtOpciones=MycUtil.concatenaOpciones(opciones);
            model.addAttribute("opci", txtOpciones);
            	
          
        }catch(Exception e){
            LOG.error("",e);
        }
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_EDIT_FRM_RUBRO_OPCION;
    }
    
    /**
     * Metodo  para buscar rubro opcion
     * @param filtro
     * @param rows
     * @param page
     * @param flg_load
     * @param session
     * @param response
     * @param request
     * @return retorno
     */
    @RequestMapping(value="/findRubroOpcion",method=RequestMethod.GET)
    public @ResponseBody Map<String,Object> findRubroOpcion(RubroOpcionFilter filtro,int rows, int page, int flg_load, 
        HttpSession session, HttpServletResponse response, HttpServletRequest request){
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
            LOG.info("procesando findRubroOpcion");
            List<RubroOpcionDTO> listado;
            int total=0;
            Integer cuenta;
            
            if(flg_load==1){
                int inicio;
                inicio=rows*page-rows;
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                
                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                listado=rubroOpcionServiceNeg.listarRubroOpcion(filtro, auxiliar);
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
    
    /**
     * Metodo lista opciones
     * @param filtro
     * @return retorno
     */
    @RequestMapping(value="/loadOpciones",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> loadActividad(OpcionFilter filtro){
        LOG.info("procesando loadActividad");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
//            ActividadFilter filtro=new ActividadFilter();
        	Long idOpcionTipoSuperv=opcionServiceNeg.obtenerIdTipoSupervision();
        	
        	
            int[] auxiliar=new int[1];
            auxiliar[0]=0;
            List<OpcionDTO> listado;
            listado=rubroOpcionServiceNeg.listarOpciones(filtro,auxiliar);
            retorno.put("filas", listado);
            retorno.put("total", auxiliar[0]);
            retorno.put("idOpcionTipoSuperv", idOpcionTipoSuperv);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
}
