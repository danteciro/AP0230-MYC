/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.component.ColumAddObligaciones;
import gob.osinergmin.myc.domain.component.ColumAddObligacionesTmp;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author cflorian
 */
@Entity
@Table(name = "PGH_OBLIGACION")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghObligacion.findAll", query = "SELECT p FROM PghObligacion p"),
    @NamedQuery(name = "PghObligacion.findActiveAll", query = "SELECT p FROM PghObligacion p WHERE p.estado='1'"),
    @NamedQuery(name = "PghObligacion.countAll",query="SELECT count(p.idObligacion) FROM PghObligacion p WHERE p.estado='1'"),
    @NamedQuery(name = "PghObligacion.countByFilter",query="SELECT count(p.idObligacion) FROM PghObligacion p WHERE p.estado='1' and upper(p.descripcion) like :descripcion "),
    @NamedQuery(name = "PghObligacion.findByFilter",query="SELECT p FROM PghObligacion p WHERE p.estado='1' and upper(p.descripcion) like :descripcion "),
    @NamedQuery(name = "PghObligacion.findByIdObligacion", query = "SELECT p FROM PghObligacion p WHERE p.estado='1' and p.idObligacion = :idObligacion"),
    @NamedQuery(name = "PghObligacion.findByCodigoObligacion", query = "SELECT p FROM PghObligacion p WHERE p.codigoObligacion = :codigoObligacion"),
    @NamedQuery(name = "PghObligacion.findByFechaEntradaVigencia", query = "SELECT p FROM PghObligacion p WHERE p.fechaEntradaVigencia = :fechaEntradaVigencia"),
    @NamedQuery(name = "PghObligacion.findByFechaTerminoVigencia", query = "SELECT p FROM PghObligacion p WHERE p.fechaTerminoVigencia = :fechaTerminoVigencia"),
    @NamedQuery(name = "PghObligacion.findByIdTipoCreacion", query = "SELECT p FROM PghObligacion p WHERE p.idTipoCreacion = :idTipoCreacion"),
    @NamedQuery(name = "PghObligacion.findByDescripcion", query = "SELECT p FROM PghObligacion p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PghObligacion.findByIdCriticidad", query = "SELECT p FROM PghObligacion p WHERE p.idCriticidad = :idCriticidad"),
    @NamedQuery(name = "PghObligacion.findByEstado", query = "SELECT p FROM PghObligacion p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghObligacion.findByUsuarioCreacion", query = "SELECT p FROM PghObligacion p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghObligacion.findByFechaCreacion", query = "SELECT p FROM PghObligacion p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghObligacion.findByTerminalCreacion", query = "SELECT p FROM PghObligacion p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghObligacion.findByUsuarioActualizacion", query = "SELECT p FROM PghObligacion p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghObligacion.findByFechaActualizacion", query = "SELECT p FROM PghObligacion p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghObligacion.findByTerminalActualizacion", query = "SELECT p FROM PghObligacion p WHERE p.terminalActualizacion = :terminalActualizacion"),
    @NamedQuery(name = "PghObligacion.findByRuta", query = "SELECT p FROM PghObligacion p WHERE p.ruta = :ruta"),
    @NamedQuery(name = "PghObligacion.findByIdObligacionRef", query = "SELECT p FROM PghObligacion p WHERE p.idObligacionRef = :idObligacionRef")})
