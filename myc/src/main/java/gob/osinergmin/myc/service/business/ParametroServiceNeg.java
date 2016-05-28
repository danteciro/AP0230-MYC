/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import gob.osinergmin.myc.domain.in.GuardarParametroDinamicoInRO;
import gob.osinergmin.myc.domain.out.GuardarParametroDinamicoOutRO;
import gob.osinergmin.myc.domain.ui.ParametroFilter;

import java.util.List;

/**
 *
 * @author jpiro
 */
public interface ParametroServiceNeg {
    public List<ParametroDinamicoDTO> listarParametrosValores(ParametroFilter filtro);
    public List<ParametroDinamicoDTO> listarParametro(ParametroFilter filtro, int[] cuenta);
    public GuardarParametroDinamicoOutRO guardarParametroDinamico(GuardarParametroDinamicoInRO in);
    public GuardarParametroDinamicoOutRO eliminarParametroDinamico(GuardarParametroDinamicoInRO in);
    public GuardarParametroDinamicoOutRO editarParametroDinamico(GuardarParametroDinamicoInRO in);
	List<ParametroDinamicoDTO> obtenerDependencias(ParametroFilter filtro);
	List<ParametroDinamicoDTO> obtenerDependenciasValores(ParametroFilter filtro);
	List<ParametroDinamicoDTO> verificarOtrosParametros(ParametroFilter filtro);
	long obtenerIdDinamico();
	
}
