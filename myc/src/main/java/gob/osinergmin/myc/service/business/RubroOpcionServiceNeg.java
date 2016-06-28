/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;
import gob.osinergmin.myc.domain.in.GuardarRubroOpcionInRO;
import gob.osinergmin.myc.domain.out.GuardarRubroOpcionOutRO;
import gob.osinergmin.myc.domain.ui.OpcionFilter;
import gob.osinergmin.myc.domain.ui.RubroOpcionFilter;
import gob.osinergmin.myc.service.exception.RubroOpcionException;
import gob.osinergmin.myc.service.exception.TramiteActividadException;

import java.util.List;

/**
 *
 * @author jsifuentes
 */
public interface RubroOpcionServiceNeg {
    public List<OpcionDTO> listarOpciones(OpcionFilter filtro, int[] cuenta);
    GuardarRubroOpcionOutRO guardarRubroOpcion(GuardarRubroOpcionInRO in) throws RubroOpcionException;
    List<RubroOpcionDTO> listarRubroOpcion(RubroOpcionFilter filtro, int[] cuenta);
	GuardarRubroOpcionOutRO editarRubroOpcion(GuardarRubroOpcionInRO in) throws RubroOpcionException;
	GuardarRubroOpcionOutRO eliminarRubroOpcion(GuardarRubroOpcionInRO in);

}
