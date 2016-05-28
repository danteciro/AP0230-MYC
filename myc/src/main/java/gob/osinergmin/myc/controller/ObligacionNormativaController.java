package gob.osinergmin.myc.controller;
import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;
import gob.osinergmin.myc.util.ConstantesWeb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author gvillanueva
 */
@Controller
@RequestMapping("/obligacionNormativa")
public class ObligacionNormativaController {
    private static final Logger LOG = LoggerFactory.getLogger(ObligacionNormativaController.class);
    
    @RequestMapping(method=RequestMethod.GET)
    public String inicio(){
       return ConstantesWeb.Navegacion.PAGE_INICIO_MANTENIMIENTO_OBLIGACIONNORMATIVA;
    }
    @RequestMapping(value = "/abrirArbolActividad", method = RequestMethod.GET)
    public String abrirArbolActividad( HttpSession sesion,Model model ) {
        return ConstantesWeb.Navegacion.PAGE_OBLIGACIONES_FORM_ARBOLACTIVIDADES;
    }
     /**
     * 
     * @param codigo
     * @param pep
     * @param rows
     * @param page
     * @param session
     * @return 
     */
    @RequestMapping(value = "/findObligacion", method = RequestMethod.GET)
    public @ResponseBody
	Map<String, Object> findObligacion(String codigo,String pep,int rows, int page, HttpSession session,HttpServletRequest request) {
		
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        LOG.info("procesando GET para RequestMapping /findObligacion " +pep);
      
            int total=0 ;
            Integer cuenta=0;
            
            List<ObligacionNormativaDTO> listado =(List<ObligacionNormativaDTO>) request.getSession().getServletContext().getAttribute("LISTA_OBLIGACIONES");
            
            //List<ObligacionNormativaDTO> listado =(List<ObligacionNormativaDTO>) servletContext.getAttribute("LISTA_OBLIGACIONES");
            
           //List<ObligacionNormativaDTO> listado =(List<ObligacionNormativaDTO>) session.getAttribute("LISTA_OBLIGACIONES");
           
           
           listaResultado.put("total", total);
            listaResultado.put("pagina", page);
            listaResultado.put("registros", cuenta);
            listaResultado.put("filas", listado);

        return listaResultado;
    }
    /**
     * 
     * @param codigoTipificacion
     * @param codigoObligacion
     * @param descripcionCriterio
     * @param pauta
     * @param sancion
     * @param request
     * @param session
     * @return 
     */
//    @RequestMapping(value = "/registrarCriterio", method = RequestMethod.POST)
//    public @ResponseBody
//        Map<String, Object> registrarCriterio(String codigoTipificacion,String tieneAct,String codigoObligacion, String descripcionCriterio, String pauta, String sancion,HttpServletRequest request, HttpSession session){
//        LOG.info("procesando POST para RequestMapping /registrar POST");
//        Map<String, Object> salida = new HashMap<String, Object>();
//        List<CriterioDTO> listaCriterios = (List<CriterioDTO>)request.getSession().getServletContext().getAttribute("LISTA_CRITERIOS");
//        CriterioDTO criterio = new CriterioDTO();
//        criterio.setCodigoObligacion(codigoObligacion);
//        criterio.setDescripcionCriterio(descripcionCriterio);
//        criterio.setPauta(pauta);
//        criterio.setSancion(sancion);
//        criterio.setIdTipificacion(codigoTipificacion);
//        criterio.setTieneAct(tieneAct);
//        listaCriterios.add(criterio);
//        salida.put("resultado", 0);
//        return salida;
//    }
    /**
     * 
     * @param codigo
     * @param pep
     * @param rows
     * @param page
     * @param session
     * @return 
     */
//    @RequestMapping(value = "/findCriterio", method = RequestMethod.GET)
//    public @ResponseBody
//	Map<String, Object> findCriterio(String pep,int rows, int page, HttpSession session,HttpServletRequest request) {
//        Map<String, Object> listaResultado = new HashMap<String, Object>();
//        
//        int total=0 ;
//        Integer cuenta=0;
//        
//        List<CriterioDTO> listado = (List<CriterioDTO>) request.getSession().getServletContext().getAttribute("LISTA_CRITERIOS");
//        List<CriterioDTO> listaFiltro = new ArrayList<CriterioDTO>();
//        for(CriterioDTO criterio : listado){
//            if(criterio.getCodigoObligacion().equals(pep)){
//                listaFiltro.add(criterio);
//            }
//        }
//        
//        listaResultado.put("total", total);
//        listaResultado.put("pagina", page);
//        listaResultado.put("registros", cuenta);
//        listaResultado.put("filas", listaFiltro);
//        
//        return listaResultado;
//    }
    
    /**
     * 
     * @param request
     * @param pep
     * @param rows
     * @param page
     * @param session
     * @return 
     */
    @RequestMapping(value = "/findConfirmacion", method = RequestMethod.GET)
    public @ResponseBody
	Map<String, Object> findConfirmacion(String pep,int rows, int page, HttpSession session,HttpServletRequest request) {
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        
        int total=0 ;
        Integer cuenta=0;
        
        List<ObligacionNormativaDTO> listado = new ArrayList<ObligacionNormativaDTO>();//(List<ObligacionNormativaDTO>) request.getSession().getServletContext().getAttribute("LISTA_CONFIRMACION");
        ObligacionNormativaDTO ob = new ObligacionNormativaDTO();
        if(pep.equals("1")){
            ob.setCodigoObligacion("1");
            ob.setDescripcionObligacion("Prueba de obligacion");
            listado.add(ob);
        }else{
            for(int i=0;i<5;i++){
                ob.setCodigoObligacion(""+i);
                ob.setDescripcionObligacion("Prueba de obligacion "+i);
                listado.add(ob);
            }
        }
        List<ObligacionNormativaDTO> listaFiltro = new ArrayList<ObligacionNormativaDTO>();
        for(ObligacionNormativaDTO obligacion : listado){
            listaFiltro.add(obligacion);
        }
        
        listaResultado.put("total", total);
        listaResultado.put("pagina", page);
        listaResultado.put("registros", cuenta);
        listaResultado.put("filas", listaFiltro);
        
        return listaResultado;
    }
}
