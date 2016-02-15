/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "PGH_VALOR_PARAMETRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghValorParametro.findAll", query = "SELECT p FROM PghValorParametro p"),
    @NamedQuery(name = "PghValorParametro.countByFilter",query="Select count(d.idValorParametro) from PghValorParametro d where d.estado='1' and d.idParametroDinamico.idParametroDinamico=:idParametroDinamico "),
    @NamedQuery(name = "PghValorParametro.findByIdValorParametro",query="Select d from PghValorParametro d where d.estado='1' and d.idValorParametro=:idValorParametro  "),
    @NamedQuery(name = "PghValorParametro.findByIdParametroDinamico",query="Select d from PghValorParametro d where d.estado='1' and d.idParametroDinamico.idParametroDinamico=:idParametroDinamico ")})
  
public class PghValorParametro extends Auditoria{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VALOR_PARAMETRO")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_VALOR_PARAMETRO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idValorParametro;
    @Size(max = 100)
    @Column(name = "VALOR")
    private String valor;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 500)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Column(name = "VALOR_DEFECTO")
    private String valorDefecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)

    @JoinColumn(name = "ID_PARAMETRO_DINAMICO", referencedColumnName = "ID_PARAMETRO_DINAMICO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghParametroDinamico idParametroDinamico;
    @OneToMany(mappedBy = "idValorParametro", fetch = FetchType.LAZY)
    private List<PghHstValorParametro> pghHstValorParametroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idValorParametro", fetch = FetchType.LAZY)
    private List<PghRequProcParaDina> pghRequProcParaDinaList;

    public PghValorParametro() {
    }

    public PghValorParametro(Long idValorParametro) {
        this.idValorParametro = idValorParametro;
    }

    public PghValorParametro(Long idValorParametro, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idValorParametro = idValorParametro;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }
    
    public PghValorParametro(Long idValorParametro,String valor,String descripcion){
    	this.idValorParametro = idValorParametro;
    	this.valor=valor;
    	this.descripcion=descripcion;
    }

    public Long getIdValorParametro() {
        return idValorParametro;
    }

    public void setIdValorParametro(Long idValorParametro) {
        this.idValorParametro = idValorParametro;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getValorDefecto() {
        return valorDefecto;
    }

    public void setValorDefecto(String valorDefecto) {
        this.valorDefecto = valorDefecto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    public PghParametroDinamico getIdParametroDinamico() {
        return idParametroDinamico;
    }

    public void setIdParametroDinamico(PghParametroDinamico idParametroDinamico) {
        this.idParametroDinamico = idParametroDinamico;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghHstValorParametro> getPghHstValorParametroList() {
        return pghHstValorParametroList;
    }

    public void setPghHstValorParametroList(List<PghHstValorParametro> pghHstValorParametroList) {
        this.pghHstValorParametroList = pghHstValorParametroList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghRequProcParaDina> getPghRequProcParaDinaList() {
        return pghRequProcParaDinaList;
    }

    public void setPghRequProcParaDinaList(List<PghRequProcParaDina> pghRequProcParaDinaList) {
        this.pghRequProcParaDinaList = pghRequProcParaDinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValorParametro != null ? idValorParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghValorParametro)) {
            return false;
        }
        PghValorParametro other = (PghValorParametro) object;
        if ((this.idValorParametro == null && other.idValorParametro != null) || (this.idValorParametro != null && !this.idValorParametro.equals(other.idValorParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghValorParametro[ idValorParametro=" + idValorParametro + " ]";
    }
    
}
