/*
* Resumen
* Objeto            : EtapaTramiteDTO.java
* Descripción       : Objeto que transporta datos de EtapaTramite
* Fecha de Creación : 07/11/2016
* PR de Creación    : 
* Autor             : GMD
* =====================================================================================================================================================================
* Modificaciones |
* Motivo         |  Fecha        |   Nombre                     |     Descripción
* =====================================================================================================================================================================
* OSINE_SFS-1232 | 07/11/2016    |   Luis García Reyna          |     Busqueda por filtros
*/

package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author lgarciar
 */
public class EtapaTramiteDTO {
    
    private Long idEtapaTramite;
    private Long idEtapa;
    private Long idConfTramite;
    private TramiteNpsDTO tramite;
    private EtapaNpsDTO etapa;
    private ActividadDTO actividad;
    private Long idResponsable;

    public Long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Long idResponsable) {
        this.idResponsable = idResponsable;
    }
    private Long countSubEtapa;
    

    public Long getCountSubEtapa() {
        return countSubEtapa;
    }

    public void setCountSubEtapa(Long countSubEtapa) {
        this.countSubEtapa = countSubEtapa;
    }

    public ActividadDTO getActividad() {
        return actividad;
    }

    public void setActividad(ActividadDTO actividad) {
        this.actividad = actividad;
    }

    public EtapaNpsDTO getEtapa() {
        return etapa;
    }

    public void setEtapa(EtapaNpsDTO etapa) {
        this.etapa = etapa;
    }

    public TramiteNpsDTO getTramite() {
        return tramite;
    }

    public void setTramite(TramiteNpsDTO tramite) {
        this.tramite = tramite;
    }
    

    private String estado;

    public Long getIdEtapaTramite() {
        return idEtapaTramite;
    }

    public void setIdEtapaTramite(Long idEtapaTramite) {
        this.idEtapaTramite = idEtapaTramite;
    }

    public Long getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Long idEtapa) {
        this.idEtapa = idEtapa;
    }

    public Long getIdConfTramite() {
        return idConfTramite;
    }

    public void setIdConfTramite(Long idConfTramite) {
        this.idConfTramite = idConfTramite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
