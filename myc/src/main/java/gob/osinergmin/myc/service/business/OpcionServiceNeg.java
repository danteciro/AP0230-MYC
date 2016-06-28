/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.ui.OpcionFilter;

import java.util.List;

/**
* Resumen.
* Objeto                   : OpcionServiceNeg.java 
* Descripción              : Service para el uso del modulo de rubroOpcion.
* Fecha de Creación        : 26/05/2016
* PR de Modificacion       : OSINE_119
* Autor                    : Juan Sifuentes Acosta.
* ---------------------------------------------------------------------------------------
* Modificaciones
* Motivo       Fecha       Nombre                 Descripcion
* ----------------------------------------------------------------------------------------
 */

public interface OpcionServiceNeg {
	/**
	 * Metodo para listar opciones mediante un filtro
	 * @param filtro
	 */
    public List<OpcionDTO> findOpcionByFilter(OpcionFilter filtro);
	public Long obtenerIdTipoSupervision();
}
