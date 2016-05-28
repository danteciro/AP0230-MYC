/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class ZonificacionException extends BaseException{
    public static final String ERROR_CREAR_ZONIFICACION = "zonificacion.service.crear.error";
    public static final String ERROR_EDITAR_ZONIFICACION = "zonificacion.service.editar.error";
    public static final String ERROR_VALIDA_ZONIFICACION = "zonificacion.service.crear.validar.error";
    public static final String ERROR_BUSCAR_ZONIFICACION = "zonificacion.service.buscar.error";
    public static final String ERROR_CONTAR_ZONIFICACION = "zonificacion.service.contar.error";
    public static final String ERROR_ELIMINAR_ZONIFICACION= "zonificacion.service.eliminar.error";


    public ZonificacionException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ZonificacionException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ZonificacionException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public ZonificacionException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public ZonificacionException(String codigo) {
            super(codigo);	
    }
}
