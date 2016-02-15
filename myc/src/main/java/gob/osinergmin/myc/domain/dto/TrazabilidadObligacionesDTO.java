/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

import java.util.Date;

/**
 *
 * @author jpiro
 */
public class TrazabilidadObligacionesDTO {
    private Date fechaVigencia;
    private String codTrazabilidad;
    private Long idTrazabilidad;

    public Long getIdTrazabilidad() {
        return idTrazabilidad;
    }

    public void setIdTrazabilidad(Long idTrazabilidad) {
        this.idTrazabilidad = idTrazabilidad;
    }
    
    public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }
}
