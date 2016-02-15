/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.PghAutoayuda;
import gob.osinergmin.myc.domain.builder.AutoayudaBuilder;
import gob.osinergmin.myc.domain.dto.AutoayudaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.AutoayudaFilter;
import gob.osinergmin.myc.service.dao.AutoayudaDAO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.RequisitoDAO;
import gob.osinergmin.myc.service.exception.AutoayudaException;
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
@Service("autoayudaDAO")
public class AutoayudaDAOImpl implements AutoayudaDAO {
    private static final Logger LOG = LoggerFactory.getLogger(AutoayudaDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<AutoayudaDTO> find(AutoayudaFilter filtro) throws AutoayudaException {
        List<AutoayudaDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = AutoayudaBuilder.toListAutoayudaDto(query.getResultList());

        return listado;
    }
    
    @Override
    public AutoayudaDTO update(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO) throws AutoayudaException{
        AutoayudaDTO retorno = null;
        try{
            PghAutoayuda registroDAO = AutoayudaBuilder.getAutoayuda(autoayudaDTO);
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.update(registroDAO);
            
            retorno=AutoayudaBuilder.toAutoayudaDto(registroDAO);
        }catch(Exception e){
            LOG.error("Error al editar Requisito",e);
            AutoayudaException e2 = new AutoayudaException("Error al editar Requisito",e);
            throw e2;
        }
        return retorno;
    }
    
    private Query getFindQuery(AutoayudaFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdAutoayuda()!=null){
                query = crud.getEm().createNamedQuery("PghAutoayuda.findByIdPersonal");
            }else{
                query = crud.getEm().createNamedQuery("PghAutoayuda.findByFilter");
            }
            
            if(filtro.getIdAutoayuda()==null){
                if(filtro.getNombreAutoayuda()!=null && !filtro.getNombreAutoayuda().equals("")){
                    query.setParameter("nombreAutoayuda","%"+filtro.getNombreAutoayuda().toUpperCase()+"%");
                }else{
                    query.setParameter("nombreAutoayuda","%");
                }
                if(filtro.getIdentificadorAutoayuda()!=null && !filtro.getIdentificadorAutoayuda().equals("")){
                    query.setParameter("identificadorAutoayuda","%"+filtro.getIdentificadorAutoayuda().toUpperCase()+"%");
                }else{
                    query.setParameter("identificadorAutoayuda","%");
                }
            }else{
                query.setParameter("idAutoayuda",filtro.getIdAutoayuda());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
}
