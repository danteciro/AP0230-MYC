/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_CNF_REQU_PROCEDIMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghCnfRequProcedimiento.findAll", query = "SELECT p FROM PghCnfRequProcedimiento p where p.estado=:estado"),
    @NamedQuery(name = "PghCnfRequProcedimiento.countAll", query = "SELECT count(p.idRequisitoProcedimiento) FROM PghCnfRequProcedimiento p where p.estado=:estado"),
    @NamedQuery(name = "PghCnfRequProcedimiento.findByIdProcedimiento", query = "SELECT p FROM PghCnfRequProcedimiento p where p.estado=:estado and p.idProcedimiento.idProcedimiento=:idProcedimiento and p.flgGeneral=:flgGeneral order by p.nroOrden "),
    @NamedQuery(name = "PghCnfRequProcedimiento.countByIdProcedimiento", query = "SELECT count(p.idRequisitoProcedimiento) FROM PghCnfRequProcedimiento p where p.estado=:estado and p.idProcedimiento.idProcedimiento=:idProcedimiento and p.flgGeneral=:flgGeneral"),
    @NamedQuery(name = "PghCnfRequProcedimiento.findAllByIdProcedimiento", query = "SELECT p FROM PghCnfRequProcedimiento p where p.estado=:estado and p.idProcedimiento.idProcedimiento=:idProcedimiento"),
    @NamedQuery(name = "PghCnfRequProcedimiento.findAllByIdProcedimientoIdTramite", query = "SELECT p FROM PghCnfRequProcedimiento p where p.estado=:estado and p.idProcedimiento.idProcedimiento=:idProcedimiento and p.idTramite.idTramite=:idTramite"),
    @NamedQuery(name = "PghCnfRequProcedimiento.findAllByIdProcedimientoIdActividad", query = "SELECT p FROM PghCnfRequProcedimiento p where p.estado=:estado and p.idProcedimiento.idProcedimiento=:idProcedimiento and p.idActividad.idActividad=:idActividad")
})
public class PghCnfRequProcedimiento extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REQUISITO_PROCEDIMIENTO")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_CNF_REQU_PROCEDIMIENTO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idRequisitoProcedimiento;
    @Size(max = 1500)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "ID_REQUISITO_PROCEDIMIENTO_PAD")
    private Long idRequisitoProcedimientoPad;
    @Column(name = "FLG_GENERAL")
    private String flgGeneral;
    @Column(name = "NRO_ORDEN")
    private Long nroOrden;
    @JoinColumn(name = "ID_ZONIFICACION", referencedColumnName = "ID_ZONIFICACION")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghZonificacion idZonificacion;
