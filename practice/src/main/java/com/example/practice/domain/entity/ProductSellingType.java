package com.example.practice.domain.entity;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductSellingType {

  SELLING("판매중"),
  HOLD("보류중"),
  STOP_SELLING("판매중지");

  private final String description;

  public static List<ProductSellingType> forDisplay() {
    return List.of(SELLING, HOLD);
  }
}
