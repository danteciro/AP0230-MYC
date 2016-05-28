package gob.osinergmin.myc.domain.dto;

import java.util.List;

public class CnfRequProcedimientoDTO {
    private Long idRequisitoProcedimiento;
    private ProcedimientoDTO procedimiento;
    private RequisitoDTO requisito;
    private String comentario;
    private Long idRequisitoProcedimientoPad;
    private String flgGeneral;
    private List<RequProcParaDinaDTO> valoresParaDina;
    private String estado;
    
    private Long idRequisito;
    private Long idProcedimiento;
    private Long idTramite;
    private String descTramite; 
    private Long idActividad;
    private String descActividad;
    private Long idZonificacion;
    private String descZonificacion;
    private Long idMotivoTramite;
    private String descMotivoTramite;
    private Long nroOrden;

    public Long getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(Long nroOrden) {
        this.nroOrden = nroOrden;
    }
    
    public String getDescZonificacion() {
        return descZonificacion;
    }

    public void setDescZonificacion(String descZonificacion) {
        this.descZonificacion = descZonificacion;
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

    public String getDescMotivoTramite() {
        return descMotivoTramite;
    }

    public void setDescMotivoTramite(String descMotivoTramite) {
        this.descMotivoTramite = descMotivoTramite;
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public Long getIdZonificacion() {
        return idZonificacion;
    }

    public void setIdZonificacion(Long idZonificacion) {
        this.idZonificacion = idZonificacion;
    }

    public Long getIdMotivoTramite() {
        return idMotivoTramite;
    }

    public void setIdMotivoTramite(Long idMotivoTramite) {
        this.idMotivoTramite = idMotivoTramite;
    }
    
    public Long getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public Long getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(Long idRequisito) {
        this.idRequisito = idRequisito;
    }
    
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public List<RequProcParaDinaDTO> getValoresParaDina() {
        return valoresParaDina;
    }

    public void setValoresParaDina(List<RequProcParaDinaDTO> valoresParaDina) {
        this.valoresParaDina = valoresParaDina;
    }

    public RequisitoDTO getRequisito() {
        return requisito;
    }

    public void setRequisito(RequisitoDTO requisito) {
        this.requisito = requisito;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getIdRequisitoProcedimientoPad() {
        return idRequisitoProcedimientoPad;
    }

    public void setIdRequisitoProcedimientoPad(Long idRequisitoProcedimientoPad) {
        this.idRequisitoProcedimientoPad = idRequisitoProcedimientoPad;
    }

    public String getFlgGeneral() {
        return flgGeneral;
    }

    public void setFlgGeneral(String flgGeneral) {
        this.flgGeneral = flgGeneral;
    }
    public Long getIdRequisitoProcedimiento() {
            return idRequisitoProcedimiento;
    }
    public void setIdRequisitoProcedimiento(Long idRequisitoProcedimiento) {
            this.idRequisitoProcedimiento = idRequisitoProcedimiento;
    }
    public ProcedimientoDTO getProcedimiento() {
            return procedimiento;
    }
    public void setProcedimiento(ProcedimientoDTO procedimiento) {
            this.procedimiento = procedimiento;
    }
}
