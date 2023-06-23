package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.entity.ProductFolder;
import org.springframework.data.jpa.repository.JpaRepository;
// ++++ 폴더 만들기
public interface ProductFolderRepository extends JpaRepository<ProductFolder, Long> {
}
