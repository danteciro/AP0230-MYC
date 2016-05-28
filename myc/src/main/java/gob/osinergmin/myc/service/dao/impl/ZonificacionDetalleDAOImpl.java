/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.MdiUbigeo;
import gob.osinergmin.myc.domain.PghZonificacionDetalle;
import gob.osinergmin.myc.domain.builder.ZonificacionDetalleBuilder;
import gob.osinergmin.myc.domain.dto.DistritoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDetalleDTO;
import gob.osinergmin.myc.domain.ui.ZonificacionDetalleFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ZonificacionDetalleDAO;
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
 * @author lbarboza
 */
@Service("zonificacionDetalleDAO")
public class ZonificacionDetalleDAOImpl implements ZonificacionDetalleDAO{
    private static final Logger LOG = LoggerFactory.getLogger(ZonificacionDetalleDAOImpl.class);
    @Inject
    private CrudDAO crud;

    @Override
    public List<ZonificacionDetalleDTO> obtenerZonificacionDetalle(ZonificacionDetalleFilter filtro) {
        List<ZonificacionDetalleDTO> listado = null;
        
        Query query = null;
        LOG.info("IdZonificacion : --> " + filtro.getIdZonificacion());
        if(filtro.getIdZonificacion()!=null && !filtro.getIdZonificacion().equals("")){	
        	query = crud.getEm().createNamedQuery("PghZonificacionDetalle.findByFilter");
            if(filtro.getEstado()!=null){
                query.setParameter("estado",filtro.getEstado());
            }
            if(filtro.getIdZonificacion()!=null){
                query.setParameter("idZonificacion",filtro.getIdZonificacion());
            }
        }else{
        	query = crud.getEm().createNamedQuery("PghZonificacionDetalle.findAllByFilter");
            if(filtro.getEstado()!=null){
                query.setParameter("estado",filtro.getEstado());
            }            
        }
        
        listado = ZonificacionDetalleBuilder.toListZonificacionDetalleDto(query.getResultList());
        
        return listado;
    }

