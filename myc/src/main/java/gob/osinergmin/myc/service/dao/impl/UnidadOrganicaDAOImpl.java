/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;
import gob.osinergmin.myc.domain.MdiUnidadOrganica;
import gob.osinergmin.myc.domain.builder.UnidadOrganicaBuilder;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.CnfActUniOrganicaFilter;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.UnidadOrganicaDAO;
import gob.osinergmin.myc.service.exception.UnidadOrganicaException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
*
* @author mdiosesf
*/

@Service
@Transactional
public class UnidadOrganicaDAOImpl implements UnidadOrganicaDAO{	
	private static final Logger LOG = LoggerFactory.getLogger(UnidadOrganicaDAOImpl.class);
	
	@Inject
    private CrudDAO crud;	

	@Override
	public List<UnidadOrganicaDTO> findUnidadOrganica(UnidadOrganicaFilter filtro) {
		Query query=null;
		List<UnidadOrganicaDTO> listado=null;
        try{
        	if(filtro.getIdUnidadOrganicaSuperior()!=null && filtro.getDescripcion()!=null && filtro.getSigla()!=null && filtro.getCodDepSiga()!=null){
                query = crud.getEm().createNamedQuery("MdiUnidadOrganica.findByFiltroIdUnidadOrganicaSuperior");                
            } else if(filtro.getIdUnidadOrganica()!=null){
                query = crud.getEm().createNamedQuery("MdiUnidadOrganica.findByIdUnidadOrganica");
            } else if(filtro.getIdUnidadOrganicaSuperior()!=null){
                query = crud.getEm().createNamedQuery("MdiUnidadOrganica.findByIdUnidadOrganicaSuperior");
            } else if(filtro.getNivel()!=null){ 
                query = crud.getEm().createNamedQuery("MdiUnidadOrganica.findNivel");
            } else {
            	 query = crud.getEm().createNamedQuery("MdiUnidadOrganica.findAll");
            }    
            
            if(filtro.getIdUnidadOrganica()!=null){
            	query.setParameter("idUnidadOrganica",filtro.getIdUnidadOrganica());
            } if(filtro.getIdUnidadOrganicaSuperior()!=null){
            	query.setParameter("idUnidadOrganicaSuperior",filtro.getIdUnidadOrganicaSuperior());
            } if(filtro.getSigla()!=null){
            	query.setParameter("sigla",filtro.getSigla());
            } if(filtro.getCodDepSiga()!=null){
            	query.setParameter("codDepSiga",filtro.getCodDepSiga());
            } if(filtro.getNivel()!=null){ 
            	query.setParameter("nivel",filtro.getNivel()); 
            } if(filtro.getDescripcion()!=null){ 
            	query.setParameter("descripcion",filtro.getDescripcion()); 
            }                   
            listado = UnidadOrganicaBuilder.toListUnidadOrganicaDto(query.getResultList());
            return listado;
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
		return listado;		
	}

	@Override
	public UnidadOrganicaDTO create(UnidadOrganicaDTO unidadOrganicaDTO,
			UsuarioDTO usuarioDTO) throws UnidadOrganicaException {
		UnidadOrganicaDTO retorno = null;
        try{
        	MdiUnidadOrganica registro=UnidadOrganicaBuilder.toUnidadOrganicaTabla(unidadOrganicaDTO);
            registro.setDatosAuditoria(usuarioDTO);
            crud.create(registro);
            retorno = UnidadOrganicaBuilder.toUnidadOrganicaDto(registro);
        }catch(Exception ex){
            LOG.error("Error en create", ex.getMessage());
        }
        return retorno;
	}

	@Override
	public UnidadOrganicaDTO update(UnidadOrganicaDTO unidadOrganicaDTO,
			UsuarioDTO usuarioDTO) throws UnidadOrganicaException {
		UnidadOrganicaDTO retorno = null;
		try{
        	MdiUnidadOrganica registro=UnidadOrganicaBuilder.toUnidadOrganicaTabla(unidadOrganicaDTO);
            registro.setDatosAuditoria(usuarioDTO);
            crud.update(registro);
            retorno = UnidadOrganicaBuilder.toUnidadOrganicaDto(registro);
        }catch(Exception ex){
            LOG.error("Error en create", ex.getMessage());
        }
		return null;
	}
	 /* OSINE_SFS-1232 - REQF- - Inicio */
	@Override
	public List<UnidadOrganicaDTO> findUnidadOrganicaByEtapaConfiguracion(UnidadOrganicaFilter filtro) throws UnidadOrganicaException {
		Query query = null;
		StringBuilder sql = new StringBuilder();
		String queryString = new String();
		List<UnidadOrganicaDTO> lista = new ArrayList<UnidadOrganicaDTO>();
		List<MdiUnidadOrganica> listaMdiUO =  new ArrayList<MdiUnidadOrganica>();
		sql.append(" select distinct uo from MdiUnidadOrganica uo, PghCnfActUniOrganica cuo where uo.idUnidadOrganica = cuo.idUnidadOrganica.idUnidadOrganica ");
		queryString = sql.toString();
		query = crud.getEm().createQuery(queryString);
		listaMdiUO = query.getResultList();
		lista = UnidadOrganicaBuilder.toListUnidadOrganicaDto(listaMdiUO); 
		return lista;
	}

	
	public boolean estaEnLista(List<UnidadOrganicaDTO> lista, UnidadOrganicaDTO unidadOrganicaDTO){
		for (UnidadOrganicaDTO unidad : lista) {
			if(unidad.getIdUnidadOrganica()== unidadOrganicaDTO.getIdUnidadOrganica())
				return true;
		}
		return false;
	}
	
	
	@Override
	public List<UnidadOrganicaDTO> findUnidadOrganicaGerencia(UnidadOrganicaFilter filtro) throws UnidadOrganicaException {
		List<UnidadOrganicaDTO> listaUnidadesHijas = findUnidadOrganicaByEtapaConfiguracion(filtro);
	    List<UnidadOrganicaDTO> listaUnidadPadre = new ArrayList<UnidadOrganicaDTO>();
	    
	    UnidadOrganicaFilter unidadOrganicaFilter = new UnidadOrganicaFilter();
	    unidadOrganicaFilter.setIdUnidadOrganica(listaUnidadesHijas.get(0).getIdUnidadOrganicaSuperior());
	    UnidadOrganicaDTO unidadOrganicaDTOPadre = findUnidadOrganica(unidadOrganicaFilter).get(0);
	    
		if(listaUnidadesHijas.size()>0)
			listaUnidadPadre.add(unidadOrganicaDTOPadre);
		
		for (UnidadOrganicaDTO unidadOrganicaDTO : listaUnidadesHijas) {
			unidadOrganicaFilter = new UnidadOrganicaFilter();
		    unidadOrganicaFilter.setIdUnidadOrganica(unidadOrganicaDTO.getIdUnidadOrganicaSuperior());
		    unidadOrganicaDTOPadre = findUnidadOrganica(unidadOrganicaFilter).get(0);
			
			if(!estaEnLista(listaUnidadPadre, unidadOrganicaDTOPadre)){
				listaUnidadPadre.add(unidadOrganicaDTOPadre);
			}
		}
		return listaUnidadPadre;
	}

	@Override
	public List<UnidadOrganicaDTO> findUnidadesNivelTresJoinEtapaConfiguracion(
			UnidadOrganicaFilter filtro) throws UnidadOrganicaException {
		Query query = null;
		StringBuilder sql = new StringBuilder();
		String queryString = new String();
		List<UnidadOrganicaDTO> lista = new ArrayList<UnidadOrganicaDTO>();
		List<MdiUnidadOrganica> listaMdiUO =  new ArrayList<MdiUnidadOrganica>();
		sql.append(" select distinct uo from MdiUnidadOrganica uo, PghCnfActUniOrganica cuo where uo.idUnidadOrganica = cuo.idUnidadOrganica.idUnidadOrganica ");
		if(filtro.getIdUnidadOrganica()!=null){
			sql.append(" and uo.idUnidadOrganicaSuperior = " + filtro.getIdUnidadOrganica()); 
		}
		queryString = sql.toString();
		query = crud.getEm().createQuery(queryString);
		listaMdiUO = query.getResultList();
		lista = UnidadOrganicaBuilder.toListUnidadOrganicaDto(listaMdiUO); 
		return lista;
	}

	@Override
	public List<UnidadOrganicaDTO> findUnidadUnidadOrganicaDTOByIdCnfActUniOrganicaDTO(
			CnfActUniOrganicaFilter cnfActUniOrganicaFilter)
			throws UnidadOrganicaException {
		Query query = null;
		StringBuilder sql = new StringBuilder();
		String queryString = new String();
		List<UnidadOrganicaDTO> lista = new ArrayList<UnidadOrganicaDTO>();
		List<MdiUnidadOrganica> listaMdiUO =  new ArrayList<MdiUnidadOrganica>();
		sql.append(" select distinct uo from MdiUnidadOrganica uo, PghCnfActUniOrganica cuo where uo.idUnidadOrganica = cuo.idUnidadOrganica.idUnidadOrganica ");
		if(cnfActUniOrganicaFilter.getIdCnfActUniOrganicaFilter()!=null){
			sql.append(" and cuo.idCnfActUniOrganica = " + cnfActUniOrganicaFilter.getIdCnfActUniOrganicaFilter()); 
		}
		queryString = sql.toString();
		query = crud.getEm().createQuery(queryString);
		listaMdiUO = query.getResultList();
		lista = UnidadOrganicaBuilder.toListUnidadOrganicaDto(listaMdiUO); 
		return lista;
	}
	
	
	
	/* OSINE_SFS-1232 - REQF- - Fin */
	
	
	
	
	
}