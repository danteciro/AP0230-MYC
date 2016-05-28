package gob.osinergmin.myc.service.exception;
/**
 * 
 * @author gvillanueva
 */
public class BaseLegalException extends BaseException{
	
	public BaseLegalException(String message){
		super(message);
	}
	
	public BaseLegalException(String message, Exception exception){
		super(message, exception);
	}
	
	public BaseLegalException(String codigo,String message, Exception exception){
		super(codigo, message, exception);
	}
}