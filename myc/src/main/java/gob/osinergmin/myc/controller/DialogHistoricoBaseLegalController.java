package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author gvillanueva
 */
@Controller("dialogHistoricoBaseLegal")
@RequestMapping("/baseLegal/historico")
public class DialogHistoricoBaseLegalController {
    private static final Logger LOG = LoggerFactory.getLogger(MantenimientoBaseLegalController.class);
    
    @Autowired
    private MaestroColumnaServiceNeg maestroColumnaService;
    
    /**
     * 
     * @param model
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
    public String inicio(Model model, HttpServletRequest request,HttpSession session) {
        
        return "moduloObligaciones/baseLegal/mantenimiento/historico";
    }
    /**
     * 
     * @param rows
     * @param page
     * @param session
     * @return 
     */
    @RequestMapping(value = "/obtenerHistoricoObligacion", method = RequestMethod.GET)
    public @ResponseBody
        Map<String, Object> obtenerHistoricoObligacion(int rows, int page, HttpSession session){
        List<Map<String, Object>> salida1= new ArrayList<Map<String,Object>>();
        Map<String, Object> listaResultadoHistoricoObligacion = new HashMap<String, Object>();

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
         fila.put("codigoObligacion", "OBL003");
         fila.put("descripcionObligacion", "De haberse efectuado alguna modificacion o ampliacion en el establecimiento respecto de las condiciones en las que fue autorizada su operacion, las modificaciones y/o ampliaciones deben contar con las autorizaciones requeridas por la normativa vigente.");
         fila.put("fechaCreacion", "09/10/2014 04:40 p.m.");
         fila.put("fechaVigencia", "09/10/2014 04:40 p.m.");
         fila.put("usuario","EFRISANCHO");
         fila.put("tieneDetalle","0");
         salida1.add(fila);
         Map<String,Object> fila1= new HashMap<String,Object>();
         fila1.put("codigoObligacion", "OBL003-1");
         fila1.put("descripcionObligacion", "De haberse efectuado alguna modificacion o ampliacion en el establecimiento respecto de las condiciones en las que fue autorizada su operacion, las modificaciones y/o ampliaciones deben contar con las autorizaciones requeridas por la normativa vigente.");
         fila1.put("fechaCreacion", "10/10/2014 04:40 p.m.");
         fila1.put("fechaVigencia", "10/10/2014 04:40 p.m.");
         fila1.put("usuario","EFRISANCHO");
         fila1.put("tieneDetalle","0");
         salida1.add(fila1);
         }			 
                         listaResultadoHistoricoObligacion.put("total",total);
                         listaResultadoHistoricoObligacion.put("pagina",page);
                         listaResultadoHistoricoObligacion.put("registros",cuenta);
                         listaResultadoHistoricoObligacion.put("filas",salida1); 


