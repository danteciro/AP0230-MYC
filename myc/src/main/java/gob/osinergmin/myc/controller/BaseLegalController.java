package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.CnfObligacionDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;
import gob.osinergmin.myc.domain.ui.BaseLegalFilter;
import gob.osinergmin.myc.domain.ui.ObligacionFilter;
import gob.osinergmin.myc.service.business.BaseLegalServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.ObligacionNormativaServiceNeg;
import gob.osinergmin.myc.service.business.ObligacionTipoServiceNeg;
import gob.osinergmin.myc.util.ConstantesWeb;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.apache.log4j.Logger;
/**
 *
 * @author gvillanueva
 */
@Controller
@RequestMapping("/baseLegal")
public class BaseLegalController {
    private static final Logger LOG = LoggerFactory.getLogger(BaseLegalController.class);
    
    @Autowired
    ServletContext servletContext;
    
    @Autowired
    private BaseLegalServiceNeg baseLegalService;   
    
    @Autowired 
    private MaestroColumnaServiceNeg maestroColumnaService;
    
    @Autowired
    private ObligacionNormativaServiceNeg obligacionNormativaService;
    
    @Autowired
    private ObligacionTipoServiceNeg obligacionTipoService;
       
    //al cargar la página
    @RequestMapping(method=RequestMethod.GET)
    public String inicio(Model model,HttpServletRequest request) {
    	model.addAttribute("fecha", ConstantesWeb.getFECHA());
    	model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_INICIO_MANTENIMIENTO_BASE_LEGAL;
    }
    
