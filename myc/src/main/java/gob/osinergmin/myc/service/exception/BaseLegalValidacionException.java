package gob.osinergmin.myc.service.exception;
/**
 * 
 * @author gvillanueva
 */
public class BaseLegalValidacionException extends BaseException{
	
	public BaseLegalValidacionException(String message){
		super(message);
	}
	
	public BaseLegalValidacionException(String message, Exception exception){
		super(message, exception);
	}
	
	public BaseLegalValidacionException(String codigo,String message, Exception exception){
		super(codigo, message, exception);
	}
}