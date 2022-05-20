package com.revenatium.model

import javax.persistence.*

@Entity
@Table(name = "categories")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    val id: Long,
    val description: String,
    @Column(name = "status")
    val isActive: Boolean
)
