
package gob.osinergmin.myc.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author gvillanueva
 */
@Entity
@Table(name = "PGH_PROCESO_OBLIGACION_TIPO")
@NamedQueries({
    @NamedQuery(name = "PghProcesoObligacionTipo.findAll", query = "SELECT p FROM PghProcesoObligacionTipo p"),
    @NamedQuery(name = "PghProcesoObligacionTipo.findByIdFK", query = "SELECT p FROM PghProcesoObligacionTipo p "
        + "where p.pghProcesoObligacionTipoPK.idObligacionTipo=:idObligacionTipo "
        + "and p.pghProcesoObligacionTipoPK.idProceso=:idProceso "
        + "and p.pghProcesoObligacionTipoPK.idActividad=:idActividad and p.estado='1'")
})
public class PghProcesoObligacionTipo extends Auditoria {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PghProcesoObligacionTipoPK pghProcesoObligacionTipoPK;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_PROCESO", referencedColumnName = "ID_PROCESO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghProceso pghProceso;
    @JoinColumn(name = "ID_OBLIGACION_TIPO", referencedColumnName = "ID_OBLIGACION_TIPO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghObligacionTipo pghObligacionTipo;
    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID_ACTIVIDAD", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MdiActividad mdiActividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pghProcesoObligacionTipo", fetch = FetchType.LAZY)
    private List<PghConfObligacion> pghConfObligacionList;
    
    @Transient
    private Long idProceso;
    @Transient
    private String descripProceso;
    @Transient
    private String descObligTipo;

    public PghProcesoObligacionTipo() {
    }

    public PghProcesoObligacionTipo(PghProcesoObligacionTipoPK pghProcesoObligacionTipoPK) {
        this.pghProcesoObligacionTipoPK = pghProcesoObligacionTipoPK;
    }

    public PghProcesoObligacionTipo(PghProcesoObligacionTipoPK pghProcesoObligacionTipoPK, String estado, Date fechaCreacion, String terminalCreacion, String usuarioCreacion) {
        this.pghProcesoObligacionTipoPK = pghProcesoObligacionTipoPK;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
        this.usuarioCreacion = usuarioCreacion;
    }

    public PghProcesoObligacionTipo(long idObligacionTipo, long idProceso, long idActividad, long idProOblTip) {
        this.pghProcesoObligacionTipoPK = new PghProcesoObligacionTipoPK(idObligacionTipo, idProceso, idActividad, idProOblTip);
    }
    
    public PghProcesoObligacionTipo(long idProOblTip , long idActividad,String nombre,long idObligacionTipo,String descObligTipo,Long idProceso, String descripcionProceso){
    	 this.pghProcesoObligacionTipoPK = new PghProcesoObligacionTipoPK(idObligacionTipo, idProceso, idActividad, idProOblTip);
         this.mdiActividad= new MdiActividad(idActividad,nombre);
         this.pghProceso=new PghProceso(idProceso,descripcionProceso);
         this.pghObligacionTipo=new PghObligacionTipo(idObligacionTipo,descObligTipo);
    }

    public PghProcesoObligacionTipoPK getPghProcesoObligacionTipoPK() {
        return pghProcesoObligacionTipoPK;
    }

    public void setPghProcesoObligacionTipoPK(PghProcesoObligacionTipoPK pghProcesoObligacionTipoPK) {
        this.pghProcesoObligacionTipoPK = pghProcesoObligacionTipoPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PghProceso getPghProceso() {
        return pghProceso;
    }

    public void setPghProceso(PghProceso pghProceso) {
        this.pghProceso = pghProceso;
    }

    public PghObligacionTipo getPghObligacionTipo() {
        return pghObligacionTipo;
    }

    public void setPghObligacionTipo(PghObligacionTipo pghObligacionTipo) {
        this.pghObligacionTipo = pghObligacionTipo;
    }

    public MdiActividad getMdiActividad() {
        return mdiActividad;
    }

    public void setMdiActividad(MdiActividad mdiActividad) {
        this.mdiActividad = mdiActividad;
    }

    public List<PghConfObligacion> getPghConfObligacionList() {
        return pghConfObligacionList;
    }

    public void setPghConfObligacionList(List<PghConfObligacion> pghConfObligacionList) {
        this.pghConfObligacionList = pghConfObligacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pghProcesoObligacionTipoPK != null ? pghProcesoObligacionTipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghProcesoObligacionTipo)) {
            return false;
        }
        PghProcesoObligacionTipo other = (PghProcesoObligacionTipo) object;
        if ((this.pghProcesoObligacionTipoPK == null && other.pghProcesoObligacionTipoPK != null) || (this.pghProcesoObligacionTipoPK != null && !this.pghProcesoObligacionTipoPK.equals(other.pghProcesoObligacionTipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghProcesoObligacionTipo[ pghProcesoObligacionTipoPK=" + pghProcesoObligacionTipoPK + " ]";
    }
    
}
