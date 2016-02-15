/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cflorian
 */
@Entity
@Table(name = "PGH_DETALLE_CRITERIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghDetalleCriterio.countAll", query = "SELECT count(p.idDetalleCriterio) FROM PghDetalleCriterio p"),
    @NamedQuery(name = "PghDetalleCriterio.findAll", query = "SELECT p FROM PghDetalleCriterio p"),
    @NamedQuery(name = "PghDetalleCriterio.countByFilter", query = "SELECT count(p.idDetalleCriterio) FROM PghDetalleCriterio p WHERE p.estado='1' and upper(p.sancionEspecifica) like :sancionEspecifica"),
    @NamedQuery(name = "PghDetalleCriterio.countByFilterDetalle", query = "SELECT count(p.idDetalleCriterio) FROM PghDetalleCriterio p WHERE p.idCriterio.idCriterio =:idCriterio and p.estado='1' "),
    @NamedQuery(name = "PghDetalleCriterio.findByFilter", query = "SELECT p FROM PghDetalleCriterio p WHERE p.estado='1' and upper(p.sancionEspecifica) like :sancionEspecifica"),
    @NamedQuery(name = "PghDetalleCriterio.countByIdDetalleCriterio", query = "SELECT count(p.idDetalleCriterio) FROM PghDetalleCriterio p WHERE p.idDetalleCriterio = :idDetalleCriterio"),
    @NamedQuery(name = "PghDetalleCriterio.findByIdDetalleCriterio", query = "SELECT p FROM PghDetalleCriterio p WHERE p.idDetalleCriterio = :idDetalleCriterio"),
    @NamedQuery(name = "PghDetalleCriterio.findByIdDetalleCriterioDetalle", query = "SELECT p FROM PghDetalleCriterio p WHERE p.idCriterio.idCriterio = :idCriterio and p.estado='1' "),
    @NamedQuery(name = "PghDetalleCriterio.findBySancionEspecifica", query = "SELECT p FROM PghDetalleCriterio p WHERE p.sancionEspecifica = :sancionEspecifica"),
    @NamedQuery(name = "PghDetalleCriterio.findByUsuarioCreacion", query = "SELECT p FROM PghDetalleCriterio p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghDetalleCriterio.findByFechaCreacion", query = "SELECT p FROM PghDetalleCriterio p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghDetalleCriterio.findByTerminalCreacion", query = "SELECT p FROM PghDetalleCriterio p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghDetalleCriterio.findByUsuarioActualizacion", query = "SELECT p FROM PghDetalleCriterio p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghDetalleCriterio.findByFechaActualizacion", query = "SELECT p FROM PghDetalleCriterio p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghDetalleCriterio.findByTerminalActualizacion", query = "SELECT p FROM PghDetalleCriterio p WHERE p.terminalActualizacion = :terminalActualizacion"),
    @NamedQuery(name = "PghDetalleCriterio.findByEstado", query = "SELECT p FROM PghDetalleCriterio p WHERE p.estado = :estado")})
public class PghDetalleCriterio extends ColumAddObligacionesTmp {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_CRITERIO")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_DETALLE_CRITERIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idDetalleCriterio;
    @Column(name = "SANCION_ESPECIFICA")
    private String sancionEspecifica;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "SANCION_MONETARIA")
    private String sancionMonetaria;
    @JoinColumn(name = "ID_CRITERIO", referencedColumnName = "ID_CRITERIO")
//    @ManyToOne
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghCriterio idCriterio;
    @OneToMany(mappedBy = "idDetalleCriterio", fetch = FetchType.LAZY)
    private List<PghTipificacionSancion> pghTipificacionSancionList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIPO_SANCION_ESPECIFICA")    
    private MdiMaestroColumna tipoSancionEspecifica;

    public PghDetalleCriterio() {
    }

    public PghDetalleCriterio(Long idDetalleCriterio) {
        this.idDetalleCriterio = idDetalleCriterio;
    }

    public Long getIdDetalleCriterio() {
        return idDetalleCriterio;
    }

    public void setIdDetalleCriterio(Long idDetalleCriterio) {
        this.idDetalleCriterio = idDetalleCriterio;
    }

    public String getSancionEspecifica() {
        return sancionEspecifica;
    }

    public void setSancionEspecifica(String sancionEspecifica) {
        this.sancionEspecifica = sancionEspecifica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PghCriterio getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(PghCriterio idCriterio) {
        this.idCriterio = idCriterio;
    }
    

    public String getSancionMonetaria() {
		return sancionMonetaria;
	}

	public void setSancionMonetaria(String sancionMonetaria) {
		this.sancionMonetaria = sancionMonetaria;
	}

	public MdiMaestroColumna getTipoSancionEspecifica() {
		return tipoSancionEspecifica;
	}

	public void setTipoSancionEspecifica(MdiMaestroColumna tipoSancionEspecifica) {
		this.tipoSancionEspecifica = tipoSancionEspecifica;
	}	

	public List<PghTipificacionSancion> getPghTipificacionSancionList() {
		return pghTipificacionSancionList;
	}

	public void setPghTipificacionSancionList(
			List<PghTipificacionSancion> pghTipificacionSancionList) {
		this.pghTipificacionSancionList = pghTipificacionSancionList;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCriterio != null ? idDetalleCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghDetalleCriterio)) {
            return false;
        }
        PghDetalleCriterio other = (PghDetalleCriterio) object;
        if ((this.idDetalleCriterio == null && other.idDetalleCriterio != null) || (this.idDetalleCriterio != null && !this.idDetalleCriterio.equals(other.idDetalleCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PghDetalleCriterio[ idDetalleCriterio=" + idDetalleCriterio + " ]";
    }
    
}
