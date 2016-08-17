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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "PGH_PERSONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghPersonal.findAll", query = "SELECT p FROM PghPersonal p"),
    @NamedQuery(name = "PghPersonal.findByNombreUsuarioSiged", query = "SELECT p "
            + "FROM PghPersonal p "
            + "LEFT JOIN p.idLocador lo "
            + "LEFT JOIN lo.idTipoDocumentoIdentidad tdlo "
            + "LEFT JOIN p.idSupervisoraEmpresa se "
            + "where p.estado=1 and p.nombreUsuarioSiged=:nombreUsuarioSiged and p.aplicacion = 'MYC' "),
    // htorress - RSIS 3 - Inicio
    //@NamedQuery(name = "PghPersonal.findByDescRol", query = "SELECT p FROM PghPersonal p where p.estado=1 and p.idRol.nombreRol=:descRol and p.aplicacion = 'INPS'"),
    @NamedQuery(name = "PghPersonal.findByDescRol", query = "SELECT p FROM PghPersonal p where p.estado=1 and p.idRol.nombreRol IN (:descRol) and p.aplicacion = 'MYC'"),
    // htorress - RSIS 3 - Fin
    @NamedQuery(name = "PghPersonal.findByIdLocador", query = "SELECT p FROM PghPersonal p where p.estado=1 and p.idLocador.idLocador=:idLocador and p.aplicacion = 'MYC'"),
    @NamedQuery(name = "PghPersonal.findByIdSupervisoraEmpresa", query = "SELECT p FROM PghPersonal p where p.estado=1 and p.idSupervisoraEmpresa.idSupervisoraEmpresa=:idSupervisoraEmpresa and p.aplicacion = 'MYC'"),
    @NamedQuery(name = "PghPersonal.findByIdPersonal", query = "SELECT p FROM PghPersonal p where p.estado=1 and p.idPersonal=:idPersonal and p.aplicacion = 'MYC'"),
    @NamedQuery(name = "PghPersonal.findByIdPersonalUnidOrgFlagDefault", 
            query = "SELECT new PghPersonal(p.idPersonal,p.idLocador.idLocador,p.idSupervisoraEmpresa.idSupervisoraEmpresa,p.idPersonalSiged,p.apellidoPaterno,"
                    + "p.apellidoMaterno,p.nombre,p.nombreCompleto,p.nombreUsuarioSiged,puo.idPersonalUnidadOrganica,"
                    + "puo.flagDefault,puo.idUnidadOrganica.idUnidadOrganica) "
                    + "FROM PghPersonal p "
                    + "LEFT JOIN p.pghPersonalUnidadOrganicaList puo "
                    + "where p.estado=1 and p.idPersonal=:idPersonal and p.aplicacion = 'MYC' and puo.flagDefault=:flagDefault and puo.estado=1 ")
})
public class PghPersonal extends Auditoria {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONAL")
    private Long idPersonal;
    @Column(name = "ID_TIPO_DOCUMENTO_IDENTIDAD")
    private Long idTipoDocumentoIdentidad;
	@Column(name = "ID_PERSONAL_SIGED")
    private Long idPersonalSiged;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 38)
    @Column(name = "NOMBRE_USUARIO_SIGED")
    private String nombreUsuarioSiged;
    @Size(max = 50)
    @Column(name = "NUMERO_DOC_IDENTIDAD")
    private String numeroDocIdentidad;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Size(max = 100)
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Size(max = 100)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Size(max = 200)
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;    
    @Size(max = 25)
    @Column(name = "APLICACION")
    private String aplicacion;    
    @OneToMany(mappedBy = "idPersonal", fetch = FetchType.LAZY)
    private List<PghPersonalUnidadOrganica> pghPersonalUnidadOrganicaList;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghRol idRol;
    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghCargo idCargo;
    @OneToMany(mappedBy = "idPersonalOri", fetch = FetchType.LAZY)
    private List<PghHistoricoEstado> pghHistoricoEstadoList;
    @OneToMany(mappedBy = "idPersonalDest", fetch = FetchType.LAZY)
    private List<PghHistoricoEstado> pghHistoricoEstadoList1;
