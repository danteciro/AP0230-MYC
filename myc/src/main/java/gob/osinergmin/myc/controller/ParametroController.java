package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import gob.osinergmin.myc.domain.dto.RequProcParaDinaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ValorParametroDTO;
import gob.osinergmin.myc.domain.in.GuardarCnfRequProcedimientoInRO;
import gob.osinergmin.myc.domain.in.GuardarParametroDinamicoInRO;
import gob.osinergmin.myc.domain.in.GuardarValorParametroInRO;
import gob.osinergmin.myc.domain.out.GuardarCnfRequProcedimientoOutRO;
import gob.osinergmin.myc.domain.out.GuardarParametroDinamicoOutRO;
import gob.osinergmin.myc.domain.out.GuardarValorParametroOutRO;
import gob.osinergmin.myc.domain.ui.ParametroFilter;
import gob.osinergmin.myc.domain.ui.ValorParametroFilter;
import gob.osinergmin.myc.service.business.CnfRequProcedimientoNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.ParametroServiceNeg;
import gob.osinergmin.myc.service.business.ValorParametroServiceNeg;
import gob.osinergmin.myc.service.exception.MaestroColumnaException;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author jpiro
 */

@Controller
@RequestMapping("/parametro")
public class ParametroController {
    private static final Logger LOG = LoggerFactory.getLogger(ParametroController.class);
    
    @Autowired
    private ParametroServiceNeg parametroServiceNeg;
    
    @Autowired
    private ValorParametroServiceNeg valorParametroServiceNeg;
    
	@Inject
	private MaestroColumnaServiceNeg maestroColumnaServiceNeg;
	
