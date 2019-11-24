package com.innercirclesoftware.nutrionbackend.food

import com.innercirclesoftware.nutrionbackend.food.nutrients.FoodNutrient
import com.innercirclesoftware.nutrionbackend.food.nutrients.FoodNutrientCsv
import com.innercirclesoftware.nutrionbackend.food.nutrients.FoodNutrientRepository
import com.innercirclesoftware.nutrionbackend.importer.CsvImporter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FoodConfig {


    @Bean
    fun foodCsvImporter(foodRepository: FoodRepository): CsvImporter<Food> {
        return CsvImporter(
                repository = foodRepository,
                parser = FoodCsv.parser,
                fileName = FoodCsv.FILE_NAME,
                headers = FoodCsv.headers
        )
    }

    @Bean
    fun foodNutrientImporter(foodNutrientRepository: FoodNutrientRepository): CsvImporter<FoodNutrient> {
        return CsvImporter(
                repository = foodNutrientRepository,
                parser = FoodNutrientCsv.parser,
                fileName = FoodNutrientCsv.FILE_NAME,
                headers = FoodNutrientCsv.headers
        )
    }
}