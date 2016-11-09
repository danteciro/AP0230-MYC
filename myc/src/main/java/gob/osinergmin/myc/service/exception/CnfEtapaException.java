package gob.osinergmin.myc.service.exception;

public class CnfEtapaException extends BaseException{

	 /**
	 * 
	 */
	
	public static final String ERROR_CREAR_CNF_ETAPA = "etapa.service.crear.error";
	    public static final String ERROR_EDITAR_CNF_ETAPA = "etapa.service.editar.error";
	    public static final String ERROR_VALIDA_CNF_ETAPA = "etapa.service.crear.validar.error";
	    public static final String ERROR_VALIDA_CNF_EDITAR_ETAPA = "etapa.service.editar.validar.error";
	    public static final String ERROR_BUSCAR_CNF_ETAPA = "etapa.service.buscar.error";
	    public static final String ERROR_CONTAR_CNF_ETAPA = "etapa.service.contar.error";
	    public static final String ERROR_ELIMINAR_CNF_ETAPA= "etapa.service.eliminar.error";

	    public CnfEtapaException(Exception exception) {
	            super(exception);
	    }

	    /**
	     * Constructor de la clase ContratoLocadorException que recibe como parametros message
	     * y exception
	     * 
	     * @param message
	     * @param exception
	     */
	    public CnfEtapaException(String message, Exception exception) {
	            super(message, exception);
	    }

	    /**
	     * Constructor de la clase ContratoLocadorException que recibe como parametros message
	     * y exception
	     * 
	     * @param message
	     * @param exception
	     */
	    public CnfEtapaException(String codigo, Exception exception, boolean buscarCodigo) {		
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
	    public CnfEtapaException(String codigo, String message, Exception exception) {		
	            super(codigo, message, exception);		
	    }

	    /**
	     * Constructor de la clase ContratoLocadorException que recibe como parametro
	     * codigoException
	     * 
	     * @param codigo
	     */
	    public CnfEtapaException(String codigo) {
	            super(codigo);	
	    }
	
}
