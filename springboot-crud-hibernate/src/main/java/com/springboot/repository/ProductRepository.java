/**
 * 
 */
package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Product;

/**
 * @author cristian.perez
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
