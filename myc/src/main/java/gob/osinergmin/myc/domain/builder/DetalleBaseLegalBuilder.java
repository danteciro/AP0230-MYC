package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghBaseLegal;
import gob.osinergmin.myc.domain.PghDetalleBaseLegal;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.DetalleBaseLegalDTO;

import java.util.ArrayList;
import java.util.List;

public class DetalleBaseLegalBuilder {
	
	public static PghDetalleBaseLegal getDetalleBaseLegal(BaseLegalDTO registroDTO){
            PghDetalleBaseLegal registro=null;
            if(registroDTO!=null){
		registro =new PghDetalleBaseLegal();
		registro.setIdDetalleBaseLegal(registroDTO.getIdDetalleBaseLegal());
		registro.setIdNivelArticulo(registroDTO.getIdNivelArtirculo());
		registro.setArticulo(registroDTO.getArticuloNormaLegal());
		registro.setInciso1(registroDTO.getIncisoUnoNormaLegal());
		registro.setInciso2(registroDTO.getIncisoDosNormaLegal());
//		if(registroDTO.getTipoAnexo()!=-1 && registroDTO.getTipoAnexo()!=null){
                registro.setIdTipoAnexo(registroDTO.getTipoAnexo());
//		}
		registro.setArticuloAnexo(registroDTO.getArticuloAnexo());
		registro.setInciso1Anexo(registroDTO.getIncisoUnoAnexo());
		registro.setInciso2Anexo(registroDTO.getIncisoDosAnexo());
//		if(registroDTO.getTipoNormaTecnica()!=-1 && registroDTO.getTipoNormaTecnica()!=null){
                registro.setIdTipoNormaTecnica(registroDTO.getTipoNormaTecnica());
//		}
		registro.setNormaTecnica(registroDTO.getDescripcionNormaTecnica());
		registro.setFechaEntradaVigencia(registroDTO.getFechaEntradaVigenciaNorma());
		registro.setFechaPublicacion(registroDTO.getFechaPublicacionNorma());
		registro.setModificatorias(registroDTO.getModificatoria());
		registro.setConcordancias(registroDTO.getConcordancia());
		registro.setDescripcion(registroDTO.getDescripcionGeneralBaseLegal());
		registro.setEstado(registroDTO.getEstado());
		/*Rsis 1 - Inicio*/
		registro.setNumeroAnexo(registroDTO.getNumeroAnexo());
		/*Rsis 1 - Fin*/
		PghBaseLegal idBaseLegal = new PghBaseLegal();
		idBaseLegal.setIdBaseLegal(registroDTO.getIdBaseLegal());
		registro.setIdBaseLegal(idBaseLegal);
		
                if(registroDTO.getCodTrazabilidad()!=null){
                    registro.setCodTrazabilidad(registroDTO.getCodTrazabilidad());
                }
                
                
            }
            return registro;
	}
	
	public static List<BaseLegalDTO> toListDetalleBaseLegalDto(List<PghDetalleBaseLegal> lista){
		BaseLegalDTO registroDTO;
		List<BaseLegalDTO> retorno = new ArrayList<BaseLegalDTO>();
		if(lista!=null){
			for(PghDetalleBaseLegal maestro:lista){
				registroDTO=toDetalleBaseLegalDto(maestro);
				retorno.add(registroDTO);
			}
		}
		return retorno;
	}
	
	public static BaseLegalDTO toDetalleBaseLegalDto(PghDetalleBaseLegal registro){
		BaseLegalDTO registroDTO=new BaseLegalDTO();
		if(registro!=null){
			registroDTO.setIdDetalleBaseLegal(registro.getIdDetalleBaseLegal());
			registroDTO.setIdNivelArtirculo(registro.getIdNivelArticulo());
			registroDTO.setArticuloNormaLegal(registro.getArticulo());
			registroDTO.setIncisoUnoNormaLegal(registro.getInciso1());
			registroDTO.setIncisoDosNormaLegal(registro.getInciso2());
			registroDTO.setTipoAnexo(registro.getIdTipoAnexo());
			registroDTO.setArticuloAnexo(registro.getArticuloAnexo());
			registroDTO.setIncisoUnoAnexo(registro.getInciso1Anexo());
			registroDTO.setIncisoDosAnexo(registro.getInciso2Anexo());
			registroDTO.setTipoNormaTecnica(registro.getIdTipoNormaTecnica());
			registroDTO.setDescripcionNormaTecnica(registro.getNormaTecnica());
			registroDTO.setFechaEntradaVigenciaNorma(registro.getFechaEntradaVigencia());
			registroDTO.setFechaPublicacionNorma(registro.getFechaPublicacion());
			registroDTO.setModificatoria(registro.getModificatorias());
			registroDTO.setConcordancia(registro.getConcordancias());
			registroDTO.setDescripcionGeneralBaseLegal(registro.getDescripcion());
			registroDTO.setEstado(registro.getEstado());
			registroDTO.setUsuarioCreacion(registro.getUsuarioCreacion());
			registroDTO.setTerminalCreacion(registro.getTerminalCreacion());
			registroDTO.setFechaCreacion(registro.getFechaCreacion());
			/*Rsis 1 - Inicio*/
			registroDTO.setNumeroAnexo(registro.getNumeroAnexo());
			/*Rsis 1 - Fin*/
		}
		return registroDTO;
	}
	
	public static DetalleBaseLegalDTO toDetalleBaseLegalRefDto(PghDetalleBaseLegal registro){
		DetalleBaseLegalDTO registroDTO=new DetalleBaseLegalDTO();
		if(registro!=null){
			registroDTO.setIdDetalleBaseLegal(registro.getIdDetalleBaseLegal());
			registroDTO.setIdNivelArtirculo(registro.getIdNivelArticulo());
			registroDTO.setArticuloNormaLegal(registro.getArticulo());
			registroDTO.setIncisoUnoNormaLegal(registro.getInciso1());
			registroDTO.setIncisoDosNormaLegal(registro.getInciso2());
			registroDTO.setTipoAnexo(registro.getIdTipoAnexo());
			registroDTO.setArticuloAnexo(registro.getArticuloAnexo());
			registroDTO.setIncisoUnoAnexo(registro.getInciso1Anexo());
			registroDTO.setIncisoDosAnexo(registro.getInciso2Anexo());
			registroDTO.setTipoNormaTecnica(registro.getIdTipoNormaTecnica());
			registroDTO.setDescripcionNormaTecnica(registro.getNormaTecnica());
			registroDTO.setFechaEntradaVigenciaNorma(registro.getFechaEntradaVigencia());
			registroDTO.setFechaPublicacionNorma(registro.getFechaPublicacion());
			registroDTO.setModificatoria(registro.getModificatorias());
			registroDTO.setConcordancia(registro.getConcordancias());
			registroDTO.setDescripcionGeneralBaseLegal(registro.getDescripcion());
			registroDTO.setEstado(registro.getEstado());
			registroDTO.setUsuarioCreacion(registro.getUsuarioCreacion());
			registroDTO.setTerminalCreacion(registro.getTerminalCreacion());
			registroDTO.setFechaCreacion(registro.getFechaCreacion());
			/*Rsis 1 - Inicio*/
			registroDTO.setNumeroAnexo(registro.getNumeroAnexo());
			/*Rsis 1 - Fin*/						
		}
		return registroDTO;
	}

}
