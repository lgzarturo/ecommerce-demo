package com.revenatium.controller

import com.revenatium.annotation.GetProductsByCategory
import com.revenatium.business.service.ProductInterface
import com.revenatium.business.service.ProductService
import com.revenatium.business.service.ProductServiceAdditional
import com.revenatium.model.Product
import com.revenatium.repository.ProductRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductController(private val productRepository: ProductRepository) {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @Qualifier("productService")
    @Autowired
    private lateinit var productInterface: ProductInterface

    @GetMapping
    fun list(@RequestParam(required = false) mongo: Boolean = false): Iterable<Product> {
        if (mongo) productInterface = ProductServiceAdditional()
        if (productInterface.javaClass.isAnnotationPresent(GetProductsByCategory::class.java)) {
            log.info("Atrapamos la anotación ahora trae los productos de la categoría 1")
            return productInterface.getProductsByCategory(1)
        }
        return productInterface.getProducts()
    }

    @GetMapping("/category/{categoryId}")
    fun listByCategory(@PathVariable categoryId: Long) = productInterface.getProductsByCategory(categoryId)

    @PostMapping
    fun create(@RequestBody product: Product) = productInterface.addProduct(product)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = productInterface.getProductById(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product) = productInterface.updateProduct(id, product)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = productInterface.deleteProduct(id)

}
