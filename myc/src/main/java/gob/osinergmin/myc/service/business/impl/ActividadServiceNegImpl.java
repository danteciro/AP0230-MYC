/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.service.business.ActividadServiceNeg;
import gob.osinergmin.myc.service.dao.ActividadDAO;
import gob.osinergmin.myc.util.Constantes;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpiro
 */
@Service("ActividadServiceNeg")
public class ActividadServiceNegImpl implements ActividadServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(ActividadServiceNeg.class);
    @Inject
    private ActividadDAO actividadDAO;    
    
    @Override
    public List<ActividadDTO> findActividadByFilter(ActividadFilter filtro){
        LOG.info("Neg findTramiteByFilter");
        List<ActividadDTO> retorno=null;
        try{
            retorno = actividadDAO.find(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    public List<ActividadDTO> listarActividad(ActividadFilter filtro, int[] cuenta){
        LOG.info("Neg listarActividad");
        List<ActividadDTO> retorno=null;
        try{
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            cuenta[0] = actividadDAO.count(filtro).intValue();
            if (cuenta[0] > 0) {
                retorno = actividadDAO.find(filtro);
                LOG.info("cuenta -size: "+retorno.size());
            }
            //retorno = actividadDAO.find(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
	public List<ProcesoObligacionTipoDTO> listarActividadConfigurada() {
		List<ProcesoObligacionTipoDTO> retorno=null;
		try{
            retorno = actividadDAO.listarConfigurada();
        }catch(Exception ex){
            LOG.error("",ex);
        }
		return retorno;
	}
}
