package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;
import gob.osinergmin.myc.domain.dto.SancionEspecificaDTO;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.util.ConstantesWeb;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author gvillanueva
 */
@Controller
@RequestMapping("/indice")
public class IndiceController {
    private static final Logger LOG = LoggerFactory.getLogger(PrincipalController.class);
    
//    @Autowired
//    ServletContext servletContext;
//    List<SancionEspecificaDTO> listaSanciones=new ArrayList<SancionEspecificaDTO>();
//    List<BaseLegalDTO> listaBasesLegales=new ArrayList<BaseLegalDTO>(); 
//    List<ObligacionNormativaDTO> listaObligacionesNormativas=new ArrayList<ObligacionNormativaDTO>();
//    List<TipificacionDTO> listaTipificaciones=new ArrayList<TipificacionDTO>();
//    List<CriterioDTO> listaCriterios=new ArrayList<CriterioDTO>();
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model,HttpSession session,HttpServletRequest request) {
//        if(listaBasesLegales ==null)
//        {
//        listaSanciones=new ArrayList<SancionEspecificaDTO>();
//        listaBasesLegales=new ArrayList<BaseLegalDTO>(); 
//        listaObligacionesNormativas=new ArrayList<ObligacionNormativaDTO>();  
//        listaTipificaciones=new ArrayList<TipificacionDTO>();
//        listaCriterios=new ArrayList<CriterioDTO>();
//        }
//        
//       
//        //request ServletContext
//        request.getSession().getServletContext().setAttribute("LISTA_SANCIONESESPECIFICAS", listaSanciones);
//        request.getSession().getServletContext().setAttribute("LISTA_BASES_LEGALES", listaBasesLegales);
//        request.getSession().getServletContext().setAttribute("LISTA_OBLIGACIONES", listaObligacionesNormativas);
//        request.getSession().getServletContext().setAttribute("LISTA_TIPIFICACIONES", listaTipificaciones);
//        request.getSession().getServletContext().setAttribute("LISTA_CRITERIOS", listaCriterios);
//        /*servletContext*/
////        servletContext.setAttribute("LISTA_BASES_LEGALES", listaBasesLegales);
////        servletContext.setAttribute("LISTA_OBLIGACIONES", listaObligacionesNormativas);
//        /*sessiones*/
////        session.setAttribute("LISTA_BASES_LEGALES", listaBasesLegales);  
////        session.setAttribute("LISTA_OBLIGACIONES", listaObligacionesNormativas);
    	model.addAttribute("fecha", ConstantesWeb.getFECHA());
    	model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
    	return ConstantesWeb.Navegacion.PAGE_INICIO_INDICE;
    }
    
       
}
