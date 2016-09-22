/**
* Resumen		
* Objeto			: MantenimientoActividadController.java
* Descripción		: Controla el mantenimiento de actividades en el MYC.
* Fecha de Creación	: 27/06/2016.
* PR de Creación	: OSINE_SFS-600
* Autor				: Hernán Torres Sáenz.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
* 
*/ 

package gob.osinergmin.myc.controller;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ModuloDTO;
import gob.osinergmin.myc.domain.dto.OrgaActiModuSeccDTO;
import gob.osinergmin.myc.domain.dto.SeccionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.business.TipificacionServiceNeg;
import gob.osinergmin.myc.domain.ui.ModuloFilter;
import gob.osinergmin.myc.domain.ui.OrgaActiModuSeccionFilter;
import gob.osinergmin.myc.domain.ui.SeccionFilter;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.business.ActividadServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.ModuloServiceNeg;
import gob.osinergmin.myc.service.business.OrgaActiModuSeccServiceNeg;
import gob.osinergmin.myc.service.business.SeccionServiceNeg;
import gob.osinergmin.myc.service.business.TipificacionSancionServiceNeg;
import gob.osinergmin.myc.service.business.UnidadOrganicaServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mantenimientoConfiguracionSiguo")
public class MantenimientoConfiguracionSiguoController {
    private static final Logger LOG = LoggerFactory.getLogger(MantenimientoConfiguracionSiguoController.class);
    
    @Inject
    TipificacionServiceNeg tipificacionserviceNeg;
    @Inject
    TipificacionSancionServiceNeg tipificacionSancionServiceNeg;
    @Inject
    MaestroColumnaServiceNeg maestroColumnaServiceNeg;
    @Inject    
    ActividadServiceNeg actividadServiceNeg;
    @Inject
    UnidadOrganicaServiceNeg unidadOrganicaServiceNeg;
    @Inject
    ModuloServiceNeg moduloServiceNeg;
    @Inject
    OrgaActiModuSeccServiceNeg orgaActiModuSeccServiceNeg;
    @Inject
    SeccionServiceNeg seccionServiceNeg;
    // Carga Mantenimiento Configuracion Siguo
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
    	List<UnidadOrganicaDTO> GerUO=unidadOrganicaServiceNeg.findUnidadOrganica(new UnidadOrganicaFilter(null,null,Constantes.NIVEL_GERENCIA));
    	List<ModuloDTO> Componente=moduloServiceNeg.findModulo(new ModuloFilter(Constantes.ESTADO_ACTIVO));
    	
