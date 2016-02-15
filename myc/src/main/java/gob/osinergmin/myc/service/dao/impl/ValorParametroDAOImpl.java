package gob.osinergmin.myc.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghValorParametro;
import gob.osinergmin.myc.domain.builder.ParametroDinamicoBuilder;
import gob.osinergmin.myc.domain.builder.ValorParametroBuilder;
import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ValorParametroDTO;
import gob.osinergmin.myc.domain.ui.ParametroFilter;
import gob.osinergmin.myc.domain.ui.ValorParametroFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ValorParametroDAO;
import gob.osinergmin.myc.service.exception.ValorParametroException;
import gob.osinergmin.myc.util.PropertyUtils;

@Service("ValorParametroDAO")
public class ValorParametroDAOImpl implements ValorParametroDAO {

	 private static final Logger LOG = LoggerFactory.getLogger(ValorParametroDAOImpl.class);
	 @Inject
	 private CrudDAO crud;

	    
	@Override
	public ValorParametroDTO createValor(ValorParametroDTO valorParametroDTO,
			UsuarioDTO userDTO) throws ValorParametroException  {
		ValorParametroDTO retorno =null;
		
		try{
			PghValorParametro valorParametroDAO= ValorParametroBuilder.getValorParametro(valorParametroDTO);
			valorParametroDAO.setDatosAuditoria(userDTO);
			crud.create(valorParametroDAO);
			retorno = ValorParametroBuilder.toValorParametroDTO(valorParametroDAO);
		
		}catch(Exception e){
	        LOG.error("ERROR--->"+e.getMessage());
	        LOG.error(PropertyUtils.getProperty(ValorParametroException.ERROR_CREAR_VALOR_PARAMETRO),e);
	        ValorParametroException e2 = new ValorParametroException(ValorParametroException.ERROR_CREAR_VALOR_PARAMETRO,e, true);
	        throw e2;
			
		}
		return retorno;
	}
	
	@Override
	public ValorParametroDTO editar(ValorParametroDTO parametroDTO,
			UsuarioDTO userDTO) throws ValorParametroException {
		ValorParametroDTO retorno =null;
		
		try{
			PghValorParametro parametroDAO= ValorParametroBuilder.getValorParametro(parametroDTO);
			parametroDAO.setDatosAuditoria(userDTO);
			crud.update(parametroDAO);
			retorno = ValorParametroBuilder.toValorParametroDTO(parametroDAO);
		}catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(ValorParametroException.ERROR_CREAR_VALOR_PARAMETRO),e);
            ValorParametroException e2 = new ValorParametroException(ValorParametroException.ERROR_CREAR_VALOR_PARAMETRO,e, true);
            throw e2;
			
		}
		return retorno;
	}
	
	@Override
	public ValorParametroDTO changeEstado(ValorParametroDTO parametroDTO,
			UsuarioDTO user) throws ValorParametroException {
		ValorParametroDTO retorno =null;
		
		try{
			PghValorParametro parametroDAO=crud.find(parametroDTO.getIdValorParametro(), PghValorParametro.class);
			parametroDAO.setDatosAuditoria(user);
			parametroDAO.setEstado(parametroDTO.getEstado());
			crud.update(parametroDAO); 
			retorno = ValorParametroBuilder.toValorParametroDTO(parametroDAO);
		}catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(ValorParametroException.ERROR_CREAR_VALOR_PARAMETRO),e);
            ValorParametroException e2 = new ValorParametroException(ValorParametroException.ERROR_CREAR_VALOR_PARAMETRO,e, true);
        throw e2;
			
		}
		return retorno;
	}
	

		    
    @Override
    public List<ValorParametroDTO> findValorParametro(ValorParametroFilter filtro) throws ValorParametroException {
        LOG.info("Busqueda de Valores");
        List<ValorParametroDTO> listado = null;

        Query query = getFindQueryValor(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }

        listado = ValorParametroBuilder.toListValorParametro(query.getResultList());

        return listado;
    }

	@Override
	public Long countValor(ValorParametroFilter filtro) throws ValorParametroException {
		 Query query = getFindQueryValor(filtro, true);
		 List<PghValorParametro> lstPghValorParametro = query.getResultList();
		 if(lstPghValorParametro == null || lstPghValorParametro.size() == 0)
			 return 0L;
		 
	     return new Long(lstPghValorParametro.size());
	}
	
	private Query getFindQueryValor(ValorParametroFilter filtro, boolean count) {
        Query query=null;
        try{
          
             if (filtro.getIdParametroDinamico()!= null) {
                    query = crud.getEm().createNamedQuery("PghValorParametro.findByIdParametroDinamico");          
            }

            if(filtro.getIdParametroDinamico()!=null){
            	query.setParameter("idParametroDinamico",filtro.getIdParametroDinamico());
            }
        }catch(Exception e){
            LOG.error("Error getFindQueryValor: "+e.getMessage());
        }
        
        return query;
    }
	
	 @Override
	    public List<ValorParametroDTO>obtenerDependencias(ValorParametroFilter filtro) {
			List<ValorParametroDTO> listado=null;
			Query query;
			try{
				StringBuilder jpql = new StringBuilder();
	        	//
	        	jpql.append("select new PghValorParametro(vp.idValorParametro,vp.valor,vp.descripcion)" );
	        	jpql.append(" from PghRequProcParaDina pp" );
	        	jpql.append(" left join pp.idValorParametro  vp " );
	        	if (!StringUtil.isEmptyNum(filtro.getIdValorParametro())) {
	        	jpql.append(" where   vp.idValorParametro=:idValorParametro ");
	        	}
	        	query = crud.getEm().createQuery(jpql.toString());
	        	
	        	if (!StringUtil.isEmptyNum(filtro.getIdValorParametro())) {
	                query.setParameter("idValorParametro",filtro.getIdValorParametro());
	            }
	        	
	        	listado= ValorParametroBuilder.toListValorParametro(query.getResultList());
				
			}catch(Exception e){
				LOG.error("Error getValidarDependencia : " + e.getMessage());
			}
		      
			
	    	return listado;
	    	
	    }
	 
	 @Override
	    public  List<ValorParametroDTO> verificarOtrosValoresParametros(ValorParametroFilter filtro) {
			List<ValorParametroDTO> listado=null;
			Query query;
			try{
				StringBuilder jpql = new StringBuilder();
				jpql.append("select new PghValorParametro(vp.idValorParametro,vp.valor,vp.descripcion)" );
	        	jpql.append(" from PghValorParametro vp" );
	        	jpql.append(" where vp.estado=1 ");
	        	if (!StringUtil.isEmptyNum(filtro.getIdParametroDinamico())) {
	            	jpql.append(" and    vp.idParametroDinamico.idParametroDinamico=:idParametro ");
	            	}
	        	
	        	if (!StringUtil.isEmpty(filtro.getValor())) {
	        	jpql.append(" and   upper(vp.valor)=upper(:valor) ");
	        	}
	       
	        	query = crud.getEm().createQuery(jpql.toString());
	        	if (!StringUtil.isEmptyNum(filtro.getIdParametroDinamico())) {
	                query.setParameter("idParametro",filtro.getIdParametroDinamico());
	            }
	        	if (!StringUtil.isEmpty(filtro.getValor())) {
	        		query.setParameter("valor",filtro.getValor());
	            }
	        	listado= ValorParametroBuilder.toListValorParametro(query.getResultList());
				
			}catch(Exception e){
				LOG.error("Error getVerificarOtrosParametros: " + e.getMessage());
			}
		      
			
	    	return listado;
	    	
	    }
		

}
