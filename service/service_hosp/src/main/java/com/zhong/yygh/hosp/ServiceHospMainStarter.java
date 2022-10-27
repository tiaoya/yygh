package com.zhong.yygh.hosp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : zhong
 * @Description :
 * @create : 2022/10/17-21:24
 */
@MapperScan(value = "com.zhong.yygh.hosp.mapper")
@ComponentScan(value = "com.zhong.yygh")
@SpringBootApplication
public class ServiceHospMainStarter {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospMainStarter.class,args);
    }
}
