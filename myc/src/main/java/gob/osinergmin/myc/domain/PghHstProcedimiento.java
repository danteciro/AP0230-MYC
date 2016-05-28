/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_HST_PROCEDIMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghHstProcedimiento.findAll", query = "SELECT p FROM PghHstProcedimiento p"),
    @NamedQuery(name = "PghHstProcedimiento.findByIdHstProcedimiento", query = "SELECT p FROM PghHstProcedimiento p WHERE p.idHstProcedimiento = :idHstProcedimiento"),
    @NamedQuery(name = "PghHstProcedimiento.findByItem", query = "SELECT p FROM PghHstProcedimiento p WHERE p.item = :item"),
    @NamedQuery(name = "PghHstProcedimiento.findByDenominacion", query = "SELECT p FROM PghHstProcedimiento p WHERE p.denominacion = :denominacion"),
    @NamedQuery(name = "PghHstProcedimiento.findByBaseLegal", query = "SELECT p FROM PghHstProcedimiento p WHERE p.baseLegal = :baseLegal"),
    @NamedQuery(name = "PghHstProcedimiento.findByDerechoTramitacion", query = "SELECT p FROM PghHstProcedimiento p WHERE p.derechoTramitacion = :derechoTramitacion"),
    @NamedQuery(name = "PghHstProcedimiento.findByIdValorUit", query = "SELECT p FROM PghHstProcedimiento p WHERE p.idValorUit = :idValorUit"),
    @NamedQuery(name = "PghHstProcedimiento.findByIdCalificacion", query = "SELECT p FROM PghHstProcedimiento p WHERE p.idCalificacion = :idCalificacion"),
    @NamedQuery(name = "PghHstProcedimiento.findByIdSilencioAdministrativo", query = "SELECT p FROM PghHstProcedimiento p WHERE p.idSilencioAdministrativo = :idSilencioAdministrativo"),
    @NamedQuery(name = "PghHstProcedimiento.findByPlazoResolver", query = "SELECT p FROM PghHstProcedimiento p WHERE p.plazoResolver = :plazoResolver"),
    @NamedQuery(name = "PghHstProcedimiento.findByIdInicioProcedimiento", query = "SELECT p FROM PghHstProcedimiento p WHERE p.idInicioProcedimiento = :idInicioProcedimiento"),
    @NamedQuery(name = "PghHstProcedimiento.findByIdAutoridadCompetente", query = "SELECT p FROM PghHstProcedimiento p WHERE p.idAutoridadCompetente = :idAutoridadCompetente"),
    @NamedQuery(name = "PghHstProcedimiento.findByIdReconsideracion", query = "SELECT p FROM PghHstProcedimiento p WHERE p.idReconsideracion = :idReconsideracion"),
    @NamedQuery(name = "PghHstProcedimiento.findByIdApelacion", query = "SELECT p FROM PghHstProcedimiento p WHERE p.idApelacion = :idApelacion"),
    @NamedQuery(name = "PghHstProcedimiento.findByIdAnexoRrh", query = "SELECT p FROM PghHstProcedimiento p WHERE p.idAnexoRrh = :idAnexoRrh"),
    @NamedQuery(name = "PghHstProcedimiento.findByNotaProcedimiento", query = "SELECT p FROM PghHstProcedimiento p WHERE p.notaProcedimiento = :notaProcedimiento"),
    @NamedQuery(name = "PghHstProcedimiento.findByEstado", query = "SELECT p FROM PghHstProcedimiento p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghHstProcedimiento.findByUsuarioCreacion", query = "SELECT p FROM PghHstProcedimiento p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghHstProcedimiento.findByFechaCreacion", query = "SELECT p FROM PghHstProcedimiento p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghHstProcedimiento.findByTerminalCreacion", query = "SELECT p FROM PghHstProcedimiento p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghHstProcedimiento.findByUsuarioActualizacion", query = "SELECT p FROM PghHstProcedimiento p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghHstProcedimiento.findByFechaActualizacion", query = "SELECT p FROM PghHstProcedimiento p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghHstProcedimiento.findByTerminalActualizacion", query = "SELECT p FROM PghHstProcedimiento p WHERE p.terminalActualizacion = :terminalActualizacion")})
