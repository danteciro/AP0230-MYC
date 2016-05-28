/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_AUTOAYUDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghAutoayuda.findByIdPersonal", query = "SELECT p FROM PghAutoayuda p WHERE p.idAutoayuda=:idAutoyuda "),
    @NamedQuery(name = "PghAutoayuda.findByFilter", query = "SELECT p FROM PghAutoayuda p WHERE upper(p.nombreAutoayuda) like :nombreAutoayuda and upper(p.identificadorAutoayuda) like :identificadorAutoayuda ")
})
public class PghAutoayuda extends Auditoria{
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AUTOAYUDA")
    private Long idAutoayuda;
    @Size(max = 50)
    @Column(name = "NOMBRE_AUTOAYUDA")
    private String nombreAutoayuda;
    @Size(max = 4000)
    @Column(name = "DESCRIPCION_AUTOAYUDA")
    private String descripcionAutoayuda;
    @Size(max = 40)
    @Column(name = "IDENTIFICADOR_AUTOAYUDA")
    private String identificadorAutoayuda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    
    public PghAutoayuda() {
    }

    public PghAutoayuda(Long idAutoayuda) {
        this.idAutoayuda = idAutoayuda;
    }

    public PghAutoayuda(Long idAutoayuda, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idAutoayuda = idAutoayuda;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdAutoayuda() {
        return idAutoayuda;
    }

    public void setIdAutoayuda(Long idAutoayuda) {
        this.idAutoayuda = idAutoayuda;
    }

    public String getNombreAutoayuda() {
        return nombreAutoayuda;
    }

    public void setNombreAutoayuda(String nombreAutoayuda) {
        this.nombreAutoayuda = nombreAutoayuda;
    }

    public String getDescripcionAutoayuda() {
        return descripcionAutoayuda;
    }

    public void setDescripcionAutoayuda(String descripcionAutoayuda) {
        this.descripcionAutoayuda = descripcionAutoayuda;
    }

    public String getIdentificadorAutoayuda() {
        return identificadorAutoayuda;
    }

    public void setIdentificadorAutoayuda(String identificadorAutoayuda) {
        this.identificadorAutoayuda = identificadorAutoayuda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutoayuda != null ? idAutoayuda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghAutoayuda)) {
            return false;
        }
        PghAutoayuda other = (PghAutoayuda) object;
        if ((this.idAutoayuda == null && other.idAutoayuda != null) || (this.idAutoayuda != null && !this.idAutoayuda.equals(other.idAutoayuda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghAutoayuda[ idAutoayuda=" + idAutoayuda + " ]";
    }
    
}
