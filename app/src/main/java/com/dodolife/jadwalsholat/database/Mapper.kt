package com.dodolife.jadwalsholat.database

import com.dodolife.jadwalsholat.database.entity.PrayerTimesDb
import com.dodolife.jadwalsholat.network.entity.PrayerTimesData

fun PrayerTimesData.toDb(): PrayerTimesDb {
    return PrayerTimesDb(
        fajr!!,
        sunrise.let { it.toString() },
        dhuhur.toString(),
        ashar.toString(),
        maghrib.toString(),
        isha.toString(),
        name.orEmpty()
    )
}