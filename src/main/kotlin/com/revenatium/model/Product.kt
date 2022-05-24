package com.revenatium.model

import org.hibernate.validator.constraints.Range
import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "products")
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var productId: Long? = null
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    var category: Category? = null
    @NotEmpty
    var name: String? = null
    @NotEmpty
    var barCode: String? = null
    @Range(min = 15, max = 1_000_000)
    var price: BigDecimal? = null
    @Max(10_000)
    var stock: Int? = null
    var status: Boolean? = null
    override fun toString(): String {
        return "Product(productId:$productId, category:${category?.id}, name:$name)"
    }
}
