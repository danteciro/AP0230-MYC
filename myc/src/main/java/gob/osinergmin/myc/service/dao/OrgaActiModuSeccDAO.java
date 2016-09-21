package gob.osinergmin.myc.service.dao;

import java.util.List;

import gob.osinergmin.myc.domain.dto.OrgaActiModuSeccDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.OrgaActiModuSeccionFilter;

public interface OrgaActiModuSeccDAO {

	Long count(OrgaActiModuSeccionFilter filtro);
	List<OrgaActiModuSeccDTO> obtenerOrgaActiModuSeccion(OrgaActiModuSeccionFilter filtro);
	OrgaActiModuSeccDTO create(OrgaActiModuSeccDTO orgaActiModuSeccDTO,UsuarioDTO usuarioDTO);
	OrgaActiModuSeccDTO delete(OrgaActiModuSeccDTO orgaActiModuSeccDTO,UsuarioDTO usuarioDTO);
	OrgaActiModuSeccDTO find(Long idOrgaActiModuSecc);
	OrgaActiModuSeccDTO update(OrgaActiModuSeccDTO orgaActiModuSeccDTO,UsuarioDTO usuarioDTO);
	List<OrgaActiModuSeccDTO> valida(OrgaActiModuSeccDTO orgaActiModuSeccDTO);

}
