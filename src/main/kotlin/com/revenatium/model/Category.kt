package com.revenatium.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "categories")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    var id: Long? = null,
    val description: String? = null,
    @Column(name = "status", nullable = false)
    val isActive: Boolean? = null,
    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = [CascadeType.REMOVE])
    val products: List<Product> = emptyList()
)
