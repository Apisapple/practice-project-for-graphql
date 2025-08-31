package com.example.practice.api.controller.product;

import com.example.practice.api.ApiResponse;
import com.example.practice.api.controller.product.dto.request.ProductCreateRequest;
import jakarta.validation.Valid;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.api.service.product.ProductService;
import com.example.practice.api.service.product.response.ProductResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping("api/v1/products/selling")
	public List<ProductResponse> getSellingProducts() {
		return productService.getSellingProducts();
	}

	@PostMapping("api/v1/products/new")
	public ApiResponse<ProductResponse> createProduct(@Valid @RequestBody ProductCreateRequest request) {
		return ApiResponse.of(HttpStatus.OK, HttpStatus.OK.name(), productService.createProduct(request));
	}
}
