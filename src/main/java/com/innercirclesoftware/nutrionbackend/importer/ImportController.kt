package com.innercirclesoftware.nutrionbackend.importer

import com.innercirclesoftware.nutrionbackend.food.FoodImporter
import com.innercirclesoftware.nutrionbackend.food.nutrients.FoodNutrientImporter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/import")
class ImportController(@Autowired private val foodImporter: FoodImporter,
                       @Autowired private val foodNutrientImporter: FoodNutrientImporter) {

    @PostMapping("/foods")
    fun `import all foods`() = foodImporter.importAll()


    @PostMapping("/nutrients")
    fun `import all nutrients`() = foodNutrientImporter.importAll()

    @PostMapping("/all")
    fun `import all`() {
        arrayOf(foodImporter, foodNutrientImporter).forEach { importer -> importer.importAll() }
    }
}