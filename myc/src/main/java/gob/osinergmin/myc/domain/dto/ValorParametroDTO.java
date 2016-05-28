/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author jpiro
 */
public class ValorParametroDTO {
    private Long idValorParametro;
    private Long idParametroDinamico;
    private String valor;
    private String descripcion;
    private String comentario;
    private String valorDefecto;
    private String estado;
    private String ambito;

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public Long getIdValorParametro() {
        return idValorParametro;
    }

    public void setIdValorParametro(Long idValorParametro) {
        this.idValorParametro = idValorParametro;
    }

    public Long getIdParametroDinamico() {
        return idParametroDinamico;
    }

    public void setIdParametroDinamico(Long idParametroDinamico) {
        this.idParametroDinamico = idParametroDinamico;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        if(valor!=null){
    	this.valor = valor.toUpperCase();
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
    	this.descripcion = descripcion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getValorDefecto() {
        return valorDefecto;
    }

    public void setValorDefecto(String valorDefecto) {
        this.valorDefecto = valorDefecto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
