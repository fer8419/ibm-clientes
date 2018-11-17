/**
 * 
 */
package com.ibm.clientes.persistence.repository;

import org.springframework.stereotype.Repository;

import com.ibm.clientes.persistence.model.Tarjeta;

/**
 * Repositorio de para operaciones de acceso a datos para la entidad
 * {@link Tarjeta}
 * 
 * @author Edwin Cardona
 *
 */
@Repository
public interface TarjetaRepository extends GenericRepository<Tarjeta, Integer> {

}
