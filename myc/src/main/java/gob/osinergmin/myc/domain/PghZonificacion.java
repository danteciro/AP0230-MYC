/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_ZONIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghZonificacion.findAll", query = "SELECT p FROM PghZonificacion p where p.estado=:estado and p.nombre like :nombre order by p.nombre "),
    @NamedQuery(name = "PghZonificacion.findValidaNombre", query = "SELECT p FROM PghZonificacion p where p.estado=:estado and p.nombre = :nombre "),
    @NamedQuery(name = "PghZonificacion.findByIdZonificacion", query = "SELECT p FROM PghZonificacion p where p.idZonificacion=:idZonificacion")
})
public class PghZonificacion extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ZONIFICACION")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_ZONIFICACION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idZonificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 38)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "idZonificacion", fetch = FetchType.LAZY)
    private List<PghCnfRequProcedimiento> pghCnfRequProcedimientoList;
    @OneToMany(mappedBy = "idZonificacion", fetch = FetchType.LAZY)
    private List<PghZonificacionDetalle> pghZonificacionDetalleList;

    public PghZonificacion() {
    }

    public PghZonificacion(Long idZonificacion) {
        this.idZonificacion = idZonificacion;
    }

    public PghZonificacion(Long idZonificacion, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idZonificacion = idZonificacion;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdZonificacion() {
        return idZonificacion;
    }

    public void setIdZonificacion(Long idZonificacion) {
        this.idZonificacion = idZonificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<PghCnfRequProcedimiento> getPghCnfRequProcedimientoList() {
        return pghCnfRequProcedimientoList;
    }

    public void setPghCnfRequProcedimientoList(List<PghCnfRequProcedimiento> pghCnfRequProcedimientoList) {
        this.pghCnfRequProcedimientoList = pghCnfRequProcedimientoList;
    }
    
    @XmlTransient
    public List<PghZonificacionDetalle> getPghZonificacionDetalleList() {
        return pghZonificacionDetalleList;
    }

    public void setPghZonificacionDetalleList(List<PghZonificacionDetalle> pghZonificacionDetalleList) {
        this.pghZonificacionDetalleList = pghZonificacionDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZonificacion != null ? idZonificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghZonificacion)) {
            return false;
        }
        PghZonificacion other = (PghZonificacion) object;
        if ((this.idZonificacion == null && other.idZonificacion != null) || (this.idZonificacion != null && !this.idZonificacion.equals(other.idZonificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.test.PghZonificacion[ idZonificacion=" + idZonificacion + " ]";
    }
    
}
