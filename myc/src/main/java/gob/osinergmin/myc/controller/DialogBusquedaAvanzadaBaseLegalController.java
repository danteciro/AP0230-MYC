package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.BaseLegalFilter;
import gob.osinergmin.myc.service.business.BaseLegalServiceNeg;
import gob.osinergmin.myc.service.business.ObligacionBaseLegalServiceNeg;
import gob.osinergmin.myc.service.business.ObligacionNormativaServiceNeg;
import gob.osinergmin.myc.util.ConstantesWeb;

import java.beans.PropertyEditorSupport;
import java.net.Inet4Address;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author gvillanueva
 */
@Controller("dialogBusquedaAvanzadaBaseLegal")
@RequestMapping("/baseLegal/common/busquedaAvanzada")
public class DialogBusquedaAvanzadaBaseLegalController {
    private static final Logger LOG = LoggerFactory.getLogger(DialogBusquedaAvanzadaBaseLegalController.class);
    
    @Autowired
    private BaseLegalServiceNeg baseLegalService;  
    
    @Autowired
    private ObligacionNormativaServiceNeg obligacionNormativaService;
    
    @Autowired
    private ObligacionBaseLegalServiceNeg obligacionBaseLegalServiceNeg;
    /**
     * 
     * @param model
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
    public String inicio(Model model, HttpServletRequest request,HttpSession session) {
        return "moduloObligaciones/common/formBusqAvanzadaBaseLegal";
    }
    /**
     * 
     * @param session
     * @param model
     * @return 
     */
    @RequestMapping(value = "/arbolActividades", method = RequestMethod.GET)
    public String dialogArbolActividades(HttpSession session,
                    Model model) {

            String arbolActividades = "<li id='0' class='folder'>ACTIVIDADES"
                            + "<ul>";
            arbolActividades += "</li>";

            model.addAttribute("arbolActividades", arbolActividades);
            return "moduloObligaciones/common/formArbolActividades";
    }
    /**
     * 
     * @param session
     * @param model
     * @return 
     */
    @RequestMapping(value = "/arbolProductos", method = RequestMethod.GET)
    public String dialogArbolProductos(HttpSession session,
                    Model model) {

            String arbolProductos = "<li id='0' class='folder'>ACTIVIDADES"
                            + "<ul>";
            arbolProductos += "</li>";

            model.addAttribute("arbolProductos", arbolProductos);
            return "moduloObligaciones/common/formArbolProductos";
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
    public @ResponseBody Map<String, Object> findBaseLegal(BaseLegalFilter filtro,int varLista, int rows, int page, HttpSession session,HttpServletRequest request) {
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
                listado=baseLegalService.listarBaseLegalConcordancia(filtro, auxiliar);
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
     * <-- AsociarBaseToBase -->
     * @author l_garcia_reyna
     * @param filtro
     * @param rows
     * @param page
     * @param session
     * @return      
     */
    // 06-11-2015
    @RequestMapping(value = "/listarBaseLegalToBaseLegal", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> findBaseLegalToBaseLegal(BaseLegalFilter filtro,int varLista, int rows, int page, HttpSession session,HttpServletRequest request) {
        LOG.info("Funcion: listar de Bases Legales para asociar -- Controller -- Metodo-> listarBaseLegalToBaseLegal");
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
                listado=baseLegalService.listarBaseLegalToBaseLegal(filtro, auxiliar);
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
    //
    /**
     * 
     * @param idBaseLegal
     * @return
     */
    @RequestMapping(value = "/asignarBasesLegales", method = RequestMethod.POST)
    public @ResponseBody 
    Map<String, Object> asignarBasesLegales(int rows,int page,
    		@RequestParam ( value = "basesLegales[]" , required = false ) String[] basesLegales, String idObligacion,String codTrazabilidad ) {
        Map<String, Object> salida = new HashMap<String, Object>();
        
        List<BaseLegalDTO> listaBasesLegalesConcordancia = new ArrayList<BaseLegalDTO>();
        List<BaseLegalDTO> listaBasesLegalesConcordanciaGrid = new ArrayList<BaseLegalDTO>();
        try {
            int total = 0;
            page = 1;
            Integer cuenta = 0;
            
            ObligacionBaseLegalDTO registro = null;
            LOG.info("bases legales = "+idObligacion);
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00002");
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            System.out.println("bases legales = "+basesLegales);
            String[] basesLegalesOld = basesLegales;
            for (int i = 0; i < basesLegales.length; i++) {
                if (!basesLegalesOld[i].equals("undefined")) {
                    registro = new ObligacionBaseLegalDTO();
//                    System.out.println("dddd " + basesLegalesOld[i]);
                    registro.setIdBaseLegal(new Long(basesLegalesOld[i]));
                    registro.setIdObligacion(new Long(idObligacion));
                    registro.setEstado("1");
                    registro.setCodTrazabilidad(codTrazabilidad);
                    registro = obligacionBaseLegalServiceNeg.guardaObligacionBaseLegal(registro, usuarioDTO);
                    //BaseLegalDTO consulta = baseLegalService.findBaseLegalbyCodigo(basesLegalesOld[i]);
                    //System.out.println("consulta " + consulta);
                    //listaBasesLegalesConcordancia.add(consulta);
                }
            }

            listaBasesLegalesConcordanciaGrid = listaBasesLegalesConcordancia;
            String mensaje=MantenimientoBaseLegalController.controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_SUCCESS_CREATE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_BASELEGAL);
            salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            salida.put("total", total);
            salida.put("pagina", page);
            salida.put("registros", cuenta);
            salida.put("filas", listaBasesLegalesConcordanciaGrid);

        } catch (Exception e) {
            LOG.error("", e);
            String mensaje=MantenimientoBaseLegalController.controlMessagesStaticEntity(ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE_RELATION,ConstantesWeb.mensajes.MSG_ENTITY_BASELEGAL);
            salida.put(ConstantesWeb.VV_MENSAJE, mensaje);
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        }
        return salida;
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
}
