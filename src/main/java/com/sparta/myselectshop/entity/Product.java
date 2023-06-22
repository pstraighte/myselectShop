package com.sparta.myselectshop.entity;

import com.sparta.myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.dto.ProductRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 9. 기본 코드(코드스니펫) 넣고 타임스탬프(Timestamped) class(상속 받아옴) 만들기
// 1) Timestamped : java - entity class 만들기
// 2) ProductRequestDto : java - dto class 만들기
// 3) java - repository - Productrepository 만들기
// -> java - Controller  - interpace  ProductController(만들기)

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "product") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Product extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    public Product(ProductRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getLprice();
    }
    // 관심 상품 업로드3
    public void update(ProductMypriceRequestDto requestDto) {
        this.myprice = requestDto.getMyprice();
    }
}