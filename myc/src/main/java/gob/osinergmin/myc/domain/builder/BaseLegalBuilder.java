
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiDocumentoAdjunto;
import gob.osinergmin.myc.domain.PghBaseLegal;
import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;

import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;

/**
 *
 * @author gvillanueva
 */
public class BaseLegalBuilder {
    
    public static PghBaseLegal getBaseLegal(BaseLegalDTO baseLegalDTO) {
    	PghBaseLegal registro = null;
        if(baseLegalDTO!=null){
            registro=new PghBaseLegal();
            registro.setIdBaseLegal(baseLegalDTO.getIdBaseLegal());
            registro.setCodigoBaseLegal(baseLegalDTO.getCodigoBaseLegal());
            registro.setDescripcion(baseLegalDTO.getDescripcionGeneralBaseLegal());
            if(baseLegalDTO.getTipoNormaLegal()!=-1){
            	registro.setIdTipoNormaLegal(baseLegalDTO.getTipoNormaLegal());
            }
            registro.setNumero(baseLegalDTO.getNumeroNormaLegal());
            registro.setAnio(baseLegalDTO.getAnioNormaLegal());
            if(baseLegalDTO.getSiglaNormaLegal()!=-1){
            	registro.setIdSigla(baseLegalDTO.getSiglaNormaLegal());
            }
            registro.setFechaPublicacion(baseLegalDTO.getFechaPublicacionNormaLegal());
            registro.setFechaEntradaVigencia(baseLegalDTO.getFechaEntradaVigenciaNormaLegal());
            registro.setTitulo(baseLegalDTO.getTituloNormaLegal());
            registro.setEstado(baseLegalDTO.getEstado());
            registro.setIdBaseLegalRef(baseLegalDTO.getIdBaseLegalRef());
            registro.setFechaTerminoVigencia(baseLegalDTO.getFechaTerminoVigenciaNormaLegal());
            if(baseLegalDTO.getIdDocumentoAdjunto()!=null){
                registro.setIdDocumentoAdjunto(new MdiDocumentoAdjunto(baseLegalDTO.getIdDocumentoAdjunto()));
            }
            if(baseLegalDTO.getCodTrazabilidad()!=null){
                registro.setCodTrazabilidad(baseLegalDTO.getCodTrazabilidad());
            }
            if(baseLegalDTO.getFlagPadre()!=null){
            	registro.setFlagPadre(baseLegalDTO.getFlagPadre());
            }
            if(baseLegalDTO.getIdBaseLegalPadre()!=null){
            	registro.setIdBaseLegalPadre(baseLegalDTO.getIdBaseLegalPadre());
            }
        }
        return registro;

    }
    
    public static List<BaseLegalDTO> toListBaseLegalDto(List<PghBaseLegal> lista) {
    	BaseLegalDTO baseLegalDTO;
        List<BaseLegalDTO> retorno = new ArrayList<BaseLegalDTO>();
        if (lista != null) {
        	Log.info("entro222-->");
            for (PghBaseLegal maestro : lista) {
            	baseLegalDTO = toBaseLegalDto(maestro);
                retorno.add(baseLegalDTO);
            }
        }
        return retorno;
        /*llenar listado aca*/
    }
    
