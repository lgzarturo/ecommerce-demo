package com.revenatium.business.component

import com.revenatium.annotation.GetSpecificDate
import com.revenatium.business.service.ProductService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class StartupEvent(
    private val convertDate: ConvertDate,
    private val productService: ProductService
    ) : ApplicationListener<ApplicationReadyEvent> {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        log.debug("Ejecutando evento al inicio de SpringBoot")
        productService.getProducts().forEach(::println)
        log.info("Fecha ${convertDate.createDateFromString("1983-01-17")}")

        convertDate.javaClass.declaredMethods.forEach {
            if (it.isAnnotationPresent(GetSpecificDate::class.java)) {
                log.info("Dentro de la anotación")
                val annotation = it.getAnnotation(GetSpecificDate::class.java)
                val date = it.invoke(convertDate, annotation.date)
                log.info("La fecha es $date")
            }
        }
    }
}
