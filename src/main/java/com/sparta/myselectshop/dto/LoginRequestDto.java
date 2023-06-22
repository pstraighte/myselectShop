package com.sparta.myselectshop.dto;

import lombok.Getter;
import lombok.Setter;
// 회원가입 기능 만들기

@Setter
@Getter
public class LoginRequestDto {
    private String username;
    private String password;
}