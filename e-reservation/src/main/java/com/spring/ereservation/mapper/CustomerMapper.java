/**
 * 
 */
package com.spring.ereservation.mapper;

import org.modelmapper.ModelMapper;

import com.spring.ereservation.models.Customer;
import com.spring.ereservation.resources.dto.CustomerDTO;

/**
 * @author cristian.perez
 *
 */
public class CustomerMapper {
	
	private ModelMapper modelMapper;
	
	public CustomerMapper() {
		modelMapper = new ModelMapper();
	}
	
	public Customer convertToEntity(CustomerDTO customerDTO) {
	    Customer customer = modelMapper.map(customerDTO, Customer.class);
	    
	    return customer;
	}
	
	public CustomerDTO convertToDTO(Customer customer) {
	    CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
	    
	    return customerDTO;
	}
}
