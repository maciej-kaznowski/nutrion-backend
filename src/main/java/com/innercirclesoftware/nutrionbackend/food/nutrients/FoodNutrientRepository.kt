package com.innercirclesoftware.nutrionbackend.food.nutrients

import org.springframework.data.jpa.repository.JpaRepository

interface FoodNutrientRepository : JpaRepository<FoodNutrient, Long> {

    fun findAllByFoodIdEquals(foodId: Long): List<FoodNutrient>?

}