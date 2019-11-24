package com.innercirclesoftware.nutrionbackend.food

import org.springframework.data.jpa.repository.JpaRepository

interface FoodRepository : JpaRepository<Food, Long>