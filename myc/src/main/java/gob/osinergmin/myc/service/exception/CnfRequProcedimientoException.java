/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class CnfRequProcedimientoException extends BaseException {
    public static final String ERROR_CREAR_REQU_PROCEDIMIENTO = "requProcedimento.service.crear.error";
    public static final String ERROR_EDITAR_REQU_PROCEDIMIENTO = "requProcedimento.service.editar.error";
    public static final String ERROR_VALIDA_REQU_PROCEDIMIENTO = "requProcedimento.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_REQU_PROCEDIMIENTO = "requProcedimento.service.editar.validar.error";
    public static final String ERROR_BUSCAR_REQU_PROCEDIMIENTO = "requProcedimento.service.buscar.error";
    public static final String ERROR_CONTAR_REQU_PROCEDIMIENTO = "requProcedimento.service.contar.error";
    public static final String ERROR_ELIMINAR_REQU_PROCEDIMIENTO= "requProcedimento.service.eliminar.error";

    public CnfRequProcedimientoException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public CnfRequProcedimientoException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public CnfRequProcedimientoException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public CnfRequProcedimientoException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public CnfRequProcedimientoException(String codigo) {
            super(codigo);	
    }
}
