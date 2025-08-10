package com.example.unit.beverage;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.*;

class AmericanoTest {

	@Test
	void getNameTest() {
		Americano americano = new Americano();

		assertThat(americano.getName()).isEqualTo("Americano");
	}

	@Test
	void getPriceTest() {
		Americano americano = new Americano();

		assertThat(americano.getPrice()).isEqualTo(4000);
	}
}