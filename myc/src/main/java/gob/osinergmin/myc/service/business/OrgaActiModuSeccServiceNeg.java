package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.OrgaActiModuSeccDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.OrgaActiModuSeccionFilter;

import java.util.List;

public interface OrgaActiModuSeccServiceNeg {

	List<OrgaActiModuSeccDTO> listarOrgaActiModuSeccion(OrgaActiModuSeccionFilter filtro, int[] auxiliar);

	OrgaActiModuSeccDTO guardaConfiguracion(OrgaActiModuSeccDTO orgaActiModuSeccDTO, UsuarioDTO usuarioDTO);

	OrgaActiModuSeccDTO eliminarConfiguracion(OrgaActiModuSeccDTO orgaActiModuSeccDTO, UsuarioDTO usuarioDTO);

	OrgaActiModuSeccDTO find(Long idOrgaActiModuSecc);

	OrgaActiModuSeccDTO actualizaConfiguracion(OrgaActiModuSeccDTO orgaActiModuSeccDTO, UsuarioDTO usuarioDTO);

	List<OrgaActiModuSeccDTO> validaConfiguracion(OrgaActiModuSeccDTO orgaActiModuSeccDTO);

}
