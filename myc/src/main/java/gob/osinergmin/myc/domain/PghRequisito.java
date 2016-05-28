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
@Table(name = "PGH_REQUISITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="PghRequisito.countAll",query="Select count(d.idRequisito) from PghRequisito d where d.estado='1'"),
    @NamedQuery(name="PghRequisito.findAll",query="Select d from PghRequisito d where d.estado='1'"),
    @NamedQuery(name="PghRequisito.countByFilter",query="Select count(d.idRequisito) from PghRequisito d where d.estado='1' and upper(d.descripcion) like :descripcion "),
    @NamedQuery(name="PghRequisito.findByFilter",query="Select d from PghRequisito d where d.estado='1' and upper(d.descripcion) like :descripcion order by d.descripcion"),
    @NamedQuery(name="PghRequisito.findByIdRequisito",query="Select new PghRequisito(d.idRequisito,d.descripcion,d.comentarioPredeterminado,da.idDocumentoAdjunto,da.nombreArchivo,da.rutaAlfresco) from PghRequisito d left join d.idDocumentoAdjunto da where d.estado='1' and d.idRequisito=:idRequisito ")
})
public class PghRequisito extends Auditoria {
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REQUISITO", nullable = false)
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_REQUISITO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idRequisito;
    @Size(max = 4000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 1500)
    @Column(name = "COMENTARIO_PREDETERMINADO")
    private String comentarioPredeterminado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idRequisito", fetch = FetchType.LAZY)
    private List<PghHstRequisito> pghHstRequisitoList;
    @JoinColumn(name = "ID_DOCUMENTO_ADJUNTO", referencedColumnName = "ID_DOCUMENTO_ADJUNTO")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiDocumentoAdjunto idDocumentoAdjunto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequisito", fetch = FetchType.LAZY)
    private List<PghCnfRequProcedimiento> pghCnfRequProcedimientoList;

    public PghRequisito() {
    }

    public PghRequisito(Long idRequisito) {
        this.idRequisito = idRequisito;
    }

    public PghRequisito(Long idRequisito,String descripcion){
        this.idRequisito= idRequisito;
        this.descripcion= descripcion;  
    }
    public PghRequisito(Long idRequisito,String descripcion,String comentarioPredeterminado,Long idDocumentoAdjunto,String nombre,String rutaAlfresco){
        this.idRequisito= idRequisito;
        this.descripcion= descripcion; 
        this.comentarioPredeterminado=comentarioPredeterminado;
        this.idDocumentoAdjunto=new MdiDocumentoAdjunto(idDocumentoAdjunto,nombre,rutaAlfresco);
    }
    
    public PghRequisito(String descripcion) {
        this.descripcion=descripcion;
    }

    public Long getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(Long idRequisito) {
        this.idRequisito = idRequisito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentarioPredeterminado() {
        return comentarioPredeterminado;
    }

    public void setComentarioPredeterminado(String comentarioPredeterminado) {
        this.comentarioPredeterminado = comentarioPredeterminado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghHstRequisito> getPghHstRequisitoList() {
        return pghHstRequisitoList;
    }

    public void setPghHstRequisitoList(List<PghHstRequisito> pghHstRequisitoList) {
        this.pghHstRequisitoList = pghHstRequisitoList;
    }

    public MdiDocumentoAdjunto getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }

    public void setIdDocumentoAdjunto(MdiDocumentoAdjunto idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
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
        hash += (idRequisito != null ? idRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghRequisito)) {
            return false;
        }
        PghRequisito other = (PghRequisito) object;
        if ((this.idRequisito == null && other.idRequisito != null) || (this.idRequisito != null && !this.idRequisito.equals(other.idRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghRequisito[ idRequisito=" + idRequisito + " ]";
    }
    
}
