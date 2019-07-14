package com.dodolife.jadwalsholat.database

import com.dodolife.jadwalsholat.database.entity.PrayerTimesDb
import com.dodolife.jadwalsholat.network.entity.PrayerTimesData

fun PrayerTimesData.toDb(): PrayerTimesDb {
    return PrayerTimesDb(
        fajr, sunrise, dhuhur, ashar, maghrib, isha
    )
}