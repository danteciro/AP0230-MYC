/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.common.util;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.BaseLegalConcordanciaDTO;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.CnfObligacionDTO;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.dto.RequProcParaDinaDTO;
import gob.osinergmin.myc.domain.dto.TemaDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.dao.ProcedimientoTramiteDAO;
import gob.osinergmin.myc.service.dao.impl.BaseLegalDAOImpl;
import gob.osinergmin.myc.util.Constantes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
public class MycUtil {
    private static final Logger LOG = LoggerFactory.getLogger(ProcedimientoTramiteDAO.class);
    
    public static String concatenaValorParametroFromRequProcParaDina(List<RequProcParaDinaDTO> requProcParaDinas){
        String retorno="";
        if(requProcParaDinas!=null && requProcParaDinas.size()>0){
            //longitud pa array
            int longi=0;
            for(RequProcParaDinaDTO maestra : requProcParaDinas){
                if(maestra.getValorParametro().getIdValorParametro()!=null){
                    longi++;
                }
            }
            //
            String[] s = new String[longi];
            int cont=0;
            for(RequProcParaDinaDTO maestra : requProcParaDinas){
                if(maestra.getValorParametro().getIdValorParametro()!=null){
                    s[cont]=maestra.getValorParametro().getIdValorParametro().toString();
                    cont++;
                }
            }
            retorno = StringUtils.join(s, ",");
        }        
        return retorno;
    }
    
    public static String concatenaTramites(List<TramiteDTO> tramites){
        String retorno="";
        if(tramites!=null && tramites.size()>0){
            String[] s = new String[tramites.size()];
            int cont=0;
            for(TramiteDTO maestra : tramites){s[cont]=maestra.getIdTramite().toString();cont++;}
            retorno = StringUtils.join(s, ",");
        }        
        return retorno;
    }
    
    public static String concatenaActividades(List<ActividadDTO> actividades){
        String retorno="";
        if(actividades!=null && actividades.size()>0){
            String[] s = new String[actividades.size()];
            int cont=0;
            for(ActividadDTO maestra : actividades){s[cont]=maestra.getIdActividad().toString();cont++;}
            retorno = StringUtils.join(s, ",");
        }        
        return retorno;
    }
    
    //jsifuentes
    public static String concatenaOpciones(List<OpcionDTO> listado){
        String retorno="";
        if(listado!=null && listado.size()>0){
            String[] s = new String[listado.size()];
            int cont=0;
            for(OpcionDTO maestra : listado){
                s[cont]=maestra.getIdOpcion().toString();cont++;
            }
            retorno = StringUtils.join(s, ",");
        }        
        return retorno;
    }
    
    public static String concatenaTipoSancionFromTipificacionSancion(List<TipificacionSancionDTO> listado){
        String retorno="";
        if(listado!=null && listado.size()>0){
            String[] s = new String[listado.size()];
            int cont=0;
            for(TipificacionSancionDTO maestra : listado){
                s[cont]=maestra.getIdTipoSancion().toString();cont++;
            }
            retorno = StringUtils.join(s, ",");
        }        
        return retorno;
    }
    public static String concatenaTxtTipoSancionFromTipificacionSancion(List<TipificacionSancionDTO> listado){
        String retorno="";
        if(listado!=null && listado.size()>0){
            String[] s = new String[listado.size()];
            int cont=0;
            for(TipificacionSancionDTO maestra : listado){
                s[cont]=maestra.getTipoSancion().getDescripcion();cont++;
            }
            retorno = StringUtils.join(s, ",");
        }        
        return retorno;
    }
    
    public static String concatenaTipificacionSancion(List<TipificacionSancionDTO> listado){
        String retorno="";
        if(listado!=null && listado.size()>0){
            String[] s = new String[listado.size()];
            int cont=0;
            for(TipificacionSancionDTO maestra : listado){s[cont]=maestra.getIdTipoSancion().toString();cont++;}
            retorno = StringUtils.join(s, ",");
        }        
        return retorno;
    }
    
