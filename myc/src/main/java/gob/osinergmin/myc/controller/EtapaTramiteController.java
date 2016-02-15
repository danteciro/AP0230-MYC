/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.EtapaFilter;
import gob.osinergmin.myc.service.business.EtapaServiceNeg;
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
@RequestMapping("/etapaTramite")
public class EtapaTramiteController {
    private static final Logger LOG = LoggerFactory.getLogger(EtapaTramiteController.class);
    
    @Autowired
    private EtapaServiceNeg etapaServiceNeg;
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT_ETAPA_TRAMITE;
    }
    
    @RequestMapping(value = "/abrirMantTramite", method = RequestMethod.GET)
    public String abrirMantTramite( String tipo, Long idEtapa, String txtEtapa,HttpSession sesion,Model model ) {
        try{
            model.addAttribute("tipo", tipo);
            model.addAttribute("idEtapa", idEtapa);
            model.addAttribute("txtEtapa", new String(txtEtapa.getBytes(), "UTF-8"));
        }catch(Exception e){
            LOG.error("error",e);
        }
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_TRAMITE;
    } 
    
    @RequestMapping(value="/listarEtapa",method= RequestMethod.GET)
    public @ResponseBody Map<String, Object> listarEtapa(String idProcesoBusqueda, String descripcion,int rows, int page, int flg_load, HttpSession session){
        LOG.info("procesando listarEtapa - inicio");
        Map<String,Object> retorno = new HashMap<String, Object>();
        try{
            int inicio = 0;
            List<EtapaDTO> listado = null;
            int total = 0;
            Integer cuenta = 0;
            
            EtapaFilter filtro = new EtapaFilter();
            
            if(flg_load==1){
                if(!idProcesoBusqueda.equals("0")){
                    filtro.setIdProceso(new Long(idProcesoBusqueda));
                    filtro.setDescripcion(descripcion);
                }else{
                    filtro.setIdProceso(null);
                }
                
                inicio = rows * page - rows;
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                int[] auxiliar = new int[1];//para el paso por referencia TODO cambiar?
                auxiliar[0] = 0;
                
                listado = etapaServiceNeg.findEtapaByFilter(filtro, auxiliar);

                cuenta = auxiliar[0];
                if (cuenta > 0) {
                    total = (int) Math.ceil((double) cuenta / (double) rows);
                }
                LOG.info("cuenta:" + cuenta);
            }
            
            retorno.put("total", total);
            retorno.put("pagina", page);
            retorno.put("registros", cuenta);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        LOG.info("procesando listarEtapa - fin");
        return retorno;
    }
    
    @RequestMapping(value="/registrarEtapa", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarEtapa(String idProceso, String descripcionEtapa/*ZonificacionDTO zonificacionDTO*/){
        LOG.info("procesando registrarEtapa");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            EtapaDTO etapaDTO = new EtapaDTO();
            
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00002");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            etapaDTO.setIdProceso(new Long(idProceso));
            etapaDTO.setDescripcion(descripcionEtapa.replaceAll(" +", " ").trim());
            
            etapaDTO.setIdEtapa(null);
            etapaDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
            List<EtapaDTO> listEtapa= new ArrayList<EtapaDTO>();
            listEtapa= etapaServiceNeg.validarEtapa(etapaDTO);
            
            if(listEtapa == null || listEtapa.size()==0){
            	
            	etapaDTO = etapaServiceNeg.guardarEtapa(etapaDTO, usuarioDTO);
 	            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
 	            retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
 	            retorno.put("resultado", 0);
 	            retorno.put("idEtapa",etapaDTO.getIdEtapa());
 	            retorno.put("etapa",etapaDTO);
 	            
 	            retorno.put("listadoEtapa", etapaServiceNeg.listarEtapaByDescProceso(Constantes.DESC_PROCESO_PRE_OPERATIVA));

             } else {
            	 retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.RESTRICT);  
             	 retorno.put(ConstantesWeb.VV_MENSAJE, Constantes.CONSTANTE_MSJE_YA_EXISTE+" Etapa.");
             }
            
              }catch(Exception ex){
            LOG.error("Error en registrarEtapa: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value="/editarEtapa", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarEtapa(EtapaDTO etapaDTO){
        LOG.info("procesando editarEtapa");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            List<EtapaDTO> listEtapa= new ArrayList<EtapaDTO>();
            listEtapa= etapaServiceNeg.validarEtapa(etapaDTO);
            
            if( (listEtapa == null || listEtapa.size()==0) || listEtapa.get(0).getIdEtapa().equals(etapaDTO.getIdEtapa()) ){
            
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setCodigo("00002");
                usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());

                etapaDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);

                etapaDTO = etapaServiceNeg.guardarEtapa(etapaDTO, usuarioDTO);

                retorno.put("etapa",etapaDTO);
                retorno.put("resultado", 0);
            }else {
                retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.RESTRICT);  
                retorno.put(ConstantesWeb.VV_MENSAJE, Constantes.CONSTANTE_MSJE_YA_EXISTE+" Etapa.");
            }
        }catch(Exception ex){
            LOG.error("Error en editarEtapa: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value = "/eliminarEtapa", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarEtapa(Long idEtapa){
        LOG.info("procesando eliminarEtapa");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            EtapaDTO etapaDTO = new EtapaDTO();
            etapaDTO.setIdEtapa(idEtapa);
            
            etapaDTO = etapaServiceNeg.eliminarEtapa(etapaDTO);
            
            retorno.put("etapa",etapaDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en eliminarEtapa: "+ex.getMessage());
        }
        return retorno;
    }
    
   
    
}