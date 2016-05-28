/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.component.ColumAddObligaciones;
import gob.osinergmin.myc.domain.component.ColumAddObligacionesTmp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cflorian
 */
@Entity
@Table(name = "PGH_DETALLE_OBLIGACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghDetalleObligacion.countAll", query = "SELECT count(p.idDetalleObligacion) FROM PghDetalleObligacion p"),
    @NamedQuery(name = "PghDetalleObligacion.findAll", query = "SELECT p FROM PghDetalleObligacion p"),
    @NamedQuery(name = "PghDetalleObligacion.countByFilter", query = "SELECT count(p.idDetalleObligacion) FROM PghDetalleObligacion p WHERE p.estado='1' and upper(p.descripcion) like :descripcion"),
    @NamedQuery(name = "PghDetalleObligacion.findByFilter", query = "SELECT p FROM PghDetalleObligacion p WHERE p.estado='1' and upper(p.descripcion) like :descripcion"),
    @NamedQuery(name = "PghDetalleObligacion.countByIdDetalleObligacion", query = "SELECT count(p.idDetalleObligacion) FROM PghDetalleObligacion p WHERE p.idDetalleObligacion = :idDetalleObligacion"),
    @NamedQuery(name = "PghDetalleObligacion.findByIdDetalleObligacion", query = "SELECT p FROM PghDetalleObligacion p WHERE p.idDetalleObligacion = :idDetalleObligacion"),
    @NamedQuery(name = "PghDetalleObligacion.findByDescripcion", query = "SELECT p FROM PghDetalleObligacion p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PghDetalleObligacion.findByEstado", query = "SELECT p FROM PghDetalleObligacion p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghDetalleObligacion.findByUsuarioCreacion", query = "SELECT p FROM PghDetalleObligacion p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghDetalleObligacion.findByFechaCreacion", query = "SELECT p FROM PghDetalleObligacion p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghDetalleObligacion.findByTerminalCreacion", query = "SELECT p FROM PghDetalleObligacion p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghDetalleObligacion.findByUsuarioActualizacion", query = "SELECT p FROM PghDetalleObligacion p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghDetalleObligacion.findByFechaActualizacion", query = "SELECT p FROM PghDetalleObligacion p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghDetalleObligacion.findByTerminalActualizacion", query = "SELECT p FROM PghDetalleObligacion p WHERE p.terminalActualizacion = :terminalActualizacion"),
    @NamedQuery(name = "PghDetalleObligacion.findByTipoDescObl", query = "SELECT p FROM PghDetalleObligacion p WHERE p.tipoDescObl = :tipoDescObl")})
public class PghDetalleObligacion extends ColumAddObligacionesTmp {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_OBLIGACION")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_DETALLE_OBLIGACION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idDetalleObligacion;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "TIPO_DESC_OBL")
    private String tipoDescObl;
    @Basic(optional = true)
    @Column(name = "ID_DOCUMENTO_ADJUNTO")
    private Long idDocumentoAdjunto;
    @JoinColumn(name = "ID_OBLIGACION", referencedColumnName = "ID_OBLIGACION")
    @ManyToOne
    private PghObligacion idObligacion;

    public PghDetalleObligacion() {
    }

    public PghDetalleObligacion(Long idDetalleObligacion) {
        this.idDetalleObligacion = idDetalleObligacion;
    }

    public Long getIdDetalleObligacion() {
        return idDetalleObligacion;
    }

    public void setIdDetalleObligacion(Long idDetalleObligacion) {
        this.idDetalleObligacion = idDetalleObligacion;
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

    public String getTipoDescObl() {
        return tipoDescObl;
    }

    public void setTipoDescObl(String tipoDescObl) {
        this.tipoDescObl = tipoDescObl;
    }

    public PghObligacion getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(PghObligacion idObligacion) {
        this.idObligacion = idObligacion;
    }

    public Long getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }

    public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleObligacion != null ? idDetalleObligacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghDetalleObligacion)) {
            return false;
        }
        PghDetalleObligacion other = (PghDetalleObligacion) object;
        if ((this.idDetalleObligacion == null && other.idDetalleObligacion != null) || (this.idDetalleObligacion != null && !this.idDetalleObligacion.equals(other.idDetalleObligacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PghDetalleObligacion[ idDetalleObligacion=" + idDetalleObligacion + " ]";
    }
    
}
