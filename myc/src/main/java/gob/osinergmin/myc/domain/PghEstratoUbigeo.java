package gob.osinergmin.myc.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author gvillanueva
 */
@Entity
@Table(name = "PGH_ESTRATO_UBIGEO")
@NamedQueries({
    @NamedQuery(name = "PghEstratoUbigeo.findAll", query = "SELECT p FROM PghEstratoUbigeo p where p.estado = '1' "),
    @NamedQuery(name = "PghEstratoUbigeo.findByIdEstratoUbigeo", query = "SELECT p FROM PghEstratoUbigeo p WHERE p.idEstratoUbigeo = :idEstratoUbigeo")
})
public class PghEstratoUbigeo extends Auditoria {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTRATO_UBIGEO")
    private Long idEstratoUbigeo;
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_ESTRATO", referencedColumnName = "ID_ESTRATO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghEstrato idEstrato;
    @JoinColumns({
        @JoinColumn(name = "ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO"),
        @JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "ID_PROVINCIA"),
        @JoinColumn(name = "ID_DISTRITO", referencedColumnName = "ID_DISTRITO")})
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiUbigeo mdiUbigeo;

    public PghEstratoUbigeo() {
    }

    public PghEstratoUbigeo(Long idEstratoUbigeo) {
        this.idEstratoUbigeo = idEstratoUbigeo;
    }

    public PghEstratoUbigeo(Long idEstratoUbigeo, String estado, Date fechaCreacion, String usuarioCreacion, String terminalCreacion) {
        this.idEstratoUbigeo = idEstratoUbigeo;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdEstratoUbigeo() {
        return idEstratoUbigeo;
    }

    public void setIdEstratoUbigeo(Long idEstratoUbigeo) {
        this.idEstratoUbigeo = idEstratoUbigeo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @XmlTransient
    public PghEstrato getIdEstrato() {
        return idEstrato;
    }

    public void setIdEstrato(PghEstrato idEstrato) {
        this.idEstrato = idEstrato;
    }

    public MdiUbigeo getMdiUbigeo() {
        return mdiUbigeo;
    }

    public void setMdiUbigeo(MdiUbigeo mdiUbigeo) {
        this.mdiUbigeo = mdiUbigeo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstratoUbigeo != null ? idEstratoUbigeo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghEstratoUbigeo)) {
            return false;
        }
        PghEstratoUbigeo other = (PghEstratoUbigeo) object;
        if ((this.idEstratoUbigeo == null && other.idEstratoUbigeo != null) || (this.idEstratoUbigeo != null && !this.idEstratoUbigeo.equals(other.idEstratoUbigeo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghEstratoUbigeo[ idEstratoUbigeo=" + idEstratoUbigeo + " ]";
    }
    
}
