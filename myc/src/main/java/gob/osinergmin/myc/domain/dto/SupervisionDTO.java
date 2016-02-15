package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author lbarboza
 */
public class SupervisionDTO {
    
    /** Codigo de la supervision**/
    private String idSupervision;
    /** Descripcion de la supervision**/
    private String descripcionSupervision;

    public String getIdSupervision() {
        return idSupervision;
    }

    public void setIdSupervision(String idSupervision) {
        this.idSupervision = idSupervision;
    }

    public String getDescripcionSupervision() {
        return descripcionSupervision;
    }

    public void setDescripcionSupervision(String descripcionSupervision) {
        this.descripcionSupervision = descripcionSupervision;
    }
}