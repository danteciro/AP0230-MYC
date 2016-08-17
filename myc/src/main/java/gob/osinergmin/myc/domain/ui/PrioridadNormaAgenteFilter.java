/**
* Resumen           
* Objeto            : PrioridadNormaAgenteFilter.java
* Descripción       : Filtro Prioridad Norma Agente
* Fecha de Creación : 28/06/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Erick Ortiz Gil.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
package gob.osinergmin.myc.domain.ui;
import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

/**
 *
 * @author eortiz
 */
public class PrioridadNormaAgenteFilter extends BasePaginatorFilter{
    private Long idActividad;
    private Long idAgente;
    private Long idBaseLegal;
    private Long idPrioridadNormaAgente;
    private Long orden;
    private String estado;
    private String codigosOrden;
    private String codigosPrioridadNormaAgente;
    private boolean flagNotInIdPrioridadNormaAgente;
    
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public Long getIdAgente() {
		return idAgente;
	}
	public void setIdAgente(Long idAgente) {
		this.idAgente = idAgente;
	}
	public Long getIdPrioridadNormaAgente() {
		return idPrioridadNormaAgente;
	}
	public void setIdPrioridadNormaAgente(Long idPrioridadNormaAgente) {
		this.idPrioridadNormaAgente = idPrioridadNormaAgente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdBaseLegal() {
		return idBaseLegal;
	}
	public void setIdBaseLegal(Long idBaseLegal) {
		this.idBaseLegal = idBaseLegal;
	}
	public Long getOrden() {
		return orden;
	}
	public void setOrden(Long orden) {
		this.orden = orden;
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
	public boolean isFlagNotInIdPrioridadNormaAgente() {
		return flagNotInIdPrioridadNormaAgente;
	}
	public void setFlagNotInIdPrioridadNormaAgente(
			boolean flagNotInIdPrioridadNormaAgente) {
		this.flagNotInIdPrioridadNormaAgente = flagNotInIdPrioridadNormaAgente;
	}
}