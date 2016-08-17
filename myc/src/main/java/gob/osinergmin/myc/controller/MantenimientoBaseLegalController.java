/**
 * Resumen.
 * Objeto            : MantenimientoBaseLegalController.java
 * Descripción       : 
 * Fecha de Creación : 
 * PR de Creación    : 
 * Autor             : 
 * ---------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo   	Fecha     		Nombre                Descripción
 * OSINE_119	10/06/2016		Roy Colorado		  Se implementaron los siguientes métodos
 * 													  - registrarInfraccion();
 * 													  - registrarIncumplimiento();
 * 													  - findIncumplimiento();
 * 													  - eliminarIncumplimiento();
 * 													  - descargaArchivoInfraccion();
 * 													  - Se agregó el siguiente método consultaInfraccionByObligacionId();	
 * ----------------------------------------------------------------------------------------
 */

package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.PghCriterio;
import gob.osinergmin.myc.common.util.JsonUtil;
import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.CnfObligacionDTO;
import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.DetalleBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.DetalleCriterioDTO;
import gob.osinergmin.myc.domain.dto.DetalleDocumentoCriterioDTO;
import gob.osinergmin.myc.domain.dto.DetalleNormaTecnicaDTO;
import gob.osinergmin.myc.domain.dto.DetalleObligacionDTO;
import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.dto.IncumplimientoDTO;
import gob.osinergmin.myc.domain.dto.InfraccionDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ObliTipiDTO;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;
import gob.osinergmin.myc.domain.dto.ObligacionTipificacionDTO;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;
import gob.osinergmin.myc.domain.dto.TemaDTO;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarDocumentoAdjuntoInRO;
import gob.osinergmin.myc.domain.in.GuardarRubroOpcionInRO;
import gob.osinergmin.myc.domain.out.GuardarDocumentoAdjuntoOutRO;
import gob.osinergmin.myc.domain.out.GuardarRubroOpcionOutRO;
import gob.osinergmin.myc.domain.ui.BaseLegalFilter;
import gob.osinergmin.myc.domain.ui.ObligacionFilter;
import gob.osinergmin.myc.service.business.BaseLegalServiceNeg;
import gob.osinergmin.myc.service.business.CnfObligServiceNeg;
import gob.osinergmin.myc.service.business.CriterioServiceNeg;
import gob.osinergmin.myc.service.business.DetalleCriterioServiceNeg;
import gob.osinergmin.myc.service.business.DetalleObligacionServiceNeg;
import gob.osinergmin.myc.service.business.DocumentoAdjuntoNeg;
import gob.osinergmin.myc.service.business.IncumplimientoServiceNeg;
import gob.osinergmin.myc.service.business.InfraccionServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.ObliTipiServiceNeg;
import gob.osinergmin.myc.service.business.ObligacionBaseLegalServiceNeg;
import gob.osinergmin.myc.service.business.ObligacionNormativaServiceNeg;
import gob.osinergmin.myc.service.business.ObligacionTipificacionServiceNeg;
import gob.osinergmin.myc.service.business.PrioridadNormaAgenteServiceNeg;
import gob.osinergmin.myc.service.business.TipificacionServiceNeg;
import gob.osinergmin.myc.service.business.TrazabilidadObligacionesServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

import java.beans.PropertyEditorSupport;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Inet4Address;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.helpers.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.commons.lang.StringUtils;
/**
 *
 * @author gvillanueva
 */
@Controller
@RequestMapping("/mantenimiento/baseLegal")
public class MantenimientoBaseLegalController {
    private static final Logger LOG = LoggerFactory.getLogger(MantenimientoBaseLegalController.class);
    @Inject
    private DocumentoAdjuntoNeg documentoServiceNeg;
    @Autowired
    private MaestroColumnaServiceNeg maestroColumnaService;
    
    @Autowired
    private BaseLegalServiceNeg baseLegalService; 
    
    @Autowired
    private ObligacionNormativaServiceNeg obligacionNormativaService;
    
    @Autowired
    private TipificacionServiceNeg tipificacionService;
    
    @Autowired
    private CriterioServiceNeg criterioService;
    
    @Autowired
    private DetalleCriterioServiceNeg detalleCriterioService;
    
    @Autowired
    private CnfObligServiceNeg cnfObligService;
    
    @Autowired
    private DetalleObligacionServiceNeg detalleObligacionService;
    
    @Autowired
    private ObligacionBaseLegalServiceNeg obligacionBaseLegalServiceNeg;
    
    @Autowired
    private ObligacionTipificacionServiceNeg obligacionTipificacionServiceNeg;

    @Autowired
    private TrazabilidadObligacionesServiceNeg trazabilidadObligacionesServiceNeg;
    
    @Inject
    private ObliTipiServiceNeg obliTipiServiceNeg;
    
    @Inject
    private ObliTipiServiceNeg obliTipiCriterioServiceNeg;
    /*PR_OSINE119 - Item 13 - Inicio*/
    @Autowired
    private InfraccionServiceNeg infraccionServiceNeg;
    /*PR_OSINE119 - Item 13 - Fin*/
    
    /*PR_OSINE119 - Item 14 - Inicio*/
    @Autowired
    private IncumplimientoServiceNeg incumplimientoServiceNeg ;
    /*PR_OSINE119 - Item 14 - Fin*/
	
	/* OSINE_SFS-600 - REQF-0012 - Inicio */
    @Inject
    private PrioridadNormaAgenteServiceNeg prioridadNormaAgenteNeg; 
	/* OSINE_SFS-600 - REQF-0012 - Fin */
	
