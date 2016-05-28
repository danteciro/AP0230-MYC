package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author gvillanueva
 */
public class SancionEspecificaDTO {
    
    /** Codigo del criterio**/
    private String idSancionEspecifica;
    /** Descripcion del criterio**/
    private String descripcionSancionEspecifica;
    
    private String idCriterio;
    
    private String codigoTipificacion;
    
    private String codigoObligacion;

    public String getIdSancionEspecifica() {
        return idSancionEspecifica;
    }

    public void setIdSancionEspecifica(String idSancionEspecifica) {
        this.idSancionEspecifica = idSancionEspecifica;
    }

    public String getDescripcionSancionEspecifica() {
        return descripcionSancionEspecifica;
    }

    public void setDescripcionSancionEspecifica(String descripcionSancionEspecifica) {
        this.descripcionSancionEspecifica = descripcionSancionEspecifica;
    }

    public String getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(String idCriterio) {
        this.idCriterio = idCriterio;
    }

    public String getCodigoObligacion() {
        return codigoObligacion;
    }

    public void setCodigoObligacion(String codigoObligacion) {
        this.codigoObligacion = codigoObligacion;
    }

    public String getCodigoTipificacion() {
        return codigoTipificacion;
    }

    public void setCodigoTipificacion(String codigoTipificacion) {
        this.codigoTipificacion = codigoTipificacion;
    }
    
    
}
