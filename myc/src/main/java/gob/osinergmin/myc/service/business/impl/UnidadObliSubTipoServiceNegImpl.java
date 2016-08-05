package gob.osinergmin.myc.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.domain.dto.UnidadObliSubTipoDTO;
import gob.osinergmin.myc.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.business.UnidadObliSubTipoServiceNeg;
import gob.osinergmin.myc.service.dao.UnidadObliSubTipoDAO;

@Service("unidadObliSubTipoServiceNeg")
public class UnidadObliSubTipoServiceNegImpl implements UnidadObliSubTipoServiceNeg {
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(UnidadObliSubTipoServiceNegImpl.class);
	
	@Inject
	private UnidadObliSubTipoDAO unidadObliSubTipoDAO;
	
	@Override
	
	public UnidadObliSubTipoDTO guardarUnidadMuestral(UnidadObliSubTipoDTO unidadObliSubTipo,UsuarioDTO usuarioDTO) {
		UnidadObliSubTipoDTO unidad = null;
		try {
			unidad = unidadObliSubTipoDAO.guardarUnidadMuestral(unidadObliSubTipo,usuarioDTO);
			
		} catch (Exception e) {
			LOG.error("Error guardarUnidadMuestral",e);
		}
		
		return unidad;
	}

	@Override
	@Transactional
	public List<UnidadObliSubTipoDTO> guardarUnidadMuestral(List<UnidadSupervisadaDTO> listaUnidadSupervisada,UsuarioDTO usuarioDTO, UnidadObliSubTipoDTO unidadObliSubTipo) {
		List<UnidadObliSubTipoDTO> listaUnidades = null;
		UnidadObliSubTipoDTO unidad;
		try {
			if(listaUnidadSupervisada!=null){
				listaUnidades = new ArrayList<UnidadObliSubTipoDTO>();
				for(UnidadSupervisadaDTO unidadSupervisadaMuestral:listaUnidadSupervisada){
					UnidadSupervisadaDTO idUnidadSupervisada = new UnidadSupervisadaDTO();
			    	idUnidadSupervisada.setIdUnidadSupervisada(unidadSupervisadaMuestral.getIdUnidadSupervisada());
			    	unidadObliSubTipo.setIdUnidadSupervisada(idUnidadSupervisada);					
					unidad = unidadObliSubTipoDAO.guardarUnidadMuestral(unidadObliSubTipo,usuarioDTO);
					listaUnidades.add(unidad);
				}
			}
					
			
		} catch (Exception e) {
			LOG.error("Error guardarUnidadMuestral",e);
		}
		
		return listaUnidades;		
		
	}

	@Override
	@Transactional
	public List<UnidadObliSubTipoDTO> listarPruebaMuestralxPeriodoxSubTipo(UnidadObliSubTipoDTO filtroPruebaMuestral) {
		List<UnidadObliSubTipoDTO> lista = null;
		try {
			lista = unidadObliSubTipoDAO.listarPruebaMuestralxPeriodoxSubTipo(filtroPruebaMuestral);
			
		} catch (Exception e) {
			LOG.error("Error listarUnidadMuestral",e);
		}
		
		return lista;
	}
	
	
}
