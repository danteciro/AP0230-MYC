package gob.osinergmin.myc.service.exception;

/**
*
* @author dmedrano
* @version 1.0 	21/10/14
* @see
*/
public class MaestroColumnaException extends BaseException{
	public static final String ERROR_CREAR_MAESTRO_COLUMNA = "maestroColumna.service.crear.error";
        public static final String ERROR_EDITAR_MAESTRO_COLUMNA = "maestroColumna.service.editar.error";
        public static final String ERROR_BUSCAR_MAESTRO_COLUMNA = "maestroColumna.service.buscar.error";
        public static final String ERROR_CONTAR_MAESTRO_COLUMNA = "maestroColumna.service.contar.error";
        public static final String ERROR_ELIMINAR_MAESTRO_COLUMNA= "maestroColumna.service.eliminar.error";
	
	/**
	 * Constructor de la clase MaestroColulmnaException que recibe como parametro exception
	 * 
	 * @param exception
	 */
	public MaestroColumnaException(Exception exception) {
		super(exception);
	}

	/**
	 * Constructor de la clase MaestroColulmnaException que recibe como parametros message
	 * y exception
	 * 
	 * @param message
	 * @param exception
	 */
	public MaestroColumnaException(String message, Exception exception) {
		super(message, exception);
	}
	
	/**
	 * Constructor de la clase MaestroColulmnaException que recibe como parametros message
	 * y exception
	 * 
	 * @param message
	 * @param exception
	 */
	public MaestroColumnaException(String codigo, Exception exception, boolean buscarCodigo) {		
		super(codigo, exception, buscarCodigo);
	}

	/**
	 * Constructor de la clase MaestroColulmnaException que recibe como parametros
	 * codigoException, message y exception
	 * 
	 * @param codigo
	 * @param message
	 * @param exception
	 */
	public MaestroColumnaException(String codigo, String message, Exception exception) {		
		super(codigo, message, exception);		
	}

	/**
	 * Constructor de la clase MaestroColulmnaException que recibe como parametro
	 * codigoException
	 * 
	 * @param codigo
	 */
	public MaestroColumnaException(String codigo) {
		super(codigo);	
	}
}

