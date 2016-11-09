package gob.osinergmin.myc.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.MdiUnidadOrganica;
import gob.osinergmin.myc.domain.NpsConfTramite;
import gob.osinergmin.myc.domain.NpsTramite;
import gob.osinergmin.myc.domain.PghCnfActUniOrganica;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.CnfActUniOrganicaDTO;
import gob.osinergmin.myc.domain.dto.ConfTramiteDTO;
import gob.osinergmin.myc.domain.dto.TramiteNpsDTO;

public class ConfTramiteNpsBuilder {
	
	public static ConfTramiteDTO toNpsConfTramiteDTO(NpsConfTramite npsConfTramite){
  	  ConfTramiteDTO npsConfTramiteDTO = new ConfTramiteDTO();
		if(npsConfTramite!=null){
			if(npsConfTramite.getEstado()!=null){
				npsConfTramiteDTO.setEstado(npsConfTramite.getEstado());
			}
			if(npsConfTramite.getIdCnfActUniOrganica()!=null && npsConfTramite.getIdCnfActUniOrganica().getIdCnfActUniOrganica()!=null){
				CnfActUniOrganicaDTO cnfActUniOrganica = new CnfActUniOrganicaDTO();
				cnfActUniOrganica.setIdCnfActUniOrganica(npsConfTramite.getIdCnfActUniOrganica().getIdCnfActUniOrganica());
					MdiUnidadOrganica mdiUnidadOrganica = new MdiUnidadOrganica();
				if(npsConfTramite.getIdCnfActUniOrganica().getIdUnidadOrganica()!=null){
					mdiUnidadOrganica.setDescripcion(npsConfTramite.getIdCnfActUniOrganica().getIdUnidadOrganica().getDescripcion());
					mdiUnidadOrganica.setIdUnidadOrganica(npsConfTramite.getIdCnfActUniOrganica().getIdUnidadOrganica().getIdUnidadOrganica());
					mdiUnidadOrganica.setIdUnidadOrganicaSuperior(npsConfTramite.getIdCnfActUniOrganica().getIdUnidadOrganica().getIdUnidadOrganicaSuperior());
					cnfActUniOrganica.setIdUnidadOrganica(mdiUnidadOrganica);
				}
				if( npsConfTramite.getIdCnfActUniOrganica().getIdActividad()!=null){
					MdiActividad mdiActividad = new MdiActividad();
					mdiActividad.setNombre(npsConfTramite.getIdCnfActUniOrganica().getIdActividad().getNombre());
					cnfActUniOrganica.setIdActividad(mdiActividad);
				}
				npsConfTramiteDTO.setIdCnfActUniOrganica(cnfActUniOrganica);
			}
			if(npsConfTramite.getIdConfTramite()!=null){
				npsConfTramiteDTO.setIdConfTramite(npsConfTramite.getIdConfTramite());
			}
			
			if(npsConfTramite.getIdTramite() !=null){
				TramiteNpsDTO npsTramite = new TramiteNpsDTO();
					npsTramite.setIdTramite(npsConfTramite.getIdTramite().getIdTramite());
					npsTramite.setDescripcion(npsConfTramite.getIdTramite().getDescripcion());
				npsConfTramiteDTO.setIdTramite(npsTramite);
			}
			if(npsConfTramite.getOrientacion()!=null){
				npsConfTramiteDTO.setOrientacion(npsConfTramite.getOrientacion());
			}
			if(npsConfTramite.getPorcentajeNotificacion()!=null){
				npsConfTramiteDTO.setPorcentajeNotificacion(npsConfTramite.getPorcentajeNotificacion());
			}
			
		}
		return npsConfTramiteDTO;		
	}
	
	
	public static NpsConfTramite toNpsConfTramite(ConfTramiteDTO npsConfTramiteDTO){
		NpsConfTramite npsConfTramite = new NpsConfTramite();
		if(npsConfTramiteDTO!=null){
			if(npsConfTramiteDTO.getEstado()!=null){
				npsConfTramite.setEstado(npsConfTramiteDTO.getEstado());
			}
			if(npsConfTramiteDTO.getIdCnfActUniOrganica()!=null && npsConfTramiteDTO.getIdCnfActUniOrganica()!=null){
				PghCnfActUniOrganica pghCnfActUniOrganica = new PghCnfActUniOrganica();
				pghCnfActUniOrganica.setIdCnfActUniOrganica(npsConfTramiteDTO.getIdCnfActUniOrganica().getIdCnfActUniOrganica());
				npsConfTramite.setIdCnfActUniOrganica(pghCnfActUniOrganica);
			}
			if(npsConfTramiteDTO.getIdConfTramite()!=null){
				npsConfTramite.setIdConfTramite(npsConfTramiteDTO.getIdConfTramite());
			}
			if(npsConfTramiteDTO.getIdTramite() !=null){
				NpsTramite npsTramite = new NpsTramite();
				npsTramite.setIdTramite(npsConfTramiteDTO.getIdTramite().getIdTramite());
				npsConfTramite.setIdTramite(npsTramite);
			}
			if(npsConfTramiteDTO.getOrientacion()!=null){
				npsConfTramite.setOrientacion(npsConfTramiteDTO.getOrientacion());
			}
			if(npsConfTramiteDTO.getPorcentajeNotificacion()!=null){
				npsConfTramite.setPorcentajeNotificacion(npsConfTramiteDTO.getPorcentajeNotificacion());
			}
			
		}
		return npsConfTramite;		
	}
	
	public static List<ConfTramiteDTO> toListConfTramiteDTO(List<NpsConfTramite> lista){
		List<ConfTramiteDTO> listaDTO = new ArrayList<ConfTramiteDTO>();
		ConfTramiteDTO confTramiteDTO = new ConfTramiteDTO();
		for (NpsConfTramite npsConfTramite : lista) {
			 confTramiteDTO = toNpsConfTramiteDTO(npsConfTramite);
			 listaDTO.add(confTramiteDTO);
		}
		return listaDTO;
	}
}
