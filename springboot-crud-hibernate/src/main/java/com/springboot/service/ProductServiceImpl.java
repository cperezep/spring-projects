/**
 * 
 */
package com.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Product;
import com.springboot.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author cristian.perez
 *
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		
		Product productUpdate = productRepository.findById(product.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + product.getId()));

		productUpdate.setId(product.getId());
		productUpdate.setName(product.getName());
		productUpdate.setDescription(product.getDescription());
		productUpdate.setPrice(product.getPrice());
		productRepository.save(productUpdate);

		return productUpdate;		
	}

	@Override
	public void deleteProduct(long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

		productRepository.delete(product);
	}
}
