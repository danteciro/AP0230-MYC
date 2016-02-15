package gob.osinergmin.myc.service.business.impl;

import java.io.File;
import java.io.InputStream;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.alfresco.rest.util.AlfrescoInvoker;
import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.domain.in.GuardarDocumentoAdjuntoInRO;
import gob.osinergmin.myc.domain.out.GuardarDocumentoAdjuntoOutRO;
import gob.osinergmin.myc.domain.ui.DocumentoAdjuntoFilter;
import gob.osinergmin.myc.service.business.DocumentoAdjuntoNeg;
import gob.osinergmin.myc.service.dao.DocumentoAdjuntoDAO;
import gob.osinergmin.myc.util.Constantes;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

@Service("DocumentoAdjuntoNeg")
public class DocumentoAdjuntoNegImpl implements  DocumentoAdjuntoNeg{
    private static final Logger LOG = LoggerFactory.getLogger(DocumentoAdjuntoNegImpl.class);

    @Value("${alfresco.host}")
    private String HOST;
    @Value("${alfresco.download.dir}")
    private String ALFRESCO_DOWNLOAD;
    @Value("${alfresco.user}")
    private String ALFRESCO_USER;
    @Value("${alfresco.base}")
    private String ALFRESCO_BASE;
    @Value("${alfresco.space.dir.requisitos}")
    private String ALFRESCO_SPACE_REQUISITOS;
    @Value("${alfresco.space.dir.obligaciones}")
    private String ALFRESCO_SPACE_OBLIGACIONES;
    @Value("${alfresco.space.dir.generales}")
    private String ALFRESCO_SPACE_GENERALES;
         
    @Inject
    DocumentoAdjuntoDAO documentoAdjuntoDAO;

    @Override
    public GuardarDocumentoAdjuntoOutRO enviarDatosAlfresco(DocumentoAdjuntoDTO archivo,File file){
        GuardarDocumentoAdjuntoOutRO retorno=new GuardarDocumentoAdjuntoOutRO();
        DocumentoAdjuntoDTO listado=null;

        try{
            listado = documentoAdjuntoDAO.uploadFiles(archivo, file);
            if(listado.getRutaAlfresco()!=null){
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
            archivo.setRutaAlfresco(listado.getRutaAlfresco());
            retorno.setDocumento(archivo);
            }else {
            retorno.setMensaje("error");
            }
        }catch(Exception ex){

            LOG.error("error",ex.getMessage());

        }
        return retorno;
    }
	    
    @Override
    public InputStream descargarDatosAlfresco(DocumentoAdjuntoDTO archivo){
        InputStream in =null;
        try{
            //valida SPACE
            String alfrescoSpace="";
            if(archivo.getAplicacionSpace().equals(Constantes.APPLICACION_SPACE_REQUISITOS)){
                alfrescoSpace=ALFRESCO_SPACE_REQUISITOS;
            }else if(archivo.getAplicacionSpace().equals(Constantes.APPLICACION_SPACE_OBLIGACIONES)){
                alfrescoSpace=ALFRESCO_SPACE_OBLIGACIONES;
            }else if(archivo.getAplicacionSpace().equals(Constantes.APPLICACION_SPACE_GENERALES)){
                alfrescoSpace=ALFRESCO_SPACE_GENERALES;
            }
        
            String URL_ALFRESCO_DOWNLOAD = HOST+ALFRESCO_DOWNLOAD;
            in = AlfrescoInvoker.download(URL_ALFRESCO_DOWNLOAD, ALFRESCO_USER, ALFRESCO_BASE, null, null, null, alfrescoSpace,archivo.getRutaAlfresco() );
        }catch(Exception ex){
            ex.printStackTrace();
            LOG.error("error",ex.getMessage());	 
        }
        return in;
    }

