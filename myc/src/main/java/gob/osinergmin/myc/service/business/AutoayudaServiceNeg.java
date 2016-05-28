/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.AutoayudaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.AutoayudaFilter;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface AutoayudaServiceNeg {
    public List<AutoayudaDTO> listarAutoayuda(AutoayudaFilter filtro);
    public AutoayudaDTO editarAutoayuda(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO);
}
