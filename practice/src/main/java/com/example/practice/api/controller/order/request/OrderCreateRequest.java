package com.example.practice.api.controller.order.request;

import com.example.practice.api.service.order.request.OrderCreateServiceRequest;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderCreateRequest {

    private final List<String> productNumbers;

    @Builder
    private OrderCreateRequest(List<String> productNumbers) {
        this.productNumbers = productNumbers;
    }

    public OrderCreateServiceRequest toServiceRequest() {
        return OrderCreateServiceRequest
            .builder()
            .productNumbers(productNumbers)
            .build();
    }
}
