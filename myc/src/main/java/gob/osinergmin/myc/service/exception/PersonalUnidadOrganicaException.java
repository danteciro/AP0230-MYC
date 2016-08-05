/**
* Resumen		
* Objeto		: PghCargo.java
* Descripción		: Exception para PersonalUnidadOrganica.
* Fecha de Creación	: 13/06/2016
* PR de Creación	: OSINE_SFS-480
* Autor			: Julio Piro
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                          Descripción
* ---------------------------------------------------------------------------------------------------
* 
*/ 

package gob.osinergmin.myc.service.exception;
public class PersonalUnidadOrganicaException extends BaseException {
	private static final long serialVersionUID = 1L;

	public PersonalUnidadOrganicaException(Exception exception) {
            super(exception);
    }

    /**
     * 
     * @param message
     * @param exception
     */
    public PersonalUnidadOrganicaException(String message, Exception exception) {
            super(message, exception);
    }

    /**
     * 
     * @param message
     * @param exception
     */
    public PersonalUnidadOrganicaException(String codigo, Exception exception, boolean buscarCodigo) {		
            super(codigo, exception, buscarCodigo);
    }

    /**
     * 
     * @param codigo
     * @param message
     * @param exception
     */
    public PersonalUnidadOrganicaException(String codigo, String message, Exception exception) {		
            super(codigo, message, exception);		
    }

    /**
     * 
     * @param codigo
     */
    public PersonalUnidadOrganicaException(String codigo) {
            super(codigo);	
    }
}
