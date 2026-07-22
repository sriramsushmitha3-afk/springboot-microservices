package com.ecommerce.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.products.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
