package gob.osinergmin.myc.domain.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.MdiMaestroTabla;
import gob.osinergmin.myc.domain.MdiMaestroTablaPK;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;

/**
 * Clase para convertir MdiMaestroColumna a MaestroColumnaDTO
 * @author dmedrano
 *
 */
public class MaestroColumnaBuilder {
	
	/**
	 * Convierte MdiMaestroColumna a MaestroColumnaDTO
	 * @param maestroColumna Objeto Dominio a convertir
	 * @return DTO convertido.
	 */
	/**
	 * Convierte MdiMaestroColumna a MaestroColumnaDTO
	 * @param maestroColumna
	 * @param includeMaestroTabla india si convertir el maestro tabla, true para convertir maestro tabla
	 * @return
	 */
	public static MaestroColumnaDTO getMaestroColumnaDTO(MdiMaestroColumna maestroColumna, boolean includeMaestroTabla) {
		MaestroColumnaDTO maestroColumnaDTO = null;
		if(maestroColumna!=null) {
			maestroColumnaDTO = new MaestroColumnaDTO();
			maestroColumnaDTO.setEstado(maestroColumna.getEstado());			
			//evaluando maestro y pk maestro nulos
			if(includeMaestroTabla && maestroColumna.getMdiMaestroTabla()!=null && maestroColumna.getMdiMaestroTabla().getMdiMaestroTablaPK()!=null) {
				maestroColumnaDTO.setAplicacion(maestroColumna.getMdiMaestroTabla().getMdiMaestroTablaPK().getAplicacion());
				maestroColumnaDTO.setDominio(maestroColumna.getMdiMaestroTabla().getMdiMaestroTablaPK().getDominio());
			}
			maestroColumnaDTO.setCodigo(maestroColumna.getCodigo());
			maestroColumnaDTO.setDescripcion(maestroColumna.getDescripcion());
			maestroColumnaDTO.setIdMaestroColumna(maestroColumna.getIdMaestroColumna());	
                        maestroColumnaDTO.setEsEditable(maestroColumna.getEsEditable());
		}
		return maestroColumnaDTO;
	}
	
	/**
	 * Convierte MdiMaestroColumna a MaestroColumnaDTO, tambien trata de convertir maestro tabla
	 * @param maestroColumna Objeto Dominio a convertir
	 * @return DTO convertido.
	 */
	public static MaestroColumnaDTO getMaestroColumnaDTO(MdiMaestroColumna maestroColumna) {
		return getMaestroColumnaDTO(maestroColumna, true);
	}
	
	/**
	 * Convierte lista de MdiMaestroColumna a MaestroColumnaDTO
	 * @param listaMaestroColumna lista MdiMaestroColumna
	 * @return lista MaestroColumnaDTO convertida
	 */
	public static List<MaestroColumnaDTO> getMaestroColumnaDTOList(List<MdiMaestroColumna> listaMaestroColumna) {
            List<MaestroColumnaDTO> listaMaestroColumnaDTO = new ArrayList<MaestroColumnaDTO>();
            if(!CollectionUtils.isEmpty(listaMaestroColumna)) {
                    MaestroColumnaDTO maestroColumnaDTO = null;
                    for(MdiMaestroColumna maestroColumna : listaMaestroColumna) {
                            maestroColumnaDTO = getMaestroColumnaDTO(maestroColumna);
                            listaMaestroColumnaDTO.add(maestroColumnaDTO);
                    }
            }
            return listaMaestroColumnaDTO;
	}
	
	/**
	 * Convierte MaestroColumnaDTO a MdiMaestroColumna
	 * @param maestroColumnaDTO maestro columna a convertir
	 * @return
	 */
	public static MdiMaestroColumna getMdiMaestroColumna(MaestroColumnaDTO maestroColumnaDTO) {
		MdiMaestroColumna maestroColumna = null;
		if(maestroColumnaDTO!=null){
			maestroColumna = new MdiMaestroColumna();
			maestroColumna.setDescripcion(maestroColumnaDTO.getDescripcion());
			maestroColumna.setCodigo(maestroColumnaDTO.getCodigo());
                        if(maestroColumnaDTO.getIdMaestroColumna()!=null){
                            maestroColumna.setIdMaestroColumna(maestroColumnaDTO.getIdMaestroColumna());
                        }			
			maestroColumna.setEstado(maestroColumnaDTO.getEstado());
			MdiMaestroTabla maestroTabla = new MdiMaestroTabla();
			MdiMaestroTablaPK maestroTablaPk = new MdiMaestroTablaPK();
			maestroTablaPk.setAplicacion(maestroColumnaDTO.getAplicacion());
			maestroTablaPk.setDominio(maestroColumnaDTO.getDominio());
			maestroTabla.setMdiMaestroTablaPK(maestroTablaPk);
			maestroColumna.setMdiMaestroTabla(maestroTabla);
		}
		return maestroColumna;
	}
	
	/**
	 * Devuelve un MdiMaestroColumna con solo el Id a partir de un MaestroColumnaDTO
	 * @param maestroColumnaDTO MaestroColumnaDTO origen 
	 * @return MdiMaestroColumna convertido
	 */
	public static MdiMaestroColumna getSimpleMdiMaestroColumna(MaestroColumnaDTO maestroColumnaDTO){
		MdiMaestroColumna maestroColumna = null;
		if(maestroColumnaDTO!=null){
			maestroColumna = new MdiMaestroColumna();
			maestroColumna.setIdMaestroColumna(maestroColumnaDTO.getIdMaestroColumna());			
		}
		return maestroColumna;
	}
}
