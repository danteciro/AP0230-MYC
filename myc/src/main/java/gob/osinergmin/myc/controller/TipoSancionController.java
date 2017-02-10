package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.TipoSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipoSancionFilter;
import gob.osinergmin.myc.service.business.TipoSancionServiceNeg;
import gob.osinergmin.myc.service.business.UbigeoServiceNeg;
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
/**
*
* @author dmedrano
*/
@Controller
@RequestMapping("/tipoSancion")
public class TipoSancionController {
    private static final Logger LOG = LoggerFactory.getLogger(PrincipalController.class);
    @Inject
    TipoSancionServiceNeg tipoSancionServiceNeg;
    @Inject
    UbigeoServiceNeg ubigeoServiceNeg;
	 
    @RequestMapping(value = "/abrirMantTipoSancion", method = RequestMethod.GET)
    public String abrirMantObligacionTipo( HttpSession sesion,Model model ) {
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_TIPO_SANCION;
    } 
    
    @RequestMapping(value = "/abrirPopupBusqSancAdm", method = RequestMethod.GET)
    public String abrirPopupBusqSancAdm ( String seleccion, HttpSession sesion , HttpServletRequest request , Model model, String codActividad) {
        LOG.info("abrirPopupBusqSancAdm");
        model.addAttribute("seleccion", seleccion);
        return ConstantesWeb.Navegacion.PAGE_GENERAL_FRM_SELECT_SANC_ADM;
    }
    
    @RequestMapping(value = "/listarTipoSancion", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> listarTipoSancion(TipoSancionFilter filtro, HttpSession session) {
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
            LOG.info("procesando listarTipoSancion:" + filtro.getDescripcion()+" - "+filtro.getIdTipoSancion());
            Map<String,Object> retorno=new HashMap<String,Object>();
            List<TipoSancionDTO> listado = null;
            int[] cuenta=new int[1];
            cuenta[0]=0;
            listado = tipoSancionServiceNeg.listarTipoSancion(filtro, cuenta);
            
            listaResultado.put("lista", listado);
            retorno.put("filas", listado);
            retorno.put("total", listado.size());
        }catch(Exception e){
            LOG.error("", e);
        }
        return listaResultado;
    }
    
    @RequestMapping(value="/findTipoSancion",method=RequestMethod.GET)
    public @ResponseBody Map<String,Object> findTipoSancion(TipoSancionFilter filtro,int rows, int page, int flg_load){
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
            LOG.info("procesando findTipoSancion");
            List<TipoSancionDTO> listado=new ArrayList<TipoSancionDTO>();
            int total=0;
            Integer cuenta=0;
            
            if(flg_load==1){
                int inicio;
                inicio=rows*page-rows;
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                
                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                listado=tipoSancionServiceNeg.listarTipoSancion(filtro, auxiliar);
                LOG.info("cuenta Controller findTipoSancion="+auxiliar[0]);

                cuenta=auxiliar[0];
                if (cuenta > 0) {
                    total = (int) Math.ceil((double) cuenta / (double) rows);
                }
            }         
            retorno.put("total", total);
            retorno.put("pagina", page);
            retorno.put("registros", cuenta);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    @RequestMapping(value="/registrarTipoSancion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarTipoSancion(TipoSancionDTO registro){
        LOG.info("procesando registrarTipoSancion");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00002");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            registro.setIdTipoSancion(null);
            registro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
            registro = tipoSancionServiceNeg.guardarTipoSancion(registro, usuarioDTO);
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en registrarProcesoObligacionTipo: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    @RequestMapping(value="/editarTipoSancion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarTipoSancion(TipoSancionDTO registro){
        LOG.info("procesando registrarTipoSancion");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00002");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            registro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
            registro = tipoSancionServiceNeg.guardarTipoSancion(registro, usuarioDTO);
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en editarTipoSancion: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    @RequestMapping(value="/eliminarTipoSancion", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> eliminarTipoSancion(TipoSancionDTO registro){
        LOG.info("procesando eliminarTipoSancion,"+registro.getIdTipoSancion());
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00002");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            //registro = tipoSancionServiceNeg.eliminarTipoSancion(registro, usuarioDTO);
            registro = tipoSancionServiceNeg.eliminarTipoSancion(registro);
            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en eliminarTipoSancion: "+ex.getMessage());
        }
        return retorno;
    }
    
}
