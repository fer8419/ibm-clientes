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

import com.ibm.clientes.persistence.model.Tarjeta;
import com.ibm.clientes.persistence.repository.TarjetaRepository;
import com.ibm.clientes.service.exception.BusinessException;
import com.ibm.clientes.service.exception.ResourceNotFoundException;

/**
 * Implementacion de lo metodos necesarios para las operaciones requeridas en
 * las tarjetas
 * 
 * @author Edwin Cardona
 *
 */
@Service("tarjetaService")
public class TarjetaServiceImpl implements TarjetaService {

	@Autowired
	private TarjetaRepository repository;

	@Override
	public List<Tarjeta> listar() {
		return repository.findAll();
	}

	@Override
	public Tarjeta consultar(Integer codigo) {
		Optional<Tarjeta> optCliente = repository.findById(codigo);
		return optCliente.orElseThrow(
				() -> new ResourceNotFoundException(String.format("Tarjeta con codigo %s no encontrado", codigo)));
	}

	@Transactional
	@Override
	public Integer insertar(@Valid Tarjeta objNuevo) {
		validarNumero(objNuevo.getNumero());
		return repository.save(objNuevo).getCodigo();
	}

	@Transactional
	@Override
	public void actualizar(@Valid Tarjeta obj) {
		validarNumero(obj.getNumero());
		repository.save(obj);
	}

	@Transactional
	@Override
	public void eliminar(Tarjeta obj) {
		repository.delete(obj);
	}

	@Transactional
	@Override
	public void eliminar(Integer codigo) {
		repository.deleteById(codigo);
	}

	/**
	 * Validar numero de tarjeta
	 * 
	 * @param numero numero de la tarjeta
	 * @throws BusinessException si el formato de numero de la tarjeta es invalido
	 */
	private void validarNumero(String numero) {
		String[] bloques = numero.split(" ");
		if (bloques.length != 4) {
			throw new BusinessException("Formato de numero de tarjeta invalido");
		}
	}

}
