/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.DistritoDTO;
import gob.osinergmin.myc.domain.dto.ProvinciaDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDetalleDTO;
import gob.osinergmin.myc.domain.ui.UbigeoFilter;
import gob.osinergmin.myc.service.business.UbigeoServiceNeg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jpiro
 */
@Controller
@RequestMapping("/ubigeo")
public class UbigeoController {
    private static final Logger LOG = LoggerFactory.getLogger(PrincipalController.class);
    @Inject
    UbigeoServiceNeg ubigeoServiceNeg;
    
    @RequestMapping(value = "/listarProvincias", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> listarProvincias(UbigeoFilter filtro, HttpSession session) {
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
            LOG.info("procesando listarProvincias:" + filtro.getIdDepartamento());
            List<ProvinciaDTO> listado = null;
            listado = ubigeoServiceNeg.obtenerListadoProvincias(filtro);
            
            listaResultado.put("lista", listado);
        }catch(Exception e){
            LOG.error("", e);
        }
        return listaResultado;
    }
    
    @RequestMapping(value = "/listarDistritos", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> listarDistritos(UbigeoFilter filtro, HttpSession session) {
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
            LOG.info("procesando listarDistrito:" + filtro.getIdDepartamento()+" - "+filtro.getIdProvincia());
            Map<String,Object> retorno=new HashMap<String,Object>();
            List<DistritoDTO> listado = null;
            listado = ubigeoServiceNeg.obtenerListadoDistritos(filtro);
            
            listaResultado.put("lista", listado);
            retorno.put("filas", listado);
            retorno.put("total", listado.size());
        }catch(Exception e){
            LOG.error("", e);
        }
        return listaResultado;
    }
    
    @RequestMapping(value = "/listarZonificacionDetalle", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> listarZonificacionDetalle(UbigeoFilter filtro, HttpSession session) {
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
            LOG.info("procesando listarZonificacion:" + filtro.getIdDepartamento()+" - "+filtro.getIdProvincia()+" - "+filtro.getIdDistrito());
            List<ZonificacionDetalleDTO> listado = null;
            listado = ubigeoServiceNeg.listarZonificacionDetalle(filtro);
            
            listaResultado.put("lista", listado);
        }catch(Exception e){
            LOG.error("", e);
        }
        return listaResultado;
    }
}
