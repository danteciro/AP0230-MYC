package gob.osinergmin.myc.service.exception;

public class ValorParametroException extends BaseException {

	public static final String ERROR_CREAR_VALOR_PARAMETRO = "valor_parametro.service.crear.error";
	    public static final String ERROR_EDITAR_VALOR_PARAMETRO = "valor_parametro.service.editar.error";
	    public static final String ERROR_VALIDA_VALOR_PARAMETRO = "valor_parametro.service.crear.validar.error";
	    public static final String ERROR_VALIDA_EDITAR_VALOR_PARAMETRO = "valor_parametro.service.editar.validar.error";
	    public static final String ERROR_BUSCAR_VALOR_PARAMETRO = "valor_parametro.service.buscar.error";
	    public static final String ERROR_CONTAR_VALOR_PARAMETRO = "valor_parametro.service.contar.error";
	    public static final String ERROR_ELIMINAR_VALOR_PARAMETRO= "valor_parametro.service.eliminar.error";
	    
	    
		   public ValorParametroException(Exception exception) {
				super(exception);
				// TODO Auto-generated constructor stub
			}
		   
		   
		    /**
		     * Constructor de la clase ContratoLocadorException que recibe como parametros message
		     * y exception
		     * 
		     * @param message
		     * @param exception
		     */
		    public ValorParametroException(String codigo, Exception exception, boolean buscarCodigo) {		
		            super(codigo, exception, buscarCodigo);
		    }


}
