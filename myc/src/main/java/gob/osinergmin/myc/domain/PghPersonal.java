/**
* Resumen		
* Objeto		: PghPersonal.java
* Descripción		: Domain de la entidad.
* Fecha de Creación	: 13/06/2016
* PR de Creación	: OSINE_SFS-480
* Autor			: Julio Piro
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                          Descripción
* ---------------------------------------------------------------------------------------------------
* 
*/ 

package gob.osinergmin.myc.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "PGH_PERSONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghPersonal.findAll", query = "SELECT p FROM PghPersonal p")
})
public class PghPersonal extends Auditoria {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONAL")
    private Long idPersonal;
    @Column(name = "ID_TIPO_DOCUMENTO_IDENTIDAD")
    private Long idTipoDocumentoIdentidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_DOC_IDENTIDAD")
    private long numeroDocIdentidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 302)
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "ID_PERSONAL_SIGED")
    private Long idPersonalSiged;
    @Size(max = 25)
    @Column(name = "APLICACION")
    private String aplicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 38)
    @Column(name = "NOMBRE_USUARIO_SIGED")
    private String nombreUsuarioSiged;
    @OneToMany(mappedBy = "idPersonal", fetch = FetchType.LAZY)
    private List<PghPersonalUnidadOrganica> pghPersonalUnidadOrganicaList;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghRol idRol;
    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghCargo idCargo;
    @JoinColumn(name = "ID_SUPERVISORA_EMPRESA", referencedColumnName = "ID_SUPERVISORA_EMPRESA")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiSupervisoraEmpresa idSupervisoraEmpresa;
    @JoinColumn(name = "ID_LOCADOR", referencedColumnName = "ID_LOCADOR")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiLocador idLocador;

    public PghPersonal() {
    }

    public PghPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public PghPersonal(Long idPersonal, long numeroDocIdentidad, String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, String nombreCompleto, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion, String nombreUsuarioSiged) {
        this.idPersonal = idPersonal;
        this.numeroDocIdentidad = numeroDocIdentidad;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.nombreCompleto = nombreCompleto;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
        this.nombreUsuarioSiged = nombreUsuarioSiged;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Long getIdTipoDocumentoIdentidad() {
        return idTipoDocumentoIdentidad;
    }

    public void setIdTipoDocumentoIdentidad(Long idTipoDocumentoIdentidad) {
        this.idTipoDocumentoIdentidad = idTipoDocumentoIdentidad;
    }

    public long getNumeroDocIdentidad() {
        return numeroDocIdentidad;
    }

    public void setNumeroDocIdentidad(long numeroDocIdentidad) {
        this.numeroDocIdentidad = numeroDocIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdPersonalSiged() {
        return idPersonalSiged;
    }

    public void setIdPersonalSiged(Long idPersonalSiged) {
        this.idPersonalSiged = idPersonalSiged;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getNombreUsuarioSiged() {
        return nombreUsuarioSiged;
    }

    public void setNombreUsuarioSiged(String nombreUsuarioSiged) {
        this.nombreUsuarioSiged = nombreUsuarioSiged;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghPersonalUnidadOrganica> getPghPersonalUnidadOrganicaList() {
        return pghPersonalUnidadOrganicaList;
    }

    public void setPghPersonalUnidadOrganicaList(List<PghPersonalUnidadOrganica> pghPersonalUnidadOrganicaList) {
        this.pghPersonalUnidadOrganicaList = pghPersonalUnidadOrganicaList;
    }

    public PghRol getIdRol() {
        return idRol;
    }

    public void setIdRol(PghRol idRol) {
        this.idRol = idRol;
    }

    public PghCargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(PghCargo idCargo) {
        this.idCargo = idCargo;
    }

    public MdiSupervisoraEmpresa getIdSupervisoraEmpresa() {
        return idSupervisoraEmpresa;
    }

    public void setIdSupervisoraEmpresa(MdiSupervisoraEmpresa idSupervisoraEmpresa) {
        this.idSupervisoraEmpresa = idSupervisoraEmpresa;
    }

    public MdiLocador getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(MdiLocador idLocador) {
        this.idLocador = idLocador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonal != null ? idPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghPersonal)) {
            return false;
        }
        PghPersonal other = (PghPersonal) object;
        if ((this.idPersonal == null && other.idPersonal != null) || (this.idPersonal != null && !this.idPersonal.equals(other.idPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghPersonal[ idPersonal=" + idPersonal + " ]";
    }
    
}
