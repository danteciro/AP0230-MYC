/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "MDI_SUPERVISORA_EMPRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiSupervisoraEmpresa.findAll", query = "SELECT m FROM MdiSupervisoraEmpresa m")})
public class MdiSupervisoraEmpresa extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUPERVISORA_EMPRESA")
    private Long idSupervisoraEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_EMPRESA_CONSTITUCION")
    private long tipoEmpresaConstitucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "RUC")
    private String ruc;
    @Size(max = 50)
    @Column(name = "CIIU_PRINCIPAL")
    private String ciiuPrincipal;
    @Size(max = 100)
    @Column(name = "PAGINA_WEB")
    private String paginaWeb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private char estado;
    @Size(max = 2)
    @Column(name = "ORIGEN_INFORMACION")
    private String origenInformacion;
    @OneToMany(mappedBy = "idSupervisoraEmpresa", fetch = FetchType.LAZY)
    private List<MdiContratoEmpresaLocador> mdiContratoEmpresaLocadorList;

    public MdiSupervisoraEmpresa() {
    }

    public MdiSupervisoraEmpresa(Long idSupervisoraEmpresa) {
        this.idSupervisoraEmpresa = idSupervisoraEmpresa;
    }

    public MdiSupervisoraEmpresa(Long idSupervisoraEmpresa, long tipoEmpresaConstitucion, String razonSocial, String ruc, char estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idSupervisoraEmpresa = idSupervisoraEmpresa;
        this.tipoEmpresaConstitucion = tipoEmpresaConstitucion;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdSupervisoraEmpresa() {
        return idSupervisoraEmpresa;
    }

    public void setIdSupervisoraEmpresa(Long idSupervisoraEmpresa) {
        this.idSupervisoraEmpresa = idSupervisoraEmpresa;
    }

    public long getTipoEmpresaConstitucion() {
        return tipoEmpresaConstitucion;
    }

    public void setTipoEmpresaConstitucion(long tipoEmpresaConstitucion) {
        this.tipoEmpresaConstitucion = tipoEmpresaConstitucion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCiiuPrincipal() {
        return ciiuPrincipal;
    }

    public void setCiiuPrincipal(String ciiuPrincipal) {
        this.ciiuPrincipal = ciiuPrincipal;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getOrigenInformacion() {
        return origenInformacion;
    }

    public void setOrigenInformacion(String origenInformacion) {
        this.origenInformacion = origenInformacion;
    }

    @XmlTransient
    public List<MdiContratoEmpresaLocador> getMdiContratoEmpresaLocadorList() {
        return mdiContratoEmpresaLocadorList;
    }

    public void setMdiContratoEmpresaLocadorList(List<MdiContratoEmpresaLocador> mdiContratoEmpresaLocadorList) {
        this.mdiContratoEmpresaLocadorList = mdiContratoEmpresaLocadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSupervisoraEmpresa != null ? idSupervisoraEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiSupervisoraEmpresa)) {
            return false;
        }
        MdiSupervisoraEmpresa other = (MdiSupervisoraEmpresa) object;
        if ((this.idSupervisoraEmpresa == null && other.idSupervisoraEmpresa != null) || (this.idSupervisoraEmpresa != null && !this.idSupervisoraEmpresa.equals(other.idSupervisoraEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.MdiSupervisoraEmpresa[ idSupervisoraEmpresa=" + idSupervisoraEmpresa + " ]";
    }
    
}
