/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class ActividadException extends BaseException {
    public static final String ERROR_CREAR_ACTIVIDAD = "actividad.service.crear.error";
    public static final String ERROR_EDITAR_ACTIVIDAD = "actividad.service.editar.error";
    public static final String ERROR_VALIDA_ACTIVIDAD = "actividad.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_ACTIVIDAD = "actividad.service.editar.validar.error";
    public static final String ERROR_BUSCAR_ACTIVIDAD = "actividad.service.buscar.error";
    public static final String ERROR_CONTAR_ACTIVIDAD = "actividad.service.contar.error";
    public static final String ERROR_ELIMINAR_ACTIVIDAD= "actividad.service.eliminar.error";

    public ActividadException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ActividadException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ActividadException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public ActividadException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public ActividadException(String codigo) {
            super(codigo);	
    }
}
