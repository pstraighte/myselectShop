package com.sparta.myselectshop.service;

import com.sparta.myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.dto.ProductRequestDto;
import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.naver.dto.ItemDto;
import com.sparta.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// 13.  roductrepository 주입 받아올 필드 만들고 createProduct 메세드 만들기 + 에너테이션 추가
// 저장하는 기능완!

@Service
@RequiredArgsConstructor
public class ProductService {
    // Controller로 받아온 Dto를 저장할 Entity로 만들어주는 메서드

    private final ProductRepository productRepository;
    public static final int MIN_MY_PRICE = 100;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }

    // 관심 상품 업로드2
    @Transactional // => 업데이트시 필수!
    public ProductResponseDto updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        int myprice = requestDto.getMyprice();
        // myprice 은 100원 이상이어야 함
        if (myprice < MIN_MY_PRICE) {
            throw new IllegalArgumentException("유효하지 않은 관심 가격입니다. 최소 " + MIN_MY_PRICE + "원 이상으로 설정해주세요.");
        }

        // 관심 상품이 존재하는지 찾기 => 있으면 product 받고 없으면 아래 문구 띄움
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 상품을 찾을 수 없습니다.")
        );

        // Product class에  update 메서드 만듬
        product.update(requestDto);

        return new ProductResponseDto(product);
    }

    // 관심 상품 조회 & 출력2 -> Scheduler
    public List<ProductResponseDto> getProducts() {
        // productRepository.findAll().var => 맞춰서 아래와 같이 자동으로 나옴
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDto> responseDtoList = new ArrayList<>();
//        iter =>  향상된 for문 자동 완성
        for (Product product : productList) {
            responseDtoList.add(new ProductResponseDto(product));
        }
        return responseDtoList;
    }

    // 관심 상품 조회 & 출력4
    @Transactional
    public void updateBySearch(Long id, ItemDto itemDto) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 상품은 존재하지 않습니다.")
        );
        // product 업데이트
        // updateByItemDto 통해  Product 이동하여 메서드 만들기
        product.updateByItemDto(itemDto);
    }
}
