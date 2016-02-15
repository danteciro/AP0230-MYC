package gob.osinergmin.myc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import gob.osinergmin.myc.domain.dto.BeanTest;
import gob.osinergmin.myc.domain.dto.DepartamentoDTO;
import gob.osinergmin.myc.domain.dto.DistritoDTO;
import gob.osinergmin.myc.domain.dto.OficinaRegionalDTO;
import gob.osinergmin.myc.domain.dto.ProvinciaDTO;
import gob.osinergmin.myc.domain.dto.UbigeoDTO;
import gob.osinergmin.myc.util.ConstantesWeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/oficinasRegionales")
public class OficinasRegionalesController {

	private static final Logger LOG = LoggerFactory.getLogger(PrincipalController.class);
	
    @RequestMapping(method = RequestMethod.GET)
    public String inicio() {
        return ConstantesWeb.Navegacion.PAGE_REGISTRO_CONF_OFICINASREGICONALES;  
    }
    
    @RequestMapping(value = "/abrirMantOficinaRegional", method = RequestMethod.GET)
    public String abrirMantOficinaRegional ( HttpSession sesion,Model model ) {
        return ConstantesWeb.Navegacion.PAGE_REGISTRO_CONF_FRM_OFICINASREGICONALES;
    }
    @RequestMapping(value = "/abrirConfiguracionRegion", method = RequestMethod.GET)
    public String abrirConfiguracionRegion ( HttpSession sesion,Model model ) {
        return ConstantesWeb.Navegacion.PAGE_REGISTRO_CONF_FRM_REGION;
    }
    
