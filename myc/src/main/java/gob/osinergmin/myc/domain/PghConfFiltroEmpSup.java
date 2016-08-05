/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mdiosesf
 */
@Entity
@Table(name = "PGH_CONF_FILTRO_EMP_SUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghConfFiltroEmpSup.findAll", query = "SELECT p FROM PghConfFiltroEmpSup p WHERE p.estado = '1'"),
    @NamedQuery(name = "PghConfFiltroEmpSup.findByIdFiltroEmpSup", query = "SELECT p FROM PghConfFiltroEmpSup p WHERE p.idFiltroEmpSup = :idFiltroEmpSup"),
    @NamedQuery(name = "PghConfFiltroEmpSup.findByIdFiltroIdUnidadOrganica", query = "SELECT p FROM PghConfFiltroEmpSup p WHERE p.idFiltro = :idFiltro AND p.idUnidadOrganica = :idUnidadOrganica"),
    @NamedQuery(name = "PghConfFiltroEmpSup.findByIdUnidadOrganica", query = "SELECT p FROM PghConfFiltroEmpSup p WHERE p.estado = '1' AND p.idUnidadOrganica = :idUnidadOrganica")})
public class PghConfFiltroEmpSup extends Auditoria {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="SEQ_GENERATOR", sequenceName="PGH_CONF_FILTRO_EMP_SUP_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GENERATOR")
    @Column(name = "ID_FILTRO_EMP_SUP")
    private Long idFiltroEmpSup;
    @Basic(optional = false)
    @Column(name = "ID_FILTRO")
    private long idFiltro;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "ID_UNIDAD_ORGANICA")
    private long idUnidadOrganica;

    public PghConfFiltroEmpSup() {
    }

    public PghConfFiltroEmpSup(Long idFiltroEmpSup) {
        this.idFiltroEmpSup = idFiltroEmpSup;
    }

    public PghConfFiltroEmpSup(Long idFiltroEmpSup, long idFiltro, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion) {
        this.idFiltroEmpSup = idFiltroEmpSup;
        this.idFiltro = idFiltro;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdFiltroEmpSup() {
        return idFiltroEmpSup;
    }

    public void setIdFiltroEmpSup(Long idFiltroEmpSup) {
        this.idFiltroEmpSup = idFiltroEmpSup;
    }

    public long getIdFiltro() {
        return idFiltro;
    }

    public void setIdFiltro(long idFiltro) {
        this.idFiltro = idFiltro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public String getTerminalCreacion() {
        return terminalCreacion;
    }

    public void setTerminalCreacion(String terminalCreacion) {
        this.terminalCreacion = terminalCreacion;
    }

    public String getTerminalActualizacion() {
        return terminalActualizacion;
    }

    public void setTerminalActualizacion(String terminalActualizacion) {
        this.terminalActualizacion = terminalActualizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getIdUnidadOrganica() {
        return idUnidadOrganica;
    }

    public void setIdUnidadOrganica(Long idUnidadOrganica) {
        this.idUnidadOrganica = idUnidadOrganica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFiltroEmpSup != null ? idFiltroEmpSup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghConfFiltroEmpSup)) {
            return false;
        }
        PghConfFiltroEmpSup other = (PghConfFiltroEmpSup) object;
        if ((this.idFiltroEmpSup == null && other.idFiltroEmpSup != null) || (this.idFiltroEmpSup != null && !this.idFiltroEmpSup.equals(other.idFiltroEmpSup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HIBERNATE.PghConfFiltroEmpSup[ idFiltroEmpSup=" + idFiltroEmpSup + " ]";
    }    
}
