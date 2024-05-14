package com.hnjd.hyx

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry


@SpringBootApplication(
    scanBasePackages = ["com.hnjd.hyx"],
    exclude = [
        SecurityAutoConfiguration::class,
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration::class
    ]
)

// 指定要扫描的Mapper类的包的路径
@MapperScan("com.hnjd.hyx.**.mapper")
class Application : WebMvcConfigurer {
    // 添加跨域配置
    // SpringBoot—CORS跨域问题详解和解决方案 (https://www.cnblogs.com/Andya/p/13590046.html)
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOriginPatterns("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(true)
            .maxAge(3600)
    }
}

fun main(args:Array<String>) {
    SpringApplication.run(Application::class.java,*args)
}
