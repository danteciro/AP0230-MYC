/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.DepartamentoDTO;
import gob.osinergmin.myc.domain.dto.DistritoDTO;
import gob.osinergmin.myc.domain.dto.ProvinciaDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDetalleDTO;
import gob.osinergmin.myc.domain.ui.UbigeoFilter;
import gob.osinergmin.myc.service.business.UbigeoServiceNeg;
import gob.osinergmin.myc.service.dao.UbigeoDAO;
import gob.osinergmin.myc.util.Constantes;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpiro
 */
@Service("ubigeoServiceNeg")
public class UbigeoServiceNegImpl implements UbigeoServiceNeg {
    private static final Logger LOG = LoggerFactory.getLogger(EtapaServiceNegImpl.class);
    @Inject
    private UbigeoDAO ubigeoDAO;
    
    @Override
    @Transactional(readOnly=true)
    public List<ZonificacionDetalleDTO> listarZonificacionDetalle(UbigeoFilter filtro){
        List<ZonificacionDetalleDTO> retorno=null;
        LOG.info("Neg obtenerListadoProvincias");
        try{
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            retorno = ubigeoDAO.listarZonificacionDetalle(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }        
        return retorno;
    }
    
    @Override
    public List<DistritoDTO> obtenerListadoDistritos(UbigeoFilter filtro){
        List<DistritoDTO> retorno=null;
        LOG.info("Neg obtenerListadoDistritos");
        try{
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            retorno = ubigeoDAO.obtenerDistritos(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }        
        return retorno;
    }
    
    @Override
    public List<ProvinciaDTO> obtenerListadoProvincias(UbigeoFilter filtro){
        List<ProvinciaDTO> retorno=null;
        LOG.info("Neg obtenerListadoProvincias");
        try{
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            retorno = ubigeoDAO.obtenerProvincias(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }        
        return retorno;
    }
    
    @Override
    public List<DepartamentoDTO> obtenerListadoDepartamentos(){
        List<DepartamentoDTO> retorno=null;
        LOG.info("Neg obtenerListadoDepartamentos");
        try{
            UbigeoFilter filtro=new UbigeoFilter();
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            retorno = ubigeoDAO.obtenerDepartamentos(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno; 
    }
}
