package gob.osinergmin.myc.controller; 

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.DetalleCriterioDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ObliTipiDTO;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.CriterioImplFilter;
import gob.osinergmin.myc.domain.ui.DetalleCriterioImplFilter;
import gob.osinergmin.myc.domain.ui.TipificacionSancionFilter;
import gob.osinergmin.myc.service.business.CriterioServiceNeg;
import gob.osinergmin.myc.service.business.DetalleCriterioServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.ObliTipiServiceNeg;
import gob.osinergmin.myc.service.business.ObligacionTipificacionServiceNeg;
import gob.osinergmin.myc.service.business.TipificacionSancionServiceNeg;
import gob.osinergmin.myc.service.business.TipificacionServiceNeg;
import gob.osinergmin.myc.service.business.TipoSancionServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *@author luis_garcia
 * 
 */

@Controller
@RequestMapping("/criterio")

public class CriterioController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CriterioController.class);
	
	@Autowired
	ServletContext servletContext;
	
	@Inject
    private MaestroColumnaServiceNeg maestroColumnaServiceNeg;
	
	@Inject
	private TipoSancionServiceNeg tipoSancionServiceNeg;
	
	@Autowired
    private ObligacionTipificacionServiceNeg obligacionTipificacionServiceNeg;
	
	@Inject
	private TipificacionServiceNeg tipificacionServiceNeg;
	
	@Inject
	private TipificacionSancionServiceNeg tipificacionSancionServiceNeg;
	
	@Inject
	private ObliTipiServiceNeg obliTipiServiceNeg;
	 
	//Al_cargar_la_página
	@RequestMapping(method=RequestMethod.GET)
	public String inicio(Model model,HttpServletRequest request) {
		 model.addAttribute("fecha", ConstantesWeb.getFECHA());
		 model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
		 return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_CRITERIO;
	}
	
	@Inject
	private CriterioServiceNeg criterioServiceNeg;

    @RequestMapping(value="/eliminarDetalleCriterio", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> eliminarDetalleCriterio(DetalleCriterioDTO detalleCriterioDTO,HttpServletRequest request){
        LOG.info("procesando editarDetalleCriterio");
        Map<String,Object> retorno = new HashMap<String,Object>();
        LOG.info("---->idDetalleCriterio="+detalleCriterioDTO.getIdDetalleCriterio());
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            DetalleCriterioDTO registro=detalleCriterioServiceNeg.eliminarSancionEspecifica(detalleCriterioDTO,usuarioDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
            retorno.put("detalleCriterio", registro);              
            retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en editarDetalleCriterio",e.getMessage());
        }        
        return retorno;
    }
    @RequestMapping(value="/editarDetalleCriterio", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarDetalleCriterio(DetalleCriterioDTO detalleCriterioDTO,HttpServletRequest request){
        LOG.info("procesando editarDetalleCriterio");
        Map<String,Object> retorno = new HashMap<String,Object>();
        LOG.info("---->idCriterio="+detalleCriterioDTO.getIdCriterio());
        LOG.info("---->idDetalleCriterio="+detalleCriterioDTO.getIdDetalleCriterio());
        LOG.info("---->SancionEspecifica="+detalleCriterioDTO.getSancionEspecifica());
        LOG.info("---->tipoSancionEspecifica="+detalleCriterioDTO.getTipoSancionEspecifica());
        LOG.info("---->SancionMonetaria="+detalleCriterioDTO.getSancionMonetaria());
        if(detalleCriterioDTO.getTipificacionSancion()!=null){
            for (TipificacionSancionDTO reg : detalleCriterioDTO.getTipificacionSancion()) {
                LOG.info("---->tipiSanc.idTipoSancion="+reg.getIdTipoSancion());
                LOG.info("---->tipiSanc.idTipificacion="+reg.getIdTipificacion());
            }
        }
        
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            detalleCriterioDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
            DetalleCriterioDTO registro=detalleCriterioServiceNeg.editarSancionEspecifica(detalleCriterioDTO,usuarioDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
            retorno.put("detalleCriterio", registro);              
            retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en editarDetalleCriterio",e.getMessage());
        }        
        return retorno;
    }
    @RequestMapping(value="/registrarDetalleCriterio", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarDetalleCriterio(DetalleCriterioDTO detalleCriterioDTO,HttpServletRequest request){
        LOG.info("procesando registrarDetalleCriterio");
        Map<String,Object> retorno = new HashMap<String,Object>();
        LOG.info("---->idCriterio="+detalleCriterioDTO.getIdCriterio());
        LOG.info("---->SancionEspecifica="+detalleCriterioDTO.getSancionEspecifica());
        LOG.info("---->tipoSancionEspecifica="+detalleCriterioDTO.getTipoSancionEspecifica());
        LOG.info("---->SancionMonetaria="+detalleCriterioDTO.getSancionMonetaria());
        detalleCriterioDTO.setIdDetalleCriterio(null);
        if(detalleCriterioDTO.getTipificacionSancion()!=null){
            for (TipificacionSancionDTO reg : detalleCriterioDTO.getTipificacionSancion()) {
                LOG.info("---->tipiSanc.idTipoSancion="+reg.getIdTipoSancion());
                LOG.info("---->tipiSanc.idTipificacion="+reg.getIdTipificacion());
            }
        }
        
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            detalleCriterioDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
            DetalleCriterioDTO registro=detalleCriterioServiceNeg.guardarSancionEspecifica(detalleCriterioDTO,usuarioDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
            retorno.put("detalleCriterio", registro);              
            retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarDetalleCriterio",e.getMessage());
        }        
        return retorno;
    }
        
        
    @RequestMapping(value="/listarCriterioImpl",method= RequestMethod.GET)
    public @ResponseBody 
    Map<String,Object> findIdCriterio(CriterioImplFilter filtro, int rows, int page, HttpSession session,HttpServletRequest request) {
    	LOG.info("Funcion: listar Criterio -- Controller -- Metodo-> listarCriterioImpl");
    	
        Map<String,Object> listaResultado=new HashMap<String,Object>();
        
        try{
        	List<CriterioDTO> listado;
 
            	int[] auxiliar=new int[1];
	            listado=criterioServiceNeg.listarCriterioImpl(filtro, auxiliar);
	            if(listado!=null){
	            	Long contador = new Long(listado.size());
		            int indiceInicial = (page - 1) * rows;
		            int indiceFinal = indiceInicial + rows;
		            List<CriterioDTO> listaCriterio = new ArrayList<CriterioDTO>();
		            listaCriterio = listado.subList(
		                    indiceInicial, indiceFinal > listado
		                    .size() ? listado.size()
		                    : indiceFinal);
		            Long numeroFilas = (contador / rows);
		            if ((contador % rows) > 0) {
		                numeroFilas = numeroFilas + 1L;
		            }
		            
		            listaResultado.put("total", numeroFilas);
		            listaResultado.put("pagina", page);
		            listaResultado.put("registros", contador);
		            listaResultado.put("filas", listaCriterio);
	            }

        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }        
        return listaResultado;
    }    
    
    @Inject
	private DetalleCriterioServiceNeg detalleCriterioServiceNeg;
    
    @RequestMapping(value="/listarDetalleCriterioImpl",method= RequestMethod.GET)
    public @ResponseBody 
    Map<String,Object> findIdDetalleCriterioImpl(DetalleCriterioImplFilter filtro, int rows, int page, HttpSession session,HttpServletRequest request) {
    	LOG.info("Funcion: listar Detalle Criterio -- Controller -- Metodo-> listarDetalleCriterioImpl");
    	
        Map<String,Object> listaResultado=new HashMap<String,Object>();
        
        try{
        	List<DetalleCriterioDTO> listado;
	            int[] auxiliar=new int[1];
	            auxiliar[0]=0;
	            listado=detalleCriterioServiceNeg.listarDetalleCriterioImpl(filtro, auxiliar);
	            if(listado!=null){
	            	Long contador = new Long(listado.size());
		            int indiceInicial = (page - 1) * rows;
		            int indiceFinal = indiceInicial + rows;
		            List<DetalleCriterioDTO> listaCriterio = new ArrayList<DetalleCriterioDTO>();
		            listaCriterio = listado.subList(
		                    indiceInicial, indiceFinal > listado
		                    .size() ? listado.size()
		                    : indiceFinal);
		            Long numeroFilas = (contador / rows);
		            if ((contador % rows) > 0) {
		                numeroFilas = numeroFilas + 1L;
		            }
		            
		            listaResultado.put("total", numeroFilas);
		            listaResultado.put("pagina", page);
		            listaResultado.put("registros", contador);
		            listaResultado.put("filas", listaCriterio);
	            }
            
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }        
        return listaResultado;
    }
    
    @RequestMapping(value = "/abrirCriterio", method = RequestMethod.GET)
    public String abrirOrdenServicio (String tipo,Long idCriterio,CriterioDTO criterioDTO, HttpSession sesion,Model model ) throws Exception {
        LOG.info("abrir criterio .. Id --> " + idCriterio);
        LOG.info("abrir criterio tipo --> " + tipo);
        
        if(tipo.equals("editar")){        	
        	CriterioDTO criterio=criterioServiceNeg.obtenerCriterio(idCriterio);
        	ObliTipiDTO obliTipiDTO = new ObliTipiDTO();
        	obliTipiDTO = obliTipiServiceNeg.obtenerRelacion(idCriterio);
        	if(obliTipiDTO!=null){
        		criterio.setCodigoTipificacion(obliTipiDTO.getCodigoTipificacion());
        		criterio.setIdTipificacion(obliTipiDTO.getIdTipificacion());
        	}
        	
        	int[] cuenta = null;
        	TipificacionSancionFilter filtro= new TipificacionSancionFilter();
        	filtro.setIdCriterio(idCriterio);
            List<MaestroColumnaDTO> nivelMaestro = maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_NIVEL_CRITERIO);            
            Long idNivelTipificacion = nivelMaestro.get(0).getIdMaestroColumna();
        	filtro.setNivel(idNivelTipificacion);
        	List<TipificacionSancionDTO> listaTipiSancion = tipificacionSancionServiceNeg.findTipificacionSancionCriterio(filtro, cuenta);
                String txtListaTipiSancion=MycUtil.concatenaTipificacionSancion(listaTipiSancion);
                LOG.info("listaTipiSancion----->"+txtListaTipiSancion);
        	model.addAttribute("listaTipiSancion",txtListaTipiSancion);
        	model.addAttribute("criterio", criterio);
        }
        model.addAttribute("tipo", tipo);
        model.addAttribute("listaTipoCriterio", maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_TIPO_SANCION));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_FRM_CRITERIO;
    }
    
    
    @RequestMapping(value = "/obtenerProcesosCriterio", method = RequestMethod.GET)
    public @ResponseBody
    List<TipificacionSancionDTO> obtenerProcesosCriterio(Long idTipificacion) {
    	LOG.info("procesando GET para RequestMapping Consulta Requi ");
    	LOG.info("idTipificacion = " + idTipificacion);
        TipificacionDTO tipificacion = tipificacionServiceNeg.obtenerTipificacion(idTipificacion);
        List<TipificacionSancionDTO> listaSancion = tipificacion.getListaTipificacionSancion();
        return listaSancion;
    }

    @RequestMapping(value="/editarCriterio", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarCriterio(Long idCriterio,String descripcion,Long tipoCriterio,String sancionMonetaria,Long idTipificacion,String[] listaSanciones,HttpServletRequest request){
        LOG.info("procesando editarCriterio Criterio");
        LOG.info("idCriterio---->"+idCriterio);
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            for (String sancion : listaSanciones) {
                LOG.info("sancion--->"+sancion);
            }
            //setear usuario
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            //setear Criterio
            CriterioDTO criterio = new CriterioDTO();
            criterio.setIdCriterio(idCriterio);
            criterio.setDescripcion(descripcion);
            MaestroColumnaDTO tipoCriterioMaestro = new MaestroColumnaDTO();
            tipoCriterioMaestro.setIdMaestroColumna(tipoCriterio);
            criterio.setTipoCriterio(tipoCriterioMaestro);
            criterio.setSancionMonetaria(sancionMonetaria);     
            TipificacionSancionDTO tipiSancion = new TipificacionSancionDTO();
            tipiSancion.setIdTipificacion(idTipificacion);
            criterio.setTipiSancion(tipiSancion);
            criterio.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);        	
            criterio = criterioServiceNeg.editarCriterioMaestro(criterio,usuarioDTO,idTipificacion,listaSanciones);        	
            String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_UPDATE, ConstantesWeb.mensajes.MSG_ENTITY_CRITERIO);
        	retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
            retorno.put("idCriterio",criterio.getIdCriterio());
            retorno.put("resultado", 0);

        }catch(Exception ex){
            LOG.error("Error en editarCriterio: ",ex);
        }
        return retorno;
    }
    @RequestMapping(value="/registrarCriterio", method= RequestMethod.POST)
