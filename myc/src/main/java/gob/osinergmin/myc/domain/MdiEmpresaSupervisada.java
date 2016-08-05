/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gvillanueva
 */
@Entity
@Table(name = "MDI_EMPRESA_SUPERVISADA")
@NamedQueries({
    @NamedQuery(name = "MdiEmpresaSupervisada.findAll", query = "SELECT m FROM MdiEmpresaSupervisada m")})
public class MdiEmpresaSupervisada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPRESA_SUPERVISADA")
    private Long idEmpresaSupervisada;
    @Size(max = 200)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Size(max = 30)
    @Column(name = "NUMERO_IDENTIFICACION")
    private String numeroIdentificacion;
    @Size(max = 100)
    @Column(name = "NOMBRE_COMERCIAL")
    private String nombreComercial;
    @Size(max = 50)
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Size(max = 50)
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Size(max = 30)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 38)
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Size(max = 38)
    @Column(name = "USUARIO_ACTUALIZACION")
    private String usuarioActualizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 38)
    @Column(name = "TERMINAL_ACTUALIZACION")
    private String terminalActualizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 38)
    @Column(name = "TERMINAL_CREACION")
    private String terminalCreacion;
    @Column(name = "CIIU_PRINCIPAL")
    private BigInteger ciiuPrincipal;
    @Size(max = 2)
    @Column(name = "FLAG_BANDERA")
    private String flagBandera;
    @Column(name = "TIPO_DOCUMENTO_IDENTIDAD")
    private Long tipoDocumentoIdentidad;
    @Column(name = "NATURALEZA")
    private Character naturaleza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ORIGEN_INFORMACION")
    private String origenInformacion;
    @Column(name = "CODIGO_EMPRESA")
    private Long codigoEmpresa;
    @Size(max = 11)
    @Column(name = "RUC")
    private String ruc;
    @Size(max = 100)
    @Column(name = "UTM")
    private String utm;
    @Size(max = 50)
    @Column(name = "NOMBRE_CORTO")
    private String nombreCorto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private Character estado;
    @Size(max = 18)
    @Column(name = "CELULAR")
    private String celular;
    @Size(max = 50)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresaSupervisada", fetch = FetchType.LAZY)
    private List<MdiUnidadSupervisada> mdiUnidadSupervisadaList;

    public MdiEmpresaSupervisada() {
    }

    public MdiEmpresaSupervisada(Long idEmpresaSupervisada) {
        this.idEmpresaSupervisada = idEmpresaSupervisada;
    }

    public MdiEmpresaSupervisada(Long idEmpresaSupervisada, String usuarioCreacion, Date fechaCreacion, String terminalCreacion, String origenInformacion, Character estado) {
        this.idEmpresaSupervisada = idEmpresaSupervisada;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
        this.origenInformacion = origenInformacion;
        this.estado = estado;
    }

    public Long getIdEmpresaSupervisada() {
        return idEmpresaSupervisada;
    }

    public void setIdEmpresaSupervisada(Long idEmpresaSupervisada) {
        this.idEmpresaSupervisada = idEmpresaSupervisada;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTerminalActualizacion() {
        return terminalActualizacion;
    }

    public void setTerminalActualizacion(String terminalActualizacion) {
        this.terminalActualizacion = terminalActualizacion;
    }

    public String getTerminalCreacion() {
        return terminalCreacion;
    }

    public void setTerminalCreacion(String terminalCreacion) {
        this.terminalCreacion = terminalCreacion;
    }

    public BigInteger getCiiuPrincipal() {
        return ciiuPrincipal;
    }

    public void setCiiuPrincipal(BigInteger ciiuPrincipal) {
        this.ciiuPrincipal = ciiuPrincipal;
    }

    public String getFlagBandera() {
        return flagBandera;
    }

    public void setFlagBandera(String flagBandera) {
        this.flagBandera = flagBandera;
    }

    public Long getTipoDocumentoIdentidad() {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(Long tipoDocumentoIdentidad) {
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }

    public Character getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(Character naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getOrigenInformacion() {
        return origenInformacion;
    }

    public void setOrigenInformacion(String origenInformacion) {
        this.origenInformacion = origenInformacion;
    }

    public Long getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Long codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getUtm() {
        return utm;
    }

    public void setUtm(String utm) {
        this.utm = utm;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<MdiUnidadSupervisada> getMdiUnidadSupervisadaList() {
        return mdiUnidadSupervisadaList;
    }

    public void setMdiUnidadSupervisadaList(List<MdiUnidadSupervisada> mdiUnidadSupervisadaList) {
        this.mdiUnidadSupervisadaList = mdiUnidadSupervisadaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresaSupervisada != null ? idEmpresaSupervisada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiEmpresaSupervisada)) {
            return false;
        }
        MdiEmpresaSupervisada other = (MdiEmpresaSupervisada) object;
        if ((this.idEmpresaSupervisada == null && other.idEmpresaSupervisada != null) || (this.idEmpresaSupervisada != null && !this.idEmpresaSupervisada.equals(other.idEmpresaSupervisada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Z.MdiEmpresaSupervisada[ idEmpresaSupervisada=" + idEmpresaSupervisada + " ]";
    }
    
}
