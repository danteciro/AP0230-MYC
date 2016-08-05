/**
* Resumen.
* Objeto                            	:              UnidadSupervisadaServiceNeg.java.
* Descripción                   		:              Interface del Objeto UnidadSupervisadaServiceNegImpl.
* Fecha de Creación     				:              23/05/2016
* Autor                               	:              gvillanueva.
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                                  	Fecha                             Nombre                              Descripción
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                        gvillanueva                   			RSIS25
*/
package gob.osinergmin.myc.service.business;
import java.util.List;
import gob.osinergmin.myc.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.myc.domain.ui.UnidadSupervisadaFilter;
/**
 *
 * @author gvillanueva
 */
public interface UnidadSupervisadaServiceNeg {
	public Long contarUnidadSupervisadaxActividad(UnidadSupervisadaFilter filtro);
	public Long contarUnidadSupervisadaxActividadxEstratoDistrito(UnidadSupervisadaFilter filtro);
	public Long contarUnidadSupervisadaxActividadxEstratoProvincia(UnidadSupervisadaFilter filtro);
	public Long contarUnidadSupervisadaxActividadxEstratoDepartamento(UnidadSupervisadaFilter filtro);
	public List<UnidadSupervisadaDTO> listaUnidadSupervisadaEstratoDepartamento(UnidadSupervisadaFilter filtro);
	public List<UnidadSupervisadaDTO> listaUnidadSupervisadaEstratoDistrito(UnidadSupervisadaFilter filtro);
	public List<UnidadSupervisadaDTO> listaUnidadSupervisadaEstratoProvincia(UnidadSupervisadaFilter filtro);
}