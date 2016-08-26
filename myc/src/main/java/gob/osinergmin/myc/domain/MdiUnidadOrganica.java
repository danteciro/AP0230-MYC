/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author mdiosesf
 */
@Entity
@Table(name = "MDI_UNIDAD_ORGANICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiUnidadOrganica.findAll", query = "SELECT m FROM MdiUnidadOrganica m WHERE m.estado='1' AND m.nivel IS NOT NULL ORDER BY m.idUnidadOrganica"),
    @NamedQuery(name = "MdiUnidadOrganica.findByIdUnidadOrganica", query = "SELECT m FROM MdiUnidadOrganica m WHERE m.estado='1' and m.idUnidadOrganica = :idUnidadOrganica"),
    @NamedQuery(name = "MdiUnidadOrganica.findByIdUnidadOrganicaSuperior", query = "SELECT m FROM MdiUnidadOrganica m WHERE m.estado='1' and m.idUnidadOrganicaSuperior = :idUnidadOrganicaSuperior AND m.nivel IS NOT NULL"),    
    @NamedQuery(name = "MdiUnidadOrganica.findByFiltroIdUnidadOrganicaSuperior", query = "SELECT m FROM MdiUnidadOrganica m WHERE m.estado = '1' AND m.idUnidadOrganicaSuperior = :idUnidadOrganicaSuperior AND m.descripcion = :descripcion AND m.codDepSiga = :codDepSiga AND m.sigla = :sigla AND m.nivel IS NOT NULL"),
    @NamedQuery(name = "MdiUnidadOrganica.findNivel", query = "SELECT m FROM MdiUnidadOrganica m WHERE m.estado='1' AND m.nivel = :nivel")})
public class MdiUnidadOrganica extends Auditoria {
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UNIDAD_ORGANICA")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "mdi_unidad_organica_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idUnidadOrganica;
    @Column(name = "ID_UNIDAD_ORGANICA_SUPERIOR")
    private Long idUnidadOrganicaSuperior;
    @Column(name = "SEDE")
    private Long sede;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "DETALLE")
    private String detalle;
    @Column(name = "COD_DEP_SIGA")
    private String codDepSiga;
    @Column(name = "ID_TIPO_UNIDAD_ORGANICA")
    private Long idTipoUnidadOrganica;
    @Column(name = "SIGLA")
    private String sigla;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "NIVEL")
    private Long nivel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NOMBRE_NIVEL")
    private MdiMaestroColumna nombreNivel;
    @OneToMany(mappedBy = "idUnidadOrganica", fetch = FetchType.LAZY)
    private List<PghPersonalUnidadOrganica> pghPersonalUnidadOrganicaList;
    @OneToMany(mappedBy = "idUnidadOrganica", fetch = FetchType.LAZY)
    private List<PghCnfActUniOrganica> pghCnfActUniOrganicaList;
    
    public MdiUnidadOrganica() {
    }
    public MdiUnidadOrganica(Long idUnidadOrganica, String descripcion, String detalle, String codDepSiga, String sigla, String estado) {
        this.idUnidadOrganica = idUnidadOrganica;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.codDepSiga = codDepSiga;
        this.sigla = sigla;
        this.estado = estado;
    }
    public MdiUnidadOrganica(Long idUnidadOrganica) {
        this.idUnidadOrganica = idUnidadOrganica;
    }

    public Long getIdUnidadOrganica() {
        return idUnidadOrganica;
    }

    public void setIdUnidadOrganica(Long idUnidadOrganica) {
        this.idUnidadOrganica = idUnidadOrganica;
    }

    public Long getIdUnidadOrganicaSuperior() {
        return idUnidadOrganicaSuperior;
    }

    public void setIdUnidadOrganicaSuperior(Long idUnidadOrganicaSuperior) {
        this.idUnidadOrganicaSuperior = idUnidadOrganicaSuperior;
    }

    public Long getSede() {
        return sede;
    }

    public void setSede(Long sede) {
        this.sede = sede;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getCodDepSiga() {
        return codDepSiga;
    }

    public void setCodDepSiga(String codDepSiga) {
        this.codDepSiga = codDepSiga;
    }

    public Long getIdTipoUnidadOrganica() {
        return idTipoUnidadOrganica;
    }

    public void setIdTipoUnidadOrganica(Long idTipoUnidadOrganica) {
        this.idTipoUnidadOrganica = idTipoUnidadOrganica;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getNivel() {
        return nivel;
    }

    public void setNivel(Long nivel) {
            this.nivel = nivel;
    }

    public MdiMaestroColumna getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(MdiMaestroColumna nombreNivel) {
        this.nombreNivel = nombreNivel;
    }    
    
	@XmlTransient
    public List<PghCnfActUniOrganica> getPghCnfActUniOrganicaList() {
		return pghCnfActUniOrganicaList;
	}

	public void setPghCnfActUniOrganicaList(
			List<PghCnfActUniOrganica> pghCnfActUniOrganicaList) {
		this.pghCnfActUniOrganicaList = pghCnfActUniOrganicaList;
	}
	
    @XmlTransient
    @JsonIgnore
    public List<PghPersonalUnidadOrganica> getPghPersonalUnidadOrganicaList() {
        return pghPersonalUnidadOrganicaList;
    }

    public void setPghPersonalUnidadOrganicaList(List<PghPersonalUnidadOrganica> pghPersonalUnidadOrganicaList) {
        this.pghPersonalUnidadOrganicaList = pghPersonalUnidadOrganicaList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadOrganica != null ? idUnidadOrganica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiUnidadOrganica)) {
            return false;
        }
        MdiUnidadOrganica other = (MdiUnidadOrganica) object;
        if ((this.idUnidadOrganica == null && other.idUnidadOrganica != null) || (this.idUnidadOrganica != null && !this.idUnidadOrganica.equals(other.idUnidadOrganica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.inps.domain.MdiUnidadOrganica[ idUnidadOrganica=" + idUnidadOrganica + " ]";
    }
}
