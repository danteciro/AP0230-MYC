/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.component.ColumAddObligacionesTmp;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cflorian
 */
@Entity
@Table(name = "PGH_TEMA_OBLIGACION_MAESTRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghTemaObligacionMaestro.findAll", query = "SELECT p FROM PghTemaObligacionMaestro p")})
public class PghTemaObligacionMaestro extends ColumAddObligacionesTmp {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TEM_OBL_MA")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_TEMA_OBL_MAE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idTemOblMa;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "ID_TEMA_OBLIGACION")
    private long idTemaObligacion;
//    @JoinColumn(name = "ID_OBLIGACION", referencedColumnName = "ID_OBLIGACION", insertable = false, updatable = false)
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private PghObligacion pghObligacion;
    @JoinColumn(name = "ID_OBLIGACION", referencedColumnName = "ID_OBLIGACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghObligacion idObligacion;

    public PghTemaObligacionMaestro() {
    }

    public Long getIdTemOblMa() {
        return idTemOblMa;
    }

    public void setIdTemOblMa(Long idTemOblMa) {
        this.idTemOblMa = idTemOblMa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getIdTemaObligacion() {
        return idTemaObligacion;
    }

    public void setIdTemaObligacion(long idTemaObligacion) {
        this.idTemaObligacion = idTemaObligacion;
    }

//    public PghObligacion getPghObligacion() {
//        return pghObligacion;
//    }
//
//    public void setPghObligacion(PghObligacion pghObligacion) {
//        this.pghObligacion = pghObligacion;
//    }

    public PghObligacion getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(PghObligacion idObligacion) {
        this.idObligacion = idObligacion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTemOblMa != null ? idTemOblMa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghTemaObligacionMaestro)) {
            return false;
        }
        PghTemaObligacionMaestro other = (PghTemaObligacionMaestro) object;
        if ((this.idTemOblMa == null && other.idTemOblMa != null) || (this.idTemOblMa != null && !this.idTemOblMa.equals(other.idTemOblMa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.PghTemaObligacionMaestro[ idTemOblMa=" + idTemOblMa + " ]";
    }
    
}
