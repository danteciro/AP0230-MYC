/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author jpiro
 */
public class ConcursoException extends BaseException {
    public static final String ERROR_CREAR_CONCURSO = "concurso.service.crear.error";
    public static final String ERROR_EDITAR_CONCURSO = "concurso.service.editar.error";
    public static final String ERROR_BUSCAR_CONCURSO = "concurso.service.buscar.error";
    public static final String ERROR_ELIMINAR_CONCURSO= "concurso.service.eliminar.error";

    public ConcursoException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ConcursoException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public ConcursoException(String codigo, Exception exception, boolean buscarCodigo) {		
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
    public ConcursoException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public ConcursoException(String codigo) {
            super(codigo);	
    }
}
