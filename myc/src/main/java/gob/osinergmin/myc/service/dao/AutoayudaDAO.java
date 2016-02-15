/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.AutoayudaDTO;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.AutoayudaFilter;
import gob.osinergmin.myc.service.exception.AutoayudaException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface AutoayudaDAO {
    public List<AutoayudaDTO> find(AutoayudaFilter filtro) throws AutoayudaException;
    public AutoayudaDTO update(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO) throws AutoayudaException;
}
