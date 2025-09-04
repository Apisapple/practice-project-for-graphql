package com.example.practice.api.service.product;

import com.example.practice.api.controller.product.dto.request.ProductCreateRequest;
import com.example.practice.api.service.product.response.ProductResponse;
import com.example.practice.domain.product.Product;
import com.example.practice.domain.product.ProductSellingStatus;
import com.example.practice.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

private final ProductRepository productRepository;

    public List<ProductResponse> getSellingProducts() {
        List<Product> products = productRepository.findBySellingStatusIn(
            ProductSellingStatus.forDisplay());

        return products.stream().map(ProductResponse::of).toList();
    }

    /**
     * 상품 등록 - 상품 번호는 가장 최근 상품의 상품 번호에서 1 증가한 값으로 한다. - 상품 번호가 없을 경우, "001"로 한다.
     * <p>
     * * 동시성 이슈가 있을 수 있음.
     */
    @Transactional
    public ProductResponse createProduct(ProductCreateRequest request) {
        String nextProductNumber = createNextProductNumber();

        Product product = request.toEntity(nextProductNumber);
        Product savedProduct = productRepository.save(product);

        return ProductResponse.of(savedProduct);

    }

    private String createNextProductNumber() {
        String latestProductNumber = productRepository.findLatestProductNumber();
        if (latestProductNumber == null) {
            return "001";
        }

        int latestProductNumberInt = Integer.parseInt(latestProductNumber);
        int nextProductNumberInt = latestProductNumberInt + 1;

        return String.format("%03d", nextProductNumberInt);
    }
}
