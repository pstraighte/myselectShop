package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.dto.ProductRequestDto;
import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 10. RestController 추가 + 필요한 에너테이션 추가하고 API 만들기 -> java - dto class ProductResponseDto

// 12. java - service class ProductService 만글고 ProductService용 필드 하나 선언
// API에 return 넣어주기 => return ProductService.createProduct(requestDto);
// createProduct로 이동 -> ProductResponseDto

@RestController
@RequiredArgsConstructor // 생성자 주입을 간편하게 해줌(Lombok)
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    // 관심 상품 등록 APi
    // 넘어오는 클라이언트의(HTTP body)의 데이터를 requestDto 로 받아옴
    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto){
        return productService.createProduct(requestDto);
    }

    // 관심 상품 업로드1 => ProductMypriceRequestDto class 만들기
    // ProductRepository class의 updateProduct 메서드 만들기 -> updateProduct 이동
    @PutMapping("/products/{id}") // {id} => PathVariable
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto){
        return productService.updateProduct(id, requestDto);
    }

    // 관심 상품 조회 & 출력1 -> ProductService
    @GetMapping("/products")
    public List<ProductResponseDto> getProducts() {
        return productService.getProducts();
    }

}
