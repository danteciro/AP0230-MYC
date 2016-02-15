/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class TramiteException extends BaseException  {
    public static final String ERROR_CREAR_TRAMITE = "tramite.service.crear.error";
    public static final String ERROR_EDITAR_TRAMITE = "tramite.service.editar.error";
    public static final String ERROR_VALIDA_TRAMITE = "tramite.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_TRAMITE = "tramite.service.editar.validar.error";
    public static final String ERROR_BUSCAR_TRAMITE = "tramite.service.buscar.error";
    public static final String ERROR_CONTAR_TRAMITE = "tramite.service.contar.error";
    public static final String ERROR_ELIMINAR_TRAMITE= "tramite.service.eliminar.error";

    public TramiteException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public TramiteException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public TramiteException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public TramiteException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public TramiteException(String codigo) {
            super(codigo);	
    }
}
