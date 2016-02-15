/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class UbigeoException extends BaseException {
    public static final String ERROR_CREAR_UBIGEO = "ubigeo.service.crear.error";
    public static final String ERROR_EDITAR_UBIGEO = "ubigeo.service.editar.error";
    public static final String ERROR_VALIDA_UBIGEO = "ubigeo.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_UBIGEO = "ubigeo.service.editar.validar.error";
    public static final String ERROR_BUSCAR_UBIGEO = "ubigeo.service.buscar.error";
    public static final String ERROR_CONTAR_UBIGEO = "ubigeo.service.contar.error";
    public static final String ERROR_ELIMINAR_UBIGEO= "ubigeo.service.eliminar.error";

    public UbigeoException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public UbigeoException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public UbigeoException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public UbigeoException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public UbigeoException(String codigo) {
            super(codigo);	
    }
}
