package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.CfgActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.service.business.ActividadServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Clase controladora que permite gestionar la configuración de actividades
 * @author cflorian
 * @version 1.0
 * @see
 */
@Controller
@RequestMapping("/actividadesController")
public class ActividadesController {
    private static final Logger LOG = LoggerFactory.getLogger(ActividadesController.class);
    @Inject    
    ActividadServiceNeg actividadServiceNeg;
	
	/**
	 * Metodo que da inicio al controller y redirecciona al modulo de configuración de actividades
	 * @return
	 */
    @RequestMapping(method = RequestMethod.GET)
    public String inicio() {
    	LOG.info("inicio - actividadesController");
        return ConstantesWeb.Navegacion.PAGE_REGISTRO_CONF_BUSQ_ACTIVIDAD;  
    }
    
    /**
     * Metodo que permite el listado de actividades
     * @param rows
     * @param page
     * @param flg_load
     * @param session
     * @return
     */
    @RequestMapping(value="/listarActividades",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> listarActividades(int rows, int page,int flg_load,HttpSession session){
        LOG.info("listarActividades - actividadesController");
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
        	List<CfgActividadDTO> lstActividades= new ArrayList<CfgActividadDTO>();
        	int inicio = 0;
        	int total=0 ;
            Integer cuenta=0;            
            int[] auxiliar = new int[1];
            auxiliar[0] = 0;             
            inicio = rows * page - rows;
            
            //lstPlacasRodaje = registroService.listarPlacasRodaje(numExpediente, auxiliar);
            
            //borrar desde aca
            CfgActividadDTO cfgActividadDTO = new CfgActividadDTO();
            cfgActividadDTO.setIndex("1");
            cfgActividadDTO.setCodGrupoActividad("1");
            cfgActividadDTO.setDesGrupoActividad("Establecimiento de Venta al Público");
            cfgActividadDTO.setCodSubGrupoActividad("1");
            cfgActividadDTO.setDesSubGrupoActividad("Establecimiento de Venta al Público de Combustibles");
            cfgActividadDTO.setCodActividad("050");
            cfgActividadDTO.setDesActividad("050 - Estaciones de Servicio/Grifo");
            cfgActividadDTO.setCodTipoDireccion("1");//Establecimiento
            cfgActividadDTO.setDesTipoDireccion("Establecimiento");
            cfgActividadDTO.setFlgTramInstalacion(true);
            cfgActividadDTO.setFlgTramModInstalacion(true);
            cfgActividadDTO.setFlgTramEstRiesgo(false);
            cfgActividadDTO.setFlgTramPlanContingencia(false);
            cfgActividadDTO.setFlgTramOpinionFav(false);
            cfgActividadDTO.setFlgTramActasVerif(true);
            cfgActividadDTO.setFlgTramActasVerifYPrueba(false);
            cfgActividadDTO.setFlgTramActasPrueba(false);
            cfgActividadDTO.setFlgTramInscripcion(false);
            cfgActividadDTO.setFlgTramModInscripcion(false);
            cfgActividadDTO.setFlgTramSuspension(false);
            cfgActividadDTO.setFlgTramCancelacion(false);
            cfgActividadDTO.setFlgTramHabilitacion(false);
            cfgActividadDTO.setFlgTramReconsideracion(false);
            cfgActividadDTO.setFlgTramApelacion(false);
            cfgActividadDTO.setFlgAsignado(false);
            lstActividades.add(cfgActividadDTO);
            cfgActividadDTO = new CfgActividadDTO();
            cfgActividadDTO.setIndex("2");
            cfgActividadDTO.setCodGrupoActividad("1");
            cfgActividadDTO.setDesGrupoActividad("Establecimiento de Venta al Público");
            cfgActividadDTO.setCodSubGrupoActividad("1");
            cfgActividadDTO.setDesSubGrupoActividad("Establecimiento de Venta al Público de Combustibles");
            cfgActividadDTO.setCodActividad("056");
            cfgActividadDTO.setDesActividad("056 - Estaciones de Servicio con Gasocentro de GLP");
            cfgActividadDTO.setCodTipoDireccion("0");//Establecimiento
            cfgActividadDTO.setDesTipoDireccion("");
            cfgActividadDTO.setFlgTramInstalacion(false);
            cfgActividadDTO.setFlgTramModInstalacion(false);
            cfgActividadDTO.setFlgTramEstRiesgo(false);
            cfgActividadDTO.setFlgTramPlanContingencia(false);
            cfgActividadDTO.setFlgTramOpinionFav(false);
            cfgActividadDTO.setFlgTramActasVerif(false);
            cfgActividadDTO.setFlgTramActasVerifYPrueba(false);
            cfgActividadDTO.setFlgTramActasPrueba(false);
            cfgActividadDTO.setFlgTramInscripcion(false);
            cfgActividadDTO.setFlgTramModInscripcion(false);
            cfgActividadDTO.setFlgTramSuspension(false);
            cfgActividadDTO.setFlgTramCancelacion(false);
            cfgActividadDTO.setFlgTramHabilitacion(false);
            cfgActividadDTO.setFlgTramReconsideracion(false);
            cfgActividadDTO.setFlgTramApelacion(false);
            cfgActividadDTO.setFlgAsignado(false);
            lstActividades.add(cfgActividadDTO);
            cfgActividadDTO = new CfgActividadDTO();
            cfgActividadDTO.setIndex("3");
            cfgActividadDTO.setCodGrupoActividad("1");
            cfgActividadDTO.setDesGrupoActividad("Establecimiento de Venta al Público");
            cfgActividadDTO.setCodSubGrupoActividad("1");
            cfgActividadDTO.setDesSubGrupoActividad("Establecimiento de Venta al Público de Combustibles");
            cfgActividadDTO.setCodActividad("057");
            cfgActividadDTO.setDesActividad("057 - Grifo Rural");
            cfgActividadDTO.setCodTipoDireccion("0");//Establecimiento
            cfgActividadDTO.setDesTipoDireccion("");
            cfgActividadDTO.setFlgTramInstalacion(false);
            cfgActividadDTO.setFlgTramModInstalacion(false);
            cfgActividadDTO.setFlgTramEstRiesgo(false);
            cfgActividadDTO.setFlgTramPlanContingencia(false);
            cfgActividadDTO.setFlgTramOpinionFav(false);
            cfgActividadDTO.setFlgTramActasVerif(false);
            cfgActividadDTO.setFlgTramActasVerifYPrueba(false);
            cfgActividadDTO.setFlgTramActasPrueba(false);
            cfgActividadDTO.setFlgTramInscripcion(false);
            cfgActividadDTO.setFlgTramModInscripcion(false);
            cfgActividadDTO.setFlgTramSuspension(false);
            cfgActividadDTO.setFlgTramCancelacion(false);
            cfgActividadDTO.setFlgTramHabilitacion(false);
            cfgActividadDTO.setFlgTramReconsideracion(false);
            cfgActividadDTO.setFlgTramApelacion(false);
            cfgActividadDTO.setFlgAsignado(false);
            lstActividades.add(cfgActividadDTO);
            cfgActividadDTO = new CfgActividadDTO();
            cfgActividadDTO.setIndex("4");
            cfgActividadDTO.setCodGrupoActividad("1");
            cfgActividadDTO.setDesGrupoActividad("Establecimiento de Venta al Público");
            cfgActividadDTO.setCodSubGrupoActividad("1");
            cfgActividadDTO.setDesSubGrupoActividad("Establecimiento de Venta al Público de Combustibles");
            cfgActividadDTO.setCodActividad("058");
            cfgActividadDTO.setDesActividad("058 - Grifo Flotante");
            cfgActividadDTO.setCodTipoDireccion("0");//Establecimiento
            cfgActividadDTO.setDesTipoDireccion("");
            cfgActividadDTO.setFlgTramInstalacion(false);
            cfgActividadDTO.setFlgTramModInstalacion(false);
            cfgActividadDTO.setFlgTramEstRiesgo(false);
            cfgActividadDTO.setFlgTramPlanContingencia(false);
            cfgActividadDTO.setFlgTramOpinionFav(false);
            cfgActividadDTO.setFlgTramActasVerif(false);
            cfgActividadDTO.setFlgTramActasVerifYPrueba(false);
            cfgActividadDTO.setFlgTramActasPrueba(false);
            cfgActividadDTO.setFlgTramInscripcion(false);
            cfgActividadDTO.setFlgTramModInscripcion(false);
            cfgActividadDTO.setFlgTramSuspension(false);
            cfgActividadDTO.setFlgTramCancelacion(false);
            cfgActividadDTO.setFlgTramHabilitacion(false);
            cfgActividadDTO.setFlgTramReconsideracion(false);
            cfgActividadDTO.setFlgTramApelacion(false);
            cfgActividadDTO.setFlgAsignado(false);
            lstActividades.add(cfgActividadDTO);
            cfgActividadDTO = new CfgActividadDTO();
            cfgActividadDTO.setIndex("5");
            cfgActividadDTO.setCodGrupoActividad("1");
            cfgActividadDTO.setDesGrupoActividad("Establecimiento de Venta al Público");
            cfgActividadDTO.setCodSubGrupoActividad("1");
            cfgActividadDTO.setDesSubGrupoActividad("Establecimiento de Venta al Público de Combustibles");
            cfgActividadDTO.setCodActividad("071");
            cfgActividadDTO.setDesActividad("071 - Gasocentro de GLP");
            cfgActividadDTO.setCodTipoDireccion("0");//Establecimiento
            cfgActividadDTO.setDesTipoDireccion(""); 
            cfgActividadDTO.setFlgTramInstalacion(false);
            cfgActividadDTO.setFlgTramModInstalacion(false);
            cfgActividadDTO.setFlgTramEstRiesgo(false);
            cfgActividadDTO.setFlgTramPlanContingencia(false);
            cfgActividadDTO.setFlgTramOpinionFav(false);
            cfgActividadDTO.setFlgTramActasVerif(false);
            cfgActividadDTO.setFlgTramActasVerifYPrueba(false);
            cfgActividadDTO.setFlgTramActasPrueba(false);
            cfgActividadDTO.setFlgTramInscripcion(false);
            cfgActividadDTO.setFlgTramModInscripcion(false);
            cfgActividadDTO.setFlgTramSuspension(false);
            cfgActividadDTO.setFlgTramCancelacion(false);
            cfgActividadDTO.setFlgTramHabilitacion(false);
            cfgActividadDTO.setFlgTramReconsideracion(false);
            cfgActividadDTO.setFlgTramApelacion(false);
            cfgActividadDTO.setFlgAsignado(false);
            lstActividades.add(cfgActividadDTO);
            cfgActividadDTO = new CfgActividadDTO();
            cfgActividadDTO.setIndex("6");
            cfgActividadDTO.setCodGrupoActividad("2");
            cfgActividadDTO.setDesGrupoActividad("Planta Envasadora");
            cfgActividadDTO.setCodSubGrupoActividad("2");
            cfgActividadDTO.setDesSubGrupoActividad("");
            cfgActividadDTO.setCodActividad("070");
            cfgActividadDTO.setDesActividad("070 - Planta Envasadora de GLP");
            cfgActividadDTO.setCodTipoDireccion("0");//Establecimiento
            cfgActividadDTO.setDesTipoDireccion("");
            cfgActividadDTO.setFlgTramInstalacion(false);
            cfgActividadDTO.setFlgTramModInstalacion(false);
            cfgActividadDTO.setFlgTramEstRiesgo(false);
            cfgActividadDTO.setFlgTramPlanContingencia(false);
            cfgActividadDTO.setFlgTramOpinionFav(false);
            cfgActividadDTO.setFlgTramActasVerif(false);
            cfgActividadDTO.setFlgTramActasVerifYPrueba(false);
            cfgActividadDTO.setFlgTramActasPrueba(false);
            cfgActividadDTO.setFlgTramInscripcion(false);
            cfgActividadDTO.setFlgTramModInscripcion(false);
            cfgActividadDTO.setFlgTramSuspension(false);
            cfgActividadDTO.setFlgTramCancelacion(false);
            cfgActividadDTO.setFlgTramHabilitacion(false);
            cfgActividadDTO.setFlgTramReconsideracion(false);
            cfgActividadDTO.setFlgTramApelacion(false);
            cfgActividadDTO.setFlgAsignado(false);
            lstActividades.add(cfgActividadDTO);

     
            auxiliar[0] = lstActividades.size();
            //borrar hasta aca
            
            cuenta=auxiliar[0];
            if (cuenta > 0) {
                total = (int) Math.ceil((double) cuenta / (double) rows);
            }            

                retorno.put("total", total);
                retorno.put("pagina", page);
                retorno.put("registros", cuenta);
                retorno.put("filas", lstActividades);                
            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    /**
     * Metodo que permite el listado de actividades y los trámites asociados a él
     * @param rows
     * @param page
     * @param flg_load
     * @param session
     * @return
     */
    @RequestMapping(value="/listarActividadYTramites",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> listarActividadYTramites(int rows, int page,int flg_load,HttpSession session){
        LOG.info("listarActividadYTramites - actividadesController");
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
        	List<CfgActividadDTO> lstActividades= new ArrayList<CfgActividadDTO>();
        	int inicio = 0;
        	int total=0 ;
            Integer cuenta=0;            
            int[] auxiliar = new int[1];
            auxiliar[0] = 0;             
            inicio = rows * page - rows;
            
            //lstPlacasRodaje = registroService.listarPlacasRodaje(numExpediente, auxiliar);
            
            //borrar desde aca
            CfgActividadDTO cfgActividadDTO = new CfgActividadDTO();
            cfgActividadDTO.setIndex("1");
            cfgActividadDTO.setDesGrupoActividad("Establecimiento de Venta al Público");
            cfgActividadDTO.setDesSubGrupoActividad("Establecimiento de Venta al Público de Combustibles");
            cfgActividadDTO.setDesActividad("050 - Estaciones de Servicio/Grifo");
            cfgActividadDTO.setDesEtapa("Instalación");
            cfgActividadDTO.setDesTramite("Instalación");
            cfgActividadDTO.setFlgUROC(false);
            cfgActividadDTO.setFlgUPPD(false);
            cfgActividadDTO.setFlgGO(false);
            cfgActividadDTO.setFlgSCOP(false);
            lstActividades.add(cfgActividadDTO);
            cfgActividadDTO = new CfgActividadDTO();
            cfgActividadDTO.setIndex("2");
            cfgActividadDTO.setDesGrupoActividad("Establecimiento de Venta al Público");
            cfgActividadDTO.setDesSubGrupoActividad("Establecimiento de Venta al Público de Combustibles");
            cfgActividadDTO.setDesActividad("050 - Estaciones de Servicio/Grifo");
            cfgActividadDTO.setDesEtapa("Instalación");
            cfgActividadDTO.setDesTramite("Modificación de Instalación");
            cfgActividadDTO.setFlgUROC(false);
            cfgActividadDTO.setFlgUPPD(false);
            cfgActividadDTO.setFlgGO(false);
            cfgActividadDTO.setFlgSCOP(false);
            lstActividades.add(cfgActividadDTO);
            cfgActividadDTO = new CfgActividadDTO();
            cfgActividadDTO.setIndex("3");
            cfgActividadDTO.setDesGrupoActividad("Establecimiento de Venta al Público");
            cfgActividadDTO.setDesSubGrupoActividad("Establecimiento de Venta al Público de Combustibles");
            cfgActividadDTO.setDesActividad("050 - Estaciones de Servicio/Grifo");
            cfgActividadDTO.setDesEtapa("Pruebas");
            cfgActividadDTO.setDesTramite("Actas de Verificación de Pruebas");
            cfgActividadDTO.setFlgUROC(false);
            cfgActividadDTO.setFlgUPPD(false);
            cfgActividadDTO.setFlgGO(false);
            cfgActividadDTO.setFlgSCOP(false);
            lstActividades.add(cfgActividadDTO);
     
            auxiliar[0] = lstActividades.size();
            //borrar hasta aca
            
            cuenta=auxiliar[0];
            if (cuenta > 0) {
                total = (int) Math.ceil((double) cuenta / (double) rows);
            }            

                retorno.put("total", total);
                retorno.put("pagina", page);
                retorno.put("registros", cuenta);
                retorno.put("filas", lstActividades);                
            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    /**
     * Metodo que redirecciona al popup de Asignacion de Unidades Fiscalizadoras y Scop a la actividad segun el tramite
     * @param sesion
     * @param request
     * @param model
     * @param codActividad
     * @return
     */
	@RequestMapping(value = "/irPopupAsigUnidFisScop", method = RequestMethod.GET)
    public String irPopupAsigUnidFisScop ( HttpSession sesion , HttpServletRequest request ,
									    Model model, String codActividad) {
		LOG.info("irPopupAsigUnidFisScop - actividadesController");
		return ConstantesWeb.Navegacion.PAGE_REGISTRO_CONF_REG_ASIGNACION;
    }	
	
	
	@RequestMapping(value = "/abrirPopupBusqActividad", method = RequestMethod.GET)
    public String abrirPopupBusqActividad ( HttpSession sesion , HttpServletRequest request ,
									    Model model, String codActividad) {
		LOG.info("abrirPopupBusqActividad - actividadesController");
		return ConstantesWeb.Navegacion.PAGE_REGISTRO_CONF_FRM_SELECT_ACTIVIDADES;
    }
        
    /**
     * Metodo lista actividades, jpiro
     * @return
     */    
    @RequestMapping(value="/loadActividad",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> loadActividad(ActividadFilter filtro){
        LOG.info("procesando loadActividad");
        LOG.info("idProcedimiento="+filtro.getIdProcedimiento());
        LOG.info("idTramite="+filtro.getIdTramite());
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            //ActividadFilter filtro=new ActividadFilter();
            int[] auxiliar=new int[1];
            auxiliar[0]=0;
            List<ActividadDTO> listado;
            listado=actividadServiceNeg.listarActividad(filtro,auxiliar);
            retorno.put("filas", listado);
            retorno.put("total", auxiliar[0]);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    /**
     * Metodo lista actividades configuradas
     * @return
     */    
    @RequestMapping(value="/loadActividadConfigurada",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> loadActividadConfigurada(HttpSession session,HttpServletRequest request){
        LOG.info("procesando loadActividad");

        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
        	ActividadFilter filtro = new ActividadFilter();
        	String actividades = (String) request.getSession().getAttribute(Constantes.ACTIVIDADES_ORGANICA_DIVISION_CONCATENADA);
        	filtro.setIdsActividades(actividades);
            List<ProcesoObligacionTipoDTO> listado;
//            listado=actividadServiceNeg.listarActividadConfigurada();
            listado=actividadServiceNeg.listarActividadConfigurada(filtro);
            retorno.put("filas", listado);                                   

        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }  
	
	/* OSINE_SFS-600 - REQF-0009 - Inicio */
    @RequestMapping(value="/listarActividad",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> listarActividad(ActividadFilter filtro){
        LOG.info("procesando listarActividad");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ActividadDTO> listado;
            listado=actividadServiceNeg.findActividadByFilter(filtro);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    /* OSINE_SFS-600 - REQF-0009 - Fin */
    
}
