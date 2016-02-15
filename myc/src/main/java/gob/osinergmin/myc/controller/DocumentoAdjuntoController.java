            /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarDocumentoAdjuntoInRO;
import gob.osinergmin.myc.domain.out.GuardarDocumentoAdjuntoOutRO;
import gob.osinergmin.myc.domain.ui.DocumentoAdjuntoFilter;
import gob.osinergmin.myc.service.business.DocumentoAdjuntoNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.cxf.helpers.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jpiro
 */
@Controller
@RequestMapping("/documentoAdjunto")
public class DocumentoAdjuntoController {
    private static final Logger LOG = LoggerFactory.getLogger(DocumentoAdjuntoController.class);
    @Value("${archivo.tipo.extenciones}")
    private String tipoExtencionesArchivo;
    @Value("${archivo.tipo.extenciones.baseLegal}")
    private String tipoExtencionesArchivoBaseLegal;
    @Value("${archivo.tipo.extenciones.criterio}")
    private String tipoExtencionesArchivoCriterio;
    @Value("${archivo.tipo.extenciones.obligacion}")
    private String tipoExtencionesArchivoObligacion;
    @Value("${archivo.tipo.extenciones.descripcion}")
    private String tipoExtencionesArchivoDescrpcion;
    @Inject
    private DocumentoAdjuntoNeg documentoServiceNeg;
    
    @RequestMapping(value = "/subirArchivoBaseLegal", method = RequestMethod.POST)
    public void subirArchivoBaseLegal(@RequestParam("archivos[0]") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
	LOG.info("subirArchivoBaseLegal");
	LOG.info("nombre = " + file.getOriginalFilename().toUpperCase());
        request.getSession().removeAttribute("listaArchivosBL");
        
	response.setContentType("text/html;charset=utf-8");
        try {
            LOG.info("formatos permitidos: "+tipoExtencionesArchivoBaseLegal);
            LOG.info("tamaño file="+file.getSize());
            String[] extenciones = tipoExtencionesArchivoBaseLegal.split("\\|");
            String strExtenciones = "";
            for (int i = 0; i < extenciones.length; i++) {
                strExtenciones += extenciones[i] + ", ";
            }
            if(!strExtenciones.isEmpty()){
                strExtenciones = strExtenciones.substring(0,strExtenciones.length()-2);
            }
            if (!validaFormatoPermitido(extenciones,file.getOriginalFilename())) {
                response.getWriter().write("{\"error\":true,\"mensaje\":\"Formato no permitido. ( Extenciones permitidas: "+strExtenciones+") \"}");
                return;
            }
            if(file.getSize()>new Long(4000000)){
                response.getWriter().write("{\"error\":true,\"mensaje\":\"Tamaño maximo permitido 4 MB.\"}");
                return;
            }
            List<DocumentoAdjuntoDTO> files = new ArrayList<DocumentoAdjuntoDTO>();
            
            DocumentoAdjuntoDTO archivoDTO = new DocumentoAdjuntoDTO();
            archivoDTO.setNombreArchivo(file.getOriginalFilename().toUpperCase());
            archivoDTO.setRutaAlfrescoTmp(file.getBytes());
            
            files.add(archivoDTO);
            request.getSession().setAttribute("listaArchivosBL", files);
            LOG.info("archivos recien setteado a sesion: " + files);

            response.getWriter().write("{\"error\":false,\"mensaje\":\"Se cargo el archivo\"}");
            return;
            
        } catch (Exception e) {
            LOG.error("Error subiendo archivo BL", e);
            try {
                response.getWriter().write("{\"error\":true,\"mensaje\":\"Error al insertar Documento\"}");
            } catch (IOException ex) {
                LOG.debug("error al escribir en response", ex);
                ex.printStackTrace();
            }
            return;
        }
    }
    
