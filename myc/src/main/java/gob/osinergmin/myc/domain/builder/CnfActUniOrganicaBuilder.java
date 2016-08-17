package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.MdiUnidadOrganica;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;

import java.util.ArrayList;
import java.util.List;

public class CnfActUniOrganicaBuilder {

	public static List<ActividadDTO> toListActividadxUnidadOrganicaDto(List<MdiActividad> lista) {
		ActividadDTO actividadDTO;
        List<ActividadDTO> listaActvidadDTO = new ArrayList<ActividadDTO>();
        if (lista != null) {
            for (MdiActividad maestro : lista) {
                actividadDTO = toActividadDto(maestro); 
                listaActvidadDTO.add(actividadDTO);
            }
        }
        return listaActvidadDTO;
	}

	private static ActividadDTO toActividadDto(MdiActividad maestro) {
		ActividadDTO actividadDTO = new ActividadDTO();
		actividadDTO.setIdActividad(maestro.getIdActividad());
		actividadDTO.setNombre(maestro.getNombre());
		actividadDTO.setCodigo(maestro.getCodigo());
		actividadDTO.setEstado(maestro.getEstado());        
        return  actividadDTO;
	}

}