    	model.addAttribute("listadoGerencia",GerUO);
    	model.addAttribute("listadoComponente",Componente);
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_CONFIGURACION_SIGUO;
    }
    
    // Carga Mantenimiento Configuracion Siguo
    @RequestMapping(value = "/abrirMantActividadAgente", method = RequestMethod.GET)
    public String abrirMantActividadAgente (ActividadDTO actividad,HttpSession sesion,Model model ) {
        try{
        	
        	
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }

        return ConstantesWeb.Navegacion.PAGE_GENERAL_FRM_ACTIVIDAD_AGENTE;
    }
    
    @RequestMapping(value="/findActividadComponenteSeccion",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> findActividadComponenteSeccion(OrgaActiModuSeccionFilter filtro,int rows, int page, int flg_load, 
        HttpSession session, HttpServletResponse response, HttpServletRequest request){
        Map<String,Object> retorno=new HashMap<String,Object>();
        
        try{
            LOG.info("procesando findActividadComponenteSeccion");
            List<OrgaActiModuSeccDTO> listado;
            int total=0;
            Integer cuenta;
            
            if(flg_load==1){
                
            	int inicio;
                inicio=rows*page-rows;
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);

                int[] auxiliar=new int[1];
                auxiliar[0]=0;
            
                listado =orgaActiModuSeccServiceNeg.listarOrgaActiModuSeccion(filtro,auxiliar); //procesoObligacionTipoNeg.listarProcesoObligacionTipo(filtro, auxiliar);//obligacionTipoNeg.listarObligacionTipo(filtro, auxiliar);
                LOG.info("cuenta Controller findActividadComponenteSeccion="+auxiliar[0]);
                
                Long contador = new Long(listado.size());
                int indiceInicial = (page - 1) * rows;
                int indiceFinal = indiceInicial + rows;
                List<OrgaActiModuSeccDTO> listaTipificacionPaginada = new ArrayList<OrgaActiModuSeccDTO>();
                listaTipificacionPaginada = listado.subList(
                        indiceInicial, indiceFinal > listado
                        .size() ? listado.size()
                        : indiceFinal);
                Long numeroFilas = (contador / rows);
                if ((contador % rows) > 0) {
                    numeroFilas = numeroFilas + 1L;
                }
                
//                cuenta=auxiliar[0];
//                
//                if (cuenta > 0) {
//                    total = (int) Math.ceil((double) cuenta / (double) rows);
//                }
                retorno.put("total", numeroFilas);	            
	            retorno.put("registros", contador);
	            retorno.put("filas", listaTipificacionPaginada);
            }
                
                        
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    @RequestMapping(value = "/abrirMantModulo", method = RequestMethod.GET)
    public String abrirMantObligacionProceso( String tipo,Long idOrgaActiModuSecc,Long item,HttpSession sesion,Model model ) {
        try{
        	List<UnidadOrganicaDTO> GerUO=unidadOrganicaServiceNeg.findUnidadOrganica(new UnidadOrganicaFilter(null,null,Constantes.NIVEL_GERENCIA));
        	List<ModuloDTO> Componente=moduloServiceNeg.findModulo(new ModuloFilter(Constantes.ESTADO_ACTIVO));
        	List<SeccionDTO> Seccion=seccionServiceNeg.findSeccion(new SeccionFilter(Constantes.ESTADO_ACTIVO));
        	OrgaActiModuSeccDTO configuracion = orgaActiModuSeccServiceNeg.find(idOrgaActiModuSecc);
            model.addAttribute("tipo", tipo);          
            if(!tipo.equals("new") && idOrgaActiModuSecc!=null){
                model.addAttribute("idOrgaActiModuSecc", idOrgaActiModuSecc);   
                model.addAttribute("configuracion", configuracion);
            }
            model.addAttribute("item",item);
            model.addAttribute("listadoGerenciaModal",GerUO);
        	model.addAttribute("listadoComponenteModal",Componente);
        	model.addAttribute("listadoSeccionModal",Seccion);
        	
        }catch(Exception e){
            LOG.error("",e);
        }
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_FRM_CONFIGURACION_SIGUO;
    }
    @RequestMapping(value="/registrarConfiguracionSiguo", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarConfiguracionSiguo(OrgaActiModuSeccDTO orgaActiModuSeccDTO,HttpSession session,HttpServletRequest request){
        LOG.info("procesando registrarConfiguracionSiguo");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            List<OrgaActiModuSeccDTO> validaConfiguracion = orgaActiModuSeccServiceNeg.validaConfiguracion(orgaActiModuSeccDTO);
            if(validaConfiguracion!=null){
            	String mensaje = "Configuraci&oacute;n existente";
            	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ADVERTENCIA_EXISTENCIA);   
                retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
            }else{
            	orgaActiModuSeccDTO.setIdOrgaActiModuSecc(null);
                orgaActiModuSeccDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                OrgaActiModuSeccDTO configuracion=orgaActiModuSeccServiceNeg.guardaConfiguracion(orgaActiModuSeccDTO,usuarioDTO);
                String mensaje = "Exito";
                retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);           
                retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
            }
            
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en registrarConfiguracionSiguo: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    @RequestMapping(value="/editarConfiguracionSiguo", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarConfiguracionSiguo(OrgaActiModuSeccDTO orgaActiModuSeccDTO,HttpSession session,HttpServletRequest request){
    	LOG.info("procesando actualizarConfiguracionSiguo");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            OrgaActiModuSeccDTO cnfIni = orgaActiModuSeccServiceNeg.find(orgaActiModuSeccDTO.getIdOrgaActiModuSecc());
            LOG.info("INICIAL ID UNI : "+cnfIni.getIdUnidadOrganica().getIdUnidadOrganica() + " ID ACTI : "+cnfIni.getIdActividad().getIdActividad() + " ID MOD : "+ cnfIni.getIdModulo().getIdModulo() + " ID SEC : "+cnfIni.getIdSeccion().getIdSeccion());
            LOG.info("FINAL ID UNI : "+orgaActiModuSeccDTO.getIdUnidadOrganica().getIdUnidadOrganica() + " ID ACTI : "+orgaActiModuSeccDTO.getIdActividad().getIdActividad() + " ID MOD : "+ orgaActiModuSeccDTO.getIdModulo().getIdModulo() + " ID SEC : "+orgaActiModuSeccDTO.getIdSeccion().getIdSeccion());
            List<OrgaActiModuSeccDTO> validaConfiguracion = orgaActiModuSeccServiceNeg.validaConfiguracion(orgaActiModuSeccDTO);
            if(validaConfiguracion!=null){
            	if(cnfIni.getIdUnidadOrganica().getIdUnidadOrganica().equals(orgaActiModuSeccDTO.getIdUnidadOrganica().getIdUnidadOrganica()) 
            			&& cnfIni.getIdActividad().getIdActividad().equals(orgaActiModuSeccDTO.getIdActividad().getIdActividad())
            			&& cnfIni.getIdModulo().getIdModulo().equals(orgaActiModuSeccDTO.getIdModulo().getIdModulo())
            			&& cnfIni.getIdSeccion().getIdSeccion().equals(orgaActiModuSeccDTO.getIdSeccion().getIdSeccion())){
            		
            		orgaActiModuSeccDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                    OrgaActiModuSeccDTO configuracionA=orgaActiModuSeccServiceNeg.actualizaConfiguracion(orgaActiModuSeccDTO,usuarioDTO);
                    
                    String mensaje = "Exito";
                    retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                    retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
            		
            	}else{
            		String mensaje = "Configuraci&oacute;n existente";
            		retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ADVERTENCIA_EXISTENCIA);   
            		retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
            	}
            }else{
	            orgaActiModuSeccDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
	            OrgaActiModuSeccDTO configuracionB=orgaActiModuSeccServiceNeg.actualizaConfiguracion(orgaActiModuSeccDTO,usuarioDTO);
	            
	            String mensaje = "Exito";
	            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
	            retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
            }
        }catch(Exception e){            
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en actualizaConfiguracionSiguo: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
    @RequestMapping(value="/eliminarConfiguracionSiguo", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> eliminarConfiguracionSiguo(OrgaActiModuSeccDTO orgaActiModuSeccDTO,HttpServletRequest request){
        LOG.info("procesando eliminar configuracion-->"+orgaActiModuSeccDTO.getIdOrgaActiModuSecc());
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
        	UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            
            orgaActiModuSeccDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            OrgaActiModuSeccDTO configuracion=orgaActiModuSeccServiceNeg.eliminarConfiguracion(orgaActiModuSeccDTO,usuarioDTO);
            
            String mensaje = "Exito";
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            retorno.put(ConstantesWeb.VV_MENSAJE, mensaje);
        }catch(Exception e){            
        	retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, e.getMessage());
            LOG.error("Error en eliminar Configuracion: "+e.getMessage());
            e.printStackTrace();
        }        
        return retorno;
    }
 
}
