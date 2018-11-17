package com.ibm.clientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ibm.clientes.persistence.model.Cliente;
import com.ibm.clientes.persistence.repository.ClienteRepository;
import com.ibm.clientes.service.exception.ResourceNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceImplTest {

	@Mock
	private ClienteRepository repository;
	@InjectMocks
	private ClienteServiceImpl service;

	@Test
	public void listarTest() {
		Mockito.when(repository.findAll()).thenReturn(obtenerListaClientes());

		List<Cliente> clientes = service.listar();

		Assert.assertNotNull(clientes);
		Assert.assertFalse(clientes.isEmpty());
	}
	
	@Test
	public void consultarTest() {
		int codigo = 1;
		Optional<Cliente> optCliente = Optional.of(crearCliente());
		Mockito.when(repository.findById(codigo)).thenReturn(optCliente);

		Cliente cliente = service.consultar(codigo);

		Assert.assertNotNull(cliente);
		Assert.assertEquals(codigo, cliente.getCodigo());
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void consultarErrorTest() {
		int codigo = 2;
		Optional<Cliente> optCliente = Optional.empty();
		Mockito.when(repository.findById(codigo)).thenReturn(optCliente);

		service.consultar(codigo);
	}

	private List<Cliente> obtenerListaClientes() {
		List<Cliente> clientes = new ArrayList<>(1);
		Cliente cliente = crearCliente();
		clientes.add(cliente);
		return clientes;
	}

	private Cliente crearCliente() {
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setCiudad("Medellin");
		cliente.setDireccion("abc123");
		cliente.setNombre("Edwin");
		cliente.setTelefono(123456L);
		return cliente;
	}
}
