package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.dto.FolderRequestDto;
import com.sparta.myselectshop.security.UserDetailsImpl;
import com.sparta.myselectshop.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor // lombok의 생성자 쉽게 사용하게 해주는 에너테이션
public class FolderController {

    private final FolderService folderService;

    @PostMapping("/folders")
    // @RequestBody =>데이터가 여러개 넘어올 때 주로 사용(지금은 폴더가 여러개 들어옴)
    // @AuthenticationPrincipal : 인가를 하기 위한 것으로 security - JwtAuthorizationFilter 통해 진행
    public void addFolders(@RequestBody FolderRequestDto folderRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
       List<String> folderNames = folderRequestDto.getFolderNames();
        folderService.addFolders(folderNames,userDetails.getUser());

    }

}
