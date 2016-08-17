/**
* Resumen		
* Objeto		: PghCargo.java
* Descripción		: DTO para PersonalUnidadOrganica.
* Fecha de Creación	: 13/06/2016
* PR de Creación	: OSINE_SFS-480
* Autor			: Julio Piro
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                          Descripción
* ---------------------------------------------------------------------------------------------------
* 
*/ 

package gob.osinergmin.myc.domain.dto;

public class PersonalUnidadOrganicaDTO {
    private Long idPersonalUnidadOrganica;
    private UnidadOrganicaDTO unidadOrganica;
    private String flagDefault;
    private String estado;

    public Long getIdPersonalUnidadOrganica() {
        return idPersonalUnidadOrganica;
    }

    public void setIdPersonalUnidadOrganica(Long idPersonalUnidadOrganica) {
        this.idPersonalUnidadOrganica = idPersonalUnidadOrganica;
    }

    public UnidadOrganicaDTO getUnidadOrganica() {
        return unidadOrganica;
    }

    public void setUnidadOrganica(UnidadOrganicaDTO unidadOrganica) {
        this.unidadOrganica = unidadOrganica;
    }

    public String getFlagDefault() {
        return flagDefault;
    }

    public void setFlagDefault(String flagDefault) {
        this.flagDefault = flagDefault;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
