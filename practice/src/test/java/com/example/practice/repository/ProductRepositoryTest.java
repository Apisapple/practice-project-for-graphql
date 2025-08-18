package com.example.practice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.practice.domain.entity.Product;
import com.example.practice.domain.entity.ProductSellingStatus;
import com.example.practice.domain.entity.ProductType;

@DataJpaTest
@ActiveProfiles("test")
class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void findALlBySellingStatusTest() {
		// given
		Product product = Product.builder()
				.productNumber("0001")
				.type(ProductType.HANDMADE)
				.sellingStatus(ProductSellingStatus.SELLING)
				.name("Americano")
				.price(4000)
				.build();
		productRepository.save(product);

		// when
		var products = productRepository.findAllBySellingStatus(ProductSellingStatus.SELLING);

		// then
		org.assertj.core.api.Assertions.assertThat(products).hasSize(1);
		org.assertj.core.api.Assertions.assertThat(products.get(0).getName()).isEqualTo("Americano");
	}
}