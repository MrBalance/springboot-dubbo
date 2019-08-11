package com.balance;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableDubboConfiguration
//@MapperScan(basePackages = "com.balance.dao")
@SpringBootApplication
public class SpringbootDubboServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboServiceApplication.class, args);
    }

}
