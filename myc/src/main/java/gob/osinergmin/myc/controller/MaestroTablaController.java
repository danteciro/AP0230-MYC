/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.MaestroTablaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.MaestroTablaFilter;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.MaestroTablaServiceNeg;
import gob.osinergmin.myc.service.dao.MaestroTablaDAO;
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
 * @author lbarboza
 */
@Controller
@RequestMapping("/maestroTabla")
public class MaestroTablaController {
    private static final Logger LOG = LoggerFactory.getLogger(MaestroTablaController.class);
    @Inject
    private MaestroColumnaServiceNeg maestroColumnaServiceNeg;
    @Inject
    private MaestroTablaServiceNeg maestroTablaServiceNeg;
    @Inject
    private MaestroTablaDAO maestroTablaDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        try {
//            model.addAttribute("listadoDominio", maestroTablaServiceNeg.buscarDominios());
        } catch (Exception ex) {
            LOG.error("Error en inicio MaestroTablaController : "+ex.getMessage());
        }
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT_MAESTRO_TABLA;
    }
    
    @RequestMapping(value = "/abrirMantMaestroTabla", method = RequestMethod.GET)
    public String abrirMantMaestroColumna ( HttpSession sesion,Model model ) {
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT_MAESTRO_TABLA;
    }
    
    @RequestMapping(value = "/guardarMaestroTabla", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> guardarMaestroColumna(MaestroTablaDTO maestroTablaDTO,HttpServletRequest request, HttpSession session){
        LOG.info("procesando editarMaestroColumna");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            maestroTablaDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
            MaestroTablaDTO registro=maestroTablaServiceNeg.guardarMaestroTabla(maestroTablaDTO,usuarioDTO);
            
            salida.put("MaestroColumna",registro);
            salida.put("listadoAplicaciones",maestroTablaServiceNeg.buscarAplicaciones());
            salida.put("listadoDominios",maestroTablaServiceNeg.buscarDominios());
            salida.put(ConstantesWeb.VV_MENSAJE, "ok");
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
        } catch (Exception e) {
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            salida.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
        }
        return salida;
    }
    @RequestMapping(value = "/editarMaestroTabla", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> editarMaestroColumna(MaestroTablaDTO maestroTablaDTO,HttpServletRequest request, HttpSession session){
        LOG.info("procesando editarMaestroColumna");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            maestroTablaDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);

            MaestroTablaDTO registro=maestroTablaServiceNeg.editarMaestroTabla(maestroTablaDTO,usuarioDTO);
            
            salida.put("MaestroColumna",registro);
            salida.put("listadoAplicaciones",maestroTablaServiceNeg.buscarAplicaciones());
            salida.put("listadoDominios",maestroTablaServiceNeg.buscarDominios());
            salida.put(ConstantesWeb.VV_MENSAJE, "ok");
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
        } catch (Exception e) {
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            salida.put(ConstantesWeb.VV_MENSAJE, "Error al procesar");
            e.printStackTrace();
        }
        return salida;
    }
    
    @RequestMapping(value="/findMaestroTabla",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> findMaestroColumna(MaestroTablaFilter filtro,int rows, int page,int flg_load,HttpSession session){
        LOG.info("findRequisito");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<MaestroTablaDTO> listado;
            int total=0;
            Integer cuenta;
            
            if(flg_load==1){
                int inicio;
                inicio=rows*page-rows;
                
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                
                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                
                listado=maestroTablaServiceNeg.listarMaestroTabla(filtro, auxiliar);
                LOG.info("Cuenta Controller findMaestroTabla="+auxiliar[0]);
                //LOG.info("Cuenta Controller ="+listado.size());
                if(listado!=null){
	            	Long contador = new Long(listado.size());
		            int indiceInicial = (page - 1) * rows;
		            int indiceFinal = indiceInicial + rows;
		            List<MaestroTablaDTO> listaConfiguracion = new ArrayList<MaestroTablaDTO>();
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
}
