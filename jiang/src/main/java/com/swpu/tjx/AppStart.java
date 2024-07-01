package com.swpu.tjx;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//配置启动类
@SpringBootApplication  //启动类注解
@MapperScan(basePackages = {"com.swpu.tjx.mapper"}) //让mp动态为这个包下的接口生成实现类
public class AppStart {
    //main方法启动项目
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class,args);
    }
}