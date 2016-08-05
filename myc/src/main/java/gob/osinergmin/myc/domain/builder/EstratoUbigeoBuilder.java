/**
* Resumen.
* Objeto                            :              EstratoUbigeoBuilder.java.
* Descripción                   	:              Builder del Objeto PghEstratoUbigeo.
* Fecha de Creación     			:              23/05/2016
* Autor                             :              gvillanueva.
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                              		Fecha                             Nombre                              Descripción
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                     Giancarlo Villanueva                    RSIS25
*/
package gob.osinergmin.myc.domain.builder;
import gob.osinergmin.myc.domain.PghEstratoUbigeo;
import gob.osinergmin.myc.domain.dto.EstratoUbigeoDTO;
import java.util.ArrayList;
import java.util.List;
public class EstratoUbigeoBuilder {

	public static List<EstratoUbigeoDTO> toListEstratoUbigeoDto(List<PghEstratoUbigeo> lista) {
		EstratoUbigeoDTO registroDTO;
		List<EstratoUbigeoDTO> retorno = new ArrayList<EstratoUbigeoDTO>();
		if(lista != null){
			for(PghEstratoUbigeo maestro: lista){
				registroDTO = toEstratoUbigeoDto(maestro);
				retorno.add(registroDTO);
			}
		}
		return retorno;
	}

	private static EstratoUbigeoDTO toEstratoUbigeoDto(PghEstratoUbigeo maestro) {
		EstratoUbigeoDTO registroDTO = new EstratoUbigeoDTO();
		if(maestro!=null){
                    registroDTO.setIdEstratoUbigeo(maestro.getIdEstratoUbigeo());
                    registroDTO.setEstado(maestro.getEstado());	
                    if(maestro.getIdEstrato()!=null && maestro.getIdEstrato().getIdEstrato()!=null){
                    	registroDTO.setIdEstrato(maestro.getIdEstrato().getIdEstrato());
                    }
                    if(maestro.getMdiUbigeo()!=null && maestro.getMdiUbigeo().getMdiUbigeoPK()!=null){
                        registroDTO.setDepartamento(maestro.getMdiUbigeo().getMdiUbigeoPK().getIdDepartamento());
                        registroDTO.setProvincia(maestro.getMdiUbigeo().getMdiUbigeoPK().getIdProvincia());
                        registroDTO.setDistrito(maestro.getMdiUbigeo().getMdiUbigeoPK().getIdDistrito());
                    }
		}
		return registroDTO;
	}



}
