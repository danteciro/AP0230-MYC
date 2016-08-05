package gob.osinergmin.myc.service.dao;

import java.util.List;

import gob.osinergmin.myc.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.myc.domain.ui.UnidadSupervisadaFilter;

public interface UnidadSupervisadaDAO {
	public Long contarUnidadSupervisadaxActividad(UnidadSupervisadaFilter filtro);
	public Long contarUnidadSupervisadaxActividadxEstrato(UnidadSupervisadaFilter filtro);
	public Long contarUnidadSupervisadaxActividadxEstratoDistrito(UnidadSupervisadaFilter filtro);
	public Long contarUnidadSupervisadaxActividadxEstratoProvincia(UnidadSupervisadaFilter filtro);
	public Long contarUnidadSupervisadaxActividadxEstratoDepartamento(UnidadSupervisadaFilter filtro);
	public List<UnidadSupervisadaDTO> listarUnidadSupervisadaxActividadxEstratoDepartamento(UnidadSupervisadaFilter filtro);
	public List<UnidadSupervisadaDTO> listarUnidadSupervisadaxActividadxEstratoDistrito(UnidadSupervisadaFilter filtro);
	public List<UnidadSupervisadaDTO> listarUnidadSupervisadaxActividadxEstratoProvincia(UnidadSupervisadaFilter filtro);
}
