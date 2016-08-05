/**
* Resumen		
* Objeto		: PghCargo.java
* Descripción		: Filter para PersonalUnidadOrganica.
* Fecha de Creación	: 13/06/2016
* PR de Creación	: OSINE_SFS-480
* Autor			: Julio Piro
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                          Descripción
* ---------------------------------------------------------------------------------------------------
* 
*/ 

package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

public class PersonalUnidadOrganicaFilter extends BasePaginatorFilter {
    private Long idPersonalUnidadOrganica;
    private Long idUnidadOrganica;

    public PersonalUnidadOrganicaFilter() {
    }

    public PersonalUnidadOrganicaFilter(Long idPersonalUnidadOrganica, Long idUnidadOrganica) {
        this.idPersonalUnidadOrganica = idPersonalUnidadOrganica;
        this.idUnidadOrganica = idUnidadOrganica;
    }

    public Long getIdPersonalUnidadOrganica() {
        return idPersonalUnidadOrganica;
    }

    public void setIdPersonalUnidadOrganica(Long idPersonalUnidadOrganica) {
        this.idPersonalUnidadOrganica = idPersonalUnidadOrganica;
    }

    public Long getIdUnidadOrganica() {
        return idUnidadOrganica;
    }

    public void setIdUnidadOrganica(Long idUnidadOrganica) {
        this.idUnidadOrganica = idUnidadOrganica;
    }
}
