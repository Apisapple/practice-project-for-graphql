package com.example.practice.api.service.order;

import com.example.practice.api.controller.order.request.OrderCreateRequest;
import com.example.practice.api.service.order.response.OrderResponse;
import com.example.practice.domain.order.Order;
import com.example.practice.domain.order.OrderRepository;
import com.example.practice.domain.product.Product;
import com.example.practice.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;

	public OrderResponse createOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
		List<String> productNumbers = request.getProductNumbers();
		List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);

		Order order = Order.create(products, registeredDateTime);
		Order savedOrder = orderRepository.save(order);
		return OrderResponse.of(savedOrder);
	}
}
