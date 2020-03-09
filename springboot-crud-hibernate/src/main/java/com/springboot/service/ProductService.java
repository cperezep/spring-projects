/**
 * 
 */
package com.springboot.service;

import java.util.List;

import com.springboot.model.Product;

/**
 * @author cristian.perez
 *
 */
public interface ProductService {

	Product createProduct(Product product);

	Product updateProduct(Product product);

	List<Product> getAllProduct();

	Product getProductById(long id);

	void deleteProduct(long id);
}