    @InitBinder
    public void binder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat("dd/MM/yyyy").parse(value));
                } catch (ParseException e) {
                    setValue(null);
                }
            }

            public String getAsText() {
                return new SimpleDateFormat("dd/MM/yyyy")
                .format((Date) getValue());
            }

        });
    }
    
    /**
    * jpiro - Abre dialog asosciarBaseLegal al controlador DialogBusquedaAvanzadaBaseLegalController
    * @param model
    * @param session
    * @param redirectAttributes
    * @return
    */
    @RequestMapping ( value = "/abrirDialogAsociarBaseLegal" , method = RequestMethod.GET )
    public String abrirDialogAsociarBaseLegal(String variable, String idsBaseLegal, Model model,HttpSession session) {
        model.addAttribute("listTipoNormaLegal", maestroColumnaService.listarTipoNormaLegal());
        model.addAttribute("listSigla", maestroColumnaService.listarSigla());
        model.addAttribute("listTipoAnexo", maestroColumnaService.listarTipoAnexo());
                
        LOG.info("variable-->"+variable);
        model.addAttribute("variable", variable);
        model.addAttribute("idsBaseLegal", idsBaseLegal);
        return "moduloObligaciones/common/formAsociarBaseLegal";
    }
    
    /**
    * jpiro - Abre dialog asosciarBaseLegal al controlador DialogBusquedaAvanzadaBaseLegalController
    * @param model
    * @param session
    * @param redirectAttributes
    * @return
    */
    @RequestMapping ( value = "/abrirDialogAsociarObligacion" , method = RequestMethod.GET )
    public String abrirDialogAsociarObligacion(String idsObligacion, Model model,HttpSession session) {
        model.addAttribute("idsObligacion", idsObligacion);
        model.addAttribute("listCriticidad", maestroColumnaService.listarCriticidad());
        return "moduloObligaciones/common/formAsociarObligacion";
    }
    
    /**
     * 
     * @param filtro
     * @param rows
     * @param page
     * @param session
     * @return 
     */
    @RequestMapping(value = "/findBaseLegal", method = RequestMethod.GET)
    public @ResponseBody
	Map<String, Object> findBaseLegal(BaseLegalFilter filtro, int rows, int page, HttpSession session,HttpServletRequest request) {
		LOG.info("Funcion: listar de Bases Legales -- Controller -- Metodo-> findBaseLegal");
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
//        	List<BaseLegalDTO> listado;
            int total=0 ;
            Integer cuenta=0;
            
//            int inicio;
//            inicio=rows*page-rows;
//            filtro.setStartIndex(inicio);
//            filtro.setResultsNumber(rows);
//            int[] auxiliar=new int[1];
//            auxiliar[0]=0;
//            listado=baseLegalService.listarBaseLegal(filtro, auxiliar);
//            LOG.info("Funcion: contador -- auxiliar: " + auxiliar);
            
            List<BaseLegalDTO> listado =(List<BaseLegalDTO>) request.getSession().getServletContext().getAttribute("LISTA_BASES_LEGALES");        
            
//            cuenta=auxiliar[0];
//            if(cuenta>0){
//            	total=(int) Math.ceil((double) cuenta / (double) rows);
//            }
            listaResultado.put("total", total);
            listaResultado.put("pagina", page);
            listaResultado.put("registros", cuenta);
            listaResultado.put("filas", listado);
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
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
           List<ObligacionNormativaDTO> listaFiltro= new ArrayList<ObligacionNormativaDTO>();
           for(ObligacionNormativaDTO obligacion : listado){
               
               if(obligacion.getCodigoBaseLegal().equals(pep)){              
                    listaFiltro.add(obligacion);
               }
            }
           listaResultado.put("total", total);
            listaResultado.put("pagina", page);
            listaResultado.put("registros", cuenta);
            listaResultado.put("filas", listaFiltro);

        return listaResultado;
    }
    /**
     * 
     * @param row_id
     * @param rows
     * @param page
     * @param session
     * @return 
     */    
    @RequestMapping(value = "/findDetalleBaseLegal", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> buscarDetalle(String row_id,int rows, int page, HttpSession session,HttpServletRequest request){
        
        LOG.info("procesando GET para RequestMapping /findDetalle " +row_id);
        
	Map<String, Object> listaDetalle = new HashMap<String, Object>();
        
        int total=0;
	int cuenta=0;
        
        List<BaseLegalDTO> listadoBasesLegales =(List<BaseLegalDTO>) request.getSession().getServletContext().getAttribute("LISTA_BASES_LEGALES");
        List<ObligacionNormativaDTO> listado =(List<ObligacionNormativaDTO>) request.getSession().getServletContext().getAttribute("LISTA_OBLIGACIONES");
        
//        List<BaseLegalDTO> listadoBasesLegales =(List<BaseLegalDTO>) servletContext.getAttribute("LISTA_BASES_LEGALES");
//        List<ObligacionNormativaDTO> listado =(List<ObligacionNormativaDTO>) servletContext.getAttribute("LISTA_OBLIGACIONES");
        
//        List<BaseLegalDTO> listadoBasesLegales =(List<BaseLegalDTO>) session.getAttribute("LISTA_BASES_LEGALES");
//        List<ObligacionNormativaDTO> listado =(List<ObligacionNormativaDTO>) session.getAttribute("LISTA_OBLIGACIONES");
           List<ObligacionNormativaDTO> listaFiltro= new ArrayList<ObligacionNormativaDTO>();
           
           for(ObligacionNormativaDTO obligacion : listado){
               System.out.println(" Valor: "+obligacion.getCodigoBaseLegal());
               System.out.println(" Valor: "+row_id);
               if(obligacion.getCodigoBaseLegal().equals(row_id)){              
                    listaFiltro.add(obligacion);
                    
               }
               
            }
            for(BaseLegalDTO baseLegal : listadoBasesLegales){
               System.out.println(" Valor: "+baseLegal.getTieneAct());
               System.out.println(" Valor: "+row_id);
               if(baseLegal.getCodigoBaseLegal().equals(row_id)){              
                    baseLegal.setTieneAct(new Long(1));
                    
               }
               
            }
           
                                listaDetalle.put("total",total);
				listaDetalle.put("pagina",page);
				listaDetalle.put("registros",cuenta);
				listaDetalle.put("filas",listaFiltro); 
        return listaDetalle;
    }
    /**
     * 
     * @param rows
     * @param page
     * @param session
     * @return 
     */
    @RequestMapping(value = "/resultadoBusquedaAvanzadaBaseLegal", method = RequestMethod.GET)
    public @ResponseBody
                 Map<String, Object> resultadoBusquedaAvanzadaBaseLegal(int rows, int page, HttpSession session){
		 List<Map<String, Object>> salida1= new ArrayList<Map<String,Object>>();
		 Map<String, Object> listaResultadoBaseLegal = new HashMap<String, Object>();
		 
		int cuenta=1; 
		int total=0;
		int inicio=0;
		if(cuenta > 0){
		total=(int) Math.ceil((double) cuenta / (double) rows);
		if(page > total){
		page=total;
		}
                                inicio=rows * page - rows;
                }
                if(page==1){
		 Map<String,Object> fila= new HashMap<String,Object>();
		 fila.put("idBaseLegal", "9");
		 fila.put("codigoBaseLegal", "BL009");
		 fila.put("descBaseLegal", "Art. 11° Num. 3 de Reglamento Aprobado por D.S. N° 054-1993-EM y Modificatorias");
                 fila.put("check","1");
                 salida1.add(fila);
                 Map<String,Object> fila1= new HashMap<String,Object>();
		 fila1.put("idBaseLegal", "10");
		 fila1.put("codigoBaseLegal", "BL010");
		 fila1.put("descBaseLegal", "Art. 13° Num. 5 de Reglamento Aprobado por D.S. N° 054-1993-EM");
                 fila1.put("check","1");
                 salida1.add(fila1);
                 Map<String,Object> fila2= new HashMap<String,Object>();
		 fila2.put("idBaseLegal", "12");
		 fila2.put("codigoBaseLegal", "BL012");
		 fila2.put("descBaseLegal", "Art. 9° de Reglamento Aprobado por D.S. N° 027-1994-EM");
                 fila2.put("check","1");
                 salida1.add(fila2);
		 }			 
				 listaResultadoBaseLegal.put("total",total);
				 listaResultadoBaseLegal.put("pagina",page);
				 listaResultadoBaseLegal.put("registros",cuenta);
				 listaResultadoBaseLegal.put("filas",salida1); 
                		 
				 
		return listaResultadoBaseLegal;
	}
    
    /**
     * 
     * @param baseLegalDTO
     * @param request
     * @param session
     * @return 
     */	
    @RequestMapping(value = "/registrarBaseLegal", method = RequestMethod.POST)
    public @ResponseBody 
        Map<String, Object> registrar(BaseLegalDTO baseLegalDTO, HttpServletRequest request, HttpSession session){
        LOG.info("procesando POST para RequestMapping /registrar POST ");
        Map<String, Object> salida = new HashMap<String, Object>();
        List<BaseLegalDTO> listadoBaseLegal =(List<BaseLegalDTO>) request.getSession().getServletContext().getAttribute("LISTA_BASES_LEGALES");
        
//        List<BaseLegalDTO> listadoBaseLegal =(List<BaseLegalDTO>) servletContext.getAttribute("LISTA_BASES_LEGALES");
        
        //List<BaseLegalDTO> listadoBaseLegal =(List<BaseLegalDTO>) session.getAttribute("LISTA_BASES_LEGALES");
        listadoBaseLegal.add(baseLegalDTO);
          
        salida.put("resultado", 0);
        
        return salida;
    }
    /**
     * 
     * @param obligacionNormativaDTO
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping(value = "/registrarObligacionNormativa", method = RequestMethod.POST)
    public @ResponseBody 
        Map<String, Object> registrarObligacion(ObligacionNormativaDTO obligacionNormativaDTO,HttpServletRequest request, HttpSession session){
        LOG.info("procesando POST para RequestMapping /registrar POST");
        Map<String, Object> salida = new HashMap<String, Object>();
        List<ObligacionNormativaDTO> listaObligaciones = (List<ObligacionNormativaDTO>) request.getSession().getServletContext().getAttribute("LISTA_OBLIGACIONES");
        
//        List<ObligacionNormativaDTO> listaObligaciones = (List<ObligacionNormativaDTO>) servletContext.getAttribute("LISTA_OBLIGACIONES");
        
        //List<ObligacionNormativaDTO> listaObligaciones = (List<ObligacionNormativaDTO>) session.getAttribute("LISTA_OBLIGACIONES");
        listaObligaciones.add(obligacionNormativaDTO); 
        
        salida.put("resultado", 0);
        return salida;
    }

    
    /**
    * Redirige al controlador DialogBusquedaAvanzadaBaseLegalController
    * @param model
    * @param session
    * @param redirectAttributes
    * @return
    */
    @RequestMapping ( value = "/abrirDialogBusquedaAvanzadaBaseLegal" , method = RequestMethod.GET )
    public String abrirDialogBusquedaAvanzadaBaseLegal(Model model,HttpSession session) {
        //redirectAttributes.addFlashAttribute("idDialog", "dlgBusquedaAvanzadaBaseLegal");
        //redirectAttributes.addFlashAttribute("listenerJS", "moduloDatosEmpresa.listenerDlgBusquedaEmpresa()");
        //return "redirect:common/busquedaAvanzada/inicio"; 
        
        model.addAttribute("listTipoNormaLegal", maestroColumnaService.listarTipoNormaLegal());
        model.addAttribute("listSigla", maestroColumnaService.listarSigla());
        model.addAttribute("listTipoAnexo", maestroColumnaService.listarTipoAnexo());
        model.addAttribute("listCriticidad", maestroColumnaService.listarCriticidad());
        model.addAttribute("listObligacionTipo", obligacionTipoService.listarObligacionTipoConf());
        return "moduloObligaciones/common/formBusqAvanzadaBaseLegal";
    }
    /**
    * Redirige al controlador DialogHistoricoBaseLegalController
    * @param model
    * @param session
    * @param redirectAttributes
    * @return
    */
    @RequestMapping ( value = "/abrirDialogHistoricoBaseLegal" , method = RequestMethod.GET )
    public String abrirDialogHistoricoBaseLegal(Model model,HttpSession session, final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("idDialog", "dlgHistoricoBaseLegal");
        //redirectAttributes.addFlashAttribute("listenerJS", "moduloDatosEmpresa.listenerDlgBusquedaEmpresa()");
        return "redirect:historico/inicio"; 
    }
    /**
     * <-- Produccion -->
     * @param filtro
     * @param rows
     * @param page
     * @param session
     * @return 
     */
    @RequestMapping(value = "/listarBaseLegal", method = RequestMethod.GET)
    public @ResponseBody
	Map<String, Object> findBaseLegal(BaseLegalFilter filtro,int varLista, int rows, int page, HttpSession session,HttpServletRequest request) {
		LOG.info("Funcion: listar de Bases Legales -- Controller -- Metodo-> listarBaseLegal");
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
        	List<BaseLegalDTO> listado;
            int total=0 ;
            Integer cuenta;
            if(varLista==1){
	            int inicio;
	            inicio=rows*page-rows;
	            filtro.setStartIndex(inicio);
	            filtro.setResultsNumber(rows);
	            int[] auxiliar=new int[1];
	            auxiliar[0]=0;
	            LOG.info("Filtro: " + filtro + " Auxiliar:" + auxiliar);
	            listado=baseLegalService.listarBaseLegal(filtro, auxiliar);
	            LOG.info("Funcion: contador -- auxiliar: " + auxiliar);
	            cuenta=auxiliar[0];
	            if(cuenta>0){
	            	total=(int) Math.ceil((double) cuenta / (double) rows);
	            }
	            listaResultado.put("total", total);
	            listaResultado.put("pagina", page);
	            listaResultado.put("registros", cuenta);
	            listaResultado.put("filas", listado);
            }
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
    }
    /**
     * <-- Produccion -->
     * @param filtro
     * @param rows
     * @param page
     * @param session
     * @return 
     */
    @RequestMapping(value = "/listarBaseLegalPadre", method = RequestMethod.POST)
    public @ResponseBody
	Map<String, Object> findBaseLegalPadre(BaseLegalFilter filtro,Long varLista, int rows, int page, HttpSession session,HttpServletRequest request) {
		LOG.info("Funcion: listar de Bases Legales -- Controller -- Metodo-> listarBaseLegal");
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
        	List<BaseLegalDTO> listado;
            int total=0 ;
            Integer cuenta;
            if(varLista==1){
	            int inicio;
	            inicio=rows*page-rows;
	            filtro.setStartIndex(inicio);
	            filtro.setResultsNumber(rows);
	            int[] auxiliar=new int[1];
	            auxiliar[0]=0;
	            LOG.info("Filtro: " + filtro + " Auxiliar:" + auxiliar);
	            listado=baseLegalService.listarBaseLegalPadre(filtro, auxiliar);
	            LOG.info("Funcion: contador -- auxiliar: " + auxiliar);
	            cuenta=auxiliar[0];
	            if(cuenta>0){
	            	total=(int) Math.ceil((double) cuenta / (double) rows);
	            }
	            listaResultado.put("total", total);
	            listaResultado.put("pagina", page);
	            listaResultado.put("registros", cuenta);
	            listaResultado.put("filas", listado);
            }
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
    }
    @RequestMapping(value = "/listarBaseLegalPadreGet", method = RequestMethod.POST)
    public @ResponseBody
	Map<String, Object> findBaseLegalPadreGet(BaseLegalFilter filtro,Long varLista, int rows, int page, HttpSession session,HttpServletRequest request) {
		LOG.info("Funcion: listar de Bases Legales -- Controller -- Metodo-> listarBaseLegal");
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
        	List<BaseLegalDTO> listado;
            int total=0 ;
            Integer cuenta;
            if(varLista==1){
	            int inicio;
	            inicio=rows*page-rows;
	            filtro.setStartIndex(inicio);
	            filtro.setResultsNumber(rows);
	            int[] auxiliar=new int[1];
	            auxiliar[0]=0;
	            LOG.info("Filtro: " + filtro + " Auxiliar:" + auxiliar);
	            listado=baseLegalService.listarBaseLegalPadre(filtro, auxiliar);
	            LOG.info("Funcion: contador -- auxiliar: " + auxiliar);
	            cuenta=auxiliar[0];
	            if(cuenta>0){
	            	total=(int) Math.ceil((double) cuenta / (double) rows);
	            }
	            listaResultado.put("total", total);
	            listaResultado.put("pagina", page);
	            listaResultado.put("registros", cuenta);
	            listaResultado.put("filas", listado);
            }
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
    }
    
    @RequestMapping(value = "/listarBusqAvanObligacion", method = RequestMethod.POST)
    public @ResponseBody
	Map<String, Object> listarBusqAvanObligacion(BaseLegalFilter filtro,int varLista, int rows, int page, HttpSession session,HttpServletRequest request) {
		LOG.info("Funcion: listar Obligaciones -- Controller -- Metodo-> listar Obligaciones");
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
        	List<BaseLegalDTO> listado;
            int total=0 ;
            Integer cuenta;
            if(varLista==1){
	            int inicio;
	            inicio=rows*page-rows;
	            filtro.setStartIndex(inicio);
	            filtro.setResultsNumber(rows);
	            int[] auxiliar=new int[1];
	            auxiliar[0]=0;
	            LOG.info("Filtro: " + filtro + " Auxiliar:" + auxiliar);
	            listado=baseLegalService.listarBaseLegalPadre(filtro, auxiliar);
	            LOG.info("Funcion: contador -- auxiliar: " + auxiliar);
	            cuenta=auxiliar[0];
	            if(cuenta>0){
	            	total=(int) Math.ceil((double) cuenta / (double) rows);
	            }
	            listaResultado.put("total", total);
	            listaResultado.put("pagina", page);
	            listaResultado.put("registros", cuenta);
	            listaResultado.put("filas", listado);
            }
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
    }
    
    /**
     * <-- Produccion -->
     * @param filtro
     * @param rows
     * @param page
     * @param session
     * @return 
     */
    @RequestMapping(value = "/listarDetalleBaseLegalHijo", method = RequestMethod.POST)
    public @ResponseBody
	Map<String, Object> listarDetalleBaseLegalHijo(Long row_id, int rows, int page, HttpSession session,HttpServletRequest request) {
		LOG.info("Funcion: listar de Bases Legales -- Controller -- Metodo-> listarBaseLegal");
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        List<BaseLegalDTO> listado = new ArrayList<BaseLegalDTO>();
        try{
        	
            listado=baseLegalService.listarBaseLegalHijo(row_id);
            LOG.info("listado de hijos" + listado);
            if(listado!=null){
            	Long contador = new Long(listado.size());
	            int indiceInicial = (page - 1) * rows;
	            int indiceFinal = indiceInicial + rows;
	            List<BaseLegalDTO> listaConfiguracion = new ArrayList<BaseLegalDTO>();
	            listaConfiguracion = listado.subList(
	                    indiceInicial, indiceFinal > listado
	                    .size() ? listado.size()
	                    : indiceFinal);
	            Long numeroFilas = (contador / rows);
	            if ((contador % rows) > 0) {
	                numeroFilas = numeroFilas + 1L;
	            }
	            
	            listaResultado.put("total", numeroFilas);
	            listaResultado.put("pagina", page);
	            listaResultado.put("registros", contador);
	            listaResultado.put("filas", listaConfiguracion);
            }
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
    }
    @RequestMapping(value = "/listarDetalleBaseLegalByObligacion", method = RequestMethod.POST)
    public @ResponseBody
	Map<String, Object> listarDetalleBaseLegalByObligacion(Long row_id, int rows, int page, HttpSession session,HttpServletRequest request) {
		LOG.info("Funcion: listar de Bases Legales -- Controller -- Metodo-> listarBaseLegal");
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        List<BaseLegalDTO> listado = new ArrayList<BaseLegalDTO>();
        try{
        	
            listado=baseLegalService.listarBaseLegalByObligacion(row_id);
            LOG.info("listado de hijos" + listado);
            if(listado!=null){
            	Long contador = new Long(listado.size());
	            int indiceInicial = (page - 1) * rows;
	            int indiceFinal = indiceInicial + rows;
	            List<BaseLegalDTO> listaConfiguracion = new ArrayList<BaseLegalDTO>();
	            listaConfiguracion = listado.subList(
	                    indiceInicial, indiceFinal > listado
	                    .size() ? listado.size()
	                    : indiceFinal);
	            Long numeroFilas = (contador / rows);
	            if ((contador % rows) > 0) {
	                numeroFilas = numeroFilas + 1L;
	            }
	            
	            listaResultado.put("total", numeroFilas);
	            listaResultado.put("pagina", page);
	            listaResultado.put("registros", contador);
	            listaResultado.put("filas", listaConfiguracion);
            }
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
    }
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/consultaBaseLegalHijo", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> consultaBaseLegalHijo(Long idBaseLegal) {
    	Map<String, Object> resultado = new HashMap<String, Object>();
        List<BaseLegalDTO> listado = new ArrayList<BaseLegalDTO>();
        try{
        listado=baseLegalService.listarBaseLegalHijo(idBaseLegal);
        LOG.info("listado de Base Legal "+ listado);
        resultado.put("listado", listado);
        }catch(Exception e){
            LOG.info("error al procesar listado de Temas " +e);
        }
        return resultado;
    }
    /**
     * <-- Produccion -->
     * @param filtro
     * @param varLista
     * @param rows
     * @param page
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/listarObligacion", method = RequestMethod.POST)
    public @ResponseBody
	Map<String, Object> findObligacionNormativa(ObligacionFilter filtro,int varLista, int rows, int page, HttpSession session,HttpServletRequest request) {
		LOG.info("Funcion: listar de Bases Legales -- Controller -- Metodo-> listarBaseLegal");
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try{
        	List<ObligacionNormativaDTO> listado;
            int total=0 ;
            Integer cuenta;
            if(varLista==1){
	            int inicio;
	            inicio=rows*page-rows;
	            filtro.setStartIndex(inicio);
	            filtro.setResultsNumber(rows);
	            int[] auxiliar=new int[1];
	            auxiliar[0]=0;
	            LOG.info("Filtro: " + filtro + " Auxiliar:" + auxiliar);
	            listado=obligacionNormativaService.listarObligacion(filtro, auxiliar);
	            LOG.info("Funcion: contador -- auxiliar: " + auxiliar);
	            cuenta=auxiliar[0];
	            if(cuenta>0){
	            	total=(int) Math.ceil((double) cuenta / (double) rows);
	            }
	            listaResultado.put("total", total);
	            listaResultado.put("pagina", page);
	            listaResultado.put("registros", cuenta);
	            listaResultado.put("filas", listado);
            }
        }catch(Exception ex){
        	LOG.error("error controller",ex);
        }
        
        return listaResultado;
    }
    /**
     * <-- Producción -->
     * @param model
     * @param session
     * @param redirectAttributes
     * @param Edicion
     * @param request
     * @param Nuevo
     * @return
     */
    @RequestMapping ( value = "/abrirDialogMantenimientoBaseLegal" , method = RequestMethod.GET )
    public String abrirDialogMantenimientoBaseLegal(String flagBaseLegal,Model model,HttpSession session, HttpServletRequest request) {
    	model.addAttribute("idDialog", "dlgMantenimientoBaseLegal");
        model.addAttribute("flagBaseLegal", flagBaseLegal);

        return "moduloObligaciones/baseLegal/mantenimiento/nuevo";
    }
    
    
    
}