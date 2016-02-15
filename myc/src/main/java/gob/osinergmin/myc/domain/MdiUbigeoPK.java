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
import javax.validation.constraints.Size;

/**
 *
 * @author jpiro
 */
@Embeddable
public class MdiUbigeoPK implements Serializable {
    /*@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "ID_DEPARTAMENTO")
    private String idDepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "ID_PROVINCIA")
    private String idProvincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "ID_DISTRITO")
    private String idDistrito;*/
    
    @Basic(optional = false)
    @Column(name = "ID_DEPARTAMENTO", nullable = false, length = 2)
    private String idDepartamento;
    @Basic(optional = false)
    @Column(name = "ID_PROVINCIA", nullable = false, length = 2)
    private String idProvincia;
    @Basic(optional = false)
    @Column(name = "ID_DISTRITO", nullable = false, length = 2)
    private String idDistrito;

    public MdiUbigeoPK() {
    }

    public MdiUbigeoPK(String idDepartamento, String idProvincia, String idDistrito) {
        this.idDepartamento = idDepartamento;
        this.idProvincia = idProvincia;
        this.idDistrito = idDistrito;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(String idDistrito) {
        this.idDistrito = idDistrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartamento != null ? idDepartamento.hashCode() : 0);
        hash += (idProvincia != null ? idProvincia.hashCode() : 0);
        hash += (idDistrito != null ? idDistrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiUbigeoPK)) {
            return false;
        }
        MdiUbigeoPK other = (MdiUbigeoPK) object;
        if ((this.idDepartamento == null && other.idDepartamento != null) || (this.idDepartamento != null && !this.idDepartamento.equals(other.idDepartamento))) {
            return false;
        }
        if ((this.idProvincia == null && other.idProvincia != null) || (this.idProvincia != null && !this.idProvincia.equals(other.idProvincia))) {
            return false;
        }
        if ((this.idDistrito == null && other.idDistrito != null) || (this.idDistrito != null && !this.idDistrito.equals(other.idDistrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.MdiUbigeoPK[ idDepartamento=" + idDepartamento + ", idProvincia=" + idProvincia + ", idDistrito=" + idDistrito + " ]";
    }
    
}
