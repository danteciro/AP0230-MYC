package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.MdiUnidadOrganica;
import gob.osinergmin.myc.domain.PghModulo;
import gob.osinergmin.myc.domain.PghOrgaActiModuSecc;
import gob.osinergmin.myc.domain.PghSeccion;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ModuloDTO;
import gob.osinergmin.myc.domain.dto.OrgaActiModuSeccDTO;
import gob.osinergmin.myc.domain.dto.SeccionDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;

import java.util.ArrayList;
import java.util.List;

public class OrgaActiModuSeccBuilder {

	public static List<OrgaActiModuSeccDTO> toListOrgaActiModuSeccDto(List<Object[]> listado) {
		OrgaActiModuSeccDTO registroDTO;
        List<OrgaActiModuSeccDTO> retorno = new ArrayList<OrgaActiModuSeccDTO>();
        if (listado != null) {
            for (Object[] maestro : listado) {
                registroDTO = toOrgaActiModuSeccDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
	}

	public static OrgaActiModuSeccDTO toOrgaActiModuSeccDto(Object[] maestro) {
		OrgaActiModuSeccDTO orgaActiModuSeccDTO = new OrgaActiModuSeccDTO();
		
		if(maestro[0]!=null){
			orgaActiModuSeccDTO.setIdOrgaActiModuSecc(new Long(maestro[0].toString()));
		}
		
		if(maestro[1]!=null && maestro[2]!=null){
			UnidadOrganicaDTO idUnidadOrganicaSuperior=new UnidadOrganicaDTO();
			idUnidadOrganicaSuperior.setIdUnidadOrganica(new Long(maestro[1].toString()));
			idUnidadOrganicaSuperior.setDescripcion(maestro[2].toString());
			orgaActiModuSeccDTO.setIdUnidadOrganicaSuperior(idUnidadOrganicaSuperior);
		}
		
		if(maestro[3]!=null && maestro[4]!=null){
			UnidadOrganicaDTO idUnidadOrganica=new UnidadOrganicaDTO();
			idUnidadOrganica.setIdUnidadOrganica(new Long(maestro[3].toString()));
			idUnidadOrganica.setDescripcion(maestro[4].toString());
			orgaActiModuSeccDTO.setIdUnidadOrganica(idUnidadOrganica);
		}		
		
		if(maestro[5]!=null && maestro[6]!=null){
			ActividadDTO idActividad = new ActividadDTO();
			idActividad.setIdActividad(new Long(maestro[5].toString()));
			idActividad.setDescripcionActividad(maestro[6].toString());
			orgaActiModuSeccDTO.setIdActividad(idActividad);
		}
		
		if(maestro[7]!=null){
			orgaActiModuSeccDTO.setOrdenComponente(new Long(maestro[7].toString()));
		}
		
		if(maestro[8]!=null && maestro[9]!=null){
			ModuloDTO idModulo = new ModuloDTO();
			idModulo.setIdModulo(new Long(maestro[8].toString()));
			idModulo.setDescripcion(maestro[9].toString());
			orgaActiModuSeccDTO.setIdModulo(idModulo);
		}
		
		if(maestro[10]!=null){
			orgaActiModuSeccDTO.setOrdenSeccion(new Long(maestro[10].toString()));
		}
		
		if(maestro[11]!=null && maestro[12]!=null){
			SeccionDTO idSeccion = new SeccionDTO();
			idSeccion.setIdSeccion(new Long(maestro[11].toString()));
			idSeccion.setDescripcion(maestro[12].toString());
			orgaActiModuSeccDTO.setIdSeccion(idSeccion);
		}
		
		return orgaActiModuSeccDTO;
	}

	public static OrgaActiModuSeccDTO toOrgaActiModuSeccDto(PghOrgaActiModuSecc configuracion) {
		OrgaActiModuSeccDTO orgaActiModuSeccDTO = new OrgaActiModuSeccDTO();
		
		if(configuracion.getIdOrgaActiModuSecc()!=null){
			orgaActiModuSeccDTO.setIdOrgaActiModuSecc(configuracion.getIdOrgaActiModuSecc());
		}	
		
		if(configuracion.getIdUnidadOrganica()!=null && configuracion.getIdUnidadOrganica().getIdUnidadOrganica()!=null){	
			UnidadOrganicaDTO idUnidadOrganica=new UnidadOrganicaDTO();
			idUnidadOrganica.setIdUnidadOrganica(configuracion.getIdUnidadOrganica().getIdUnidadOrganica());
			idUnidadOrganica.setDescripcion(configuracion.getIdUnidadOrganica().getDescripcion());
			orgaActiModuSeccDTO.setIdUnidadOrganica(idUnidadOrganica);
		}		

		if(configuracion.getIdActividad()!=null && configuracion.getIdActividad().getIdActividad()!=null){
			ActividadDTO idActividad = new ActividadDTO();
			idActividad.setIdActividad(configuracion.getIdActividad().getIdActividad());
			idActividad.setDescripcionActividad(configuracion.getIdActividad().getNombre());
			orgaActiModuSeccDTO.setIdActividad(idActividad);
		}
		
		if(configuracion.getOrdenComponente()!=null){
			orgaActiModuSeccDTO.setOrdenComponente(configuracion.getOrdenComponente());
		}
		
		if(configuracion.getIdModulo()!=null && configuracion.getIdModulo().getIdModulo()!=null){
			ModuloDTO idModulo = new ModuloDTO();
			idModulo.setIdModulo(configuracion.getIdModulo().getIdModulo());
			idModulo.setDescripcion(configuracion.getIdModulo().getDescripcion());
			orgaActiModuSeccDTO.setIdModulo(idModulo);
		}
		
		if(configuracion.getOrdenSeccion()!=null && configuracion.getOrdenSeccion()!=null){
			orgaActiModuSeccDTO.setOrdenSeccion(configuracion.getOrdenSeccion());
		}
		
		if(configuracion.getIdSeccion()!=null && configuracion.getIdSeccion().getIdSeccion()!=null){
			SeccionDTO idSeccion = new SeccionDTO();
			idSeccion.setIdSeccion(configuracion.getIdSeccion().getIdSeccion());
			idSeccion.setDescripcion(configuracion.getIdSeccion().getDescripcion());
			orgaActiModuSeccDTO.setIdSeccion(idSeccion);
		}
		if(configuracion.getEstado()!=null){
			orgaActiModuSeccDTO.setEstado(configuracion.getEstado());
		}
		
		return orgaActiModuSeccDTO;
	}

	public static PghOrgaActiModuSecc getOrgaActiModuSecc(OrgaActiModuSeccDTO configuracion) {
		PghOrgaActiModuSecc orgaActiModuSeccDTO= new PghOrgaActiModuSecc();
		
		if(configuracion.getIdOrgaActiModuSecc()!=null){
			orgaActiModuSeccDTO.setIdOrgaActiModuSecc(configuracion.getIdOrgaActiModuSecc());
		}	
		
		if(configuracion.getIdUnidadOrganica()!=null && configuracion.getIdUnidadOrganica().getIdUnidadOrganica()!=null){	
			MdiUnidadOrganica idUnidadOrganica=new MdiUnidadOrganica();
			idUnidadOrganica.setIdUnidadOrganica(configuracion.getIdUnidadOrganica().getIdUnidadOrganica());
			idUnidadOrganica.setDescripcion(configuracion.getIdUnidadOrganica().getDescripcion());
			orgaActiModuSeccDTO.setIdUnidadOrganica(idUnidadOrganica);
		}		

		if(configuracion.getIdActividad()!=null && configuracion.getIdActividad().getIdActividad()!=null){
			MdiActividad idActividad = new MdiActividad();
			idActividad.setIdActividad(configuracion.getIdActividad().getIdActividad());
			idActividad.setNombre(configuracion.getIdActividad().getNombre());
			orgaActiModuSeccDTO.setIdActividad(idActividad);
		}
		
		if(configuracion.getOrdenComponente()!=null){
			orgaActiModuSeccDTO.setOrdenComponente(configuracion.getOrdenComponente());
		}
		
		if(configuracion.getIdModulo()!=null && configuracion.getIdModulo().getIdModulo()!=null){
			PghModulo idModulo = new PghModulo();
			idModulo.setIdModulo(configuracion.getIdModulo().getIdModulo());
			idModulo.setDescripcion(configuracion.getIdModulo().getDescripcion());
			orgaActiModuSeccDTO.setIdModulo(idModulo);
		}
		
		if(configuracion.getOrdenSeccion()!=null && configuracion.getOrdenSeccion()!=null){
			orgaActiModuSeccDTO.setOrdenSeccion(configuracion.getOrdenSeccion());
		}
		
		if(configuracion.getIdSeccion()!=null && configuracion.getIdSeccion().getIdSeccion()!=null){
			PghSeccion idSeccion = new PghSeccion();
			idSeccion.setIdSeccion(configuracion.getIdSeccion().getIdSeccion());
			idSeccion.setDescripcion(configuracion.getIdSeccion().getDescripcion());
			orgaActiModuSeccDTO.setIdSeccion(idSeccion);
		}
		if(configuracion.getEstado()!=null){
			orgaActiModuSeccDTO.setEstado(configuracion.getEstado());
		}
		
		return orgaActiModuSeccDTO;
	}

}
