package com.example.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.unit.beverage.Americano;

class CafeKioskTest {

	@Test
	void add() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		cafeKiosk.add(new Americano());
		Assertions.assertEquals(1, cafeKiosk.getBeverages().size());
	}

	@Test
	void remove() {
	}

	@Test
	void clear() {
	}

	@Test
	void calculateTotalPrice() {
	}

	@Test
	void createOrder() {
	}
}