        return listaResultadoHistoricoObligacion;
    }
    @RequestMapping(value = "/obtenerDetalleHistoricoObligacion", method = RequestMethod.GET)
    public @ResponseBody
        Map<String, Object> obtenerDetalleHistoricoObligacion(int rows, int page, HttpSession session,Long codigoObligacion){
        List<Map<String, Object>> salida1= new ArrayList<Map<String,Object>>();
        Map<String, Object> listaResultadoDetalleHistoricoObligacion = new HashMap<String, Object>();

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
         fila.put("accion","Modificar");
         fila.put("campoModificado", "Descripcion Obligacion");
         fila.put("datoAnterior", "De haberse efectuado alguna modificacion o ampliacion en el establecimiento respecto de las condiciones en las que fue autorizada su operacion, las modificaciones y/o ampliaciones deben contar con las autorizaciones requeridas por la normativa vigente.");
         fila.put("datoActual", "De haber efectuado alguna modificacion o ampliacion en el establecimiento respecto de las condiciones en las que fue autorizada su operacion, las modificaciones y/o ampliaciones deben contar con las autorizaciones requeridas por la normativa vigente.");
         fila.put("fechaModificado","09/10/2014 04:50 p.m.");
         fila.put("usuario","EFRISANCHO");
         salida1.add(fila);
         
         Map<String,Object> fila1= new HashMap<String,Object>();
         fila1.put("accion","Agregar");
         fila1.put("campoModificado", "Tipificacion");
         fila1.put("datoAnterior", "-");
         fila1.put("datoActual", "2.3");
         fila1.put("fechaModificado","09/10/2014 04:50 p.m.");
         fila1.put("usuario","EFRISANCHO");
         salida1.add(fila1);
         }			 
                         listaResultadoDetalleHistoricoObligacion.put("total",total);
                         listaResultadoDetalleHistoricoObligacion.put("pagina",page);
                         listaResultadoDetalleHistoricoObligacion.put("registros",cuenta);
                         listaResultadoDetalleHistoricoObligacion.put("filas",salida1); 


        return listaResultadoDetalleHistoricoObligacion;
    }
    /**
     * 
     * @param rows
     * @param page
     * @param session
     * @return 
     */
    @RequestMapping(value = "/obtenerHistoricoBaseLegal", method = RequestMethod.GET)
    public @ResponseBody
        Map<String, Object> obtenerHistoricoBaseLegal(int rows, int page, HttpSession session){
        List<Map<String, Object>> salida1= new ArrayList<Map<String,Object>>();
        Map<String, Object> listaResultadoHistoricoBaseLegal = new HashMap<String, Object>();

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
         fila.put("codigoObligacion", "BL001");
         fila.put("descripcionObligacion", "Art. 1 de Reglamento Aprobado por D.S. N. 213 - 2002 - EM");
         fila.put("fechaCreacion", "09/10/2014 04:40 p.m.");
         fila.put("usuario","EFRISANCHO");
         fila.put("tieneDetalle","0");
         salida1.add(fila);
         Map<String,Object> fila1= new HashMap<String,Object>();
         fila1.put("codigoObligacion", "BL001-1");
         fila1.put("descripcionObligacion", "Art. 1 de Reglamento Aprobado por D.Leg. N. 213 - 2002 - EM");
         fila1.put("fechaCreacion", "09/10/2014 04:40 p.m.");
         fila1.put("usuario","EFRISANCHO");
         fila1.put("tieneDetalle","0");
         salida1.add(fila1);
         }			 
                         listaResultadoHistoricoBaseLegal.put("total",total);
                         listaResultadoHistoricoBaseLegal.put("pagina",page);
                         listaResultadoHistoricoBaseLegal.put("registros",cuenta);
                         listaResultadoHistoricoBaseLegal.put("filas",salida1); 


        return listaResultadoHistoricoBaseLegal;
    }
    @RequestMapping(value = "/obtenerDetalleHistoricoBaseLegal", method = RequestMethod.GET)
    public @ResponseBody
        Map<String, Object> obtenerDetalleHistoricoBaseLegal(int rows, int page, HttpSession session,Long codigoObligacion){
        List<Map<String, Object>> salida1= new ArrayList<Map<String,Object>>();
        Map<String, Object> listaResultadoDetalleHistoricoBaseLegal = new HashMap<String, Object>();

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
         fila.put("accion","Modificar");
         fila.put("campoModificado", "Descripcion Obligacion");
         fila.put("datoAnterior", "De haberse efectuado alguna modificacion o ampliacion en el establecimiento respecto de las condiciones en las que fue autorizada su operacion, las modificaciones y/o ampliaciones deben contar con las autorizaciones requeridas por la normativa vigente.");
         fila.put("datoActual", "De haber efectuado alguna modificacion o ampliacion en el establecimiento respecto de las condiciones en las que fue autorizada su operacion, las modificaciones y/o ampliaciones deben contar con las autorizaciones requeridas por la normativa vigente.");
         fila.put("fechaModificado","09/10/2014 04:50 p.m.");
         fila.put("usuario","EFRISANCHO");
         salida1.add(fila);
         
         Map<String,Object> fila1= new HashMap<String,Object>();
         fila1.put("accion","Agregar");
         fila1.put("campoModificado", "Tipificacion");
         fila1.put("datoAnterior", "-");
         fila1.put("datoActual", "2.3");
         fila1.put("fechaModificado","09/10/2014 04:50 p.m.");
         fila1.put("usuario","EFRISANCHO");
         salida1.add(fila1);
         }			 
                         listaResultadoDetalleHistoricoBaseLegal.put("total",total);
                         listaResultadoDetalleHistoricoBaseLegal.put("pagina",page);
                         listaResultadoDetalleHistoricoBaseLegal.put("registros",cuenta);
                         listaResultadoDetalleHistoricoBaseLegal.put("filas",salida1); 


        return listaResultadoDetalleHistoricoBaseLegal;
    }
}
