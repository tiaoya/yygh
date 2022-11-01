package com.zhong.yygh.cmn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : zhong
 * @Description :
 * @create : 2022/11/1-14:59
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.zhong"})
@MapperScan("com.zhong.yygh.cmn.mapper")
public class ServiceCmnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCmnApplication.class, args);
    }
}
