/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;
import gob.osinergmin.myc.domain.PghProceso;
import gob.osinergmin.myc.domain.builder.ProcesoBuilder;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.ui.ProcesoFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.EtapaDAO;
import gob.osinergmin.myc.service.dao.ProcesoDAO;
import gob.osinergmin.myc.service.exception.ProcesoException;

import java.util.ArrayList;
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
@Service("procesoDAO")
public class ProcesoDAOImpl implements ProcesoDAO {
    private static final Logger LOG = LoggerFactory.getLogger(EtapaDAO.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<ProcesoDTO> listarProceso(ProcesoFilter filtro) throws ProcesoException{
        List<ProcesoDTO> retorno=null;
        try{
            Query query = getFindQuery(filtro);
            retorno = ProcesoBuilder.toListProcesoDto(query.getResultList());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }   
    
    private Query getFindQuery(ProcesoFilter filtro) {
        Query query=null;
        try{
            query = crud.getEm().createNamedQuery("PghProceso.findAll");
            
            if (filtro.getEstado()!= null) {
                query.setParameter("estado",filtro.getEstado());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
    /* OSINE_SFS-1232 - REQF- - Inicio */
    public List<ProcesoDTO> listarProcesoByIdentificador(ProcesoFilter filtro) throws ProcesoException{
    	Query query=null;
        List<PghProceso> lista = new ArrayList<PghProceso>();
        List<ProcesoDTO> listaDto = new ArrayList<ProcesoDTO>();
    	
        try{
            query = crud.getEm().createNamedQuery("PghProceso.findByIdentificadorProceso");
            if (filtro.getIdentificadorProceso()!= null) {
                query.setParameter("identificadorProceso",filtro.getIdentificadorProceso());
            }
            lista = query.getResultList();
            listaDto = ProcesoBuilder.toListProcesoDto(lista);
            
        }catch(Exception e){
            LOG.error("Error listarProcesoByIdentificador: " + e.getMessage());
        }
		return listaDto;
        
    }
    /* OSINE_SFS-1232 - REQF- - Inicio */
    
}
