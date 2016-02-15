/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author jpiro
 */
public class ProcTramActividadDTO {
    private Long idProcTramActi;
    private Long idProcedimientoTramite;
    private Long idActividad;
    private String estado;

    public ProcTramActividadDTO(){
    }
    
    public ProcTramActividadDTO(Long idProcedimientoTramite,Long idActividad,String estado){
        this.idProcedimientoTramite=idProcedimientoTramite;
        this.idActividad=idActividad;
        this.estado=estado;
    }

    public Long getIdProcTramActi() {
        return idProcTramActi;
    }

    public void setIdProcTramActi(Long idProcTramActi) {
        this.idProcTramActi = idProcTramActi;
    }
    
    public Long getIdProcedimientoTramite() {
        return idProcedimientoTramite;
    }

    public void setIdProcedimientoTramite(Long idProcedimientoTramite) {
        this.idProcedimientoTramite = idProcedimientoTramite;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