//    @JoinColumn(name = "ID_UNIDAD_ORGANICA", referencedColumnName = "ID_UNIDAD_ORGANICA")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private MdiUnidadOrganica idUnidadOrganica;
    @JoinColumn(name = "ID_SUPERVISORA_EMPRESA", referencedColumnName = "ID_SUPERVISORA_EMPRESA")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiSupervisoraEmpresa idSupervisoraEmpresa;
    @JoinColumn(name = "ID_LOCADOR", referencedColumnName = "ID_LOCADOR")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiLocador idLocador;
    @OneToMany(mappedBy = "idPersonal", fetch = FetchType.LAZY)
    private List<PghExpediente> pghExpedienteList;
    
    @Transient
    PghPersonalUnidadOrganica personalUnidadOrganicaDefault;
    
    public PghPersonal() {
    }

    public PghPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public PghPersonal(Long idPersonal, String numeroDocIdentidad, String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, String nombreCompleto, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion, String nombreUsuarioSiged) {
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
    
    public PghPersonal(Long idPersonal,Long idLocador,Long idSupervisoraEmpresa,Long idPersonalSiged,String apellidoPaterno,
            String apellidoMaterno,String nombre,String nombreCompleto,String nombreUsuarioSiged,
            Long idPersonalUnidadOrganica,String flagDefault,Long idUnidadOrganica){
        this.idPersonal=idPersonal;
        this.idLocador=new MdiLocador(idLocador);
        this.idSupervisoraEmpresa=new MdiSupervisoraEmpresa(idSupervisoraEmpresa);
        this.idPersonalSiged=idPersonalSiged;
        this.apellidoPaterno=apellidoPaterno;
        this.apellidoMaterno=apellidoMaterno;
        this.nombre=nombre;
        this.nombreCompleto=nombreCompleto;
        this.nombreUsuarioSiged=nombreUsuarioSiged;
        this.personalUnidadOrganicaDefault=new PghPersonalUnidadOrganica(idPersonalUnidadOrganica, flagDefault, idUnidadOrganica);        
    }
    
    public PghPersonal(Long idPersonal,String nombre,String apellidoPaterno,String apellidoMaterno) {
        this.idPersonal = idPersonal;
        this.nombre=nombre;
        this.apellidoPaterno=apellidoPaterno;
        this.apellidoMaterno=apellidoMaterno;
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

    public String getNumeroDocIdentidad() {
        return numeroDocIdentidad;
    }

    public void setNumeroDocIdentidad(String numeroDocIdentidad) {
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

    @XmlTransient
    @JsonIgnore
    public List<PghExpediente> getPghExpedienteList() {
        return pghExpedienteList;
    }

    public void setPghExpedienteList(List<PghExpediente> pghExpedienteList) {
        this.pghExpedienteList = pghExpedienteList;
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
    @XmlTransient
    @JsonIgnore
    public List<PghHistoricoEstado> getPghHistoricoEstadoList() {
        return pghHistoricoEstadoList;
    }
    public void setPghHistoricoEstadoList(List<PghHistoricoEstado> pghHistoricoEstadoList) {
        this.pghHistoricoEstadoList = pghHistoricoEstadoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghHistoricoEstado> getPghHistoricoEstadoList1() {
        return pghHistoricoEstadoList1;
    }

    public void setPghHistoricoEstadoList1(List<PghHistoricoEstado> pghHistoricoEstadoList1) {
        this.pghHistoricoEstadoList1 = pghHistoricoEstadoList1;
    }
    
    public PghPersonalUnidadOrganica getPersonalUnidadOrganicaDefault() {
        return personalUnidadOrganicaDefault;
    }

    public void setPersonalUnidadOrganicaDefault(PghPersonalUnidadOrganica personalUnidadOrganicaDefault) {
        this.personalUnidadOrganicaDefault = personalUnidadOrganicaDefault;
    }
    
}
