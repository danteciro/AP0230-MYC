/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.ui.ProcesoFilter;
import gob.osinergmin.myc.service.exception.ProcesoException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface ProcesoDAO {
    public List<ProcesoDTO> listarProceso(ProcesoFilter filtro) throws ProcesoException;
}
