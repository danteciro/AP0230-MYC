/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 *
 * @author dmedrano
 * 
 */
@Embeddable
public class MdiMaestroTablaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DOMINIO", nullable = false, length = 20)
    private String dominio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "APLICACION", nullable = false, length = 25)
    private String aplicacion;

    public MdiMaestroTablaPK() {
    }

    public MdiMaestroTablaPK(String dominio, String aplicacion) {
        this.dominio = dominio;
        this.aplicacion = aplicacion;
    }
    
    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dominio != null ? dominio.hashCode() : 0);
        hash += (aplicacion != null ? aplicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiMaestroTablaPK)) {
            return false;
        }
        MdiMaestroTablaPK other = (MdiMaestroTablaPK) object;
        if ((this.dominio == null && other.dominio != null) || (this.dominio != null && !this.dominio.equals(other.dominio))) {
            return false;
        }
        if ((this.aplicacion == null && other.aplicacion != null) || (this.aplicacion != null && !this.aplicacion.equals(other.aplicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.mdiws.domain.MdiMaestroTablaPK[ dominio=" + dominio + ", aplicacion=" + aplicacion + " ]";
    }
    
}
