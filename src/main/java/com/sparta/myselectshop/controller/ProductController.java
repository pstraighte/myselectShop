package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.dto.ProductRequestDto;
import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.security.UserDetailsImpl;
import com.sparta.myselectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    //  ++ 유저별 관심 상품 조회 =>  @AuthenticationPrincipal) 추가
    @PostMapping("/products") // 각 메서드 매개변수의 User 추가
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.createProduct(requestDto, userDetails.getUser());
    }

    // 관심 상품 업로드1 => ProductMypriceRequestDto class 만들기
    // ProductRepository class의 updateProduct 메서드 만들기 -> updateProduct 이동
    @PutMapping("/products/{id}") // {id} => PathVariable
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.updateProduct(id, requestDto);
    }

    // 관심 상품 조회 & 출력1 -> ProductService
    //  ++ 유저별 관심 상품 조회 =>  @AuthenticationPrincipal) 추가
    // +++ 페이징 기능 추가
    @GetMapping("/products")
    public Page<ProductResponseDto> getProducts(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc,

            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.getProducts(userDetails.getUser(), page - 1, size, sortBy, isAsc);
    }

    @PostMapping("/products/{productId}/folder")
    // @RequestParam : form 형식으로 폴더의 Id가 넘어옴
    public void addFolder(
            @PathVariable Long productId,
            @RequestParam Long folderId,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        productService.addFolder(productId, folderId, userDetails.getUser());
    }

    @GetMapping("/folders/{folderId}/products")
    public Page<ProductResponseDto> getProductsInFolder(
            @PathVariable Long folderId,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        return productService.getProductsInFolder(
                folderId,
                page -1,
                size,
                sortBy,
                isAsc,
                userDetails.getUser()
        );
    }

}
