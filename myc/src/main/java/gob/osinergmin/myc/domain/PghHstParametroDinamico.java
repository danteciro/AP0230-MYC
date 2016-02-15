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
@Table(name = "PGH_HST_PARAMETRO_DINAMICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghHstParametroDinamico.findAll", query = "SELECT p FROM PghHstParametroDinamico p"),
    @NamedQuery(name = "PghHstParametroDinamico.findByIdHstParamaetroDinamico", query = "SELECT p FROM PghHstParametroDinamico p WHERE p.idHstParamaetroDinamico = :idHstParamaetroDinamico"),
    @NamedQuery(name = "PghHstParametroDinamico.findByNombre", query = "SELECT p FROM PghHstParametroDinamico p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PghHstParametroDinamico.findByIdAmbitoParametrico", query = "SELECT p FROM PghHstParametroDinamico p WHERE p.idAmbitoParametrico = :idAmbitoParametrico"),
    @NamedQuery(name = "PghHstParametroDinamico.findByDescripcion", query = "SELECT p FROM PghHstParametroDinamico p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PghHstParametroDinamico.findByComentario", query = "SELECT p FROM PghHstParametroDinamico p WHERE p.comentario = :comentario"),
    @NamedQuery(name = "PghHstParametroDinamico.findByEstado", query = "SELECT p FROM PghHstParametroDinamico p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghHstParametroDinamico.findByUsuarioCreacion", query = "SELECT p FROM PghHstParametroDinamico p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghHstParametroDinamico.findByFechaCreacion", query = "SELECT p FROM PghHstParametroDinamico p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghHstParametroDinamico.findByTerminalCreacion", query = "SELECT p FROM PghHstParametroDinamico p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghHstParametroDinamico.findByUsuarioActualizacion", query = "SELECT p FROM PghHstParametroDinamico p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghHstParametroDinamico.findByFechaActualizacion", query = "SELECT p FROM PghHstParametroDinamico p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghHstParametroDinamico.findByTerminalActualizacion", query = "SELECT p FROM PghHstParametroDinamico p WHERE p.terminalActualizacion = :terminalActualizacion")})
public class PghHstParametroDinamico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HST_PARAMAETRO_DINAMICO")
    private Long idHstParamaetroDinamico;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "ID_AMBITO_PARAMETRICO")
    private Long idAmbitoParametrico;
    @Size(max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 500)
    @Column(name = "COMENTARIO")
    private String comentario;
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
    @JoinColumn(name = "ID_PARAMETRO_DINAMICO", referencedColumnName = "ID_PARAMETRO_DINAMICO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghParametroDinamico idParametroDinamico;

    public PghHstParametroDinamico() {
    }

    public PghHstParametroDinamico(Long idHstParamaetroDinamico) {
        this.idHstParamaetroDinamico = idHstParamaetroDinamico;
    }

    public PghHstParametroDinamico(Long idHstParamaetroDinamico, char estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idHstParamaetroDinamico = idHstParamaetroDinamico;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdHstParamaetroDinamico() {
        return idHstParamaetroDinamico;
    }

    public void setIdHstParamaetroDinamico(Long idHstParamaetroDinamico) {
        this.idHstParamaetroDinamico = idHstParamaetroDinamico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdAmbitoParametrico() {
        return idAmbitoParametrico;
    }

    public void setIdAmbitoParametrico(Long idAmbitoParametrico) {
        this.idAmbitoParametrico = idAmbitoParametrico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public PghParametroDinamico getIdParametroDinamico() {
        return idParametroDinamico;
    }

    public void setIdParametroDinamico(PghParametroDinamico idParametroDinamico) {
        this.idParametroDinamico = idParametroDinamico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHstParamaetroDinamico != null ? idHstParamaetroDinamico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghHstParametroDinamico)) {
            return false;
        }
        PghHstParametroDinamico other = (PghHstParametroDinamico) object;
        if ((this.idHstParamaetroDinamico == null && other.idHstParamaetroDinamico != null) || (this.idHstParamaetroDinamico != null && !this.idHstParamaetroDinamico.equals(other.idHstParamaetroDinamico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghHstParametroDinamico[ idHstParamaetroDinamico=" + idHstParamaetroDinamico + " ]";
    }
    
}
