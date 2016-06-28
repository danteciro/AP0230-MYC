/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

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

/**
 *
 * @author jsifuentes
 */
@Entity
@Table(name = "PGH_OPCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghOpcion.findAll", query = "SELECT m FROM PghOpcion m WHERE m.estado=:estado and m.aplicacion=:aplicacion order by m.idOpcion"),
    @NamedQuery(name = "PghOpcion.findByIdentificadorOpcion", query = "SELECT m FROM PghOpcion m WHERE m.estado=:estado and m.aplicacion=:aplicacion and m.identificador_opcion=:identificadorOpcion order by m.idOpcion"),
    @NamedQuery(name = "PghOpcion.countAll", query = "SELECT count(m.idOpcion) FROM PghOpcion m WHERE m.estado=:estado"),
    @NamedQuery(name = "PghOpcion.findByIdRubroOpcion", query = "SELECT new PghOpcion(op.idOpcion,op.nombre) "
                                                              + "FROM PghRubroOpcion ro "
                                                              + "inner join ro.idOpcion op "
                                                              + "WHERE op.estado=:estado and ro.estado=:estado and ro.idRubroOpcion=:idRubroOpcion"),
    @NamedQuery(name = "PghOpcion.findByIdActividad", query = "SELECT new PghOpcion(op.idOpcion,op.nombre) "
                                                              + "FROM PghRubroOpcion ro "
                                                              + "inner join ro.idOpcion op "
                                                              + "WHERE op.estado=:estado and ro.estado=:estado and ro.idActividad.idActividad=:idActividad")
      
})
public class PghOpcion extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OPCION")
    private Long idOpcion;
    @Size(max = 100)
    @Column(name = "NOMBRE_OPCION")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "APLICACION")
    private String aplicacion;
    @Basic(optional = false)
    @Column(name = "IDENTIFICADOR_OPCION")
    private String identificador_opcion;
    @OneToMany(mappedBy = "idOpcion", fetch = FetchType.LAZY)
    private List<PghRubroOpcion> pghRubroOpcionList;
    
    public PghOpcion() {
    }
    
    

    public PghOpcion(String identificador_opcion) {
		super();
		this.identificador_opcion = identificador_opcion;
	}

	public PghOpcion(Long idOpcion) {
        this.idOpcion = idOpcion;
    }
    
    public PghOpcion(Long idOpcion,String nombre) {
        this.idOpcion = idOpcion;
        this.nombre=nombre;
    }

    public Long getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Long idOpcion) {
        this.idOpcion = idOpcion;
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

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}
		
    public String getIdentificador_opcion() {
		return identificador_opcion;
	}

	public void setIdentificador_opcion(String identificador_opcion) {
		this.identificador_opcion = identificador_opcion;
	}

	@XmlTransient
    @JsonIgnore
	public List<PghRubroOpcion> getPghRubroOpcionList() {
		return pghRubroOpcionList;
	}

	public void setPghRubroOpcionList(List<PghRubroOpcion> pghRubroOpcionList) {
		this.pghRubroOpcionList = pghRubroOpcionList;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpcion != null ? idOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghOpcion)) {
            return false;
        }
        PghOpcion other = (PghOpcion) object;
        if ((this.idOpcion == null && other.idOpcion != null) || (this.idOpcion != null && !this.idOpcion.equals(other.idOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghOpcion[ idOpcion=" + idOpcion + " ]";
    }
    
}
