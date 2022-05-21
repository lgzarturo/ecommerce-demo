package com.revenatium.repository

import com.revenatium.model.Category
import com.revenatium.model.ShoppingProduct
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShoppingProductRepository : JpaRepository<ShoppingProduct, Long>
