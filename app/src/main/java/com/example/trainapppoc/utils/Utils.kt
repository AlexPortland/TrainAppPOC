package com.example.trainapppoc.utils

import java.text.SimpleDateFormat
import java.util.*

fun trainUrlBuilder(utcTime: Long, direction: String?): String {
    // 1654861366421, Date=20220612, Hour=1400
    val akko = "1500"
    val shalom = "4600"

    val urlPrefix = "https://www.rail.co.il/pages/trainsearchresultnew.aspx?"
    var urlSource = "FSID="
    var urlDestination = "TSID="
    var urlDate = "Date="
    var urlHour = "Hour="
    val urlSuffix = "IOT=true&IBA=false&TSP="

    if (direction == "TO_HOME") {
        urlSource += shalom
        urlDestination += akko
    } else {
        urlSource += akko
        urlDestination += shalom
    }
    urlDate += formatDate(Date(utcTime))
    urlHour += formatDate2Hour(Date(utcTime))

    return "$urlPrefix$urlSource&$urlDestination&$urlDate&$urlHour&$urlSuffix$utcTime"
}

fun formatDate2Hour(date: Date): String {
    val format = SimpleDateFormat("HHmm",
        Locale.getDefault())
    return format.format(date)
}
fun formatDate(date: Date): String {
    val format = SimpleDateFormat("yyyyMMdd",
        Locale.getDefault())
    return format.format(date)
}

enum class Direction{
    TO_WORK,
    TO_HOME
}