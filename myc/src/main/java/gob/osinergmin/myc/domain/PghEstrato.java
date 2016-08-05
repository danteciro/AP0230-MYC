/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_ESTRATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghEstrato.findAll", query = "SELECT p FROM PghEstrato p")
})
public class PghEstrato extends Auditoria {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTRATO")
    private Long idEstrato;
    @Size(max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idEstrato", fetch = FetchType.LAZY)
    private List<PghEstratoUbigeo> pghEstratoUbigeoList;

    public PghEstrato() {
    }

    public PghEstrato(Long idEstrato) {
        this.idEstrato = idEstrato;
    }

    public PghEstrato(Long idEstrato, String estado, Date fechaCreacion, String usuarioCreacion, String terminalCreacion) {
        this.idEstrato = idEstrato;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdEstrato() {
        return idEstrato;
    }

    public void setIdEstrato(Long idEstrato) {
        this.idEstrato = idEstrato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghEstratoUbigeo> getPghEstratoUbigeoList() {
        return pghEstratoUbigeoList;
    }

    public void setPghEstratoUbigeoList(List<PghEstratoUbigeo> pghEstratoUbigeoList) {
        this.pghEstratoUbigeoList = pghEstratoUbigeoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstrato != null ? idEstrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghEstrato)) {
            return false;
        }
        PghEstrato other = (PghEstrato) object;
        if ((this.idEstrato == null && other.idEstrato != null) || (this.idEstrato != null && !this.idEstrato.equals(other.idEstrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghEstrato[ idEstrato=" + idEstrato + " ]";
    }
    
}
