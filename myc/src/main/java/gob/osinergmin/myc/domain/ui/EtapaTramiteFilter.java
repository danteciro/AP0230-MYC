/*
* Resumen
* Objeto            : EtapaTramiteFilter.java
* Descripción       : Objeto que realiza tareas de filtrado para EtapaTramite
* Fecha de Creación : 07/11/2016
* PR de Creación    : 
* Autor             : GMD
* =====================================================================================================================================================================
* Modificaciones |
* Motivo         |  Fecha        |   Nombre                     |     Descripción
* =====================================================================================================================================================================
* OSINE_SFS-1232 | 07/11/2016    |   Luis García Reyna          |     Busqueda por filtros
*/

package gob.osinergmin.myc.domain.ui;

/**
 *
 * @author Ubuntu
 */
public class EtapaTramiteFilter {
    
    private Long idGerencia;
    private Long idDivision;
    private Long idSector;
    private Long idActividad;
    private Long idAgente;
    private Long idResponsable;
    private Long idTramite;

    public Long getIdGerencia() {
        return idGerencia;
    }

    public void setIdGerencia(Long idGerencia) {
        this.idGerencia = idGerencia;
    }

    public Long getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Long idDivision) {
        this.idDivision = idDivision;
    }

    public Long getIdSector() {
        return idSector;
    }

    public void setIdSector(Long idSector) {
        this.idSector = idSector;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public Long getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(Long idAgente) {
        this.idAgente = idAgente;
    }

    public Long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Long idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }
    
    
}
