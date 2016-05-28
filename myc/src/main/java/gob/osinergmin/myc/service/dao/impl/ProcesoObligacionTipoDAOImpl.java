package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghProcesoObligacionTipo;
import gob.osinergmin.myc.domain.builder.ProcesoObligacionTipoBuilder;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ProcesoObligacionTipoFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ProcesoObligacionTipoDAO;
import gob.osinergmin.myc.service.exception.ProcesoObligacionTipoException;
import gob.osinergmin.myc.util.Constantes;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("ProcesoObligacionTipoDAO")
public class ProcesoObligacionTipoDAOImpl implements ProcesoObligacionTipoDAO{

	private static final Logger LOG = LoggerFactory.getLogger(ProcesoObligacionTipoDAOImpl.class);
    @Inject
    private CrudDAO crud;    
    
    @Override
    public List<ProcesoObligacionTipoDTO> obtenerProcesoObligacionTipo(ProcesoObligacionTipoFilter filtro) {
        List<ProcesoObligacionTipoDTO> listado=null;

        Query query = getFindQuery(filtro);
        
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }

        listado = ProcesoObligacionTipoBuilder.toListProcesoObligacionTipoDto(query.getResultList());

        return listado;
    }
    
	@Override
	public Long count(ProcesoObligacionTipoFilter filtro){
		 Query query = getFindQuery(filtro);
		 List<PghProcesoObligacionTipo> lstProcesoObligacionTipo= query.getResultList();
		 if(lstProcesoObligacionTipo == null || lstProcesoObligacionTipo.size() == 0)
			 return 0L;
		 
	     return new Long(lstProcesoObligacionTipo.size());
	}
	
	 private Query getFindQuery(ProcesoObligacionTipoFilter filtro) {
   	  Query query=null;
         try{
        	 
        	 String queryString = "";
           	StringBuilder jpql = new StringBuilder();
           	//
           	jpql.append("Select new PghProcesoObligacionTipo(pot.pghProcesoObligacionTipoPK.idProOblTip, pot.mdiActividad.idActividad,pot.mdiActividad.nombre, pot.pghObligacionTipo.idObligacionTipo, pot.pghObligacionTipo.nombre,pot.pghProceso.idProceso,pot.pghProceso.descripcion) ");
           	jpql.append( "from PghProcesoObligacionTipo pot " );
           	jpql.append( "where pot.estado='1'");
           	
           	if(!StringUtil.isEmptyNum(filtro.getIdActividad())){
           	jpql.append( " and pot.mdiActividad.idActividad=:idActividad");
           	}
           	if(!StringUtil.isEmptyNum(filtro.getIdObligacionTipo())){
           	jpql.append(" and pot.pghObligacionTipo.idObligacionTipo=:idObligacionTipo");	
           	}
           	if(!StringUtil.isEmptyNum(filtro.getIdProceso())){
           	jpql.append(" and pot.pghProceso.idProceso=:idProceso");	
           	}
                //order by 
                jpql.append(" order by pot.pghProceso.descripcion ");	
            query = crud.getEm().createQuery(jpql.toString());
          	 
             
            if(!StringUtil.isEmptyNum(filtro.getIdActividad())){
            query.setParameter("idActividad", filtro.getIdActividad());
            }
            if(!StringUtil.isEmptyNum(filtro.getIdObligacionTipo())){
            query.setParameter("idObligacionTipo", filtro.getIdObligacionTipo());	
            }
            if(!StringUtil.isEmptyNum(filtro.getIdProceso())){
            query.setParameter("idProceso", filtro.getIdProceso());	
            }
             
         }catch(Exception ex){
        	  LOG.error("Error getFindQuery: "+ex.getMessage());
         }
		return query;
         }
	 
	 
    @Override
    public ProcesoObligacionTipoDTO create(ProcesoObligacionTipoDTO procesoObligacionTipoDTO, UsuarioDTO usuarioDTO) throws ProcesoObligacionTipoException{
         ProcesoObligacionTipoDTO registro = null;
        try{
            ProcesoObligacionTipoDTO valida=buscarProcObligTipoByIdFK(procesoObligacionTipoDTO);
            LOG.info("--------->valida="+valida);
            
            PghProcesoObligacionTipo procesoObligacion;
            LOG.info("procesoObligacionTipoDTO.getIdProOblTip()----->"+procesoObligacionTipoDTO.getIdProOblTip());
            if(procesoObligacionTipoDTO.getIdProOblTip()!=null){
                if(valida.getIdProOblTip()!=null && !valida.getIdProOblTip().equals(procesoObligacionTipoDTO.getIdProOblTip())){
                    throw new ProcesoObligacionTipoException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Proceso - Obligaci&oacute;n Tipo.",null);
                }
                procesoObligacion=ProcesoObligacionTipoBuilder.getProcesoObligacionTipo(procesoObligacionTipoDTO);
                procesoObligacion.setDatosAuditoria(usuarioDTO);
                crud.update(procesoObligacion);
            }else{
                if(valida.getIdProOblTip()!=null){
                    throw new ProcesoObligacionTipoException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Proceso - Obligaci&oacute;n Tipo.",null);
                }
                Long id = crud.findSequence("PGH_PROCESO_OBLIG_TIPO_SEQ");
                procesoObligacionTipoDTO.setIdProOblTip(id);
                procesoObligacion=ProcesoObligacionTipoBuilder.getProcesoObligacionTipo(procesoObligacionTipoDTO);
                procesoObligacion.setDatosAuditoria(usuarioDTO);
                crud.create(procesoObligacion);
            }
            registro = ProcesoObligacionTipoBuilder.toProcesoObligacionTipoDto(procesoObligacion);
        }catch (ProcesoObligacionTipoException ex) {
            LOG.error("error create = ",ex);
            throw ex;
        }catch(Exception ex){
            LOG.error("error create... ",ex);
            ProcesoObligacionTipoException e2 = new ProcesoObligacionTipoException(ProcesoObligacionTipoException.ERROR_CREAR_PROC_OBLI_ACTIVIDAD, ex, true);
            throw e2;
        }
        return registro;
    }  
	
    public ProcesoObligacionTipoDTO buscarProcObligTipoByIdFK(ProcesoObligacionTipoDTO procesoObligacionTipoDTO){
        List<ProcesoObligacionTipoDTO> lista=null;
        ProcesoObligacionTipoDTO retorno= new ProcesoObligacionTipoDTO();
        
        Query query = crud.getEm().createNamedQuery("PghProcesoObligacionTipo.findByIdFK");
        query.setParameter("idObligacionTipo",procesoObligacionTipoDTO.getIdObligacionTipo());
        query.setParameter("idProceso",procesoObligacionTipoDTO.getIdProceso());
        query.setParameter("idActividad",procesoObligacionTipoDTO.getActividad().getIdActividad());           
                
        lista = ProcesoObligacionTipoBuilder.toListProcesoObligacionTipoDto(query.getResultList());
        if(!lista.isEmpty()){
            retorno=lista.get(0);
        }
        
        return retorno;
    }
	 
    @Override
    public ProcesoObligacionTipoDTO changeState(ProcesoObligacionTipoDTO procesoObligacionDTO, UsuarioDTO user) throws ProcesoObligacionTipoException{
        ProcesoObligacionTipoDTO registro = null;
        try{
            Map<String, Object> valida= validaEliminarProcesoObligacionTipo(procesoObligacionDTO.getIdProOblTip());
            
            if(valida.get("rpta").toString().equals("0")){
                throw new ProcesoObligacionTipoException(valida.get("msje").toString(),null);
            }
            
            String queryUpdate = "update PghProcesoObligacionTipo pot set "
                    + "pot.estado = '0' "
                    + "where pot.pghProcesoObligacionTipoPK.idProOblTip = "+procesoObligacionDTO.getIdProOblTip();
	    crud.getEm().createQuery(queryUpdate).executeUpdate();
            registro=procesoObligacionDTO;
        }catch (ProcesoObligacionTipoException ex) {
            LOG.error("error changeState = ",ex);
            throw ex;
        }catch(Exception ex){
            LOG.error("error changeState... ",ex);
            ProcesoObligacionTipoException e2 = new ProcesoObligacionTipoException(ProcesoObligacionTipoException.ERROR_ELIMINAR_PROC_OBLI_ACTIVIDAD, ex, true);
            throw e2;
        }
        return registro;
     }
    
    public Map<String, Object> validaEliminarProcesoObligacionTipo(Long idProOblTip){
        LOG.info("procesando validaEliminarProcesoObligacionTipo");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            String hql,rpta="1",msje="";
            Query query=null;
            
            //verifica que la etapa no tenga un hijo-Tramite
            if(rpta.equals("1")){
                hql="SELECT t from PghConfObligacion t where t.estado=:estado and t.pghProcesoObligacionTipo.pghProcesoObligacionTipoPK.idProOblTip=:idProOblTip ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idProOblTip", idProOblTip);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Proceso - Obligaci&oacute;n Tipo mientras este siendo usada en Config Obligaci&oacute;n.";
                }
            }
            retorno.put("rpta",rpta);
            retorno.put("msje",msje);
        }catch(Exception ex){
            LOG.error("Error en validaEliminarProcesoObligacionTipo ",ex);
        }
        return retorno;
    }
    
    @Override
    public ProcesoObligacionTipoDTO edit(ProcesoObligacionTipoDTO procesoObligacionDTO, UsuarioDTO user) throws ProcesoObligacionTipoException{
        LOG.info("---->edit ProcesoObligacionTipoDTO");
        ProcesoObligacionTipoDTO registro = null;
        try{
            ProcesoObligacionTipoDTO valida=buscarProcObligTipoByIdFK(procesoObligacionDTO);
            LOG.info("--------->valida="+valida);
            if(valida.getIdProOblTip()!=null && !valida.getIdProOblTip().equals(procesoObligacionDTO.getIdProOblTip())){
                throw new ProcesoObligacionTipoException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Proceso - Obligaci&oacute;n Tipo.",null);
            }
            
            String queryUpdate = "update PghProcesoObligacionTipo pot set "
                    + "pot.pghProcesoObligacionTipoPK.idObligacionTipo = "+procesoObligacionDTO.getIdObligacionTipo()+", "
                    + "pot.pghProcesoObligacionTipoPK.idProceso = "+procesoObligacionDTO.getIdProceso()+", "
                    + "pot.pghProcesoObligacionTipoPK.idActividad = "+procesoObligacionDTO.getActividad().getIdActividad()+" "
                    + "where pot.pghProcesoObligacionTipoPK.idProOblTip = "+procesoObligacionDTO.getIdProOblTip();
	    crud.getEm().createQuery(queryUpdate).executeUpdate();
            registro=procesoObligacionDTO;
            
        }catch (ProcesoObligacionTipoException ex) {
            LOG.error("error edit = ",ex);
            throw ex;
        }catch(Exception ex){
            LOG.error("error edit... ",ex);
            ProcesoObligacionTipoException e2 = new ProcesoObligacionTipoException(ProcesoObligacionTipoException.ERROR_EDITAR_PROC_OBLI_ACTIVIDAD, ex, true);
            throw e2;
        }
         return registro;
    }
	 
}
