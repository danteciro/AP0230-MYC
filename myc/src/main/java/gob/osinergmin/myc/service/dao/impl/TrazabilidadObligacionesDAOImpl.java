/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.dto.TrazabilidadObligacionesDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.RequisitoDAO;
import gob.osinergmin.myc.service.dao.TrazabilidadObligacionesDAO;
import gob.osinergmin.myc.service.exception.TrazabilidadObligacionesException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpiro
 */
@Service("trazabilidadObligacionesDAO")
public class TrazabilidadObligacionesDAOImpl implements TrazabilidadObligacionesDAO{
    private static final Logger LOG = LoggerFactory.getLogger(TrazabilidadObligacionesDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public Long getSequenceTrazaObli() throws TrazabilidadObligacionesException{
        return crud.findSequence("PGH_CODIGO_TRAZABILIDAD_SEQ");
    }
}
