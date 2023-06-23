package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 9-3 : jpa 상속받고 <Entity class, id 타입>입력 -> ProductService
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByUser(User user, Pageable pageable);

}
