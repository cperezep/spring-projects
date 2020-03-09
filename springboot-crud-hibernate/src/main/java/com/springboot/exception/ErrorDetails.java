/**
 * 
 */
package com.springboot.exception;

import java.util.Date;

import lombok.Data;

/**
 * @author cristian.perez
 *
 */
@Data
public class ErrorDetails {
	private String status;
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(String status, Date timestamp, String message, String details) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
}
