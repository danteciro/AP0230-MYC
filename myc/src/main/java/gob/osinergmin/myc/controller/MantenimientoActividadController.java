/**
* Resumen		
* Objeto			: MantenimientoActividadController.java
* Descripción		: Controla el mantenimiento de actividades en el MYC.
* Fecha de Creación	: 27/06/2016.
* PR de Creación	: OSINE_SFS-600
* Autor				: Hernán Torres Sáenz.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
* 
*/ 

package gob.osinergmin.myc.controller;
import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.business.TipificacionServiceNeg;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.service.business.ActividadServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.TipificacionSancionServiceNeg;
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
import gob.osinergmin.myc.common.util.StringUtil;

@Controller
@RequestMapping("/mantenimientoActividad")
public class MantenimientoActividadController {
    private static final Logger LOG = LoggerFactory.getLogger(MantenimientoActividadController.class);
    
    @Inject
    TipificacionServiceNeg tipificacionserviceNeg;
    @Inject
    TipificacionSancionServiceNeg tipificacionSancionServiceNeg;
    @Inject
    MaestroColumnaServiceNeg maestroColumnaServiceNeg;
    @Inject    
    ActividadServiceNeg actividadServiceNeg;
    
    // Carga Mantenimiento Actividad y Agente
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        model.addAttribute("listadoActividades",actividadServiceNeg.findActividadByFilter(new ActividadFilter(true)));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_ACTIVIDAD_AGENTE_INSTALACION;
    }
    
    // Carga Mantenimiento Actividad y Agente
    @RequestMapping(value = "/abrirMantActividadAgente", method = RequestMethod.GET)
    public String abrirMantActividadAgente (ActividadDTO actividad,HttpSession sesion,Model model ) {
        try{
        	
        	
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }

        return ConstantesWeb.Navegacion.PAGE_GENERAL_FRM_ACTIVIDAD_AGENTE;
    }
    
 // Carga Mantenimiento Agente
    @RequestMapping(value = "/abrirMantFrmAgente", method = {RequestMethod.GET, RequestMethod.POST})
    public String abrirMantFrmAgente (ActividadDTO actividad, String tipo, HttpSession sesion,Model model ) {
        try{
        	
        	model.addAttribute("tipo", tipo);
        	model.addAttribute("act", actividad);
        	model.addAttribute("act3", actividad);
        	
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }
        return ConstantesWeb.Navegacion.PAGE_GENERAL_FRM_AGENTE;
    }

    // Carga Mantenimiento de la Actividad
    @RequestMapping(value = "/abrirMantActividad", method = RequestMethod.POST)
    public String abrirMantActividad (ActividadDTO actividad, String tipo, HttpSession sesion,Model model ) {
        try{
        	model.addAttribute("tipo", tipo);
        	model.addAttribute("a", actividad);
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }

        return ConstantesWeb.Navegacion.PAGE_GENERAL_FRM_ACTIVIDAD;
    }    
    
    @RequestMapping(value = "/findActividad", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody Map<String,Object> findActividad(ActividadFilter filtro,int rows, int page,int flg_load,HttpSession session){
    	LOG.info("findActividad");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ActividadDTO> listado;
            //int total=0;
            //Integer cuenta;
            
            if(flg_load==1){
                int inicio;
                inicio=rows*page-rows;
                
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                
                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                
                listado=actividadServiceNeg.listarActividad(filtro);
                
                if(listado!=null){
                	int indiceInicial = (page - 1) * rows;
    	            int indiceFinal = indiceInicial + rows;
    	            
                	Long contador = new Long(listado.size());
    	            
    	            
                	List<ActividadDTO> listaConfiguracion = listado.subList(
    	                    indiceInicial, indiceFinal > listado
    	                    .size() ? listado.size()
    	                    : indiceFinal);
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
    
    @RequestMapping(value = "/cargarActividadPadre", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> cargarActividadPadre(ActividadFilter filtro,HttpSession session){
    	LOG.info("findActividad");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
        	//retorno=(Map<String, Object>) actividadServiceNeg.findActividadByFilter(new ActividadFilter(true));
        	retorno.put("listadoActividades",actividadServiceNeg.findActividadByFilter(new ActividadFilter(true)));
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/consultarActividad",method= {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody Map<String,Object> consultarActividad(ActividadFilter filtro, HttpServletRequest request,HttpSession session){
        
    	LOG.info("consultarActividad");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
        	List<ActividadDTO> listado;
            
            listado=actividadServiceNeg.listarActividad(filtro);
            
            if(listado!=null){
            	Long contador = new Long(listado.size());
                retorno.put("registros", contador);
                retorno.put("filas", listado);  
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/consultarAgente",method= {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody Map<String,Object> consultarAgente(ActividadFilter filtro, HttpServletRequest request,HttpSession session){
        
    	LOG.info("consultarActividad");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
        	List<ActividadDTO> listado;
            
            listado=actividadServiceNeg.listarAgente(filtro);
            
            if(listado!=null){
            	Long contador = new Long(listado.size());
                retorno.put("registros", contador);
                retorno.put("filas", listado);  
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/findAgenteInstalacion",method= {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody Map<String,Object> findAgenteInstalacion(ActividadFilter filtro,int rows, int page,int flg_load,HttpSession session){
        LOG.info("findAgentesIntalacion");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ActividadDTO> listado;
            //int total=0;
            //Integer cuenta;
            
            if(flg_load==1){
                int inicio;
                inicio=rows*page-rows;
                
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                
                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                
                listado=actividadServiceNeg.listarAgentesIntalacion(filtro);
                
                if(listado!=null){
                	int indiceInicial = (page - 1) * rows;
    	            int indiceFinal = indiceInicial + rows;
    	            
                	Long contador = new Long(listado.size());
    	            
    	            
                	List<ActividadDTO> listaConfiguracion = listado.subList(
    	                    indiceInicial, indiceFinal > listado
    	                    .size() ? listado.size()
    	                    : indiceFinal);
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
    
    @RequestMapping(value = "/guardarActividad", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> guardarActividad(ActividadDTO actividad, String tipo, boolean forzarOrdenamiento,HttpServletRequest request, HttpSession session,Model model){
        LOG.info("procesando guardarActividad");
        Map<String, Object> salida = new HashMap<String, Object>();
        ActividadFilter filtro=new ActividadFilter();
        try {
        	actividad.setNombre(StringUtil.fixerUpper(actividad.getNombre()));
        	String mensaje="";
        	boolean nombreExiste=false;
            boolean codigoExiste=false;
            boolean ordenExiste=false;            
           
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            List<ActividadDTO> listaActividadBd = actividadServiceNeg.findActividadByFilter(filtro);
            filtro=new ActividadFilter();
			if(actividad.getIdActividadPadre()!=null)
				filtro.setIdActividadPadre(actividad.getIdActividadPadre());
			else 
				filtro.setFlagListarActividadesPadre(true);        	
        	List<ActividadDTO> listaActividadBd_ = actividadServiceNeg.findActividadByFilter(filtro);
        	if(tipo.equals("editar")){
        		int contador=-1;
        		int contador_=-1;
        		for (int i=0; i < listaActividadBd.size(); i++) {
        			if(actividad.getIdActividad().toString().equals(listaActividadBd.get(i).getIdActividad().toString())){
        				contador=i;
        				break;
        			}
        		}
        		for (int x=0; x < listaActividadBd_.size(); x++) {
        			if(actividad.getIdActividad().toString().equals(listaActividadBd_.get(x).getIdActividad().toString())){
        				contador_=x;
        				break;
        			}
        		}        		
        		if(contador>-1){
        			listaActividadBd.remove(contador);
        		}
        		if(contador_>-1){
        			listaActividadBd_.remove(contador_);
        		}
        	}
        	
        	if(!forzarOrdenamiento){
	        	for(ActividadDTO actividadBd : listaActividadBd){
	    			if(actividad.getNombre().equals(actividadBd.getNombre())){
	    				nombreExiste=true;
	    				mensaje="El nombre de la Actividad \u00f3 Agente ya est\u00e1 registrado.";
	    				break;
	    			}
	    		}
        	}
        	
        	if(!nombreExiste){
        		
        		if(!tipo.equals("editar")){
        			for(ActividadDTO actividadBd : listaActividadBd){
    	    			if(actividad.getCodigo().equals(actividadBd.getCodigo())){
    	    				codigoExiste=true;
    	    				mensaje="El c\u00f3digo de la Actividad \u00f3 Agente ya est\u00e1 registrado.";
    	    				break;
    	    			}					
            		}
        		}
        		
        		
        		if(!codigoExiste){        			
            		for(ActividadDTO actividadBd : listaActividadBd_){
    		        	if(actividad.getOrden().equals(actividadBd.getOrden())){
    						ordenExiste=true;
    						mensaje="El orden ingresado ya est\u00e1 registrado.<br>El sistema ajustar\u00e1 el ordenamiento "
    								+ "para las actividades con orden mayor \u00f3 igual al ingresado. ¿Desea continuar?.";
    						break;
    					}
            		}
            	}
        	}
        	
        	// Mensaje Error según nombre ó código.
        	if(nombreExiste || codigoExiste){
        		salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
                salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
                LOG.error("Error en guardarActividad,",mensaje);
        	}else{
        		UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
                usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
        		if(ordenExiste){        			
        			salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.RESTRICT);
                    salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
                    LOG.error("Error en guardarActividad,",mensaje);
        		}else{
        			// GUARDAR
        			if(tipo.equals("nuevo")){
        				salida=actividadServiceNeg.guardarActividad(actividad,usuarioDTO,forzarOrdenamiento);
                	// EDITAR
                	}else if(tipo.equals("editar")){
                		filtro=new ActividadFilter();
                		filtro.setIdActividad(actividad.getIdActividad());
                		filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                		List<ActividadDTO>lista=actividadServiceNeg.findActividadByFilter(filtro);
                		if(lista!=null && lista.size()!=0){
                			ActividadDTO actividadUpdate=lista.get(0);
                			actividadUpdate.setCodigo(actividad.getCodigo());
                			actividadUpdate.setNombre(actividad.getNombre());
                			actividadUpdate.setOrden(actividad.getOrden());
                			salida=actividadServiceNeg.editarActividad(actividadUpdate,usuarioDTO,forzarOrdenamiento);
                		} 
                	}
        		}
        	}
        	
        } catch (Exception e) {
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            salida.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en guardarActividad,",e);
        }
        return salida;
    }   
    
    @RequestMapping(value = "/eliminarActividad", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarActividad(Long idActividad, HttpServletRequest request){
        LOG.info("procesando eliminarActividad");
        Map<String,Object> retorno = new HashMap<String,Object>();
        ActividadFilter filtro = new ActividadFilter();
        try{
        	ActividadDTO actividadDTO = new ActividadDTO();
        	filtro.setIdActividad(idActividad);
        	
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            retorno = verificarEliminarActividad(filtro);
            if(retorno.get("resultado").equals(BaseConstantesOutBean.SUCCESS)) {
            	actividadDTO = actividadServiceNeg.eliminarActividad(idActividad, Constantes.CONSTANTE_ESTADO_INACTIVO, usuarioDTO);
            	retorno.put("Actividad",actividadDTO);
            } 
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en eliminarActividad: "+ex.getMessage());
        }
        return retorno;
    }
    
    
    // Carga Mantenimiento Agentes
    @RequestMapping(value = "/abrirMantFrmBusqAgente", method = RequestMethod.POST)
    public String abrirMantFrmBusqAgente (ActividadDTO actividad,HttpSession sesion,Model model ) {
        try{
        	
        	model.addAttribute("idActividadPadre", actividad.getIdActividad());
        	model.addAttribute("a", actividad);
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }

        return ConstantesWeb.Navegacion.PAGE_GENERAL_FRM_BUSQ_AGENTE;
    }
    
    @RequestMapping(value = "/findAgente", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody Map<String,Object> findAgente(ActividadFilter filtro,int rows, int page,int flg_load,HttpSession session){
    	LOG.info("findAgente");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<ActividadDTO> listado;
            //int total=0;
            //Integer cuenta;
            
            if(flg_load==1){
                int inicio;
                inicio=rows*page-rows;
                
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                
                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                
                listado=actividadServiceNeg.listarAgentesIntalacion(filtro);
                
                if(listado!=null){
                	int indiceInicial = (page - 1) * rows;
    	            int indiceFinal = indiceInicial + rows;
    	            
                	Long contador = new Long(listado.size());
    	            
    	            
                	List<ActividadDTO> listaConfiguracion = listado.subList(
    	                    indiceInicial, indiceFinal > listado
    	                    .size() ? listado.size()
    	                    : indiceFinal);
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
    
    @RequestMapping(value = "/ajustarActividades", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> ajustarActividades(ActividadDTO actividad, String tipo, HttpServletRequest request, HttpSession session,Model model){
        LOG.info("procesando ajustarActividades");
        Map<String, Object> salida = new HashMap<String, Object>();
        try { 
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            actividad.setNombre(StringUtil.fixerUpper(actividad.getNombre()));
        	if(tipo.equals("nuevo")){
        		salida=actividadServiceNeg.guardarActividad(actividad,usuarioDTO,true); 
        	}else if(tipo.equals("editar")){
        		ActividadFilter filtro=new ActividadFilter();
        		filtro.setIdActividad(actividad.getIdActividad());
        		filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
        		List<ActividadDTO>lista=actividadServiceNeg.findActividadByFilter(filtro);
        		if(lista!=null && lista.size()!=0){
        			ActividadDTO actividadUpdate=lista.get(0);
        			actividadUpdate.setCodigo(actividad.getCodigo());
        			actividadUpdate.setNombre(actividad.getNombre());
        			actividadUpdate.setOrden(actividad.getOrden());
        			salida=actividadServiceNeg.editarActividad(actividadUpdate,usuarioDTO,true);
        		}      		
        	}        	
        } catch (Exception e) {
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            salida.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en ajustarActividades,",e);
        }
        return salida;
    }
    
    public @ResponseBody Map<String, Object> verificarEliminarActividad(ActividadFilter filtro){
    	LOG.info("procesando verificarEliminarActividad");
        Map<String, Object> retorno = new HashMap<String, Object>();
        try { 
        	retorno=actividadServiceNeg.verificarEliminarActividad(filtro); 	
        } catch (Exception e) {
        	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
        	retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en verificarEliminarActividad,",e);
        }
        return retorno;
    }
}
