package com.dodolife.jadwalsholat.network.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PrayerTimesData(
    @Json(name = "Fajr") val fajr: String? = "kotlin",
    @Json(name = "Sunrise") val sunrise: String?,
    @Json(name = "Dhuhr") val dhuhur: String?,
    @Json(name = "Asr") val ashar: String?,
    @Json(name = "Maghrib") val maghrib: String?,
    @Json(name = "Isha") val isha: String?,
    @Json(name = "name") val name: String?
)