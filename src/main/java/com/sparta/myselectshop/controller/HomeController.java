package com.sparta.myselectshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 5. Controller 세팅 여기까지하면 서버 준비완! -> (프론트 작업) templates
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
}