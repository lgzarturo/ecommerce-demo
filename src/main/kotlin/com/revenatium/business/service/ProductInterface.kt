package com.revenatium.business.service

import com.revenatium.model.Product
import java.util.Optional

interface ProductInterface {
    fun getProducts(): Iterable<Product>
    fun getProductById(id: Long): Product
    fun addProduct(product: Product): Product
    fun updateProduct(id: Long, product: Product): Product
    fun deleteProduct(id: Long)
}
