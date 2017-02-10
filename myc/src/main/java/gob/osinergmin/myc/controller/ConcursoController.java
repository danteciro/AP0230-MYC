/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.ConcursoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConcursoFilter;
import gob.osinergmin.myc.service.business.ConcursoServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;
import java.net.Inet4Address;
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
 * @author lbarboza
 */
@Controller
@RequestMapping("/concurso")
public class ConcursoController {
    private static final Logger LOG = LoggerFactory.getLogger(ConcursoController.class);
    
    @Autowired
    private ConcursoServiceNeg concursoServiceNeg;
    @Autowired
    private MaestroColumnaServiceNeg maestroColumnaServiceNeg;
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_CONSURSO;
    }
    
    @RequestMapping(value = "/abrirPopupArchivo", method = RequestMethod.GET)
    public String abrirPopupArchivo (Long idConcurso,String numeroConcurso,HttpSession sesion,Model model) {
        try{
            model.addAttribute("idConcurso", idConcurso);
            model.addAttribute("numeroConcurso", numeroConcurso);
            model.addAttribute("listadoTipoDocumento", maestroColumnaServiceNeg.buscarByDominioByAplicacion(Constantes.CONSTANTE_DOMINIO_TIPO_DOC_CONCURSO,Constantes.APPLICACION_SGLSS));
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_CONSURSO_ADJUNTOS;
    }
    
    @RequestMapping(value="/listarConcurso",method= RequestMethod.GET)
    public @ResponseBody Map<String, Object> listarConcurso(String idConcurso, String numeroConcurso, String nombreConcurso, String descripcionConcurso,int rows, int page, int flg_load, HttpSession session){
        LOG.info("procesando listarConcurso - inicio");
        Map<String,Object> retorno = new HashMap<String, Object>();
        try{
            int inicio = 0;
            List<ConcursoDTO> listado = null;
            int total = 0;
            Integer cuenta = 0;
            Long idConcur = null;
            if(!idConcurso.equals("0")){
                idConcur = new Long(idConcurso);
            }
            if(numeroConcurso.equals("")){
                numeroConcurso = "%%";
            }
            if(nombreConcurso.equals("")){
                nombreConcurso = "%%";
            }
            if(descripcionConcurso.equals("")){
                descripcionConcurso = "%%";
            }
            
            ConcursoFilter filtro = new ConcursoFilter();
            
            if(flg_load==1){
                filtro.setIdConcurso(idConcur);
                filtro.setNumeroConcurso(numeroConcurso);
                filtro.setNombreConcurso(nombreConcurso);
                filtro.setDescripcionConcurso(descripcionConcurso);
                
                inicio = rows * page - rows;
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                int[] auxiliar = new int[1];//para el paso por referencia TODO cambiar?
                auxiliar[0] = 0;
            
                listado = concursoServiceNeg.obtenerListadoConcurso(filtro, auxiliar);
                
                cuenta = auxiliar[0];
                if (cuenta > 0) {
                    total = (int) Math.ceil((double) cuenta / (double) rows);
                }
                LOG.info("cuenta:" + cuenta);
            }
            
            //cuenta = listado.size();
            
            retorno.put("total", total);
            retorno.put("pagina", page);
            retorno.put("registros", cuenta);
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        LOG.info("procesando listarConcurso - fin");
        return retorno;
    }
    
    @RequestMapping(value="/registrarConcurso", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarConcurso(String numeroConcurso, String nombreConcurso, String descripcionConcurso/*ZonificacionDTO zonificacionDTO*/){
        LOG.info("procesando registrarConcurso");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            ConcursoDTO concursoDTO = new ConcursoDTO();
            ConcursoDTO concursoValidar = new ConcursoDTO();
            
            ConcursoFilter filtro = new ConcursoFilter();
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO.charAt(0));
            filtro.setNumeroConcurso(numeroConcurso);
            filtro.setNombreConcurso(nombreConcurso);
            filtro.setDescripcionConcurso("%%");//Se agrega la descripcion en blanco, ya que el find lo requiere.
            int[] auxiliar = new int[1];//para el paso por referencia TODO cambiar?
            auxiliar[0] = 0;
            try{
                concursoValidar = (ConcursoDTO)concursoServiceNeg.obtenerListadoConcurso(filtro, auxiliar).get(0);
            }catch(Exception x){
                concursoValidar = null;
            }
            
            if(concursoValidar != null){
                retorno.put("resultado", 1);
                retorno.put("mensaje", Constantes.CONSTANTE_MSJE_YA_EXISTE+" Concurso con los mismos Numero y Nombre.");
            }else{
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setCodigo("00002");
                usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());

                concursoDTO.setNumeroConcurso(numeroConcurso);
                concursoDTO.setNombreConcurso(nombreConcurso);
                concursoDTO.setDescripcionConcurso(descripcionConcurso);

                concursoDTO.setIdConcurso(null);
                concursoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);

                concursoDTO = concursoServiceNeg.guardarConcurso(concursoDTO, usuarioDTO);

                retorno.put("idConcurso",concursoDTO.getIdConcurso());
                retorno.put("concurso",concursoDTO);
                retorno.put("resultado", 0);
            }
        }catch(Exception ex){
            LOG.error("Error en registrarConcurso: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value="/editarConcurso", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarConcurso(ConcursoDTO concursoDTO){
        LOG.info("procesando editarConcurso");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            ConcursoDTO concursoValidar = new ConcursoDTO();
            
            ConcursoFilter filtro = new ConcursoFilter();
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO.charAt(0));
            filtro.setNumeroConcurso(concursoDTO.getNumeroConcurso());
            filtro.setNombreConcurso(concursoDTO.getNombreConcurso());
            filtro.setDescripcionConcurso("%%");
            int[] auxiliar = new int[1];//para el paso por referencia TODO cambiar?
            auxiliar[0] = 0;
            
            try{
                concursoValidar = (ConcursoDTO)concursoServiceNeg.obtenerListadoConcurso(filtro, auxiliar).get(0);
            }catch(Exception x){
                concursoValidar = null;
            }
            
            if(concursoValidar != null  && !concursoValidar.getIdConcurso().equals(concursoDTO.getIdConcurso())){
                retorno.put("resultado", 1);
                retorno.put("mensaje", Constantes.CONSTANTE_MSJE_YA_EXISTE+" Concurso con los mismos Numero y Nombre.");
            }else{
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setCodigo("00002");
                usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());

                concursoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);

                concursoDTO = concursoServiceNeg.guardarConcurso(concursoDTO, usuarioDTO);

                retorno.put("idConcurso",concursoDTO.getIdConcurso());
                retorno.put("concurso",concursoDTO);
                retorno.put("resultado", 0);
            }
        }catch(Exception ex){
            LOG.error("Error en editarConcurso: "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @RequestMapping(value = "/eliminarConcurso", method = RequestMethod.POST)
    public @ResponseBody  Map<String, Object> eliminarConcurso(Long idConcurso){
        LOG.info("procesando eliminarConcurso");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            ConcursoDTO concursoDTO = new ConcursoDTO();
            concursoDTO.setIdConcurso(idConcurso);
            
            concursoDTO = concursoServiceNeg.eliminarConcurso(concursoDTO);
            
            retorno.put("concurso",concursoDTO);
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        }catch(Exception ex){
            retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("Error en eliminarConcurso",ex);
        }
        return retorno;
    }
}