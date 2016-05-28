/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author jpiro
 */
public class ZonificacionDTO {
    private Long idZonificacion;
    private String nombre;
    private String estado;

    public ZonificacionDTO(){
    }
    
    public ZonificacionDTO(Long idZonificacion,String nombre){
        this.idZonificacion=idZonificacion;
        this.nombre=nombre;
    }
    
    public Long getIdZonificacion() {
        return idZonificacion;
    }

    public void setIdZonificacion(Long idZonificacion) {
        this.idZonificacion = idZonificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