public class PghObligacion extends ColumAddObligacionesTmp {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_OBLIGACION")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_OBLIGACION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idObligacion;
    @Column(name = "CODIGO_OBLIGACION")
    private String codigoObligacion;
    @Column(name = "FECHA_ENTRADA_VIGENCIA")
    @Temporal(TemporalType.DATE)
    private Date fechaEntradaVigencia;
    @Column(name = "FECHA_TERMINO_VIGENCIA")
    @Temporal(TemporalType.DATE)
    private Date fechaTerminoVigencia;
    @Column(name = "ID_TIPO_CREACION")
    private Long idTipoCreacion;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ID_CRITICIDAD")
    private Long idCriticidad;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "RUTA")
    private String ruta;
    @Column(name = "ID_OBLIGACION_REF")
    private Long idObligacionRef;
    @Basic(optional = true)
    @Column(name = "ID_DOCUMENTO_ADJUNTO")
    private Long idDocumentoAdjunto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idObligacion", fetch = FetchType.LAZY)
    private List<PghDetalleObligacion> pghDetalleObligacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idObligacion", fetch = FetchType.LAZY)
    private List<PghConfObligacion> pghConfObligacionList;
    @OneToMany(mappedBy = "idObligacion", fetch = FetchType.LAZY)
    private List<PghObliTipiCriterio> pghObliTipiCriterioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idObligacion", fetch = FetchType.LAZY)
    private List<PghObligacionTipificacion> pghObligacionTipificacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idObligacion", fetch = FetchType.LAZY)
    private List<PghTemaObligacionMaestro> pghTemaObligacionMaestroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idObligacion", fetch = FetchType.LAZY)
    private List<PghObligacionBaseLegal> pghObligacionBaseLegalList;
    
    @Transient
    private Long tieneAct;

    public PghObligacion() {
    }

    public PghObligacion(Long idObligacion) {
        this.idObligacion = idObligacion;
    }
    
    public PghObligacion(Long idObligacion, String codigoObligacion, String descripcion,String estado,Long tieneAct) {
        this.idObligacion = idObligacion;
        this.codigoObligacion = codigoObligacion;
        this.descripcion = descripcion;
        this.estado=estado;
        this.tieneAct = tieneAct;
    }
    
    public PghObligacion(Long idObligacion, String codigoObligacion, String descripcion) {
        this.idObligacion = idObligacion;
        this.codigoObligacion=codigoObligacion;
        this.descripcion=descripcion;
    }
    public Long getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(Long idObligacion) {
        this.idObligacion = idObligacion;
    }

    public String getCodigoObligacion() {
        return codigoObligacion;
    }

    public void setCodigoObligacion(String codigoObligacion) {
        this.codigoObligacion = codigoObligacion;
    }

    public Date getFechaEntradaVigencia() {
        return fechaEntradaVigencia;
    }

    public void setFechaEntradaVigencia(Date fechaEntradaVigencia) {
        this.fechaEntradaVigencia = fechaEntradaVigencia;
    }

    public Date getFechaTerminoVigencia() {
        return fechaTerminoVigencia;
    }

    public void setFechaTerminoVigencia(Date fechaTerminoVigencia) {
        this.fechaTerminoVigencia = fechaTerminoVigencia;
    }

    public Long getIdTipoCreacion() {
        return idTipoCreacion;
    }

    public void setIdTipoCreacion(Long idTipoCreacion) {
        this.idTipoCreacion = idTipoCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdCriticidad() {
        return idCriticidad;
    }

    public void setIdCriticidad(Long idCriticidad) {
        this.idCriticidad = idCriticidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Long getIdObligacionRef() {
        return idObligacionRef;
    }

    public void setIdObligacionRef(Long idObligacionRef) {
        this.idObligacionRef = idObligacionRef;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghDetalleObligacion> getPghDetalleObligacionList() {
        return pghDetalleObligacionList;
    }

    public void setPghDetalleObligacionList(List<PghDetalleObligacion> pghDetalleObligacionList) {
        this.pghDetalleObligacionList = pghDetalleObligacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghConfObligacion> getPghConfObligacionList() {
        return pghConfObligacionList;
    }

    public void setPghConfObligacionList(
        List<PghConfObligacion> pghConfObligacionList) {
        this.pghConfObligacionList = pghConfObligacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghObligacionTipificacion> getPghObligacionTipificacionList() {
        return pghObligacionTipificacionList;
    }

    public void setPghObligacionTipificacionList(List<PghObligacionTipificacion> pghObligacionTipificacionList) {
        this.pghObligacionTipificacionList = pghObligacionTipificacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghTemaObligacionMaestro> getPghTemaObligacionMaestroList() {
        return pghTemaObligacionMaestroList;
    }

    public void setPghTemaObligacionMaestroList(List<PghTemaObligacionMaestro> pghTemaObligacionMaestroList) {
        this.pghTemaObligacionMaestroList = pghTemaObligacionMaestroList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghObligacionBaseLegal> getPghObligacionBaseLegalList() {
        return pghObligacionBaseLegalList;
    }

    public void setPghObligacionBaseLegalList(List<PghObligacionBaseLegal> pghObligacionBaseLegalList) {
        this.pghObligacionBaseLegalList = pghObligacionBaseLegalList;
    }

    public Long getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }

    public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }    
    
    public List<PghObliTipiCriterio> getPghObliTipiCriterioList() {
		return pghObliTipiCriterioList;
	}

	public void setPghObliTipiCriterioList(
			List<PghObliTipiCriterio> pghObliTipiCriterioList) {
		this.pghObliTipiCriterioList = pghObliTipiCriterioList;
	}
	
	public Long getTieneAct() {
		return tieneAct;
	}

	public void setTieneAct(Long tieneAct) {
		this.tieneAct = tieneAct;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idObligacion != null ? idObligacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghObligacion)) {
            return false;
        }
        PghObligacion other = (PghObligacion) object;
        if ((this.idObligacion == null && other.idObligacion != null) || (this.idObligacion != null && !this.idObligacion.equals(other.idObligacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PghObligacion[ idObligacion=" + idObligacion + " ]";
    }
    
}
