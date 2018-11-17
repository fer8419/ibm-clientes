/**
 * 
 */
package com.ibm.clientes.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entidad para el modelo Tarjetas
 * 
 * @author Edwin Cardona
 *
 */
@Entity
@Table(name = "CLI_TARJETAS")
public class Tarjeta implements GenericEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO", unique = true, nullable = false)
	private int codigo;

	@NotEmpty
	@Size(max = 19, min = 19)
	@Column(name = "NV_NUMERO", nullable = false, length = 19)
	private String numero;

	@NotNull
	@Min(100)
	@Max(9999)
	@Column(name = "IN_CCV", nullable = false, precision = 4)
	private Short ccv;

	@NotEmpty
	@Size(max = 50)
	@Column(name = "NV_TIPO", nullable = false, length = 50)
	private String tipo;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "IN_CODIGO_CLIENTE", nullable = false)
	@JsonBackReference
	private Cliente cliente;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Short getCcv() {
		return ccv;
	}

	public void setCcv(Short ccv) {
		this.ccv = ccv;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
