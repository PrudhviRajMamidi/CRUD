package com.crud.api.repository;

import com.crud.api.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	Product findByName(String name);

	List<Product> findAllByName(String name);

	
}
