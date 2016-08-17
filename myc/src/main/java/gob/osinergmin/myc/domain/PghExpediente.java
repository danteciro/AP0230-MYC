/**
* Resumen		
* Objeto		: PghExpediente.java
* Descripción		: Clase del modelo de dominio PghExpediente
* Fecha de Creación	: 
* PR de Creación	: OSINE_SFS-480
* Autor			: Julio Piro Gonzales
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
* OSINE_SFS-480     19/05/2016      Luis García Reyna           Crear la interfaz "devolver asignaciones" de acuerdo a especificaciones.
* OSINE_SFS-480     23/05/2016      Hernán Torres Saenz         Implementar la funcionalidad de anular orden de servicio de acuerdo a especificaciones.
* OSINE_SFS-480     02/06/2016      Luis García Reyna           Crear la opción "Editar" en pestaña asignaciones de la bandeja del especialista el cual direccionará a la interfaz "Anular orden de servicio"
*
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_EXPEDIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghExpediente.findAll", query = "SELECT p FROM PghExpediente p"),
    @NamedQuery(name = "PghExpediente.findByIdExpediente", query = "SELECT p FROM PghExpediente p where estado='1' and p.idExpediente=:idExpediente "),
    @NamedQuery(name = "PghExpediente.findDerivadosByIdPersonal", query = "SELECT p FROM PghExpediente p LEFT JOIN p.pghHistoricoEstadoList he where p.estado=1 and he.idPersonalOri.idPersonal=:idPersonalOri "),
    @NamedQuery(name = "PghExpediente.countOrdenServicio", query = "SELECT count(d.idOrdenServicio) from PghOrdenServicio d where d.estado='1' and d.idExpediente.idExpediente=:idExpediente ")
})
public class PghExpediente extends Auditoria {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idExpediente", fetch = FetchType.LAZY)
    private List<PghHistoricoEstado> pghHistoricoEstadoList;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EXPEDIENTE")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_EXPEDIENTE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idExpediente;
    @Column(name = "TIENE_CODIGO_OSINERGMIN")
    private Character tieneCodigoOsinergmin;
    @Size(max = 200)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Size(max = 12)
    @Column(name = "NUMERO_EXPEDIENTE")
    private String numeroExpediente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION_SIGED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionSiged;
    @Column(name = "NUMERO_FOLIOS")
    private Long numeroFolios;
    @Size(max = 18)
    @Column(name = "ESTADO_SOLICITUD_SIGED")
    private String estadoSolicitudSiged;
    @Size(max = 18)
    @Column(name = "ID_SIGED")
    private String idSiged;
    @Column(name = "FECHA_PRUEBA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrueba;
    @Size(max = 200)
    @Column(name = "OBSERVACION_SOL_ANT")
    private String observacionSolAnt;
    @Size(max = 18)
    @Column(name = "USUARIO_SIGED")
    private String usuarioSiged;
    @Size(max = 1000)
    @Column(name = "ASUNTO_SIGED")
    private String asuntoSiged;
    @Column(name = "FLAG_ORIGEN")
    private String flagOrigen;
    @Column(name = "FECHA_ESTADO_PROCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstadoProceso;
    @Column(name = "FLAG_TRAMITE_FINALIZADO")
    private String flagTramiteFinalizado;
    @JoinColumn(name = "ID_TRAMITE", referencedColumnName = "ID_TRAMITE")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghTramite idTramite;
    @JoinColumn(name = "ID_PROC_TRAM_ACTI", referencedColumnName = "ID_PROC_TRAM_ACTI")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghProcTramActividad idProcTramActi;
    @JoinColumn(name = "ID_PROCESO", referencedColumnName = "ID_PROCESO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghProceso idProceso;
    @JoinColumn(name = "ID_PERSONAL", referencedColumnName = "ID_PERSONAL")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghPersonal idPersonal;
    @JoinColumn(name = "ID_FLUJO_SIGED", referencedColumnName = "ID_FLUJO_SIGED")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghFlujoSiged idFlujoSiged;
    @JoinColumn(name = "ID_ESTADO_PROCESO", referencedColumnName = "ID_ESTADO_PROCESO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghEstadoProceso idEstadoProceso;
    @JoinColumn(name = "ID_UNIDAD_SUPERVISADA", referencedColumnName = "ID_UNIDAD_SUPERVISADA")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiUnidadSupervisada idUnidadSupervisada;
    @JoinColumn(name = "ID_EMPRESA_SUPERVISADA", referencedColumnName = "ID_EMPRESA_SUPERVISADA")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiEmpresaSupervisada idEmpresaSupervisada;
    @OneToMany(mappedBy = "idExpediente", fetch = FetchType.LAZY)
    private List<PghOrdenServicio> pghOrdenServicioList;
    @JoinColumn(name = "ID_OBLIGACION_TIPO", referencedColumnName = "ID_OBLIGACION_TIPO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghObligacionTipo idObligacionTipo;
    @JoinColumn(name = "ID_OBLIGACION_SUB_TIPO", referencedColumnName = "ID_OBLIGACION_SUB_TIPO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghObligacionSubTipo idObligacionSubTipo;
    @Column(name = "FLAG_MUESTRAL")
    private String flagMuestral;

    @Transient
    private Date fechaDerivacion;
    @Transient
    private PghOrdenServicio ordenServicio;
    @Transient
    private Long nroOrdenesServicio; 
    /* OSINE_SFS-480 - RSIS 38 - Inicio */
    @Transient
    private Long iteracionExpediente;

    public String getFlagMuestral() {
        return flagMuestral;
    }

    public void setFlagMuestral(String flagMuestral) {
        this.flagMuestral = flagMuestral;
    }

    public Long getIteracionExpediente() {
        return iteracionExpediente;
    }

    public void setIteracionExpediente(Long iteracionExpediente) {
        this.iteracionExpediente = iteracionExpediente;
    }
    /* OSINE_SFS-480 - RSIS 38 - Fin */
    public Long getNroOrdenesServicio() {
        return nroOrdenesServicio;
    }

    public void setNroOrdenesServicio(Long nroOrdenesServicio) {
        this.nroOrdenesServicio = nroOrdenesServicio;
    }

    public PghOrdenServicio getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(PghOrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    public Date getFechaDerivacion() {
        return fechaDerivacion;
    }

    public void setFechaDerivacion(Date fechaDerivacion) {
        this.fechaDerivacion = fechaDerivacion;
    }
    
    public PghExpediente() {
    }

    public PghExpediente(Long idExpediente) {
        this.idExpediente = idExpediente;
    }

    public PghExpediente(Long idExpediente, Date fechaCreacionSiged, String estado, Date fechaCreacion, String usuarioCreacion, String terminalCreacion) {
        this.idExpediente = idExpediente;
        this.fechaCreacionSiged = fechaCreacionSiged;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
    }
    
    /* OSINE_SFS-480 - RSIS 44 - Inicio */
    public PghExpediente(Long idExpediente,String numeroExpediente,Date fechaCreacionSiged,String asuntoSiged,String flagOrigen,Long idObligacionTipo,
            String flagTramiteFinalizado,Long idTramite,Long idEtapaTr, Long idProcesoTr, Long idProceso,Long idUnidadSupervisada,String codigoOsinergmin,
            String nombreUnidad,Long idEmpresaSupervisada,String razonSocial,String ruc,String numeroIdentificacion,Long tipoDocumentoIdentidad,
            String descripcion,Long idFlujoSiged,String nombreFlujoSiged,Long idPersonal,String nombre,String apellidoPaterno,String apellidoMaterno,
            Date fechaDerivacion,Long idOrdenServicio, Date fechaCreacionOS,String numeroOrdenServicio, Long idTipoAsignacion,Long iteracion,String flagCumplimiento,
            Long idEstadoProceso, String identificadorEstado,String nombreEstado,Long idLocador,String nombreCompletoArmadoLo,Long idSupervisoraEmpresa,
            String razonSocialSE,String nombreConsorcioSE, String motivoReasignacionOS, Long nroOrdenesServicio,
            String numeroRegistroHidrocarburo, String nombreActividad,Long idPeticion, String descripcionPeticion, String codigoPeticion, Long idMotivo, String comentarioDevolucion,Long iteracionExpediente,
            String flagMuestral, Long idObligacionSubTipo){ 
            this.idExpediente=idExpediente;
            this.numeroExpediente=numeroExpediente;
            this.fechaCreacionSiged=fechaCreacionSiged;
            this.asuntoSiged=asuntoSiged;
            this.flagOrigen=flagOrigen;
            this.idObligacionTipo=new PghObligacionTipo(idObligacionTipo);
            this.flagTramiteFinalizado=flagTramiteFinalizado;
            this.idUnidadSupervisada=new MdiUnidadSupervisada(idUnidadSupervisada,codigoOsinergmin,nombreUnidad,numeroRegistroHidrocarburo,nombreActividad);
            this.idEmpresaSupervisada=new MdiEmpresaSupervisada(idEmpresaSupervisada,razonSocial,ruc,numeroIdentificacion,tipoDocumentoIdentidad,descripcion);
            this.idFlujoSiged=new PghFlujoSiged(idFlujoSiged,nombreFlujoSiged);
            this.idPersonal=new PghPersonal(idPersonal,nombre,apellidoPaterno,apellidoMaterno);
            this.fechaDerivacion=fechaDerivacion;
            this.ordenServicio=new PghOrdenServicio(idOrdenServicio,fechaCreacionOS,numeroOrdenServicio,idTipoAsignacion,idLocador,nombreCompletoArmadoLo,idSupervisoraEmpresa,razonSocialSE,nombreConsorcioSE,idEstadoProceso,identificadorEstado,nombreEstado,iteracion,
            flagCumplimiento,motivoReasignacionOS,idPeticion,descripcionPeticion, codigoPeticion,idMotivo,comentarioDevolucion);
            this.idTramite=new PghTramite(idTramite,idEtapaTr,idProcesoTr);
            this.idProceso=new PghProceso(idProceso);
            this.nroOrdenesServicio=nroOrdenesServicio;
            this.iteracionExpediente=iteracionExpediente;
            this.flagMuestral=flagMuestral;
            this.idObligacionSubTipo=new PghObligacionSubTipo(idObligacionSubTipo);
    }       
    /* OSINE_SFS-480 - RSIS 44 - Fin */

    public Long getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(Long idExpediente) {
        this.idExpediente = idExpediente;
    }

    public Character getTieneCodigoOsinergmin() {
        return tieneCodigoOsinergmin;
    }

    public void setTieneCodigoOsinergmin(Character tieneCodigoOsinergmin) {
        this.tieneCodigoOsinergmin = tieneCodigoOsinergmin;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public Date getFechaCreacionSiged() {
        return fechaCreacionSiged;
    }

    public void setFechaCreacionSiged(Date fechaCreacionSiged) {
        this.fechaCreacionSiged = fechaCreacionSiged;
    }

    public Long getNumeroFolios() {
        return numeroFolios;
    }

    public void setNumeroFolios(Long numeroFolios) {
        this.numeroFolios = numeroFolios;
    }

    public String getEstadoSolicitudSiged() {
        return estadoSolicitudSiged;
    }

    public void setEstadoSolicitudSiged(String estadoSolicitudSiged) {
        this.estadoSolicitudSiged = estadoSolicitudSiged;
    }

    public String getIdSiged() {
        return idSiged;
    }

    public void setIdSiged(String idSiged) {
        this.idSiged = idSiged;
    }

    public Date getFechaPrueba() {
        return fechaPrueba;
    }

    public void setFechaPrueba(Date fechaPrueba) {
        this.fechaPrueba = fechaPrueba;
    }

    public String getObservacionSolAnt() {
        return observacionSolAnt;
    }

    public void setObservacionSolAnt(String observacionSolAnt) {
        this.observacionSolAnt = observacionSolAnt;
    }

    public String getUsuarioSiged() {
        return usuarioSiged;
    }

    public void setUsuarioSiged(String usuarioSiged) {
        this.usuarioSiged = usuarioSiged;
    }


    public String getAsuntoSiged() {
        return asuntoSiged;
    }

    public void setAsuntoSiged(String asuntoSiged) {
        this.asuntoSiged = asuntoSiged;
    }

    public String getFlagOrigen() {
        return flagOrigen;
    }

    public void setFlagOrigen(String flagOrigen) {
        this.flagOrigen = flagOrigen;
    }

    public Date getFechaEstadoProceso() {
        return fechaEstadoProceso;
    }

    public void setFechaEstadoProceso(Date fechaEstadoProceso) {
        this.fechaEstadoProceso = fechaEstadoProceso;
    }

    public String getFlagTramiteFinalizado() {
        return flagTramiteFinalizado;
    }

    public void setFlagTramiteFinalizado(String flagTramiteFinalizado) {
        this.flagTramiteFinalizado = flagTramiteFinalizado;
    }

    public PghTramite getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(PghTramite idTramite) {
        this.idTramite = idTramite;
    }

    public PghProcTramActividad getIdProcTramActi() {
        return idProcTramActi;
    }

    public void setIdProcTramActi(PghProcTramActividad idProcTramActi) {
        this.idProcTramActi = idProcTramActi;
    }

    public PghProceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(PghProceso idProceso) {
        this.idProceso = idProceso;
    }

    public PghPersonal getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(PghPersonal idPersonal) {
        this.idPersonal = idPersonal;
    }

    public PghFlujoSiged getIdFlujoSiged() {
        return idFlujoSiged;
    }

    public void setIdFlujoSiged(PghFlujoSiged idFlujoSiged) {
        this.idFlujoSiged = idFlujoSiged;
    }

    public PghEstadoProceso getIdEstadoProceso() {
        return idEstadoProceso;
    }

    public void setIdEstadoProceso(PghEstadoProceso idEstadoProceso) {
        this.idEstadoProceso = idEstadoProceso;
    }

    public MdiUnidadSupervisada getIdUnidadSupervisada() {
        return idUnidadSupervisada;
    }

    public void setIdUnidadSupervisada(MdiUnidadSupervisada idUnidadSupervisada) {
        this.idUnidadSupervisada = idUnidadSupervisada;
    }

    public MdiEmpresaSupervisada getIdEmpresaSupervisada() {
        return idEmpresaSupervisada;
    }

    public void setIdEmpresaSupervisada(MdiEmpresaSupervisada idEmpresaSupervisada) {
        this.idEmpresaSupervisada = idEmpresaSupervisada;
    }
    
    public PghObligacionTipo getIdObligacionTipo() {
        return idObligacionTipo;
    }

    public void setIdObligacionTipo(PghObligacionTipo idObligacionTipo) {
        this.idObligacionTipo = idObligacionTipo;
    }
    
    public PghObligacionSubTipo getIdObligacionSubTipo() {
        return idObligacionSubTipo;
    }

    public void setIdObligacionSubTipo(PghObligacionSubTipo idObligacionSubTipo) {
        this.idObligacionSubTipo = idObligacionSubTipo;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghOrdenServicio> getPghOrdenServicioList() {
        return pghOrdenServicioList;
    }

    public void setPghOrdenServicioList(List<PghOrdenServicio> pghOrdenServicioList) {
        this.pghOrdenServicioList = pghOrdenServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExpediente != null ? idExpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghExpediente)) {
            return false;
        }
        PghExpediente other = (PghExpediente) object;
        if ((this.idExpediente == null && other.idExpediente != null) || (this.idExpediente != null && !this.idExpediente.equals(other.idExpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.inps.domain.PghExpediente[ idExpediente=" + idExpediente + " ]";
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghHistoricoEstado> getPghHistoricoEstadoList() {
        return pghHistoricoEstadoList;
    }

    public void setPghHistoricoEstadoList(List<PghHistoricoEstado> pghHistoricoEstadoList) {
        this.pghHistoricoEstadoList = pghHistoricoEstadoList;
    }
    
}
