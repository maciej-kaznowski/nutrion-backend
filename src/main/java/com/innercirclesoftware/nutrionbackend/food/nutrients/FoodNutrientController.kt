package com.innercirclesoftware.nutrionbackend.food.nutrients

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(name = "/api/v1/nutrients")
class FoodNutrientController(@Autowired private val repository: FoodNutrientRepository)