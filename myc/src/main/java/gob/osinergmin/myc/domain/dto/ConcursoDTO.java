/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author lbarboza
 */
public class ConcursoDTO {
    private Long idConcurso;
    private String numeroConcurso;
    private String nombreConcurso;
    private String descripcionConcurso;
    private String estado;

    public Long getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(Long idConcurso) {
        this.idConcurso = idConcurso;
    }

    public String getNumeroConcurso() {
        return numeroConcurso;
    }

    public void setNumeroConcurso(String numeroConcurso) {
        if(numeroConcurso!=null){
            this.numeroConcurso = numeroConcurso.toUpperCase();
        }else{
            this.numeroConcurso = numeroConcurso;
        }        
    }

    public String getNombreConcurso() {
        return nombreConcurso;
    }

    public void setNombreConcurso(String nombreConcurso) {
        if(nombreConcurso!=null){
            this.nombreConcurso = nombreConcurso.toUpperCase();
        }else{
            this.nombreConcurso = nombreConcurso;
        }
    }

    public String getDescripcionConcurso() {
        return descripcionConcurso;
    }

    public void setDescripcionConcurso(String descripcionConcurso) {
        if(descripcionConcurso!=null){
            this.descripcionConcurso = descripcionConcurso.toUpperCase();
        }else{
            this.descripcionConcurso = descripcionConcurso;
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}