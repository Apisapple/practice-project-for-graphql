package com.example.unit;

import java.time.LocalDateTime;

import com.example.unit.beverage.Americano;
import com.example.unit.beverage.Latte;
import com.example.unit.order.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CafeKioskRunner {

	public static void main(String[] args) {
		CafeKiosk cafeKiosk = new CafeKiosk();
		cafeKiosk.add(new Americano());

		log.info(">>Added beverage: Americano");

		cafeKiosk.add(new Latte());
		log.info(">>Added beverage: Latte");

		int totalPrice = cafeKiosk.calculateTotalPrice();

		log.info(">>Total price: {}", totalPrice);

		Order order = cafeKiosk.createOrder(LocalDateTime.now());
		log.info(">>Created order: {}", order);
	}
}
