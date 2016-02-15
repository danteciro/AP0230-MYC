/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.component.ColumAddObligaciones;
import gob.osinergmin.myc.domain.component.ColumAddObligacionesTmp;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cflorian
 */
@Entity
@Table(name = "PGH_LISTADO_BASE_LEGAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghListadoBaseLegal.findAll", query = "SELECT p FROM PghListadoBaseLegal p"),
    @NamedQuery(name = "PghListadoBaseLegal.findByIdListadoBaseLegal", query = "SELECT p FROM PghListadoBaseLegal p WHERE p.idListadoBaseLegal = :idListadoBaseLegal"),
    @NamedQuery(name = "PghListadoBaseLegal.findByEstado", query = "SELECT p FROM PghListadoBaseLegal p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghListadoBaseLegal.findByUsuarioCreacion", query = "SELECT p FROM PghListadoBaseLegal p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghListadoBaseLegal.findByFechaCreacion", query = "SELECT p FROM PghListadoBaseLegal p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghListadoBaseLegal.findByTerminalCreacion", query = "SELECT p FROM PghListadoBaseLegal p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghListadoBaseLegal.findByUsuarioActualizacion", query = "SELECT p FROM PghListadoBaseLegal p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghListadoBaseLegal.findByFechaActualizacion", query = "SELECT p FROM PghListadoBaseLegal p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghListadoBaseLegal.findByTerminalActualizacion", query = "SELECT p FROM PghListadoBaseLegal p WHERE p.terminalActualizacion = :terminalActualizacion")})
public class PghListadoBaseLegal extends ColumAddObligacionesTmp {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="ID_LISTADO_BASE_LEGAL_SEQ",sequenceName="PGH_LISTADO_BASE_LEGAL_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ID_LISTADO_BASE_LEGAL_SEQ")
    @Column(name = "ID_LISTADO_BASE_LEGAL")
    private Long idListadoBaseLegal;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_BASE_LEGAL_ORI", referencedColumnName = "ID_BASE_LEGAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghBaseLegal idBaseLegalOri;
    @JoinColumn(name = "ID_BASE_LEGAL_DEST", referencedColumnName = "ID_BASE_LEGAL")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghBaseLegal idBaseLegalDest;

    public PghListadoBaseLegal() {
    }

    public PghListadoBaseLegal(Long idListadoBaseLegal) {
        this.idListadoBaseLegal = idListadoBaseLegal;
    }

    public PghListadoBaseLegal(Long idListadoBaseLegal, String estado, Date fechaCreacion, String terminalCreacion, String usuarioCreacion) {
        this.idListadoBaseLegal = idListadoBaseLegal;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
        this.usuarioCreacion = usuarioCreacion;
    }

    public Long getIdListadoBaseLegal() {
        return idListadoBaseLegal;
    }

    public void setIdListadoBaseLegal(Long idListadoBaseLegal) {
        this.idListadoBaseLegal = idListadoBaseLegal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PghBaseLegal getIdBaseLegalOri() {
        return idBaseLegalOri;
    }

    public void setIdBaseLegalOri(PghBaseLegal idBaseLegalOri) {
        this.idBaseLegalOri = idBaseLegalOri;
    }

    public PghBaseLegal getIdBaseLegalDest() {
        return idBaseLegalDest;
    }

    public void setIdBaseLegalDest(PghBaseLegal idBaseLegalDest) {
        this.idBaseLegalDest = idBaseLegalDest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idListadoBaseLegal != null ? idListadoBaseLegal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghListadoBaseLegal)) {
            return false;
        }
        PghListadoBaseLegal other = (PghListadoBaseLegal) object;
        if ((this.idListadoBaseLegal == null && other.idListadoBaseLegal != null) || (this.idListadoBaseLegal != null && !this.idListadoBaseLegal.equals(other.idListadoBaseLegal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghListadoBaseLegal[ idListadoBaseLegal=" + idListadoBaseLegal + " ]";
    }
    
}

