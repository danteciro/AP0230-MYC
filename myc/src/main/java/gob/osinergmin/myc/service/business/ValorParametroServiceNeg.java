package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import gob.osinergmin.myc.domain.dto.ValorParametroDTO;
import gob.osinergmin.myc.domain.in.GuardarValorParametroInRO;
import gob.osinergmin.myc.domain.out.GuardarValorParametroOutRO;
import gob.osinergmin.myc.domain.ui.ValorParametroFilter;

import java.util.List;

public interface ValorParametroServiceNeg {

	  public List<ValorParametroDTO> listarValorParametro(ValorParametroFilter filtro, int[] cuenta);
	  public GuardarValorParametroOutRO guardarValorParametro(GuardarValorParametroInRO in);
	  public GuardarValorParametroOutRO editarValorParametro(GuardarValorParametroInRO in);
	  public GuardarValorParametroOutRO eliminarValorParametro(GuardarValorParametroInRO in);
	  public List<ValorParametroDTO> obtenerDependencias(ValorParametroFilter filtro);
	List<ValorParametroDTO> verificarOtrosValoresParametros(
			ValorParametroFilter filtro);
}
