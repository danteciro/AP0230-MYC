package gob.osinergmin.myc.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.NpsConfTramite;
import gob.osinergmin.myc.domain.NpsEtapa;
import gob.osinergmin.myc.domain.NpsEtapaTramite;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.CnfActUniOrganicaDTO;
import gob.osinergmin.myc.domain.dto.ConfTramiteDTO;
import gob.osinergmin.myc.domain.dto.EtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.EtapaTramiteDTO;
import gob.osinergmin.myc.domain.dto.EtapaTramiteNpsDTO;
import gob.osinergmin.myc.domain.dto.TramiteNpsDTO;

/* OSINE_SFS-1232 - lgarciar - Inicio */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* OSINE_SFS-1232 - lgarciar - Fin */

public class EtapaTramiteBuilder {
private static final Logger LOG = LoggerFactory.getLogger(EtapaTramiteBuilder.class);
	public static NpsEtapaTramite toNpsEtapaTramite(EtapaTramiteNpsDTO etapaTramiteNpsDTO){
		NpsEtapaTramite npsEtapaTramite = new NpsEtapaTramite();
		if(etapaTramiteNpsDTO!=null){
			if(etapaTramiteNpsDTO.getIdEtapa()!=null && etapaTramiteNpsDTO.getIdEtapa().getIdEtapa()!=null){
				NpsEtapa npsEtapa = new NpsEtapa();
				npsEtapa.setIdEtapa(etapaTramiteNpsDTO.getIdEtapa().getIdEtapa());
				npsEtapaTramite.setIdEtapa(npsEtapa);
			}
			
			if(etapaTramiteNpsDTO.getIdEtapaTramite()!=null){
				npsEtapaTramite.setIdEtapaTramite(etapaTramiteNpsDTO.getIdEtapaTramite());
			}
			
			if(etapaTramiteNpsDTO.getIdConfTramite()!=null){
				NpsConfTramite npsConfTramite = new NpsConfTramite();
				npsConfTramite.setIdConfTramite(etapaTramiteNpsDTO.getIdConfTramite().getIdConfTramite());
				npsEtapaTramite.setIdConfTramite(npsConfTramite);
			}
			if(etapaTramiteNpsDTO.getEstado()!=null){
				npsEtapaTramite.setEstado(etapaTramiteNpsDTO.getEstado());
			}
		}
		
		return npsEtapaTramite;
	}
	
	public static EtapaTramiteNpsDTO toEtapaTramiteDTO(NpsEtapaTramite npsEtapaTramite){
		EtapaTramiteNpsDTO etapaTramiteNpsDTO = new EtapaTramiteNpsDTO();
		if(npsEtapaTramite!=null){
			if(npsEtapaTramite.getIdEtapaTramite()!=null){
				etapaTramiteNpsDTO.setIdEtapaTramite(npsEtapaTramite.getIdEtapaTramite());
			}
			if(npsEtapaTramite.getIdEtapa()!=null){
				EtapaNpsDTO etapaNpsDTO = new EtapaNpsDTO();
				etapaNpsDTO.setIdEtapa(npsEtapaTramite.getIdEtapa().getIdEtapa());
				etapaNpsDTO.setDescripcion(npsEtapaTramite.getIdEtapa().getDescripcion());
				etapaNpsDTO.setPlazo(npsEtapaTramite.getIdEtapa().getPlazo());
				etapaTramiteNpsDTO.setIdEtapa(etapaNpsDTO);
			}
			if(npsEtapaTramite.getIdConfTramite()!=null){
				ConfTramiteDTO confTramiteDTO = new ConfTramiteDTO();
				confTramiteDTO.setIdConfTramite(npsEtapaTramite.getIdConfTramite().getIdConfTramite());
					TramiteNpsDTO tramiteNpsDTO = new TramiteNpsDTO();
					tramiteNpsDTO.setDescripcion(npsEtapaTramite.getIdConfTramite().getIdTramite().getDescripcion());
					tramiteNpsDTO.setIdTramite(npsEtapaTramite.getIdConfTramite().getIdTramite().getIdTramite());
				confTramiteDTO.setIdTramite(tramiteNpsDTO);
				
				CnfActUniOrganicaDTO cnfActUniOrganicaDTO = new CnfActUniOrganicaDTO();
					MdiActividad mdiActividad = new MdiActividad();
					mdiActividad.setNombre(npsEtapaTramite.getIdConfTramite().getIdCnfActUniOrganica().getIdActividad().getNombre());
					
				cnfActUniOrganicaDTO.setIdActividad(mdiActividad);
				
				confTramiteDTO.setIdCnfActUniOrganica(cnfActUniOrganicaDTO);
				
				etapaTramiteNpsDTO.setIdConfTramite(confTramiteDTO);
			}
			if(npsEtapaTramite.getEstado()!=null){
				etapaTramiteNpsDTO.setEstado(npsEtapaTramite.getEstado());
			}
			
		}
		return etapaTramiteNpsDTO;
	}
	
