/**
 * 
 */
package com.ibm.clientes.service;

import java.util.List;

import com.ibm.clientes.service.exception.ResourceNotFoundException;

/**
 * Interfaz para declarar los metodos de operaciones crud
 * 
 * @author Edwin Cardona
 *
 */
public interface GenericCrudService<T> {

	/**
	 * Listar todos los registros de T
	 * 
	 * @return Lista de tipo {@linkplain T}
	 */
	List<T> listar();

	/**
	 * Consultar un registro en base al codigo
	 * 
	 * @param codigo clave primaria
	 * @return objeto de tipo {@link T}
	 * @throws ResourceNotFoundException si no existe entidad para el codigo
	 *                                   indicado
	 */
	T consultar(Integer codigo);

	/**
	 * Insertar nuevo registro
	 * 
	 * @param objNuevo objeto a insertar
	 * @return clave primaria generada
	 */
	Integer insertar(T objNuevo);

	/**
	 * Actualiza un registro existente
	 * 
	 * @param obj objeto a actualizar
	 */
	void actualizar(T obj);

	/**
	 * Eliminar registro existente
	 * 
	 * @param obj objeto a eliminar
	 * @throws ResourceNotFoundException si no existe entidad para el codigo
	 *                                   indicado
	 */
	void eliminar(T obj);

	/**
	 * Eliminar registro existente
	 * 
	 * @param codigo clave primaria del objeto a eliminar
	 */
	void eliminar(Integer codigo);
}
