/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author lchancayauri
 */
@Entity
@Table(name = "PGH_MODULO_X_ACTIVIDAD")
@NamedQueries({
	@NamedQuery(name = "PghModuloXActividad.findAll", query = "SELECT p FROM PghModuloXActividad p") })
public class PghModuloXActividad extends Auditoria {
    private static final Long serialVersionUID = 1L;
    @EmbeddedId
    protected PghModuloXActividadPK pghModuloXActividadPK;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 20)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ORDEN_CREACION", nullable = false)
    private Long ordenCreacion;
    @Basic(optional = false)
    @Column(name = "ORDEN_EDICION", nullable = false)
    private Long ordenEdicion;
    @Basic(optional = false)
    @Column(name = "ORDEN_DETALLE", nullable = false)
    private Long ordenDetalle;
    @Basic(optional = false)
    @Column(name = "TRAZABILIDAD", nullable = false)
    private String trazabilidad;
    @JoinColumn(name = "ID_MODULO", referencedColumnName = "ID_MODULO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PghModulo pghModulo;

    public PghModuloXActividad() {
    }

    public PghModuloXActividad(PghModuloXActividadPK pghModuloXActividadPK) {
	this.pghModuloXActividadPK = pghModuloXActividadPK;
    }

    public PghModuloXActividad(Long idModulo, Long idActividad) {
	this.pghModuloXActividadPK = new PghModuloXActividadPK(idModulo, idActividad);
    }

    public PghModuloXActividadPK getPghModuloXActividadPK() {
	return pghModuloXActividadPK;
    }

    public void setPghModuloXActividadPK(PghModuloXActividadPK pghModuloXActividadPK) {
	this.pghModuloXActividadPK = pghModuloXActividadPK;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public Long getOrdenCreacion() {
	return ordenCreacion;
    }

    public void setOrdenCreacion(Long ordenCreacion) {
	this.ordenCreacion = ordenCreacion;
    }

    public Long getOrdenEdicion() {
	return ordenEdicion;
    }

    public void setOrdenEdicion(Long ordenEdicion) {
	this.ordenEdicion = ordenEdicion;
    }

    public Long getOrdenDetalle() {
	return ordenDetalle;
    }

    public void setOrdenDetalle(Long ordenDetalle) {
	this.ordenDetalle = ordenDetalle;
    }

    public String getTrazabilidad() {
	return trazabilidad;
    }

    public void setTrazabilidad(String trazabilidad) {
	this.trazabilidad = trazabilidad;
    }

    public PghModulo getPghModulo() {
	return pghModulo;
    }

    public void setPghModulo(PghModulo pghModulo) {
	this.pghModulo = pghModulo;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (pghModuloXActividadPK != null ? pghModuloXActividadPK.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof PghModuloXActividad)) {
	    return false;
	}
	PghModuloXActividad other = (PghModuloXActividad) object;
	if ((this.pghModuloXActividadPK == null && other.pghModuloXActividadPK != null)
		|| (this.pghModuloXActividadPK != null && !this.pghModuloXActividadPK.equals(other.pghModuloXActividadPK))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "gob.osinergming.siguoweb.domain.PghModuloXActividad[ pghModuloXActividadPK=" + pghModuloXActividadPK + " ]";
    }

}
