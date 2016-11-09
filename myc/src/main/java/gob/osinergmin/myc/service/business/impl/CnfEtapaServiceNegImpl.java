package gob.osinergmin.myc.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.EtapaFilter;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.business.CnfEtapaServiceNeg;
import gob.osinergmin.myc.service.business.EtapaServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.UnidadOrganicaServiceNeg;
import gob.osinergmin.myc.service.exception.EtapaException;
import gob.osinergmin.myc.util.Constantes;

import org.springframework.stereotype.Service;

@Service("CnfEtapaService")
public class CnfEtapaServiceNegImpl implements CnfEtapaServiceNeg{

	@Inject
	public MaestroColumnaServiceNeg maestroColumnaServiceNeg;
	
	@Inject
	public UnidadOrganicaServiceNeg unidadOrganicaServiceNeg;
	
	@Override
	public List<MaestroColumnaDTO> listarComboResponsable() {
	    List<MaestroColumnaDTO> lista = new ArrayList<MaestroColumnaDTO>(); 
		try {
			lista = maestroColumnaServiceNeg.buscarByDominioByAplicacion( Constantes.RESPONSABLE_DOMINIO ,Constantes.APPLICACION_MYC);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return lista;
	
	}

	@Override
	public List<MaestroColumnaDTO> listarComboSector() {
	    List<MaestroColumnaDTO> lista = new ArrayList<MaestroColumnaDTO>(); 
			try {
				lista = maestroColumnaServiceNeg.buscarByDominioByAplicacion( Constantes.SECTOR_DOMINIO ,Constantes.APPLICACION_MYC);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    return lista;
	}

	@Override
	public List<UnidadOrganicaDTO> listarComboUnidad(UnidadOrganicaFilter unidadOrganicaFilter) {
		List<UnidadOrganicaDTO> lista = new ArrayList<UnidadOrganicaDTO>(); 
		lista = unidadOrganicaServiceNeg.findUnidadOrganica(unidadOrganicaFilter);
		
	
		return null;
	}

	@Override
	public List<MaestroColumnaDTO> listarComboAgente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MaestroColumnaDTO> listarComboResposable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MaestroColumnaDTO> listarComboActividad() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
