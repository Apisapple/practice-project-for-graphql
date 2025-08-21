package com.example.practice.domain.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductType {

  HANDMADE("제조 음료"),
  BOTTLE("병 음료"),
  BAKERY("제과");

  private final String description;
}
