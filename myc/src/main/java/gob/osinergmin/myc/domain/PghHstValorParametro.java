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
@Table(name = "PGH_HST_VALOR_PARAMETRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghHstValorParametro.findAll", query = "SELECT p FROM PghHstValorParametro p"),
    @NamedQuery(name = "PghHstValorParametro.findByIdHstValorParametro", query = "SELECT p FROM PghHstValorParametro p WHERE p.idHstValorParametro = :idHstValorParametro"),
    @NamedQuery(name = "PghHstValorParametro.findByIdParametroDinamico", query = "SELECT p FROM PghHstValorParametro p WHERE p.idParametroDinamico = :idParametroDinamico"),
    @NamedQuery(name = "PghHstValorParametro.findByValor", query = "SELECT p FROM PghHstValorParametro p WHERE p.valor = :valor"),
    @NamedQuery(name = "PghHstValorParametro.findByDescripcion", query = "SELECT p FROM PghHstValorParametro p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PghHstValorParametro.findByComentario", query = "SELECT p FROM PghHstValorParametro p WHERE p.comentario = :comentario"),
    @NamedQuery(name = "PghHstValorParametro.findByValorDefecto", query = "SELECT p FROM PghHstValorParametro p WHERE p.valorDefecto = :valorDefecto"),
    @NamedQuery(name = "PghHstValorParametro.findByEstado", query = "SELECT p FROM PghHstValorParametro p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghHstValorParametro.findByUsuarioCreacion", query = "SELECT p FROM PghHstValorParametro p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghHstValorParametro.findByFechaCreacion", query = "SELECT p FROM PghHstValorParametro p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghHstValorParametro.findByTerminalCreacion", query = "SELECT p FROM PghHstValorParametro p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghHstValorParametro.findByUsuarioActualizacion", query = "SELECT p FROM PghHstValorParametro p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghHstValorParametro.findByFechaActualizacion", query = "SELECT p FROM PghHstValorParametro p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghHstValorParametro.findByTerminalActualizacion", query = "SELECT p FROM PghHstValorParametro p WHERE p.terminalActualizacion = :terminalActualizacion")})
public class PghHstValorParametro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HST_VALOR_PARAMETRO")
    private Long idHstValorParametro;
    @Column(name = "ID_PARAMETRO_DINAMICO")
    private Long idParametroDinamico;
    @Size(max = 100)
    @Column(name = "VALOR")
    private String valor;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 500)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Column(name = "VALOR_DEFECTO")
    private Character valorDefecto;
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
    @JoinColumn(name = "ID_VALOR_PARAMETRO", referencedColumnName = "ID_VALOR_PARAMETRO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghValorParametro idValorParametro;

    public PghHstValorParametro() {
    }

    public PghHstValorParametro(Long idHstValorParametro) {
        this.idHstValorParametro = idHstValorParametro;
    }

    public PghHstValorParametro(Long idHstValorParametro, char estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idHstValorParametro = idHstValorParametro;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdHstValorParametro() {
        return idHstValorParametro;
    }

    public void setIdHstValorParametro(Long idHstValorParametro) {
        this.idHstValorParametro = idHstValorParametro;
    }

    public Long getIdParametroDinamico() {
        return idParametroDinamico;
    }

    public void setIdParametroDinamico(Long idParametroDinamico) {
        this.idParametroDinamico = idParametroDinamico;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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

    public Character getValorDefecto() {
        return valorDefecto;
    }

    public void setValorDefecto(Character valorDefecto) {
        this.valorDefecto = valorDefecto;
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

    public PghValorParametro getIdValorParametro() {
        return idValorParametro;
    }

    public void setIdValorParametro(PghValorParametro idValorParametro) {
        this.idValorParametro = idValorParametro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHstValorParametro != null ? idHstValorParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghHstValorParametro)) {
            return false;
        }
        PghHstValorParametro other = (PghHstValorParametro) object;
        if ((this.idHstValorParametro == null && other.idHstValorParametro != null) || (this.idHstValorParametro != null && !this.idHstValorParametro.equals(other.idHstValorParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghHstValorParametro[ idHstValorParametro=" + idHstValorParametro + " ]";
    }
    
}
