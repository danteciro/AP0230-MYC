/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.component.ColumAddObligacionesTmp;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cflorian
 */
@Entity
@Table(name = "PGH_DETALLE_DOCUMENTO_CRITERIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghDetalleDocumentoCriterio.findAll", query = "SELECT p FROM PghDetalleDocumentoCriterio p"),
    @NamedQuery(name = "PghDetalleDocumentoCriterio.findByTitulo", query = "SELECT p FROM PghDetalleDocumentoCriterio p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "PghDetalleDocumentoCriterio.findByEstado", query = "SELECT p FROM PghDetalleDocumentoCriterio p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghDetalleDocumentoCriterio.findByUsuarioCreacion", query = "SELECT p FROM PghDetalleDocumentoCriterio p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghDetalleDocumentoCriterio.findByFechaCreacion", query = "SELECT p FROM PghDetalleDocumentoCriterio p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghDetalleDocumentoCriterio.findByTerminalCreacion", query = "SELECT p FROM PghDetalleDocumentoCriterio p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghDetalleDocumentoCriterio.findByUsuarioActualizacion", query = "SELECT p FROM PghDetalleDocumentoCriterio p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghDetalleDocumentoCriterio.findByFechaActualizacion", query = "SELECT p FROM PghDetalleDocumentoCriterio p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghDetalleDocumentoCriterio.findByTerminalActualizacion", query = "SELECT p FROM PghDetalleDocumentoCriterio p WHERE p.terminalActualizacion = :terminalActualizacion"),
    @NamedQuery(name = "PghDetalleDocumentoCriterio.findByIdDetalleDocumentoCriterio", query = "SELECT p FROM PghDetalleDocumentoCriterio p WHERE p.idDetalleDocumentoCriterio = :idDetalleDocumentoCriterio")})
public class PghDetalleDocumentoCriterio extends ColumAddObligacionesTmp {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_DOCUMENTO_CRITERIO")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_DETALLE_DOCU_CRITERIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idDetalleDocumentoCriterio;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_CRITERIO", referencedColumnName = "ID_CRITERIO")
//    @ManyToOne
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghCriterio idCriterio;
    @Basic(optional = true)
    @Column(name = "ID_DOCUMENTO_ADJUNTO")
    private Long idDocumentoAdjunto;

    public PghDetalleDocumentoCriterio() {
    }

    public PghDetalleDocumentoCriterio(Long idDetalleDocumentoCriterio) {
        this.idDetalleDocumentoCriterio = idDetalleDocumentoCriterio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdDetalleDocumentoCriterio() {
        return idDetalleDocumentoCriterio;
    }

    public void setIdDetalleDocumentoCriterio(Long idDetalleDocumentoCriterio) {
        this.idDetalleDocumentoCriterio = idDetalleDocumentoCriterio;
    }

    public PghCriterio getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(PghCriterio idCriterio) {
        this.idCriterio = idCriterio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleDocumentoCriterio != null ? idDetalleDocumentoCriterio.hashCode() : 0);
        return hash;
    }

    public Long getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }

    public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghDetalleDocumentoCriterio)) {
            return false;
        }
        PghDetalleDocumentoCriterio other = (PghDetalleDocumentoCriterio) object;
        if ((this.idDetalleDocumentoCriterio == null && other.idDetalleDocumentoCriterio != null) || (this.idDetalleDocumentoCriterio != null && !this.idDetalleDocumentoCriterio.equals(other.idDetalleDocumentoCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PghDetalleDocumentoCriterio[ idDetalleDocumentoCriterio=" + idDetalleDocumentoCriterio + " ]";
    }
    
}
