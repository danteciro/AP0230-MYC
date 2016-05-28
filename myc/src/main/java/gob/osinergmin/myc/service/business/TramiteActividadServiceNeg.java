package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.in.GuardarTramiteActividadInRO;
import gob.osinergmin.myc.domain.out.GuardarTramiteActividadOutRO;
import gob.osinergmin.myc.domain.ui.TramiteActividadFilter;
import gob.osinergmin.myc.service.exception.TramiteActividadException;

import java.util.List;

public interface TramiteActividadServiceNeg {

	List<TramiteActividadDTO> listarTramiteActividad(TramiteActividadFilter filtro,
			int[] cuenta);
	
	TramiteActividadDTO buscarTramiteActividadByFiltro(
			TramiteActividadFilter filtro);

	GuardarTramiteActividadOutRO guardarTramiteActividad(
			GuardarTramiteActividadInRO in) throws TramiteActividadException;

	GuardarTramiteActividadOutRO editarTramiteActividad(
			GuardarTramiteActividadInRO in) throws TramiteActividadException;

	GuardarTramiteActividadOutRO eliminarTramiteActividad(
			GuardarTramiteActividadInRO in);

}
