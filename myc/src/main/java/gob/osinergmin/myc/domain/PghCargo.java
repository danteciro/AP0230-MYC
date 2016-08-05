/**
* Resumen		
* Objeto		: PghCargo.java
* Descripción		: Domain de la entidad.
* Fecha de Creación	: 13/06/2016
* PR de Creación	: OSINE_SFS-480
* Autor			: Julio Piro
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                          Descripción
* ---------------------------------------------------------------------------------------------------
* 
*/ 

package gob.osinergmin.myc.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "PGH_CARGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghCargo.findAll", query = "SELECT p FROM PghCargo p")
})
public class PghCargo extends Auditoria {
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CARGO")
    private Long idCargo;
    @Size(max = 20)
    @Column(name = "NOMBRE_CARGO")
    private String nombreCargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idCargo", fetch = FetchType.LAZY)
    private List<PghPersonal> pghPersonalList;

    public PghCargo() {
    }

    public PghCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public PghCargo(Long idCargo, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idCargo = idCargo;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghPersonal> getPghPersonalList() {
        return pghPersonalList;
    }

    public void setPghPersonalList(List<PghPersonal> pghPersonalList) {
        this.pghPersonalList = pghPersonalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghCargo)) {
            return false;
        }
        PghCargo other = (PghCargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.PghCargo[ idCargo=" + idCargo + " ]";
    }
    
}
