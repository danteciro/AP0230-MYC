package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghRubroOpcion;
import gob.osinergmin.myc.domain.builder.RubroOpcionBuilder;
import gob.osinergmin.myc.domain.builder.TramiteActividadBuilder;
import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.RubroOpcionFilter;
import gob.osinergmin.myc.domain.ui.TramiteActividadFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.RubroOpcionDAO;
import gob.osinergmin.myc.service.dao.TramiteActividadDAO;
import gob.osinergmin.myc.service.dao.TramiteDAO;
import gob.osinergmin.myc.service.exception.TramiteActividadException;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
/**
*
* @author jsifuentes
*/
@Service("RubroOpcionDAO")
public class RubroOpcionDAOImpl implements RubroOpcionDAO {
    private static final Logger LOG = LoggerFactory.getLogger(TramiteActividadDAO.class);
    @Inject
    private CrudDAO crud;

    
    @Override
    public RubroOpcionDTO create(RubroOpcionDTO rubroOpciondDTO, UsuarioDTO usuarioDTO)  throws TramiteActividadException{
    	RubroOpcionDTO registro = null;
    	try{
            PghRubroOpcion rubroOpcion = RubroOpcionBuilder.getRubroOpcion(rubroOpciondDTO);
            rubroOpcion.setDatosAuditoria(usuarioDTO);
            crud.create(rubroOpcion);
    		registro = RubroOpcionBuilder.toRubroOpcionDto(rubroOpcion);
    	}catch(Exception ex){
    		ex.printStackTrace();
    		LOG.error("Error create Exception ="+ ex.getMessage());
    		TramiteActividadException e2= new TramiteActividadException(TramiteActividadException.ERROR_CREAR_TRAM_ACTIVIDAD,ex,true);
    	}
    	return registro;
    }  
    
	
    @Override
	public RubroOpcionDTO changeState(RubroOpcionDTO rubroOpcionDTO, UsuarioDTO user){
    	RubroOpcionDTO registro = null;
		try{
			 LOG.info("idRubroOpcion---->"+rubroOpcionDTO.getIdRubroOpcion());
			
			PghRubroOpcion rubroOpcion=crud.find(rubroOpcionDTO.getIdRubroOpcion(), PghRubroOpcion.class);
			rubroOpcion.setDatosAuditoria(user);
			rubroOpcion.setEstado(rubroOpcionDTO.getEstado());
			
			crud.update(rubroOpcion);
			
			registro = RubroOpcionBuilder.toRubroOpcionDto(rubroOpcion);
			LOG.info("(Cambiar Estado Rubro Opcion DAO Impl) retorno: "+registro.toString());
		}catch(Exception ex){
			LOG.error("",ex);
		}
		return registro;
	}
    
    @Override
    public List<RubroOpcionDTO> find(RubroOpcionFilter filtro){
        List<RubroOpcionDTO> retorno=null;
        try{
            Query query = getFindQuery(filtro);
            if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
                query.setFirstResult(filtro.getStartIndex());
                query.setMaxResults(filtro.getResultsNumber());
            }
            retorno = RubroOpcionBuilder.toListRubroOpcionDto(query.getResultList());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
	@Override
	public Long count(RubroOpcionFilter filtro){
		 Query query = getFindQuery(filtro);
		 List<PghRubroOpcion> lstPghRubroOpcion = query.getResultList();
		 if(lstPghRubroOpcion == null || lstPghRubroOpcion.size() == 0)
			 return 0L;
		 
	     return new Long(lstPghRubroOpcion.size());
	}
	
    private Query getFindQuery(RubroOpcionFilter filtro) {
        Query query=null;
        try{
            String queryString = "";
            StringBuilder jpql = new StringBuilder();
            jpql.append("Select new PghRubroOpcion(ro.idRubroOpcion, ro.idActividad.idActividad, ro.idActividad.nombre, ro.idOpcion.idOpcion, ro.idOpcion.nombre) ");
            jpql.append( "from PghRubroOpcion ro " );
            jpql.append(" inner join ro.idActividad a  " );
            jpql.append(" inner join ro.idOpcion o  " ); 
            jpql.append( "where ro.estado='1'");
          	
            if(!StringUtil.isEmptyNum(filtro.getIdActividad())){
          	  jpql.append(" and ro.idActividad.idActividad=:idActividad");	
            }
          	
            query = crud.getEm().createQuery(jpql.toString());
          	 
            if(!StringUtil.isEmptyNum(filtro.getIdActividad())){
                query.setParameter("idActividad", filtro.getIdActividad());
            }
          }catch(Exception e){
              LOG.error("Error getFindQuery: "+e.getMessage());
          }
          
        
        return query;
    }
    
    public List<TramiteActividadDTO> valiRelacionTramiteRubro(TramiteActividadFilter filtro){
        LOG.info("metodo validaCreateProcedimiento");
        List<TramiteActividadDTO> retorno=new ArrayList<TramiteActividadDTO>();
        Query query=crud.getEm().createNamedQuery("PghCnfTramiteActividad.findByIdTramiteIdActividad");
        query.setParameter("estado",filtro.getEstado());
        query.setParameter("idTramite",filtro.getIdTramite());
        query.setParameter("idActividad",filtro.getIdActividad());
        retorno = TramiteActividadBuilder.toListTramiteActividadDto(query.getResultList());
        LOG.info("tramiActi-->"+retorno);
                    
        return retorno;
    }
}
