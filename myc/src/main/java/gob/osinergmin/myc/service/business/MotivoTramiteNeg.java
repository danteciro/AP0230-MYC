/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.MotivoTramiteDTO;
import gob.osinergmin.myc.domain.ui.MotivoTramiteFilter;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface MotivoTramiteNeg {
    public List<MotivoTramiteDTO> findMotivoTramiteByFilter(MotivoTramiteFilter filtro);
}
