package com.ecommerce.products.builder;

import com.ecommerce.products.dto.request.ProductCreateRequest;
import com.ecommerce.products.dto.request.ProductUpdateRequest;
import com.ecommerce.products.dto.response.ProductResponse;
import com.ecommerce.products.model.Product;

public class ProductBuilder {

	public static Product buildProductFromProductCreateRequest(ProductCreateRequest productCreateRequest) {
		
		return Product.builder()
				.productName(productCreateRequest.getProductName())
				.brand(productCreateRequest.getBrand())
				.description(productCreateRequest.getDescription())
				.price(productCreateRequest.getPrice())
				.rating(productCreateRequest.getRating())
				.build();
		
		
	}

	public static ProductResponse buildProductResponseFromProduct(Product savedProduct) {
		
		return ProductResponse.builder()
						.productId(savedProduct.getProductId())
						.productName(savedProduct.getProductName())
						.brand(savedProduct.getBrand())
						.description(savedProduct.getDescription())
						.price(savedProduct.getPrice())
						.rating(savedProduct.getRating())
						.build();

	}

	public static Product buildProductFromProductUpdateRequest(Product existingProduct, ProductUpdateRequest productUpdateRequest) {
		return Product.builder()
						.productId(existingProduct.getProductId())
						.productName(productUpdateRequest.getProductName())
						.brand(productUpdateRequest.getBrand())
						.description(productUpdateRequest.getDescription())
						.price(productUpdateRequest.getPrice())
						.rating(productUpdateRequest.getRating())
						.build();	
	}

}
