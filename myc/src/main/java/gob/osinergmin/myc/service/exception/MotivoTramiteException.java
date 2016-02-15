/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class MotivoTramiteException extends BaseException {
    public static final String ERROR_CREAR_MOTIVO_TRAMITE = "motivoTramite.service.crear.error";
    public static final String ERROR_EDITAR_MOTIVO_TRAMITE = "motivoTramite.service.editar.error";
    public static final String ERROR_VALIDA_MOTIVO_TRAMITE = "motivoTramite.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_MOTIVO_TRAMITE = "motivoTramite.service.editar.validar.error";
    public static final String ERROR_BUSCAR_MOTIVO_TRAMITE = "motivoTramite.service.buscar.error";
    public static final String ERROR_CONTAR_MOTIVO_TRAMITE = "motivoTramite.service.contar.error";
    public static final String ERROR_ELIMINAR_MOTIVO_TRAMITE= "motivoTramite.service.eliminar.error";

    public MotivoTramiteException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public MotivoTramiteException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public MotivoTramiteException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public MotivoTramiteException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public MotivoTramiteException(String codigo) {
            super(codigo);	
    }
}
