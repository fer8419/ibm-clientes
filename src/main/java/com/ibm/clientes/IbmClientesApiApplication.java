package com.ibm.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * Archivo de configuración Spring boot modificado para desplegar web pero
 * tambien funciona autocontenido
 * 
 * @author Edwin Cardona
 *
 */
@SpringBootApplication
public class IbmClientesApiApplication extends SpringBootServletInitializer {

	/**
	 * Metodo principal
	 * 
	 * @param args argumentos de ejecución principal
	 */
	public static void main(String[] args) {
		SpringApplication.run(IbmClientesApiApplication.class, args);
	}

	/**
	 * Agregar message converter para manejo del mapeo de jackson de las propiedades
	 * LAZY
	 * 
	 * https://stackoverflow.com/questions/21708339/avoid-jackson-serialization-on-non-fetched-lazy-objects
	 * https://dzone.com/articles/customizing
	 * https://www.logicbig.com/tutorials/spring-framework/spring-boot/message-converters.html
	 * 
	 * @return MappingJackson2HttpMessageConverter Jackson
	 */
	@Bean
	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

		ObjectMapper mapper = new ObjectMapper();

		// Crear módulo hibernate
		Hibernate5Module modulo = new Hibernate5Module();

		// Habilitar campos transient de entidades
		modulo.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);

		// Registering Hibernate5Module to support lazy objects
		mapper.registerModule(modulo);

		messageConverter.setObjectMapper(mapper);

		return messageConverter;
	}
}
