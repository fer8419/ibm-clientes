package com.ibm.clientes.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ibm.clientes.persistence.model.Cliente;
import com.ibm.clientes.persistence.model.Tarjeta;
import com.ibm.clientes.persistence.repository.TarjetaRepository;
import com.ibm.clientes.service.exception.BusinessException;

@RunWith(MockitoJUnitRunner.class)
public class TarjetaServiceImplTest {

	@Mock
	private TarjetaRepository repository;
	@InjectMocks
	private TarjetaServiceImpl service;

	@Test
	public void insertarTest() {
		Tarjeta tarjeta = crearTarjeta();
		Tarjeta tarjetaPersist = crearTarjeta();
		tarjetaPersist.setCodigo(1);
		Mockito.when(repository.save(tarjeta)).thenReturn(tarjetaPersist);

		Integer codigo = service.insertar(tarjeta);

		Assert.assertNotNull(codigo);
		Assert.assertTrue(codigo > 0);
	}

	@Test(expected = BusinessException.class)
	public void insertarErrorTest() {
		Tarjeta tarjeta = crearTarjeta();
		tarjeta.setNumero("1234 5678 9123");

		service.insertar(tarjeta);
	}

	@Test(expected = BusinessException.class)
	public void insertarError2Test() {
		Tarjeta tarjeta = crearTarjeta();
		tarjeta.setNumero("1234 5678   9123");

		service.insertar(tarjeta);
	}

	private Tarjeta crearTarjeta() {
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setNumero("1234 5678 9123 4567");
		tarjeta.setCcv((short)123);
		tarjeta.setTipo("debito");
		tarjeta.setCliente(new Cliente());

		return tarjeta;
	}
}
