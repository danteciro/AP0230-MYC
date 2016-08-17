/**
* Resumen		
* Objeto		: PghRol.java
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
@Table(name = "PGH_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghRol.findAll", query = "SELECT p FROM PghRol p")
})
public class PghRol extends Auditoria {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ROL")
    private Long idRol;
    @Size(max = 50)
    @Column(name = "NOMBRE_ROL")
    private String nombreRol;
    @Size(max = 40)
    @Column(name = "IDENTIFICADOR_ROL")
    private String identificadorRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idRol", fetch = FetchType.LAZY)
    private List<PghPersonal> pghPersonalList;    
    @OneToMany(mappedBy = "idRol", fetch = FetchType.LAZY)
    private List<PghRolOpcion> pghRolOpcionList;

    public PghRol() {
    }

    public PghRol(Long idRol) {
        this.idRol = idRol;
    }

    public PghRol(Long idRol, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idRol = idRol;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getIdentificadorRol() {
        return identificadorRol;
    }

    public void setIdentificadorRol(String identificadorRol) {
        this.identificadorRol = identificadorRol;
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
    
    @XmlTransient
    public List<PghRolOpcion> getPghRolOpcionList() {
        return pghRolOpcionList;
    }

    public void setPghRolOpcionList(List<PghRolOpcion> pghRolOpcionList) {
        this.pghRolOpcionList = pghRolOpcionList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghRol)) {
            return false;
        }
        PghRol other = (PghRol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghRol[ idRol=" + idRol + " ]";
    }
    
}
