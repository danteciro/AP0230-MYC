/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.ui.ProcesoFilter;
import gob.osinergmin.myc.service.business.ProcesoServiceNeg;
import gob.osinergmin.myc.service.dao.ProcesoDAO;
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
@Service("procesoServiceNeg")
public class ProcesoServiceNegImpl implements ProcesoServiceNeg {
    private static final Logger LOG = LoggerFactory.getLogger(EtapaServiceNegImpl.class);
    @Inject
    private ProcesoDAO procesoDAO;
    
    @Override
    public List<ProcesoDTO> listarProceso(){
        LOG.info("Neg listarEtapaPreOperativo");
        List<ProcesoDTO> retorno=null;
        try{
            ProcesoFilter filtro=new ProcesoFilter();
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            retorno = procesoDAO.listarProceso(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
}
