/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.service.exception.ActividadException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface ActividadDAO {
    public List<ActividadDTO> find(ActividadFilter filtro) throws ActividadException;
    public Long count(ActividadFilter filtro) throws ActividadException;
    public List<ProcesoObligacionTipoDTO> listarConfigurada();
	public ActividadDTO listarActividadxCodigo(ActividadFilter filtro);
}