    /*
     * Verifica que un idTramite exista en un List<TramiteDTO>
     */
    public static boolean existIdTramiteEnLista(Long idTramite, List<TramiteDTO> tramites){
        boolean retorno=false;//inicializo como que NO ESTA
        if(tramites!=null){
            for(TramiteDTO maestroAct : tramites){
                if(idTramite.equals(maestroAct.getIdTramite())){
                    retorno=true;
                }
            }
        }
        return retorno;
    }
    
    /*
     * Verifica que idTramite de la listaComparacion NO estan en la listaMaestra>
     */
    public static List<TramiteDTO> listTramiteNoExisteEnListTramite(List<TramiteDTO> listaComparacion, List<TramiteDTO> listaMaestra){
        List<TramiteDTO> listaNoExiste=new ArrayList<TramiteDTO>();
        String txtTramActu=MycUtil.concatenaTramites(listaComparacion);
        String txtTramUpda=MycUtil.concatenaTramites(listaMaestra);
        LOG.info("----> txtTramAct= "+txtTramActu+" - txtTramUpd= "+txtTramUpda);
        if(!txtTramActu.equals(txtTramUpda) && !txtTramActu.equals("")){
            for(TramiteDTO regTramActu : listaComparacion){
                boolean existe=MycUtil.existIdTramiteEnLista(regTramActu.getIdTramite(),listaMaestra);
                if(!existe){
                    listaNoExiste.add(regTramActu);
                }
            }
        }
        return listaNoExiste;
    }
    
    /*
     * Verifica que un idActividad exista en un List<ActividadDTO>
     */
    public static boolean existIdActividadEnLista(Long idActividad, List<ActividadDTO> actividades){
        boolean retorno=false;//inicializo como que NO ESTA
        if(actividades!=null){
            for(ActividadDTO maestroAct : actividades){
                if(idActividad.equals(maestroAct.getIdActividad())){
                    retorno=true;
                }
            }
        }
        return retorno;
    }
    
    /*
     * Verifica que idTramite de la listaComparacion NO estan en la listaMaestra>
     */
    public static List<ActividadDTO> listActividadNoExisteEnListActividad(List<ActividadDTO> listaComparacion, List<ActividadDTO> listaMaestra){
        List<ActividadDTO> listaNoExiste=new ArrayList<ActividadDTO>();
        String txtActiActu=MycUtil.concatenaActividades(listaComparacion);
        String txtActiUpda=MycUtil.concatenaActividades(listaMaestra);
        LOG.info("----> txtActiActu= "+txtActiActu+" - txtActiUpda= "+txtActiUpda);
        //si listas son diferentes, y la lista maestra(upd) es vacia, quiere decir que se retiraron todas las actividades
        //
        /*if(!txtActiActu.equals(txtActiUpda) && txtActiUpda.equals("")){
        
        }*/
        
        
        if(!txtActiActu.equals(txtActiUpda) && !txtActiActu.equals("")){
            for(ActividadDTO regActiActu : listaComparacion){
                boolean existe=MycUtil.existIdActividadEnLista(regActiActu.getIdActividad(),listaMaestra);
                if(!existe){
                    listaNoExiste.add(regActiActu);
                }
            }
        }
        return listaNoExiste;
    }
    
    public static String concatenaObligaciones(List<ObligacionBaseLegalDTO> lista){
        String retorno="";
        if(lista!=null && lista.size()>0){
            String[] s = new String[lista.size()];
            int cont=0;
            for(ObligacionBaseLegalDTO maestra : lista){s[cont]=maestra.getIdObligacion().toString();cont++;}
            retorno = StringUtils.join(s, ",");
        }        
        return retorno;
    }
    
    public static boolean existeIdEnLista(Long o, List<ObligacionBaseLegalDTO> listado){
        boolean retorno=false;//inicializo como que NO ESTA
        if(listado!=null){
            for(ObligacionBaseLegalDTO maestroAct : listado){
                if(o.equals(maestroAct.getIdObligacion())){
                    retorno=true;
                }
            }
        }
        return retorno;
    }