    @RequestMapping(value = "/abrirPopupBusqResponsable", method = RequestMethod.GET)
    public String abrirPopupBusqResponsable ( HttpSession sesion,Model model ) {
        return ConstantesWeb.Navegacion.PAGE_REGISTRO_CONF_OFICINASREGICONALES_FRM_BUSQUEDARESPONSABLE;
    }   
  
    
    @RequestMapping(value="/findResponsable",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> findResponsable(int rows, int page,int flg_load,HttpSession session){
        LOG.info("procesando findResponsable");
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
        	List<BeanTest> lstUbigeo= new ArrayList<BeanTest>();
        	Integer item=1;
        	int inicio = 0;
        	int total=0 ;
            Integer cuenta=0;            
            int[] auxiliar = new int[1];
            auxiliar[0] = 0;             
            inicio = rows * page - rows;
            
            //lstPlacasRodaje = registroService.listarPlacasRodaje(numExpediente, auxiliar);
            
          
            
            BeanTest beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo1("431123");
            beans.setCampo2("dmedrano");
            beans.setCampo3("Medrano Herrera Diana");
            beans.setCampo4("dmedrano@abc.com.pe");
            item++;
            
            BeanTest beans1=new BeanTest();
            beans1.setItem(item);
            beans1.setCampo1("025412");
            beans1.setCampo2("rgarcia");
            beans1.setCampo3("Garcia Mendez Rosa");
            beans1.setCampo4("rgarcia@abc.com.pe");
            lstUbigeo.add(beans);
            lstUbigeo.add(beans1);
     
            auxiliar[0] = lstUbigeo.size();
            
            cuenta=auxiliar[0];
            if (cuenta > 0) {
                total = (int) Math.ceil((double) cuenta / (double) rows);
            }            

                retorno.put("total", total);
                retorno.put("pagina", page);
                retorno.put("registros", cuenta);
                retorno.put("filas", lstUbigeo);                
            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/findUbigeo",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> findUbigeo(int rows, int page,int flg_load,HttpSession session){
        LOG.info("procesando findUbigeo");
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
        	List<BeanTest> lstUbigeo= new ArrayList<BeanTest>();
        	Integer item=1;
        	int inicio = 0;
        	int total=0 ;
            Integer cuenta=0;            
            int[] auxiliar = new int[1];
            auxiliar[0] = 0;             
            inicio = rows * page - rows;
            
            //lstPlacasRodaje = registroService.listarPlacasRodaje(numExpediente, auxiliar);
            
            //borrar desde aca
            UbigeoDTO ubigeo = new UbigeoDTO();
            DepartamentoDTO dpt = new DepartamentoDTO();
            dpt.setIdDepartamento("00");
            dpt.setNombre("Piura");
            
            ProvinciaDTO prov= new ProvinciaDTO();
            prov.setIdProvincia("00");
            prov.setNombre("Piura");
            
            DistritoDTO dist =new DistritoDTO();
            dist.setIdDistrito("01");
            dist.setNombre("Castilla");
            
            
            BeanTest beans=new BeanTest();
            if(flg_load == 1){
	            beans.setItem(item);
	            beans.setCampo1("Cajamarca");
	            beans.setCampo2("-");
	            beans.setCampo3("-");            
	            lstUbigeo.add(beans);
	            item++;
            }
            
            beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo1("Cajamarca");
            beans.setCampo2("Cajamarca");
            beans.setCampo3("-");            
            lstUbigeo.add(beans);
            item++;
            beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo1("Cajamarca");
            beans.setCampo2("Cajamarca");
            beans.setCampo3("Jesus");            
            lstUbigeo.add(beans);
            item++;
            beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo1("Cajamarca");
            beans.setCampo2("Cajabamba");
            beans.setCampo3("-");            
            lstUbigeo.add(beans);
            item++;
            beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo1("Cajamarca");
            beans.setCampo2("Celendin");
            beans.setCampo3("-");            
            lstUbigeo.add(beans);
            item++;
            beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo1("Cajamarca");
            beans.setCampo2("Contumaza");
            beans.setCampo3("-");            
            lstUbigeo.add(beans);
            item++;
            beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo1("Cajamarca");
            beans.setCampo2("San Miguel");
            beans.setCampo3("-");            
            lstUbigeo.add(beans);
            item++;
            beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo1("Cajamarca");
            beans.setCampo2("San Pablo");
            beans.setCampo3("-");            
            lstUbigeo.add(beans);
            item++;
     
            auxiliar[0] = lstUbigeo.size();
            item++;
            cuenta=auxiliar[0];
            if (cuenta > 0) {
                total = (int) Math.ceil((double) cuenta / (double) rows);
            }            

                retorno.put("total", total);
                retorno.put("pagina", page);
                retorno.put("registros", cuenta);
                retorno.put("filas", lstUbigeo);                
            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/findRegiones",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> findRegiones(int rows, int page,int flg_load,HttpSession session){
        LOG.info("procesando findRegiones");
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
        	List<BeanTest> lstUbigeo= new ArrayList<BeanTest>();
        	Integer item=1;
        	int inicio = 0;
        	int total=0 ;
            Integer cuenta=0;            
            int[] auxiliar = new int[1];
            auxiliar[0] = 0;             
            inicio = rows * page - rows;
            
            //lstPlacasRodaje = registroService.listarPlacasRodaje(numExpediente, auxiliar);
            
            //borrar desde aca
         
            
            BeanTest beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo2("Ancash");
            beans.setCampo3("Diana Medrano Herrera");
            beans.setFlgAsignado(false);
            lstUbigeo.add(beans);
            item++;
            beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo2("Cajamarca");
            beans.setCampo3("Diana Medrano Herrera");  
            beans.setFlgAsignado(true);
            lstUbigeo.add(beans);
            item++;
            beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo2("La Libertad");
            beans.setCampo3("Diana Medrano Herrera");  
            beans.setFlgAsignado(false);
            lstUbigeo.add(beans);
            item++;
            auxiliar[0] = lstUbigeo.size();
            //borrar hasta aca
            
            cuenta=auxiliar[0];
            if (cuenta > 0) {
                total = (int) Math.ceil((double) cuenta / (double) rows);
            }            

                retorno.put("total", total);
                retorno.put("pagina", page);
                retorno.put("registros", cuenta);
                retorno.put("filas", lstUbigeo);                
            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/findOficinas",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> findOficinas(int rows, int page,int flg_load,HttpSession session){
        LOG.info("procesando findOficinas");
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
        	List<BeanTest> lstUbigeo= new ArrayList<BeanTest>();
        	Integer item=1;
        	int inicio = 0;
        	int total=0 ;
            Integer cuenta=0;            
            int[] auxiliar = new int[1];
            auxiliar[0] = 0;             
            inicio = rows * page - rows;
            
            //lstPlacasRodaje = registroService.listarPlacasRodaje(numExpediente, auxiliar);
            
            //borrar desde aca
         
            
            BeanTest beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo2("Cajamarca");
            beans.setCampo3("Jr. Cruz de Piedra 608-A");
            beans.setCampo4("076-341163");
            beans.setCampo5("-");
            beans.setCampo6("Regional");
            lstUbigeo.add(beans);
            item++;
            beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo2("Chota");
            beans.setCampo3("Calle Gregorio Malca N° 612");
            beans.setCampo4("0800-41-800");
            beans.setCampo5("-");
            beans.setCampo6("Delegada");
            lstUbigeo.add(beans);
            item++;
            beans=new BeanTest();
            beans.setItem(item);
            beans.setCampo2("Jaen");
            beans.setCampo3("Calle Capitan Quiñones 130");
            beans.setCampo4("0800-41-800");
            beans.setCampo5("-");
            beans.setCampo6("Delegada");
            lstUbigeo.add(beans);     
            auxiliar[0] = lstUbigeo.size();
            //borrar hasta aca
            item ++;
            cuenta=auxiliar[0];
            if (cuenta > 0) {
                total = (int) Math.ceil((double) cuenta / (double) rows);
            }            

                retorno.put("total", total);
                retorno.put("pagina", page);
                retorno.put("registros", cuenta);
                retorno.put("filas", lstUbigeo);                
            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/findOficinaRegional",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> findOficinaRegional(int rows, int page,int flg_load,HttpSession session){
        LOG.info("procesando findOficinaRegional");
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
        	List<BeanTest> lstOficinaRegional = new ArrayList<BeanTest>();
        	Integer item=1;
        	int inicio = 0;
        	int total=0 ;
            Integer cuenta=0;            
            int[] auxiliar = new int[1];
            auxiliar[0] = 0;             
            inicio = rows * page - rows;
            
            //lstPlacasRodaje = registroService.listarPlacasRodaje(numExpediente, auxiliar);
            
            //borrar desde aca
            BeanTest bean = new BeanTest();
            bean.setItem(item);
            bean.setCampo1("OMR I");
            bean.setCampo2("MACRO I");
            bean.setCampo3("Diana Medrano Herrera");
            bean.setCampo4("1");
            BeanTest bean1 = new BeanTest();
            bean1.setItem(item);
            bean1.setCampo1("OMR II");
            bean1.setCampo2("MACRO II");
            bean1.setCampo4("1");
            BeanTest bean2 = new BeanTest();
            bean2.setItem(item);
            bean2.setCampo1("OMR III");
            bean2.setCampo2("MACRO III");
            bean2.setCampo4("1");
            lstOficinaRegional.add(bean); 
            lstOficinaRegional.add(bean1);
            lstOficinaRegional.add(bean2); 
            auxiliar[0] = lstOficinaRegional.size();
            
            cuenta=auxiliar[0];
            if (cuenta > 0) {
                total = (int) Math.ceil((double) cuenta / (double) rows);
            }            

                retorno.put("total", total);
                retorno.put("pagina", page);
                retorno.put("registros", cuenta);
                retorno.put("filas", lstOficinaRegional);                
            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
}
