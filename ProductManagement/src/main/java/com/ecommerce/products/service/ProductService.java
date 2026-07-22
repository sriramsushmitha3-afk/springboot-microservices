package com.ecommerce.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.products.builder.ProductBuilder;
import com.ecommerce.products.dao.ProductRepository;
import com.ecommerce.products.dto.request.ProductCreateRequest;
import com.ecommerce.products.dto.request.ProductUpdateRequest;
import com.ecommerce.products.dto.response.ProductResponse;
import com.ecommerce.products.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRespository;

	
	
	public ProductResponse saveProduct(ProductCreateRequest productCreateRequest) {
		
		Product product = ProductBuilder.buildProductFromProductCreateRequest(productCreateRequest);
		Product savedProduct = productRespository.save(product);
		ProductResponse productResponseFromProduct = ProductBuilder.buildProductResponseFromProduct(savedProduct);
		return productResponseFromProduct;
	}
	
	public List<ProductResponse> getAllProducts(){
		
		return productRespository.findAll()
						.stream()
						.map(ProductBuilder::buildProductResponseFromProduct)
						.toList();
		
	}

	public ProductResponse getProductById(long productId) {
		Product product = productRespository.findById(productId).orElseThrow(()->new RuntimeException("Product not found with id: "+productId));
		return ProductBuilder.buildProductResponseFromProduct(product);
	}

	public ProductResponse updateProductById(long productId, ProductUpdateRequest productUpdateRequest) {
		Product existingProduct = productRespository.findById(productId).orElseThrow(()->new RuntimeException("Product not found with id: "+productId));
		Product product = ProductBuilder.buildProductFromProductUpdateRequest(existingProduct, productUpdateRequest);
		Product savedProduct = productRespository.save(product);
		ProductResponse productResponseFromProduct = ProductBuilder.buildProductResponseFromProduct(savedProduct);
		
		return productResponseFromProduct;
	}

	public void deleteProductById(long productId) {
		if(!productRespository.existsById(productId)) {
			throw new RuntimeException("Product not found with Id:"+productId);
		}
		productRespository.deleteById(productId);
	}
	
	
	

}
