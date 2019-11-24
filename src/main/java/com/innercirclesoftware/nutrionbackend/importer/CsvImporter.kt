package com.innercirclesoftware.nutrionbackend.importer

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord
import org.apache.logging.log4j.LogManager
import org.springframework.data.jpa.repository.JpaRepository
import java.io.IOException

class CsvImporter<T>(private val repository: JpaRepository<T, Long>,
                     private val parser: (CSVRecord) -> T,
                     private val csvFormat: CSVFormat,
                     private val fileName: String) : Importer<T> {

    constructor(repository: JpaRepository<T, Long>,
                parser: (CSVRecord) -> T,
                fileName: String,
                headers: Array<String>) : this(
            repository,
            parser,
            CSVFormat.DEFAULT.withDelimiter(',').withQuote('"').withHeader(*headers),
            fileName
    )

    private val log = LogManager.getLogger()

    override fun importAll() {
        log.info("Importing all...")

        val foodCsv = javaClass.classLoader.getResourceAsStream(fileName)
                ?: throw IOException("Could not find resource $fileName")

        var imported = 0L
        try {
            csvFormat.parse(foodCsv.bufferedReader())
                    .asSequence()
                    .drop(1) //drop header
                    .map { csvRecord -> parser(csvRecord) }
                    .chunked(10_000)
                    .forEach { list ->
                        repository.saveAll(list)
                        imported += list.size
                        log.info("Current import progress $imported")

                    }
        } catch (exception: Exception) {
            log.error("Failure after $imported, could not import", exception)
            throw ImportException(exception)
        }
    }
}

class ImportException @JvmOverloads constructor(reason: Throwable? = null, message: String? = reason?.message) : Exception(message, reason)
