package com.revenatium.model

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "shopping_products")
data class ShoppingProduct(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var shoppingId: Long? = null,
    var productId: Long? = null,
    var total: BigDecimal? = null,
    var status: Boolean? = null
)