    @RequestMapping(value="/descargaArchivoAlfresco",method= RequestMethod.GET)
    public void descargaArchivoAlfresco( DocumentoAdjuntoDTO filtro, HttpServletResponse response) {
        LOG.info("procesando descargaArchivoAlfresco--->"+filtro.getNombreArchivo());        
        LOG.info("procesando descargaArchivoAlfresco--->"+filtro.getRutaAlfresco());        
        InputStream is =documentoServiceNeg.descargarDatosAlfresco(filtro);
        
        try {        	
    		 if(is==null){
    	        response.getWriter()
    			.write("ERROR: AL DESCARGAR ARCHIVO..!!");
    		    return;
    		 }       	
        	String nombreFichero = filtro.getNombreArchivo();        	
            response.setHeader("Content-Disposition", "attachment; filename=\""
                        + nombreFichero+ "\"");
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();

        }catch (Exception ex) {
            LOG.info("--->"+ex.getMessage());
            LOG.info("Error writing file to output stream. Filename was '" + filtro.getNombreArchivo() + "'");
            throw new RuntimeException("IOError writing file to output stream");
        }        
        

    }
    
    public boolean validaFormatoPermitido(String[] extenciones, String nombre){
        boolean permitida = false;
        int lastIndexOf = nombre.lastIndexOf(".");
        String formato = nombre.substring(lastIndexOf);

        for (int i = 0; i < extenciones.length; i++) {
            if (formato.equalsIgnoreCase(extenciones[i])) {
                permitida = true;
                break;
            }
        }
        return permitida;
    }
    
    @RequestMapping(value = "/subirArchivoCriterio", method = RequestMethod.POST)
    public void subirArchivoCriterio(@RequestParam("archivos[0]") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
	LOG.info("--- subirArchivoCriterio ---");
	LOG.info("nombre = " + file.getOriginalFilename().toUpperCase());
        request.getSession().removeAttribute(Constantes.CONSTANTE_ARCHIVO_CRITERIO);
        
	response.setContentType("text/html;charset=utf-8");
        try {
            LOG.info("formatos permitidos: "+tipoExtencionesArchivoCriterio);
            LOG.info("tamaño file="+file.getSize());
            String[] extenciones = tipoExtencionesArchivoCriterio.split("\\|");
            String strExtenciones = "";
            for (int i = 0; i < extenciones.length; i++) {
                strExtenciones += extenciones[i] + ", ";
            }
            if(!strExtenciones.isEmpty()){
                strExtenciones = strExtenciones.substring(0,strExtenciones.length()-2);
            }
            if (!validaFormatoPermitido(extenciones,file.getOriginalFilename())) {
                response.getWriter().write("{\"error\":true,\"mensaje\":\"Formato no permitido. ( Extenciones permitidas: "+strExtenciones+") \"}");
                return;
            }
            DocumentoAdjuntoDTO archivoDTO = new DocumentoAdjuntoDTO();
            archivoDTO.setNombreArchivo(file.getOriginalFilename().toUpperCase());
            archivoDTO.setRutaAlfrescoTmp(file.getBytes());
            
            request.getSession().setAttribute(Constantes.CONSTANTE_ARCHIVO_CRITERIO, archivoDTO);
            response.getWriter().write("{\"error\":false,\"mensaje\":\"Se cargo el archivo\"}");
            return;
            
        } catch (Exception e) {
            LOG.error("Error subiendo archivo BL", e);
            try {
                response.getWriter().write("{\"error\":true,\"mensaje\":\"Error al insertar Documento\"}");
            } catch (IOException ex) {
                LOG.debug("error al escribir en response", ex);
                ex.printStackTrace();
            }
            return;
        }
    }
    
