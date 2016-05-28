/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.TrazabilidadObligacionesDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.business.TrazabilidadObligacionesServiceNeg;
import gob.osinergmin.myc.service.dao.TrazabilidadObligacionesDAO;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpiro
 */
@Service("trazabilidadObligacionesServiceNeg")
public class TrazabilidadObligacionesServiceNegImpl implements TrazabilidadObligacionesServiceNeg {
    private static final Logger LOG = LoggerFactory.getLogger(TrazabilidadObligacionesServiceNegImpl.class);
    @Inject
    TrazabilidadObligacionesDAO trazabilidadObligacionesDAO;
    
    public Long obtenerSequenceTrazaObli(){
        Long retorno=null;
        try{
            retorno=trazabilidadObligacionesDAO.getSequenceTrazaObli();
        }catch(Exception e){
            LOG.error("Error, "+e.getMessage());
        }
        return retorno;
    }
}
