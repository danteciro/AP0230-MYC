/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class ProcesoException extends BaseException {
    public static final String ERROR_CREAR_PROCESO = "proceso.service.crear.error";
    public static final String ERROR_EDITAR_PROCESO = "proceso.service.editar.error";
    public static final String ERROR_VALIDA_PROCESO = "proceso.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_PROCESO = "proceso.service.editar.validar.error";
    public static final String ERROR_BUSCAR_PROCESO = "proceso.service.buscar.error";
    public static final String ERROR_CONTAR_PROCESO = "proceso.service.contar.error";
    public static final String ERROR_ELIMINAR_PROCESO = "proceso.service.eliminar.error";

    public ProcesoException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ProcesoException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ProcesoException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public ProcesoException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public ProcesoException(String codigo) {
            super(codigo);	
    }
}
