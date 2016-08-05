/**
* Resumen.
* Objeto                            :              InpsController.java.
* Descripción                   	:              Controller encargado de los metodos del menu INPS.
* Fecha de Creación     			:              23/05/2016
* Autor                             :              mdiosesf.
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                              		Fecha                             Nombre                              Descripción
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                       Mario Dioses                  			
*/
package gob.osinergmin.myc.controller;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.business.ObligacionTipoServiceNeg;
import gob.osinergmin.myc.service.business.UnidadOrganicaServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/inps")
public class InpsController {
    private static final Logger LOG = LoggerFactory.getLogger(InpsController.class);
    @Value("${unidad.organica.nivel.gerencia}")
    private Long nivelGerencia;
    @Value("${unidad.organica.max.nivel}")
    private Long maxNivelDivision;
    
    @Inject
    UnidadOrganicaServiceNeg unidadOrganicaServiceNeg;
    
    @Inject 
    private ObligacionTipoServiceNeg obligacionTipoNeg;
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_INPS;
    }
    
    @RequestMapping(value="/filtroEmpSupervisoras", method = RequestMethod.GET)
    public String inicioEmpSupervisadas(Model model, HttpSession sesion,HttpServletRequest request) {
        try{
            model.addAttribute("fecha", ConstantesWeb.getFECHA());
            model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
            model.addAttribute("maxNivelDivision", maxNivelDivision);
            model.addAttribute("listaUnidadOrganicaGerencia", unidadOrganicaServiceNeg.findUnidadOrganica(new UnidadOrganicaFilter(null, null, nivelGerencia)));
        }catch(Exception e){
                LOG.error("Error en inicioEmpSupervisadas",e);
        }
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_FILTROEMPSUPERVISORAS_INPS;
    }
    
    @RequestMapping(value="/seleccionMuestral", method = RequestMethod.GET)
    public String inicioSeleccionMuestral(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        String identificador = Constantes.IDENTIFICADOR_SELECCION_MUESTRAL;
        model.addAttribute("listadoTipoSupervision",obligacionTipoNeg.listaObligacionTipoSelecccionMuestral(identificador));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_SELECCION_MUESTRAL;
    }
}
