package com.sparta.myselectshop.naver.controller;


import com.sparta.myselectshop.naver.dto.ItemDto;
import com.sparta.myselectshop.naver.service.NaverApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 8. 기본 내용 만들고 사용할 메서드 만들기
// 1) ItemDto : java - naver - dto class
// 2) NaverApiService : java - naver - service class
 // => 다 세팅하면 "탐색하기"dptj 검색하고 결과 받는 것 까지 가능

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NaverApiController {

    private final NaverApiService naverApiService;

    @GetMapping("/search")
    public List<ItemDto> searchItems(@RequestParam String query)  {
        return naverApiService.searchItems(query);
    }
}