//    @JoinColumn(name = "ID_ZONIFICACION_DETALLE", referencedColumnName = "ID_ZONIFICACION_DETALLE")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private PghZonificacionDetalle idZonificacionDetalle;
    @JoinColumn(name = "ID_TRAMITE", referencedColumnName = "ID_TRAMITE")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghTramite idTramite;
    @JoinColumn(name = "ID_REQUISITO", referencedColumnName = "ID_REQUISITO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghRequisito idRequisito;
    @JoinColumn(name = "ID_PROCEDIMIENTO", referencedColumnName = "ID_PROCEDIMIENTO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghProcedimiento idProcedimiento;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pghCnfRequProcedimiento1", fetch = FetchType.LAZY)
    private PghCnfRequProcedimiento pghCnfRequProcedimiento;
    @JoinColumn(name = "ID_REQUISITO_PROCEDIMIENTO", referencedColumnName = "ID_REQUISITO_PROCEDIMIENTO", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private PghCnfRequProcedimiento pghCnfRequProcedimiento1;
    @JoinColumn(name = "ID_MOTIVO_TRAMITE", referencedColumnName = "ID_MOTIVO_TRAMITE")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghMotivoTramite idMotivoTramite;
    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiActividad idActividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequisitoProcedimiento", fetch = FetchType.LAZY)
    private List<PghRequProcParaDina> pghRequProcParaDinaList;

    public PghCnfRequProcedimiento() {
    }

    public PghCnfRequProcedimiento(Long idRequisitoProcedimiento) {
        this.idRequisitoProcedimiento = idRequisitoProcedimiento;
    }

    public PghCnfRequProcedimiento(Long idRequisitoProcedimiento, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idRequisitoProcedimiento = idRequisitoProcedimiento;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }
    
    public PghCnfRequProcedimiento(Long idProcedimiento,String item,String denominacion){
    	
    	this.idProcedimiento=new PghProcedimiento(idProcedimiento,item, denominacion);
    	
    }

    public String getFlgGeneral() {
        return flgGeneral;
    }

    public void setFlgGeneral(String flgGeneral) {
        this.flgGeneral = flgGeneral;
    }

    public Long getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(Long nroOrden) {
        this.nroOrden = nroOrden;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdRequisitoProcedimiento() {
        return idRequisitoProcedimiento;
    }

    public void setIdRequisitoProcedimiento(Long idRequisitoProcedimiento) {
        this.idRequisitoProcedimiento = idRequisitoProcedimiento;
    }

    public Long getIdRequisitoProcedimientoPad() {
        return idRequisitoProcedimientoPad;
    }

    public void setIdRequisitoProcedimientoPad(Long idRequisitoProcedimientoPad) {
        this.idRequisitoProcedimientoPad = idRequisitoProcedimientoPad;
    }

    public PghZonificacion getIdZonificacion() {
        return idZonificacion;
    }

    public void setIdZonificacion(PghZonificacion idZonificacion) {
        this.idZonificacion = idZonificacion;
    }
//    public PghZonificacionDetalle getIdZonificacionDetalle() {
//        return idZonificacionDetalle;
//    }
//
//    public void setIdZonificacionDetalle(PghZonificacionDetalle idZonificacionDetalle) {
//        this.idZonificacionDetalle = idZonificacionDetalle;
//    }

    public PghTramite getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(PghTramite idTramite) {
        this.idTramite = idTramite;
    }

    public PghRequisito getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(PghRequisito idRequisito) {
        this.idRequisito = idRequisito;
    }

    public PghProcedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(PghProcedimiento idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public PghCnfRequProcedimiento getPghCnfRequProcedimiento() {
        return pghCnfRequProcedimiento;
    }

    public void setPghCnfRequProcedimiento(PghCnfRequProcedimiento pghCnfRequProcedimiento) {
        this.pghCnfRequProcedimiento = pghCnfRequProcedimiento;
    }

    public PghCnfRequProcedimiento getPghCnfRequProcedimiento1() {
        return pghCnfRequProcedimiento1;
    }

    public void setPghCnfRequProcedimiento1(PghCnfRequProcedimiento pghCnfRequProcedimiento1) {
        this.pghCnfRequProcedimiento1 = pghCnfRequProcedimiento1;
    }

    public PghMotivoTramite getIdMotivoTramite() {
        return idMotivoTramite;
    }

    public void setIdMotivoTramite(PghMotivoTramite idMotivoTramite) {
        this.idMotivoTramite = idMotivoTramite;
    }

    public MdiActividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(MdiActividad idActividad) {
        this.idActividad = idActividad;
    }
    
    @XmlTransient
    public List<PghRequProcParaDina> getPghRequProcParaDinaList() {
        return pghRequProcParaDinaList;
    }

    public void setPghRequProcParaDinaList(List<PghRequProcParaDina> pghRequProcParaDinaList) {
        this.pghRequProcParaDinaList = pghRequProcParaDinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequisitoProcedimiento != null ? idRequisitoProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghCnfRequProcedimiento)) {
            return false;
        }
        PghCnfRequProcedimiento other = (PghCnfRequProcedimiento) object;
        if ((this.idRequisitoProcedimiento == null && other.idRequisitoProcedimiento != null) || (this.idRequisitoProcedimiento != null && !this.idRequisitoProcedimiento.equals(other.idRequisitoProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghCnfRequProcedimiento[ idRequisitoProcedimiento=" + idRequisitoProcedimiento + " ]";
    }
    
}
