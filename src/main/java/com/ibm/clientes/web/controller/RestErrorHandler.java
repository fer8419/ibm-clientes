package com.ibm.clientes.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ibm.clientes.service.exception.BusinessException;
import com.ibm.clientes.service.exception.ResourceNotFoundException;

/**
 * Clase para manejar las excepciones de la aplicación
 * 
 * @author Edwin Cardona
 *
 */
@RestControllerAdvice
public class RestErrorHandler {

	private static Logger logger = LoggerFactory.getLogger(RestErrorHandler.class);

	/**
	 * Manejar excepciones de recursos no encontrados
	 * 
	 * @param ex excepciones
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> manejarExcepcionNoEncontrado(ResourceNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * Manejar excepciones de negocio
	 * 
	 * @param ex excepciones
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> manejarExcepcionNegocio(BusinessException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
	}

	/**
	 * Manejar excepciones de validaciones de longitud, obligatoriedad, formato
	 * 
	 * @param ex excepciones
	 * @return ResponseEntity<CustomResponseType>
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> manejarExcepcionDatos(MethodArgumentNotValidException ex) {
		return new ResponseEntity<>("Valide los campos", HttpStatus.CONFLICT);
	}

	/**
	 * Manejar excepciones de error interno del servidor
	 * 
	 * @param ex excepcion
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<String> manejarExcepcionServidor(Exception ex) {
		String mensaje = "Ha sucedido un error no controlado en la aplicacion";
		logger.error(mensaje, ex);
		return new ResponseEntity<>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
