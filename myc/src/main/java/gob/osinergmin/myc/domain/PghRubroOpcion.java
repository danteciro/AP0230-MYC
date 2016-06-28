/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;


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
 * @author jpiro
 */
@Entity
@Table(name = "PGH_OPCION_ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghRubroOpcion.findAll", query = "SELECT p FROM PghRubroOpcion p"),
//    @NamedQuery(name = "PghRubroOpcion.findByIdTramiteIdActividad", query = "SELECT p FROM PghRubroOpcion p where p.estado=:estado and p.idTramite.idTramite=:idTramite and p.idActividad.idActividad=:idActividad"),
//    @NamedQuery(name = "PghRubroOpcion.findByIdTramiteActividad", query = "SELECT p FROM PghRubroOpcion p where p.estado=:estado and p.idTramiteActivdad=:idTramiteActivdad")
})
public class PghRubroOpcion extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_OPCION_ACTIVIDAD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    @Column(name = "ID_OPCION_ACTIVIDAD")
    private Long idRubroOpcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_OPCION", referencedColumnName = "ID_OPCION")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghOpcion idOpcion;
    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiActividad idActividad;
    
    public PghRubroOpcion() {
    }
    
    public PghRubroOpcion(Long idRubroOpcion, Long idActividad,String nombre, Long idOpcion, String descripcion){
  	    this.idRubroOpcion = idRubroOpcion;
        this.idActividad = new MdiActividad(idActividad,nombre);
        this.idOpcion = new PghOpcion(idOpcion,descripcion);
  }

    public PghRubroOpcion(Long idRubroOpcion) {
        this.idRubroOpcion = idRubroOpcion;
    }    
    
    public Long getIdRubroOpcion() {
		return idRubroOpcion;
	}

	public void setIdRubroOpcion(Long idRubroOpcion) {
		this.idRubroOpcion = idRubroOpcion;
	}

	public PghOpcion getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(PghOpcion idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
	public MdiActividad getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(MdiActividad idActividad) {
		this.idActividad = idActividad;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idRubroOpcion != null ? idRubroOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghRubroOpcion)) {
            return false;
        }
        PghRubroOpcion other = (PghRubroOpcion) object;
        if ((this.idRubroOpcion == null && other.idRubroOpcion != null) || (this.idRubroOpcion != null && !this.idRubroOpcion.equals(other.idRubroOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghRubroOpcion[ idRubroOpcion=" + idRubroOpcion + " ]";
    }
    
}
