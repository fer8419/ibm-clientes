/**
 * 
 */
package com.ibm.clientes.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entidad para el modelo Clientes
 * 
 * @author Edwin Cardona
 *
 */
@Entity
@Table(name = "CLI_CLIENTES")
public class Cliente implements GenericEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO", unique = true, nullable = false)
	private int codigo;

	@NotEmpty
	@Size(max = 50)
	@Column(name = "NV_NOMBRE", nullable = false, length = 50)
	private String nombre;

	@NotEmpty
	@Size(max = 100)
	@Column(name = "NV_DIRECCION", nullable = false, length = 100)
	private String direccion;

	@NotEmpty
	@Size(max = 30)
	@Column(name = "NV_CIUDAD", nullable = false, length = 30)
	private String ciudad;

	@NotNull
	@Digits(integer = 20, fraction = 0)
	@Column(name = "IN_TELEFONO", nullable = false, precision = 20)
	private Long telefono;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Tarjeta> tarjetas = new ArrayList<>(0);

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

}
