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
@Table(name = "PGH_ETAPA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghEtapa.countAll", query = "SELECT count(p.idEtapa) FROM PghEtapa p left join p.idProceso pr where p.estado=:estado"),
    @NamedQuery(name = "PghEtapa.findAll", query = "SELECT new PghEtapa(p.idEtapa, pr.descripcion, p.descripcion, p.idProceso.idProceso) FROM PghEtapa p left join p.idProceso pr where p.estado=:estado"),
    @NamedQuery(name = "PghEtapa.findByDescProceso", query = "SELECT p FROM PghEtapa p left join p.idProceso pro where p.estado=:estado and pro.descripcion=:descProceso"),
    @NamedQuery(name = "PghEtapa.countByDescProceso", query = "SELECT count(p.idEtapa) FROM PghEtapa p left join p.idProceso pro where p.estado=:estado and pro.descripcion=:descProceso"),
    @NamedQuery(name = "PghEtapa.countByIdProceso", query = "SELECT count(p.idEtapa) FROM PghEtapa p left join p.idProceso pr where p.estado=:estado and p.idProceso.idProceso=:idProceso and upper(p.descripcion) like :descripcion "),
    @NamedQuery(name = "PghEtapa.findByIdProceso", query = "SELECT new PghEtapa(p.idEtapa, pr.descripcion, p.descripcion, p.idProceso.idProceso) FROM PghEtapa p left join p.idProceso pr where p.estado=:estado and p.idProceso.idProceso=:idProceso and upper(p.descripcion) like :descripcion order by p.descripcion"),
    @NamedQuery(name = "PghEtapa.findByIdEtapa", query = "SELECT p FROM PghEtapa p where p.idEtapa=:idEtapa"),
    @NamedQuery(name = "PghEtapa.findAllWithDetail", 
        query = "SELECT new PghEtapa(e.idEtapa,e.descripcion," +
"sum(case when t.idTramite is not null and t.estado='1' then 1 else 0 end) as nroTram," +
"sum(case when ta.idTramiteActivdad is not null and ta.estado='1' then 1 else 0 end) as nroAct ) " +
"from PghEtapa e " +
"left join e.pghTramiteList t " +
"left join t.pghCnfTramiteActividadList ta " +
"WHERE e.estado='1' and e.idProceso.idProceso=:idProceso " +
"group by e.idEtapa,e.descripcion ")
})
public class PghEtapa extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ETAPA")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_ETAPA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idEtapa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_PROCESO", referencedColumnName = "ID_PROCESO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghProceso idProceso;
    @OneToMany(mappedBy = "idEtapa", fetch = FetchType.LAZY)
    private List<PghTramite> pghTramiteList;
    
    //LBARBOZA
    @Transient
    private String proceso;
    @Transient
    private Long nroTram;
    @Transient
    private Long nroAct;

    public PghEtapa() {
    }

    public PghEtapa(Long idEtapa) {
        this.idEtapa = idEtapa;
    }

    public PghEtapa(Long idEtapa, String usuarioCreacion, Date fechaCreacion, String terminalCreacion, String estado) {
        this.idEtapa = idEtapa;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
        this.estado = estado;
    }
    
    public PghEtapa(Long idEtapa, String proceso, String descripcion, Long idProceso){
        this.idEtapa = idEtapa;
        this.proceso = proceso;
        this.descripcion = descripcion;
        this.idProceso = new PghProceso(idProceso);
    }
    
    public PghEtapa(Long idEtapa, String descripcion, Long nroTram, Long nroAct){
        this.idEtapa = idEtapa;
        this.descripcion = descripcion;
        this.nroTram = nroTram;
        this.nroAct = nroAct;
    }

    public Long getNroTram() {
        return nroTram;
    }

    public void setNroTram(Long nroTram) {
        this.nroTram = nroTram;
    }

    public Long getNroAct() {
        return nroAct;
    }

    public void setNroAct(Long nroAct) {
        this.nroAct = nroAct;
    }

    public Long getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Long idEtapa) {
        this.idEtapa = idEtapa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PghProceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(PghProceso idProceso) {
        this.idProceso = idProceso;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghTramite> getPghTramiteList() {
        return pghTramiteList;
    }

    public void setPghTramiteList(List<PghTramite> pghTramiteList) {
        this.pghTramiteList = pghTramiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtapa != null ? idEtapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghEtapa)) {
            return false;
        }
        PghEtapa other = (PghEtapa) object;
        if ((this.idEtapa == null && other.idEtapa != null) || (this.idEtapa != null && !this.idEtapa.equals(other.idEtapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghEtapa[ idEtapa=" + idEtapa + " ]";
    }
}
