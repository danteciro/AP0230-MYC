package gob.osinergmin.myc.service.dao.impl;

import java.util.List;

import gob.osinergmin.myc.domain.builder.ObligacionSubTipoBuilder;
import gob.osinergmin.myc.domain.builder.ObligacionTipoBuilder;
import gob.osinergmin.myc.domain.dto.ObligacionSubTipoDTO;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.ui.ObligacionSubTipoFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ObligacionSubTipoDAO;


import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("ObligacionSubTipoDAO")
public class ObligacionSubTipoDAOImpl implements  ObligacionSubTipoDAO{

    private static final Logger LOG = LoggerFactory.getLogger(ObligacionSubTipoDAOImpl.class);
    @Inject
    private CrudDAO crud;
	@Override
	public List<ObligacionSubTipoDTO> listaObligacionSubTipo(ObligacionSubTipoFilter filtro) {
		List<ObligacionSubTipoDTO> listado=null;
		Query query = crud.getEm().createNamedQuery("PghObligacionSubTipo.findByParameters");
		query.setParameter("idObligacionTipo", filtro.getIdObligacionTipo());
		query.setParameter("identificadorMuestral",filtro.getIdentificadorSeleccion());
		query.setParameter("estado", filtro.getEstado());
        listado = ObligacionSubTipoBuilder.toListObligacionSubTipoDto(query.getResultList());        
        return listado;    
	}    
    


}
