/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.MdiConcurso;
import gob.osinergmin.myc.domain.builder.ConcursoBuilder;
import gob.osinergmin.myc.domain.dto.ConcursoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConcursoFilter;
import gob.osinergmin.myc.service.dao.ConcursoDAO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.exception.ConcursoException;
import gob.osinergmin.myc.util.Constantes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author lbarboza
 */
@Service("concursoDAO")
public class ConcursoDAOImpl implements ConcursoDAO{
    private static final Logger LOG = LoggerFactory.getLogger(ConcursoDAOImpl.class);
    @Inject
    private CrudDAO crud;

    @Override
    public HashMap obtenerConcurso(ConcursoFilter filtro) {
        HashMap resultado = new HashMap();
        List<ConcursoDTO> listado = null;
        try{
            Long cuenta = count(filtro);
            resultado.put("cuenta", cuenta);
            
            Query query = getFindQuery(filtro, false);
            if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
                query.setFirstResult(filtro.getStartIndex());
                query.setMaxResults(filtro.getResultsNumber());
            }
            listado = ConcursoBuilder.toListConcursoDto(query.getResultList());
            resultado.put("listado", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return resultado;
    }
    
    //@Override
    public Long count(ConcursoFilter filtro) {
        LOG.info("contador DAO IMPL");
        Query query = getFindQuery(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
    }

    @Override
    public ConcursoDTO create(ConcursoDTO concursoDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Concurso DAO Impl");
        ConcursoDTO retorno = null;
        try{
            MdiConcurso concurso = ConcursoBuilder.getConcurso(concursoDTO);
            concurso.setDatosAuditoria(usuarioDTO);
            
            if(concursoDTO.getIdConcurso() != null){
                crud.update(concurso);
            }else{
                crud.create(concurso);
            }
            retorno = ConcursoBuilder.toConcursoDto(concurso);
            LOG.info("(Registro Concurso DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public ConcursoDTO changeState(ConcursoDTO concursoDTO, String estado) throws ConcursoException {
        LOG.info("Cambiar Estado Concurso DAO Impl");
        ConcursoDTO retorno = null;
        try{
            Map<String, Object> valida= validaEliminarConcurso(concursoDTO.getIdConcurso());
            
            if(valida.get("rpta").toString().equals("0")){
                throw new ConcursoException(valida.get("msje").toString(),null);
            }
            
            MdiConcurso registroDTO = crud.find(concursoDTO.getIdConcurso(), MdiConcurso.class);
            registroDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            crud.update(registroDTO);
            retorno = ConcursoBuilder.toConcursoDto(registroDTO);
        }catch (ConcursoException ex) {
            LOG.error("error changeState = ",ex);
            throw ex;
        }catch(Exception ex){
            LOG.error("error changeState... ",ex);
            ConcursoException e2 = new ConcursoException(ConcursoException.ERROR_ELIMINAR_CONCURSO, ex, true);
            throw e2;
        }
        return retorno;
    }
    
    public Map<String, Object> validaEliminarConcurso(Long idConcurso){
        LOG.info("procesando validaEliminarEtapa");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            String hql,rpta="1",msje="";
            Query query=null;
            
            //verifica que la etapa no tenga un hijo-Tramite
            if(rpta.equals("1")){
                hql="select t from MdiContratoEmpresaLocador t where t.estado=:estado and t.idConcurso.idConcurso=:idConcurso ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idConcurso", idConcurso);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Concurso mientras este siendo usado en Contrato Empresa Locador.";
                }
            }
            retorno.put("rpta",rpta);
            retorno.put("msje",msje);
        }catch(Exception ex){
            LOG.error("Error en validaEliminarEtapa ",ex);
        }
        return retorno;
    }
    
    private Query getFindQuery(ConcursoFilter filtro, boolean count){
        Query query = null;
        try{
            if(count){
                if(filtro.getIdConcurso() != null){
                    query = crud.getEm().createNamedQuery("MdiConcurso.countByIdConcurso");
                }else{
                    query = crud.getEm().createNamedQuery("MdiConcurso.countByFilter");
                }
            }else{
                if(filtro.getIdConcurso() != null){
                    query = crud.getEm().createNamedQuery("MdiConcurso.findByIdConcurso");
                }else{
                    query = crud.getEm().createNamedQuery("MdiConcurso.findByFilter");
                }
            }
            
            if(filtro.getIdConcurso() != null){
                query.setParameter("idConcurso", filtro.getIdConcurso());
            }
            if(filtro.getNumeroConcurso()!= null){
                query.setParameter("numeroConcurso", filtro.getNumeroConcurso());
            }
            if(filtro.getNombreConcurso()!= null){
                query.setParameter("nombreConcurso", filtro.getNombreConcurso());
            }
            if(filtro.getDescripcionConcurso()!= null){
                //query.setParameter("descripcionConcurso", filtro.getDescripcionConcurso());
                query.setParameter("descripcionConcurso","%"+StringUtil.removeBlank(filtro.getDescripcionConcurso().toUpperCase())+"%");
            }
            if(filtro.getEstado()+""!= null){
                query.setParameter("estado", filtro.getEstado());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
}