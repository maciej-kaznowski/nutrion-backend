package com.innercirclesoftware.nutrionbackend

import org.apache.logging.log4j.LogManager
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication(scanBasePackageClasses = [NutrionBackendApplication::class])
@EnableJpaAuditing
class NutrionBackendApplication

fun main(args: Array<String>) {
    runApplication<NutrionBackendApplication>(*args)
}

@Suppress("NOTHING_TO_INLINE")
inline fun Any.logger() = LogManager.getLogger(javaClass.simpleName)

