/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghTipoSancion;
import gob.osinergmin.myc.domain.builder.TipoSancionBuilder;
import gob.osinergmin.myc.domain.dto.TipoSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipoSancionFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.TipoSancionDAO;
import gob.osinergmin.myc.service.exception.ProcesoObligacionTipoException;
import gob.osinergmin.myc.service.exception.TipoSancionException;
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
@Service("TipoSancionDAO")
public class TipoSancionDAOImpl implements TipoSancionDAO{
    private static final Logger LOG = LoggerFactory.getLogger(TipoSancionDAOImpl.class);
    @Inject
    private CrudDAO crud;

    @Override
    public HashMap listarTipoSancion(TipoSancionFilter filtro) {
        HashMap resultado = new HashMap();
        List<TipoSancionDTO> retorno = null;
        try{
            Long cuenta = count(filtro);
            LOG.info("--->cuenta="+cuenta);
            resultado.put("cuenta", cuenta);
            
            Query query = getFindQuery(filtro, false);
            if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
                query.setFirstResult(filtro.getStartIndex());
                query.setMaxResults(filtro.getResultsNumber());
            }
            
            retorno = TipoSancionBuilder.toListTipoSancionDto(query.getResultList());
            resultado.put("listado", retorno);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return resultado;
    }

    @Override
    public TipoSancionDTO create(TipoSancionDTO tipoSancionDTO, UsuarioDTO usuarioDTO) throws TipoSancionException{
        LOG.info("Registro Tipo Sancion DAO Impl");
        TipoSancionDTO retorno = null;
        try{
            TipoSancionDTO valida=findValida(tipoSancionDTO);
            LOG.info("--------->valida="+valida);
            
            PghTipoSancion tipoSancion = TipoSancionBuilder.getTipoSancion(tipoSancionDTO);
            tipoSancion.setDatosAuditoria(usuarioDTO);
            
            if(tipoSancionDTO.getIdTipoSancion() != null){
                if(valida.getIdTipoSancion()!=null && !valida.getIdTipoSancion().equals(tipoSancionDTO.getIdTipoSancion())){
                    throw new TipoSancionException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Tipo Sanci&oacute;n.",null);
                }
                crud.update(tipoSancion);
            }else{
                if(valida.getIdTipoSancion()!=null){
                    throw new TipoSancionException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Tipo Sanci&oacute;n.",null);
                }
                crud.create(tipoSancion);
            }
            retorno = TipoSancionBuilder.toTipoSancionDto(tipoSancion);
        }catch (TipoSancionException ex) {
            LOG.error("error create = ",ex);
            throw ex;
        }catch(Exception ex){
            LOG.error("error create... ",ex);
            TipoSancionException e2 = new TipoSancionException(TipoSancionException.ERROR_CREAR_TIPO_SANCION, ex, true);
            throw e2;
        }
        return retorno;
    }
    
    public TipoSancionDTO findValida(TipoSancionDTO tipoSancionDTO){
        List<TipoSancionDTO> lista=null;
        TipoSancionDTO retorno= new TipoSancionDTO();
        
        Query query = crud.getEm().createNamedQuery("PghTipoSancion.findValida");
        query.setParameter("descripcion",tipoSancionDTO.getDescripcion().toUpperCase());
        
        lista = TipoSancionBuilder.toListTipoSancionDto(query.getResultList());
        if(!lista.isEmpty()){
            retorno=lista.get(0);
        }
        
        return retorno;
    }

    @Override
    public TipoSancionDTO changeState(TipoSancionDTO tipoSancionDTO, String estado) throws TipoSancionException{
        LOG.info("Cambiar Estado Etapa DAO Impl");
        TipoSancionDTO retorno = null;
        try{
            Map<String, Object> valida= validaEliminarTipoSancion(tipoSancionDTO.getIdTipoSancion());
            
            if(valida.get("rpta").toString().equals("0")){
                throw new TipoSancionException(valida.get("msje").toString(),null);
            }
            
            Query query = crud.getEm().createNamedQuery("PghTipoSancion.findByIdTipoSancion");//cambiar
            TipoSancionFilter filtro = new TipoSancionFilter();
            filtro.setIdTipoSancion(tipoSancionDTO.getIdTipoSancion());
            query.setParameter("idTipoSancion",filtro.getIdTipoSancion());
            tipoSancionDTO = TipoSancionBuilder.toTipoSancionDto((PghTipoSancion)query.getResultList().get(0));
            
            PghTipoSancion tipoSancion = TipoSancionBuilder.getTipoSancion(tipoSancionDTO);
            tipoSancion.setEstado(estado.charAt(0));
            
            crud.update(tipoSancion);
            
            retorno = TipoSancionBuilder.toTipoSancionDto(tipoSancion);
            LOG.info("(Cambiar Estado Tipo Sancion DAO Impl) retorno: "+retorno.toString());
        }catch (TipoSancionException ex) {
            LOG.error("error changeState = ",ex);
            throw ex;
        }catch(Exception ex){
            LOG.error("error changeState... ",ex);
            TipoSancionException e2 = new TipoSancionException(TipoSancionException.ERROR_ELIMINAR_TIPO_SANCION, ex, true);
            throw e2;
        }
        return retorno;
    }
    
    public Map<String, Object> validaEliminarTipoSancion(Long idTipoSancion){
        LOG.info("procesando validaEliminarEtapa");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            String hql,rpta="1",msje="";
            Query query=null;
            
            if(rpta.equals("1")){
                hql="SELECT t from PghTipificacionSancion t where t.estado=:estado and t.pghTipoSancion.idTipoSancion=:idTipoSancion ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idTipoSancion", idTipoSancion);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Tipo Sanci&oacute;n mientras este siendo usado en Tipificaci&oacute;n Sanci&oacute;n.";
                }
            }
            
            retorno.put("rpta",rpta);
            retorno.put("msje",msje);
        }catch(Exception ex){
            LOG.error("Error en validaEliminarEtapa ",ex);
        }
        return retorno;
    }
    
    //@Override
    public Long count(TipoSancionFilter filtro) {
        LOG.info("contador DAO IMPL");
        Query query = getFindQuery(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
    }
    
    private Query getFindQuery(TipoSancionFilter filtro, boolean count) {
        Query query=null;
        try{
            if(count){
                if (filtro.getIdTipoSancion()!= null) {
                    query = crud.getEm().createNamedQuery("PghTipoSancion.countByIdTipoSancion");
                }else if (filtro.getDescripcion()!= null) {
                    query = crud.getEm().createNamedQuery("PghTipoSancion.countByDescripcion");
                }else {
                    query = crud.getEm().createNamedQuery("PghTipoSancion.countAll");
                }
            }else{
                if (filtro.getIdTipoSancion()!= null) {
                    query = crud.getEm().createNamedQuery("PghTipoSancion.findByIdTipoSancion");
                }else if (filtro.getDescripcion()!= null) {
                    query = crud.getEm().createNamedQuery("PghTipoSancion.findByDescripcion");
                }else {
                    query = crud.getEm().createNamedQuery("PghTipoSancion.findAll");
                }
            }

            if (filtro.getIdTipoSancion()!= null) {
                query.setParameter("idTipoSancion",filtro.getIdTipoSancion());
            }
            if (filtro.getDescripcion()!= null) {
                query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%");
            }
            if (filtro.getEstado()!= null) {
                query.setParameter("estado",filtro.getEstado().charAt(0));
            }
        }catch(Exception ex){
            LOG.error("Error getFindQuery: "+ex.getMessage());
        }
        return query;
    }
}