/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class ParametroException extends BaseException{
    public static final String ERROR_CREAR_PARAMETRO = "parametro.service.crear.error";
    public static final String ERROR_EDITAR_PARAMETRO = "parametro.service.editar.error";
    public static final String ERROR_VALIDA_PARAMETRO = "parametro.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_PARAMETRO = "parametro.service.editar.validar.error";
    public static final String ERROR_BUSCAR_PARAMETRO = "parametro.service.buscar.error";
    public static final String ERROR_CONTAR_PARAMETRO = "parametro.service.contar.error";
    public static final String ERROR_ELIMINAR_PARAMETRO= "parametro.service.eliminar.error";

    public ParametroException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ParametroException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ParametroException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public ParametroException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public ParametroException(String codigo) {
            super(codigo);	
    }
}
