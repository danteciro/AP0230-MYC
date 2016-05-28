package gob.osinergmin.myc.domain.dto;

public class RequProcParaDinaDTO {
    private Long idRequProcParaDina;
    private Long idRequisitoProcedimiento;
    private ValorParametroDTO valorParametro;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ValorParametroDTO getValorParametro() {
        return valorParametro;
    }

    public void setValorParametro(ValorParametroDTO valorParametro) {
        this.valorParametro = valorParametro;
    }
    
    public Long getIdRequProcParaDina() {
        return idRequProcParaDina;
    }

    public void setIdRequProcParaDina(Long idRequProcParaDina) {
        this.idRequProcParaDina = idRequProcParaDina;
    }
    
    public Long getIdRequisitoProcedimiento() {
            return idRequisitoProcedimiento;
    }
    public void setIdRequisitoProcedimiento(Long idRequisitoProcedimiento) {
            this.idRequisitoProcedimiento = idRequisitoProcedimiento;
    }
}
