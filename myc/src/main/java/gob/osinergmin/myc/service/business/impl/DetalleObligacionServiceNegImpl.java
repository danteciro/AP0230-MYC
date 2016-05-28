/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.DetalleObligacionDTO;
import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarDocumentoAdjuntoInRO;
import gob.osinergmin.myc.domain.out.GuardarDocumentoAdjuntoOutRO;
import gob.osinergmin.myc.domain.ui.DetalleObligacionFilter;
import gob.osinergmin.myc.service.business.DetalleObligacionServiceNeg;
import gob.osinergmin.myc.service.business.DocumentoAdjuntoNeg;
import gob.osinergmin.myc.service.dao.DetalleObligacionDAO;
import gob.osinergmin.myc.service.dao.DocumentoAdjuntoDAO;
import gob.osinergmin.myc.util.Constantes;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lbarboza
 */
@Service("DetalleObligacionServiceNegImpl")
public class DetalleObligacionServiceNegImpl implements DetalleObligacionServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(DetalleObligacionServiceNegImpl.class);
    
    @Inject
    private DetalleObligacionDAO detalleObligacionDAO;

    @Inject
    private DocumentoAdjuntoDAO documentoAdjuntoDAO;
    
    @Inject
    private DocumentoAdjuntoNeg documentoServiceNeg;
    
    @Override
    @Transactional
    public DetalleObligacionDTO guardaDetalleObligacion(DetalleObligacionDTO detalleObligacionDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Detalle Obligacion ServiceNegImpl");
        DetalleObligacionDTO registro = null;
        try{
            DocumentoAdjuntoDTO documentoAdjunto = detalleObligacionDTO.getDocumentoAdjunto();
            registro = detalleObligacionDAO.create(detalleObligacionDTO, usuarioDTO);
            if(documentoAdjunto != null){
                int lastIndexOf = documentoAdjunto.getNombreArchivo().lastIndexOf(".");
                String formato = documentoAdjunto.getNombreArchivo().substring(lastIndexOf);
                String rutaAlfrescoBD = registro.getIdDetalleObligacion() + "_IMG"+ formato;
                System.out.println("-- rutaAlfrescoBD = "+rutaAlfrescoBD);
                File someFile = new File(rutaAlfrescoBD);
                FileOutputStream fos = new FileOutputStream(someFile);
                fos.write(documentoAdjunto.getRutaAlfrescoTmp());
                fos.flush();
                fos.close();
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
                    registro.setIdDocumentoAdjunto(documentoAdjuntoCreado.getIdDocumentoAdjunto());
                    detalleObligacionDAO.update(registro, usuarioDTO);
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
    public DetalleObligacionDTO eliminarDetalleObligacion(DetalleObligacionDTO detalleObligacionDTO) {
        LOG.info("Eliminar Detalle Obligacion ServiceNegImpl");
        DetalleObligacionDTO eliminar = null;
        try{
            eliminar = detalleObligacionDAO.changeState(detalleObligacionDTO);
            LOG.info("(Eliminar Detalle Obligacion ServiceNegImpl) registro: "+eliminar.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return eliminar;
    }

    @Override
    @Transactional
    public List<DetalleObligacionDTO> listarDetalleObligacion(DetalleObligacionFilter filtro, int[] cuenta) {
        LOG.info("Funcion: Listar Detalle Obligacion-- Service Impl -- Clase: listarDetalleObligacion");
        List<DetalleObligacionDTO> listado = null;
        try{
            cuenta[0] = detalleObligacionDAO.count(filtro).intValue();
            LOG.info("cuenta: "+cuenta[0]);
            if(cuenta[0] > 0){
                listado = detalleObligacionDAO.find(filtro);
                LOG.info("Funcion: numero de registros en el listado: "+listado.size());
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return listado;
    }

	@Override
	public DetalleObligacionDTO updateDetalleObligacion(
			DetalleObligacionDTO detalleObligacionDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Actualizar Detalle Obligacion ServiceNegImpl");
        DetalleObligacionDTO registro = null;
        try{
            DocumentoAdjuntoDTO documentoAdjunto = detalleObligacionDTO.getDocumentoAdjunto();
            registro = detalleObligacionDAO.update(detalleObligacionDTO, usuarioDTO);
            if(documentoAdjunto != null){
                String rutaAlfrescoBD;
                if(registro.getIdDocumentoAdjunto() != null){
                    DocumentoAdjuntoDTO documentoAdjuntoActual = documentoAdjuntoDAO.get(registro.getIdDocumentoAdjunto());
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
                documentoAdjunto.setAplicacionSpace(Constantes.APPLICACION_SPACE_OBLIGACIONES);//setear space 08/06/2015
                GuardarDocumentoAdjuntoOutRO outFileAlfresco  = documentoServiceNeg.enviarDatosAlfresco(documentoAdjunto, someFile);
                if (outFileAlfresco != null && outFileAlfresco.getMensaje().equalsIgnoreCase("ok")) {

                    if(registro.getIdDocumentoAdjunto() != null){
                        DocumentoAdjuntoDTO documentoAdjuntoActual = documentoAdjuntoDAO.get(registro.getIdDocumentoAdjunto());
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
                        registro.setIdDocumentoAdjunto(documentoAdjuntoCreado.getIdDocumentoAdjunto());
                        detalleObligacionDAO.update(registro, usuarioDTO);
                    }
                }
            }
            LOG.info("(Actualizar Detalle Obligacion ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return registro;
	}
    
    
}