    @RequestMapping(value = "/subirArchivoObligacion", method = RequestMethod.POST)
    public void subirArchivoObligacion(@RequestParam("archivos[0]") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
	LOG.info("--- subirArchivoObligacion ---");
	LOG.info("nombre = " + file.getOriginalFilename().toUpperCase());
        request.getSession().removeAttribute(Constantes.CONSTANTE_ARCHIVO_OBLIGACION);
        
	response.setContentType("text/html;charset=utf-8");
        try {
            LOG.info("formatos permitidos: "+tipoExtencionesArchivoObligacion);
            LOG.info("tamaño file="+file.getSize());
            String[] extenciones = tipoExtencionesArchivoObligacion.split("\\|");
            String strExtenciones = "";
            for (int i = 0; i < extenciones.length; i++) {
                strExtenciones += extenciones[i] + ", ";
            }
            if(!strExtenciones.isEmpty()){
                strExtenciones = strExtenciones.substring(0,strExtenciones.length()-2);
            }
            if (!validaFormatoPermitido(extenciones,file.getOriginalFilename())) {
                response.getWriter().write("{\"error\":true,\"mensaje\":\"Formato no permitido. ( Extenciones permitidas: "+strExtenciones+") \"}");
                return;
            }
            DocumentoAdjuntoDTO archivoDTO = new DocumentoAdjuntoDTO();
            archivoDTO.setNombreArchivo(file.getOriginalFilename().toUpperCase());
            archivoDTO.setRutaAlfrescoTmp(file.getBytes());
            
            request.getSession().setAttribute(Constantes.CONSTANTE_ARCHIVO_OBLIGACION, archivoDTO);
            response.getWriter().write("{\"error\":false,\"mensaje\":\"Se cargo el archivo\"}");
            return;
            
        } catch (Exception e) {
            LOG.error("Error subiendo archivo BL", e);
            try {
                response.getWriter().write("{\"error\":true,\"mensaje\":\"Error al insertar Documento\"}");
            } catch (IOException ex) {
                LOG.debug("error al escribir en response", ex);
                ex.printStackTrace();
            }
            return;
        }
    }
    
    @RequestMapping(value = "/subirArchivoDescripcion", method = RequestMethod.POST)
    public void subirArchivoDescripcion(@RequestParam("archivos[0]") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
	LOG.info("--- subirArchivoDescripcion ---");
	LOG.info("nombre = " + file.getOriginalFilename().toUpperCase());
        request.getSession().removeAttribute(Constantes.CONSTANTE_ARCHIVO_DESCRIPCON);
        
	response.setContentType("text/html;charset=utf-8");
        try {
            LOG.info("formatos permitidos: "+tipoExtencionesArchivoDescrpcion);
            LOG.info("tamaño file="+file.getSize());
            String[] extenciones = tipoExtencionesArchivoDescrpcion.split("\\|");
            String strExtenciones = "";
            for (int i = 0; i < extenciones.length; i++) {
                strExtenciones += extenciones[i] + ", ";
            }
            if(!strExtenciones.isEmpty()){
                strExtenciones = strExtenciones.substring(0,strExtenciones.length()-2);
            }
            if (!validaFormatoPermitido(extenciones,file.getOriginalFilename())) {
                response.getWriter().write("{\"error\":true,\"mensaje\":\"Formato no permitido. ( Extenciones permitidas: "+strExtenciones+") \"}");
                return;
            }
            DocumentoAdjuntoDTO archivoDTO = new DocumentoAdjuntoDTO();
            archivoDTO.setNombreArchivo(file.getOriginalFilename().toUpperCase());
            archivoDTO.setRutaAlfrescoTmp(file.getBytes());
            
            request.getSession().setAttribute(Constantes.CONSTANTE_ARCHIVO_DESCRIPCON, archivoDTO);
            response.getWriter().write("{\"error\":false,\"mensaje\":\"Se cargo el archivo\"}");
            return;
            
        } catch (Exception e) {
            LOG.error("Error subiendo archivo BL", e);
            try {
                response.getWriter().write("{\"error\":true,\"mensaje\":\"Error al insertar Documento\"}");
            } catch (IOException ex) {
                LOG.debug("error al escribir en response", ex);
                ex.printStackTrace();
            }
            return;
        }
    }
    
