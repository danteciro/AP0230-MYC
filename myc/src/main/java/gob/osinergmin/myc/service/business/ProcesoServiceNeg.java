/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.ui.ProcesoFilter;
import gob.osinergmin.myc.service.exception.ProcesoException;

import java.util.List;

/**
 *
 * @author jpiro
 */
public interface ProcesoServiceNeg {
    public List<ProcesoDTO> listarProceso();
    /* OSINE_SFS-1232 - REQF- - Inicio */
    public List<ProcesoDTO> listarProcesoByIdentificador(ProcesoFilter filtro)  throws ProcesoException;
    /* OSINE_SFS-1232 - REQF- - Inicio */
}
