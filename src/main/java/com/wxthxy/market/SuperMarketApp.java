package com.wxthxy.market;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wxthxy.market.dao")
public class SuperMarketApp {
    public static void main(String[] args) {
        SpringApplication.run(SuperMarketApp.class,args);
    }
}
