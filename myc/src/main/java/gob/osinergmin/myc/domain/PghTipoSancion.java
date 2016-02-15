/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cflorian
 */
@Entity
@Table(name = "PGH_TIPO_SANCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghTipoSancion.countAll", query = "SELECT count(p.idTipoSancion) FROM PghTipoSancion p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghTipoSancion.findAll", query = "SELECT p FROM PghTipoSancion p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghTipoSancion.countByIdTipoSancion", query = "SELECT count(p.idTipoSancion) FROM PghTipoSancion p WHERE p.idTipoSancion = :idTipoSancion"),
    @NamedQuery(name = "PghTipoSancion.findByIdTipoSancion", query = "SELECT p FROM PghTipoSancion p WHERE p.idTipoSancion = :idTipoSancion"),
    @NamedQuery(name = "PghTipoSancion.countByDescripcion", query = "SELECT count(p.idTipoSancion) FROM PghTipoSancion p WHERE upper(p.descripcion) like :descripcion and p.estado = :estado"),
    @NamedQuery(name = "PghTipoSancion.findByDescripcion", query = "SELECT p FROM PghTipoSancion p WHERE upper(p.descripcion) like :descripcion and p.estado = :estado"),
    @NamedQuery(name = "PghTipoSancion.findValida", query = "SELECT p FROM PghTipoSancion p WHERE upper(p.descripcion) = :descripcion and p.estado = '1'")
//    @NamedQuery(name = "PghTipoSancion.findByEstado", query = "SELECT p FROM PghTipoSancion p WHERE p.estado = :estado"),
//    @NamedQuery(name = "PghTipoSancion.findByUsuarioCreacion", query = "SELECT p FROM PghTipoSancion p WHERE p.usuarioCreacion = :usuarioCreacion"),
//    @NamedQuery(name = "PghTipoSancion.findByFechaCreacion", query = "SELECT p FROM PghTipoSancion p WHERE p.fechaCreacion = :fechaCreacion"),
//    @NamedQuery(name = "PghTipoSancion.findByTerminalCreacion", query = "SELECT p FROM PghTipoSancion p WHERE p.terminalCreacion = :terminalCreacion"),
//    @NamedQuery(name = "PghTipoSancion.findByUsuarioActualizacion", query = "SELECT p FROM PghTipoSancion p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
//    @NamedQuery(name = "PghTipoSancion.findByFechaActualizacion", query = "SELECT p FROM PghTipoSancion p WHERE p.fechaActualizacion = :fechaActualizacion"),
//    @NamedQuery(name = "PghTipoSancion.findByTerminalActualizacion", query = "SELECT p FROM PghTipoSancion p WHERE p.terminalActualizacion = :terminalActualizacion")
})
public class PghTipoSancion extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_SANCION")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_TIPO_SANC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idTipoSancion;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTADO")
    private Character estado;
// 05-11-2015
    @Column(name = "ABREVIATURA")
    private String abreviatura;
//
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pghTipoSancion")
    private List<PghTipificacionSancion> pghTipificacionSancionList;

    public PghTipoSancion() {
    }

    public PghTipoSancion(Long idTipoSancion) {
        this.idTipoSancion = idTipoSancion;
    }

    public Long getIdTipoSancion() {
        return idTipoSancion;
    }

    public void setIdTipoSancion(Long idTipoSancion) {
        this.idTipoSancion = idTipoSancion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    

    @XmlTransient
    public List<PghTipificacionSancion> getPghTipificacionSancionList() {
        return pghTipificacionSancionList;
    }

    public void setPghTipificacionSancionList(List<PghTipificacionSancion> pghTipificacionSancionList) {
        this.pghTipificacionSancionList = pghTipificacionSancionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSancion != null ? idTipoSancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghTipoSancion)) {
            return false;
        }
        PghTipoSancion other = (PghTipoSancion) object;
        if ((this.idTipoSancion == null && other.idTipoSancion != null) || (this.idTipoSancion != null && !this.idTipoSancion.equals(other.idTipoSancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PghTipoSancion[ idTipoSancion=" + idTipoSancion + " ]";
    }

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
    
}
