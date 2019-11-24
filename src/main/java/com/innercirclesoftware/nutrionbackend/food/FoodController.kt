package com.innercirclesoftware.nutrionbackend.food

import com.innercirclesoftware.nutrionbackend.food.nutrients.FoodNutrientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/foods")
class FoodController(@Autowired private val foodRepository: FoodRepository,
                     @Autowired private val foodNutrientRepository: FoodNutrientRepository) {

    @GetMapping("/{id}")
    fun `find food by id`(@PathVariable("id") id: Long) = foodRepository.findByIdOrNull(id)

    @GetMapping("/{id}/nutrients")
    fun `list nutrients for food`(@PathVariable("id") foodId: Long) = foodNutrientRepository.findAllByFoodIdEquals(foodId)
}