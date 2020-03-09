/**
 * 
 */
package com.spring.ereservation.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ereservation.mapper.CustomerMapper;
import com.spring.ereservation.models.Customer;
import com.spring.ereservation.resources.dto.CustomerDTO;
import com.spring.ereservation.services.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

/**
 * Represents customer web service
 * 
 * @RestController es una extensión de @Controller y la particularidad que este
 *                 tiene es que convierte automaticamente Java POJOS a JSON.
 * 
 * @author cristian.perez
 *
 */
@RestController
@RequestMapping("/api/v1/customers")
@Api(tags = "customer") // Anotación para la documentación con Swagger
@RequiredArgsConstructor
public class CustomerResource {
	private final CustomerService customerService;
	private final CustomerMapper customerMapper;
	
	@GetMapping
	@ApiOperation(value = "List all Customers", notes = "Service in order to read all customers")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Customers found successully"),
			@ApiResponse(code = 404, message = "Customers not found") })
	public ResponseEntity<List<Customer>> findAll() {
		return ResponseEntity.ok(customerService.findAll());
	}

	@PostMapping
	// Annotations for swagger documentation
	@ApiOperation(value = "Create Customer", notes = "Service in order to create a new customer")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Customer created successully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
		Customer customer = customerMapper.convertToEntity(customerDTO);
		/* customer.setIdentification(customerDTO.getIdentification());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setAddress(customerDTO.getAddress());
		customer.setEmail(customerDTO.getEmail());
		customer.setPhone(customerDTO.getPhone()); */
		Customer customerCreated = customerService.create(customer);

		return new ResponseEntity<>(customerMapper.convertToDTO(customerCreated), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	// Annotations for swagger documentation
	@ApiOperation(value = "Update Customer", notes = "Service in order to update a customer")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Customer updated successully"),
			@ApiResponse(code = 404, message = "Customer not found") })
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") String id, CustomerDTO customerDTO) {
		Customer customer = this.customerService.findByIdentification(id);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		} else {
			customer.setIdentification(customerDTO.getIdentification());
			customer.setFirstName(customerDTO.getFirstName());
			customer.setLastName(customerDTO.getLastName());
			customer.setAddress(customerDTO.getAddress());
			customer.setEmail(customerDTO.getEmail());
			customer.setPhone(customerDTO.getPhone());
		}

		return new ResponseEntity<>(this.customerService.update(customer), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	// Annotations for swagger documentation
	@ApiOperation(value = "Delete Customer", notes = "Service in order to delete a customer")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Customer deleted successully"),
			@ApiResponse(code = 404, message = "Customer not found") })
	public void deleteCustomer(@PathVariable("id") String id) {
		Customer customer = this.customerService.findByIdentification(id);
		if (customer != null) {
			this.customerService.delete(customer);
		}
	}
}
