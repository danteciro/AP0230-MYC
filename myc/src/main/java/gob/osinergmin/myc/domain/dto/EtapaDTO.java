/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author jpiro
 */
public class EtapaDTO {
    private Long idEtapa;
    private Long idProceso;
    private String descripcion;
    private String estado;
    private String proceso;

    private Long nroTram;
    private Long nroAct;

    public Long getNroTram() {
        return nroTram;
    }

    public void setNroTram(Long nroTram) {
        this.nroTram = nroTram;
    }

    public Long getNroAct() {
        return nroAct;
    }

    public void setNroAct(Long nroAct) {
        this.nroAct = nroAct;
    }
    
    public Long getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Long idEtapa) {
        this.idEtapa = idEtapa;
    }

    public Long getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Long idProceso) {
        this.idProceso = idProceso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if(descripcion!=null){
            this.descripcion = descripcion.toUpperCase();
        }else{
            this.descripcion = descripcion;
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }
}
