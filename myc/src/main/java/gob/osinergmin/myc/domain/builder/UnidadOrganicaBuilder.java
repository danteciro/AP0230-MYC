package gob.osinergmin.myc.domain.builder;
import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.MdiUnidadOrganica;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import java.util.ArrayList;
import java.util.List;
/**
*
* @author mdiosesf
*/
public class UnidadOrganicaBuilder {

	public static List<UnidadOrganicaDTO> toListUnidadOrganicaDto(List<MdiUnidadOrganica> lista) {
		UnidadOrganicaDTO registroDTO;
        List<UnidadOrganicaDTO> retorno = new ArrayList<UnidadOrganicaDTO>();
        if(lista != null && lista.size()>0) {
            for (MdiUnidadOrganica maestro : lista) {
                registroDTO = toUnidadOrganicaDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static UnidadOrganicaDTO toUnidadOrganicaDto(MdiUnidadOrganica registro) {
    	UnidadOrganicaDTO registroDTO = new UnidadOrganicaDTO();        
    	registroDTO.setIdUnidadOrganica(registro.getIdUnidadOrganica());
    	registroDTO.setIdUnidadOrganicaSuperior(registro.getIdUnidadOrganicaSuperior());
    	registroDTO.setDescripcion(registro.getDescripcion());            	
    	registroDTO.setCodDepSiga(registro.getCodDepSiga());
    	registroDTO.setDetalle(registro.getDetalle());
    	registroDTO.setSede(registro.getSede());
    	registroDTO.setSigla(registro.getSigla());
    	registroDTO.setNivel(registro.getNivel());
		registroDTO.setEstado(registro.getEstado());
    	if(registro.getNombreNivel()!=null){
    		registroDTO.setNombreNivel(new MaestroColumnaDTO(registro.getNombreNivel().getIdMaestroColumna(), registro.getNombreNivel().getDescripcion()));
    	}
        return registroDTO;
    }	
    
    public static MdiUnidadOrganica toUnidadOrganicaTabla(UnidadOrganicaDTO registro) {
    	MdiUnidadOrganica mdiUnidadOrganica = new MdiUnidadOrganica();        
    	mdiUnidadOrganica.setIdUnidadOrganica(registro.getIdUnidadOrganica());
    	mdiUnidadOrganica.setIdUnidadOrganicaSuperior(registro.getIdUnidadOrganicaSuperior());
    	mdiUnidadOrganica.setDescripcion(registro.getDescripcion());            	
    	mdiUnidadOrganica.setCodDepSiga(registro.getCodDepSiga());
    	mdiUnidadOrganica.setDetalle(registro.getDetalle());
    	mdiUnidadOrganica.setSede(registro.getSede());
    	mdiUnidadOrganica.setEstado(registro.getEstado());
    	mdiUnidadOrganica.setSigla(registro.getSigla());
    	mdiUnidadOrganica.setNivel(registro.getNivel());
    	if(registro.getNombreNivel()!=null){
    		MdiMaestroColumna maestroNombreNivel=new MdiMaestroColumna();
    		maestroNombreNivel.setIdMaestroColumna(registro.getNombreNivel().getIdMaestroColumna());
    		mdiUnidadOrganica.setNombreNivel(maestroNombreNivel);
    	}
        return mdiUnidadOrganica;
    }	
}
