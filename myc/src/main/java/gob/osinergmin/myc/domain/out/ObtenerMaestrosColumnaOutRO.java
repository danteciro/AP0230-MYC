package gob.osinergmin.myc.domain.out;

import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.base.BaseOutBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de respuesta de web service.
 * @author dmedrano
 * @version 1.0
 */
public class ObtenerMaestrosColumnaOutRO extends BaseOutBean implements Serializable{			
	private static final long serialVersionUID = -6117697084673031018L;
	private List<MaestroColumnaDTO> listaColumnas;
        private MaestroColumnaDTO registro;
	
	public ObtenerMaestrosColumnaOutRO(){
		super();
		listaColumnas = new ArrayList<MaestroColumnaDTO>();
	}

	public List<MaestroColumnaDTO> getListaColumnas() {
		return listaColumnas;
	}

	public void setListaColumnas(List<MaestroColumnaDTO> listaColumnas) {
		this.listaColumnas = listaColumnas;
	}

    public MaestroColumnaDTO getRegistro() {
        return registro;
    }

    public void setRegistro(MaestroColumnaDTO registro) {
        this.registro = registro;
    }
				
}
