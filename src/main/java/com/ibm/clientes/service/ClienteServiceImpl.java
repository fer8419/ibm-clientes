/**
 * 
 */
package com.ibm.clientes.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.clientes.persistence.model.Cliente;
import com.ibm.clientes.persistence.repository.ClienteRepository;
import com.ibm.clientes.service.exception.ResourceNotFoundException;

/**
 * Implementacion de lo metodos necesarios para las operaciones requeridas en el
 * cliente
 * 
 * @author Edwin Cardona
 *
 */
@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public List<Cliente> listar() {
		return repository.findAll();
	}

	@Override
	public Cliente consultar(Integer codigo) {
		Optional<Cliente> optCliente = repository.findById(codigo);
		return optCliente.orElseThrow(
				() -> new ResourceNotFoundException(String.format("Cliente con codigo %s no encontrado", codigo)));
	}

	@Transactional
	@Override
	public Integer insertar(@Valid Cliente objNuevo) {
		return repository.save(objNuevo).getCodigo();
	}

	@Transactional
	@Override
	public void actualizar(@Valid Cliente obj) {
		repository.save(obj);
	}

	@Transactional
	@Override
	public void eliminar(Cliente obj) {
		repository.delete(obj);
	}

	@Transactional
	@Override
	public void eliminar(Integer codigo) {
		Cliente cliente = consultar(codigo);
		eliminar(cliente);
	}

}
