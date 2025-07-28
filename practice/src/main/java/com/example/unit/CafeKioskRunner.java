package com.example.unit;

import com.example.unit.beverage.Americano;
import com.example.unit.beverage.Latte;

public class CafeKioskRunner {

	public static void main(String[] args) {
		CafeKiosk cafeKiosk = new CafeKiosk();
		cafeKiosk.add(new Americano());

		System.out.println(">>Added beverage: Americano");

		cafeKiosk.add(new Latte());
		System.out.println(">>Added beverage: Latte");

		int totalPrice = cafeKiosk.calculateTotalPrice();

		System.out.printf(">>Total price: %d", totalPrice);
	}
}
