package com.revenatium.model.dto

import com.revenatium.annotation.ConvertToUppercase
import java.math.BigDecimal

data class ProductDto(
    @ConvertToUppercase
    var name: String? = null,
    var price: BigDecimal = BigDecimal.ZERO,
    var stock: Int = 0
)
