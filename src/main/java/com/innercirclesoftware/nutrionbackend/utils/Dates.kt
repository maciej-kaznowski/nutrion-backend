package com.innercirclesoftware.nutrionbackend.utils

import java.text.DateFormat
import java.time.Instant
import java.util.*

object Dates {

    fun now() = Date.from(Instant.now())!!

}

fun String.toDate(dateFormat: DateFormat) = dateFormat.parse(this)!!