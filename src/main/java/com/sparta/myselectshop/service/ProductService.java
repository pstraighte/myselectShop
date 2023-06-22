package com.sparta.myselectshop.service;

import com.sparta.myselectshop.dto.ProductRequestDto;
import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.repository.ProductRepository;
import com.sparta.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// 13.  roductrepository 주입 받아올 필드 만들고 createProduct 메세드 만들기 + 에너테이션 추가
// 저장하는 기능완!

@Service
@RequiredArgsConstructor
public class ProductService {
    // Controller로 받아온 Dto를 저장할 Entity로 만들어주는 메서드

    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }
}
