package com.ibm.clientes.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibm.clientes.persistence.model.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteServiceIntegracionTest {

	@Autowired
	private ClienteService service;

	private static Integer codigoGenerado;
	
	@BeforeClass
	public static void init() {
		System.out.println("inicio");
	}
	
	@Before
	public void before() {
		System.out.println("before");
	}

	@Test
	public void t1InsertarTest() {
		codigoGenerado = service.insertar(crearCliente());

		Assert.assertNotNull(codigoGenerado);
		Assert.assertTrue(codigoGenerado > 0);
	}

	@Test
	public void t2ListarTest() {
		List<Cliente> clientes = service.listar();

		Assert.assertNotNull(clientes);
		Assert.assertFalse(clientes.isEmpty());
	}

	@Test
	public void t3ConsultarTest() {
		Cliente cliente = service.consultar(codigoGenerado);

		Assert.assertNotNull(cliente);
	}
	
	@Test
	public void t4EliminarTest() {
		service.eliminar(codigoGenerado);

		List<Cliente> clientes = service.listar();

		Assert.assertNotNull(clientes);
		Assert.assertFalse(clientes.stream().anyMatch(cliente -> codigoGenerado.equals(cliente.getCodigo())));
	}

	private Cliente crearCliente() {
		Cliente cliente = new Cliente();
		cliente.setCiudad("Medellin");
		cliente.setDireccion("abc123");
		cliente.setNombre("Edwin");
		cliente.setTelefono(123456L);
		return cliente;
	}
}
