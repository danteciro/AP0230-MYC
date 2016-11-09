package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;

import java.util.List;


public interface CnfEtapaServiceNeg {

	public List<MaestroColumnaDTO> listarComboResponsable();
	public List<MaestroColumnaDTO> listarComboSector();
	public List<UnidadOrganicaDTO> listarComboUnidad(UnidadOrganicaFilter unidadOrganicaFilter);
	public List<MaestroColumnaDTO> listarComboAgente();
	public List<MaestroColumnaDTO> listarComboResposable();
	public List<MaestroColumnaDTO> listarComboActividad();
	
	
}
