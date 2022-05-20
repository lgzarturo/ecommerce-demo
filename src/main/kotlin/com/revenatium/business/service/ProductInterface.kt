package com.revenatium.business.service

import com.revenatium.model.Product

interface ProductInterface {
    fun getProducts(): Iterable<Product>
}
