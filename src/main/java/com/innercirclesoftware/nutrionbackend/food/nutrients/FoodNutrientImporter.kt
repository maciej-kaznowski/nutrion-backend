package com.innercirclesoftware.nutrionbackend.food.nutrients

import com.innercirclesoftware.nutrionbackend.importer.CsvImporter
import com.innercirclesoftware.nutrionbackend.importer.Importer
import org.apache.commons.csv.CSVRecord
import org.springframework.stereotype.Service

interface FoodNutrientImporter : Importer<FoodNutrient>

@Service
class FoodNutrientImporterImpl(private val csvImporter: CsvImporter<FoodNutrient>) : FoodNutrientImporter, Importer<FoodNutrient> by csvImporter

object FoodNutrientCsv {

    const val FILE_NAME = "food_nutrient.csv"

    val headers = arrayOf("id", "fdc_id", "nutrient_id", "amount", "data_points", "derivation_id", "min", "max", "median", "footnote", "min_year_acquired")

    val parser: (CSVRecord) -> FoodNutrient = { record ->
        //"id","fdc_id","nutrient_id","amount","data_points","derivation_id","min","max","median","footnote","min_year_acquired"
        //"4178832","346049","1079","0","","75","","","","",""
        FoodNutrient(
                id = record.get("id").toLong(),
                foodId = record.get("fdc_id").toLong(),
                nutrientId = record.get("nutrient_id").toLong(),
                amount = record.get("amount").toDouble(),
                dataPoints = record.get("data_points"),
                derivationId = record.get("derivation_id").toLongOrNull(),
                min = record.get("min").toDoubleOrNull(),
                max = record.get("max").toDoubleOrNull(),
                median = record.get("median").toDoubleOrNull(),
                footnote = record.get("footnote"),
                minYearAcquired = record.get("min_year_acquired")
        )
    }
}