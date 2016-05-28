package gob.osinergmin.myc.service.exception;

public class TramiteActividadException  extends BaseException{
	    
	    public static final String ERROR_CREAR_TRAM_ACTIVIDAD = "tramActividad.service.crear.error";
	    public static final String ERROR_EDITAR_TRAM_ACTIVIDAD = "tramActividad.service.editar.error";
	    public static final String ERROR_VALIDA_TRAM_ACTIVIDAD = "tramActividad.service.crear.validar.error";
	    public static final String ERROR_VALIDA_EDITAR_TRAM_ACTIVIDAD = "tramActividad.service.editar.validar.error";
	    public static final String ERROR_BUSCAR_TRAM_ACTIVIDAD = "tramActividad.service.buscar.error";
	    public static final String ERROR_CONTAR_TRAM_ACTIVIDAD = "tramActividad.service.contar.error";
	    public static final String ERROR_ELIMINAR_TRAM_ACTIVIDADTRAMITE = "tramActividad.service.eliminar.error";

	public TramiteActividadException(Exception exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}
	
    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public TramiteActividadException(String codigo) {
            super(codigo);	
    }
    
    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros
     * codigoException, message y exception
     * 
     * @param codigo
     * @param message
     * @param exception
     */
    public TramiteActividadException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }
    
    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public TramiteActividadException(String codigo, Exception exception, boolean buscarCodigo) {		
            super(codigo, exception, buscarCodigo);
    }
    
    /**
     * Constructor de la clase ContratoLocadorException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public TramiteActividadException(String message, Exception exception) {
            super(message, exception);
    }

}
