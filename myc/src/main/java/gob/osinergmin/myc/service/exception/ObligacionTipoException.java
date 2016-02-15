/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class ObligacionTipoException extends BaseException {
    public static final String ERROR_CREAR_OBLIGACION_TIPO = "obligacionTipo.service.crear.error";
    public static final String ERROR_EDITAR_OBLIGACION_TIPO = "obligacionTipo.service.editar.error";
    public static final String ERROR_BUSCAR_OBLIGACION_TIPO = "obligacionTipo.service.buscar.error";
    public static final String ERROR_CONTAR_OBLIGACION_TIPO = "obligacionTipo.service.contar.error";
    public static final String ERROR_ELIMINAR_OBLIGACION_TIPO= "obligacionTipo.service.eliminar.error";

    /**
     * Constructor de la clase MaestroColulmnaException que recibe como parametro exception
     * 
     * @param exception
     */
    public ObligacionTipoException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase MaestroColulmnaException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ObligacionTipoException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase MaestroColulmnaException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ObligacionTipoException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public ObligacionTipoException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase MaestroColulmnaException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public ObligacionTipoException(String codigo) {
            super(codigo);	
    }
}
