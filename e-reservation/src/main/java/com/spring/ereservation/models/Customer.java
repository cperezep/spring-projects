/**
 * 
 */
package com.spring.ereservation.models;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

/**
 * @author cristian.perez
 *
 */
@Data // Gets and Sets
@Entity // Defines that a class can be mapped to a table
@Table(name = "customer")
//Query on JPQL, ?1 -> first parameter (Native Query)
@NamedQuery(name = "Customer.findByIdentification", query = "Select c from Customer c where c.identification = ?1")
public class Customer {
	@Id
	@GeneratedValue
	private UUID id;

	private String identification;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	
	@CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

	@OneToMany(mappedBy = "customer")
	private Set<Reserve> reserves;
}
