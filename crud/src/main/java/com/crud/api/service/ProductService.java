package com.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.entity.Product;
import com.crud.api.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product addProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> addProducts(List<Product> products) {
		return repository.saveAll(products); 
	}
	
	public List<Product> getProducts() {
		return repository.findAll();
	}

	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	
	public List<Product> getProductsByName(String name) {
		return repository.findAllByName(name);
	}
	
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product removed "+id;
	}

	public String deleteAllProducts() {
		repository.deleteAll();
		return "All products removed..";
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
}
