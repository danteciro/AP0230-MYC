package gob.osinergmin.myc.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghParametroDinamico;
import gob.osinergmin.myc.domain.PghValorParametro;
import gob.osinergmin.myc.domain.builder.ParametroDinamicoBuilder;
import gob.osinergmin.myc.domain.builder.PghCnfRequProcedimientoBuilder;
import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import gob.osinergmin.myc.domain.dto.RequProcParaDinaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ParametroFilter;
import gob.osinergmin.myc.domain.ui.RequisitoFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ParametroDinamicoDAO;
import gob.osinergmin.myc.service.exception.ParametroException;
import gob.osinergmin.myc.util.PropertyUtils;


/**
*
* @author jpiro
*/

@Service("ParametroDinamicoDAO")

public class ParametroDinamicoDAOImpl  implements ParametroDinamicoDAO{

    private static final Logger LOG = LoggerFactory.getLogger(ParametroDinamicoDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    	@Override
	public ParametroDinamicoDTO create(ParametroDinamicoDTO parametroDTO,
			UsuarioDTO userDTO) throws ParametroException {
		ParametroDinamicoDTO retorno =null;
		
		try{
			PghParametroDinamico parametroDAO= ParametroDinamicoBuilder.getParametrodinamico(parametroDTO);
			parametroDAO.setDatosAuditoria(userDTO);
			crud.create(parametroDAO);
			retorno = ParametroDinamicoBuilder.toParametroDinamicoDTO(parametroDAO);
		}catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(ParametroException.ERROR_CREAR_PARAMETRO),e);
            ParametroException e2 = new ParametroException(ParametroException.ERROR_CREAR_PARAMETRO,e, true);
            throw e2;
			
		}
		return retorno;
	}

	@Override
	public List<ParametroDinamicoDTO> find(ParametroFilter filtro)
			throws ParametroException {
        List<ParametroDinamicoDTO> listado = null;

        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }

        listado = ParametroDinamicoBuilder.toListParametroDinamicoDTO(query.getResultList());

        return listado;
	}

	@Override
	public Long count(ParametroFilter filtro) throws ParametroException {
		 Query query = getFindQuery(filtro, true);
		 List<PghParametroDinamico> lstParametro = query.getResultList();
		 if(lstParametro == null || lstParametro.size() == 0)
			 return 0L;
		 
	     return new Long(lstParametro.size());
	}
	
	private Query getFindQuery(ParametroFilter filtro, boolean count) {
        Query query=null;
        try{
        	String queryString = "";
        	StringBuilder jpql = new StringBuilder();
        	//
        	jpql.append("Select new PghParametroDinamico(d.idParametroDinamico,d.nombre,d.descripcion,d.comentario ,d.idAmbitoParametrico.idMaestroColumna ,d.idAmbitoParametrico.descripcion,mc.idMaestroColumna,mc.descripcion,d.pregunta) ");
        	jpql.append( "from PghParametroDinamico d " );
            jpql.append(" left join d.idTipoConsulta  mc " );
        	jpql.append( "where d.estado='1'");
        	
        	if(!StringUtil.isEmpty(filtro.getNombre())){
        	jpql.append( " and upper(d.nombre) like :nombre ");
        	}
        	if(!StringUtil.isEmptyNum(filtro.getIdAmbitoParametrico())){
        	jpql.append(" and d.idAmbitoParametrico.idMaestroColumna=:idAmbitoParametrico");
        	}
        	if(!StringUtil.isEmptyNum(filtro.getIdParametro())){
        	jpql.append(" and d.idParametroDinamico=:idParametroDinamico");	
        	}
        	
        	 query = crud.getEm().createQuery(jpql.toString());
        	 
        	 if(!StringUtil.isEmptyNum(filtro.getIdParametro())){
                query.setParameter("idParametroDinamico",filtro.getIdParametro());
            }
            if(!StringUtil.isEmpty(filtro.getNombre())){
                query.setParameter("nombre","%"+StringUtil.removeBlank(filtro.getNombre().toUpperCase())+"%");
            }
            if(!StringUtil.isEmptyNum(filtro.getIdAmbitoParametrico())){
            	query.setParameter("idAmbitoParametrico", filtro.getIdAmbitoParametrico());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }

	@Override
	public ParametroDinamicoDTO changeEstado(ParametroDinamicoDTO parametroDTO,
			UsuarioDTO user) throws ParametroException {
		ParametroDinamicoDTO retorno =null;
		
		try{
			PghParametroDinamico parametroDAO=crud.find(parametroDTO.getIdParametroDinamico(), PghParametroDinamico.class);
			parametroDAO.setDatosAuditoria(user);
			parametroDAO.setEstado(parametroDTO.getEstado());
			crud.update(parametroDAO);
			retorno = ParametroDinamicoBuilder.toParametroDinamicoDTO(parametroDAO);
		}catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(ParametroException.ERROR_CREAR_PARAMETRO),e);
            ParametroException e2 = new ParametroException(ParametroException.ERROR_CREAR_PARAMETRO,e, true);
            throw e2;
			
		}
		return retorno;
	}
	
	@Override
	public ParametroDinamicoDTO editar(ParametroDinamicoDTO parametroDTO,
			UsuarioDTO userDTO) throws ParametroException {
		ParametroDinamicoDTO retorno =null;
		
		try{
			PghParametroDinamico parametroDAO= ParametroDinamicoBuilder.getParametrodinamico(parametroDTO);
			parametroDAO.setDatosAuditoria(userDTO);
			crud.update(parametroDAO);
			retorno = ParametroDinamicoBuilder.toParametroDinamicoDTO(parametroDAO);
		}catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(ParametroException.ERROR_CREAR_PARAMETRO),e);
            ParametroException e2 = new ParametroException(ParametroException.ERROR_CREAR_PARAMETRO,e, true);
            throw e2;
			
		}
		return retorno;
	}
	
    @Override
    public List<ParametroDinamicoDTO>obtenerDependencias(ParametroFilter filtro) {
		List<ParametroDinamicoDTO> listado=null;
		Query query;
		try{
			StringBuilder jpql = new StringBuilder();
        	//
        	jpql.append("select new PghParametroDinamico(pd.idParametroDinamico,pd.nombre,pd.descripcion)" );
        	jpql.append(" from PghRequProcParaDina pp" );
        	jpql.append(" left join pp.idValorParametro  vp " );
        	jpql.append(" left join vp.idParametroDinamico pd");
        	if (!StringUtil.isEmptyNum(filtro.getIdParametro())) {
        	jpql.append(" where   pd.idParametroDinamico=:idParametro ");
        	jpql.append(" and pd.estado=1 and vp.estado=1 ");
        	}
        	query = crud.getEm().createQuery(jpql.toString());
        	
        	if (!StringUtil.isEmptyNum(filtro.getIdParametro())) {
                query.setParameter("idParametro",filtro.getIdParametro());
            }
        	
        	listado= ParametroDinamicoBuilder.toListParametroDinamicoDTO(query.getResultList());
			
		}catch(Exception e){
			LOG.error("Error getValidarDependencia : " + e.getMessage());
		}
	      
		
    	return listado;
    	
    }
	
    @Override
    public List<ParametroDinamicoDTO>obtenerDependenciasValores(ParametroFilter filtro) {
		List<ParametroDinamicoDTO> listado=null;
		Query query;
		try{
			StringBuilder jpql = new StringBuilder();
        	jpql.append("select new PghParametroDinamico(pd.idParametroDinamico,pd.nombre,pd.descripcion)" ); 
        	jpql.append(" from PghValorParametro vp" );
        	jpql.append(" left join vp.idParametroDinamico pd");
        	if (!StringUtil.isEmptyNum(filtro.getIdParametro())) {
        	jpql.append(" where   pd.idParametroDinamico=:idParametro ");
        	jpql.append(" and pd.estado=1 and vp.estado=1 ");
        	}
        	query = crud.getEm().createQuery(jpql.toString());
        	
        	if (!StringUtil.isEmptyNum(filtro.getIdParametro())) {
                query.setParameter("idParametro",filtro.getIdParametro());
            }
        	
        	listado= ParametroDinamicoBuilder.toListParametroDinamicoDTO(query.getResultList());
			
		}catch(Exception e){
			LOG.error("Error getValidarDependenciaValores : " + e.getMessage());
		}
	      
		
    	return listado;
    	
    }
	
    @Override
    public  List<ParametroDinamicoDTO>verificarOtrosParametros(ParametroFilter filtro) {
		List<ParametroDinamicoDTO> listado=null;
		Query query;
		try{
			StringBuilder jpql = new StringBuilder();
        	jpql.append("select new PghParametroDinamico(pd.idParametroDinamico,pd.nombre,pd.descripcion)" ); 
        	jpql.append(" from PghParametroDinamico pd" );
        	jpql.append(" where pd.estado=1 ");
        	/*if (!StringUtil.isEmptyNum(filtro.getIdAmbitoParametrico())) {
        	jpql.append(" and   pd.idAmbitoParametrico.idMaestroColumna=:idAmbitoParametrico ");
        	}*/
        	if (!StringUtil.isEmpty(filtro.getNombre())) {
        	jpql.append(" and   pd.nombre=:nombre ");
        	}
       
        	query = crud.getEm().createQuery(jpql.toString());
        	
        	/*if (!StringUtil.isEmptyNum(filtro.getIdAmbitoParametrico())) {
                query.setParameter("idAmbitoParametrico",filtro.getIdAmbitoParametrico());
            }*/
        	if (!StringUtil.isEmpty(filtro.getNombre())) {
        		query.setParameter("nombre",filtro.getNombre().trim());
            }
        	listado= ParametroDinamicoBuilder.toListParametroDinamicoDTO(query.getResultList());
			
		}catch(Exception e){
			LOG.error("Error getVerificarOtrosParametros: " + e.getMessage());
		}
	      
		
    	return listado;
    	
    }
    
    @Override
	public long obtenerIdDinamico() {
		long idValor = 0;

		try{
			idValor = crud.findSequence("pgh_parametro_dinamico_seq");
		}catch(Exception excepcion){
			LOG.error("Error obtenerIdDinamico: " + excepcion.getMessage());
		}
		return idValor -1;
		
	}
}
