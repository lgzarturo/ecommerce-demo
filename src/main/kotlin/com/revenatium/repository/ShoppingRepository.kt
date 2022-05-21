package com.revenatium.repository

import com.revenatium.model.Category
import com.revenatium.model.Shopping
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShoppingRepository : JpaRepository<Shopping, Long>
