/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface ActividadServiceNeg {
    public List<ActividadDTO> listarActividad(ActividadFilter filtro, int[] cuenta);
    public List<ActividadDTO> findActividadByFilter(ActividadFilter filtro);
    public List<ProcesoObligacionTipoDTO> listarActividadConfigurada();
}
