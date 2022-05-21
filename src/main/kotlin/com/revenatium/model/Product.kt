package com.revenatium.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "products")
data class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var productId: Long? = null,
    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "category_id", nullable = true)
    var category: Category? = null,
    var name: String? = null,
    var barCode: String? = null,
    var price: BigDecimal? = null,
    var stock: Int? = null,
    var status: Boolean? = null
) {
    override fun toString(): String {
        return "Product(productId:$productId, category:${category?.id}, name:$name)"
    }
}
