package gob.osinergmin.myc.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.myc.domain.PghUnidObliSubTipo;
import gob.osinergmin.myc.domain.builder.ObligacionSubTipoBuilder;
import gob.osinergmin.myc.domain.builder.UnidadObligacionSubTipoBuilder;
import gob.osinergmin.myc.domain.dto.ObligacionSubTipoDTO;
import gob.osinergmin.myc.domain.dto.UnidadObliSubTipoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.UnidadObliSubTipoDAO;

@Service("unidadObliSubTipoDAO")
public class UnidadObliSubTipoDAOImpl implements UnidadObliSubTipoDAO{
	private static final Logger LOG = LoggerFactory.getLogger(UnidadObliSubTipoDAOImpl.class);
	
	@Inject
    private CrudDAO crud;	
	@Override
	public UnidadObliSubTipoDTO guardarUnidadMuestral(UnidadObliSubTipoDTO unidadObliSubTipo,UsuarioDTO usuarioDTO) {
		UnidadObliSubTipoDTO retorno = null;
        try{
            PghUnidObliSubTipo registroDAO = UnidadObligacionSubTipoBuilder.getObligacionSubTipo(unidadObliSubTipo);
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.create(registroDAO);
            
            retorno=UnidadObligacionSubTipoBuilder.toObligacionSubTipoDto(registroDAO);
        }catch(Exception e){
            e.printStackTrace();
        }
        return retorno;
	}
	
	@Override
	public List<UnidadObliSubTipoDTO> listarPruebaMuestralxPeriodoxSubTipo(UnidadObliSubTipoDTO filtroPruebaMuestral) {
		List<UnidadObliSubTipoDTO> listado=null;
		Query query = crud.getEm().createNamedQuery("PghUnidObliSubTipo.findByPeriodoBySubTipo");
		if(filtroPruebaMuestral.getIdObligacionSubTipoF()!=null){
			query.setParameter("idObligacionSubTipo", filtroPruebaMuestral.getIdObligacionSubTipoF());
		}
		if(filtroPruebaMuestral.getPeriodo()!=null){
			query.setParameter("periodo",filtroPruebaMuestral.getPeriodo());
		}
		if(filtroPruebaMuestral.getEstado()!=null){
			query.setParameter("estado", filtroPruebaMuestral.getEstado());
		}		
        listado = UnidadObligacionSubTipoBuilder.toListUnidadObligacionSubTipoDto(query.getResultList());        
        return listado;  
	}

}