//05-11-2015
    public @ResponseBody Map<String,Object> registrarCriterio(String basesLegales,String descripcion,Long idObligacion,Long tipoCriterio,String sancionMonetaria,Long idTipificacion,String[] listaSanciones,HttpServletRequest request){
//
    	LOG.info("procesando registrar Criterio");
        Map<String,Object> retorno = new HashMap<String,Object>();
        Long idActividad = null;
        try{
        	//el id que se recibe del campo idTipificacion es el ID de la tabla pgh_obligacion_tipificacion,se consultara nuevamente para poder obtener el verdadero idTipificacion y el idActividad
        	List<TipificacionDTO> listTipificaciones = new ArrayList<TipificacionDTO>();
        	listTipificaciones=obligacionTipificacionServiceNeg.listarTipificacionPorObligacion(idObligacion);
        	for (TipificacionDTO tipificacionDTO : listTipificaciones) {
        		Long idObliTipi = tipificacionDTO.getIdObliTipi();
				if( idObliTipi.equals(idTipificacion)){
					idTipificacion = tipificacionDTO.getIdTipificacion();
					idActividad = tipificacionDTO.getIdActividad();
					break;
				}
			}
        	
        	//setear usuario
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
        	//setear Criterio
//05-11-2015
            if(sancionMonetaria!=null && !sancionMonetaria.equals("")){         	
	            TipificacionDTO tipToCompare = tipificacionServiceNeg.obtenerTipificacion(idTipificacion);
	            double sanMonTipificacion = Double.parseDouble(tipToCompare.getSancionMonetaria());            
	            double sanMonCriterio =  Double.parseDouble(sancionMonetaria);
	            LOG.info("sancion tipificacion: "+sanMonTipificacion + " sancion criterio: "+sanMonCriterio);
	            if(sanMonCriterio<sanMonTipificacion || sanMonCriterio == sanMonTipificacion){
	        	CriterioDTO criterio = new CriterioDTO();
	        	criterio.setDescripcion(descripcion);
	//05-11-2015
	        	criterio.setBasesLegales(basesLegales);
	        	if(idObligacion!=null){
	        		criterio.setIdObligacion(idObligacion);
	        		LOG.info("obligacion id ..>"+idObligacion);
	        	}
	        	
	        	if(tipoCriterio!=null){
	        		MaestroColumnaDTO tipoCriterioMaestro = new MaestroColumnaDTO();
	            	tipoCriterioMaestro.setIdMaestroColumna(tipoCriterio);
	            	criterio.setTipoCriterio(tipoCriterioMaestro);	
	        	}        	
	//        	
	        	if(idActividad != 0){
	        		criterio.setIdActividad(idActividad);
	        	}
	        	criterio.setSancionMonetaria(sancionMonetaria);     
	        	TipificacionSancionDTO tipiSancion = new TipificacionSancionDTO();
	        	tipiSancion.setIdTipificacion(idTipificacion);
	        	criterio.setTipiSancion(tipiSancion);
	        	criterio.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);        	
	        	criterio = criterioServiceNeg.guardaCriterioMaestro(criterio,usuarioDTO,idTipificacion,listaSanciones);  
	        	
	        	String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE, ConstantesWeb.mensajes.MSG_ENTITY_CRITERIO);
	        	retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
	        		retorno.put("idCriterio",criterio.getIdCriterio());
	                retorno.put("resultado", 0);
	            }else{
	            	String mensaje = "El monto de la sanci&oacute;n monetaria no puede ser mayor a la sanci&oacute;n monetaria de la tipificaci&oacute;n";
	            	retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
	                retorno.put("resultado", 3);
	            }
            }else{
            	CriterioDTO criterio = new CriterioDTO();
	        	criterio.setDescripcion(descripcion);
	//05-11-2015
	        	criterio.setBasesLegales(basesLegales);
	        	if(idObligacion!=null){
	        		criterio.setIdObligacion(idObligacion);
	        		LOG.info("obligacion id ..>"+idObligacion);
	        	}
	        	
	        	if(tipoCriterio!=null){
	        		MaestroColumnaDTO tipoCriterioMaestro = new MaestroColumnaDTO();
	            	tipoCriterioMaestro.setIdMaestroColumna(tipoCriterio);
	            	criterio.setTipoCriterio(tipoCriterioMaestro);	
	        	}        	
	        	
	        	if(idActividad != 0){
	        		criterio.setIdActividad(idActividad);
	        	}
	//        	
	        	criterio.setSancionMonetaria(sancionMonetaria);     
	        	TipificacionSancionDTO tipiSancion = new TipificacionSancionDTO();
	        	tipiSancion.setIdTipificacion(idTipificacion);
	        	criterio.setTipiSancion(tipiSancion);
	        	criterio.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);        	
	        	criterio = criterioServiceNeg.guardaCriterioMaestro(criterio,usuarioDTO,idTipificacion,listaSanciones);  
	        	
	        	String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE, ConstantesWeb.mensajes.MSG_ENTITY_CRITERIO);
	        	retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
	        		retorno.put("idCriterio",criterio.getIdCriterio());
	                retorno.put("resultado", 0);
            }

        }catch(Exception ex){
            LOG.error("Error en registrarTipificacion: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
      
    @RequestMapping ( value = "/abrirDialogMantSanciones" , method = RequestMethod.GET )
    public String abrirDialogMantSanciones(String tipo,DetalleCriterioDTO detalleCriterioDTO,Model model,HttpSession session, HttpServletRequest request) throws Exception {
      	LOG.info("abrirDialogMantSanciones");
        LOG.info("----------->"+detalleCriterioDTO.getSancionEspecifica());
        model.addAttribute("tipo", tipo);
        model.addAttribute("reg", detalleCriterioDTO);
        model.addAttribute("listaTipoCriterio", maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_TIPO_SANCION));
        return "general/criterio/sanciones/mantSanciones";
    }
    
    @RequestMapping(value = "/eliminaCriterio", method = RequestMethod.GET)
    public @ResponseBody 
        Map<String, Object> eliminaCriterio(CriterioDTO criterioDTO,HttpSession session){
        LOG.info("Eliminar Criterio Controller <--> ");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
        	
        	UsuarioDTO usuarioDTO = getUsuario(session);
        	
        	criterioDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
        	CriterioDTO retorno=criterioServiceNeg.eliminarCriterio(criterioDTO,usuarioDTO);
        	
        	String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_DELETE, ConstantesWeb.mensajes.MSG_ENTITY_CRITERIO);
        	salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
        	salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        	
        } catch (Exception e) {
        	String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_DELETE, ConstantesWeb.mensajes.MSG_ENTITY_CRITERIO);
        	salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
        	salida.put(ConstantesWeb.VV_RESULTADO, 3);
        	e.printStackTrace();
        }
      
        return salida;
    }


	private UsuarioDTO getUsuario(HttpSession session) {
//		UsuarioDTO usuarioView = (UsuarioDTO) sesion.getAttribute(Constantes.SESION_USUARIO);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        try {
            usuarioDTO.setCodigo("00002");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioDTO;
	}
    
	   /**
	    * Concatena_Mensaje_Estático + Mensaje_Entidad
	    * @param msgStatic
	    * @param msgDinamic
	    * @return
	    */
	   public static String controlMessagesStaticEntity(String msgStatic,String msgEntity){
		   String concatenado = "";
		   String[] s = new String[2];
		   s[0]=msgStatic;
		   s[1]=msgEntity;
		   concatenado=s[0]+" "+s[1];
		   return concatenado;
	   }
    
    
}
