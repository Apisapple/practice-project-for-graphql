package com.example.unit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.unit.beverage.Beverage;
import com.example.unit.order.Order;

import lombok.Getter;

@Getter
public class CafeKiosk {

	private List<Beverage> beverages = new ArrayList<>();

	public void add(Beverage beverage) {
		beverages.add(beverage);
	}

	public void remove(Beverage beverage) {
		beverages.remove(beverage);
	}

	public void clear() {
		beverages.clear();
	}

	public int calculateTotalPrice() {
		return this.beverages.stream().mapToInt(Beverage::getPrice).sum();
	}

	public Order createOrder() {
		return new Order(LocalDateTime.now(), beverages);
	}
}
