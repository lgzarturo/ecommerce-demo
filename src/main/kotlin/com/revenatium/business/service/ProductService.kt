package com.revenatium.business.service

import com.revenatium.model.Product
import com.revenatium.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(private val productRepository: ProductRepository) : ProductInterface {
    override fun getProducts(): Iterable<Product> {
        return productRepository.findAll()
    }

    override fun getProductById(id: Long): Optional<Product> {
        return productRepository.findById(id)
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
