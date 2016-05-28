package gob.osinergmin.myc.domain.in;

import java.io.Serializable;

/**
 * Clase de peticion de web service.
 * @author dmedrano
 * @version 1.0
 */
public class ObtenerMaestrosColumnaInRO implements Serializable{	
    private static final long serialVersionUID = 3713032972243894836L;
    private Long idMaestroColumna;
    private String codigo;
    private String dominio;
    private String aplicacion;
    private String descripcion;

    public ObtenerMaestrosColumnaInRO(){		
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDominio() {
            return dominio;
    }

    public void setDominio(String dominio) {
            this.dominio = dominio;
    }

    public String getAplicacion() {
            return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
            this.aplicacion = aplicacion;
    }

    public Long getIdMaestroColumna() {
        return idMaestroColumna;
    }

    public void setIdMaestroColumna(Long idMaestroColumna) {
        this.idMaestroColumna = idMaestroColumna;
    }
    
}
