/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class MaestroTablaException extends BaseException {
    public static final String ERROR_CREAR_MAESTRO_TABLA = "maestroTabla.service.crear.error";
    public static final String ERROR_EDITAR_MAESTRO_TABLA = "maestroTabla.service.editar.error";
    public static final String ERROR_BUSCAR_MAESTRO_TABLA = "maestroTabla.service.buscar.error";
    public static final String ERROR_CONTAR_MAESTRO_TABLA = "maestroTabla.service.contar.error";
    public static final String ERROR_ELIMINAR_MAESTRO_TABLA= "maestroTabla.service.eliminar.error";

    /**
     * Constructor de la clase MaestroColulmnaException que recibe como parametro exception
     * 
     * @param exception
     */
    public MaestroTablaException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase MaestroColulmnaException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public MaestroTablaException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase MaestroColulmnaException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public MaestroTablaException(String codigo, Exception exception, boolean buscarCodigo) {		
            super(codigo, exception, buscarCodigo);
    }

    /**
     * Constructor de la clase MaestroColulmnaException que recibe como parametros
     * codigoException, message y exception
     * 
     * @param codigo
     * @param message
     * @param exception
     */
    public MaestroTablaException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase MaestroColulmnaException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public MaestroTablaException(String codigo) {
            super(codigo);	
    }
}
