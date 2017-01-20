/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.business.TipificacionServiceNeg;
import gob.osinergmin.myc.domain.ui.TipificacionFilter;
import gob.osinergmin.myc.domain.ui.TipificacionSancionFilter;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.TipificacionSancionServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;
import java.net.Inet4Address;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author jpiro
 */
@Controller
@RequestMapping("/tipificacion")
public class TipificacionController {
    private static final Logger LOG = LoggerFactory.getLogger(TipificacionController.class);

    @Inject
    TipificacionServiceNeg tipificacionserviceNeg;
    @Inject
    TipificacionSancionServiceNeg tipificacionSancionServiceNeg;
    @Inject
    MaestroColumnaServiceNeg maestroColumnaServiceNeg;
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_TIPIFICACION;
    }
    
    @RequestMapping(value = "/abrirMantTipificacion", method = RequestMethod.GET)
    public String abrirMantTipificacion ( String tipo, Long idTipificacion,HttpSession sesion,Model model ) {
        LOG.info("abrirMantRequisito, tipo:"+tipo);
        LOG.info("abrirMantRequisito, idTipificacion:"+idTipificacion);
        try{
            String nombre = "";
            String codTipificacion = "";
            TipificacionFilter filtro1 = new TipificacionFilter();
            filtro1.setDescripcion(nombre);
            filtro1.setCodTipificacion(codTipificacion);
            filtro1.setIdTipificacion(idTipificacion);
            int[] auxiliar=new int[1];
            auxiliar[0]=0;
            
            model.addAttribute("tipo", tipo);
            model.addAttribute("listaTipoSancion", maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_TIPO_SANCION));
//            model.addAttribute("listaTipificacionPadre", tipificacionserviceNeg.listarTipificacionesPadre(filtro1));
            model.addAttribute("listaTipificacionPadre", tipificacionserviceNeg.obtenerTipificaciones(""));

            if(!tipo.equals("new") && idTipificacion!=null){
                TipificacionFilter filtro=new TipificacionFilter();
                filtro.setIdTipificacion(idTipificacion);
                
                TipificacionDTO registro=tipificacionserviceNeg.obtenerTipificacionNivel(idTipificacion);
                List<TipificacionSancionDTO> lista=registro.getListaTipificacionSancion();
                String tipSan=MycUtil.concatenaTipoSancionFromTipificacionSancion(lista);
                String txtTipSan=MycUtil.concatenaTxtTipoSancionFromTipificacionSancion(lista);
                //String idTipSan = MycUtil.concatenaTipificacionSancion(lista);
                
                model.addAttribute("listaTipificacionSancion",tipSan);
                model.addAttribute("listaTxtTipificacionSancion",txtTipSan);
                //model.addAttribute("listaIdTipificacionSancion",idTipSan);
                model.addAttribute("r", registro);
                model.addAttribute("nombreArchivo",registro.getDescripcion());
                LOG.info("nombreArchivo:"+registro.getDescripcion());
            }
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }
            
        
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_FRM_TIPIFICACION;
    }
    
    @RequestMapping(value="/findTipificacion",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> findTipificacion(TipificacionFilter filtro,int rows, int page,int flg_load,HttpSession session){
        LOG.info("findTipificacion");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<TipificacionDTO> listado;
            int total=0;
            Integer cuenta;
            
            if(flg_load==1){
                int inicio;
                inicio=rows*page-rows;
                
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                
                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                String descripcion = new String(filtro.getDescripcion().getBytes(), "UTF-8");
                filtro.setDescripcion(descripcion);
                String codTipificacion=new String(filtro.getCodTipificacion().getBytes(), "UTF-8");
                filtro.setCodTipificacion(codTipificacion);
                
                listado=tipificacionserviceNeg.listarTipificaciones(filtro, auxiliar);
                
                if(listado!=null){
                	Long contador = new Long(listado.size());
    	            int indiceInicial = (page - 1) * rows;
    	            int indiceFinal = indiceInicial + rows;
    	            List<TipificacionDTO> listaConfiguracion = new ArrayList<TipificacionDTO>();
    	            listaConfiguracion = listado.subList(
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
    
    @RequestMapping(value="/findTipificacionSancion",method=RequestMethod.GET)
    public @ResponseBody Map<String,Object> findTipificacionSancion(TipificacionSancionFilter filtro,int rows,int page, int flg_load,HttpSession session){
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            LOG.info("procesando findActividadProcedimiento");
            List<TipificacionSancionDTO> listado;
            if(flg_load==1){
               int[] auxiliar=new int[1];
                auxiliar[0]=0;
                listado=tipificacionSancionServiceNeg.findTipificacionSancion(filtro,auxiliar);
                if(listado!=null){
                	Long contador = new Long(listado.size());
    	            int indiceInicial = (page - 1) * rows;
    	            int indiceFinal = indiceInicial + rows;
    	            List<TipificacionSancionDTO> listaConfiguracion = new ArrayList<TipificacionSancionDTO>();
    	            listaConfiguracion = listado.subList(
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
    
    @RequestMapping(value="/findTipificacionSancionMantSanc",method=RequestMethod.GET)
    public @ResponseBody Map<String,Object> findTipificacionSancionMantSanc(TipificacionSancionFilter filtro,HttpSession session){
        LOG.info("procesando findTipificacionSancionMantSanc");
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<TipificacionSancionDTO> listado;
            int[] auxiliar=new int[1];
            auxiliar[0]=0;
            filtro.setNivel(maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_NIVEL_CRITERIO).get(0).getIdMaestroColumna());
            listado=tipificacionSancionServiceNeg.findTipificacionSancionCriterio(filtro,auxiliar);
            LOG.info("cuenta Controller findTipificacionSancionMantSanc="+auxiliar[0]);

            retorno.put("filas", listado);      
        }catch(Exception ex){
            LOG.error("error en findTipificacionSancionMantSanc",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value = "/findListadoTipificacion", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> obtenerListadoTipificaciones(){
        LOG.info("procesando POST para RequestMapping /findListadoTipificacion");
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            //List<MaestroColumnaDTO> listaAmbitoParametro = maestroColumnaServiceNeg.buscarTodos(Constantes.DOMINIO_AMBITO_PARAMETRICO);
            String nombre = "";
            String codTipificacion = "";
            TipificacionFilter filtro = new TipificacionFilter();
            filtro.setDescripcion(nombre);
            filtro.setCodTipificacion(codTipificacion);
            int[] auxiliar=new int[1];
            auxiliar[0]=0;
            List<TipificacionDTO> listaZonificaciones = tipificacionserviceNeg.listarTipificaciones(filtro, auxiliar);
            map.put("lista", listaZonificaciones);
        }/*catch (ZonificacionException ex) {
            LOG.error( ex.getMessage() , ex);
            map.put("error", ex.getMessage());
        }*/catch(Exception ex){
            LOG.error( ex.getMessage() , ex);
            map.put("error", ex.getMessage());
        }
        return map;
    }
    
    @RequestMapping(value="/registrarTipificacion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarTipificacion(String codigoTipificacion, String tipoSancion, String tipoMoneda, String sancionMonetaria, String descripcion, String basesLegales, String tipificacionPadre, String tipoSanciones/*ZonificacionDetalleDTO zonificacionDetalleDTO*/){
        LOG.info("procesando registrarTipificacion");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            TipificacionDTO tipificacionDTO = new TipificacionDTO();
            TipificacionDTO tipificacionValidar = new TipificacionDTO();
            
            tipificacionValidar = tipificacionserviceNeg.obtenerTipificacion(codigoTipificacion,basesLegales);
            if(tipificacionValidar != null){
                retorno.put("resultado", 1);
                retorno.put("mensaje", Constantes.CONSTANTE_MSJE_YA_EXISTE+" Tipificaci&oacute;n con el mismo c&oacute;digo y base legal.");
            }else{
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                try{
                	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                	String usuario = ConstantesWeb.getUSUARIO(request);
                	usuarioDTO.setCodigo(usuario);
                }catch(Exception e){
                	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
                }
                usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());

                tipificacionDTO.setIdTipificacion(null);
                tipificacionDTO.setCodTipificacion(codigoTipificacion);
                if(!tipoMoneda.equals("")){
                    tipificacionDTO.setIdTipoMoneda(new Long(tipoMoneda));
                }
                tipificacionDTO.setClaseSancion(new Long(tipoSancion));
                tipificacionDTO.setSancionMonetaria(sancionMonetaria);
                tipificacionDTO.setDescripcion(descripcion);
                tipificacionDTO.setBasesLegales(basesLegales);
                if(!tipificacionPadre.equals("")){
                    tipificacionDTO.setIdTipificacionPadre(new Long(tipificacionPadre));
                }
                tipificacionDTO.setActivo(Constantes.CONSTANTE_ESTADO_ACTIVO);

                tipificacionDTO = tipificacionserviceNeg.guardaTipificacion(tipificacionDTO, usuarioDTO);

                if(!tipoSanciones.equals("-1")){
                    //tipoSanciones = tipoSanciones.substring(0, tipoSanciones.length()-1);
                    String[] listadoTipoSancion = tipoSanciones.split(",");
                    List<MaestroColumnaDTO> listaNivel= maestroColumnaServiceNeg.buscarByDominioByAplicacion(Constantes.DOMINIO_NIVEL_TIPIFICACION, Constantes.APPLICACION_MYC);
                    Long idNivel = listaNivel.get(0).getIdMaestroColumna(); 
                    for (String idTipoSancion : listadoTipoSancion) {
                        TipificacionSancionDTO tipificacionSancionDTO = new TipificacionSancionDTO();
                        tipificacionSancionDTO.setIdTipiSanc(null);
                        tipificacionSancionDTO.setIdTipificacion(tipificacionDTO.getIdTipificacion());
                        tipificacionSancionDTO.setIdTipoSancion(new Long(idTipoSancion));
                        MaestroColumnaDTO nivel = new MaestroColumnaDTO();
                        nivel.setIdMaestroColumna(idNivel);
                        tipificacionSancionDTO.setNivel(nivel);
                        tipificacionSancionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);

                        tipificacionSancionDTO = tipificacionSancionServiceNeg.guardarTipificacionSancion(tipificacionSancionDTO, usuarioDTO);
                    }
                }

                retorno.put("idTipificacion",tipificacionDTO.getIdTipificacion());
                retorno.put("tipificacion",tipificacionDTO);
                retorno.put("resultado", 0);
            }
        }catch(Exception ex){
            LOG.error("Error en registrarTipificacion: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value="/registrarTipificacionSancion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarTipificacionSancion(String idTipificacion, String idTipoSancion/*ZonificacionDetalleDTO zonificacionDetalleDTO*/){
        LOG.info("procesando registrarTipificacionSancion");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            TipificacionSancionDTO tipificacionSancionDTO = new TipificacionSancionDTO();
            
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            try{
            	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            	String usuario = ConstantesWeb.getUSUARIO(request);
            	usuarioDTO.setCodigo(usuario);
            }catch(Exception e){
            	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
            }
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            tipificacionSancionDTO.setIdTipiSanc(null);
            tipificacionSancionDTO.setIdTipificacion(new Long(idTipificacion));
            tipificacionSancionDTO.setIdTipoSancion(new Long(idTipoSancion));
            tipificacionSancionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
            tipificacionSancionDTO = tipificacionSancionServiceNeg.guardarTipificacionSancion(tipificacionSancionDTO, usuarioDTO);
            
            retorno.put("idTipiSanc",tipificacionSancionDTO.getIdTipificacion());
            retorno.put("tipificacionSancion",tipificacionSancionDTO);
            retorno.put("resultado", 0);
        }catch(Exception ex){
            LOG.error("Error en registrarTipificacionSancion: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value="/editarTipificacion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarTipificacion(String idTipificacion, String codigoTipificacion, String tipoSancion, String tipoMoneda, String sancionMonetaria, String descripcion, String basesLegales, String tipificacionPadre, String tipoSanciones/*ZonificacionDetalleDTO zonificacionDetalleDTO*/){
        LOG.info("procesando editarTipificacion");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            TipificacionDTO tipificacionDTO = new TipificacionDTO();
            TipificacionDTO tipificacionValidar = new TipificacionDTO();
            
            tipificacionValidar = tipificacionserviceNeg.obtenerTipificacion(codigoTipificacion,basesLegales);
            if(tipificacionValidar != null && !tipificacionValidar.getIdTipificacion().equals(new Long(idTipificacion)) ){
                retorno.put("resultado", 1);
                retorno.put("mensaje", "No se puede editar la tipificaci&oacute;n con el mismo c&oacute;digo y base legal");
            }else{
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                try{
                	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                	String usuario = ConstantesWeb.getUSUARIO(request);
                	usuarioDTO.setCodigo(usuario);
                }catch(Exception e){
                	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
                }
                usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());

                tipificacionDTO.setIdTipificacion(new Long(idTipificacion));
                tipificacionDTO.setCodTipificacion(codigoTipificacion);
                if(!tipoMoneda.equals("")){
                    tipificacionDTO.setIdTipoMoneda(new Long(tipoMoneda));
                }
                tipificacionDTO.setSancionMonetaria(sancionMonetaria);
                tipificacionDTO.setDescripcion(descripcion);
                tipificacionDTO.setBasesLegales(basesLegales);
                if(!tipificacionPadre.equals("")){
                    tipificacionDTO.setIdTipificacionPadre(new Long(tipificacionPadre));
                }
                tipificacionDTO.setClaseSancion(new Long(tipoSancion));
                tipificacionDTO.setActivo(Constantes.CONSTANTE_ESTADO_ACTIVO);

                tipificacionDTO = tipificacionserviceNeg.guardaTipificacion(tipificacionDTO, usuarioDTO);

                //retirar todas las tipificacSancion ya existentes
                //listado de todas las sanciones de Base de Datos
                TipificacionDTO registro=tipificacionserviceNeg.obtenerTipificacionNivel(new Long(idTipificacion));
                List<TipificacionSancionDTO> lista=registro.getListaTipificacionSancion();
                //Listado de las sanciones actuales
                String[] listadoTipoSancion = tipoSanciones.split(",");
                LOG.info("sin cortar"+tipoSanciones);
                LOG.info("cortado"+listadoTipoSancion);
                List<TipificacionSancionDTO> listaActual=null;
                if(!tipoSanciones.equals("-1")){
                	listaActual=new ArrayList<TipificacionSancionDTO>();                
                    for(String idTipoSancion:listadoTipoSancion){
                    	TipificacionSancionDTO tipiSancion = new TipificacionSancionDTO();
                    	tipiSancion.setIdTipoSancion(new Long(idTipoSancion));
                    	listaActual.add(tipiSancion);                	
                    }
                }
                
                String cadenaAct="";
                String cadenaUpd="";
                if(lista!=null && !lista.equals("")){
                	cadenaAct=MycUtil.concatenaTipificacionSancion(lista);
                    LOG.info("Listado Base de Datos( Bases en Concordancia ): "+cadenaAct);
                }
                if(listaActual!=null && !listaActual.equals("")){
                	cadenaUpd=MycUtil.concatenaTipificacionSancion(listaActual);
                    LOG.info("Listado por Actualizar( Bases en Concordancia ): "+cadenaUpd);
                }
                
                List<MaestroColumnaDTO> listaNivel= maestroColumnaServiceNeg.buscarByDominioByAplicacion(Constantes.DOMINIO_NIVEL_TIPIFICACION, Constantes.APPLICACION_MYC);
                Long idNivel = listaNivel.get(0).getIdMaestroColumna();
                
                if(!tipoSanciones.equals("-1")){
                	
                	if(!cadenaAct.equals(cadenaUpd)){
                        LOG.info("SE PROCEDE A ACTUALIZAR LISTADO DE BASES LEGALES EN CONCORDANCIA");
                        //se comparan las cadenas <--> insertar cuando no existen
                        for(TipificacionSancionDTO regBase: listaActual){
                            boolean existe=MycUtil.existeIdSancionEnLista(regBase.getIdTipoSancion(),lista);
                            if(!existe){
                                LOG.info("Nuevo TipiSancion-->"+regBase.getIdTipoSancion());
                                TipificacionSancionDTO encontrado = tipificacionSancionServiceNeg.buscarTipificacionSancionNivel(regBase.getIdTipoSancion(),tipificacionDTO.getIdTipificacion(),idNivel);
                                if(encontrado!=null){
                                	TipificacionSancionDTO tipificacionSancionDTO = new TipificacionSancionDTO();                                    
                                    tipificacionSancionDTO.setIdTipiSanc(encontrado.getIdTipiSanc());
                                    tipificacionSancionDTO.setIdTipificacion(tipificacionDTO.getIdTipificacion());
                                    tipificacionSancionDTO.setIdTipoSancion(regBase.getIdTipoSancion());
                                    tipificacionSancionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                                    
                                    MaestroColumnaDTO nivel = new MaestroColumnaDTO();
                                    nivel.setIdMaestroColumna(idNivel);
                                    tipificacionSancionDTO.setNivel(nivel);
                                    tipificacionSancionDTO = tipificacionSancionServiceNeg.guardarTipificacionSancion(tipificacionSancionDTO, usuarioDTO);
                                	
                                }else{
                                	TipificacionSancionDTO tipificacionSancionDTO = new TipificacionSancionDTO();
                                    
                                    tipificacionSancionDTO.setIdTipiSanc(null);
                                    tipificacionSancionDTO.setIdTipificacion(tipificacionDTO.getIdTipificacion());
                                    tipificacionSancionDTO.setIdTipoSancion(regBase.getIdTipoSancion());
                                    tipificacionSancionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                                    MaestroColumnaDTO nivel = new MaestroColumnaDTO();
                                    nivel.setIdMaestroColumna(idNivel);
                                    tipificacionSancionDTO.setNivel(nivel);
                                    tipificacionSancionDTO = tipificacionSancionServiceNeg.guardarTipificacionSancion(tipificacionSancionDTO, usuarioDTO);
                                }                           
                            }
                        }
                        //se comparan las cadenas <--> eliminan cuando no se encuentra en el nuevo listado
                        for(TipificacionSancionDTO regBase:lista){
                            boolean existe=MycUtil.existeIdSancionEnLista(regBase.getIdTipoSancion(),listaActual);
                            if(!existe){
                                LOG.info("Eliminado logico TipiSancion-->"+regBase.getIdTipoSancion());
                                TipificacionSancionDTO tipifSanc = new TipificacionSancionDTO();
                                tipifSanc.setIdTipoSancion(regBase.getIdTipoSancion());
                                tipifSanc.setIdTipiSanc(regBase.getIdTipiSanc());
                                tipificacionSancionServiceNeg.eliminarTipificacionSancion(tipifSanc);
                            }
                        }
                    }

                }else{
                	
                	if(lista!=null && !lista.isEmpty()){
                        LOG.info("----------->encontro,"+lista);
                        for(TipificacionSancionDTO tipifSanc:lista){
                            tipificacionSancionServiceNeg.eliminarTipificacionSancion(tipifSanc);
                        }
                    }
                }

                retorno.put("idTipificacion",tipificacionDTO.getIdTipificacion());
                retorno.put("tipificacion",tipificacionDTO);
                retorno.put("resultado", 0);
            }
        }catch(Exception ex){
            LOG.error("Error en editarTipificacion: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value = "/eliminarTipificacion", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarTipificacion(Long idTipificacion){
        LOG.info("procesando eliminarTipificacion");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            TipificacionDTO tipificacionDTO = new TipificacionDTO();
            tipificacionDTO.setIdTipificacion(idTipificacion);
            tipificacionDTO.setActivo(Constantes.CONSTANTE_ESTADO_INACTIVO);
            
            tipificacionDTO = tipificacionserviceNeg.eliminarTipificacion(tipificacionDTO);
            
            retorno.put("tipificacion",tipificacionDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en eliminarTipificacion: "+ex.getMessage());
        }
        return retorno;
    }
}
