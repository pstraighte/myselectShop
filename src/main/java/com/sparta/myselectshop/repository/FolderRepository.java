package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
// ++++ 폴더 만들기
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