    @Override 
    @Transactional
    public GuardarDocumentoAdjuntoOutRO registrarDocumentoAdjunto(GuardarDocumentoAdjuntoInRO in){
        GuardarDocumentoAdjuntoOutRO retorno=new GuardarDocumentoAdjuntoOutRO();
        try{
            DocumentoAdjuntoDTO registro=documentoAdjuntoDAO.create(in.getDocumento(), in.getUsuario()); 
            retorno.setDocumento(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch(Exception ex){
            LOG.error("error registrarDocumentoAdjunto", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
        }
        return retorno;

    }
	   
	   
    @Override 
    @Transactional
    public GuardarDocumentoAdjuntoOutRO editarDocumentoAdjunto(GuardarDocumentoAdjuntoInRO in){
        GuardarDocumentoAdjuntoOutRO retorno=new GuardarDocumentoAdjuntoOutRO();
        try{   
            DocumentoAdjuntoDTO registro=documentoAdjuntoDAO.editar(in.getDocumento(), in.getUsuario()); 
            retorno.setDocumento(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch(Exception ex){
            LOG.error("error guardarParametroDinamico", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
        }

        return retorno;
    }
    
    @Override 
    @Transactional
    public GuardarDocumentoAdjuntoOutRO eliminarDocumentoAdjunto(GuardarDocumentoAdjuntoInRO in){
        GuardarDocumentoAdjuntoOutRO retorno=new GuardarDocumentoAdjuntoOutRO();
        try{   
            DocumentoAdjuntoDTO registro=documentoAdjuntoDAO.changeState(in.getDocumento(), in.getUsuario()); 
            retorno.setDocumento(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch(Exception ex){
            LOG.error("error guardarParametroDinamico", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
        }

        return retorno;
    }

    @Override
    public DocumentoAdjuntoDTO consultarDatosAlfresco(Long idDocumentoAdjunto) {
            DocumentoAdjuntoDTO retorno=null;
                    try{   
                            retorno=documentoAdjuntoDAO.findDocumentoAdjunto(idDocumentoAdjunto); 
                    }catch(Exception ex){
                            LOG.error("error guardarParametroDinamico", ex);

                    }
            return retorno;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentoAdjuntoDTO> listarDocumentoAdjunto(DocumentoAdjuntoFilter filtro, int[] cuenta) {
        LOG.info("Neg listarDocumentoAdjunto");
        List<DocumentoAdjuntoDTO> retorno=null;
        try{
            HashMap resultado = new HashMap();
            
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            resultado = documentoAdjuntoDAO.listarDocumentoAdjunto(filtro);
            retorno = (List<DocumentoAdjuntoDTO>)resultado.get("listado");
            Long contador = (Long)resultado.get("cuenta");
            cuenta[0] = contador.intValue();
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    public DocumentoAdjuntoDTO enviarUnArchivoAlfresco(DocumentoAdjuntoDTO registro){
        LOG.info("entro enviarUnArchivoAlfresco");
        
        DocumentoAdjuntoDTO retorno=null;
        try{
            //genera nombre alfresco
            Date today = new Date();
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ddMMyyyyhhmmss");
            String prefix = DATE_FORMAT.format(today);
            String rutaAlfrescoBD = "MYC" + prefix + "_" + registro.getNombreArchivo().replace(" ", "");
        
            File someFile = new File(rutaAlfrescoBD);
            FileOutputStream fos = new FileOutputStream(someFile);
            fos.write(registro.getRutaAlfrescoTmp());
            fos.flush();
            fos.close();

            retorno=new DocumentoAdjuntoDTO();
            retorno.setNombreArchivo(registro.getNombreArchivo());
            retorno.setAplicacionSpace(registro.getAplicacionSpace());
            LOG.info("enviando alfresh - nombre=>"+retorno.getNombreArchivo());
            LOG.info("enviando alfresh - file=>"+someFile);
            DocumentoAdjuntoDTO outFile = enviarFileAlfresco(retorno, someFile);
            if (outFile!=null && outFile.getRutaAlfresco()!=null){
                retorno.setRutaAlfresco(rutaAlfrescoBD);
            }else{
                retorno=null;
            }
        }catch(Exception e){
            LOG.error("Error al inicio de metodo enviarUnArchivoAlfresco ", e.getMessage());
            e.printStackTrace();
        }
        
        return retorno;
    }
    
    public DocumentoAdjuntoDTO enviarFileAlfresco(DocumentoAdjuntoDTO archivo, File file) {
        LOG.info("entro enviarDatosAlfresco en Service");
        DocumentoAdjuntoDTO retorno = new DocumentoAdjuntoDTO();
        DocumentoAdjuntoDTO listado = null;

        try {
            listado = documentoAdjuntoDAO.uploadFiles(archivo, file);
            if (listado!=null && listado.getRutaAlfresco() != null) {
                retorno.setRutaAlfresco(listado.getRutaAlfresco());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            LOG.error("error en enviarFileAlfresco, ", ex.getMessage());
        }
        return retorno;
    }
    
    
}