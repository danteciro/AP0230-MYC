package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghCnfTramiteActividad;
import gob.osinergmin.myc.domain.builder.ProcedimientoBuilder;
import gob.osinergmin.myc.domain.builder.ProcedimientoTramiteBuilder;
import gob.osinergmin.myc.domain.builder.TramiteActividadBuilder;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoTramiteDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ProcTramActividadFilter;
import gob.osinergmin.myc.domain.ui.ProcedimientoFilter;
import gob.osinergmin.myc.domain.ui.TramiteActividadFilter;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.RequisitoDAO;
import gob.osinergmin.myc.service.dao.TramiteActividadDAO;
import gob.osinergmin.myc.service.dao.TramiteDAO;
import gob.osinergmin.myc.service.exception.ProcTramActividadException;
import gob.osinergmin.myc.service.exception.ProcedimientoException;
import gob.osinergmin.myc.service.exception.TramiteActividadException;
import gob.osinergmin.myc.util.Constantes;

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
@Service("TramiteActividadDAO")
public class TramiteActividadDAOImpl implements TramiteActividadDAO {
    private static final Logger LOG = LoggerFactory.getLogger(TramiteActividadDAO.class);
    @Inject
    private CrudDAO crud;
    @Inject
    private TramiteDAO tramiteDAO;
    
    @Override
    public TramiteActividadDTO create(TramiteActividadDTO tramiteActividadDTO, UsuarioDTO usuarioDTO)  throws TramiteActividadException{
    	TramiteActividadDTO registro = null;
    	try{
            //verifica idTramite-idActividad tengan relacion en CnfTramiteActividad
            List<TramiteActividadDTO> valiTramActi=valiRelacionTramiteRubro(new TramiteActividadFilter(tramiteActividadDTO.getIdTramiteActivdad(),tramiteActividadDTO.getIdTramite(),tramiteActividadDTO.getActividad().getIdActividad(),tramiteActividadDTO.getEstado()));
            LOG.info("valiTramActi---->"+valiTramActi);
          
            PghCnfTramiteActividad tramiteActividad = TramiteActividadBuilder.getTramiteActividad(tramiteActividadDTO);
            tramiteActividad.setDatosAuditoria(usuarioDTO);
    		
            if(valiTramActi.isEmpty()){
                crud.create(tramiteActividad);
            }else{
                TramiteActividadDTO regValida=valiTramActi.get(0);
                LOG.info("------------------->"+regValida);
                LOG.info("------------------->"+regValida.getDescTramite());
                LOG.info("------------------->"+regValida.getActividad().getNombre());
            	throw new TramiteActividadException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Rubro ("+regValida.getActividad().getNombre()+") - Tr&aacute;mite ("+regValida.getDescTramite()+").",null);
            }
    		registro = TramiteActividadBuilder.toTramiteActividadDto(tramiteActividad);
    	}catch(TramiteActividadException ex ){
    		ex.printStackTrace();
    		LOG.error("Error create TramiteActividadException XD = "+ ex.getMessage());
    		throw ex;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		LOG.error("Error create Exception ="+ ex.getMessage());
    		TramiteActividadException e2= new TramiteActividadException(TramiteActividadException.ERROR_CREAR_TRAM_ACTIVIDAD,ex,true);
    	}
    	return registro;
    }  
    
    @Override
    public TramiteActividadDTO updateVerificado(TramiteActividadDTO tramiteActividadDTO, UsuarioDTO usuarioDTO)  throws TramiteActividadException{
    	TramiteActividadDTO registro = null;
    	try{
            //verifica idTramite-idActividad tengan relacion en CnfTramiteActividad
            List<TramiteActividadDTO> valiTramActi=valiRelacionTramiteRubro(new TramiteActividadFilter(tramiteActividadDTO.getIdTramiteActivdad(),tramiteActividadDTO.getIdTramite(),tramiteActividadDTO.getActividad().getIdActividad(),tramiteActividadDTO.getEstado()));
            LOG.info("valiTramActi---->"+valiTramActi);
          
    		PghCnfTramiteActividad tramiteActividad = TramiteActividadBuilder.getTramiteActividad(tramiteActividadDTO);
    		tramiteActividad.setDatosAuditoria(usuarioDTO);    		 		   		
    		
    		if(!valiTramActi.isEmpty() && valiTramActi.get(0).getIdTramiteActivdad()!=tramiteActividad.getIdTramiteActivdad()){
    			//throw new TramiteActividadException("Rubro no permitido en Tr&aacute;mite.",null);
                        throw new TramiteActividadException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Rubro ("+valiTramActi.get(0).getActividad().getNombre()+") - Tr&aacute;mite ("+valiTramActi.get(0).getDescTramite()+").",null);
    		}else{
            	if(tramiteActividadDTO.getIdTramiteActivdad() != null){
	    			crud.update(tramiteActividad);
	    			 registro=TramiteActividadBuilder.toTramiteActividadDto(tramiteActividad);
	    		}
            }
    		registro = TramiteActividadBuilder.toTramiteActividadDto(tramiteActividad);
    	}catch(TramiteActividadException ex ){
    		ex.printStackTrace();
    		LOG.error("Error editar TramiteActividadException XD = "+ ex.getMessage());
    		throw ex;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		LOG.error("Error editar Exception ="+ ex.getMessage());
    		TramiteActividadException e2= new TramiteActividadException(TramiteActividadException.ERROR_CREAR_TRAM_ACTIVIDAD,ex,true);
    	}
    	return registro;
    }  
	
