/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author jpiro
 */
public class ZonificacionDetalleDTO {
    private Long idZonificacionDetalle;
    private String estado;
    private ZonificacionDTO zonificacion;
    private UbigeoDTO ubigeo;
    private Long idZonificacion;
    private String idDepartamento;
    private String idProvincia;
    private String idDistrito;
    private String nombreProvincia;
    private String nombreDepartamento;
    private String nombreDistrito;
    private String nombreZonificacion;

    public Long getIdZonificacionDetalle() {
        return idZonificacionDetalle;
    }

    public void setIdZonificacionDetalle(Long idZonificacionDetalle) {
        this.idZonificacionDetalle = idZonificacionDetalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ZonificacionDTO getZonificacion() {
        return zonificacion;
    }

    public void setZonificacion(ZonificacionDTO zonificacion) {
        this.zonificacion = zonificacion;
    }

    public UbigeoDTO getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(UbigeoDTO ubigeo) {
        this.ubigeo = ubigeo;
    }

    public Long getIdZonificacion() {
        return idZonificacion;
    }

    public void setIdZonificacion(Long idZonificacion) {
        this.idZonificacion = idZonificacion;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(String idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public String getNombreZonificacion() {
        return nombreZonificacion;
    }

    public void setNombreZonificacion(String nombreZonificacion) {
        this.nombreZonificacion = nombreZonificacion;
    }
}
