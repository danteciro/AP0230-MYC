/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_REQU_PROC_PARA_DINA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghRequProcParaDina.findAll", query = "SELECT p FROM PghRequProcParaDina p"),
    @NamedQuery(name = "PghRequProcParaDina.findByIdRequisitoProcedimiento", query = "SELECT p FROM PghRequProcParaDina p "
        + "where p.estado=:estado and p.idRequisitoProcedimiento.idRequisitoProcedimiento=:idRequisitoProcedimiento")
    })
public class PghRequProcParaDina extends Auditoria{
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REQU_PROC_PARA_DINA")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_REQU_PROC_PARA_DINA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idRequProcParaDina;
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_VALOR_PARAMETRO", referencedColumnName = "ID_VALOR_PARAMETRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghValorParametro idValorParametro;
    @JoinColumn(name = "ID_REQUISITO_PROCEDIMIENTO", referencedColumnName = "ID_REQUISITO_PROCEDIMIENTO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghCnfRequProcedimiento idRequisitoProcedimiento;

    public PghRequProcParaDina() {
    }

    public PghRequProcParaDina(Long idRequProcParaDina) {
        this.idRequProcParaDina = idRequProcParaDina;
    }
    
    public PghRequProcParaDina(Long idRequProcParaDina,Long idValorParametro, String valor, String descripcion ) {
        this.idRequProcParaDina = idRequProcParaDina;       
        this.idValorParametro=new PghValorParametro(idValorParametro,valor,descripcion);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdRequProcParaDina() {
        return idRequProcParaDina;
    }

    public void setIdRequProcParaDina(Long idRequProcParaDina) {
        this.idRequProcParaDina = idRequProcParaDina;
    }

    public PghValorParametro getIdValorParametro() {
        return idValorParametro;
    }

    public void setIdValorParametro(PghValorParametro idValorParametro) {
        this.idValorParametro = idValorParametro;
    }
    
    public PghCnfRequProcedimiento getIdRequisitoProcedimiento() {
        return idRequisitoProcedimiento;
    }

    public void setIdRequisitoProcedimiento(PghCnfRequProcedimiento idRequisitoProcedimiento) {
        this.idRequisitoProcedimiento = idRequisitoProcedimiento;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequProcParaDina != null ? idRequProcParaDina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghRequProcParaDina)) {
            return false;
        }
        PghRequProcParaDina other = (PghRequProcParaDina) object;
        if ((this.idRequProcParaDina == null && other.idRequProcParaDina != null) || (this.idRequProcParaDina != null && !this.idRequProcParaDina.equals(other.idRequProcParaDina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghRequProcParaDina[ idRequProcParaDina=" + idRequProcParaDina + " ]";
    }
    
}