    @Override
    public ZonificacionDetalleDTO create(ZonificacionDetalleDTO zonificacionDetalleDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Zonificacion Detalle DAO Impl");
        ZonificacionDetalleDTO retorno = null;
        try{
            PghZonificacionDetalle zonificacionDetalle = ZonificacionDetalleBuilder.getZonificacionDetalle(zonificacionDetalleDTO);
            zonificacionDetalle.setDatosAuditoria(usuarioDTO);
            
            if(zonificacionDetalleDTO.getIdZonificacionDetalle() != null){
                crud.update(zonificacionDetalle);
            }else{
                crud.create(zonificacionDetalle);
            }
            retorno = ZonificacionDetalleBuilder.toZonificacionDetalleDto(zonificacionDetalle);
            LOG.info("(Registro Zonificacion Detalle DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public ZonificacionDetalleDTO changeState(ZonificacionDetalleDTO zonificacionDetalleDTO, String estado) {
        LOG.info("Cambiar Estado Zonificacion Detalle DAO Impl");
        ZonificacionDetalleDTO retorno = null;
        try{
            Query query =crud.getEm().createNamedQuery("PghZonificacionDetalle.findByIdZonificacionDetalle");
            ZonificacionDetalleFilter filtro = new ZonificacionDetalleFilter();
            filtro.setIdZonificacionDetalle(zonificacionDetalleDTO.getIdZonificacionDetalle());
            query.setParameter("idZonificacionDetalle",filtro.getIdZonificacionDetalle());
            zonificacionDetalleDTO = ZonificacionDetalleBuilder.toZonificacionDetalleDto((PghZonificacionDetalle)query.getResultList().get(0));
            
            PghZonificacionDetalle zonificacionDetalle = ZonificacionDetalleBuilder.getZonificacionDetalle(zonificacionDetalleDTO);
            zonificacionDetalle.setEstado(estado);
            
            crud.update(zonificacionDetalle);
            
            retorno = ZonificacionDetalleBuilder.toZonificacionDetalleDto(zonificacionDetalle);
            LOG.info("(Cambiar Estado Zonificacion Detalle DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    public void disabledZonificacionDetalle(Long idZonificacion){
        LOG.info("Desahabilitar Zonificacion Detalle DAO Impl");
        LOG.info("-- idZonificacion = "+idZonificacion);
        String queryString = "update PghZonificacionDetalle zd set zd.estado = '0' where zd.idZonificacion.idZonificacion = "+idZonificacion;
        Query query = crud.getEm().createQuery(queryString);
        query.executeUpdate();
    }
    
    @Override
    public List<DistritoDTO> obtenerDistritosUnicos(Long idZonificacion, Long idDepartamento, Long idProvincia) {
	LOG.info("entro obtenerDistritos");
	List<DistritoDTO> retorno = null;
	try {
            String subquery = "SELECT zd.mdiUbigeo.mdiUbigeoPK.idDistrito FROM PghZonificacionDetalle zd "
                + " where zd.estado=1 and "
                + " zd.mdiUbigeo.mdiUbigeoPK.idDepartamento = "+idDepartamento+" and "
                + " zd.mdiUbigeo.mdiUbigeoPK.idProvincia = "+idProvincia+" and "
                + " zd.idZonificacion.idZonificacion =  "+idZonificacion;
            
            String query = "SELECT u " +
                "FROM MdiUbigeo u " +
                "WHERE " +
                " u.mdiUbigeoPK.idDistrito != '00' and " +
                " u.mdiUbigeoPK.idDepartamento = "+idDepartamento+" and " +
                " u.mdiUbigeoPK.idProvincia = "+idProvincia+" and " +
                " u.mdiUbigeoPK.idDistrito not in ("+subquery+") order by u.nombre "    ;
            
	    List<MdiUbigeo> listaUbigeo = null;
            
	    listaUbigeo = crud.getEm().createQuery(query).getResultList(); 
              LOG.info("listaUbigeo=="+listaUbigeo);
	    retorno = new ArrayList<DistritoDTO>();
	    DistritoDTO distritoDTO = null;
	    for (MdiUbigeo ubigeo : listaUbigeo) {
		distritoDTO = new DistritoDTO();
		distritoDTO.setIdDepartamento(ubigeo.getMdiUbigeoPK().getIdDepartamento());
		distritoDTO.setIdDistrito(ubigeo.getMdiUbigeoPK().getIdDistrito());
		distritoDTO.setIdProvincia(ubigeo.getMdiUbigeoPK().getIdProvincia());
		distritoDTO.setNombre(ubigeo.getNombre());
		distritoDTO.setEstado(ubigeo.getEstado());
		retorno.add(distritoDTO);
	    }
	} catch (Exception e) {
	    LOG.error("error", e);
	}
	return retorno;
    }

    @Override
    public ZonificacionDetalleDTO obtenerZonificacionDetalleUbigeo(Long idZonificacionDetalle, Long idDepartamento, Long idProvincia, Long idDistrito) {
        LOG.info("obtenerZonificacionDetalleUbigeo DAO Impl");
        ZonificacionDetalleDTO retorno = null;
        try{
            ZonificacionDetalleDTO zonificacionDetalleDTO = null;
            Query query =crud.getEm().createNamedQuery("PghZonificacionDetalle.findByIdZonificacionDetalleUbigeo");
            query.setParameter("idZonificacion",idZonificacionDetalle);
            query.setParameter("idDistrito",formateaNumeroEntero(idDistrito));
            query.setParameter("idDepartamento",formateaNumeroEntero(idDepartamento));
            query.setParameter("idProvincia",formateaNumeroEntero(idProvincia));
            query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);
            LOG.info("parametros = idZonificacion = "+idZonificacionDetalle+", idDistrito = "+formateaNumeroEntero(idDistrito)+", idProvincia = "+formateaNumeroEntero(idProvincia)+", idDepartamento = "+formateaNumeroEntero(idDepartamento));
            zonificacionDetalleDTO = ZonificacionDetalleBuilder.toZonificacionDetalleDto((PghZonificacionDetalle)query.getResultList().get(0));
            
            PghZonificacionDetalle zonificacionDetalle = ZonificacionDetalleBuilder.getZonificacionDetalle(zonificacionDetalleDTO);
            
            retorno = ZonificacionDetalleBuilder.toZonificacionDetalleDto(zonificacionDetalle);
            LOG.info("(Cambiar Estado Zonificacion Detalle DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    public String formateaNumeroEntero(Long numero){
        String retorno = "";
        int nro = numero.intValue();
        LOG.info("nro = "+nro);
        if(nro < 10){
            retorno = "0"+nro;
        }else{
            retorno = ""+nro;
        }
        return retorno;
    }
}