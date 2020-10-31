package com.balance;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 启动dubbo注解
@EnableDubbo
// 扫描servlet
@ServletComponentScan(basePackages = {"com.balance.servlet" , "com.balance.filter"})
@SpringBootApplication
public class SpringbootDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboConsumerApplication.class, args);
    }

}
