package com.balance;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 启动dubbo注解
@EnableDubboConfiguration
// dao层扫描
@MapperScan(basePackages = "com.balance.dao")
@SpringBootApplication
public class SpringbootDubboServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboServiceApplication.class, args);
    }

}
