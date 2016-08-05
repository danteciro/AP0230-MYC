package gob.osinergmin.myc.service.exception;
/**
 *
 * @author mdiosesf
 */
public class ConfFiltroEmpSupException extends BaseException {
	private static final long serialVersionUID = 1L;

	public ConfFiltroEmpSupException(Exception exception) {
            super(exception);
    }

    /**
     * 
     * @param message
     * @param exception
     */
    public ConfFiltroEmpSupException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * 
     * @param message
     * @param exception
     */
    public ConfFiltroEmpSupException(String codigo, Exception exception, boolean buscarCodigo) {		
            super(codigo, exception, buscarCodigo);
    }

    /**
     * 
     * @param codigo
     * @param message
     * @param exception
     */
    public ConfFiltroEmpSupException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * 
     * @param codigo
     */
    public ConfFiltroEmpSupException(String codigo) {
            super(codigo);	
    }
}
