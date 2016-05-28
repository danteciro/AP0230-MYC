/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_TIPO_SUPERVISION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghTipoSupervision.findAll", query = "SELECT p FROM PghTipoSupervision p"),
    @NamedQuery(name = "PghTipoSupervision.findByIdTipoSupervision", query = "SELECT p FROM PghTipoSupervision p WHERE p.idTipoSupervision = :idTipoSupervision"),
    @NamedQuery(name = "PghTipoSupervision.findByEstado", query = "SELECT p FROM PghTipoSupervision p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghTipoSupervision.findByUsuarioCreacion", query = "SELECT p FROM PghTipoSupervision p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghTipoSupervision.findByFechaCreacion", query = "SELECT p FROM PghTipoSupervision p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghTipoSupervision.findByTerminalCreacion", query = "SELECT p FROM PghTipoSupervision p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghTipoSupervision.findByUsuarioActualizacion", query = "SELECT p FROM PghTipoSupervision p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghTipoSupervision.findByFechaActualizacion", query = "SELECT p FROM PghTipoSupervision p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghTipoSupervision.findByTerminalActualizacion", query = "SELECT p FROM PghTipoSupervision p WHERE p.terminalActualizacion = :terminalActualizacion"),
    @NamedQuery(name = "PghTipoSupervision.findByDescripcion", query = "SELECT p FROM PghTipoSupervision p WHERE p.descripcion = :descripcion")})
public class PghTipoSupervision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_SUPERVISION")
    private Long idTipoSupervision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private char estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 38)
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 38)
    @Column(name = "TERMINAL_CREACION")
    private String terminalCreacion;
    @Size(max = 38)
    @Column(name = "USUARIO_ACTUALIZACION")
    private String usuarioActualizacion;
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Size(max = 38)
    @Column(name = "TERMINAL_ACTUALIZACION")
    private String terminalActualizacion;
    @Size(max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_PROCESO", referencedColumnName = "ID_PROCESO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghProceso idProceso;

    public PghTipoSupervision() {
    }

    public PghTipoSupervision(Long idTipoSupervision) {
        this.idTipoSupervision = idTipoSupervision;
    }

    public PghTipoSupervision(Long idTipoSupervision, char estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idTipoSupervision = idTipoSupervision;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdTipoSupervision() {
        return idTipoSupervision;
    }

    public void setIdTipoSupervision(Long idTipoSupervision) {
        this.idTipoSupervision = idTipoSupervision;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTerminalCreacion() {
        return terminalCreacion;
    }

    public void setTerminalCreacion(String terminalCreacion) {
        this.terminalCreacion = terminalCreacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getTerminalActualizacion() {
        return terminalActualizacion;
    }

    public void setTerminalActualizacion(String terminalActualizacion) {
        this.terminalActualizacion = terminalActualizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PghProceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(PghProceso idProceso) {
        this.idProceso = idProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSupervision != null ? idTipoSupervision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghTipoSupervision)) {
            return false;
        }
        PghTipoSupervision other = (PghTipoSupervision) object;
        if ((this.idTipoSupervision == null && other.idTipoSupervision != null) || (this.idTipoSupervision != null && !this.idTipoSupervision.equals(other.idTipoSupervision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghTipoSupervision[ idTipoSupervision=" + idTipoSupervision + " ]";
    }
    
}
