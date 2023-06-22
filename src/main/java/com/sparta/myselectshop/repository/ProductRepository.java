package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// 9-3 : jpa 상속받고 <Entity class, id 타입>입력 -> ProductService
public interface ProductRepository extends JpaRepository<Product, Long> {

}
