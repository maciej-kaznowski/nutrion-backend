package com.innercirclesoftware.nutrionbackend.products

import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>