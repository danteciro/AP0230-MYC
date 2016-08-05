package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.in.GuardarObligacionTipoInRO;
import gob.osinergmin.myc.domain.out.GuardarObligacionTipoOutRO;
import gob.osinergmin.myc.domain.ui.ObligacionTipoFilter;
import gob.osinergmin.myc.service.exception.ObligacionTipoException;

import java.util.List;

public interface ObligacionTipoServiceNeg {
	List<ObligacionTipoDTO> listarObligacionTipo(ObligacionTipoFilter filtro,int[] cuenta);
	GuardarObligacionTipoOutRO guardarObligacionTipo(GuardarObligacionTipoInRO in) throws ObligacionTipoException;
	GuardarObligacionTipoOutRO editarObligacionTipo(GuardarObligacionTipoInRO in) throws ObligacionTipoException;
	GuardarObligacionTipoOutRO eliminarObligacionTipo(GuardarObligacionTipoInRO in) throws ObligacionTipoException;
	List<ObligacionTipoDTO> listarObligacion();
	List<ObligacionTipoDTO> listarObligacionTipoConf();
	List<ObligacionTipoDTO> listaObligacionTipoSelecccionMuestral(String identificador);/*OSINE_SFS-480 - RSIS25*/
 }
