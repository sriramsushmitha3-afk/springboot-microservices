package com.ecommerce.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.products.dto.request.ProductCreateRequest;
import com.ecommerce.products.dto.request.ProductUpdateRequest;
import com.ecommerce.products.dto.response.ProductResponse;
import com.ecommerce.products.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping
	public ProductResponse saveProduct(@RequestBody ProductCreateRequest productCreateRequest) {
		return productService.saveProduct(productCreateRequest);
		
	}
	
	@GetMapping
	public List<ProductResponse> getAllProducts(){
		return productService.getAllProducts();
		
	}
	
	@GetMapping("/{productId}")
	public ProductResponse getProductById(@PathVariable long productId) {
		
		return productService.getProductById(productId);
		
	}
	
	@PutMapping("/{productId}")
	public ProductResponse updateProductById(@PathVariable long productId, @RequestBody ProductUpdateRequest productUpdateRequest) {
		return productService.updateProductById(productId, productUpdateRequest);
		
	}
	
	@DeleteMapping("/{productId}")
	public void deleteProductById(@PathVariable long productId) {
		 productService.deleteProductById(productId);
	}
}