    public static BaseLegalDTO toBaseLegalDto(PghBaseLegal baseLegal) {
    	BaseLegalDTO baseLegalDTO = new BaseLegalDTO();
        
    	baseLegalDTO.setIdBaseLegal(baseLegal.getIdBaseLegal());
    	baseLegalDTO.setCodigoBaseLegal(baseLegal.getCodigoBaseLegal());
    	baseLegalDTO.setDescripcionGeneralBaseLegal(baseLegal.getDescripcion());
    	baseLegalDTO.setTipoNormaLegal(baseLegal.getIdTipoNormaLegal());
    	baseLegalDTO.setNumeroNormaLegal(baseLegal.getNumero());
    	baseLegalDTO.setAnioNormaLegal(baseLegal.getAnio());
    	baseLegalDTO.setSiglaNormaLegal(baseLegal.getIdSigla());
    	baseLegalDTO.setTituloNormaLegal(baseLegal.getTitulo());
    	baseLegalDTO.setFechaPublicacionNormaLegal(baseLegal.getFechaPublicacion());
    	baseLegalDTO.setFechaEntradaVigenciaNormaLegal(baseLegal.getFechaEntradaVigencia());
    	baseLegalDTO.setEstado(baseLegal.getEstado());
    	baseLegalDTO.setFechaTerminoVigenciaNormaLegal(baseLegal.getFechaTerminoVigencia());
    	baseLegalDTO.setIdBaseLegalRef(baseLegal.getIdBaseLegalRef());
        if(baseLegal.getIdDocumentoAdjunto()!=null){
            baseLegalDTO.setIdDocumentoAdjunto(baseLegal.getIdDocumentoAdjunto().getIdDocumentoAdjunto());
            baseLegalDTO.setNombreArchivo(baseLegal.getIdDocumentoAdjunto().getNombreArchivo());
            baseLegalDTO.setRutaAlfresco(baseLegal.getIdDocumentoAdjunto().getRutaAlfresco());
        }
        if(baseLegal.getFlagPadre()!=null){
        	baseLegalDTO.setFlagPadre(baseLegal.getFlagPadre());
        }
        if(baseLegal.getIdBaseLegalPadre()!=null){
        	baseLegalDTO.setIdBaseLegalPadre(baseLegal.getIdBaseLegalPadre());
        }

        if(baseLegal.getTieneAct()!=null){
        	baseLegalDTO.setTieneAct(baseLegal.getTieneAct());
        }
// 05-11-2015
        if(baseLegal.getCodTrazabilidad()!=null){
        	baseLegalDTO.setCodTrazabilidad(baseLegal.getCodTrazabilidad());
        }  
//       
        return baseLegalDTO;
    }

// 05-11-2015
    public static BaseLegalDTO toBaseLegalRetornoDto(PghBaseLegal baseLegal,Long idDetalleBaseLegalRetorno,String codTrazabilidadRetorno) {
		BaseLegalDTO baseLegalDTO = new BaseLegalDTO();
        
    	baseLegalDTO.setIdBaseLegal(baseLegal.getIdBaseLegal());
    	baseLegalDTO.setCodigoBaseLegal(baseLegal.getCodigoBaseLegal());
    	baseLegalDTO.setDescripcionGeneralBaseLegal(baseLegal.getDescripcion());
    	baseLegalDTO.setTipoNormaLegal(baseLegal.getIdTipoNormaLegal());
    	baseLegalDTO.setNumeroNormaLegal(baseLegal.getNumero());
    	baseLegalDTO.setAnioNormaLegal(baseLegal.getAnio());
    	baseLegalDTO.setSiglaNormaLegal(baseLegal.getIdSigla());
    	baseLegalDTO.setTituloNormaLegal(baseLegal.getTitulo());
    	baseLegalDTO.setFechaPublicacionNormaLegal(baseLegal.getFechaPublicacion());
    	baseLegalDTO.setFechaEntradaVigenciaNormaLegal(baseLegal.getFechaEntradaVigencia());
    	baseLegalDTO.setEstado(baseLegal.getEstado());
    	baseLegalDTO.setFechaTerminoVigenciaNormaLegal(baseLegal.getFechaTerminoVigencia());
    	baseLegalDTO.setIdBaseLegalRef(baseLegal.getIdBaseLegalRef());
        if(baseLegal.getIdDocumentoAdjunto()!=null){
            baseLegalDTO.setIdDocumentoAdjunto(baseLegal.getIdDocumentoAdjunto().getIdDocumentoAdjunto());
            baseLegalDTO.setNombreArchivo(baseLegal.getIdDocumentoAdjunto().getNombreArchivo());
            baseLegalDTO.setRutaAlfresco(baseLegal.getIdDocumentoAdjunto().getRutaAlfresco());
        }
        if(baseLegal.getFlagPadre()!=null){
        	baseLegalDTO.setFlagPadre(baseLegal.getFlagPadre());
        }
        if(baseLegal.getIdBaseLegalPadre()!=null){
        	baseLegalDTO.setIdBaseLegalPadre(baseLegal.getIdBaseLegalPadre());
        }

        if(baseLegal.getTieneAct()!=null){
        	baseLegalDTO.setTieneAct(baseLegal.getTieneAct());
        }
        baseLegalDTO.setIdDetalleBaseLegal(idDetalleBaseLegalRetorno);
        if(codTrazabilidadRetorno!=null){
        	baseLegalDTO.setCodTrazabilidad(codTrazabilidadRetorno);
        }
        return baseLegalDTO;
	}
//    

