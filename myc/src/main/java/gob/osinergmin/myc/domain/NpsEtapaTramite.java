/**
* Resumen		
* Objeto            : NpsEtapaTramite.java
* Descripción       : Clase del modelo de dominio NpsEtapaTramite
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

import java.util.Date;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorojasb
 */
@Entity
@Table(name = "NPS_ETAPA_TRAMITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NpsEtapaTramite.findAll", query = "SELECT n FROM NpsEtapaTramite n"),
    @NamedQuery(name = "NpsEtapaTramite.findByIdEtapaTramite", query = "SELECT n FROM NpsEtapaTramite n WHERE n.idEtapaTramite = :idEtapaTramite")})
public class NpsEtapaTramite extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "NPS_ETAPA_TRAMITE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    @Column(name = "ID_ETAPA_TRAMITE")
    private Long idEtapaTramite;
    @JoinColumn(name = "ID_CONF_TRAMITE", referencedColumnName = "ID_CONF_TRAMITE")
    @ManyToOne(fetch = FetchType.LAZY)
    private NpsConfTramite idConfTramite;
    @JoinColumn(name = "ID_ETAPA", referencedColumnName = "ID_ETAPA")
    @ManyToOne(fetch = FetchType.LAZY)
    private NpsEtapa idEtapa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    
    @Transient
    private Long countSubEtapa;
    
    @Transient
    private Long idResponsable;

 
    /* OSINE_SFS-1232 - lgarciar - Inicio */
    public NpsEtapaTramite(Long idEtapaTramite, Long idConfTramite, Long idTramite, String descTramite, Long idEtapa, String descEtapa, Long plazo, Long idCnfActUniOrganica, Long idActividad, String nombre, Long idResponsable, Long countSubEtapa) {
        this.idEtapaTramite = idEtapaTramite;
        this.idConfTramite = new NpsConfTramite(idCnfActUniOrganica, idActividad, nombre, idConfTramite, descTramite, idTramite);
        this.idEtapa = new NpsEtapa(idEtapa, descEtapa, plazo);
        this.idResponsable = idResponsable;
        this.countSubEtapa = countSubEtapa;               
    }
    /* OSINE_SFS-1232 - lgarciar - Fin */
    
    public NpsEtapaTramite() {
    }

    public NpsEtapaTramite(Long idEtapaTramite) {
        this.idEtapaTramite = idEtapaTramite;
    }

    public NpsEtapaTramite(Long idEtapaTramite, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idEtapaTramite = idEtapaTramite;
    }

    public Long getIdEtapaTramite() {
        return idEtapaTramite;
    }

    public void setIdEtapaTramite(Long idEtapaTramite) {
        this.idEtapaTramite = idEtapaTramite;
    }

    public NpsConfTramite getIdConfTramite() {
        return idConfTramite;
    }

    public void setIdConfTramite(NpsConfTramite idConfTramite) {
        this.idConfTramite = idConfTramite;
    }

    public NpsEtapa getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(NpsEtapa idEtapa) {
        this.idEtapa = idEtapa;
    }

    public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

    
    public Long getCountSubEtapa() {
        return countSubEtapa;
    }

    public void setCountSubEtapa(Long countSubEtapa) {
        this.countSubEtapa = countSubEtapa;
    }
    
    public Long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Long idResponsable) {
        this.idResponsable = idResponsable;
    }
        
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtapaTramite != null ? idEtapaTramite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NpsEtapaTramite)) {
            return false;
        }
        NpsEtapaTramite other = (NpsEtapaTramite) object;
        if ((this.idEtapaTramite == null && other.idEtapaTramite != null) || (this.idEtapaTramite != null && !this.idEtapaTramite.equals(other.idEtapaTramite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.NpsEtapaTramite[ idEtapaTramite=" + idEtapaTramite + " ]";
    }
    
}
