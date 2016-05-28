/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class EtapaException extends BaseException {
    public static final String ERROR_CREAR_ETAPA = "etapa.service.crear.error";
    public static final String ERROR_EDITAR_ETAPA = "etapa.service.editar.error";
    public static final String ERROR_VALIDA_ETAPA = "etapa.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_ETAPA = "etapa.service.editar.validar.error";
    public static final String ERROR_BUSCAR_ETAPA = "etapa.service.buscar.error";
    public static final String ERROR_CONTAR_ETAPA = "etapa.service.contar.error";
    public static final String ERROR_ELIMINAR_ETAPA= "etapa.service.eliminar.error";

    public EtapaException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public EtapaException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public EtapaException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public EtapaException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public EtapaException(String codigo) {
            super(codigo);	
    }
}
