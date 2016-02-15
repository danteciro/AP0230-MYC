/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.component.ColumAddObligacionesTmp;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author cflorian
 */
@Entity
@Table(name = "PGH_CRITERIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghCriterio.countAll", query = "SELECT count(p.idCriterio) FROM PghCriterio p"),
    @NamedQuery(name = "PghCriterio.findAll", query = "SELECT p FROM PghCriterio p"),
    @NamedQuery(name = "PghCriterio.countByFilter", query = "SELECT count(p.idCriterio) FROM PghCriterio p WHERE p.estado='1' and upper(p.descripcion) like :descripcion"),
    @NamedQuery(name = "PghCriterio.findByFilter", query = "SELECT p FROM PghCriterio p WHERE p.estado='1' and upper(p.descripcion) like :descripcion"),
    @NamedQuery(name = "PghCriterio.countByIdCriterio", query = "SELECT count(p.idCriterio) FROM PghCriterio p WHERE p.idCriterio = :idCriterio"),
    @NamedQuery(name = "PghCriterio.findByIdCriterio", query = "SELECT p FROM PghCriterio p WHERE p.idCriterio = :idCriterio"),
    @NamedQuery(name = "PghCriterio.findByDescripcion", query = "SELECT p FROM PghCriterio p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PghCriterio.findByUsuarioCreacion", query = "SELECT p FROM PghCriterio p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghCriterio.findByFechaCreacion", query = "SELECT p FROM PghCriterio p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghCriterio.findByTerminalCreacion", query = "SELECT p FROM PghCriterio p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghCriterio.findByUsuarioActualizacion", query = "SELECT p FROM PghCriterio p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghCriterio.findByFechaActualizacion", query = "SELECT p FROM PghCriterio p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghCriterio.findByTerminalActualizacion", query = "SELECT p FROM PghCriterio p WHERE p.terminalActualizacion = :terminalActualizacion"),
    @NamedQuery(name = "PghCriterio.findByEstado", query = "SELECT p FROM PghCriterio p WHERE p.estado = :estado"),   
    })



public class PghCriterio extends ColumAddObligacionesTmp {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CRITERIO")
    @NotNull
    @SequenceGenerator(name = "ID_CRITERIO_SEQ", sequenceName = "PGH_CRITERIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CRITERIO_SEQ")
    private Long idCriterio;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "SANCION_MONETARIA")
    private String sancionMonetaria;
    @Column(name = "ESTADO")
    private String estado;
//    @OneToMany(mappedBy = "idCriterio")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterio", fetch = FetchType.LAZY)
    private List<PghDetalleDocumentoCriterio> pghDetalleDocumentoCriterioList;
//    @JoinColumn(name = "ID_TIPIFICACION", referencedColumnName = "ID_TIPIFICACION")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterio", fetch = FetchType.LAZY)
    private List<PghDetalleCriterio> pghDetalleCriterioList;
    @OneToMany(mappedBy = "idCriterio", fetch = FetchType.LAZY)
    private List<PghObliTipiCriterio> pghObliTipiCriterioList;
    @OneToMany(mappedBy = "idCriterio", fetch = FetchType.LAZY)
    private List<PghTipificacionSancion> pghTipificacionSancionList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIPO_CRITERIO")    
    private MdiMaestroColumna tipoCriterio;
// 05-11-2015
    @Column(name = "BASES_LEGALES")
    private String basesLegales;
//   
    
    public PghCriterio() {
    }

    public PghCriterio(Long idCriterio) {
        this.idCriterio = idCriterio;
    }

    public Long getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Long idCriterio) {
        this.idCriterio = idCriterio;
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

    @XmlTransient
    public List<PghDetalleDocumentoCriterio> getPghDetalleDocumentoCriterioList() {
        return pghDetalleDocumentoCriterioList;
    }

    public void setPghDetalleDocumentoCriterioList(List<PghDetalleDocumentoCriterio> pghDetalleDocumentoCriterioList) {
        this.pghDetalleDocumentoCriterioList = pghDetalleDocumentoCriterioList;
    }

    public String getSancionMonetaria() {
		return sancionMonetaria;
	}

	public void setSancionMonetaria(String sancionMonetaria) {
		this.sancionMonetaria = sancionMonetaria;
	}
	
	public List<PghObliTipiCriterio> getPghObliTipiCriterioList() {
		return pghObliTipiCriterioList;
	}

	public void setPghObliTipiCriterioList(
			List<PghObliTipiCriterio> pghObliTipiCriterioList) {
		this.pghObliTipiCriterioList = pghObliTipiCriterioList;
	}

	public List<PghTipificacionSancion> getPghTipificacionSancionList() {
		return pghTipificacionSancionList;
	}

	public void setPghTipificacionSancionList(
			List<PghTipificacionSancion> pghTipificacionSancionList) {
		this.pghTipificacionSancionList = pghTipificacionSancionList;
	}

	//    @XmlTransient
//    public List<PghDetalleCriterio> getPghDetalleCriterioList() {
//        return pghDetalleCriterioList;
//    }
//
//    public void setPghDetalleCriterioList(List<PghDetalleCriterio> pghDetalleCriterioList) {
//        this.pghDetalleCriterioList = pghDetalleCriterioList;
//    }
    @XmlTransient
    @JsonIgnore
    public List<PghDetalleCriterio> getPghDetalleCriterioList() {
        return pghDetalleCriterioList;
    }

    public void setPghDetalleCriterioList(List<PghDetalleCriterio> pghDetalleCriterioList) {
        this.pghDetalleCriterioList = pghDetalleCriterioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriterio != null ? idCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghCriterio)) {
            return false;
        }
        PghCriterio other = (PghCriterio) object;
        if ((this.idCriterio == null && other.idCriterio != null) || (this.idCriterio != null && !this.idCriterio.equals(other.idCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PghCriterio[ idCriterio=" + idCriterio + " ]";
    }
    
    public MdiMaestroColumna getTipoCriterio() {
        return tipoCriterio;
    }

    public void setTipoCriterio(MdiMaestroColumna tipoCriterio) {
        this.tipoCriterio = tipoCriterio;
    }
    
    public PghCriterio(Long idCriterio, String descripcion) {
        this.idCriterio = idCriterio;
        this.descripcion= descripcion;
    }

	public String getBasesLegales() {
		return basesLegales;
	}

	public void setBasesLegales(String basesLegales) {
		this.basesLegales = basesLegales;
	}

    
}
