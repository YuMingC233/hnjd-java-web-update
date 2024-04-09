package com.hnjd.hyx

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
class Application

fun main(args:Array<String>) {
    SpringApplication.run(Application::class.java,*args)
}