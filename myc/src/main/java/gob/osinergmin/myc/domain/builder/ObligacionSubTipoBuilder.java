/**
* Resumen.
* Objeto                            :              ObligacionSubTipoBuilder.java.
* Descripción                   	:              Builder del Objeto PghObligacionSubTipo.
* Fecha de Creación     			:              23/05/2016
* Autor                             :              gvillanueva.
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                              		Fecha                             Nombre                              Descripción
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                     Giancarlo Villanueva                    RSIS25
*/
package gob.osinergmin.myc.domain.builder;
import gob.osinergmin.myc.domain.PghObligacionSubTipo;
import gob.osinergmin.myc.domain.PghObligacionTipo;
import gob.osinergmin.myc.domain.dto.ObligacionSubTipoDTO;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import java.util.ArrayList;
import java.util.List;
public class ObligacionSubTipoBuilder {
	public static PghObligacionSubTipo getObligacionSubTipo(ObligacionSubTipoDTO ObligacionSubTipoDTO){
		PghObligacionSubTipo registro = null;
        if(ObligacionSubTipoDTO != null){
            registro = new PghObligacionSubTipo();
            if(ObligacionSubTipoDTO.getIdObligacionSubTipo() != null){
                registro.setIdObligacionSubTipo(ObligacionSubTipoDTO.getIdObligacionSubTipo());
            }
            registro.setNombre(ObligacionSubTipoDTO.getNombre());
            registro.setEstado(ObligacionSubTipoDTO.getEstado());
            registro.setIdentificadorSeleccion(ObligacionSubTipoDTO.getIdentificadorSeleccion());
            PghObligacionTipo pghObligacionTipo = new PghObligacionTipo();
            pghObligacionTipo.setIdObligacionTipo(ObligacionSubTipoDTO.getIdObligacionTipo().getIdObligacionTipo());
            registro.setIdObligacionTipo(pghObligacionTipo);
        }
        return registro;
    }
    
    public static List<ObligacionSubTipoDTO> toListObligacionSubTipoDto(List<PghObligacionSubTipo> lista) {
    	ObligacionSubTipoDTO registroDTO;
        List<ObligacionSubTipoDTO> retorno = new ArrayList<ObligacionSubTipoDTO>();
        if (lista != null) {
            for (PghObligacionSubTipo maestro : lista) {
                registroDTO = toObligacionSubTipoDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    }
    
    public static ObligacionSubTipoDTO toObligacionSubTipoDto(PghObligacionSubTipo registro) {
    	ObligacionSubTipoDTO registroDTO = new ObligacionSubTipoDTO();
        
        registroDTO.setIdObligacionSubTipo(registro.getIdObligacionSubTipo());
        registroDTO.setNombre(registro.getNombre());
        registroDTO.setEstado(registro.getEstado());
        registroDTO.setIdentificadorSeleccion(registro.getIdentificadorSeleccion());
        if(registro.getIdObligacionTipo()!=null && registro.getIdObligacionTipo().getIdObligacionTipo()!=null){
        	ObligacionTipoDTO obligacionTipo = new ObligacionTipoDTO();
            obligacionTipo.setIdObligacionTipo(registro.getIdObligacionTipo().getIdObligacionTipo());
            registroDTO.setIdObligacionTipo(obligacionTipo);
        }
        
        return registroDTO;
    }
}
