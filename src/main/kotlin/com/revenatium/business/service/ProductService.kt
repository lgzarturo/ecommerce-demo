package com.revenatium.business.service

import com.revenatium.model.Product
import com.revenatium.repository.ProductRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) : ProductInterface {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun getProducts(): Iterable<Product> {
        return productRepository.findAll()
    }

    override fun getProductsByCategory(categoryId: Long): Iterable<Product> {
        return productRepository.findByCategoryId(categoryId)
    }

    override fun getProductById(id: Long): Product {
        return productRepository.findById(id).orElseThrow {
            IllegalArgumentException("Producto con el ID $id, no existe")
        }
    }

    override fun addProduct(product: Product): Product {
        return productRepository.save(product)
    }

    override fun updateProduct(id: Long, product: Product): Product {
        getProductById(id)
        product.productId = id
        productRepository.save(product)
        if (product.productId == null) {
            throw IllegalArgumentException("Producto con el ID $id, no se puede actualizar")
        }
        return product
    }

    override fun deleteProduct(id: Long) {
        try {
            productRepository.deleteById(id)
        } catch (e: IllegalArgumentException) {
            log.error("Error al intentar borrar el producto con el ID $id, ya que no existe")
            throw IllegalArgumentException("El producto con el ID $id no puede ser borrado")
        }
    }
}
