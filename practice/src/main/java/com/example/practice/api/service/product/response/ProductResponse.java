package com.example.practice.api.service.product.response;

import com.example.practice.domain.entity.Product;
import com.example.practice.domain.entity.ProductSellingType;
import com.example.practice.domain.entity.ProductType;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponse {

  private Long id;

  private String productNumber;

  private ProductType type;

  private ProductSellingType sellingType;

  private String name;

  private int price;

  @Builder
  private ProductResponse(Long id, String productNumber, ProductType type, ProductSellingType sellingType, String name,
      int price) {
    this.id = id;
    this.productNumber = productNumber;
    this.type = type;
    this.sellingType = sellingType;
    this.name = name;
    this.price = price;
  }

  public static ProductResponse of(Product product) {
    return ProductResponse.builder()
        .id(product.getId())
        .productNumber(product.getProductNumber())
        .type(product.getType())
        .sellingType(product.getSellingType())
        .name(product.getName())
        .price(product.getPrice())
        .build();
  }
}
