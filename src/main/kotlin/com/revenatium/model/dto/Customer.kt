package com.revenatium.model.dto

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class Customer(val address: Address, val name: String)

@Component
class Address

@Service
class Configuration {
    @Bean
    fun getName() = "test"
}
