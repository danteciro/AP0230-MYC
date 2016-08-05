/**
* Resumen.
* Objeto                            :              UnidadSupervisadaBuilder.java.
* Descripción                   	:              Builder del Objeto MdiUnidadSupervisada.
* Fecha de Creación     			:              23/05/2016
* Autor                             :              gvillanueva.
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                              		Fecha                             Nombre                              Descripción
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                     Giancarlo Villanueva                    RSIS25
*/
package gob.osinergmin.myc.domain.builder;
import gob.osinergmin.myc.domain.MdiUnidadSupervisada;
import gob.osinergmin.myc.domain.dto.UnidadSupervisadaDTO;
import java.util.ArrayList;
import java.util.List;
public class UnidadSupervisadaBuilder {

	public static List<UnidadSupervisadaDTO> toListUnidadSupervisadaDto(List<MdiUnidadSupervisada> lista) {
		UnidadSupervisadaDTO registroDTO;
        List<UnidadSupervisadaDTO> retorno = new ArrayList<UnidadSupervisadaDTO>();
        if (lista != null) {
            for (MdiUnidadSupervisada maestro : lista) {
                registroDTO = toUnidadSupervisadaDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
	}

	private static UnidadSupervisadaDTO toUnidadSupervisadaDto(MdiUnidadSupervisada maestro) {
		UnidadSupervisadaDTO registroDTO = new UnidadSupervisadaDTO();
		registroDTO.setIdUnidadSupervisada(maestro.getIdUnidadSupervisada());
		return registroDTO;
	}

}
