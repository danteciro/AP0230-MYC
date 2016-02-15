/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "PGH_PROCEDIMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="PghProcedimiento.findAll", query = "SELECT p FROM PghProcedimiento p"),
    @NamedQuery(name="PghProcedimiento.findByIdProcedimiento", query = "SELECT p FROM PghProcedimiento p where p.idProcedimiento=:idProcedimiento and p.estado=:estado"),
    @NamedQuery(name="PghProcedimiento.findByItemDenominacion", query = "SELECT p FROM PghProcedimiento p where p.estado=:estado and p.item=:item and p.denominacion=:denominacion"),
    @NamedQuery(name="PghProcedimiento.findByItemNullDenominacion", query = "SELECT p FROM PghProcedimiento p where p.estado=:estado and p.item is null and p.denominacion=:denominacion"),
    @NamedQuery(name="PghProcedimiento.findProcByIdProcedimientoIdTramite", query = "SELECT new PghProcedimiento(pt.idTramite.descripcion,pta.idActividad.nombre,p.denominacion,p.item) "
                + "FROM PghProcedimiento p "
                + "left join p.pghProcedimientoTramiteList pt "
                + "left join pt.pghProcTramActividadList pta "
                + "WHERE pta.estado=:estado and p.estado=:estado and pt.idTramite.idTramite=:idTramite and pta.idActividad.idActividad=:idActividad")
})
public class PghProcedimiento extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROCEDIMIENTO")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_PROCEDIMIENTO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idProcedimiento;
    @Size(max = 10)
    @Column(name = "ITEM")
    private String item;
    @Size(max = 500)
    @Column(name = "DENOMINACION")
    private String denominacion;
    @Size(max = 2000)
    @Column(name = "BASE_LEGAL")
    private String baseLegal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DERECHO_TRAMITACION")
    private Float derechoTramitacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CALIFICACION")
    private MdiMaestroColumna idCalificacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SILENCIO_ADMINISTRATIVO")
    private MdiMaestroColumna idSilencioAdministrativo;
    @Column(name = "PLAZO_RESOLVER")
    private Float plazoResolver;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_INICIO_PROCEDIMIENTO")
    private MdiMaestroColumna idInicioProcedimiento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_AUTORIDAD_COMPETENTE")
    private MdiMaestroColumna idAutoridadCompetente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_APELACION")
    private MdiMaestroColumna idApelacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_RECONSIDERACION")
    private MdiMaestroColumna idReconsideracion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ANEXO_RRH")
    private MdiMaestroColumna idAnexoRrh;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VALOR_UIT")
    private MdiMaestroColumna idValorUit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 4000)
    @Column(name = "NOTA_PROCEDIMIENTO")
    private String notaProcedimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcedimiento", fetch = FetchType.LAZY)
    private List<PghProcedimientoTramite> pghProcedimientoTramiteList;
    @OneToMany(mappedBy = "idProcedimiento", fetch = FetchType.LAZY)
    private List<PghHstProcedimiento> pghHstProcedimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcedimiento", fetch = FetchType.LAZY)
    private List<PghCnfRequProcedimiento> pghCnfRequProcedimientoList;

    //JPIRO
    @Transient
    private Long idProceso;
    @Transient
    private Long idEtapa;
    @Transient
    private String proceso;
    @Transient
    private Long tieneAct;
    @Transient
    private String descTramite;
    @Transient
    private String descActividad;
    
    public PghProcedimiento() {
    }

    public PghProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public PghProcedimiento(Long idProcedimiento, String item,String denominacion,Long idProceso,Long idEtapa,String proceso, Long tieneAct) {
        this.idProcedimiento = idProcedimiento;
        this.item=item;
        this.denominacion=denominacion;
        this.idProceso=idProceso;
        this.idEtapa=idEtapa;
        this.proceso=proceso;
        this.tieneAct=tieneAct;
    }
    
    public PghProcedimiento(String descTramite,String descActividad, String denominacion, String item) {
        this.descTramite=descTramite;
        this.descActividad=descActividad;
        this.denominacion=denominacion;
        this.item=item;
    }

    public String getDescTramite() {
        return descTramite;
    }

    public void setDescTramite(String descTramite) {
        this.descTramite = descTramite;
    }

    public String getDescActividad() {
        return descActividad;
    }

    public void setDescActividad(String descActividad) {
        this.descActividad = descActividad;
    }

    public Long getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Long idProceso) {
        this.idProceso = idProceso;
    }

    public Long getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Long idEtapa) {
        this.idEtapa = idEtapa;
    }

    public Long getTieneAct() {
        return tieneAct;
    }

    public void setTieneAct(Long tieneAct) {
        this.tieneAct = tieneAct;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }
    
    public PghProcedimiento(Long idProcedimiento,String item,String denominacion){
    	this.idProcedimiento=idProcedimiento;
    	this.item=item;
    	this.denominacion=denominacion;
    }

    public Long getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
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

    public Float getDerechoTramitacion() {
        return derechoTramitacion;
    }

    public void setDerechoTramitacion(Float derechoTramitacion) {
        this.derechoTramitacion = derechoTramitacion;
    }

    public MdiMaestroColumna getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(MdiMaestroColumna idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public MdiMaestroColumna getIdSilencioAdministrativo() {
        return idSilencioAdministrativo;
    }

    public void setIdSilencioAdministrativo(MdiMaestroColumna idSilencioAdministrativo) {
        this.idSilencioAdministrativo = idSilencioAdministrativo;
    }

    public Float getPlazoResolver() {
        return plazoResolver;
    }

    public void setPlazoResolver(Float plazoResolver) {
        this.plazoResolver = plazoResolver;
    }

    public MdiMaestroColumna getIdInicioProcedimiento() {
        return idInicioProcedimiento;
    }

    public void setIdInicioProcedimiento(MdiMaestroColumna idInicioProcedimiento) {
        this.idInicioProcedimiento = idInicioProcedimiento;
    }

    public MdiMaestroColumna getIdAutoridadCompetente() {
        return idAutoridadCompetente;
    }

    public void setIdAutoridadCompetente(MdiMaestroColumna idAutoridadCompetente) {
        this.idAutoridadCompetente = idAutoridadCompetente;
    }

    public MdiMaestroColumna getIdApelacion() {
        return idApelacion;
    }

    public void setIdApelacion(MdiMaestroColumna idApelacion) {
        this.idApelacion = idApelacion;
    }

    public MdiMaestroColumna getIdReconsideracion() {
        return idReconsideracion;
    }

    public void setIdReconsideracion(MdiMaestroColumna idReconsideracion) {
        this.idReconsideracion = idReconsideracion;
    }

    public MdiMaestroColumna getIdAnexoRrh() {
        return idAnexoRrh;
    }

    public void setIdAnexoRrh(MdiMaestroColumna idAnexoRrh) {
        this.idAnexoRrh = idAnexoRrh;
    }

    public MdiMaestroColumna getIdValorUit() {
        return idValorUit;
    }

    public void setIdValorUit(MdiMaestroColumna idValorUit) {
        this.idValorUit = idValorUit;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNotaProcedimiento() {
        return notaProcedimiento;
    }

    public void setNotaProcedimiento(String notaProcedimiento) {
        this.notaProcedimiento = notaProcedimiento;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghProcedimientoTramite> getPghProcedimientoTramiteList() {
        return pghProcedimientoTramiteList;
    }

    public void setPghProcedimientoTramiteList(List<PghProcedimientoTramite> pghProcedimientoTramiteList) {
        this.pghProcedimientoTramiteList = pghProcedimientoTramiteList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghHstProcedimiento> getPghHstProcedimientoList() {
        return pghHstProcedimientoList;
    }

    public void setPghHstProcedimientoList(List<PghHstProcedimiento> pghHstProcedimientoList) {
        this.pghHstProcedimientoList = pghHstProcedimientoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghCnfRequProcedimiento> getPghCnfRequProcedimientoList() {
        return pghCnfRequProcedimientoList;
    }

    public void setPghCnfRequProcedimientoList(List<PghCnfRequProcedimiento> pghCnfRequProcedimientoList) {
        this.pghCnfRequProcedimientoList = pghCnfRequProcedimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcedimiento != null ? idProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghProcedimiento)) {
            return false;
        }
        PghProcedimiento other = (PghProcedimiento) object;
        if ((this.idProcedimiento == null && other.idProcedimiento != null) || (this.idProcedimiento != null && !this.idProcedimiento.equals(other.idProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghProcedimiento[ idProcedimiento=" + idProcedimiento + " ]";
    }
    
}
