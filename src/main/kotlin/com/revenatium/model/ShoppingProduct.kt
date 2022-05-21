package com.revenatium.model

import java.math.BigDecimal

data class ShoppingProduct(
    var id: Long? = null,
    var shoppingId: Long? = null,
    var productId: Long? = null,
    var total: BigDecimal? = null,
    var status: Boolean? = null
)
