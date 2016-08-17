/**
* Resumen           
* Objeto            : PrioridadNormaAgenteDTO.java
* Descripción       : Objeto DTO Lista de Prioridad Norma Agente
* Fecha de Creación : 28/06/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Erick Ortiz Gil.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
package gob.osinergmin.myc.domain.dto;
import java.util.List;

public class ListaPrioridadNormaAgenteDTO {	
	private List<PrioridadNormaAgenteDTO> listaPrioridadNorma;
	private String codigosOrden;
    private String codigosPrioridadNormaAgente;

	public List<PrioridadNormaAgenteDTO> getListaPrioridadNorma() {
		return listaPrioridadNorma;
	}

	public void setListaPrioridadNorma(List<PrioridadNormaAgenteDTO> listaPrioridadNorma) {
		this.listaPrioridadNorma = listaPrioridadNorma;
	}

	public String getCodigosOrden() {
		return codigosOrden;
	}

	public void setCodigosOrden(String codigosOrden) {
		this.codigosOrden = codigosOrden;
	}

	public String getCodigosPrioridadNormaAgente() {
		return codigosPrioridadNormaAgente;
	}

	public void setCodigosPrioridadNormaAgente(
			String codigosPrioridadNormaAgente) {
		this.codigosPrioridadNormaAgente = codigosPrioridadNormaAgente;
	}
}
