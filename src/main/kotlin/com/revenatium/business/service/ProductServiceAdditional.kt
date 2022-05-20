package com.revenatium.business.service

import com.revenatium.model.Product
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

//MongoDB
@Service
class ProductServiceAdditional : ProductInterface {

    constructor() {

    }

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun getProducts(): Iterable<Product> {
        log.info("Obteniendo datos de Mongo DB")
        return emptyList()
    }

    override fun getProductsByCategory(categoryId: Long): Iterable<Product> {
        log.info("Obteniendo datos de Mongo DB por categoría")
        return emptyList()
    }

    override fun getProductById(id: Long): Product {
        TODO("Not yet implemented")
    }

    override fun addProduct(product: Product): Product {
        TODO("Not yet implemented")
    }

    override fun updateProduct(id: Long, product: Product): Product {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(id: Long) {
        TODO("Not yet implemented")
    }
}
