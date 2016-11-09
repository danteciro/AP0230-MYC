package gob.osinergmin.myc.domain.builder;
import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.MdiUnidadOrganica;
import gob.osinergmin.myc.domain.PghCnfActUniOrganica;
import gob.osinergmin.myc.domain.PghObligacionTipo;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.CnfActUniOrganicaDTO;


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

	/* OSINE_SFS-1232 - REQF- - Inicio */
	
	public static List<CnfActUniOrganicaDTO> toListCnfActUniOrganicaDTO(List<PghCnfActUniOrganica> lista) {
		CnfActUniOrganicaDTO cnfActUniOrganicaDTO;
        List<CnfActUniOrganicaDTO> listaCnfActUniOrganicaDTO = new ArrayList<CnfActUniOrganicaDTO>();
        if (lista != null) {
            for (PghCnfActUniOrganica registro : lista) {
            	cnfActUniOrganicaDTO = toCnfActUniOrganicaDTO(registro); 
            	listaCnfActUniOrganicaDTO.add(cnfActUniOrganicaDTO);
            }
        }
        return listaCnfActUniOrganicaDTO;
	}

	
	
	private static CnfActUniOrganicaDTO toCnfActUniOrganicaDTO( PghCnfActUniOrganica pghCnfActUniOrganica){
		CnfActUniOrganicaDTO cnfActUniOrganicaDTO = new CnfActUniOrganicaDTO();
		if( pghCnfActUniOrganica!=null){
			if(pghCnfActUniOrganica.getIdCnfActUniOrganica()!=null){
				cnfActUniOrganicaDTO.setIdCnfActUniOrganica(pghCnfActUniOrganica.getIdCnfActUniOrganica());
			}
			if(pghCnfActUniOrganica.getIdActividad()!=null){
				cnfActUniOrganicaDTO.setIdActividad(pghCnfActUniOrganica.getIdActividad());
			}
			if(pghCnfActUniOrganica.getIdObligacionTipo()!=null){
				PghObligacionTipo pghObligacionTipo = new PghObligacionTipo();
				pghObligacionTipo.setIdObligacionTipo(pghCnfActUniOrganica.getIdObligacionTipo().getIdObligacionTipo());
				cnfActUniOrganicaDTO.setIdObligacionTipo(pghObligacionTipo);
			}
			if(pghCnfActUniOrganica.getIdUnidadOrganica()!=null){
			    MdiUnidadOrganica mdiUnidadOrganica = new MdiUnidadOrganica();
			    mdiUnidadOrganica.setIdUnidadOrganica(pghCnfActUniOrganica.getIdCnfActUniOrganica());
			    cnfActUniOrganicaDTO.setIdUnidadOrganica(mdiUnidadOrganica);
			}
			if(pghCnfActUniOrganica.getEstado()!=null){
				cnfActUniOrganicaDTO.setEstado(pghCnfActUniOrganica.getEstado());
			}
		}
		return cnfActUniOrganicaDTO;
	}
	
	/* OSINE_SFS-1232 - REQF- - Fin */
	
	private static ActividadDTO toActividadDto(MdiActividad maestro) {
		ActividadDTO actividadDTO = new ActividadDTO();
		actividadDTO.setIdActividad(maestro.getIdActividad());
		actividadDTO.setNombre(maestro.getNombre());
		actividadDTO.setCodigo(maestro.getCodigo());
		actividadDTO.setEstado(maestro.getEstado());        
        return  actividadDTO;
	}

}
