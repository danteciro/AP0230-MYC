/**
* Resumen		
* Objeto		: PersonalUnidadOrganicaDAOImpl.java
* Descripción		: implements de interface para capa DAO de PersonalUnidadOrganica.
* Fecha de Creación	: 13/06/2016
* PR de Creación	: OSINE_SFS-480
* Autor			: Julio Piro
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                          Descripción
* ---------------------------------------------------------------------------------------------------
* 
*/

package gob.osinergmin.myc.service.dao.impl;
import gob.osinergmin.myc.domain.builder.PersonalUnidadOrganicaBuilder;
import gob.osinergmin.myc.domain.dto.PersonalUnidadOrganicaDTO;
import gob.osinergmin.myc.domain.ui.PersonalUnidadOrganicaFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.PersonalUnidadOrganicaDAO;
import gob.osinergmin.myc.service.exception.PersonalUnidadOrganicaException;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PersonalUnidadOrganicaDAOImpl implements PersonalUnidadOrganicaDAO{	
    private static final Logger LOG = LoggerFactory.getLogger(PersonalUnidadOrganicaDAOImpl.class);
	
    @Inject
    private CrudDAO crud;	

    @Override
    public List<PersonalUnidadOrganicaDTO> findByFilter(PersonalUnidadOrganicaFilter filtro) throws PersonalUnidadOrganicaException{
        List<PersonalUnidadOrganicaDTO> retorno=null;
        try{
            Query query = getFindQuery(filtro);
            retorno = PersonalUnidadOrganicaBuilder.toListPersonalUnidadOrganicaDto(query.getResultList());
        }catch(Exception e){
            LOG.error("Error en findByFilter",e);
        }
        return retorno;
    }
        
    private Query getFindQuery(PersonalUnidadOrganicaFilter filtro) {
        Query query=null;
	try{
            if(filtro.getIdUnidadOrganica()!=null){
                query = crud.getEm().createNamedQuery("PghPersonalUnidadOrganica.findByIdUnidadOrganica");                
            }else{
            	 query = crud.getEm().createNamedQuery("PghPersonalUnidadOrganica.findAll");
            }    
            
            if(filtro.getIdUnidadOrganica()!=null){
            	query.setParameter("idUnidadOrganica",filtro.getIdUnidadOrganica());
            }                   
            
        }catch(Exception e){
            LOG.error("Error getFindQuery",e);
        }
        return query;		
    }

}