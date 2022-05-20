package com.revenatium.controller

import com.revenatium.business.service.ProductService
import com.revenatium.model.Product
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val productService: ProductService
) {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun list() = productService.getProducts()

    @PostMapping
    fun create(@RequestBody product: Product) = productService.addProduct(product)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = productService.getProductById(id).orElseThrow {
        IllegalArgumentException("Producto con el ID $id, no existe")
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product) = productService.updateProduct(id, product)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = try {
        productService.deleteProduct(id)
    } catch (e: IllegalArgumentException) {
        log.error("Error al intentar borrar el producto con el ID $id, ya que no existe")
        throw IllegalArgumentException("El producto con el ID $id no puede ser borrado")
    }

}
