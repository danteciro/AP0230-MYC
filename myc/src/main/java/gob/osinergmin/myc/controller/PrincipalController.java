package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.util.ConstantesWeb;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/principal")
public class PrincipalController {
    private static final Logger LOG = LoggerFactory.getLogger(PrincipalController.class);
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_INICIO;
    }
    @RequestMapping(value = "/mantenimiento")
    public String mantenimiento (Model model,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
	return ConstantesWeb.Navegacion.PAGE_GENERAL_INICIO_MANTENIMIENTO;
                
    }
    @RequestMapping(value = "/mantenimientoRequisitos")
    public String mantenimientoRequisitos (Model model,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
	return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT;
    }
    
    @RequestMapping(value = "/mantenimientoObligaciones")
    public String mantenimientoObligaciones (Model model,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_INICIO_INDICE;
    }
    
    @RequestMapping(value = "/mantenimientoGeneral")
    public String mantenimientoGeneral () {
	return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT;
    }
    
    @RequestMapping(value = "/configuracion")
    public String configuracion (Model model,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
	return ConstantesWeb.Navegacion.PAGE_GENERAL_INICIO_CONFIGURACION;
    }
    @RequestMapping(value = "/configuracionRequisitos")
    public String configuracionRequisitos (Model model,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
	model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_CONF;
    }
    
    @RequestMapping(value = "/configuracionRegistro")
    public String configuracionRegistro (Model model) {
	return ConstantesWeb.Navegacion.PAGE_REGISTRO_CONF;
    }
}
