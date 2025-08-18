package com.example.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practice.domain.entity.Product;
import com.example.practice.domain.entity.ProductSellingStatus;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findBySellingStatusIn(List<ProductSellingStatus> sellingTypes);
}
