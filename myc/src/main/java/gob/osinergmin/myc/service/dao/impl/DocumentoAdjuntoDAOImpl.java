package gob.osinergmin.myc.service.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.alfresco.remote.rest.ro.out.AlfrescoOutRO;
import gob.osinergmin.alfresco.remote.rest.ro.out.list.ListAlfrescoOutRO;
import gob.osinergmin.alfresco.rest.util.AlfrescoInvoker;
import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.MdiDocumentoAdjunto;
import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.builder.DocumentoAdjuntoBuilder;
import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.DocumentoAdjuntoFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.DocumentoAdjuntoDAO;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.siged.remote.enums.InvocationResult;
import java.util.HashMap;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Value;

@Service("DocumentoAdjuntoDAO")
public class DocumentoAdjuntoDAOImpl implements DocumentoAdjuntoDAO{
    private static final Logger LOG = LoggerFactory.getLogger(DocumentoAdjuntoDAOImpl.class);

    
    @Value("${alfresco.host}")
    private String HOST;
    @Value("${alfresco.upload.dir}")
    private String ALFRESCO_UPLOAD;
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
    
//    private static final String HOST = "http://11.160.121.132:8180/siged-rest-old";
//    private static final String URL_ALFRESCO_UPLOAD = HOST + "/remote/alfresco/uploadFiles";
//    private static final String URL_ALFRESCO_DOWNLOAD = HOST + "/remote/alfresco/download";
   
    @Inject
    private CrudDAO crud;
	   
    @Override
    public DocumentoAdjuntoDTO uploadFiles(DocumentoAdjuntoDTO documentoDTO, File file) {
        String URL_ALFRESCO_UPLOAD = HOST+ALFRESCO_UPLOAD;
        ListAlfrescoOutRO listAlfrescoOutRO;
        List<File> files = new ArrayList<File>();
        DocumentoAdjuntoDTO retorno = new DocumentoAdjuntoDTO();

        files.add(file);    
        LOG.info("-------->"+URL_ALFRESCO_UPLOAD);
        //valida SPACE
        String alfrescoSpace="";
        if(documentoDTO.getAplicacionSpace().equals(Constantes.APPLICACION_SPACE_REQUISITOS)){
            alfrescoSpace=ALFRESCO_SPACE_REQUISITOS;
        }else if(documentoDTO.getAplicacionSpace().equals(Constantes.APPLICACION_SPACE_OBLIGACIONES)){
            alfrescoSpace=ALFRESCO_SPACE_OBLIGACIONES;
        }else if(documentoDTO.getAplicacionSpace().equals(Constantes.APPLICACION_SPACE_GENERALES)){
            alfrescoSpace=ALFRESCO_SPACE_GENERALES;
        }
        
        listAlfrescoOutRO = AlfrescoInvoker.upload(URL_ALFRESCO_UPLOAD, ALFRESCO_USER, ALFRESCO_BASE, null, null, null, alfrescoSpace, files);

        if (listAlfrescoOutRO.getResultCode().equals(InvocationResult.SUCCESS.getCode())) {
           System.out.println("Archivos subidos exitosamente: ");

           if (listAlfrescoOutRO.getFiles() != null) {
              for (Iterator<AlfrescoOutRO> iterator = listAlfrescoOutRO.getFiles().iterator(); iterator.hasNext();) {
                 System.out.println("------------------------------------------");
                 AlfrescoOutRO a = iterator.next();
                 System.out.println("FullFilePath: " + a.getFullFilePath());
                 retorno.setRutaAlfresco(a.getFullFilePath());
                 System.out.println("------------------------------------------");
              }
           }
        } else {
           System.out.println("Error message: " + listAlfrescoOutRO.getMessage());
           System.out.println("Error errorcode: " + listAlfrescoOutRO.getErrorCode());
           System.out.println("Error resultcode: " + listAlfrescoOutRO.getResultCode());
        }
        return retorno;
    }
	   

    @Override
    public DocumentoAdjuntoDTO create(DocumentoAdjuntoDTO documentoDTO, UsuarioDTO userDTO){
        DocumentoAdjuntoDTO retorno= new DocumentoAdjuntoDTO();
        try{
            MdiDocumentoAdjunto documentoDAO= DocumentoAdjuntoBuilder.getDocumentoAdjunto(documentoDTO);
            documentoDAO.setDatosAuditoria(userDTO);
            crud.create(documentoDAO);
            retorno = DocumentoAdjuntoBuilder.toDocumentoAdjuntoDto(documentoDAO);
        }catch(Exception e){
            LOG.error("ERROR en create DAO--->"+e.getMessage());
            e.printStackTrace();
        }
        return retorno;
    }
	   
