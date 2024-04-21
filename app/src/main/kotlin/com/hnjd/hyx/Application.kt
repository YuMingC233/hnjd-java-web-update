package com.hnjd.hyx

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration


@SpringBootApplication(
    scanBasePackages = ["com.hnjd.hyx"],
    exclude = [
        SecurityAutoConfiguration::class,
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration::class
    ]
)

// 指定要扫描的Mapper类的包的路径
@MapperScan("com.hnjd.hyx.**.mapper")
class Application

fun main(args:Array<String>) {
    SpringApplication.run(Application::class.java,*args)
}