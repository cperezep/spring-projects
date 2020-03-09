/**
 * 
 */
package com.spring.ereservation.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ereservation.models.Customer;

/**
 * Interface in order to define DB operations belong to Customer
 * 
 * Los repositorios manejan transacciones a la base de datos. Los services se
 * encargan de manejar la logica de tu negocio. Los controllers usualmente
 * sirven la información que se muestra al usuario.
 * 
 * @author cristian.perez
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

	public List<Customer> findByLastName(String lastName);

	public Customer findByIdentification(String identification);

}