public class PghHstProcedimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HST_PROCEDIMIENTO")
    private Long idHstProcedimiento;
    @Size(max = 10)
    @Column(name = "ITEM")
    private String item;
    @Size(max = 500)
    @Column(name = "DENOMINACION")
    private String denominacion;
    @Size(max = 500)
    @Column(name = "BASE_LEGAL")
    private String baseLegal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DERECHO_TRAMITACION")
    private BigDecimal derechoTramitacion;
    @Column(name = "ID_VALOR_UIT")
    private Long idValorUit;
    @Column(name = "ID_CALIFICACION")
    private Long idCalificacion;
    @Column(name = "ID_SILENCIO_ADMINISTRATIVO")
    private Long idSilencioAdministrativo;
    @Column(name = "PLAZO_RESOLVER")
    private BigDecimal plazoResolver;
    @Column(name = "ID_INICIO_PROCEDIMIENTO")
    private Long idInicioProcedimiento;
    @Column(name = "ID_AUTORIDAD_COMPETENTE")
    private Long idAutoridadCompetente;
    @Column(name = "ID_RECONSIDERACION")
    private Long idReconsideracion;
    @Column(name = "ID_APELACION")
    private Long idApelacion;
    @Column(name = "ID_ANEXO_RRH")
    private Long idAnexoRrh;
    @Size(max = 4000)
    @Column(name = "NOTA_PROCEDIMIENTO")
    private String notaProcedimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private char estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 38)
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 38)
    @Column(name = "TERMINAL_CREACION")
    private String terminalCreacion;
    @Size(max = 38)
    @Column(name = "USUARIO_ACTUALIZACION")
    private String usuarioActualizacion;
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Size(max = 38)
    @Column(name = "TERMINAL_ACTUALIZACION")
    private String terminalActualizacion;
    @JoinColumn(name = "ID_PROCEDIMIENTO", referencedColumnName = "ID_PROCEDIMIENTO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghProcedimiento idProcedimiento;

    public PghHstProcedimiento() {
    }

    public PghHstProcedimiento(Long idHstProcedimiento) {
        this.idHstProcedimiento = idHstProcedimiento;
    }

    public PghHstProcedimiento(Long idHstProcedimiento, char estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idHstProcedimiento = idHstProcedimiento;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdHstProcedimiento() {
        return idHstProcedimiento;
    }

    public void setIdHstProcedimiento(Long idHstProcedimiento) {
        this.idHstProcedimiento = idHstProcedimiento;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getBaseLegal() {
        return baseLegal;
    }

    public void setBaseLegal(String baseLegal) {
        this.baseLegal = baseLegal;
    }

    public BigDecimal getDerechoTramitacion() {
        return derechoTramitacion;
    }

    public void setDerechoTramitacion(BigDecimal derechoTramitacion) {
        this.derechoTramitacion = derechoTramitacion;
    }

    public Long getIdValorUit() {
        return idValorUit;
    }

    public void setIdValorUit(Long idValorUit) {
        this.idValorUit = idValorUit;
    }

    public Long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Long getIdSilencioAdministrativo() {
        return idSilencioAdministrativo;
    }

    public void setIdSilencioAdministrativo(Long idSilencioAdministrativo) {
        this.idSilencioAdministrativo = idSilencioAdministrativo;
    }

    public BigDecimal getPlazoResolver() {
        return plazoResolver;
    }

    public void setPlazoResolver(BigDecimal plazoResolver) {
        this.plazoResolver = plazoResolver;
    }

    public Long getIdInicioProcedimiento() {
        return idInicioProcedimiento;
    }

    public void setIdInicioProcedimiento(Long idInicioProcedimiento) {
        this.idInicioProcedimiento = idInicioProcedimiento;
    }

    public Long getIdAutoridadCompetente() {
        return idAutoridadCompetente;
    }

    public void setIdAutoridadCompetente(Long idAutoridadCompetente) {
        this.idAutoridadCompetente = idAutoridadCompetente;
    }

    public Long getIdReconsideracion() {
        return idReconsideracion;
    }

    public void setIdReconsideracion(Long idReconsideracion) {
        this.idReconsideracion = idReconsideracion;
    }

    public Long getIdApelacion() {
        return idApelacion;
    }

    public void setIdApelacion(Long idApelacion) {
        this.idApelacion = idApelacion;
    }

    public Long getIdAnexoRrh() {
        return idAnexoRrh;
    }

    public void setIdAnexoRrh(Long idAnexoRrh) {
        this.idAnexoRrh = idAnexoRrh;
    }

    public String getNotaProcedimiento() {
        return notaProcedimiento;
    }

    public void setNotaProcedimiento(String notaProcedimiento) {
        this.notaProcedimiento = notaProcedimiento;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTerminalCreacion() {
        return terminalCreacion;
    }

    public void setTerminalCreacion(String terminalCreacion) {
        this.terminalCreacion = terminalCreacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getTerminalActualizacion() {
        return terminalActualizacion;
    }

    public void setTerminalActualizacion(String terminalActualizacion) {
        this.terminalActualizacion = terminalActualizacion;
    }

    public PghProcedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(PghProcedimiento idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHstProcedimiento != null ? idHstProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghHstProcedimiento)) {
            return false;
        }
        PghHstProcedimiento other = (PghHstProcedimiento) object;
        if ((this.idHstProcedimiento == null && other.idHstProcedimiento != null) || (this.idHstProcedimiento != null && !this.idHstProcedimiento.equals(other.idHstProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghHstProcedimiento[ idHstProcedimiento=" + idHstProcedimiento + " ]";
    }
    
}
