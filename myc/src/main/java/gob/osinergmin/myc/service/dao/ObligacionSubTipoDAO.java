package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ObligacionSubTipoDTO;
import gob.osinergmin.myc.domain.ui.ObligacionSubTipoFilter;

import java.util.List;

public interface ObligacionSubTipoDAO {

	List<ObligacionSubTipoDTO> listaObligacionSubTipo(ObligacionSubTipoFilter filtro);
	
}
