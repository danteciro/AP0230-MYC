/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.MotivoTramiteDTO;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.MotivoTramiteFilter;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.business.MotivoTramiteNeg;
import gob.osinergmin.myc.service.business.TramiteServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
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
@RequestMapping("/tramite")
public class TramiteController {
    private static final Logger LOG = LoggerFactory.getLogger(PrincipalController.class);
    @Inject
    private TramiteServiceNeg tramiteServiceNeg;
    @Inject
    private MotivoTramiteNeg motivoTramiteNeg;
    
    @RequestMapping(value="/loadMotivoTramite",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> loadMotivoTramite(MotivoTramiteFilter filtro){
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            LOG.info("procesando loadMotivoTramite");
            List<MotivoTramiteDTO> listado;
            
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
            listado=motivoTramiteNeg.findMotivoTramiteByFilter(filtro);
            
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/loadTramite",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> loadTramite(TramiteFilter filtro){
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            LOG.info("procesando loadTramite");
            List<TramiteDTO> listado;
            
            //TramiteFilter filtro=new TramiteFilter();
            //filtro.setIdEtapa(idEtapa);
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
            listado=tramiteServiceNeg.findTramiteByFilter(filtro);
            
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/listarTramite",method=RequestMethod.GET)
    public @ResponseBody Map<String,Object> listarTramite(String idEtapa){
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            LOG.info("procesando loadTramite");
            List<TramiteDTO> listado;
            
            TramiteFilter filtro=new TramiteFilter();
            filtro.setIdEtapa(new Long(idEtapa));
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
            listado=tramiteServiceNeg.findTramiteByFilter(filtro);
            
            
            
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/listarTramiteUtil",method=RequestMethod.GET)
    public @ResponseBody Map<String,Object> listarTramiteUti(String idEtapa,int rows, int page){
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            LOG.info("procesando loadTramite");
            List<TramiteDTO> listado;
            
            TramiteFilter filtro=new TramiteFilter();
            filtro.setIdEtapa(new Long(idEtapa));
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
            listado=tramiteServiceNeg.findTramiteByFilter(filtro);
            
            if(listado!=null){
            	Long contador = new Long(listado.size());
	            int indiceInicial = (page - 1) * rows;
	            int indiceFinal = indiceInicial + rows;
	            List<TramiteDTO> listaConfiguracion = new ArrayList<TramiteDTO>();
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
            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/registrarTramite", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarTramite(String idEtapa, String descripcionTramite/*TramiteDTO tramiteDTO*/){
        LOG.info("procesando registrarTramite");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            TramiteDTO tramiteDTO = new TramiteDTO();
            
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00002");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            tramiteDTO.setIdEtapa(new Long(idEtapa));
            tramiteDTO.setDescripcion(descripcionTramite.toUpperCase().replaceAll(" +", " ").trim());
            LOG.info("--->"+tramiteDTO.getDescripcion());
            //tramiteDTO.getDescripcion().replaceAll(" +", " ");
            //LOG.info("--->"+tramiteDTO.getDescripcion());
            
            tramiteDTO.setIdTramite(null);
            tramiteDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
            tramiteDTO = tramiteServiceNeg.guardarTramite(tramiteDTO, usuarioDTO);
            
            retorno.put("idTramite",tramiteDTO.getIdTramite());
            retorno.put("tramite",tramiteDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, 0);
            retorno.put(ConstantesWeb.VV_MENSAJE, "OK");
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, 1);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en registrarTramite: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value = "/eliminarTramite", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarTramite(Long idTramite){
        LOG.info("procesando eliminarTramite");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            TramiteDTO tramiteDTO = new TramiteDTO();
            tramiteDTO.setIdTramite(idTramite);
            
            tramiteDTO = tramiteServiceNeg.eliminarTramite(tramiteDTO);
            
            retorno.put("tramite",tramiteDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en eliminarTramite: "+ex.getMessage());
        }
        return retorno;
    }
}