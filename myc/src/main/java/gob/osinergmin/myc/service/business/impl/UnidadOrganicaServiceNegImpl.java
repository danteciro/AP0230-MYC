package gob.osinergmin.myc.service.business.impl;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.CnfActUniOrganicaFilter;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.business.UnidadOrganicaServiceNeg;
import gob.osinergmin.myc.service.dao.UnidadOrganicaDAO;
import gob.osinergmin.myc.service.exception.UnidadOrganicaException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author mdiosesf
 */
@Service("unidadOrganicaServiceNeg")
public class UnidadOrganicaServiceNegImpl implements UnidadOrganicaServiceNeg {    
    private static final Logger LOG = LoggerFactory.getLogger(UnidadOrganicaServiceNegImpl.class);
    
    @Inject
    UnidadOrganicaDAO unidadOrganicaDAO;
    
    
	@Override
	public List<UnidadOrganicaDTO> findUnidadOrganica(UnidadOrganicaFilter filtro) {
		LOG.info("Funcion: findUnidadOrganica");
		List<UnidadOrganicaDTO> listado=null;
        try{
        	listado = unidadOrganicaDAO.findUnidadOrganica(filtro);             	
        }catch(Exception ex){
            LOG.error("Error en findUnidadOrganica", ex);
        }
		return listado;
	}

	@Override
	public UnidadOrganicaDTO guardarUnidadOrganica(UnidadOrganicaDTO unidadOrganicaDTO,
			UsuarioDTO usuarioDTO) throws UnidadOrganicaException {		
		try {
			return unidadOrganicaDAO.create(unidadOrganicaDTO, usuarioDTO);
        } catch (Exception ex) {
            LOG.error("Error en guardarUnidadOrganica", ex);
            throw new UnidadOrganicaException(ex.getMessage(),null);
        }
	}
	@Override
	public List<UnidadOrganicaDTO> obtenerListadoUnidadOrganica(
			UnidadOrganicaFilter filtro) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long obtenerIdUnidadOrganicaByIdEntidad(Long idEntidad) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UnidadOrganicaDTO editarUnidadOrganica(UnidadOrganicaDTO unidadOrganicaDTO,
			UsuarioDTO usuarioDTO) throws UnidadOrganicaException {
		try {
            return unidadOrganicaDAO.update(unidadOrganicaDTO, usuarioDTO);
        } catch (Exception ex) {
            LOG.error("Error en editarUnidadOrganica", ex);
            throw new UnidadOrganicaException(ex.getMessage(),null);
        }
	}
	/* OSINE_SFS-1232 - REQF- - Inicio */
	@Override
	public List<UnidadOrganicaDTO> findUnidadOrganicaByEtapaConfiguracion(UnidadOrganicaFilter filtro) throws UnidadOrganicaException {
		List<UnidadOrganicaDTO> lista = new ArrayList<UnidadOrganicaDTO>();
		lista = unidadOrganicaDAO.findUnidadOrganicaByEtapaConfiguracion(filtro);
		return lista;
	}

	@Override
	public List<UnidadOrganicaDTO> findUnidadOrganicaGerencia(UnidadOrganicaFilter filtro) throws UnidadOrganicaException {
		List<UnidadOrganicaDTO> lista = new ArrayList<UnidadOrganicaDTO>();
		lista = unidadOrganicaDAO.findUnidadOrganicaGerencia(filtro);
		return lista;
	}

	@Override
	public List<UnidadOrganicaDTO> findUnidadesNivelTresJoinEtapaConfiguracion(UnidadOrganicaFilter filtro) throws UnidadOrganicaException {
		List<UnidadOrganicaDTO> lista = new ArrayList<UnidadOrganicaDTO>();
		lista = unidadOrganicaDAO.findUnidadesNivelTresJoinEtapaConfiguracion(filtro);
		return lista;
	}
	/* OSINE_SFS-1232 - REQF- - Inicio */

	@Override
	public List<UnidadOrganicaDTO> findUnidadUnidadOrganicaByIdCnfActUniOrganicaDTO(CnfActUniOrganicaFilter cnfActUniOrganicaFilter) throws UnidadOrganicaException {
		List<UnidadOrganicaDTO> lista = new ArrayList<UnidadOrganicaDTO>();
		lista = unidadOrganicaDAO.findUnidadUnidadOrganicaDTOByIdCnfActUniOrganicaDTO(cnfActUniOrganicaFilter);
		return lista;
	}
	
	
	
}