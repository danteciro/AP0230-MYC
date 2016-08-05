/**
* Resumen.
* Objeto                            :              UnidadObligacionSubTipoBuilder.java.
* Descripción                   	:              Builder del Objeto PghUnidObliSubtipo.
* Fecha de Creación     			:              23/05/2016
* Autor                             :              gvillanueva.
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                              		Fecha                             Nombre                              Descripción
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                     Giancarlo Villanueva                    RSIS25
*/
package gob.osinergmin.myc.domain.builder;
import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.MdiUnidadSupervisada;
import gob.osinergmin.myc.domain.PghObligacionSubTipo;
import gob.osinergmin.myc.domain.PghUnidObliSubTipo;
import gob.osinergmin.myc.domain.dto.ObligacionSubTipoDTO;
import gob.osinergmin.myc.domain.dto.UnidadObliSubTipoDTO;
import gob.osinergmin.myc.domain.dto.UnidadSupervisadaDTO;

public class UnidadObligacionSubTipoBuilder {

	public static PghUnidObliSubTipo getObligacionSubTipo(UnidadObliSubTipoDTO registroDTO) {
		PghUnidObliSubTipo registroDAO = null;
		if(registroDTO!=null){
			registroDAO = new PghUnidObliSubTipo();
			if(registroDTO.getIdUnidObliSubtipo()!=null){
				registroDAO.setIdUnidObliSubTipo(registroDTO.getIdUnidObliSubtipo());
			}
			if(registroDTO.getEstado()!=null){
				registroDAO.setEstado(registroDTO.getEstado());
			}
			/* Inicio: OSINE_SFS-480 - RSIS27 - Inicio */
			MdiMaestroColumna muestral = new MdiMaestroColumna();
			muestral.setIdMaestroColumna(new Long(registroDTO.getTipoSeleccion()));
			registroDAO.setTipoSeleccion(muestral);
			/* Inicio: OSINE_SFS-480 - RSIS25 - Fin */
			registroDAO.setPeriodo(registroDTO.getPeriodo());
			if(registroDTO.getIdUnidadSupervisada()!=null && registroDTO.getIdUnidadSupervisada().getIdUnidadSupervisada()!=null){
				MdiUnidadSupervisada idUnidadSupervisada = new MdiUnidadSupervisada();
				idUnidadSupervisada.setIdUnidadSupervisada(registroDTO.getIdUnidadSupervisada().getIdUnidadSupervisada());
				registroDAO.setIdUnidadSupervisada(idUnidadSupervisada);
			}
			
			if(registroDTO.getIdObligacionSubTipo()!=null && registroDTO.getIdObligacionSubTipo().getIdObligacionSubTipo()!=null){
				PghObligacionSubTipo idObligacionSubTipo = new PghObligacionSubTipo();
				idObligacionSubTipo.setIdObligacionSubTipo(registroDTO.getIdObligacionSubTipo().getIdObligacionSubTipo());
				registroDAO.setIdObligacionSubTipo(idObligacionSubTipo);
			}
			registroDAO.setFlagSupOrdenServicio(registroDTO.getFlagSupOrdenServicio());/* OSINE_SFS-480 - RSIS27 */
			
		}
		return registroDAO;
	}
	
	public static List<UnidadObliSubTipoDTO> toListUnidadObligacionSubTipoDto(List<PghUnidObliSubTipo> lista) {
		UnidadObliSubTipoDTO registroDTO;
        List<UnidadObliSubTipoDTO> retorno = new ArrayList<UnidadObliSubTipoDTO>();
        if (lista != null) {
            for (PghUnidObliSubTipo maestro : lista) {
                registroDTO = toObligacionSubTipoDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    }

	public static UnidadObliSubTipoDTO toObligacionSubTipoDto(PghUnidObliSubTipo registroDAO) {
		UnidadObliSubTipoDTO registroDTO = null;
		if(registroDAO!=null){
			registroDTO = new UnidadObliSubTipoDTO();
			if(registroDAO.getIdUnidObliSubTipo()!=null){
				registroDTO.setIdUnidObliSubtipo(registroDAO.getIdUnidObliSubTipo());
			}
			if(registroDAO.getEstado()!=null){
				registroDTO.setEstado(registroDAO.getEstado());
			}			
			registroDTO.setTipoSeleccion(registroDAO.getTipoSeleccion().getIdMaestroColumna().toString());/* OSINE_SFS-480 - RSIS27 - gvillanueva*/
			registroDTO.setPeriodo(registroDAO.getPeriodo());
			if(registroDAO.getIdObligacionSubTipo()!=null && registroDAO.getIdObligacionSubTipo().getIdObligacionSubTipo()!=null){
				ObligacionSubTipoDTO idObligacionSubTipo = new ObligacionSubTipoDTO();
				idObligacionSubTipo.setIdObligacionSubTipo(registroDAO.getIdObligacionSubTipo().getIdObligacionSubTipo());
				registroDTO.setIdObligacionSubTipo(idObligacionSubTipo);
			}
			if(registroDAO.getIdUnidadSupervisada()!=null && registroDAO.getIdUnidadSupervisada().getIdUnidadSupervisada()!=null){
				UnidadSupervisadaDTO idUnidadSupervisada = new UnidadSupervisadaDTO();
				idUnidadSupervisada.setIdUnidadSupervisada(registroDAO.getIdUnidadSupervisada().getIdUnidadSupervisada());
				registroDTO.setIdUnidadSupervisada(idUnidadSupervisada);
			}
			registroDTO.setFlagSupOrdenServicio(registroDAO.getFlagSupOrdenServicio());/* OSINE_SFS-480 - RSIS27 - gvillanueva */
		}
		return registroDTO;
	}

}