    @RequestMapping(value = "/subirArchivo", method = RequestMethod.POST)
    public void subirArchivoLegal(@RequestParam("archivo") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
	LOG.info("subirArchivo");
	LOG.info("nombre = " + file.getOriginalFilename().toUpperCase());
        request.getSession().removeAttribute("archivoSubido");
        
	response.setContentType("text/html;charset=utf-8");
        try {
            LOG.info("formatos permitidos: "+tipoExtencionesArchivo);
            LOG.info("tamaño file="+file.getSize());
            String[] extenciones = tipoExtencionesArchivo.split("\\|");
            String strExtenciones = "";
            for (int i = 0; i < extenciones.length; i++) {
                strExtenciones += extenciones[i] + ", ";
            }
            if(!strExtenciones.isEmpty()){
                strExtenciones = strExtenciones.substring(0,strExtenciones.length()-2);
            }
            if (!validaFormatoPermitido(extenciones,file.getOriginalFilename())) {
                response.getWriter().write("{\"error\":true,\"mensaje\":\"Formato no permitido. ( Extenciones permitidas: "+strExtenciones+") \"}");
                return;
            }
            //List<DocumentoAdjuntoDTO> files = new ArrayList<DocumentoAdjuntoDTO>();
            
            DocumentoAdjuntoDTO archivoDTO = new DocumentoAdjuntoDTO();
            archivoDTO.setNombreArchivo(file.getOriginalFilename().toUpperCase());
            archivoDTO.setRutaAlfrescoTmp(file.getBytes());
            
            //files.add(archivoDTO);
            request.getSession().setAttribute("archivoSubido", archivoDTO);
            LOG.info("archivo recien setteado a sesion: " + archivoDTO);

            response.getWriter().write("{\"error\":false,\"mensaje\":\"Se cargo el archivo\"}");
            return;
            
        } catch (Exception e) {
            LOG.error("Error subiendo archivo BL", e);
            try {
                response.getWriter().write("{\"error\":true,\"mensaje\":\"Error al insertar Documento\"}");
            } catch (IOException ex) {
                LOG.debug("error al escribir en response", ex);
                ex.printStackTrace();
            }
            return;
        }
    }
    
    @RequestMapping(value = "/findByFiltro", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> findByFiltro(DocumentoAdjuntoFilter filtro, int rows,int page, HttpSession session) {            
        LOG.info("findByFiltro");
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        try {   
            int inicio = 0;
                List<DocumentoAdjuntoDTO> listado = null;

                filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);

                inicio = rows * page - rows;
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                int[] auxiliar = new int[1];//para el paso por referencia TODO cambiar?
                auxiliar[0] = 0; 
                Integer cuenta=0;
                int total=0 ;
                listado= documentoServiceNeg.listarDocumentoAdjunto(filtro, auxiliar);
                LOG.info("cuenta controller:"+auxiliar[0]);

                cuenta=auxiliar[0];
                if (cuenta > 0) {
                    total = (int) Math.ceil((double) cuenta / (double) rows);
                }
                LOG.info("cuenta:" + cuenta);

                listaResultado.put("total", total);
                listaResultado.put("pagina", page);
                listaResultado.put("registros", cuenta);
                listaResultado.put("filas", listado);
        } catch (Exception ex) {
                LOG.error("", ex);
        }
        return listaResultado;
    }
    
