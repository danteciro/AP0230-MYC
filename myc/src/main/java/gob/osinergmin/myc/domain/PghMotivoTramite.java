/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_MOTIVO_TRAMITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghMotivoTramite.findAll", query = "SELECT p FROM PghMotivoTramite p where estado=:estado"),
    @NamedQuery(name = "PghMotivoTramite.findByIdTramite", query = "SELECT p FROM PghMotivoTramite p where p.estado=:estado and p.idTramite.idTramite=:idTramite")
})
public class PghMotivoTramite extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MOTIVO_TRAMITE")
    private Long idMotivoTramite;
    @Size(max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_TRAMITE", referencedColumnName = "ID_TRAMITE")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghTramite idTramite;

    public PghMotivoTramite() {
    }

    public PghMotivoTramite(Long idMotivoTramite) {
        this.idMotivoTramite = idMotivoTramite;
    }

    public PghMotivoTramite(Long idMotivoTramite, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idMotivoTramite = idMotivoTramite;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdMotivoTramite() {
        return idMotivoTramite;
    }

    public void setIdMotivoTramite(Long idMotivoTramite) {
        this.idMotivoTramite = idMotivoTramite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PghTramite getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(PghTramite idTramite) {
        this.idTramite = idTramite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotivoTramite != null ? idMotivoTramite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghMotivoTramite)) {
            return false;
        }
        PghMotivoTramite other = (PghMotivoTramite) object;
        if ((this.idMotivoTramite == null && other.idMotivoTramite != null) || (this.idMotivoTramite != null && !this.idMotivoTramite.equals(other.idMotivoTramite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghMotivoTramite[ idMotivoTramite=" + idMotivoTramite + " ]";
    }
    
}
