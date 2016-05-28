package gob.osinergmin.myc.service.exception;

public class ObligacionException extends BaseException{

	public ObligacionException(Exception exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}
	public ObligacionException(String message, Exception exception) {
        super(message, exception);
	}
	public ObligacionException(String codigo, Exception exception, boolean buscarCodigo) {		
        super(codigo, exception, buscarCodigo);
}
}