    @Inject
    private CnfRequProcedimientoNeg cnfRequProcedimientoNeg;

    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT_PARAMETRO;
    }
    
    @RequestMapping(value="/listarParametrosValores",method= RequestMethod.GET)
    public @ResponseBody Map<String, Object> listarParametrosValores(ParametroFilter filtro, HttpSession session){
        LOG.info("procesando listarParametrosValores - inicio");
        Map<String,Object> retorno = new HashMap<String, Object>();
        try{
            List<ParametroDinamicoDTO> listado;
            Integer cuenta;

            //filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            listado=parametroServiceNeg.listarParametrosValores(filtro);
            
            cuenta=listado.size();
            
            retorno.put("registros", cuenta);
            retorno.put("filas", listado);
            
        }catch(Exception ex){
            LOG.error("",ex);
        }
        LOG.info("procesando listarParametrosValores - fin");
        return retorno;
    }
    
    @RequestMapping(value = "/eliminarParametro", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarParametro(ParametroDinamicoDTO parametroDTO) throws UnknownHostException{
    	 LOG.info("procesando eliminarParametro");
         Map<String,Object> retorno = new HashMap<String,Object>();
         long idParametro;
         
         try{
         UsuarioDTO usuarioDTO = new UsuarioDTO();
         try{
         	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
         	String usuario = ConstantesWeb.getUSUARIO(request);
         	usuarioDTO.setCodigo(usuario);
         }catch(Exception e){
         	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
         }
         usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
         parametroDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
         GuardarParametroDinamicoInRO in =new GuardarParametroDinamicoInRO();
         in.setParametro(parametroDTO);
         in.setUsuario(usuarioDTO);
         
    	 /*Validacion dependencias */
         List<ParametroDinamicoDTO>listaValor=new ArrayList<ParametroDinamicoDTO>();
         ParametroFilter filtro = new ParametroFilter();
         filtro.setIdParametro(parametroDTO.getIdParametroDinamico());
         listaValor=parametroServiceNeg.obtenerDependenciasValores(filtro);
         
         List<ParametroDinamicoDTO>listaParam=new ArrayList<ParametroDinamicoDTO>(); 

         List<ValorParametroDTO> listado = new ArrayList<ValorParametroDTO>();
    	 ValorParametroFilter objParametroFilter = new ValorParametroFilter();
    	 
    	 idParametro = filtro.getIdParametro();
    	 objParametroFilter.setIdParametroDinamico(idParametro);
    	 int[] auxiliar = new int[1];
    	 auxiliar[0]=0;

   		 listado = valorParametroServiceNeg.listarValorParametro(objParametroFilter, auxiliar);
   		 listaParam = parametroServiceNeg.obtenerDependencias(filtro);

         if(listado.size()!=0){
		         if(listado.get(0).getValor().equals(Constantes.VALOR_DEFECTO) && listado.size()>1) {
		        	 retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.DEPENDENCE_VALOR);
		             retorno.put(ConstantesWeb.VV_MENSAJE, "DEPENDENCE_VALOR");

		         } else if(!listado.get(0).getValor().equals(Constantes.VALOR_DEFECTO) && listado.size()>0 ){
		        	 retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.DEPENDENCE_VALOR);  
		             retorno.put(ConstantesWeb.VV_MENSAJE, "DEPENDENCE_VALOR");
		             
		         } else if(listado.get(0).getValor().equals(Constantes.VALOR_DEFECTO) && listado.size()==1) {
		        	 RequProcParaDinaDTO registroDTO = new RequProcParaDinaDTO();
		        	 registroDTO.setValorParametro(listado.get(0));
		             GuardarCnfRequProcedimientoInRO in1=new GuardarCnfRequProcedimientoInRO();
		             in1.setRequProcParaDinaDTO(registroDTO);
		             in1.setUsuario(usuarioDTO);
		             
		             GuardarCnfRequProcedimientoOutRO out=cnfRequProcedimientoNeg.eliminarRequProcParaDinaDTO(in1);
		            listaParam = parametroServiceNeg.obtenerDependencias(filtro);
		            
		             ValorParametroDTO valorParametroDTOList=new ValorParametroDTO();
		        	 UsuarioDTO usuarioDTOList = new UsuarioDTO();
		        	 try{
		                	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		                	String usuario = ConstantesWeb.getUSUARIO(request);
		                	usuarioDTO.setCodigo(usuario);
		                }catch(Exception e){
		                	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
		                }
		        	 usuarioDTOList.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
		        	 valorParametroDTOList.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
		        	 valorParametroDTOList.setIdValorParametro(listado.get(0).getIdValorParametro());

		             GuardarValorParametroInRO inValor =new GuardarValorParametroInRO();
		             inValor.setValorParametro(valorParametroDTOList);
		             inValor.setUsuario(usuarioDTOList);

		             GuardarValorParametroOutRO outValor = valorParametroServiceNeg.eliminarValorParametro(inValor);
		        	 GuardarParametroDinamicoOutRO out2 = parametroServiceNeg.eliminarParametroDinamico(in);
		        	 retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
		             retorno.put("parametro", out2.getParametro());              
		             retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
		             
		         } else if(listaParam.size()!=0 && listaParam!=null){  
		        	 retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.DEPENDENCE);
		             retorno.put(ConstantesWeb.VV_MENSAJE, "DEPENDENCE");
		             
		         } 
         }else if ((listado.size()==0 || listado==null)&&(listaParam.size()==0 || listaParam==null)){ 
        	 
        	 GuardarParametroDinamicoOutRO out = parametroServiceNeg.eliminarParametroDinamico(in);
        	 retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
             retorno.put("parametro", out.getParametro());              
             retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
             }       
         
    	 
         }catch(Exception ex){
        	 LOG.info("error",ex.getMessage());
        	 ex.printStackTrace();
         }
    	return retorno;
    	
    }
    
    @RequestMapping(value = "/validarParametro", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> validarParametro(ParametroDinamicoDTO parametroDTO) throws UnknownHostException{
    	 LOG.info("procesando editarParametro");
         Map<String,Object> retorno = new HashMap<String,Object>();
         try{
        	 /*Validacion dependencias */
             List<ParametroDinamicoDTO>listaProc=new ArrayList<ParametroDinamicoDTO>(); 
             ParametroFilter filtro = new ParametroFilter();
             filtro.setIdParametro(parametroDTO.getIdParametroDinamico());
             listaProc=parametroServiceNeg.obtenerDependencias(filtro);
             
             if(listaProc.size()==0 || listaProc == null){
 	            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
 	            retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
             } else {
             	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.DEPENDENCE);  
             	retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
             }
         }catch(Exception ex){
        	 LOG.info("error",ex.getMessage());
        	 ex.printStackTrace();
         }
		return retorno;
    }     
    
    @RequestMapping(value = "/editarParametro", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> editarParametro(ParametroDinamicoDTO parametroDTO) throws UnknownHostException{
    	 LOG.info("procesando editarParametro");
         Map<String,Object> retorno = new HashMap<String,Object>();
         try{
        	 
         UsuarioDTO usuarioDTO = new UsuarioDTO();
         try{
         	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
         	String usuario = ConstantesWeb.getUSUARIO(request);
         	usuarioDTO.setCodigo(usuario);
         }catch(Exception e){
         	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
         }
         usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
         parametroDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
         
         String nombre =parametroDTO.getNombre().replaceAll(" +", " ");            
         parametroDTO.setNombre(nombre);
         
         GuardarParametroDinamicoInRO in =new GuardarParametroDinamicoInRO();
         in.setParametro(parametroDTO);
         in.setUsuario(usuarioDTO);
         
         
         /*Validacion  */
         List<ParametroDinamicoDTO>listaProc=new ArrayList<ParametroDinamicoDTO>(); 
         ParametroFilter filtro = new ParametroFilter();
         filtro.setIdParametro(parametroDTO.getIdParametroDinamico());
         
         MaestroColumnaDTO maestroDTO = new MaestroColumnaDTO();
         maestroDTO.setIdMaestroColumna(parametroDTO.getIdAmbitoParametrico().getIdMaestroColumna());
         filtro.setNombre(parametroDTO.getNombre().trim());
         
         listaProc=parametroServiceNeg.verificarOtrosParametros(filtro);
         

         if( (listaProc.size()==0 || listaProc == null) || 
        		 listaProc!=null && listaProc.get(0).getIdParametroDinamico().equals(in.getParametro().getIdParametroDinamico() ) ){
             GuardarParametroDinamicoOutRO out = parametroServiceNeg.editarParametroDinamico(in);
             retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
             retorno.put("parametro", out.getParametro());              
             retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
	            
         } else {
         	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.RESTRICT);  
         	retorno.put(ConstantesWeb.VV_MENSAJE, Constantes.CONSTANTE_MSJE_YA_EXISTE + " Par&aacute;metro Din&aacute;mico.");
         }
         
               	 
         }catch(Exception ex){
        	 LOG.info("error",ex.getMessage());
        	 ex.printStackTrace();
         }
    	return retorno;
    	
    }
    
       
    @RequestMapping(value = "/findAmbitoParametro", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> obtenerListadoAmbitoParametro(){
    	LOG.info("procesando POST para RequestMapping /findAmbitoParametro");
		Map<String, Object> map = new HashMap<String, Object>();
		/*UsuarioOsinerg user = (UsuarioOsinerg) session.getAttribute("usuarioOsinerg");*/
		try {
			List<MaestroColumnaDTO> listaAmbitoParametro = maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_AMBITO_PARAMETRICO);
			map.put("lista", listaAmbitoParametro);			
		} catch (MaestroColumnaException e) {
			LOG.error( e.getMessage() , e);
			map.put("error", e.getMessage());
		}catch (Exception e){
			LOG.error( e.getMessage() , e);
			map.put("error", e.getMessage());
		}				
		return map;
	}
    
    @RequestMapping(value = "/findTipoSancion", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> obtenerListadoTipoSancion(){
    	LOG.info("procesando POST para RequestMapping /findTipoSancion");
		Map<String, Object> map = new HashMap<String, Object>();
		/*UsuarioOsinerg user = (UsuarioOsinerg) session.getAttribute("usuarioOsinerg");*/
		try {
			List<MaestroColumnaDTO> listaAmbitoParametro = maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_TIPO_SANCION);
			map.put("lista", listaAmbitoParametro);			
		} catch (MaestroColumnaException e) {
			LOG.error( e.getMessage() , e);
			map.put("error", e.getMessage());
		}catch (Exception e){
			LOG.error( e.getMessage() , e);
			map.put("error", e.getMessage());
		}				
		return map;
	}
    
    @RequestMapping(value = "/findTipoConsulta", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> obtenerListadoTipoConsulta(){
    	LOG.info("procesando POST para RequestMapping /findTipoConsulta");
		Map<String, Object> map = new HashMap<String, Object>();
		/*UsuarioOsinerg user = (UsuarioOsinerg) session.getAttribute("usuarioOsinerg");*/
		try {
			List<MaestroColumnaDTO> listaAmbitoParametro = maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_TIPO_CONSULTA);
			map.put("lista", listaAmbitoParametro);			
		} catch (MaestroColumnaException e) {
			LOG.error( e.getMessage() , e);
			map.put("error", e.getMessage());
		}catch (Exception e){
			LOG.error( e.getMessage() , e);
			map.put("error", e.getMessage());
		}				
		return map;
	}
    
    @RequestMapping(value="/findParametro", method=RequestMethod.GET)
    public @ResponseBody Map<String, Object> findParametro(ParametroFilter filtro,int rows, int page,int flg_load, HttpSession session){
        Map<String,Object> retorno = new HashMap<String, Object>();
        try{
            LOG.info("procesando findParametro");
            List<ParametroDinamicoDTO> listado;
            int total=0 ;
            Integer cuenta;

            if(flg_load==1){//si flag es cero, envia filas (listado) = null
                int inicio;
                inicio = rows * page - rows;

                //ParametroFilter filtro=new ParametroFilter();
                if(filtro.getIdAmbitoParametrico()==null)
                	filtro.setIdAmbitoParametrico(new Long(0));
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);

                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                listado=parametroServiceNeg.listarParametro(filtro,auxiliar);
                LOG.info("cuenta Controller Parametros="+auxiliar[0]);
                /*
                 * listado=valorParametroServiceNeg.listarValorParametro(filtro, auxiliar);
            LOG.info("cuenta Controller valor Parametros="+auxiliar[0]);*/

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
    
    @RequestMapping(value="/findValorParametro",method= RequestMethod.GET)
    public @ResponseBody Map<String, Object> findValorParametro(ValorParametroFilter filtro, int rows, int page,int flg_load, HttpSession session){
        Map<String,Object> retorno = new HashMap<String, Object>();
        try{
            LOG.info("procesando findParametro");
            List<ValorParametroDTO> listado;
            int total=0 ;
            Integer cuenta;

            if(flg_load==1){//si flag es cero, envia filas (listado) = null
                int inicio;
                inicio = rows * page - rows;

                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);

                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                
             listado=valorParametroServiceNeg.listarValorParametro(filtro, auxiliar);
            LOG.info("cuenta Controller valor Parametros="+auxiliar[0]);

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
    
    @RequestMapping(value="/registrarParametro", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarParametro(ParametroDinamicoDTO parametroDTO){
        LOG.info("procesando registrarParametro");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            try{
            	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            	String usuario = ConstantesWeb.getUSUARIO(request);
            	usuarioDTO.setCodigo(usuario);
            }catch(Exception e){
            	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
            }
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            parametroDTO.setIdParametroDinamico(null);
            parametroDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            GuardarParametroDinamicoInRO in =new GuardarParametroDinamicoInRO();
            
            String nombre =parametroDTO.getNombre().replaceAll(" +", " ");            
            parametroDTO.setNombre(nombre);
            
            in.setParametro(parametroDTO);
            in.setUsuario(usuarioDTO);
              
       	 /*Validacion  */
            List<ParametroDinamicoDTO>listaProc=new ArrayList<ParametroDinamicoDTO>(); 
            ParametroFilter filtro = new ParametroFilter();
            filtro.setIdParametro(parametroDTO.getIdParametroDinamico());
            filtro.setIdAmbitoParametrico(parametroDTO.getIdAmbitoParametrico().getIdMaestroColumna());
            filtro.setNombre(parametroDTO.getNombre().trim());
            
            listaProc=parametroServiceNeg.verificarOtrosParametros(filtro);
            
            if(listaProc.size()==0 || listaProc == null){
	            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
	            retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
	            
	            GuardarParametroDinamicoOutRO out = parametroServiceNeg.guardarParametroDinamico(in);
	            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
	            retorno.put("requisito", out.getParametro());              
	            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
	           
	            if(parametroDTO.getIdAmbitoParametrico().getIdMaestroColumna() == Constantes.ID_REQUISITO){
	            	this.insertarValorDinamicoDefecto();
	            }
            } else {
            	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.RESTRICT);  
            	retorno.put(ConstantesWeb.VV_MENSAJE, Constantes.CONSTANTE_MSJE_YA_EXISTE + " Par&aacute;metro Din&aacute;mico.");
            }
        }catch(Exception e){
            LOG.error("Error en registrarParametroDinamico: "+e.getMessage());
            e.printStackTrace();
        }
        
        return retorno;
    }
    
    
    @RequestMapping(value="/registrarValorParametro", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarValorParametro(ValorParametroDTO valorParametroDTO){
        LOG.info("procesando registrarValorParametro");
        Map<String,Object> retorno = new HashMap<String,Object>();
        LOG.info("vALOR= "+ valorParametroDTO.getValor());
        
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            try{
            	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            	String usuario = ConstantesWeb.getUSUARIO(request);
            	usuarioDTO.setCodigo(usuario);
            }catch(Exception e){
            	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
            }
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            valorParametroDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            GuardarValorParametroInRO in =new GuardarValorParametroInRO();
            valorParametroDTO.setIdValorParametro(null);
            
            String valor =valorParametroDTO.getValor().replaceAll(" +", " ");            
            valorParametroDTO.setValor(valor);
            in.setValorParametro(valorParametroDTO);
            
            in.setUsuario(usuarioDTO);
            
            
          	 /*Validacion  */
               List<ValorParametroDTO>listaProc=new ArrayList<ValorParametroDTO>(); 
               ValorParametroFilter filtro = new ValorParametroFilter();
               filtro.setIdParametroDinamico(valorParametroDTO.getIdParametroDinamico());
               filtro.setValor(valorParametroDTO.getValor().trim());
                              
               listaProc=valorParametroServiceNeg.verificarOtrosValoresParametros(filtro);
               
               if(listaProc.size()==0 || listaProc == null) {
   	            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
   	            retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
   	            
	   	         GuardarValorParametroOutRO out = valorParametroServiceNeg.guardarValorParametro(in);
	             retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
	             retorno.put("requisito", out.getValorParametro());              
	             retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
             
   	            
               } else {
               	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.RESTRICT);  
               	retorno.put(ConstantesWeb.VV_MENSAJE, Constantes.CONSTANTE_MSJE_YA_EXISTE+" Valor Par&aacute;metro Din&aacute;mico.");
               }
               
             
            
           
           
        }catch(Exception e){
            LOG.error("Error en registrarParametroDinamico: "+e.getMessage());
            e.printStackTrace();
        }
        
        return retorno;
    }
    
    @RequestMapping(value = "/validarValorParametro", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> validarValorParametro(ValorParametroDTO valorParametroDTO) throws UnknownHostException{
    	 LOG.info("procesando editarParametro");
         Map<String,Object> retorno = new HashMap<String,Object>();
         try{
        	 /*Validacion dependencias */
             List<ValorParametroDTO>listaProc=new ArrayList<ValorParametroDTO>(); 
             ValorParametroFilter filtro = new ValorParametroFilter();
             filtro.setIdValorParametro(valorParametroDTO.getIdValorParametro());
             if (filtro.getValor()!=null){
             filtro.setValor(valorParametroDTO.getValor().trim());
             }
             listaProc=valorParametroServiceNeg.obtenerDependencias(filtro);
             
             if(listaProc.size()==0 || listaProc == null){
 	            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
 	            retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
             } else {
             	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.DEPENDENCE);  
             	retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
             }
         }catch(Exception ex){
        	 LOG.info("error",ex.getMessage());
        	 ex.printStackTrace();
         }
		return retorno;
    }     
    
    @RequestMapping(value = "/editarValorParametro", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> editarValorParametro(ValorParametroDTO valorParametroDTO) throws UnknownHostException{
    	 LOG.info("procesando editarValorParametro");
         Map<String,Object> retorno = new HashMap<String,Object>();
         
         try{
        	 
         UsuarioDTO usuarioDTO = new UsuarioDTO();
         try{
         	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
         	String usuario = ConstantesWeb.getUSUARIO(request);
         	usuarioDTO.setCodigo(usuario);
         }catch(Exception e){
         	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
         }
         usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
         valorParametroDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
         GuardarValorParametroInRO in =new GuardarValorParametroInRO();
         String valor =valorParametroDTO.getValor().replaceAll(" +", " ");            
         valorParametroDTO.setValor(valor);
         
         in.setValorParametro(valorParametroDTO);
         in.setUsuario(usuarioDTO);
         
         /*Validacion  */
         List<ValorParametroDTO>listaProc=new ArrayList<ValorParametroDTO>(); 
         ValorParametroFilter filtro = new ValorParametroFilter();
         filtro.setIdParametroDinamico(valorParametroDTO.getIdParametroDinamico());
         filtro.setValor(valorParametroDTO.getValor().trim());
                        
         listaProc=valorParametroServiceNeg.verificarOtrosValoresParametros(filtro);
         
         if((listaProc.size()==0 || listaProc == null) || 
          		 (listaProc!=null && listaProc.get(0).getIdValorParametro().equals(in.getValorParametro().getIdValorParametro() ))){
	      
	            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
	            retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
	            
            GuardarValorParametroOutRO out = valorParametroServiceNeg.editarValorParametro(in);
            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
            retorno.put("parametro", out.getValorParametro());              
            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
       
	            
         } else {
         	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.RESTRICT);  
         	retorno.put(ConstantesWeb.VV_MENSAJE, Constantes.CONSTANTE_MSJE_YA_EXISTE+" Valor Par&aacute;metro Din&aacute;mico.");
         }
                
         }catch(Exception ex){
        	 LOG.info("error",ex.getMessage());
        	 ex.printStackTrace();
         }
    	return retorno;
    	
    }
    
    @RequestMapping(value = "/eliminarValorParametro", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarValorParametro(ValorParametroDTO valorParametroDTO) throws UnknownHostException{
    	 LOG.info("procesando eliminarValorParametro");
         Map<String,Object> retorno = new HashMap<String,Object>();
         
         UsuarioDTO usuarioDTO = new UsuarioDTO();
         try{
         	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
         	String usuario = ConstantesWeb.getUSUARIO(request);
         	usuarioDTO.setCodigo(usuario);
         }catch(Exception e){
         	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
         }
         usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
         valorParametroDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
         GuardarValorParametroInRO in =new GuardarValorParametroInRO();
         in.setValorParametro(valorParametroDTO);
         in.setUsuario(usuarioDTO);
         
           
         /*Validacion dependencias */
         List<ValorParametroDTO>listaProc=new ArrayList<ValorParametroDTO>(); 
         ValorParametroFilter filtro = new ValorParametroFilter();
         filtro.setIdValorParametro(valorParametroDTO.getIdValorParametro());
         listaProc=valorParametroServiceNeg.obtenerDependencias(filtro);
         
         if(listaProc.size()==0 || listaProc == null){
         
    	 GuardarValorParametroOutRO out = valorParametroServiceNeg.eliminarValorParametro(in);
         retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
         retorno.put("parametro", out.getValorParametro());              
         retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
         } else {
         retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.DEPENDENCE);  
         retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
         }
         
         try{
        	 
         }catch(Exception ex){
        	 LOG.info("error",ex.getMessage());
        	 ex.printStackTrace();
         }
    	return retorno;
    	
    }
    
    @RequestMapping(value="/insertarValorDinamicoDefecto", method= RequestMethod.POST)
	public @ResponseBody Map<String,Object> insertarValorDinamicoDefecto(){
	LOG.info("procesando insertarValorDinamicoDefecto");
	
	long idDinamico = parametroServiceNeg.obtenerIdDinamico();
	
    ValorParametroDTO valorParametroDTO = new ValorParametroDTO();
    GuardarValorParametroInRO in = new GuardarValorParametroInRO();
    try {
	     valorParametroDTO.setIdValorParametro(null);
	     valorParametroDTO.setValor(Constantes.VALOR.toLowerCase());
	     valorParametroDTO.setDescripcion(Constantes.VALOR);
	     valorParametroDTO.setValorDefecto("1");
	     valorParametroDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
	     valorParametroDTO.setIdParametroDinamico(idDinamico);
	     
	     UsuarioDTO usuarioDTO = new UsuarioDTO();
	     try{
         	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
         	String usuario = ConstantesWeb.getUSUARIO(request);
         	usuarioDTO.setCodigo(usuario);
         }catch(Exception e){
         	usuarioDTO.setCodigo(Constantes.USUARIO_LOGIN_DEFAULT);
         }
	     usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
	        
	     in.setValorParametro(valorParametroDTO);
	     in.setUsuario(usuarioDTO);
	        
	     GuardarValorParametroOutRO out = valorParametroServiceNeg.guardarValorParametro(in);
	     } catch(Exception exepcion) {
	    	 LOG.error("Error en insertarValorDinamicoDefecto: "+exepcion.getMessage());
	    	 exepcion.printStackTrace();
	    	 }
    return null;
    }
}
