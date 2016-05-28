/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.PghCnfTramiteActividad;
import gob.osinergmin.myc.domain.PghProcedimientoTramite;
import gob.osinergmin.myc.domain.PghTramite;
import gob.osinergmin.myc.domain.builder.TramiteBuilder;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.TramiteDAO;
import gob.osinergmin.myc.service.exception.TramiteException;
import gob.osinergmin.myc.util.Constantes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpiro
 */
@Service("TramiteDAO")
public class TramiteDAOImpl implements TramiteDAO {
    private static final Logger LOG = LoggerFactory.getLogger(TramiteDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<TramiteDTO> find(TramiteFilter filtro) throws TramiteException{
        List<TramiteDTO> retorno=null;
        try{
            Query query = getFindQuery(filtro);
            retorno = TramiteBuilder.toListTramiteDto(query.getResultList());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    private Query getFindQuery(TramiteFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdEtapa()!= null && filtro.getDescripcion()!=null && filtro.getEstado()!=null){
                query = crud.getEm().createNamedQuery("PghTramite.findByIdEtapaAndDescripcion");
            }else if (filtro.getIdEtapa()!= null) {
                query = crud.getEm().createNamedQuery("PghTramite.findByIdEtapa");
            }else if(filtro.getIdProcedimiento()!=null){
                query = crud.getEm().createNamedQuery("PghTramite.findByIdProcedimiento");
            }else if(filtro.getIdTramiteActividad()!=null){
            	query = crud.getEm().createNamedQuery("PghTramite.findByIdTramiteActividad");
            }else {
                query = crud.getEm().createNamedQuery("PghTramite.findAll");
            }
            
            if (filtro.getIdEtapa()!= null) {
                query.setParameter("idEtapa",filtro.getIdEtapa());
            }
            if (filtro.getEstado()!= null) {
                query.setParameter("estado",filtro.getEstado());
            }
            if (filtro.getIdProcedimiento()!= null) {
                query.setParameter("idProcedimiento",filtro.getIdProcedimiento());
            }
            if (filtro.getIdTramiteActividad()!= null) {
                query.setParameter("idTramiteActivdad",filtro.getIdTramiteActividad());
            }
            if (filtro.getIdEtapa()!= null && filtro.getDescripcion()!=null && filtro.getEstado()!=null) {
                query.setParameter("descripcion",filtro.getDescripcion().toUpperCase());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }

    @Override
    public TramiteDTO create(TramiteDTO tramiteDTO, UsuarioDTO usuarioDTO) throws TramiteException {
        LOG.info("Registro Tramite DAO Impl");
        TramiteDTO retorno = null;
        try{
            PghTramite tramite = TramiteBuilder.getTramite(tramiteDTO);
            tramite.setDatosAuditoria(usuarioDTO);
            
            List<TramiteDTO> listaValida=find(new TramiteFilter(tramiteDTO.getIdEtapa(),tramiteDTO.getDescripcion(),Constantes.CONSTANTE_ESTADO_ACTIVO));
            
            if(tramiteDTO.getIdTramite() != null){
                crud.update(tramite);
            }else{
                if(!listaValida.isEmpty()){
                    //throw new TramiteException("El Tr&aacute;mite ya existe en la Etapa especificada.",null);
                    throw new TramiteException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Tr&aacute;mite, en Etapa especificada.",null);
                }
                crud.create(tramite);
            }
            retorno = TramiteBuilder.toTramiteDto(tramite);
            LOG.info("(Registro Tramite DAO Impl) retorno: "+retorno.toString());
        }catch (TramiteException ex) {
            LOG.error("error create TramiteDAO = "+ex.getMessage());
            throw ex;
        }catch(Exception ex){
            LOG.error("error create TramiteDAO ==  "+ex.getMessage());
            TramiteException e2 = new TramiteException(TramiteException.ERROR_CREAR_TRAMITE, ex, true);
        }
        return retorno;
    }

    @Override
    public TramiteDTO changeState(TramiteDTO tramiteDTO, String estado) throws TramiteException {
        LOG.info("Cambiar Estado Tramite DAO Impl");
        TramiteDTO retorno = null;
        try{
            Map<String, Object> valida= validaEliminarTramite(tramiteDTO.getIdTramite());
            
            if(valida.get("rpta").toString().equals("0")){
                throw new TramiteException(valida.get("msje").toString(),null);
            }
            
            PghTramite tramite = crud.find(tramiteDTO.getIdTramite(),PghTramite.class);
            tramite.setEstado(estado);
            crud.update(tramite);
            retorno = TramiteBuilder.toTramiteDto(tramite);
        }catch (TramiteException ex) {
            LOG.error("error changeState = ",ex);
            throw ex;
        }catch(Exception ex){
            LOG.error("error changeState... ",ex);
            TramiteException e2 = new TramiteException(TramiteException.ERROR_ELIMINAR_TRAMITE, ex, true);
            throw e2;
        }
        return retorno;
    }
    
    public Map<String, Object> validaEliminarTramite(Long idTramite){
        LOG.info("procesando validaEliminarEtapa");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            String hql,rpta="1",msje="";
            Query  query=null;
            //verifica que tramite no esten relacionados en pgh_tramite_actividad
            if(rpta.equals("1")){
                hql="SELECT ta.idTramiteActivdad FROM PghCnfTramiteActividad ta WHERE ta.estado=:estado and ta.idTramite.idTramite=:idTramite ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idTramite", idTramite);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Tr&aacute;mite mientras este siendo usado en Tr&aacute;mite - Rubro.";
                }
            }
            // verifica q tramite no este realcionado en pghProcedimientoTramite
            if(rpta.equals("1")){
                hql="SELECT pt.idProcedimientoTramite FROM PghProcedimientoTramite pt WHERE pt.estado=:estado and pt.idTramite.idTramite=:idTramite ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idTramite", idTramite);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Tr&aacute;mite mientras este siendo usado en Procedimiento - Tr&aacute;mite.";
                }
            }
            if(rpta.equals("1")){
                hql="SELECT mt.idMotivoTramite FROM PghMotivoTramite mt WHERE mt.estado=:estado and mt.idTramite.idTramite=:idTramite ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idTramite", idTramite);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Tr&aacute;mite mientras este siendo usado en Motivo - Tr&aacute;mite.";
                }
            }
            if(rpta.equals("1")){
                hql="SELECT t from PghCnfRequProcedimiento t where t.estado=:estado and t.idTramite.idTramite=:idTramite ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idTramite", idTramite);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Tr&aacute;mite mientras este siendo usado en Configuracion de Requisito Procedimiento.";
                }
            }
            
            retorno.put("rpta",rpta);
            retorno.put("msje",msje);
        }catch(Exception ex){
            LOG.error("Error en validaEliminarEtapa ",ex);
        }
        return retorno;
    }
}