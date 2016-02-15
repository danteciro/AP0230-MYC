/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDTO;
import gob.osinergmin.myc.domain.ui.ZonificacionFilter;
import gob.osinergmin.myc.service.business.ZonificacionServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 *
 * @author lbarboza
 */
@Controller
@RequestMapping("/zonificacion")
public class ZonificacionController {
    private static final Logger LOG = LoggerFactory.getLogger(ZonificacionController.class);
    
    @Autowired
    private ZonificacionServiceNeg zonificacionService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT_ZONIFICACION;
    }
    
    @RequestMapping(value="/listarZonificacion",method= RequestMethod.GET)
    public @ResponseBody Map<String, Object> listarZonificacion(ZonificacionFilter filter, int rows, int page, String sidx,
            String sord, HttpSession session){
        LOG.info("procesando listarZonificacion - inicio");
        LOG.info("-- nombre = "+filter.getNombre());
        Map<String,Object> retorno = new HashMap<String, Object>();
        try{
            List<ZonificacionDTO> listadoZonificacion = zonificacionService.obtenerListadoZonificacion(filter);
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<ZonificacionDTO> listaZonificacionPaginada = new ArrayList<ZonificacionDTO>();
            listaZonificacionPaginada = listadoZonificacion.subList(
                indiceInicial, indiceFinal > listadoZonificacion
                .size() ? listadoZonificacion.size()
                : indiceFinal);
        
            Long contador = new Long(listadoZonificacion.size()) ;
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listaZonificacionPaginada);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        LOG.info("procesando listarZonificacion - fin");
        return retorno;
    }
    
    @RequestMapping(value="/registrarZonificacion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarZonificacion(String nombreZonificacion/*ZonificacionDTO zonificacionDTO*/){
        LOG.info("procesando registrarZonificacion");
        LOG.info("-- nombreZonificacion = "+nombreZonificacion);
        nombreZonificacion=nombreZonificacion.replaceAll(" +", " ").trim();
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            ZonificacionDTO zonificacionDTO = new ZonificacionDTO();
            ZonificacionDTO zonificacionValidar = zonificacionService.obtenerZonificacionValidaNombre(nombreZonificacion);
            
            if(zonificacionValidar != null){
                retorno.put("resultado", 1);
                //retorno.put("mensaje", "No se puede registrar una zonificacion con el mismo nombre");
                retorno.put("mensaje", Constantes.CONSTANTE_MSJE_YA_EXISTE+" Zonificaci&oacute;n.");
            }else{
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setCodigo("00002");
                usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());

                zonificacionDTO.setNombre(nombreZonificacion);

                zonificacionDTO.setIdZonificacion(null);
                zonificacionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);

                zonificacionDTO = zonificacionService.guardarZonificacion(zonificacionDTO, usuarioDTO);

                retorno.put("idZoni",zonificacionDTO.getIdZonificacion());
                retorno.put("zonificacion",zonificacionDTO);
                retorno.put("resultado", 0);
            }
        }catch(Exception ex){
            LOG.error("Error en registrarZonificacion: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value="/editarZonificacion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarZonificacion(ZonificacionDTO zonificacionDTO){
        LOG.info("procesando editarZonificacion");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            ZonificacionDTO zonificacionValidar = zonificacionService.obtenerZonificacionValidaNombre(zonificacionDTO.getNombre());
            
            if(zonificacionValidar != null && !zonificacionValidar.getIdZonificacion().equals(zonificacionDTO.getIdZonificacion())){
                retorno.put("resultado", 1);
                //retorno.put("mensaje", "No se puede registrar una zonificacion con el mismo nombre");
                retorno.put("mensaje", Constantes.CONSTANTE_MSJE_YA_EXISTE+" Zonificaci&oacute;n.");
            }else{
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setCodigo("00002");
                usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());

                zonificacionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);

                zonificacionDTO = zonificacionService.guardarZonificacion(zonificacionDTO, usuarioDTO);

                retorno.put("zonificacion",zonificacionDTO);
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            }
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en editarZonificacion: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value = "/eliminarZonificacion", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarZonificacion(Long idZonificacion){
        LOG.info("procesando eliminarZonificacion");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            ZonificacionDTO zonificacionDTO = new ZonificacionDTO();
            zonificacionDTO.setIdZonificacion(idZonificacion);
            
            zonificacionDTO = zonificacionService.eliminarZonificacion(zonificacionDTO);
            
            retorno.put("zonificacion",zonificacionDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en eliminarZonificacion: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
}