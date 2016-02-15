/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghBaseLegal;
import gob.osinergmin.myc.domain.PghCnfTramiteActividad;
import gob.osinergmin.myc.domain.PghEtapa;
import gob.osinergmin.myc.domain.PghTramite;
import gob.osinergmin.myc.domain.builder.BaseLegalBuilder;
import gob.osinergmin.myc.domain.builder.EtapaBuilder;
import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.EtapaFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.EtapaDAO;
import gob.osinergmin.myc.service.exception.EtapaException;
import gob.osinergmin.myc.util.Constantes;
import java.util.HashMap;
import java.util.List;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jpiro
 */
@Service("EtapaDAO")
public class EtapaDAOImpl implements EtapaDAO{
    private static final Logger LOG = LoggerFactory.getLogger(EtapaDAOImpl.class);
    @Inject
    private CrudDAO crud;    
    
    
    @Override
    public HashMap listarEtapa(EtapaFilter filtro) throws EtapaException{
        HashMap resultado = new HashMap();
        List<EtapaDTO> retorno=null;
        try{
            Long cuenta = count(filtro);
            resultado.put("cuenta", cuenta);
            
            Query query = getFindQuery(filtro, false);
            if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
                query.setFirstResult(filtro.getStartIndex());
                query.setMaxResults(filtro.getResultsNumber());
            }
            //Query query = crud.getEm().createNamedQuery("PghEtapa.findAll");
            retorno = EtapaBuilder.toListEtapaDto(query.getResultList());
            resultado.put("listado", retorno);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return resultado;
    }
    
    //@Override
    public Long count(EtapaFilter filtro) {
        LOG.info("contador DAO IMPL");
        Query query = getFindQuery(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
    }
    
    private Query getFindQuery(EtapaFilter filtro, boolean count) {
        Query query=null;
        try{
            if(count){
                if (filtro.getIdProceso()!= null) {
                    query = crud.getEm().createNamedQuery("PghEtapa.countByIdProceso");
                }else if (filtro.getDescProceso()!= null) {
                    query = crud.getEm().createNamedQuery("PghEtapa.countByDescProceso");
                }else {
                    query = crud.getEm().createNamedQuery("PghEtapa.countAll");
                }
            }else{
                if (filtro.getIdProceso()!= null) {
                    query = crud.getEm().createNamedQuery("PghEtapa.findByIdProceso");
                }else if (filtro.getDescProceso()!= null) {
                    query = crud.getEm().createNamedQuery("PghEtapa.findByDescProceso");
                }else {
                    query = crud.getEm().createNamedQuery("PghEtapa.findAll");
                }
            }

            if (filtro.getIdProceso()!= null) {
                query.setParameter("idProceso",filtro.getIdProceso());
            }
            if (filtro.getDescProceso()!= null) {
                query.setParameter("descProceso",filtro.getDescProceso());
            }
            if (filtro.getEstado()!= null) {
                query.setParameter("estado",filtro.getEstado());
            }
            if (filtro.getDescripcion()!= null) {
                query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%");
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }

    @Override
    public EtapaDTO create(EtapaDTO etapaDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Etapa DAO Impl");
        EtapaDTO retorno = null;
        try{
            PghEtapa etapa = EtapaBuilder.getEtapa(etapaDTO);
            etapa.setDatosAuditoria(usuarioDTO);
            
            if(etapaDTO.getIdEtapa() != null){
                crud.update(etapa);
            }else{
                crud.create(etapa);
            }
            retorno = EtapaBuilder.toEtapaDto(etapa);
            LOG.info("(Registro Etapa DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public EtapaDTO changeState(EtapaDTO etapaDTO, String estado) throws EtapaException {
        LOG.info("Cambiar Estado Etapa DAO Impl");
        EtapaDTO retorno = null;
        try{
            Map<String, Object> valida= validaEliminarEtapa(etapaDTO.getIdEtapa());
            
            if(valida.get("rpta").toString().equals("0")){
                throw new EtapaException(valida.get("msje").toString(),null);
            }
            
            PghEtapa etapa = crud.find(etapaDTO.getIdEtapa(),PghEtapa.class);
            etapa.setEstado(estado);
            crud.update(etapa);
            retorno = EtapaBuilder.toEtapaDto(etapa);
        }catch (EtapaException ex) {
            LOG.error("error changeState = ",ex);
            throw ex;
        }catch(Exception ex){
            LOG.error("error changeState... ",ex);
            EtapaException e2 = new EtapaException(EtapaException.ERROR_ELIMINAR_ETAPA, ex, true);
            throw e2;
        }
        return retorno;
    }
    
    public Map<String, Object> validaEliminarEtapa(Long idEtapa){
        LOG.info("procesando validaEliminarEtapa");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            String hql,rpta="1",msje="";
            Query query=null;
            
            //verifica que la etapa no tenga un hijo-Tramite
            if(rpta.equals("1")){
                hql="SELECT t.idTramite from PghTramite t where t.estado=:estado and t.idEtapa.idEtapa=:idEtapa ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idEtapa", idEtapa);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Etapa mientras este siendo usada en Tr&aacute;mite.";
                }
            }
            //verifica que tramites de la etapa no esten relacionados en pgh_tramite_actividad
            if(rpta.equals("1")){
            hql="SELECT ta.idTramiteActivdad FROM PghCnfTramiteActividad ta left join ta.idTramite tr WHERE ta.estado=:estado and tr.idEtapa.idEtapa=:idEtapa ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idEtapa", idEtapa);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Etapa mientras este siendo usada en Tr&aacute;mite - Rubro.";
                }
            }
            retorno.put("rpta",rpta);
            retorno.put("msje",msje);
        }catch(Exception ex){
            LOG.error("Error en validaEliminarEtapa ",ex);
        }
        return retorno;
    }

	@Override
	public List<EtapaDTO> listarEtapaById(Long idProceso) {
		List<EtapaDTO> retorno=null;
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT p FROM PghEtapa p WHERE p.estado='1' and p.idProceso.idProceso='"+idProceso+"' order by p.descripcion");
        LOG.info("Query: "+jpql.toString());
        Query query = crud.getEm().createQuery(jpql.toString());
		
        List<PghEtapa> resultados = query.getResultList();
		
        if(resultados.size()>0){
        	retorno=EtapaBuilder.toListEtapaUtilDto(resultados);
        }
        return retorno;
	}
    @Override
    public List<EtapaDTO> listEtapaDetailById(Long idProceso) {
        List<EtapaDTO> retorno=null;
        
        Query query = crud.getEm().createNamedQuery("PghEtapa.findAllWithDetail");
        query.setParameter("idProceso",idProceso);
        retorno = EtapaBuilder.toListEtapaUtilDto(query.getResultList());
        
        return retorno;
    }
	
	@Override
	public List<EtapaDTO> validarEtapa(EtapaDTO etapaDTO){
		List<EtapaDTO> listado=null;
		Query query;
		try{
			StringBuilder jpql = new StringBuilder();
        	//
        	jpql.append("SELECT p FROM PghEtapa p ");
        	jpql.append(" where p.idProceso.idProceso=:idProceso");
        	jpql.append(" and  p.descripcion=:descripcion");
        	query = crud.getEm().createQuery(jpql.toString());
        	query.setParameter("idProceso",etapaDTO.getIdProceso());
        	query.setParameter("descripcion",etapaDTO.getDescripcion());
        	listado = EtapaBuilder.toListEtapaDto(query.getResultList());
        	
		}catch(Exception e){
			LOG.error("Error validarEtapa : " + e.getMessage());
		}
	      
		
    	return listado;
		
	}
	
	
}