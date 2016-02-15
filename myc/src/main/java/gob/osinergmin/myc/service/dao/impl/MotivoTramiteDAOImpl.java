/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.builder.MotivoTramiteBuilder;
import gob.osinergmin.myc.domain.dto.MotivoTramiteDTO;
import gob.osinergmin.myc.domain.ui.MotivoTramiteFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.MotivoTramiteDAO;
import gob.osinergmin.myc.service.dao.RequisitoDAO;
import gob.osinergmin.myc.service.exception.MotivoTramiteException;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpiro
 */
@Service("motivoTramiteDAOImpl")
public class MotivoTramiteDAOImpl implements MotivoTramiteDAO{
    private static final Logger LOG = LoggerFactory.getLogger(RequisitoDAO.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<MotivoTramiteDTO> find(MotivoTramiteFilter filtro) throws MotivoTramiteException{
        List<MotivoTramiteDTO> retorno=null;
        try{
            Query query = getFindQuery(filtro);
            retorno = MotivoTramiteBuilder.toListMotivoTramiteDto(query.getResultList());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    private Query getFindQuery(MotivoTramiteFilter filtro) {
        Query query=null;
        try{
            if (filtro.getIdTramite()!= null) {
                query = crud.getEm().createNamedQuery("PghMotivoTramite.findByIdTramite");
            }else {
                query = crud.getEm().createNamedQuery("PghMotivoTramite.findAll");
            }
            
            if (filtro.getIdTramite()!= null) {
                query.setParameter("idTramite",filtro.getIdTramite());
            }
            if (filtro.getEstado()!= null) {
                query.setParameter("estado",filtro.getEstado());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
}
