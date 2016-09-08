/**
* Resumen		
* Objeto			: PghModulo.java
* Descripción		: Clase del modelo de dominio PghModulo
* Fecha de Creación	: 
* PR de Creación	: 
* Autor				: lchancayauri
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
* OSINE_SFS-598     23/07/2016      mdiosesf      				
* 
*/ 
package gob.osinergmin.myc.domain;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lchancayauri
 */
@Entity
@Table(name = "PGH_MODULO")
@NamedQueries({
    @NamedQuery(name = "PghModulo.findAll", query = "SELECT p FROM PghModulo p WHERE p.estado='1'")})
public class PghModulo extends Auditoria {
	private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MODULO", nullable = false)
    private Long idModulo;
    @Basic(optional = false)
    @Column(name = "RUTA", nullable = false, length = 200)
    private String ruta;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ESTADO", nullable = false, length = 2)
    private String estado;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES", nullable = false, length = 500)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pghModulo")
    private List<PghModuloXActividad> pghModuloXActividadList;
    /* OSINE_SFS-598 - RSIS 04 - Inicio */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModulo", fetch = FetchType.LAZY)
    private List<PghOrgaActiModuSecc> pghOrgaActiModuSeccList;
    /* OSINE_SFS-598 - RSIS 04 - Fin */
    
    public PghModulo() {
    }

    public PghModulo(Long idModulo) {
        this.idModulo = idModulo;
    }    
    
    /* OSINE_SFS-598 - RSIS 04 - Inicio */
    public PghModulo(Long idModulo, String ruta, String descripcion, String estado, String observaciones) {
		this.idModulo = idModulo;
		this.ruta = ruta;
		this.descripcion = descripcion;
		this.estado = estado;
		this.observaciones = observaciones;
	}
    /* OSINE_SFS-598 - RSIS 04 - Fin */

	public PghModulo(Long idModulo, String ruta, String descripcion, Date fechaCreacion, Date fechaActualizacion, String usuarioCreacion, String usuarioActualizacion, String terminalCreacion, String terminalActualizacion, String estado, String observaciones) {
        this.idModulo = idModulo;
        this.ruta = ruta;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.usuarioCreacion = usuarioCreacion;
        this.usuarioActualizacion = usuarioActualizacion;
        this.terminalCreacion = terminalCreacion;
        this.terminalActualizacion = terminalActualizacion;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public Long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<PghModuloXActividad> getPghModuloXActividadList() {
        return pghModuloXActividadList;
    }

    public void setPghModuloXActividadList(List<PghModuloXActividad> pghModuloXActividadList) {
        this.pghModuloXActividadList = pghModuloXActividadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModulo != null ? idModulo.hashCode() : 0);
        return hash;
    }
    
    /* OSINE_SFS-598 - RSIS 04 - Inicio */
    @XmlTransient
    public List<PghOrgaActiModuSecc> getPghOrgaActiModuSeccList() {
        return pghOrgaActiModuSeccList;
    }    
   
    public void setPghOrgaActiModuSeccList(List<PghOrgaActiModuSecc> pghOrgaActiModuSeccList) {
        this.pghOrgaActiModuSeccList = pghOrgaActiModuSeccList;
    }
    /* OSINE_SFS-598 - RSIS 04 - Fin */

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghModulo)) {
            return false;
        }
        PghModulo other = (PghModulo) object;
        if ((this.idModulo == null && other.idModulo != null) || (this.idModulo != null && !this.idModulo.equals(other.idModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergming.siguoweb.domain.PghModulo[ idModulo=" + idModulo + " ]";
    }    
}
