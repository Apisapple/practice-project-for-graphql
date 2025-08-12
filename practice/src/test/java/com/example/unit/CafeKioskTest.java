package com.example.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.unit.beverage.Americano;
import com.example.unit.order.Order;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.time.LocalDateTime;

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
	void addSeveralBeverage() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		Americano americano = new Americano();

		cafeKiosk.add(americano);

		assertThat(cafeKiosk.getBeverages().size()).isEqualTo(1);
	}

	@Test
	void createOrderOpenTime() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		cafeKiosk.add(new Americano());

		Order order = cafeKiosk.createOrder(LocalDateTime.of(2025, 8, 13, 10, 0));

		assertThat(order).isNotNull();
		assertThat(order.getBeverages().get(0).getName()).isEqualTo("Americano");
	}

	@Test
	void createOrderOutsideOpenTime() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		cafeKiosk.add(new Americano());

		assertThatThrownBy(() -> cafeKiosk.createOrder(LocalDateTime.of(2025, 8, 13, 9, 59)))
				.isInstanceOf(IllegalStateException.class)
				.hasMessage("The shop is closed.");
	}
}