    @Override
	public TramiteActividadDTO changeState(TramiteActividadDTO tramiteActividadDTO, UsuarioDTO user){
		TramiteActividadDTO registro = null;
		try{
			 LOG.info("idTramiteActiv---->"+tramiteActividadDTO.getIdTramiteActivdad());
			
			PghCnfTramiteActividad tramiteActividadDAO=crud.find(tramiteActividadDTO.getIdTramiteActivdad(), PghCnfTramiteActividad.class);
			tramiteActividadDAO.setDatosAuditoria(user);
			tramiteActividadDAO.setEstado(tramiteActividadDTO.getEstado());
			
			crud.update(tramiteActividadDAO);
			
			registro = TramiteActividadBuilder.toTramiteActividadDto(tramiteActividadDAO);
			LOG.info("(Cambiar Estado Tramite Actividad DAO Impl) retorno: "+registro.toString());
		}catch(Exception ex){
			LOG.error("",ex);
		}
		return registro;
	}
    
    @Override
    public List<TramiteActividadDTO> find(TramiteActividadFilter filtro){
        List<TramiteActividadDTO> retorno=null;
        try{
            Query query = getFindQuery(filtro);
            if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
                query.setFirstResult(filtro.getStartIndex());
                query.setMaxResults(filtro.getResultsNumber());
            }
            retorno = TramiteActividadBuilder.toListTramiteActividadDto(query.getResultList());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
	@Override
	public Long count(TramiteActividadFilter filtro){
		 Query query = getFindQuery(filtro);
		 List<PghCnfTramiteActividad> lstPghCnfTramiteActividad = query.getResultList();
		 if(lstPghCnfTramiteActividad == null || lstPghCnfTramiteActividad.size() == 0)
			 return 0L;
		 
	     return new Long(lstPghCnfTramiteActividad.size());
	}
	
    @Override
    public TramiteActividadDTO findById(TramiteActividadFilter filtro) {
    	TramiteActividadDTO retorno;

        Query query = crud.getEm().createNamedQuery("PghCnfTramiteActividad.findByIdTramiteActividad");
        query.setParameter("idTramiteActivdad",filtro.getIdTramiteActividad());
        query.setParameter("estado",filtro.getEstado());
        
        retorno = (TramiteActividadDTO) TramiteActividadBuilder.toListTramiteActividadDto(query.getResultList()).get(0);

        return retorno;
    }
    
    private Query getFindQuery(TramiteActividadFilter filtro) {
        Query query=null;
        try{
            String queryString = "";
            StringBuilder jpql = new StringBuilder();
            //
            jpql.append("Select new PghCnfTramiteActividad(cta.idTramiteActivdad, cta.estado, cta.idActividad.idActividad,cta.idActividad.nombre, cta.idTramite.idTramite, cta.idTramite.descripcion,e.idEtapa,e.descripcion,e.idProceso.idProceso,e.idProceso.descripcion) ");
            jpql.append( "from PghCnfTramiteActividad cta " );
            jpql.append(" left join cta.idTramite t " );
            jpql.append(" left join t.idEtapa e " ); 
            jpql.append( "where cta.estado='1'");
          	
            if(!StringUtil.isEmptyNum(filtro.getIdProceso())){
          	jpql.append( " and e.idProceso.idProceso= :idProceso ");
            }
            if(!StringUtil.isEmptyNum(filtro.getIdEtapa())){
          	jpql.append( " and e.idEtapa= :idEtapa ");
            }
            if(!StringUtil.isEmptyNum(filtro.getIdTramite())){
          	jpql.append(" and cta.idTramite=:idTramite");
            }
            if(!StringUtil.isEmptyNum(filtro.getIdActividad())){
          	jpql.append(" and cta.idActividad.idActividad=:idActividad");	
            }
          	
            query = crud.getEm().createQuery(jpql.toString());
          	 
            if(!StringUtil.isEmptyNum(filtro.getIdProceso())){
              	query.setParameter("idProceso", filtro.getIdProceso());
            }
            if(!StringUtil.isEmptyNum(filtro.getIdEtapa())){
              	query.setParameter("idEtapa", filtro.getIdEtapa());
            }
            if(!StringUtil.isEmptyNum(filtro.getIdTramite())){
              	query.setParameter("idTramite", filtro.getIdTramite());
            }              
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
        //busco procedimientos con el idTramite - idActividad
        Query query=crud.getEm().createNamedQuery("PghCnfTramiteActividad.findByIdTramiteIdActividad");
        query.setParameter("estado",filtro.getEstado());
        query.setParameter("idTramite",filtro.getIdTramite());
        query.setParameter("idActividad",filtro.getIdActividad());
        retorno = TramiteActividadBuilder.toListTramiteActividadDto(query.getResultList());
        LOG.info("tramiActi-->"+retorno);
                    
        return retorno;
    }
}
