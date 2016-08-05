package gob.osinergmin.myc.service.dao;
import gob.osinergmin.myc.domain.dto.ConfFiltroEmpSupDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConfFiltroEmpSupFilter;
import gob.osinergmin.myc.service.exception.ConfFiltroEmpSupException;

import java.util.List;

/**
 *
 * @author mdiosesf
 */
public interface ConfFiltroEmpSupDAO {
    public List<ConfFiltroEmpSupDTO> findConfFiltroEmpSup(ConfFiltroEmpSupFilter filtro) throws ConfFiltroEmpSupException;
    public ConfFiltroEmpSupDTO create(ConfFiltroEmpSupDTO confFiltroEmpSupDTO, UsuarioDTO usuarioDTO) throws ConfFiltroEmpSupException;
    public ConfFiltroEmpSupDTO update(ConfFiltroEmpSupDTO confFiltroEmpSupDTO, UsuarioDTO usuarioDTO) throws ConfFiltroEmpSupException;
}