	public static String concatenaRelacion(List<ObligacionBaseLegalDTO> lista) {
		String retorno="";
        if(lista!=null && lista.size()>0){
            String[] s = new String[lista.size()];
            int cont=0;
            for(ObligacionBaseLegalDTO maestra : lista){s[cont]=maestra.getIdBaseLegal().toString();cont++;}
            retorno = StringUtils.join(s, ",");
        }        
        return retorno;
	}

	public static boolean existeIdBaseLegalEnLista(Long o,
			List<ObligacionBaseLegalDTO> listado) {
		boolean retorno=false;//inicializo como que NO ESTA
        if(listado!=null){
            for(ObligacionBaseLegalDTO maestroAct : listado){
                if(o.equals(maestroAct.getIdBaseLegal())){
                    retorno=true;
                }
            }
        }
        return retorno;
	}
	
	public static boolean existeIdSancionEnLista(Long o,
			List<TipificacionSancionDTO> listado) {
		boolean retorno=false;//inicializo como que NO ESTA
        if(listado!=null){
            for(TipificacionSancionDTO maestroAct : listado){
                if(o.equals(maestroAct.getIdTipoSancion())){
                    retorno=true;
                }
            }
        }
        return retorno;
	}

	public static ObligacionBaseLegalDTO existeObjectEnLista(Long o,
			List<ObligacionBaseLegalDTO> listado) {
		ObligacionBaseLegalDTO retorno=null;//inicializo como que NO ESTA
        if(listado!=null){
            for(ObligacionBaseLegalDTO maestroAct : listado){
                if(o.equals(maestroAct.getIdBaseLegal())){
                    retorno=maestroAct;
                }
            }
        }
        return retorno;
	}
	
	public static String concatenaListadoTemas(List<TemaDTO> temaObligacionAct) {
		String retorno="";
        if(temaObligacionAct!=null && temaObligacionAct.size()>0){
            String[] s = new String[temaObligacionAct.size()];
            int cont=0;
            for(TemaDTO maestra : temaObligacionAct){s[cont]=maestra.getIdTemaObligacion().toString();cont++;}
            retorno = StringUtils.join(s, ",");
        }        
        return retorno;
	}
	
	public static String concatenaListadoActividades(List<CnfObligacionDTO> actividad) {
		String retorno="";
        if(actividad!=null && actividad.size()>0){
            String[] s = new String[actividad.size()];
            int cont=0;
            for(CnfObligacionDTO maestra : actividad){s[cont]=maestra.getIdActividad().toString();cont++;}
            retorno = StringUtils.join(s, ",");
        }        
        return retorno;
	}

