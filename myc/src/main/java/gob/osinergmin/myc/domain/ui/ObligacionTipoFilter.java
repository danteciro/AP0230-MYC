package gob.osinergmin.myc.domain.ui;

import java.util.List;

import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

public class ObligacionTipoFilter  extends BasePaginatorFilter{

	private Long idObligacionTipo;
	private String nombre;
	private String estado;
	
        public ObligacionTipoFilter(){}
        
        public ObligacionTipoFilter(String nombre,String estado){
            this.nombre=nombre;
            this.estado=estado;
        }
        
	List<ObligacionTipoDTO> obligaciones;
	
	public Long getIdObligacionTipo() {
		return idObligacionTipo;
	}
	public void setIdObligacionTipo(Long idObligacionTipo) {
		this.idObligacionTipo = idObligacionTipo;
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
	
	public List<ObligacionTipoDTO> getObligaciones() {
		return obligaciones;
	}
	
	public void setObligaciones(List<ObligacionTipoDTO> obligaciones) {
		this.obligaciones = obligaciones;
	}
	
}
