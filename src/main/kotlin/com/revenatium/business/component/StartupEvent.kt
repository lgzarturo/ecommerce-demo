package com.revenatium.business.component

import com.revenatium.annotation.ConvertToUppercase
import com.revenatium.annotation.GetSpecificDate
import com.revenatium.business.service.ProductService
import com.revenatium.model.dto.ProductDto
import com.revenatium.repository.CategoryRepository
import com.revenatium.repository.ClientRepository
import com.revenatium.repository.ShoppingProductRepository
import com.revenatium.repository.ShoppingRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class StartupEvent(
    private val convertDate: ConvertDate,
    private val productService: ProductService,
    private val categoryRepository: CategoryRepository,
    private val clientRepository: ClientRepository,
    private val shoppingRepository: ShoppingRepository,
    private val shoppingProductRepository: ShoppingProductRepository
    ) : ApplicationListener<ApplicationReadyEvent> {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        log.debug("Ejecutando evento al inicio de SpringBoot")
        log.info("Fecha ${convertDate.createDateFromString("1983-01-17")}")

        convertDate.javaClass.declaredMethods.forEach {
            if (it.isAnnotationPresent(GetSpecificDate::class.java)) {
                log.info("Dentro de la anotación")
                val annotation = it.getAnnotation(GetSpecificDate::class.java)
                val date = it.invoke(convertDate, annotation.date)
                log.info("La fecha es $date")
            }
        }

        productService.getProductById(1).let { product ->
            log.info("Producto encontrado $product")
            val productDto = ProductDto(
                product.name,
                product.price!!,
                product.stock!!
            )
            productDto.javaClass.declaredFields.forEach { field ->
                if (field.isAnnotationPresent(ConvertToUppercase::class.java)) {
                    field.isAccessible = true
                    val objectValue = field.get(productDto)
                    if (objectValue is String) {
                        field.set(productDto, objectValue.uppercase())
                    }
                }
            }
            log.info("Producto convertido $productDto")
        }

        log.info("Productos")
        productService.getProducts().forEach(::println)
        log.info("Cliente")
        clientRepository.findAll().forEach(::println)
        log.info("Categorías")
        categoryRepository.findAll().forEach {
            println(it)
            it.products.forEach(::println)
            println("--------------------------------")
        }
        log.info("Compras")
        shoppingRepository.findAll().forEach(::println)
        log.info("Compras y sus productos")
        shoppingProductRepository.findAll().forEach(::println)
    }
}
