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
        InfraccionDTO registro = null;
        try{
            DocumentoAdjuntoDTO documentoAdjunto = infraccionDTO.getDocumentoAdjuntoDTO();            
            registro = infraccionDAO.create(infraccionDTO, usuarioDTO);
            if(documentoAdjunto != null){
                int lastIndexOf = documentoAdjunto.getNombreArchivo().lastIndexOf(".");
                String formato = documentoAdjunto.getNombreArchivo().substring(lastIndexOf);
                registro.setIdObligacion(infraccionDTO.getIdObligacion());
                String rutaAlfrescoBD = registro.getIdObligacion().getIdObligacion() + "_IMG"+ formato;                
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
                    infraccionDAO.update(registro, usuarioDTO);
                }
            }
            LOG.info("(Registro Detalle Obligacion ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return registro;
    }
  
	@Override
	public InfraccionDTO updateInfraccion(
			InfraccionDTO infraccionDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Actualizar Detalle Obligacion ServiceNegImpl");
        InfraccionDTO registro = null;
        try{
            DocumentoAdjuntoDTO documentoAdjunto = infraccionDTO.getDocumentoAdjuntoDTO();
            registro = infraccionDAO.update(infraccionDTO, usuarioDTO);
            if(documentoAdjunto != null){
                String rutaAlfrescoBD;
                if(registro.getDocumentoAdjuntoDTO().getIdDocumentoAdjunto() == null){
                    DocumentoAdjuntoDTO documentoAdjuntoActual = documentoAdjuntoDAO.get(registro.getDocumentoAdjuntoDTO().getIdDocumentoAdjunto());
                    rutaAlfrescoBD = documentoAdjuntoActual.getRutaAlfresco();
                }else{
                    int lastIndexOf = documentoAdjunto.getNombreArchivo().lastIndexOf(".");
                    String formato = documentoAdjunto.getNombreArchivo().substring(lastIndexOf);
                    rutaAlfrescoBD = registro.getIdObligacion() + "_IMG"+ formato;
                }
                System.out.println("-- rutaAlfrescoBD = "+rutaAlfrescoBD);
                File someFile = new File(rutaAlfrescoBD);
                FileOutputStream fos = new FileOutputStream(someFile);
                fos.write(documentoAdjunto.getRutaAlfrescoTmp());
                fos.flush();
                fos.close();
                documentoAdjunto.setAplicacionSpace(Constantes.APPLICACION_SPACE_OBLIGACIONES);
                GuardarDocumentoAdjuntoOutRO outFileAlfresco  = documentoServiceNeg.enviarDatosAlfresco(documentoAdjunto, someFile);
                if (outFileAlfresco != null && outFileAlfresco.getMensaje().equalsIgnoreCase("ok")) {

                    if(registro.getDocumentoAdjuntoDTO().getIdDocumentoAdjunto() != null){
                        DocumentoAdjuntoDTO documentoAdjuntoActual = documentoAdjuntoDAO.get(registro.getDocumentoAdjuntoDTO().getIdDocumentoAdjunto());
                        documentoAdjuntoActual.setNombreArchivo(documentoAdjunto.getNombreArchivo());
                        GuardarDocumentoAdjuntoInRO inDoc = new GuardarDocumentoAdjuntoInRO();
                        inDoc.setDocumento(documentoAdjuntoActual);
                        inDoc.setUsuario(usuarioDTO);
                        documentoServiceNeg.editarDocumentoAdjunto(inDoc);
                    }else{
                        GuardarDocumentoAdjuntoInRO inDoc = new GuardarDocumentoAdjuntoInRO();
                        documentoAdjunto.setRutaAlfresco(rutaAlfrescoBD);
                        documentoAdjunto.setIdDocumentoAdjunto(null);
                        documentoAdjunto.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                        inDoc.setDocumento(documentoAdjunto);
                        inDoc.setUsuario(usuarioDTO);

                        GuardarDocumentoAdjuntoOutRO saveDoc = documentoServiceNeg.registrarDocumentoAdjunto(inDoc);
                        DocumentoAdjuntoDTO documentoAdjuntoCreado = saveDoc.getDocumento();
                        registro.getDocumentoAdjuntoDTO().setIdDocumentoAdjunto(documentoAdjuntoCreado.getIdDocumentoAdjunto());
                        infraccionDAO.update(registro, usuarioDTO);
                    }
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