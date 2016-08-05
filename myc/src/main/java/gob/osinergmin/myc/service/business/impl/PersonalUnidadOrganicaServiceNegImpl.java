/**
* Resumen		
* Objeto		: PersonalUnidadOrganicaServiceNegImpl.java
* Descripción		: Implements para capa Service de PersonalUnidadOrganica.
* Fecha de Creación	: 13/06/2016
* PR de Creación	: OSINE_SFS-480
* Autor			: Julio Piro
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                          Descripción
* ---------------------------------------------------------------------------------------------------
* 
*/ 

package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.PersonalUnidadOrganicaDTO;
import gob.osinergmin.myc.domain.ui.PersonalUnidadOrganicaFilter;
import gob.osinergmin.myc.service.business.PersonalUnidadOrganicaServiceNeg;
import gob.osinergmin.myc.service.dao.PersonalUnidadOrganicaDAO;
import gob.osinergmin.myc.service.exception.PersonalUnidadOrganicaException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("personalUnidadOrganicaServiceNeg")
public class PersonalUnidadOrganicaServiceNegImpl implements PersonalUnidadOrganicaServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(PersonalUnidadOrganicaServiceNegImpl.class);
    @Inject
    PersonalUnidadOrganicaDAO personalUnidadOrganicaDAO;
    
    @Override
    public List<PersonalUnidadOrganicaDTO> findbyFilter(PersonalUnidadOrganicaFilter filtro) throws PersonalUnidadOrganicaException{
        LOG.error("findbyFilter");
        List<PersonalUnidadOrganicaDTO> retorno=new ArrayList<PersonalUnidadOrganicaDTO>();
        try{                   	
            retorno = personalUnidadOrganicaDAO.findByFilter(filtro);            
        }catch(Exception e){
            LOG.error("Error en findbyFilter",e);
        }
        return retorno;
    }
}
