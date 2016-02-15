package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.in.GuardarProcesoObligacionTipoInRO;
import gob.osinergmin.myc.domain.out.GuardarProcesoObligacionTipoOutRO;
import gob.osinergmin.myc.domain.ui.ProcesoObligacionTipoFilter;
import gob.osinergmin.myc.service.exception.ProcesoObligacionTipoException;

import java.util.List;

public interface ProcesoObligacionTipoServiceNeg {

    List<ProcesoObligacionTipoDTO> listarProcesoObligacionTipo(ProcesoObligacionTipoFilter filtro, int[] cuenta);
    GuardarProcesoObligacionTipoOutRO guardarProcesoObligacionTipo(GuardarProcesoObligacionTipoInRO in)throws ProcesoObligacionTipoException;
    GuardarProcesoObligacionTipoOutRO editarProcesoObligacionTipo(GuardarProcesoObligacionTipoInRO in)throws ProcesoObligacionTipoException;
    GuardarProcesoObligacionTipoOutRO eliminarProcesoObligacionTipo(GuardarProcesoObligacionTipoInRO in)throws ProcesoObligacionTipoException;

}
