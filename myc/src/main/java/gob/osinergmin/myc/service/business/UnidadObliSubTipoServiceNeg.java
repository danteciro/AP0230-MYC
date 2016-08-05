/**
* Resumen.
* Objeto                            	:              UnidadObliSubTipoServiceNeg.java.
* Descripción                   		:              Interface del Objeto UnidadObliSubTipoServiceNegImpl.
* Fecha de Creación     				:              23/05/2016
* Autor                               	:              gvillanueva.
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                                  	Fecha                             Nombre                              Descripción
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                        gvillanueva                   			RSIS25
*/
package gob.osinergmin.myc.service.business;

import java.util.List;

import gob.osinergmin.myc.domain.dto.UnidadObliSubTipoDTO;
import gob.osinergmin.myc.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;

public interface UnidadObliSubTipoServiceNeg {

	UnidadObliSubTipoDTO guardarUnidadMuestral(UnidadObliSubTipoDTO unidadObliSubTipo, UsuarioDTO usuarioDTO);

	List<UnidadObliSubTipoDTO> guardarUnidadMuestral(List<UnidadSupervisadaDTO> listaUnidadSupervisada,UsuarioDTO usuarioDTO, UnidadObliSubTipoDTO unidadObliSubTipo);

	List<UnidadObliSubTipoDTO> listarPruebaMuestralxPeriodoxSubTipo(UnidadObliSubTipoDTO filtroPruebaMuestral);

}
