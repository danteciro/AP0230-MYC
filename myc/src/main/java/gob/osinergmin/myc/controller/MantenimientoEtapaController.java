/*
* Resumen
* Objeto            : MantenimientoEtapaController.java
* Descripción       : Controla el flujo de datos del objeto MantenimientoEtapa
* Fecha de Creación : 06/10/2016
* PR de Creación    : 
* Autor             : GMD
* =====================================================================================================================================================================
* Modificaciones |
* Motivo         |  Fecha        |   Nombre                     |     Descripción
* =====================================================================================================================================================================
* OSINE_SFS-1232 | 23/08/2016    |   Victor  Rojas              |     PANTALLA: CONFIGURACION ETAPAS Y SUBETAPAS
* OSINE_SFS-1232 | 07/11/2016    |   Luis García Reyna          |     Busqueda por filtros
*/

package gob.osinergmin.myc.controller;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import gob.osinergmin.myc.domain.NpsEtapa;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.CnfActUniOrganicaDTO;
import gob.osinergmin.myc.domain.dto.ConfTramiteDTO;
import gob.osinergmin.myc.domain.dto.ConfigEtapaDTO;
import gob.osinergmin.myc.domain.dto.EtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.EtapaTramiteDTO;
import gob.osinergmin.myc.domain.dto.EtapaTramiteNpsDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.dto.SubEtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.TramiteNpsDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.CnfActUniOrganicaFilter;
import gob.osinergmin.myc.domain.ui.ConfTramiteFilter;
import gob.osinergmin.myc.domain.ui.EtapaNpsFilter;
import gob.osinergmin.myc.domain.ui.EtapaTramiteBusquedaFilter;
import gob.osinergmin.myc.domain.ui.EtapaTramiteFilter;
import gob.osinergmin.myc.domain.ui.ProcesoFilter;
import gob.osinergmin.myc.domain.ui.SubEtapaNpsFilter;
import gob.osinergmin.myc.domain.ui.TramiteNpsFilter;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.business.ActividadServiceNeg;
import gob.osinergmin.myc.service.business.CnfActUniOrganicaServiceNeg;
import gob.osinergmin.myc.service.business.EtapaNpsServiceNeg;
import gob.osinergmin.myc.service.business.EtapaTramiteNpsServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.ConfTramiteNpsServiceNeg;
import gob.osinergmin.myc.service.business.EtapaTramiteServiceNeg;
import gob.osinergmin.myc.service.business.ProcesoServiceNeg;
import gob.osinergmin.myc.service.business.SubEtapaNpsServiceNeg;
import gob.osinergmin.myc.service.business.TramiteNpsServiceNeg;
import gob.osinergmin.myc.service.business.UnidadOrganicaServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/mantenimientoEtapa")
public class MantenimientoEtapaController {

	private static final Logger LOG = LoggerFactory.getLogger(MantenimientoEtapaController.class);
    

	@Inject
	private UnidadOrganicaServiceNeg unidadOrganicaServiceNeg;
	
	@Inject
	private ActividadServiceNeg actividadServiceNeg;
	
	@Inject
	private MaestroColumnaServiceNeg maestroColumnaServiceNeg;

	@Inject
	private CnfActUniOrganicaServiceNeg cnfActUniOrganicaServiceNeg;
	
	@Inject
	private ConfTramiteNpsServiceNeg confTramiteServiceNeg;
	
	@Inject
	private EtapaNpsServiceNeg etapaNpsServiceNeg;
	
	@Inject
	private SubEtapaNpsServiceNeg subEtapaNpsServiceNeg;
	
	@Inject
	private ProcesoServiceNeg procesoServiceNeg;
	
	@Inject
	private EtapaTramiteNpsServiceNeg etapaTramiteNpsServiceNeg;
        
        /* OSINE_SFS-1232 - lgarciar - Inicio */
        @Inject
	private EtapaTramiteServiceNeg etapaTramiteServiceNeg;  
        /* OSINE_SFS-1232 - lgarciar - Fin */
	
