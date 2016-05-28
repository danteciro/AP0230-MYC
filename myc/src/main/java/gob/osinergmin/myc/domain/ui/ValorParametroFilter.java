/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

/**
 *
 * @author jpiro
 */
public class ValorParametroFilter extends BasePaginatorFilter{
    private Long idValorParametro;
    private Long idParametroDinamico;
    private String descripcion;
    private String valor;
     
    public ValorParametroFilter(){
    }
    
    public ValorParametroFilter(Long idParametroDinamico){
        this.idParametroDinamico=idParametroDinamico;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
    
    
    
    
    
}
