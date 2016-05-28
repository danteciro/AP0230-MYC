/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author jpiro
 */
public class AutoayudaDTO {
    private Long idAutoayuda;
    private String nombreAutoayuda;
    private String identificadorAutoayuda;
    private String estado;
    private String descripcionAutoayuda;

    public String getDescripcionAutoayuda() {
        return descripcionAutoayuda;
    }

    public void setDescripcionAutoayuda(String descripcionAutoayuda) {
        this.descripcionAutoayuda = descripcionAutoayuda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    public Long getIdAutoayuda() {
        return idAutoayuda;
    }

    public void setIdAutoayuda(Long idAutoayuda) {
        this.idAutoayuda = idAutoayuda;
    }

    public String getNombreAutoayuda() {
        return nombreAutoayuda;
    }

    public void setNombreAutoayuda(String nombreAutoayuda) {
        this.nombreAutoayuda = nombreAutoayuda;
    }

    public String getIdentificadorAutoayuda() {
        return identificadorAutoayuda;
    }

    public void setIdentificadorAutoayuda(String identificadorAutoayuda) {
        this.identificadorAutoayuda = identificadorAutoayuda;
    }
    
}
