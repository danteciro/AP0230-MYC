/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.builder.ActividadBuilder;
import gob.osinergmin.myc.domain.builder.OpcionBuilder;
import gob.osinergmin.myc.domain.builder.ProcesoObligacionTipoBuilder;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.OpcionFilter;
import gob.osinergmin.myc.service.dao.ActividadDAO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.OpcionDAO;
import gob.osinergmin.myc.service.exception.ActividadException;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
* Resumen.
* Objeto                   : OpcionDAOImpl.java 
* Descripción              : DAOImpl para el uso del modulo de rubroOpcion.
* Fecha de Creación        : 26/05/2016
* PR de Modificacion       : OSINE_119
* Autor                    : Juan Sifuentes Acosta.
* ---------------------------------------------------------------------------------------
* Modificaciones
* Motivo       Fecha       Nombre                 Descripcion
* ----------------------------------------------------------------------------------------
 */
@Service("OpcionDAO")
public class OpcionDAOImpl implements OpcionDAO {
    private static final Logger LOG = LoggerFactory.getLogger(OpcionDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<OpcionDTO> find(OpcionFilter filtro) throws ActividadException{
        List<OpcionDTO> listado;

        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }

        listado = OpcionBuilder.toListOpcionDto(query.getResultList());

        return listado;
    }
    
    @Override
    public Long count(OpcionFilter filtro) throws ActividadException{
        Query query = getFindQuery(filtro, true);
        return (Long) query.getSingleResult();
    }
    
    private Query getFindQuery(OpcionFilter filtro, boolean count) {
        Query query=null;
        try{
            if (count) {
              query = crud.getEm().createNamedQuery("PghOpcion.countAll");
            }else {
               if (filtro.getIdRubroOpcion()!= null) {
                   query = crud.getEm().createNamedQuery("PghOpcion.findByIdRubroOpcion");
               }else if (filtro.getIdActividad()!= null) {
                   query = crud.getEm().createNamedQuery("PghOpcion.findByIdActividad");
               }else if (!StringUtil.isEmpty(filtro.getIdentificadorOpcion())) {
            	   query = crud.getEm().createNamedQuery("PghOpcion.findByIdentificadorOpcion");                 
               }else{
                   query = crud.getEm().createNamedQuery("PghOpcion.findAll");
               }
            }
            
            if (filtro.getEstado()!= null){
                query.setParameter("estado",filtro.getEstado());
            }
            if (filtro.getIdRubroOpcion()!= null){
                query.setParameter("idRubroOpcion",filtro.getIdRubroOpcion());
            }
            if (filtro.getIdActividad()!= null){
                query.setParameter("idActividad",(filtro.getIdActividad()));
            }
            if (filtro.getAplicacion()!= null){
                query.setParameter("aplicacion",StringUtil.removeBlank(filtro.getAplicacion()));
            }  
            if (!StringUtil.isEmpty(filtro.getIdentificadorOpcion())){
            	query.setParameter("identificadorOpcion",StringUtil.removeBlank(filtro.getIdentificadorOpcion()));
            }

        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }

	@Override
	public Long findIdentificadorOpcion(OpcionFilter filtro)
			throws ActividadException {
		// TODO Auto-generated method stub
		Long retorno=null;
        OpcionDTO opcion;
		Query query = getFindQuery(filtro, false);
		if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
		query.setFirstResult(filtro.getStartIndex());
		query.setMaxResults(filtro.getResultsNumber());
		}
		
		List<OpcionDTO> list=OpcionBuilder.toListOpcionDto(query.getResultList());
		if(list!=null && list.size()>0){
		retorno= list.get(0).getIdOpcion();            
		}
		return retorno;

	}
}
