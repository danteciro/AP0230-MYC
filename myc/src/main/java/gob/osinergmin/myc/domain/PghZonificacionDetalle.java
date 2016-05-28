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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_ZONIFICACION_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghZonificacionDetalle.findAll", query = "SELECT u FROM PghZonificacionDetalle u "
        + " where u.estado=:estado and "
        + " u.mdiUbigeo.mdiUbigeoPK.idDistrito = :idDistrito and "
        + " u.mdiUbigeo.mdiUbigeoPK.idDepartamento = :idDepartamento and "
        + " u.mdiUbigeo.mdiUbigeoPK.idProvincia = :idProvincia "),
    @NamedQuery(name = "PghZonificacionDetalle.findByIdZonificacionDetalleUbigeo", query = "SELECT u FROM PghZonificacionDetalle u "
        + " where u.estado=:estado and "
        + " u.idZonificacion.idZonificacion = :idZonificacion and"
        + " u.mdiUbigeo.mdiUbigeoPK.idDistrito = :idDistrito and "
        + " u.mdiUbigeo.mdiUbigeoPK.idDepartamento = :idDepartamento and "
        + " u.mdiUbigeo.mdiUbigeoPK.idProvincia = :idProvincia "),
    @NamedQuery(name = "PghZonificacionDetalle.findByIdZonificacionDetalle", query = "SELECT p FROM PghZonificacionDetalle p where p.idZonificacionDetalle=:idZonificacionDetalle"),
    @NamedQuery(name = "PghZonificacionDetalle.findByFilter", 
        query = "SELECT new PghZonificacionDetalle(zd.idZonificacionDetalle,zd.idZonificacion.idZonificacion,zo.nombre,"
        + "zd.mdiUbigeo.mdiUbigeoPK.idDepartamento,zd.mdiUbigeo.mdiUbigeoPK.idProvincia,zd.mdiUbigeo.mdiUbigeoPK.idDistrito,zd.mdiUbigeo.nombre, "
        + " (SELECT up.nombre " +
                "FROM MdiUbigeo up " +
                "WHERE " +
                " up.mdiUbigeoPK.idDepartamento = zd.mdiUbigeo.mdiUbigeoPK.idDepartamento and " +        
                " up.mdiUbigeoPK.idProvincia = zd.mdiUbigeo.mdiUbigeoPK.idProvincia and " +
                " up.mdiUbigeoPK.idDistrito = '00'), "
        + " (SELECT ud.nombre " +
                "FROM MdiUbigeo ud " +
                "WHERE " +
                " ud.mdiUbigeoPK.idDepartamento = zd.mdiUbigeo.mdiUbigeoPK.idDepartamento and " +        
                " ud.mdiUbigeoPK.idProvincia = '00' and " +
                " ud.mdiUbigeoPK.idDistrito = '00') "
        + ") "
        + "FROM PghZonificacionDetalle zd "
        + "LEFT JOIN zd.idZonificacion zo "
        + " where zd.estado=:estado and  "
        + " zd.idZonificacion.idZonificacion=:idZonificacion "),
    @NamedQuery(name = "PghZonificacionDetalle.findAllByFilter", 
        query = "SELECT new PghZonificacionDetalle(zd.idZonificacionDetalle,zd.idZonificacion.idZonificacion,zo.nombre,"
        + "zd.mdiUbigeo.mdiUbigeoPK.idDepartamento,zd.mdiUbigeo.mdiUbigeoPK.idProvincia,zd.mdiUbigeo.mdiUbigeoPK.idDistrito,zd.mdiUbigeo.nombre, "
        + " (SELECT up.nombre " +
                "FROM MdiUbigeo up " +
                "WHERE " +
                " up.mdiUbigeoPK.idDepartamento = zd.mdiUbigeo.mdiUbigeoPK.idDepartamento and " +        
                " up.mdiUbigeoPK.idProvincia = zd.mdiUbigeo.mdiUbigeoPK.idProvincia and " +
                " up.mdiUbigeoPK.idDistrito = '00'), "
        + " (SELECT ud.nombre " +
                "FROM MdiUbigeo ud " +
                "WHERE " +
                " ud.mdiUbigeoPK.idDepartamento = zd.mdiUbigeo.mdiUbigeoPK.idDepartamento and " +        
                " ud.mdiUbigeoPK.idProvincia = '00' and " +
                " ud.mdiUbigeoPK.idDistrito = '00') "
        + ") "
        + "FROM PghZonificacionDetalle zd "
        + "LEFT JOIN zd.idZonificacion zo "
        + " where zd.estado=:estado ")
})
public class PghZonificacionDetalle extends Auditoria{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ZONIFICACION_DETALLE")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_ZONIFICACION_DET_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idZonificacionDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_ZONIFICACION", referencedColumnName = "ID_ZONIFICACION")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghZonificacion idZonificacion;
    @JoinColumns({
        @JoinColumn(name = "ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO"),
        @JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "ID_PROVINCIA"),
        @JoinColumn(name = "ID_DISTRITO", referencedColumnName = "ID_DISTRITO")})
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiUbigeo mdiUbigeo;
    /*@JoinColumns({
        @JoinColumn(name = "ID_MACRO_REGION", referencedColumnName = "ID_MACRO_REGION"),
        @JoinColumn(name = "ID_REGION", referencedColumnName = "ID_REGION")})
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiMacroRegionXRegion mdiMacroRegionXRegion;*/
    
    //LBARBOZA
    @Transient
    private String UbigeoProvincia;
    @Transient
    private String UbigeoDepartamento;
    @Transient
    private String nombreZonificacion;

    public PghZonificacionDetalle() {
    }

    public PghZonificacionDetalle(Long idZonificacionDetalle) {
        this.idZonificacionDetalle = idZonificacionDetalle;
    }
    
    public PghZonificacionDetalle(Long idZonificacionDetalle, Long idZonificacion, String nombreZonificacion, String idDepartamento,
            String idProvincia, String idDistrito, String nombreDistrito, String nombreProvincia, String nombreDepartamento){
        this.idZonificacionDetalle = idZonificacionDetalle;
        this.idZonificacion = new PghZonificacion(idZonificacion);
        this.nombreZonificacion = nombreZonificacion;
        this.mdiUbigeo = new MdiUbigeo(idDepartamento, idProvincia, idDistrito, nombreDistrito);
        this.UbigeoProvincia = nombreProvincia;
        this.UbigeoDepartamento = nombreDepartamento;
    }

    public PghZonificacionDetalle(Long idZonificacionDetalle, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idZonificacionDetalle = idZonificacionDetalle;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdZonificacionDetalle() {
        return idZonificacionDetalle;
    }

    public void setIdZonificacionDetalle(Long idZonificacionDetalle) {
        this.idZonificacionDetalle = idZonificacionDetalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PghZonificacion getIdZonificacion() {
        return idZonificacion;
    }

    public void setIdZonificacion(PghZonificacion idZonificacion) {
        this.idZonificacion = idZonificacion;
    }

    public MdiUbigeo getMdiUbigeo() {
        return mdiUbigeo;
    }

    public void setMdiUbigeo(MdiUbigeo mdiUbigeo) {
        this.mdiUbigeo = mdiUbigeo;
    }

    public String getUbigeoProvincia() {
        return UbigeoProvincia;
    }

    public void setUbigeoProvincia(String UbigeoProvincia) {
        this.UbigeoProvincia = UbigeoProvincia;
    }

    public String getUbigeoDepartamento() {
        return UbigeoDepartamento;
    }

    public void setUbigeoDepartamento(String UbigeoDepartamento) {
        this.UbigeoDepartamento = UbigeoDepartamento;
    }

    public String getNombreZonificacion() {
        return nombreZonificacion;
    }

    public void setNombreZonificacion(String nombreZonificacion) {
        this.nombreZonificacion = nombreZonificacion;
    }

    /*public MdiMacroRegionXRegion getMdiMacroRegionXRegion() {
        return mdiMacroRegionXRegion;
    }

    public void setMdiMacroRegionXRegion(MdiMacroRegionXRegion mdiMacroRegionXRegion) {
        this.mdiMacroRegionXRegion = mdiMacroRegionXRegion;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZonificacionDetalle != null ? idZonificacionDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghZonificacionDetalle)) {
            return false;
        }
        PghZonificacionDetalle other = (PghZonificacionDetalle) object;
        if ((this.idZonificacionDetalle == null && other.idZonificacionDetalle != null) || (this.idZonificacionDetalle != null && !this.idZonificacionDetalle.equals(other.idZonificacionDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.test.PghZonificacionDetalle[ idZonificacionDetalle=" + idZonificacionDetalle + " ]";
    }
    
}
