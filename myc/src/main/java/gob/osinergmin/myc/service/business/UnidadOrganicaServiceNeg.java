package gob.osinergmin.myc.service.business;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.exception.UnidadOrganicaException;
import java.util.List;

/**
 *
 * @author mdiosesf
 */
public interface UnidadOrganicaServiceNeg {
	public List<UnidadOrganicaDTO> findUnidadOrganica(UnidadOrganicaFilter filtro);
	public UnidadOrganicaDTO guardarUnidadOrganica(UnidadOrganicaDTO unidadOrganicaDTO, UsuarioDTO usuarioDTO) throws UnidadOrganicaException;
	public UnidadOrganicaDTO editarUnidadOrganica(UnidadOrganicaDTO unidadOrganicaDTO, UsuarioDTO usuarioDTO) throws UnidadOrganicaException;
	public List<UnidadOrganicaDTO> obtenerListadoUnidadOrganica(UnidadOrganicaFilter filtro);
    public Long obtenerIdUnidadOrganicaByIdEntidad(Long idEntidad);
    
}