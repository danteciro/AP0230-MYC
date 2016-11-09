package gob.osinergmin.myc.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.myc.domain.NpsEtapa;
import gob.osinergmin.myc.domain.PghProceso;
import gob.osinergmin.myc.domain.dto.EtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;

public class EtapaNpsBuilder {

	public static EtapaNpsDTO toEtapaNpsDTO(NpsEtapa npsEtapa){
		EtapaNpsDTO etapaNpsDTO = new EtapaNpsDTO();
		if(npsEtapa!=null){
			if(npsEtapa.getDescripcion()!=null){
				etapaNpsDTO.setDescripcion(npsEtapa.getDescripcion());
			}
			if(npsEtapa.getIdEtapa()!=null){
				etapaNpsDTO.setIdEtapa(npsEtapa.getIdEtapa());
			}
			if(npsEtapa.getEstado()!=null){
				etapaNpsDTO.setEstado(npsEtapa.getEstado());
			}
			if(npsEtapa.getIdProceso()!=null && npsEtapa.getIdProceso().getIdProceso()!=null){
				ProcesoDTO procesoDTO = new ProcesoDTO();
				procesoDTO.setIdProceso(npsEtapa.getIdProceso().getIdProceso());
				etapaNpsDTO.setIdProceso(procesoDTO);
			}
			if(npsEtapa.getPlazo()!=null){
				etapaNpsDTO.setPlazo(npsEtapa.getPlazo());
			}
		}
		return etapaNpsDTO;
	}
	
	
	public static List<EtapaNpsDTO> toListEtapaDTO(List<NpsEtapa> lista){
		EtapaNpsDTO etapaNpsDTO = new EtapaNpsDTO();
		List<EtapaNpsDTO> listaDto = new ArrayList<EtapaNpsDTO>();
		if(lista!=null && lista.size()>0){
			for (NpsEtapa npsEtapa : lista) {
				etapaNpsDTO = toEtapaNpsDTO(npsEtapa);
				listaDto.add(etapaNpsDTO);
			}	
		}
		return listaDto;
	}
	
	
	public static NpsEtapa toNpsEtapa(EtapaNpsDTO etapaNpsDTO){
		NpsEtapa npsEtapa = new NpsEtapa();
		if(etapaNpsDTO!=null){
			if(etapaNpsDTO.getDescripcion()!=null){
				npsEtapa.setDescripcion(etapaNpsDTO.getDescripcion());
			}
			if(etapaNpsDTO.getEstado()!=null){
				npsEtapa.setEstado(etapaNpsDTO.getEstado());
			}
			if(etapaNpsDTO.getIdProceso()!=null && etapaNpsDTO.getIdProceso().getIdProceso()!=null){
				PghProceso pghProceso = new PghProceso();
				pghProceso.setIdProceso(etapaNpsDTO.getIdProceso().getIdProceso());
				npsEtapa.setIdProceso(pghProceso);
			}
			if(etapaNpsDTO.getPlazo()!=null){
				npsEtapa.setPlazo(etapaNpsDTO.getPlazo());
			}
			if(etapaNpsDTO.getIdEtapa()!=null){
				npsEtapa.setIdEtapa(etapaNpsDTO.getIdEtapa());
			}
		}
		
		return npsEtapa;
	}
	
	
	
}
