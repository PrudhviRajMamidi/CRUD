package com.crud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.entity.Product;
import com.crud.api.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.addProducts(products);
	}
	
	@GetMapping("/products")
	public List<Product> findProducts() {
		return service.getProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	
	@GetMapping("/product/{name}")
	public Product findProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteProducts() {
		return service.deleteAllProducts();
	}
	
}
