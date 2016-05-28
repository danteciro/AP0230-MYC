/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.component;

import gob.osinergmin.myc.domain.Auditoria;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author jpiro
 */
@MappedSuperclass
public class ColumAddObligaciones extends Auditoria {
    @Column(name = "ID_PADRE")
    protected Long idPadre;
    @Column(name = "COD_TRAZABILIDAD")
    protected String codTrazabilidad;

    public Long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Long idPadre) {
        this.idPadre = idPadre;
    }

    public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
    }
}
