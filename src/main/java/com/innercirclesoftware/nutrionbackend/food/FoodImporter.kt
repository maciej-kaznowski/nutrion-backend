package com.innercirclesoftware.nutrionbackend.food

import com.innercirclesoftware.nutrionbackend.importer.CsvImporter
import com.innercirclesoftware.nutrionbackend.importer.Importer
import com.innercirclesoftware.nutrionbackend.utils.toDate
import org.apache.commons.csv.CSVRecord
import org.springframework.stereotype.Service
import java.text.DateFormat
import java.text.SimpleDateFormat

interface FoodImporter : Importer<Food>

@Service
class FoodImporterImpl(private val csvImporter: CsvImporter<Food>) : FoodImporter, Importer<Food> by csvImporter

object FoodCsv {

    const val FILE_NAME = "food.csv"

    val headers = arrayOf("fdc_id", "data_type", "description", "food_category_id", "publication_date")

    private val dateFormat: DateFormat by lazy {
        //2019-04-01
        SimpleDateFormat("yyyy-MM-dd")
    }


    val parser: (CSVRecord) -> Food = { record ->
        //"335224", "sample_food", "Whole wheat bread, Store brand/other, PEPPERIDGE FARM (MI,NC) - CY1202V", "18", "2019-04-01"
        Food(
                id = record.get("fdc_id").toLong(),
                dataType = record.get("data_type"),
                description = record.get("description"),
                foodCategoryId = record.get("food_category_id").toLong(),
                publicationDate = record.get("publication_date").toDate(dateFormat)
        )

    }
}