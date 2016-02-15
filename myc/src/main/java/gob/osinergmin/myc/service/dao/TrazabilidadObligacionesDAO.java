/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.TrazabilidadObligacionesDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.exception.TrazabilidadObligacionesException;

/**
 *
 * @author jpiro
 */
public interface TrazabilidadObligacionesDAO {
    public Long getSequenceTrazaObli() throws TrazabilidadObligacionesException;
}
