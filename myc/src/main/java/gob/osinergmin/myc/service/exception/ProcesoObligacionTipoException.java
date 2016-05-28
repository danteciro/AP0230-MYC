package gob.osinergmin.myc.service.exception;

public class ProcesoObligacionTipoException extends BaseException{
	
	
	    public static final String ERROR_CREAR_PROC_OBLI_ACTIVIDAD = "procesoObliTipo.service.crear.error";
	    public static final String ERROR_EDITAR_PROC_OBLI_ACTIVIDAD = "procesoObliTipo.service.editar.error";
	    public static final String ERROR_VALIDA_PROC_OBLI_ACTIVIDAD = "procesoObliTipo.service.crear.validar.error";
	    public static final String ERROR_VALIDA_EDITAR_PROC_OBLI_ACTIVIDAD = "procesoObliTipo.service.editar.validar.error";
	    public static final String ERROR_BUSCAR_PROC_OBLI_ACTIVIDAD = "procesoObliTipo.service.buscar.error";
	    public static final String ERROR_CONTAR_PROC_OBLI_ACTIVIDAD = "tramActividad.service.contar.error";
	    public static final String ERROR_ELIMINAR_PROC_OBLI_ACTIVIDAD = "procesoObliTipo.service.eliminar.error";
	
	    public ProcesoObligacionTipoException(Exception exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}
	    
	    /**
	     * Constructor de la clase ProcesoObligacionTipoException que recibe como parametro
	     * codigoException
	     * 
	     * @param codigo
	     */
	    public ProcesoObligacionTipoException(String codigo) {
	            super(codigo);	
	    }
	    
	    /**
	     * Constructor de la clase ProcesoObligacionTipoException que recibe como parametros
	     * codigoException, message y exception
	     * 
	     * @param codigo
	     * @param message
	     * @param exception
	     */
	    public ProcesoObligacionTipoException(String codigo, String message, Exception exception) {		
	            super(codigo, message, exception);		
	    }
	    
	    /**
	     * Constructor de la clase ProcesoObligacionTipoException que recibe como parametros message
	     * y exception
	     * 
	     * @param message
	     * @param exception
	     */
	    public ProcesoObligacionTipoException(String codigo, Exception exception, boolean buscarCodigo) {		
	            super(codigo, exception, buscarCodigo);
	    }
	    
	    /**
	     * Constructor de la clase ProcesoObligacionTipoException que recibe como parametros message
	     * y exception
	     * 
	     * @param message
	     * @param exception
	     */
	    public ProcesoObligacionTipoException(String message, Exception exception) {
	            super(message, exception);
	    }

		
}
