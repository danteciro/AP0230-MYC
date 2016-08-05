/**
* Resumen		
* Objeto		: PghCargo.java
* Descripción		: Interface capa Service para PersonalUnidadOrganica.
* Fecha de Creación	: 13/06/2016
* PR de Creación	: OSINE_SFS-480
* Autor			: Julio Piro
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                          Descripción
* ---------------------------------------------------------------------------------------------------
* 
*/ 

package gob.osinergmin.myc.service.business;
import gob.osinergmin.myc.domain.dto.PersonalUnidadOrganicaDTO;
import gob.osinergmin.myc.domain.ui.PersonalUnidadOrganicaFilter;
import gob.osinergmin.myc.service.exception.PersonalUnidadOrganicaException;
import java.util.List;

public interface PersonalUnidadOrganicaServiceNeg {
	public List<PersonalUnidadOrganicaDTO> findbyFilter(PersonalUnidadOrganicaFilter filtro) throws PersonalUnidadOrganicaException;
}