/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class TipificacionException extends BaseException {
    public static final String ERROR_CREAR_TIPIFICACION = "tipificacion.service.crear.error";
    public static final String ERROR_EDITAR_TIPIFICACION = "tipificacion.service.editar.error";
    public static final String ERROR_VALIDA_TIPIFICACION = "tipificacion.service.crear.validar.error";
    public static final String ERROR_BUSCAR_TIPIFICACION = "tipificacion.service.buscar.error";
    public static final String ERROR_ELIMINAR_TIPIFICACION= "tipificacion.service.eliminar.error";

    public TipificacionException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public TipificacionException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public TipificacionException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public TipificacionException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public TipificacionException(String codigo) {
            super(codigo);	
    }
}
