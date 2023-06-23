package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.entity.Folder;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.entity.ProductFolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// ++++ 폴더 만들기
public interface ProductFolderRepository extends JpaRepository<ProductFolder, Long> {
    Optional<ProductFolder> findByProductAndFolder(Product product, Folder folder);
}
