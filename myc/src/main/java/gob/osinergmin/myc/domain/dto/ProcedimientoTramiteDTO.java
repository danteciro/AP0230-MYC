/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author jpiro
 */
public class ProcedimientoTramiteDTO {
    private Long idProcedimientoTramite;
    private Long idProcedimiento;
    private Long idTramite;
    private String estado;
    private String descTramite;
    
    public ProcedimientoTramiteDTO(){
    }
    
    public ProcedimientoTramiteDTO(Long idProcedimiento, Long idTramite, String estado){
        this.idProcedimiento=idProcedimiento;
        this.idTramite=idTramite;
        this.estado=estado;
    }

    public String getDescTramite() {
        return descTramite;
    }

    public void setDescTramite(String descTramite) {
        this.descTramite = descTramite;
    }

    public Long getIdProcedimientoTramite() {
        return idProcedimientoTramite;
    }

    public void setIdProcedimientoTramite(Long idProcedimientoTramite) {
        this.idProcedimientoTramite = idProcedimientoTramite;
    }

    public Long getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
