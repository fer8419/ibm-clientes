/**
 * 
 */
package com.ibm.clientes.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ibm.clientes.persistence.model.GenericEntity;

/**
 * Repositorio de spring jpa para las operaciones basicas de cliente. Toma una
 * entidad de la aplicacion y un tipo de dato para la clave primaria,
 * Integer,Long, etc
 * 
 * @author Edwin Cardona
 *
 */
@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity, I> extends JpaRepository<T, I> {

}