    @RequestMapping(value = "/registrarDocumento", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> registrarDocumento(DocumentoAdjuntoDTO documentoAdjunto, HttpServletRequest request, HttpSession sesion) {
        LOG.info("procesando registrarDocumento:"+documentoAdjunto);

        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            DocumentoAdjuntoDTO archivo = (DocumentoAdjuntoDTO) request.getSession().getAttribute("archivoSubido");
            request.getSession().removeAttribute("archivoSubido");
            LOG.info("archivo sesion-->"+archivo);
            if (archivo != null) {
                LOG.info("entro en NO nulo");
                archivo.setAplicacionSpace(documentoAdjunto.getAplicacionSpace());
                DocumentoAdjuntoDTO docuAdjuEnviado=documentoServiceNeg.enviarUnArchivoAlfresco(archivo);
                if(docuAdjuEnviado!=null){
                    documentoAdjunto.setNombreArchivo(docuAdjuEnviado.getNombreArchivo());
                    documentoAdjunto.setRutaAlfresco(docuAdjuEnviado.getRutaAlfresco());
                    
                    //GUARDADO DE documentoAdjunto en BD
                    UsuarioDTO usuarioDTO = new UsuarioDTO();
                    usuarioDTO.setCodigo("00001");//TODO por completar
                    usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
                    
                    documentoAdjunto.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                    documentoAdjunto.setFechaCarga(new Date());
                    documentoAdjunto.setIdDocumentoAdjunto(null);
                    
                    GuardarDocumentoAdjuntoInRO in=new GuardarDocumentoAdjuntoInRO();
                    in.setDocumento(documentoAdjunto);
                    in.setUsuario(usuarioDTO);
                    GuardarDocumentoAdjuntoOutRO out = documentoServiceNeg.registrarDocumentoAdjunto(in);
                    if (out.getCodigoResultado() == BaseConstantesOutBean.ERROR) {
                        salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                        salida.put(ConstantesWeb.VV_MENSAJE, "Error al Guardar Registro");
                    } else {
                        salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
                    }
                }else{
                    salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);            
                    salida.put(ConstantesWeb.VV_MENSAJE, "Error al insertar Documento");
                }
    	    }else{
                LOG.info("entro en SI nulo");
                //archivo es obligatorio, por lo q se envia error
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);            
                salida.put(ConstantesWeb.VV_MENSAJE, "Archivo adjunto no encontrado");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            LOG.error("Error registrarDocumento ", ex);
        }
        return salida;
    }
    
    @RequestMapping(value = "/editarDocumento", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> editarDocumento(DocumentoAdjuntoDTO documentoAdjunto, HttpServletRequest request, HttpSession sesion) {
        LOG.info("procesando editarDocumento:"+documentoAdjunto);

        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());

            GuardarDocumentoAdjuntoInRO in=new GuardarDocumentoAdjuntoInRO();
            in.setDocumento(documentoAdjunto);
            in.setUsuario(usuarioDTO);
            GuardarDocumentoAdjuntoOutRO out = documentoServiceNeg.editarDocumentoAdjunto(in);
            if (out.getCodigoResultado() == BaseConstantesOutBean.ERROR) {
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                salida.put(ConstantesWeb.VV_MENSAJE, "Error al Editar Registro");
            } else {
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            LOG.error("Error editarDocumento ", ex);
        }
        return salida;
    }
    @RequestMapping(value = "/eliminarDocumento", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> eliminarDocumento(DocumentoAdjuntoDTO documentoAdjunto, HttpServletRequest request, HttpSession sesion) {
        LOG.info("procesando eliminarDocumento:"+documentoAdjunto);

        Map<String, Object> salida = new HashMap<String, Object>();
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());

            GuardarDocumentoAdjuntoInRO in=new GuardarDocumentoAdjuntoInRO();
            in.setDocumento(documentoAdjunto);
            in.setUsuario(usuarioDTO);
            GuardarDocumentoAdjuntoOutRO out = documentoServiceNeg.eliminarDocumentoAdjunto(in);
            if (out.getCodigoResultado() == BaseConstantesOutBean.ERROR) {
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
                salida.put(ConstantesWeb.VV_MENSAJE, "Error al Eliminar Registro");
            } else {
                salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
            LOG.error("Error editarDocumento ", ex);
        }
        return salida;
    }
}