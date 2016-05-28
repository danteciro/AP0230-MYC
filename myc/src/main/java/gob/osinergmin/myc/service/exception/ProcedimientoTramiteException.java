/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class ProcedimientoTramiteException extends BaseException {
    public static final String ERROR_CREAR_PROCEDIMIENTO_TRAMITE = "procedimientoTramite.service.crear.error";
    public static final String ERROR_EDITAR_PROCEDIMIENTO_TRAMITE = "procedimientoTramite.service.editar.error";
    public static final String ERROR_VALIDA_PROCEDIMIENTO_TRAMITE = "procedimientoTramite.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_PROCEDIMIENTO_TRAMITE = "procedimientoTramite.service.editar.validar.error";
    public static final String ERROR_BUSCAR_PROCEDIMIENTO_TRAMITE = "procedimientoTramite.service.buscar.error";
    public static final String ERROR_CONTAR_PROCEDIMIENTO_TRAMITE = "procedimientoTramite.service.contar.error";
    public static final String ERROR_ELIMINAR_PROCEDIMIENTO_TRAMITE = "procedimientoTramite.service.eliminar.error";

    public ProcedimientoTramiteException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ProcedimientoTramiteException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ProcedimientoTramiteException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public ProcedimientoTramiteException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public ProcedimientoTramiteException(String codigo) {
            super(codigo);	
    }
}
