/**
 * 
 */
package com.spring.ereservation.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.ereservation.models.Customer;
import com.spring.ereservation.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

/**
 * Class defines the service customer.
 * 
 * Las transacciones son el conjunto de operaciones que afectan la base de datos
 * (create, updates o deletes, no se recomienda realizar consultas de solo
 * lectura) y se ejecutan en bloque, es decir, se ejecutan todas con éxito
 * (commit) o no ejecutamos ninguna (rollback). Las transacciones empiezan y
 * terminan a nivel de servicio y nunca a nivel de capa de datos, para indicar
 * que una clase o método será transaccional utilizamos la
 * anotación @Transactional.
 * 
 * Si el metodo @Transactional tiene varias transacciones y alguna de ellas
 * falla entonces daria rollback a todas las transacciones ejecutadas
 * previamente del mismo metodo.
 * 
 * @author cristian.perez
 *
 */
@Service

// @Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerService {
	private final CustomerRepository customerRepository;

	/**
	 * Method for saving a customer
	 * 
	 * @param customer
	 * @return
	 */
	@Transactional
	public Customer create(Customer customer) {
		return this.customerRepository.save(customer);
	}

	/**
	 * Method for finding a customer by id
	 * 
	 * @param identification
	 * @return
	 */
	public Customer findByIdentification(String identification) {
		return this.customerRepository.findByIdentification(identification);
	}

	/**
	 * Method for updating a customer
	 * 
	 * @param customer
	 * @return
	 */
	@Transactional
	public Customer update(Customer customer) {
		return this.customerRepository.save(customer);
	}

	/**
	 * Method for deleting a customer
	 * 
	 * @param customer
	 */
	@Transactional
	public void delete(Customer customer) {
		this.customerRepository.delete(customer);
	}
	
	/**
	 * Mehod for getting all customers
	 * @return
	 */
	public List<Customer> findAll() {
		return this.customerRepository.findAll();
	}
}