    @Override
    public DocumentoAdjuntoDTO editar(DocumentoAdjuntoDTO documentoDTO, UsuarioDTO usuarioDTO){
        DocumentoAdjuntoDTO retorno= new DocumentoAdjuntoDTO();
        try{
            MdiDocumentoAdjunto documentoUpdate;
	    documentoUpdate = crud.find(documentoDTO.getIdDocumentoAdjunto(), MdiDocumentoAdjunto.class);
//	    documentoUpdate.setTipoDocumentoCarga(new MdiMaestroColumna(documentoDTO.getTipoDocumentoCarga().getIdMaestroColumna()));
	    documentoUpdate.setTitulo(documentoDTO.getTitulo());
	    documentoUpdate.setFechaDocumento(documentoDTO.getFechaDocumento());
	    documentoUpdate.setComentario(documentoDTO.getComentario());
	    documentoUpdate.setDatosAuditoria(usuarioDTO);
	    
	    crud.update(documentoUpdate);
            retorno = DocumentoAdjuntoBuilder.toDocumentoAdjuntoDto(documentoUpdate);
        }catch(Exception e){
            LOG.error("Error editar ",e);         
        }
        return retorno;
    }

    @Override
    public DocumentoAdjuntoDTO get(Long idDocumentoAdjunto){
        MdiDocumentoAdjunto documentoAdjunto = crud.find(idDocumentoAdjunto, MdiDocumentoAdjunto.class);
        DocumentoAdjuntoDTO documentoAdjuntoDTO = DocumentoAdjuntoBuilder.toDocumentoAdjuntoDto(documentoAdjunto);
        return documentoAdjuntoDTO;
    }
   
   @Override
   public DocumentoAdjuntoDTO changeState(DocumentoAdjuntoDTO documentoAdjuntoDTO,UsuarioDTO usuarioDTO) {
        DocumentoAdjuntoDTO retorno = null;
        try{
            MdiDocumentoAdjunto registro = crud.find(documentoAdjuntoDTO.getIdDocumentoAdjunto(), MdiDocumentoAdjunto.class);
            registro.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            registro.setDatosAuditoria(usuarioDTO);
            crud.update(registro);
            retorno = DocumentoAdjuntoBuilder.toDocumentoAdjuntoDto(registro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }


@Override
public DocumentoAdjuntoDTO findDocumentoAdjunto(Long idDocumentoAdjunto) {
	DocumentoAdjuntoDTO retorno = null;
	try{
        MdiDocumentoAdjunto registroDTO = crud.find(idDocumentoAdjunto, MdiDocumentoAdjunto.class);
        retorno = DocumentoAdjuntoBuilder.toDocumentoAdjuntoDto(registroDTO);
    }catch(Exception ex){
        LOG.error("",ex);
    }
    return retorno;
}

    @Override
    public HashMap listarDocumentoAdjunto(DocumentoAdjuntoFilter filtro) {
        HashMap resultado = new HashMap();
        List<DocumentoAdjuntoDTO> retorno=null;
        try{
            Long cuenta = count(filtro);
            resultado.put("cuenta", cuenta);
            
            Query query = getFindQuery(filtro, false);
            if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
                query.setFirstResult(filtro.getStartIndex());
                query.setMaxResults(filtro.getResultsNumber());
            }
            retorno = DocumentoAdjuntoBuilder.toListDocumentoAdjuntoDto(query.getResultList());
            resultado.put("listado", retorno);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return resultado;
    }
    
    //@Override
    public Long count(DocumentoAdjuntoFilter filtro) {
        LOG.info("contador DAO IMPL");
        Query query = getFindQuery(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
    }
    
    private Query getFindQuery(DocumentoAdjuntoFilter filtro, boolean count) {
        Query query=null;
        try{
            if(count){
                if (filtro.getIdConcurso()!= null) {
                    query = crud.getEm().createNamedQuery("MdiDocumentoAdjunto.countByIdConcurso");
                }else if (filtro.getTitulo()!= null) {
                    query = crud.getEm().createNamedQuery("MdiDocumentoAdjunto.countByTitulo");
                }else {
                    query = crud.getEm().createNamedQuery("MdiDocumentoAdjunto.countAll");
                }
            }else{
                if (filtro.getIdConcurso()!= null) {
                    query = crud.getEm().createNamedQuery("MdiDocumentoAdjunto.findByIdConcurso");
                }else if (filtro.getTitulo()!= null) {
                    query = crud.getEm().createNamedQuery("MdiDocumentoAdjunto.findByTitulo");
                }else {
                    query = crud.getEm().createNamedQuery("MdiDocumentoAdjunto.findAll");
                }
            }

            if (filtro.getIdConcurso()!= null) {
                query.setParameter("idConcurso",filtro.getIdConcurso());
            }
            if (filtro.getTitulo()!= null) {
                query.setParameter("titulo",filtro.getTitulo());
            }
            if (filtro.getIdDocumentoAdjunto()!= null) {
                query.setParameter("idDocumentoAdjunto",filtro.getIdDocumentoAdjunto());
            }
            if (filtro.getEstado()!= null) {
                query.setParameter("estado",filtro.getEstado());
            }
//            if (filtro.getDescripcion()!= null) {
//                query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%");
//            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
}
