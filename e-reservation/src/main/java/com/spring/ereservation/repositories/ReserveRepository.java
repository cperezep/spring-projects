/**
 * 
 */
package com.spring.ereservation.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.ereservation.models.Reserve;

/**
 * @author cristian.perez
 *
 */
public interface ReserveRepository extends JpaRepository<Reserve, UUID> {

	// Query on JPQL(Java Persistence Query Language)
	@Query("Select r from Reserve r where r.dateIn >=: dateStart and r.dateOut <=: dateEnd")
	public List<Reserve> find(@Param("dateStart") Date dateStart, @Param("dateEnd") Date dateEnd);

}
