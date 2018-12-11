package br.com.ciceroednilson.global.exception;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @author ciceroednilson
 * 
 * 
 * Essa classe tem como objetivo receber todas as exceções não tratadas no sistema para as exceptions abaixo.
 *
 *	NullPointerException.class 
 *	RuntimeException.class
 *	IllegalArgumentException.class
 */
@ControllerAdvice
public class RestResponseExceptionHandler {

	public RestResponseExceptionHandler() {
		
	}
	
	/**
	 * Método que vai tratar as execeções que ocorrerão no sistema
	 * 
	 * Execeções que o método espera
	 * NullPointerException.class
	 * RuntimeException.class
	 * IllegalArgumentException.class
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = {NullPointerException.class, RuntimeException.class, IllegalArgumentException.class})
	protected ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex) {
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		Hashtable<String, String> erros =  new Hashtable<>();
		
		if(ex.getClass().equals(NullPointerException.class)){
		
			erros.put("erro", "00");
			erros.put("detalhe", ex.getMessage());
		}
		else if(ex.getClass().equals(RuntimeException.class)){

			erros.put("erro", "01");
			erros.put("detalhe", ex.getMessage());
		}
		else{
			
			erros.put("erro", "02");
			erros.put("detalhe", ex.getMessage());
		}
		
		response.put("erros", erros);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
