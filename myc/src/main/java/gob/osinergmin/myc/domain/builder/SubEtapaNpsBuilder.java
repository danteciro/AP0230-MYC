package gob.osinergmin.myc.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.NpsEtapa;
import gob.osinergmin.myc.domain.NpsSubetapa;
import gob.osinergmin.myc.domain.dto.EtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.SubEtapaNpsDTO;

public class SubEtapaNpsBuilder {
	
	 public static NpsSubetapa toSubEtapaNps(SubEtapaNpsDTO subEtapaNpsDTO){
		 NpsSubetapa npsSubetapa = new NpsSubetapa();
		 	if(subEtapaNpsDTO!=null){
		 		if(subEtapaNpsDTO.getDescripcion()!=null){
		 			npsSubetapa.setDescripcion(subEtapaNpsDTO.getDescripcion());
		 		}
		 		if(subEtapaNpsDTO.getEstado()!=null){
		 			npsSubetapa.setEstado(subEtapaNpsDTO.getEstado());
		 		}
		 		if(subEtapaNpsDTO.getIdEtapa()!=null && subEtapaNpsDTO.getIdEtapa().getIdEtapa()!=null){
		 			NpsEtapa npsEtapa = new NpsEtapa();
		 			npsEtapa.setIdEtapa(subEtapaNpsDTO.getIdEtapa().getIdEtapa());
		 			npsSubetapa.setIdEtapa(npsEtapa);
		 		}
		 		if(subEtapaNpsDTO.getIdEtapa()!=null){
		 			npsSubetapa.setIdSubetapa(subEtapaNpsDTO.getIdSubetapa());
		 		}
		 		if(subEtapaNpsDTO.getTiempoDias()!=null){
		 			npsSubetapa.setTiempoDias(subEtapaNpsDTO.getTiempoDias());
		 		}
		 		if(subEtapaNpsDTO.getIdResponsable()!=null && subEtapaNpsDTO.getIdResponsable().getIdMaestroColumna()!=null){
		 			MdiMaestroColumna maestroColumna = new MdiMaestroColumna();
		 			maestroColumna.setIdMaestroColumna(subEtapaNpsDTO.getIdResponsable().getIdMaestroColumna());
		 			maestroColumna.setDescripcion(subEtapaNpsDTO.getIdResponsable().getDescripcion());
		 			npsSubetapa.setIdResponsable(maestroColumna);
		 		}
		 	}
		 return npsSubetapa;
	 }
	 
	 public static SubEtapaNpsDTO toSubEtapaNpsDTO(NpsSubetapa npsSubetapa){
		 SubEtapaNpsDTO subEtapaNpsDTO = new SubEtapaNpsDTO();
		if(npsSubetapa!=null){
			if(npsSubetapa!=null){
				if(npsSubetapa.getDescripcion()!=null){
					subEtapaNpsDTO.setDescripcion(npsSubetapa.getDescripcion());
				}
				if(npsSubetapa.getEstado()!=null){
					subEtapaNpsDTO.setEstado(npsSubetapa.getEstado());
				}
				if(npsSubetapa.getIdEtapa()!=null && npsSubetapa.getIdEtapa().getIdEtapa()!=null){
					EtapaNpsDTO etapaNpsDTO = new EtapaNpsDTO();
					etapaNpsDTO.setIdEtapa(npsSubetapa.getIdEtapa().getIdEtapa());
					etapaNpsDTO.setDescripcion(npsSubetapa.getIdEtapa().getDescripcion());
					subEtapaNpsDTO.setIdEtapa(etapaNpsDTO);
				}
				if(npsSubetapa.getIdSubetapa()!=null){
					subEtapaNpsDTO.setIdSubetapa(npsSubetapa.getIdSubetapa());
				}
			    if(npsSubetapa.getTiempoDias()!=null){
					subEtapaNpsDTO.setTiempoDias(npsSubetapa.getTiempoDias());
				}
				if(npsSubetapa.getIdResponsable()!=null && npsSubetapa.getIdResponsable().getIdMaestroColumna()!=null ){
					MaestroColumnaDTO maestroColumnaDTO = new MaestroColumnaDTO();
					maestroColumnaDTO.setIdMaestroColumna(npsSubetapa.getIdResponsable().getIdMaestroColumna());
					maestroColumnaDTO.setDescripcion(npsSubetapa.getIdResponsable().getDescripcion());
					subEtapaNpsDTO.setIdResponsable(maestroColumnaDTO);
				}
			}
		}
		 return subEtapaNpsDTO;
	 }
	 
	 public static List<SubEtapaNpsDTO> toListSubEtapaDTO(List<NpsSubetapa> lista){
		 List<SubEtapaNpsDTO> listaDto = new ArrayList<SubEtapaNpsDTO>();
		 SubEtapaNpsDTO subEtapaNpsDTO = new SubEtapaNpsDTO();
		 if(lista!=null && lista.size()>0){
			 for (NpsSubetapa npsSubetapa : lista) {
				 	subEtapaNpsDTO = toSubEtapaNpsDTO(npsSubetapa);
				 	listaDto.add(subEtapaNpsDTO);
			 }
		 }
		 return listaDto;
	 }
	 /* OSINE_SFS-1232 - RSIS 6 - Inicio */
		public static List<SubEtapaNpsDTO> listObjectToListSubEtapaDTO(List<Object[]> resultado) {
			List<SubEtapaNpsDTO> retorno = new ArrayList<SubEtapaNpsDTO>();
			if(resultado!=null){
				SubEtapaNpsDTO proceso;
				for(Object[] obj:resultado){
					proceso = new SubEtapaNpsDTO();
						 long l1 = Math.round(((Number) obj[0]).doubleValue());					 
					proceso.setIdSubetapa(l1);
					proceso.setDescripcion(obj[1].toString());
					proceso.setEstado(obj[2].toString());
						long l2 = Math.round(((Number) obj[3]).doubleValue());
						String str1 = String.valueOf(l2);
						short s1 =Short.valueOf(str1);
					proceso.setTiempoDias(new Long(obj[3].toString()));
						long l3 = Math.round(((Number) obj[4]).doubleValue());	
						EtapaNpsDTO etapaNpsDTO = new EtapaNpsDTO();
						etapaNpsDTO.setIdEtapa(l3);
					proceso.setIdEtapa(etapaNpsDTO);
						MaestroColumnaDTO maestroColumnaDTO = new MaestroColumnaDTO();
						long l4 = Math.round(((Number) obj[5]).doubleValue());
						maestroColumnaDTO.setIdMaestroColumna(l4);
					proceso.setIdResponsable(maestroColumnaDTO);
					retorno.add(proceso);

				}
			}
			return retorno;
		}
		/* OSINE_SFS-1232 - RSIS 4 - Fin */
	 
}
