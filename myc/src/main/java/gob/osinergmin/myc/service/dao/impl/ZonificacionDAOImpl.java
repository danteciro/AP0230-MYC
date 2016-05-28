/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.PghZonificacion;
import gob.osinergmin.myc.domain.builder.ZonificacionBuilder;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDTO;
import gob.osinergmin.myc.domain.ui.ZonificacionFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ZonificacionDAO;
import gob.osinergmin.myc.service.exception.ZonificacionException;
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
 * @author jpiro
 */
@Service("zonificacionDAO")
public class ZonificacionDAOImpl implements ZonificacionDAO{
    private static final Logger LOG = LoggerFactory.getLogger(ZonificacionDAOImpl.class);
    @Inject
    private CrudDAO crud;    
    
    public List<ZonificacionDTO> obtenerZonificacion(ZonificacionFilter filtro) throws ZonificacionException{
        List<ZonificacionDTO> listado=null;

        Query query =crud.getEm().createNamedQuery("PghZonificacion.findAll");
        if(filtro.getEstado()!=null){
            query.setParameter("estado",filtro.getEstado());
        }
        if(filtro.getNombre()!=null){
            query.setParameter("nombre","%"+filtro.getNombre().toUpperCase()+"%");
        }else{
            query.setParameter("nombre","%");            
        }
        listado = ZonificacionBuilder.toListZonificacionDto(query.getResultList());

        return listado;
    }
    @Override
    public List<ZonificacionDTO> obtenerZonificacionValidaNombre(ZonificacionFilter filtro) throws ZonificacionException{
        List<ZonificacionDTO> listado=null;

        Query query =crud.getEm().createNamedQuery("PghZonificacion.findValidaNombre");
        query.setParameter("estado",filtro.getEstado());
        query.setParameter("nombre",filtro.getNombre().toUpperCase());
        listado = ZonificacionBuilder.toListZonificacionDto(query.getResultList());

        return listado;
    }

    @Override
    public ZonificacionDTO create(ZonificacionDTO zonificacionDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Zonificacion DAO Impl");
        ZonificacionDTO retorno = null;
        try{
            PghZonificacion zonificacion = ZonificacionBuilder.getZonificacion(zonificacionDTO);
            zonificacion.setDatosAuditoria(usuarioDTO);
            
            if(zonificacionDTO.getIdZonificacion() != null){
                crud.update(zonificacion);
            }else{
                crud.create(zonificacion);
            }
            retorno = ZonificacionBuilder.toZonificacionDto(zonificacion);
            LOG.info("(Registro Zonificacion DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public ZonificacionDTO changeState(ZonificacionDTO zonificacionDTO, String estado) throws ZonificacionException {
        LOG.info("Cambiar Estado Zonificacion DAO Impl");
        ZonificacionDTO retorno = null;
        try{
            Map<String, Object> valida= validaEliminarZonificacion(zonificacionDTO.getIdZonificacion());
            
            if(valida.get("rpta").toString().equals("0")){
                throw new ZonificacionException(valida.get("msje").toString(),null);
            }
            
            Query query =crud.getEm().createNamedQuery("PghZonificacion.findByIdZonificacion");
            ZonificacionFilter filtro = new ZonificacionFilter();
            filtro.setIdZonificacion(zonificacionDTO.getIdZonificacion());
            query.setParameter("idZonificacion",filtro.getIdZonificacion());
            zonificacionDTO = ZonificacionBuilder.toZonificacionDto((PghZonificacion)query.getResultList().get(0));
            
            PghZonificacion zonificacion = ZonificacionBuilder.getZonificacion(zonificacionDTO);
            zonificacion.setEstado(estado);
            
            crud.update(zonificacion);
            
            retorno = ZonificacionBuilder.toZonificacionDto(zonificacion);
            LOG.info("(Cambiar Estado Zonificacion DAO Impl) retorno: "+retorno.toString());
        }catch (ZonificacionException ex) {
            LOG.error("error changeState = ",ex);
            throw ex;
        }catch(Exception ex){
            LOG.error("error changeState... ",ex);
            ZonificacionException e2 = new ZonificacionException(ZonificacionException.ERROR_ELIMINAR_ZONIFICACION, ex, true);
            throw e2;
        }
        return retorno;
    }
    
    public Map<String, Object> validaEliminarZonificacion(Long idZonificacion){
        LOG.info("procesando validaEliminarZonificacion");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            String hql,rpta="1",msje="";
            Query query=null;
            
            //verifica que la etapa no tenga un hijo-Tramite
            if(rpta.equals("1")){
                hql="SELECT t.idRequisitoProcedimiento from PghCnfRequProcedimiento t where t.estado=:estado and t.idZonificacion.idZonificacion=:idZonificacion ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idZonificacion", idZonificacion);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Zonificaci&oacute;n mientras este siendo usada en Requisitos.";
                }
            }
            
            retorno.put("rpta",rpta);
            retorno.put("msje",msje);
        }catch(Exception ex){
            LOG.error("Error en validaEliminarZonificacion ",ex);
        }
        return retorno;
    }
}