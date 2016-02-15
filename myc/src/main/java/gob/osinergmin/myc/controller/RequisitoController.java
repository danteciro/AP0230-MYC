/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.dto.RequisitoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ValorParametroDTO;
import gob.osinergmin.myc.domain.in.GuardarDocumentoAdjuntoInRO;
import gob.osinergmin.myc.domain.in.GuardarRequisitoInRO;
import gob.osinergmin.myc.domain.out.GuardarDocumentoAdjuntoOutRO;
import gob.osinergmin.myc.domain.out.GuardarRequisitoOutRO;
import gob.osinergmin.myc.domain.out.GuardarValorParametroOutRO;
import gob.osinergmin.myc.domain.ui.RequisitoFilter;
import gob.osinergmin.myc.domain.ui.ValorParametroFilter;
import gob.osinergmin.myc.service.business.DocumentoAdjuntoNeg;
import gob.osinergmin.myc.service.business.RequisitoServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.URI;
import java.text.SimpleDateFormat;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/requisito")
public class RequisitoController {
    private static final Logger LOG = LoggerFactory.getLogger(RequisitoController.class);
    
    @Inject
    private RequisitoServiceNeg requisitoServiceNeg;
    @Inject
    private DocumentoAdjuntoNeg documentoServiceNeg;
    //@Value("#{mycProps['archivo.tipo.extenciones']}")
    @Value("${archivo.tipo.extenciones}")
    private String tipoExtencionesArchivo;    
    
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpSession sesion,HttpServletRequest request) {
        model.addAttribute("fecha", ConstantesWeb.getFECHA());
        model.addAttribute("usuario", ConstantesWeb.getUSUARIO(request));
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT_REQUISITO;
    }
    
    @RequestMapping(value="/eliminarRequisito", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> eliminarRequisito(RequisitoDTO requisitoDTO){
        LOG.info("procesando eliminarRequisito");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            requisitoDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            GuardarRequisitoInRO in=new GuardarRequisitoInRO();
            in.setRequisito(requisitoDTO);
            in.setUsuario(usuarioDTO);
            
            /*Validacion dependencias de Procedimientos*/
            List<CnfRequProcedimientoDTO>listaProc=new ArrayList<CnfRequProcedimientoDTO>(); 
            RequisitoFilter filtro = new RequisitoFilter();
            filtro.setIdRequisito(requisitoDTO.getIdRequisito());
            listaProc=requisitoServiceNeg.obtenerDependencias(filtro);
            
            if(listaProc.size()==0 || listaProc == null ){
	            GuardarRequisitoOutRO out=requisitoServiceNeg.eliminarRequisito(in);
	            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
	            retorno.put("requisito", out.getRequisito());              
	            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
            } else {
            	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.DEPENDENCE);  
            	retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
            }
            
        }catch(Exception e){
            LOG.error("Error en eliminarRequisito: "+e.getMessage());
            e.printStackTrace();
        }
        
        return retorno;
    }
    
    @RequestMapping(value="/validarRequisito", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> validarRequisito(RequisitoDTO requisitoDTO){
        LOG.info("procesando validarRequisito");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{
        	 /*Validacion dependencias de Procedimientos*/
            List<CnfRequProcedimientoDTO>listaProc=new ArrayList<CnfRequProcedimientoDTO>(); 
            RequisitoFilter filtro = new RequisitoFilter();
            filtro.setIdRequisito(requisitoDTO.getIdRequisito());
            listaProc=requisitoServiceNeg.obtenerDependencias(filtro);
            
            if(listaProc.size()==0 || listaProc == null){
	            retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
	            retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
            } else {
            	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.DEPENDENCE);  
            	retorno.put(ConstantesWeb.VV_MENSAJE, "ok");
            }
        	
        }catch(Exception e){
            LOG.error("Error en validarRequisito: "+e.getMessage());
            e.printStackTrace();
        }
		return retorno;
    }
    @RequestMapping(value="/editarRequisito", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> editarRequisito(RequisitoDTO requisitoDTO, HttpServletRequest request){
        LOG.info("procesando editarRequisito");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            requisitoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            GuardarRequisitoInRO in=new GuardarRequisitoInRO();
            // lista de Archivos
    	    List<DocumentoAdjuntoDTO> listaArchivos = ((List<DocumentoAdjuntoDTO>) request.getSession().getAttribute("listaArchivos"));
    	
    	    DocumentoAdjuntoDTO documento =new DocumentoAdjuntoDTO(); 
    	    
    	    if (listaArchivos == null) {
    		LOG.info("--->nombreArchivo="+requisitoDTO.getNombreArchivo());
                listaArchivos = new ArrayList<DocumentoAdjuntoDTO>();
                in.setRequisito(requisitoDTO);
                in.setUsuario(usuarioDTO);    	
            
                if( requisitoDTO.getIdRequisito().equals(in.getRequisito().getIdRequisito() )) {	    		
                    GuardarRequisitoOutRO out=requisitoServiceNeg.editarRequisito(in);
                    retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
                    retorno.put("requisito", out.getRequisito());              
                    retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
                }
            
    	    } else {
                Date today = new Date();
    				
                SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ddMMyyyyhhmmss");
    		String prefix = DATE_FORMAT.format(today);
    		String rutaAlfrescoBD="MYCSGR"+prefix+"_"+listaArchivos.get(0).getNombreArchivo().replace(" ", "");
    	    	
                List<File> files = new ArrayList<File>();
                int i = 1;
                for (DocumentoAdjuntoDTO a : listaArchivos) {
                    requisitoDTO.setNombreArchivo(a.getNombreArchivo());
    	    	
                    File someFile = new File(rutaAlfrescoBD);
                    FileOutputStream fos = new FileOutputStream(someFile);
                    fos.write( a.getRutaAlfrescoTmp());
                    fos.flush();
                    fos.close(); 		     
                    files.add(someFile);
                    documento.setNombreArchivo(a.getNombreArchivo());    
                    documento.setAplicacionSpace(Constantes.APPLICACION_SPACE_REQUISITOS);
                }
    	    
                GuardarDocumentoAdjuntoInRO inDoc=new GuardarDocumentoAdjuntoInRO();
                GuardarDocumentoAdjuntoOutRO outFile=documentoServiceNeg.enviarDatosAlfresco(documento, files.get(0));
    	    
                if (outFile.getMensaje().equalsIgnoreCase("ok")){
	    	    documento.setRutaAlfresco(rutaAlfrescoBD);
	    	    documento.setIdDocumentoAdjunto(null);
	    	    documento.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
	    	    inDoc.setDocumento(documento);
	    	    inDoc.setUsuario(usuarioDTO);
	    	    
	    	    /*if (requisitoDTO.getIdDocumentoAdjunto()!=null){
                        GuardarDocumentoAdjuntoOutRO saveDoc =documentoServiceNeg.editarDocumentoAdjunto(inDoc);
			requisitoDTO.setIdDocumentoAdjunto(saveDoc.getDocumento().getIdDocumentoAdjunto());	 	
	    	    } else {*/
                        GuardarDocumentoAdjuntoOutRO saveDoc =documentoServiceNeg.registrarDocumentoAdjunto(inDoc);
                        requisitoDTO.setIdDocumentoAdjunto(saveDoc.getDocumento().getIdDocumentoAdjunto());	           
	    	    //}
	    	    
	            in.setRequisito(requisitoDTO);
	            in.setUsuario(usuarioDTO);
	            
	            if( requisitoDTO.getIdRequisito().equals(in.getRequisito().getIdRequisito() )) {
                        GuardarRequisitoOutRO out=requisitoServiceNeg.editarRequisito(in);
                        retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
                        retorno.put("requisito", out.getRequisito());              
                        retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());
	            }
		        
                    request.getSession().removeAttribute("listaArchivos");
                } else 	{
                    retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.RESTRICT);  
                    retorno.put(ConstantesWeb.VV_MENSAJE, "Error al insertar Documento");
	            request.getSession().removeAttribute("listaArchivos");
	        	
                }
    	    
    	    }   
            
            
        }catch(Exception e){
            LOG.error("Error en editarRequisito: "+e.getMessage());
            e.printStackTrace();
        }
        
        return retorno;
    }
    
    @RequestMapping(value="/registrarRequisito", method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> registrarRequisito(RequisitoDTO requisitoDTO,HttpServletRequest request){
        LOG.info("procesando registrarRequisito");
        Map<String,Object> retorno = new HashMap<String,Object>();
        
        try{
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCodigo("00001");//TODO por completar
            usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            requisitoDTO.setIdRequisito(null);
            requisitoDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);           
            requisitoDTO.getDescripcion().replaceAll(" +", " ");
            GuardarRequisitoInRO in=new GuardarRequisitoInRO();
            
            // lista de Archivos
    	    List<DocumentoAdjuntoDTO> listaArchivos = ((List<DocumentoAdjuntoDTO>) request.getSession().getAttribute("listaArchivos"));
    	
    	    DocumentoAdjuntoDTO documento =new DocumentoAdjuntoDTO(); 
    	    
            /*Validacion  */
            List<RequisitoDTO>listaReq=new ArrayList<RequisitoDTO>(); 
            RequisitoFilter filtro = new RequisitoFilter();
            filtro.setIdRequisito(requisitoDTO.getIdRequisito());
            filtro.setDescripcion(requisitoDTO.getDescripcion().replaceAll(" +", " "));
                           
            listaReq=requisitoServiceNeg.validarRequisitoIdentico(filtro);     
    	    
    	    
    	    if (listaArchivos == null) {
    	    	
    		    listaArchivos = new ArrayList<DocumentoAdjuntoDTO>();
                in.setRequisito(requisitoDTO);
                in.setUsuario(usuarioDTO);    		
                
                if(listaReq.size()==0 || listaReq == null) {
                    GuardarRequisitoOutRO out=requisitoServiceNeg.guardarRequisito(in);
 	   	            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
 	   	            retorno.put("requisito", out.getRequisito());              
 	   	            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());	      	            
                   } else {
                   	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.RESTRICT);  
                   	retorno.put(ConstantesWeb.VV_MENSAJE, Constantes.CONSTANTE_MSJE_YA_EXISTE+" Requisito.");
                   }
                
    	    } else {    	    
    	    
                List<File> files = new ArrayList<File>();
                int i = 1;
                Date today = new Date();

                SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ddMMyyyyhhmmss");
                String prefix = DATE_FORMAT.format(today);
                String rutaAlfrescoBD="MYCSGR"+prefix+"_"+listaArchivos.get(0).getNombreArchivo().replace(" ", "");
	    		
                for (DocumentoAdjuntoDTO a : listaArchivos) {
                    requisitoDTO.setNombreArchivo(a.getNombreArchivo());

                    //File someFile = new File(a.getNombreArchivo());
                    File someFile = new File(rutaAlfrescoBD);
                    FileOutputStream fos = new FileOutputStream(someFile);
                    fos.write( a.getRutaAlfrescoTmp());
                    fos.flush();
                    fos.close(); 		     
                    files.add(someFile);
                    documento.setNombreArchivo(a.getNombreArchivo());    
                    documento.setAplicacionSpace(Constantes.APPLICACION_SPACE_REQUISITOS);
                }

                GuardarDocumentoAdjuntoInRO inDoc=new GuardarDocumentoAdjuntoInRO();
                GuardarDocumentoAdjuntoOutRO outFile=documentoServiceNeg.enviarDatosAlfresco(documento, files.get(0));
    	    
    	    
                if (outFile.getMensaje().equalsIgnoreCase("ok")){
    	    	
	    	    //documento.setRutaAlfresco(outFile.getDocumento().getRutaAlfresco());
    	    	documento.setRutaAlfresco(rutaAlfrescoBD);
	    	    documento.setIdDocumentoAdjunto(null);
	    	    documento.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
	    	    inDoc.setDocumento(documento);
	    	    inDoc.setUsuario(usuarioDTO);
	    	    
                GuardarDocumentoAdjuntoOutRO saveDoc =documentoServiceNeg.registrarDocumentoAdjunto(inDoc);
                requisitoDTO.setIdDocumentoAdjunto(saveDoc.getDocumento().getIdDocumentoAdjunto());	           
	            
	            in.setRequisito(requisitoDTO);
	            in.setUsuario(usuarioDTO);	            
     
	            
               if(listaReq.size()==0 || listaReq == null) {
                   GuardarRequisitoOutRO out=requisitoServiceNeg.guardarRequisito(in);
	   	            retorno.put(ConstantesWeb.VV_RESULTADO, out.getCodigoResultado());
	   	            retorno.put("requisito", out.getRequisito());              
	   	            retorno.put(ConstantesWeb.VV_MENSAJE, out.getMensaje());	      	            
                  } else {
                  	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.RESTRICT);  
                  	retorno.put(ConstantesWeb.VV_MENSAJE, Constantes.CONSTANTE_MSJE_YA_EXISTE+" Requisito.");
                  }
	            
	            request.getSession().removeAttribute("listaArchivos");
			} else 	{
	    	    retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);  
                retorno.put(ConstantesWeb.VV_MENSAJE, "Error al insertar Documento");
	            request.getSession().removeAttribute("listaArchivos");
	        	
	    		}
    	    
    	    }          
           
            
        }catch(Exception e){
            LOG.error("Error en registrarRequisito: "+e.getMessage());
            e.printStackTrace();
        }
        
        return retorno;
    }
    
    @RequestMapping(value = "/abrirMantRequisito", method = RequestMethod.GET)
    public String abrirMantRequisito ( String tipo, Long idRequisito,HttpSession sesion,Model model ) {
        LOG.info("abrirMantRequisito, tipo:"+tipo);
        LOG.info("abrirMantRequisito, idRequisito:"+idRequisito);
        model.addAttribute("tipo", tipo);
        
        
        if(!tipo.equals("new") && idRequisito!=null){
            RequisitoFilter filtro=new RequisitoFilter();
            filtro.setIdRequisito(idRequisito);
            RequisitoDTO registro=requisitoServiceNeg.buscarRequisitoByFiltro(filtro);
            model.addAttribute("r", registro);
            model.addAttribute("nombreArchivo",registro.getNombreArchivo());
            model.addAttribute("idDocumentoAdjunto",registro.getIdDocumentoAdjunto());
            LOG.info("nombreArchivo:"+registro.getNombreArchivo()+"-"+registro.getIdDocumentoAdjunto());
        }
        
        return ConstantesWeb.Navegacion.PAGE_REQUISITOS_MANT_FRM_REQUISITO;
    }
    
    @RequestMapping(value="/verificaRequisitoSimilar",method= RequestMethod.GET)
    public @ResponseBody List<RequisitoDTO> verificaRequisitoSimilar(RequisitoFilter filtro){
        LOG.info("procesando verificaRequisitoSimilar");
        List<RequisitoDTO> retorno=new ArrayList<RequisitoDTO>();
        try{
        	
            String descripcion = new String(filtro.getDescripcion().replaceAll(" +", " ").getBytes(), "UTF-8");
            filtro.setDescripcion(descripcion);
        	
            retorno=requisitoServiceNeg.verificaRequisitoSimilar(filtro);                
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value="/consultarRequisito",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> consultarRequisito(RequisitoFilter filtro, HttpServletRequest request,HttpSession session){
        
    	
    	LOG.info("consultarRequisito");
        List<RequisitoDTO> requisitos=new ArrayList<RequisitoDTO>();
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
        	
            String descripcion = new String(filtro.getDescripcion().getBytes(), "UTF-8");
            filtro.setDescripcion(descripcion);
        //	request.setCharacterEncoding("UTF-8");
            Integer cuenta;
            int[] auxiliar=new int[1];
            auxiliar[0]=0;
            requisitos =requisitoServiceNeg.listarRequisito(filtro, auxiliar);
            cuenta=auxiliar[0];
            retorno.put("registros", cuenta);
            retorno.put("filas", requisitos);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
        
    
    
    @RequestMapping(value="/findRequisito",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> findRequisito(RequisitoFilter filtro,int rows, int page,int flg_load,HttpSession session){
        LOG.info("findRequisito");
    	
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            List<RequisitoDTO> listado;
            int total=0;
            Integer cuenta;
            
            if(flg_load==1){
                int inicio;
                inicio=rows*page-rows;
                
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                
                int[] auxiliar=new int[1];
                auxiliar[0]=0;
                String descripcion = new String(filtro.getDescripcion().getBytes(), "UTF-8");
                filtro.setDescripcion(descripcion);
                
                listado=requisitoServiceNeg.listarRequisito(filtro, auxiliar);
                LOG.info("Cuenta Controller findRequisito="+auxiliar[0]);
                //LOG.info("Cuenta Controller ="+listado.size());
                
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
    
    @RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
    public void getFile( @PathVariable("file_name") String fileName, 
        HttpServletResponse response) {
        try {
            // get your file as InputStream
            String nombreFichero = "leeme.txt";
            String unPath = "D:/NUEVO/";

            URI url = getClass().getResource("../../../../../reports").toURI();

            //  response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment; filename=\""
                        + nombreFichero+ "\"");
            LOG.info(url.getPath()+nombreFichero);
            InputStream is = new FileInputStream(url.getPath()+nombreFichero);
            // copy it to response's OutputStream
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();

        }catch (Exception ex) {
            LOG.info("--->"+ex.getMessage());
            LOG.info("Error writing file to output stream. Filename was '" + fileName + "'");
            throw new RuntimeException("IOError writing file to output stream");
        }
    }
    
    @RequestMapping(value = "/subirArchivo", method = RequestMethod.POST)
    public void subirArchivo(@RequestParam("archivos[0]") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
	LOG.info("subirArchivo");

	LOG.info("subirArchivo " + file.getOriginalFilename().toUpperCase());
	String nombre = file.getOriginalFilename();

	response.setContentType("text/html;charset=utf-8");
        request.getSession().removeAttribute("listaArchivos");
	List<DocumentoAdjuntoDTO> files = (List<DocumentoAdjuntoDTO>) request.getSession()
		.getAttribute("listaArchivos");
	LOG.info("archivos en sesion: " + files);
	Long ultimoIdArchivo = (long) -1;
	String[] extenciones = tipoExtencionesArchivo.split("\\|");	

	if (files == null) {
	    files = new ArrayList<DocumentoAdjuntoDTO>();
	}
	if (!file.isEmpty()) {
	    try {

		boolean permitida = false;
		int lastIndexOf = nombre.lastIndexOf(".");
		String formato = nombre.substring(lastIndexOf);

		for (int i = 0; i < extenciones.length; i++) {
			if (formato.equalsIgnoreCase(extenciones[i])) {
				permitida = true;
			break;
		    }
		}

		if (!permitida) {
		    response.getWriter()
			    .write("{\"error\":true,\"mensaje\":\"Formato no Permitido\"}");
		    return;
		}

		DocumentoAdjuntoDTO archivoDTO = new DocumentoAdjuntoDTO();

		archivoDTO.setNombreArchivo(file.getOriginalFilename().toUpperCase());
		archivoDTO.setRutaAlfrescoTmp(file.getBytes());
		files.add(archivoDTO);
		request.getSession().setAttribute("listaArchivos", files);
		response.getWriter()
			.write("{\"error\":false,\"mensaje\":\"Se cargo el archivo\"}");
		return;

	    } catch (Exception e) {
	    	LOG.error("Error subiendo archivo", e);
		try {
		    response.getWriter()
			    .write("{\"error\":true,\"mensaje\":\"Error al insertar Documento\"}");
		} catch (IOException ex) {
			LOG.debug("error al escribir en response", ex);
		    ex.printStackTrace();
		}

		return;
	    }
	}/* else {
	    try {
		response.getWriter().write(
			"{\"error\":true,\"mensaje\":\"Ingrese un archivo\"}");

	    } catch (IOException ex) {
	    	LOG.debug("error al escribir en response", ex);
		ex.printStackTrace();
	    }
	    return;
	}*/

    }
    
    @RequestMapping(value="/descargaArchivoAlfresco",method= RequestMethod.GET)
    //public @ResponseBody Map<String, Object> descargaArchivoAlfresco(DocumentoAdjuntoDTO filtro){
    public void descargaArchivoAlfresco( DocumentoAdjuntoDTO filtro, HttpServletResponse response) {
        LOG.info("procesando descargaArchivoAlfresco--->"+filtro.getNombreArchivo());        
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
    
    

}