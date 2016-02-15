/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.util.ConstantesWeb;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jpiro
 */
@Controller
@RequestMapping("/commonRequisitos")
public class CommonRequisitoController {
    private static final Logger LOG = LoggerFactory.getLogger(CommonRequisitoController.class);
    
    /**
     * @param seleccion, "multiple" o "individual" tipo de seleccion en el arbol de actividades
     */
    @RequestMapping(value = "/abrirPopupBusqActividad", method = RequestMethod.GET)
    public String abrirPopupBusqActividad ( String seleccion, Long idProcedimiento,Long idTramite,HttpSession sesion , HttpServletRequest request , Model model, String codActividad) {
        LOG.info("abrirPopupBusqActividad");
        model.addAttribute("seleccion", seleccion);
        model.addAttribute("idProcedimientoAct", idProcedimiento);
        model.addAttribute("idTramiteAct", idTramite);
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_FRM_SELECT_ACTIVIDADES;
    }	
}
