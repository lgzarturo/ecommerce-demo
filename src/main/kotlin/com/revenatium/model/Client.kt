package com.revenatium.model

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "clients")
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String? = null,
    var lastName: String? = null,
    var phone: BigDecimal? = null,
    var direction: String? = null,
    var email: String? = null
)

