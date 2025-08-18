package com.example.practice.domain.entity;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductSellingStatus {

  SELLING("판매중"),
  HOLD("보류중"),
  STOP_SELLING("판매중지");

  private final String description;

	public static List<ProductSellingStatus> forDisplay() {
    return List.of(SELLING, HOLD);
  }
}
