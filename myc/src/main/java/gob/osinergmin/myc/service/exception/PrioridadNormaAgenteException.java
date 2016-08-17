/**
* Resumen           
* Objeto            : PrioridadNormaAgenteException.java
* Descripción       : Clase excepcion de prioridad norma agente en el MYC.
* Fecha de Creación : 04/07/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Mario Dioses Fernandez.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
package gob.osinergmin.myc.service.exception;

/**
 *
 * @author mdiosesf
 */
public class PrioridadNormaAgenteException extends BaseException {
	private static final long serialVersionUID = 1L;
	public static final String ERROR_CREAR_PRIORIDAD = "prioridad.service.crear.error";
    public static final String ERROR_EDITAR_PRIORIDAD = "prioridad.service.editar.error";
    public static final String ERROR_VALIDA_PRIORIDAD = "prioridad.service.crear.validar.error";
    public static final String ERROR_VALIDA_EDITAR_PRIORIDAD = "prioridad.service.editar.validar.error";
    public static final String ERROR_BUSCAR_PRIORIDAD = "prioridad.service.buscar.error";
    public static final String ERROR_CONTAR_PRIORIDAD = "prioridad.service.contar.error";
    public static final String ERROR_ELIMINAR_PRIORIDAD= "prioridad.service.eliminar.error";

    public PrioridadNormaAgenteException(Exception exception) {
            super(exception);
    }

    /**
     * Constructor de la clase PrioridadNormaAgenteException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public PrioridadNormaAgenteException(String message, Exception exception) {
    	super(message, exception);
    }

    /**
     * Constructor de la clase PrioridadNormaAgenteException que recibe como parametros message
     * y exception
     * 
     * @param message
     * @param exception
     */
    public PrioridadNormaAgenteException(String codigo, Exception exception, boolean buscarCodigo) {		
    	super(codigo, exception, buscarCodigo);
    }

    /**
     * Constructor de la clase PrioridadNormaAgenteException que recibe como parametros
     * codigoException, message y exception
     * 
     * @param codigo
     * @param message
     * @param exception
     */
    public PrioridadNormaAgenteException(String codigo, String message, Exception exception) {		
    	super(codigo, message, exception);		
    }

    /**
     * Constructor de la clase PrioridadNormaAgenteException que recibe como parametro
     * codigoException
     * 
     * @param codigo
     */
    public PrioridadNormaAgenteException(String codigo) {
            super(codigo);	
    }
}
