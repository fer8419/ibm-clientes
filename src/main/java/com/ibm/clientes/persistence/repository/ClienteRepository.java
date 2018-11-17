/**
 * 
 */
package com.ibm.clientes.persistence.repository;

import org.springframework.stereotype.Repository;

import com.ibm.clientes.persistence.model.Cliente;

/**
 * Repositorio de para operaciones de acceso a datos para la entidad
 * {@link Cliente}
 * 
 * @author Edwin Cardona
 *
 */
@Repository
public interface ClienteRepository extends GenericRepository<Cliente, Integer> {

}
