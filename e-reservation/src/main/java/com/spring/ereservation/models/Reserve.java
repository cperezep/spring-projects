/**
 * 
 */
package com.spring.ereservation.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author cristian.perez
 *
 */
@Data // Gets and Sets
@Entity // Defines that a class can be mapped to a table
@Table(name = "reserve")
public class Reserve {
	@Id
	@GeneratedValue
	private UUID id;

	@Temporal(TemporalType.DATE)
	private Date dateIn;

	@Temporal(TemporalType.DATE)
	private Date dateOut;

	private int numberPeople;
	private String description;

	@ManyToOne
	@JoinColumn(name = "idCustomer", nullable = false)
	private Customer customer;
}
