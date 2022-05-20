package com.revenatium.business.component

import com.revenatium.business.service.ProductService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class StartupEvent(private val productService: ProductService) : ApplicationListener<ApplicationReadyEvent> {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        log.debug("Ejecutando evento al inicio de SpringBoot")
        productService.getProducts().forEach(::println)
    }
}
