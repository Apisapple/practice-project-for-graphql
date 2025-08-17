package com.example.practice.api.service.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.practice.api.service.product.response.ProductResponse;
import com.example.practice.domain.entity.Product;
import com.example.practice.domain.entity.ProductSellingType;
import com.example.practice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<ProductResponse> getSellingProducts() {

    List<Product> products = productRepository.findBySellingTypeIn(ProductSellingType.forDisplay());

    return products.stream()
        .map(ProductResponse::of)
        .toList();
  }
}
