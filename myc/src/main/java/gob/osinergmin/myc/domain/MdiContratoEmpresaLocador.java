/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

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
@Table(name = "MDI_CONTRATO_EMPRESA_LOCADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiContratoEmpresaLocador.findAll", query = "SELECT m FROM MdiContratoEmpresaLocador m")})
public class MdiContratoEmpresaLocador extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONTRATO_EMPRESA_LOCADOR")
    private Long idContratoEmpresaLocador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO_CONTRATO")
    private String numeroContrato;
    @Column(name = "FECHA_INICIO_CONTRATO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioContrato;
    @Column(name = "FECHA_FIN_CONTRATO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinContrato;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HONORARIO_TOTAL")
    private BigDecimal honorarioTotal;
    @Column(name = "MOTIVO_CONCLUSION")
    private Long motivoConclusion;
    @Size(max = 20)
    @Column(name = "NUMERO_CARTA_NOTARIAL")
    private String numeroCartaNotarial;
    @Column(name = "FECHA_NOTIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNotificacion;
    @Size(max = 200)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Column(name = "FECHA_EFECTIVO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEfectivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_PROCESO")
    private long estadoProceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "CATEGORIA_LOCADOR")
    private Long categoriaLocador;
    @JoinColumn(name = "ID_SUPERVISORA_EMPRESA", referencedColumnName = "ID_SUPERVISORA_EMPRESA")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiSupervisoraEmpresa idSupervisoraEmpresa;
    @JoinColumn(name = "ID_LOCADOR", referencedColumnName = "ID_LOCADOR")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiLocador idLocador;
    @JoinColumn(name = "ID_CONCURSO", referencedColumnName = "ID_CONCURSO")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiConcurso idConcurso;

    public MdiContratoEmpresaLocador() {
    }

    public MdiContratoEmpresaLocador(Long idContratoEmpresaLocador) {
        this.idContratoEmpresaLocador = idContratoEmpresaLocador;
    }

    public Long getIdContratoEmpresaLocador() {
        return idContratoEmpresaLocador;
    }

    public void setIdContratoEmpresaLocador(Long idContratoEmpresaLocador) {
        this.idContratoEmpresaLocador = idContratoEmpresaLocador;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public Date getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(Date fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public Date getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public BigDecimal getHonorarioTotal() {
        return honorarioTotal;
    }

    public void setHonorarioTotal(BigDecimal honorarioTotal) {
        this.honorarioTotal = honorarioTotal;
    }

    public Long getMotivoConclusion() {
        return motivoConclusion;
    }

    public void setMotivoConclusion(Long motivoConclusion) {
        this.motivoConclusion = motivoConclusion;
    }

    public String getNumeroCartaNotarial() {
        return numeroCartaNotarial;
    }

    public void setNumeroCartaNotarial(String numeroCartaNotarial) {
        this.numeroCartaNotarial = numeroCartaNotarial;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaEfectivo() {
        return fechaEfectivo;
    }

    public void setFechaEfectivo(Date fechaEfectivo) {
        this.fechaEfectivo = fechaEfectivo;
    }

    public long getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(long estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCategoriaLocador() {
        return categoriaLocador;
    }

    public void setCategoriaLocador(Long categoriaLocador) {
        this.categoriaLocador = categoriaLocador;
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

    public MdiConcurso getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(MdiConcurso idConcurso) {
        this.idConcurso = idConcurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContratoEmpresaLocador != null ? idContratoEmpresaLocador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiContratoEmpresaLocador)) {
            return false;
        }
        MdiContratoEmpresaLocador other = (MdiContratoEmpresaLocador) object;
        if ((this.idContratoEmpresaLocador == null && other.idContratoEmpresaLocador != null) || (this.idContratoEmpresaLocador != null && !this.idContratoEmpresaLocador.equals(other.idContratoEmpresaLocador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.MdiContratoEmpresaLocador[ idContratoEmpresaLocador=" + idContratoEmpresaLocador + " ]";
    }
    
}
