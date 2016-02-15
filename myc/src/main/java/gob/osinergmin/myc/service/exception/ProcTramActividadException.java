/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class ProcTramActividadException extends BaseException {
    public static final String ERROR_CREAR_PROC_TRAM_ACTIVIDAD = "procTramActividad.service.crear.error";
    public static final String ERROR_EDITAR_PROC_TRAM_ACTIVIDAD = "procTramActividad.service.editar.error";
    public static final String ERROR_VALIDA_PROC_TRAM_ACTIVIDAD = "procTramActividad.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_PROC_TRAM_ACTIVIDAD = "procTramActividad.service.editar.validar.error";
    public static final String ERROR_BUSCAR_PROC_TRAM_ACTIVIDAD = "procTramActividad.service.buscar.error";
    public static final String ERROR_CONTAR_PROC_TRAM_ACTIVIDAD = "procTramActividad.service.contar.error";
    public static final String ERROR_ELIMINAR_PROC_TRAM_ACTIVIDADTRAMITE = "procTramActividad.service.eliminar.error";

    public ProcTramActividadException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ProcTramActividadException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ProcTramActividadException(String codigo, Exception exception, boolean buscarCodigo) {		
            super(codigo, exception, buscarCodigo);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros
     * codigoException, message y exception
     * 
     * @param codigo
     * @param message
     * @param exception
     */
    public ProcTramActividadException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public ProcTramActividadException(String codigo) {
            super(codigo);	
    }
}
