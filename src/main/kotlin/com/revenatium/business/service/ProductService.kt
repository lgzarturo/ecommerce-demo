package com.revenatium.business.service

import com.revenatium.model.Product
import com.revenatium.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) : ProductInterface {
    override fun getProducts(): Iterable<Product> {
        return productRepository.findAll()
    }
}