	public static List<BaseLegalDTO> toListBaseLegalHijoDto(List<Object[]> resultados) {
		BaseLegalDTO baseLegalDTO;
        List<BaseLegalDTO> retorno = new ArrayList<BaseLegalDTO>();
        if (resultados != null) {
        	Log.info("entro222-->");
        	int cont=0;
            for (Object[] maestro : resultados) {
            	baseLegalDTO = new BaseLegalDTO();
            	baseLegalDTO.setIdBaseLegal(new Long(maestro[0].toString()));
            	baseLegalDTO.setCodigoBaseLegal(maestro[1].toString());
            	baseLegalDTO.setDescripcionGeneralBaseLegal(maestro[2].toString());
            	baseLegalDTO.setEstado(maestro[3].toString());
            	if(maestro[4]!=null){
            		baseLegalDTO.setFlagPadre(maestro[4].toString());
            	}
            	cont++;
            	baseLegalDTO.setCorrelativo(new Long(cont));
            	
                retorno.add(baseLegalDTO);
            }
        }
        return retorno;
        /*llenar listado aca*/
	}
    // 06-11-2015
	public static List<BaseLegalDTO> toListBaseLegalToBaseLegalDto(List<PghBaseLegal> lista) {
    	BaseLegalDTO baseLegalDTO;
        List<BaseLegalDTO> retorno = new ArrayList<BaseLegalDTO>();
        if (lista != null) {
        	Log.info("Ingreso-->");
            for (PghBaseLegal maestro : lista) {
            	baseLegalDTO = toBaseLegalToBaseLegalDto(maestro);
                retorno.add(baseLegalDTO);
            }
        }
        return retorno;
        /*llenar_listado_aca*/
    }
	//
    // 06-11-2015
	private static BaseLegalDTO toBaseLegalToBaseLegalDto(PghBaseLegal baseLegal) {
	BaseLegalDTO baseLegalDTO = new BaseLegalDTO();
    	baseLegalDTO.setIdBaseLegal(baseLegal.getIdBaseLegal());
		baseLegalDTO.setCodigoBaseLegal(baseLegal.getCodigoBaseLegal());
		baseLegalDTO.setDescripcionGeneralBaseLegal(baseLegal.getDescripcion());
		baseLegalDTO.setTipoNormaLegal(baseLegal.getIdTipoNormaLegal());
		baseLegalDTO.setNumeroNormaLegal(baseLegal.getNumero());
		baseLegalDTO.setAnioNormaLegal(baseLegal.getAnio());
		baseLegalDTO.setSiglaNormaLegal(baseLegal.getIdSigla());
		baseLegalDTO.setTituloNormaLegal(baseLegal.getTitulo());
		baseLegalDTO.setFechaPublicacionNormaLegal(baseLegal.getFechaPublicacion());
		baseLegalDTO.setFechaEntradaVigenciaNormaLegal(baseLegal.getFechaEntradaVigencia());
		baseLegalDTO.setEstado(baseLegal.getEstado());
		baseLegalDTO.setFechaTerminoVigenciaNormaLegal(baseLegal.getFechaTerminoVigencia());
		baseLegalDTO.setIdBaseLegalRef(baseLegal.getIdBaseLegalRef());
	    if(baseLegal.getIdDocumentoAdjunto()!=null){
	        baseLegalDTO.setIdDocumentoAdjunto(baseLegal.getIdDocumentoAdjunto().getIdDocumentoAdjunto());
	        baseLegalDTO.setNombreArchivo(baseLegal.getIdDocumentoAdjunto().getNombreArchivo());
	        baseLegalDTO.setRutaAlfresco(baseLegal.getIdDocumentoAdjunto().getRutaAlfresco());
	    }
	    if(baseLegal.getFlagPadre()!=null){
	    	baseLegalDTO.setFlagPadre(baseLegal.getFlagPadre());
	    }
	    if(baseLegal.getIdBaseLegalPadre()!=null){
	    	baseLegalDTO.setIdBaseLegalPadre(baseLegal.getIdBaseLegalPadre());
	    }
	
	    if(baseLegal.getTieneAct()!=null){
	    	baseLegalDTO.setTieneAct(baseLegal.getTieneAct());
	    }
	//05-11-2015
	    if(baseLegal.getCodTrazabilidad()!=null){
	    	baseLegalDTO.setCodTrazabilidad(baseLegal.getCodTrazabilidad());
	    }  
	//   
	    return baseLegalDTO;
	}
	//

