package com.revenatium.repository

import com.revenatium.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
    fun findByCategoryId(categoryId: Long): Iterable<Product>
    @Query("SELECT p FROM Product p where p.categoryId = ?1")
    fun traemeTodoPorElIdDeCategoria(categoryId: Long): Iterable<Product>
}
