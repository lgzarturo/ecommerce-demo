package com.revenatium

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class EcommerceDemoApplication

fun main(args: Array<String>) {
    val apc = SpringApplication.run(EcommerceDemoApplication::class.java, *args)
    apc.beanDefinitionNames.forEach(::println)
}
