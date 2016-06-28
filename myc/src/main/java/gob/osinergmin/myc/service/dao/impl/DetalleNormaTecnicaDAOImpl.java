package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghCnfTramiteActividad;
import gob.osinergmin.myc.domain.PghDetalleBaseLegal;
import gob.osinergmin.myc.domain.PghDetalleNormaTecnica;
import gob.osinergmin.myc.domain.PghRubroOpcion;
import gob.osinergmin.myc.domain.builder.DetalleBaseLegalBuilder;
import gob.osinergmin.myc.domain.builder.DetalleNormaTecnicaBuilder;
import gob.osinergmin.myc.domain.builder.ProcedimientoBuilder;
import gob.osinergmin.myc.domain.builder.ProcedimientoTramiteBuilder;
import gob.osinergmin.myc.domain.builder.RubroOpcionBuilder;
import gob.osinergmin.myc.domain.builder.TramiteActividadBuilder;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.DetalleBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.DetalleNormaTecnicaDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoTramiteDTO;
import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ProcTramActividadFilter;
import gob.osinergmin.myc.domain.ui.ProcedimientoFilter;
import gob.osinergmin.myc.domain.ui.RubroOpcionFilter;
import gob.osinergmin.myc.domain.ui.TramiteActividadFilter;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.DetalleNormaTecnicaDAO;
import gob.osinergmin.myc.service.dao.RequisitoDAO;
import gob.osinergmin.myc.service.dao.RubroOpcionDAO;
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
* @author jsifuentes
*/
@Service("DetalleNormaTecnicaDAO")
public class DetalleNormaTecnicaDAOImpl implements DetalleNormaTecnicaDAO {
    private static final Logger LOG = LoggerFactory.getLogger(TramiteActividadDAO.class);
    @Inject
    private CrudDAO crud;
    @Inject
    private TramiteDAO tramiteDAO;
    

    
    @Override
    public DetalleNormaTecnicaDTO create(DetalleNormaTecnicaDTO rubroOpciondDTO, UsuarioDTO usuarioDTO)  throws TramiteActividadException{
    	DetalleNormaTecnicaDTO registro = null;
    	try{
//            PghRubroOpcion rubroOpcion = RubroOpcionBuilder.getRubroOpcion(rubroOpciondDTO);
//            rubroOpcion.setDatosAuditoria(usuarioDTO);
//            crud.create(rubroOpcion);
//    		registro = RubroOpcionBuilder.toRubroOpcionDto(rubroOpcion);
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
	
    @Override
    public TramiteActividadDTO findById(TramiteActividadFilter filtro) {
    	TramiteActividadDTO retorno;

        Query query = crud.getEm().createNamedQuery("PghCnfTramiteActividad.findByIdTramiteActividad");
        query.setParameter("idTramiteActivdad",filtro.getIdTramiteActividad());
        query.setParameter("estado",filtro.getEstado());
        
        retorno = (TramiteActividadDTO) TramiteActividadBuilder.toListTramiteActividadDto(query.getResultList()).get(0);

        return retorno;
    }
    
    private Query getFindQuery(RubroOpcionFilter filtro) {
        Query query=null;
        try{
            String queryString = "";
            StringBuilder jpql = new StringBuilder();
            //
//            jpql.append("Select new PghCnfTramiteActividad(cta.idTramiteActivdad, cta.estado, cta.idActividad.idActividad,cta.idActividad.nombre, cta.idTramite.idTramite, cta.idTramite.descripcion,e.idEtapa,e.descripcion,e.idProceso.idProceso,e.idProceso.descripcion) ");
//            jpql.append( "from PghCnfTramiteActividad cta " );
//            jpql.append(" left join cta.idTramite t " );
//            jpql.append(" left join t.idEtapa e " ); 
//            jpql.append( "where cta.estado='1'");
            
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
        //busco procedimientos con el idTramite - idActividad
        Query query=crud.getEm().createNamedQuery("PghCnfTramiteActividad.findByIdTramiteIdActividad");
        query.setParameter("estado",filtro.getEstado());
        query.setParameter("idTramite",filtro.getIdTramite());
        query.setParameter("idActividad",filtro.getIdActividad());
        retorno = TramiteActividadBuilder.toListTramiteActividadDto(query.getResultList());
        LOG.info("tramiActi-->"+retorno);
                    
        return retorno;
    }

	@Override
	public List<DetalleNormaTecnicaDTO> findDetalleNormaTecnicaById(Long idDetalleBaseLegal) {
		List<DetalleNormaTecnicaDTO> retorno=null;
		LOG.info("obtener Base Legal ");
		try {
			StringBuilder jpql = new StringBuilder();
//			jpql.append("SELECT p FROM PghDetalleNormaTecnica p WHERE p.estado='1' and p.idDetalleBaseLegal.idDetalleBaseLegal='"+idDetalleBaseLegal+"'");
//			
			
			
			jpql.append("Select new PghDetalleNormaTecnica(dnt.idDetalleNormaTecnica, dnt.descripcionNormaTecnica, dnt.idTipoNormaTecnica.idMaestroColumna, dnt.idTipoNormaTecnica.descripcion, dnt.idDetalleBaseLegal.idDetalleBaseLegal ) ");
            jpql.append( "from PghDetalleNormaTecnica dnt " );
            jpql.append(" inner join dnt.idTipoNormaTecnica mc  ");
            jpql.append(" inner join dnt.idDetalleBaseLegal dbl  ");
            jpql.append(" where dnt.estado='1' and dnt.idDetalleBaseLegal='"+idDetalleBaseLegal+"'");
            jpql.append(" order by dnt.idDetalleNormaTecnica");
			
//			jpql.append("Select new PghDetalleNormaTecnica(ro.idRubroOpcion, ro.idActividad.idActividad, ro.idActividad.nombre, ro.idOpcion.idOpcion, ro.idOpcion.nombre) ");
//            jpql.append( "from PghRubroOpcion ro " );
//            jpql.append(" inner join ro.idActividad a  " );
//            jpql.append(" inner join ro.idOpcion o  " ); 
//            jpql.append( "where ro.estado='1'");

            
			
			
	        LOG.info("Query: "+jpql.toString());
	        Query query = crud.getEm().createQuery(jpql.toString());
			
			List<PghDetalleNormaTecnica> resultados = query.getResultList();
			
	        if(resultados.size()>0){
	        	retorno=DetalleNormaTecnicaBuilder.toListDetalleNormaTecnicaDto(resultados);
	        }
			
	    }catch(RuntimeException e) {
			LOG.error(e.getMessage(),e);   
			e.printStackTrace();
		}
		catch(Exception e) {
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
		
		return retorno;
	}
}
