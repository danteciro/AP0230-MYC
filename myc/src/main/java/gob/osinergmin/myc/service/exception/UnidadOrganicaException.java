package gob.osinergmin.myc.service.exception;
/**
 *
 * @author mdiosesf
 */
public class UnidadOrganicaException extends BaseException {
	private static final long serialVersionUID = 1L;

	public UnidadOrganicaException(Exception exception) {
            super(exception);
    }

    /**
     * 
     * @param message
     * @param exception
     */
    public UnidadOrganicaException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * 
     * @param message
     * @param exception
     */
    public UnidadOrganicaException(String codigo, Exception exception, boolean buscarCodigo) {		
            super(codigo, exception, buscarCodigo);
    }

    /**
     * 
     * @param codigo
     * @param message
     * @param exception
     */
    public UnidadOrganicaException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * 
     * @param codigo
     */
    public UnidadOrganicaException(String codigo) {
            super(codigo);	
    }
}
