/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.DistritoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDetalleDTO;
import gob.osinergmin.myc.domain.ui.ZonificacionFilter;
import gob.osinergmin.myc.service.business.UbigeoServiceNeg;
import gob.osinergmin.myc.service.business.ZonificacionDetalleServiceNeg;
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
@RequestMapping("/zonificacionDetalle")
public class ZonificacionDetalleController {
    private static final Logger LOG = LoggerFactory.getLogger(ZonificacionDetalleController.class);
    
    @Autowired
    private ZonificacionServiceNeg zonificacionServiceNeg;
    
    @Autowired
    private ZonificacionDetalleServiceNeg zonificacionDetalleServiceNeg;
    
    @Autowired
    private UbigeoServiceNeg ubigeoService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        model.addAttribute("listaDepartamentos", ubigeoService.obtenerListadoDepartamentos());
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT_ZONIFICACION_DETALLE;
    }
    
    /**
     * @param seleccion, "multiple" o "individual" tipo de seleccion en el arbol de Distritos
     */
    @RequestMapping(value = "/abrirPopupBusqDistrito", method = RequestMethod.GET)
    public String abrirPopupBusqActividad ( Long idZonificacion, String seleccion, String idDepartamento,String idProvincia,HttpSession sesion , HttpServletRequest request , Model model, String codActividad) {
        LOG.info("abrirPopupBusqDistrito");
        model.addAttribute("seleccion", seleccion);
        model.addAttribute("idDepartamento", idDepartamento);
        model.addAttribute("idProvincia", idProvincia);
        model.addAttribute("idZonificacion", idZonificacion);
        return ConstantesWeb.Navegacion.PAGE_GENERAL_FRM_SELECT_DISTRITO;
    }
    
    @RequestMapping(value = "/findZonificaciones", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> obtenerListadoZonificaciones(){
        LOG.info("procesando POST para RequestMapping /findZonificaciones");
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            //List<MaestroColumnaDTO> listaAmbitoParametro = maestroColumnaServiceNeg.buscarTodos(Constantes.DOMINIO_AMBITO_PARAMETRICO);
            ZonificacionFilter filter = new ZonificacionFilter();
            List<ZonificacionDTO> listaZonificaciones = zonificacionServiceNeg.obtenerListadoZonificacion(filter);
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
    
    @RequestMapping(value="/listarZonificacionDetalle",method= RequestMethod.GET)
    public @ResponseBody Map<String, Object> listarZonificacionDetalle(Long idZonificacion, int rows, int page, String sidx,
            String sord, HttpSession session){
        LOG.info("procesando listarZonificacion - inicio");
        LOG.info("-- idZonificacion = "+idZonificacion);
        Map<String,Object> retorno = new HashMap<String, Object>();
        try{
            List<ZonificacionDetalleDTO> listaZonificacionDetalle = zonificacionDetalleServiceNeg.obtenerListadoZonificacionDetalle(idZonificacion);
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<ZonificacionDetalleDTO> listaZonificacionDetallePaginada = new ArrayList<ZonificacionDetalleDTO>();
            listaZonificacionDetallePaginada = listaZonificacionDetalle.subList(
                indiceInicial, indiceFinal > listaZonificacionDetalle
                .size() ? listaZonificacionDetalle.size()
                : indiceFinal);
        
            Long contador = new Long(listaZonificacionDetalle.size()) ;
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listaZonificacionDetallePaginada);
            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/listarZonificacionDetalleAgregar",method= RequestMethod.GET)
    public @ResponseBody Map<String, Object> listarZonificacionDetalleAgregar(Long idZonificacion, int rows, int page, String sidx,
            String sord, HttpSession session){
        LOG.info("procesando listarZonificacion - inicio");
        LOG.info("-- idZonificacion = "+idZonificacion);
        Map<String,Object> retorno = new HashMap<String, Object>();
        try{
            List<ZonificacionDetalleDTO> listaZonificacionDetalle = zonificacionDetalleServiceNeg.obtenerListadoZonificacionDetalle(idZonificacion);
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<ZonificacionDetalleDTO> listaZonificacionDetallePaginada = new ArrayList<ZonificacionDetalleDTO>();
            listaZonificacionDetallePaginada = listaZonificacionDetalle.subList(
                indiceInicial, indiceFinal > listaZonificacionDetalle
                .size() ? listaZonificacionDetalle.size()
                : indiceFinal);
        
            Long contador = new Long(listaZonificacionDetalle.size()) ;
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listaZonificacionDetallePaginada);
            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/registrarZonificacionDetalle", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarZonificacionDetalle(Long idZonificacion, String idDepartamento, String idProvincia,String distritos){
//    public @ResponseBody Map<String,Object> registrarZonificacionDetalle(String idZonificacion, String idDepartamento, String idProvincia,String idDistrito/*ZonificacionDetalleDTO zonificacionDetalleDTO*/){
        LOG.info("procesando registrarZonificacionDetalle");
        LOG.info("-- distritos = "+distritos);
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00002");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            String[] collDistritos = distritos.split(",");
            for (String idDistrito : collDistritos) {
                LOG.info("-- idDistrito = "+idDistrito);
                ZonificacionDetalleDTO zonificacionDetalleDTO = new ZonificacionDetalleDTO();    
                zonificacionDetalleDTO.setIdZonificacionDetalle(null);
                zonificacionDetalleDTO.setIdZonificacion(idZonificacion);
                zonificacionDetalleDTO.setIdDepartamento(idDepartamento);
                zonificacionDetalleDTO.setIdProvincia(idProvincia);
                zonificacionDetalleDTO.setIdDistrito(idDistrito);
                zonificacionDetalleDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                zonificacionDetalleDTO = zonificacionDetalleServiceNeg.guardarZonificacionDetalle(zonificacionDetalleDTO, usuarioDTO);
            }
            retorno.put(ConstantesWeb.VV_RESULTADO,ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO,ConstantesWeb.VV_ERROR);
            LOG.error("Error en registrarZonificacionDetalle: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value="/editarZonificacionDetalle", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarZonificacionDetalle(ZonificacionDetalleDTO zonificacionDetalleDTO){
        LOG.info("procesando editarZonificacionDetalle");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            ZonificacionDetalleDTO detalleValidar = new ZonificacionDetalleDTO();
            
            detalleValidar = zonificacionDetalleServiceNeg.obtenerZonificacionDetalle(new Long(zonificacionDetalleDTO.getIdZonificacion()), new Long(zonificacionDetalleDTO.getIdDepartamento()), new Long(zonificacionDetalleDTO.getIdProvincia()), new Long(zonificacionDetalleDTO.getIdDistrito()));
            if(detalleValidar != null){
                retorno.put("resultado", 1);
                //retorno.put("mensaje", "No se puede editar el detalle con el mismo ubigeo");
                retorno.put("mensaje", Constantes.CONSTANTE_MSJE_YA_EXISTE+" Ubigeo.");
            }else{
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setCodigo("00002");
                usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());

                zonificacionDetalleDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);

                zonificacionDetalleDTO = zonificacionDetalleServiceNeg.guardarZonificacionDetalle(zonificacionDetalleDTO, usuarioDTO);

                retorno.put("zonificacionDetalle",zonificacionDetalleDTO);
                retorno.put("resultado", 0);
            }
        }catch(Exception ex){
            LOG.error("Error en editarZonificacionDetalle: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value = "/eliminarZonificacionDetalle", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarZonificacionDetalle(Long idZonificacionDetalle){
        LOG.info("procesando eliminarZonificacionDetalle");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            ZonificacionDetalleDTO zonificacionDetalleDTO = new ZonificacionDetalleDTO();
            zonificacionDetalleDTO.setIdZonificacionDetalle(idZonificacionDetalle);
            
            zonificacionDetalleDTO = zonificacionDetalleServiceNeg.eliminarZonificacionDetalle(zonificacionDetalleDTO);
            
            retorno.put("zonificacionDetalle",zonificacionDetalleDTO);
            retorno.put("resultado", 0);
        }catch(Exception ex){
            LOG.error("Error en eliminarZonificacionDetalle: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value = "/listarDistritosUnicos", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> listarDistritosUnicos(Long idZonificacion, Long idDepartamento, Long idProvincia, HttpSession session) {
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
            LOG.info("procesando listarDistrito:" + idZonificacion+" - "+idDepartamento+" - "+idProvincia );
            Map<String,Object> retorno=new HashMap<String,Object>();
            List<DistritoDTO> listado = null;
            listado = zonificacionDetalleServiceNeg.obtenerListadoDistritosUnicos(idZonificacion, idDepartamento, idProvincia);
            
            listaResultado.put("lista", listado);
            retorno.put("filas", listado);
            retorno.put("total", listado.size());
        }catch(Exception e){
            LOG.error("", e);
        }
        return listaResultado;
    }
}