/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class RequisitoException extends BaseException {
    public static final String ERROR_CREAR_REQUISITO = "requisito.service.crear.error";
    public static final String ERROR_EDITAR_REQUISITO = "requisito.service.editar.error";
    public static final String ERROR_VALIDA_REQUISITO = "requisito.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_REQUISITO = "requisito.service.editar.validar.error";
    public static final String ERROR_BUSCAR_REQUISITO = "requisito.service.buscar.error";
    public static final String ERROR_CONTAR_REQUISITO = "requisito.service.contar.error";
    public static final String ERROR_ELIMINAR_REQUISITO= "requisito.service.eliminar.error";

    public RequisitoException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public RequisitoException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public RequisitoException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public RequisitoException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public RequisitoException(String codigo) {
            super(codigo);	
    }
}
