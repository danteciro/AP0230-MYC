/**
* Resumen           
* Objeto            : PrioridadNormaAgenteController.java
* Descripción       : Controla el mantenimiento de prioridad norma agente en el MYC.
* Fecha de Creación : 28/06/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Erick Ortiz Gil.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
package gob.osinergmin.myc.controller;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.ListaPrioridadNormaAgenteDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.PrioridadNormaAgenteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.PrioridadNormaAgenteFilter;
import gob.osinergmin.myc.service.business.ActividadServiceNeg;
import gob.osinergmin.myc.service.business.PrioridadNormaAgenteServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

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

@Controller
@RequestMapping("/prioridadNormaAgente")
public class PrioridadNormaAgenteController {
	private static final Logger LOG = LoggerFactory.getLogger(PrioridadNormaAgenteController.class);
	@Inject
	private PrioridadNormaAgenteServiceNeg prioridadNormaAgenteServiceNeg;
	@Inject
	private ActividadServiceNeg actividadServiceNeg;
	
	@RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));   
        model.addAttribute("listadoActividad",actividadServiceNeg.findActividadByFilter(new ActividadFilter(true)));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_PRIORIDAD_NORMA_AGENTE;
    }
	
	@RequestMapping(value="/findPrioridadNormaAgente",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> findPrioridadNormaAgente(PrioridadNormaAgenteFilter filtro){
        LOG.info("findPrioridadNormaAgente");    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<PrioridadNormaAgenteDTO> listado;
            int[] auxiliar=new int[1];
            auxiliar[0]=0;
            listado=prioridadNormaAgenteServiceNeg.listarPrioridadNormaAgente(filtro, auxiliar);
            retorno.put("lista", listado);  
            if(listado==null){ listado=new ArrayList<PrioridadNormaAgenteDTO>(); }
            retorno.put("total", listado.size());  
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value="/findGridPrioridadNormaAgente",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> findGridPrioridadNormaAgente(PrioridadNormaAgenteFilter filtro, int rows, int page,int flg_load, HttpSession session){
        LOG.info("findGridPrioridadNormaAgente");    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<PrioridadNormaAgenteDTO> listado;
            if(flg_load==1){                
                listado=prioridadNormaAgenteServiceNeg.listarPrioridadNormaAgente(filtro);
                
                if(listado!=null){
                	Long contador = new Long(listado.size());
    	            int indiceInicial = (page - 1) * rows;
    	            int indiceFinal = indiceInicial + rows;
    	            List<PrioridadNormaAgenteDTO> listaConfiguracion = new ArrayList<PrioridadNormaAgenteDTO>();
    	            listaConfiguracion = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal);
    	            Long numeroFilas = (contador / rows);
    	            if ((contador % rows) > 0) {
    	                numeroFilas = numeroFilas + 1L;
    	            }                	
                	retorno.put("total", numeroFilas);
                    retorno.put("pagina", page);
                    retorno.put("registros", contador);
                    retorno.put("filas", listaConfiguracion);  
                }                	    	                                                       
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@RequestMapping(value = "/abrirMantPrioridadNormaAgente", method = RequestMethod.GET)
    public String abrirMantPrioridadNormaAgente (String tipo, Long idPrioridadNormaAgente, Long idActividad, Long idAgente, HttpSession sesion, Model model) {
        LOG.info("abrirMantPrioridadNormaAgente, tipo: "+tipo);
        LOG.info("abrirMantPrioridadNormaAgente, idPrioridadNormaAgente: "+idPrioridadNormaAgente);
        List<ActividadDTO> listaActividad=null;
        List<PrioridadNormaAgenteDTO> listaPrioridad=null; 
        try{        	     	
            PrioridadNormaAgenteFilter filtroPrioridad=new PrioridadNormaAgenteFilter();
            filtroPrioridad.setIdPrioridadNormaAgente(idPrioridadNormaAgente);
            ActividadFilter filtroActividad=new ActividadFilter();
            
            int[] auxiliar=new int[1];
            auxiliar[0]=0;
            
            model.addAttribute("tipo", tipo);                                              
            model.addAttribute("idActividad",idActividad);
            model.addAttribute("idAgente",idAgente);
            
            filtroActividad.setIdActividad(idActividad);
            filtroActividad.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            listaActividad=actividadServiceNeg.findActividadByFilter(filtroActividad);
            if(listaActividad!=null && listaActividad.size()!=0){
            	model.addAttribute("actividad", listaActividad.get(0).getNombre());
            }
            filtroActividad.setIdActividad(idAgente);
            listaActividad=actividadServiceNeg.findActividadByFilter(filtroActividad);
            if(listaActividad!=null && listaActividad.size()!=0){
            	model.addAttribute("agente",listaActividad.get(0).getNombre());
            }
            List<BaseLegalDTO> listadoNormas = prioridadNormaAgenteServiceNeg.findBaseLegalByIdAgente(idAgente);
            model.addAttribute("listadoNormas", listadoNormas);
                        
            if(!tipo.equals("new") && idPrioridadNormaAgente!=null){                              
            	listaPrioridad = prioridadNormaAgenteServiceNeg.findPrioridadNormaAgenteByFilter(filtroPrioridad);    
            	if(listaPrioridad!=null && listaPrioridad.size()!=0)
            		model.addAttribute("r", listaPrioridad.get(0));
            }
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }                   
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_FRM_PRIORIDAD_NORMA_AGENTE;
    }
	
	@RequestMapping(value = "/guardarPrioridadNorma", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> guardarPrioridadNorma(ListaPrioridadNormaAgenteDTO listaPrioridad, HttpServletRequest request, HttpSession session) {
		LOG.info("procesando guardarPrioridadNorma");
        Map<String, Object> retorno = new HashMap<String, Object>();       
        try {
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());        	    			
            retorno=prioridadNormaAgenteServiceNeg.guardarPrioridadNormaAgente(listaPrioridad, usuarioDTO);
        } catch (Exception e) {
        	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
        	retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en guardarPrioridadNorma,",e);
        }
        return retorno;
	}
    
	@RequestMapping(value = "/saveEdition", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveEdition(ListaPrioridadNormaAgenteDTO listaPrioridad, HttpServletRequest request, HttpSession session) {
		LOG.info("procesando saveEdition");
        Map<String, Object> retorno = new HashMap<String, Object>();       
        try {
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());        	    			
            retorno=prioridadNormaAgenteServiceNeg.actualizarPrioridadNormaAgente(listaPrioridad, usuarioDTO);
        } catch (Exception e) {
        	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
        	retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en saveEdition,",e);
        }
        return retorno;
	}
	
	@RequestMapping(value = "/eliminarPrioridadNorma", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> eliminarPrioridadNorma(Long idPrioridadNorma,HttpServletRequest request, HttpSession session){
        LOG.info("procesando eliminarPrioridadNorma");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());            

            Map<String, Object> res1 =prioridadNormaAgenteServiceNeg.eliminarPrioridadNormaAgente(idPrioridadNorma, Constantes.ELIMINAR_ORDEN_NORMA_ID_NORMA_PRIORIDAD,usuarioDTO);            
            salida.put("resultado1",res1);
            salida.put(ConstantesWeb.VV_MENSAJE, "ok");
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
        } catch (Exception e) {
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            salida.put(ConstantesWeb.VV_MENSAJE, "Error al procesar");
            e.printStackTrace();
        }
        return salida;
    }
	
	
}
