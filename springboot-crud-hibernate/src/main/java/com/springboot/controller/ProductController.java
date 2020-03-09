/**
 * 
 */
package com.springboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Product;
import com.springboot.service.ProductService;

import lombok.RequiredArgsConstructor;

/**
 * @author cristian.perez
 *
 */
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping
	ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok().body(productService.getAllProduct());
	}

	@GetMapping("/{id}")
	ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productService.getProductById(id));
	}

	@PostMapping
	ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.ok().body(this.productService.createProduct(product));
	}

	@PutMapping("/{id}")
	ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		product.setId(id);
		return ResponseEntity.ok().body(this.productService.updateProduct(product));
	}

	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		this.productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}

}
