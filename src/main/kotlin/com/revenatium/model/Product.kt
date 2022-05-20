package com.revenatium.model

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "products")
data class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var productId: Long? = null,
    var categoryId: Long? = null,
    var name: String? = null,
    var barCode: String? = null,
    var price: BigDecimal? = null,
    var stock: Int? = null,
    var status: Boolean? = null
)
