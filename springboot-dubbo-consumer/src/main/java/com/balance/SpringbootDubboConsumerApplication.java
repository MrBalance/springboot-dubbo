package com.balance;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 启动dubbo注解
@EnableDubboConfiguration
// 扫描servlet
@ServletComponentScan(basePackages = {"com.balance.servlet" , "com.balance.filter"})
@SpringBootApplication
public class SpringbootDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboConsumerApplication.class, args);
    }

}
