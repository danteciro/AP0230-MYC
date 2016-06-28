/**
 * Resumen.
 * Objeto                   : MaestroColumnaController.java 
 * Descripción              : 
 * Fecha de Creación        : 
 * PR de Modificacion 		: 
 * Autor                    : 
 * ---------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo   	    Fecha     	  Nombre                 Descripcion
 * OSINE_119		15/06/2016	  Roy Colorado			 Se agregaron los métodos:
 * 														 obtenerMedidaSeguridad();
 * 														 obtenerAccionInfraccion();
 * 														 obtenerEscenario();
 * ----------------------------------------------------------------------------------------                                          
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.MaestroColumnaFilter;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.MaestroTablaServiceNeg;
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
@RequestMapping("/maestroColumna")
public class MaestroColumnaController {
    private static final Logger LOG = LoggerFactory.getLogger(MaestroColumnaController.class);
    @Inject
    private MaestroColumnaServiceNeg maestroColumnaServiceNeg;
    @Inject
    private MaestroTablaServiceNeg maestroTablaServiceNeg;
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        try {
            //model.addAttribute("listadoDominio", maestroTablaServiceNeg.buscarDominios());
            model.addAttribute("listadoAplicaciones",maestroTablaServiceNeg.buscarAplicaciones());
            model.addAttribute("listadoDominios",maestroTablaServiceNeg.buscarDominios());       
        } catch (Exception ex) {
            LOG.error("Error en inicio MaestroColumnaController : "+ex.getMessage());
        }
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT_MAESTRO_COLUMNA;
    }
    
    @RequestMapping(value = "/abrirMantMaestroColumna", method = RequestMethod.GET)
    public String abrirMantMaestroColumna ( String tipo, Long idMaestroColumna,HttpSession sesion,Model model ) {
        LOG.info("abrirMantRequisito");
        try{
            model.addAttribute("tipo", tipo);
            model.addAttribute("listadoAplicaciones",maestroTablaServiceNeg.buscarAplicaciones());
            model.addAttribute("listadoDominios",maestroTablaServiceNeg.buscarDominios());       
            if(!tipo.equals("new") && idMaestroColumna!=null){
                MaestroColumnaDTO registro=registro=maestroColumnaServiceNeg.findById(idMaestroColumna);
                model.addAttribute("r", registro);
            }
        }catch(Exception e){
            LOG.error("Error abrirMantMaestroColumna",e);
        }        
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT_FRM_MAESTRO_COLUMNA;
    }
    
    @RequestMapping(value = "/editarMaestroColumna", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> editarMaestroColumna(MaestroColumnaDTO maestroColumnaDTO,HttpServletRequest request, HttpSession session){
        LOG.info("procesando editarMaestroColumna");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            maestroColumnaDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);

            MaestroColumnaDTO registro=maestroColumnaServiceNeg.actualizarMaestroColumna(maestroColumnaDTO,usuarioDTO);
            
            salida.put("MaestroColumna",registro);
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
            salida.put(ConstantesWeb.VV_MENSAJE, "ok");
        } catch (Exception e) {
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            salida.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en editarMaestroColumna",e);
        }
        return salida;
    }
    @RequestMapping(value = "/guardarMaestroColumna", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> guardarMaestroColumna(MaestroColumnaDTO maestroColumnaDTO,HttpServletRequest request, HttpSession session){
        LOG.info("procesando editarMaestroColumna");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            maestroColumnaDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);

            MaestroColumnaDTO registro=maestroColumnaServiceNeg.guardarMaestroColumna(maestroColumnaDTO,usuarioDTO);
            
            salida.put("MaestroColumna",registro);
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
            salida.put(ConstantesWeb.VV_MENSAJE, "ok");
        } catch (Exception e) {
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            salida.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en guardarMaestroColumna,",e);
        }
        return salida;
    }
    
    @RequestMapping(value = "/eliminarMaestroColumna", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> eliminarMaestroColumna(MaestroColumnaDTO maestroColumnaDTO,HttpServletRequest request, HttpSession session){
        LOG.info("procesando eliminarMaestroColumna");
        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            maestroColumnaDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);

            MaestroColumnaDTO registro=maestroColumnaServiceNeg.eliminarMaestroColumna(maestroColumnaDTO,usuarioDTO);
            
            salida.put("MaestroColumna",registro);
            salida.put(ConstantesWeb.VV_MENSAJE, "ok");
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
        } catch (Exception e) {
            salida.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
            salida.put(ConstantesWeb.VV_MENSAJE, "Error al procesar");
            e.printStackTrace();
        }
        return salida;
    }
    /*PR OSINE_119 - Item 11 - Inicio*/
    /**
     * Método que obtiene una lista de medidas de seguridad
     * @return listMedidaSeguridad
     */
    @RequestMapping(value = "/obtenerMedidaSeguridad", method = RequestMethod.GET)
    public @ResponseBody
    List<MaestroColumnaDTO> obtenerMedidaSeguridad() {
        List<MaestroColumnaDTO> listMedidaSeguridad = new ArrayList<MaestroColumnaDTO>();
        try{
        listMedidaSeguridad=maestroColumnaServiceNeg.listarMedidaSeguridad();
        }catch(Exception e){
            LOG.info("error al procesar listadoSigla " +e);
        }
        return listMedidaSeguridad;
    }
    
    /**
     * Método que obtiene una lista de infracciones
     * @return listAccionInfraccion
     */
    @RequestMapping(value = "/obtenerAccionInfraccion", method = RequestMethod.GET)
    public @ResponseBody
    List<MaestroColumnaDTO> obtenerAccionInfraccion() {
        List<MaestroColumnaDTO> listAccionInfraccion = new ArrayList<MaestroColumnaDTO>();
        try{
        listAccionInfraccion=maestroColumnaServiceNeg.listarAccionInfraccion();
        }catch(Exception e){
            LOG.info("error al procesar listadoSigla " +e);
        }
        return listAccionInfraccion;
    }
    
    
    /**
     * Método que obtiene una lista escenarios de incumplimiento
     * @return listMedidaSeguridad
     */
    @RequestMapping(value = "/obtenerEscenario", method = RequestMethod.GET)
    public @ResponseBody
    List<MaestroColumnaDTO> obtenerEscenario() {
        List<MaestroColumnaDTO> listEscenarioIncumplimiento = new ArrayList<MaestroColumnaDTO>();
        try{
        listEscenarioIncumplimiento=maestroColumnaServiceNeg.listarEscenario();
        }catch(Exception e){
            LOG.info("error al procesar listadoSigla " +e);
        }
        return listEscenarioIncumplimiento;
    }
    /*PR OSINE_119 - Item 11 - Fin*/
    @RequestMapping(value="/findMaestroColumna",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> findMaestroColumna(MaestroColumnaFilter filtro,int rows, int page,int flg_load,HttpSession session){
        LOG.info("findRequisito");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<MaestroColumnaDTO> listado;
            int total=0;
            Integer cuenta;
            
            if(flg_load==1){
                int inicio;
                inicio=rows*page-rows;
                
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                
                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                
                listado=maestroColumnaServiceNeg.listarMaestroColumna(filtro, auxiliar);
                LOG.info("Cuenta Controller findRequisito="+auxiliar[0]);
                //LOG.info("Cuenta Controller ="+listado.size());
                
                cuenta=auxiliar[0];
                if (cuenta > 0) {
                    total = (int) Math.ceil((double) cuenta / (double) rows);
                }

                retorno.put("total", total);
                retorno.put("pagina", page);
                retorno.put("registros", cuenta);
                retorno.put("filas", listado);                
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
}