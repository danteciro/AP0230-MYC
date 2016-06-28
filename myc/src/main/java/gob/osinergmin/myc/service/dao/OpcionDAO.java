/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.OpcionFilter;
import gob.osinergmin.myc.service.exception.ActividadException;

import java.util.List;

/**
* Resumen.
* Objeto                   : OpcionDAO.java 
* Descripción              : DAO para el uso del modulo de rubroOpcion.
* Fecha de Creación        : 26/05/2016
* PR de Modificacion       : OSINE_119
* Autor                    : Juan Sifuentes Acosta.
* ---------------------------------------------------------------------------------------
* Modificaciones
* Motivo       Fecha       Nombre                 Descripcion
* ----------------------------------------------------------------------------------------
 */

public interface OpcionDAO {
    public List<OpcionDTO> find(OpcionFilter filtro) throws ActividadException;
    public Long count(OpcionFilter filtro) throws ActividadException;
	public Long findIdentificadorOpcion(OpcionFilter filtro)throws ActividadException;
}