	@Inject
	private TramiteNpsServiceNeg tramiteNpsServiceNeg;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String abrirMantenimiento(Model model, HttpSession session, HttpServletRequest request){
		try {
			UnidadOrganicaFilter filtro = new UnidadOrganicaFilter();
			List<UnidadOrganicaDTO> listaGerencia = unidadOrganicaServiceNeg.findUnidadOrganicaGerencia(filtro);
			model.addAttribute("listaGerencia", listaGerencia);
			
			List<MaestroColumnaDTO> listaResponsable =  new ArrayList<MaestroColumnaDTO>();
			listaResponsable = maestroColumnaServiceNeg.buscarByDominioByAplicacion(Constantes.RESPONSABLE_DOMINIO,Constantes.APPLICACION_MYC);
			System.out.println("lista respos size = " + listaResponsable.size());
			model.addAttribute("listaResponsable", listaResponsable);
		
			List<TramiteNpsDTO> listaTramite = new ArrayList<TramiteNpsDTO>();
			TramiteNpsFilter tramiteNpsFilter = new TramiteNpsFilter();
			listaTramite = tramiteNpsServiceNeg.listar(tramiteNpsFilter);
			model.addAttribute("listaTramite", listaTramite);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ConstantesWeb.Navegacion.PAGE_GENERAL_MANTENIMIENTO_ETAPAS;
	}
	
	
	@RequestMapping(value="/abrirNuevaConfiguracion", method=RequestMethod.POST)
	public String abrirNuevaConfiguracion(Model model, HttpSession session, HttpServletRequest request) throws Exception{
		UnidadOrganicaFilter filtro = new UnidadOrganicaFilter();
		List<UnidadOrganicaDTO> listaGerencia = unidadOrganicaServiceNeg.findUnidadOrganicaGerencia(filtro);
		model.addAttribute("listaGerencia", listaGerencia);
		
		List<MaestroColumnaDTO> listaResponsable =  new ArrayList<MaestroColumnaDTO>();
		listaResponsable = maestroColumnaServiceNeg.buscarByDominioByAplicacion(Constantes.RESPONSABLE_DOMINIO, Constantes.APPLICACION_MYC);
		model.addAttribute("listaResponsable", listaResponsable);
		
		List<TramiteNpsDTO> listaTramite = new ArrayList<TramiteNpsDTO>();
		TramiteNpsFilter tramiteNpsFilter = new TramiteNpsFilter();
		listaTramite = tramiteNpsServiceNeg.listar(tramiteNpsFilter);
		model.addAttribute("listaTramite", listaTramite);
		
		return ConstantesWeb.Navegacion.PAGE_GENERAL_NUEVA_CONFIGURACION_ETAPA;
	}
	
	
	@RequestMapping(value="/abrirModificarConfiguracion", method=RequestMethod.POST)
	public String abrirModificarConfiguracion(Long idConfTramite ,  Model model, HttpSession session, HttpServletRequest request) throws Exception{
		UnidadOrganicaFilter filtro = new UnidadOrganicaFilter();
		List<UnidadOrganicaDTO> listaGerencia = unidadOrganicaServiceNeg.findUnidadOrganicaGerencia(filtro);
		model.addAttribute("listaGerencia", listaGerencia);
		
		List<MaestroColumnaDTO> listaResponsable =  new ArrayList<MaestroColumnaDTO>();
		listaResponsable = maestroColumnaServiceNeg.buscarByDominioByAplicacion(Constantes.RESPONSABLE_DOMINIO, Constantes.APPLICACION_MYC);
		model.addAttribute("listaResponsable", listaResponsable);
		
		List<TramiteNpsDTO> listaTramite = new ArrayList<TramiteNpsDTO>();
		TramiteNpsFilter tramiteNpsFilter = new TramiteNpsFilter();
		listaTramite = tramiteNpsServiceNeg.listar(tramiteNpsFilter);
		model.addAttribute("listaTramite", listaTramite);
		
		ConfTramiteDTO confTramiteDTO =  confTramiteServiceNeg.findById(idConfTramite);
		model.addAttribute("confTramite", confTramiteDTO);
	
		CnfActUniOrganicaFilter cnfActUniOrganicaFilter = new CnfActUniOrganicaFilter();
		cnfActUniOrganicaFilter.setIdCnfActUniOrganicaFilter(confTramiteDTO.getIdCnfActUniOrganica().getIdCnfActUniOrganica());
		List<ActividadDTO> listaActividadDTO = actividadServiceNeg.findActividadByIdCnfActUniOrganicaDTO(cnfActUniOrganicaFilter);
		ActividadDTO actividadDTO;
		Long idActividadPadre  = 0L;
		if(listaActividadDTO!=null && listaActividadDTO.size()>0){
			actividadDTO = listaActividadDTO.get(0);
			idActividadPadre = actividadDTO.getIdActividadPadre();
		}
		if(idActividadPadre!=null){
			ActividadFilter actividadFilter = new ActividadFilter();
			actividadFilter.setIdActividad(idActividadPadre);
			actividadFilter.setEstado(Constantes.ESTADO_ACTIVO);
			actividadDTO =  actividadServiceNeg.findActividadByFilter(actividadFilter).get(0);
			if( actividadDTO !=null){
				String actividadPadre = actividadDTO.getNombre();
				model.addAttribute("actividadPadre", actividadPadre);
			}
		}
		List<UnidadOrganicaDTO> listaUnidadOrganicaDTOs = unidadOrganicaServiceNeg.findUnidadUnidadOrganicaByIdCnfActUniOrganicaDTO(cnfActUniOrganicaFilter);
		UnidadOrganicaDTO unidadOrganicaDTO;
		Long idUnidadPadre = 0L;
		
		if(listaUnidadOrganicaDTOs!=null && listaUnidadOrganicaDTOs.size()>0){
			unidadOrganicaDTO =  listaUnidadOrganicaDTOs.get(0);
			idUnidadPadre = unidadOrganicaDTO.getIdUnidadOrganicaSuperior();
		}
		if(idActividadPadre!=null){
			UnidadOrganicaFilter unidadOrganicaFilter = new UnidadOrganicaFilter();
			unidadOrganicaFilter.setIdUnidadOrganica(idUnidadPadre);
			unidadOrganicaDTO = unidadOrganicaServiceNeg.findUnidadOrganica(unidadOrganicaFilter).get(0);
			if(unidadOrganicaDTO!=null){
				String unidadPadre = unidadOrganicaDTO.getDescripcion();
				model.addAttribute("unidadPadre", unidadPadre);
				MaestroColumnaDTO maestroColumnaDTO = maestroColumnaServiceNeg.buscarByDominioByAplicacion(Constantes.SECTOR_DOMINIO,Constantes.APPLICACION_MYC).get(0);
				model.addAttribute("sector", maestroColumnaDTO.getDescripcion());
			}
		}
		return ConstantesWeb.Navegacion.PAGE_GENERAL_MODIFICAR_CONFIGURACION_ETAPA;
	}
	
	
	@RequestMapping(value="/abrirNuevaEtapa", method=RequestMethod.POST)
	public String abrirNuevaEtapa(Model model, HttpSession session, HttpServletRequest request) throws Exception{
		try {
			UnidadOrganicaFilter filtro = new UnidadOrganicaFilter();
			List<UnidadOrganicaDTO> listaGerencia = unidadOrganicaServiceNeg.findUnidadOrganicaGerencia(filtro);
			model.addAttribute("listaGerencia", listaGerencia);
			
			List<MaestroColumnaDTO> listaResponsable =  new ArrayList<MaestroColumnaDTO>();
			listaResponsable = maestroColumnaServiceNeg.buscarByDominioByAplicacion(Constantes.RESPONSABLE_DOMINIO, Constantes.APPLICACION_MYC);
			
			model.addAttribute("listaResponsable", listaResponsable);
			
			List<ProcesoDTO> listaProceso = new ArrayList<ProcesoDTO>();
			listaProceso = procesoServiceNeg.listarProceso();
			model.addAttribute("procesoEtapa", "PRE-OPERATIVA");
			model.addAttribute("listaProcesoEtapa", listaProceso);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		
		return ConstantesWeb.Navegacion.PAGE_GENERAL_NUEVA_ETAPA;
	}
	
	@RequestMapping(value="/abrirNuevaSubEtapaEtapaTramite", method=RequestMethod.POST)
	public String abrirNuevaSubEtapaEtapaTramite(Model model, HttpSession session, HttpServletRequest request) throws Exception{
		EtapaNpsFilter etapaNpsFilter = new EtapaNpsFilter();
		try {
			List<EtapaNpsDTO> listaEtapa = etapaNpsServiceNeg.listarByConfTramite(etapaNpsFilter);
			model.addAttribute("listaEtapa", listaEtapa);
			
			List<MaestroColumnaDTO> listaResponsable =  new ArrayList<MaestroColumnaDTO>();
			listaResponsable = maestroColumnaServiceNeg.buscarByDominioByAplicacion(Constantes.RESPONSABLE_DOMINIO, Constantes.APPLICACION_MYC);
			model.addAttribute("listaResponsable", listaResponsable);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return ConstantesWeb.Navegacion.PAGE_GENERAL_NUEVA_SUBETAPA_ETAPATRAMITE;
	}
	
	@RequestMapping(value="/abrirModificarSubEtapa", method=RequestMethod.POST)
	public String abrirModificarSubEtapa(Model model, Long idEtapaMod , HttpSession session, HttpServletRequest request) throws Exception{
		EtapaNpsFilter etapaNpsFilter = new EtapaNpsFilter();
		try {
			List<MaestroColumnaDTO> listaResponsable =  new ArrayList<MaestroColumnaDTO>();
			listaResponsable = maestroColumnaServiceNeg.buscarByDominioByAplicacion(Constantes.RESPONSABLE_DOMINIO, Constantes.APPLICACION_MYC);
			model.addAttribute("listaResponsable", listaResponsable);
			model.addAttribute("idEtapa", idEtapaMod);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		return ConstantesWeb.Navegacion.PAGE_GENERAL_NUEVA_SUBETAPA;
		
	}
	
	
	@RequestMapping(value="/listarDivisiones", method=RequestMethod.POST)
	public @ResponseBody  Map<String, Object> listarDivisiones(UnidadOrganicaFilter filtro, HttpSession session, HttpServletRequest request){
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			List<UnidadOrganicaDTO> listaDivisiones =  new ArrayList<UnidadOrganicaDTO>();
			listaDivisiones = unidadOrganicaServiceNeg.findUnidadesNivelTresJoinEtapaConfiguracion(filtro);
			retorno.put("listaDivisiones", listaDivisiones);
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return retorno;
	}
	
	
	@RequestMapping(value="/listarActividades", method=RequestMethod.POST)
	public @ResponseBody  Map<String, Object> listarActividades(UnidadOrganicaFilter unidadOrganicaFilter, ActividadFilter actividadFilter , HttpSession session, HttpServletRequest request){
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			List<ActividadDTO> listarActividades =  new ArrayList<ActividadDTO>();
			listarActividades = actividadServiceNeg.findActividadesPadre(actividadFilter, unidadOrganicaFilter);
			retorno.put("listaActividades", listarActividades);
			
		} catch (Exception e) {
			LOG.error("Error en MantenimientoEtapaController listarActividades: "+e.getMessage());
            e.printStackTrace();
		}
		return retorno;
	}
	
	@RequestMapping(value="/listarAgentes", method=RequestMethod.POST)
	public @ResponseBody  Map<String, Object> listarAgente(ActividadFilter actividadFilter , HttpSession session, HttpServletRequest request){
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			List<ActividadDTO> listaAgentes =  new ArrayList<ActividadDTO>();
			listaAgentes = actividadServiceNeg.findActividadesHijasJoinEtapaConfiguracion(actividadFilter);
			retorno.put("listaAgentes", listaAgentes);
			
		} catch (Exception e) {
			LOG.error("Error en MantenimientoEtapaController listarAgente: "+e.getMessage());
            e.printStackTrace();
		}
		return retorno;
	}
	
	@RequestMapping(value="/listarSectores", method=RequestMethod.POST)
	public @ResponseBody  Map<String, Object> listarSector(UnidadOrganicaFilter unidadOrganicaFilter, ActividadFilter actividadFilter , HttpSession session, HttpServletRequest request){
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			List<MaestroColumnaDTO> listaSectores =  new ArrayList<MaestroColumnaDTO>();
			UnidadOrganicaDTO unidadOrganicaDTO = unidadOrganicaServiceNeg.findUnidadOrganica(unidadOrganicaFilter).get(0);
			String codigo = unidadOrganicaDTO.getCodDepSiga().toUpperCase();
			listaSectores = maestroColumnaServiceNeg.buscarByDominioByAplicacionByCodigo(Constantes.SECTOR_DOMINIO, Constantes.APPLICACION_MYC, codigo);
			retorno.put("listaSectores", listaSectores);
			
		} catch (Exception e) {
			LOG.error("Error en MantenimientoEtapaController listarSector: "+e.getMessage());
            e.printStackTrace();
		}
		return retorno;
	}
	
	
	@RequestMapping(value="/registrarConfiguracionEtapa", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarConfiguracionTramite(ConfigEtapaDTO configEtapaDTO, HttpSession session,HttpServletRequest request){
        LOG.info("procesando registrarConfiguracionSiguo");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            UnidadOrganicaFilter unidadOrganicaFilter = new UnidadOrganicaFilter();
            	unidadOrganicaFilter.setIdUnidadOrganica(configEtapaDTO.getIdUnidadOrganica());
            ActividadFilter actividadFilter = new ActividadFilter();
            	actividadFilter.setIdActividad(configEtapaDTO.getIdActividad());           
            		
            List<CnfActUniOrganicaDTO> cnfActUniOrganicaDTO = cnfActUniOrganicaServiceNeg.findByActividadAndUnidadOrganica(unidadOrganicaFilter, actividadFilter); 
            if(cnfActUniOrganicaDTO!=null && cnfActUniOrganicaDTO.size()>0){
            	TramiteNpsDTO tramiteNpsDTO = new TramiteNpsDTO();
                tramiteNpsDTO.setIdTramite(configEtapaDTO.getIdTramite());
                
                ConfTramiteDTO confTramiteDTO = new ConfTramiteDTO();
                confTramiteDTO.setIdCnfActUniOrganica(cnfActUniOrganicaDTO.get(0));
                confTramiteDTO.setIdTramite(tramiteNpsDTO);
                confTramiteDTO.setOrientacion(configEtapaDTO.getInformeOrientacion());
                confTramiteDTO.setEstado(Constantes.ESTADO_ACTIVO);
                confTramiteDTO.setPorcentajeNotificacion(configEtapaDTO.getNotificacion());
                
                ConfTramiteDTO validaConfiguracion = confTramiteServiceNeg.validaConfiguracion(confTramiteDTO);
                if(validaConfiguracion==null){
                	confTramiteServiceNeg.create(confTramiteDTO, usuarioDTO);
                    
                    retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
                    retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
                }else{
                	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ADVERTENCIA);           
                    retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_FAIL_EXISTS);
                }
            }else{
            	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ADVERTENCIA);           
                retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_FAIL_EXISTS_CONF);
            }           
            
            
            
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en MantenimientoEtapaController ConfiguracionEtapa: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
	
	
	@RequestMapping(value="/registrarNuevaEtapa", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarNuevaEtapa(EtapaNpsDTO etapaNpsDTO ,HttpSession session,HttpServletRequest request){
        LOG.info("procesando registrarConfiguracionSiguo");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
//            ProcesoFilter  procesoFilter = new ProcesoFilter();
//            procesoFilter.setIdentificadorProceso(Constantes.PROCESO_PRE_OPERATIVO);
//            List<ProcesoDTO> listaProceso = procesoServiceNeg.listarProcesoByIdentificador(procesoFilter);
//            if(listaProceso!=null && listaProceso.size()>0){
//              ProcesoDTO procesoDTO = new ProcesoDTO();
//              procesoDTO.setIdProceso(listaProceso.get(0).getIdProceso());
//              etapaNpsDTO.setIdProceso(procesoDTO);
//            }
            List<EtapaNpsDTO> validaEtapa = etapaNpsServiceNeg.validaEtapa(etapaNpsDTO);
            if(validaEtapa!=null && validaEtapa.size()>0){
            	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ADVERTENCIA);           
                retorno.put(ConstantesWeb.VV_MENSAJE, "No se puede crear Etapa: Etapa existente.");
            }else{
            	etapaNpsServiceNeg.create(etapaNpsDTO, usuarioDTO);            
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
                retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
            }
            
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarConfiguracionSiguo: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
	
	
	@RequestMapping(value="/abrirMantenimientoEtapaTramite", method=RequestMethod.POST)
	public String  abrirMantenimientoEtapaTramite(String accion,Long idEtapaTramite, Long idEtapa, Model model ){
		System.out.println("idEtapaTramite = "+ idEtapaTramite);
		try {
			EtapaTramiteNpsDTO etapaTramiteNpsDTO = etapaTramiteNpsServiceNeg.findByIdEtapaTramite(idEtapaTramite);
			Long idEtapaVal = etapaTramiteNpsDTO.getIdEtapa().getIdEtapa();
			model.addAttribute("etapaTramite", etapaTramiteNpsDTO);
			model.addAttribute("idEtapa",idEtapa);
			
			
			List<ProcesoDTO> listaProceso = new ArrayList<ProcesoDTO>();
			listaProceso = procesoServiceNeg.listarProceso();
			model.addAttribute("proceso", "PRE-OPERATIVA");
			model.addAttribute("listaProceso", listaProceso);
			
			
			model.addAttribute("idEtapaVal", idEtapaVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ConstantesWeb.Navegacion.PAGE_GENERAL_MODIFICAR_ETAPA_TRAMITE;
	}
	
	@RequestMapping(value="/abrirMantenimientoSubEtapaTramite", method=RequestMethod.POST)
	public String  abrirMantenimientoSubEtapaTramite(String accion , SubEtapaNpsDTO subEtapaNpsDTO , Model model ){
		System.out.println("idEtapaTramite = "+ subEtapaNpsDTO.getDescripcion());
		try {
			model.addAttribute("subEtapa", subEtapaNpsDTO);
			EtapaNpsFilter etapaNpsFilter = new EtapaNpsFilter();
			List<EtapaNpsDTO> listaEtapa = etapaNpsServiceNeg.listarByConfTramite(etapaNpsFilter);
			model.addAttribute("listaEtapa", listaEtapa);
			
			List<MaestroColumnaDTO> listaResponsable =  new ArrayList<MaestroColumnaDTO>();
			listaResponsable = maestroColumnaServiceNeg.buscarByDominioByAplicacion(Constantes.RESPONSABLE_DOMINIO, Constantes.APPLICACION_MYC);
			model.addAttribute("listaResponsable", listaResponsable);
			model.addAttribute("responsable", subEtapaNpsDTO.getIdResponsable().getIdMaestroColumna());
			model.addAttribute("etapa", subEtapaNpsDTO.getIdEtapa().getIdEtapa());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ConstantesWeb.Navegacion.PAGE_SUBETAPAS_MODIFICAR_SUBETAPA_TRAMITE;
	}
	
	
	@RequestMapping(value="/registrarEtapaTramitexx", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registraEtapaTramite(Long idConfTramite , Long idEtapa,HttpSession session,HttpServletRequest request){
        LOG.info("procesando registrarConfiguracionSiguo");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            EtapaTramiteNpsDTO etapaTramiteNpsDTO = new EtapaTramiteNpsDTO();
            	ConfTramiteDTO confTramiteDTO = new ConfTramiteDTO();
            	confTramiteDTO.setIdConfTramite(idConfTramite);
            etapaTramiteNpsDTO.setIdConfTramite(confTramiteDTO);
            	EtapaNpsDTO etapaNpsDTO = new EtapaNpsDTO();
            	etapaNpsDTO.setIdEtapa(idEtapa);
            etapaTramiteNpsDTO.setIdEtapa(etapaNpsDTO);
            etapaTramiteNpsServiceNeg.create(etapaTramiteNpsDTO, usuarioDTO);
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarConfiguracionSiguo: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
	
	//VERSION 2
	@RequestMapping(value="/registraEtapaTramiteDos", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registraEtapaTramiteDos(@RequestParam(value="etapasArray[]") Long[] etapasArray, Long idConfTramite , Long idEtapa,HttpSession session,HttpServletRequest request){
        LOG.info("procesando registrarConfiguracionSiguo");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{    	
        	
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            EtapaTramiteNpsDTO etapaTramiteNpsDTO = new EtapaTramiteNpsDTO();
            	ConfTramiteDTO confTramiteDTO = new ConfTramiteDTO();
            	confTramiteDTO.setIdConfTramite(idConfTramite);
            	etapaTramiteNpsDTO.setIdConfTramite(confTramiteDTO);
            for (int i = 0; i < etapasArray.length; i++) {
            	EtapaNpsDTO etapaNpsDTO = new EtapaNpsDTO();
            	if(etapasArray[i]!=-1){
            		etapaNpsDTO.setIdEtapa(etapasArray[i]);
                	etapaTramiteNpsDTO.setIdEtapa(etapaNpsDTO);
                	etapaTramiteNpsServiceNeg.create(etapaTramiteNpsDTO, usuarioDTO);
            	}          	
            }            
            
            
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarConfiguracionSiguo: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
	
	
	
	@RequestMapping(value="/registrarNuevaSubEtapa", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarNuevaSubEtapa(SubEtapaNpsDTO subEtapaNpsDTO, Long etapaId ,HttpSession session,HttpServletRequest request){
        LOG.info("procesando registrarNuevaSubEtapa");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            EtapaNpsDTO etapaNpsDTO = new EtapaNpsDTO();
            	etapaNpsDTO.setIdEtapa(etapaId);
            subEtapaNpsDTO.setIdEtapa(etapaNpsDTO);
            subEtapaNpsServiceNeg.create(subEtapaNpsDTO, usuarioDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarNuevaSubEtapa: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
	
	@RequestMapping(value="/obtenerDatosEtapa", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> obtenerDatosEtapa(Long etapaId ,HttpSession session,HttpServletRequest request){
        LOG.info("procesando registrarNuevaSubEtapa");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
        	String idEtapa = etapaId.toString();
        	EtapaNpsDTO etapa = etapaNpsServiceNeg.findByIdEtapa(etapaId);
        	List<SubEtapaNpsDTO> subEtapas = subEtapaNpsServiceNeg.listarSubEtapas(idEtapa);
        	Long plazo=etapa.getPlazo();
        	Long disponible = etapa.getPlazo();
        	if(subEtapas!=null && subEtapas.size()>0){
        		for(SubEtapaNpsDTO sub:subEtapas){
            		disponible = disponible-sub.getTiempoDias();
            	}
        	}
        	
        	retorno.put("plazo", plazo);
        	retorno.put("disponible", disponible);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarNuevaSubEtapa: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
	
	
	@RequestMapping(value="/listarEtapa", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> listarEtapa(Long idConfTramite,HttpSession session,HttpServletRequest request,int rows, int page){
		Map<String, Object> retorno = new HashMap<String, Object>();
		 List<EtapaNpsDTO> listaEtapas = new ArrayList<EtapaNpsDTO>();
		 List<EtapaNpsDTO> listaEtapasConfiguradas = null;
		 
		try {
			 EtapaNpsFilter etapaNpsFilter = new EtapaNpsFilter();
			 if(idConfTramite!=null){
				 //Trae las etapas que estan asignadas a la configuración
				  listaEtapasConfiguradas = this.etapaNpsServiceNeg.listarEtapasConfiguradas(idConfTramite);
				  if(listaEtapasConfiguradas!=null && listaEtapasConfiguradas.size()>0){
					  		String var = "";
					  		String cadenaEtapas = "";
					  		for (EtapaNpsDTO etapaNpsDTO : listaEtapasConfiguradas) {
					  			cadenaEtapas =String.valueOf(etapaNpsDTO.getIdEtapa());
					  			var = var+","+cadenaEtapas;
							}
					  		var = var.substring(1,var.length());
					  		//trae idEtapas que no estan configuradas
					  		listaEtapas = this.etapaNpsServiceNeg.listarEtapasIds(var);
				  }else{
						 listaEtapas = this.etapaNpsServiceNeg.listarEtapas(etapaNpsFilter);
				  }
				  
			 }else{
				 
				 listaEtapas = this.etapaNpsServiceNeg.listarEtapas(etapaNpsFilter);			 
				 
			 }
			 //fin
			 int indiceInicial = -1;
			 int indiceFinal = -1;
			 Long contador = (long)listaEtapas.size();
			 Long numeroFilas = (contador / rows);
			 if ((contador % rows) > 0) {numeroFilas = numeroFilas + 1L;}
			 if(numeroFilas<page){page = numeroFilas.intValue();}
		     if(page == 0){rows = 0;}
		     indiceInicial = (page - 1) * rows;
		     indiceFinal = indiceInicial + rows;
		     List<EtapaNpsDTO> listaPaginada = listaEtapas.subList(indiceInicial > listaEtapas.size() ? listaEtapas.size() : indiceInicial, indiceFinal > listaEtapas.size() ? listaEtapas.size() : indiceFinal);
		   
		     retorno.put("filas", listaPaginada);
		     retorno.put("pagina",page);
		     retorno.put("registros",contador);
		     retorno.put("total", numeroFilas);	
		     
		} catch (Exception e) {
			LOG.error("Error en listarEtapa: "+e.getMessage());
            e.printStackTrace();
		}
		return retorno;
	}

/* OSINE_SFS-1232 - RSIS 6 - Inicio */
	@RequestMapping(value="/listarSubEtapa", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> listarSubEtapa(Long idEtapa, HttpSession session,HttpServletRequest request, int rows, int page){
		Map<String, Object> retorno = new HashMap<String, Object>();
		System.out.println("idEtapa = "+ idEtapa);
		try {
			 SubEtapaNpsFilter subEtapaNpsFilter = new SubEtapaNpsFilter();
			 NpsEtapa npsEtapa = new NpsEtapa();
			 if( idEtapa!=null && idEtapa>0){
				npsEtapa.setIdEtapa(idEtapa);
				subEtapaNpsFilter.setIdEtapa(npsEtapa);
			 }
			 List<SubEtapaNpsDTO> listaSubEtapas = this.subEtapaNpsServiceNeg.listar(subEtapaNpsFilter);
			 
			 int indiceInicial = -1;
			 int indiceFinal = -1;
			 Long contador = (long)listaSubEtapas.size();
			 Long numeroFilas = (contador / rows);
			 if ((contador % rows) > 0) {numeroFilas = numeroFilas + 1L;}
			 if(numeroFilas<page){page = numeroFilas.intValue();}
		     if(page == 0){rows = 0;}
		     indiceInicial = (page - 1) * rows;
		     indiceFinal = indiceInicial + rows;
		     List<SubEtapaNpsDTO> listaPaginada = listaSubEtapas.subList(indiceInicial > listaSubEtapas.size() ? listaSubEtapas.size() : indiceInicial, indiceFinal > listaSubEtapas.size() ? listaSubEtapas.size() : indiceFinal);
		   
		     retorno.put("filas", listaPaginada);
		     retorno.put("pagina",page);
		     retorno.put("registros",contador);
		     retorno.put("total", numeroFilas);	
		} catch (Exception e) {
			LOG.error("Error en listarSubEtapa: "+e.getMessage());
            e.printStackTrace();
		}
		return retorno;
	}
	
	
	@RequestMapping(value="/listarSubEtapaEtapa", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> listarSubEtapaEtapa(Long idEtapa,Long idResponsable, HttpSession session,HttpServletRequest request, int rows, int page){
		Map<String, Object> retorno = new HashMap<String, Object>();
		System.out.println("idEtapa = "+ idEtapa);
		System.out.println("idResponsable = "+ idResponsable);
		
		boolean idEliminar =false;
		List<SubEtapaNpsDTO> listaSubEtapas = null;
		try {
			 SubEtapaNpsFilter subEtapaNpsFilter = new SubEtapaNpsFilter();
			 NpsEtapa npsEtapa = new NpsEtapa();
			 if(idEtapa!=null){
				 if(idEtapa>0){
					npsEtapa.setIdEtapa(idEtapa);
					subEtapaNpsFilter.setIdEtapa(npsEtapa);
				 }
			 }
			if(idEtapa!=null){
			     String var = "";
			     String valorIngresado=String.valueOf(idEtapa);
			     String cadenaEtapas=(String) request.getSession().getAttribute("cadenaEtapas");
			     if(cadenaEtapas=="" || cadenaEtapas==null || cadenaEtapas=="null"){
			    	 var=String.valueOf(idEtapa);
			    	 request.getSession().setAttribute("cadenaEtapas",var);
			     }else{		     
			    	 var=String.valueOf(idEtapa);
			    	 idEliminar =validarExistente(var, cadenaEtapas);
			    	 if(idEliminar==true){
			    		var = eliminarExistente(var, cadenaEtapas);
			    	 }else{
			    		 var =cadenaEtapas+","+var;
			    	 }
			     request.getSession().setAttribute("cadenaEtapas",var);
			     }
			     
				 listaSubEtapas = this.subEtapaNpsServiceNeg.listarSubEtapas(var);
			}else{
				listaSubEtapas=null;
				request.getSession().setAttribute("cadenaEtapas",null);
			}
			 
			 int indiceInicial = -1;
			 int indiceFinal = -1;
			 Long contador = (long)listaSubEtapas.size();
			 Long numeroFilas = (contador / rows);
			 if ((contador % rows) > 0) {numeroFilas = numeroFilas + 1L;}
			 if(numeroFilas<page){page = numeroFilas.intValue();}
		     if(page == 0){rows = 0;}
		     indiceInicial = (page - 1) * rows;
		     indiceFinal = indiceInicial + rows;
		     List<SubEtapaNpsDTO> listaPaginada = listaSubEtapas.subList(indiceInicial > listaSubEtapas.size() ? listaSubEtapas.size() : indiceInicial, indiceFinal > listaSubEtapas.size() ? listaSubEtapas.size() : indiceFinal);
		   
		     retorno.put("filas", listaPaginada);
		     retorno.put("pagina",page);
		     retorno.put("registros",contador);
		     retorno.put("total", numeroFilas);	
		} catch (Exception e) {
			LOG.error("Error en listarSubEtapa: "+e.getMessage());
            e.printStackTrace();
		}
		return retorno;
	}
	
	@RequestMapping(value="/listarSubEtapaCompleta", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> listarSubEtapaCompleta(@RequestParam(value="idEtapa[]") Long[] idEtapa,Long idResponsable, HttpSession session,HttpServletRequest request, int rows, int page){
		Map<String, Object> retorno = new HashMap<String, Object>();
		System.out.println("idEtapa = "+ idEtapa);
		List<SubEtapaNpsDTO> listaSubEtapas = null;
		try {			
			if(idEtapa!=null){
				String var="";
				Long count=new Long(0);
				for (int i = 0; i < idEtapa.length; i++) {
						if(idEtapa[i]!=null){
							count++;
							if(count==1){
								var= String.valueOf(idEtapa[i]);
							}else{
								var+= ","+String.valueOf(idEtapa[i]);
							}	
						}	
				}
				LOG.info("cadena::> "+var);
				listaSubEtapas = this.subEtapaNpsServiceNeg.listarSubEtapas(var);
			}else{
				listaSubEtapas=null;
			}
			 
			 int indiceInicial = -1;
			 int indiceFinal = -1;
			 Long contador = (long)listaSubEtapas.size();
			 Long numeroFilas = (contador / rows);
			 if ((contador % rows) > 0) {numeroFilas = numeroFilas + 1L;}
			 if(numeroFilas<page){page = numeroFilas.intValue();}
		     if(page == 0){rows = 0;}
		     indiceInicial = (page - 1) * rows;
		     indiceFinal = indiceInicial + rows;
		     List<SubEtapaNpsDTO> listaPaginada = listaSubEtapas.subList(indiceInicial > listaSubEtapas.size() ? listaSubEtapas.size() : indiceInicial, indiceFinal > listaSubEtapas.size() ? listaSubEtapas.size() : indiceFinal);
		   
		     retorno.put("filas", listaPaginada);
		     retorno.put("pagina",page);
		     retorno.put("registros",contador);
		     retorno.put("total", numeroFilas);	
		} catch (Exception e) {
			LOG.error("Error en listarSubEtapa: "+e.getMessage());
            e.printStackTrace();
		}
		return retorno;
	}
	
/* OSINE_SFS-1232 - RSIS 6 - Fin */	
	@RequestMapping(value="/abrirNuevaEtapaTramite", method=RequestMethod.POST)
	public String abrirEtapaTramite(Model model, HttpSession session, HttpServletRequest request) throws Exception{
		try {
			UnidadOrganicaFilter filtro = new UnidadOrganicaFilter();
			request.getSession().removeAttribute("cadenaEtapas");
			List<ProcesoDTO> listaProceso = new ArrayList<ProcesoDTO>();
			listaProceso = procesoServiceNeg.listarProceso();
			model.addAttribute("proceso", "PRE-OPERATIVA");
			model.addAttribute("listaProceso", listaProceso);
			
		} catch (Exception e) {
			LOG.error("Error en abrirEtapaTramite: "+e.getMessage());
            e.printStackTrace();
		}
	
		return ConstantesWeb.Navegacion.PAGE_GENERAL_NUEVA_ETAPA_TRAMITE;
		
	}
	
	
	@RequestMapping(value="/modificarConfiguracion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> modificarConfiguracion(Long idConfTramite, String orientacion, Short notificacion ,HttpSession session,HttpServletRequest request){
        LOG.info("procesando registrarConfiguracionSiguo");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
			usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
			  
        	ConfTramiteDTO  confTramiteDTO = confTramiteServiceNeg.findById(idConfTramite);
            confTramiteDTO.setOrientacion(orientacion);
            confTramiteDTO.setPorcentajeNotificacion(notificacion);
            confTramiteServiceNeg.update(confTramiteDTO, usuarioDTO);
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarConfiguracionSiguo: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
	
	
	
	@RequestMapping(value="/listarEtapaTramite", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> listarEtapaTramite(EtapaTramiteBusquedaFilter etapaTramiteBusquedaFilter, HttpSession session,HttpServletRequest request, int rows, int page){
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
		     EtapaNpsFilter etapaNpsFilter = new EtapaNpsFilter();
		     ConfTramiteFilter  confTramiteFilter = new ConfTramiteFilter();
			 List<EtapaTramiteNpsDTO> listaEtapaTramite = etapaTramiteNpsServiceNeg.buscarEtapaTramite(etapaTramiteBusquedaFilter);     
			 
			 System.out.println("size listaEtapaTramite " + listaEtapaTramite.size());
			 
		     int indiceInicial = -1;
			 int indiceFinal = -1;
			 Long contador = (long)listaEtapaTramite.size();
			 Long numeroFilas = (contador / rows);
			 if ((contador % rows) > 0) {numeroFilas = numeroFilas + 1L;}
			 if(numeroFilas<page){page = numeroFilas.intValue();}
		     if(page == 0){rows = 0;}
		     indiceInicial = (page - 1) * rows;
		     indiceFinal = indiceInicial + rows;
		     List<EtapaTramiteNpsDTO> listaPaginada = listaEtapaTramite.subList(indiceInicial > listaEtapaTramite.size() ? listaEtapaTramite.size() : indiceInicial, indiceFinal > listaEtapaTramite.size() ? listaEtapaTramite.size() : indiceFinal);
		   
		     retorno.put("filas", listaPaginada);
		     retorno.put("pagina",page);
		     retorno.put("registros",contador);
		     retorno.put("total", numeroFilas);	
		} catch (Exception e) {
			LOG.error("Error en listarEtapaTramite: "+e.getMessage());
            e.printStackTrace();
		}
		return retorno;
	}
    
    /* OSINE_SFS-1232 - lgarciar - Inicio */
    @RequestMapping(value = "/findEtapaTramite", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> findExpediente(EtapaTramiteFilter filtro, int rows, int page, HttpSession session, HttpServletRequest request) {
        LOG.info("findEtapaTramite");
                
        Map<String, Object> retorno = new HashMap<String, Object>();
        int indiceInicial = -1;
        int indiceFinal = -1;        
        try {
            List<EtapaTramiteDTO> listadoPaginado = null;
            List<EtapaTramiteDTO> listado = etapaTramiteServiceNeg.listarEtapaTramite(filtro);
            Long contador = (long) listado.size();
            Long numeroFilas = (contador / rows);

            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
            if (numeroFilas < page) {
                page = numeroFilas.intValue();
            }
            if (page == 0) {
                rows = 0;
            }
            indiceInicial = (page - 1) * rows;
            indiceFinal = indiceInicial + rows;
            listadoPaginado = listado.subList(indiceInicial > listado.size() ? listado.size() : indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal);
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listadoPaginado);

        } catch (Exception ex) {
            LOG.error("Error findEtapaTramite", ex);

        }
        return retorno;
    }
    /* OSINE_SFS-1232 - lgarciar - Fin */
    
	@RequestMapping(value="/listarConfTramite", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> listarConfTramite(HttpSession session,HttpServletRequest request, int rows, int page){
		/* OSINE_SFS-1232 - RSIS 4 - Inicio */	
		Map<String, Object> retorno = new HashMap<String, Object>();
		/* OSINE_SFS-1232 - RSIS 4 - Fin */	
		
		try {
		     ConfTramiteFilter confTramiteFilter = new ConfTramiteFilter();
			 List<ConfTramiteDTO> listaConfTramite = confTramiteServiceNeg.listar(confTramiteFilter);
			 int indiceInicial = -1;
			 int indiceFinal = -1;
			 Long contador = (long)listaConfTramite.size();
			 Long numeroFilas = (contador / rows);
			 if ((contador % rows) > 0) {numeroFilas = numeroFilas + 1L;}
			 if(numeroFilas<page){page = numeroFilas.intValue();}
		     if(page == 0){rows = 0;}
		     indiceInicial = (page - 1) * rows;
		     indiceFinal = indiceInicial + rows;
		     List<ConfTramiteDTO> listaPaginada = listaConfTramite.subList(indiceInicial > listaConfTramite.size() ? listaConfTramite.size() : indiceInicial, indiceFinal > listaConfTramite.size() ? listaConfTramite.size() : indiceFinal);
		   
		     retorno.put("filas", listaPaginada);
		     retorno.put("pagina",page);
		     retorno.put("registros",contador);
		     retorno.put("total", numeroFilas);	
		} catch (Exception e) {
			LOG.error("Error en listarConfTramite: "+e.getMessage());
            e.printStackTrace();
		}
		return retorno;
	}
	
	
	  @RequestMapping(value = "/listarEtapaTramitePadre", method = RequestMethod.POST)
	    public @ResponseBody
		Map<String, Object> listarEtapaTramitePadre(EtapaNpsFilter etapaNpsFilter, ConfTramiteFilter confTramiteFilter,Long varLista, int rows, int page, HttpSession session,HttpServletRequest request) {
			LOG.info("Funcion: listar de Bases Legales -- Controller -- Metodo-> listarBaseLegal");
	        Map<String, Object> listaResultado = new HashMap<String, Object>();
	        try{
	        	List<EtapaTramiteNpsDTO> listado;
	            int total=0 ;
	            Integer cuenta;
	            if(varLista==1){
		            int inicio;
		            inicio=rows*page-rows;
		            int[] auxiliar=new int[1];
		            auxiliar[0]=0;
		            listado = etapaTramiteNpsServiceNeg.listarEtapaTramite(new EtapaNpsFilter(), new ConfTramiteFilter()); 
		            LOG.info("Funcion: contador -- auxiliar: " + auxiliar);
		            cuenta=auxiliar[0];
		            if(cuenta>0){
		            	total=(int) Math.ceil((double) cuenta / (double) rows);
		            }
		            listaResultado.put("total", total);
		            listaResultado.put("pagina", page);
		            listaResultado.put("registros", cuenta);
		            listaResultado.put("filas", listado);
	            }
	        }catch(Exception e){
	        	LOG.error("Error en listarEtapaTramitePadre: "+e.getMessage());
	            e.printStackTrace();
	        }
	        
	        return listaResultado;
	    }

	  @RequestMapping(value="/eliminarEtapaTramite", method= RequestMethod.POST)
	  public @ResponseBody Map<String, Object> eliminarEtapaTramite( Long idEtapaTramite, HttpServletRequest request){
		  System.out.println("ingreso eliminar!");
		  Map<String, Object> retorno = new HashMap<String, Object>();
		  try {
        	  UsuarioDTO usuarioDTO = new UsuarioDTO();
              usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
			  usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
			  EtapaTramiteNpsDTO etapaTramiteNpsDTO = etapaTramiteNpsServiceNeg.findByIdEtapaTramite(idEtapaTramite);
			  etapaTramiteNpsServiceNeg.delete(etapaTramiteNpsDTO, usuarioDTO);			  
			  retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
	          retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
		  } catch (UnknownHostException e) {
			  retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	          retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	          LOG.error("Error en eliminarEtapaTramite: "+e.getMessage());
	          e.printStackTrace();
		  }
		  return retorno;
	  }
	  
	  @RequestMapping(value="/validaSubEtapaRepetida", method= RequestMethod.POST)
	  public @ResponseBody Map<String, Object> validaSubEtapaRepetida( Long idSubEtapa, HttpServletRequest request){
		  System.out.println("ingreso validaSubEtapaRepetida!");
		  System.out.println(" SubEtapa = " + idSubEtapa);
			 
		  Map<String, Object> retorno = new HashMap<String, Object>();
		  try {
        	  UsuarioDTO usuarioDTO = new UsuarioDTO();
              usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
			  usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
			  SubEtapaNpsFilter subEtapaNpsFilter = new SubEtapaNpsFilter();
			  subEtapaNpsFilter.setIdSubetapa(idSubEtapa);
			  SubEtapaNpsDTO subEtapaNpsDTO = subEtapaNpsServiceNeg.findSubEtapaNpsDTO(subEtapaNpsFilter);
			  
			  if(etapaTramiteNpsServiceNeg.validaEtapaTramiteBySubEtapa(subEtapaNpsDTO)){
				  retorno.put("repetido", "si");
			  }else{
				  retorno.put("repetido", "no");
			  }
			  
		  } catch (UnknownHostException e) {
			  retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	          retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	          LOG.error("Error en eliminarEtapaTramite: "+e.getMessage());
	          e.printStackTrace();
		  }
		  return retorno;
	  }
	  
	  
	  
	  @RequestMapping(value="/eliminarSubEtapa", method= RequestMethod.POST)
	  public @ResponseBody Map<String, Object> eliminarSubEtapa( Long idSubEtapa, HttpServletRequest request){
		  System.out.println("ingreso eliminar!");
		  System.out.println(" SubEtapa = " + idSubEtapa);
			 
		  Map<String, Object> retorno = new HashMap<String, Object>();
		  try {
        	  UsuarioDTO usuarioDTO = new UsuarioDTO();
              usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
			  usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
			   SubEtapaNpsFilter subEtapaNpsFilter = new SubEtapaNpsFilter();
			   subEtapaNpsFilter.setIdSubetapa(idSubEtapa);
			   SubEtapaNpsDTO subEtapaNpsDTO = subEtapaNpsServiceNeg.findSubEtapaNpsDTO(subEtapaNpsFilter);
				  subEtapaNpsServiceNeg.delete(subEtapaNpsDTO, usuarioDTO);
				  retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
		          retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_DELETE);
		  } catch (UnknownHostException e) {
			  retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	          retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	          LOG.error("Error en eliminarEtapaTramite: "+e.getMessage());
	          e.printStackTrace();
		  }
		  return retorno;
	  }
	  
	  
	  @RequestMapping(value="/actualizarSubEtapa", method= RequestMethod.POST)
	  public @ResponseBody Map<String,Object> actualizarSubEtapa(SubEtapaNpsDTO subEtapaNpsDTO,HttpSession session,HttpServletRequest request){
	        LOG.info("procesando registrarConfiguracionSiguo");
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        try{
	        	UsuarioDTO usuarioDTO = new UsuarioDTO();
	            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            subEtapaNpsServiceNeg.update(subEtapaNpsDTO, usuarioDTO);
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
	            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
	        }catch(Exception e){            
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error en actualizarSubEtapa: "+e.getMessage());
	            e.printStackTrace();
	        }        
	        return retorno;
	    }
	
	  @RequestMapping(value="/actualizarEtapaModificarEtapaTramite", method= RequestMethod.POST)
	  public @ResponseBody Map<String,Object> actualizarEtapaModificarEtapaTramite(Long idEtapaEdit, String nombreEtapa, Long plazo , HttpSession session,HttpServletRequest request){
	        LOG.info("procesando registrarConfiguracionSiguo");
	        Map<String,Object> retorno = new HashMap<String,Object>();
	        try{
	        	UsuarioDTO usuarioDTO = new UsuarioDTO();
	            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
	            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	            EtapaNpsDTO etapaNpsDTO = etapaNpsServiceNeg.findByIdEtapa(idEtapaEdit);
	            /**/
	        	List<SubEtapaNpsDTO> subEtapas = subEtapaNpsServiceNeg.listarSubEtapas(etapaNpsDTO.getIdEtapa().toString());
	        	Long disponible = etapaNpsDTO.getPlazo();
	        	Long plazoMinimo = new Long(0);
	        	if(subEtapas!=null && subEtapas.size()>0){
	        		for(SubEtapaNpsDTO sub:subEtapas){
	            		disponible = disponible-sub.getTiempoDias();
	            		plazoMinimo += sub.getTiempoDias();
	            	}
	        	}
	        	/**/
	        	if(plazo>=plazoMinimo){
	        		etapaNpsDTO.setDescripcion(nombreEtapa);//nombre actual
		            etapaNpsDTO.setPlazo(plazo);//plazo actual
		            etapaNpsServiceNeg.update(etapaNpsDTO, usuarioDTO);
		            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
		            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE);
	        	}else{
	        		retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ADVERTENCIA);           
		            retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_FAILED_CREATE_ETAPA + " " +plazoMinimo);
	        	}
	            
	            
	            
	        }catch(Exception e){            
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
	            LOG.error("Error en actualizarSubEtapa: "+e.getMessage());
	            e.printStackTrace();
	        }        
	        return retorno;
	    }
	  
	  /* OSINE_SFS-1232 - RSIS 6 - Inicio */
	  public boolean validarExistente(String idEtapa, String cadenaEtapas){
		  boolean var = false;
	         StringBuilder sb = null;
	         String valorFormateado = cadenaEtapas.trim().isEmpty()?null:cadenaEtapas;
	         String []arrEtapas = valorFormateado!=null?cadenaEtapas.split(","):null;
	         if(arrEtapas!=null){
	             sb = new StringBuilder();
	             for (String etapa : arrEtapas) {
	            	 if(etapa.equals(idEtapa)){
	            		 var = true;
	                 }

	             }
	         }
	        return var;
	  }
	  public String eliminarExistente(String idEtapaEliminar, String cadenaEtapas){
		  String var ="";
	         StringBuilder sb = null;
	         String valorFormateado = cadenaEtapas.trim().isEmpty()?null:cadenaEtapas;
	         if(idEtapaEliminar.equals(cadenaEtapas)){
	        	 var="";
	         }else{
			         String []arrEtapas = valorFormateado!=null?cadenaEtapas.split(","):null;
			         if(arrEtapas!=null){
			             sb = new StringBuilder();
			             for (String etapa : arrEtapas) {
			            	 if(etapa.equals(idEtapaEliminar)){
			            		 System.out.println("No se considera idEtapa");
			            		 
			            	 }else{
			            		 sb.append(etapa);
			                     sb.append(",");
			                 }
		
			             }
			             var = sb.substring(0,sb.length()-1);
			         }
	         }
	        return var;
	  }
	  /* OSINE_SFS-1232 - RSIS 6 - Fin */
	  
	  
	  
	  
}
