package br.com.ciceroednilson.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author ciceroednilson
 *
 * Essa classe é apenas para testarmos os tratamentos de erros.
 */
@RestController
@RequestMapping("main")
public class MainControler {

	public MainControler() {
		
	}
	
	/***
	 * Esse método tem como objetivo gerar um erro para ser tratado pela classe que interpreta todas as exceções não tratadas.
	 * Quando ocorrer uma exceção nesse método quem vai tratar a mesma é a classe RestResponseExceptionHandler, através do 
	 * método handleGlobalException.
	 *  
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value= "/executar/{codigo}",method = RequestMethod.GET,  produces = { "application/json"})
	@ResponseBody
	public String executar(@PathVariable("codigo") long codigo){
		
		if(codigo == 0)
			throw new NullPointerException("Erro de NullPointerException");
		else if(codigo == 1)
			throw new RuntimeException("Erro de RuntimeException");
		else if(codigo == 2)
			throw new IllegalArgumentException("Erro de IllegalArgumentException");		
				
		return "Processo executado com sucesso!";
	}
	
	/***
	 * Quando podemos ter uma execeção do tipo que não é tratado na classe RestResponseExceptionHandler, 
	 * a responsabilidade de tratamento deve ser do próprio método
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= "/processar",method = RequestMethod.GET,  produces = { "application/json"})
	@ResponseBody
	public String processar()  throws Exception {
				
		try {
			
			throw new Exception("Erro tratado no próprio método!");
			
		} catch (Exception e) {
			
			throw e;
		}
	}
	
	/***
	 * Tratando uma exceção e retornando o resultado em json
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= "/validar",method = RequestMethod.GET,  produces = { "application/json"})
	@ResponseBody
	public ResponseEntity<Map<String, Object>> validar()  throws Exception {
				
		Map<String, Object> erros = new HashMap<String, Object>();
		
		try {
			
			throw new Exception("Erro tratado no próprio método com response em json!");
			
		} catch (Exception e) {
			
			erros.put("erro", e.getMessage());
			
			return new ResponseEntity<Map<String, Object>>(erros, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
