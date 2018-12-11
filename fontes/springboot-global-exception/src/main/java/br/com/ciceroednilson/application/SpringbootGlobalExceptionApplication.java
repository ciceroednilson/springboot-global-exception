package br.com.ciceroednilson.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com.ciceroednilson.*"})
public class SpringbootGlobalExceptionApplication {

	/**
	 * start da aplicação com o tomcat embed.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootGlobalExceptionApplication.class, args);
	}
}