	public static List<BaseLegalDTO> toListObligacionBaseLegalDto(List<PghObligacion> resultList) {
		BaseLegalDTO baseLegalDTO;
        List<BaseLegalDTO> retorno = new ArrayList<BaseLegalDTO>();
        if (resultList != null) {
        	Log.info("entro222-->");
            for (PghObligacion maestro : resultList) {
            	baseLegalDTO = toObligacionBaseLegalDto(maestro);
                retorno.add(baseLegalDTO);
            }
        }
        return retorno;
	}

	private static BaseLegalDTO toObligacionBaseLegalDto(PghObligacion maestro) {
		BaseLegalDTO baseLegalDTO = new BaseLegalDTO();
        if(maestro.getIdObligacion()!=null){
        	baseLegalDTO.setIdObligacion(maestro.getIdObligacion());
        }
    	if(maestro.getCodigoObligacion()!=null){
    		baseLegalDTO.setCodigoObligacion(maestro.getCodigoObligacion());	
    	}
    	if(maestro.getDescripcion()!=null){
    		baseLegalDTO.setDescripcionObligacion(maestro.getDescripcion());
    	}
    	if(maestro.getEstado()!=null){
    		baseLegalDTO.setEstadoObligacion(maestro.getEstado());
    	}
    	if(maestro.getTieneAct()!=null){
    		baseLegalDTO.setTieneAct(new Long(maestro.getTieneAct()));
    	}
    	
//       
        return baseLegalDTO;
	}

	public static List<BaseLegalDTO> toListBaseLegalByObligacionDto(List<Object[]> resultados) {
		BaseLegalDTO baseLegalDTO;
        List<BaseLegalDTO> retorno = new ArrayList<BaseLegalDTO>();
        if (resultados != null) {
        	Log.info("entro222-->");
        	int cont=0;
            for (Object[] maestro : resultados) {
            	baseLegalDTO = new BaseLegalDTO();
            	baseLegalDTO.setIdBaseLegal(new Long(maestro[0].toString()));
            	baseLegalDTO.setCodigoBaseLegal(maestro[1].toString());
            	baseLegalDTO.setDescripcionGeneralBaseLegal(maestro[2].toString());
            	baseLegalDTO.setEstado(maestro[3].toString());
            	if(maestro[4]!=null){
            		baseLegalDTO.setFlagPadre(maestro[4].toString());
            	}
            	cont++;
            	baseLegalDTO.setCorrelativo(new Long(cont));
                retorno.add(baseLegalDTO);
            }
        }
        return retorno;
	}
}
