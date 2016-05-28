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
@Table(name = "PGH_HST_REQUISITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghHstRequisito.findAll", query = "SELECT p FROM PghHstRequisito p"),
    @NamedQuery(name = "PghHstRequisito.findByIdHstRequisito", query = "SELECT p FROM PghHstRequisito p WHERE p.idHstRequisito = :idHstRequisito"),
    @NamedQuery(name = "PghHstRequisito.findByDescripcion", query = "SELECT p FROM PghHstRequisito p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PghHstRequisito.findByComentarioPredeterminado", query = "SELECT p FROM PghHstRequisito p WHERE p.comentarioPredeterminado = :comentarioPredeterminado"),
    @NamedQuery(name = "PghHstRequisito.findByIdDocumentoAdjunto", query = "SELECT p FROM PghHstRequisito p WHERE p.idDocumentoAdjunto = :idDocumentoAdjunto"),
    @NamedQuery(name = "PghHstRequisito.findByEstado", query = "SELECT p FROM PghHstRequisito p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghHstRequisito.findByUsuarioCreacion", query = "SELECT p FROM PghHstRequisito p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghHstRequisito.findByFechaCreacion", query = "SELECT p FROM PghHstRequisito p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghHstRequisito.findByTerminalCreacion", query = "SELECT p FROM PghHstRequisito p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghHstRequisito.findByUsuarioActualizacion", query = "SELECT p FROM PghHstRequisito p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghHstRequisito.findByFechaActualizacion", query = "SELECT p FROM PghHstRequisito p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghHstRequisito.findByTerminalActualizacion", query = "SELECT p FROM PghHstRequisito p WHERE p.terminalActualizacion = :terminalActualizacion")})
public class PghHstRequisito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HST_REQUISITO")
    private Long idHstRequisito;
    @Size(max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 1500)
    @Column(name = "COMENTARIO_PREDETERMINADO")
    private String comentarioPredeterminado;
    @Column(name = "ID_DOCUMENTO_ADJUNTO")
    private Long idDocumentoAdjunto;
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
    @JoinColumn(name = "ID_REQUISITO", referencedColumnName = "ID_REQUISITO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghRequisito idRequisito;

    public PghHstRequisito() {
    }

    public PghHstRequisito(Long idHstRequisito) {
        this.idHstRequisito = idHstRequisito;
    }

    public PghHstRequisito(Long idHstRequisito, char estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idHstRequisito = idHstRequisito;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdHstRequisito() {
        return idHstRequisito;
    }

    public void setIdHstRequisito(Long idHstRequisito) {
        this.idHstRequisito = idHstRequisito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentarioPredeterminado() {
        return comentarioPredeterminado;
    }

    public void setComentarioPredeterminado(String comentarioPredeterminado) {
        this.comentarioPredeterminado = comentarioPredeterminado;
    }

    public Long getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }

    public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
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

    public PghRequisito getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(PghRequisito idRequisito) {
        this.idRequisito = idRequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHstRequisito != null ? idHstRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghHstRequisito)) {
            return false;
        }
        PghHstRequisito other = (PghHstRequisito) object;
        if ((this.idHstRequisito == null && other.idHstRequisito != null) || (this.idHstRequisito != null && !this.idHstRequisito.equals(other.idHstRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghHstRequisito[ idHstRequisito=" + idHstRequisito + " ]";
    }
    
}
