package com.sparta.myselectshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

// 9-2  @EnableJpaAuditing 추가
// @Enable .. 은 각 기능을 사용하기 위해 Spring에 알려주는 것

@EnableJpaAuditing // JPA 사용을 위함
@EnableScheduling // @Scheduled 애네테이션을 사용하기 위한 것
@SpringBootApplication
public class MyselectshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyselectshopApplication.class, args);
    }

}
