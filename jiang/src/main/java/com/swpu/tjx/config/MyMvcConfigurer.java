package com.swpu.tjx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfigurer implements WebMvcConfigurer {
    //请求路径映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /images/** 静态映射路径
        // file:D://images/mall 是文件磁盘存放的路径
        // 例如访问 http://localhost:9001/images/demo.jpg 就回去 D:/images/mall/demo.jpg
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:F:/work/workspace/images/mall/");
    }
    //跨域访问
    // 重写addCorsMappings方法
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // /**表示所有请求都支持跨域访问
                .allowedOrigins("*") // 所有的外部域都可跨域访问
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS") // 哪些请求 需要跨域配置
                .allowCredentials(true) //  浏览器是否将本域名下的cookie信息携带至跨域服务器中。默认携带至跨域服务器中，但要实现cookie共享还需要前端在AJAX请求中打开withCredentials属性。
                .maxAge(300) // 超时时长设置为5分钟。 时间单位是秒
                .allowedHeaders("*"); // 请求体的头部
    }
}
