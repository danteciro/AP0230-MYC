/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.MdiUbigeo;
import gob.osinergmin.myc.domain.builder.ZonificacionDetalleBuilder;
import gob.osinergmin.myc.domain.dto.DepartamentoDTO;
import gob.osinergmin.myc.domain.dto.DistritoDTO;
import gob.osinergmin.myc.domain.dto.ProvinciaDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDetalleDTO;
import gob.osinergmin.myc.domain.ui.UbigeoFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.UbigeoDAO;
import gob.osinergmin.myc.service.exception.UbigeoException;
import java.util.ArrayList;
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
@Service("ubigeoDAO")
public class UbigeoDAOImpl implements UbigeoDAO{
    private static final Logger LOG = LoggerFactory.getLogger(UbigeoDAO.class);
    @Inject
    private CrudDAO crud;    
    
    @Override
    public List<ZonificacionDetalleDTO> listarZonificacionDetalle(UbigeoFilter filtro) throws UbigeoException{
        LOG.info("entro listarZonificacionDetalle");
	List<ZonificacionDetalleDTO> retorno = null;
	try {
	    Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("idDepartamento", filtro.getIdDepartamento());
            parameters.put("idProvincia", filtro.getIdProvincia());
            parameters.put("idDistrito", filtro.getIdDistrito());
            parameters.put("estado", filtro.getEstado());
	    retorno = ZonificacionDetalleBuilder.toListZonificacionDetalleDto(crud.findByNamedQuery("PghZonificacionDetalle.findAll", parameters));
	} catch (Exception e) {
	    LOG.error("error", e);
	}
	return retorno;
    }
    
    @Override
    public List<ProvinciaDTO> obtenerProvincias(UbigeoFilter filtro) throws UbigeoException{
	LOG.info("entro obtenerProvincias");
	List<ProvinciaDTO> retorno = null;
	try {
	    List<MdiUbigeo> listaUbigeo = null;
	    Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("idDepartamento", filtro.getIdDepartamento());

	    listaUbigeo = crud.findByNamedQuery("MdiUbigeo.findProvinciaByIdDepartamento", parameters);
            LOG.info("listaUbigeo=="+listaUbigeo);
	    retorno = new ArrayList<ProvinciaDTO>();
	    ProvinciaDTO provinciaDTO = null;
	    for (MdiUbigeo ubigeo : listaUbigeo) {
		provinciaDTO = new ProvinciaDTO();
		provinciaDTO.setIdDepartamento(ubigeo.getMdiUbigeoPK().getIdDepartamento());
		provinciaDTO.setIdProvincia(ubigeo.getMdiUbigeoPK().getIdProvincia());
		provinciaDTO.setNombre(ubigeo.getNombre());
		provinciaDTO.setEstado(ubigeo.getEstado());
		retorno.add(provinciaDTO);
	    }
	} catch (Exception e) {
	    LOG.error("error", e);
	}
	return retorno;
    }
    
    @Override
    public List<DepartamentoDTO> obtenerDepartamentos(UbigeoFilter filtro) throws UbigeoException{
        List<DepartamentoDTO> retorno=null;
        try{
            List<MdiUbigeo> listaUbigeo = new ArrayList<MdiUbigeo>();
            Query query=crud.getEm().createNamedQuery("MdiUbigeo.findDepartamento");
            //query.setParameter("estado",filtro.getEstado());
            
            listaUbigeo=query.getResultList();

	    retorno = new ArrayList<DepartamentoDTO>();
	    DepartamentoDTO departamentoDTO = new DepartamentoDTO();
	    for (MdiUbigeo ubigeo : listaUbigeo) {
		departamentoDTO = new DepartamentoDTO();
		departamentoDTO.setIdDepartamento(ubigeo.getMdiUbigeoPK().getIdDepartamento());
		departamentoDTO.setNombre(ubigeo.getNombre());
		departamentoDTO.setEstado(ubigeo.getEstado());
		retorno.add(departamentoDTO);
	    }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    public List<DistritoDTO> obtenerDistritos(UbigeoFilter filtro) {
	LOG.info("entro obtenerDistritos");
	List<DistritoDTO> retorno = null;
	try {
	    List<MdiUbigeo> listaUbigeo = null;
	    Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("idDepartamento", filtro.getIdDepartamento());
	    parameters.put("idProvincia", filtro.getIdProvincia());
            
	    listaUbigeo = crud.findByNamedQuery("MdiUbigeo.findDistritoByParametros", parameters);
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
}
