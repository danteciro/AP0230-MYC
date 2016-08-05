/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.dto.InfraccionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarDocumentoAdjuntoInRO;
import gob.osinergmin.myc.domain.out.GuardarDocumentoAdjuntoOutRO;
import gob.osinergmin.myc.service.business.DocumentoAdjuntoNeg;
import gob.osinergmin.myc.service.business.InfraccionServiceNeg;
import gob.osinergmin.myc.service.dao.DocumentoAdjuntoDAO;
import gob.osinergmin.myc.service.dao.InfraccionDAO;
import gob.osinergmin.myc.util.Constantes;

import java.io.File;
import java.io.FileOutputStream;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rcoloradoa
 */
@Service("InfraccionServiceNegImpl")
public class InfraccionServiceNegImpl implements InfraccionServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(InfraccionServiceNegImpl.class);
    
    @Inject
    private InfraccionDAO infraccionDAO;

    @Inject
    private DocumentoAdjuntoDAO documentoAdjuntoDAO;
    
    @Inject
    private DocumentoAdjuntoNeg documentoServiceNeg;           
    
    @Override
    @Transactional
    public InfraccionDTO guardaInfraccion(InfraccionDTO infraccionDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Infraccion ServiceNegImpl");
        InfraccionDTO registro = new InfraccionDTO();
        try{
            DocumentoAdjuntoDTO documentoAdjunto = infraccionDTO.getDocumentoAdjuntoDTO();   
            
            registro = infraccionDAO.create(infraccionDTO, usuarioDTO);
            
            if(documentoAdjunto != null){
                int lastIndexOf = documentoAdjunto.getNombreArchivo().lastIndexOf(".");
                String formato = documentoAdjunto.getNombreArchivo().substring(lastIndexOf);
                registro.setIdObligacion(infraccionDTO.getIdObligacion());
                String rutaAlfrescoBD = documentoAdjunto.getNombreArchivo().substring(0,lastIndexOf) + "_IMG_INF"+ formato;
                documentoAdjunto.setNombreArchivo(rutaAlfrescoBD);             
                File someFile = new File(rutaAlfrescoBD);
                FileOutputStream fos = new FileOutputStream(someFile);
                fos.write(documentoAdjunto.getRutaAlfrescoTmp());
                fos.flush();
                fos.close();
                documentoAdjunto.setAplicacionSpace(Constantes.APPLICACION_SPACE_OBLIGACIONES);
                GuardarDocumentoAdjuntoOutRO outFileAlfresco  = documentoServiceNeg.enviarDatosAlfresco(documentoAdjunto, someFile);
                if (outFileAlfresco != null && outFileAlfresco.getMensaje().equalsIgnoreCase("ok")) {                    
                	GuardarDocumentoAdjuntoInRO inDoc = new GuardarDocumentoAdjuntoInRO();
                    documentoAdjunto.setRutaAlfresco(rutaAlfrescoBD);
                    documentoAdjunto.setIdDocumentoAdjunto(null);
                    documentoAdjunto.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                    inDoc.setDocumento(documentoAdjunto);
                    inDoc.setUsuario(usuarioDTO);

                    GuardarDocumentoAdjuntoOutRO saveDoc = documentoServiceNeg.registrarDocumentoAdjunto(inDoc);
                    DocumentoAdjuntoDTO documentoAdjuntoCreado = saveDoc.getDocumento();
                    registro.setDocumentoAdjuntoDTO(documentoAdjuntoCreado);
                    infraccionDTO.setDocumentoAdjuntoDTO(documentoAdjuntoCreado);
                    infraccionDTO.setIdInfraccion(registro.getIdInfraccion());
                    
                    registro = infraccionDAO.update(infraccionDTO, usuarioDTO);
                }
            }
           
            
            LOG.info("(Registro Detalle Obligacion ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return registro;
    }
  
	@Override
	@Transactional
	public InfraccionDTO updateInfraccion(
			InfraccionDTO infraccionDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Actualizar Detalle Obligacion ServiceNegImpl");
        InfraccionDTO registro = null;
        try{
            DocumentoAdjuntoDTO documentoAdjunto = infraccionDTO.getDocumentoAdjuntoDTO();
            registro = infraccionDAO.update(infraccionDTO, usuarioDTO);
            if(documentoAdjunto != null){
                String rutaAlfrescoBD=null;
                	int lastIndexOf = documentoAdjunto.getNombreArchivo().lastIndexOf(".");
                    String formato = documentoAdjunto.getNombreArchivo().substring(lastIndexOf);
                    rutaAlfrescoBD = documentoAdjunto.getNombreArchivo().substring(0,lastIndexOf) + "_IMG_INF"+ formato;
                    documentoAdjunto.setNombreArchivo(rutaAlfrescoBD);
//                else{
//                	DocumentoAdjuntoDTO documentoAdjuntoActual = documentoAdjuntoDAO.get(registro.getDocumentoAdjuntoDTO().getIdDocumentoAdjunto());
//                    rutaAlfrescoBD = documentoAdjuntoActual.getRutaAlfresco();	
//                }               
                    
                
                System.out.println("-- rutaAlfrescoBD = "+rutaAlfrescoBD);
                File someFile = new File(rutaAlfrescoBD);
                FileOutputStream fos = new FileOutputStream(someFile);
                fos.write(documentoAdjunto.getRutaAlfrescoTmp());
                fos.flush();
                fos.close();
                documentoAdjunto.setAplicacionSpace(Constantes.APPLICACION_SPACE_OBLIGACIONES);
                GuardarDocumentoAdjuntoOutRO outFileAlfresco  = documentoServiceNeg.enviarDatosAlfresco(documentoAdjunto, someFile);
                if (outFileAlfresco != null && outFileAlfresco.getMensaje().equalsIgnoreCase("ok")) {

//                    if(registro.getDocumentoAdjuntoDTO()!=null && registro.getDocumentoAdjuntoDTO().getIdDocumentoAdjunto() != null){
//                        DocumentoAdjuntoDTO documentoAdjuntoActual = documentoAdjuntoDAO.get(registro.getDocumentoAdjuntoDTO().getIdDocumentoAdjunto());
//                        documentoAdjuntoActual.setNombreArchivo(documentoAdjunto.getNombreArchivo());
//                        GuardarDocumentoAdjuntoInRO inDoc = new GuardarDocumentoAdjuntoInRO();
//                        inDoc.setDocumento(documentoAdjuntoActual);
//                        inDoc.setUsuario(usuarioDTO);
//                        GuardarDocumentoAdjuntoOutRO saveDoc = documentoServiceNeg.editarDocumentoAdjunto(inDoc);
//                        DocumentoAdjuntoDTO documentoAdjuntoCreado = saveDoc.getDocumento();
//                        registro.getDocumentoAdjuntoDTO().setIdDocumentoAdjunto(documentoAdjuntoCreado.getIdDocumentoAdjunto());
//                        registro.getDocumentoAdjuntoDTO().setNombreArchivo(documentoAdjuntoCreado.getNombreArchivo());
//                        registro.getDocumentoAdjuntoDTO().setRutaAlfresco(documentoAdjuntoCreado.getRutaAlfresco());
//                        registro=infraccionDAO.update(registro, usuarioDTO);
//                    }else{
                        GuardarDocumentoAdjuntoInRO inDoc = new GuardarDocumentoAdjuntoInRO();
                        documentoAdjunto.setRutaAlfresco(rutaAlfrescoBD);
                        documentoAdjunto.setIdDocumentoAdjunto(null);
                        documentoAdjunto.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                        inDoc.setDocumento(documentoAdjunto);
                        inDoc.setUsuario(usuarioDTO);

                        GuardarDocumentoAdjuntoOutRO saveDoc = documentoServiceNeg.registrarDocumentoAdjunto(inDoc);
                        DocumentoAdjuntoDTO documentoAdjuntoCreado = saveDoc.getDocumento();
                        DocumentoAdjuntoDTO documento = new DocumentoAdjuntoDTO();
                        documento.setIdDocumentoAdjunto(documentoAdjuntoCreado.getIdDocumentoAdjunto());
                        documento.setNombreArchivo(documentoAdjuntoCreado.getNombreArchivo());
                        documento.setRutaAlfresco(documentoAdjuntoCreado.getRutaAlfresco());
                        registro.setDocumentoAdjuntoDTO(documento);
                        registro=infraccionDAO.update(registro, usuarioDTO);
//                    }
                }
            }
            LOG.info("(Actualizar Detalle Obligacion ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return registro;
	}
	
	@Override
    public Long listarInfraccion(Long idObligacion) {
        LOG.info("Funcion: Listar Infraccion-- Service Impl -- Clase: listarInfraccion");
        LOG.info("-- idObligacion = "+idObligacion);
        
        Long retorno = null;
        InfraccionDTO infraccion=new InfraccionDTO();
        infraccion.setIdObligacion2(idObligacion);
        retorno=infraccionDAO.findInfraccion(infraccion);
        return retorno;
        
        
    }

    
    
}