	public static boolean existIdTemaEnLista(Long idTemaObligacion,
			List<TemaDTO> listado) {
		boolean retorno=false;//inicializo como que NO ESTA
	        if(listado!=null){
	            for(TemaDTO maestroAct : listado){
	                if(idTemaObligacion.equals(maestroAct.getIdTemaObligacion())){
	                    retorno=true;
	                }
	            }
	        }
	        return retorno;
	}

//	public static String generaCodigoBaseLegal(String ultimoCodigo) {
//		String ultimoRegistro=null;
//    	try {
//    		ultimoRegistro=ultimoCodigo;
//	        String parteNumericaOblg=ultimoRegistro.substring(3,ultimoRegistro.length());
//	        System.out.println("parteNumericaOblg: "+parteNumericaOblg);
//	        String parteCadenaOblg=ultimoRegistro.substring(0,3);
//	        System.out.println("parteCadenaOblg: "+parteCadenaOblg);
//	        Integer numeroBaseLegal = new Integer(parteNumericaOblg);
//	        System.out.println("numeroBaseLegal: "+numeroBaseLegal);
//	        numeroBaseLegal++;
//	        System.out.println("numeroBaseLegal: "+numeroBaseLegal);
//	        if(numeroBaseLegal<10){
//	        	String enteroStringOblg = Integer.toString(numeroBaseLegal);
//	            parteNumericaOblg="000000"+enteroStringOblg;	
//	        }else if(numeroBaseLegal>9 && numeroBaseLegal<100){
//	        	String enteroStringOblg = Integer.toString(numeroBaseLegal);
//	            parteNumericaOblg="00000"+enteroStringOblg;
//	        }else if(numeroBaseLegal>99 && numeroBaseLegal<1000){
//	        	String enteroStringOblg = Integer.toString(numeroBaseLegal);
//	            parteNumericaOblg="0000"+enteroStringOblg;
//	        }else if(numeroBaseLegal>999 && numeroBaseLegal<10000){
//	        	String enteroStringOblg = Integer.toString(numeroBaseLegal);
//	            parteNumericaOblg="000"+enteroStringOblg;
//	        }else if(numeroBaseLegal>9999 && numeroBaseLegal<100000){
//	        	String enteroStringOblg = Integer.toString(numeroBaseLegal);
//	            parteNumericaOblg="00"+enteroStringOblg;
//	        }else if(numeroBaseLegal>99999 && numeroBaseLegal<100000){
//	        	String enteroStringOblg = Integer.toString(numeroBaseLegal);
//	            parteNumericaOblg="00"+enteroStringOblg;
//	        }else if(numeroBaseLegal>999999 && numeroBaseLegal<1000000){
//	        	String enteroStringOblg = Integer.toString(numeroBaseLegal);
//	            parteNumericaOblg="0"+enteroStringOblg;
//	        }
//        ultimoRegistro=parteCadenaOblg+parteNumericaOblg;
//
//        
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
//	return ultimoRegistro;
//
//	}

	public static String generaObligacion(String ultimoCodigo) {
		String ultimoRegistro=null;
    	try {
    		ultimoRegistro=ultimoCodigo;
    		String parteNumericaOblg=ultimoRegistro.substring(3,ultimoRegistro.length());
            System.out.println("parteNumerica Oblg: "+parteNumericaOblg);
            String parteCadenaOblg=ultimoRegistro.substring(0,3);
            System.out.println("parteCadena Oblg: "+parteCadenaOblg);
            Integer numeroBaseLegal = new Integer(parteNumericaOblg);
            System.out.println("numero Obligacion: "+numeroBaseLegal);
            numeroBaseLegal++;
            System.out.println("numeroBaseLegal: "+numeroBaseLegal);
            if(numeroBaseLegal<10){
            	String enteroStringOblg = Integer.toString(numeroBaseLegal);
                parteNumericaOblg="000000"+enteroStringOblg;	
            }else if(numeroBaseLegal>9 && numeroBaseLegal<100){
            	String enteroStringOblg = Integer.toString(numeroBaseLegal);
                parteNumericaOblg="00000"+enteroStringOblg;
            }else if(numeroBaseLegal>99 && numeroBaseLegal<1000){
            	String enteroStringOblg = Integer.toString(numeroBaseLegal);
                parteNumericaOblg="0000"+enteroStringOblg;
            }else if(numeroBaseLegal>999 && numeroBaseLegal<10000){
            	String enteroStringOblg = Integer.toString(numeroBaseLegal);
                parteNumericaOblg="000"+enteroStringOblg;
            }else if(numeroBaseLegal>9999 && numeroBaseLegal<100000){
            	String enteroStringOblg = Integer.toString(numeroBaseLegal);
                parteNumericaOblg="00"+enteroStringOblg;
            }else if(numeroBaseLegal>99999 && numeroBaseLegal<100000){
            	String enteroStringOblg = Integer.toString(numeroBaseLegal);
                parteNumericaOblg="00"+enteroStringOblg;
            }else if(numeroBaseLegal>999999 && numeroBaseLegal<1000000){
            	String enteroStringOblg = Integer.toString(numeroBaseLegal);
                parteNumericaOblg="0"+enteroStringOblg;
            }
            
            
            ultimoRegistro=parteCadenaOblg+parteNumericaOblg;
    		
    	}catch (Exception e) {
    		// TODO: handle exception
    	}
		return ultimoRegistro;
	}
}
