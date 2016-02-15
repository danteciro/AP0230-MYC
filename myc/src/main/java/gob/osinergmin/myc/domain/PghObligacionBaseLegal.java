/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.component.ColumAddObligacionesTmp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lbarboza
 */
@Entity
@Table(name = "PGH_OBLIGACION_BASE_LEGAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghObligacionBaseLegal.findAll", query = "SELECT p FROM PghObligacionBaseLegal p"),
    @NamedQuery(name = "PghObligacionBaseLegal.findByIdObligacion", query = "SELECT p FROM PghObligacionBaseLegal p WHERE p.idObligacion.idObligacion = :idObligacion"),
    @NamedQuery(name = "PghObligacionBaseLegal.findByIdBaseLegal", query = "SELECT p FROM PghObligacionBaseLegal p WHERE p.idBaseLegal.idBaseLegal = :idBaseLegal"),
    @NamedQuery(name = "PghObligacionBaseLegal.findByFechaActualizacion", query = "SELECT p FROM PghObligacionBaseLegal p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghObligacionBaseLegal.findByFechaCreacion", query = "SELECT p FROM PghObligacionBaseLegal p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghObligacionBaseLegal.findByTerminalActualizacion", query = "SELECT p FROM PghObligacionBaseLegal p WHERE p.terminalActualizacion = :terminalActualizacion"),
    @NamedQuery(name = "PghObligacionBaseLegal.findByTerminalCreacion", query = "SELECT p FROM PghObligacionBaseLegal p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghObligacionBaseLegal.findByUsuarioActualizacion", query = "SELECT p FROM PghObligacionBaseLegal p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghObligacionBaseLegal.findByUsuarioCreacion", query = "SELECT p FROM PghObligacionBaseLegal p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghObligacionBaseLegal.findByEstado", query = "SELECT p FROM PghObligacionBaseLegal p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghObligacionBaseLegal.findByIdOblBase", query = "SELECT p FROM PghObligacionBaseLegal p WHERE p.idOblBase = :idOblBase")})
public class PghObligacionBaseLegal extends ColumAddObligacionesTmp {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_OBL_BASE")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_OBL_BASE_LEGAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idOblBase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_OBLIGACION", referencedColumnName = "ID_OBLIGACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghObligacion idObligacion;
    @JoinColumn(name = "ID_BASE_LEGAL", referencedColumnName = "ID_BASE_LEGAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghBaseLegal idBaseLegal;

    public PghObligacionBaseLegal() {
    }

    public Long getIdOblBase() {
        return idOblBase;
    }

    public void setIdOblBase(Long idOblBase) {
        this.idOblBase = idOblBase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PghObligacion getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(PghObligacion idObligacion) {
        this.idObligacion = idObligacion;
    }

    public PghBaseLegal getIdBaseLegal() {
        return idBaseLegal;
    }

    public void setIdBaseLegal(PghBaseLegal idBaseLegal) {
        this.idBaseLegal = idBaseLegal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOblBase != null ? idOblBase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghObligacionBaseLegal)) {
            return false;
        }
        PghObligacionBaseLegal other = (PghObligacionBaseLegal) object;
        if ((this.idOblBase == null && other.idOblBase != null) || (this.idOblBase != null && !this.idOblBase.equals(other.idOblBase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.PghObligacionBaseLegal[ idOblBase=" + idOblBase + " ]";
    }
    
}
