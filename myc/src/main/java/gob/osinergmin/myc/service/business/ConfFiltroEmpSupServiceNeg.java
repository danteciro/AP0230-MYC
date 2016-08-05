package gob.osinergmin.myc.service.business;
import java.util.List;
import gob.osinergmin.myc.domain.dto.ConfFiltroEmpSupDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConfFiltroEmpSupFilter;
import gob.osinergmin.myc.service.exception.ConfFiltroEmpSupException;

/**
 *
 * @author mdiosesf
 */
public interface ConfFiltroEmpSupServiceNeg {
    public List<ConfFiltroEmpSupDTO> ConfFiltroEmpSup(ConfFiltroEmpSupFilter filtro) throws ConfFiltroEmpSupException;
    public ConfFiltroEmpSupDTO guardarConfFiltroEmpSup(ConfFiltroEmpSupDTO confFiltroEmpSupDTO, UsuarioDTO usuarioDTO) throws ConfFiltroEmpSupException;
    public ConfFiltroEmpSupDTO editarConfFiltroEmpSup(ConfFiltroEmpSupDTO confFiltroEmpSupDTO, UsuarioDTO usuarioDTO) throws ConfFiltroEmpSupException;
}
