package com.revenatium.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "shopping")
data class Shopping(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var shoppingId: Long? = null,
    @ManyToOne
    @JoinColumn(name = "client_id")
    var client: Client? = null,
    var date: LocalDate? = null,
    var comment: String? = null,
    var status: Boolean? = null,
    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(
        name = "shopping_products",
        joinColumns = [JoinColumn(name = "shopping_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    var products: Set<Product>? = null
) {
    override fun toString(): String {
        return "Shopping(id=$shoppingId, clientId:${client?.id}, date:$date, comment:$comment)"
    }
}
