/**
 * 
 */
package com.ibm.clientes.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.clientes.persistence.model.Cliente;
import com.ibm.clientes.persistence.model.Tarjeta;
import com.ibm.clientes.service.ClienteService;
import com.ibm.clientes.service.TarjetaService;

/**
 * Controlador rest para el servicio de cliente y tarjetas asociadas
 * 
 * @author Edwin Cardona
 *
 */
@RestController
@RequestMapping("/ibm-clientes/api")
@CrossOrigin
public class AdminClienteController {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private TarjetaService tarjetaService;

	/**
	 * Listar clientes
	 * @return lista de tipo {@link Cliente} y status http
	 */
	@GetMapping("/cliente")
	public ResponseEntity<List<Cliente>> listarClientes() {
		return new ResponseEntity<>(clienteService.listar(), HttpStatus.OK);
	}
	
	/**
	 * Consultar cliente por codigo
	 * @return objeto tipo {@link Cliente} y status http
	 */
	@GetMapping("/cliente/{codigo}")
	public ResponseEntity<Cliente> consultarCliente(@PathVariable Integer codigo) {
		return new ResponseEntity<>(clienteService.consultar(codigo), HttpStatus.OK);
	}
	
	/**
	 * Insertar nuevo cliente
	 * @param cliente datos del {@link Cliente}
	 * @return https status de la operacion
	 */
	@PostMapping("/cliente")
	public ResponseEntity<HttpStatus> crearCliente(@Valid @RequestBody Cliente cliente) {
		clienteService.insertar(cliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	/**
	 * Actualizar cliente
	 * @param cliente datos del {@link Cliente}
	 * @return https status de la operacion
	 */
	@PutMapping("/cliente")
	public ResponseEntity<HttpStatus> actualizarCliente(@Valid @RequestBody Cliente cliente) {
		clienteService.actualizar(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Eliminar cliente
	 * @param codigo codigo del cliente
	 * @return https status de la operacion
	 */
	@DeleteMapping("/cliente/{codigo}")
	public ResponseEntity<HttpStatus> eliminarCliente(@PathVariable Integer codigo) {
		clienteService.eliminar(codigo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Insertar nueva tarjeta
	 * @param cliente datos del {@link Tarjeta}
	 * @return https status de la operacion
	 */
	@PostMapping("/tarjeta")
	public ResponseEntity<HttpStatus> crearTarjeta(@Valid @RequestBody Tarjeta tarjeta) {
		tarjetaService.insertar(tarjeta);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	/**
	 * Actualizar tarjeta
	 * @param tarjeta datos del {@link Tarjeta}
	 * @return https status de la operacion
	 */
	@PutMapping("/tarjeta")
	public ResponseEntity<HttpStatus> actualizarTarjeta(@Valid @RequestBody Tarjeta tarjeta) {
		tarjetaService.actualizar(tarjeta);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Eliminar tarjeta
	 * @param codigo codigo de la tarjeta
	 * @return https status de la operacion
	 */
	@DeleteMapping("/tarjeta/{codigo}")
	public ResponseEntity<HttpStatus> eliminarTarjeta(@PathVariable Integer codigo) {
		tarjetaService.eliminar(codigo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
