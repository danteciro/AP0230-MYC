/**
* Resumen		
* Objeto			: PghSeccion.java
* Descripción		: Clase del modelo de dominio PghSeccion
* Fecha de Creación	: 23/07/2016
* PR de Creación	: 
* Autor				: mdiosesf
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------				
* 
*/ 
package gob.osinergmin.myc.domain;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mdiosesf
 */
@Entity
@Table(name = "PGH_SECCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghSeccion.findAll", query = "SELECT p FROM PghSeccion p where p.estado='1' "),
    @NamedQuery(name = "PghSeccion.findByIdSeccion", query = "SELECT p FROM PghSeccion p WHERE p.idSeccion = :idSeccion")})
public class PghSeccion extends Auditoria {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SECCION")
    private Long idSeccion;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RUTA")
    private String ruta;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeccion", fetch = FetchType.LAZY)
    private List<PghOrgaActiModuSecc> pghOrgaActiModuSeccList;

    public PghSeccion() {
    }

    public PghSeccion(Long idSeccion) {
        this.idSeccion = idSeccion;
    }

    public PghSeccion(Long idSeccion, String descripcion) {
        this.idSeccion = idSeccion;
        this.descripcion = descripcion;
    }
    
    public PghSeccion(Long idSeccion, String descripcion, String ruta, String observaciones, String estado) {
		this.idSeccion = idSeccion;
		this.descripcion = descripcion;
		this.ruta = ruta;
		this.observaciones = observaciones;
		this.estado = estado;
	}

	public Long getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Long idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }    

    @XmlTransient
    public List<PghOrgaActiModuSecc> getPghOrgaActiModuSeccList() {
        return pghOrgaActiModuSeccList;
    }

    public void setPghOrgaActiModuSeccList(List<PghOrgaActiModuSecc> pghOrgaActiModuSeccList) {
        this.pghOrgaActiModuSeccList = pghOrgaActiModuSeccList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeccion != null ? idSeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PghSeccion)) {
            return false;
        }
        PghSeccion other = (PghSeccion) object;
        if ((this.idSeccion == null && other.idSeccion != null) || (this.idSeccion != null && !this.idSeccion.equals(other.idSeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " gob.osinergmin.siguoweb.domain.PghSeccion";
    }
}
