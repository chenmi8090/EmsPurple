package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@MapperScan("com.baizhi.dao")
public class EmspurpleCmApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmspurpleCmApplication.class, args);
    }
}

