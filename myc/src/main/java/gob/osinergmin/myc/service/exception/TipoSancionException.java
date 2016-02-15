/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class TipoSancionException extends BaseException{
    public static final String ERROR_CREAR_TIPO_SANCION = "tipoSancion.service.crear.error";
    public static final String ERROR_EDITAR_TIPO_SANCION = "tipoSancion.service.editar.error";
    public static final String ERROR_VALIDA_TIPO_SANCION = "tipoSancion.service.crear.validar.error";
    public static final String ERROR_BUSCAR_TIPO_SANCION = "tipoSancion.service.buscar.error";
    public static final String ERROR_ELIMINAR_TIPO_SANCION= "tipoSancion.service.eliminar.error";

    public TipoSancionException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public TipoSancionException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public TipoSancionException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public TipoSancionException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public TipoSancionException(String codigo) {
            super(codigo);	
    }
}