    @InitBinder
    public void binder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat("dd/MM/yyyy").parse(value));
                } catch (ParseException e) {
                    setValue(null);
                }
            }

            public String getAsText() {
                return new SimpleDateFormat("dd/MM/yyyy")
                .format((Date) getValue());
            }

        });
    }
    
    private UsuarioDTO getUsuario(HttpSession sesion) {
        //	UsuarioDTO usuarioView = (UsuarioDTO) sesion.getAttribute(Constantes.SESION_USUARIO);
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
     * 
     * @param model
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
    public String inicio(Model model, HttpServletRequest request,HttpSession session) {
        
        return "moduloObligaciones/mantenimiento/baseLegal/nuevo";
    }
    /**
     * 
     * @param session
     * @param model
     * @return 
     */
    @RequestMapping(value = "/arbolActividades", method = RequestMethod.GET)
    public String dialogArbolActividades(HttpSession session,
                    Model model) {

            String arbolActividades = "<li id='0' class='folder'>ACTIVIDADES"
                            + "<ul>";
            arbolActividades += "</li>";

            model.addAttribute("arbolActividades", arbolActividades);
            return "moduloObligaciones/common/formArbolActividades";
    }
    /**
     * 
     * @param session
     * @param model
     * @return 
     */
    @RequestMapping(value = "/arbolProductos", method = RequestMethod.GET)
    public String dialogArbolProductos(HttpSession session,
                    Model model) {

            String arbolProductos = "<li id='0' class='folder'>ACTIVIDADES"
                            + "<ul>";
            arbolProductos += "</li>";

            model.addAttribute("arbolProductos", arbolProductos);
            return "moduloObligaciones/common/formArbolProductos";
    }
    /**
     * 
     * @param session
     * @param model
     * @return 
     */
    @RequestMapping(value = "/arbolTransportes", method = RequestMethod.GET)
    public String dialogArbolTransportes(HttpSession session,
                    Model model) {

            String arbolTransportes = "<li id='0' class='folder'>ACTIVIDADES"
                            + "<ul>";
            arbolTransportes += "</li>";

            model.addAttribute("arbolTransportes", arbolTransportes);
            return "moduloObligaciones/common/formArbolTransportes";
    }
    /**
     * 
     * @return 
     */
    @RequestMapping(value = "/obtenerTipoNormaLegal", method = RequestMethod.GET)
    public @ResponseBody
    List<MaestroColumnaDTO> obtenerTipoNormaLegal() {
        List<MaestroColumnaDTO> listTipoNormaLegal = new ArrayList<MaestroColumnaDTO>();
        try{
        listTipoNormaLegal=maestroColumnaService.listarTipoNormaLegal();
        }catch(Exception e){
            LOG.info("error al procesar listadoTiposNormaLegal " +e);
        }
        return listTipoNormaLegal;
    }
    @RequestMapping(value = "/obtenerNormaLegalPadre", method = RequestMethod.GET)
    public @ResponseBody
    List<BaseLegalDTO> obtenerNormaLegalPadre() {
        List<BaseLegalDTO> listNormaLegalPadre = new ArrayList<BaseLegalDTO>();
        try{
        	listNormaLegalPadre=baseLegalService.listarNormaLegalPadre();
        }catch(Exception e){
            LOG.info("error al procesar listado de normas legales padre " +e);
        }
        return listNormaLegalPadre;
    }
    /**
     * 
     * @return 
     */
    @RequestMapping(value = "/obtenerSigla", method = RequestMethod.GET)
    public @ResponseBody
    List<MaestroColumnaDTO> obtenerSigla() {
        List<MaestroColumnaDTO> listSigla = new ArrayList<MaestroColumnaDTO>();
        try{
        listSigla=maestroColumnaService.listarSigla();
        }catch(Exception e){
            LOG.info("error al procesar listadoSigla " +e);
        }
        return listSigla;
    }
    /**
     * 
     * @return 
     */
    @RequestMapping(value = "/obtenerTipoAnexo", method = RequestMethod.GET)
    public @ResponseBody
    List<MaestroColumnaDTO> obtenerTipoAnexo() {
        List<MaestroColumnaDTO> listTipoAnexo = new ArrayList<MaestroColumnaDTO>();
        try{
        listTipoAnexo=maestroColumnaService.listarTipoAnexo();
        }catch(Exception e){
            LOG.info("error al procesar listadoSigla " +e);
        }
        return listTipoAnexo;
    }    
    /***        
    * @param codigo
    * @return 
    */
    @RequestMapping(value = "/obtenerNumeroAnexo", method = RequestMethod.GET)
    public @ResponseBody
    List<MaestroColumnaDTO> obtenerNumeroAnexo(String codTipoAnexo) {
    	System.out.println("codigoo por finnn"+codTipoAnexo);
        List<MaestroColumnaDTO> listNumeroAnexo = new ArrayList<MaestroColumnaDTO>();
        try{
        listNumeroAnexo=maestroColumnaService.listarNumeroAnexo(codTipoAnexo);
        }catch(Exception e){
            LOG.info("error al procesar listadoSigla " +e);
        }
        return listNumeroAnexo;
    }
    
    /**
     * 
     * @param idActividad
     * @return 
     */
    @RequestMapping(value = "/obtenerComponentes", method = RequestMethod.GET)
    public @ResponseBody
    List<MaestroColumnaDTO> obtenerComponentes(Long idActividad) {
        LOG.info("procesando GET para RequestMapping /obtenerComponentes "+ idActividad);
        List<MaestroColumnaDTO> listComponente = new ArrayList<MaestroColumnaDTO>();
        List<MaestroColumnaDTO> listarComponentes = new ArrayList<MaestroColumnaDTO>();
        try{
        listComponente=maestroColumnaService.listarComponente();
        for (MaestroColumnaDTO componenteDTO : listComponente) {
            if(componenteDTO.getIdActividad().equals(idActividad)){
                listarComponentes.add(componenteDTO);
            }
        }
        
        }catch(Exception e){
            LOG.info("error al procesar listadoComponentes " +e);
        }
        return listarComponentes;
    }
    /**
     * 
     * @return 
     */
    @RequestMapping(value = "/obtenerTema", method = RequestMethod.GET)
    public @ResponseBody
    List<MaestroColumnaDTO> obtenerTema() {
        List<MaestroColumnaDTO> listTema = new ArrayList<MaestroColumnaDTO>();
        try{
        listTema=maestroColumnaService.listarTemas();
        }catch(Exception e){
            LOG.info("error al procesar listado de Temas " +e);
        }
        return listTema;
    }
    /**
     * 
     * @return 
     */
    @RequestMapping(value = "/obtenerCriticidad", method = RequestMethod.GET)
    public @ResponseBody
    List<MaestroColumnaDTO> obtenerCriticidad() {
        List<MaestroColumnaDTO> listCriticidad = new ArrayList<MaestroColumnaDTO>();
        try{
        listCriticidad=maestroColumnaService.listarCriticidad();
        }catch(Exception e){
            LOG.info("error al procesar listado de Criticidades " +e);
        }
        return listCriticidad;
    }
    /**
     * 
     *  * @return
     */
//05-11-2015
    @RequestMapping(value = "/obtenerTipificacionToCriterio", method = RequestMethod.GET)
    public @ResponseBody
    List<TipificacionDTO> obtenerTipificacionToCriterio(Long idObligacion) {
        List<TipificacionDTO> listTipificaciones = new ArrayList<TipificacionDTO>();
        try{
        	listTipificaciones=obligacionTipificacionServiceNeg.listarTipificacion(idObligacion);
        }catch(Exception e){
            LOG.info("error al procesar listado de Tipificaciones " +e);
        }
        return listTipificaciones;
    }
//
    /**
     * 
     * @return 
     */
    @RequestMapping(value = "/obtenerTipoNormaTecnica", method = RequestMethod.GET)
    public @ResponseBody
    List<MaestroColumnaDTO> obtenerTipoNormaTecnica() {
        List<MaestroColumnaDTO> listNormaTecnica = new ArrayList<MaestroColumnaDTO>();
        try{
        listNormaTecnica=maestroColumnaService.listarNormaTecnica();
        }catch(Exception e){
            LOG.info("error al procesar listado de Normas Tecnicas " +e);
        }
        return listNormaTecnica;
    }
    /**
     * 
     * @param montoTipificacion
     * @param descripcionTipificacion
     * @param codigoTipificacion
     * @param tipificacion
     * @param codigoObligacion
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping(value = "/registrarTipificacion", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> registrarTipificacion(Long idTipificacion, Long idObligacion,String codTrazabilidad,HttpServletRequest request, HttpSession session) {
        LOG.info("procesando POST para RequestMapping /registrarTipificacion POST -- registrarTipificacion");
        LOG.info("-- idTipificacion = "+idTipificacion);
        LOG.info("-- idObligacion = "+idObligacion);

        Map<String, Object> salida = new HashMap<String, Object>();
        ObligacionTipificacionDTO obligacionTipificacionDTO = null;

        try {
            UsuarioDTO usuarioDTO = getUsuario(session);

            obligacionTipificacionDTO = new ObligacionTipificacionDTO();
            obligacionTipificacionDTO.setIdTipificacion(idTipificacion);
            obligacionTipificacionDTO.setIdObligacion(idObligacion);
            obligacionTipificacionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            obligacionTipificacionDTO.setCodTrazabilidad(codTrazabilidad);
            List<TipificacionDTO> listaTipificacoion = obligacionTipificacionServiceNeg.listarTipificacion(idObligacion, idTipificacion);
            LOG.info("-- listaTipificacoion = " + listaTipificacoion.size());
            if (listaTipificacoion.isEmpty()) {
                obligacionTipificacionServiceNeg.guardaObligacionTipificacion(obligacionTipificacionDTO, usuarioDTO);
                String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_TIPIFICACION);
                salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            } else {
            	String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE_DUPLICATE,ConstantesWeb.mensajes.MSG_ENTITY_TIPIFICACION);
                salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            }
        } catch (Exception ex) {
            LOG.error("Error al Registrar Tipificacion Controller: " + ex.getMessage());
            ex.printStackTrace();
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_TIPIFICACION);
            salida.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }

        return salida;
    }
    /*PR OSINE_119 - Item 14 - Inicio*/    
    @RequestMapping(value = "/registrarIncumplimiento", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> registrarIncumplimiento(Long idIncumplimiento,Long  idObligacion,Long idInfraccion,Long idMaestroincumplimiento, String codTrazabilidad,HttpServletRequest request, HttpSession session) {
        LOG.info("procesando POST para RequestMapping /registrarIncumplimiento POST -- registrarIncumplimiento");
        LOG.info("-- idTipificacion = "+idIncumplimiento);
        LOG.info("-- idObligacion = "+idObligacion);
        LOG.info("-- idInfraccion = "+idInfraccion);
        Map<String, Object> salida = new HashMap<String, Object>();
        IncumplimientoDTO incumplimientoDTO = null;        
        try {
            UsuarioDTO usuarioDTO = getUsuario(session);
            
            incumplimientoDTO = new IncumplimientoDTO();
            incumplimientoDTO.setId_esce_incumplimiento(idIncumplimiento);
            incumplimientoDTO.setId_infraccion(idInfraccion);
            incumplimientoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            incumplimientoDTO.setId_esce_incu_maestro(idMaestroincumplimiento);
            incumplimientoDTO.setCod_trazabilidad(codTrazabilidad);
            incumplimientoDTO.setTerminal_creacion(usuarioDTO.getTerminal());
            incumplimientoDTO.setUsuario_creacion(usuarioDTO.getCodigo());
        
            if(idInfraccion!=null){
            
		            List<IncumplimientoDTO> listaIncumplimiento = incumplimientoServiceNeg.listarIncumplimiento(idInfraccion, idMaestroincumplimiento);		            
		            if (listaIncumplimiento==null || listaIncumplimiento.isEmpty()) {
		            	
		                incumplimientoServiceNeg.guardaIncumplimiento(incumplimientoDTO, usuarioDTO);
		                String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_INCUMPLIMIENTO);
		                salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
		                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
		            	
		            } else {
		            	String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE_DUPLICATE,ConstantesWeb.mensajes.MSG_ENTITY_INCUMPLIMIENTO);
		                salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
		                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
		            }
	        } else {	        		
	        		// OSINE_SFS-610 - Inicio
	        	    //String mensaje=controlMessagesStaticEntity("Debe registrar la Infraci&oacute;n","");
	        		String mensaje=controlMessagesStaticEntity("Debe registrar la Infracci&oacute;n","");
	        	    // OSINE_SFS-610 - Inicio
		        	salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
		            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	        }
            
        } catch (Exception ex) {
            LOG.error("Error al Registrar Incumplimiento Controller: " + ex.getMessage());
            ex.printStackTrace();
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_INCUMPLIMIENTO);
            salida.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }

        return salida;
    }
    /*PR OSINE_119 - Item 14 - Fin*/
    
    @RequestMapping(value = "/findTipificacion", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> findTipificacion(int rows, int page, String sidx,
            String sord, Long idObligacion, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        LOG.info("procesando GET para RequestMapping /findTipificacion ");
        LOG.info("-- idObligacion = " + idObligacion);

        List<TipificacionDTO> listaTipificacion = obligacionTipificacionServiceNeg.listarTipificacion(idObligacion);
        Long contador = new Long(listaTipificacion.size());
        int indiceInicial = (page - 1) * rows;
        int indiceFinal = indiceInicial + rows;
        List<TipificacionDTO> listaTipificacionPaginada = new ArrayList<TipificacionDTO>();
        listaTipificacionPaginada = listaTipificacion.subList(
                indiceInicial, indiceFinal > listaTipificacion
                .size() ? listaTipificacion.size()
                : indiceFinal);
        Long numeroFilas = (contador / rows);
        if ((contador % rows) > 0) {
            numeroFilas = numeroFilas + 1L;
        }
//        if(idTipificacion != null && idTipificacion != ""){
//            for (TipificacionDTO tipificacionDTO : listaTipificacionPaginada) {
//               if(tipificacionDTO.getIdTipificacion().equals(new Long(idTipificacion))){
//                    tipificacionDTO.setSeleccionado("1");
//                }
//            }
//        }
        map.put("total", numeroFilas);
        map.put("pagina", page);
        map.put("registros", contador);
        map.put("filas", listaTipificacionPaginada);
        return map;
    }
    /*PR OSINE_119 - Item 14 - Inicio*/
    /**
     * Método que realiza la búsqueda de incumplimientos
     * @param rows
     * @param page
     * @param sidx
     * @param sord
     * @param idIncumplimiento
     * @param session
     * @return 
     */
    @RequestMapping(value = "/findIncumplimiento", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> findIncumplimiento(int rows, int page, String sidx,
            String sord, Long idInfraccion, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        LOG.info("procesando GET para RequestMapping /findTipificacion ");
        LOG.info("-- findIncumplimiento -idInfraccion = " + idInfraccion);
        List<IncumplimientoDTO> listaIncumplimiento = new ArrayList<IncumplimientoDTO>();
        Long contador = new Long(0);
        if(idInfraccion!=null){
         listaIncumplimiento = incumplimientoServiceNeg.listarIncumplimientos(idInfraccion);
         if(listaIncumplimiento!=null){
        	 contador=new Long(listaIncumplimiento.size());
        	 int indiceInicial = (page - 1) * rows;
             int indiceFinal = indiceInicial + rows;
             List<IncumplimientoDTO> listaTipificacionPaginada = new ArrayList<IncumplimientoDTO>();
             listaTipificacionPaginada = listaIncumplimiento.subList(
                     indiceInicial, indiceFinal > listaIncumplimiento
                     .size() ? listaIncumplimiento.size()
                     : indiceFinal);
             Long numeroFilas = (contador / rows);
             if ((contador % rows) > 0) {
                 numeroFilas = numeroFilas + 1L;
             }
             map.put("total", numeroFilas);
             map.put("pagina", page);
             map.put("registros", contador);
             map.put("filas", listaTipificacionPaginada);
             map.put("idInfraccion", idInfraccion);
        	 
         }
         
        }        
        
        
        return map;
    }
    /*PR OSINE_119 - Item 14 - Fin*/
    
    /*PR OSINE_119 - Item 14 - Inicio*/
    /**
     * Método que elimina incumplimientos
     * @param idEscenearioIncumplimiento
     * @param session
     * @return
     */
    @RequestMapping(value = "/eliminarIncumplimiento", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> eliminarIncumplimiento(Long idEscenearioIncumplimiento, HttpSession session) {
    	
        Map<String, Object> map = new HashMap<String, Object>();
        UsuarioDTO usuarioDTO = getUsuario(session);
        LOG.info("procesando GET para RequestMapping /findTipificacion ");
        LOG.info("-- idIncumplimiento = " + idEscenearioIncumplimiento);
        IncumplimientoDTO incumplimientoDTO = new IncumplimientoDTO();
        incumplimientoDTO.setId_esce_incumplimiento(idEscenearioIncumplimiento);
        incumplimientoDTO  = incumplimientoServiceNeg.eliminarIncumplimiento(incumplimientoDTO,usuarioDTO);
        if (incumplimientoDTO!=null) {            
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE_RELATION,ConstantesWeb.mensajes.MSG_OPERATION_FAIL_DELETE);
            map.put(ConstantesWeb.VV_MENSAJE, mensaje);
            map.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        } else {
        	String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE_DUPLICATE,ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_DELETE);
        	map.put(ConstantesWeb.VV_MENSAJE, mensaje);
        	map.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
        return map;
    }
    
    /*PR OSINE_119 - Item 14 - Fin*/
    
    @RequestMapping(value = "/findTipificacionCriterio", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> findTipificacionCriterio(int rows, int page, String sidx,
            String sord, Long idObligacion, Long idTipificacion, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        LOG.info("procesando GET para RequestMapping /findTipificacionCriterio ");
        LOG.info("-- idObligacion = " + idObligacion);
        LOG.info("-- idTipificacion = " + idTipificacion);

        List<TipificacionDTO> listaTipificacion = obligacionTipificacionServiceNeg.listarTipificacion(idObligacion);
        Long contador = new Long(listaTipificacion.size());
        int indiceInicial = (page - 1) * rows;
        int indiceFinal = indiceInicial + rows;
        List<TipificacionDTO> listaTipificacionPaginada = new ArrayList<TipificacionDTO>();
        listaTipificacionPaginada = listaTipificacion.subList(
                indiceInicial, indiceFinal > listaTipificacion
                .size() ? listaTipificacion.size()
                : indiceFinal);
        Long numeroFilas = (contador / rows);
        if ((contador % rows) > 0) {
            numeroFilas = numeroFilas + 1L;
        }
        if(idTipificacion.intValue() > 0 ){
            for (TipificacionDTO tipificacionDTO : listaTipificacionPaginada) {
               if(tipificacionDTO.getIdTipificacion().equals(new Long(idTipificacion))){
                    tipificacionDTO.setSeleccionado("1");
                }
            }
        }
        map.put("total", numeroFilas);
        map.put("pagina", page);
        map.put("registros", contador);
        map.put("filas", listaTipificacionPaginada);
        return map;
    }
    /**
     * 
     * @param codigoEliminarTipificacion
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping(value = "/eliminarObligacionTipificacion", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> eliminarObligacionTipificacion(Long idObligacion, Long idTipificacion, String codTrazabilidad, HttpServletRequest request, HttpSession session) {
        LOG.info("procesando GET para RequestMapping /eliminarTipificacion GET ");
        LOG.info("-- idObligacion = " + idObligacion);
        LOG.info("-- idTipificacion = " + idTipificacion);
        LOG.info("-- CodTrazabilidad = " + codTrazabilidad);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            
            ObligacionTipificacionDTO obligacionTipificacionDTO  = new ObligacionTipificacionDTO();
            obligacionTipificacionDTO.setIdObligacion(idObligacion);
            obligacionTipificacionDTO.setIdTipificacion(idTipificacion);
            obligacionTipificacionDTO.setCodTrazabilidad(codTrazabilidad);
            
            ObliTipiDTO filter = new ObliTipiDTO();
            filter.setIdObligacion(idObligacion);
            filter.setIdTipificacion(idTipificacion);
            List<ObliTipiDTO> existeCriteAsoc= obliTipiCriterioServiceNeg.obtenerRelaciones(filter);
            if(existeCriteAsoc!=null){
            	obligacionTipificacionServiceNeg.eliminarObligacionTipificacion(obligacionTipificacionDTO);
            	String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_DELETE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_TIPIFICACION);
                map.put(ConstantesWeb.VV_MENSAJE, mensaje);
                map.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            }else{
            	String mensaje="No se puede eliminar tipificación mientras existan criterios asociados";
                map.put(ConstantesWeb.VV_MENSAJE, mensaje);
                map.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ADVERTENCIA);
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage(), e);
        String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_DELETE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_TIPIFICACION);
        map.put(ConstantesWeb.VV_MENSAJE, mensaje);
	    map.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
	    
        }

        return map;
    }
    
    @RequestMapping(value = "/obtenerTipificacion", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> obtenerTipificacion(Long idTipificacion, HttpServletRequest request, HttpSession session, Model model) {
        LOG.info("procesando GET para RequestMapping MantemientoBaseLegalController/obtenerTipificacion");
        LOG.info("-- idTipificacion = " + idTipificacion);
        Map<String, Object> map = new HashMap<String, Object>();
        TipificacionDTO tipificacion = null;
        try {
        	if(idTipificacion!=null){
        		tipificacion = tipificacionService.obtenerTipificacion(idTipificacion);                
                map.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        	}  
        	map.put("tipificacion", tipificacion);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            map.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            map.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
        return map;
    }
    @RequestMapping(value = "/obtenerTipificacionCriterio", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> obtenerTipificacionCriterio(Long idTipificacion, HttpServletRequest request, HttpSession session, Model model) {
        LOG.info("procesando GET para RequestMapping MantemientoBaseLegalController/obtenerTipificacion");
        LOG.info("-- idTipificacion = " + idTipificacion);
        Map<String, Object> map = new HashMap<String, Object>();
        TipificacionDTO tipificacion=new TipificacionDTO();
        try {
        	if(idTipificacion!=null){
        		tipificacion = tipificacionService.obtenerTipificacionCriterio(idTipificacion);
        	}
            
            map.put("tipificacion", tipificacion);
            map.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            map.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            map.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
        return map;
    }

    @RequestMapping(value = "/findTipificaciones", method = RequestMethod.GET)
    public @ResponseBody
    List<TipificacionDTO> findTipificaciones(String codigo, HttpServletRequest request, HttpSession sesion, Model model) {
        LOG.info("MantenimientoBaseLegalController -- findTipificaciones");
        List<TipificacionDTO> listaTipificaciones = tipificacionService.obtenerTipificaciones(codigo);
        System.out.println("-- listaTipificaciones "+ listaTipificaciones.size());
        return listaTipificaciones;
    }
    
    @RequestMapping(value = "/findTipificacionCodigo", method = RequestMethod.GET)
    public @ResponseBody
    TipificacionDTO findTipificacionCodigo(String codigo, HttpServletRequest request, HttpSession sesion, Model model) {
        LOG.info("MantenimientoBaseLegalController -- findTipificaciones");
        TipificacionDTO tipificacion = new TipificacionDTO();
        tipificacion = tipificacionService.obtenerTipificacion(codigo);
//        if(!listaTipificaciones.isEmpty()){
//            tipificacion = listaTipificaciones.get(0);
//        }
        return tipificacion;
    }
    
    @RequestMapping(value = "/findTipificacionCodigoCriterio", method = RequestMethod.GET)
    public @ResponseBody
    TipificacionDTO findTipificacionCodigoCriterio(String codigo, HttpServletRequest request, HttpSession sesion, Model model) {
        LOG.info("MantenimientoBaseLegalController -- findTipificaciones");
        TipificacionDTO tipificacion = new TipificacionDTO();
        tipificacion = tipificacionService.obtenerTipificacionCriterio(codigo);
//        if(!listaTipificaciones.isEmpty()){
//            tipificacion = listaTipificaciones.get(0);
//        }
        return tipificacion;
    }
    
    @RequestMapping(value = "/registrarCriterio", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> registrarCriterio(Long idTipificacion, Long idObligacion, String descripcionCriterio, Long idCriterio, String codTrazabilidad, HttpServletRequest request, HttpSession session){
        LOG.info("procesando POST para RequestMapping /registrarCriterio POST");
        Map<String, Object> salida = new HashMap<String, Object>();
        
        try{
            CriterioDTO criterio = new CriterioDTO();
            criterio.setIdObligacion(idObligacion);
            criterio.setDescripcion(descripcionCriterio);
            criterio.setIdTipificacion(idTipificacion);
            criterio.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            criterio.setCodTrazabilidad(codTrazabilidad);
            UsuarioDTO usuarioDTO = getUsuario(session);
            List<DetalleCriterioDTO> listaDetalleCriterio = getListDetalleCriterio(session);
            List<DetalleDocumentoCriterioDTO> listaDetalleDocumentoCriterio = getListDetalleDocumentoCriterio(session);
            if(idCriterio.intValue() > 0){
                criterio.setIdCriterio(idCriterio);
                criterio = criterioService.actualizarCriterio(criterio, usuarioDTO);    
            }else{
                criterio = criterioService.guardaCriterio(criterio, listaDetalleCriterio, listaDetalleDocumentoCriterio, usuarioDTO);    
            }
            salida.put("idCriterio",criterio.getIdCriterio());
            salida.put("criterio", criterio);
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE,ConstantesWeb.mensajes.MSG_ENTITY_CRITERIO);
            salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            LOG.error("Error al Registrar Criterio Controller: "+ex.getMessage());
            ex.printStackTrace();
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE,ConstantesWeb.mensajes.MSG_ENTITY_CRITERIO);
            salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
//            salida.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
        
        return salida;
    }
    
    @RequestMapping(value = "/eliminarCriterio", method = RequestMethod.GET)
    public @ResponseBody 
        Map<String, Object> eliminarCriterio(Long idCriterio, String codTrazabilidad ,HttpServletRequest request, HttpSession session){
        LOG.info("procesando GET para RequestMapping /eliminarCriterio GET ");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            CriterioDTO criterio = new CriterioDTO();
            criterio.setIdCriterio(idCriterio);
            criterio.setCodTrazabilidad(codTrazabilidad);
            criterioService.eliminarCriterio(criterio);
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_DELETE,ConstantesWeb.mensajes.MSG_ENTITY_CRITERIO);
            salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_DELETE,ConstantesWeb.mensajes.MSG_ENTITY_CRITERIO);
            salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
//            salida.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
        }
        return salida;
    }
    @RequestMapping(value = "/eliminarCriterioAsociado", method = RequestMethod.GET)
    public @ResponseBody 
        Map<String, Object> eliminarCriterioAsociado(Long idCriterio, String codTrazabilidad ,HttpServletRequest request, HttpSession session){
        LOG.info("procesando GET para RequestMapping /eliminarCriterio GET ");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            ObliTipiDTO criterio = new ObliTipiDTO();
            criterio.setIdObliTipiCriterio(idCriterio);

          //setear usuario
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            obliTipiServiceNeg.eliminarRelacion(criterio,usuarioDTO);            
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_DELETE,ConstantesWeb.mensajes.MSG_ENTITY_CRITERIO);
            salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_DELETE,ConstantesWeb.mensajes.MSG_ENTITY_CRITERIO);
            salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
//            salida.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
        }
        return salida;
    }


    @SuppressWarnings("unchecked")
    private List<DetalleCriterioDTO> getListDetalleCriterio(HttpSession sesion) {
        List<DetalleCriterioDTO> listaDetalleCriterio = (List<DetalleCriterioDTO>) sesion.getAttribute("LISTA_DETALLE_CRITERIO");
        if(listaDetalleCriterio == null){
            listaDetalleCriterio = new ArrayList<DetalleCriterioDTO>();
        }
	return listaDetalleCriterio;
    }
    
    private void setListDetalleCriterio(HttpSession sesion, List<DetalleCriterioDTO> listaDetalleCriterio) {
	sesion.setAttribute("LISTA_DETALLE_CRITERIO", listaDetalleCriterio);
    }
    /**
     * 
     * @param codSancionEspecifica
     * @param descSancionEspecifica
     * @param codigoCriterio
     * @param codigoTipificacion
     * @param sancionEspecifica
     * @param codigoObligacion
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping(value = "/registrarSancionEspecifica", method = RequestMethod.POST)
    public @ResponseBody 
        Map<String, Object> registrarSancionEspecifica(Long idCriterio, String descSancionEspecifica,String codTrazabilidad,
                 HttpServletRequest request, HttpSession session){
        LOG.info("procesando POST para RequestMapping /registrarSancionEspecifica POST ");
        LOG.info("-- descSancionEspecifica = "+descSancionEspecifica);
        LOG.info("-- idCriterio = "+idCriterio);
        
        Map<String, Object> salida = new HashMap<String, Object>();
        try{
            DetalleCriterioDTO detalleCriterio = new DetalleCriterioDTO();
            detalleCriterio.setSancionEspecifica(descSancionEspecifica);
            detalleCriterio.setCodTrazabilidad(codTrazabilidad);
            if(idCriterio.intValue() > 0){
                detalleCriterio.setIdCriterio(idCriterio);
                UsuarioDTO usuario = getUsuario(session);
                criterioService.guardaDetalleCriterio(detalleCriterio, usuario);
            }else{
                List<DetalleCriterioDTO> listaDetalleCriterio = getListDetalleCriterio(session);
                detalleCriterio.setIdDetalleCriterio(new Long((listaDetalleCriterio.size() + 1)*-1));
                listaDetalleCriterio.add(detalleCriterio);
                setListDetalleCriterio(session, listaDetalleCriterio);
            }
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            LOG.error("Error al Registrar Detalle Criterio Controller: "+ex.getMessage());
            ex.printStackTrace();
            salida.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
        
        return salida;
    }
    
    @RequestMapping(value = "/eliminarSancionEspecifica", method = RequestMethod.GET)
    public @ResponseBody 
        Map<String, Object> eliminarSancionEspecifica(String idCriterio, Long idDetalleCriterio,String codTrazabilidad, HttpServletRequest request, HttpSession session){
        LOG.info("procesando GET para RequestMapping /eliminarSancionEspecifica GET ");
        LOG.info("-- idDetalleCriterio = "+idDetalleCriterio);
        LOG.info("-- idCriterio = "+idCriterio);
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            if(idCriterio != null && idCriterio !=  ""){
                DetalleCriterioDTO detalleCriterio=new DetalleCriterioDTO();
                detalleCriterio.setIdDetalleCriterio(idDetalleCriterio);
                detalleCriterio.setCodTrazabilidad(codTrazabilidad);
                criterioService.eliminarDetalleCriterio(detalleCriterio);                
            }else{
                DetalleCriterioDTO detalleCriterioDelete = null;
                List<DetalleCriterioDTO> listaDetalleCriterio = getListDetalleCriterio(session);
                for (DetalleCriterioDTO detalleCriterioDTO : listaDetalleCriterio) {
                    if(detalleCriterioDTO.getIdDetalleCriterio().equals(idDetalleCriterio)){
                        detalleCriterioDelete = detalleCriterioDTO;
                    }
                }
                if(detalleCriterioDelete != null ){
                    listaDetalleCriterio.remove(detalleCriterioDelete);
                    setListDetalleCriterio(session, listaDetalleCriterio);
                }
            }
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        } catch (Exception e) {
           e.printStackTrace();
           salida.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
           salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
      
        return salida;
    }
    
    @RequestMapping(value = "/findSancionEspecifica", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> findSancionEspecifica(Long idCriterio, int rows, int page, String sidx,
            String sord, HttpSession session){
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        LOG.info("procesando GET para RequestMapping /findSancionEspecifica");
        LOG.info("-- idCriterio = "+idCriterio);
      
        List<DetalleCriterioDTO> listaDetalleCriterio;
        if(idCriterio.intValue() > 0){
            listaDetalleCriterio = criterioService.listarDetalleCriterio(new Long(idCriterio));
        }else{
            listaDetalleCriterio = getListDetalleCriterio(session);
        }
        Long contador = new Long(listaDetalleCriterio.size());
        int indiceInicial = (page - 1) * rows;
        int indiceFinal = indiceInicial + rows;
        List<DetalleCriterioDTO> listaDetalleCriterioPaginada = new ArrayList<DetalleCriterioDTO>();
        listaDetalleCriterioPaginada = listaDetalleCriterio.subList(
                indiceInicial, indiceFinal > listaDetalleCriterio
                .size() ? listaDetalleCriterio.size()
                : indiceFinal);
        Long numeroFilas = (contador / rows);
        if ((contador % rows) > 0) {
            numeroFilas = numeroFilas + 1L;
        }
        listaResultado.put("total", numeroFilas);
        listaResultado.put("pagina", page);
        listaResultado.put("registros", contador);
        listaResultado.put("filas", listaDetalleCriterioPaginada);
        return listaResultado;
    }
    
    
    @SuppressWarnings("unchecked")
    private List<DetalleDocumentoCriterioDTO> getListDetalleDocumentoCriterio(HttpSession sesion) {
        List<DetalleDocumentoCriterioDTO> listaDetalleDocumentoCriterio = (List<DetalleDocumentoCriterioDTO>) sesion.getAttribute("LISTA_DETALLE_DOCUMENTO_CRITERIO");
        if(listaDetalleDocumentoCriterio == null){
            listaDetalleDocumentoCriterio = new ArrayList<DetalleDocumentoCriterioDTO>();
        }
	return listaDetalleDocumentoCriterio;
    }
    
    private void setListDetalleDocumentoCriterio(HttpSession sesion, List<DetalleDocumentoCriterioDTO> listaDetalleDocumentoCriterio) {
	sesion.setAttribute("LISTA_DETALLE_DOCUMENTO_CRITERIO", listaDetalleDocumentoCriterio);
    }
    
    @RequestMapping(value = "/registrarArchivoCriterio", method = RequestMethod.POST)
    public @ResponseBody 
        Map<String, Object> registrarArchivoCriterio(Long idCriterio, String nombreArchivo,
                 HttpServletRequest request, HttpSession session){
        LOG.info("procesando POST para RequestMapping /registrarSancionEspecifica POST ");
        LOG.info("-- nombreArchivo = "+nombreArchivo);
        LOG.info("-- idCriterio = "+idCriterio);
        
        Map<String, Object> salida = new HashMap<String, Object>();
        try{
            DocumentoAdjuntoDTO archivoDTO = (DocumentoAdjuntoDTO)session.getAttribute(Constantes.CONSTANTE_ARCHIVO_CRITERIO);
            
            DetalleDocumentoCriterioDTO detalleDocumentoCriterio = new DetalleDocumentoCriterioDTO();
            detalleDocumentoCriterio.setTitulo(nombreArchivo);
            detalleDocumentoCriterio.setDocumento(archivoDTO);
            if(idCriterio.intValue() > 0){
                UsuarioDTO usuario = getUsuario(session);
                detalleDocumentoCriterio.setIdCriterio(idCriterio);
                criterioService.guardaDetalleDocumentoCriterio(detalleDocumentoCriterio, usuario);
            }else{
                List<DetalleDocumentoCriterioDTO> listaDetalleDocumentoCriterio = getListDetalleDocumentoCriterio(session);
                detalleDocumentoCriterio.setIdDetalleDocumentoCriterio(new Long((listaDetalleDocumentoCriterio.size()+1)*-1));
                listaDetalleDocumentoCriterio.add(detalleDocumentoCriterio);
                setListDetalleDocumentoCriterio(session, listaDetalleDocumentoCriterio);
            }
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            LOG.error("Error al Registrar Detalle Criterio Controller: "+ex.getMessage());
            ex.printStackTrace();
            salida.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
        
        return salida;
    }
    
    @RequestMapping(value = "/findArchivoCriterio", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> findArchivoCriterio(Long idCriterio, int rows, int page, String sidx,
            String sord, HttpSession session){
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        LOG.info("procesando GET para RequestMapping /findArchivoCriterio");
        LOG.info("-- idCriterio = "+idCriterio);
      
        List<DetalleDocumentoCriterioDTO> listaDetalleDocumentoCriterio;
        if(idCriterio.intValue() > 0 ){
            listaDetalleDocumentoCriterio = new ArrayList<DetalleDocumentoCriterioDTO>();
            listaDetalleDocumentoCriterio = criterioService.listarDetalleDocumentoCriterio(new Long(idCriterio));
        }else{
            listaDetalleDocumentoCriterio = getListDetalleDocumentoCriterio(session);
        }
        Long contador = new Long(listaDetalleDocumentoCriterio.size());
        int indiceInicial = (page - 1) * rows;
        int indiceFinal = indiceInicial + rows;
        List<DetalleDocumentoCriterioDTO> listaDetalleDocumentoCriterioPaginada = new ArrayList<DetalleDocumentoCriterioDTO>();
        listaDetalleDocumentoCriterioPaginada = listaDetalleDocumentoCriterio.subList(
                indiceInicial, indiceFinal > listaDetalleDocumentoCriterio
                .size() ? listaDetalleDocumentoCriterio.size()
                : indiceFinal);
        Long numeroFilas = (contador / rows);
        if ((contador % rows) > 0) {
            numeroFilas = numeroFilas + 1L;
        }
        listaResultado.put("total", numeroFilas);
        listaResultado.put("pagina", page);
        listaResultado.put("registros", contador);
        listaResultado.put("filas", listaDetalleDocumentoCriterioPaginada);
        return listaResultado;
    }
    
    @RequestMapping(value = "/eliminarArchivoCriterio", method = RequestMethod.GET)
    public @ResponseBody 
        Map<String, Object> eliminarArchivoCriterio(String idCriterio, Long idDetalleDocumentoCriterio, HttpServletRequest request, HttpSession session){
        LOG.info("procesando GET para RequestMapping /eliminarArchivoCriterio GET ");
        LOG.info("-- idDetalleDocumentoCriterio = "+idDetalleDocumentoCriterio);
        LOG.info("-- idCriterio = "+idCriterio);
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            if(idCriterio != null && idCriterio !=  ""){
                UsuarioDTO usuarioDTO = getUsuario(session);
                criterioService.eliminarDetalleDocumentoCriterio(idDetalleDocumentoCriterio,usuarioDTO);                
            }else{
                DetalleDocumentoCriterioDTO detalleDocumentoCriterioDelete = null;
                List<DetalleDocumentoCriterioDTO> listaDetalleDocumentoCriterio = getListDetalleDocumentoCriterio(session);
                for (DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO : listaDetalleDocumentoCriterio) {
                    if(detalleDocumentoCriterioDTO.getIdDetalleDocumentoCriterio().equals(idDetalleDocumentoCriterio)){
                        detalleDocumentoCriterioDelete = detalleDocumentoCriterioDTO;
                    }
                }
                if(detalleDocumentoCriterioDelete != null ){
                    listaDetalleDocumentoCriterio.remove(detalleDocumentoCriterioDelete);
                    setListDetalleDocumentoCriterio(session, listaDetalleDocumentoCriterio);
                }
            }
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        } catch (Exception e) {
           e.printStackTrace();
           salida.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
           salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
      
        return salida;
    }
    
    @RequestMapping(value="/descargaArchivoCriterio",method= RequestMethod.GET)
    public void descargaArchivoCriterio( Long idDetalleDocumentoCriterio, HttpServletResponse response, HttpSession session) {
        LOG.info("procesando GET para RequestMapping /descargaArchivoCriterio GET ");
        LOG.info("-- idDetalleDocumentoCriterio = "+idDetalleDocumentoCriterio);
        InputStream is = null;
        String nombreArchivo = "";
        List<DetalleDocumentoCriterioDTO> listaDetalleDocumentoCriterio = getListDetalleDocumentoCriterio(session);
        for (DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO : listaDetalleDocumentoCriterio) {
            if(detalleDocumentoCriterioDTO.getIdDetalleDocumentoCriterio().equals(idDetalleDocumentoCriterio)){
                DocumentoAdjuntoDTO documentoAdjunto = detalleDocumentoCriterioDTO.getDocumento();
                byte[] data = documentoAdjunto.getRutaAlfrescoTmp();
                is = new ByteArrayInputStream(data);
                nombreArchivo = documentoAdjunto.getNombreArchivo();
                break;
            }
        }
        try {        	
            if(is==null){
    	        response.getWriter().write("ERROR: AL DESCARGAR ARCHIVO..!!");
    		return;
            }       	
            String nombreFichero = nombreArchivo;        	
            response.setHeader("Content-Disposition", "attachment; filename=\"" 
                    + nombreFichero+ "\"");
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        }catch (Exception ex) {
            LOG.info("--->"+ex.getMessage());
            LOG.info("Error writing file to output stream. Filename was '" + nombreArchivo + "'");
            throw new RuntimeException("IOError writing file to output stream");
        }        
    }
    
    @RequestMapping(value="/descargaArchivoObligacion",method= RequestMethod.GET)
    public void descargaArchivoObligacion(HttpServletResponse response, HttpSession session) {
        LOG.info("procesando GET para RequestMapping /descargaArchivoObligacion GET ");
        InputStream is = null;
        String nombreArchivo = "";
        DocumentoAdjuntoDTO documentoAdjunto = (DocumentoAdjuntoDTO)session.getAttribute(Constantes.CONSTANTE_ARCHIVO_OBLIGACION);
        byte[] data = documentoAdjunto.getRutaAlfrescoTmp();
        is = new ByteArrayInputStream(data);
        nombreArchivo = documentoAdjunto.getNombreArchivo();
        try {        	
            if(is==null){
    	        response.getWriter().write("ERROR: AL DESCARGAR ARCHIVO..!!");
    		return;
            }       	
            String nombreFichero = nombreArchivo;        	
            response.setHeader("Content-Disposition", "attachment; filename=\"" 
                    + nombreFichero+ "\"");
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        }catch (Exception ex) {
            LOG.info("--->"+ex.getMessage());
            LOG.info("Error writing file to output stream. Filename was '" + nombreArchivo + "'");
            throw new RuntimeException("IOError writing file to output stream");
        }        
    }
    @RequestMapping(value="/descargaArchivoNormaLegal",method= RequestMethod.GET)
    public void descargaArchivoNormaLegal(HttpServletResponse response, HttpSession session) {
        LOG.info("procesando GET para RequestMapping /descargaArchivoNormaLegal GET ");
        InputStream is = null;
        String nombreArchivo = "";
        List<DocumentoAdjuntoDTO> ListadocumentoAdjunto = (List<DocumentoAdjuntoDTO>)session.getAttribute(Constantes.CONSTANTE_ARCHIVO_BASE_LEGAL);
        DocumentoAdjuntoDTO documentoAdjunto = ListadocumentoAdjunto.get(0);
        byte[] data = documentoAdjunto.getRutaAlfrescoTmp();
        is = new ByteArrayInputStream(data);
        nombreArchivo = documentoAdjunto.getNombreArchivo();
        try {        	
            if(is==null){
    	        response.getWriter().write("ERROR: AL DESCARGAR ARCHIVO..!!");
    		return;
            }       	
            String nombreFichero = nombreArchivo;        	
            response.setHeader("Content-Disposition", "attachment; filename=\"" 
                    + nombreFichero+ "\"");
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        }catch (Exception ex) {
            LOG.info("--->"+ex.getMessage());
            LOG.info("Error writing file to output stream. Filename was '" + nombreArchivo + "'");
            throw new RuntimeException("IOError writing file to output stream");
        }        
    }
    
    @RequestMapping(value="/descargaArchivoDescripcion",method= RequestMethod.GET)
    public void descargaArchivoDescripcion(HttpServletResponse response, HttpSession session) {
        LOG.info("procesando GET para RequestMapping /descargaArchivoDescripcion GET ");
        InputStream is = null;
        String nombreArchivo = "";
        DocumentoAdjuntoDTO documentoAdjunto = (DocumentoAdjuntoDTO)session.getAttribute(Constantes.CONSTANTE_ARCHIVO_DESCRIPCON);
        byte[] data = documentoAdjunto.getRutaAlfrescoTmp();
        is = new ByteArrayInputStream(data);
        nombreArchivo = documentoAdjunto.getNombreArchivo();
        try {        	
            if(is==null){
    	        response.getWriter().write("ERROR: AL DESCARGAR ARCHIVO..!!");
    		return;
            }       	
            String nombreFichero = nombreArchivo;        	
            response.setHeader("Content-Disposition", "attachment; filename=\"" 
                    + nombreFichero+ "\"");
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        }catch (Exception ex) {
            LOG.info("--->"+ex.getMessage());
            LOG.info("Error writing file to output stream. Filename was '" + nombreArchivo + "'");
            throw new RuntimeException("IOError writing file to output stream");
        }        
    }
    /*PR OSINE_119 - Item 11 - Inicio*/
    /**
     * Método que permite descargar un archivo del alfresco
     * @param response
     * @param session
     */
    @RequestMapping(value="/descargaArchivoInfraccion",method= RequestMethod.GET)
    public void descargaArchivoInfraccion(HttpServletResponse response, HttpSession session) {
        LOG.info("procesando GET para RequestMapping /descargaArchivoInfracion GET ");
        InputStream is = null;
        String nombreArchivo = "";
        DocumentoAdjuntoDTO documentoAdjunto = (DocumentoAdjuntoDTO)session.getAttribute(Constantes.CONSTANTE_ARCHIVO_INFRACCION);
        byte[] data = documentoAdjunto.getRutaAlfrescoTmp();
        is = new ByteArrayInputStream(data);
        nombreArchivo = documentoAdjunto.getNombreArchivo();
        try {        	
            if(is==null){
    	        response.getWriter().write("ERROR: AL DESCARGAR ARCHIVO..!!");
    		return;
            }       	
            String nombreFichero = nombreArchivo;        	
            response.setHeader("Content-Disposition", "attachment; filename=\"" 
                    + nombreFichero+ "\"");
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        }catch (Exception ex) {
            LOG.info("--->"+ex.getMessage());
            LOG.info("Error writing file to output stream. Filename was '" + nombreArchivo + "'");
            throw new RuntimeException("IOError writing file to output stream");
        }        
    }
    /*PR OSINE_119 - Item 11 - Fin*/
    @RequestMapping(value = "/cleanDatosCriterio", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> cleanDatosCriterio(HttpServletRequest request, HttpSession sesion, Model model) {
        LOG.info("MantenimientoBaseLegalController -- cleanDatosCriterio");
        sesion.setAttribute("LISTA_DETALLE_CRITERIO", new ArrayList<DetalleCriterioDTO>());
        sesion.setAttribute("LISTA_DETALLE_DOCUMENTO_CRITERIO", new ArrayList<DetalleDocumentoCriterioDTO>());
        sesion.setAttribute("MAPA_ARCHIVOS_CRITERIO", new HashMap<Long, DocumentoAdjuntoDTO>());
        Map<String, Object> salida = new HashMap<String, Object>();
        salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        return salida;
    }
    
    @RequestMapping(value = "/findCriterio", method = RequestMethod.GET)
    public @ResponseBody
        Map<String, Object> findCriterio(int rows, int page, String sidx,
            String sord, Long idObligacion, HttpSession session){

        Map<String, Object> map = new HashMap<String, Object>();
        LOG.info("procesando GET para RequestMapping /findCriterio ");
        LOG.info("-- idObligacion = " + idObligacion);
        
        CriterioDTO criterio = new CriterioDTO();
        criterio.setIdObligacion(idObligacion);
        List<CriterioDTO> listaCriterio = criterioService.listarCriterio(criterio);
        Long contador = new Long(listaCriterio.size());
        int indiceInicial = (page - 1) * rows;
        int indiceFinal = indiceInicial + rows;
        List<CriterioDTO> listaCriterioPaginada = new ArrayList<CriterioDTO>();
        listaCriterioPaginada = listaCriterio.subList(
                indiceInicial, indiceFinal > listaCriterio
                .size() ? listaCriterio.size()
                : indiceFinal);
        Long numeroFilas = (contador / rows);
        if ((contador % rows) > 0) {
            numeroFilas = numeroFilas + 1L;
        }
        map.put("total", numeroFilas);
        map.put("pagina", page);
        map.put("registros", contador);
        map.put("filas", listaCriterioPaginada);
        return map;
    }
    @RequestMapping(value = "/findObliTipiCriterio", method = RequestMethod.GET)
    public @ResponseBody
        Map<String, Object> findObliTipiCriterio(int rows, int page, String sidx,
            String sord, Long idObligacion, HttpSession session){

        Map<String, Object> map = new HashMap<String, Object>();
        LOG.info("procesando GET para RequestMapping /findCriterio ");
        LOG.info("-- idObligacion = " + idObligacion);
        
        ObliTipiDTO obliTipiDTO = new ObliTipiDTO();
        obliTipiDTO.setIdObligacion(idObligacion);
        List<ObliTipiDTO> listaRelaciones = obliTipiServiceNeg.obtenerRelaciones(obliTipiDTO);
        Long contador = new Long(listaRelaciones.size());
        int indiceInicial = (page - 1) * rows;
        int indiceFinal = indiceInicial + rows;
        List<ObliTipiDTO> listaCriterioPaginada = new ArrayList<ObliTipiDTO>();
        listaCriterioPaginada = listaRelaciones.subList(
                indiceInicial, indiceFinal > listaRelaciones
                .size() ? listaRelaciones.size()
                : indiceFinal);
        Long numeroFilas = (contador / rows);
        if ((contador % rows) > 0) {
            numeroFilas = numeroFilas + 1L;
        }
        map.put("total", numeroFilas);
        map.put("pagina", page);
        map.put("registros", contador);
        map.put("filas", listaCriterioPaginada);
        return map;
    }
    
    @RequestMapping(value = "/findDetalleCriterio", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> findDetalleCriterio(int rows, int page, String sidx, String sord, Long idCriterio, HttpSession session){
        LOG.info("procesando GET para RequestMapping /findDetalleCriterio ");
        LOG.info("-- idCriterio = " + idCriterio);
        
	Map<String, Object> map = new HashMap<String, Object>();
        List<DetalleCriterioDTO> listaDetalleCriterio = criterioService.listarDetalleCriterio(idCriterio);
        Long contador = new Long(listaDetalleCriterio.size());
        int indiceInicial = (page - 1) * rows;
        int indiceFinal = indiceInicial + rows;
        List<DetalleCriterioDTO> listaDetalleCriterioPaginada = new ArrayList<DetalleCriterioDTO>();
        listaDetalleCriterioPaginada = listaDetalleCriterio.subList(
                indiceInicial, indiceFinal > listaDetalleCriterio
                .size() ? listaDetalleCriterio.size()
                : indiceFinal);
        Long numeroFilas = (contador / rows);
        if ((contador % rows) > 0) {
            numeroFilas = numeroFilas + 1L;
        }
        map.put("total", numeroFilas);
        map.put("pagina", page);
        map.put("registros", contador);
        map.put("filas", listaDetalleCriterioPaginada);
        return map;
    }
    
    /**
     * @param codigoEliminarBaseLegal
     * @param baseLegalDTO
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping(value = "/eliminarBaseLegal", method = RequestMethod.GET)
    public @ResponseBody 
        Map<String, Object> eliminarBaseLegal(String codigoEliminarBaseLegal,BaseLegalDTO baseLegalDTO, HttpServletRequest request, HttpSession session){
        LOG.info("procesando GET para RequestMapping /eliminar GET ");
        Map<String, Object> salida = new HashMap<String, Object>();
        List<BaseLegalDTO> listadoBaseLegal =(List<BaseLegalDTO>) request.getSession().getServletContext().getAttribute("LISTA_BASES_LEGALES");
        try {
            if(listadoBaseLegal.size()>0){
            for(BaseLegalDTO baseLegal:listadoBaseLegal){
                
                    if(baseLegal.getCodigoBaseLegal().equals(codigoEliminarBaseLegal)){
                        int index=listadoBaseLegal.indexOf(baseLegal);
                        listadoBaseLegal.remove(index);
                        salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                    }
                
            }
        }else{
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        return salida;
    }
    
    /**
     * <-- Produccion -->
     * @param baseLegalDTO
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "/registrarBaseLegal", method = RequestMethod.POST)
    public @ResponseBody 
        Map<String, Object> registrar(BaseLegalDTO baseLegalDTO,HttpServletRequest request, HttpSession session){
        LOG.info("Registrar Base Legal Controller <--> ");
        Map<String, Object> salida = new HashMap<String, Object>();
        
        try{
        	List<BaseLegalDTO> baseLegal = new ArrayList<BaseLegalDTO>();
        	BaseLegalFilter filtro = new BaseLegalFilter();
        	filtro.setDescripcion(baseLegalDTO.getDescripcionGeneralBaseLegal());
        	if (baseLegalDTO.getFlagPadre() != null ){
        	  baseLegal = baseLegalService.verificarBaseLegalExistente(filtro);
        	}
        	if (baseLegal.size() == 0){
                if(baseLegalDTO.getNumeroNormaLegal()!=null && !baseLegalDTO.getNumeroNormaLegal().equals("")){
                	UsuarioDTO usuarioDTO = getUsuario(session);
                    
                    /* creado jpiro 20150107 - inicio */
                    GuardarDocumentoAdjuntoOutRO outFileAlfresco=null;
                    //si "articuloNormaLegal" es vacio entonces se evalua la subida al alfresco                    
                    String codigoBaseLegal = baseLegalService.obtenerCodigoBaseLegal(baseLegalDTO.getFlagPadre());
                    baseLegalDTO.setCodigoBaseLegal(codigoBaseLegal);
                    if(baseLegalDTO.getArticuloNormaLegal()!=null && !baseLegalDTO.getArticuloNormaLegal().equals("") ){
                        LOG.info("-->NO se sube archivo alfresco");
                        request.getSession().removeAttribute("listaArchivosBL");
                    }else{
                    	
                        LOG.info("-->SI se sube archivo alfresco");
                        List<DocumentoAdjuntoDTO> listaArchivos = ((List<DocumentoAdjuntoDTO>) request.getSession().getAttribute("listaArchivosBL"));
                        LOG.info("listaArchivos sesion-->"+listaArchivos);
                        if (listaArchivos != null && listaArchivos.size()>0) {
                            DocumentoAdjuntoDTO documento =new DocumentoAdjuntoDTO(); 
                            //genera nombre alfresco=rutaAlfrescoBD
                            int lastIndexOf = listaArchivos.get(0).getNombreArchivo().lastIndexOf(".");
                            String formato = listaArchivos.get(0).getNombreArchivo().substring(lastIndexOf);
                            String rutaAlfrescoBD = baseLegalDTO.getCodigoBaseLegal()+"_DOCUMENTO"+formato;
                            
                            File someFile = new File(rutaAlfrescoBD);
                            FileOutputStream fos = new FileOutputStream(someFile);
                            fos.write(listaArchivos.get(0).getRutaAlfrescoTmp());
                            fos.flush();
                            fos.close();
                            /* INICIO - OSINE_SFS-600 */
//                            documento.setNombreArchivo(listaArchivos.get(0).getNombreArchivo()); 
                            /* FIN -  OSINE_SFS-600 */
                            /* INICIO - OSINE_SFS-600 */
                            documento.setNombreArchivo(rutaAlfrescoBD); 
                            /* FIN -  OSINE_SFS-600 */
                            documento.setAplicacionSpace(Constantes.APPLICACION_SPACE_OBLIGACIONES);
                            
                            //GuardarDocumentoAdjuntoInRO inDoc=new GuardarDocumentoAdjuntoInRO();
                            outFileAlfresco=documentoServiceNeg.enviarDatosAlfresco(documento, someFile);
                            if (outFileAlfresco!=null && outFileAlfresco.getMensaje().equalsIgnoreCase("ok")){
                                GuardarDocumentoAdjuntoInRO inDoc=new GuardarDocumentoAdjuntoInRO();
                                documento.setRutaAlfresco(rutaAlfrescoBD);
                                documento.setIdDocumentoAdjunto(null);
                                documento.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                                inDoc.setDocumento(documento);
                                inDoc.setUsuario(usuarioDTO);

                                GuardarDocumentoAdjuntoOutRO saveDoc =documentoServiceNeg.registrarDocumentoAdjunto(inDoc);
                                
                                baseLegalDTO.setIdDocumentoAdjunto(saveDoc.getDocumento().getIdDocumentoAdjunto());	
                            }
                        }
                    }
                    /* creado jpiro 20150107 - fin */
                    
                    String estado="1";
                    baseLegalDTO.setEstado(estado);
                    String descSinEspacio = baseLegalDTO.getDescripcionGeneralBaseLegal();
                    baseLegalDTO.setDescripcionGeneralBaseLegal(descSinEspacio.trim());
                    BaseLegalDTO retorno=baseLegalService.guardaBaseLegal(baseLegalDTO,usuarioDTO);
                    //jsifuentes inicio
                    retorno.setListaBasesLegales(baseLegalDTO.getListaBasesLegales());
                    //jsifuentes fin
                    LOG.info("(Registra Base Legal) retorno: "+retorno.getCodigoBaseLegal());                
//                   String mensaje=controlMessagesEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE,ConstantesWeb.mensajes.MSG_ENTITY_BASELEGAL,retorno.getCodigoBaseLegal());
                    String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE,ConstantesWeb.mensajes.MSG_ENTITY_BASELEGAL);
    // 05-11-2015                
                    String codigoTrazabilidad = generarCodTrazabilidad();
                    salida.put("baseLegal", retorno);
                    salida.put("codTrazabilidad",codigoTrazabilidad);
    // 05-11-2015
                    salida.put("codigoBaseLegal", retorno.getCodigoBaseLegal());
                    salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                    salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
                }else{
                    salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ADVERTENCIA);
                    String mensaje="Campo Número es Obligatorio";
                    salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
                }
                //Eliminar el documento adjunto de la session
                request.getSession().removeAttribute("listaArchivosBL");
        	}
        	else{
        		salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                String mensaje="Norma Legal ya ingresada verifique y modifique la informaci&oacute;n a registrar";
                salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
        	}
        }catch(Exception e){
        	String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE,ConstantesWeb.mensajes.MSG_ENTITY_BASELEGAL);
        	salida.put(ConstantesWeb.VV_RESULTADO, 3);        	
        	salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
            LOG.error("Error al Registrar Base Legal Controller: "+e.getMessage());
            e.printStackTrace();
        }
        
        return salida;
    }
    /**
     * <-- Produccion -->
     * @param obligacionNormativaDTO
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping(value = "/registrarObligacionNormativa", method = RequestMethod.POST)
    public @ResponseBody 
        Map<String, Object> registrarObligacion(ObligacionNormativaDTO obligacionNormativaDTO,HttpServletRequest request, HttpSession session){
    	LOG.info("Registrar Obligacion Controller <--> ");
        Map<String, Object> salida = new HashMap<String, Object>();
        TipificacionDTO retornoTipificacion = null;
        try{
            String estado="1";
            obligacionNormativaDTO.setEstado(estado);
            UsuarioDTO usuarioDTO = getUsuario(session);
            DocumentoAdjuntoDTO archivoDTO = (DocumentoAdjuntoDTO)session.getAttribute(Constantes.CONSTANTE_ARCHIVO_OBLIGACION);
            obligacionNormativaDTO.setDocumentoAdjunto(archivoDTO);
            if(obligacionNormativaDTO.getIdObligacion()!=null && !obligacionNormativaDTO.getIdObligacion().toString().equals("")){
                // Si Obligacion ya Existe se Actualiza
                LOG.info("id: "+obligacionNormativaDTO.getIdObligacion());
                ObligacionNormativaDTO retorno=obligacionNormativaService.updateObligacion(obligacionNormativaDTO,usuarioDTO);
                LOG.info("(Actualiza Obligacion) retorno: "+retorno);

                String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_UPDATE, ConstantesWeb.mensajes.MSG_ENTITY_OBLIGACION);
                salida.put(ConstantesWeb.VV_MENSAJE, mensaje);	
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            }else{
                //Si la Obligación no Existe se Crea uno Nuevo
                LOG.info("id: "+obligacionNormativaDTO.getIdObligacion());
                ObligacionNormativaDTO retorno=obligacionNormativaService.guardaObligacion(obligacionNormativaDTO,usuarioDTO);
                LOG.info("(Registra Obligacion) retorno: "+retorno);

                String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE, ConstantesWeb.mensajes.MSG_ENTITY_OBLIGACION);
                salida.put("idObligacion",retorno.getIdObligacion());
                salida.put("codigoObligacion",retorno.getCodigoObligacion());
                salida.put("idDetalleObligacion", retorno.getIdDetalleObligacion());
                salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            }
//            session.removeAttribute(Constantes.CONSTANTE_ARCHIVO_OBLIGACION);
            
        }catch(Exception e){
            LOG.error("Error al Registrar Obligacion Controller: "+e.getMessage());
            e.printStackTrace();
        }
        return salida;
    }
    
    /**
     * <-- Produccion -->
     * @param request
     * @param sesion
     * @param model
     * @return 
     */
    @RequestMapping(value = "/cleanDatosObligacionArchivo", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> cleanDatosObligacionArchivo(HttpServletRequest request, HttpSession sesion, Model model) {
        LOG.info("MantenimientoBaseLegalController -- cleanDatosObligacionArchivo");
        sesion.removeAttribute(Constantes.CONSTANTE_ARCHIVO_OBLIGACION);
        Map<String, Object> salida = new HashMap<String, Object>();
        salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        return salida;
    }
    
    /**
     * <-- Produccion -->
     * @param obligacionNormativaDTO
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping(value = "/consultarObligacionNormativa", method = RequestMethod.POST)
    public @ResponseBody 
        Map<String, Object> consultarObligacionNormativa(Long idObligacion){
    	LOG.info("Actualizar Obligacion Controller <--> " +idObligacion);
        Map<String, Object> salida = new HashMap<String, Object>();
        
        try{
        	String listaTemas = null; 
        	DocumentoAdjuntoDTO documento=null;
        	DocumentoAdjuntoDTO documentoDetalle=null;
        	ObligacionNormativaDTO retorno=obligacionNormativaService.consultaObligacionById(idObligacion);
        	LOG.info("(Consultar Obligacion) retorno: "+retorno.toString());

        	DetalleObligacionDTO retornoDetalle=obligacionNormativaService.consultaDetalleObligacionById(idObligacion);
        	LOG.info("(Consultar Detalle Obligacion) retornoDetalle: "+retornoDetalle);
        	
        	List<TemaDTO> retornoTema= obligacionNormativaService.consultaTemaByObligacionId(idObligacion);
        	
        	/*PR OSINE_119 - Item 14 - Inicio*/        	
        	InfraccionDTO retornoInfraccionDTO= obligacionNormativaService.consultaInfraccionByObligacionId(idObligacion);
        	/*PR OSINE_119 - Item 14 - Fin*/
        	if(retorno.getIdDocumentoAdjunto()!=null){
               documento=documentoServiceNeg.consultarDatosAlfresco(retorno.getIdDocumentoAdjunto());
               LOG.info("idDocumento: "+retorno.getIdDocumentoAdjunto());
            }
        	if(retornoDetalle!=null){
        		if(retornoDetalle.getIdDocumentoAdjunto()!=null){
            		documentoDetalle=documentoServiceNeg.consultarDatosAlfresco(retornoDetalle.getIdDocumentoAdjunto());
                    LOG.info("idDocumento: "+retornoDetalle.getIdDocumentoAdjunto());
                 }
        	}

        	if(retornoTema!=null && retornoTema.size()>0){
                String[] s = new String[retornoTema.size()];
                int cont=0;
                for(TemaDTO maestra : retornoTema){s[cont]=maestra.getIdTemaObligacion().toString();cont++;}
                listaTemas= StringUtils.join(s, ", ");
            } 
        	
        	String idRubros = "";         	
        	ObligacionFilter filtro = new ObligacionFilter();
        	int[] auxiliar=new int[1];
        	filtro.setIdObligacion(idObligacion);
        	List<CnfObligacionDTO> cnfObligacionDTOs= obligacionNormativaService.findObligacionById(filtro, auxiliar);
        	
        	if(cnfObligacionDTOs!=null){ 
        		
        	idRubros=MycUtil.concatenaListadoActividades(cnfObligacionDTOs);
        	
        	}
        	/*PR OSINE_119 - Item 16 - Inicio*/
        	List<OpcionDTO> listaOpciones=obligacionNormativaService.obtenerOpciones(idRubros);
        	/*PR OSINE_119 - Item 16 - Fin*/
        	if (listaOpciones!=null){        		
        		salida.put("countOpc",listaOpciones.size());
        		for (int i = 0; i < listaOpciones.size(); i++) {
        			salida.put("opcion"+i,listaOpciones.get(i).getIdentificador_opcion() );        			                	
				}        	
        	}
        	        	        	
            salida.put("obligacion",retorno);
            salida.put("detalleObligacion",retornoDetalle);
            salida.put("documento",documento);
            salida.put("documentoDetalle", documentoDetalle);
            salida.put("listaTema", listaTemas);
            /*PR OSINE_119 - Item 16 - Inicio*/
            salida.put("idInfraccion", retornoInfraccionDTO);
            /*PR OSINE_119 - Item 16 - Fin*/
        	salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception e){
            LOG.error("Error al Consultar Obligacion Controller: "+e.getMessage());
            e.printStackTrace();
        }
        return salida;
    }
    /**
     * <-- Produccion -->
     * @param baseLegalDTO
     * @return 
     */
    @RequestMapping(value = "/eliminaBaseLegal", method = RequestMethod.GET)
    public @ResponseBody 
        Map<String, Object> eliminaBaseLegal(BaseLegalDTO baseLegalDTO,HttpSession session){
        LOG.info("Eliminar Base Legal Controller <--> ");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
        	
        	UsuarioDTO usuarioDTO = getUsuario(session);
        	
        	baseLegalDTO.setEstado("0");
        	BaseLegalDTO retorno=baseLegalService.eliminarBaseLegal(baseLegalDTO,usuarioDTO);
        	
        	
        	/* OSINE_SFS-600 - REQF-0012 - Inicio */
        	try{
        		prioridadNormaAgenteNeg.eliminarPrioridadNormaAgente(baseLegalDTO.getIdBaseLegal(), Constantes.ELIMINAR_ORDEN_NORMA_ID_BASE_LEGAL, usuarioDTO);
        	}catch(Exception e){
        		LOG.error("borrar prioridad norma agente",e);
        	}
        	/* OSINE_SFS-600 - REQF-0012 - Fin */
        	
        	String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_DELETE, ConstantesWeb.mensajes.MSG_ENTITY_BASELEGAL);
        	salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
        	salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        	
        } catch (Exception e) {
        	String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_DELETE, ConstantesWeb.mensajes.MSG_ENTITY_BASELEGAL);
        	salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
        	salida.put(ConstantesWeb.VV_RESULTADO, 3);
        	e.printStackTrace();
        }
      
        return salida;
    }
    /**
     * <-- Produccion -->
     * @param baseLegalDTO
     * @return
     */
    @RequestMapping(value = "/eliminaObligacion", method = RequestMethod.GET)
    public @ResponseBody 
        Map<String, Object> eliminaObligacion(Long idObligacion,HttpSession session){
        LOG.info("Eliminar Obligacion Controller <--> ");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
        	UsuarioDTO usuarioDTO = getUsuario(session);
        	
        	ObligacionNormativaDTO obligacionNormativaDTO=new ObligacionNormativaDTO();
        	obligacionNormativaDTO.setIdObligacion(idObligacion);
        	obligacionNormativaDTO.setEstado("0");
        	ObligacionNormativaDTO retorno=obligacionNormativaService.eliminarObligacion(obligacionNormativaDTO,usuarioDTO);
        	
			/* OSINE_SFS-600 - REQF-0012 - Inicio */
        	try{
        		prioridadNormaAgenteNeg.eliminarPrioridadNormaAgente(idObligacion, Constantes.ELIMINAR_ORDEN_NORMA_ID_OBLIGACION, usuarioDTO);
        	}catch(Exception e){
        		LOG.error("borrar prioridad norma agente",e);
        	}
			/* OSINE_SFS-600 - REQF-0012 - Fin */
        	
        	String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_DELETE, ConstantesWeb.mensajes.MSG_ENTITY_OBLIGACION);
        	salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
        	salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        	
        } catch (Exception e) {
        	String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_DELETE, ConstantesWeb.mensajes.MSG_ENTITY_OBLIGACION);
        	salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
        	salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            e.printStackTrace();
        }
      
        return salida;
    }
    
    /**
     * <-- Produccion -->
     * @param filtro
     * @param rows
     * @param page
     * @param session
     * @return 
     */
    @RequestMapping(value = "/listarBaseLegalConcordancia", method = RequestMethod.GET)
    public @ResponseBody
	Map<String, Object> listarBaseLegalConcordancia(BaseLegalFilter filtro,int varLista, int rows, int page, HttpSession session,HttpServletRequest request) {
		LOG.info("Funcion: listado de Bases Legales en Concordancia listarBaseLegalConcordancia codigo: "+filtro.getCodigoBaseLegal());
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
        	List<BaseLegalDTO> listado;
            int total=0 ;
            Integer cuenta;
            if(varLista==1){
	            int inicio;
	            inicio=rows*page-rows;
	            filtro.setStartIndex(inicio);
	            filtro.setResultsNumber(rows);
	            int[] auxiliar=new int[1];
	            auxiliar[0]=0;
	            LOG.info("Filtro: " + filtro + " Auxiliar:" + auxiliar);
	            listado=baseLegalService.findBaseLegalbyCodigo(filtro, auxiliar);
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
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
    }
    /**
     * <--Produccion-->
     * @param filtro
     * @param varLista
     * @param rows
     * @param page
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/listarObligacionBaseLegal", method = RequestMethod.GET)
    public @ResponseBody
	Map<String, Object> listarObligacionBaseLegal(BaseLegalFilter filtro,int varLista, int rows, int page, HttpSession session,HttpServletRequest request) {
		LOG.info("Funcion: listado de Obligaciones Asociadas a una Base Legal: "+filtro.getCodigoBaseLegal());
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
        	List<ObligacionBaseLegalDTO> listado;
        	if(filtro.getIdBaseLegal()!=null){
        		
        	int total=0 ;
            Integer cuenta;
            if(varLista==1){
	            int inicio;
	            inicio=rows*page-rows;
	            filtro.setStartIndex(inicio);
	            filtro.setResultsNumber(rows);
	            int[] auxiliar=new int[1];
	            auxiliar[0]=0;
	            LOG.info("Filtro: " + filtro + " Auxiliar:" + auxiliar);
	            listado=baseLegalService.findObligacionByBaseLegal(filtro, auxiliar);
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
        	}
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
    }
    /**
     * <--Produccion-->
     * @param filtro
     * @param varLista
     * @param rows
     * @param page
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/listarBaseLegalByObligacion", method = RequestMethod.GET)
    public @ResponseBody
	Map<String, Object> listarBaseLegalByObligacion(Long idObligacion,int varLista, int rows, int page, HttpSession session,HttpServletRequest request) {
		LOG.info("Funcion: listado de Bases Legales Asociadas a una Obligacion: "+idObligacion);
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
        	List<ObligacionBaseLegalDTO> listado;
            int total=0 ;
            Integer cuenta;
            if(varLista==1){

	            int[] auxiliar=new int[1];
	            auxiliar[0]=0;
	            LOG.info("Filtro: " + idObligacion + " Auxiliar:" + auxiliar);
	            listado=baseLegalService.findBaseLegalByObligacion(idObligacion, auxiliar);
	            LOG.info("Funcion: contador -- auxiliar: " + auxiliar);
	            
	            if(listado!=null){
	            	Long contador = new Long(listado.size());
		            int indiceInicial = (page - 1) * rows;
		            int indiceFinal = indiceInicial + rows;
		            List<ObligacionBaseLegalDTO> listaTipificacionPaginada = new ArrayList<ObligacionBaseLegalDTO>();
		            listaTipificacionPaginada = listado.subList(
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
		            listaResultado.put("filas", listaTipificacionPaginada);
	            }
            }
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
    }
    /**
     * <-- Produccion -->
     * @param descripcionNormativa
     * @param codigoObligacion
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping(value = "/registrarDetalleObligacionNormativa", method = RequestMethod.POST)
    public @ResponseBody
            Map<String, Object> registrarDetalleObligacionNormativa(String descripcionNormativa,Long idDetalleObligacion,String codigoObligacion,String codTrazabilidad,HttpServletRequest request, HttpSession session){
        Map<String, Object> salida = new HashMap<String, Object>();
        try{
            UsuarioDTO usuarioDTO = getUsuario(session);
            DocumentoAdjuntoDTO archivoDTO = (DocumentoAdjuntoDTO)session.getAttribute(Constantes.CONSTANTE_ARCHIVO_DESCRIPCON);
            
            if(idDetalleObligacion!=null && !idDetalleObligacion.equals("")){
                DetalleObligacionDTO detalleObligacionDTO = new DetalleObligacionDTO();
                detalleObligacionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                detalleObligacionDTO.setDescripcion(descripcionNormativa);
                detalleObligacionDTO.setIdObligacion(new Long(codigoObligacion));
                detalleObligacionDTO.setIdDetalleObligacion(idDetalleObligacion);
                detalleObligacionDTO.setDocumentoAdjunto(archivoDTO);
                detalleObligacionDTO.setCodTrazabilidad(codTrazabilidad);

                DetalleObligacionDTO retorno = detalleObligacionService.updateDetalleObligacion(detalleObligacionDTO, usuarioDTO);
                String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_UPDATE,ConstantesWeb.mensajes.MSG_ENTITY_OBLIGACION);
                salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            }else{

                DetalleObligacionDTO detalleObligacionDTO = new DetalleObligacionDTO();
                detalleObligacionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                detalleObligacionDTO.setDescripcion(descripcionNormativa);
                detalleObligacionDTO.setIdObligacion(new Long(codigoObligacion));
                detalleObligacionDTO.setDocumentoAdjunto(archivoDTO);
                detalleObligacionDTO.setCodTrazabilidad(codTrazabilidad);

                DetalleObligacionDTO retorno = detalleObligacionService.guardaDetalleObligacion(detalleObligacionDTO, usuarioDTO);
                LOG.info("(Registra Detalle Obligacion) retorno: "+retorno.toString());

                String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_UPDATE,ConstantesWeb.mensajes.MSG_ENTITY_OBLIGACION);
                salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                salida.put("idDetalleObligacion",retorno.getIdDetalleObligacion());
            }
        }catch(Exception e){
            LOG.error("Error al Registrar Detalle Obligacion Controller: "+e.getMessage());
            e.printStackTrace();
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_UPDATE,ConstantesWeb.mensajes.MSG_ENTITY_OBLIGACION);
            salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
        return salida;
    }
    /*PR OSINE_119 - Item 11 - Inicio*/    
    /**
     * Método que permite registrar una infracción
     * @param idAccionMaestro
     * @param idMedidaSeguridadMaestro
     * @param descripcionInfraccion
     * @param idInfraccion
     * @param codigoObligacion
     * @param codTrazabilidad
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping(value = "/registrarInfraccion", method = RequestMethod.POST)
    public @ResponseBody
        
    Map<String, Object> registrarInfraccion(String idAccionMaestro, String idMedidaSeguridadMaestro,String descripcionInfraccion,Long idInfraccion,String codigoObligacion,String codTrazabilidad,HttpServletRequest request, HttpSession session){
        Map<String, Object> salida = new HashMap<String, Object>();
        InfraccionDTO retorno = new InfraccionDTO();
        try{
        	Long idAccionMaestroTemp = Long.parseLong(idAccionMaestro);
        	Long idMedidaSeguridadMaestroTemp = Long.parseLong(idMedidaSeguridadMaestro);
            UsuarioDTO usuarioDTO = getUsuario(session);
            DocumentoAdjuntoDTO archivoDTO = (DocumentoAdjuntoDTO)session.getAttribute(Constantes.CONSTANTE_ARCHIVO_INFRACCION);
            if(idInfraccion!=null && !idInfraccion.equals("")){
                InfraccionDTO infraccionDTO = new InfraccionDTO();
                infraccionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                infraccionDTO.setIdAccionMaestro(idAccionMaestroTemp);
                infraccionDTO.setIdMedidaSeguridadMaestro(idMedidaSeguridadMaestroTemp);
                infraccionDTO.setDescripcionInfraccion(descripcionInfraccion);
                infraccionDTO.setDocumentoAdjuntoDTO(archivoDTO);                
                infraccionDTO.setCodTrazabilidad(codTrazabilidad);
                infraccionDTO.setUsuarioCreacion(usuarioDTO.getCodigo());
                infraccionDTO.setTerminalCreacion(usuarioDTO.getTerminal());
                infraccionDTO.setIdInfraccion(idInfraccion);
                retorno = infraccionServiceNeg.updateInfraccion(infraccionDTO, usuarioDTO);
                String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_UPDATE,ConstantesWeb.mensajes.MSG_ENTITY_INFRACCION);
                salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                salida.put("idInfraccion",retorno.getIdInfraccion());
                salida.put("retorno", retorno);
                
                System.out.println("Actualiza infraccion");
            }else{

                InfraccionDTO infraccionDTO = new InfraccionDTO();
                infraccionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                infraccionDTO.setDescripcionInfraccion(descripcionInfraccion);                                
                infraccionDTO.setIdAccionMaestro(idAccionMaestroTemp);
                infraccionDTO.setIdMedidaSeguridadMaestro(idMedidaSeguridadMaestroTemp);
                infraccionDTO.setDocumentoAdjuntoDTO(archivoDTO);                
                infraccionDTO.setCodTrazabilidad(codTrazabilidad);
                infraccionDTO.setUsuarioCreacion(usuarioDTO.getCodigo());
                infraccionDTO.setTerminalCreacion(usuarioDTO.getTerminal());
                PghObligacion pghObligacion = new PghObligacion();
                Long idObligaciontemp = Long.parseLong(codigoObligacion);                
                pghObligacion.setIdObligacion(idObligaciontemp);                
                infraccionDTO.setIdObligacion(pghObligacion);
                infraccionDTO.setIdObligacion2(new Long(codigoObligacion));
                
                retorno = infraccionServiceNeg.guardaInfraccion(infraccionDTO, usuarioDTO);
                LOG.info("(Registra Detalle Obligacion) retorno: "+retorno.toString());                
                String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE,ConstantesWeb.mensajes.MSG_ENTITY_INFRACCION);
                salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                salida.put("idInfraccion",retorno.getIdInfraccion());
                salida.put("retorno", retorno);
                
                System.out.println("Guarda infraccion");

            }
            request.getSession().removeAttribute(Constantes.CONSTANTE_ARCHIVO_INFRACCION);
            
        }catch(Exception e){
            LOG.error("Error al Registrar Detalle Obligacion Controller: "+e.getMessage(),e);
            e.printStackTrace();
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_UPDATE,ConstantesWeb.mensajes.MSG_ENTITY_INFRACCION);
            salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
        return salida;
    }
    /*PR OSINE_119 - Item 11 - Fin*/
    /**
     * <-- Producción -- >
     * @param codigoEditarBaseLegal
     * @param baseLegalDTO
     * @param request
     * @param session
     * @param model
     * @return 
     */
    @RequestMapping(value = "/obtenerBaseLegal", method = RequestMethod.GET)
    public String obtenerBaseLegal(Long codigoEditarBaseLegal,BaseLegalDTO baseLegalDTO, String flagBaseLegal, HttpServletRequest request, HttpSession session,Model model){
        LOG.info("procesando GET para RequestMapping /editar Gestion GET id: " + codigoEditarBaseLegal);
        BaseLegalDTO consulta = new BaseLegalDTO();
        DetalleBaseLegalDTO detalle=new DetalleBaseLegalDTO();
        List<DetalleNormaTecnicaDTO>detalleNormaTecnicaDTO = new ArrayList<DetalleNormaTecnicaDTO>();
        model.addAttribute("idDialog", "dlgMantenimientoBaseLegal");
        model.addAttribute("flagBaseLegal", flagBaseLegal);
        try {
            consulta=(BaseLegalDTO) baseLegalService.findBaseLegalbyId(codigoEditarBaseLegal);	
            String fechaVigenciaNormaLegal=convertirFechaString(consulta.getFechaEntradaVigenciaNormaLegal());
            String fechaPublicacionNormaLegal=convertirFechaString(consulta.getFechaPublicacionNormaLegal());
             
            detalle=(DetalleBaseLegalDTO) baseLegalService.findDetalleBaseLegalbyId(codigoEditarBaseLegal);
            String fechaPublicacionDetalleNormaLegal = null;
            if(detalle!=null){
                fechaPublicacionDetalleNormaLegal=convertirFechaString(detalle.getFechaEntradaVigenciaNorma());
                detalleNormaTecnicaDTO = baseLegalService.findDetalleNormaTecnicaById(detalle.getIdDetalleBaseLegal());
            }
            
            
            /**/
           //detalleNormaTecnicaDTO = baseLegalService.findDetalleNormaTecnicaById(detalle.getIdDetalleBaseLegal());            
            /**/
            model.addAttribute("baseLegal",consulta);
            model.addAttribute("detalleBaseLegal",detalle);
            model.addAttribute("fechaVigenciaNormaLegalController",fechaVigenciaNormaLegal);
            model.addAttribute("fechaPublicacionNormaLegalController",fechaPublicacionNormaLegal);
            model.addAttribute("fechaPublicacionDetalleNormaLegalController",fechaPublicacionDetalleNormaLegal);
            model.addAttribute("documentoAdjunto",consulta.getIdDocumentoAdjunto());
            if (detalleNormaTecnicaDTO != null){
            	model.addAttribute("detalleNormaTecnicaDTO",JsonUtil.convertirObjetoACadenaJson(detalleNormaTecnicaDTO));
            }else{
            	model.addAttribute("detalleNormaTecnicaDTO",JsonUtil.convertirObjetoACadenaJson(new ArrayList<DetalleNormaTecnicaDTO>()));
            }
            model.addAttribute("codTrazabilidad",generarCodTrazabilidad());
            

        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("ERROR en obtenerBaseLegal");
        }
        return "moduloObligaciones/baseLegal/mantenimiento/nuevo";
    }
    
    @RequestMapping(value = "/obtenerObligacion", method = RequestMethod.GET)
    public String obtenerObligacion(Long codigoEditarBaseLegal,BaseLegalDTO baseLegalDTO, String flagBaseLegal, HttpServletRequest request, HttpSession session,Model model){
        LOG.info("procesando GET para RequestMapping /editar Gestion GET id: " + codigoEditarBaseLegal);
        BaseLegalDTO consulta = new BaseLegalDTO();
        DetalleBaseLegalDTO detalle=new DetalleBaseLegalDTO();
        model.addAttribute("idDialog", "dlgMantenimientoBaseLegal");
        model.addAttribute("flagBaseLegal", flagBaseLegal);	
        return "moduloObligaciones/baseLegal/mantenimiento/nuevo";
    }
    
    @RequestMapping(value = "/obtenerBaseLegalPadre", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object>  obtenerBaseLegalPadre(Long idBaseLegalPadre, HttpServletRequest request, HttpSession session,Model model){
    	LOG.info("procesando GET para RequestMapping /obtener Id Padre: " + idBaseLegalPadre);
    	BaseLegalDTO baseLegal = new BaseLegalDTO();
    	Map<String, Object> retorno = new HashMap<String, Object>();
    	try {
    		String fechaVigenciaNormaLegal=null;
    		String fechaPublicacionNormaLegal=null;
    		if(idBaseLegalPadre!=null){
    			baseLegal = baseLegalService.findBaseLegalPadrebyId(idBaseLegalPadre);
        		
        		if(baseLegal.getFechaEntradaVigenciaNormaLegal()!=null){
        			fechaVigenciaNormaLegal=convertirFechaString(baseLegal.getFechaEntradaVigenciaNormaLegal());
        		}
        		if(baseLegal.getFechaPublicacionNormaLegal()!=null){
        			fechaPublicacionNormaLegal=convertirFechaString(baseLegal.getFechaPublicacionNormaLegal());
        		}
    		}
            LOG.info("Base Legal Padre: -->" + baseLegal);
            retorno.put("baseLegal", baseLegal);
            retorno.put("fechaVigencia", fechaVigenciaNormaLegal);
            retorno.put("fechaPublicacion", fechaPublicacionNormaLegal);
    		
		} catch (Exception e) {
			e.printStackTrace();
            LOG.error("ERROR en obtenerBaseLegalPadre");
		}
    	return retorno;
    }
    
    public String generarCodTrazabilidad(){
        Long seq=trazabilidadObligacionesServiceNeg.obtenerSequenceTrazaObli();
        LOG.info("---->seq="+seq);
        
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mmhhddMMyyyy");
        String prefix = DATE_FORMAT.format(today);

        String sequenceCad=org.apache.commons.lang.StringUtils.leftPad(seq.toString(), 7, "0");
        String retorno=prefix+"_"+sequenceCad;
        LOG.info("---->codTraza="+retorno);
        return retorno;
    }
    
    /**
     * <-- Produccion -->
     * @param baseLegalDTO
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "/actualizarBaseLegal", method = RequestMethod.POST)
    public @ResponseBody 
        Map<String, Object> actualizarBaseLegal(BaseLegalDTO baseLegalDTO,HttpServletRequest request, HttpSession session){
        LOG.info("procesando POST para RequestMapping /modificar POST ");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
        	if(baseLegalDTO.getNumeroNormaLegal()!=null && !baseLegalDTO.getNumeroNormaLegal().equals("")){
        		UsuarioDTO usuarioDTO = getUsuario(session);
        		GuardarDocumentoAdjuntoOutRO outFileAlfresco=null;
        		if(baseLegalDTO.getArticuloNormaLegal()!=null && !baseLegalDTO.getArticuloNormaLegal().equals("") ){
                    LOG.info("-->NO se sube archivo alfresco");
                    request.getSession().removeAttribute("listaArchivosBL");
                }else{
                    LOG.info("-->SI se sube archivo alfresco");
                    List<DocumentoAdjuntoDTO> listaArchivos = ((List<DocumentoAdjuntoDTO>) request.getSession().getAttribute("listaArchivosBL"));
                    LOG.info("listaArchivos sesion-->"+listaArchivos);
                    if (listaArchivos != null && listaArchivos.size()>0) {
                        DocumentoAdjuntoDTO documento =new DocumentoAdjuntoDTO(); 
                        //genera nombre alfresco=rutaAlfrescoBD
                        int lastIndexOf = listaArchivos.get(0).getNombreArchivo().lastIndexOf(".");
                        String formato = listaArchivos.get(0).getNombreArchivo().substring(lastIndexOf);
                        String rutaAlfrescoBD = baseLegalDTO.getCodigoBaseLegal()+"_DOCUMENTO"+formato;
                        
                        File someFile = new File(rutaAlfrescoBD);
                        FileOutputStream fos = new FileOutputStream(someFile);
                        fos.write(listaArchivos.get(0).getRutaAlfrescoTmp());
                        fos.flush();
                        fos.close();
                        /* INICIO OSINE_SFS-600 */
//                        documento.setNombreArchivo(listaArchivos.get(0).getNombreArchivo());
                        /* FIN OSINE_SFS-600 */
                        /* INICIO OSINE_SFS-600 */
                        documento.setNombreArchivo(rutaAlfrescoBD);
                        /* FIN OSINE_SFS-600 */
                        documento.setAplicacionSpace(Constantes.APPLICACION_SPACE_OBLIGACIONES);
                        
                        //GuardarDocumentoAdjuntoInRO inDoc=new GuardarDocumentoAdjuntoInRO();
                        outFileAlfresco=documentoServiceNeg.enviarDatosAlfresco(documento, someFile);
                        if (outFileAlfresco!=null && outFileAlfresco.getMensaje().equalsIgnoreCase("ok")){
                            GuardarDocumentoAdjuntoInRO inDoc=new GuardarDocumentoAdjuntoInRO();
                            documento.setRutaAlfresco(rutaAlfrescoBD);
                            documento.setIdDocumentoAdjunto(null);
                            documento.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                            inDoc.setDocumento(documento);
                            inDoc.setUsuario(usuarioDTO);

                            GuardarDocumentoAdjuntoOutRO saveDoc =documentoServiceNeg.registrarDocumentoAdjunto(inDoc);
                            
                            baseLegalDTO.setIdDocumentoAdjunto(saveDoc.getDocumento().getIdDocumentoAdjunto());	
                        }
                    }
                }        		
        		
        		String descSinEspacio = baseLegalDTO.getDescripcionGeneralBaseLegal();
                baseLegalDTO.setDescripcionGeneralBaseLegal(descSinEspacio.trim());
            	BaseLegalDTO retorno=baseLegalService.editarBaseLegal(baseLegalDTO,usuarioDTO);
            	LOG.info("(Actualiza Base Legal) retorno: "+retorno.toString());
            	
            	/* OSINE_SFS-600 - REQF-0012 - Inicio */
            	try{
            		prioridadNormaAgenteNeg.eliminarPrioridadNormaAgente(baseLegalDTO.getIdBaseLegal(), Constantes.ELIMINAR_ORDEN_NORMA_ID_RELACION_BASE_OBLIGACION, usuarioDTO);
            	}catch(Exception e){
            		LOG.error("borrar prioridad norma agente",e);
            	}
            	/* OSINE_SFS-600 - REQF-0012 - Fin */
            	String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_UPDATE, ConstantesWeb.mensajes.MSG_ENTITY_BASELEGAL);
            	salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
            	salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        	}else{
        		salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ADVERTENCIA);
        		String mensaje="Necesita Ingresar el Campo Número";
        		salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
        	}
        	//Eliminar el documento adjunto de la session
            request.getSession().removeAttribute("listaArchivosBL");
     
        } catch (Exception e) {
        	String mensaje = controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_UPDATE, ConstantesWeb.mensajes.MSG_ENTITY_BASELEGAL);
        	salida.put(ConstantesWeb.VV_RESULTADO, 3);
        	salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
            e.printStackTrace();
        }
        return salida;
    }
    /**
     * <-- produccion -->
     * Metodo lista Temas
     * @return
     */    
    @RequestMapping(value="/obtenerTemaObligacion",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> obtenerTemaObligacion(Long idObligacion){
    	LOG.info("Metodo: Listar Temas");
    	Map<String,Object> retorno=new HashMap<String,Object>();
    	List<MaestroColumnaDTO> listado=new ArrayList<MaestroColumnaDTO>();
    	List<TemaDTO> listadoTemas=new ArrayList<TemaDTO>();
        try{
            //ActividadFilter filtro=new ActividadFilter();
            int[] auxiliar=new int[1];
            auxiliar[0]=0;
            
            listado=obligacionNormativaService.listarTemas(auxiliar);
            LOG.info("listado Temas: "+ listado);
            
            if(idObligacion!=null && !idObligacion.equals("")){
            	listadoTemas=obligacionNormativaService.consultaTemaByObligacionId(idObligacion);
                if(listadoTemas!=null){
                	for(MaestroColumnaDTO temas:listado){
                    	for(TemaDTO temaObligacion:listadoTemas){                    		
                    		if(temas.getIdMaestroColumna().equals(temaObligacion.getIdTemaObligacion())){
                    			temas.setSelect(true);
//                    			listado.add(temas);
                    		}
                    	}
                    }
                }
            }
            retorno.put("filas", listado);
            retorno.put("total", auxiliar[0]);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    /**
     * <-- Produccion -->
     * @param idObligacion
     * @param idCriticidad
     * @param idTemas
     * @return
     */
    @RequestMapping(value="/registrarRelacionObligacion",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarRelacionObligacion(Long idObligacion,Long idCriticidad,String idTemas,String codTrazabilidad,HttpSession session){
    	LOG.info("Metodo: Guardar Relaciones. idObligacion: "+idObligacion +"idCriticidad: "+idCriticidad+"idTemas: "+idTemas);
    	Map<String,Object> retorno=new HashMap<String,Object>();
    	ObligacionNormativaDTO registro=new ObligacionNormativaDTO(); 
    	TemaDTO temaDto;
    	List<TemaDTO> listaTemasDto = new ArrayList<TemaDTO>();; 
        try{
        	
        	UsuarioDTO usuarioDTO = getUsuario(session);
        	
            if(idTemas!=null && !idTemas.equals("")){
                String[] listTema=idTemas.split(",");
                LOG.info("listTema ===>" + listTema);
                
            	for(int i=0;i<listTema.length;i++){
                    temaDto=new TemaDTO();
                    LOG.info("Tema: "+ listTema[i].trim());
                    temaDto.setIdTemaObligacion(new Long(listTema[i].trim()));
                    listaTemasDto.add(temaDto);

//            		LOG.info("Metodo: Guardar Relaciones. idObligacion: "+idObligacion +"idCriticidad: "+idCriticidad+"Tema: "+listTema[i]);
//            		String tema = (listTema[i]).trim();
//            		LOG.info("Tema: "+ tema);
//            		registro=obligacionNormativaService.registrarRelaciones(idObligacion,idCriticidad,tema,usuarioDTO);
            	}
            	registro.setIdObligacion(idObligacion);
            	registro.setCriticidadObligacion(idCriticidad);
            	registro.setListaTemas(listaTemasDto);
                registro.setCodTrazabilidad(codTrazabilidad);
            	registro=obligacionNormativaService.registrarRelaciones(registro,usuarioDTO);
            	String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_TEMA);
                retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);

            }else{
                registro.setIdObligacion(idObligacion);
            	registro.setCriticidadObligacion(idCriticidad);
            	registro.setListaTemas(null);
            	registro.setCodTrazabilidad(codTrazabilidad);
                registro=obligacionNormativaService.eliminarRelaciones(registro,usuarioDTO);
            	String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_TEMA);
                retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            }
        }catch(Exception ex){
            LOG.error("",ex);
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_TEMA);
            retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
        return retorno;
    }
    
    /**
     * <-- produccion -->
     * Metodo lista Procesos
     * @return
     */    
    @RequestMapping(value="/obtenerProcesoObligacion",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> obtenerProcesoObligacion(Long idActividad){
    	LOG.info("Metodo: Listar Proceso" +idActividad);
    	Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            int[] auxiliar=new int[1];
            auxiliar[0]=0;
            List<ProcesoDTO> listado;
            listado=cnfObligService.listarProceso(idActividad,auxiliar);
            LOG.info("listado Proceso: "+ listado);
            if(listado!=null){
            	retorno.put("filas", listado);
                retorno.put("total", auxiliar[0]);
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            }
            
        }catch(Exception ex){
        	LOG.error("Error: "+ex.getMessage());
            ex.printStackTrace();
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        	retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            
        }
        
        return retorno;
    }
    
    /**
     * <-- produccion -->
     * Metodo lista Procesos
     * @return
     */    
    @RequestMapping(value="/obtenerObligacionTipo",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> obtenerObligacionTipo(Long idActividad,Long idTipoProceso){
    	LOG.info("Metodo: Listar Obligacion Tipo.. Actividad: " +idActividad+" Proceso: "+idTipoProceso);
    	Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            int[] auxiliar=new int[1];
            auxiliar[0]=0;
            List<ObligacionTipoDTO> listado;
            listado=cnfObligService.listarObligacionTipo(idActividad, idTipoProceso, auxiliar);
            LOG.info("listado Obligacion Tipo: "+ listado);
            retorno.put("filas", listado);
            retorno.put("total", auxiliar[0]);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    /**
     * <--Produccion-->
     * @param idObligacion
     * @param idRubro
     * @param idProceso
     * @param idObligacionTipo
     * @return
     */
    @RequestMapping(value="/registrarConfiguracionObligacion",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarConfiguracionObligacion(Long idObligacion,Long idRubro,Long idProceso,String idObligacionTipo,String codTrazabilidad, HttpSession session, HttpServletRequest request){
    	LOG.info("datos mydata"+request.getParameter("midata"));
    	LOG.info("Metodo: Guardar Relaciones. idObligacion: "+idObligacion +"idRubro: "+idRubro+"idProceso: "+idProceso);
    	Map<String,Object> retorno=new HashMap<String,Object>();
    	CnfObligacionDTO registro=new CnfObligacionDTO();       	
    	List<OpcionDTO> listaOpciones=new ArrayList<OpcionDTO>();
        try{
        	
        	UsuarioDTO usuarioDTO = getUsuario(session);
        	
        	String[] listOblgTipo=idObligacionTipo.split(",");
        	for(int i=0;i<listOblgTipo.length;i++){
        		LOG.info("Metodo: Registrar Configuracion. idObligacion: "+idObligacion +" idRubro: "+idRubro+" idProceso: "+idProceso+" Oblg Tipo: "+listOblgTipo[i]);
        		String oblgTipo = (listOblgTipo[i]).trim();
        		LOG.info("Oblg Tipo: "+ oblgTipo);
        		registro=obligacionNormativaService.registrarConfiguracion(idObligacion,idRubro,idProceso,oblgTipo,codTrazabilidad,usuarioDTO);
        	}
        	String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_CONFIGURACION);
        	retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
        	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        	
        	String idRubros = "";         	
        	ObligacionFilter filtro = new ObligacionFilter();
        	int[] auxiliar=new int[1];
        	filtro.setIdObligacion(idObligacion);
        	List<CnfObligacionDTO> cnfObligacionDTOs= obligacionNormativaService.findObligacionById(filtro, auxiliar);
        	
        	if(cnfObligacionDTOs!=null){ 
        		
        	idRubros=MycUtil.concatenaListadoActividades(cnfObligacionDTOs);
        	
        	}else {
        		idRubros=idRubro.toString();	
        	}
        	
        	listaOpciones=obligacionNormativaService.obtenerOpciones(idRubros);
        	
        	if (listaOpciones!=null){        		
        		    retorno.put("countOpc",listaOpciones.size());
        		for (int i = 0; i < listaOpciones.size(); i++) {
        			retorno.put("opcion"+i,listaOpciones.get(i).getIdentificador_opcion() );        			                	
				}        	
        	}

        }catch(Exception ex){
        	LOG.error("Error en Registrar Configuración: "+ex.getMessage());
            ex.printStackTrace();
            String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_CONFIGURACION);
        	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        	retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            
        }
        return retorno;
    }
    /**
     * <--Produccion-->
     * @param filtro
     * @param varLista
     * @param rows
     * @param page
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/listarConfObligacion", method = RequestMethod.GET)
    public @ResponseBody
	Map<String, Object> listarConfObligacion(ObligacionFilter filtro,int varLista, int rows, int page, HttpSession session,HttpServletRequest request) {
		LOG.info("Funcion: listado de Configuraciones: "+filtro.getIdObligacion());
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
        	List<CnfObligacionDTO> listado;
            if(varLista==1){
	      
	            int[] auxiliar=new int[1];
	            auxiliar[0]=0;
	            LOG.info("Filtro: " + filtro + " Auxiliar:" + auxiliar);
	            listado=obligacionNormativaService.findObligacionById(filtro, auxiliar);
	            LOG.info("Funcion: contador -- auxiliar: " + auxiliar);
	            if(listado!=null){
	            	Long contador = new Long(listado.size());
		            int indiceInicial = (page - 1) * rows;
		            int indiceFinal = indiceInicial + rows;
		            List<CnfObligacionDTO> listaConfiguracion = new ArrayList<CnfObligacionDTO>();
		            listaConfiguracion = listado.subList(
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
		            listaResultado.put("filas", listaConfiguracion);
	            }
	            
            }
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
    }
    /**
     * <--Produccion-->
     * @param idConfObligacion
     * @return
     */
    @RequestMapping(value="/eliminarConfiguracionObligacion",method = RequestMethod.GET)
    /* OSINE_SFS-610 - Inicio */
    //public @ResponseBody Map<String, Object> eliminarConfiguracionObligacion(Long idConfObligacion,String codTrazabilidad,HttpSession session){
    public @ResponseBody Map<String, Object> eliminarConfiguracionObligacion(Long idObligacion, Long idConfObligacion,String codTrazabilidad,HttpSession session){	
    /* OSINE_SFS-610 - Fin */
        LOG.info("(Controller Eliminar Configuracion Obligacion)Ingresando... ");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
        	
        	UsuarioDTO usuarioDTO = getUsuario(session);
        	
            CnfObligacionDTO retorno=cnfObligService.eliminarConfiguracion(idConfObligacion,codTrazabilidad,usuarioDTO);
            LOG.info("Configuracion Eliminada: "+retorno.getIdConfObligacion());
            /* OSINE_SFS-610 - Inicio */
            List<OpcionDTO> listaOpciones=new ArrayList<OpcionDTO>();
            String idRubros = "";
            
            ObligacionFilter filtro = new ObligacionFilter();
        	int[] auxiliar=new int[1];
        	filtro.setIdObligacion(idObligacion);
        	List<CnfObligacionDTO> cnfObligacionDTOs= obligacionNormativaService.findObligacionById(filtro, auxiliar);
        	
        	if(cnfObligacionDTOs!=null){ 
        		
        	idRubros=MycUtil.concatenaListadoActividades(cnfObligacionDTOs);
        	
        	}
			
        	listaOpciones=obligacionNormativaService.obtenerOpciones(idRubros);
        	
        	if (listaOpciones!=null){        		
        		salida.put("countOpcActualizar",listaOpciones.size());
        		for (int i = 0; i < listaOpciones.size(); i++) {
        			salida.put("opcionActualizar"+i,listaOpciones.get(i).getIdentificador_opcion() );        			                	
				}        	
        	}
            /* OSINE_SFS-610 - Fin */
        	salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        return salida;
    }
    
    /**
    * <--Produccion-->
    * @param idConfObligacion
    * @return
    */
   @RequestMapping(value="/eliminarBaseLegalAsociada",method = RequestMethod.GET)
   public @ResponseBody Map<String, Object> eliminarBaseLegalAsociada(Long idAsocObligacion,Long idBaseLegal, Long idObligacion,String codTrazabilidad,HttpSession session){
       LOG.info("(Controller Eliminar Base Legal Asociada Obligacion)Ingresando... " + idAsocObligacion);
       Map<String, Object> salida = new HashMap<String, Object>();
       try {
       	
    	   UsuarioDTO usuarioDTO = getUsuario(session);
           
           ObligacionBaseLegalDTO oblgBaseLegal=new ObligacionBaseLegalDTO();
           oblgBaseLegal.setIdOblBase(idAsocObligacion);
           oblgBaseLegal.setIdBaseLegal(idBaseLegal);
           oblgBaseLegal.setIdObligacion(idObligacion);
           oblgBaseLegal.setCodTrazabilidad(codTrazabilidad);
           
           ObligacionBaseLegalDTO retorno=obligacionBaseLegalServiceNeg.eliminarBaseLegalAsociada(oblgBaseLegal,usuarioDTO);
           LOG.info("Asociacion Eliminada: "+retorno);
           String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_DELETE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_BASELEGAL);
           salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
           salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
       	
       } catch (Exception e) {
    	   e.printStackTrace();
    	   String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_DELETE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_BASELEGAL);
    	   salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
    	   salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
       }
     
       return salida;
   }
   
   @RequestMapping(value="/asociarObligacionCriterio", method= RequestMethod.POST)
   public @ResponseBody Map<String,Object> asociarObligacionCriterio(Long idCriterio,Long idTipificacion, Long idObligacion,HttpServletRequest request){
       LOG.info("procesando registrar Asociacion ObligacionCriterio");
       Map<String,Object> retorno = new HashMap<String,Object>();
       try{
       	//setear usuario
       	UsuarioDTO usuarioDTO = new UsuarioDTO();
           usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
           usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
       	//setear Criterio
       	ObliTipiDTO relacion = new ObliTipiDTO();
       	CriterioDTO criterio =new CriterioDTO();
       	criterio.setIdCriterio(idCriterio);
       	relacion.setCriterio(criterio);
       	TipificacionDTO tipificacion = new TipificacionDTO();
       	tipificacion.setIdTipificacion(idTipificacion);
       	relacion.setTipificacion(tipificacion);
       	ObligacionNormativaDTO obligacion = new ObligacionNormativaDTO();
       	obligacion.setIdObligacion(idObligacion);
       	relacion.setObligacion(obligacion);
       	relacion.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);        	
       	relacion = obliTipiServiceNeg.guardaRelacion(relacion,usuarioDTO);   
       	String mensaje=controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_CRITERIO);
       	retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
       	retorno.put("resultado", 0);

       }catch(Exception ex){
           LOG.error("Error en registrarTipificacion: "+ex.getMessage());
           ex.printStackTrace();
       }
       return retorno;
   }
   
   
   @RequestMapping(value="/obtenerFechaEntradaVigente", method= RequestMethod.POST)
   public @ResponseBody String obtenerFechaEntradaVigente(Long idBaseLegal, HttpServletRequest request){
	   LOG.info("procesando registrar Asociacion ObligacionCriterio");
       Map<String,Object> retorno = new HashMap<String,Object>();
       try{
    	   BaseLegalFilter filtro = new BaseLegalFilter();
    	   filtro.setIdBaseLegal(idBaseLegal);
    	   int[ ] auxiliar = {99};
    	   String fechafechaVigenciaNormaLegalFormateada = "";
    	   List<BaseLegalDTO> baseLegalDTO =  baseLegalService.listarBaseLegalToBaseLegal(filtro, auxiliar);
//    	   baseLegalDTO.get(0).getFechaEntradaVigenciaNorma();
    	   Date fechaVigenciaNormaLegal =  baseLegalDTO.get(0).getFechaEntradaVigenciaNormaLegal();
    	   if (fechaVigenciaNormaLegal != null){
    		   fechafechaVigenciaNormaLegalFormateada = new SimpleDateFormat("dd/MM/yyyy").format(fechaVigenciaNormaLegal);
    	   }
    	   retorno.put("baseLegalFechavigencia", fechafechaVigenciaNormaLegalFormateada);
    	   retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
       }catch(Exception ex){
           LOG.error("Error en registrarTipificacion: "+ex.getMessage());
           ex.printStackTrace();
       }
       return JsonUtil.convertirObjetoACadenaJson(retorno);
   }
   /**
    * Concatena Mensaje Estático + Mensaje Ingresado a Criterio
    * @param msgStatic
    * @param msgDinamic
    * @return
    */
   public static String controlMessages(String msgStatic,String msgDinamic){
	   String concatenado = "";
	   String[] s = new String[2];
	   s[0]=msgStatic;
	   s[1]=msgDinamic;
	   concatenado=StringUtils.join(s, ",");
	   return concatenado;
   }
   /**
    * oncatena Mensaje Estático + Mensaje Entidad
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
   /**
    * Concatena Mensaje Estático + Mensaje Ingresado a Criterio + Mensaje Entidad
    * @param msgStatic
    * @param msgDinamic
    * @param msgEntity
    * @return
    */
   public static String controlMessagesEntity(String msgStatic,String msgDinamic,String msgEntity){
	   String concatenado = "";
	   String[] s = new String[3];
	   s[0]=msgStatic;
	   s[1]=msgDinamic;
	   s[2]=msgEntity;
	   concatenado=s[0]+" "+s[1]+" , "+s[2];
	   return concatenado;
   }
   /** Funcion convierte fecha to String Globales **/    
    public static String convertirFechaString ( Date fecha ) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            return df.format(fecha);
        } catch ( Exception e ) {return null;}
    }
}