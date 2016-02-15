/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.RequisitoDTO;
import gob.osinergmin.myc.domain.in.GuardarRequisitoInRO;
import gob.osinergmin.myc.domain.out.GuardarRequisitoOutRO;
import gob.osinergmin.myc.domain.ui.RequisitoFilter;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jpiro
 */
public interface RequisitoServiceNeg {
    public List<RequisitoDTO> listarRequisito(RequisitoFilter filtro,int[] cuenta);
    public List<RequisitoDTO> verificaRequisitoSimilar(RequisitoFilter filtro);
    public GuardarRequisitoOutRO guardarRequisito(GuardarRequisitoInRO in);
    public GuardarRequisitoOutRO editarRequisito(GuardarRequisitoInRO in);
    public GuardarRequisitoOutRO eliminarRequisito(GuardarRequisitoInRO in);
    public RequisitoDTO buscarRequisitoByFiltro(RequisitoFilter filtro);
	public List<CnfRequProcedimientoDTO> obtenerDependencias(RequisitoFilter filtro);
	List<RequisitoDTO> validarRequisitoIdentico(RequisitoFilter filtro);
}
