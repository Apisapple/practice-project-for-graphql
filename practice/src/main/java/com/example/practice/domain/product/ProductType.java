package com.example.practice.domain.product;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductType {

	HANDMADE("제조 음료"),
	BOTTLE("병 음료"),
	BAKERY("제과");

	private final String description;

	public static boolean containsStockType(ProductType type) {
		return List.of(BOTTLE, BAKERY)
				.contains(type);
	}
}
