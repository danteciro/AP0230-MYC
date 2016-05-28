/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class ProcedimientoException extends BaseException {
    public static final String ERROR_CREAR_PROCEDIMIENTO = "procedimiento.service.crear.error";
    public static final String ERROR_EDITAR_PROCEDIMIENTO = "procedimiento.service.editar.error";
    public static final String ERROR_VALIDA_PROCEDIMIENTO = "procedimiento.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_PROCEDIMIENTO = "procedimiento.service.editar.validar.error";
    public static final String ERROR_BUSCAR_PROCEDIMIENTO = "procedimiento.service.buscar.error";
    public static final String ERROR_CONTAR_PROCEDIMIENTO = "procedimiento.service.contar.error";
    public static final String ERROR_ELIMINAR_PROCEDIMIENTO= "procedimiento.service.eliminar.error";

    public ProcedimientoException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ProcedimientoException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ProcedimientoException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public ProcedimientoException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public ProcedimientoException(String codigo) {
            super(codigo);	
    }
}
