/**
* Resumen		
* Objeto            : NpsConfTramite.java
* Descripción       : Clase del modelo de dominio NpsConfTramite
* Fecha de Creación : 
* PR de Creación    : 
* Autor             : GMD
* =====================================================================================================================================================================
* Modificaciones |
* Motivo         |   Fecha       |    Nombre                    |   Descripción
* =====================================================================================================================================================================
* OSINE_SFS-1232 | 07/11/2016    |   Luis García Reyna          |   Busqueda por filtros
*
*/ 

package gob.osinergmin.myc.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorojasb
 */
@Entity
@Table(name = "NPS_CONF_TRAMITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NpsConfTramite.findAll", query = "SELECT n FROM NpsConfTramite n"),
    @NamedQuery(name = "NpsConfTramite.findByIdConfTramite", query = "SELECT n FROM NpsConfTramite n WHERE n.idConfTramite = :idConfTramite"),
    @NamedQuery(name = "NpsConfTramite.findByEstado", query = "SELECT n FROM NpsConfTramite n WHERE n.estado = :estado"),
    @NamedQuery(name = "NpsConfTramite.findByOrientacion", query = "SELECT n FROM NpsConfTramite n WHERE n.orientacion = :orientacion"),
    @NamedQuery(name = "NpsConfTramite.findByPorcentajeNotificacion", query = "SELECT n FROM NpsConfTramite n WHERE n.porcentajeNotificacion = :porcentajeNotificacion")})
public class NpsConfTramite extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONF_TRAMITE")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "NPS_CONF_TRAMITE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idConfTramite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 200)
    @Column(name = "ORIENTACION")
    private String orientacion;
    @Column(name = "PORCENTAJE_NOTIFICACION")
    private Short porcentajeNotificacion;
    @JoinColumn(name = "ID_TRAMITE", referencedColumnName = "ID_TRAMITE")
    @ManyToOne(fetch = FetchType.EAGER)
    private NpsTramite idTramite;
    @JoinColumn(name = "ID_CNF_ACT_UNI_ORGANICA", referencedColumnName = "ID_CNF_ACT_UNI_ORGANICA")
    @ManyToOne(fetch = FetchType.EAGER)
    private PghCnfActUniOrganica idCnfActUniOrganica;
    @OneToMany(mappedBy = "idConfTramite", fetch = FetchType.LAZY)
    private List<NpsEtapaTramite> npsEtapaTramiteList;
 
    
    public NpsConfTramite() {
    }
    
    /* OSINE_SFS-1232 - lgarciar - Inicio */
    public NpsConfTramite(Long idCnfActUniOrganica, Long idActividad, String nombre, Long idConfTramite , String descTramite, Long idTramite) {
        this.idCnfActUniOrganica = new PghCnfActUniOrganica(idCnfActUniOrganica,idActividad, nombre);
        this.idConfTramite = idConfTramite;
        this.idTramite = new NpsTramite(descTramite, idTramite);
    }
    /* OSINE_SFS-1232 - lgarciar - Fin */

    public NpsConfTramite(Long idConfTramite, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idConfTramite = idConfTramite;
        this.estado = estado;
     }

    public Long getIdConfTramite() {
        return idConfTramite;
    }

    public void setIdConfTramite(Long idConfTramite) {
        this.idConfTramite = idConfTramite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public Short getPorcentajeNotificacion() {
        return porcentajeNotificacion;
    }

    public void setPorcentajeNotificacion(Short porcentajeNotificacion) {
        this.porcentajeNotificacion = porcentajeNotificacion;
    }


    public NpsTramite getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(NpsTramite idTramite) {
        this.idTramite = idTramite;
    }

    public PghCnfActUniOrganica getIdCnfActUniOrganica() {
        return idCnfActUniOrganica;
    }

    public void setIdCnfActUniOrganica(PghCnfActUniOrganica idCnfActUniOrganica) {
        this.idCnfActUniOrganica = idCnfActUniOrganica;
    }

    @XmlTransient
    public List<NpsEtapaTramite> getNpsEtapaTramiteList() {
        return npsEtapaTramiteList;
    }

    public void setNpsEtapaTramiteList(List<NpsEtapaTramite> npsEtapaTramiteList) {
        this.npsEtapaTramiteList = npsEtapaTramiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConfTramite != null ? idConfTramite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NpsConfTramite)) {
            return false;
        }
        NpsConfTramite other = (NpsConfTramite) object;
        if ((this.idConfTramite == null && other.idConfTramite != null) || (this.idConfTramite != null && !this.idConfTramite.equals(other.idConfTramite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.NpsConfTramite[ idConfTramite=" + idConfTramite + " ]";
    }
    
}
