package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

public class ObligacionFilter extends BasePaginatorFilter{
    private Long idObligacion;
    private String descripcion;
    
    private String codigoObligacion;
    private Long idCriticidadObligacion;
    //para busqueda varios actividades (rubros) por obligacion
    private String idActividadesBusq;
    //para busqueda varios temas por obligacion (rubros)
    private String idTemasBusq;
    //indicador de busqueda avanzada
    private String flgBusqAvanzada;
    //descrip detalle (acta y declaracion jurada)
    private String descDetalle;

    private String idsObligacion;
    
    public String getDescDetalle() {
        return descDetalle;
    }

    public void setDescDetalle(String descDetalle) {
        this.descDetalle = descDetalle;
    }
    
    public String getFlgBusqAvanzada() {
        return flgBusqAvanzada;
    }

    public void setFlgBusqAvanzada(String flgBusqAvanzada) {
        this.flgBusqAvanzada = flgBusqAvanzada;
    }

    public String getCodigoObligacion() {
        return codigoObligacion;
    }

    public void setCodigoObligacion(String codigoObligacion) {
        this.codigoObligacion = codigoObligacion;
    }

    public Long getIdCriticidadObligacion() {
        return idCriticidadObligacion;
    }

    public void setIdCriticidadObligacion(Long idCriticidadObligacion) {
        this.idCriticidadObligacion = idCriticidadObligacion;
    }

    public String getIdActividadesBusq() {
        return idActividadesBusq;
    }

    public void setIdActividadesBusq(String idActividadesBusq) {
        this.idActividadesBusq = idActividadesBusq;
    }

    public String getIdTemasBusq() {
        return idTemasBusq;
    }

    public void setIdTemasBusq(String idTemasBusq) {
        this.idTemasBusq = idTemasBusq;
    }

    public Long getIdObligacion() {
            return idObligacion;
    }
    public void setIdObligacion(Long idObligacion) {
            this.idObligacion = idObligacion;
    }
    public String getDescripcion() {
            return descripcion;
    }
    public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
    }

    public String getIdsObligacion() {
        return idsObligacion;
    }

    public void setIdsObligacion(String idsObligacion) {
        this.idsObligacion = idsObligacion;
    }
    
}
