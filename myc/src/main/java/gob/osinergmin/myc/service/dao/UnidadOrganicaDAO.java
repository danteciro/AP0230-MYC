package gob.osinergmin.myc.service.dao;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.CnfActUniOrganicaFilter;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.exception.UnidadOrganicaException;

import java.util.List;

/**
*
* @author mdiosesf
*/

public interface UnidadOrganicaDAO {
	List<UnidadOrganicaDTO> findUnidadOrganica(UnidadOrganicaFilter filtro) throws UnidadOrganicaException;
	UnidadOrganicaDTO create(UnidadOrganicaDTO unidadOrganicaDTO, UsuarioDTO usuarioDTO) throws UnidadOrganicaException;
	UnidadOrganicaDTO update(UnidadOrganicaDTO unidadOrganicaDTO, UsuarioDTO usuarioDTO) throws UnidadOrganicaException;
	
	/* OSINE_SFS-1232 - REQF- - Inicio */
	List<UnidadOrganicaDTO> findUnidadOrganicaByEtapaConfiguracion(UnidadOrganicaFilter filtro) throws UnidadOrganicaException;
	List<UnidadOrganicaDTO> findUnidadOrganicaGerencia(UnidadOrganicaFilter filtro) throws UnidadOrganicaException;
	List<UnidadOrganicaDTO> findUnidadesNivelTresJoinEtapaConfiguracion(UnidadOrganicaFilter filtro) throws UnidadOrganicaException;	
	
	List<UnidadOrganicaDTO> findUnidadUnidadOrganicaDTOByIdCnfActUniOrganicaDTO(CnfActUniOrganicaFilter cnfActUniOrganicaFilter) throws UnidadOrganicaException;

	/* OSINE_SFS-1232 - REQF- - Inicio */
	
	
}
