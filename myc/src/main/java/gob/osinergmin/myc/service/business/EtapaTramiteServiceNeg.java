/*
* Resumen
* Objeto            : EtapaTramiteServiceNeg.java
* Descripción       : Clase Interfaz de la capa de negocio que contiene la declaración de métodos a implementarse en el EtapaTramiteServiceNegImpl
* Fecha de Creación : 07/11/2016
* PR de Creación    : 
* Autor             : GMD
* =====================================================================================================================================================================
* Modificaciones |
* Motivo         |  Fecha        |   Nombre                     |     Descripción
* =====================================================================================================================================================================
* OSINE_SFS-1232 | 07/11/2016    |   Luis García Reyna          |     Busqueda por filtros
*/

package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.EtapaTramiteDTO;
import gob.osinergmin.myc.domain.ui.EtapaTramiteFilter;
import java.util.List;

/**
 *
 * @author lgarciar
 */
public interface EtapaTramiteServiceNeg {

    public List<EtapaTramiteDTO> listarEtapaTramite(EtapaTramiteFilter filtro);
    
}