	public static List<EtapaTramiteNpsDTO> toListEtapaTramiteDTO(List<NpsEtapaTramite> listaEtapaTramite){
		List<EtapaTramiteNpsDTO> listaDto = new ArrayList<EtapaTramiteNpsDTO>();
		for (NpsEtapaTramite npsEtapaTramite : listaEtapaTramite) {
			EtapaTramiteNpsDTO etapaTramiteNpsDTO = EtapaTramiteBuilder.toEtapaTramiteDTO(npsEtapaTramite);
			listaDto.add(etapaTramiteNpsDTO);
		}
		return listaDto;
	}
        
        public static List<EtapaTramiteDTO> toListaEtapaTramiteDTO(List<NpsEtapaTramite> lista) {
        EtapaTramiteDTO registroDTO;
        List<EtapaTramiteDTO> retorno = new ArrayList<EtapaTramiteDTO>();
        if (lista != null) {
            for (NpsEtapaTramite maestro : lista) {
                registroDTO = toEtapaTramiteDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    public static EtapaTramiteDTO toEtapaTramiteDto(NpsEtapaTramite registro) {
        EtapaTramiteDTO registroDTO = new EtapaTramiteDTO();
        if(registro!=null){

            if(registro.getIdEtapaTramite()!= null){                
                registroDTO.setIdEtapaTramite(registro.getIdEtapaTramite());
            }
            
            if(registro.getIdConfTramite()!= null && registro.getIdConfTramite().getIdConfTramite()!=null){                
                registroDTO.setIdConfTramite(registro.getIdConfTramite().getIdConfTramite());
            }
            
            if(registro.getIdConfTramite().getIdTramite()!=null){
                TramiteNpsDTO tramiteNpsDTO = new TramiteNpsDTO();
                tramiteNpsDTO.setIdTramite(registro.getIdConfTramite().getIdTramite().getIdTramite());
                tramiteNpsDTO.setDescripcion(registro.getIdConfTramite().getIdTramite().getDescripcion());
                registroDTO.setTramite(tramiteNpsDTO);
            }
            
            if(registro.getIdEtapa()!= null && registro.getIdEtapa().getIdEtapa()!=null){
                EtapaNpsDTO etapaNpsDTO = new EtapaNpsDTO();
                etapaNpsDTO.setIdEtapa(registro.getIdEtapa().getIdEtapa());
                etapaNpsDTO.setDescripcion(registro.getIdEtapa().getDescripcion());
                etapaNpsDTO.setPlazo(registro.getIdEtapa().getPlazo());
                registroDTO.setEtapa(etapaNpsDTO);
            }
            
            if(registro.getIdConfTramite().getIdCnfActUniOrganica().getIdActividad()!=null){
                ActividadDTO actividadDTO = new ActividadDTO();
                actividadDTO.setIdActividad(registro.getIdConfTramite().getIdCnfActUniOrganica().getIdActividad().getIdActividad());
                actividadDTO.setNombre(registro.getIdConfTramite().getIdCnfActUniOrganica().getIdActividad().getNombre());
                registroDTO.setActividad(actividadDTO);                           
            }
            registroDTO.setIdResponsable(registro.getIdResponsable());
            registroDTO.setCountSubEtapa(registro.getCountSubEtapa());
            
                                                     
        }
        
        return registroDTO;
    }
    
        
}
