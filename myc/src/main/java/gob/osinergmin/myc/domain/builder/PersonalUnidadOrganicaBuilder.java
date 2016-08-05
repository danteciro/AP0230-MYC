package gob.osinergmin.myc.domain.builder;
import gob.osinergmin.myc.domain.PghPersonalUnidadOrganica;
import gob.osinergmin.myc.domain.dto.PersonalUnidadOrganicaDTO;
import java.util.ArrayList;
import java.util.List;
/**
*
* @author mdiosesf
*/
public class PersonalUnidadOrganicaBuilder {

	public static List<PersonalUnidadOrganicaDTO> toListPersonalUnidadOrganicaDto(List<PghPersonalUnidadOrganica> lista) {
		PersonalUnidadOrganicaDTO registroDTO;
        List<PersonalUnidadOrganicaDTO> retorno = new ArrayList<PersonalUnidadOrganicaDTO>();
        if(lista != null && lista.size()>0) {
            for (PghPersonalUnidadOrganica maestro : lista) {
                registroDTO = toPersonalUnidadOrganicaDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static PersonalUnidadOrganicaDTO toPersonalUnidadOrganicaDto(PghPersonalUnidadOrganica registro) {
    	PersonalUnidadOrganicaDTO registroDTO = new PersonalUnidadOrganicaDTO();        
    	registroDTO.setIdPersonalUnidadOrganica(registro.getIdPersonalUnidadOrganica());
        
    	return registroDTO;
    }	
}
