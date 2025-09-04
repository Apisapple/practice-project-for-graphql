package com.example.practice.api.service.order;

import com.example.practice.api.service.order.request.OrderCreateServiceRequest;
import com.example.practice.api.service.order.response.OrderResponse;
import com.example.practice.domain.order.Order;
import com.example.practice.domain.order.OrderRepository;
import com.example.practice.domain.product.Product;
import com.example.practice.domain.product.ProductType;
import com.example.practice.domain.stock.Stock;
import com.example.practice.domain.stock.StockRepository;
import com.example.practice.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;
	private final StockRepository stockRepository;

	/**
	 * 재고 문제 -> 동시성 고민 필요
	 * optimistic lock / pessimistic lock / ...
	 */
    public OrderResponse createOrder(OrderCreateServiceRequest request,
        LocalDateTime registeredDateTime) {
		List<String> productNumbers = request.getProductNumbers();
		List<Product> products = findProductsBy(productNumbers);

		deductStockQuantities(products);

		Order order = Order.create(products, registeredDateTime);
		Order savedOrder = orderRepository.save(order);
		return OrderResponse.of(savedOrder);
	}

	private void deductStockQuantities(List<Product> products) {
		List<String> stockProductNumbers = extractStockProductNumbers(products);

		Map<String, Stock> stockMap = createStockMapBy(stockProductNumbers);
		Map<String, Long> productCountingMap = createCountingMapBy(stockProductNumbers);

		for (String stockProductNumber : new HashSet<>(stockProductNumbers)) {
			Stock stock = stockMap.get(stockProductNumber);
			int quantity = productCountingMap.get(stockProductNumber).intValue();

			if (stock.isQuantityLessThan(quantity)) {
				throw new IllegalArgumentException("재고가 부족한 상품이 있습니다.");
			}
			stock.deductQuantity(quantity);
		}
	}

	private List<Product> findProductsBy(List<String> productNumbers) {
		List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);
		Map<String, Product> productMap = products.stream().collect(Collectors.toMap(Product::getProductNumber, p -> p));

		return productNumbers.stream().map(productMap::get).collect(Collectors.toList());
	}

	private static List<String> extractStockProductNumbers(List<Product> products) {
		return products.stream().filter(product -> ProductType.containsStockType(product.getType()))
				.map(Product::getProductNumber).collect(Collectors.toList());
	}

	private Map<String, Stock> createStockMapBy(List<String> stockProductNumbers) {
		List<Stock> stocks = stockRepository.findAllByProductNumberIn(stockProductNumbers);
		return stocks.stream().collect(Collectors.toMap(Stock::getProductNumber, s -> s));
	}

	private static Map<String, Long> createCountingMapBy(List<String> stockProductNumbers) {
		return stockProductNumbers.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
	}
}
