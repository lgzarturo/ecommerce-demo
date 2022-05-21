package com.revenatium.repository

import com.revenatium.model.Category
import com.revenatium.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<Client, Long>
