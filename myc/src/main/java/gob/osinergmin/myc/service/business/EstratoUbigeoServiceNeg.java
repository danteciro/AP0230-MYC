/**
* Resumen.
* Objeto                            	:              EstratoUbigeoServiceNeg.java.
* Descripción                   		:              Interface del Objeto EstratoUbigeoServiceNegImpl.
* Fecha de Creación     				:              23/05/2016
* Autor                               	:              gvillanueva.
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                                  	Fecha                             Nombre                              Descripción
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                        gvillanueva                   			RSIS25
*/
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.EstratoUbigeoDTO;

import java.util.List;

public interface EstratoUbigeoServiceNeg {

	List<EstratoUbigeoDTO> listarEstratoUbigeo();

}
