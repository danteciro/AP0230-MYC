/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.AutoayudaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.AutoayudaFilter;
import gob.osinergmin.myc.service.business.AutoayudaServiceNeg;
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

/**
 *
 * @author jpiro
 */
@Controller
@RequestMapping("/autoayuda")
public class AutoAyudaController {
    private static final Logger LOG = LoggerFactory.getLogger(AutoAyudaController.class);
    
    @Inject
    private AutoayudaServiceNeg autoayudaServiceNeg;
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_AUTOAYUDA;
    }
    
    @RequestMapping(value="/listarAutoAyuda",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> listarAutoAyuda(AutoayudaFilter filtro,int rows, int page,HttpSession session,HttpServletRequest request){
        LOG.info("listarAutoAyuda");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<AutoayudaDTO> listado=autoayudaServiceNeg.listarAutoayuda(filtro);
            Long contador = (long) listado.size();
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<AutoayudaDTO> listadoPaginado = listado.subList(indiceInicial, indiceFinal > listado.size() ? listado.size() : indiceFinal );
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
               
            retorno.put("total", numeroFilas);
            retorno.put("pagina", page);
            retorno.put("registros", contador);
            retorno.put("filas", listadoPaginado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value = "/editarAutoayuda", method = RequestMethod.POST)
    public @ResponseBody 
        Map<String, Object> editarAutoayuda(AutoayudaDTO autoayudaDTO,HttpServletRequest request, HttpSession session){
        LOG.info("procesando POST para editarAutoayuda");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
        	
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());

            AutoayudaDTO retorno=autoayudaServiceNeg.editarAutoayuda(autoayudaDTO,usuarioDTO);
            LOG.info("(Actualiza Autoayuda) retorno: "+retorno.toString());
            	
            String mensaje = "";
            salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);        	
     
        } catch (Exception e) {
            LOG.error("Error al editar auitoayuda",e);
            String mensaje = "Error al editar Autoayuda.";
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
        }
        return salida;
    }
}
