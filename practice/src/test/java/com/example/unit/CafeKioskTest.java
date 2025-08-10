package com.example.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.unit.beverage.Americano;
import static org.assertj.core.api.AssertionsForClassTypes.*;

class CafeKioskTest {

	@Test
	void add() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		cafeKiosk.add(new Americano());
		Assertions.assertEquals(1, cafeKiosk.getBeverages().size());
	}

	@Test
	void addManualTest() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		cafeKiosk.add(new Americano());
		assertThat(cafeKiosk.getBeverages().getFirst().getName()).isEqualTo("Americano");
		assertThat(cafeKiosk.getBeverages().size()).isEqualTo(1);
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