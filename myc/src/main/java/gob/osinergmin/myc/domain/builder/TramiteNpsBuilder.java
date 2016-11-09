package gob.osinergmin.myc.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.myc.domain.NpsTramite;
import gob.osinergmin.myc.domain.dto.TramiteNpsDTO;

public class TramiteNpsBuilder {
	
	public static TramiteNpsDTO toTramiteNpsDTO(NpsTramite npsTramite){
		TramiteNpsDTO tramiteNpsDTO = new TramiteNpsDTO();
		if(npsTramite!=null){
			if(npsTramite.getIdTramite()!=null){
				tramiteNpsDTO.setIdTramite(npsTramite.getIdTramite());
			}
			if(npsTramite.getDescripcion()!=null){
				tramiteNpsDTO.setDescripcion(npsTramite.getDescripcion());
			}
			if(npsTramite.getEstado()!=null){
				tramiteNpsDTO.setEstado(npsTramite.getEstado());
			}
		}
		return tramiteNpsDTO;
	}
	
	public static NpsTramite toNpsTramite(TramiteNpsDTO tramiteNpsDTO){
		NpsTramite npsTramite = new NpsTramite();
		if(tramiteNpsDTO!=null){
			if(tramiteNpsDTO.getIdTramite()!=null){
				npsTramite.setIdTramite(tramiteNpsDTO.getIdTramite());
			}
			if(tramiteNpsDTO.getDescripcion()!=null){
				npsTramite.setDescripcion(tramiteNpsDTO.getDescripcion());
			}
			if(tramiteNpsDTO.getEstado()!=null){
				npsTramite.setEstado(tramiteNpsDTO.getEstado());
			}
		}
		return npsTramite;
	}
	
	public static List<TramiteNpsDTO> toListTramiteNpsDTO(List<NpsTramite> lista){
		List<TramiteNpsDTO> listaDto = new ArrayList<TramiteNpsDTO>();
		if(lista!=null && lista.size()>0){
			for (NpsTramite npsTramite : lista) {
				TramiteNpsDTO tramiteNpsDTO = toTramiteNpsDTO(npsTramite);
				listaDto.add(tramiteNpsDTO);
			}
		}
		return listaDto;
	}
}
