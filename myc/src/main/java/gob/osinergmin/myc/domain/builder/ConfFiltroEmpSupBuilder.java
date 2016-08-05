package gob.osinergmin.myc.domain.builder;
import gob.osinergmin.myc.domain.PghConfFiltroEmpSup;
import gob.osinergmin.myc.domain.dto.ConfFiltroEmpSupDTO;
import java.util.ArrayList;
import java.util.List;
/**
*
* @author mdiosesf
*/
public class ConfFiltroEmpSupBuilder {

	public static List<ConfFiltroEmpSupDTO> toListConfFiltroEmpSupDto(List<PghConfFiltroEmpSup> lista) {
		List<ConfFiltroEmpSupDTO> retorno = new ArrayList<ConfFiltroEmpSupDTO>();
		if (lista != null) {
			ConfFiltroEmpSupDTO registroDTO;
            for (PghConfFiltroEmpSup registro : lista) {
            	registroDTO = new ConfFiltroEmpSupDTO();
            	registroDTO.setIdFiltro(registro.getIdFiltro());
            	registroDTO.setIdFiltroEmpSup(registro.getIdFiltroEmpSup());
            	registroDTO.setIdUnidadOrganica(registro.getIdUnidadOrganica());  
            	registroDTO.setEstado(registro.getEstado());
                retorno.add(registroDTO);
            }
		}
		return retorno;	
	}
	
	public static ConfFiltroEmpSupDTO toConfFiltroEmpSupDto(PghConfFiltroEmpSup registro) {
		ConfFiltroEmpSupDTO retorno = new ConfFiltroEmpSupDTO();
		if (registro != null) {            
			retorno = new ConfFiltroEmpSupDTO();
			retorno.setIdFiltro(registro.getIdFiltro());
			retorno.setIdFiltroEmpSup(registro.getIdFiltroEmpSup());
			retorno.setIdUnidadOrganica(registro.getIdUnidadOrganica());    
			retorno.setEstado(registro.getEstado());
		}
		return retorno;	
	}
	
	public static PghConfFiltroEmpSup toConfFiltroEmpSupTabla(ConfFiltroEmpSupDTO registro) {
		PghConfFiltroEmpSup retorno = new PghConfFiltroEmpSup();
		if(registro!=null){ 
			retorno.setIdFiltro(registro.getIdFiltro());
			retorno.setIdFiltroEmpSup(registro.getIdFiltroEmpSup());
			retorno.setIdUnidadOrganica(registro.getIdUnidadOrganica());
			retorno.setEstado(registro.getEstado());
		}  
		return retorno;	
	}
}
