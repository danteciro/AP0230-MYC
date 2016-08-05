/**
* Resumen.
* Objeto                            	:              ObligacionSubTipoServiceNeg.java.
* Descripción                   		:              Interface del Objeto ObligacionSubTipoServiceNegImpl.
* Fecha de Creación     				:              23/05/2016
* Autor                               	:              gvillanueva.
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                                  	Fecha                             Nombre                              Descripción
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                        gvillanueva                   			RSIS25
*/
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ObligacionSubTipoDTO;
import gob.osinergmin.myc.domain.ui.ObligacionSubTipoFilter;

import java.util.List;

public interface ObligacionSubTipoServiceNeg {

	List<ObligacionSubTipoDTO> listarObligacionesSubTipo(ObligacionSubTipoFilter filtro);

 }
